/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        return (connections != null ? connections.length : 0);
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
