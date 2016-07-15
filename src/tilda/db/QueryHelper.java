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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import tilda.types.*;
import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.StatementType;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;
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
    protected QueryHelper(Connection C, StatementType ST, String SchemaName, String TableName, boolean fullSelect)
      throws Exception
      {
        if (C == null)
         throw new Exception("Cannot create a QueryHelper with a NULL connection.");
        
        if (fullSelect == false && ST != StatementType.SELECT)
         throw new Exception("Cannot create a 'fullSelect' QueryHelper for a StatementType '"+ST.name()+"'.");
        
        _SchemaName = SchemaName;
        _TableName  = TableName;
        _C = C;
        _ST = ST;
        _FullSelect = fullSelect;
        _Section = S.START;

        if (_ST == StatementType.SELECT)
          {
            if (fullSelect == true)
              _QueryStr.append("select ");
            else
              {
                _Section = S.FROM;
                _WherePos = 0;
              }
          }
        else if (_ST == StatementType.UPDATE)
          {
            _QueryStr.append("update ");
            C.getFullTableVar(_QueryStr, SchemaName, TableName);
            _QueryStr.append(" set ");

          }
        else if (_ST == StatementType.DELETE)
          {
            _QueryStr.append("delete from ");
            C.getFullTableVar(_QueryStr, SchemaName, TableName);
            _QueryStr.append(" ");
           _Section = S.FROM;
          }
        else
          throw new Exception("Unsupported Statement Type '" + ST + "' for the QueryHelper: "+_QueryStr.toString());
      }

    protected static enum S
      {
        START, FROM, SET, WHERE, GROUPBY, ORDERBY;
      }

    protected final String        _SchemaName;
    protected final String        _TableName;
    protected final StatementType _ST;
    protected boolean             _FullSelect;
    protected Connection          _C;
    
    protected StringBuilder       _QueryStr    = new StringBuilder();
    protected S                   _Section     = null;
    protected boolean             _Where       = false;
    protected int                 _WherePos    = -1;
    protected int                 _Cardinality = 0;
    List<ColumnDefinition>        _Columns = new ArrayList<ColumnDefinition>();
    protected int                 _SubSelectCount = 0;

    public int getCardinality()
      {
        return _Cardinality;
      }
    
    public Iterator<ColumnDefinition> getColumns()
     {
       return _Columns.iterator();
     }


    protected final void valuesBase()
    throws Exception
      {
        if (_Section != S.SET || _ST != StatementType.INSERT)
          throw new Exception("Invalid query syntax: Calling values() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        _QueryStr.append(") values (");
      }

    protected final QueryHelper selectColumnBase(String ColStr)
    throws Exception
      {
        if (_Section != S.START && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Listing a column in a Select clause after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        if (_Section == S.SET)
          _QueryStr.append(", ");
        _QueryStr.append(ColStr);
        ++_Cardinality;
        _Section = S.SET;
        return this;
      }

    public final QueryHelper selectColumn(ColumnDefinition Col)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Col.getFullColumnVarForSelect(_C, Str);
        return selectColumnBase(Str.toString());
      }

    public final QueryHelper selectDistinctColumn(ColumnDefinition Col)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Str.append("distinct(");
        Col.getFullColumnVarForSelect(_C, Str);
        Str.append(")");
        return selectColumnBase(Str.toString());
      }

    public final QueryHelper selectCountStar()
    throws Exception
      {
        _Columns.add(new ColumnDefinition(_SchemaName, _TableName, "count", 0, ColumnType.LONG, false, ""));
        return selectColumnBase("count(*)");
      }
    
    public final QueryHelper selectColumn(ColumnDefinition Col, AggregateType Agg, String Alias)
    throws Exception
      {
        _Columns.add(Col);
        StringBuilder Str = new StringBuilder();
        Str.append(_C.getAggregateStr(Agg)).append("(");
        Col.getFullColumnVarForSelect(_C, Str);
        Str.append(") as \"").append(Alias).append("\"");
        return selectColumnBase(Str.toString());
      }
    
    public final QueryHelper selectColumn(int TableId, String ColumnName, AggregateType Agg, String AliasName)
    throws Exception
     {
       return selectColumnBase(_C.getAggregateStr(Agg)+"(T"+TableId+".\""+ColumnName+"\") as \""+AliasName+"\"");
     }

    protected final QueryHelper fromTable(String SchemaName, String TableName)
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Calling from() with '" + TableName + "' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        if (_Section != S.FROM)
          {
            _QueryStr.append(" from ");
            _C.getFullTableVar(_QueryStr, _SchemaName, _TableName);
          }
        if (TableName.equalsIgnoreCase(_TableName) == false)
          {
            _QueryStr.append(_Section == S.FROM || _TableName != null? ", " : "");
            _C.getFullTableVar(_QueryStr, SchemaName, TableName);
          }
        _Section = S.FROM;
        return this;
      }
    
    protected final QueryHelper fromSubSelect(SelectQuery FullSelect)
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: Calling from() with a subselect after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        if (_Section != S.FROM)
          {
            _QueryStr.append(" from ");
            _C.getFullTableVar(_QueryStr, _SchemaName, _TableName);
          }
         _QueryStr.append(_Section == S.FROM || _TableName != null? ", (" : " (").append(FullSelect._QueryStr).append(") as T").append(++_SubSelectCount);
        _Section = S.FROM;
        return this;
      }
    
    
    public final QueryHelper where()
    throws Exception
      {
        if (_Section != S.FROM && _Section != S.SET)
          throw new Exception("Invalid query syntax: Calling where() after a " + _Section + ": "+_QueryStr.toString());
        if (_Section != S.WHERE)
          {
            if (_Section != S.FROM && _ST == StatementType.SELECT)
             {
               _QueryStr.append(" from ");
               _C.getFullTableVar(_QueryStr, _SchemaName, _TableName);
             }
            _QueryStr.append(" where ");
            _WherePos = _QueryStr.length();
          }
        _Section = S.WHERE;
        _Where = true;
        return this;
      }


    public QueryHelper subWhere(SelectQuery subWhere)
      {
        _QueryStr.append(subWhere.toString());
        return this;
      }

    /**
     * Validates the subWhereClause against the TildaSQL parser and if it passes, adds it to the
     * current query object, in parenthesis as to be cohesive with the rest of the query.
     * @param subWhereClause
     * @return
     * @throws Exception
     */
    public QueryHelper subWhere(String subWhereClause) throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling subWhere() after a " + _Section + ": "+_QueryStr.toString());

        TildaSQLValidator Validator = new TildaSQLValidator(subWhereClause);
        if (Validator.getParserSyntaxErrors() != 0)
          throw new Exception("SubWhereClause '"+subWhereClause+"' had " + Validator.getParserSyntaxErrors() + " syntax error(s).");
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            StringBuilder Str = new StringBuilder();
            int i = 0;
            while (I.hasNext() == true)
              {
                Str.append("        ").append(I.next()).append("\n");
                ++i;
              }
            throw new Exception("SubWhereClause '"+subWhereClause+"' had "+i+" validation error(s):\n"+Str.toString());
          }
        this._QueryStr.append("(").append(subWhereClause).append(")");
        return this;
      }    
    
    public final QueryHelper and()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling and() after a " + _Section + ": "+_QueryStr.toString());
        if (_QueryStr.length() != _WherePos)
          _QueryStr.append(" and ");
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper or()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling and() after a " + _Section + ": "+_QueryStr.toString());
        if (_QueryStr.length() != _WherePos)
          _QueryStr.append(" or ");
        _Section = S.WHERE;
        return this;
      }

    public final QueryHelper openPar()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.FROM)
          throw new Exception("Invalid query syntax: Calling openPar() after a " + _Section + ": "+_QueryStr.toString());
        _QueryStr.append(" (");
        _Section = S.WHERE;
        _WherePos = _QueryStr.length();
        return this;
      }

    public final QueryHelper closePar()
    throws Exception
      {
        if (_Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling closePar() after a " + _Section + " (Outside of a where clause): "+_QueryStr.toString());
        _QueryStr.append(" )");
        _Section = S.WHERE;
        return this;
      }

    protected final void OpCol(Op O, ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.SET && _Section != S.WHERE)
          throw new Exception("Invalid query syntax: Calling equals() after a " + _Section + ": "+_QueryStr.toString());
        _QueryStr.append(O._Str);
        if (_ST == StatementType.SELECT)
         Col.getFullColumnVarForSelect(_C, _QueryStr);
        else
         Col.getShortColumnVarForSelect(_C, _QueryStr);
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
        if (   _ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM)
            || _ST == StatementType.DELETE && (_Section == S.WHERE || _Section == S.FROM)
            || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET)
           )
          {
            if (V == null)
              {
                if (_Section == S.WHERE || _Section == S.FROM)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append(" IS NULL ");
                    else if (O == Op.NOT_EQUALS)
                      _QueryStr.append(" IS NOT NULL ");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value: "+_QueryStr.toString());
                  }
                else
                  _QueryStr.append(" = NULL ");
              }
            else
              {
                _QueryStr.append(O._Str);
                TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V);
              }
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, boolean V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, double V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, float V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, int V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append(V);
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, long V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET) || _ST == StatementType.DELETE && _Section == S.WHERE)
          {
            _QueryStr.append(O._Str).append(V);
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, char V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(O._Str).append('\'').append(V).append('\'');
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    protected final void OpVal(Op O, ZonedDateTime V)
    throws Exception
      {
        if (_ST == StatementType.SELECT && (_Section == S.WHERE || _Section == S.FROM) || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            if (DateTimeUtil.isNowPlaceholder(V) == true)
              _QueryStr.append(O._Str).append(_C.getCurrentTimestampStr());
            else if (V == null)
              {
                if (_Section == S.WHERE || _Section == S.FROM)
                  {
                    if (O == Op.EQUALS)
                      _QueryStr.append(" IS NULL ");
                    else if (O == Op.NOT_EQUALS)
                      _QueryStr.append(" IS NOT NULL ");
                    else
                      throw new Exception("Invalid query syntax: cannot use the operator " + O + " with a NULL value: "+_QueryStr.toString());
                  }
                else
                  _QueryStr.append(" = NULL ");
              }
            else
              {
                _QueryStr.append(O._Str).append("'").append(DateTimeUtil.printDateTimeForSQL(V)).append("'");
              }
            _Section = S.WHERE;
          }
        else
          throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }


    public String getWhereClause()
    throws Exception
      {
        if (_ST == StatementType.SELECT && _FullSelect == false)
         {
           String Str = _QueryStr.toString();
           if (_Where == false)
            Str = " where "+Str;
           return Str;
         }
        throw new Exception("Error: Calling getWhereClause() on non 'where clause' QueryHelper object (constructed as a SELECT with a null Connection): "+_QueryStr.toString());
      }

    public QueryHelper values()
    throws Exception
      {
        valuesBase();
        return this;
      }

    public QueryHelper from(String SchemaName, String TableName)
    throws Exception
      {
        fromTable(SchemaName, TableName);
        return this;
      }

    public QueryHelper from(SelectQuery Q)
    throws Exception
      {
        fromSubSelect(Q);
        return this;
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SETTERS
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected final void setColumn(ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.START && _Section != S.SET || _ST != StatementType.UPDATE)
          throw new Exception("Invalid query syntax: Calling set() after a " + _Section + ": "+_QueryStr.toString());
        if (_Section == S.SET)
          _QueryStr.append(", ");
        Col.getShortColumnVarForSelect(_C, _QueryStr);
        _Section = S.SET;
      }

    public QueryHelper set(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_LongPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        setColumn(Col1);
        return equals(Col2);
      }

    public QueryHelper set(Type_StringPrimitive Col1, String V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_CharPrimitive Col1, char V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_BooleanPrimitive Col1, boolean V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_IntegerPrimitive Col1, int V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_LongPrimitive Col1, long V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_FloatPrimitive Col1, float V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_DoublePrimitive Col1, double V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }

    public QueryHelper set(Type_DatetimePrimitive Col1, ZonedDateTime V)
    throws Exception
      {
        setColumn(Col1);
        return equals(V);
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IN
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper in(Type_StringPrimitive Col, String[] V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V, true);
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }
    public QueryHelper in(Type_StringPrimitive Col, Collection<String> V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V, true);
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }
    
    public QueryHelper in(Type_StringCollection Col, String[] V)
    throws Exception
      {
        _QueryStr.append(" TILDA.In(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ARRAY[");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V, true);
            _QueryStr.append("])");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }
    public QueryHelper in(Type_StringCollection Col, Collection<String> V)
    throws Exception
      {
        _QueryStr.append(" TILDA.In(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ARRAY[");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V, true);
            _QueryStr.append("])");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }
    

    public QueryHelper in(Type_CharPrimitive Col, char[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            if (v != null)
              for (int i = 0; i < v.length; ++i)
                {
                  if (i != 0)
                    _QueryStr.append(", ");
                  TextUtil.EscapeSingleQuoteForSQL(_QueryStr, "" + v[i]);
                }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_IntegerPrimitive Col, int[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
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
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_LongPrimitive Col, long[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
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
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_FloatPrimitive Col, float[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
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
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_DoublePrimitive Col, double[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
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
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_DatetimePrimitive Col, ZonedDateTime[] v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            if (v != null)
              for (int i = 0; i < v.length; ++i)
                {
                  if (i != 0)
                    _QueryStr.append(", ");
                  if (DateTimeUtil.isNowPlaceholder(v[i]) == true)
                    _QueryStr.append(_C.getCurrentTimestampStr());
                  else if (v[i] == null)
                    _QueryStr.append("NULL");
                  else
                    _QueryStr.append("'").append(DateTimeUtil.printDateTimeForSQL(v[i])).append("'");
                }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling an operator() after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(Type_DatetimePrimitive Col, Collection<ZonedDateTime> v)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            if (v != null)
              {
                Iterator<ZonedDateTime> I = v.iterator();
                boolean first = true;
                while (I.hasNext() == true)
                  {
                    if (first == true)
                      first = false;
                    else
                      _QueryStr.append(", ");
                    ZonedDateTime val = I.next();
                    if (DateTimeUtil.isNowPlaceholder(val) == true)
                      _QueryStr.append(_C.getCurrentTimestampStr());
                    else if (val == null)
                      _QueryStr.append("NULL");
                    else
                      _QueryStr.append("'").append(DateTimeUtil.printDateTimeForSQL(val)).append("'");
                  }
              }
            _QueryStr.append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }

    public QueryHelper in(ColumnDefinition Col, SelectQuery Q)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" in (");
        if (Q._Cardinality != 1)
          throw new Exception("Invalid query syntax: Calling the operator 'in' with a subquery that has a column cardinality " + Q._Cardinality + ": "+_QueryStr.toString());
        if (_ST == StatementType.SELECT && _Section == S.WHERE || _ST == StatementType.UPDATE && (_Section == S.WHERE || _Section == S.SET))
          {
            _QueryStr.append(Q._QueryStr).append(")");
            return this;
          }
        throw new Exception("Invalid query syntax: Calling the operator 'in' after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col EQUALS Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col EQUALS Col
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected QueryHelper equalsBase(ColumnDefinition Col1, ColumnDefinition Col2)
    throws Exception
      {
        Col1.getFullColumnVarForSelect(_C, _QueryStr);
        OpCol(Op.EQUALS, Col2);
        return this;
      }

    public QueryHelper equals(ColumnDefinition Col1)
    throws Exception
      {
        OpCol(Op.EQUALS, Col1);
        return this;
      }

    public QueryHelper equals(Type_StringPrimitive Col1, Type_StringPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_DatetimePrimitive Col1, Type_DatetimePrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_CharPrimitive Col1, Type_CharPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_BooleanPrimitive Col1, Type_BooleanPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_IntegerPrimitive Col1, Type_IntegerPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_LongPrimitive Col1, Type_LongPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_FloatPrimitive Col1, Type_FloatPrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }

    public QueryHelper equals(Type_DoublePrimitive Col1, Type_DoublePrimitive Col2)
    throws Exception
      {
        return equalsBase(Col1, Col2);
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col EQUALS value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper equals(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, V);
        return this;
      }

    public QueryHelper equals(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col < value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lt(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, V);
        return this;
      }

    public QueryHelper lt(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LT, ZDT);
        return this;
      }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <= value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper lte(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, V);
        return this;
      }

    public QueryHelper lte(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LTE, ZDT);
        return this;
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col > value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gt(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, V);
        return this;
      }

    public QueryHelper gt(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GT, ZDT);
        return this;
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col >= value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper gte(ColumnDefinition Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpCol(Op.GTE, Col);
        return this;
      }

    public QueryHelper gte(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, V);
        return this;
      }

    public QueryHelper gte(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.GTE, ZDT);
        return this;
      }




    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Col <> value
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper not_equals(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_CharPrimitive Col, char V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_BooleanPrimitive Col, boolean V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_IntegerPrimitive Col, int V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_LongPrimitive Col, long V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_FloatPrimitive Col, float V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_DoublePrimitive Col, double V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, V);
        return this;
      }

    public QueryHelper not_equals(Type_DatetimePrimitive Col, ZonedDateTime ZDT)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, ZDT);
        return this;
      }






    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Operators
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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







    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IS NULL and IS NOT NULL
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper isNull(Nullable Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.EQUALS, (String) null);
        return this;
      }

    public QueryHelper isNotNull(Nullable Col)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.NOT_EQUALS, (String) null);
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIKE
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper like(Type_StringPrimitive Col, String V)
    throws Exception
      {
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        OpVal(Op.LIKE, V);
        return this;
      }
    
    
    public QueryHelper like(Type_StringCollection Col, String V)
    throws Exception
      {
        _QueryStr.append(" TILDA.like(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ");
        TextUtil.EscapeSingleQuoteForSQL(_QueryStr, V);
        _QueryStr.append(")");
        return this;
      }
    
    public QueryHelper like(Type_StringCollection Col, String[] V)
    throws Exception
      {
        _QueryStr.append(" TILDA.like(");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(", ARRAY[");
        boolean First = true;
        for (String v : V)
          {
            if (First == true) First = false; else _QueryStr.append(", ");
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v);
          }
        _QueryStr.append("])");
        return this;
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String V)
    throws Exception
      {
        boolean First = true;
        for (Type_StringPrimitive c : Cols)
          {
            if (First == true)
              {
                _QueryStr.append(" lower(");
                First = false;
              }
            else
              _QueryStr.append(" || ' ' || ");
            c.getFullColumnVarForSelect(_C, _QueryStr);
          }
        if (First == false)
         _QueryStr.append(")");
         
        OpVal(Op.LIKE, V);
        return this;
      }


    public QueryHelper like(Type_StringPrimitive Col, String[] Vals, boolean Or)
    throws Exception
      {
        if (Vals == null)
          return this;
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true)
              First = false;
            else if (Or == true)
              or();
            else
              and();
            like(Col, v);
          }
        return this;
      }

    public QueryHelper like(Type_StringPrimitive[] Cols, String[] Vals, boolean Or)
    throws Exception
      {
        if (Vals == null)
          return this;
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true)
              First = false;
            else if (Or == true)
              or();
            else
              and();
            like(Cols, v);
          }
        return this;
      }



    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ANY
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public QueryHelper any(Type_StringCollection Col, String v)
      {
        TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v);
        _QueryStr.append(" any ");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        return this;
      }

    public QueryHelper any(Type_StringCollection Col, String[] Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(", ");
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v);
          }
        _QueryStr.append("]");
        return this;
      }

    public QueryHelper any(Type_StringCollection Col, Collection<String> Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(", ");
            TextUtil.EscapeSingleQuoteForSQL(_QueryStr, v);
          }
        _QueryStr.append("]");
        return this;
      }


    public QueryHelper any(Type_IntegerCollection Col, int v)
      {
        _QueryStr.append(v);
        _QueryStr.append(" any ");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        return this;
      }

    public QueryHelper any(Type_IntegerCollection Col, int[] Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (int v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(", ");
            _QueryStr.append(v);
          }
        _QueryStr.append("]");
        return this;
      }

    public QueryHelper any(Type_CharCollection Col, char v)
      {
        _QueryStr.append("'").append(v).append("'");
        _QueryStr.append(" any ");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        return this;
      }

    public QueryHelper any(Type_CharCollection Col, char[] Vals)
      {
        if (Vals == null)
          return this;
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" && ARRAY[");
        boolean First = true;
        for (int v : Vals)
          {
            if (First == true)
              First = false;
            else
              _QueryStr.append(", ");
            _QueryStr.append("'").append(v).append("'");
          }
        _QueryStr.append("]");
        return this;
      }

    public QueryHelper groupBy(ColumnDefinition Col)
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.GROUPBY || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: GroupBy after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        if (_Section == S.GROUPBY)
          _QueryStr.append(", ");
        else
          _QueryStr.append(" group by ");
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _Section = S.GROUPBY;
        return this;
      }

    protected void orderByBase()
    throws Exception
      {
        if (_Section != S.WHERE && _Section != S.GROUPBY && _Section != S.ORDERBY || _ST != StatementType.SELECT)
          throw new Exception("Invalid query syntax: OrderBy after a " + _Section + " in a query of type " + _ST + ": "+_QueryStr.toString());
        if (_Section == S.ORDERBY)
          _QueryStr.append(", ");
        else
          _QueryStr.append(" order by ");
        _Section = S.ORDERBY;
      }
    
    public QueryHelper orderBy(ColumnDefinition Col, boolean Asc)
    throws Exception
      {
        orderByBase();
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(Asc==true?" ASC":" DESC");
        return this;
      }
    
    public QueryHelper orderByCountStar(boolean Asc)
    throws Exception
      {
        orderByBase();
        _QueryStr.append("count(*)").append(Asc==true?" ASC":" DESC");
        return this;
      }
    
    
    public QueryHelper orderBy(ColumnDefinition Col, boolean Asc, boolean NullsLast)
    throws Exception
      {
        orderByBase();
        _C.setOrderByWithNullsOrdering(_QueryStr, Col, Asc, NullsLast);
        return this;
      }
    

    public QueryHelper ageBetween(Type_DatetimePrimitive Col, int[] ageRange)
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D1 = Today.minusYears(ageRange[1]);
        ZonedDateTime D2 = Today.minusYears(ageRange[0]-1).minusNanos(1);
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" BETWEEN ").append("'").append(DateTimeUtil.printDateTimeForSQL(D1)).append("'")
                 .append(" AND ").append("'").append(DateTimeUtil.printDateTimeForSQL(D2)).append("'");
        return this;
      }
    
    public QueryHelper ageGreaterThan(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return gt(Col, D);
      }
    public QueryHelper ageGreaterThanOrEqual(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return gte(Col, D);
      }
    public QueryHelper ageLessThan(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return lt(Col, D);
      }
    public QueryHelper ageLessThanOrEqual(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Today = DateTimeUtil.getTodayTimestamp(true);
        ZonedDateTime D = Today.minusYears(Age);
        return lte(Col, D);
      }
    public QueryHelper ageEquals(Type_DatetimePrimitive Col, int Age)
    throws Exception
      {
        ZonedDateTime Yesterday = DateTimeUtil.getIthDayTimestamp(true, -1);
        ZonedDateTime D1 = Yesterday.minusYears(Age-1);
        Col.getFullColumnVarForSelect(_C, _QueryStr);
        _QueryStr.append(" BETWEEN ").append("'").append(DateTimeUtil.printDateTimeForSQL(D1)).append("'")
                 .append(" AND ").append("'").append(DateTimeUtil.printDateTimeForSQL(Yesterday)).append("'");
        return this;
      }

    public String toString()
      {
        return _QueryStr.toString();
      }
  }
