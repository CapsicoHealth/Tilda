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

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Object
  {

    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String               _Name       = null;
    @SerializedName("description") public String               _Description= null;
    @SerializedName("occ"        ) public boolean              _OCC        = true ;
    @SerializedName("lc"         ) public String               _LCStr      = ObjectLifecycle.NORMAL.toString();

    @SerializedName("columns"    ) public List<Column>         _Columns    = new ArrayList<Column        >();

    @SerializedName("primary"    ) public PrimaryKey           _PrimaryKey = null;
    @SerializedName("foreign"    ) public List<ForeignKey>     _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"    ) public List<Index>          _Indices    = new ArrayList<Index         >();
    @SerializedName("queries"    ) public List<SubWhereClause> _Queries    = new ArrayList<SubWhereClause>();

    @SerializedName("json"       ) public List<JsonMapping>    _Json       = new ArrayList<JsonMapping   >();
    @SerializedName("http"       ) public HttpMapping[]        _Http       = { };
    @SerializedName("history"    ) public String     []        _History    = { };
    /*@formatter:on*/

    public transient Schema               _ParentSchema;
    public transient PaddingTracker       _PadderColumnNames = new PaddingTracker();
    public transient String               _OriginalName;
    public transient String               _BaseClassName;
    public transient String               _AppDataClassName;
    public transient String               _AppFactoryClassName;
    public transient boolean              _HasUniqueIndex;
    public transient FrameworkSourcedType _FST         = FrameworkSourcedType.NONE;
    public transient ObjectLifecycle      _LC;
    public transient boolean              _Validated = false;

    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
            return C;
        return null;
      }

    public String getFullName()
      {
        return _ParentSchema.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentSchema.getShortName() + "." + _Name;
      }
    
    public String getBaseName()
      {
        return _Name;
      }

    public Schema getSchema()
      {
        return _ParentSchema;
      }

    public String getAppDataClassName()
      {
        return _AppDataClassName;
      }
    
    public String getAppFactoryClassName()
      {
        return _AppFactoryClassName;
      }
    

    public String getBaseClassName()
      {
        return _BaseClassName;
      }

    public String getColumnPad(String Name)
      {
        return _PadderColumnNames.getPad(Name);
      }
    
    public boolean Setup(ParserSession PS, Schema ParentSchema)
      {
        _ParentSchema = ParentSchema;
        LOG.debug("  Validating Object " + getFullName() + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an object without a name.");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a view '" + getFullName() + "' with a name '"+_Name+"' which is not valid. "+ValidationHelper._ValidIdentifierMessage);
        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an object without a description name.");

        _OriginalName = _Name;
        _Name = _Name.toUpperCase();

        _BaseClassName = "TILDA__" + _Name;
        _AppDataClassName    = _OriginalName+"_Data";
        _AppFactoryClassName = _OriginalName+"_Factory";
        
        return true;
      }
    
    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (Setup(PS, ParentSchema) == false)
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
                if (C == null)
                  continue;
                if (i >= 64)
                  PS.AddError("Object '" + getFullName() + "' has declared more than 64 columns!");
                else
                  {
                    _PadderColumnNames.track(C._Name);
                    if (C.Validate(PS, this) == true)
                      {
                        if (ColumnNames.add(C._Name.toUpperCase()) == false)
                         PS.AddError("Column '" + C.getFullName() + "' is defined more than once in Object '" + getFullName() + "'.");
                        if (C._Type == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                          {
                            Column TZCol = new Column();
                            TZCol._Name = C._Name+"TZ";
                            TZCol._SameAs = "tilda.data.TILDA.ZONEINFO.id";
                            TZCol._Invariant = C._Invariant;
                            TZCol._Description = "Generated helper column to hold the time zone ID for '"+C._Name+"'.";
                            TZCol._Mode = ColumnMode.AUTO;
                            TZCol._Nullable = C._Nullable; 
                            TZCol._FrameworkManaged = true;
                            _Columns.add(i, TZCol);
                            ++i;
                            _PadderColumnNames.track(TZCol._Name);
                            if (ColumnNames.add(TZCol._Name.toUpperCase()) == false)
                              PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in Object '" + getFullName() + "'.");
                            if (TZCol.Validate(PS, this) == false)
                              TZCol._FailedValidation = true;
                            addForeignKey(C._Name, new String[] { TZCol._Name }, "tilda.data.TILDA.ZONEINFO");
                          }
                      }
                    else
                     C._FailedValidation = true;
                  }
              }
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
        for (SubWhereClause SWC : _Queries)
          {
            if (SWC == null)
              continue;
            if (SWC.Validate(PS, this, "Object '" + getFullName()+"'", true) == true)
              if (Names.add(SWC._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate query '" + SWC._Name + "'.");
          }

        Names.clear();
        for (JsonMapping J : _Json)
          if (J != null)
            {
              if (Names.add(J._Name) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate JSON mapping '" + J._Name + "'.");
              J.Validate(PS, this);
            }

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

        if (_PrimaryKey == null && _HasUniqueIndex == false)
          PS.AddError("Object '" + getFullName() + "' doesn't have any identity. You must define at least a primary key or a unique index.");

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private boolean CreateAutogenPK(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && C._Name.equalsIgnoreCase("refnum") == true)
            return PS.AddError("Object '" + getFullName() + "' has defined an autogen primary key but is also defining column 'refnum', which is a reserved name.");

        Column C = new Column();
        C._Name = "refnum";
        C._SameAs = "tilda.data.TILDA.KEY.refnum";
        C._Invariant = true;
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "refnum")._Description;
        _Columns.add(0, C);

        return true;
      }

    private boolean CreateOCCColumns(ParserSession PS)
      {
        for (Column C : _Columns)
          if (C != null && (C._Name.equalsIgnoreCase("created") == true || C._Name.equalsIgnoreCase("lastUpdated") == true || C._Name.equalsIgnoreCase("deleted") == true))
            return PS.AddError("Object '" + getFullName() + "' has defined OCC to be true but is also defining column '" + C._Name + "', which is a reserved name.");

        Column C = new Column();
        C._Name = "created";
        C._SameAs = "tilda.data.TILDA.KEY.created";
        C._Invariant = true;
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "created")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column();
        C._Name = "lastUpdated";
        C._SameAs = "tilda.data.TILDA.KEY.lastUpdated";
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "lastUpdated")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        C = new Column();
        C._Name = "deleted";
        C._SameAs = "tilda.data.TILDA.KEY.deleted";
        C._Description = PS.getColumn("tilda.data", "TILDA", "KEY", "deleted")._Description;
        C._Mode = ColumnMode.AUTO;
        C._FrameworkManaged = true;
        _Columns.add(C);

        return true;
      }

    public static boolean isOCCColumn(Column C)
      {
        return C.isOCCGenerated();
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

    public ObjectLifecycle getLifecycle()
      {
        return _LC;
      }

    public boolean isOCC()
      {
        return _OCC;
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
         for (Column C : FK._SrcColumnObjs)
           if (C._Name.equals(Name) == true)
            {
              if (FK._DestObjectObj._PrimaryKey._Autogen == true)
               return true;
            }
        return false;
      }
  }
