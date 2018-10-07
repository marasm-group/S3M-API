package org.marasm.s3m.api.nodes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.marasm.s3m.api.S3MNode;
import org.marasm.s3m.api.S3MQueue;
import org.marasm.s3m.api.serialization.S3MSerializer;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class SupplierS3MNode implements S3MNode {

    private List<S3MQueue> ouputQueues;
    @NonNull
    private Supplier<List<byte[]>> supplier;
    private S3MSerializer serializer;

    @Override
    public List<S3MQueue> getInputQueues() {
        return null;
    }

    @Override
    public void setInputQueues(List<S3MQueue> inputQueues) {
        throw new UnsupportedOperationException(getClass().getName() + " does not support input");
    }

    @Override
    public List<S3MQueue> getOutputQueues() {
        return ouputQueues;
    }

    @Override
    public void setOutputQueues(List<S3MQueue> outputQueues) {
        this.ouputQueues = outputQueues;
    }

    @Override
    public List<byte[]> process(List<byte[]> input) throws Exception {
        return supplier.get();
    }

    @Override
    public void init(Map<String, String> properties, S3MSerializer serializer) {
        this.serializer = serializer;
    }

}
