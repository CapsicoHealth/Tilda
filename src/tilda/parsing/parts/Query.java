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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.db.stores.DBType;
import tilda.enums.ColumnType;
import tilda.generation.java8.Helper;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class Query
  {
    protected static final Logger LOG = LogManager.getLogger(Query.class.getName());

    /*@formatter:off*/
    @SerializedName("db"    ) public String   _DB    ;
    @SerializedName("clause") public String   _Clause;
    /*@formatter:on*/

    public static class Attribute
      {
        public Attribute(Column Col, String VarName, boolean Multi)
          {
            _Col = Col;
            _VarName = VarName;
            _Multi = Multi;
          }

        public final Column  _Col;
        public final String  _VarName;
        public final boolean _Multi;
      }

    public transient List<Attribute> _Attributes = new ArrayList<Attribute>();
    public transient String _ClauseDynamic;

    public Query()
      {
      }

    public Query(String _SubWhere)
      {
        _Clause = _SubWhere;
      }


    protected static class Match
      {
        public Match(int start, int end, String name, char type)
          {
            _start = start;
            _end = end;
            _name = name;
            _type = type;
          }

        public final int    _start;
        public final int    _end;
        public final String _name;
        public final char   _type;

        public static void add(List<Match> L, int start, int end, String name, char type)
          {
            int i = 0;
            Match M = new Match(start, end, name, type);
            while (i < L.size())
              {
                Match m = L.get(i);
                if (m._start > M._start)
                  {
                    L.add(i, M);
                    return;
                  }
                ++i;
              }
            L.add(M);
          }
      }

    private static final Pattern _ParamPattern    = Pattern.compile("\\?\\(([a-z_A-Z]\\w*)?\\)");
    private static final Pattern _ArrayPattern    = Pattern.compile("\\?\\[([a-z_A-Z]\\w*)?\\]");
    private static final Pattern _ComplexColRegex = Pattern.compile("\\b([a-zA-Z]\\w+(\\.[a-zA-Z]\\w+)+)\\b");

    public boolean Validate(ParserSession PS, Base ParentObject, String OwnerObjName)
      {
        int Errs = PS.getErrorCount();

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Clause) == true)
          return PS.AddError(OwnerObjName + " is defining an subWhereclause without a query value.");

        if (TextUtil.CrudeStringValidation(_Clause, '\'', '\'') == false)
          PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which has an unterminated string sequence.");

        // LOG.debug("Start clause: "+_Clause+";");

        List<Match> Matches = new ArrayList<Match>();
        Matcher M = _ParamPattern.matcher(_Clause);
        while (M.find() == true)
          Match.add(Matches, M.start(), M.end(), M.group(1), 'P');

        M = _ArrayPattern.matcher(_Clause);
        while (M.find() == true)
          Match.add(Matches, M.start(), M.end(), M.group(1), 'A');

        M = _ComplexColRegex.matcher(_Clause);
        while (M.find() == true)
          {
            if (_Clause.substring(0, M.start()).toLowerCase().matches(".*\\s*from\\s*") == false && _Clause.substring(M.end()).matches("\\s*\\(.*") == false)
              Match.add(Matches, M.start(), M.end(), M.group(1), 'C');
          }

        StringBuilder ColsRegex = new StringBuilder("\\b(");
        boolean First = true;
        String[] ColumnNames = ParentObject.getColumnNames();
        for (String colName : ColumnNames)
          {
            if (First == true)
              First = false;
            else
              ColsRegex.append("|");
            ColsRegex.append(colName);
          }
        ColsRegex.append(")\\b");
        // LOG.debug(ColsRegex);
        M = Pattern.compile(ColsRegex.toString()).matcher(_Clause);
        while (M.find() == true)
          {
            int i = M.start();
            if (i == 0 || _Clause.charAt(i - 1) != '.')
              Match.add(Matches, M.start(), M.end(), M.group(1), 'C');
          }

        // for (Match m : Matches)
        // {
        // LOG.debug(" "+m._type+": "+m._name+" ("+m._start+"-"+m._end+")");
        // }

        StringBuilder NewClauseStatic  = new StringBuilder();
        StringBuilder NewClauseDynamic = new StringBuilder();
        int clauseStrIndex = 0;
        Column lastColumnMatch = null;
        for (int i = 0; i < Matches.size(); ++i)
          {
            Match m = Matches.get(i);
            if (clauseStrIndex <  m._start)
             {
               NewClauseStatic .append(_Clause, clauseStrIndex, m._start);
               String Sub = TextUtil.EscapeDoubleQuoteWithSlash(_Clause.substring(clauseStrIndex, m._start));
               if (clauseStrIndex == 0)
                NewClauseDynamic.append(Sub.substring(1, Sub.length()-1));
               else
                NewClauseDynamic.append(Sub);
             }
            if (m._type == 'P' || m._type == 'A')
              {
                if (lastColumnMatch == null)
                  {
                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which has a parameter marker '?(" + m._name + ")' without any previously stated column.");
                    break;
                  }
                NewClauseStatic.append("?");
                NewClauseDynamic.append(").append(\"?\").append(");
                String var = m._name;
                if (TextUtil.FindElement(ColumnNames, var, false, 0) != -1)
                  {
                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which has a parameter marker '?(" + m._name + ")' which is already taken as a column name.");
                    break;
                  }

                if (TextUtil.isNullOrEmpty(var) == true)
                  var = lastColumnMatch.getName();
                else
                  var = lastColumnMatch.getName() + TextUtil.CapitalizeFirstCharacter(var);
                _Attributes.add(new Attribute(lastColumnMatch, var, m._type == 'A'));
              }
            else if (m._type == 'C')
              {
                ReferenceHelper R = ReferenceHelper.parseColumnReference(m._name, ParentObject);
                Column C = PS.getColumn(R._P, R._S, R._O, R._C);
                if (C == null)
                  {
                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to an unknown column '" + m._name + "'.");
                    continue;
                  }
                if (C.hasBeenValidatedSuccessfully() == false)
                  {
                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to column '" + C.getShortName() + "' which has failed validation previously and cannot be processed any more.");
                    continue;
                  }
                // if (C.isCollection() == true)
                // {
                // PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to an array column, which is not supported.");
                // continue;
                // }
                if (C._Type == ColumnType.BINARY || C._Type == ColumnType.BITFIELD)
                  {
                    PS.AddError(OwnerObjName + " is defining a subWhereclause '" + _Clause + "' which refers to a " + C._Type + " column which is not a supported type.");
                    continue;
                  }
                lastColumnMatch = C;
                NewClauseStatic.append(PS._CGSql.getFullColumnVar(C));
                NewClauseDynamic.append(clauseStrIndex==0?"\"); " : "); ").append(Helper.getFullColVarAtRuntime(C)).append("; S.append(");
              }
            clauseStrIndex = m._end;
          }
        if (clauseStrIndex < _Clause.length())
          {
            NewClauseStatic .append(_Clause, clauseStrIndex, _Clause.length());
            String Sub = TextUtil.EscapeDoubleQuoteWithSlash(_Clause.substring(clauseStrIndex, _Clause.length()));
            NewClauseDynamic.append(Sub.substring(clauseStrIndex == 0 ? 1 : 0, Sub.length()-1));
          }
        
        _Clause = NewClauseStatic.toString();
        _ClauseDynamic = NewClauseDynamic.toString();
        
        if (_ClauseDynamic.endsWith(".append(") == true)
          {
            _ClauseDynamic+="\"";
          }

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

        return Errs == PS.getErrorCount();
      }

    public static Query getQuery(Query[] Querries, DBType Db)
      {
        if (Querries == null)
          return null;

        Query Default = null;
        for (Query q : Querries)
          {
            if (q._DB.equalsIgnoreCase(Db.getName()) == true)
              return q;
            else if (q._DB.equals("*") == true)
              Default = q;
          }

        if (Default == null)
          {
            StringBuilder Str = new StringBuilder();
            for (Query q : Querries)
              Str.append(Str.length() == 0 ? "" : ", ").append(q._DB);
            LOG.error("Cannot find a query for DB '"+Db.getName()+"'. Only choices available were "+Str.toString()+".");
          }
        
        return Default;
      }
  }
