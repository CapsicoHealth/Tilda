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
import tilda.enums.ObjectMode;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.DefaultsHelper;
import tilda.parsing.parts.helpers.DescriptionRewritingHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public abstract class Base
  {

    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("name"        ) public String               _Name       = null;
    @SerializedName("dbOnly"      ) private Boolean              _DBOnly_DEPRECATED;
    @SerializedName("mode"        ) public String               _ModeStr    ;
    @SerializedName("shortAlias"  ) public String               _ShortAlias_DEPRECATED = null;
    @SerializedName("prefix"      ) public String               _Prefix = null;
    @SerializedName("description" ) public String               _Description= null;    
    @SerializedName("descriptionX") public String[]             _DescriptionX= null;
    @SerializedName("referenceUrl") public String               _ReferenceUrl;
    @SerializedName("referenceTag") public String               _ReferenceTag;
    @SerializedName("entityClass" ) public String               _EntityClass;
    @SerializedName("queries"     ) public List<SubWhereClause> _Queries    = new ArrayList<SubWhereClause>();
    @SerializedName("json"        ) public List<OutputMap>      _JsonDEPRECATED = new ArrayList<OutputMap >();
    @SerializedName("outputMaps"  ) public List<OutputMap>      _OutputMaps = new ArrayList<OutputMap>();
    @SerializedName("masks"       ) public List<Mask>           _Masks = new ArrayList<Mask>();
    @SerializedName("tenantInit"  ) public Boolean              _TenantInit = Boolean.FALSE;
    /*@formatter:on*/

    public transient Schema          _ParentSchema;
    public transient PaddingTracker  _PadderColumnNames = new PaddingTracker();
    public transient String          _OriginalDescription;
    public transient String          _OriginalName;
    public transient String          _BaseClassName;
    public transient String          _AppDataClassName;
    public transient String          _AppFactoryClassName;
    public transient boolean         _Validated         = false;
    public transient final TildaType _TildaType;
    public transient Object          _RealizedObj;
    public transient View            _RealizedView;
    public transient boolean         _HasUniqueQuery;
    public transient ObjectMode      _Mode;

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
        _Prefix = b._Prefix;
        _EntityClass = b._EntityClass;
        _Description = b._Description;
        _DBOnly_DEPRECATED = b._DBOnly_DEPRECATED;
        _ModeStr = b._ModeStr;

        // SubWhereClauses are being modified as part of validation, and so we need a clean copy here.
        _Queries = new ArrayList<SubWhereClause>();
        for (SubWhereClause SWC : b._Queries)
          if (SWC != null)
            _Queries.add(new SubWhereClause(SWC));

        // OutputMaps are being modified as part of validation, and so we need a clean copy here.
        // for (OutputMap OM : b._JsonDEPRECATED)
        // _JsonDEPRECATED.add(new OutputMap(OM));
        // for (OutputMap OM : b._OutputMaps)
        // _OutputMaps.add(new OutputMap(OM));
        _JsonDEPRECATED = OutputMap.newInstances(b._JsonDEPRECATED);
        _OutputMaps = OutputMap.newInstances(b._OutputMaps);
        _Masks = Mask.newInstances(b._Masks);

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

    public String getBaseClassName()
      {
        return _BaseClassName;
      }

    public String getColumnPad(String Name)
      {
        return _PadderColumnNames.getPad(Name);
      }

    protected boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated == true)
          return true;

        int Errs = PS.getErrorCount();

        _ParentSchema = parentSchema;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an " + _TildaType.name() + " without a name.");

        _OriginalName = _Name;
//        LOG.debug("  Validating " + _TildaType.name() + " " + getFullName() + ".");

        if (_Name.length() > PS._CGSql.getMaxTableNameSize())
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + _Name.length() + " for this identifier.");
        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name containing invalid characters (must all be alphanumeric or underscore).");

        if (ValidationHelper.isValidIdentifier(_Name) == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name '" + _Name + "' which is not valid. " + ValidationHelper._ValidIdentifierMessage);
        if (ValidationHelper.isReservedIdentifier(_Name) == true)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with a name '" + _Name + "' which is a reserved identifier.");

        if (TextUtil.isNullOrEmpty(_Description) == true && TextUtil.isNullOrEmpty(_DescriptionX) == true)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' without a description or descriptionX.");

        if (TextUtil.isNullOrEmpty(_Description) == false && TextUtil.isNullOrEmpty(_DescriptionX) == false)
          PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring " + _TildaType.name() + " '" + getBaseName() + "' with both a description and descriptionX: only one must be specified.");

        if (TextUtil.isNullOrEmpty(_DescriptionX) == false)
          _Description = String.join(" ", _DescriptionX);
        
        if (TextUtil.isNullOrEmpty(_EntityClass) == true)
          {
            if (_ParentSchema._EntityClasses!=null && _ParentSchema._EntityClasses.length > 0)
             PS.AddError("Object '" + _Name + "' is not declaring an entity class when the schema defined one or more. Once a schema defined one or more entity class, all entities must define one as well.");
          }
        else
          {
            if (_ParentSchema._EntityClasses==null || _ParentSchema._EntityClasses.length == 0)
             PS.AddError("Object '" + _Name + "' is declaring an entity class when the schema did not define any. An entity cannot define a class if the schema did not define them.");
            else if (TextUtil.contains(_ParentSchema._EntityClasses, _EntityClass, true, 0) == false)
              PS.AddError("Object '" + _Name + "' is declaring an entity class '"+_EntityClass+"' which cannot be found in the list defined by the schema. Note that checke are done in a cese-insensitive way.");
          }
        
        
        _OriginalDescription = _Description;
        _Description = DescriptionRewritingHelper.processReferenceUrl(_OriginalDescription, this);
        
        // _Name = _Name.toUpperCase();

        // if dbOnly has been set, we have to check for deprecation condition
        if (_DBOnly_DEPRECATED != null)
          {
            if (_ModeStr != null)
              PS.AddError("Object/View '" + getFullName() + "' defined both 'dbOnly' and 'mode'. dbOnly is deprecated. Stop using it and use mode=NORMAL|DB_ONLY|CODE_ONLY instead.");
            else
              _ModeStr = _DBOnly_DEPRECATED == true ? ObjectMode.DB_ONLY.name() : ObjectMode.NORMAL.name();
          }
        // Pick up Mode from Schema conventions if present and local value is empty. 
        if (TextUtil.isNullOrEmpty(_ModeStr) == true && parentSchema._Conventions != null && parentSchema._Conventions._DefaultMode != null)
          _ModeStr = parentSchema._Conventions._DefaultMode.name();
        if (TextUtil.isNullOrEmpty(_ModeStr) == true)
          _Mode = ObjectMode.NORMAL;
        else if ((_Mode = ObjectMode.parse(_ModeStr)) == null)
          PS.AddError("Object/View '" + getFullName() + "' defined an invalid 'mode' '" + _ModeStr + "'.");

        if (TextUtil.isNullOrEmpty(_ShortAlias_DEPRECATED) == false && TextUtil.isNullOrEmpty(_Prefix) == false)
         PS.AddError("Object/View '" + getFullName() + "' is defining both 'shortAlias' and 'prefix'. 'shortAlias' has been deprecated in favor of 'prefix' so both cannot be supplied. Fix and use 'prefix' only.");
        else if (TextUtil.isNullOrEmpty(_ShortAlias_DEPRECATED) == false)
          _Prefix = _ShortAlias_DEPRECATED;

        _BaseClassName = "TILDA__" + _Name.toUpperCase();
        _AppDataClassName = _OriginalName + "_Data";
        _AppFactoryClassName = _OriginalName + "_Factory";

        // LDH-NOTE: We do not validate the mappings at this time, because the whole parent object
        // has not finished being validated. As such, columns and other generated
        // artifacts won't exist yet at this point. All we do is transfer the entries in the
        // deprecated tag 'json' to the new tag 'outputMaps'.
        if (_JsonDEPRECATED.isEmpty() == false)
          {
            for (OutputMap J : _JsonDEPRECATED)
              _OutputMaps.add(J);
            _JsonDEPRECATED.clear();
          }

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    protected void validateQueries(ParserSession PS, Set<String> Names)
      {
        DefaultsHelper.defaultAllQuery(PS, this);

        _HasUniqueQuery = false;
        for (SubWhereClause SWC : _Queries)
          {
            if (SWC == null)
              continue;
            if (SWC.validate(PS, this, "Object '" + getFullName() + "'", true) == true)
              if (Names.add(SWC._Name.toUpperCase()) == false)
                PS.AddError("Object '" + getFullName() + "' is defining a query '" + SWC._Name + "' that has a name clashing with another query or index.");
            if (SWC._Unique == true)
              _HasUniqueQuery = true;
          }
      }

    protected void validateOutputMaps(ParserSession PS)
      {
        DefaultsHelper.defaultOutputMap(PS, this);

        Set<String> Names = new HashSet<String>();
        for (OutputMap OM : _OutputMaps)
          if (OM != null)
            {
              if (Names.add(OM._Name) == false)
                PS.AddError(_TildaType.name() + " '" + getFullName() + "' is defining a duplicate Output mapping named '" + OM._Name + "'.");
              OM.validate(PS, this);
            }
      }

    protected void validateMasks(ParserSession PS)
      {
        Set<String> colNames = new HashSet<String>();
        for (Mask M : _Masks)
          if (M != null)
            {
              M.validate(PS, this);
              for (Column C : M._ColumnObjs)
                if (C != null && colNames.add(C._Name) == false)
                  PS.AddError(_TildaType.name() + " '" + getFullName() + "' is defining a mask with a duplicate column '" + C._Name + "'.");
            }
      }


    /**
     * "colA", "abc*"
     * 
     * @param vals
     * @return
     */
    protected List<String> expandColumnNames(String[] vals, ParserSession PS, String constructType, String constructName)
      {
        return expandColumnNames(vals, PS, constructType, constructName, null);
      }

    /**
     * "colA", "abc*"
     * 
     * @param vals
     * @return
     */
    protected List<String> expandColumnNames(String[] vals, ParserSession PS, String constructType, String constructName, String[] exclude)
      {
        String[] colNames = getColumnNames();
        Set<String> S = new HashSet<String>(); // gotta be a set in case multiple column templates resolve to the same column name(s).
        List<String> L = new ArrayList<String>();
        for (String val : vals)
          {
            String[] valsA = new String[] { val
            };
            boolean found = false;
            for (String colName : colNames)
              {
                if (TextUtil.findStarElement(valsA, colName, true, 0) == -1)
                  continue;
                if (exclude != null && exclude.length > 0 && TextUtil.findStarElement(exclude, colName, true, 0) != -1)
                  continue;
                if (S.add(colName) == true)
                  L.add(colName);
                found = true;
              }
            if (found == false)
              PS.AddError("Object/View " + this.getFullName() + " is defining a column template '" + val + "' for " + constructType + " '" + constructName + "' which doesn't map to any columns.");
          }
        return L;
      }

    public SubWhereClause getQuery(String name)
      {
        if (_Queries == null || _Queries.isEmpty() == false)
          for (SubWhereClause swc : _Queries)
            if (swc._Name.equalsIgnoreCase(name) == true)
              return swc;
        return null;
      }

    public OutputMap getOutputMap(String name)
      {
        if (_OutputMaps == null || _OutputMaps.isEmpty() == false)
          for (OutputMap om : _OutputMaps)
            if (om._Name.equalsIgnoreCase(name) == true)
              return om;
        return null;
      }
    
    public boolean hasMasking()
     {
       for (String colName : getColumnNames())
         {
           Column c = getColumn(colName);
           if (c != null && c.isMasked() == true)
            return true;
         }
       return false;
     }

    /**
     * Returns the list of columns that represent the first identity of the object. If a PK is defined,
     * the columns defined for it will be returned. Otherwise, the columns for the first defined unique index
     * will be returned. Null is returned otherwise, that that should never happen because all Objects are required
     * to have at least one identity.<BR>
     * <BR>
     * This method should only be called <B>AFTER</B> {@link Object#validate(ParserSession, Schema)} has been called first.
     * 
     * @return
     */
    public abstract String[] getFirstIdentityColumnNames(boolean naturalIdentitiesFirst);
  }
