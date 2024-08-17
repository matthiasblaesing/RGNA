package com.sayed

import java.nio.ByteBuffer
import java.nio.ByteOrder

static byte[] float2ByteArray(float value)
{
    return ByteBuffer.allocate(4).putFloat(value).array()
}

static byte[] FloatArray2ByteArray(float[] values)
{
    ByteBuffer buffer = ByteBuffer.allocate(4 * values.length)
    buffer.order(ByteOrder.LITTLE_ENDIAN)
    for (float value : values)
        buffer.putFloat(value)
    buffer.flip()
    return buffer.array();
}
