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

package tilda.analyzer.helper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper
  {
    private static transient final String Formatter = "yyyy-MM-dd HH:mm:ss";
    private static transient final String TimezoneId = "US/Eastern";
    
    
    public static String getTimeNow()
    {
      ZonedDateTime ZDT1 = ZonedDateTime.now(ZoneId.of(TimezoneId));
      return ZDT1.format(DateTimeFormatter.ofPattern(Formatter));
    }
    
  }
