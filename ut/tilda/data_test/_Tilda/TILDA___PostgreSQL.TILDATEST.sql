
create schema if not exists TILDATEST;



create table if not exists TILDATEST.Test -- The table to keep track tests amd owners
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "id"           varchar(128)  not null   -- The name of the test
  , "name"         varchar(128)  not null   -- The name of the test
  , "test_fk"      bigint        not null   -- The name of the test
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Test)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Test)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.Test)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Test_Test FOREIGN KEY ("test_fk") REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Test IS E'The table to keep track tests amd owners';
COMMENT ON COLUMN TILDATEST.Test."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Test."id" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."name" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."test_fk" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."created" IS E'The timestamp for when the record was created. (TILDATEST.Test)';
COMMENT ON COLUMN TILDATEST.Test."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Test)';
COMMENT ON COLUMN TILDATEST.Test."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Test)';
CREATE UNIQUE INDEX IF NOT EXISTS Test_Name ON TILDATEST.Test ("name");
delete from TILDA.Key where "name" = 'TILDATEST.TEST';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TEST',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Test), 250, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Test2 -- The table to keep track tests amd owners
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "name"         varchar(128)  not null   -- The name of the test
  , "test_fk"      bigint        not null   -- The name of the test
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Test2)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Test2)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.Test2)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Test2_Test FOREIGN KEY ("test_fk") REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Test2 IS E'The table to keep track tests amd owners';
COMMENT ON COLUMN TILDATEST.Test2."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Test2."name" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test2."test_fk" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test2."created" IS E'The timestamp for when the record was created. (TILDATEST.Test2)';
COMMENT ON COLUMN TILDATEST.Test2."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Test2)';
COMMENT ON COLUMN TILDATEST.Test2."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Test2)';
CREATE UNIQUE INDEX IF NOT EXISTS Test2_Name ON TILDATEST.Test2 ("name");
delete from TILDA.Key where "name" = 'TILDATEST.TEST2';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TEST2',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Test2), 250, current_timestamp, current_timestamp);



create table if not exists TILDATEST.User -- Users
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "id"           varchar(40)   not null   -- The user's id
  , "email"        varchar(255)  not null   -- The user's email
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.User)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.User)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.User)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDATEST.User IS E'Users';
COMMENT ON COLUMN TILDATEST.User."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.User."id" IS E'The user''s id';
COMMENT ON COLUMN TILDATEST.User."email" IS E'The user''s email';
COMMENT ON COLUMN TILDATEST.User."created" IS E'The timestamp for when the record was created. (TILDATEST.User)';
COMMENT ON COLUMN TILDATEST.User."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.User)';
COMMENT ON COLUMN TILDATEST.User."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.User)';
CREATE UNIQUE INDEX IF NOT EXISTS User_Id ON TILDATEST.User ("id");
CREATE UNIQUE INDEX IF NOT EXISTS User_Email ON TILDATEST.User ("email");
CREATE INDEX IF NOT EXISTS User_All ON TILDATEST.User ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATEST.USER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.USER',(select COALESCE(max("refnum"),0)+1 from TILDATEST.User), 500, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Form -- User-entered forms
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "userRefnum"   bigint        not null   -- The user who created the form
  , "type"         varchar(40)   not null   -- Form template type
  , "fillDateTZ"   character(5)             -- Generated helper column to hold the time zone ID for 'fillDate'.
  , "fillDate"     timestamptz              -- The date the form was filled
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Form)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Form)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.Form)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Form_User FOREIGN KEY ("userRefnum") REFERENCES TILDATEST.User ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Form_fillDate FOREIGN KEY ("fillDateTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Form IS E'User-entered forms';
COMMENT ON COLUMN TILDATEST.Form."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Form."userRefnum" IS E'The user who created the form';
COMMENT ON COLUMN TILDATEST.Form."type" IS E'Form template type';
COMMENT ON COLUMN TILDATEST.Form."fillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATEST.Form."fillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATEST.Form."created" IS E'The timestamp for when the record was created. (TILDATEST.Form)';
COMMENT ON COLUMN TILDATEST.Form."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Form)';
COMMENT ON COLUMN TILDATEST.Form."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Form)';
CREATE INDEX IF NOT EXISTS Form_Type ON TILDATEST.Form ("type", "fillDate" ASC);
CREATE INDEX IF NOT EXISTS Form_All ON TILDATEST.Form ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATEST.FORM';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.FORM',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Form), 500, current_timestamp, current_timestamp);



create table if not exists TILDATEST.FormAnswer -- Form answers
 (  "refnum"       bigint         not null   -- The primary key for this record
  , "formRefnum"   bigint         not null   -- The form's refnum
  , "field"        varchar(60)    not null   -- question/field id
  , "value"        varchar(4000)             -- answer value
  , "created"      timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.FormAnswer)
  , "lastUpdated"  timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.FormAnswer)
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted. (TILDATEST.FormAnswer)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_FormAnswer_Form FOREIGN KEY ("formRefnum") REFERENCES TILDATEST.Form ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.FormAnswer IS E'Form answers';
COMMENT ON COLUMN TILDATEST.FormAnswer."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.FormAnswer."formRefnum" IS E'The form''s refnum';
COMMENT ON COLUMN TILDATEST.FormAnswer."field" IS E'question/field id';
COMMENT ON COLUMN TILDATEST.FormAnswer."value" IS E'answer value';
COMMENT ON COLUMN TILDATEST.FormAnswer."created" IS E'The timestamp for when the record was created. (TILDATEST.FormAnswer)';
COMMENT ON COLUMN TILDATEST.FormAnswer."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.FormAnswer)';
COMMENT ON COLUMN TILDATEST.FormAnswer."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.FormAnswer)';
CREATE UNIQUE INDEX IF NOT EXISTS FormAnswer_FormAnswer ON TILDATEST.FormAnswer ("formRefnum", "field");
CREATE INDEX IF NOT EXISTS FormAnswer_All ON TILDATEST.FormAnswer ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATEST.FORMANSWER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.FORMANSWER',(select COALESCE(max("refnum"),0)+1 from TILDATEST.FormAnswer), 500, current_timestamp, current_timestamp);




-- DDL META DATA VERSION 2019-01-09
create or replace view TILDATEST.TestView as 
-- 'A join of test and user'
select TILDATEST.Test."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Test."name" as "name" -- The name of the test
  from TILDATEST.Test
 where (TILDATEST.Test."deleted" is null)
;


COMMENT ON VIEW TILDATEST.TestView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDATEST.TestView as \n-- ''A join of test and user''\nselect TILDATEST.Test."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Test."name" as "name" -- The name of the test\n  from TILDATEST.Test\n where (TILDATEST.Test."deleted" is null)\n;\n\n';

COMMENT ON COLUMN TILDATEST.TestView."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.TestView."name" IS E'The name of the test';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.TestView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDATEST.Form_SAT01_PivotView as 
with T as (
-- 'A pivoted view of SAT_01 forms'
select TILDATEST.Form."refnum" as "formRefnum" -- The primary key for this record
     , trim(TILDATEST.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATEST.Form."fillDate" as "formFillDate" -- The date the form was filled
     , TILDATEST.User."refnum" as "formUserRefnum" -- The primary key for this record
     , TILDATEST.User."email" as "formUserEmail" -- The user's email
     , TILDATEST.FormAnswer."field" as "field" -- question/field id
     , max(TILDATEST.FormAnswer."value") as "value" -- answer value
  from TILDATEST.Form
     inner join TILDATEST.User on TILDATEST.Form."userRefnum" = TILDATEST.User."refnum"
     left  join TILDATEST.FormAnswer on TILDATEST.FormAnswer."formRefnum" = TILDATEST.Form."refnum"
 where (    TILDATEST.Form."type" = 'SAT_01'
        and TILDATEST.Form."deleted" is null
        and TILDATEST.FormAnswer."deleted" is null
       )
   and ( TILDATEST.FormAnswer."field" in ('Q1', 'Q2', 'Q3', 'Q4')
       )
 group by 1, 2, 3, 4, 5, 6
) select "formRefnum" 
       , "formFillDateTZ" 
       , "formFillDate" 
       , "formUserRefnum" 
       , "formUserEmail" 
     , MAX("value") as "value"
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q1') ,null))::integer as "Q1"
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q2') ,null))::integer as "Q2"
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q3') ,null))::integer as "Q3"
     , MAX("value") filter (where "field"= 'Q4')  as "Q4"
from T
     group by 1, 2, 3, 4, 5
;


COMMENT ON VIEW TILDATEST.Form_SAT01_PivotView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDATEST.Form_SAT01_PivotView as \nwith T as (\n-- ''A pivoted view of SAT_01 forms''\nselect TILDATEST.Form."refnum" as "formRefnum" -- The primary key for this record\n     , trim(TILDATEST.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATEST.Form."fillDate" as "formFillDate" -- The date the form was filled\n     , TILDATEST.User."refnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATEST.User."email" as "formUserEmail" -- The user''s email\n     , TILDATEST.FormAnswer."field" as "field" -- question/field id\n     , max(TILDATEST.FormAnswer."value") as "value" -- answer value\n  from TILDATEST.Form\n     inner join TILDATEST.User on TILDATEST.Form."userRefnum" = TILDATEST.User."refnum"\n     left  join TILDATEST.FormAnswer on TILDATEST.FormAnswer."formRefnum" = TILDATEST.Form."refnum"\n where (    TILDATEST.Form."type" = ''SAT_01''\n        and TILDATEST.Form."deleted" is null\n        and TILDATEST.FormAnswer."deleted" is null\n       )\n   and ( TILDATEST.FormAnswer."field" in (''Q1'', ''Q2'', ''Q3'', ''Q4'')\n       )\n group by 1, 2, 3, 4, 5, 6\n) select "formRefnum" \n       , "formFillDateTZ" \n       , "formFillDate" \n       , "formUserRefnum" \n       , "formUserEmail" \n     , MAX("value") as "value"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q1'') ,null))::integer as "Q1"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q2'') ,null))::integer as "Q2"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q3'') ,null))::integer as "Q3"\n     , MAX("value") filter (where "field"= ''Q4'')  as "Q4"\nfrom T\n     group by 1, 2, 3, 4, 5\n;\n\n';

COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."formRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."formFillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."formUserRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."formUserEmail" IS E'The user''s email';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."Q1" IS E'Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field=''Q1'')';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."Q2" IS E'Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field=''Q2'')';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."Q3" IS E'Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field=''Q3'')';
COMMENT ON COLUMN TILDATEST.Form_SAT01_PivotView."Q4" IS E'Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field=''Q4'')';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.Form_SAT01_PivotView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;

