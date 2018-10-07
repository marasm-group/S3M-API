package org.marasm.s3m.api.serialization;

import java.io.Serializable;

public interface S3MSerializer {

    byte[] serialize(Serializable object);

    <T> T deserialize(byte[] data);
}
