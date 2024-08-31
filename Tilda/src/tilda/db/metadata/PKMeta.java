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

package tilda.db.metadata;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PKMeta
  {
    static final Logger LOG = LogManager.getLogger(PKMeta.class.getName());
    
    protected PKMeta(ResultSet RS)
    throws Exception
      {
//         LOG.debug(JDBCHelper.PrintResultSet(RS));
         _Name   = RS.getString("PK_NAME" );
         _Columns.add(RS.getString("COLUMN_NAME"));
         while (RS.next() == true)
          _Columns.add(RS.getString("COLUMN_NAME"));           
      }

    public final String       _Name  ;
    public final List<String> _Columns = new ArrayList<String>();

    public String toString()
      {
        StringBuilder Str = new StringBuilder();
        for (String PKCol : _Columns)
          {
            if (Str.length() != 0)
             Str.append(", ");
            Str.append(PKCol);
          }
        return "Name: " + _Name + "("+Str.toString()+");";
      }
  }
