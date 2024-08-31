package tilda.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.Statement;

import tilda.utils.FileUtil;

public class DDLTest
  {

    public static String _STATEMENT_ = "-----------------------------------------------------------------------------------------------------------------\r\n"
    + "-----------------------------------------------------------------------------------------------------------------\r\n"
    + "-- TILDA aggregates\r\n"
    + "-----------------------------------------------------------------------------------------------------------------\r\n"
    + "\r\n"
    + "---------------------\r\n"
    + "-- First\r\n"
    + "CREATE OR REPLACE FUNCTION TILDA.first_agg (anyelement, anyelement)\r\n"
    + "RETURNS anyelement LANGUAGE SQL COST 1 IMMUTABLE STRICT AS $$\r\n"
    + "        SELECT $1;\r\n"
    + "$$;\r\n"
    + "\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(anyelement)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = anyelement,\r\n"
    + "           stype    = anyelement\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(real)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = real,\r\n"
    + "           stype    = real\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(double precision)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = double precision,\r\n"
    + "           stype    = double precision\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(text)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = text,\r\n"
    + "           stype    = text\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(integer)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = integer,\r\n"
    + "           stype    = integer\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(bigint)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = bigint,\r\n"
    + "           stype    = bigint\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(date)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = date,\r\n"
    + "           stype    = date\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='first(timestamp with time zone)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.FIRST (\r\n"
    + "           sfunc    = TILDA.first_agg,\r\n"
    + "           basetype = timestamptz,\r\n"
    + "           stype    = timestamptz\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "\r\n"
    + "---------------------\r\n"
    + "-- Last\r\n"
    + "CREATE OR REPLACE FUNCTION TILDA.last_agg ( anyelement, anyelement )\r\n"
    + "RETURNS anyelement LANGUAGE SQL COST 1 IMMUTABLE STRICT AS $$\r\n"
    + "        SELECT $2;\r\n"
    + "$$;\r\n"
    + "DO $$ BEGIN\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(anyelement)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = anyelement,\r\n"
    + "           stype    = anyelement\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(real)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = real,\r\n"
    + "           stype    = real\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(double precision)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = double precision,\r\n"
    + "           stype    = double precision\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(text)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = text,\r\n"
    + "           stype    = text\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(integer)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = integer,\r\n"
    + "           stype    = integer\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(bigint)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = bigint,\r\n"
    + "           stype    = bigint\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(date)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = date,\r\n"
    + "           stype    = date\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "    if not exists (select p.oid::regprocedure from pg_proc p join pg_namespace n on p.pronamespace = n.oid  where p.oid::regprocedure::text='last(timestamp with time zone)' and n.nspname = 'public') THEN\r\n"
    + "        CREATE AGGREGATE public.LAST (\r\n"
    + "           sfunc    = TILDA.last_agg,\r\n"
    + "           basetype = timestamptz,\r\n"
    + "           stype    = timestamptz\r\n"
    + "        );\r\n"
    + "    END IF;\r\n"
    + "END $$;\r\n"
    + "\r\n"
    + "";

    public static void main(String[] args)
    throws Exception
      {
        Class.forName("org.postgresql.Driver");
        java.sql.Connection C = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pepper", args[0], args[1]);
        C.setAutoCommit(false);
        C.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
        C.setClientInfo("defaultRowFetchSize", "5000");
        Statement S = C.createStatement();
        
        BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Projects\\repos\\OSS\\Tilda\\src\\tilda\\db\\stores\\PostgreSQL.helpers-start.sql"))); 
        _STATEMENT_ = FileUtil.getContentsFromReader(in);
        System.out.println(_STATEMENT_);
        S.execute(_STATEMENT_);
        while (S.getMoreResults() == true || S.getUpdateCount() != -1)
          S.getResultSet();
        StringBuilder str = new StringBuilder();
        SQLWarning warn = S.getWarnings();
        while (warn != null)
          {
            str.append("       ").append(warn.getMessage()).append("\r\n");
            warn = warn.getNextWarning();
          }
        if (str.length() == 0)
          System.out.println("Messages:\n" + str.toString());
        S.close();
        System.out.println("Closed Statement");
        C.commit();
        System.out.println("Committed");
        C.close();
        System.out.println("Closed Connection");
      }
  }
