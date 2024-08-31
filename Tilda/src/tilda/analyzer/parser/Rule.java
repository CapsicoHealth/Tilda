/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda.analyzer.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Rule
  {
    @SerializedName("name") public String _Name     = null;
    @SerializedName("regexes") public List<String> _Regexes     = new ArrayList<String>();
    @SerializedName("columns") public List<String> _Columns     = new ArrayList<String>();
  }
