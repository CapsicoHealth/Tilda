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

package tilda.parsing.parts.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.utils.HTMLFilter;
import tilda.utils.TextUtil;

public class DescriptionRewritingHelper
  {
    static final Logger LOG = LogManager.getLogger(DescriptionRewritingHelper.class.getName());

    public static String processReferenceUrl(String description, Base b)
      {
        if (TextUtil.isNullOrEmpty(b._ReferenceUrl) == false)
         description = TextUtil.searchReplace(description, "${REFERENCE_URL}", "<A target=\"_other\" href="+TextUtil.escapeDoubleQuoteWithSlash(b._ReferenceUrl)+">"+HTMLFilter.cleanAbsolute(b._ReferenceUrl)+"</A>");
         
        if (TextUtil.isNullOrEmpty(b._Tag) == false)
          description = TextUtil.searchReplace(description, "${TAG}", b._Tag);
         
        return description;
      }

    protected static Pattern _REGEX_FK_TABLE_DESCRIPTION = Pattern.compile("\\$\\{FK_TABLE_DESCRIPTION\\.([^\\}]+)\\}");

    public static String processFKTableDescription(String description, tilda.parsing.parts.Object obj)
      {
        Matcher M = _REGEX_FK_TABLE_DESCRIPTION.matcher(description);
        if (M.matches() == true && M.groupCount() > 0)
          {
            Column C = obj.getColumn(M.group(1));
            if (C != null)
             return M.replaceFirst(C._Description);
          }
        return description;
      }
    
  }
