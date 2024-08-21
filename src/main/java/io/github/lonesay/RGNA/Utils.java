package io.github.lonesay.RGNA;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Utils {

    private Utils() {
    }

    public static byte[] float2ByteArray(float value) {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static byte[] floatArray2ByteArray(float[] values) {
        ByteBuffer buffer = ByteBuffer.allocate(4 * values.length);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        for (float value : values) {
            buffer.putFloat(value);

        }
        buffer.flip();
        return buffer.array();
    }
}
