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
import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ObjectMode;
import tilda.enums.OutputFormatType;
import tilda.enums.TZMode;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ClonerHelper;
import tilda.types.ColumnDefinition;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class Object extends Base
  {

    static final Logger                   LOG           = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("occ"           ) public boolean              _OCC        = true;
    @SerializedName("tzFk"          ) public Boolean              _TZFK       = true;
    @SerializedName("tzMode"        ) public String               _TzModeStr;
    @SerializedName("etl"           ) public boolean              _ETL        = false;
    @SerializedName("lc"            ) public String               _LCStr      ;
    @SerializedName("cloneFrom"     ) public ClonerFrom           _CloneFrom  ;
    @SerializedName("cloneAs"       ) public Cloner[]             _CloneAs    ;
    @SerializedName("columns"       ) public List<Column>         _Columns    = new ArrayList<Column    >();

    @SerializedName("primary"       ) public PrimaryKey           _PrimaryKey = null;
    @SerializedName("foreign"       ) public List<ForeignKey>     _ForeignKeys= new ArrayList<ForeignKey>();
    @SerializedName("indices"       ) public List<Index>          _Indices    = new ArrayList<Index     >();
    @SerializedName("http"          ) public HttpMapping[]        _Http       = { };
    @SerializedName("history"       ) public History              _History;
    /*@formatter:on*/

    public transient boolean              _HasUniqueIndex;
    public transient boolean              _HasNonUniqueIndex;
    public transient boolean              _HasNaturalIdentity;
    public transient FrameworkSourcedType _FST          = FrameworkSourcedType.NONE;
    public transient View                 _SourceView   = null;                                        // For tables such as Realized tables generated out of views.
    public transient Object               _SourceObject = null;                                        // For tables such as Realized tables generated out of views.
    public transient ObjectLifecycle      _LC;
    public transient TZMode               _TzMode;
    public transient Object               _HistoryObj   = null;                                        // For tables with history settings
    public transient List<Object>         _Clones       = new ArrayList<Object>();

    public Object()
      {
        super(TildaType.OBJECT);
      }

    public Object(Object obj)
      {
        super(obj);
        _OCC = obj._OCC;
        _TZFK = obj._TZFK;
        _TzModeStr = obj._TzModeStr;
        _ETL = obj._ETL;
        _LCStr = obj._LCStr;
        for (Column C : obj._Columns)
          if (C != null && C._FCT != FrameworkColumnType.TZ)
            _Columns.add(new Column(C));
        if (obj._PrimaryKey != null)
          _PrimaryKey = new PrimaryKey(obj._PrimaryKey);
        if (obj._ForeignKeys.isEmpty() == false)
          for (ForeignKey FK : obj._ForeignKeys)
            if (FK != null && FK.isTZ() == false)
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

    public boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated == true)
          return true;

        int Errs = PS.getErrorCount();

        if (_CloneFrom != null)
          {
            // Handle cloneFrom logic to find columns from source obj and copy them to this object's columns.
            _ParentSchema = parentSchema;
            _OriginalName = _Name;
            if (_CloneFrom.validate(PS, this) == true)
              {
                ClonerHelper.handleClonefrom(PS, this);
                _CloneFrom._SrcObjectObj._Clones.add(this);
              }
            _ParentSchema = null;
            _OriginalName = null;
          }

        if (super.validate(PS, parentSchema) == false)
          return false;

        if (_CloneAs != null)
          if (ClonerHelper.handleCloneAs(PS, this) == false)
            return false;

        // We get a lot of reusable bits from this central TILDA table, so let's check it's all good.
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

        // Pick up TZMode from Schema conventions if present and local value is empty, unless it's an Object proxy for a view.
        if (_FST != FrameworkSourcedType.VIEW)
          {
            if (TextUtil.isNullOrEmpty(_TzModeStr) == true && parentSchema._Conventions != null && parentSchema._Conventions._DefaultTzModeStr != null)
              _TzModeStr = parentSchema._Conventions._DefaultTzModeStr;
            if ((_TzMode = TZMode.parse(_TzModeStr)) == null)
              return PS.AddError("Object '" + getFullName() + "' defined an invalid 'tzMode' '" + _TzModeStr + "'.");
          }

        if (_Columns == null || _Columns.isEmpty() == true)
          PS.AddError("Object '" + getFullName() + "' doesn't define any columns!");
        else
          {
            // Let's process the columns and check for unicity.
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
                if (C.validate(PS, this) == true)
                  if (ColumnNames.add(C.getName().toUpperCase()) == false)
                    PS.AddError("Column '" + C.getFullName() + "' is defined more than once in Object '" + getFullName() + "'. Note that column names are checked in a case-insensitive way, so 'id' is the same as 'ID' even though they are treated in a case-sensitive way in the database if the database allows.");
              }
            // Let's take care of TZ columns
            for (int i = 0; i < _Columns.size(); ++i)
              {
                Column C = _Columns.get(i);
                if (C.needsTZ() == true && _FST != FrameworkSourcedType.REALIZED)
                  {
                    String ColZName = C.getTZName();
                    Column TZCol = null;
                    if (C._TzMode.isColumn() == true || getColumn(ColZName) == null)
                      {
                        TZCol = new Column(ColZName, null, 0, C._Nullable, C._AllowEmpty, ColumnMode.AUTO, C._Invariant, null, "Generated helper column to hold the time zone ID for " + getTzColumnNames(C) + ".", null, null, null, C._TzMode);
                        TZCol._TzCol = true;
                      }
                    if (TZCol != null)
                      {
                        if (C.isCollection() == false || C._TzMode.isRow() == true) // Row-level means one for all timestamps, including if they are arrays.
                          TZCol._SameAs = "tilda.data.TILDA.ZONEINFO.id";
                        else
                          TZCol._TypeStr = "STRING[]"; // Only Arrays/Lists allowed for DateTimes.
                        TZCol._FCT = FrameworkColumnType.TZ;
                        _Columns.add(i, TZCol);
                        ++i;
                        _PadderColumnNames.track(TZCol.getName());
                        TZCol.validate(PS, this);
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
            // Let's check after all columns are processes and framework-managed columns (e.g. TZ) are created
            // that we don't have more than ColumnDefinition._MAX_COL_COUNT columns, and set the sequence order.
            int Counter = -1;
            for (int i = 0; i < _Columns.size(); ++i)
              {
                Column C = _Columns.get(i);
                if (C._Mode == ColumnMode.CALCULATED)
                  continue;
                C.setSequenceOrder(++Counter);
                if (Counter >= ColumnDefinition._MAX_COL_COUNT)
                  PS.AddError("Object '" + getFullName() + "' has declared " + (i + 1) + " columns. Max allowed is " + ColumnDefinition._MAX_COL_COUNT + "!");
              }
          }

        Set<String> Names = new HashSet<String>();

        _HasUniqueIndex = false;
        _HasNonUniqueIndex = false;
        Set<String> Signatures = new HashSet<String>();
        Names.clear();
        Index clusterIndex = null;
        for (Index I : _Indices)
          {
            if (I == null)
              continue;
            if (I.validate(PS, this) == true)
              if (Names.add(I._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate index named '" + I._Name + "'.");
            if (I._Db == true && Signatures.add(I.getSignature()) == false)
              PS.AddError("Object '" + getFullName() + "' is defining a duplicate index on signature '" + I.getSignature() + "'.");
            if (I._Unique == true)
              _HasUniqueIndex = true;
            else
              _HasNonUniqueIndex = true;
            if (I._Cluster == true)
              {
                if (clusterIndex != null)
                  PS.AddError("Object '" + getFullName() + "' is defining index '" + I.getSignature() + "' as a cluster while '" + clusterIndex.getSignature() + "' was already defined so. Only one index can be nominated as a cluster index.");
                else
                  clusterIndex = I;
              }
          }

        // Pick up LC from Schema conventions if present and local value is empty.
        if (TextUtil.isNullOrEmpty(_LCStr) == true && parentSchema._Conventions != null && parentSchema._Conventions._DefaultLC != null)
          _LCStr = parentSchema._Conventions._DefaultLC.name();

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
          _PrimaryKey.validate(PS, this);

        Set<String> FKNames = new HashSet<String>();
        for (ForeignKey FK : _ForeignKeys)
          {
            if (FK == null)
              continue;
            if (FK.validate(PS, this) == true)
              if (FKNames.add(FK._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a duplicate foreignKey named '" + FK._Name + "'.");
          }

        if (_PrimaryKey == null && _HasUniqueIndex == false && _FST != FrameworkSourcedType.VIEW)
          PS.AddError("Object '" + getFullName() + "' doesn't have any identity. You must define at least a primary key or a unique index.");

        _HasNaturalIdentity = _HasUniqueIndex == true || _PrimaryKey != null && _PrimaryKey._Autogen == false;

        // LDH-NOTE: We have to validate queries, mappings, masks and history here, because the whole parent object
        // only finishes being validated at this time.
        super.validateQueries(PS, Names);
        super.validateOutputMaps(PS);
        super.validateMasks(PS);

        if (_History != null && _History.validate(PS, this) == true)
          {
            setupHistory(PS, parentSchema);
          }

        return _Validated = Errs == PS.getErrorCount();
      }


    private String getTzColumnNames(Column col)
      {
        if (col._TzMode.isColumn())
          return "'" + col._Name + "'";

        StringBuilder str = new StringBuilder("1 or more columns at the " + col._ParentObject.getShortName() + " row level: ");
        boolean first = true;
        for (Column c : _Columns)
          if (c.needsTZ() == true && c._TzMode.isRow() == true)
            {
              if (first == true)
                first = false;
              else
                str.append(", ");
              str.append(c._Name);
            }
        return str.toString();
      }

    /**
     * To call after parent object has been validated
     * 
     * @param PS
     * @param ParentSchema
     */
    protected void setupHistory(ParserSession PS, Schema ParentSchema)
      {
        Object obj = new Object(this);
        obj._History = null;
        obj._Name = _Name + _History._Postfix;
        obj._Description = "History table for " + getShortName() + ".<BR>" + _Description;
        obj._FST = FrameworkSourcedType.HISTORY;
        obj._LC = ObjectLifecycle.WORM;
        // obj._OCC = false;
        obj._SourceObject = this;
        obj._ParentSchema = ParentSchema;

        _HistoryObj = obj;

        // We need to clean up columns that were not included in the history definition.
        obj._Columns = Column.cleanupColumnList(obj._Columns, _History._IncludedColumns);
        // obj._Columns = Column.cleanupFrameworkColumns(obj._Columns);

        // We also need to clean up mappings if they reference a column that is not being carried over
        for (OutputMap OM : obj._OutputMaps)
          if (OM != null)
            {
              List<String> X = CollectionUtil.toList(_History._IncludedColumns);
              X.add(ParentSchema.getConventionCreatedName());
              X.add(ParentSchema.getConventionLastUpdatedName());
              X.add(ParentSchema.getConventionDeletedName());
              OM._Columns = Column.cleanupColumnList(OM._Columns, X.toArray(new String[X.size()]));
            }

        // We also need to clean up Indices
        /// TO DO !!!!!

        if (obj._PrimaryKey != null)
          {
            // Replace the primary key with a regular index
            Index I = new Index();
            I._Name = "PKHistory";
            if (obj._PrimaryKey._Columns != null && _PrimaryKey._Columns.length > 0)
              I._Columns = _PrimaryKey._Columns;
            else
              {
                obj.CreateAutogenPK(PS);
                I._Columns = new String[] { _ParentSchema.getConventionPrimaryKeyName()
                };
              }
            I._OrderBy = new String[] { ParentSchema.getConventionLastUpdatedName() + " desc"
            };
            I._Db = true;
            obj._Indices.add(I);
            obj._PrimaryKey = null;
          }
        // Changing unique indices, if any, to non-unique indices by adding the lastUpdated column as an orderBy;
        if (obj._Indices != null)
          for (Index I : obj._Indices)
            if (I != null && (I._OrderBy == null || I._OrderBy.length == 0))
              {
                I._OrderBy = new String[] { ParentSchema.getConventionLastUpdatedName() + " desc"
                };
              }

        // because we are stripping the object of its identities, we have to create a new fake one and make sure it doesn't
        // get pushed to the DB given that it'll overlap with the non-unique index created above from the original identity.
        Index I = new Index();
        I._Name = "FakeIdentity";
        I._Columns = new String[] { ParentSchema.getConventionLastUpdatedName(), ParentSchema.getConventionCreatedName()
        };
        I._Db = false;
        obj._Indices.add(I);

        ParentSchema._Objects.add(obj);
      }

    public Object getHistoryObject()
      {
        return _HistoryObj;
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
            if (N != null && N.equalsIgnoreCase(_ParentSchema.getConventionPrimaryKeyName()) == true)
              return PS.AddError("Object '" + getFullName() + "' has defined an autogen primary key but is also defining column '" + _ParentSchema.getConventionPrimaryKeyName() + "', which is a reserved name.");
          }

        Column C = new Column(_ParentSchema.getConventionPrimaryKeyName(), null, 0, false, false, null, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "refnum")._Description, null, null, null, null);
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
            if (N != null && (N.equalsIgnoreCase(_ParentSchema.getConventionCreatedName()) == true
            || N.equalsIgnoreCase(_ParentSchema.getConventionLastUpdatedName()) == true
            || N.equalsIgnoreCase(_ParentSchema.getConventionCreatedName() + "ETL") == true
            || N.equalsIgnoreCase(_ParentSchema.getConventionLastUpdatedName() + "ETL") == true
            || N.equalsIgnoreCase(_ParentSchema.getConventionDeletedName()) == true))
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

        // LDH-NOTE: At this point in time, the referenced columns are not fully validated, so do not
        // try to clone the "sameAs" column or any of the attributes, such as _FCT. Things have to be
        // spelled out directly here in order to support the Tilda master schema and entities.
        Column C = new Column(_ParentSchema.getConventionCreatedName(), null, 0, false, false, ColumnMode.AUTO, true, null, PS.getColumn("tilda.data", "TILDA", "Key", "created")._Description + " (" + getShortName() + ")", null, null, null, null);
        C._SameAs = "tilda.data.TILDA.Key.created";
        C._FCT = FrameworkColumnType.OCC_CREATED;
        _Columns.add(C);

        C = new Column(_ParentSchema.getConventionLastUpdatedName(), null, 0, false, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdated")._Description + " (" + getShortName() + ")", null, null, null, null);
        C._SameAs = "tilda.data.TILDA.Key.lastUpdated";
        C._FCT = FrameworkColumnType.OCC_LASTUPDATED;
        _Columns.add(C);

        C = new Column(_ParentSchema.getConventionDeletedName(), null, 0, true, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "deleted")._Description + " (" + getShortName() + ")", null, null, null, null);
        C._SameAs = "tilda.data.TILDA.Key.deleted";
        C._FCT = FrameworkColumnType.OCC_DELETED;
        _Columns.add(C);

        if (addETLLastUpdated == true)
          {
            C = new Column(_ParentSchema.getConventionCreatedName() + "ETL", null, 0, true, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "createdETL")._Description + " (" + getShortName() + ")", null, null, null, null);
            C._SameAs = "tilda.data.TILDA.Key.createdETL";
            C._FCT = FrameworkColumnType.OCC_CREATED;
            _Columns.add(C);

            C = new Column(_ParentSchema.getConventionLastUpdatedName() + "ETL", null, 0, true, false, ColumnMode.AUTO, false, null, PS.getColumn("tilda.data", "TILDA", "Key", "lastUpdatedETL")._Description + " (" + getShortName() + ")", null, null, null, null);
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
     * 
     * @return
     */
    public boolean isJsonable()
      {
        for (OutputMap OM : _OutputMaps)
          if (OM != null && OM._OutputTypes.contains(OutputFormatType.JSON) == true)
            return true;
        return false;
      }

    /**
     * Checks if there any CSV output maps
     * 
     * @return
     */
    public boolean isCSVable()
      {
        for (OutputMap OM : _OutputMaps)
          if (OM != null && OM._OutputTypes.contains(OutputFormatType.CSV) == true)
            return true;
        return false;
      }

    /**
     * Checks if there any JSON or CSV output maps. If more methods of serializations are added in the future,
     * this method will add extra checks.
     * 
     * @return
     */
    public boolean isSerializable()
      {
        for (OutputMap OM : _OutputMaps)
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
     * will be returned. Null is returned otherwise, but that should never happen because all Objects are required
     * to have at least one identity.<BR>
     * If naturalIdentitiesFirst is true though, natural identities will be privileged first and the autogen PK will
     * be returned only if there are no natural identities.<BR>
     * A natural identity is defined as a unique index, of a non-autogen primary key.
     * <BR>
     * This method should only be called <B>AFTER</B> {@link Object#validate(ParserSession, Schema)} has been called first.
     * 
     * @return
     */
    public List<Column> getFirstIdentityColumns(boolean naturalIdentitiesFirst)
      {
        if (_PrimaryKey != null && (naturalIdentitiesFirst == false || _PrimaryKey._Autogen == false))
          return _PrimaryKey._ColumnObjs;

        if (_Indices != null)
          for (Index I : _Indices)
            if (I != null && I._Unique == true)
              return I._ColumnObjs;

        if (_PrimaryKey != null)
          return _PrimaryKey._ColumnObjs;

        return null;
      }

    @Override
    public String[] getFirstIdentityColumnNames(boolean naturalIdentitiesFirst)
      {
        return Column.getColumnNames(getFirstIdentityColumns(naturalIdentitiesFirst));
      }

    public Index getIndex(String name)
      {
        if (_Indices == null || _Indices.isEmpty() == false)
          for (Index idx : _Indices)
            if (idx != null && idx._Name.equalsIgnoreCase(name) == true)
              return idx;
        return null;
      }

    public boolean hasAutos()
      {
        for (Column C : _Columns)
          if (C != null && C._Mode == ColumnMode.AUTO)
            return true;
        return false;
      }

    public boolean hasCollectionColumn()
      {
        for (Column C : _Columns)
          if (C != null && C.isCollection() == true)
            return true;
        return false;
      }

    public boolean hasCollectionQuery()
      {
        if (_Queries != null)
          for (SubWhereClause swc : _Queries)
            if (swc._Attributes != null)
              for (Query.Attribute attr : swc._Attributes)
                if (attr._Multi == true)
                  return true;
        return false;
      }
  }
