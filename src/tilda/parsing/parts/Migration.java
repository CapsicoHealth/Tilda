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

import tilda.parsing.ParserSession;

public class Migration
  {
    /*@formatter:off*/
    @SerializedName("renames") public List<MigrationRename> _Renames = new ArrayList<MigrationRename>();
// DROP is currently being removed from feature list as per #58. Too complex with lots of issues.
//    @SerializedName("drops"  ) public List<MigrationDrop>   _Drops   = new ArrayList<MigrationDrop  >();
    @SerializedName("moves"  ) public List<MigrationMove>   _Moves   = new ArrayList<MigrationMove  >();
    /*@formatter:on*/

    public transient Schema              _Parent;

    public boolean Validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        for (int i = 0; i < _Renames.size(); ++i)
          {
            MigrationRename M = _Renames.get(i);
            M.Validate(PS, Parent);
            if (M._Object != null && M._Object._CloneAs != null)
              for (Cloner cl : M._Object._CloneAs)
                {
                  MigrationRename M2 = new MigrationRename(M);
                  M2._ObjectName = cl._Name;
                  _Renames.add(M2);
                }
          }

        // DROP is currently being removed from feature list as per #58. Too complex with lots of issues.
//        for (MigrationDrop M : _Drops)
//          M.Validate(PS, Parent);

        for (MigrationMove M : _Moves)
          M.Validate(PS, Parent);

        return Errs == PS.getErrorCount();
      }

  }
