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

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DefaultType;
import tilda.enums.MultiType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ProtectionType;
import tilda.enums.ValidationStatus;
import tilda.enums.VisibilityType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Column extends TypeDef
  {
    static final Logger             LOG                = LogManager.getLogger(Column.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) protected String      _Name       ;
	@SerializedName("sameas"     ) public String         _SameAs     ;
    @SerializedName("nullable"   ) public Boolean        _Nullable   ;
    @SerializedName("mode"       ) public String         _ModeStr    ;
    @SerializedName("invariant"  ) public Boolean        _Invariant  ;
    @SerializedName("protect"    ) public String         _ProtectStr ;
    @SerializedName("description") public String         _Description;
    @SerializedName("mapper"     ) public ColumnMapper   _Mapper     ;
    @SerializedName("enum"       ) public ColumnEnum     _Enum       ;
    @SerializedName("values"     ) public ColumnValue[]  _Values     ;
    /*@formatter:on*/
    
    public transient boolean        _FrameworkManaged = false;
    public transient ColumnMode     _Mode;
    public transient ProtectionType _Protect;
    public transient Column         _SameAsObj;
    public transient Object         _ParentObject;
    public transient PaddingTracker _PadderValueNames  = new PaddingTracker();
    public transient PaddingTracker _PadderValueValues = new PaddingTracker();
    public transient boolean        _PrimaryKey        = false;
    public transient boolean        _UniqueIndex       = false;
    public transient ColumnMapper   _MapperDef         ;
    public transient ColumnValue    _DefaultCreateValue;
    public transient ColumnValue    _DefaultUpdateValue;

    private transient ValidationStatus _Validation = ValidationStatus.NONE;

    public Column()
     {
      
      }
    public Column(String Name, String TypeStr, Integer Size, boolean Nullable, ColumnMode Mode, boolean Invariant, ProtectionType Protect, String Description)
      {
        super(TypeStr, Size);
        _Name = Name;
        _Nullable = Nullable;
        _ModeStr = Mode == null ? null : Mode.name();
        _Invariant = Invariant;
        _ProtectStr = Protect == null ? null : Protect.name();
        _Description = Description;
      }
    
    public Column(String Name, String SameAs, String Description)
      {
        _Name = Name;
        _SameAs = SameAs;
        _Description = Description;
        
//        if (Mapper != null)
//         _Mapper = new ColumnMapper(Mapper._SrcColumns, Mapper._DestObject, Mapper._Name, Mapper._Group, Mapper._Multi);
//        
//        if (Enum != null)
//          _Enum = new ColumnEnum(Enum._SrcColumns, Enum._DestObject, Enum._Multi);
//
//        _Values = ColumnValue.deepCopy(Values);
      }

    public String getFullName()
      {
        return _ParentObject.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentObject.getShortName() + "." + _Name;
      }
    
    public String getName()
      {
        return _Name;
      }
    
    public boolean Validate(ParserSession PS, Object ParentObject)
      {
        _ParentObject = ParentObject;
        if (_Validation != ValidationStatus.NONE)
          return _Validation == ValidationStatus.SUCCESS;
        int Errs = PS.getErrorCount();
        ValidateBase(PS, ParentObject);
        _Validation = Errs == PS.getErrorCount() ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;
        return _Validation == ValidationStatus.SUCCESS;
      }

    private void ValidateBase(ParserSession PS, Object ParentObject)
      {
        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            PS.AddError("Column '" + getFullName() + "' didn't define a 'name'. It is mandatory.");
            return;
          }
        
        if (ValidationHelper.isValidIdentifier(_Name) == false)
         {
           PS.AddError("Column '" + getFullName() + "' has a name '"+_Name+"' which is not valid. "+ValidationHelper._ValidIdentifierMessage);
           return;
         }

        if (ValidateSameAs(PS) == false)
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

        if (super.Validate(PS, "Column '" + getFullName() + "'", true, _SameAsObj!=null || _Mode==ColumnMode.CALCULATED) == false)
         return;

        if (TextUtil.isNullOrEmpty(_Description) == true)
          PS.AddError("Column '" + getFullName() + "' didn't define a 'description'. It is mandatory.");

        if (_Protect != null && _Type != ColumnType.STRING)
         PS.AddError("Column '" + getFullName() + "' is defined as a '" + _Type + "' with a '_Protect'. Only String columns should have a '_Protect' defined.");

        ValidateValues(PS);

        if (_Mapper != null && _Enum != null)
         PS.AddError("Column '" + getFullName() + "' is defining both a mapper and an enum, which is not allowed: only one can be defined at a time.");
        else if (_Mapper != null)
         _Mapper.Validate(PS, this);
        else if (_Enum != null)
         _Enum.Validate(PS, this);
      }


    private boolean ValidateSameAs(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return true;

        int Errs = PS.getErrorCount();

        ReferenceHelper R = ReferenceHelper.parseColumnReference(_SameAs, _ParentObject);

        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true || TextUtil.isNullOrEmpty(R._C) == true)
          PS.AddError("Column '" + getFullName() + "' is declaring sameas '" + _SameAs + "' with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object\\.)?column'.");
        else
          {
            _SameAsObj = PS.getColumn(R._P, R._S, R._O, R._C);
            if (_SameAsObj == null)
              PS.AddError("Column '" + getFullName() + "' is declaring sameas '" + _SameAs + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            else if (_SameAsObj == this)
              PS.AddError("Column '" + getFullName() + "' is declaring a 'sameas' to itself! That makes no sense.");
            else
              copyFromSameAs(PS);
          }

        return Errs == PS.getErrorCount();
      }

    private void copyFromSameAs(ParserSession PS)
      {
        if (_SameAsObj == null)
          return;

        if (_TypeStr != null && _TypeStr.equals(_SameAsObj._TypeStr) == false)
          PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining a type '"+_TypeStr+"' which doesn't match the destination column's type '"+_SameAsObj._TypeStr+"'. Note that redefining a type for a sameas column is superfluous in the first place.");
        else
          _TypeStr = _SameAsObj._TypeStr;

/* Should we do this or not? For mappers with extra PKs, this adds additional requirements on the new table with 
 * column names and all... Not very flexible. 
        if (_SameAsObj._Mapper != null)
          {
            if (_Mapper != null)
             PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining a mapper, which is not allowed.");
            else
             _Mapper = new ColumnMapper(_SameAsObj._Mapper);
          }
        else if (_SameAsObj._Enum != null)
          {
            if (_Enum != null)
             PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining an enum, which is not allowed.");
            else
             _Enum = new ColumnEnum(_SameAsObj._Enum);
          }
*/

        if (_Size != null && _Size != 0 && _Size != _SameAsObj._Size)
          PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining a size '"+_Size+"' which doesn't match the destination column's size '"+_SameAsObj._Size+"'. Note that redefining a size for a sameas column is superfluous in the first place.");
        else if (_Mapper != null && _Mapper._Multi != MultiType.NONE)
          {
            _TypeStr+= _Mapper._Multi == MultiType.LIST ? "[``]"
                     : _Mapper._Multi == MultiType.SET  ? "{``}"
                     : null;
          }
        else if (_Enum != null && _Enum._Multi != MultiType.NONE)
          {
            _TypeStr+= _Enum._Multi == MultiType.LIST ? "[``]"
                     : _Enum._Multi == MultiType.SET  ? "{``}"
                     : null;
          }
        else if (_MapperDef != null && _MapperDef._Multi != MultiType.NONE)
          {
            _TypeStr+= _MapperDef._Multi == MultiType.LIST ? "[``]"
                     : _MapperDef._Multi == MultiType.SET  ? "{``}"
                     : null;
          }
        else
          {
            _Size = _SameAsObj._Size;
          }

        if (_SameAsObj._Values != null)
         {
           if (_Values != null)
             PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining 'values', which is not allowed.");
            else
             _Values = ColumnValue.deepCopy(_SameAsObj._Values);
          }

        if (_ProtectStr != null)
          PS.AddError("Column '" + getFullName() + "' is a 'sameas' and is redefining 'protect', which is not allowed.");
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

        // LDH-NOTE: We are not copying "description" over. SameAs allows to reuse type definitions in various contexts,
        // so the description is unlikely to be reusable.
//        if (_Description== null)
//          _Description= _SameAsObj._Description;
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

    private boolean ValidateValues(ParserSession PS)
      {
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

            V.Validate(PS, this);

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
        return _FrameworkManaged == false 
            && _Mode == ColumnMode.NORMAL 
            && _ParentObject.isAutoGenPrimaryKey(this) == false 
            && _DefaultCreateValue == null
            && (   _Invariant == false && _Nullable == false
                || _Invariant == true
               );

      }

    public VisibilityType getVisibility()
      {
        return _ParentObject.getLifecycle() == ObjectLifecycle.READONLY || _MapperDef != null || _FrameworkManaged == true ? VisibilityType.PRIVATE
            : _Invariant == true || _PrimaryKey == true || _Mode == ColumnMode.AUTO ? VisibilityType.PROTECTED 
            : VisibilityType.PUBLIC;
      }

    public boolean isCopyToColumn()
      {
        return _PrimaryKey == false && _Mode != ColumnMode.CALCULATED && _Invariant == false;
      }

    public boolean isSavedField()
      {
        return _PrimaryKey == true || _UniqueIndex == true;
      }
    public boolean isOCCGenerated()
      {
        return _ParentObject.isOCC() == true && _Type == ColumnType.DATETIME && (_Name.equals("created") == true || _Name.equals("lastUpdated") == true || _Name.equals("deleted") == true);
      }
    
    public boolean isJSONColumn()
      {
        return (_PrimaryKey == false || _ParentObject.isAutoGenPrimaryKey(this) == false) 
            && _Mode == ColumnMode.NORMAL && _FrameworkManaged == false && _Name.equals("deleted") == false
            ;
      }
    public boolean hasBeenValidatedSuccessfully()
      {
        return _Validation == ValidationStatus.SUCCESS;
      }
    public Object getSingleColFK()
      {
        for (ForeignKey FK : _ParentObject._ForeignKeys)
         if (FK!=null)
          {
            if (FK._SrcColumnObjs.size() == 1 && FK._SrcColumnObjs.get(0)._Name.equals(_Name))
             return FK._DestObjectObj;
          }
        return null;
      }
  }
