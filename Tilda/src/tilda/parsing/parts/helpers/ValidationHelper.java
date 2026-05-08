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

package tilda.parsing.parts.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Convention;
import tilda.utils.TextUtil;


public class ValidationHelper
  {
    static final Logger LOG = LogManager.getLogger(ValidationHelper.class.getName());

    public static List<Column> ProcessColumn(ParserSession PS, Base ParentObject, String What, String[] ColumnNames, Processor P)
      {
        List<Column> Columns = new ArrayList<Column>();
        Set<String> Names = new HashSet<String>();
        if (ColumnNames != null)
          for (String c : ColumnNames)
            {
              if (TextUtil.isNullOrEmpty(c) == true)
                continue;
              Column C = ParentObject.getColumn(c);
              if (C == null)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with column '" + c + "' which cannot be found.");
                  continue;
                }
              if (C.hasBeenValidatedSuccessfully() == false)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with column '" + c + "' which has failed validation previously and cannot be processed any more.");
                  continue;
                }
              if (Names.add(C.getName().toUpperCase()) == false)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with duplicated column '" + c + "'.");
                  continue;
                }
              Columns.add(C);
              if (P != null && P.process(PS, ParentObject, What, C) == false)
                continue;
            }
        return Columns;
      }

    public static interface Processor
      {
        public boolean process(ParserSession PS, Base ParentObject, String What, Column C);
      }

    public static String _ValidIdentifierMessage = "Names must conform to a common subset of SQL, C++, Java, .Net and JavaScript identifier conventions.";

    public static boolean isValidIdentifier(String Name)
      {
        char[] chars = Name.toCharArray();
        if (Character.isJavaIdentifierStart(chars[0]) == false)
          return false;
        for (int i = 1; i < chars.length; ++i)
          if (Character.isJavaIdentifierPart(chars[i]) == false)
            return false;

        return true;
      }

    public static boolean isReservedIdentifier(String name)
      {
        if (name != null && name.equalsIgnoreCase("class") == true)
          return true;

        return false;
      }


    public static boolean validateColumnName(ParserSession PS, String containerType, String columnName, String fullName, Convention convention)
      {
        int Errs = PS.getErrorCount();

        if (columnName.length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError(containerType+" column '" + fullName + "' has a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + columnName.length() + " for this identifier.");
        if (convention != null && convention._ColumnNamingConvention.validateColumnName(columnName) == false)
          PS.AddError("Column '" + fullName + "' has a name '" + columnName + "' which doesn't match the schema's column naming convention '" + convention._ColumnNamingConvention.name() + "'.");
        if (columnName.equals(TextUtil.sanitizeName(columnName)) == false)
          PS.AddError(containerType+" column '" + fullName + "' has a name containing invalid characters (must all be alphanumeric or underscore).");
        if (ValidationHelper.isValidIdentifier(columnName) == false)
          PS.AddError(containerType+" column '" + fullName + "' has a name '" + columnName + "' which is not valid. " + ValidationHelper._ValidIdentifierMessage);
        if (ValidationHelper.isReservedIdentifier(columnName) == true)
          PS.AddError(containerType+" column '" + fullName + "' has a name '" + columnName + "' which is a reserved identifier.");

        return Errs == PS.getErrorCount();
      }
  }
