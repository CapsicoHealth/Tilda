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

package tilda.db;

import tilda.enums.StatementType;

/**
 * <B>LDH-NOTE</B>
 * This class helps build queries more safely, but it's not a compile-time tool. Therefore, there is no point
 * in trying to catch syntax errors as the database will do that plenty fine.<BR>
 * It's tempting to add extra features to catch mismatched parentheses, checking there is no duplicate
 * table names in the From clause. The only thing that was interesting is that using operators in the SET part
 * of a select or update causes weird things. For example, select a=3 evaluates as a boolean expression which
 * i find weird, so i check for it. Other than that, nothing except major issues like
 * 
 * @author ldh
 *
 */
public class DeleteQuery extends QueryHelper
  {
    public DeleteQuery(Connection C, String SchemaName, String TableName)
      throws Exception
      {
        super(C, StatementType.DELETE, SchemaName, TableName, true);
      }

    public int execute()
      throws Exception
      {
        return _C.ExecuteUpdate(_SchemaName, _TableName, _QueryStr.toString());
      }
  }
