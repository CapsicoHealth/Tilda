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


package tilda.data;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
 * This is the application class <B>Data_KEY</B> mapped to the table <B>TILDA.KEY</B>.
 * 
 * @see tilda.data._Tilda.TILDA__KEY
 */
public class Key_Data extends tilda.data._Tilda.TILDA__KEY
  {
    protected static final Logger LOG = LogManager.getLogger(Key_Data.class.getName());

    public Key_Data() { }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Implement your customizations, if any, below.
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void init(Connection C) throws Exception
      {
        // Add logic to initialize your object, for example, caching some values, or validating some things.
      }

    @Override
    protected boolean BeforeWrite(Connection C)
      throws Exception
      {
        // Do things before writing the object to disk, for example, take care of AUTO fields.
        return true;
      }

    @Override
    protected boolean AfterRead(Connection C)
      throws Exception
      {
        // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
        return true;
      }

    protected AtomicLong _K = new AtomicLong(0);

    public long nextKey() throws SQLException
      {
        long k = _K.addAndGet(-1);
        if (k >= 0)
          return getMax() - k;

        synchronized (_K)
          {
            k = _K.addAndGet(-1);
            if (k >= 0)
              return getMax() - k;
            return Key_Factory.replenish(this);
          }
      }
  }
