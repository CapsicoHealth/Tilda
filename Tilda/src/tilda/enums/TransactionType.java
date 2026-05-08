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


public enum TransactionType
  {
    COMMIT            ("--COMMIT--"            ), 
    ROLLBACK          ("--ROLLBACK--"          ),
    SAVEPOINT_SET     ("--SAVEPOINT SET--"     ),
    SAVEPOINT_COMMIT  ("--SAVEPOINT COMMIT--"  ),
    SAVEPOINT_ROLLBACK("--SAVEPOINT ROLLBACK--"),
    STATEMENT_CLOSE   ("--STATEMENT CLOSE--"   ),
    CONNECTION_CLOSE  ("--CONNECTION CLOSE--"  ),
    CONNECTION_GET    ("--CONNECTION GET--"    ),
    TILDA_SETTER      ("--TILDA SETTER--"      ),
    TILDA_TOSTRING    ("--TILDA TOSTRING--"    ),
    TILDA_TOJSON      ("--TILDA TOJSON--"      ),
    TILDA_TOCSV       ("--TILDA TOCSV--"      )
    ;

    private TransactionType(String Name)
      {
        _Name = Name;
      }

    protected String _Name;

    public String getName()
      {
        return _Name;
      }

  };
