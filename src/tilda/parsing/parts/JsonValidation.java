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
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.MultiType;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;
import tilda.grammar.WhereClauseCodeGenJavaOnJson;
import tilda.parsing.ParserSession;
import tilda.types.ColumnDefinition;
import tilda.utils.TextUtil;

public class JsonValidation
  {

    protected static final Logger LOG = LogManager.getLogger(JsonValidation.class.getName());

    public JsonValidation()
      {
      }

    /*@formatter:off*/
    @SerializedName("rule" ) public String[] _Rule;
    @SerializedName("descr") public String   _Descr;
    /*@formatter:on*/

    public JsonValidation(JsonValidation jv)
      {
        _Rule = jv._Rule;
        _Descr = jv._Descr;
      }
    
    
    public transient String _JavaCodeGenStr = null;

    public boolean validate(ParserSession PS, Column C)
      {
        if (_Rule == null || _Rule.length == 0)
          {
            PS.AddError("Column '" + C.getFullName() + " defined a jsonSchema with a validation rule without any rule.");
            return false;
          }
        if (TextUtil.isNullOrEmpty(_Descr) == true)
          {
            PS.AddError("Column '" + C.getFullName() + " defined a jsonSchema with a validation rule without any description.");
            return false;
          }

        List<ColumnDefinition> ColDefs = new ArrayList<ColumnDefinition>();
        for (JsonField f : C._JsonSchema._Fields)
          {
            ColumnDefinition Col = ColumnDefinition.create(null, null, f._Name, f._Type, f._TypeCollection != MultiType.NONE, f._Nullable, f._Description);
            ColDefs.add(Col);
          }

        StringBuilder Str = new StringBuilder();
        for (String s : _Rule)
          Str.append(s).append("\n");

        WhereClauseCodeGenJavaOnJson WC_CG = new WhereClauseCodeGenJavaOnJson();
        TildaSQLValidator Validator = new TildaSQLValidator(Str.toString());
        if (Validator.getParserSyntaxErrors() != 0)
          {
            PS.AddError("Column '" + C.getFullName() + " defined a jsonSchema with an invalid validation rule.");
            LOG.error("\n" + Str.toString());
            return false;
          }
        Validator.setColumnEnvironment(ColDefs);
        Validator.setCodeGen(WC_CG);
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            boolean Err = false;
            while (I.hasNext() == true)
              {
                PS.AddError("Column '" + C.getFullName() + " defined a jsonSchema with an invalid validation rule: " + I.next());
                Err = true;
              }
            if (Err == true)
              return false;
          }

        _JavaCodeGenStr = WC_CG.getCodeStr();

        //LOG.debug("Generated Java rule check:\n" + _JavaCodeGenStr);

        return true;
      }
  }
