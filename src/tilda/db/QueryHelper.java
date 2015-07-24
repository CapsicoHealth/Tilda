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

package tilda.db;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Iterator;

import tilda.enums.ColumnDefinition;
import tilda.enums.StatementType;
import tilda.utils.DateTimeUtil;
import tilda.utils.TextUtil;

/**
 * <B>LDH-NOTE</B>
 * This class helps build queries more safely, but it's not a compile-time tool. Therefore, there is no point
 * in trying to catch syntax errors as the database will do that plenty fine.<BR>
 * It's tempting to add extra features to catch mismatched parentheses, checking there is no duplicate
 * table names in the From clause. The only thing that was interesting is that using operators in the SET part
 * of a select or update causes weird things. For example, select a=3 evaluates as a boolean expression which
 * i find weird, so i check for it. Other than that, nothing except major issues like
 * 
 * @author ldh
 *
 */
public abstract class QueryHelper
  {
    protected QueryHelper(Connection C, StatementType ST, String TableName)
      throws Exception
      {
        _TableName = TableName;
        _C = C;
        _ST = ST;

        _Section = S.START;
        
        if (_ST == StatementType.SELECT)
         {
           if (C != null)
            _QueryStr.append("select ");
           else
            _Section = S.WHERE;
         }
        else if (_ST == StatementType.UPDATE)
          _QueryStr.append("update ").append(_TableName).append(" set ");
        else if (_ST == StatementType.DELETE)
          {
            _QueryStr.append("delete from ").append(_TableName).append(" ");
            _Section = S.FROM;
          }
        else
          throw new Exception("Unsupported Statement Type '" + ST + "' for the QueryHelper.");
      }

    public void setConnection(Connection C)
      {
        _C = C;
      }

    protected static enum S
      {
        START, FROM, SET, WHERE;
      }

    protected final String        _TableName;
    protected final StatementType _ST;

    protected Connection          _C;
    protected StringBuilder       _QueryStr = new StringBuilder();
    protected S                   _Section  = null;


    protected final void valuesBase()
      throws Exception
      {
        if (_Section != S.SET || _ST != StatementType.INSERT)
          throw new Exception("Invalid query syntax: Calling values() after a " + _Section + " in a query of type " + _ST);
        _QueryStr.append(") values (");
      }

    protected final void setColumn(ColumnDefinition Col)
      throws Exception
      {
        if (_Section != S.START && _Section != S.SET)
          throw new Exception("Invalid query syntax: Calling set() after a " + _Section);
        if (_Section == S.SET)
          _QueryStr.append(", ");
        _QueryStr.append(Col.toString(_ST));
        _Section = S.SET;
      }

    protected final void fromTable(String TableName)
      throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Calling from() with '" + TableName + "' after a " + _Section + " in a query of type " + _ST);
        if (_Section != S.FROM)
          _QueryStr.append(" from ").append(_TableName);
        if (TableName.equalsIgnoreCase(_TableName) == false)
          _QueryStr.append(", ").append(TableName);
        _Section = S.FROM;
      }

    public final QueryHelper where(ColumnDefinition Col)
      throws Exception
      {
        where();
        _QueryStr.append(Col.toString(_ST));
        return this;
      }

    public final QueryHelper where()
      throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET)
          throw new Exception("Invalid query syntax: Calling where() after a " + _Section);
        if (_Section != S.WHERE)
          {
            if (_Section != S.FROM && _ST == StatementType.SELECT)
              _QueryStr.append("from ").append(_TableName);
            _QueryStr.append(" where ");
          }
        _Section = S.WHERE;
        return this;
     }


    public final QueryHelper and()
        throws Exception
        {
          if (_Section != S.WHERE)
            throw new Exception("Invalid query syntax: Calling and() after a " + _Section);
          _QueryStr.append(" and ");
          _Section = S.WHERE;
          return this;
        }

    public final QueryHelper and(ColumnDefinition Col)
      throws Exception
      {
        and();
        _QueryStr.append(Col.toString(_ST));
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper or()
        throws Exception
        {
          if (_Section != S.WHERE)
            throw new Exception("Invalid query syntax: Calling and() after a " + _Section);
          _QueryStr.append(" or ");
          _Section = S.WHERE;
          return this;
        }

    public final QueryHelper or(ColumnDefinition Col)
      throws Exception
      {
        or();
        _QueryStr.append(Col.toString(_ST));
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper openPar()
      throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling openPar() after a " + _Section);
        _QueryStr.append(" (");
        _Section = S.WHERE;
        return this;
      }
    
    public QueryHelper openPar(ColumnDefinition Col)
        throws Exception
        {
          openPar();
          _QueryStr.append(Col.toString(_ST));
          return this;
        }

    public final QueryHelper closePar()
      throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling closePar() after a " + _Section + " (Outside of a where clause).");
        _QueryStr.append(" )");
        _Section = S.WHERE;
        return this;
      }


    protected final void OpCol(Op O, ColumnDefinition Col)
      throws Exception
      {
        if (_Section != S.SET && _Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling equals() after a " + _Section);
        _QueryStr.append(O._Str).append(Col.toString(_ST));
      }

    public static enum Op
      {
        EQUALS(" = ")
        , LT(" < ")
        , LTE(" <= ")
        , GT(" > ")
        , GTE(" >= ")
        , NOT_EQUALS(" <> ")
        , PLUS(" + ")
        , MINUS(" - ")
        , MULTIPLY(" * ")
        , DIVIDE(" / ")
        , LIKE(" like ");

        Op(String Str)
          {
            _Str = Str;
          }

        public final String _Str;
      }

    protected final void OpVal(Op O, String V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str);
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, boolean V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, double V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, float V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, int V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, long V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET) || _ST == StatementType.DELETE && _Section == S.WHERE)
          {
            _QueryStr.append(O._Str).append(V);
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, char V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append('\'').append(V).append('\'');
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    protected final void OpVal(Op O, ZonedDateTime V)
      throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            if (DateTimeUtil.isNowPlaceholder(V) == true)
              _QueryStr.append(O._Str).append(_C.getCurrentTimestampStr());
            else if (V == null)
              {
                if (_Section == S.WHERE)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append("IS NULL");
                    else if (O != Op.NOT_EQUALS)
                      _QueryStr.append("IS NOT NULL");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value");
                  }
                else
                  _QueryStr.append("= NULL");
              }
            else
              {
                _QueryStr.append(O._Str).append("'").append(DateTimeUtil.printDateTimeForSQL(V)).append("'");
              }
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
    }
    
    public QueryHelper in(String[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }
    
    public QueryHelper in(Collection<String> v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             {
               Iterator<String> I = v.iterator();
               boolean first = true;
               while (I.hasNext() == true)
                {
                  if (first == true) first = false; else _QueryStr.append(", ");
                  TextUtil.EscapeSingleQuoteForSQL(_QueryStr, I.next());
                }
             }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }
    

    public QueryHelper in(char[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 TextUtil.EscapeSingleQuoteForSQL(_QueryStr, ""+v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }
    
    public QueryHelper in(int[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 _QueryStr.append(v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }

    public QueryHelper in(long[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 _QueryStr.append(v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }

    public QueryHelper in(float[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 _QueryStr.append(v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }
    
    public QueryHelper in(double[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
             for (int i = 0; i < v.length; ++i)
               {
                 if (i != 0)
                   _QueryStr.append(", ");
                 _QueryStr.append(v[i]);
               }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST);
      }

    public QueryHelper in(ZonedDateTime[] v) throws Exception
      {
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(" in (");
            if (v != null)
              for (int i = 0; i < v.length; ++i)
                {
                  if (i != 0)
                    _QueryStr.append(", ");
                  if (DateTimeUtil.isNowPlaceholder(v[i]) == true)
                    _QueryStr.append(_C.getCurrentTimestampStr());
                  else if (v[i] != null)
                    _QueryStr.append("ULL");
                  else
                    _QueryStr.append("'").append(DateTimeUtil.printDateTimeForSQL(v[i])).append("'");
                }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST);
      }

    public String getWhereClause() throws Exception
      {
        if (_ST == StatementType.SELECT && _C == null)
         return _QueryStr.toString();
        throw new Exception("Error: Calling getWhereClause() on non 'where clause' QueryHelper object (constructed as a SELECT with a null Connection).");
      }

    public QueryHelper values()
      throws Exception
      {
        valuesBase();
        return this;
      }

    public QueryHelper set(ColumnDefinition Col)
      throws Exception
      {
        setColumn(Col);
        return this;
      }

    public QueryHelper from(String Table)
      throws Exception
      {
        fromTable(Table);
        return this;
      }

    public QueryHelper equals(ColumnDefinition Col)
        throws Exception
        {
          OpCol(Op.EQUALS, Col);
          return this;
        }

      public QueryHelper equals(String V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(char V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(boolean V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(int V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(long V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(float V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(double V)
        throws Exception
        {
          OpVal(Op.EQUALS, V);
          return this;
        }

      public QueryHelper equals(ZonedDateTime ZDT)
        throws Exception
        {
          OpVal(Op.EQUALS, ZDT);
          return this;
        }
    

    public QueryHelper lt(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.LT, Col);
        return this;
      }

    public QueryHelper lt(String V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(char V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(boolean V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(int V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(long V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(float V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(double V)
      throws Exception
      {
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.LT, ZDT);
        return this;
      }

    public QueryHelper lte(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.LTE, Col);
        return this;
      }

    public QueryHelper lte(String V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(char V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(boolean V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(int V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(long V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(float V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(double V)
      throws Exception
      {
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.LTE, ZDT);
        return this;
      }

    public QueryHelper gt(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.GT, Col);
        return this;
      }

    public QueryHelper gt(String V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(char V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(boolean V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(int V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(long V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(float V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(double V)
      throws Exception
      {
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.GT, ZDT);
        return this;
      }

    public QueryHelper gte(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.GTE, Col);
        return this;
      }

    public QueryHelper gte(String V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(char V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(boolean V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(int V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(long V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(float V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(double V)
      throws Exception
      {
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.GTE, ZDT);
        return this;
      }

    public QueryHelper not_equals(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.NOT_EQUALS, Col);
        return this;
      }

    public QueryHelper not_equals(String V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(char V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(boolean V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(int V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(long V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(float V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(double V)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.NOT_EQUALS, ZDT);
        return this;
      }
    
    public QueryHelper isNull() throws Exception
     {
       OpVal(Op.EQUALS, (String) null);
       return this;
     }

    public QueryHelper isNotNull() throws Exception
      {
        OpVal(Op.NOT_EQUALS, (String) null);
        return this;
      }

    public QueryHelper plus(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.PLUS, Col);
        return this;
      }

    public QueryHelper plus(String V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(char V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(boolean V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(int V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(long V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(float V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(double V)
      throws Exception
      {
        OpVal(Op.PLUS, V);
        return this;
      }

    public QueryHelper plus(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.PLUS, ZDT);
        return this;
      }

    public QueryHelper minus(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.MINUS, Col);
        return this;
      }

    public QueryHelper minus(String V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(char V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(boolean V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(int V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(long V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(float V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(double V)
      throws Exception
      {
        OpVal(Op.MINUS, V);
        return this;
      }

    public QueryHelper minus(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.MINUS, ZDT);
        return this;
      }

    public QueryHelper multiply(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.MULTIPLY, Col);
        return this;
      }

    public QueryHelper multiply(String V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(char V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(boolean V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(int V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(long V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(float V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(double V)
      throws Exception
      {
        OpVal(Op.MULTIPLY, V);
        return this;
      }

    public QueryHelper multiply(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.MULTIPLY, ZDT);
        return this;
      }

    public QueryHelper divide(ColumnDefinition Col)
      throws Exception
      {
        OpCol(Op.DIVIDE, Col);
        return this;
      }

    public QueryHelper divide(String V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(char V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(boolean V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(int V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(long V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(float V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(double V)
      throws Exception
      {
        OpVal(Op.DIVIDE, V);
        return this;
      }

    public QueryHelper divide(ZonedDateTime ZDT)
      throws Exception
      {
        OpVal(Op.DIVIDE, ZDT);
        return this;
      }

    public QueryHelper like(String V)
        throws Exception
        {
          OpVal(Op.LIKE, V);
          return this;
        }
    public QueryHelper like(ColumnDefinition Col, String V)
        throws Exception
        {
          _QueryStr.append(Col.toString(_ST));
          OpVal(Op.LIKE, V);
          return this;
        }

    public QueryHelper like(ColumnDefinition Col, String[] Vals) throws Exception
      {
        if (Vals == null)
         return this;
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true) First = false; else or();
            like(Col, v);
          }
        return this;
      }

    public QueryHelper any(ColumnDefinition Col, String V)
      {
        TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V);
        _QueryStr.append(" any ").append(Col.toString(_ST));
        return this;
      }

    public QueryHelper any(ColumnDefinition Col, String[] Vals)
      {
        if (Vals == null)
          return this;
        _QueryStr.append(Col.toString(_ST))
                 .append(" && ARRAY[");
         boolean First = true;
         for (String v : Vals)
           {
             if (First == true) First = false; else _QueryStr.append(", ");
             TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v);
           }
         _QueryStr.append("]");
         return this;
      }
  }
