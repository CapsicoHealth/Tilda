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

import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DefaultType;
import tilda.enums.FrameworkColumnType;
import tilda.enums.MultiType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ProtectionType;
import tilda.enums.TZMode;
import tilda.enums.TildaType;
import tilda.enums.ValidationStatus;
import tilda.enums.VisibilityType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.DescriptionRewritingHelper;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public class Column extends TypeDef
  {
    static final Logger                  LOG                = LogManager.getLogger(Column.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) protected String      _Name       ;
	@SerializedName("sameas"     ) public String         _SameAs__DEPRECATED;
    @SerializedName("sameAs"     ) public String         _SameAs     ;
    @SerializedName("nullable"   ) public Boolean        _Nullable   ;
    @SerializedName("invariant"  ) public Boolean        _Invariant  ;
    @SerializedName("mode"       ) public String         _ModeStr    ;
    @SerializedName("protect"    ) public String         _ProtectStr ;
    @SerializedName("tzMode"     ) public String         _TzModeStr  ;    
    @SerializedName("default"    ) public String         _Default    ;
    @SerializedName("description") public String         _Description;
    @SerializedName("mapper"     ) public ColumnMapper   _Mapper     ;
    @SerializedName("enum"       ) public ColumnEnum     _Enum       ;
    @SerializedName("values"     ) public ColumnValue[]  _Values     ;
    @SerializedName("jsonSchema" ) public JsonSchema     _JsonSchema ;
    /*@formatter:on*/

    public transient FrameworkColumnType _FCT               = FrameworkColumnType.NONE;

    // LDH-NOTE: Because views can be materialized, we decided to create Proxy Objects. Since Aggregates
    // can affect the type of the column, we propagate it.
    public transient AggregateType       _Aggregate         = null;

    public transient ColumnMode          _Mode;
    public transient ProtectionType      _Protect;
    public transient TZMode              _TzMode;
    public transient Column              _SameAsObj;
    public transient Object              _ParentObject;
    public transient PaddingTracker      _PadderValueNames  = new PaddingTracker();
    public transient PaddingTracker      _PadderValueValues = new PaddingTracker();
    public transient boolean             _PrimaryKey        = false;
    public transient boolean             _ForeignKey        = false;
    public transient boolean             _UniqueIndex       = false;
    public transient ColumnMapper        _MapperDef;
    public transient ColumnValue         _DefaultCreateValue;
    public transient ColumnValue         _DefaultUpdateValue;
    public transient String              _MaskDef;

    protected transient int              _SequenceOrder     = -1;

    public transient String[]            _expressionStrs;
    public transient String[]            _expressionDependencyColumnNames;

    private transient ValidationStatus   _Validation        = ValidationStatus.NONE;

    public Column()
      {
      }

    public Column(Column c)
      {
        super(c);
        _Name = c._Name;
        _SameAs__DEPRECATED = c._SameAs__DEPRECATED;
        _SameAs = c._SameAs;
        _Nullable = c._Nullable;
        _ModeStr = c._ModeStr;
        _Invariant = c._Invariant;
        _ProtectStr = c._ProtectStr;
        _TzModeStr = c._TzModeStr;
        // _Mask = c._Mask;
        _Description = c._Description;
        if (c._Mapper != null)
          _Mapper = new ColumnMapper(c._Mapper);
        if (c._Enum != null)
          _Enum = new ColumnEnum(c._Enum);
        if (c._Values != null)
          {
            _Values = new ColumnValue[c._Values.length];
            for (int i = 0; i < c._Values.length; ++i)
              _Values[i] = new ColumnValue(c._Values[i]);
          }
        _Default = c._Default;
        if (c._JsonSchema != null)
          _JsonSchema = new JsonSchema(c._JsonSchema);
        _MaskDef = c._MaskDef;
      }

    public Column(String Name, String TypeStr, Integer Size, String Description, Integer Precision, Integer Scale)
      {
        super(TypeStr, Size, Precision, Scale);
        _Name = Name;
        _Description = Description;

      }

    public Column(String name, String typeStr, Integer size, boolean nullable, ColumnMode mode, boolean invariant, ProtectionType protect, String Description, Integer Precision, Integer Scale, String maskDef, TZMode tzMode)
      {
        super(typeStr, size, Precision, Scale);
        _Name = name;
        _Nullable = nullable;
        _ModeStr = mode == null ? null : mode.name();
        _Invariant = invariant;
        _ProtectStr = protect == null ? null : protect.name();
        _MaskDef = maskDef;
        _Description = Description;
        _Precision = Precision;
        _Scale = Scale;
        _TzMode = tzMode;
      }

    public Column(String Name, ColumnType Type, String Description)
      {
        _Name = Name;
        _Type = Type;
        _Description = Description;

        // if (Mapper != null)
        // _Mapper = new ColumnMapper(Mapper._SrcColumns, Mapper._DestObject, Mapper._Name, Mapper._Group, Mapper._Multi);
        //
        // if (Enum != null)
        // _Enum = new ColumnEnum(Enum._SrcColumns, Enum._DestObject, Enum._Multi);
        //
        // _Values = ColumnValue.deepCopy(Values);
      }

    public Column(String Name, String SameAs, String Description)
      {
        _Name = Name;
        _SameAs = SameAs;
        _Description = Description;

        // if (Mapper != null)
        // _Mapper = new ColumnMapper(Mapper._SrcColumns, Mapper._DestObject, Mapper._Name, Mapper._Group, Mapper._Multi);
        //
        // if (Enum != null)
        // _Enum = new ColumnEnum(Enum._SrcColumns, Enum._DestObject, Enum._Multi);
        //
        // _Values = ColumnValue.deepCopy(Values);
      }

    /**
     * Gets the full Tilda name of the column, which includes the package name
     * 
     * @return The full Tilda name of the column, i.e., Package.Schema.Table.Column
     */
    public String getFullName()
      {
        return (_ParentObject == null ? null : _ParentObject.getFullName()) + "." + _Name;
      }

    /**
     * Gets the full SQL name of the column, i.e., Schema.Table.Column
     * 
     * @return the full SQL name of the column, i.e., Schema.Table.Column
     */
    public String getShortName()
      {
        return (_ParentObject == null ? null : _ParentObject.getShortName()) + "." + _Name;
      }

    /**
     * Gets the name of the column.
     * 
     * @return The name of the column
     */
    public String getName()
      {
        return _Name;
      }

    /**
     * Changes the column's name. Must only be called before any validation has occurred.
     * 
     * @param newName
     */
    public void renameTo(String newName)
      {
        _Name = newName;
      }

    public boolean validate(ParserSession PS, Object ParentObject)
      {
        _ParentObject = ParentObject;
        if (_Validation != ValidationStatus.NONE)
          return _Validation == ValidationStatus.SUCCESS;
        int Errs = PS.getErrorCount();
        validateBase(PS, ParentObject);
        _Validation = Errs == PS.getErrorCount() ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;
        return _Validation == ValidationStatus.SUCCESS;
      }

    private void validateBase(ParserSession PS, Object ParentObject)
      {
        String N = getLogicalName();
        if (TextUtil.isNullOrEmpty(N) == true)
          {
            PS.AddError("Column '" + getFullName() + "' didn't define a 'name'. It is mandatory.");
            return;
          }

        ValidationHelper.validateColumnName(PS, "Object", N, getFullName(), _ParentObject._ParentSchema._Conventions);

        if (validateSameAs(PS) == false)
          return;

        // Checking values
        if (_ModeStr != null)
          if ((_Mode = ColumnMode.parse(_ModeStr)) == null)
            {
              PS.AddError("Column '" + getFullName() + "' defined an invalid 'mode' '" + _ModeStr + "'.");
              return;
            }

        if (_ProtectStr != null)
          if ((_Protect = ProtectionType.parse(_ProtectStr)) == null)
            {
              PS.AddError("Column '" + getFullName() + "' defined an invalid 'protect' '" + _ProtectStr + "'.");
              return;
            }

        setDefaults();

        if (super.validate(PS, "Column '" + getFullName() + "'", true, _SameAsObj != null || _Mode == ColumnMode.CALCULATED) == false)
          return;

        if (_Type != ColumnType.DATETIME)
          {
            if (TextUtil.isNullOrEmpty(_TzModeStr) == false)
              PS.AddError("Column '" + getFullName() + "' defined tzMode value '" + _TzModeStr + "' when the column is not a DATETIME.");
          }
        else
          {
            if (TextUtil.isNullOrEmpty(_TzModeStr) == true)
              _TzModeStr = ParentObject._TzModeStr;
            if ((_TzMode = TZMode.parse(_TzModeStr)) == null)
              PS.AddError("Column '" + getFullName() + "' defined an invalid 'tzMode' '" + _TzModeStr + "'.");
            if (isCollection() == true && _TzMode == TZMode.ROW)
              PS.AddError("Column '" + getFullName() + "' is a datetime collection with tzMode='" + _TzModeStr + "': datetime collections cannot have row-level tzMode.");
          }

        if (TextUtil.isNullOrEmpty(_Description) == true)
          {
            if (_SameAsObj != null)
              PS.AddError("Column '" + getFullName() + "' didn't define a 'description' and neither did its sameAs reference. It is mandatory.");
            else
              PS.AddError("Column '" + getFullName() + "' didn't define a 'description'. It is mandatory.");
          }

        _Description = DescriptionRewritingHelper.processReferenceUrl(_Description, _ParentObject);

        if (_Protect != null && _Type != ColumnType.STRING)
          PS.AddError("Column '" + getFullName() + "' is defined as a '" + _Type + "' with a '_Protect'. Only String columns should have a '_Protect' defined.");

        validateValues(PS);

        if (_Mapper != null && _Enum != null)
          PS.AddError("Column '" + getFullName() + "' is defining both a mapper and an enum, which is not allowed: only one can be defined at a time.");
        else if (_Mapper != null)
          _Mapper.validate(PS, this);
        else if (_Enum != null)
          _Enum.validate(PS, this);

        if (_JsonSchema != null && _Type != ColumnType.JSON)
          PS.AddError("Column '" + getFullName() + "' is defining a jsonSchema, but is not of type JSON.");
        if (_JsonSchema != null)
          _JsonSchema.validate(PS, this);

        // if ((_Nullable == null || _Nullable == true)
        // && _Values != null
        // && (!_Name.equals("created") && !_Name.equals("lastUpdated"))
        // && _SameAs == null)
        // {
        // PS.AddNote("Column '" + getFullName() + "' is defining a default value for a nullable column.");
        // }

        // if (TextUtil.isNullOrEmpty(_Mask) == false)
        // ValueHelper.CheckColumnValue(PS, this, _Name, _Mask, DefaultType.NONE);
      }


    private boolean validateSameAs(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_SameAs) == true && TextUtil.isNullOrEmpty(_SameAs__DEPRECATED) == true)
          return true;

        int Errs = PS.getErrorCount();

        if (TextUtil.isNullOrEmpty(_SameAs__DEPRECATED) == false)
          {
            if (TextUtil.isNullOrEmpty(_SameAs) == false)
              return PS.AddError("Column '" + getFullName() + "' is declaring both 'sameas' and 'sameAs'. Use 'sameAs' only since 'sameas' is deprecated.");
            _SameAs = _SameAs__DEPRECATED;
            _SameAs__DEPRECATED = null;
          }

        _SameAs = _SameAs.trim();
        ReferenceHelper R = ReferenceHelper.parseColumnReference(_SameAs, _ParentObject);
        _SameAsObj = R.resolveAsColumn(PS, "Column '" + getFullName() + "'", "sameAs '" + _SameAs + "'", true);
        if (_SameAsObj == this)
          PS.AddError("Column '" + getFullName() + "' is declaring a 'sameAs' to itself! That makes no sense.");
        else if (_SameAsObj != null)
          copyFromSameAs(PS, R._multi);

        return Errs == PS.getErrorCount();
      }

    protected static String withoutCollection(String typeStr)
      {
        return typeStr == null ? null : typeStr.replace("[]", "").replace("{}", "");
      }

    protected void copyFromSameAs(ParserSession PS, boolean multi)
      {
        if (_SameAsObj == null)
          return;

        if (_Name == null)
          _Name = _SameAsObj._Name;

        // String sameAs_TypeStr = SameAsHelper.getSameAsRoot_TypeStr(this);
        // Integer sameAs_Size = SameAsHelper.getSameAsRoot_Size(this);
        // Integer sameAs_Precision = SameAsHelper.getSameAsRoot_Precision(this);
        // Integer sameAs_Scale = SameAsHelper.getSameAsRoot_Scale(this);
        // ColumnValue[] sameAs_Values = SameAsHelper.getSameAsRoot_ColumnValues(this);
        // String sameAs_ProtectStr = SameAsHelper.getSameAsRoot_ProtectStr(this);
        // String sameAs_ModeStr = SameAsHelper.getSameAsRoot_ModeStr(this);
        // Boolean sameAs_Nullable = SameAsHelper.getSameAsRoot_Nullable(this);
        // String sameAs_Description = SameAsHelper.getSameAsRoot_Description(this);

        if (_TypeStr != null && withoutCollection(_TypeStr).equals(withoutCollection(_SameAsObj._TypeStr)) == false && _Aggregate == null)
          PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining a type '" + _TypeStr + "' which doesn't match the destination column's type '" + _SameAsObj._TypeStr + "'. Note that redefining a type for a sameAs column is superfluous in the first place.");
        else if (_Aggregate == null)
          _TypeStr = _SameAsObj._TypeStr + (_SameAsObj.isCollection() == false && multi == true ? "[]" : "");

        /*
         * Should we do this or not? For mappers with extra PKs, this adds additional requirements on the new table with
         * column names and all... Not very flexible.
         * if (_SameAsObj._Mapper != null)
         * {
         * if (_Mapper != null)
         * PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining a mapper, which is not allowed.");
         * else
         * _Mapper = new ColumnMapper(_SameAsObj._Mapper);
         * }
         * else if (_SameAsObj._Enum != null)
         * {
         * if (_Enum != null)
         * PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining an enum, which is not allowed.");
         * else
         * _Enum = new ColumnEnum(_SameAsObj._Enum);
         * }
         */

        if (_SameAsObj._Precision != null)
          _Precision = _SameAsObj._Precision;

        if (_SameAsObj._Scale != null)
          _Scale = _SameAsObj._Scale;

        if (_Size != null && _Size != 0 && _SameAsObj._Size != null && _Size < _SameAsObj._Size)
          PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining a size '" + _Size + "' that is lower than the origianal column's size '" + _SameAsObj._Size + "'. You can only enlarge a column (for example to go from a CHAR to a VARCHAR), not shrink it.");
        else if (_Mapper != null && _Mapper._Multi != MultiType.NONE)
          {
            _TypeStr += _Mapper._Multi == MultiType.LIST ? "[]"
            : _Mapper._Multi == MultiType.SET ? "{}"
            : null;
          }
        else if (_Enum != null && _Enum._Multi != MultiType.NONE)
          {
            _TypeStr += _Enum._Multi == MultiType.LIST ? "[]"
            : _Enum._Multi == MultiType.SET ? "{}"
            : null;
          }
        else if (_MapperDef != null && _MapperDef._Multi != MultiType.NONE)
          {
            _TypeStr += _MapperDef._Multi == MultiType.LIST ? "[]"
            : _MapperDef._Multi == MultiType.SET ? "{}"
            : null;
          }
        else if (_Aggregate == null && multi == false)
          {
            _Size = _SameAsObj._Size;
          }

        if (_SameAsObj._Values != null)
          {
            if (_Values != null)
              PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining 'values', which is not allowed.");
            else
              _Values = ColumnValue.deepCopy(_SameAsObj._Values);
          }

        if (_ProtectStr != null)
          {
            if (TextUtil.isNullOrEmpty(_SameAsObj._ProtectStr) == false
            && ProtectionType.parse(_SameAsObj._ProtectStr).ordinal() > ProtectionType.parse(_ProtectStr).ordinal())
              PS.AddError("Column '" + getFullName() + "' is a 'sameAs' and is redefining 'protect' from '" + _SameAsObj._ProtectStr + "' to '" + _ProtectStr + "', which is not allowed: only protection upgrades are allowed, not downgrades.");
          }
        else
          _ProtectStr = _SameAsObj._ProtectStr;

        if (_ModeStr == null)
          _ModeStr = _SameAsObj._ModeStr;

        if (_Nullable == null)
          _Nullable = _SameAsObj._Nullable;

        // Only reuse Invariant definition if the destination column is not a PK. By definition, PKs are invariant, so when
        // their definition are reused, mostly as part of an FK definition, most likely Invariant=true makes no sense as
        // an automatically inherited thing. The developer can always re-define "invariantness".
        if (_Invariant == null && _SameAsObj._PrimaryKey == false)
          _Invariant = _SameAsObj._Invariant;

        if (_Description == null)
          _Description = _SameAsObj._Description;
      }

    private void setDefaults()
      {
        if (_Nullable == null)
          _Nullable = Boolean.TRUE;
        if (_Mode == null)
          _Mode = ColumnMode.NORMAL;
        if (_Invariant == null)
          _Invariant = Boolean.FALSE;
        if (_Protect == null && _Type == ColumnType.STRING)
          _Protect = ProtectionType.ABSOLUTE;
      }

    private boolean validateValues(ParserSession PS)
      {
        if (_Values != null && _Values.length > 0 && _Default != null) // we want to allow "" as a default value, so only checking for null here, not isNullOrEmpty.
          return PS.AddError("Column '" + getFullName() + "' defines a 'default' and 'values' attributes. Only one or the other is alowed.");

        if (_Default != null) // we want to allow "" as a default value, so only checking for null here, not isNullOrEmpty.
          {
            _Values = new ColumnValue[] { new ColumnValue(_Name + "_CreateDefault", _Default, null, null, null, DefaultType.CREATE)
            };
            _Default = null;
          }

        if (_Values == null || _Values.length == 0)
          return true;

        int Errs = PS.getErrorCount();

        Set<String> Names = new HashSet<String>();
        Set<String> Values = new HashSet<String>();
        Set<String> Labels = new HashSet<String>();

        for (ColumnValue V : _Values)
          {
            if (V == null)
              continue;

            V.validate(PS, this);

            _PadderValueNames.track(V._Name);
            _PadderValueValues.track(V._Value);

            if (Names.add(V._Name.toUpperCase()) == false)
              PS.AddError("Column '" + getFullName() + "' defines a duplicate value with 'variable'='" + V._Name + "'.");
            if (Values.add(V._Value.toUpperCase()) == false)
              PS.AddError("Column '" + getFullName() + "' defines a duplicate value with 'value'='" + V._Value + "'.");
            if (Labels.add(V._Label.toUpperCase()) == false)
              PS.AddError("Column '" + getFullName() + "' defines a duplicate value with 'label'='" + V._Label + "'.");
            if (V._Default == DefaultType.CREATE || V._Default == DefaultType.ALWAYS)
              {
                if (_DefaultCreateValue != null)
                  PS.AddError("Column '" + getFullName() + "' defines more than one value with 'default'=" + DefaultType.CREATE + " or " + DefaultType.ALWAYS + ".");
                else
                  _DefaultCreateValue = V;
              }
            if (V._Default == DefaultType.UPDATE || V._Default == DefaultType.ALWAYS)
              {
                if (_DefaultUpdateValue != null)
                  PS.AddError("Column '" + getFullName() + "' defines more than one value with 'default'=" + DefaultType.UPDATE + " or " + DefaultType.ALWAYS + ".");
                else
                  _DefaultUpdateValue = V;
              }
          }

        return Errs == PS.getErrorCount();
      }

    public boolean isCreateColumn()
      {
        return _FCT == FrameworkColumnType.NONE
        && _Mode == ColumnMode.NORMAL
        && _ParentObject.isAutoGenPrimaryKey(this) == false
        && _DefaultCreateValue == null
        && (_Invariant == false && _Nullable == false
        || _Invariant == true);
      }

    /*
     * public boolean isOCCGenerated()
     * {
     * return _ParentObject.isOCC() == true && _Type == ColumnType.DATETIME && (_Name.equalsIgnoreCase("created") == true || _Name.equalsIgnoreCase("lastUpdated") == true ||
     * _Name.equalsIgnoreCase("createdETL") == true || _Name.equalsIgnoreCase("lastUpdatedETL") == true || _Name.equalsIgnoreCase("deleted") == true);
     * }
     * 
     * public boolean isOCCLastUpdated()
     * {
     * return _ParentObject.isOCC() == true && _Type == ColumnType.DATETIME && _Name.equalsIgnoreCase("lastUpdated") == true;
     * }
     * 
     * public boolean isOCCDeleted()
     * {
     * return _ParentObject.isOCC() == true && _Type == ColumnType.DATETIME && _Name.equalsIgnoreCase("deleted") == true;
     * }
     * 
     * public static boolean isOCCColumnName(String Name)
     * {
     * return Name.equalsIgnoreCase("created") || Name.equalsIgnoreCase("lastUpdated") || Name.equalsIgnoreCase("deleted");
     * }
     */

    public VisibilityType getVisibility()
      {
        return _ParentObject.getLifecycle() == ObjectLifecycle.READONLY || _MapperDef != null || (_FCT != FrameworkColumnType.NONE && _FCT != FrameworkColumnType.OCC_CREATED && _FCT != FrameworkColumnType.OCC_LASTUPDATED && _FCT != FrameworkColumnType.OCC_DELETED) ? VisibilityType.PRIVATE
        : _Invariant == true || _PrimaryKey == true || (_Mode == ColumnMode.AUTO && _FCT != FrameworkColumnType.OCC_LASTUPDATED && _FCT != FrameworkColumnType.OCC_DELETED) ? VisibilityType.PROTECTED
        : VisibilityType.PUBLIC;
      }

    public boolean isCopyToColumn()
      {
        // LDH-NOTE: Why would invariants be excluded? They are write-once-read-many so they should be set to a new copy of an object.
        return _PrimaryKey == false && _Mode != ColumnMode.CALCULATED; // && _Invariant == false;
      }

    public boolean isSavedField()
      {
        return _PrimaryKey == true || _UniqueIndex == true;
      }

    public boolean isJSONColumn()
      {
        return (_PrimaryKey == false || _ParentObject.isAutoGenPrimaryKey(this) == false)
        && _Mode == ColumnMode.NORMAL && _FCT == FrameworkColumnType.NONE && _Name.equals("deleted") == false;
      }

    public boolean isPrimaryKey()
      {
        return _PrimaryKey;
      }

    public boolean isForeignKey()
      {
        return _ForeignKey;
      }

    public boolean hasBeenValidatedSuccessfully()
      {
        return _Validation == ValidationStatus.SUCCESS;
      }

    public Object getSingleColFK()
      {
        for (ForeignKey FK : _ParentObject._ForeignKeys)
          if (FK != null)
            {
              if (FK._SrcColumnObjs.size() == 1 && FK._SrcColumnObjs.get(0)._Name.equals(_Name))
                return FK._DestObjectObj;
            }
        return null;
      }

    public void setSequenceOrder(int i)
      {
        _SequenceOrder = i;
      }

    public int getSequenceOrder()
      {
        return _SequenceOrder;
      }

    /**
     * returns a comma-separated string containing the <B>unescaped</B> column short names
     * 
     * @param L
     * @return
     */
    public static String printColumnList(List<Column> L, boolean simple)
      {
        StringBuilder Str = new StringBuilder();
        for (Column C : L)
          Str.append(Str.length() == 0 ? "" : ", ").append(simple == true ? C.getName() : C.getShortName());
        return Str.toString();
      }

    /**
     * returns an array of column names
     * 
     * @param L
     * @return
     */
    public static String[] getColumnNames(List<Column> L)
      {
        if (L == null)
          return null;
        String[] names = new String[L.size()];
        for (int i = 0; i < L.size(); ++i)
          names[i] = L.get(i)._Name;
        return names;
      }

    public static String[] cleanupColumnList(String[] columns, String[] masterColumns)
      {
        List<String> L = new ArrayList<String>();
        for (String colName : columns)
          if (TextUtil.contains(masterColumns, colName, true, 0) == true)
            L.add(colName);
        return L.toArray(new String[L.size()]);
      }

    public static List<Column> cleanupColumnList(List<Column> columns, String[] masterColumns)
      {
        List<Column> L = new ArrayList<Column>();
        for (Column col : columns)
          if (col != null && TextUtil.contains(masterColumns, col._Name, true, 0) == true)
            L.add(col);
        return L;
      }

    public static List<Column> cleanupFrameworkColumns(List<Column> columns)
      {
        List<Column> L = new ArrayList<Column>();
        for (Column col : columns)
          if (col != null && col._FCT != FrameworkColumnType.TZ)
            L.add(col);
        return L;
      }


    @Override
    public String toString()
      {
        return getClass().getName() + ": " + getFullName() + " (" + super.toString() + ")";

      }

    String getLogicalName()
      {
        String N = getName();
        if (N == null)
          {
            // This method could be called before validation of columns, and so sameAs may not have been validated yet
            if (_SameAs != null)
              N = _SameAs.substring(_SameAs.lastIndexOf('.') + 1);
            else if (_SameAs__DEPRECATED != null)
              N = _SameAs__DEPRECATED.substring(_SameAs__DEPRECATED.lastIndexOf('.') + 1);
          }
        return N;
      }

    /**
     * A column needs an extra timezone support column if it is of type DATETIME and was not framework-generated (e.g., created, lastUpdated...)
     * 
     * @return
     */
    public boolean needsTZ()
      {
        return getType() == ColumnType.DATETIME && (_FCT == FrameworkColumnType.NONE || _FCT == FrameworkColumnType.PIVOT);
      }

    public String getTZName()
      {
        if (needsTZ() == false)
          return null;
        return _TzMode == TZMode.COLUMN ? getName() + _ParentObject._ParentSchema.getConventionTzColPostfix() : _ParentObject._ParentSchema.getConventionTzRowName();
      }

    protected static Column deepColumnSearch(ParserSession PS, Base parent, String colName)
      {
        Column col = parent.getColumn(colName);
        if (col != null)
          return col;

        if (parent._TildaType == TildaType.VIEW) // Let's do a deeper search for the other columns from the tables/views brought in
          {
            // LDH-NOTE: This should be abstracted better as a utility method. Looking up
            // a column by name across the entire view space is important moving forward
            // with a few new tilda features.
            Set<String> objs = new HashSet<String>();
            for (ViewColumn vc : ((View) parent)._ViewColumns)
              {
                if (vc._SameAsObj != null && vc._SameAsObj._ParentObject != null && objs.add(vc._SameAsObj._ParentObject._Name) == true)
                  {
                    for (Column c : vc._SameAsObj._ParentObject._Columns)
                      if (c._Name.equals(colName) == true)
                        return c;
                  }
              }
          }
        return null;
      }

    public boolean isMasked()
      {
        return _MaskDef != null;
      }

  }
