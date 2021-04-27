package jadecocoonwiki.saveeditor.model.savedata;

public class SLESSaveData extends JCSaveData
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
    private static final int ADDRESS_MINION_ONE_ATTACK = 0xCE0;
    private static final int ADDRESS_MINION_ONE_DEFENSE = 0xCE1;
    private static final int ADDRESS_MINION_ONE_MAGIC_ATTACK = 0xCE2;
    private static final int ADDRESS_MINION_ONE_MAGIC_DEFENSE = 0xCE3;
    private static final int ADDRESS_MINION_ONE_SPEED = 0xCE4;

    private static final int CHECKSUM_START_BOUNDARY = 0x0300;
    private static final int CHECKSUM_END_BOUNDARY = 0x1FBF;

    protected SLESSaveData(byte[] bytes)
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
        return ADDRESS_MINION_ONE_EXISTENCE + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionCurrentHPAddress(int slot)
    {
        return ADDRESS_MINION_ONE_CURRENT_HP + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionMaximumHPAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAXIMUM_HP + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionAttackAddress(int slot)
    {
        return ADDRESS_MINION_ONE_ATTACK + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionDefenseAddress(int slot)
    {
        return ADDRESS_MINION_ONE_DEFENSE + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionMagicAttackAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAGIC_ATTACK + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionMagicDefenseAddress(int slot)
    {
        return ADDRESS_MINION_ONE_MAGIC_DEFENSE + (slot * MINION_DATA_SIZE);
    }

    @Override
    protected int getMinionSpeedAddress(int slot)
    {
        return ADDRESS_MINION_ONE_SPEED + (slot * MINION_DATA_SIZE);
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
