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
import tilda.enums.OutputFormatType;
import tilda.parsing.ParserSession;
import tilda.types.ColumnDefinition;

public class Object extends Base
  {

    static final Logger                   LOG          = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("occ"           ) public boolean              _OCC        = true ;
    @SerializedName("dbOnly"        ) public boolean              _DBOnly     = false;
    @SerializedName("etl"           ) public boolean              _ETL        = false;
    @SerializedName("lc"            ) public String               _LCStr      = ObjectLifecycle.NORMAL.toString();

    @SerializedName("columns"       ) public List<Column>         _Columns    = new ArrayList<Column        >();

    @SerializedName("primary"       ) public PrimaryKey           _PrimaryKey = null;
    @SerializedName("foreign"       ) public List<ForeignKey>     _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"       ) public List<Index>          _Indices    = new ArrayList<Index         >();
    @SerializedName("http"          ) public HttpMapping[]        _Http       = { };
    @SerializedName("history"       ) public String     []        _History    = { };
    @SerializedName("migrations"    ) public Migration  []        _Migrations = { };
//    @SerializedName("dropOldColumns") public String     []        _DropOldColumns = { };
    
    /*@formatter:on*/

    public transient boolean              _HasUniqueIndex;
    public transient boolean              _HasUniqueQuery;
    public transient FrameworkSourcedType _FST         = FrameworkSourcedType.NONE;
    public transient ObjectLifecycle      _LC;

    @Override
    public String toString()
      {
        return super.toString() + ": " + getFullName();
      }

    @Override
    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C.getName() != null && C.getName().equals(name) == true)
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

        if (getFullName().equals("tilda.data.TILDA.Key") == true)
          {
            if (getColumn("created") == null || getColumn("lastUpdated") == null || getColumn("deleted") == null || getColumn("lastUpdatedETL") == null || getColumn("createdETL") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base OCC (created, lastUpdated, deleted) columns.");
            if (getColumn("refnum") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base refnum columns.");
            _OCC = true;
          }
        else if (_FST != FrameworkSourcedType.VIEW)
          {
            if (_OCC == true)
              {
                if (CreateOCCColumns(PS, _ETL) == false)
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

                _PadderColumnNames.track(C.getLogicalName());
                if (C.Validate(PS, this) == true)
                  {
                    if (ColumnNames.add(C.getName().toUpperCase()) == false)
                      PS.AddError("Column '" + C.getFullName() + "' is defined more than once in Object '" + getFullName() + "'. Note that column names are checked in a case-insensitive way, so 'id' is the same as 'ID'.");
                    if (C._Type == ColumnType.DATETIME && Object.isOCCColumn(C) == false && C._FrameworkManaged == false)
                      {
                        Column TZCol = new Column(C.getName() + "TZ", null, 0, C._Nullable, ColumnMode.AUTO, C._Invariant, null, "Generated helper column to hold the time zone ID for '" + C.getName() + "'.");
                        TZCol._SameAs = "tilda.data.TILDA.ZONEINFO.id";
                        TZCol._FrameworkManaged = true;
                        _Columns.add(i, TZCol);
                        ++i;
                        _PadderColumnNames.track(TZCol.getName());
                        if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                          PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in Object '" + getFullName() + "'.");
                        TZCol.Validate(PS, this);
                        addForeignKey(C.getName(), new String[] { TZCol.getName()
                        }, "tilda.data.TILDA.ZONEINFO");
                      }
                  }
              }
            int Counter = -1;
            for (int i = 0; i < _Columns.size(); ++i)
              {
                Column C = _Columns.get(i);
                if (C._Mode == ColumnMode.CALCULATED)
                  continue;
                C.setSequenceOrder(++Counter);
                if (Counter >= ColumnDefinition._MAX_COL_COUNT)
                  {
                    PS.AddError("Object '" + getFullName() + "' has declared " + (i + 1) + " columns. Max allowed is "+ColumnDefinition._MAX_COL_COUNT+"!");
                  }
              }
          }

        Set<String> Names = new HashSet<String>();
        for (int i = 0; i < _Migrations.length; ++i)
          {
            Migration M = _Migrations[i];
            if (M != null)
              if (M.Validate(PS, this, i) == true)
                {
                  for (String col : M._ColumnNames)
                    if (Names.add(col) == false)
                      PS.AddError("Object '" + getFullName() + "' has declared migration #" + i + " with a column '" + col + "' which has already been specified in another migration!");
                }
          }


        _HasUniqueIndex = false;
        Set<String> Signatures = new HashSet<String>();
        Names.clear();
        for (Index I : _Indices)
          {
            if (I == null)
              continue;
            if (I.Validate(PS, this) == true)
              if (Names.add(I._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate index '" + I._Name + "'.");
            if (I._Db == true && Signatures.add(I.getSignature()) == false)
              PS.AddError("Object '" + getFullName() + "' is defining a duplicate index on signature '" + I.getSignature() + "'.");
            if (I._Unique == true)
              _HasUniqueIndex = true;
          }

        Names.clear();
        _HasUniqueQuery = false;
        for (SubWhereClause SWC : _Queries)
          {
            if (SWC == null)
              continue;
            if (SWC.Validate(PS, this, "Object '" + getFullName() + "'", true) == true)
              if (Names.add(SWC._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate query '" + SWC._Name + "'.");
            if (SWC._Unique == true)
              _HasUniqueQuery = true;
          }

        // LDH-NOTE: We have to validate mappings here, because the whole parent object
        //          only finishes being validated at this time.
        super.ValidateOutputMappings(PS);

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
          {
            if (C == null)
              continue;

            String N = C.getLogicalName();
            if (N != null && N.equalsIgnoreCase("refnum") == true)
              return PS.AddError("Object '" + getFullName() + "' has defined an autogen primary key but is also defining column 'refnum', which is a reserved name.");
          }

        Column C = new Column("refnum", null, 0, false, null, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "refnum")._Description);
        C._SameAs = "tilda.data.TILDA.Key.refnum";
        _Columns.add(0, C);

        return true;
      }

    private boolean CreateOCCColumns(ParserSession PS, boolean addETLLastUpdated)
      {
        for (Column C : _Columns)
          {
            if (C == null)
              continue;

            String N = C.getLogicalName();
            if (N != null && (N.equalsIgnoreCase("created") == true || N.equalsIgnoreCase("lastUpdated") == true || N.equalsIgnoreCase("createdETL") == true || N.equalsIgnoreCase("lastUpdatedETL") == true || N.equalsIgnoreCase("deleted") == true))
              return PS.AddError("Object '" + getFullName() + "' has defined OCC to be true but is also defining column '" + C.getName() + "', which is a reserved name.");
          }

        Object KeyObj = PS.getObject("tilda.data", "TILDA", "Key");
        if (KeyObj == null)
          {
            LOG.error("WHHHUUUT???? TILDA.Key cannot be found");
            throw new Error("There is a class-path issue here... This process cannot see the base Tilda object definitions.");
          }
        else if (KeyObj.getColumn("created") == null)
          {
            LOG.error("WHHHUUUT???? TILDA.Key.created cannot be found");
            throw new Error("There is a class-path issue here... This process cannot see the base Tilda object definitions.");
          }

        Column C = new Column("created", null, 0, false, ColumnMode.AUTO, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "created")._Description);
        C._SameAs = "tilda.data.TILDA.Key.created";
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column("lastUpdated", null, 0, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdated")._Description);
        C._SameAs = "tilda.data.TILDA.Key.lastUpdated";
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column("deleted", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "deleted")._Description);
        C._SameAs = "tilda.data.TILDA.Key.deleted";
        C._FrameworkManaged = true;
        _Columns.add(C);

        if (addETLLastUpdated == true)
          {
            C = new Column("createdETL", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "createdETL")._Description);
            C._SameAs = "tilda.data.TILDA.Key.createdETL";
            C._FrameworkManaged = true;
            _Columns.add(C);

            C = new Column("lastUpdatedETL", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdatedETL")._Description);
            C._SameAs = "tilda.data.TILDA.Key.lastUpdatedETL";
            C._FrameworkManaged = true;
            _Columns.add(C);
          }

        return true;
      }

    public static boolean isOCCColumn(Column C)
      {
        return C.isOCCGenerated();
      }

    public static boolean isOCCLastUpdated(Column C)
      {
        return C.isOCCLastUpdated();
      }

    public static boolean isOCCDeleted(Column C)
      {
        return C.isOCCDeleted();
      }

    public void AddColumnAfter(Column SiblingCol, Column NewCol)
      {
        int i = _Columns.indexOf(SiblingCol);
        if (i != -1)
          _Columns.add(i + 1, NewCol);
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

    public List<ForeignKey> getForeignKeys(String targetSchema, String TargetObject)
      {
        List<ForeignKey> FKs = new ArrayList<ForeignKey>();
        for (ForeignKey FK : _ForeignKeys)
          if (FK._ParentObject.getShortName().equalsIgnoreCase(targetSchema + "." + TargetObject) == true)
            FKs.add(FK);
        return FKs;
      }
    
    public List<ForeignKey> getForeignKeys(Column Col)
      {
        List<ForeignKey> FKs = new ArrayList<ForeignKey>();
        for (ForeignKey FK : _ForeignKeys)
          if (FK != null)
            for (Column C : FK._SrcColumnObjs)
             if (C == Col)
              FKs.add(FK);
        return FKs;
      }

    public boolean isJsonable()
      {
        for (OutputMapping OM : _OutputMaps)
          if (OM._OutputTypes.contains(OutputFormatType.JSON) == true)
           return true;
        return false;
      }
    
  }
