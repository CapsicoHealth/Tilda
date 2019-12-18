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

import tilda.enums.ObjectLifecycle;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public abstract class Base
  {

    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String               _Name       = null;
    @SerializedName("description") public String               _Description= null;
    @SerializedName("queries"    ) public List<SubWhereClause> _Queries    = new ArrayList<SubWhereClause>();
    @SerializedName("json"       ) public List<OutputMapping>  _JsonDEPRECATED = new ArrayList<OutputMapping >();
    @SerializedName("outputMaps" ) public List<OutputMapping>  _OutputMaps = new ArrayList<OutputMapping>();
    @SerializedName("tenantInit" ) public Boolean              _TenantInit = Boolean.FALSE;
    /*@formatter:on*/

    public transient Schema          _ParentSchema;
    public transient PaddingTracker  _PadderColumnNames = new PaddingTracker();
    public transient String          _OriginalName;
    public transient String          _BaseClassName;
    public transient String          _AppDataClassName;
    public transient String          _AppFactoryClassName;
    public transient String          _AppJsonClassName;
    public transient boolean         _Validated         = false;
    public transient final TildaType _TildaType;

    public abstract Column getColumn(String name);

    public abstract String[] getColumnNames();

    public abstract ObjectLifecycle getLifecycle();

    public abstract boolean isOCC();

    public Base(TildaType Type)
      {
        _TildaType = Type;
      }

    public Base(Base b)
      {
        _Name = b._Name;
        _Description = b._Description;

        // SubWhereClauses are being modified as part of validation, and so we need a clean copy here.
        _Queries = new ArrayList<SubWhereClause>();
        for (SubWhereClause SWC : b._Queries)
          if (SWC != null)
            _Queries.add(new SubWhereClause(SWC));

        // OutputMaps are being modified as part of validation, and so we need a clean copy here.
        for (OutputMapping OM : b._JsonDEPRECATED)
          _JsonDEPRECATED.add(new OutputMapping(OM));
        for (OutputMapping OM : b._OutputMaps)
          _OutputMaps.add(new OutputMapping(OM));

        _TenantInit = b._TenantInit;
        _TildaType = b._TildaType;
      }


    /**
     * 
     * @return the FULL name of the schema (including the package name) + '.' + the name of the object.
     */
    public String getFullName()
      {
        return (_ParentSchema == null ? "" : (_ParentSchema.getFullName() + ".")) + _OriginalName;
      }

    /**
     * 
     * @return simply the name of the schema + '.' + the name of the object.
     */
    public String getShortName()
      {
        return (_ParentSchema == null ? "" : (_ParentSchema.getShortName() + ".")) + _OriginalName;
      }

    /**
     * 
     * @return simply the name of the object, i.e. _Name
     */
    public String getBaseName()
      {
        return _OriginalName;
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

    public String getAppJsonClassName()
      {
        return _AppJsonClassName;
      }

    public String getBaseClassName()
      {
        return _BaseClassName;
      }

    public String getColumnPad(String Name)
      {
        return _PadderColumnNames.getPad(Name);
      }

    protected boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (_Validated == true)
          return true;

        int Errs = PS.getErrorCount();

        _ParentSchema = ParentSchema;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an " + _TildaType.name() + " without a name.");

        _OriginalName = _Name;
        LOG.debug("  Validating " + _TildaType.name() + " " + getFullName() + ".");

        if (_Name.length() > PS._CGSql.getMaxTableNameSize())
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + _Name.length() + " for this identifier.");
        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name containing invalid characters (must all be alphanumeric or underscore).");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name '" + _Name + "' which is not valid. " + ValidationHelper._ValidIdentifierMessage);

        if (TextUtil.isNullOrEmpty(_Description) == true)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' without a description name.");

        // _Name = _Name.toUpperCase();

        _BaseClassName = "TILDA__" + _Name.toUpperCase();
        _AppDataClassName = _OriginalName + "_Data";
        _AppFactoryClassName = _OriginalName + "_Factory";
        _AppJsonClassName = _OriginalName + "_Json";

        // LDH-NOTE: We do not validate the mappings at this time, because the whole parent object
        // has not finished being validated. As such, columns and other generetated
        // artifacts won't exist yet at this point.

        if (_JsonDEPRECATED.isEmpty() == false)
          {
            for (OutputMapping J : _JsonDEPRECATED)
              _OutputMaps.add(J);
            _JsonDEPRECATED.clear();
          }

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    protected boolean ValidateOutputMappings(ParserSession PS)
      {
        int Errs = PS.getErrorCount();
        Set<String> Names = new HashSet<String>();

        for (OutputMapping OM : _OutputMaps)
          if (OM != null)
            {
              if (Names.add(OM._Name) == false)
                PS.AddError(_TildaType.name() + " '" + getFullName() + "' is defining a duplicate Output mapping '" + OM._Name + "'.");
              OM.Validate(PS, this);
            }
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    /**
     * "colA", "abc*"
     * 
     * @param vals
     * @return
     */
    protected List<String> expandColumnNames(String[] vals, ParserSession PS, String constructType, String constructName)
      {
        String[] colNames = getColumnNames();
        Set<String> S = new HashSet<String>(); // gotta be a set in case multiple column templates resolve to the swame column name(s).
        for (String val : vals)
          {
            String[] valsA = new String[] { val
            };
            boolean found = false;
            for (String colName : colNames)
              {
                if (TextUtil.findStarElement(valsA, colName, false, 0) != -1)
                  {
                    S.add(colName);
                    found = true;
                  }
              }
            if (found == false)
              PS.AddError("Object/View " + this.getFullName() + " is defining a column template '" + val + "' for " + constructType + " '" + constructName + "' which doesn't map to any columns.");
          }
        return new ArrayList<String>(S);
      }
  }
