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

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.utils.TextUtil;

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
    @SerializedName("mode"           )      public String             _mode = null;

    transient boolean _Upserts;
    transient boolean _Inserts;
    transient boolean _TruncateFirst;
    transient String  _ZipFilePath      = null;
    
    public boolean validate(Connection C, String rootFolder, List<String> errorMessages) throws Exception
     {
       SchemaMeta sMeta = new SchemaMeta(_SchemaName);
       sMeta.load(C, _TableName);
       TableMeta tableMeta = sMeta.getTableMeta(_TableName);
       if (tableMeta == null)
         {
           errorMessages.add("Table " + getTableFullName() + " cannot be found. ");
           return false;
         }
        for (ColumnHeader CH : _ColumnHeaderList)
         if (CH != null)
          CH.validate();

       if (TextUtil.isNullOrEmpty(rootFolder) == false)
         {
           ListIterator<String> filesIterator = _FileList.listIterator();
           while(filesIterator.hasNext())
             {
               filesIterator.set(rootFolder + File.separator + filesIterator.next());
             }
         }
       
       if (TextUtil.isNullOrEmpty(_mode) == true)
         {
           errorMessages.add("Data definition for " + getTableFullName() + " is not defining the 'mode' property, which is mandatory. ");
           return false;
         }
       else if (_mode.equals("INSERT") == true)
         {
           _Inserts = true;
         }
       else if  (_mode.equals("TRUNCATE_INSERT") == true)
         {
           _Inserts = true;
           _TruncateFirst = true;
         }
       else if (_mode.equals("UPSERT") == true)
         {
           _Upserts = true;
           String[] uniqueColumns = getUniqueColumnsList();
           if (uniqueColumns.length < 1)
             {
               errorMessages.add("Data definition for " + getTableFullName() + " is invalid: upserts must also specify the object's identify in 'uniqueColumns'. ");
               return false;
             }
           if (tableMeta.getIndex(uniqueColumns, true) == null)
             {
               errorMessages.add("Data definition for " + getTableFullName() + " is invalid: 'uniqueColumns' is listing columns which do not match any existing unique index in the database.");
               return false;
             }
         }
       else
         {
           errorMessages.add("Data definition for " + getTableFullName() + " is defining a mode='"+_mode+"' which is invalid. Must be one of 'INSERT', 'TRUNCATE_INSERT', 'UPSERT'. ");
           return false;
         }
       return true;
     }
    
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
    
    public String[] getUniqueColumnsList()
      {
        return _uniqueColumnsList.toArray(new String[_uniqueColumnsList.size()]);
      }
      
    public boolean isUpserts()
      {
        return _Upserts;
      }
    
    public boolean isInserts()
      {
        return _Inserts;
      }
    
    public boolean isTruncateFirst()
      {
        return _TruncateFirst;
      }

    public String getTableFullName()
      {
        return this._SchemaName + "." + this._TableName;
      }
    
    public void setIsUpserts()
      {
        this._Upserts = true;
        this._Inserts = false;
      }
    
    public void setIsInserts()
      {
        this._Inserts = true;
        this._Upserts = false;
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
        return this._TruncateFirst;
      }
    
    public void setShouldTruncate()
      {
        if (isInserts() != isUpserts() && isInserts())
          this._TruncateFirst = true;
      }
    
    public void setZipFilePath(String value)
      {
        this._ZipFilePath = value;
      }
    
    public String getZipFilePath()
      {
        return this._ZipFilePath;
      }

  }
