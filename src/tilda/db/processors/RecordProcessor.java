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

public interface RecordProcessor
  {
    /**
     * Called before the first record is processed
     */
    default public void start()
    throws Exception
      {
      }

    /**
     * Called for each record
     * 
     * @param count the count of the record being processed starting at 0 for the first record
     * @param RS the result set to be processed
     * @return whether this was successful or not. If false is returned, the process will be aborted.
     * @throws Exception
     */
    public boolean process(int count, ResultSet RS)
    throws Exception;


    /**
     * Called after the last record has been processed successfully
     * 
     * @param hasMore whether there are more records to be processed
     * @param maxCount the max count originally supplied to the query handler
     */
    default void end(boolean hasMore, int maxCount)
    throws Exception
      {
      }    
  }
