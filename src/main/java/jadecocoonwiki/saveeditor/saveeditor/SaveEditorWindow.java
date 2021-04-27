package jadecocoonwiki.saveeditor.saveeditor;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import jadecocoonwiki.saveeditor.helper.JCSaveDataHelper;
import jadecocoonwiki.saveeditor.model.creature.Minion;
import jadecocoonwiki.saveeditor.model.savedata.JCSaveData;
import jadecocoonwiki.saveeditor.model.savedata.SaveData;
import jadecocoonwiki.saveeditor.saveeditor.levantstats.LevantStatsForm;
import jadecocoonwiki.saveeditor.saveeditor.minion.MinionForm;
import jadecocoonwiki.saveeditor.saveeditor.misc.MiscForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

import static java.lang.String.format;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class SaveEditorWindow
{
    private final int slot;
    private final JCSaveDataHelper jcSaveDataHelper;

    private final JFrame frame;
    private JPanel pnlSaveEditor;
    private JTabbedPane tbpMain;
    private LevantStatsForm frmLevantStats;
    private JTabbedPane tbpPartyMinions;
    private JPanel pnlPartyMinions;
    private MinionForm frmPartyMinion0;
    private MinionForm frmPartyMinion1;
    private MinionForm frmPartyMinion2;
    private MiscForm frmMisc;
    private JButton btnFinish;

    private Observer observer;

    public SaveEditorWindow(JCSaveData saveData, int slot)
    {
        this.slot = slot;
        this.jcSaveDataHelper = new JCSaveDataHelper(saveData);

        $$$setupUI$$$();
        this.disableUnusedPartyMinionForms();
        this.btnFinish.addMouseListener(new FinishButtonMouseListener());

        this.frame = new JFrame(format("Editing save %d", slot));
        this.frame.setContentPane(this.pnlSaveEditor);
        this.frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.addWindowListener(new WindowOnCloseListener());
    }

    private void createUIComponents()
    {
        this.frmLevantStats = new LevantStatsForm(this.jcSaveDataHelper.getLevantStats());

        this.frmPartyMinion0 = new MinionForm(this.jcSaveDataHelper.getPartyMinion(0));
        this.frmPartyMinion1 = new MinionForm(this.jcSaveDataHelper.getPartyMinion(1));
        this.frmPartyMinion2 = new MinionForm(this.jcSaveDataHelper.getPartyMinion(2));

        this.frmMisc = new MiscForm(this.jcSaveDataHelper.getMisc());
    }

    private void disableUnusedPartyMinionForms()
    {
        Optional<Minion> partyMinion0 = this.jcSaveDataHelper.getPartyMinion(0);
        Optional<Minion> partyMinion1 = this.jcSaveDataHelper.getPartyMinion(1);
        Optional<Minion> partyMinion2 = this.jcSaveDataHelper.getPartyMinion(2);

        if (!partyMinion0.isPresent() && !partyMinion1.isPresent() && !partyMinion2.isPresent())
        {
            this.tbpMain.setEnabledAt(this.tbpMain.indexOfComponent(this.pnlPartyMinions), false);
        }

        partyMinion0.ifPresent(minion -> this.tbpPartyMinions.setEnabledAt(0, true));
        partyMinion1.ifPresent(minion -> this.tbpPartyMinions.setEnabledAt(1, true));
        partyMinion2.ifPresent(minion -> this.tbpPartyMinions.setEnabledAt(2, true));
    }

    private void finishEditing()
    {
        this.jcSaveDataHelper.setLevantStats(this.frmLevantStats.getLevantStats());
        this.jcSaveDataHelper.setPartyMinion(0, this.frmPartyMinion0.getMinionOptional());
        this.jcSaveDataHelper.setPartyMinion(1, this.frmPartyMinion1.getMinionOptional());
        this.jcSaveDataHelper.setPartyMinion(2, this.frmPartyMinion2.getMinionOptional());
        this.jcSaveDataHelper.setMisc(this.frmMisc.getMisc());
        this.jcSaveDataHelper.repairCheckSum();
        this.observer.onSaveEditDone(this.jcSaveDataHelper.getSaveData(), slot);
        this.dispose();
    }

    private void discardChanges()
    {
        this.observer.onSaveEditDiscard(slot);
        this.dispose();
    }

    public void dispose()
    {
        this.frame.dispose();
    }

    public int getSlot()
    {
        return slot;
    }

    public void setObserver(Observer observer)
    {
        this.observer = observer;
    }

    public void requestFocus()
    {
        this.frame.toFront();
        this.frame.requestFocus();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        pnlSaveEditor = new JPanel();
        pnlSaveEditor.setLayout(new GridLayoutManager(2, 2, new Insets(8, 8, 8, 8), -1, -1));
        tbpMain = new JTabbedPane();
        tbpMain.setEnabled(true);
        pnlSaveEditor.add(tbpMain, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setEnabled(true);
        panel1.setForeground(new Color(-4473925));
        tbpMain.addTab("Levant Stats", panel1);
        panel1.add(frmLevantStats.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        pnlPartyMinions = new JPanel();
        pnlPartyMinions.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnlPartyMinions.setEnabled(true);
        tbpMain.addTab("Party Minions", pnlPartyMinions);
        tbpPartyMinions = new JTabbedPane();
        tbpPartyMinions.setEnabled(true);
        pnlPartyMinions.add(tbpPartyMinions, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setEnabled(true);
        tbpPartyMinions.addTab("Slot 1", panel2);
        tbpPartyMinions.setEnabledAt(0, false);
        panel2.add(frmPartyMinion0.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tbpPartyMinions.addTab("Slot 2", panel3);
        tbpPartyMinions.setEnabledAt(1, false);
        panel3.add(frmPartyMinion1.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tbpPartyMinions.addTab("Slot 3", panel4);
        tbpPartyMinions.setEnabledAt(2, false);
        panel4.add(frmPartyMinion2.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tbpMain.addTab("Misc", panel5);
        panel5.add(frmMisc.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnFinish = new JButton();
        btnFinish.setText("Finish");
        pnlSaveEditor.add(btnFinish, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        pnlSaveEditor.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return pnlSaveEditor;
    }

    public interface Observer
    {
        void onSaveEditDone(SaveData editedSaveData, int slot);

        void onSaveEditDiscard(int slot);
    }

    private class FinishButtonMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            finishEditing();
        }
    }

    private class WindowOnCloseListener extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent windowEvent)
        {
            requestFocus(); // take focus from any formatted text field - otherwise they might not notice
            int choice = JOptionPane.showConfirmDialog(frame,
                    "Do you want to save your changes to this save?",
                    "Close this window?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION)
            {
                finishEditing();
            }
            else if (choice == JOptionPane.NO_OPTION)
            {
                discardChanges();
            }
        }
    }
}