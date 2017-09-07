package tilda.loader.ui;

import javax.swing.table.AbstractTableModel;

public class DataImportTableModel extends AbstractTableModel
  {

    private static final long serialVersionUID = 6603195072158914607L;

    private String[]          columnNames      = { "Table", "Import", "Truncate"
    };
    private Object[][]        data             = null;

    public DataImportTableModel(Object data[][])
      {
        this.data = data;
      }

    public int getColumnCount()
      {
        return columnNames.length;
      }

    public int getRowCount()
      {
        return data.length;
      }

    public String getColumnName(int col)
      {
        return columnNames[col];
      }

    public Object getValueAt(int row, int col)
      {
        return data[row][col];
      }

    public Class<?> getColumnClass(int c)
      {
        return getValueAt(0, c).getClass();
      }

    public boolean isCellEditable(int row, int col)
      {
        if (col == 1 || col == 2)
          {
            return true;
          }
        else
          {
            return false;
          }
      }

    /*
     * Don't need to implement this method unless your table's data can
     * change.
     */
    public void setValueAt(Object value, int row, int col)
      {
        data[row][col] = value;
        data[row][2] = value;
        fireTableCellUpdated(row, col);
        fireTableCellUpdated(row, 2);
      }
  }
