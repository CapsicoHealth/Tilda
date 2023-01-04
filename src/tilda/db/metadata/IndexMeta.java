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

package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndexMeta
  {
    
    static final Logger LOG = LogManager.getLogger(IndexMeta.class.getName());
    
    protected IndexMeta(ResultSet RS, TableMeta parentTable/*, int indexPos*/)
    throws Exception
      {
//        LOG.debug(JDBCHelper.printResultSet(RS));
        _Name = RS.getString("INDEX_NAME" );
        _Unique = RS.getBoolean("NON_UNIQUE") == false;
        _ParentTable = parentTable;
//        _indexPos = indexPos;
//        _Name = name != null ? name : (_Unique ? "ui_":"i_")+_indexPos;
      }

    public final String     _Name  ;
    public final boolean    _Unique;
    public final TableMeta  _ParentTable;    
//    public final int        _indexPos ;
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
        // LDH-NOTE: Records are supposed to come in ordered, as per the JDBC spec. So it's easier to just add
        //          because otherwise, seems like ORDINAL_VALUE may be 1-based on 0-based depending on the database.
        //          For SQLServer, appears to be 0-based, causing the index-based add call to fail with entry '0' of course.
        if (Found == false)
         _Columns.add(/*CM._Pos-1,*/ CM);
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
            Str.append("|" + (ICM._Asc == null || ICM._Asc == true ? "asc" : "desc"));
          }

        return (_Unique ? "u" : "") + "i|" + Str.toString();
      }
  }
