/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
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

-- Original file: https://github.com/CapsicoHealth/Tilda/blob/master/src/tilda/db/stores/BigQuery.helpers-start.sql
-- Documentation: https://github.com/CapsicoHealth/Tilda/wiki/Tilda-Common-Helper-Database-Functions

-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-- TILDA Schema
-----------------------------------------------------------------------------------------------------------------
create schema IF NOT EXISTS TILDA;


CREATE OR REPLACE FUNCTION TILDA.like1(v1 STRING, v2 ARRAY<STRING>) RETURNS BOOL AS (
  (exists (select 1 from unnest(v2) x2_ where v1 like x2_) )
);

CREATE OR REPLACE FUNCTION TILDA.like2(v1 ARRAY<STRING>, v2 ARRAY<STRING>) RETURNS BOOL AS (
   (exists (select 1 from unnest(v1) x1_, unnest(v2) x2_ where x1_ like x2_) )
);

CREATE OR REPLACE FUNCTION TILDA.in1(v1 STRING, v2 ARRAY<STRING>) RETURNS BOOL AS (
   v1 in unnest(v2)
);

CREATE OR REPLACE FUNCTION TILDA.in2(v1 ARRAY<STRING>, v2 ARRAY<STRING>) RETURNS BOOL AS (
   exists(select 1 from unnest(v1) x1_ where x1_ in unnest(v2))
);

CREATE OR REPLACE FUNCTION TILDA.age(date_of_birth DATE, as_of_date DATE) AS (
    DATE_DIFF(as_of_date,date_of_birth, YEAR) - 
      IF(EXTRACT(MONTH FROM date_of_birth)*100 + EXTRACT(DAY FROM date_of_birth) > EXTRACT(MONTH FROM as_of_date)*100 + EXTRACT(DAY FROM as_of_date),1,0)
);



CREATE OR REPLACE VIEW TILDA.BQJobDetailsView as
SELECT start_time, end_time, project_id, job_id, user_email
     , coalesce(total_bytes_billed, 0) AS total_bytes_billed
     , (CASE WHEN statement_type='CREATE_MODEL' THEN 25000.0 else 500.0 END)*coalesce(total_bytes_billed, 0)/(1024*1024*1024*1024) AS cost_cents -- $5/TB EXCEPT FOR modeling which costs $250/TB
     , 25000.0*coalesce(total_bytes_billed, 0)/(1024*1024*1024*1024) AS cost_cents_modeling -- $250/TB
     , job_type
     , statement_type
     , priority, state, cache_hit
     , query AS q
     , error_result IS NULL AS success
     , TO_JSON_STRING (error_result) AS error_result
  FROM `region-us`.INFORMATION_SCHEMA.JOBS_BY_PROJECT
 order by start_time desc
;

--SELECT DISTINCT statement_type FROM TILDA.BQJobDetailsView
--SELECT *   FROM `region-us`.INFORMATION_SCHEMA.JOBS_BY_PROJECT
--WHERE REGEXP_CONTAINS(query, r'(?i)^\s*create\s+(or\s+replace\s+)?model\s+.*') = TRUE
--  AND statement_type <> 'CREATE_MODEL'
 

CREATE OR REPLACE VIEW TILDA.BQCostsView as
select project_id
     , CAST(DATE_TRUNC(start_time, DAY) as DATE) as day
     , user_email
     , statement_type
     , round(sum(cost_cents)/100.0, 2) cost_dollars
     , CASE WHEN sum(total_bytes_billed) < 1024           THEN cast(sum(total_bytes_billed) AS STRING)||' B'
            WHEN sum(total_bytes_billed) < 1024*1024      THEN cast(round(sum(total_bytes_billed)/1024.0, 2) AS STRING)||' KB'
            WHEN sum(total_bytes_billed) < 1024*1024*1024 THEN cast(round(sum(total_bytes_billed)/(1024.0*1024.0), 2) AS STRING)||' MB'
            ELSE cast(round(sum(total_bytes_billed)/(1024.0*1024.0*1024.0), 2) AS STRING)||' GB'
       END AS total_bytes_billed
from TILDA.BQJobDetailsView
WHERE total_bytes_billed IS NOT null
group by 1, 2, 3, 4
order by 1, 2, 3, 4
;


CREATE OR REPLACE PROCEDURE TILDA.BQJobDetailsMonthBackup()
BEGIN
	-- SCRIPT TO BE EXECUTED ON 2nd of each month
	DECLARE d_start DATE;
	DECLARE d_end DATE;
	
	set d_end = DATE_TRUNC(current_date(), MONTH);
	set d_start = DATE_SUB(d_end, interval 1 month);
	
	EXECUTE IMMEDIATE "create or replace table TILDA.BQJobDetails_"||FORMAT_DATE('%Y_%m', d_start)||" as select * from TILDA.BQJobDetailsView where start_time >= '"||d_start||"' and start_time < '"||d_end||"';";
END;





/*
with T as (
select * EXCEPT (success), success  from `capsicoprojects.TILDA.BQJobDetails_2022_01_18`
union ALL
select *, NULL AS success from `capsicoprojects.TILDA.BQJobDetails_2021_07_09`
)
select start_time, project_id, user_email, statement_type, q
  from T 
 where statement_type IS NOT NULL 
   AND user_email = 'some_user@company.com'
order BY start_time desc

select user_email, statement_type, count(*)
from T
group by 1, 2
order by 1, 2
*/

