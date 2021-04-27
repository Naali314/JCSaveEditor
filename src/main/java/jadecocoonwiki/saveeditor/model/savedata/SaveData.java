package jadecocoonwiki.saveeditor.model.savedata;

public class SaveData
{
    private final byte[] bytes;

    protected SaveData(byte[] bytes)
    {
        this.bytes = bytes;
    }

    protected byte[] getBytes()
    {
        return this.bytes;
    }
}
