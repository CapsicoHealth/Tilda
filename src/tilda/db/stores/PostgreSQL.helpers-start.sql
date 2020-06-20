/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

-- Original file: https://github.com/CapsicoHealth/Tilda/blob/master/src/tilda/db/stores/PostgreSQL.helpers-start.sql
-- Documentation: https://github.com/CapsicoHealth/Tilda/wiki/Tilda-Common-Helper-Database-Functions

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA Schema
-----------------------------------------------------------------------------------------------------------------
create schema IF NOT EXISTS TILDA;

SET search_path TO TILDA;

CREATE EXTENSION if not exists pg_trgm;

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA like() and ilike() functions
-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like val);';
CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like ANY(val));';
CREATE OR REPLACE FUNCTION TILDA.Like(v text, val text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v like ANY(val);';

CREATE OR REPLACE FUNCTION TILDA.ILike(v text[], val text)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ ilike val);';
CREATE OR REPLACE FUNCTION TILDA.ILike(v text[], val text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ ilike ANY(val));';
CREATE OR REPLACE FUNCTION TILDA.ILike(v text, val text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v ilike ANY(val);';


  
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA contains() functions
-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TILDA.contains(v int4range[], val integer)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ @> val);';

CREATE OR REPLACE FUNCTION TILDA.contains(v int8range[], val bigint)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ @> val);';
 
CREATE OR REPLACE FUNCTION TILDA.contains(v tstzrange[], val timestamptz)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ @> val);';

CREATE OR REPLACE FUNCTION TILDA.contains(v daterange [], val date)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ @> val);';

  

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA in() functions
-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TILDA.In(v text[], vals text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v integer[], vals integer[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v bigint[], vals bigint[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v boolean[], vals boolean[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v text, vals text[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v = ANY(vals);';

CREATE OR REPLACE FUNCTION TILDA.In(v integer, vals integer[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v = ANY(vals);';

CREATE OR REPLACE FUNCTION TILDA.In(v bigint, vals bigint[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v = ANY(vals);';

CREATE OR REPLACE FUNCTION TILDA.In(v boolean, vals boolean[])
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
  'select v = ANY(vals);';

  
  
  

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA toXXX() functions for Int, Double, Date
-----------------------------------------------------------------------------------------------------------------

---------------------
-- ToInt
CREATE OR REPLACE FUNCTION TILDA.toInt(str varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN case when str is null then val else str::integer end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, str3 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, null), Tilda.toInt(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;


---------------------
-- ToDouble
CREATE OR REPLACE FUNCTION TILDA.toDouble(str varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN case when str is null then val else str::double precision end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, str3 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, null), Tilda.toDouble(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;


---------------------
-- ToFloat
CREATE OR REPLACE FUNCTION TILDA.toFloat(str varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN case when str is null then val else str::real end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toFloat(str1 varchar, str2 varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN coalesce(Tilda.toFloat(str1, null), Tilda.toFloat(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toFloat(str1 varchar, str2 varchar, str3 varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN coalesce(Tilda.toFloat(str1, null), Tilda.toFloat(str2, null), Tilda.toFloat(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;


---------------------
-- ToDate
CREATE OR REPLACE FUNCTION TILDA.toDate(str varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN case when str is null then val else str::Date end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, str3 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, null), Tilda.toDate(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;


---------------------
-- ToBool
CREATE OR REPLACE FUNCTION Tilda.toBool(str varchar, val boolean)
RETURNS boolean AS $$
BEGIN
  RETURN case when str is null then val else str::boolean end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.toBool(str1 varchar, str2 varchar, val boolean)
RETURNS boolean AS $$
BEGIN
  RETURN coalesce(Tilda.toBool(str1, null), Tilda.toBool(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.toBool(str1 varchar, str2 varchar, str3 varchar, val boolean)
RETURNS boolean AS $$
BEGIN
  RETURN coalesce(Tilda.toBool(str1, null), Tilda.toBool(str2, null), Tilda.toBool(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;


---------------------
-- ToBoolInt
CREATE OR REPLACE FUNCTION Tilda.toBoolInt(str varchar, val boolean)
RETURNS integer AS $$
BEGIN
  RETURN case when str is null then val else str::boolean::integer end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.toBoolInt(str1 varchar, str2 varchar, val boolean)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toBoolInt(str1, null), Tilda.toBoolInt(str2, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.toBoolInt(str1 varchar, str2 varchar, str3 varchar, val boolean)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toBoolInt(str1, null), Tilda.toBoolInt(str2, null), Tilda.toBoolInt(str3, val));
END;
$$ LANGUAGE plpgsql COST 1 IMMUTABLE;





-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA Duration functions
-----------------------------------------------------------------------------------------------------------------

---------------------
-- age
CREATE OR REPLACE FUNCTION TILDA.age(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1)) + date_part(''month'', age($2, $1))/12.0 + date_part(''day'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.Age(timestamptz, timestamptz) IS 'Computes the age in years between 2 dates ''start'' and ''end'' with decimal places, so 1.25 years is 1y and 3 months. It is not 100% accurate as we use a simple 1y=365 days calculation. Use Tilda.DaysBetween if you want accurate days-based calculations.';


---------------------
-- ageBetween
CREATE OR REPLACE FUNCTION TILDA.ageBetween(timestamptz, timestamptz, float, float)
  RETURNS boolean
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT TILDA.Age($1, $2) >= $3 AND TILDA.Age($1, $2) < $4';


---------------------
-- daysBetween
CREATE OR REPLACE FUNCTION TILDA.daysBetween(ts1 timestamptz, ts2 timestamptz, midnight boolean)
  RETURNS integer
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT case when $3 or $2 < $1 then $2::DATE - $1::DATE else $2::DATE - $1::DATE + 1 end;';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean) IS 'Computes the number of days between 2 dates ''start'' and ''end''. The third parameter indicates whether the midnight rule should be applied or not. If true, the number of days between 2016-12-01 and 2016-12-02 for example will be 1 (i.e., one mignight passed). If false, the returned count will be 2. Note that this function doesn.''t care about timezones and only compares the date portions of the parameters passed in.';

CREATE OR REPLACE FUNCTION TILDA.daysBetween(ts1 timestamptz, ts2 timestamptz)
  RETURNS integer
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT case when $2 < $1 then $2::DATE - $1::DATE else $2::DATE - $1::DATE + 1 end;';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz) IS 'Computes the number of days between 2 dates ''start'' and ''end''. This function is the same as TILDA.DaysBetween(timestamptz, timestamptz, boolean) but with the third parapeter defaulted to false, i.e., the number of days between 2016-12-01 and 2016-12-02 is 2.';


------------------------------------------------------------------
-- monthsBetween, quartersBetween, yearsBetween
CREATE OR REPLACE FUNCTION TILDA.monthsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*12+date_part(''month'', age($2, $1))+date_part(''days'', age($2, $1))/30.0;';
COMMENT ON FUNCTION TILDA.MonthsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of months between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 30th part of a month no matter which month it is.';

CREATE OR REPLACE FUNCTION TILDA.quartersBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*4+date_part(''month'', age($2, $1))/3.0+date_part(''days'', age($2, $1))/91.0;';
COMMENT ON FUNCTION TILDA.QuartersBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of quarters between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 91st part of a quarter no matter which quarter it is.';

CREATE OR REPLACE FUNCTION TILDA.yearsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))+date_part(''month'', age($2, $1))/12.0+date_part(''days'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.YearsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of years between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 365th part of a year no matter which year it is.';




-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA aggregates
-----------------------------------------------------------------------------------------------------------------

---------------------
-- First
CREATE OR REPLACE FUNCTION TILDA.first_agg (anyelement, anyelement)
RETURNS anyelement LANGUAGE SQL COST 1 IMMUTABLE STRICT AS $$
        SELECT $1;
$$;

DO $$ BEGIN
if not exists (SELECT 1 FROM pg_aggregate WHERE aggfnoid::TEXT = 'public.first') THEN
CREATE AGGREGATE public.FIRST (
        sfunc    = TILDA.first_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;

---------------------
-- Last
CREATE OR REPLACE FUNCTION TILDA.last_agg ( anyelement, anyelement )
RETURNS anyelement LANGUAGE SQL COST 1 IMMUTABLE STRICT AS $$
        SELECT $2;
$$;
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_aggregate WHERE aggfnoid::TEXT = 'public.last') THEN
CREATE AGGREGATE public.LAST (
        sfunc    = TILDA.last_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;

---------------------
-- array_cat_agg
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_aggregate WHERE aggfnoid::TEXT = 'public.array_cat_agg') THEN
CREATE AGGREGATE public.array_cat_agg (anyarray)
(
    sfunc = array_cat,
    stype = anyarray,
    initcond = '{}'
);  
END IF;
END $$;




-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- ARRAY Helpers
-----------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION TILDA.arrayTrunc(arr anyarray, maxCount integer)
 RETURNS anyarray
 LANGUAGE sql
 IMMUTABLE COST 1
AS $$
SELECT array_agg(a) FROM (SELECT unnest(arr) a limit maxCount) X;
$$
;

CREATE OR REPLACE FUNCTION TILDA.arrayUnique(arr anyarray)
 RETURNS anyarray
 LANGUAGE sql
 IMMUTABLE COST 2
AS $$
select array_agg(a order by a) from (select distinct unnest(arr) as a) x;
$$
;
CREATE OR REPLACE FUNCTION TILDA.arrayMergeUnique(arr1 anyarray, arr2 anyarray)
 RETURNS anyarray
 LANGUAGE sql
 IMMUTABLE COST 2
AS $$
select array_agg(a order by a) from (select distinct unnest(arr1||arr2) as a) x;
$$
;
CREATE OR REPLACE FUNCTION TILDA.arrayMergeUnique(arr1 anyarray, arr2 anyarray, arr3 anyarray)
 RETURNS anyarray
 LANGUAGE sql
 IMMUTABLE COST 2
AS $$
select array_agg(a order by a) from (select distinct unnest(arr1||arr2||arr3) as a) x;
$$
;


-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA String-to-Array conversion for automated array support, mostly from ETL platforms
-----------------------------------------------------------------------------------------------------------------
DROP CAST IF EXISTS (text AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(text)
  RETURNS text[]
  IMMUTABLE COST 2 LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (text AS text[]) WITH FUNCTION TILDA.strToArray(text) as Implicit;

DROP CAST IF EXISTS (varchar AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(varchar)
  RETURNS text[]
  IMMUTABLE COST 2 LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (varchar AS text[]) WITH FUNCTION TILDA.strToArray(varchar) as Implicit;

-- allows a native representation, i.e., '{xxx,"abc 123",aaa}' to be parsed back into an array.
CREATE OR REPLACE FUNCTION TILDA.StrNativeArrayToArray(v text)
  RETURNS text[]
  IMMUTABLE COST 2 LANGUAGE SQL AS $$
  select regexp_split_to_array(regexp_replace(v, '^{\"?|\"?}$', '', 'g'), '\"?,\"?')
$$;





-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA boolean to smallint case
-----------------------------------------------------------------------------------------------------------------
DROP CAST IF EXISTS (boolean AS smallint);
CREATE OR REPLACE FUNCTION TILDA.boolToSmallint(boolean)
  RETURNS smallint
  IMMUTABLE COST 1 LANGUAGE SQL AS
'SELECT (case when $1 then 1 else 0 end)::SMALLINT;';
CREATE CAST (boolean AS smallint) WITH FUNCTION TILDA.boolToSmallint(boolean) as Implicit;


-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- Schema management helpers
-----------------------------------------------------------------------------------------------------------------

-- Function to check dynamically if a table exists. It can also be used as an SQL-Injection
-- check when another function needs to create some dynamic SQL and received table/schema names
-- as strings
CREATE OR REPLACE FUNCTION TILDA.existsTable(schemaName varchar, tableName varchar)
RETURNS boolean
STABLE COST 1000 LANGUAGE SQL AS
  'SELECT true FROM information_schema.tables WHERE lower(tables.table_schema)=lower($1) and lower(tables.table_name)=lower($2);'
;

-- Function to check dynamically if a column exists. It can also be used as an SQL-Injection
-- check when another function needs to create some dynamic SQL and received table/schema/column names
-- as strings
CREATE OR REPLACE FUNCTION TILDA.existsColumn(schemaName varchar, tableName varchar, colName varchar)
RETURNS boolean
STABLE COST 1000 LANGUAGE SQL AS $$
  SELECT true FROM information_schema.tables T
              JOIN information_schema.columns C on C.table_schema=T.table_schema and C.table_name=T.table_name
   WHERE lower(T.table_schema)=lower($1) and lower(T.table_name)=lower($2) and lower(c.column_name)=lower($3)
   ;
$$;



-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- DDL Dependency management helper functions
-----------------------------------------------------------------------------------------------------------------
drop function if exists Tilda.getDependenciesDDLs(p_view_schema varchar, p_view_name varchar) ;
drop type if exists tilda.getDependenciesDDLsDef;
CREATE TYPE tilda.getDependenciesDDLsDef as (
  "srcSchemaName" text,
  "srcTVName"     text,
  "seq"           integer,
  "depSchemaName" text,
  "depViewName"   text,
  "restoreScript" text,
  "created"       timestamptz,
  "lastUpdated"   timestamptz,
  "deleted"       timestamptz
);

create or replace function Tilda.getDependenciesDDLs(p_view_schema varchar, p_view_name varchar) 
returns SETOF Tilda.getDependenciesDDLsDef as
$$
declare
  v_curr record;
  v_ddltxt text;
  v_txt text;
  v_seq integer;
  v_rec Tilda.getDependenciesDDLsDef%rowtype;
begin
v_seq:=0;
for v_curr in 
(
  select obj_schema, obj_name, obj_type
    from ( with recursive recursive_deps(obj_schema, obj_name, obj_type, depth) as 
            ( select p_view_schema, p_view_name, null::varchar, 0
              union
              select dep_schema::varchar, dep_name::varchar, dep_type::varchar, recursive_deps.depth + 1
                from ( select ref_nsp.nspname ref_schema, ref_cl.relname ref_name, rwr_cl.relkind dep_type, rwr_nsp.nspname dep_schema, rwr_cl.relname dep_name
                         from pg_depend dep
                           join pg_class ref_cl on dep.refobjid = ref_cl.oid
                           join pg_namespace ref_nsp on ref_cl.relnamespace = ref_nsp.oid
                           join pg_rewrite rwr on dep.objid = rwr.oid
                           join pg_class rwr_cl on rwr.ev_class = rwr_cl.oid
                           join pg_namespace rwr_nsp on rwr_cl.relnamespace = rwr_nsp.oid
                        where dep.deptype = 'n'
                          and dep.classid = 'pg_rewrite'::regclass
                     ) deps
                  join recursive_deps on upper(deps.ref_schema) = upper(recursive_deps.obj_schema) and upper(deps.ref_name) = upper(recursive_deps.obj_name)
                where (upper(deps.ref_schema) != upper(deps.dep_schema) or upper(deps.ref_name) != upper(deps.dep_name))
            )
           select obj_schema, obj_name, obj_type, depth
             from recursive_deps 
            where depth > 0
         ) t
  group by obj_schema, obj_name, obj_type
  order by max(depth) desc
) loop

  v_ddltxt:='';
  
  if v_curr.obj_type = 'v' then
    select 'CREATE VIEW ' || coalesce(v_curr.obj_schema,'schema') || '.' || coalesce(v_curr.obj_name,'obj') || ' AS ' || E'\n' || coalesce(view_definition, 'def') || ';' || E'\n' 
      into v_txt
      from information_schema.views
     where table_schema = v_curr.obj_schema and table_name = v_curr.obj_name;
  elsif v_curr.obj_type = 'm' then
    select 'CREATE MATERIALIZED VIEW ' || v_curr.obj_schema || '.' || v_curr.obj_name || ' AS ' || E'\n' || definition || ';' || E'\n'
      into v_txt
      from pg_matviews
     where schemaname = v_curr.obj_schema and matviewname = v_curr.obj_name;
  end if;

  v_ddltxt:=v_ddltxt||coalesce(v_txt,'-- NO DEFINITION'||E'\n');

  select string_agg('GRANT ' || privilege_type || ' ON ' || table_schema || '.' || table_name || ' TO ' || grantee || ';' || E'\n', '')
    into v_txt
    from information_schema.role_table_grants
   where table_schema = v_curr.obj_schema and table_name = v_curr.obj_name;

  v_ddltxt:=v_ddltxt||coalesce(v_txt,'-- NO GRANTS'||E'\n');
  
  select 'COMMENT ON ' || case when c.relkind = 'v' then 'VIEW'
                               when c.relkind = 'm' then 'MATERIALIZED VIEW'
                               else ''
                          end
                       || ' ' || n.nspname || '.' || c.relname || ' IS ''' || replace(d.description, '''', '''''') || ''';' || E'\n'
    into v_txt
    from pg_class c
      join pg_namespace n on n.oid = c.relnamespace
      join pg_description d on d.objoid = c.oid and d.objsubid = 0
   where n.nspname = v_curr.obj_schema and c.relname = v_curr.obj_name and d.description is not null;

  v_ddltxt:=v_ddltxt||coalesce(v_txt,'-- NO VIEW COMMENTS'||E'\n');

  select string_agg('COMMENT ON COLUMN ' || n.nspname || '.' || c.relname || '."' || a.attname || '" IS ''' || replace(d.description, '''', '''''') || ''';' || E'\n', '')
    into v_txt
    from pg_class c
      join pg_attribute a on c.oid = a.attrelid
      join pg_namespace n on n.oid = c.relnamespace
      join pg_description d on d.objoid = c.oid and d.objsubid = a.attnum
   where n.nspname = v_curr.obj_schema and c.relname = v_curr.obj_name and d.description is not null;

  v_ddltxt:=v_ddltxt||coalesce(v_txt,'-- NO COLUMN COMMENTS'||E'\n');
  v_seq:=v_seq+1;
  for v_rec in select p_view_schema as "srcSchemaName", p_view_name as "srcTVName", v_seq as "seq"
                    , v_curr.obj_schema as "depSchemaName", v_curr.obj_name as "depViewName", v_ddltxt as "restoreScript"
                    , statement_timestamp() as "created", statement_timestamp() as "lastUpdated", null as "deleted"
    LOOP
      return next v_rec;
    END LOOP;
end loop;
end;
$$
LANGUAGE plpgsql COST 5000 ;




-- Renames a column and properly handles cases where the table doesn't exist, source column doesn't exist, or dest column already exists.  
-- Furthermore, the function handles a list of possible source names. For example, V2 of something renames a to b, and then V3 renames 
-- b to c. This function can then handle a case of renaming either a or b to c. This can be useful when migrating different existing versions.
-- A check will be performed to make sure there is only one valid source column.
-- Return values:
--     1: the operation was completed successfully and the column was renamed
--     0: none of the source columns exist and the destination column already exists. We assume it was previously renamed.
--    -1: the table couldn't be found
--    -2: there were multiple matches in the table for the source column list. Only one match is expected.
--    -3: none of the source columns can be found.
--    -4: the destination column already exists.
drop FUNCTION IF EXISTS tilda.renameColumnIfExists(schemaName varchar, tableName varchar, columnNames varchar[], newColumnName varchar);
CREATE FUNCTION tilda.renameColumnIfExists(schemaName varchar, tableName varchar, columnNames varchar[], newColumnName varchar) 
RETURNS TABLE ("code" integer, "msg" text) as $$
DECLARE
  _tableName varchar;
  _columnNames varchar[];
  _newColumnName varchar;
BEGIN
  SELECT tables.table_name, C2.column_name, array_agg(C1.column_name::TEXT)
    INTO   _tableName, _newColumnName, _columnNames
    FROM information_schema.tables
      LEFT join information_schema.columns C2 on C2.table_schema=tables.table_schema and C2.table_name=tables.table_name and C2.column_name=newColumnName
      LEFT join information_schema.columns C1 on C1.table_schema=tables.table_schema and C1.table_name=tables.table_name and Tilda.In(C1.column_name,columnNames)
   WHERE lower(tables.table_schema)=lower(schemaName) and lower(tables.table_name)=lower(tableName)
   GROUP BY 1,2
  ;
   -- Does the table exist?
  IF _tableName is null
  THEN RETURN QUERY select -1, 'Table '||schemaName||'.'||tableName||' cannot be found.';
  -- Are there more than one potential source columns actually in the table?
  ELSEIF array_length(_columnNames,1) > 1
  THEN RETURN QUERY select -2, 'Multiple potential source columns '||schemaName||'.'||tableName||'.'||_columnNames::TEXT||' exist. There should be only one match.';
  -- Does the src column not exist and neither the dest column?
  ELSEIF _columnNames[1] is null AND _newColumnName is null
  THEN RETURN QUERY select -3, 'Source column(s) '||schemaName||'.'||tableName||'.'||columnNames::TEXT||' cannot be found.';
  -- Does the src column not exist but the dest column does?
  ELSEIF _columnNames[1] is null AND _newColumnName is not null
  THEN RETURN QUERY select 0, 'Destination column '||schemaName||'.'||tableName||'.'||newColumnName||' already exists. Maybe it has been renamed already?';
  -- the source column exists, but does the destination column already exists?
  ELSEIF _newColumnName is not null
  THEN RETURN QUERY select -4, 'Destination column '||schemaName||'.'||tableName||'.'||newColumnName||' already exists.';
  ELSE
  -- good to go
  EXECUTE 'ALTER TABLE '||schemaName||'.'||tableName||' RENAME COLUMN "'||_columnNames[1]||'" TO "'||newColumnName||'"';
  RETURN QUERY select 1, 'Column '||schemaName||'.'||tableName||'.'||_columnNames[1]||' has been successfully renamed to '||newColumnName||'.';
  END IF;
END
$$ LANGUAGE plpgsql  COST 1000 ;






-- Copies the contents of srcColumnName to destColumnName and if successful, drops srcColumnName. This is useful when for example some migration has already
-- occurred to create the destination column and a copy/drop is needed vs the renameColumnIfExists() function which just renames a column.
-- Return values:
--     1: the operation was completed successfully and the column was renamed
--     0: the source column cannot be found and the dest column already exists. We assume a previous operation was already performed successfully.
--    -1: the table couldn't be found
--    -3: source columns can be found.
--    -4: the destination column cannot be found.
drop FUNCTION IF EXISTS tilda.copyColumnAndDrop(schemaName varchar, tableName varchar, srcColumnName varchar, destColumnName varchar);
CREATE FUNCTION tilda.copyColumnAndDrop(schemaName varchar, tableName varchar, srcColumnName varchar, destColumnName varchar) 
RETURNS TABLE ("code" integer, "msg" text) as $$
DECLARE
  _tableName varchar;
  _srcColumnName varchar;
  _destColumnName varchar;
BEGIN
  SELECT tables.table_name, C1.column_name, C2.column_name
    INTO   _tableName, _srcColumnName, _destColumnName
    FROM information_schema.tables
      LEFT join information_schema.columns C1 on C1.table_schema=tables.table_schema and C1.table_name=tables.table_name and C1.column_name=srcColumnName
      LEFT join information_schema.columns C2 on C2.table_schema=tables.table_schema and C2.table_name=tables.table_name and C2.column_name=destColumnName
   WHERE lower(tables.table_schema)=lower(schemaName) and lower(tables.table_name)=lower(tableName)
  ;
   -- Does the table exist?
  IF _tableName is null
  THEN RETURN QUERY select -1, 'Table '||schemaName||'.'||tableName||' cannot be found.';
  -- Does the src column not exist and dest column exist?
  ELSEIF _srcColumnName is null AND _destColumnName is not null
  THEN RETURN QUERY select 0, 'Source column '||_destColumnName||' does not exist and destination column '||_destColumnName||' exists. Maybe it has been copied and dropped already?';
  -- Does the src column not exist and neither the dest column?
  ELSEIF _srcColumnName is null
  THEN RETURN QUERY select -3, 'Source column(s) '||schemaName||'.'||tableName||'.'||srcColumnName||' cannot be found.';
  -- the source column exists, but does the destination column already exists?
  ELSEIF _destColumnName is null
  THEN RETURN QUERY select -4, 'Destination column '||schemaName||'.'||tableName||'.'||destColumnName||' does not exist.';
  ELSE
    -- good to go
    EXECUTE 'update '||schemaName||'.'||tableName||' set "'||_destColumnName||'"="'||_srcColumnName||'"';
    EXECUTE 'ALTER TABLE '||schemaName||'.'||tableName||' DROP COLUMN "'||_srcColumnName||'"';  
    RETURN QUERY select 1, 'Column '||_srcColumnName||' has been copied to '||_destColumnName||' and then dropped.';
  END IF;
END
$$ LANGUAGE plpgsql COST 1000 ;




-- Often, after doing some complex migration, changing business logic or data models, you need t0 be able to compare 2
-- tables and make sure they are identical. For example, you have a complex view that you have changed in non-trivial ways.
-- You would dump the original view into a temp table and then compare with results from the new view.
-- returns the number of rows with a discrepancy.
CREATE OR REPLACE FUNCTION tilda.CompareTables(table1 varchar, identity1 varchar[], columns1 varchar[], table2 varchar, identity2 varchar[], columns2 varchar[])
  RETURNS BIGINT AS
$BODY$
declare
  v_query1 text;
  v_query2 text;
  v_query3 text;
  v_txt text;
  v_txt2 text;
  v_res1 BIGINT;
  v_res2 BIGINT;
BEGIN
  if identity2 is null then
    identity2:= identity1;
  end if;
  if columns2 is null then
    columns2:= columns1;
  end if;

  -- sub select for first table
  select '"'||array_to_string(identity1, '","')||'"' into v_txt;
  v_query1:= '(select '||v_txt;
  select '"'||array_to_string(columns1, '","')||'"' into v_txt;
  v_query1:= v_query1||', row_to_json(row('||v_txt||'))::TEXT as txt'||E'\n'||'        from '||table1||') t1';
  -- count for the first table
  EXECUTE 'select count(*) from '||v_query1 INTO v_res1;

  -- sub select for second table
  select '"'||array_to_string(identity2, '","')||'"' into v_txt;
  v_query2:= '(select '||v_txt;
  select '"'||array_to_string(columns2, '","')||'"' into v_txt;
  v_query2:= v_query2||', row_to_json(row('||v_txt||'))::TEXT as txt'||E'\n'||'        from '||table2||') t2';
  -- count for the second table
  EXECUTE 'select count(*) from '||E'\n'||'        '||v_query2 INTO v_res2;

  -- test that the 2 counts are the same
  if v_res1-v_res2 <> 0 then
   return v_res1-v_res2;
  end if;

  v_txt:='';
  v_txt2:='';
  FOR i IN array_lower(identity1, 1) .. array_upper(identity1, 1)
  LOOP
    if length(v_txt) <> 0 then
       v_txt:=v_txt||E'\n'||'             and ';
       v_txt2:=v_txt2||E'\n'||'   and ';
    end if;
    v_txt:=v_txt||'t1."'||identity1[i]||'" = t2."'||identity2[i]||'"';
    v_txt2:=v_txt2||'(t1."'||identity1[i]||'" is null or t2."'||identity2[i]||'" is null)';
  END LOOP;

  v_query3:='select count(*)'||E'\n'
          ||' from '||v_query1||E'\n'
          ||' full outer join '||v_query2||E'\n'
          ||'              on '||v_txt||E'\n'
          ||' where ('||v_txt2||') or t1.txt <> t2.txt';
  RAISE NOTICE '%',v_query3;
  EXECUTE v_query3 INTO v_res1;

  RETURN v_res1;
END; $BODY$
  LANGUAGE plpgsql STABLE 
  COST 1000;


  
  
  
----------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------
-- Sizing helpers
----------------------------------------------------------------------------------------------------------------------------------------

-- Return size information per quarter on a specific tables, or all tables in a specific schema
-- schema_name: the name of the schema
-- table_name: the name of the table, or NULL if all tables in the schema are to be analyzed
-- created_col_name: the name of the date or timestamp column to use for quarterly grouping
-- start_date: the date the analysis should start from (based on the created_col_name names)
create or replace function Tilda.getSizing(schema_name varchar, table_name varchar, created_col_name varchar, start_date date) 
returns TABLE ("schemaName" varchar, "tableName" varchar, q date, "totalCount" bigint, "qCount" bigint, "totalSize" bigint, "totalSizepretty" text
             , "qSize" numeric, "qSizepretty" text, "qPercent" numeric) as $$
declare
  v_curr record;
  v_rec record;
  v_query text;
  v_count integer;
begin
  v_query:='with T as ('||E'\n';
  v_count:=-1;
  for v_curr in (
    SELECT
     schemaname as s,
     relname as t,
     columns.column_name as col,
     pg_total_relation_size(relid) As tsize
    FROM pg_catalog.pg_statio_user_tables
      LEFT join information_schema.columns on columns.table_schema=schemaname and columns.table_name=relname and lower(columns.column_name)=lower($3)
    WHERE ($1 is null OR lower($1)=lower(schemaname))
      AND ($2 is null OR lower($2)=lower(relname   ))
    ORDER BY pg_total_relation_size(relid) DESC
   ) LOOP
     v_count:=v_count+1;
     IF v_curr.col is not null
      THEN v_query:=v_query||(case when v_count> 0 then E'UNION\n' else '' end)
         ||'  select '''||v_curr.s||'''::VARCHAR as "schemaName", '''||v_curr.t||'''::VARCHAR as "tableName", '||v_curr.tsize||'::BIGINT as "totalSize"'||E'\n'
         ||'       , "totalCount", date_trunc(''quarter'', '||quote_ident($3)||')::DATE as q'||E'\n'
         ||'       , count(*) as "qCount"'||E'\n'
         ||'    from '||v_curr.s||'.'||v_curr.t||E'\n'
         ||'       join (select count(*) as "totalCount" from '||v_curr.s||'.'||v_curr.t||') as T on 1=1'||E'\n'
         ||'   where '||quote_ident($3)||' >= '''||$4||''''||E'\n'
         ||'   group by 4, 5'||E'\n'
         ;
      ELSE v_query:=v_query||(case when v_count> 0 then E'UNION\n' else '' end)
         ||'  select '''||v_curr.s||'''::VARCHAR as "schemaName", '''||v_curr.t||'''::VARCHAR as "tableName", '||v_curr.tsize||'::BIGINT as "totalSize"'||E'\n'
         ||'       , "totalCount", null::DATE as q'||E'\n'
         ||'       , count(*) as "qCount"'||E'\n'
         ||'    from '||v_curr.s||'.'||v_curr.t||E'\n'
         ||'       join (select count(*) as "totalCount" from '||v_curr.s||'.'||v_curr.t||') as T on 1=1'||E'\n'
         ||'   group by 4, 5'||E'\n'
         ; 
      END IF;
  END LOOP;
  v_query:=v_query||')'||E'\n'
         ||'select "schemaName", "tableName", q, "totalCount", "qCount"'||E'\n'
         ||'     , "totalSize" , pg_size_pretty("totalSize") as "totalSizePretty"'||E'\n'
         ||'     , round(1.0*"totalSize"*"qCount"/"totalCount",2) as "qSize"'||E'\n'
         ||'     , pg_size_pretty(1.0*"totalSize"*"qCount"/"totalCount") as "qSizePretty"'||E'\n'
         ||'     , round(100.0*"qCount"/"totalCount",2) as "qPercent"'||E'\n'
         ||' from T'||E'\n'
         ;
  RETURN QUERY EXECUTE v_query;
end;
$$
LANGUAGE plpgsql COST 1000 ;




-- returns an list of schemas, with the aggregate storage sizes of all of their tables, ordered by their sizes, with a running total.
drop function if exists Tilda.getSchemaSizes();
create or replace function Tilda.getSchemaSizes() 
returns TABLE ("schemaName" varchar, "totalSize" numeric, "totalSizePretty" text
                                   , "totalSizeTable" numeric, "totalSizeTablePretty" text
                                   , "totalSizeIndices" numeric, "totalSizeIndicesPretty" text
                                   , "totalSizeOther" numeric, "totalSizeOtherPretty" text
                                   , "runningTotalSize" numeric, "runningTotalSizePretty" text
                                   , "runningTotalSizeTables" numeric, "runningTotalSizeTablesPretty" text
                                   , "runningTotalSizeIndices" numeric, "runningTotalSizeIndicesPretty" text
              ) as $$
with T as (
SELECT
   schemaname::VARCHAR as "schemaName"
  ,sum(pg_total_relation_size(relid)) As "totalSize"
  ,pg_size_pretty(sum(pg_total_relation_size(relid))) As "totalSizePretty"
  ,sum(pg_relation_size(relid)) AS "totalSizeTable"
  ,pg_size_pretty(sum(pg_relation_size(relid))) AS "totalSizeTablePretty"
  ,sum(pg_indexes_size(relid)) AS "totalSizeIndices"
  ,pg_size_pretty(sum(pg_indexes_size(relid))) AS "totalSizeIndicesPretty"
  ,sum(pg_total_relation_size(relid)-pg_relation_size(relid)-pg_indexes_size(relid)) AS "totalSizeOther"
  ,pg_size_pretty(sum(pg_total_relation_size(relid)-pg_relation_size(relid)-pg_indexes_size(relid))) AS "totalSizeOtherPretty"
  FROM pg_catalog.pg_statio_user_tables
  group by 1
  ORDER BY 2 DESC
)
select "schemaName"
     , "totalSize", "totalSizePretty"
     , "totalSizeTable", "totalSizeTablePretty"
     , "totalSizeIndices", "totalSizeIndicesPretty"
     , "totalSizeOther", "totalSizeOtherPretty"
     , sum("totalSize") over(order by "totalSize" desc) as "runningTotalSize"
     , pg_size_pretty(sum("totalSize") over(order by "totalSize" desc)) as "runningTotalSizePretty"
     , sum("totalSizeTable") over(order by "totalSize" desc) as "runningTotalSizeTables"
     , pg_size_pretty(sum("totalSizeTable") over(order by "totalSize" desc)) as "runningTotalSizeTablesPretty"
     , sum("totalSizeIndices") over(order by "totalSize" desc) as "runningTotalSizeIndices"
     , pg_size_pretty(sum("totalSizeIndices") over(order by "totalSize" desc)) as "runningTotalSizeIndicesPretty"
  from T
group by 1, 2, 3, 4, 5, 6, 7, 8, 9
$$ LANGUAGE SQL COST 1000 ;



-- returns an list of tables, with their storage sizes, ordered by their sizes, with a running total.
drop function if exists Tilda.getTableSizes();
create or replace function Tilda.getTableSizes() 
returns TABLE ("schemaName" varchar, "tableName" varchar, "totalSize" numeric, "totalSizePretty" text
                                                        , "totalSizeTable" numeric, "totalSizeTablePretty" text
                                                        , "totalSizeIndices" numeric, "totalSizeIndicesPretty" text
                                                        , "totalSizeOther" numeric, "totalSizeOtherPretty" text
                                                        , "runningTotalSize" numeric, "runningTotalSizePretty" text
                                                        , "runningTotalSizeTables" numeric, "runningTotalSizeTablesPretty" text
                                                        , "runningTotalSizeIndices" numeric, "runningTotalSizeIndicesPretty" text
              ) as $$
with T as (
SELECT
   schemaname::VARCHAR as "schemaName"
  ,relname::VARCHAR as "tableName"
  ,pg_total_relation_size(relid)::numeric As "totalSize"
  ,pg_size_pretty(pg_total_relation_size(relid)) As "totalSizePretty"
  ,pg_relation_size(relid)::numeric AS "totalSizeTable"
  ,pg_size_pretty(pg_relation_size(relid)) AS "totalSizeTablePretty"
  ,pg_indexes_size(relid)::numeric AS "totalSizeIndices"
  ,pg_size_pretty(pg_indexes_size(relid)) AS "totalSizeIndicesPretty"
  ,(pg_total_relation_size(relid)-pg_relation_size(relid)-pg_indexes_size(relid))::numeric AS "totalSizeOther"
  ,pg_size_pretty(pg_total_relation_size(relid)-pg_relation_size(relid)-pg_indexes_size(relid)) AS "totalSizeOtherPretty"
  FROM pg_catalog.pg_statio_user_tables
  ORDER BY pg_total_relation_size(relid) DESC
)
select "schemaName", "tableName"
     , "totalSize", "totalSizePretty"
     , "totalSizeTable", "totalSizeTablePretty"
     , "totalSizeIndices", "totalSizeIndicesPretty"
     , "totalSizeOther", "totalSizeOtherPretty"
     , sum("totalSize") over(order by "totalSize" desc) as "runningTotalSize"
     , pg_size_pretty(sum("totalSize") over(order by "totalSize" desc)) as "runningTotalSizePretty"
     , sum("totalSizeTable") over(order by "totalSize" desc) as "runningTotalSizeTables"
     , pg_size_pretty(sum("totalSizeTable") over(order by "totalSize" desc)) as "runningTotalSizeTablesPretty"
     , sum("totalSizeIndices") over(order by "totalSize" desc) as "runningTotalSizeIndices"
     , pg_size_pretty(sum("totalSizeIndices") over(order by "totalSize" desc)) as "runningTotalSizeIndicesPretty"
  from T
group by 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
$$ LANGUAGE SQL COST 1000 ;



-- Get the list of tables and columns that have a foreign key to a target table.
/*
SELECT tc.table_schema, tc.table_name, tc.constraint_name, kcu.column_name, ccu.table_schema AS foreign_schema_name, ccu.table_name AS foreign_table_name, ccu.column_name AS foreign_column_name
  FROM information_schema.table_constraints tc
    JOIN information_schema.key_column_usage kcu ON tc.constraint_name = kcu.constraint_name
    JOIN information_schema.constraint_column_usage ccu ON ccu.constraint_name = tc.constraint_name
 WHERE constraint_type = 'FOREIGN KEY'
   AND ccu.table_name='clinician_dim'
 ORDER BY tc.table_schema, tc.table_name, kcu.column_name
*/



/*
DROP SEQUENCE IF EXISTS temp_seq;
CREATE SEQUENCE temp_seq START 1101001 INCREMENT 1 CACHE 1000;
with T as (
  select refnum from Patients.Order
  where refnum > 1101000
  order by refnum
  limit 2000000
)
update Patients.Order
  set refnum=nextval('temp_seq')
where refnum in (select refnum from T)

update tilda.key set max=(select max(refnum)+1 from PATIENTS.Order) where "name"='PATIENTS.ORDER'
DROP SEQUENCE IF EXISTS temp_seq;
*/

