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
import tilda.utils.TextUtil;

public class TemplateExpansion

  {
    protected static final Logger LOG = LogManager.getLogger(FlaggingRange.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name         ;
    @SerializedName("title"      ) public String   _Title        ;
    @SerializedName("expr"       ) public String   _Expression_DEPRECATED   ;
    @SerializedName("formula"    ) public String   _Formula      ;
    @SerializedName("description") public String   _Description  ;
    /*@formatter:on*/

    protected transient View      _ParentView;
    
    public TemplateExpansion()
      {
      }
    
    public void validate(ParserSession PS, View ParentView, Template GT)
      {        
        _ParentView = ParentView;
        
        if (TextUtil.isNullOrEmpty(_Name) == true)
         PS.AddError("Formula template "+GT._Name+" is defining an expansion without a name.");
        
        if (TextUtil.isNullOrEmpty(_Title) == true)
          _Title = _Name;

        if (TextUtil.isNullOrEmpty(_Expression_DEPRECATED) == false && TextUtil.isNullOrEmpty(_Formula) == false)
          PS.AddError("Formula template "+GT._Name+" is defining an expansion with both an 'expr' and 'formula' value: only one is allowed, and 'expr' has been deprecated in favor of 'formula'.");
        else if (TextUtil.isNullOrEmpty(_Expression_DEPRECATED) == false && TextUtil.isNullOrEmpty(_Formula) == true)
          _Formula = _Expression_DEPRECATED;
        else if (TextUtil.isNullOrEmpty(_Expression_DEPRECATED) == true && TextUtil.isNullOrEmpty(_Formula) == true)
          _Formula = _Name;

        if (TextUtil.isNullOrEmpty(_Description) == true)
          _Description = _Name;
      }
  }
