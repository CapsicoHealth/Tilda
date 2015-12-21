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

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.JoinType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ViewColumn
  {
    static final Logger             LOG                = LogManager.getLogger(ViewColumn.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) public String         _Name         ;
	@SerializedName("sameas"     ) public String         _SameAs       ;
    @SerializedName("joinType"   ) public String         _JoinStr      ;
    @SerializedName("joinOnly"   ) public boolean        _JoinOnly      = false;
    @SerializedName("aggregate"  ) public String         _AggregateStr ;
    @SerializedName("useMapper"  ) public boolean        _UseMapper     = false;
    @SerializedName("useEnum"    ) public boolean        _UseEnum       = false;
    /*@formatter:on*/
    
    
    
    
    public ViewColumn()
     {
     }
/*
    public ViewColumn(String Name, String SameAs, JoinType Join, boolean JoinOnly, AggregateType  Aggregate)
      {
        _Name = Name;
        _SameAs = SameAs;
        _Join = Join;
        _JoinOnly = JoinOnly;
        _Aggregate = Aggregate;
      }
*/

    public transient View     _ParentView;
    public transient Column   _SameAsObj;
    public transient JoinType _Join;
    public transient AggregateType _Aggregate;    
    public transient boolean  _FailedValidation = false;

    public boolean _FrameworkGenerated = false;
    

    public String getFullName()
      {
        return _ParentView.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentView.getShortName() + "." + _Name;
      }
    
    public String getName()
      {
        return _Name;
      }
    
    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return PS.AddError("View column '" + getFullName() + "' didn't define a 'sameAs'. It is mandatory.");
        
        if (ValidateSameAs(PS) == false)
          return false;
        
        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            _Name = _SameAsObj._Name;
          }
        
        if (_JoinStr != null)
          if ((_Join = JoinType.parse(_JoinStr)) == null)
            return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'joinType' '" + _JoinStr + "'.");
        
        if (_AggregateStr != null)
          {
            if ((_Aggregate = AggregateType.parse(_AggregateStr)) == null)
             return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'aggregate' '" + _AggregateStr + "'.");
            if (_SameAsObj._Type == ColumnType.DATETIME)
             return PS.AddError("View Column '" + getFullName() + "' defined an aggregate on DATETIME column '" + _SameAsObj._Name + "' which is not supported as timezone information would not be retrievable.");
          }
        
        return Errs == PS.getErrorCount();
      }


    private boolean ValidateSameAs(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return true;

        int Errs = PS.getErrorCount();

        ReferenceHelper R = ReferenceHelper.parseColumnReference(_SameAs, _ParentView);

        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true || TextUtil.isNullOrEmpty(R._C) == true)
          PS.AddError("Column '" + getFullName() + "' is declaring sameas '" + _SameAs + "' with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object\\.)?column'.");
        else
          {
            Column Col = PS.getColumn(R._P, R._S, R._O, R._C);
            if (Col == null)
              PS.AddError("Column '" + getFullName() + "' is declaring sameas '" + _SameAs + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            else
              _SameAsObj = Col;
          }

        return Errs == PS.getErrorCount();
      }
  }
