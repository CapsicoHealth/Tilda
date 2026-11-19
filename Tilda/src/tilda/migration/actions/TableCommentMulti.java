/* ===========================================================================
 * Copyright (C) 2026 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.migration.actions;

import java.util.ArrayList;
import java.util.List;

import tilda.data.MaintenanceLog_Data;
import tilda.db.Connection;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;

public class TableCommentMulti extends MigrationAction
  {
    private final Object _obj;
    private final boolean _tableComment;
    private final List<Column> _columns = new ArrayList<Column>();

    public TableCommentMulti(Object obj, boolean tableComment)
      {
        super(obj._ParentSchema._Name, obj._Name, false, MaintenanceLog_Data._actionComment, MaintenanceLog_Data._objectTypeTable);
        _obj = obj;
        _tableComment = tableComment;
      }

    public void addColumn(Column col)
      {
        if (col._ParentObject != _obj)
          throw new IllegalArgumentException("A batched comment must belong to " + _obj.getShortName());
        _columns.add(col);
      }

    public boolean isEmpty()
      {
        return _tableComment == false && _columns.isEmpty();
      }

    @Override
    public boolean process(Connection con) throws Exception
      {
        return con.alterTableComments(_obj, _tableComment, _columns);
      }

    @Override
    public String getDescription()
      {
        StringBuilder text = new StringBuilder("Set comments on ");
        text.append(_obj.getFullName());
        if (_tableComment == true)
          text.append(" (table description)");
        for (Column col : _columns)
          text.append("\n                                                         - column ").append(col.getName());
        return text.toString();
      }
  }