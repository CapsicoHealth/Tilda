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

package tilda.utils;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DateTimeZone
  {
    UTC("Etc/UTC")
    , ZULU("Etc/Zulu")
    , CanadaNewfoundland("Canada/Newfoundland")
    , CanadaAtlantic("Canada/Atlantic")
    , USEastern("US/Eastern")
    , CanadaEastern("Canada/Eastern")
    , USCentral("US/Central")
    , CanadaCentral("Canada/Central")
    , CanadaSaskatchewan("Canada/Saskatchewan")
    , USArizona("US/Arizona")
    , USMountain("US/Mountain")
    , CanadaMountain("Canada/Mountain")
    , USPacific("US/Pacific")
    , CanadaPacific("Canada/Pacific")
    , USAlaska("US/Alaska")
    , USHawaii("US/Hawaii")
    , USSamoa("US/Samoa");

    private DateTimeZone(String Str)
      {
        _ZoneId = ZoneId.of(Str);
      }

    protected static final Map<String, DateTimeZone> _TIMEZONES = new HashMap<String, DateTimeZone>();
    static
      {
        for (DateTimeZone tz : DateTimeZone.values())
          _TIMEZONES.put(tz._ZoneId.getId().toLowerCase(), tz);
      }

    public final ZoneId                              _ZoneId;


    public static DateTimeZone parse(String Str)
      {
        return _TIMEZONES.get(Str.toLowerCase());
      }

    public static List<DateTimeZone> get(String subName)
      {
        subName = subName.toLowerCase();
        List<DateTimeZone> L = new ArrayList<DateTimeZone>();
        for (Map.Entry<String, DateTimeZone> tz : _TIMEZONES.entrySet())
          if (tz.getKey().indexOf(subName) != -1)
            L.add(tz.getValue());
        return L;
      }

  }
