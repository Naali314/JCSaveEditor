package jadecocoonwiki.saveeditor.saveeditor.minion;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import jadecocoonwiki.saveeditor.model.creature.Minion;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.util.Optional;

import static jadecocoonwiki.saveeditor.helper.FormatterProvider.*;

public class MinionForm
{
    private final Optional<Minion> minionOptional;

    @SuppressWarnings("unused")
    private JPanel pnlMinionOne;

    private JFormattedTextField txtCurrentHP;
    private JFormattedTextField txtMaximumHP;
    private JFormattedTextField txtDMFire;
    private JLabel lblDMFire;
    private JFormattedTextField txtDMAir;
    private JLabel lblDMAir;
    private JFormattedTextField txtDMEarth;
    private JLabel lblDMEarth;
    private JFormattedTextField txtDMWater;
    private JLabel lblDMWater;
    private JFormattedTextField txtDMPoison;
    private JLabel lblDMPoison;
    private JFormattedTextField txtDMSleep;
    private JLabel lblDMSleep;
    private JFormattedTextField txtDMFleshToStone;
    private JLabel lblDMFleshToStone;
    private JFormattedTextField txtDMDeath;
    private JLabel lblDMDeath;
    private JFormattedTextField txtDMAbsorption;
    private JLabel lblDMAbsorption;
    private JFormattedTextField txtDMHealing;
    private JLabel lblDMHealing;
    private JFormattedTextField txtDMBasicAttack;
    private JLabel lblDMBasicAttack;
    private JFormattedTextField txtAttack;
    private JFormattedTextField txtDefense;
    private JFormattedTextField txtMagicAttack;
    private JFormattedTextField txtMagicDefense;
    private JFormattedTextField txtSpeed;

    public MinionForm(Optional<Minion> minionOptional)
    {
        this.minionOptional = minionOptional;
        $$$setupUI$$$();
    }

    private void createUIComponents()
    {
        NumberFormatter hpFormatter = getHPFormatter();
        NumberFormatter dmFormatter = getSignedByteFormatter();
        NumberFormatter statsFormatter = getStatsFormatter();

        this.txtCurrentHP = new JFormattedTextField(hpFormatter);
        this.txtMaximumHP = new JFormattedTextField(hpFormatter);
        this.txtDMFire = new JFormattedTextField(dmFormatter);
        this.lblDMFire = new JLabel();
        addDMTextFieldListener(this.txtDMFire, this.lblDMFire);
        this.txtDMAir = new JFormattedTextField(dmFormatter);
        this.lblDMAir = new JLabel();
        addDMTextFieldListener(this.txtDMAir, this.lblDMAir);
        this.txtDMEarth = new JFormattedTextField(dmFormatter);
        this.lblDMEarth = new JLabel();
        addDMTextFieldListener(this.txtDMEarth, this.lblDMEarth);
        this.txtDMWater = new JFormattedTextField(dmFormatter);
        this.lblDMWater = new JLabel();
        addDMTextFieldListener(this.txtDMWater, this.lblDMWater);
        this.txtDMPoison = new JFormattedTextField(dmFormatter);
        this.lblDMPoison = new JLabel();
        addDMTextFieldListener(this.txtDMPoison, this.lblDMPoison);
        this.txtDMSleep = new JFormattedTextField(dmFormatter);
        this.lblDMSleep = new JLabel();
        addDMTextFieldListener(this.txtDMSleep, this.lblDMSleep);
        this.txtDMFleshToStone = new JFormattedTextField(dmFormatter);
        this.lblDMFleshToStone = new JLabel();
        addDMTextFieldListener(this.txtDMFleshToStone, this.lblDMFleshToStone);
        this.txtDMDeath = new JFormattedTextField(dmFormatter);
        this.lblDMDeath = new JLabel();
        addDMTextFieldListener(this.txtDMDeath, this.lblDMDeath);
        this.txtDMAbsorption = new JFormattedTextField(dmFormatter);
        this.lblDMAbsorption = new JLabel();
        addDMTextFieldListener(this.txtDMAbsorption, this.lblDMAbsorption);
        this.txtDMHealing = new JFormattedTextField(dmFormatter);
        this.lblDMHealing = new JLabel();
        addDMTextFieldListener(this.txtDMHealing, this.lblDMHealing);
        this.txtDMBasicAttack = new JFormattedTextField(dmFormatter);
        this.lblDMBasicAttack = new JLabel();
        addDMTextFieldListener(this.txtDMBasicAttack, this.lblDMBasicAttack);
        this.txtAttack = new JFormattedTextField(statsFormatter);
        this.txtDefense = new JFormattedTextField(statsFormatter);
        this.txtMagicAttack = new JFormattedTextField(statsFormatter);
        this.txtMagicDefense = new JFormattedTextField(statsFormatter);
        this.txtSpeed = new JFormattedTextField(statsFormatter);

        if (this.minionOptional.isPresent())
        {
            Minion minion = this.minionOptional.get();

            this.txtCurrentHP.setValue(minion.getCurrentHP());
            this.txtMaximumHP.setValue(minion.getMaximumHP());
            this.txtDMFire.setValue(minion.getDmFire());
            this.txtDMAir.setValue(minion.getDmAir());
            this.txtDMEarth.setValue(minion.getDmEarth());
            this.txtDMWater.setValue(minion.getDmWater());
            this.txtDMPoison.setValue(minion.getDmPoison());
            this.txtDMSleep.setValue(minion.getDmSleep());
            this.txtDMFleshToStone.setValue(minion.getDmFleshToStone());
            this.txtDMDeath.setValue(minion.getDmDeath());
            this.txtDMAbsorption.setValue(minion.getDmAbsorption());
            this.txtDMHealing.setValue(minion.getDmHealing());
            this.txtDMBasicAttack.setValue(minion.getDmBasicAttack());
            this.txtAttack.setValue(minion.getAttack());
            this.txtDefense.setValue(minion.getDefense());
            this.txtMagicAttack.setValue(minion.getMagicAttack());
            this.txtMagicDefense.setValue(minion.getMagicDefense());
            this.txtSpeed.setValue(minion.getSpeed());
        }
    }

    private void addDMTextFieldListener(JFormattedTextField textField, JLabel targetLabel)
    {
        textField.addPropertyChangeListener("value", evt -> {
            if (evt.getNewValue() instanceof Byte)
            {
                byte input = (Byte) evt.getNewValue();
                double newPercentage = Math.abs(3.125 * input);
                String damageOrHeal = input >= 0 ? "damage" : "heal";
                targetLabel.setText(String.format("(~ %.1f %% %s)", newPercentage, damageOrHeal));
            }
        });
    }

    public Optional<Minion> getMinionOptional()
    {
        if (this.minionOptional.isPresent())
        {
            Minion minion = minionOptional.get();
            minion.setCurrentHP((Integer) txtCurrentHP.getValue());
            minion.setMaximumHP((Integer) txtMaximumHP.getValue());
            minion.setDmFire((byte) txtDMFire.getValue());
            minion.setDmAir((byte) txtDMAir.getValue());
            minion.setDmEarth((byte) txtDMEarth.getValue());
            minion.setDmWater((byte) txtDMWater.getValue());
            minion.setDmPoison((byte) txtDMPoison.getValue());
            minion.setDmSleep((byte) txtDMSleep.getValue());
            minion.setDmFleshToStone((byte) txtDMFleshToStone.getValue());
            minion.setDmDeath((byte) txtDMDeath.getValue());
            minion.setDmAbsorption((byte) txtDMAbsorption.getValue());
            minion.setDmHealing((byte) txtDMHealing.getValue());
            minion.setDmBasicAttack((byte) txtDMBasicAttack.getValue());
            minion.setAttack((Short) txtAttack.getValue());
            minion.setDefense((Short) txtDefense.getValue());
            minion.setMagicAttack((Short) txtMagicAttack.getValue());
            minion.setMagicDefense((Short) txtMagicDefense.getValue());
            minion.setSpeed((Short) txtSpeed.getValue());
            return Optional.of(minion);
        }
        else
        {
            return Optional.empty();
        }
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
        pnlMinionOne = new JPanel();
        pnlMinionOne.setLayout(new GridLayoutManager(19, 4, new Insets(8, 8, 8, 8), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Current HP");
        pnlMinionOne.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Maximum HP");
        pnlMinionOne.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Attack");
        pnlMinionOne.add(label3, new GridConstraints(13, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Defense");
        pnlMinionOne.add(label4, new GridConstraints(14, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Magic Attack");
        pnlMinionOne.add(label5, new GridConstraints(15, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Magic Defense");
        pnlMinionOne.add(label6, new GridConstraints(16, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Speed");
        pnlMinionOne.add(label7, new GridConstraints(17, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        pnlMinionOne.add(spacer1, new GridConstraints(0, 3, 18, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        pnlMinionOne.add(spacer2, new GridConstraints(18, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        pnlMinionOne.add(txtCurrentHP, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtMaximumHP, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtAttack, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDefense, new GridConstraints(14, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtMagicAttack, new GridConstraints(15, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtMagicDefense, new GridConstraints(16, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtSpeed, new GridConstraints(17, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("DM Fire");
        pnlMinionOne.add(label8, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(txtDMFire, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("DM Air");
        pnlMinionOne.add(label9, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("DM Earth");
        pnlMinionOne.add(label10, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("DM Water");
        pnlMinionOne.add(label11, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("DM Poison");
        pnlMinionOne.add(label12, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("DM Sleep");
        pnlMinionOne.add(label13, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("DM Flesh-To-Stone");
        pnlMinionOne.add(label14, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("DM Death");
        pnlMinionOne.add(label15, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("DM Absorption");
        pnlMinionOne.add(label16, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("DM Healing");
        pnlMinionOne.add(label17, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setText("DM Basic Attack");
        pnlMinionOne.add(label18, new GridConstraints(12, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(txtDMAir, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMEarth, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMWater, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMPoison, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMSleep, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMFleshToStone, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMDeath, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMAbsorption, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMHealing, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(txtDMBasicAttack, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnlMinionOne.add(lblDMFire, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMAir, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMEarth, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMWater, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMPoison, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMSleep, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMFleshToStone, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMDeath, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMAbsorption, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMHealing, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMinionOne.add(lblDMBasicAttack, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return pnlMinionOne;
    }

}
