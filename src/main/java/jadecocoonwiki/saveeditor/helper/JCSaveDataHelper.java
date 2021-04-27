package jadecocoonwiki.saveeditor.helper;

import jadecocoonwiki.saveeditor.model.creature.LevantStats;
import jadecocoonwiki.saveeditor.model.creature.Minion;
import jadecocoonwiki.saveeditor.model.creature.MinionExistence;
import jadecocoonwiki.saveeditor.model.misc.Miscellaneous;
import jadecocoonwiki.saveeditor.model.savedata.JCSaveData;
import jadecocoonwiki.saveeditor.model.savedata.SaveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jadecocoonwiki.saveeditor.model.creature.MinionExistence.IN_PARTY;

public class JCSaveDataHelper
{
    private final JCSaveData saveData;
    private final List<Minion> minionList;

    public JCSaveDataHelper(JCSaveData saveData)
    {
        this.saveData = saveData;
        this.minionList = new ArrayList<>();
        this.loadMinionLists();
    }

    private void loadMinionLists()
    {
        for (int slot = 0; slot < 15; slot++)
        {
            MinionExistence existence = this.saveData.getMinionExistence(slot);

            Minion minion = new Minion();
            minion.setExistence(existence);
            minion.setCurrentHP(this.saveData.getMinionCurrentHP(slot));
            minion.setMaximumHP(this.saveData.getMinionMaximumHP(slot));
            minion.setAttack(this.saveData.getMinionAttack(slot));
            minion.setDefense(this.saveData.getMinionDefense(slot));
            minion.setMagicAttack(this.saveData.getMinionMagicAttack(slot));
            minion.setMagicDefense(this.saveData.getMinionMagicDefense(slot));
            minion.setSpeed(this.saveData.getMinionSpeed(slot));

            minionList.add(minion);
        }
    }

    public LevantStats getLevantStats()
    {
        LevantStats levantStats = new LevantStats();
        levantStats.setCurrentHP(this.saveData.getLevantCurrentHP());
        levantStats.setMaximumHP(this.saveData.getLevantMaximumHP());
        levantStats.setAttack(this.saveData.getLevantAttack());
        levantStats.setDefense(this.saveData.getLevantDefense());
        levantStats.setMagicAttack(this.saveData.getLevantMagicAttack());
        levantStats.setMagicDefense(this.saveData.getLevantMagicDefense());
        levantStats.setSpeed(this.saveData.getLevantSpeed());
        return levantStats;
    }

    public void setLevantStats(LevantStats levantStats)
    {
        this.saveData.setLevantCurrentHP(levantStats.getCurrentHP());
        this.saveData.setLevantMaximumHP(levantStats.getMaximumHP());
        this.saveData.setLevantAttack(levantStats.getAttack());
        this.saveData.setLevantDefense(levantStats.getDefense());
        this.saveData.setLevantMagicAttack(levantStats.getMagicAttack());
        this.saveData.setLevantMagicDefense(levantStats.getMagicDefense());
        this.saveData.setLevantSpeed(levantStats.getSpeed());
    }

    public Optional<Minion> getPartyMinion(int partySlot)
    {
        return this.minionList
                .stream()
                .filter(minion -> minion.getExistence() == IN_PARTY)
                .skip(partySlot)
                .findFirst();
    }

    public void setPartyMinion(int partySlot, Optional<Minion> minionOptional)
    {
        if (minionOptional.isPresent())
        {
            Minion minion = minionOptional.get();
            this.saveData.setMinionCurrentHP(partySlot, minion.getCurrentHP());
            this.saveData.setMinionMaximumHP(partySlot, minion.getMaximumHP());
            this.saveData.setMinionAttack(partySlot, minion.getAttack());
            this.saveData.setMinionDefense(partySlot, minion.getDefense());
            this.saveData.setMinionMagicAttack(partySlot, minion.getMagicAttack());
            this.saveData.setMinionMagicDefense(partySlot, minion.getMagicDefense());
            this.saveData.setMinionSpeed(partySlot, minion.getSpeed());
        }
    }

    public Miscellaneous getMisc()
    {
        Miscellaneous miscellaneous = new Miscellaneous();
        miscellaneous.setMoney(this.saveData.getMoney());
        return miscellaneous;
    }

    public void setMisc(Miscellaneous miscellaneous)
    {
        this.saveData.setMoney(miscellaneous.getMoney());
    }

    public void repairCheckSum()
    {
        this.saveData.repairCheckSum();
    }

    public SaveData getSaveData()
    {
        return this.saveData;
    }
}
