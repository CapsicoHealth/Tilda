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

package tilda.data.importers.zones;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import tilda.Importer;
import tilda.data.ZoneInfo_Factory;
import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;

public class RootImporter implements Importer
  {
    /*@formatter:off*/
    @SerializedName("zones") public List<ZoneInfo_Data> _Zones = new ArrayList<ZoneInfo_Data>();
    /*@formatter:on*/

    @Override
    public int process(Connection C)
    throws Exception
      {
        int Count = 0;

        for (ZoneInfo_Data obj : _Zones)
          {
            ++Count;
            if (obj.upsert(C, true) == false)
              throw new Exception("Cannot upsert ZoneInfo");
          }
        ZoneInfo_Factory.initMappings(C);

        return Count;
      }
  }
