/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.grammar;

import java.time.ZonedDateTime;
import java.util.List;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;

public interface WhereClauseCodeGen
  {
    /*@formatter:off*/

    public void boolOperatorAND(boolean not);
    public void boolOperatorOR (boolean not);
     
    public void boolOpenPar ();
    public void boolClosePar();
     
    public void binLike              (List<ColumnDefinition> Columns, boolean not);
    public void binEqual             (List<ColumnDefinition> Columns, ColumnType Type, boolean not);
    public void binLessThan          (List<ColumnDefinition> Columns, ColumnType Type);
    public void binLessThanOrEqual   (List<ColumnDefinition> Columns, ColumnType Type);
    public void binGreaterThan       (List<ColumnDefinition> Columns, ColumnType Type);
    public void binGreaterThanOrEqual(List<ColumnDefinition> Columns, ColumnType Type);
    public void binIn                (List<ColumnDefinition> Columns, boolean not);
    public String binClose           ();

    /**
     * Must be called with a nullable column (where a null test makes sense). If orEmpty is true 
     * then the column MUST be a collection or a String.<BR>
     * <B style="color:red; font-size: 125%;">Implementers of this interface are <U>NOT</U> expected to do this validation!</B>
     * 
     * @param Column  A Column definition
     * @param not     Whether this is a "is null" or "is not null"
     * @param orEmpty Whether a check for 'emptiness' should be performed as well, which means a 
     *                length of 0 for collections, and val.trim().length() == 0 for Strings.
     */
    public void isNull(ColumnDefinition Column, boolean not, boolean orEmpty);

    /**
     * Must be called with a single 'collection' Column, or a list of Columns where ALL are single Strings
     * and will be concatenated together and checked for length.<BR>
     * <B style="color:red; font-size: 125%;">Implementers of this interface are <U>NOT</U> expected to do this validation!</B>
     * @param Columns a list of column definitions
     */
    public void funcLen(List<ColumnDefinition> Columns);

    public void col                  (ColumnDefinition Column);

    public void   valueListOpen        ();
    public void   valueListSeparator   ();
    public void   valueLiteralNumeric  (String Number);
    public void   valueLiteralChar     (char c);
    public void   valueLiteralString   (String Str);
    public void   valueLiteralTimestamp(ZonedDateTime ZDT);
    public void   valueTimestampCurrent();
    public void   valueTimestampYesterday(boolean first);
    public void   valueTimestampToday    (boolean first);
    public void   valueTimestampTomorrow (boolean first);
    public void   valueParameter       (String Str);
    public String valueListClose       (ColumnType Type);
    
    public void   arithmeticOpenPar  ();
    public void   arithmeticClosePar ();
    public void   arithmeticPlus     (boolean minus);
    public void   arithmeticMultiply (boolean division);

    public void   end();
    
    public String getCodeStr();

    /*@formatter:on*/
  }
