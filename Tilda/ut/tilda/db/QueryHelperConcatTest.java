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

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;

/**
 * Tests for QueryHelper.selectColumnConcat (#873). Runs against any Postgres database, using a temp table
 * only, so nothing is left behind:
 *
 * <pre>
 * java tilda.db.QueryHelperConcatTest "jdbc:postgresql://localhost:5432/mydb?user=me&password=xxx"
 * </pre>
 */
public class QueryHelperConcatTest
  {
    protected static final Logger LOG = LogManager.getLogger(QueryHelperConcatTest.class.getName());

    protected static final String           SCHEMA = "pg_temp";
    protected static final String           TABLE  = "concat_test";
    protected static final ColumnDefinition COL_A  = new ColumnDefinition(SCHEMA, TABLE, "a", 0, ColumnType.STRING, false, "", null, null);
    protected static final ColumnDefinition COL_B  = new ColumnDefinition(SCHEMA, TABLE, "b", 0, ColumnType.STRING, false, "", null, null);
    protected static final ColumnDefinition COL_C  = new ColumnDefinition(SCHEMA, TABLE, "c", 0, ColumnType.STRING, false, "", null, null);
    protected static final ColumnDefinition COL_D  = new ColumnDefinition(SCHEMA, TABLE, "d", 0, ColumnType.STRING, false, "", null, null);

    protected static int _Failures = 0;

    public static void main(String[] args)
      {
        if (args.length != 1)
          {
            LOG.error("Usage: QueryHelperConcatTest <postgres jdbc url>");
            System.exit(-1);
          }
        try (java.sql.Connection JC = DriverManager.getConnection(args[0]))
          {
            JC.setAutoCommit(false);
            JC.createStatement().execute("create temp table " + TABLE + "(a text, b text, c text, d text)");
            JC.createStatement().execute("insert into " + TABLE + " values ('a1', 'b1', 'c1', 'd1'), ('a2', null, 'c2', null)");
            Connection C = new Connection(JC);

            // Separator, no coalesce: this used to generate "a||'-'b", an SQL syntax error.
            check(C, COL_A, "-", COL_B, null, null, null, null, null, Arrays.asList("a1-b1", null));
            // No separator, no coalesce: this used to generate "ab", an SQL syntax error.
            check(C, COL_A, null, COL_B, null, null, null, null, null, Arrays.asList("a1b1", null));
            check(C, COL_A, "", COL_B, null, null, null, null, null, Arrays.asList("a1b1", null));
            // Coalesce, with and without a separator (already working, must not regress).
            check(C, COL_A, "-", COL_B, null, null, null, null, "?", Arrays.asList("a1-b1", "a2-?"));
            check(C, COL_A, null, COL_B, null, null, null, null, "?", Arrays.asList("a1b1", "a2?"));
            // 4 columns, mixing separators, and a separator that needs escaping.
            check(C, COL_A, "'", COL_B, null, COL_C, " / ", COL_D, null, Arrays.asList("a1'b1c1 / d1", null));
            check(C, COL_A, "'", COL_B, null, COL_C, " / ", COL_D, "", Arrays.asList("a1'b1c1 / d1", null));
            check(C, COL_A, "'", COL_B, null, COL_C, " / ", COL_D, "?", Arrays.asList("a1'b1c1 / d1", "a2'?c2 / ?"));

            JC.rollback();
          }
        catch (Throwable T)
          {
            LOG.error("An exception occurred", T);
            ++_Failures;
          }
        if (_Failures != 0)
          {
            LOG.error("QueryHelperConcatTest: " + _Failures + " FAILURE(S).");
            System.exit(1);
          }
        LOG.info("QueryHelperConcatTest: all tests passed.");
      }

    private static void check(Connection C, ColumnDefinition col1, String sep2, ColumnDefinition col2, String sep3, ColumnDefinition col3, String sep4, ColumnDefinition col4, String coalesce, List<String> expected)
    throws Exception
      {
        SelectQuery Q = new SelectQuery(C, SCHEMA, TABLE, true);
        Q.selectColumnConcat(col1, sep2, col2, sep3, col3, sep4, col4, coalesce).from().orderBy(COL_A, true);
        String sql = Q.toString();
        java.sql.Savepoint SP = C._C.setSavepoint();
        try
          {
            List<String> results = new ArrayList<String>();
            Q.execute((count, RS) -> results.add(RS.getString(1)), 0, -1);
            if (results.equals(expected) == true)
              LOG.info("OK:     " + sql + " -> " + results);
            else
              {
                LOG.error("FAILED: " + sql + " -> " + results + ", expected " + expected);
                ++_Failures;
              }
          }
        catch (Exception E)
          {
            LOG.error("FAILED: " + sql + " -> " + E.getMessage());
            ++_Failures;
            C._C.rollback(SP);
          }
      }
  }
