package org.marasm.s3m.api.nodes;

import org.marasm.s3m.api.S3MNode;
import org.marasm.s3m.api.S3MQueue;
import org.marasm.s3m.api.serialization.S3MSerializer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class JoiningS3MNode implements S3MNode {

    protected S3MSerializer serializer;
    private List<S3MQueue> inputQueues;
    private S3MQueue outputQueue;

    @Override
    public List<S3MQueue> getInputQueues() {
        return inputQueues;
    }

    @Override
    public void setInputQueues(List<S3MQueue> inputQueues) {
        this.inputQueues = inputQueues;
    }

    @Override
    public List<S3MQueue> getOutputQueues() {
        return Collections.singletonList(getOutputQueue());
    }

    @Override
    public void setOutputQueues(List<S3MQueue> outputQueues) {
        if (outputQueues.size() > 1) {
            throw new IllegalArgumentException("Too many output queues assigned to " + getClass().getName());
        }
        setOutputQueue(outputQueues.get(0));
    }

    @Override
    public List<byte[]> process(List<byte[]> input) throws Exception {
        return Collections.singletonList(join(input));
    }

    public S3MQueue getOutputQueue() {
        return outputQueue;
    }

    public void setOutputQueue(S3MQueue outputQueue) {
        this.outputQueue = outputQueue;
    }

    public abstract byte[] join(List<byte[]> input) throws Exception;

    @Override
    public void init(Map<String, String> properties, S3MSerializer serializer) {
        this.serializer = serializer;
    }
}
