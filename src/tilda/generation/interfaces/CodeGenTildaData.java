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
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.Object;

/**
 * Interface for a generator module for the Support class
 * 
 * @author ldh
 *
 */
public interface CodeGenTildaData extends CodeGenBase
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
     * @param C
     * @throws Exception
     */
    public void genField(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param out
     * @param g
     * @param _Values
     */
    public void genFieldValues(PrintWriter Out, GeneratorSession G, Column C);

    /**
     * 
     * @param Out
     * @param C
     * @throws Exception
     */
    public void genMethodGet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param Out
     * @param G
     * @param V
     */
    public void genMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V);

    /**
     * 
     * @param Out
     * @param C
     * @throws Exception
     */
    public void genMethodSet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param Out
     * @param G
     * @param V
     */
    public void genMethodSetAs(PrintWriter Out, GeneratorSession G, ColumnValue V);

    /**
     * 
     * @param Out
     * @param G
     * @param C
     */
    public void genMethodSetDateTimeNow(PrintWriter Out, GeneratorSession G, Column C);

    /**
     * 
     * @param Out
     * @param G
     * @param C
     */
    public void genMethodSetDateTimeUndefined(PrintWriter Out, GeneratorSession G, Column C);

    /**
     * 
     * @param Out
     * @param G
     * @param C
     */
    public void genMethodSetDateTimeExplicit(PrintWriter Out, GeneratorSession G, Column C);

    /**
     * 
     * @param Out
     * @param C
     * @throws Exception
     */
    public void genMethodSetNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param Out
     * @param C
     * @throws Exception
     */
    public void genMethodHasChanged(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param Out
     * @param C
     * @throws Exception
     */
    public void genMethodIsNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;


    /**
     * 
     * @param Out
     * @param G
     * @param O
     * @throws Exception
     */
    public void genMethodTouch(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception;

    /**
     * 
     * @param Out
     * @param O
     * @throws Exception
     */
    public void genMethodWrite(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception;

    /**
     * 
     * @param Out
     * @param O
     * @throws Exception
     */
    public void genMethodUpsert(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception;

    /**
     * 
     * @param Out
     * @param G
     * @param O
     * @param CopyToColumns
     * @throws Exception
     */
    public void genMethodCopyTo(PrintWriter Out, GeneratorSession G, Object O, List<Column> CopyToColumns)
    throws Exception;


    /**
     * 
     * @param out
     * @param g
     * @param o
     */
    public void genMethodCopyForHistory(PrintWriter out, GeneratorSession G, Object obj, Object histObj)
    throws Exception;
    

    /**
     * 
     * @param Out
     * @param G
     * @param O
     * @param CopyToColumns
     * @throws Exception
     */
    public void genMethodMask(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception;

    
    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genMethodRefresh(PrintWriter Out, GeneratorSession G, Object O);

    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genMethodRead(PrintWriter Out, GeneratorSession G, Object O);


    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genMethodToString(PrintWriter Out, GeneratorSession G, Object O);


    /**
     * 
     * @param Out
     * @param G
     * @param O
     */
    public void genMethodOutput(PrintWriter Out, GeneratorSession G, Object O);

  }
