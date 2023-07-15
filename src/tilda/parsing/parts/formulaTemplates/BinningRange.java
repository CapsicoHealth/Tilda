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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.View;

public class BinningRange
  {
    protected static final Logger LOG = LogManager.getLogger(BinningRange.class.getName());

    /*@formatter:off*/
    @SerializedName("min"         ) public Double _Min;
    @SerializedName("max"         ) public Double _Max;
    @SerializedName("minExclusive") public Double _MinExclusive;
    @SerializedName("maxExclusive") public Double _MaxExclusive;
    @SerializedName("name"        ) public String _Name  ;
    /*@formatter:on*/

    protected transient View      _ParentView;
    
    public BinningRange()
      {
      }

    public BinningRange(BinningRange BR)
      {
        _Min = BR._Min;
        _Max = BR._Max;
        _MinExclusive = BR._MinExclusive;
        _MaxExclusive = BR._MaxExclusive;
        _Name = BR._Name;
      }
    

    public void validate(ParserSession PS, View ParentView, Binning B)
      {        
        _ParentView = ParentView;
        
        if(_Min == null && _MinExclusive == null)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has does not have a Min or MinExclude attribute. There must be at least one minimum binning value.");

        if(_Max == null && _MaxExclusive == null)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has does not have a Max or MaxExclude attribute. There must be at least one maximum binning value.");        
        
        if(_Min != null && _MinExclusive != null)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has both Min and MinExclude attribute. There cannot be two minimum binning values.");
        
        if(_Max != null && _MaxExclusive != null)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has both Max and MaxExclude attribute. There cannot be two maximum binning values.");
        
       if(_Min != null)         
         if(_Min > (_Max != null ? _Max : _MaxExclusive))
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has a Min value '" + _Min + "'+ that is greater (or equal) than the range maximum " + (_Max != null ? _Max : _MaxExclusive) + ".");
       
       if(_MinExclusive != null)         
         if(_MinExclusive > (_Max != null ? _Max : _MaxExclusive))
           PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + B._Column + "' range '" + _Name + "' that has a MinExclude value '" + _MinExclusive + "'+ that is greater (or equal) than the range maximum " + (_Max != null ? _Max : _MaxExclusive) + ".");
       
      }
  }
