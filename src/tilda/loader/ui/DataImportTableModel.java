/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

public class DataImportTableModel extends AbstractTableModel
  {

    private static final long serialVersionUID = 6603195072158914607L;

    private String[]          columnNames      = { "Table", "Import" };
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
        return (data != null ? data.length : 0);
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
        return (col == 1 || col == 2);
      }

    /*
     * Don't need to implement this method unless your table's data can
     * change.
     */
    public void setValueAt(Object value, int row, int col)
      {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
      }
  }
