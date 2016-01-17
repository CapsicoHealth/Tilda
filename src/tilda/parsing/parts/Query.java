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

package tilda.parsing.parts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.parsing.ParserSession;
import tilda.enums.ColumnType;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Query
  {
    protected static final Logger LOG = LogManager.getLogger(Query.class.getName());
    
    /*@formatter:off*/
    @SerializedName("db"    ) public String   _DB    ;
    @SerializedName("clause") public String   _Clause;
    /*@formatter:on*/

    public transient List<Column> _ColumnObjs = new ArrayList<Column>();
    public transient List<String> _VarNames   = new ArrayList<String>();

//  private static final Pattern _P1 = Pattern.compile("\\b([a-zA-Z_][\\w\\.]*)(\\W+\\?\\(([a-z_A-Z]\\w*)?\\))");
    private static final Pattern _P1 = Pattern.compile("\\b([a-zA-Z_][\\w\\.]*)((?:\\s+is\\s+(?:not)?null)|(?:\\W*\\?\\((?:[a-z_A-Z]\\w*)?\\)))");
    private static final Pattern _P2 = Pattern.compile("\\?\\(([a-z_A-Z]\\w*)?\\)");

    public Query()
      {
      }
    public Query(String _SubWhere)
      {
        _Clause = _SubWhere;
      }

    public boolean Validate(ParserSession PS, Base ParentObject, String OwnerObjName)
      {
        int Errs = PS.getErrorCount();

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Clause) == true)
          return PS.AddError(OwnerObjName + " is defining an subWhereclause without a query value.");

        if (TextUtil.CrudeStringValidation(_Clause, '\'', '\'') == false)
          PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which has an unterminated string sequence.");
        
        StringBuilder NewClause = new StringBuilder();
        int i = 0;
        
//        Set<String> VarNames = new HashSet<String>();
//        LOG.debug("    input clause: "+_Clause+";");
        Matcher M = _P1.matcher(_Clause);
        while (M.find() == true)
          {
            if (M.start() != i)
             NewClause.append(_Clause, i, M.start());
            String col = M.group(1);
            String var = M.group(2);
//            LOG.debug("       match: "+M.group()+"; col: "+col+"; var: "+var+";");
            ReferenceHelper R = ReferenceHelper.parseColumnReference(col, ParentObject);
            Column C = PS.getColumn(R._P, R._S, R._O, R._C);
            if (C == null)
              {
                PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to an unknown column '"+col+"'.");
                continue;
              }
            if (C.hasBeenValidatedSuccessfully() == false)
              {
                PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to column '" + C.getShortName() + "' which has failed validation previously and cannot be processed any more.");
                continue;
              }
            if (C.isCollection() == true)
              {
                PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to an array column, which is not supported.");
                continue;
              }
            if (C._Type == ColumnType.BINARY || C._Type == ColumnType.BITFIELD)
              {
                PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to a "+C._Type+" column which is not a supported type.");
                continue;
              }
            if (var != null && var.matches("\\s*is\\s+(not\\s+)?null\\s*") == false)
              {
                Matcher M2 = _P2.matcher(var);
                if (M2.find() == false)
                 {
                   PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which has a column espression '" + var + "' which cannot be parsed out.");
                   continue;
                 }
                var = M2.group(1);
                if (TextUtil.isNullOrEmpty(var) == true)
                 var = col;
                else
                 var = col+TextUtil.CapitalizeFirstCharacter(var);
//                if (VarNames.add(var) == false)
//                 var = "*"+var;
//                  {
//                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' with a duplicate variable name '"+var+"'.");
//                    continue;
//                  }
//                LOG.debug("       --> var: "+var+";");
                _ColumnObjs.add(C);
                _VarNames.add(var);
              }
            NewClause.append(PS._CGSql.getFullColumnVar(C)).append(_Clause, M.end(1), M.end());
            i = M.end();
          }
        NewClause.append(_Clause, i, _Clause.length());
        _Clause = NewClause.toString();

        if (TextUtil.isNullOrEmpty(_DB) == true)
         _DB = "*";

        if (_DB.equals("*") == false)
          {
            boolean Found = false;
            for (DBType t : DBType._DBTypes)
              if (t.getName().equalsIgnoreCase(_DB) == true)
                {
                  Found = true;
                  break;
                }
            if (Found == false)
              PS.AddError(OwnerObjName + " is defining a subWhereclause with a DB value '" + _DB + "' which cannot be matched to an active DBType.");
          }
        
        _Clause = _Clause.replaceAll(_P2.pattern(), "?");
        
//        LOG.debug("    final clause: "+_Clause+";");

        return Errs == PS.getErrorCount();
      }
  }
