package jadecocoonwiki.saveeditor.model.savedata;

public class SLUSSaveData extends JCSaveData
{
    private static final int ADDRESS_CHECKSUM = 0x2C0;

    private static final int ADDRESS_MONEY = 0x324;
    private static final int ADDRESS_MONEY_DISPLAY = 0x2BC;

    private static final int ADDRESS_LEVANT_CURRENT_HP = 0xAD0;
    private static final int ADDRESS_LEVANT_CURRENT_HP_DISPLAY = 0x2AC;
    private static final int ADDRESS_LEVANT_MAXIMUM_HP = 0xAD2;
    private static final int ADDRESS_LEVANT_MAXIMUM_HP_DISPLAY = 0x2B0;
    private static final int ADDRESS_LEVANT_ATTACK = 0xAF4;
    private static final int ADDRESS_LEVANT_DEFENSE = 0xAF5;
    private static final int ADDRESS_LEVANT_MAGIC_ATTACK = 0xAF6;
    private static final int ADDRESS_LEVANT_MAGIC_DEFENSE = 0xAF7;
    private static final int ADDRESS_LEVANT_SPEED = 0xAF8;

    private static final int MINION_DATA_SIZE = 0xA0;
    private static final int ADDRESS_MINION_ONE_EXISTENCE = 0xC88;
    private static final int ADDRESS_MINION_ONE_CURRENT_HP = 0xCCC;
    private static final int ADDRESS_MINION_ONE_MAXIMUM_HP = 0xCCE;
    private static final int ADDRESS_MINION_ONE_DM_FIRE = 0xCD4;
    private static final int ADDRESS_MINION_ONE_DM_AIR = 0xCD5;
    private static final int ADDRESS_MINION_ONE_DM_EARTH = 0xCD6;
    private static final int ADDRESS_MINION_ONE_DM_WATER = 0xCD7;
    private static final int ADDRESS_MINION_ONE_DM_POISON = 0xCD8;
    private static final int ADDRESS_MINION_ONE_DM_SLEEP = 0xCD9;
    private static final int ADDRESS_MINION_ONE_DM_FLESH_TO_STONE = 0xCDA;
    private static final int ADDRESS_MINION_ONE_DM_DEATH = 0xCDB;
    private static final int ADDRESS_MINION_ONE_DM_ABSORPTION = 0xCDC;
    private static final int ADDRESS_MINION_ONE_DM_HEALING = 0xCDD;
    private static final int ADDRESS_MINION_ONE_DM_BASIC_ATTACK = 0xCDE;
    private static final int ADDRESS_MINION_ONE_ATTACK = 0xCE0;
    private static final int ADDRESS_MINION_ONE_DEFENSE = 0xCE1;
    private static final int ADDRESS_MINION_ONE_MAGIC_ATTACK = 0xCE2;
    private static final int ADDRESS_MINION_ONE_MAGIC_DEFENSE = 0xCE3;
    private static final int ADDRESS_MINION_ONE_SPEED = 0xCE4;

    private static final int CHECKSUM_START_BOUNDARY = 0x0300;
    private static final int CHECKSUM_END_BOUNDARY = 0x1FBF;

    protected SLUSSaveData(byte[] bytes)
    {
        super(bytes);
    }

    @Override
    protected int getMoneyAddress()
    {
        return ADDRESS_MONEY;
    }

    @Override
    protected int getMoneyDisplayAddress()
    {
        return ADDRESS_MONEY_DISPLAY;
    }

    @Override
    protected int getLevantCurrentHPAddress()
    {
        return ADDRESS_LEVANT_CURRENT_HP;
    }

    @Override
    protected int getLevantCurrentHPDisplayAddress()
    {
        return ADDRESS_LEVANT_CURRENT_HP_DISPLAY;
    }

    @Override
    protected int getLevantMaximumHPAddress()
    {
        return ADDRESS_LEVANT_MAXIMUM_HP;
    }

    @Override
    protected int getLevantMaximumHPDisplayAddress()
    {
        return ADDRESS_LEVANT_MAXIMUM_HP_DISPLAY;
    }

    @Override
    protected int getLevantAttackAddress()
    {
        return ADDRESS_LEVANT_ATTACK;
    }

    @Override
    protected int getLevantDefenseAddress()
    {
        return ADDRESS_LEVANT_DEFENSE;
    }

    @Override
    protected int getLevantMagicAttackAddress()
    {
        return ADDRESS_LEVANT_MAGIC_ATTACK;
    }

    @Override
    protected int getLevantMagicDefenseAddress()
    {
        return ADDRESS_LEVANT_MAGIC_DEFENSE;
    }

    @Override
    protected int getLevantSpeedAddress()
    {
        return ADDRESS_LEVANT_SPEED;
    }

    @Override
    protected int getMinionExistenceAddress(int slot)
    {
        return ADDRESS_MINION_ONE_EXISTENCE + getMinionOffset(slot);
    }

    @Override
    protected int getMinionCurrentHPAddress(int slot)
    {
        return ADDRESS_MINION_ONE_CURRENT_HP + getMinionOffset(slot);
    }

    @Override
    protected int getMinionMaximumHPAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAXIMUM_HP + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMFireAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_FIRE + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMAirAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_AIR + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMEarthAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_EARTH + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMWaterAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_WATER + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMPoisonAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_POISON + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMSleepAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_SLEEP + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMFleshToStoneAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_FLESH_TO_STONE + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMDeathAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_DEATH + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMAbsorptionAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_ABSORPTION + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMHealingAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_HEALING + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDMBasicAttackAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DM_BASIC_ATTACK + getMinionOffset(slot);
    }

    @Override
    protected int getMinionAttackAddress(int slot)
    {
        return ADDRESS_MINION_ONE_ATTACK + getMinionOffset(slot);
    }

    @Override
    protected int getMinionDefenseAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DEFENSE + getMinionOffset(slot);
    }

    @Override
    protected int getMinionMagicAttackAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAGIC_ATTACK + getMinionOffset(slot);
    }

    @Override
    protected int getMinionMagicDefenseAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAGIC_DEFENSE + getMinionOffset(slot);
    }

    @Override
    protected int getMinionSpeedAddress(int slot)
    {
        return ADDRESS_MINION_ONE_SPEED + getMinionOffset(slot);
    }

    private int getMinionOffset(int slot)
    {
        return MINION_DATA_SIZE * slot;
    }


    @Override
    protected int getChecksumStartBoundary()
    {
        return CHECKSUM_START_BOUNDARY;
    }

    @Override
    protected int getChecksumEndBoundary()
    {
        return CHECKSUM_END_BOUNDARY;
    }

    @Override
    protected int getAddressChecksum()
    {
        return ADDRESS_CHECKSUM;
    }
}
