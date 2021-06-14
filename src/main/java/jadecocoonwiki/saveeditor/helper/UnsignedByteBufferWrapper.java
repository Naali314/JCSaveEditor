package jadecocoonwiki.saveeditor.helper;

import java.nio.ByteBuffer;

import static java.nio.ByteOrder.LITTLE_ENDIAN;

public class UnsignedByteBufferWrapper
{
    private final ByteBuffer buffer;

    public UnsignedByteBufferWrapper(byte[] bytes)
    {
        this.buffer = ByteBuffer
                .wrap(bytes)
                .order(LITTLE_ENDIAN);
    }

    public short getUnsignedByte(int position)
    {
        return ((short) (buffer.get(position) & (short) 0xff));
    }

    public void putUnsignedByte(int position, int value)
    {
        buffer.put(position, (byte) (value & 0xff));
    }

    // ---------------------------------------------------------------

    public byte getSignedByte(int position)
    {
        return buffer.get(position);
    }

    public void putSignedByte(int position, byte value)
    {
        buffer.put(position, value);
    }

    // ---------------------------------------------------------------

    public int getUnsignedShort(int position)
    {
        return (buffer.getShort(position) & 0xffff);
    }

    public void putUnsignedShort(int position, int value)
    {
        buffer.putShort(position, (short) (value & 0xffff));
    }

    // ---------------------------------------------------------------

    public long getUnsignedInt(int position)
    {
        return ((long) buffer.getInt(position) & 0xffffffffL);
    }

    public void putUnsignedInt(int position, long value)
    {
        buffer.putInt(position, (int) (value & 0xffffffffL));
    }
}
