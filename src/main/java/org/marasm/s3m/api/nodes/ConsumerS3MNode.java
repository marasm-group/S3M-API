package org.marasm.s3m.api.nodes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.marasm.s3m.api.S3MNode;
import org.marasm.s3m.api.S3MQueue;
import org.marasm.s3m.api.serialization.S3MSerializer;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ConsumerS3MNode implements S3MNode {

    protected S3MSerializer serializer;
    private List<S3MQueue> inputQueues;
    @NonNull
    private Consumer<List<byte[]>> consumer;

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
        return null;
    }

    @Override
    public void setOutputQueues(List<S3MQueue> outputQueues) {
        throw new UnsupportedOperationException(getClass().getName() + " does not support output");
    }

    @Override
    public List<byte[]> process(List<byte[]> input) throws Exception {
        consumer.accept(input);
        return null;
    }

    @Override
    public void init(Map<String, String> properties, S3MSerializer serializer) {
        this.serializer = serializer;
    }
}
