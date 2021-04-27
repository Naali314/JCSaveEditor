package jadecocoonwiki.saveeditor.model.creature;

public enum MinionExistence
{
    IN_STORAGE(2),
    IN_PARTY(3),
    NONEXISTENT(4);

    private final int code;

    MinionExistence(int code)
    {
        this.code = code;
    }

    public static MinionExistence getValue(int code)
    {
        for (MinionExistence e : MinionExistence.values())
        {
            if (e.code == code)
            {
                return e;
            }
        }
        return null;
    }
}
