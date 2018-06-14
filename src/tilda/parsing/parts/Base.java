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
    /*@formatter:on*/

    public transient Schema               _ParentSchema;
    public transient PaddingTracker       _PadderColumnNames = new PaddingTracker();
    public transient String               _OriginalName;
    public transient String               _BaseClassName;
    public transient String               _AppDataClassName;
    public transient String               _AppFactoryClassName;
    public transient String               _AppJsonClassName;
    public transient boolean              _Validated = false;

    public abstract Column getColumn(String name);
    public abstract String[] getColumnNames();
    public abstract ObjectLifecycle getLifecycle();
    public abstract boolean isOCC();
    public abstract String getWhat();

    /**
     * 
     * @return the FULL name of the schema (including the package name) + '.' + the name of the object.
     */
    public String getFullName()
      {
        return _ParentSchema.getFullName() + "." + _OriginalName;
      }

    /**
     * 
     * @return simply the name of the schema + '.' + the name of the object.
     */
    public String getShortName()
      {
        return _ParentSchema.getShortName() + "." + _OriginalName;
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
        LOG.debug("  Validating "+getWhat()+" " + getFullName() + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an "+getWhat()+" without a name.");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring "+getWhat()+" '" + getFullName() + "' with a name '"+_Name+"' which is not valid. "+ValidationHelper._ValidIdentifierMessage);
        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring "+getWhat()+" '" + getFullName() + "' without a description name.");

        _OriginalName = _Name;
//        _Name = _Name.toUpperCase();

        _BaseClassName = "TILDA__" + _Name.toUpperCase();
        _AppDataClassName    = _OriginalName+"_Data";
        _AppFactoryClassName = _OriginalName+"_Factory";
        _AppJsonClassName = _OriginalName+"_Json";
        
        // LDH-NOTE: We do not validate the mappings at this time, because the whole parent object
        //          has not finished being validated. As such, columns and other generetated
        //          artifacts won't exist yet at this point.
        
        if (_JsonDEPRECATED.isEmpty() == false)
          for (OutputMapping J : _JsonDEPRECATED)
            _OutputMaps.add(J);        
        
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
                PS.AddError(getWhat()+" '" + getFullName() + "' is defining a duplicate Output mapping '" + OM._Name + "'.");
              OM.Validate(PS, this);
            }
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
 }
