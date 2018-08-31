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

package tilda.parsing.parts.formulaTemplates;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.interfaces.PatternObject;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.View;
import tilda.utils.TextUtil;

public class Binning implements PatternObject
  {
    protected static final Logger LOG = LogManager.getLogger(Binning.class.getName());

    /*@formatter:off*/
    @SerializedName("column" ) public String _Column ;
    @SerializedName("type"   ) public String _TypeStr ;
    @SerializedName("ranges" ) public List<BinningRange> _Ranges = new ArrayList<BinningRange>();
    /*@formatter:on*/

    protected transient View      _ParentView;

    private ColumnType _Type;

    public Binning()
      {
      }

    public Binning(Binning B)
      {
        _Column = B._Column;
        _TypeStr = B._TypeStr;
        _Ranges = B._Ranges;
      }

    public View getParentView()
      {
        return this._ParentView;
      }

    public String getShortName()
      {
        return this._ParentView.getShortName() + "." + this._Column;
      }
    
    public String getColumnName()
      {
        return this._Column;
      }
    
    public void Validate(ParserSession PS, View ParentView)
    {  
      _ParentView = ParentView; 
      
      if(TextUtil.isNullOrEmpty(_Column) == true)
        PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "'is defining a formula pattern without a Column. You must define a Column for the Formula to use.");
      
      if(_Ranges.size() == 0)
        PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern without any Ranges. You must define at least one Range with either a 'min' or 'minExclude' and either a 'max' or 'maxExclude' and a 'name'.");
      
      if (TextUtil.isNullOrEmpty(_TypeStr) == true)
        PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "' without a type.");
      else if ((_Type = ColumnType.parse(_TypeStr)) == null)
        PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "' with an invalid type '" + _TypeStr + "'.");
      
      for(BinningRange BR : _Ranges)
        {     
          BR.Validate(PS, _ParentView, this);
          
          Formula F = new Formula();
          
          F._Name = _Column + "_" + BR._Name;
          F._Id = _Column + "_" + BR._Name;                 
          
          
          String[] desc = new String[1];
          desc[0] = "This formula checks whether the column '" + _Column + "' value falls in the range of " + (BR._Min != null ? BR._Min : BR._MinExclusive) + " and " + (BR._Max != null ? BR._Max : BR._MaxExclusive) + ".";         
          F._Description = desc;
          
          F._TypeStr = _TypeStr;
          
          String[] formulaStr = new String[1];
          formulaStr[0] = "case when " + _Column;
          if(BR._Min != null)
            formulaStr[0] += " >= " + BR._Min + " and " + _Column;
          else if(BR._MinExclusive != null)
            formulaStr[0] += " > " + BR._MinExclusive + " and " + _Column; 
          
          if(BR._Max != null)
            formulaStr[0] += " <= " + BR._Max + " then 1 else 0 end";
          else if(BR._MinExclusive != null)
            formulaStr[0] += " < " + BR._MaxExclusive + " then 1 else 0 end"; 
                   
          F._FormulaStrs = formulaStr;
          
          F._Title = _Column + "_" + BR._Name + " Title";
          
          //Check existing formulas
          for(Formula VF : _ParentView._Formulas)
            if(VF._Name.equals(F._Name))
              PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern generated column name '" + F._Name + "' with the same name as a user defined formula column " + VF._Name +". Formula column names must be unique.");
          
         F._FormulaTemplate = true;
         
          _ParentView._Formulas.add(F);               
        }
    }
  }
