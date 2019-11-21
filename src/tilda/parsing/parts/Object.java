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
import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ObjectMode;
import tilda.enums.OutputFormatType;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.types.ColumnDefinition;

public class Object extends Base
  {

    static final Logger                   LOG           = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("occ"           ) public boolean              _OCC        = true ;
    @SerializedName("dbOnly"        ) public Boolean              _DBOnly_DEPRECATED;
    @SerializedName("tzFk"          ) public Boolean              _TZFK       = true;
    @SerializedName("mode"          ) public String               _ModeStr    ;
    @SerializedName("etl"           ) public boolean              _ETL        = false;
    @SerializedName("lc"            ) public String               _LCStr      ;
    @SerializedName("cloneAs"       ) public Cloner[]             _CloneAs    ;

    @SerializedName("columns"       ) public List<Column>         _Columns    = new ArrayList<Column        >();

    @SerializedName("primary"       ) public PrimaryKey           _PrimaryKey = null;
    @SerializedName("foreign"       ) public List<ForeignKey>     _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"       ) public List<Index>          _Indices    = new ArrayList<Index         >();
    @SerializedName("http"          ) public HttpMapping[]        _Http       = { };
    @SerializedName("history"       ) public String     []        _History    = { };
//    @SerializedName("migrations"    ) public Migration  []        _Migrations = { };
    
    /*@formatter:on*/

    public transient boolean              _HasUniqueIndex;
    public transient boolean              _HasUniqueQuery;
    public transient boolean              _HasNaturalIdentity;
    public transient FrameworkSourcedType _FST          = FrameworkSourcedType.NONE;
    public transient View                 _SourceView   = null;                                        // For tables such as Realized tables generated out of views.
    public transient Object               _SourceObject = null;                                        // For tables such as Realized tables generated out of views.
    public transient ObjectLifecycle      _LC;
    public transient ObjectMode           _Mode;

    public Object()
      {
        super(TildaType.OBJECT);
      }

    public Object(Object obj)
      {
        super(obj);
        _OCC = obj._OCC;
        _DBOnly_DEPRECATED = obj._DBOnly_DEPRECATED;
        _TZFK = obj._TZFK;
        _ModeStr = obj._ModeStr;
        _ETL = obj._ETL;
        _LCStr = obj._LCStr;
        for (Column C : obj._Columns)
          if (C != null)
            _Columns.add(new Column(C));
        if (obj._PrimaryKey != null)
          _PrimaryKey = new PrimaryKey(obj._PrimaryKey);
        if (obj._ForeignKeys.isEmpty() == false)
          for (ForeignKey FK : obj._ForeignKeys)
            if (FK != null)
              _ForeignKeys.add(new ForeignKey(FK));
        if (obj._Indices.isEmpty() == false)
          for (Index I : obj._Indices)
            if (I != null)
              _Indices.add(new Index(I));

        _Http = obj._Http;
        _History = obj._History;
      }

    @Override
    public String toString()
      {
        return getFullName() + " (" + super.toString() + ")";
      }

    @Override
    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C.getName() != null && C.getName().equals(name) == true)
            {
              return C;
            }
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

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (_Validated == true)
          return true;

        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_CloneAs != null)
          for (Cloner C : _CloneAs)
            {
              if (C.Validate(PS, this) == false)
                return false;
              Object obj = new Object(this);
              obj._Name = _Name + "_" + C._Name;
              obj._Description = C._Description;
              obj._FST = FrameworkSourcedType.CLONED;
              obj._SourceObject = this;
              ParentSchema._Objects.add(obj);
            }

        if (getFullName().equals("tilda.data.TILDA.Key") == true)
          {
            Column created = getColumn("created");
            Column lastUpdated = getColumn("lastUpdated");
            Column deleted = getColumn("deleted");
            Column createdETL = getColumn("createdETL");
            Column lastUpdatedETL = getColumn("lastUpdatedETL");

            if (created == null || lastUpdated == null || deleted == null || createdETL == null || lastUpdatedETL == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base OCC (created, lastUpdated, deleted, createdETL, lastUpdatedETL) columns.");

            _OCC = true;
            created._FCT = FrameworkColumnType.OCC_CREATED;
            lastUpdated._FCT = FrameworkColumnType.OCC_LASTUPDATED;
            deleted._FCT = FrameworkColumnType.OCC_DELETED;
            createdETL._FCT = FrameworkColumnType.OCC_CREATED;
            lastUpdatedETL._FCT = FrameworkColumnType.OCC_LASTUPDATED;

            if (getColumn("refnum") == null)
              return PS.AddError("Object '" + getFullName() + "' is a built-in Tilda framework object but doesn't seem to have defined the base refnum columns.");
          }
        else if (_FST != FrameworkSourcedType.VIEW && _FST != FrameworkSourcedType.REALIZED)
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
                    if (C.needsTZ() == true && _FST != FrameworkSourcedType.REALIZED)
                      {
                        Column TZCol = new Column(C.getName() + "TZ", null, 0, C._Nullable, ColumnMode.AUTO, C._Invariant, null, "Generated helper column to hold the time zone ID for '" + C.getName() + "'.", null, null);
                        if (C.isCollection() == false)
                          TZCol._SameAs = "tilda.data.TILDA.ZONEINFO.id";
                        else
                          TZCol._TypeStr = "STRING[]"; // Only Arrays/Lists allowed for DateTimes.
                        TZCol._FCT = FrameworkColumnType.TZ;
                        _Columns.add(i, TZCol);
                        ++i;
                        _PadderColumnNames.track(TZCol.getName());
                        TZCol.Validate(PS, this);
                        if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                          PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in Object '" + getFullName() + "'.");
                        if (C.isCollection() == false && _TZFK == true)
                          {
                            addForeignKey(C.getName(), new String[] { TZCol.getName()
                            }, "tilda.data.TILDA.ZONEINFO");
                          }
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
                    PS.AddError("Object '" + getFullName() + "' has declared " + (i + 1) + " columns. Max allowed is " + ColumnDefinition._MAX_COL_COUNT + "!");
                  }
              }
          }

        Set<String> Names = new HashSet<String>();
        /*
         * for (int i = 0; i < _Migrations.length; ++i)
         * {
         * Migration M = _Migrations[i];
         * if (M != null)
         * if (M.Validate(PS, this, i) == true)
         * {
         * for (String col : M._ColumnNames)
         * if (Names.add(col) == false)
         * PS.AddError("Object '" + getFullName() + "' has declared migration #" + i + " with a column '" + col + "' which has already been specified in another migration!");
         * }
         * }
         */


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

        _HasUniqueQuery = false;
        for (SubWhereClause SWC : _Queries)
          {
            if (SWC == null)
              continue;
            if (SWC.Validate(PS, this, "Object '" + getFullName() + "'", true) == true)
              if (Names.add(SWC._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a query '" + SWC._Name + "' that has a name clashing with another query or index.");
            if (SWC._Unique == true)
              _HasUniqueQuery = true;
          }

        // LDH-NOTE: We have to validate mappings here, because the whole parent object
        // only finishes being validated at this time.
        super.ValidateOutputMappings(PS);

        // if dbOnly has been set, we have to check for deprecation condition
        if (_DBOnly_DEPRECATED != null)
          {
            if (_ModeStr != null)
              return PS.AddError("Object '" + getFullName() + "' defined both 'dbOnly' and 'mode'. dbOnly is deprecated. Stop using it and use mode=NORMAL|DB_ONLY|CODE_ONLY instead.");
            else
              _Mode = _DBOnly_DEPRECATED == true ? ObjectMode.DB_ONLY : ObjectMode.NORMAL;
          }
        else if (_ModeStr == null)
          _Mode = ObjectMode.NORMAL;
        else if ((_Mode = ObjectMode.parse(_ModeStr)) == null)
          return PS.AddError("Object '" + getFullName() + "' defined an invalid 'mode' '" + _ModeStr + "'.");

        // If an object is CODE_ONLY, then it can only be READ_ONLY, i.e., selects. Since CODE_ONLY objects are meant
        // to be used with complex queries matching a known set of columns, there is nothing to insert, update or delete.
        if (_Mode == ObjectMode.CODE_ONLY)
          {
            if (_LCStr != null && _LCStr.equals(ObjectLifecycle.READONLY.toString()) == false)
              return PS.AddError("Object '" + getFullName() + "' defined mode=CODE_ONLY and lc=" + _LCStr + ". If an object is defined as CODE_ONLY, it can only be READ_ONLY as well.");
            _LC = ObjectLifecycle.READONLY;
          }
        else if (_LCStr == null)
          _LC = ObjectLifecycle.NORMAL;
        else if ((_LC = ObjectLifecycle.parse(_LCStr)) == null)
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
        
        _HasNaturalIdentity = _HasUniqueIndex == true || _PrimaryKey != null && _PrimaryKey._Autogen == false;

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

    public boolean isPrimaryKey(String Name)
      {
        if (_PrimaryKey != null)
          for (String n : _PrimaryKey._Columns)
            if (n.equals(Name) == true)
              return true;
        return false;
      }

    public boolean isUniqueIndexColumn(String Name)
      {
        if (_Indices != null)
          for (Index I : _Indices)
            {
              if (I == null || I._Unique == false || I._Db == false)
                continue;
              for (String n : I._Columns)
                if (n.equals(Name) == true)
                  return true;
            }
        return false;
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

        Column C = new Column("refnum", null, 0, false, null, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "refnum")._Description, null, null);
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

        Column C = new Column("created", null, 0, false, ColumnMode.AUTO, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "created")._Description + " (" + getShortName() + ")", null, null);
        C._SameAs = "tilda.data.TILDA.Key.created";
        C._FCT = FrameworkColumnType.OCC_CREATED;
        _Columns.add(C);

        C = new Column("lastUpdated", null, 0, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdated")._Description + " (" + getShortName() + ")", null, null);
        C._SameAs = "tilda.data.TILDA.Key.lastUpdated";
        C._FCT = FrameworkColumnType.OCC_LASTUPDATED;
        _Columns.add(C);

        C = new Column("deleted", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "deleted")._Description + " (" + getShortName() + ")", null, null);
        C._SameAs = "tilda.data.TILDA.Key.deleted";
        C._FCT = FrameworkColumnType.OCC_DELETED;
        _Columns.add(C);

        if (addETLLastUpdated == true)
          {
            C = new Column("createdETL", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "createdETL")._Description + " (" + getShortName() + ")", null, null);
            C._SameAs = "tilda.data.TILDA.Key.createdETL";
            C._FCT = FrameworkColumnType.OCC_CREATED;
            _Columns.add(C);

            C = new Column("lastUpdatedETL", null, 0, true, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdatedETL")._Description + " (" + getShortName() + ")", null, null);
            C._SameAs = "tilda.data.TILDA.Key.lastUpdatedETL";
            C._FCT = FrameworkColumnType.OCC_LASTUPDATED;
            _Columns.add(C);
          }

        return true;
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

    /**
     * Checks if there any JSON output maps
     * @return
     */
    public boolean isJsonable()
      {
        for (OutputMapping OM : _OutputMaps)
          if (OM != null && OM._OutputTypes.contains(OutputFormatType.JSON) == true)
            return true;
        return false;
      }

    /**
     * Checks if there any JSON or CSV output maps. If more methods of serializations are added in the future,
     * this method will add extra checks.
     * @return
     */
    public boolean isSerializable()
      {
        for (OutputMapping OM : _OutputMaps)
          if (OM != null && (OM._OutputTypes.contains(OutputFormatType.JSON) == true || OM._OutputTypes.contains(OutputFormatType.CSV) == true))
            return true;
        return false;
      }

    
    public void addQuery(SubWhereClause SWC)
      {
        if (SWC != null)
          _Queries.add(new SubWhereClause(SWC));
      }

    public void addQueries(List<SubWhereClause> Queries)
      {
        if (Queries != null)
          for (SubWhereClause SWC : Queries)
            if (SWC != null)
              addQuery(SWC);
      }

    /**
     * Returns the list of columns that represent the first identity of the object. If a PK is defined,
     * the columns defined for it will be returned. Otherwise, the columns for the first defined unique index
     * will be returned. Null is returned otherwise, that that should never happen because all Objects are required
     * to have at least one identity.<BR>
     * <BR>
     * This method should only be called <B>AFTER</B> {@link Object#Validate(ParserSession, Schema)} has been called first.
     * 
     * @return
     */
    public List<Column> getFirstIdentityColumns()
      {
        if (_PrimaryKey != null)
          return _PrimaryKey._ColumnObjs;
        if (_Indices != null)
          for (Index I : _Indices)
            if (I._Unique == true)
              return I._ColumnObjs;
        return null;
      }

  }
