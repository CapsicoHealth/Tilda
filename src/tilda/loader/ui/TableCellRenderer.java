package tilda.loader.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class TableCellRenderer extends DefaultTableCellRenderer
  {

    private static final long serialVersionUID = -4854392142881995074L;

    Color                     backgroundColor  = getBackground();

    @Override
    public Component getTableCellRendererComponent(
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
      {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, 2);
        c.setEnabled(false);
        return c;
      }
  }
