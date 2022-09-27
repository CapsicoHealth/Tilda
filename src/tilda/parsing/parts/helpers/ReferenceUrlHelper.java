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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.HTMLFilter;
import tilda.utils.TextUtil;

public class ReferenceUrlHelper
  {
    static final Logger LOG = LogManager.getLogger(DefaultsHelper.class.getName());

    public static String processReferenceUrl(String description, String referenceUrl)
      {
        return TextUtil.isNullOrEmpty(referenceUrl) == false 
        ? description
        : description.replaceAll("${REFERENCE_URL}", "<A target=\"_other\" href=\""+TextUtil.escapeDoubleQuoteWithSlash(referenceUrl)+"\">"+HTMLFilter.cleanAbsolute(referenceUrl)+"</A>");
      }
    
  }
