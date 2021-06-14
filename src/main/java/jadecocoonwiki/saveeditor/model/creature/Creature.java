package jadecocoonwiki.saveeditor.model.creature;

public abstract class Creature
{
    private int currentHP;
    private int maximumHP;
    private byte dmFire;
    private byte dmAir;
    private byte dmEarth;
    private byte dmWater;
    private byte dmPoison;
    private byte dmSleep;
    private byte dmFleshToStone;
    private byte dmDeath;
    private byte dmAbsorption;
    private byte dmHealing;
    private byte dmBasicAttack;
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

    public byte getDmFire()
    {
        return dmFire;
    }

    public void setDmFire(byte dmFire)
    {
        this.dmFire = dmFire;
    }

    public byte getDmAir()
    {
        return dmAir;
    }

    public void setDmAir(byte dmAir)
    {
        this.dmAir = dmAir;
    }

    public byte getDmEarth()
    {
        return dmEarth;
    }

    public void setDmEarth(byte dmEarth)
    {
        this.dmEarth = dmEarth;
    }

    public byte getDmWater()
    {
        return dmWater;
    }

    public void setDmWater(byte dmWater)
    {
        this.dmWater = dmWater;
    }

    public byte getDmPoison()
    {
        return dmPoison;
    }

    public void setDmPoison(byte dmPoison)
    {
        this.dmPoison = dmPoison;
    }

    public byte getDmSleep()
    {
        return dmSleep;
    }

    public void setDmSleep(byte dmSleep)
    {
        this.dmSleep = dmSleep;
    }

    public byte getDmFleshToStone()
    {
        return dmFleshToStone;
    }

    public void setDmFleshToStone(byte dmFleshToStone)
    {
        this.dmFleshToStone = dmFleshToStone;
    }

    public byte getDmDeath()
    {
        return dmDeath;
    }

    public void setDmDeath(byte dmDeath)
    {
        this.dmDeath = dmDeath;
    }

    public byte getDmAbsorption()
    {
        return dmAbsorption;
    }

    public void setDmAbsorption(byte dmAbsorption)
    {
        this.dmAbsorption = dmAbsorption;
    }

    public byte getDmHealing()
    {
        return dmHealing;
    }

    public void setDmHealing(byte dmHealing)
    {
        this.dmHealing = dmHealing;
    }

    public byte getDmBasicAttack()
    {
        return dmBasicAttack;
    }

    public void setDmBasicAttack(byte dmBasicAttack)
    {
        this.dmBasicAttack = dmBasicAttack;
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
