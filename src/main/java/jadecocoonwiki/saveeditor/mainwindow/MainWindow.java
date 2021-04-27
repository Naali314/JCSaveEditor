package jadecocoonwiki.saveeditor.mainwindow;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import jadecocoonwiki.saveeditor.helper.CustomCellRenderer;
import jadecocoonwiki.saveeditor.model.savedata.JCSaveData;
import jadecocoonwiki.saveeditor.model.savedata.MemoryCard;
import jadecocoonwiki.saveeditor.model.savedata.SaveData;
import jadecocoonwiki.saveeditor.model.savedata.SizeMismatchException;
import jadecocoonwiki.saveeditor.saveeditor.SaveEditorWindow;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.*;

public class MainWindow implements SaveEditorWindow.Observer
{
    private final List<String> jcSlesGameIds = Arrays.asList("SLES-02201", "SLES-02202", "SLES-02203", "SLES-02205", "SLES-02206");
    private final List<SaveEditorWindow> openSaveEditorWindows;

    private final JFrame frame;
    private JPanel pnlMain;
    private JButton btnOpenFile;
    private JList<String> lstSaveData;
    private JButton btnSaveAs;
    private JButton btnSave;
    private JButton btnEditSaveData;
    private JButton btnJCWiki;
    private JButton btnJCDiscord;

    private MemoryCard memoryCard;

    public MainWindow()
    {
        $$$setupUI$$$();

        this.memoryCard = null;
        this.openSaveEditorWindows = new ArrayList<>();

        this.lstSaveData.setCellRenderer(new CustomCellRenderer());
        this.lstSaveData.addMouseListener(new SaveDataListMouseListener());
        this.btnOpenFile.addMouseListener(new OpenFileButtonMouseListener());
        this.btnEditSaveData.addMouseListener(new EditSaveDataButtonMouseListener());
        this.btnSaveAs.addMouseListener(new SaveAsButtonMouseListener());
        this.btnSave.addMouseListener(new SaveButtonMouseListener());
        this.btnJCDiscord.addMouseListener(new OpenDiscordMouseListener());
        this.btnJCWiki.addMouseListener(new OpenWikiMouseListener());

        this.frame = new JFrame("Jade Cocoon Save Editor");
        this.frame.setContentPane(this.pnlMain);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);

        JOptionPane.showMessageDialog(this.frame,
                "This save editor currently is a work-in-progress project. It may or may not function correctly. " +
                        "It *should* not cause any harm, but be careful nonetheless. Always keep backups of your files.");
    }

    private void openSaveData()
    {
        int selectedIndex = getSelectedSaveDataIndex();

        Optional<SaveEditorWindow> openSaveEditorWindow = this.openSaveEditorWindows
                .stream()
                .filter(saveEditorWindow -> saveEditorWindow.getSlot() == selectedIndex)
                .findFirst();
        if (openSaveEditorWindow.isPresent())
        {
            openSaveEditorWindow.get().requestFocus();
        }
        else
        {
            if (this.memoryCard != null)
            {
                String selectedGameId = this.memoryCard.getGameId(selectedIndex);
                JCSaveData selectedSaveData = null;
                if (isJCSLUSGameID(selectedGameId))
                {
                    selectedSaveData = this.memoryCard.getSLUSSaveData(selectedIndex);
                }
                if (isJCSLESGameID(selectedGameId))
                {
                    selectedSaveData = this.memoryCard.getSLESSaveData(selectedIndex);
                }
                if (selectedSaveData == null)
                {
                    JOptionPane.showMessageDialog(this.frame, "This game is not supported.");
                }
                else
                {
                    SaveEditorWindow saveEditorWindow = new SaveEditorWindow(selectedSaveData, selectedIndex);
                    saveEditorWindow.setObserver(this);
                    this.openSaveEditorWindows.add(saveEditorWindow);
                }
            }
        }
    }

    private int getSelectedSaveDataIndex()
    {
        return this.lstSaveData.getSelectedIndex();
    }

    private boolean isJCSLESGameID(String gameId)
    {
        return this.jcSlesGameIds.contains(gameId);
    }

    private boolean isJCSLUSGameID(String gameId)
    {
        return "SLUS-00854".equals(gameId);
    }

    @Override
    public void onSaveEditDone(SaveData editedSaveData, int slot)
    {
        this.removeOpenSaveEditorWindow(slot);
        this.memoryCard.setSaveData(editedSaveData, slot);
    }

    @Override
    public void onSaveEditDiscard(int slot)
    {
        this.removeOpenSaveEditorWindow(slot);
    }

    private void removeOpenSaveEditorWindow(int slot)
    {
        this.openSaveEditorWindows.removeIf(window -> window.getSlot() == slot);
    }

    private void openWebpage(URI uri)
    {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
        {
            try
            {
                desktop.browse(uri);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
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
        pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayoutManager(6, 3, new Insets(8, 8, 8, 8), -1, -1));
        btnOpenFile = new JButton();
        btnOpenFile.setText("Open file ...");
        pnlMain.add(btnOpenFile, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnSaveAs = new JButton();
        btnSaveAs.setEnabled(false);
        btnSaveAs.setText("Save As ...");
        pnlMain.add(btnSaveAs, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnEditSaveData = new JButton();
        btnEditSaveData.setText("Edit this data");
        pnlMain.add(btnEditSaveData, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnlMain.add(panel1, new GridConstraints(0, 1, 6, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder(null, "Game IDs", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lstSaveData = new JList();
        lstSaveData.setEnabled(false);
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        defaultListModel1.addElement("Empty Slot");
        lstSaveData.setModel(defaultListModel1);
        panel1.add(lstSaveData, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        btnSave = new JButton();
        btnSave.setEnabled(false);
        btnSave.setText("Save");
        pnlMain.add(btnSave, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnJCWiki = new JButton();
        btnJCWiki.setText("JC Wiki");
        pnlMain.add(btnJCWiki, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnJCDiscord = new JButton();
        btnJCDiscord.setText("JC Discord");
        pnlMain.add(btnJCDiscord, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        pnlMain.add(spacer1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        pnlMain.add(spacer2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return pnlMain;
    }

    private class OpenFileButtonMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            if (!openSaveEditorWindows.isEmpty() && JOptionPane.showConfirmDialog(frame,
                    "When you successfully load a memory card, all changes to the current one will be discarded. Continue?",
                    "Discard changes?",
                    OK_CANCEL_OPTION,
                    QUESTION_MESSAGE) == CANCEL_OPTION)
            {
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            int chosenOption = fileChooser.showOpenDialog(frame);
            if (chosenOption == APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                try
                {
                    memoryCard = new MemoryCard(Paths.get(selectedFile.getAbsolutePath()));
                    for (SaveEditorWindow openSaveEditorWindow : openSaveEditorWindows)
                    {
                        openSaveEditorWindow.dispose();
                    }
                    openSaveEditorWindows.clear();
                    lstSaveData.setListData(memoryCard.getGameIds());
                    btnSaveAs.setEnabled(true);
                    btnSave.setEnabled(true);
                    lstSaveData.setEnabled(true);
                }
                catch (IOException ioException)
                {
                    JOptionPane.showMessageDialog(frame,
                            "Something went wrong while reading the file.",
                            "Error loading file",
                            JOptionPane.WARNING_MESSAGE);
                }
                catch (SizeMismatchException sizeMismatchException)
                {
                    JOptionPane.showMessageDialog(frame,
                            "The file you provided appears to be too small or too large for a memory card file.",
                            "Unrecognized file",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private class SaveDataListMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            if (e.getClickCount() == 2)
            {
                openSaveData();
            }
        }
    }

    private class SaveAsButtonMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            JFileChooser fileChooser = new JFileChooser();
            int chosenOption = fileChooser.showSaveDialog(null);
            if (chosenOption == APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                try
                {
                    Path path = Paths.get(selectedFile.getAbsolutePath());
                    memoryCard.save(path);
                    JOptionPane.showMessageDialog(frame, "Memory card was saved to " + path);
                }
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(frame,
                            "Something went wrong while save the file.",
                            "Error saving file",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private class SaveButtonMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            try
            {
                memoryCard.save();
                JOptionPane.showMessageDialog(frame, "Memory card was saved to " + memoryCard.getPath());
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(frame,
                        "Something went wrong while save the file.",
                        "Error saving file",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class EditSaveDataButtonMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            if (lstSaveData.getSelectedIndex() != -1)
            {
                openSaveData();
            }
        }
    }

    private class OpenDiscordMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            try
            {
                URL wikiURI = new URL("https://discord.gg/ErwKG2v");
                openWebpage(wikiURI.toURI());
            }
            catch (URISyntaxException | MalformedURLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private class OpenWikiMouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            try
            {
                URL wikiURI = new URL("https://thejadecocoonproject.fandom.com/wiki/Jade_Cocoon_Wiki");
                openWebpage(wikiURI.toURI());
            }
            catch (URISyntaxException | MalformedURLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
