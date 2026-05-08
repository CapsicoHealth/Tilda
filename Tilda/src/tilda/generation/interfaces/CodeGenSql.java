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
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;


public interface CodeGenSql extends DBType, CodeGenBase
  {

    /**
     * 
     * @param Out
     * @throws Exception
     */
    public void genFileStart(PrintWriter Out, Schema S)
    throws Exception;

    public boolean stringNeedsTrim(Column C);

    public boolean stringArrayAggNeedsText(ViewColumn C);

    public String getBaseSelectStatement(List<Column> Columns);

    public String getEqualCurentTimestamp();
    public String getEqualCurentDateTime();
    public String getCommaCurentTimestamp();
    public String getCommaCurentDateTime();

    public void genDDL(PrintWriter Out, Object O)
    throws Exception;

    public void genDDL(PrintWriter Out, View V)
    throws Exception;

    public void genDDLComments(PrintWriter Out, View V)
    throws Exception;

    public String getDDLMetadataVersion();

    public Query genViewJoin(StringBuilder Str, ViewJoin VJ)
    throws Exception;

    public void genIndex(PrintWriter Out, Index I)
    throws Exception;

    public void genKeysManagement(PrintWriter Out, Object O);
  }
