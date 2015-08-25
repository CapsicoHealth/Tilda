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

import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class View extends Base
  {


    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns" ) public List<ViewColumn>     _ViewColumns= new ArrayList<ViewColumn>();
    @SerializedName("joins"   ) public List<ViewJoin>       _Joins      = new ArrayList<ViewJoin  >();
    @SerializedName("subWhere") public String               _SubWhere;
    @SerializedName("groupBy" ) public GroupBy              _GroupBy;
    @SerializedName("subQuery") public SubWhereClause       _SubQuery;
    /*@formatter:on*/

    @Override
    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
            return C._SameAsObj;
        return null;
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
      }

    @Override
    public boolean isOCC()
      {
        return false;
      }

    @Override
    public String getWhat()
      {
        return "View";
      }
    
    public ViewJoin getViewjoin(String ObjectName)
     {
       if (_Joins != null)
        for (ViewJoin vj : _Joins)
         if (vj != null && vj._ObjectObj.getBaseName().equals(ObjectName) == true)
          return vj;
       return null;
     }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_ViewColumns == null || _ViewColumns.isEmpty() == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a view without any columns.");

        Set<String> ColumnNames = new HashSet<String>();        
        Set<String> ObjectNames = new HashSet<String>();        
        for (int i = 0; i < _ViewColumns.size(); ++i)
         {
           ViewColumn C = _ViewColumns.get(i);
           C.Validate(PS, this);
           if (ColumnNames.add(C.getName().toUpperCase()) == false)
             PS.AddError("Column '" + C.getFullName() + "' is defined more than once in View '" + getFullName() + "'.");
           if (ObjectNames.add(C._SameAsObj._ParentObject.getFullName()) == false)
             {
               if (C._Join != null)
                 PS.AddError("Column '" + C.getFullName() + "' is defining a join type: only the first column of a refered table can define a join type.");
             }
           else if (ObjectNames.size() ==1 && C._Join != null)
             {
               PS.AddError("Column '" + C.getFullName() + "' is defining a join type: columns of the first refered table are considered part of the 'from' clause of a view and cannot define a join type.");
             }
           if (C._SameAsObj._Type == ColumnType.DATETIME && Object.isOCCColumn(C._SameAsObj) == false)
              {
                ViewColumn TZCol = new ViewColumn();
                TZCol._SameAs = C._SameAs+"TZ";
                TZCol._FrameworkGenerated = true;
                TZCol._Name = C._Name==null?null:C._Name+"TZ";
                TZCol.Validate(PS, this);
                _ViewColumns.add(i, TZCol);
                ++i;
                if (ColumnNames.add(TZCol.getName().toUpperCase()) == false)
                  PS.AddError("Generated column '" + TZCol.getFullName() + "' conflicts with another column already named the same in view '" + getFullName() + "'.");
                _PadderColumnNames.track(TZCol.getName());
              }
         }

        if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
          PS.AddError("View '" + getFullName() + "' is defining both a subWhere AND a subQuery: only one is allowed.");
        else
          {
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
             _SubQuery = new SubWhereClause(_SubWhere);

            if (_SubQuery != null)
              {
                if (_SubQuery._From != null && _SubQuery._From.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with a from clause: that is not allowed for views.");
                if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with an orderBy: that is not allowed for views.");
                
                _SubQuery.Validate(PS, this, "View " + getFullName() + "'s "+(TextUtil.isNullOrEmpty(_SubWhere)==false?"subWhere":"subQuery"), false);
                
                if (_SubQuery._ColumnObjs.isEmpty() == false)
                 PS.AddError("View '" + getFullName() + "' is defining a subQuery with parameters: that is not allowed for views.");
              }
          }
        
        if (_Joins != null)
         for (ViewJoin VJ : _Joins)
           VJ.Validate(PS, this);
        
        if (_GroupBy != null)
          _GroupBy.Validate(PS, this);
        
        Object O = new Object();
        O._FST = FrameworkSourcedType.VIEW;
        O._Name = _OriginalName;
        O._Description = _Description;
        O._Queries = _Queries;
        O._Json   = _Json;
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = false;
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._FrameworkGenerated == false && C._JoinOnly == false)
            O._Columns.add(new ViewColumnWrapper(C._SameAsObj, C));
        _ParentSchema._Objects.add(O);
        O.Validate(PS, ParentSchema);

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
  }
