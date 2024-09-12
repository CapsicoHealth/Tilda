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

package tilda.interfaces;

import java.io.Writer;
import java.time.ZonedDateTime;


public interface CSVable
  {
    default String getCSVHeader(String csvExportName) throws Exception
     {
       throw new UnsupportedOperationException();
     }
    public void toCSV(Writer out, String csvExportName) throws Exception;
    public void toCSV(Writer out, String csvExportName, ZonedDateTime lastsync) throws Exception;
  }
