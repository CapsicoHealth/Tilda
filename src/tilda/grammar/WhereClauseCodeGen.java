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
    public void isNull               (ColumnDefinition Column, boolean not);
    public String binClose           ();

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

    /*@formatter:on*/
  }
