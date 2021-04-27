package jadecocoonwiki.saveeditor.model.creature;

public abstract class Creature
{
    private int currentHP;
    private int maximumHP;
    private short attack;
    private short defense;
    private short magicAttack;
    private short magicDefense;
    private short speed;

    public int getCurrentHP()
    {
        return currentHP;
    }

    public void setCurrentHP(int currentHP)
    {
        this.currentHP = currentHP;
    }

    public int getMaximumHP()
    {
        return maximumHP;
    }

    public void setMaximumHP(int maximumHP)
    {
        this.maximumHP = maximumHP;
    }

    public short getAttack()
    {
        return attack;
    }

    public void setAttack(short attack)
    {
        this.attack = attack;
    }

    public short getDefense()
    {
        return defense;
    }

    public void setDefense(short defense)
    {
        this.defense = defense;
    }

    public short getMagicAttack()
    {
        return magicAttack;
    }

    public void setMagicAttack(short magicAttack)
    {
        this.magicAttack = magicAttack;
    }

    public short getMagicDefense()
    {
        return magicDefense;
    }

    public void setMagicDefense(short magicDefense)
    {
        this.magicDefense = magicDefense;
    }

    public short getSpeed()
    {
        return speed;
    }

    public void setSpeed(short speed)
    {
        this.speed = speed;
    }
}
