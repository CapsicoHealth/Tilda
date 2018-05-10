package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.JDBCHelper;

public class IndexMeta
  {
    
    static final Logger LOG = LogManager.getLogger(IndexMeta.class.getName());
    
    protected IndexMeta(ResultSet RS, TableMeta parentTable)
    throws Exception
      {
//        LOG.debug(JDBCHelper.PrintResultSet(RS));
        _Name   = RS.getString("INDEX_NAME" );//.toLowerCase();
        _Unique = RS.getBoolean("NON_UNIQUE") == false;
        _ParentTable = parentTable;
      }

    public final String     _Name  ;
    public final boolean    _Unique;
    public final TableMeta  _ParentTable;    
    public final List<IndexColumnMeta> _Columns = new ArrayList<IndexColumnMeta>();
    
    public String getCleanName()
      {
        String cleanName = _Name;
        if (cleanName.toLowerCase().startsWith(_ParentTable._TableName.toLowerCase()) == true)
          cleanName = cleanName.substring(_ParentTable._TableName.length());
        if (cleanName.startsWith("_") == true)
          cleanName = cleanName.substring(1);
        
        return cleanName;
      }
    

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
