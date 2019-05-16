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

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
--- TILDA KEY-related functions
-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TILDA.getKeyBatch(t text, c integer) 
RETURNS TABLE (min_key_inclusive bigint, max_key_exclusive bigint) AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t returning "max" into val;
  return query select val-c as min_key_inclusive, val as max_key_exclusive;
END; $$
LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION TILDA.getKeyBatchAsMaxExclusive(t text, c integer) RETURNS bigint AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t returning "max" into val;
  return val;
END; $$
LANGUAGE PLPGSQL;


-- Updates the key in TILDA.Key to match the max(refnum)+1 from the named table
CREATE OR REPLACE FUNCTION TILDA.updateMaxKey(schemaName varchar, tableName varchar)
RETURNS bigint AS $$
DECLARE
  val bigint;
  q text;
BEGIN
  IF (SELECT TILDA.existsColumn($1,$2,'refnum')) is distinct from true THEN -- test for table and schema existence.. and doubles as SQL injection barier.
   return null;
  END IF;
  q:='SELECT coalesce(max(refnum),0) from '||schemaName||'.'||tableName;
  EXECUTE q into val;
  val:=val+1;
  q:='update TILDA.Key set max='||val||' where name='''||upper(schemaName||'.'||tableName)||'''';
  EXECUTE q;
  return val;
END; $$
LANGUAGE PLPGSQL;


-- Updates the key's max value in TILDA.Key to max(refnum)+1 of all registered tables.
CREATE OR REPLACE FUNCTION TILDA.updateAllMaxKeys() RETURNS bigint AS $$
DECLARE
  val bigint;
  counter bigint;
  skipped bigint;
  q text;
  v_curr record;
BEGIN
  counter:=0;
  skipped:=0;
  for v_curr in (
    SELECT name
          ,substr(name, 1, strpos(name,'.')-1) as schemaName
          ,substr(name, strpos(name,'.')+1) as tableName
      from TILDA.Key
   ) LOOP
      -- It's possible for an old table to still be in the Tilda.Key table but no longer exist, or no longer have th erefnum column.
      IF (SELECT TILDA.existsColumn(v_curr.schemaName,v_curr.tableName, 'refnum')) is distinct from true THEN
        skipped:=skipped+1;
        RAISE NOTICE 'Skipped table #% of %: %',skipped, counter, v_curr.name;
        CONTINUE;
      END IF;

      q:='SELECT coalesce(max(refnum),0) from '||v_curr.schemaName||'.'||v_curr.tableName;
      RAISE NOTICE '%',q;
      EXECUTE q into val;
      val:=val+1;
      q:='update TILDA.Key set max='||val||' where name='''||v_curr.name||'''';
      RAISE NOTICE '%',q;
      EXECUTE q;
      counter:=counter+1;
      RAISE NOTICE 'Processed table #%: %',counter, v_curr.name;
    END LOOP;
  RAISE NOTICE 'Processed % tables, and skipped % (total=%)',counter, skipped, (counter+skipped);
  return counter;
END; $$
LANGUAGE PLPGSQL;





-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA Mapping helper functions
-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar)
  RETURNS varchar
  STABLE COST 200 LANGUAGE SQL AS
'SELECT dst from TILDA.MAPPING where type=$1 and src=upper($2)';

CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar, varchar)
  RETURNS varchar
  STABLE COST 200 LANGUAGE SQL AS
'SELECT coalesce(TILDA.map($1, $2), $3)';






