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

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_ZONEINFO</B> mapped to the table <B>TILDA.ZONEINFO</B>.
@see tilda.data._Tilda.TILDA__ZONEINFO
*/
public class ZoneInfo_Factory extends tilda.data._Tilda.TILDA__ZONEINFO_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(ZoneInfo_Factory.class.getName());

   public ZoneInfo_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public static void init(Connection C) throws Exception
     {
       for (ZoneInfo_Data info : __ENUMERATIONS_BY_ID.values())
        {
          ZonedDateTime ZDT = ZonedDateTime.of(2015, 6, 21, 11, 0, 0, 0, ZoneId.of(info.getValue()));
          if (ZDT.getZone().getId().equals(info.getValue()) == false)
           {
             LOG.info("ZoneInfo id="+info.getId()+" and value="+info.getValue()+" has an alternate value "+ZDT.getZone().getId());
             __ENUMERATIONS_BY_VALUE.put(ZDT.getZone().getId(), info);
           }
          ZDT = ZonedDateTime.of(2014, 12, 22, 11, 0, 0, 0, ZoneId.of(info.getValue()));
          if (ZDT.getZone().getId().equals(info.getValue()) == false)
           {
             LOG.info("ZoneInfo id="+info.getId()+" and value="+info.getValue()+" has an alternate value "+ZDT.getZone().getId());
             __ENUMERATIONS_BY_VALUE.put(ZDT.getZone().getId(), info);
           }
        }
     }
   
   
   public static Calendar nowAsCalendar(String ZoneInfoId)
     {
       ZoneInfo_Data ZoneInfo = ZoneInfo_Factory.getEnumerationById(ZoneInfoId);
       return Calendar.getInstance(java.util.TimeZone.getTimeZone(ZoneInfo.getValue()));
     }
   
 }
