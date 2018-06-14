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

package tilda.enums;

import java.util.ArrayList;
import java.util.List;

public enum OutputFormatType
  {
  JSON,

  CSV,
  
  NVP;

    public static OutputFormatType parse(String Str)
      {
        if (Str != null)
          for (OutputFormatType e : OutputFormatType.values())
            if (Str.equalsIgnoreCase(e.name()) == true)
              return e;
        return null;
      }

    public static List<OutputFormatType> parse(String[] Strs)
      {
        List<OutputFormatType> L = new ArrayList<OutputFormatType>();
        if (Strs != null)
          for (String s : Strs)
            {
              OutputFormatType OFT = parse(s);
              if (OFT != null)
                L.add(OFT);
            }
        return L;
      }

  }
