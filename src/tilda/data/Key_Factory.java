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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_KEY</B> mapped to the table <B>TILDA.KEY</B>.
@see tilda.data._Tilda.TILDA__KEY
*/
public class Key_Factory extends tilda.data._Tilda.TILDA__KEY_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Key_Factory.class.getName());

   public Key_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   
   public static void init(Connection C) throws Exception
     {
       // Add logic to initialize your object, for example, caching some values, or validating some things.
     }

   protected static long replenish(Key_Data K)
       throws SQLException, Error
       {
         long k;
         Connection C = null;
         try
           {
             C = ConnectionPool.get("KEYS");
             UpdateQuery Q = newUpdateQuery(C);
             Q.set(COLS.MAX, COLS.MAX).plus(COLS.COUNT)
              .where().equals(COLS.REFNUM, K.getRefnum());
             Q.execute();
             K.Refresh(C);
             K._K.set(K.getCount());
             LOG.debug("Refilled '"+K.getName()+"' keys "+(K.getMax()-K.getCount()+1)+" - "+K.getMax());
             k = K._K.addAndGet(-1);
             C.commit();
             return K.getMax() - k;
           }
         catch (Throwable T)
           {
             if (C != null)
              C.rollback();
             LOG.error("Cannot initialize the Tilda KEYS", T);
             throw new Error(T);
           }
         finally
           {
             if (C != null)
               {
                 C.close();
               }
           }
       }
   
 }
