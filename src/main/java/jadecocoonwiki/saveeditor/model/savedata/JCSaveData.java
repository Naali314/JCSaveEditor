package jadecocoonwiki.saveeditor.model.savedata;

import jadecocoonwiki.saveeditor.helper.UnsignedByteBufferWrapper;
import jadecocoonwiki.saveeditor.model.creature.MinionExistence;

public abstract class JCSaveData extends SaveData
{
    UnsignedByteBufferWrapper buffer;

    protected JCSaveData(byte[] bytes)
    {
        super(bytes);

        this.buffer = new UnsignedByteBufferWrapper(this.getBytes());
    }

    protected abstract int getMoneyAddress();

    protected abstract int getMoneyDisplayAddress();

    public long getMoney()
    {
        return buffer.getUnsignedInt(getMoneyAddress());
    }

    public void setMoney(long newValue)
    {
        buffer.putUnsignedInt(getMoneyAddress(), newValue);
        buffer.putUnsignedInt(getMoneyDisplayAddress(), newValue);
    }

    protected abstract int getLevantCurrentHPAddress();

    protected abstract int getLevantCurrentHPDisplayAddress();

    public int getLevantCurrentHP()
    {
        return buffer.getUnsignedShort(getLevantCurrentHPAddress());
    }

    public void setLevantCurrentHP(int newValue)
    {
        buffer.putUnsignedShort(getLevantCurrentHPAddress(), newValue);
        buffer.putUnsignedShort(getLevantCurrentHPDisplayAddress(), newValue);
    }

    protected abstract int getLevantMaximumHPAddress();

    protected abstract int getLevantMaximumHPDisplayAddress();

    public int getLevantMaximumHP()
    {
        return buffer.getUnsignedShort(getLevantMaximumHPAddress());
    }

    public void setLevantMaximumHP(int newValue)
    {
        buffer.putUnsignedShort(getLevantMaximumHPAddress(), newValue);
        buffer.putUnsignedShort(getLevantMaximumHPDisplayAddress(), newValue);
    }

    protected abstract int getLevantAttackAddress();

    public short getLevantAttack()
    {
        return buffer.getUnsignedByte(getLevantAttackAddress());
    }

    public void setLevantAttack(short newValue)
    {
        buffer.putUnsignedByte(getLevantAttackAddress(), newValue);
    }

    protected abstract int getLevantDefenseAddress();

    public short getLevantDefense()
    {
        return buffer.getUnsignedByte(getLevantDefenseAddress());
    }

    public void setLevantDefense(short newValue)
    {
        buffer.putUnsignedByte(getLevantDefenseAddress(), newValue);
    }

    protected abstract int getLevantMagicAttackAddress();

    public short getLevantMagicAttack()
    {
        return buffer.getUnsignedByte(getLevantMagicAttackAddress());
    }

    public void setLevantMagicAttack(short newValue)
    {
        buffer.putUnsignedByte(getLevantMagicAttackAddress(), newValue);
    }

    protected abstract int getLevantMagicDefenseAddress();

    public short getLevantMagicDefense()
    {
        return buffer.getUnsignedByte(getLevantMagicDefenseAddress());
    }

    public void setLevantMagicDefense(short newValue)
    {
        buffer.putUnsignedByte(getLevantMagicDefenseAddress(), newValue);
    }

    protected abstract int getLevantSpeedAddress();

    public short getLevantSpeed()
    {
        return buffer.getUnsignedByte(getLevantSpeedAddress());
    }

    public void setLevantSpeed(short newValue)
    {
        buffer.putUnsignedByte(getLevantSpeedAddress(), newValue);
    }


    protected abstract int getMinionExistenceAddress(int slot);

    public MinionExistence getMinionExistence(int slot)
    {
        return MinionExistence.getValue(buffer.getUnsignedByte(getMinionExistenceAddress(slot)));
    }

    protected abstract int getMinionCurrentHPAddress(int slot);

    public int getMinionCurrentHP(int slot)
    {
        return buffer.getUnsignedShort(getMinionCurrentHPAddress(slot));
    }

    public void setMinionCurrentHP(int slot, int newValue)
    {
        buffer.putUnsignedShort(getMinionCurrentHPAddress(slot), newValue);
    }

    protected abstract int getMinionMaximumHPAddress(int slot);

    public int getMinionMaximumHP(int slot)
    {
        return buffer.getUnsignedShort(getMinionMaximumHPAddress(slot));
    }

    public void setMinionMaximumHP(int slot, int newValue)
    {
        buffer.putUnsignedShort(getMinionMaximumHPAddress(slot), newValue);
    }

    protected abstract int getMinionDMFireAddress(int slot);

    public byte getMinionDMFire(int slot)
    {
        return buffer.getSignedByte(getMinionDMFireAddress(slot));
    }

    public void setMinionDMFire(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMFireAddress(slot), newValue);
    }

    protected abstract int getMinionDMAirAddress(int slot);

    public byte getMinionDMAir(int slot)
    {
        return buffer.getSignedByte(getMinionDMAirAddress(slot));
    }

    public void setMinionDMAir(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMAirAddress(slot), newValue);
    }

    protected abstract int getMinionDMEarthAddress(int slot);

    public byte getMinionDMEarth(int slot)
    {
        return buffer.getSignedByte(getMinionDMEarthAddress(slot));
    }

    public void setMinionDMEarth(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMEarthAddress(slot), newValue);
    }

    protected abstract int getMinionDMWaterAddress(int slot);

    public byte getMinionDMWater(int slot)
    {
        return buffer.getSignedByte(getMinionDMWaterAddress(slot));
    }

    public void setMinionDMWater(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMWaterAddress(slot), newValue);
    }

    protected abstract int getMinionDMPoisonAddress(int slot);

    public byte getMinionDMPoison(int slot)
    {
        return buffer.getSignedByte(getMinionDMPoisonAddress(slot));
    }

    public void setMinionDMPoison(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMPoisonAddress(slot), newValue);
    }

    protected abstract int getMinionDMSleepAddress(int slot);

    public byte getMinionDMSleep(int slot)
    {
        return buffer.getSignedByte(getMinionDMSleepAddress(slot));
    }

    public void setMinionDMSleep(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMSleepAddress(slot), newValue);
    }

    protected abstract int getMinionDMFleshToStoneAddress(int slot);

    public byte getMinionDMFleshToStone(int slot)
    {
        return buffer.getSignedByte(getMinionDMFleshToStoneAddress(slot));
    }

    public void setMinionDMFleshToStone(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMFleshToStoneAddress(slot), newValue);
    }

    protected abstract int getMinionDMDeathAddress(int slot);

    public byte getMinionDMDeath(int slot)
    {
        return buffer.getSignedByte(getMinionDMDeathAddress(slot));
    }

    public void setMinionDMDeath(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMDeathAddress(slot), newValue);
    }

    protected abstract int getMinionDMAbsorptionAddress(int slot);

    public byte getMinionDMAbsorption(int slot)
    {
        return buffer.getSignedByte(getMinionDMAbsorptionAddress(slot));
    }

    public void setMinionDMAbsorption(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMAbsorptionAddress(slot), newValue);
    }

    protected abstract int getMinionDMHealingAddress(int slot);

    public byte getMinionDMHealing(int slot)
    {
        return buffer.getSignedByte(getMinionDMHealingAddress(slot));
    }

    public void setMinionDMHealing(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMHealingAddress(slot), newValue);
    }

    protected abstract int getMinionDMBasicAttackAddress(int slot);

    public byte getMinionDMBasicAttack(int slot)
    {
        return buffer.getSignedByte(getMinionDMBasicAttackAddress(slot));
    }

    public void setMinionDMBasicAttack(int slot, byte newValue)
    {
        buffer.putSignedByte(getMinionDMBasicAttackAddress(slot), newValue);
    }

    protected abstract int getMinionAttackAddress(int slot);

    public short getMinionAttack(int slot)
    {
        return buffer.getUnsignedByte(getMinionAttackAddress(slot));
    }

    public void setMinionAttack(int slot, short newValue)
    {
        buffer.putUnsignedByte(getMinionAttackAddress(slot), newValue);
    }

    protected abstract int getMinionDefenseAddress(int slot);

    public short getMinionDefense(int slot)
    {
        return buffer.getUnsignedByte(getMinionDefenseAddress(slot));
    }

    public void setMinionDefense(int slot, short newValue)
    {
        buffer.putUnsignedByte(getMinionDefenseAddress(slot), newValue);
    }

    protected abstract int getMinionMagicAttackAddress(int slot);

    public short getMinionMagicAttack(int slot)
    {
        return buffer.getUnsignedByte(getMinionMagicAttackAddress(slot));
    }

    public void setMinionMagicAttack(int slot, short newValue)
    {
        buffer.putUnsignedByte(getMinionMagicAttackAddress(slot), newValue);
    }

    protected abstract int getMinionMagicDefenseAddress(int slot);

    public short getMinionMagicDefense(int slot)
    {
        return buffer.getUnsignedByte(getMinionMagicDefenseAddress(slot));
    }

    public void setMinionMagicDefense(int slot, short newValue)
    {
        buffer.putUnsignedByte(getMinionMagicDefenseAddress(slot), newValue);
    }

    protected abstract int getMinionSpeedAddress(int slot);

    public short getMinionSpeed(int slot)
    {
        return buffer.getUnsignedByte(getMinionSpeedAddress(slot));
    }

    public void setMinionSpeed(int slot, short newValue)
    {
        buffer.putUnsignedByte(getMinionSpeedAddress(slot), newValue);
    }


    public void repairCheckSum()
    {
        int checkSum = 0;
        for (int i = getChecksumStartBoundary(); i <= getChecksumEndBoundary(); i++)
        {
            checkSum += buffer.getUnsignedByte(i);
        }
        buffer.putUnsignedInt(getAddressChecksum(), checkSum);
    }

    protected abstract int getChecksumStartBoundary();

    protected abstract int getChecksumEndBoundary();

    protected abstract int getAddressChecksum();
}
