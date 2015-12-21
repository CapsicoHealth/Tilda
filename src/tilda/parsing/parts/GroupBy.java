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

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class GroupBy
  {
    static final Logger             LOG                = LogManager.getLogger(GroupBy.class.getName());

    /*@formatter:off*/
	@SerializedName("columns" ) public String[]  _Columns;
	@SerializedName("count"   ) public boolean   _Count  = false;
    /*@formatter:on*/
    
    public GroupBy()
     {
     }

    public transient View          _ParentView;
    public transient List<Column>  _GroupByObjs   = new ArrayList<Column>();    
    
    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (_Columns == null || _Columns.length == 0)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a groupBy without any columns.");
        
        Set<String> Names = new HashSet<String>();
        for (String gb : _Columns)
          {
            if (TextUtil.isNullOrEmpty(gb) == true)
              continue;
            Column C = ParentView.getColumn(gb);
            if (C == null)
              {
                PS.AddError("View '"+ParentView._Name+"' defined a groupBy with an unknown column '"+gb+"'.");
                continue;
              }
            if (Names.add(C.getFullName()) == false)
              {
                PS.AddError("View '"+ParentView._Name+"' defined a groupBy with a duplicated column '"+gb+"'.");
                continue;
              }
            _GroupByObjs.add(C);
          }
        
        if (_Count == true)
          {
//            ViewColumn VC = new ViewColumn();
//            VC._
          }
        

        return Errs == PS.getErrorCount();
      }
  }
