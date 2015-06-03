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

import java.time.ZonedDateTime;

import tilda.interfaces.OCCObject;

public enum SyncStatus
{
    NEW('N')
  , UPDATED('U')
  , DELETED('D')
  , OLD('O');

  private SyncStatus(char Status)
    {
      _Status = Status;
    }

  public final char _Status;
  
  public static SyncStatus get(ZonedDateTime Marker, OCCObject Obj)
    {
      return Obj.getDeleted    () != null ? ( Obj.getDeleted().isAfter(Marker) == true && Obj.getCreated().isBefore(Marker) == true ? DELETED : OLD)
           : Obj.getCreated    ().isAfter(Marker) == true ? NEW
           : Obj.getLastUpdated().isAfter(Marker) == true ? UPDATED
                                                          : OLD;
    }
}