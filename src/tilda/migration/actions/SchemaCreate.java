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
import tilda.parsing.parts.Schema;

public class SchemaCreate extends MigrationAction
  {
    public SchemaCreate(Schema S)
      {
        super(S._Name, null, false, null);
        _S = S;
      }

    protected Schema _S;

    public boolean process(Connection C)
    throws Exception
      {
        return C.createSchema(_S);
      }

    public String getDescription()
      {
        return "Create schema "+_S.getFullName();
      }
  }
