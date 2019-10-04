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

package tilda.db.processors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;


public class TimeStampRP implements RecordProcessor
  {
    @Override
    public void start()
      {
      }

    protected OffsetDateTime _ODT;

    @Override
    public boolean process(int Index, ResultSet RS)
      throws SQLException
      {
        _ODT = (OffsetDateTime) RS.getObject(1);
        return true;
      }

    @Override
    public void end(boolean hasMore, int MaxIndex)
      {
      }

    public OffsetDateTime getResult()
      {
        return _ODT;
      }
  }
