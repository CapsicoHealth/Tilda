-----------------------------------------------------------------------------------------------------------------
-- TILDA in() functions
CREATE OR REPLACE FUNCTION TILDA.In(v text[], vals text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v integer[], vals integer[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v bigint[], vals bigint[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';


-----------------------------------------------------------------------------------------------------------------
-- TILDA toXXX() functions for Int, Double, Date
CREATE OR REPLACE FUNCTION TILDA.toInt(str varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN case when str is null then val else str::integer end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, str3 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, null), Tilda.toInt(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.toDouble(str varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN case when str is null then val else str::double precision end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, str3 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, null), Tilda.toDouble(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.toFloat(str varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN case when str is null then val else str::real end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toFloat(str1 varchar, str2 varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN coalesce(Tilda.toFloat(str1, null), Tilda.toFloat(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toFloat(str1 varchar, str2 varchar, str3 varchar, val real)
RETURNS real AS $$
BEGIN
  RETURN coalesce(Tilda.toFloat(str1, null), Tilda.toFloat(str2, null), Tilda.toFloat(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.toDate(str varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN case when str is null then val else str::Date end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, str3 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, null), Tilda.toDate(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


-----------------------------------------------------------------------------------------------------------------
-- TILDA Like() functions
CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text)
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like val);';
CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like ANY(val));';
CREATE OR REPLACE FUNCTION TILDA.Like(v text, val text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v like ANY(val);';


-----------------------------------------------------------------------------------------------------------------
--- TILDA KEY-related functions
CREATE OR REPLACE FUNCTION TILDA.getKeyBatch(t text, c integer) 
RETURNS TABLE (min_key_inclusive bigint, max_key_exclusive bigint) AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t;
  SELECT "max" into val from TILDA.Key where "name"=t;
  return query select val-c as min_key_inclusive, val as max_key_exclusive;
END; $$
LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION TILDA.getKeyBatchAsMaxExclusive(t text, c integer) RETURNS bigint AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t;
  SELECT "max" into val from TILDA.Key where "name"=t;
  return val;
END; $$
LANGUAGE PLPGSQL;



-----------------------------------------------------------------------------------------------------------------
-- TILDA String-to-Array conversion for automated array support, mostly from ETL platforms
DROP CAST IF EXISTS (text AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(text)
  RETURNS text[]
  IMMUTABLE LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (text AS text[]) WITH FUNCTION TILDA.strToArray(text) as Implicit;

DROP CAST IF EXISTS (varchar AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(varchar)
  RETURNS text[]
  IMMUTABLE LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (varchar AS text[]) WITH FUNCTION TILDA.strToArray(varchar) as Implicit;

-- allows a native representation, i.e., '{xxx,"abc 123",aaa}' to be parsed back into an array.
CREATE OR REPLACE FUNCTION TILDA.StrNativeArrayToArray(v text)
  RETURNS text[]
  IMMUTABLE LANGUAGE SQL AS $$
  select regexp_split_to_array(regexp_replace(v, '^{\"?|\"?}$', '', 'g'), '\"?,\"?')
$$;



-----------------------------------------------------------------------------------------------------------------
-- TILDA Duration functions
CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz, boolean)
  RETURNS integer
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''days'', $2 - $1)::integer+(case $3 or $2 < $1 when true then 0 else 1 end);';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean) IS 'Computes the number of days between 2 dates ''start'' and ''end''. The third parameter indicates whether the midnight rule should be applied or not. If true, the number of days between 2016-12-01 and 2016-12-02 for example will be 1 (i.e., one mignight passed). If false, the returned count will be 2.';


CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz)
  RETURNS integer
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''days'', $2 - $1)::integer+1;';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz) IS 'Computes the number of days between 2 dates ''start'' and ''end''. This function is the same as TILDA.DaysBetween(timestamptz, timestamptz, boolean) but with the third parapeter defaulted to false, i.e., the number of days between 2016-12-01 and 2016-12-02 is 2.';


CREATE OR REPLACE FUNCTION TILDA.monthsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*12+date_part(''month'', age($2, $1))+date_part(''days'', age($2, $1))/30.0;';
COMMENT ON FUNCTION TILDA.MonthsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of months between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 30th part of a month no matter which month it is.';


CREATE OR REPLACE FUNCTION TILDA.quartersBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*4+date_part(''month'', age($2, $1))/3.0+date_part(''days'', age($2, $1))/91.0;';
COMMENT ON FUNCTION TILDA.QuartersBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of quarters between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 91st part of a quarter no matter which quarter it is.';


CREATE OR REPLACE FUNCTION TILDA.yearsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))+date_part(''month'', age($2, $1))/12.0+date_part(''days'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.YearsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of years between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 365th part of a year no matter which year it is.';


CREATE OR REPLACE FUNCTION TILDA.age(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1)) + date_part(''month'', age($2, $1))/12.0 + date_part(''day'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.Age(timestamptz, timestamptz) IS 'Computes the age in years between 2 dates ''start'' and ''end'' with decimal places, so 1.25 years is 1y and 3 months. It is not 100% accurate as we use a simple 1y=365 days calculation. Use Tilda.DaysBetween if you want accurate days-based calculations.';


CREATE OR REPLACE FUNCTION TILDA.ageBetween(timestamptz, timestamptz, float, float)
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
'SELECT TILDA.Age($1, $2) >= $3 AND TILDA.Age($1, $2) < $4';

CREATE OR REPLACE FUNCTION TILDA.first_agg (anyelement, anyelement)
RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$
        SELECT $1;
$$;



-----------------------------------------------------------------------------------------------------------------
-- TILDA FIRST/LAST aggregates
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_proc WHERE proname = 'first' AND proisagg=true) THEN
CREATE AGGREGATE public.FIRST (
        sfunc    = TILDA.first_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;
 
CREATE OR REPLACE FUNCTION TILDA.last_agg ( anyelement, anyelement )
RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$
        SELECT $2;
$$;
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_proc WHERE proname = 'last' AND proisagg=true) THEN
CREATE AGGREGATE public.LAST (
        sfunc    = TILDA.last_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;


-----------------------------------------------------------------------------------------------------------------
-- Loading the TableFunc extension
CREATE extension if not exists tablefunc;


-----------------------------------------------------------------------------------------------------------------
-- DDL Dependency management helper functions
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
LANGUAGE plpgsql;




-- compares 2 tables row by row as per the identify columns and check if they are all equals.
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
  v_query1:= v_query1||', row_to_json(row('||v_txt||'))'||E'\n'||'        from '||table1||') t1';
  -- count for the first table
  EXECUTE 'select count(*) from '||v_query1 INTO v_res1;

  -- sub select for second table
  select '"'||array_to_string(identity2, '","')||'"' into v_txt;
  v_query2:= '(select '||v_txt;
  select '"'||array_to_string(columns2, '","')||'"' into v_txt;
  v_query2:= v_query2||', row_to_json(row('||v_txt||'))'||E'\n'||'        from '||table2||') t2';
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

  v_query3:='select count(*)'||E'\n'||' from '||v_query1||E'\n\n'||' full outer join '||v_query2||E'\n'||'              on '||v_txt||E'\n'||' where '||v_txt2;
  RAISE NOTICE '%',v_query3;
  EXECUTE v_query3 INTO v_res1;

  RETURN v_res1;
END; $BODY$
  LANGUAGE plpgsql STABLE
  COST 100;
