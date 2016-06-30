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

package tilda.generation.interfaces;

import java.io.PrintWriter;
import java.util.List;

import tilda.db.stores.DBType;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.View;


public interface CodeGenSql extends DBType, CodeGenBase
  {
    
    public String getFullTableVar(Object O);
    public String getFullColumnVar(Column C);
    public String getFullColumnVar(Column C, int i);
    public String getFullTableVar(Object O, int i);
    public String getShortColumnVar(Column C);
    
    public String getColumnType(Column C);
    public String getColumnTypeRaw(Column C, boolean MultiOverride);
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean isArray);
    public boolean stringNeedsTrim(Column C);
    
    boolean supportsArrays();
    
    public String getBaseSelectStatement(List<Column> Columns);
    public String getEqualCurentTimestamp();
    public String getCommaCurentTimestamp();

    public void genDDL(PrintWriter Out, Object O) throws Exception;
    public void genDDL(PrintWriter Out, View   V) throws Exception;
    public void genIndex(PrintWriter Out, Index I);
    public void genKeysManagement(PrintWriter Out, Object O);
  }
