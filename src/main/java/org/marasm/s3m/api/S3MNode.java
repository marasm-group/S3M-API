package org.marasm.s3m.api;

import org.marasm.s3m.api.serialization.S3MSerializer;

import java.util.List;
import java.util.Map;

public interface S3MNode {

    List<S3MQueue> getInputQueues();

    void setInputQueues(List<S3MQueue> inputQueues);

    List<S3MQueue> getOutputQueues();

    void setOutputQueues(List<S3MQueue> outputQueues);

    List<byte[]> process(List<byte[]> input) throws Exception;

    void init(Map<String, String> properties, S3MSerializer serializer);

    default boolean mutating() {
        return true;
    }

    default String alias() {
        return null;
    }

}
