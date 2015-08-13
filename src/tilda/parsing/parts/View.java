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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.PaddingTracker;

import com.google.gson.annotations.SerializedName;

public class View
  {
    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String               _Name       = null;
    @SerializedName("description") public String               _Description= null;

    @SerializedName("columns"    ) public List<ViewColumn>     _ViewColumns= new ArrayList<ViewColumn    >();
    
    @SerializedName("queries"    ) public List<SubWhereClause> _Queries    = new ArrayList<SubWhereClause>();
    @SerializedName("json"       ) public List<JsonMapping>    _Json       = new ArrayList<JsonMapping   >();
    /*@formatter:on*/

    public transient Schema               _ParentSchema;
    public transient PaddingTracker       _PadderColumnNames = new PaddingTracker();
    public transient String               _BaseClassName;
    public transient String               _AppDataClassName;
    public transient String               _AppFactoryClassName;
    

    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
            return C._SameAsObj;
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

    public boolean isAutoGenPrimaryKey(Column column)
      {
        return false;
      }

    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
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

    
    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        int Errs = PS.getErrorCount();

        
        return Errs == PS.getErrorCount();
      }
  }
