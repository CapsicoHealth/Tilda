package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IndexMeta
  {
    protected IndexMeta(ResultSet RS)
    throws Exception
      {
        _Name   = RS.getString("INDEX_NAME" ).toLowerCase();
        _Unique = RS.getBoolean("NON_UNIQUE") == false;
      }

    public final String     _Name  ;
    public final boolean    _Unique;
    public final List<IndexColumnMeta> _Columns = new ArrayList<IndexColumnMeta>();

    public void addColumn(ResultSet RS) throws Exception
      {
        IndexColumnMeta CM = new IndexColumnMeta(RS);
        boolean Found = false;
        for (IndexColumnMeta ICM : _Columns)
         if (ICM._Pos == CM._Pos)
           {
             Found = true;
             break;
           }
        if (Found == false)
         _Columns.add(CM._Pos-1, CM);
      }
    
    public String toString()
      {
        StringBuilder Str = new StringBuilder();
        for (IndexColumnMeta ICM : _Columns)
          {
            if (Str.length() != 0)
             Str.append(", ");
            Str.append("(").append(ICM.toString()).append(")");
          }
        return "Name: " + _Name + "; Unique: " + _Unique + "; Columns: ["+Str.toString()+"];";
      }
  }
