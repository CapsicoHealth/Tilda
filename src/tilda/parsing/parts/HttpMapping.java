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

import com.google.gson.annotations.SerializedName;

public class HttpMapping
  {

    public HttpMapping()
      {
      }

    @SerializedName("name"       ) public String   _Name;
    @SerializedName("mandatories") public String[] _Mandatories;
    @SerializedName("optionals"  ) public String[] _Optionals;
    
    public transient List<Column> _MandatoryObjs= new ArrayList<Column>();
    public transient List<Column> _OptionalObj  = new ArrayList<Column>();
    
  }
