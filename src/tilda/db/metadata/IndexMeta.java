package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndexMeta
  {
    
    static final Logger LOG = LogManager.getLogger(IndexMeta.class.getName());
    
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
    
    public List<String> getColumnNames()
      {
        List<String> columnNames = new ArrayList<>();
        for(IndexColumnMeta icm : _Columns)
          columnNames.add(icm._Col);
        return columnNames;
      }
    
    public String getSignature() 
      {
        StringBuilder Str = new StringBuilder();
        for (IndexColumnMeta ICM : _Columns)
          {
            if (Str.length() != 0)
            {
              Str.append("|");
            }
            Str.append(ICM._Col);
            Str.append("|" + (ICM._Asc == null ? "**"+ICM._AscStr+"**" : ICM._Asc == true ? "asc" : "desc"));
          }

        return (_Unique ? "u" : "") + "i|" + Str.toString();
      }
  }
