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
    @SerializedName("renames" ) public List<MigrationRename>   _Renames  = new ArrayList<MigrationRename >();
    @SerializedName("moves"   ) public List<MigrationMove>     _Moves    = new ArrayList<MigrationMove   >();
    @SerializedName("notNulls") public List<MigrationNotNull>  _NotNulls = new ArrayList<MigrationNotNull>();
//  DROP is currently being removed from feature list as per #58. Too complex with lots of issues.
//  @SerializedName("drops"  ) public List<MigrationDrop>   _Drops   = new ArrayList<MigrationDrop  >();
    /*@formatter:on*/

    public transient Schema              _Parent;

    public boolean validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        for (int i = 0; i < _Renames.size(); ++i)
          {
            MigrationRename M = _Renames.get(i);
            M.validate(PS, Parent);
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
//          M.validate(PS, Parent);

        for (MigrationMove M : _Moves)
          M.validate(PS, Parent);

        for (MigrationNotNull M : _NotNulls)
          M.validate(PS, Parent);

        return Errs == PS.getErrorCount();
      }

    public MigrationNotNull getNotNull(Column col)
      {
        for (MigrationNotNull mnn : _NotNulls)
          for (Column c : mnn._Columns)
            if (col.getFullName().equals(c.getFullName()) == true)
             return mnn;
        return null;
      }

  }
