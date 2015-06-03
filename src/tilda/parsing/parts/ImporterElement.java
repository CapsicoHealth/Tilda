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

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ImporterElement
  {
    static final Logger              LOG                = LogManager.getLogger(ImporterElement.class.getName());

    /*@formatter:off*/
    @SerializedName("name"            ) public String                 _Name       ;
    @SerializedName("type"            ) public String                 _Type       ;
    @SerializedName("multi"           ) public boolean                _Multi      ;
    @SerializedName("elements"        ) public List<ImporterElement>  _Elements = new ArrayList<ImporterElement>();
    /*@formatter:on*/

    public transient Importer _ParentImporter;

    public boolean Validate(ParserSession PS, Importer ParentImporter)
      {
        int Errs = PS.getErrorCount();
        _ParentImporter = ParentImporter;
        LOG.debug("  Validating Importer Element " + _Name + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Importer '" + ParentImporter._Name + "' is declaring a mapper without a name.");
        if (ValidationHelper.isValidIdentifier(_Name) == false)
          return PS.AddError("Importer '" + ParentImporter._Name + "' is declaring a mapper '" + _Name + "' with a name which is not valid. " + ValidationHelper._ValidIdentifierMessage);

        return Errs == PS.getErrorCount();
      }
  }
