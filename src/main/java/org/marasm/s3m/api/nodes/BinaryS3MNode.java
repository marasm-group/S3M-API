package org.marasm.s3m.api.nodes;


import lombok.AllArgsConstructor;
import lombok.ToString;
import org.marasm.s3m.api.S3MQueue;

import java.util.List;

@ToString
@AllArgsConstructor
public abstract class BinaryS3MNode extends JoiningS3MNode {


    @Override
    public void setInputQueues(List<S3MQueue> inputQueues) {
        if (inputQueues.size() > 2) {
            throw new IllegalArgumentException("Too many input queues assigned to " + getClass().getName());
        }
        super.setInputQueues(inputQueues);
    }

    @Override
    public byte[] join(List<byte[]> input) throws Exception {
        return process(input.get(0), input.get(1));
    }

    public abstract byte[] process(byte[] inputA, byte[] inputB) throws Exception;

}
