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

package tilda.migration.actions;

import tilda.db.Connection;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.View;

public class ViewDrop extends MigrationAction
  {
    public ViewDrop(View V)
      {
        super(V._ParentSchema._Name, V._Name, false);
        _V = V;
      }
    protected View _V;

    @Override
    public boolean process(Connection C)
    throws Exception
      {
        return C.dropView(_V);
      }

    public String getDescription()
      {
        return "Dropping view " + _V.getFullName();
      }
  }
