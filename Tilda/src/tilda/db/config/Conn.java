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

package tilda.db.config;

import com.google.gson.annotations.SerializedName;

public class Conn
  {
    /*@formatter:off*/
    @SerializedName("id"     ) public String   _Id      = null;
    @SerializedName("driver" ) public String   _Driver  = null;
    @SerializedName("db"     ) public String   _DB      = null;
    @SerializedName("user"   ) public String   _User    = null;
    @SerializedName("pswd"   ) public String   _Pswd    = null;
    @SerializedName("initial") public int      _Initial =  3;
    @SerializedName("max"    ) public int      _Max     = 30;
    @SerializedName("schemas") public String[] _Schemas = new String[]{};
    /*@formatter:on*/
  }
