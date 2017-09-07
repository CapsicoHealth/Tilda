package tilda.loader.ui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModelListener implements TableModelListener
  {

    public void tableChanged(TableModelEvent e)
      {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        Object data = model.getValueAt(row, column);
        Boolean b = (Boolean) data;
        model.setValueAt(b, row, 2);
      }
  }
