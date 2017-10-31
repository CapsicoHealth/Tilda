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

package tilda.loader.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.annotations.SerializedName;

public class DataObject
  {

    @SerializedName("filepath"       )      public List<String>       _FileList = new ArrayList<String>();
    @SerializedName("schemaName"     )      public String             _SchemaName;
    @SerializedName("tableName"      )      public String             _TableName;
    @SerializedName("headerList"     )	    public List<String>       _HeaderList    = new ArrayList<String>();
    @SerializedName("maps"        	 )	    public List<ColumnHeader> _ColumnHeaderList    = new ArrayList<ColumnHeader>();
    @SerializedName("datePattern"    )      public String             _datePattern;
    @SerializedName("dateTimePattern")      public String             _dateTimePattern;
    @SerializedName("zoneId"      	 )      public String             _zoneId;
    @SerializedName("headersIncluded")      public boolean            _HeadersIncluded;
    @SerializedName("multiHeaderDelimeter") public String             _multiHeaderDelimeter;
    @SerializedName("uniqueColumns"  )      public List<String>       _uniqueColumnsList    = new ArrayList<String>();
    @SerializedName("upserts"        )      public boolean            _upserts = false;
    @SerializedName("inserts"        )      public boolean            _inserts = false;
    
    private transient boolean _truncate = false;
    
    
    
    public  String[] getColumns(){
      List<String> Cols = new LinkedList<String>();
      for(ColumnHeader ColumnHeader : _ColumnHeaderList)
        {
          if(ColumnHeader != null)
            Cols.add(ColumnHeader._Column);
        }
      
      return Cols.toArray(new String[Cols.size()]);
    }
    public  String[] getHeaders(){
      List<String> Headers = new LinkedList<String>();
      for(ColumnHeader ColumnHeader : _ColumnHeaderList)
        {
          Headers.add(ColumnHeader._Header);
        }
      
      return Headers.toArray(new String[Headers.size()]);
    }  
    public Map<String,ColumnHeader> getMultiHeaderColumnMap()
    {
      Map<String,ColumnHeader> MultiHeaderColMap = new HashMap<String,ColumnHeader>();
      for(ColumnHeader ColumnHeader : _ColumnHeaderList)
        {
          MultiHeaderColMap.put(ColumnHeader._Column, ColumnHeader);
        }
      return MultiHeaderColMap;
    }
    public String[] getHeadersList(){
      return _HeaderList.toArray(new String[_HeaderList.size()]);
    }
    public void validate() throws Exception
      {
        for (ColumnHeader CH : _ColumnHeaderList)
          if (CH != null)
            CH.validate();
        
      }
    
    public String[] getUniqueColumnsList()
      {
        return _uniqueColumnsList.toArray(new String[_uniqueColumnsList.size()]);
      }
      
    public boolean isUpserts()
      {
        return this._upserts;
      }
    
    public boolean isInserts()
      {
        return this._inserts;
      }

    public String getTableFullName()
      {
        return this._SchemaName + "." + this._TableName;
      }
    
    public void setIsUpserts()
      {
        this._upserts = true;
        this._inserts = false;
      }
    
    public void setIsInserts()
      {
        this._inserts = true;
        this._upserts = false;
      }
    
    public void setFilePath(String filePath)
      {
        if (this._FileList == null)
          this._FileList = new ArrayList<String>();        
        this._FileList.clear();
        this._FileList.add(filePath);
      }
    
    public boolean isShouldTruncate()
      {
        return this._truncate;
      }
    
    public void setShouldTruncate()
      {
        if (isInserts() != isUpserts() && isInserts())
          this._truncate = true;
      }

  }
