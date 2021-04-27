package jadecocoonwiki.saveeditor.model.creature;

public class Minion extends Creature
{
    private MinionExistence existence;

    public MinionExistence getExistence()
    {
        return existence;
    }

    public void setExistence(MinionExistence existence)
    {
        this.existence = existence;
    }
}
