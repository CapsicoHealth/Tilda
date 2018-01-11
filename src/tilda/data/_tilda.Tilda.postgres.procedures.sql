
drop function if exists Tilda.getDependenciesDDLs(p_view_schema varchar, p_view_name varchar) ;
drop type if exists tilda.getDependenciesDDLsDef;
CREATE TYPE tilda.getDependenciesDDLsDef as (
  "schemaName" text,
  "viewName"   text,
  "ddl"        text
);


create or replace function Tilda.getDependenciesDDLs(p_view_schema varchar, p_view_name varchar) 
returns SETOF Tilda.getDependenciesDDLsDef as
$$
declare
  v_curr record;
  v_ddltxt text;
  v_txt text;
  v_rec Tilda.getDependenciesDDLsDef%rowtype;
begin
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
    select 'CREATE VIEW ' || v_curr.obj_schema || '.' || v_curr.obj_name || ' AS ' || E'\n' || view_definition || ';' || E'\n' 
      into v_txt
      from information_schema.views
     where table_schema = v_curr.obj_schema and table_name = v_curr.obj_name;
  elsif v_curr.obj_type = 'm' then
    select 'CREATE MATERIALIZED VIEW ' || v_curr.obj_schema || '.' || v_curr.obj_name || ' AS ' || E'\n' || definition || ';' || E'\n'
      into v_txt
      from pg_matviews
     where schemaname = v_curr.obj_schema and matviewname = v_curr.obj_name;
  end if;

  v_ddltxt:=v_ddltxt||v_txt;

  select string_agg('GRANT ' || privilege_type || ' ON ' || table_schema || '.' || table_name || ' TO ' || grantee || ';' || E'\n', '')
    into v_txt
    from information_schema.role_table_grants
   where table_schema = v_curr.obj_schema and table_name = v_curr.obj_name;

  v_ddltxt:=v_ddltxt||v_txt;
  
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

  v_ddltxt:=v_ddltxt||v_txt;

  select string_agg('COMMENT ON COLUMN ' || n.nspname || '.' || c.relname || '.' || a.attname || ' IS ''' || replace(d.description, '''', '''''') || ''';' || E'\n', '')
    into v_txt
    from pg_class c
      join pg_attribute a on c.oid = a.attrelid
      join pg_namespace n on n.oid = c.relnamespace
      join pg_description d on d.objoid = c.oid and d.objsubid = a.attnum
   where n.nspname = v_curr.obj_schema and c.relname = v_curr.obj_name and d.description is not null;

  v_ddltxt:=v_ddltxt||v_txt;

  for v_rec in select v_curr.obj_schema as "schemaName", v_curr.obj_name as "viewName", v_ddltxt as "ddl"
    LOOP
      return next v_rec;
    END LOOP;
end loop;
end;
$$
LANGUAGE plpgsql;

--delete from deps_saved_ddl;
select * from Tilda.getDependenciesDDLs('PATIENTS', 'PATIENT');
--select * from deps_saved_ddl;
