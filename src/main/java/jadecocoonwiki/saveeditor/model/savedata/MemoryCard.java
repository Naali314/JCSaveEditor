package jadecocoonwiki.saveeditor.model.savedata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MemoryCard
{
    private static final int MEMORY_CARD_SIZE = 0x20000;
    private static final int SAVE_DATA_SIZE = 0x2000;

    private final Path path;

    private byte[] bytes;

    public MemoryCard(Path path) throws IOException, SizeMismatchException
    {
        this.path = path;
        this.bytes = Files.readAllBytes(path);
        if (this.bytes.length != MEMORY_CARD_SIZE)
        {
            throw new SizeMismatchException();
        }
    }

    public Path getPath()
    {
        return path;
    }

    public String[] getGameIds()
    {
        String[] gameIds = new String[15];

        for (int i = 0; i < 15; i++)
        {
            gameIds[i] = getGameId(i);
        }
        return gameIds;
    }

    public String getGameId(int index)
    {
        int indexOnMemCard = index + 1;
        byte[] idBytes = Arrays.copyOfRange(this.bytes, indexOnMemCard * 0x80 + 0xC, indexOnMemCard * 0x80 + 0x16);
        String id = new String(idBytes);

        String gameNamePattern = "[A-Z]{4}-[0-9]{5}";
        if (id.matches(gameNamePattern))
        {
            return id;
        }
        else
        {
            return "Empty Slot";
        }
    }

    // TODO: this doesn't look too nice, but I somehow can't think of a better way.
    // I want to construct some instance which extends JCSaveData without naming the concrete classes here directly.
    public SLUSSaveData getSLUSSaveData(int index)
    {
        byte[] saveDataBytes = getSaveDataBytes(index);
        return new SLUSSaveData(saveDataBytes);
    }

    public SLESSaveData getSLESSaveData(int index)
    {
        byte[] saveDataBytes = getSaveDataBytes(index);
        return new SLESSaveData(saveDataBytes);
    }

    private byte[] getSaveDataBytes(int index)
    {
        int indexOnMemCard = index + 1;

        return Arrays.copyOfRange(bytes, indexOnMemCard * SAVE_DATA_SIZE, (indexOnMemCard + 1) * SAVE_DATA_SIZE);
    }

    public void setSaveData(SaveData saveData, int slot)
    {
        int indexOnMemCard = slot + 1;

        ByteBuffer buffer = ByteBuffer.wrap(this.bytes);
        buffer.position(indexOnMemCard * SAVE_DATA_SIZE);
        buffer.put(saveData.getBytes());

        this.bytes = buffer.array();
    }

    public void save() throws IOException
    {
        this.save(this.path);
    }

    public void save(Path path) throws IOException
    {
        Files.write(path, bytes);
    }
}
