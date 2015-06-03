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
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class View implements IThing
  {
    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String               _Name       ;
    @SerializedName("description") public String               _Description;
    @SerializedName("columns"    ) public List<Column>         _Columns = new ArrayList<Column        >();
    @SerializedName("indices"    ) public List<Index>          _Indices = new ArrayList<Index         >();
    @SerializedName("queries"    ) public List<SubWhereClause> _Queries = new ArrayList<SubWhereClause>();
    @SerializedName("json"       ) public List<JsonMapping>    _Json    = new ArrayList<JsonMapping   >();
    /*@formatter:on*/

    public transient Schema          _ParentSchema;
    public transient PaddingTracker  _PadderColumnNames = new PaddingTracker();
    public transient String          _OriginalName;
    public transient String          _BaseClassName;
    public transient String          _AppDataClassName;
    public transient String          _AppFactoryClassName;
    public transient boolean         _HasUniqueIndex;

    @Override
    public String getThingType()
      {
        return "View";
      }

    @Override
    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
            return C;
        return null;
      }

    @Override
    public String getFullName()
      {
        return _ParentSchema.getFullName() + "." + _Name;
      }

    @Override
    public String getShortName()
      {
        return _ParentSchema.getShortName() + "." + _Name;
      }
    
    @Override
    public String getBaseName()
      {
        return _Name;
      }

    @Override
    public Schema getSchema()
      {
        return _ParentSchema;
      }

    @Override
    public boolean isAutoGenPrimaryKey(Column column)
      {
        return false;
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
      }
    
    @Override
    public String getAppDataClassName()
      {
        return _AppDataClassName;
      }
    
    @Override
    public String getAppFactoryClassName()
      {
        return _AppFactoryClassName;
      }
    

    @Override
    public String getBaseClassName()
      {
        return _BaseClassName;
      }

    @Override
    public String getColumnPad(String Name)
      {
        return _PadderColumnNames.getPad(Name);
      }

    public boolean Setup(ParserSession PS, Schema ParentSchema)
      {
        _ParentSchema = ParentSchema;
        LOG.debug("  Validating "+getThingType()+" " + getFullName() + ".");

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
        int Errs = PS.getErrorCount();

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
        
        return Errs == PS.getErrorCount();
      }
    
    protected void addForeignKey(String Name, String[] ColumnNames, String DestinationObject)
      {
      }

    @Override
    public void AddColumnAfter(Column SiblingCol, Column NewCol)
      {
        int i = _Columns.indexOf(SiblingCol);
        if (i != -1)
         _Columns.add(i+1, NewCol);
      }

    @Override
    public boolean isOCC()
      {
        return false;
      }

    @Override
    public boolean isAutoGenForeignKey(String Name)
      {
        return false;
      }
  }
