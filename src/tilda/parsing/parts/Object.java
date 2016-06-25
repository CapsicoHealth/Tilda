/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.parsing.parts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;

public class Object extends Base
  {

    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("occ"           ) public boolean              _OCC        = true ;
    @SerializedName("lc"            ) public String               _LCStr      = ObjectLifecycle.NORMAL.toString();

    @SerializedName("columns"       ) public List<Column>         _Columns    = new ArrayList<Column        >();

    @SerializedName("primary"       ) public PrimaryKey           _PrimaryKey = null;
    @SerializedName("foreign"       ) public List<ForeignKey>     _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"       ) public List<Index>          _Indices    = new ArrayList<Index         >();
    @SerializedName("http"          ) public HttpMapping[]        _Http       = { };
    @SerializedName("history"       ) public String     []        _History    = { };
    @SerializedName("dropOldColumns") public String     []        _DropOldColumns = { };
    
    /*@formatter:on*/

    public transient boolean              _HasUniqueIndex;
    public transient boolean              _HasUniqueQuery;
    public transient FrameworkSourcedType _FST = FrameworkSourcedType.NONE;
    public transient ObjectLifecycle      _LC;

    @Override
    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C.getName() != null && C.getName().equalsIgnoreCase(name) == true)
            return C;
        return null;
      }
    @Override
    public String[] getColumnNames()
      {
        String[] Cols = new String[_Columns.size()];
        for (int i = 0; i < _Columns.size(); ++i)
         Cols[i] = _Columns.get(i).getName();
        return Cols;
      }
    
    @Override
    public ObjectLifecycle getLifecycle()
      {
        return _LC;
      }
    @Override
    public boolean isOCC()
      {
        return _OCC;
      }
    @Override
    public String getWhat()
      {
        return "Object";
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (_Validated == true)
          return true;

        if (super.Validate(PS, ParentSchema) == false)
         return false;

        int Errs = PS.getErrorCount();

        if (getFullName().equals("tilda.data.TILDA.KEY") == true)
          {
            if (getColumn("created") == null || getColumn("lastUpdated") == null || getColumn("deleted") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base OCC (created, lastUpdated, deleted) columns.");
            if (getColumn("refnum") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base refnum columns.");
            _OCC = true;
          }
        else
          {
            if (_OCC == true)
              {
                if (CreateOCCColumns(PS) == false)
                  return false;
              }
            if (_PrimaryKey != null && _PrimaryKey._Autogen == true)
              {
                if (CreateAutogenPK(PS) == false)
                  return false;
              }
          }


        if (_Columns == null || _Columns.isEmpty() == true)
          PS.AddError("Object '" + getFullName() + "' doesn't define any columns!");
        else
          {
            Set<String> ColumnNames = new HashSet<String>();
            for (int i = 0; i < _Columns.size(); ++i)
              {
                Column C = _Columns.get(i);
                // It's possible in JSON to have dangling commas, which GSON will read fine as a NULL object. So we need to protect against that.
                if (C == null)
                 {
                   _Columns.remove(i);
                   --i;
                   continue;
                 }
                if (i >= 64)
                  PS.AddError("Object '" + getFullName() + "' has declared more than 64 columns!");
                else
                  {
                    _PadderColumnNames.track(C.getName());
                    if (C.Validate(PS, this) == true)
                      {
                        if (ColumnNames.add(C.getName().toUpperCase()) == false)
                         PS.AddError("Column '" + C.getFullName() + "' is defined more than once in Object '" + getFullName() + "'.");
                        if (C._Type == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                          {
                            Column TZCol = new Column(C.getName()+"TZ", null, 0, C._Nullable, ColumnMode.AUTO, C._Invariant, null, "Generated helper column to hold the time zone ID for '"+C.getName()+"'.");
                            TZCol._SameAs = "tilda.data.TILDA.ZONEINFO.id";
                            TZCol._FrameworkManaged = true;
                            _Columns.add(i, TZCol);
                            ++i;
                            _PadderColumnNames.track(TZCol.getName());
                            if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                              PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in Object '" + getFullName() + "'.");
                            TZCol.Validate(PS, this);
                            addForeignKey(C.getName(), new String[] { TZCol.getName() }, "tilda.data.TILDA.ZONEINFO");
                          }
                      }
                  }
              }
          }

        for (int i = 0; i < _DropOldColumns.length; ++i)
          {
            String n = _DropOldColumns[i];
            if (getColumn(n) != null)
             PS.AddError("Object '" + getFullName() + "' is defining a drop column '" + n + "' which is also already defined as a real column. DropOldColumns is used to automate cleaning of old columns that should no longer be part of a table definition.");
          }

        _HasUniqueIndex = false;
        Set<String> Names = new HashSet<String>();
        for (Index I : _Indices)
          {
            if (I == null)
              continue;
            if (I.Validate(PS, this) == true)
              if (Names.add(I._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate index '" + I._Name + "'.");
            if (I._Unique == true)
              _HasUniqueIndex = true;
          }

        Names.clear();
        _HasUniqueQuery = false;
        for (SubWhereClause SWC : _Queries)
          {
            if (SWC == null)
              continue;
            if (SWC.Validate(PS, this, "Object '" + getFullName()+"'", true) == true)
              if (Names.add(SWC._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate query '" + SWC._Name + "'.");
            if (SWC._Unique == true)
              _HasUniqueQuery = true;
          }

        super.ValidateJsonMappings(PS);
        
        if ((_LC = ObjectLifecycle.parse(_LCStr)) == null)
          return PS.AddError("Object '" + getFullName() + "' defined an invalid 'lc' '" + _LCStr + "'.");

        if (_PrimaryKey != null)
          _PrimaryKey.Validate(PS, this);

        Set<String> FKNames = new HashSet<String>();
        for (ForeignKey FK : _ForeignKeys)
          {
            if (FK == null)
              continue;
            if (FK.Validate(PS, this) == true)
              if (FKNames.add(FK._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate foreignKey '" + FK._Name + "'.");
          }

        if (_PrimaryKey == null && _HasUniqueIndex == false && _FST != FrameworkSourcedType.VIEW)
          PS.AddError("Object '" + getFullName() + "' doesn't have any identity. You must define at least a primary key or a unique index.");

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    /**
     * A Column is an autogen PK if and only if it is the one column defined by the PK. All AutoGen PKs must
     * have only one column (and also be a LONG).
     * 
     * @param C
     * @return
     */
    public boolean isAutoGenPrimaryKey(Column C)
      {
        return _PrimaryKey != null && _PrimaryKey._Autogen == true && C == _PrimaryKey._ColumnObjs.get(0);
      }

    private boolean CreateAutogenPK(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && C.getName().equalsIgnoreCase("refnum") == true)
            return PS.AddError("Object '" + getFullName() + "' has defined an autogen primary key but is also defining column 'refnum', which is a reserved name.");

        Column C = new Column("refnum", null, 0, false, null, true, null, PS.getColumn("tilda.data", "TILDA", "KEY", "refnum")._Description);
        C._SameAs = "tilda.data.TILDA.KEY.refnum";
        _Columns.add(0, C);

        return true;
      }

    private boolean CreateOCCColumns(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && (C.getName().equalsIgnoreCase("created") == true || C.getName().equalsIgnoreCase("lastUpdated") == true || C.getName().equalsIgnoreCase("deleted") == true))
            return PS.AddError("Object '" + getFullName() + "' has defined OCC to be true but is also defining column '" + C.getName() + "', which is a reserved name.");

        Column C = new Column("created", null, 0, false, ColumnMode.AUTO, true, null, PS.getColumn("tilda.data", "TILDA", "KEY", "created")._Description);
        C._SameAs = "tilda.data.TILDA.KEY.created";
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column("lastUpdated", null, 0, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "KEY", "lastUpdated")._Description);
        C._SameAs = "tilda.data.TILDA.KEY.lastUpdated";
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column("deleted", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "KEY", "deleted")._Description);
        C._SameAs = "tilda.data.TILDA.KEY.deleted";
        C._FrameworkManaged = true;
        _Columns.add(C);

        return true;
      }

    public static boolean isOCCColumn(Column C)
      {
        return C.isOCCGenerated();
      }

    public void AddColumnAfter(Column SiblingCol, Column NewCol)
      {
        int i = _Columns.indexOf(SiblingCol);
        if (i != -1)
         _Columns.add(i+1, NewCol);
      }

    public List<Column> getDefaultCreateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C._DefaultCreateValue != null)
            L.add(C);
        return L;
      }

    public List<Column> getDefaultUpdateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C._DefaultUpdateValue != null)
            L.add(C);
        return L;
      }

    public List<Column> getCopyToColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C.isCopyToColumn() == true)
            L.add(C);
        return L;
      }


    public List<Column> getCreateColumns()
      {
        List<Column> L = new ArrayList<Column>();
        for (Column C : _Columns)
          if (C != null && C.isCreateColumn() == true)
            L.add(C);
        return L;
      }
    
    public List<Column> getJsonColumns()
    {
      List<Column> L = new ArrayList<Column>();
      for (Column C : _Columns)
        if (C != null && C.isJSONColumn() == true)
          L.add(C);
      return L;
    }
    

    protected void addForeignKey(String Name, String[] ColumnNames, String DestinationObject)
      {
        ForeignKey FK = new ForeignKey();
        FK._Name = Name;
        FK._DestObject = DestinationObject;
        FK._SrcColumns = ColumnNames;

        _ForeignKeys.add(FK);
      }

    public boolean isAutoGenForeignKey(String Name)
      {
        for (ForeignKey FK : _ForeignKeys)
         {
          if (FK == null)
           continue;
          for (Column C : FK._SrcColumnObjs)
           if (C != null && C.getName().equals(Name) == true)
            {
              if (FK._DestObjectObj._PrimaryKey._Autogen == true)
                return true;
            }
         }
        return false;
      }
  }
