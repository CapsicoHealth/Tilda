package tilda.loader.ui;

import javax.swing.table.AbstractTableModel;

public class ConnectionsTableModel extends AbstractTableModel
  {

    private static final long serialVersionUID = 8497360740251550634L;
    
    private String[]          columnNames      = { "Connection Id", "URL", "Select" };
    private Object[][]        connections      = null;

    public ConnectionsTableModel(Object connections[][])
      {
        this.connections = connections;
      }

    @Override
    public int getColumnCount()
      {
        return columnNames.length;
      }

    @Override
    public int getRowCount()
      {
        return this.connections.length;
      }

    public String getColumnName(int col)
      {
        return columnNames[col];
      }

    public Class<?> getColumnClass(int c)
      {
        return getValueAt(0, c).getClass();
      }

    public boolean isCellEditable(int row, int col)
      {
        return (col == 2);
      }

    
    @Override
    public Object getValueAt(int row, int col)
      {
         return connections[row][col];        
      }
    
    public void setValueAt(Object value, int row, int col)
      {
        connections[row][col] = value;
        fireTableCellUpdated(row, col);
      }
    

  }
