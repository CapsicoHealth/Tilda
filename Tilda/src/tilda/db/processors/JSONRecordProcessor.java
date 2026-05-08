/* ===========================================================================
 * Copyright (C) 2019 CapsicoHealth Inc.
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

package tilda.db.processors;

import java.io.Writer;
import java.sql.ResultSet;
import java.util.Iterator;

import tilda.db.SelectQuery;
import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.utils.json.JSONUtil;

public class JSONRecordProcessor implements RecordProcessor
 {
   public JSONRecordProcessor(Writer Out, SelectQuery Q) throws Exception
    {
      _Out = Out;
      _Q = Q;
    }

   protected Writer _Out;
   protected SelectQuery _Q;

   @Override
   public void start()
    {
    }

   @Override
   public boolean process(int Index, ResultSet RS)
   throws Exception
    {
      _Out.write(Index == 0 ? "    { " : "  , { ");
      int i = 1;
      Iterator<ColumnDefinition> I = _Q.getColumns();
      while (I.hasNext() == true)
        {
          ColumnDefinition c = I.next();
          if (c.getType() == ColumnType.CHAR || c.getType() == ColumnType.STRING)
           JSONUtil.print(_Out, c.getName(), i==1 , RS.getString(i).trim());
          else if (c.getType() == ColumnType.DOUBLE || c.getType() == ColumnType.FLOAT)
           JSONUtil.print(_Out, c.getName(), i==1 , RS.getDouble(i));
          else if (c.getType() == ColumnType.LONG || c.getType() == ColumnType.INTEGER)
            JSONUtil.print(_Out, c.getName(), i==1 , RS.getLong(i));
          else
           throw new Exception(c.getType()+" column '"+c.getName()+"' was passed in through a query in position "+i+": JSONRecordProcessor only supports columns of type char/string/text, long/integer, or double/float.");
          ++i;
        }
      _Out.append(" }\n");
      return true;
    }

   @Override
   public void end(boolean hasMore, int MaxIndex)
    {
    }
}