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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.enums.JoinType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ViewJoin
  {
    static final Logger             LOG                = LogManager.getLogger(ViewJoin.class.getName());

    /*@formatter:off*/
	@SerializedName("object"     ) public String  _Object ;
	@SerializedName("on"         ) public Query[] _Ons    ;
    @SerializedName("joinType"   ) public String  _JoinStr;
    /*@formatter:on*/
	
    
    public ViewJoin()
     {
     }

    public transient View     _ParentView;
    public transient Object   _ObjectObj;
    public transient JoinType _Join;
    public transient boolean  _FailedValidation = false;

    
    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Object) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a join without any 'object' specified.");

        if (_Ons == null || _Ons.length == 0)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a join without any 'on' specified.");

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_Object, ParentView._ParentSchema);
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' declares a join '" + _Object + "' with an incorrect syntax. It should be '((package\\.)?schema\\.)?object'.");
        else
          {
            _ObjectObj = PS.getObject(R._P, R._S, R._O);
            if (_ObjectObj == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' declares a join '" + _Object + "' with Object '" + _Object + "' resolving to '"+R.getFullName()+"' which cannot be found.");
            if (_ObjectObj._Validated == false)
             return PS.AddError("View '" + ParentView.getFullName() + "' declares a join '" + _Object + "' with Object '" + _Object + "' which has failed validation.");
          }
        
        if (_JoinStr != null)
          if ((_Join = JoinType.parse(_JoinStr)) == null)
            return PS.AddError("Join on '" + _ObjectObj.getFullName() + "' defined an invalid 'joinType' '" + _JoinStr + "'.");
        
        return Errs == PS.getErrorCount();
      }
    
    public Query getQuery(DBType Db)
      {
        return Query.getQuery(_Ons, Db);
      }
    
  }
