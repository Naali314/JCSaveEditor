package jadecocoonwiki.saveeditor.helper;

import javax.swing.*;
import java.awt.*;

public class CustomCellRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (index % 2 == 0)
        {
            c.setBackground(Color.lightGray);
        }
        else
        {
            c.setBackground(Color.white);
        }
        return c;
    }
}