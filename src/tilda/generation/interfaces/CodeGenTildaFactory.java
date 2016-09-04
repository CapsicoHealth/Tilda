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

import tilda.generation.GeneratorSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.SubWhereClause;

public interface CodeGenTildaFactory extends CodeGenBase
  {

    /**
     * 
     * @param Out
     * @throws Exception
     */
    public void genFileStart(PrintWriter Out, Object O)
    throws Exception;

    /**
     * 
     * @param Out
     * @param O
     * @param CreateColumns
     * @throws Exception
     */
    public void genMethodCreate(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns, List<Column> DefaultColumns)
    throws Exception;

    /**
     * 
     * @param Out
     * @param O
     * @param PK
     */
    public void genMethodLookupByPrimaryKey(PrintWriter Out, GeneratorSession G, PrimaryKey PK, long LookupId);

    /**
     * 
     * @param Out
     * @param O
     * @param I
     */
    public void genMethodLookupByUniqueIndex(PrintWriter Out, GeneratorSession G, Index I, long LookupId);

    /**
     * 
     * @param Out
     * @param G
     * @param I
     * @param LookupId
     */
    public void genMethodLookupWhereIndex(PrintWriter Out, GeneratorSession G, Index I, int LookupId);

    /**
     * 
     * @param Out
     * @param G
     * @param Q
     * @param LookupId
     */
    public void genMethodLookupByUniqueQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q, int LookupId);

    /**
     * 
     * @param Out
     * @param G
     * @param Q
     * @param LookupId
     */
    public void genMethodLookupWhereQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q, int LookupId);

    /**
     * 
     * @param Out
     * @param G
     * @param FK
     */
    public void genMethodLookupParent(PrintWriter Out, GeneratorSession G, ForeignKey FK);

    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genQueryHelper(PrintWriter Out, GeneratorSession G, Object O);


    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genMappingSupport(PrintWriter Out, GeneratorSession G, Object O);

    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genEnumerationSupport(PrintWriter Out, GeneratorSession G, Object O);
  }
