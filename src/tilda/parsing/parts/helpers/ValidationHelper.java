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

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.utils.TextUtil;
import tilda.parsing.parts.Object;


public class ValidationHelper
  {
    public static List<Column> ProcessColumn(ParserSession PS, Base ParentObject, String What, String[] ColumnNames, Processor P)
      {
        List<Column> Columns = new ArrayList<Column>();
        Set<String> Names = new HashSet<String>();
        if (ColumnNames != null)
          for (String c : ColumnNames)
            {
              if (TextUtil.isNullOrEmpty(c) == true)
                return null;
              Column C = ParentObject.getColumn(c);
              if (C == null)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with column '" + c + "' which cannot be found.");
                  return null;
                }
              if (C._FailedValidation == true)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with column '" + c + "' which has failed validation previously and cannot be processed any more.");
                  return null;
                }
              if (Names.add(C._Name.toUpperCase()) == false)
                {
                  PS.AddError("Object '" + ParentObject.getFullName() + "' is defining " + What + " with duplicated column '" + c + "'.");
                  return null;
                }
              Columns.add(C);
              if (P != null && P.process(PS, ParentObject, What, C) == false)
                return null;
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
  }
