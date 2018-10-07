package org.marasm.s3m.api.nodes;

import org.marasm.s3m.api.S3MNode;
import org.marasm.s3m.api.S3MQueue;
import org.marasm.s3m.api.serialization.S3MSerializer;

import java.util.List;
import java.util.Map;

public abstract class BaseS3MNode implements S3MNode {

    protected S3MSerializer serializer;
    private List<S3MQueue> inputQueues;
    private List<S3MQueue> outputQueues;

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
        return outputQueues;
    }

    @Override
    public void setOutputQueues(List<S3MQueue> outputQueues) {
        if (outputQueues.size() > 2) {
            throw new IllegalArgumentException("Too many output queues assigned to " + getClass().getName());
        }
        this.outputQueues = outputQueues;
    }

    @Override
    public void init(Map<String, String> properties, S3MSerializer serializer) {
        this.serializer = serializer;
    }

}
