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

public enum TZMode
  {
  /**
   * A TZ column generated per DATETIMEZ (date-time with timezone) column (default)
   */
  COLUMN,

  /**
   * A TZ column generated per DATETIME (plain, no timezone) column (default)
   */
  COLUMN_NO_TZ,

  /**
   * A TZ column generated per Row for all DATETIMEZ (date-time with timezone) columns
   */
  ROW,

  /**
   * A TZ column generated per Row for all DATETIME (plain, no timezone) columns
   */
  ROW_NO_TZ;

    public static TZMode parse(String Str)
      {
        for (TZMode e : TZMode.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public boolean isRow()
      {
        return this == ROW || this == ROW_NO_TZ;
      }

    public boolean isColumn()
      {
        return this == COLUMN || this == COLUMN_NO_TZ;
      }

    public boolean isTZ()
      {
        return this == COLUMN || this == ROW;
      }

    public boolean isNoTZ()
      {
        return this == COLUMN_NO_TZ || this == ROW_NO_TZ;
      }

  }
