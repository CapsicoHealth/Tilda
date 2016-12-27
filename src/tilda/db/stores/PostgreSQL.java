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

package tilda.db.stores;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringListRP;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.Generator;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.PostgresType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.CollectionUtil;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.TextUtil;
import tilda.utils.pairs.StringStringPair;

public class PostgreSQL implements DBType
  {
    static final Logger LOG = LogManager.getLogger(PostgreSQL.class.getName());

    @Override
    public String getName()
      {
        return "PostgreSQL";
      }


    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23505");
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "statement_timestamp()";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public boolean isLockOrConnectionError(SQLException E)
      {
        return TextUtil.indexOf(E.getMessage().toLowerCase(), _LOCK_CONN_ERROR_SUBSTR);
      }

    @Override
    public boolean needsSavepoint()
      {
        return true;
      }

    @Override
    public boolean supportsSelectLimit()
      {
        return true;
      }

    @Override
    public boolean supportsSelectOffset()
      {
        return true;
      }

    @Override
    public boolean supportsArrays()
      {
        return true;
      }


    @Override
    public String getSelectLimitClause(int Start, int Size)
      {
        if (Start <= 0 && Size <= 0)
          return "";

        StringBuilder Str = new StringBuilder();
        if (Size <= 0)
          Str.append(" LIMIT ALL");
        else
          Str.append(" LIMIT ").append(Size);
        if (Start > 0)
          Str.append(" OFFSET " + Start);

        return Str.toString();
      }

    @Override
    public String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case AVG:
              return "avg";
            case DEV:
              return "stddev";
            case MAX:
              return "max";
            case MIN:
              return "min";
            case SUM:
              return "sum";
            case VAR:
              return "variance";
            case ARRAY:
              return "array_agg";
            default:
              throw new Error("Cannot convert AggregateType " + AT + " to a database aggregate function name.");
          }
      }


    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return true;
      }

    protected static tilda.generation.postgres9.Sql _SQL = new tilda.generation.postgres9.Sql();

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return _SQL;
      }

    @Override
    public boolean createSchema(Connection Con, Schema S)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        getSQlCodeGen().genFileStart(Out, S);
        return Con.ExecuteDDL(S.getShortName(), null, Str.toString());
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, true, true);
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean createKeysEntry(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, false, true);
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Str.toString());
      }

    @Override
    public boolean dropView(Connection Con, View V)
    throws Exception
      {
        return Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), "DROP VIEW IF EXISTS " + V.getShortName() + " CASCADE");
      }

    @Override
    public boolean createView(Connection Con, View V)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullViewDDL(getSQlCodeGen(), Out, V);
        return Con.ExecuteDDL(V._ParentSchema._Name, V.getBaseName(), Str.toString());
      }

    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false && DefaultValue == null)
          throw new Exception("Cannot add new 'not null' column '" + Col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ADD COLUMN \"" + Col.getName() + "\" " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection());
        if (Col._Nullable == false)
          {
            Q += " not null DEFAULT " + ValueHelper.printValue(Col, DefaultValue);
          }
        if (Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) == false)
         return false;

        return alterTableAlterColumnComment(Con, Col);
      }

    @Override
    public boolean alterTableAlterColumnComment(Connection Con, Column Col)
    throws Exception
      {
        String Q = "COMMENT ON COLUMN " + Col._ParentObject.getShortName() + ".\"" + Col.getName() + "\" IS " + TextUtil.EscapeSingleQuoteForSQL(Col._Description) + ";";
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP COLUMN \"" + ColumnName + "\"";

        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnNull(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false)
          {
            String Q = "SELECT count(*) from " + Col._ParentObject.getShortName() + " where \"" + Col.getName() + "\" IS NULL";
            ScalarRP RP = new ScalarRP();
            Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > 0)
              {
                if (DefaultValue == null)
                  throw new Exception("Cannot alter column '" + Col.getFullName() + "' to not null without a default value. Add a default value in the model, or manually migrate your database.");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " set \"" + Col.getName() + "\" = " + ValueHelper.printValue(Col, DefaultValue) + " where \"" + Col.getName() + "\" IS NULL";
                Con.ExecuteUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
              }
          }

        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" " + (Col._Nullable == false ? "SET" : "DROP") + " NOT NULL;";
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    @Override
    public int getVarCharThreshhold()
      {
        return 20;
      }

    @Override
    public int getCLOBThreshhold()
      {
        return 4096;
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          return Collection == true ? "text[]" : S < getVarCharThreshhold() ? PostgresType.CHAR._SQLType + "(" + S + ")" : S < getCLOBThreshhold() ? PostgresType.STRING._SQLType + "(" + S + ")" : "text";
        return PostgresType.get(T)._SQLType + (T != ColumnType.JSON && Collection == true ? "[]" : "");
      }


    @Override
    public boolean alterTableAlterColumnStringSize(Connection Con, Column Col, int DBSize)
    throws Exception
      {
        // Is it shrinking?
        if (Col._Size < getCLOBThreshhold() && DBSize < getCLOBThreshhold() && Col._Size < DBSize
        || Col._Size < getCLOBThreshhold() && DBSize >= getCLOBThreshhold())
          {
            String Q = "SELECT max(length(\"" + Col.getName() + "\")) from " + Col._ParentObject.getShortName();
            ScalarRP RP = new ScalarRP();
            Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, RP);
            if (RP.getResult() > Col._Size)
              {
                Q = "select \"" + Col.getName() + "\" || '  (' || length(\"" + Col.getName() + "\") || ')' as _x from "+Col._ParentObject.getShortName()
                   +" group by \"" + Col.getName() + "\""
                   +" order by length(\"" + Col.getName() + "\") desc"
                   +" limit 10";
                StringListRP SLRP = new StringListRP();
                Con.ExecuteSelect(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q, SLRP);
                LOG.error("Column sample:");
                for (String s : SLRP.getResult())
                  LOG.error("   - "+s);
                throw new Exception("Cannot alter String column '" + Col.getFullName() + "' from size " + DBSize + " down to " + Col._Size + " because there are values with sizes up to " + RP.getResult()
                + " that would be truncated. You need to manually migrate your database.");
              }
          }

        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName() + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection());
        return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }


    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnType fromType, Column Col, ZoneInfo_Data defaultZI)
    throws Exception
      {
        if (fromType == ColumnType.STRING)
          {
            if (Col.getType() == ColumnType.INTEGER || Col.getType() == ColumnType.LONG || Col.getType() == ColumnType.FLOAT || Col.getType() == ColumnType.DOUBLE)
              {
                String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
                + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection())
                + " USING (trim(\"" + Col.getName() + "\")::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ");";
                return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
              }
            else if (Col.getType() == ColumnType.DATETIME)
              {
                String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
                + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection())
                + " USING (trim(\"" + Col.getName() + "\")::" + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ");";

                if (Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) == false)
                 return false;

                Col = Col._ParentObject.getColumn(Col.getName() + "TZ");
                Q = "UPDATE " + Col._ParentObject.getShortName() + " SET \"" + Col.getName() + "\" = 'UTC' WHERE \"" + Col.getName() + "\" IS NULL";

                return Con.ExecuteUpdate(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q) >= 0;
              }
          }
         String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ALTER COLUMN \"" + Col.getName()
                + "\" TYPE " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection()) + ";";
         return Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
      }

    protected static void PrintFunctionIn(StringBuilder Str, String Type)
      {
        // Str.append("DROP FUNCTION IF EXISTS TILDA.In2(" + Type + "[], " + Type + "[]);\n")
        // .append("CREATE OR REPLACE FUNCTION TILDA.In2(v " + Type + "[], vals " + Type + "[]) RETURNS boolean AS $$\n")
        // .append("BEGIN\n")
        // .append(" IF v is not null AND vals is not null THEN\n")
        // .append(" RETURN v && vals;\n")
        // .append(" END IF;\n")
        // .append(" RETURN false;\n")
        // .append("END; $$\n")
        // .append("LANGUAGE PLPGSQL;\n")
        // .append("\n")
        // .append("\n");

        // Str.append("DROP FUNCTION IF EXISTS TILDA.In(" + Type + "[], " + Type + "[]);\n")
        // .append("CREATE OR REPLACE FUNCTION TILDA.In(v " + Type + "[], vals " + Type + "[])\n")
        // .append(" RETURNS boolean\n")
        // .append(" STRICT IMMUTABLE LANGUAGE SQL AS\n")
        // .append(" 'select CASE WHEN v is not null and vals is not null then v && vals else false end;';\n")
        // .append("\n")
        // .append("\n");

        Str.append("CREATE OR REPLACE FUNCTION TILDA.In(v " + Type + "[], vals " + Type + "[])\n")
        .append("  RETURNS boolean\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("  'select v && vals;';\n")
        .append("\n")
        .append("\n");

      }

    @Override
    public boolean addHelperFunctions(Connection Con)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        /*
         * Str.append("DROP FUNCTION IF EXISTS TILDA.like(text[], text);\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.like(v text[], val text) RETURNS boolean AS $$\n")
         * .append("DECLARE\n")
         * .append("  str text;\n")
         * .append("BEGIN\n")
         * .append("  IF v is not null AND val is not null THEN\n")
         * .append("    FOREACH str IN ARRAY v LOOP\n")
         * .append("      IF str LIKE val THEN\n")
         * .append("        RETURN true;\n")
         * .append("      END IF;\n")
         * .append("    END LOOP;\n")
         * .append("  END IF;\n")
         * .append("  RETURN false;\n")
         * .append("END; $$\n")
         * .append("LANGUAGE PLPGSQL;\n")
         * .append("\n")
         * .append("\n")
         * .append("DROP FUNCTION IF EXISTS TILDA.like(text[], text[]);\n")
         * .append("CREATE OR REPLACE FUNCTION TILDA.like(v text[], vals text[]) RETURNS boolean AS $$\n")
         * .append("DECLARE\n")
         * .append("  str1 text;\n")
         * .append("  str2 text;\n")
         * .append("  i integer := 1;\n")
         * .append("BEGIN\n")
         * .append("  IF v is not null AND vals is not null THEN\n")
         * .append("    FOREACH str1 IN ARRAY v LOOP\n")
         * .append("      FOREACH str2 IN ARRAY vals LOOP\n")
         * .append("        IF str1 LIKE str2 THEN\n")
         * .append("          RETURN true;\n")
         * .append("        END IF;\n")
         * .append("      END LOOP;\n")
         * .append("    END LOOP;\n")
         * .append("  END IF;\n")
         * .append("  RETURN false;\n")
         * .append("END; $$\n")
         * .append("LANGUAGE PLPGSQL;\n")
         */
        Str.append("CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text)\n")
        .append("  RETURNS boolean\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("  'select exists (select * from unnest(v) x_ where x_ like val);';\n")
        .append("DROP FUNCTION IF EXISTS TILDA.Like(text[], text[]);\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text[])\n")
        .append("  RETURNS boolean\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("  'select exists (select * from unnest(v) x_ where x_ like ANY(val));';\n")
        .append("\n")
        .append("\n");
        PrintFunctionIn(Str, "text");
        PrintFunctionIn(Str, "integer");
        PrintFunctionIn(Str, "bigint");

        Str.append("CREATE OR REPLACE FUNCTION TILDA.getKeyBatch(t text, c integer) RETURNS TABLE (min_key_inclusive bigint, max_key_exclusive bigint) AS $$\n")
        .append("DECLARE\n")
        .append("  val bigint;\n")
        .append("BEGIN\n")
        .append("  UPDATE TILDA.KEY set \"max\"=\"max\"+c where \"name\"=t;\n")
        .append("  SELECT \"max\" into val from TILDA.KEY where \"name\"=t;\n")
        .append("  return query select val-c as min_key_inclusive, val as max_key_exclusive;\n")
        .append("END; $$\n")
        .append("LANGUAGE PLPGSQL;\n")
        .append("\n")
        .append("\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.getKeyBatchAsMaxExclusive(t text, c integer) RETURNS bigint AS $$\n")
        .append("DECLARE\n")
        .append("  val bigint;\n")
        .append("BEGIN\n")
        .append("  UPDATE TILDA.KEY set \"max\"=\"max\"+c where \"name\"=t;\n")
        .append("  SELECT \"max\" into val from TILDA.KEY where \"name\"=t;\n")
        .append("  return val;\n")
        .append("END; $$\n")
        .append("LANGUAGE PLPGSQL;\n")
        .append("\n")
        .append("\n")
        .append("DROP CAST IF EXISTS (text AS text[]);\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.strToArray(text)\n")
        .append("  RETURNS text[]\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("'SELECT regexp_split_to_array($1, ''``'');';\n")
        .append("CREATE CAST (text AS text[]) WITH FUNCTION TILDA.strToArray(text) as Implicit;\n")
        .append("\n")
        .append("DROP CAST IF EXISTS (varchar AS text[]);\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.strToArray(varchar)\n")
        .append("  RETURNS text[]\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("'SELECT regexp_split_to_array($1, ''``'');';\n")
        .append("CREATE CAST (varchar AS text[]) WITH FUNCTION TILDA.strToArray(varchar) as Implicit;\n")
        .append("\n")
        .append("\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean)\n")
        .append("  RETURNS integer\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("'SELECT date_part(''days'', $2 - $1)::integer+(case $3 when true then 0 else 1 end);';\n")
        .append("COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean) IS 'Computes the number of days between 2 dates ''start'' and ''end''. The third parameter indicates whether the midnight rule should be applied or not. If true, the number of days between 2016-12-01 and 2016-12-02 for example will be 1 (i.e., one mignight passed). If false, the returned count will be 2.';")
        .append("\n")
        .append("\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.Age(timestamptz, timestamptz)\n")
        .append("  RETURNS float\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("'SELECT date_part(''year'', age($2, $1)) + date_part(''month'', age($2, $1))/12.0;';\n")
        .append("\n")
        .append("\n")
        .append("CREATE OR REPLACE FUNCTION TILDA.AgeBetween(timestamptz, timestamptz, float, float)\n")
        .append("  RETURNS boolean\n")
        .append("  STRICT IMMUTABLE LANGUAGE SQL AS\n")
        .append("'SELECT TILDA.Age($1, $2) >= $3 AND TILDA.Age($1, $2) < $4';\n")
        .append("\n")
        .append("\n")
        .append("CREATE extension if not exists tablefunc;\n")
        ;

        return Con.ExecuteDDL("TILDA", "FUNCTIONS", Str.toString());
      }


    @Override
    public StringStringPair getTypeMapping(int Type, String Name, int Size, String TypeName)
    throws Exception
      {
        // LOG.debug("Type: "+Type+"; Name: "+Name+"; Size: "+Size+"; TypeName: "+TypeName+";");
        // if (Name.equals("feature_id") == true)
        // {
        // int xxx = 0;
        // ++xxx;
        // }
        ColumnType TildaType = null;
        String TypeSql = null;
        switch (Type)
          {
            /*@formatter:off*/
            case java.sql.Types.ARRAY        : TypeSql = "ARRAY"        ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.DISTINCT     : TypeSql = "DISTINCT"     ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.BIGINT       : TypeSql = "BIGINT"       ; TildaType = ColumnType.LONG; break;
            case java.sql.Types.BINARY       : TypeSql = "BINARY"       ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BIT          : TypeSql = "BIT"          ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.BLOB         : TypeSql = "BLOB"         ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BOOLEAN      : TypeSql = "BOOLEAN"      ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.CHAR         : TypeSql = "CHAR"         ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.CLOB         : TypeSql = "CLOB"         ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.DATALINK     : TypeSql = "DATALINK"     ; TildaType = null; break;
            case java.sql.Types.DATE         : TypeSql = "DATE"         ; TildaType = null; break;
            case java.sql.Types.DECIMAL      : TypeSql = "DECIMAL"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.DOUBLE       : TypeSql = "DOUBLE"       ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.FLOAT        : TypeSql = "FLOAT"        ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.INTEGER      : TypeSql = "INTEGER"      ; TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : TypeSql = "JAVA_OBJECT"  ; TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : TypeSql = "LONGNVARCHAR" ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: TypeSql = "LONGVARBINARY"; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : TypeSql = "LONGVARCHAR"  ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : TypeSql = "NCHAR"        ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : TypeSql = "NCLOB"        ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : TypeSql = "NULL"         ; TildaType = null; break;
            case java.sql.Types.NUMERIC      : TypeSql = "NUMERIC"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.NVARCHAR     : TypeSql = "NVARCHAR"     ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        :
              if (TypeName != null && TypeName.equalsIgnoreCase("jsonb") == true)
                {
                  TypeSql = "JSONB";
                  TildaType = ColumnType.JSON;
                }
              else
                {
                  TypeSql = "OTHER";
                  TildaType = null;
                }
              break;
            case java.sql.Types.REAL         : TypeSql = "REAL"         ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.REF          : TypeSql = "REF"          ; TildaType = null; break;
            case java.sql.Types.ROWID        : TypeSql = "ROWID"        ; TildaType = null; break;
            case java.sql.Types.SMALLINT     : TypeSql = "SMALLINT"     ; TildaType = null; break;
            case java.sql.Types.SQLXML       : TypeSql = "SQLXML"       ; TildaType = null; break;
            case java.sql.Types.STRUCT       : TypeSql = "STRUCT"       ; TildaType = null; break;
            case java.sql.Types.TIME         : TypeSql = "TIME"         ; TildaType = null; break;
            case java.sql.Types.TIMESTAMP    : TypeSql = "TIMESTAMP"    ; TildaType = ColumnType.DATETIME; break;
            case java.sql.Types.TINYINT      : TypeSql = "TINYINT"      ; TildaType = null; break;
            case java.sql.Types.VARBINARY    : TypeSql = "VARBINARY"    ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR      : TypeSql = "VARCHAR"      ; TildaType = ColumnType.STRING; break;
            default: throw new Exception("Cannot map SQL Type "+Type+" for column "+Name+"("+TypeName+").");
            /*@formatter:on*/
          }
        return new StringStringPair(TypeSql, TildaType.name());
      }


    private ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception
      {
        switch (TypeName)
          {
            case "_int4":
              TildaType = ColumnType.INTEGER;
              break;
            case "_int8":
              TildaType = ColumnType.LONG;
              break;
            case "_float4":
              TildaType = ColumnType.FLOAT;
              break;
            case "_float8":
              TildaType = ColumnType.DOUBLE;
              break;
            case "_bpchar":
              TildaType = ColumnType.CHAR;
              break;
            case "_text":
            case "character_data":
              TildaType = ColumnType.STRING;
              break;
            case "_bool":
              TildaType = ColumnType.BOOLEAN;
              break;
            default:
              throw new Exception("Cannot map SQL TypeName " + TypeName + " for array column '" + Name + "'.");
          }
        return TildaType;
      }

    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(SchemaName) == false)
          Str.append(SchemaName).append(".").append(TableName).append(".");
        else if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append(TableName).append(".");
        Str.append("\"").append(ColumnName).append("\"");
      }

    @Override
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName)
      {
        Str.append(SchemaName).append(".").append(TableName);
      }


    @Override
    public void setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val)
    throws Exception
      {
        java.sql.Array A = C.createArrayOf(_SQL.getColumnTypeRaw(Type, -1, true), val.toArray());
        allocatedArrays.add(A);
        PS.setArray(i, A);
      }


    @Override
    public Collection<?> getArray(ResultSet RS, int i, ColumnType Type, boolean isSet)
    throws Exception
      {
        Array A = RS.getArray(i);
        if (A == null)
          return null;
        Collection<?> val = isSet == true ? CollectionUtil.toSet(A.getArray())
        : CollectionUtil.toList(A.getArray());
        A.free();
        return val;
      }


    @Override
    public void setJson(PreparedStatement PS, int i, String jsonValue)
    throws Exception
      {
        // TODO Auto-generated method stub

      }


    @Override
    public String getJson(ResultSet RS, int i)
    throws Exception
      {
        // TODO Auto-generated method stub
        return null;
      }


    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        return "cast(? as jsonb)";
      }


    @Override
    public void setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast)
      {
        Col.getFullColumnVarForSelect(C, Str);
        Str.append(Asc == true ? " ASC" : " DESC");
        Str.append(" NULLS ").append(NullsLast == true ? "LAST" : "FIRST");
      }


    @Override
    public void truncateTable(Connection C, String schemaName, String tableName)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        Str.append("TRUNCATE ");
        getFullTableVar(Str, schemaName, tableName);
        C.ExecuteUpdate(schemaName, tableName, Str.toString());
      }


    @Override
    public void age(Connection C, StringBuilder Str, Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count, String Operator)
      {
        Str.append(" (");
        ColEnd.getFullColumnVarForSelect(C, Str);
        Str.append(" - ");
        ColStart.getFullColumnVarForSelect(C, Str);
        Str.append(")").append(Operator).append("INTERVAL '").append(Count).append(" ").append(Type.toString()).append("'");
      }


    @Override
    public boolean alterTableComment(Connection Con, Object Obj)
    throws Exception
      {
        String Q = "COMMENT ON TABLE " + Obj.getShortName() + " IS " + TextUtil.EscapeSingleQuoteForSQL(Obj._Description) + ";";
        return Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }


    @Override
    public void within(Connection C, StringBuilder Str, Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long DurationCount, IntervalEnum DurationType)
      {
        if (DurationCount >= 0)
          {
            Str.append(" ("); Col.getFullColumnVarForSelect(C, Str); Str.append(" >= "); ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str); Str.append(" < "); ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" + INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(")");
          }
        else
          {
            DurationCount = -DurationCount;
            Str.append(" ("); Col.getFullColumnVarForSelect(C, Str); Str.append(" > "); ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" - INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str); Str.append(" <= "); ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(")");
          }
      }
  }
