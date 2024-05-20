
create schema if not exists TILDATUTORIAL;



create table if not exists TILDATUTORIAL.User -- Users
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "id"           varchar(40)   not null   -- The user's id
  , "email"        varchar(255)  not null   -- The user's email
  , "created"      timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was created. (TILDATUTORIAL.User)
  , "lastUpdated"  timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was last updated. (TILDATUTORIAL.User)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATUTORIAL.User)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDATUTORIAL.User IS E'Users';
COMMENT ON COLUMN TILDATUTORIAL.User."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.User."id" IS E'The user''s id';
COMMENT ON COLUMN TILDATUTORIAL.User."email" IS E'The user''s email';
COMMENT ON COLUMN TILDATUTORIAL.User."created" IS E'The timestamp for when the record was created. (TILDATUTORIAL.User)';
COMMENT ON COLUMN TILDATUTORIAL.User."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATUTORIAL.User)';
COMMENT ON COLUMN TILDATUTORIAL.User."deleted" IS E'The timestamp for when the record was deleted. (TILDATUTORIAL.User)';
CREATE UNIQUE INDEX IF NOT EXISTS User_Id ON TILDATUTORIAL.User ("id");
CREATE UNIQUE INDEX IF NOT EXISTS User_Email ON TILDATUTORIAL.User ("email");
CREATE INDEX IF NOT EXISTS User_All ON TILDATUTORIAL.User ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATUTORIAL.USER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATUTORIAL.USER',(select COALESCE(max("refnum"),0)+1 from TILDATUTORIAL.User), 500, current_timestamp, current_timestamp);



create table if not exists TILDATUTORIAL.Form -- User-entered forms
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "userRefnum"   bigint        not null   -- The user who created the form
  , "type"         varchar(40)   not null   -- Form template type
  , "fillDateTZ"   character(5)             -- Generated helper column to hold the time zone ID for 'fillDate'.
  , "fillDate"     timestamptz              -- The date the form was filled
  , "created"      timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was created. (TILDATUTORIAL.Form)
  , "lastUpdated"  timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was last updated. (TILDATUTORIAL.Form)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATUTORIAL.Form)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Form_User FOREIGN KEY ("userRefnum") REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Form_fillDate FOREIGN KEY ("fillDateTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATUTORIAL.Form IS E'User-entered forms';
COMMENT ON COLUMN TILDATUTORIAL.Form."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Form."userRefnum" IS E'The user who created the form';
COMMENT ON COLUMN TILDATUTORIAL.Form."type" IS E'Form template type';
COMMENT ON COLUMN TILDATUTORIAL.Form."fillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Form."fillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Form."created" IS E'The timestamp for when the record was created. (TILDATUTORIAL.Form)';
COMMENT ON COLUMN TILDATUTORIAL.Form."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATUTORIAL.Form)';
COMMENT ON COLUMN TILDATUTORIAL.Form."deleted" IS E'The timestamp for when the record was deleted. (TILDATUTORIAL.Form)';
CREATE INDEX IF NOT EXISTS Form_Type ON TILDATUTORIAL.Form ("type", "fillDate" ASC);
CREATE INDEX IF NOT EXISTS Form_All ON TILDATUTORIAL.Form ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATUTORIAL.FORM';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATUTORIAL.FORM',(select COALESCE(max("refnum"),0)+1 from TILDATUTORIAL.Form), 500, current_timestamp, current_timestamp);



create table if not exists TILDATUTORIAL.FormAnswer -- Form answers
 (  "refnum"       bigint         not null   -- The primary key for this record
  , "formRefnum"   bigint         not null   -- The form's refnum
  , "field"        varchar(60)    not null   -- question/field id
  , "value"        varchar(4000)             -- answer value
  , "created"      timestamptz    not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was created. (TILDATUTORIAL.FormAnswer)
  , "lastUpdated"  timestamptz    not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was last updated. (TILDATUTORIAL.FormAnswer)
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted. (TILDATUTORIAL.FormAnswer)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_FormAnswer_Form FOREIGN KEY ("formRefnum") REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATUTORIAL.FormAnswer IS E'Form answers';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."formRefnum" IS E'The form''s refnum';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."field" IS E'question/field id';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."value" IS E'answer value';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."created" IS E'The timestamp for when the record was created. (TILDATUTORIAL.FormAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATUTORIAL.FormAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.FormAnswer."deleted" IS E'The timestamp for when the record was deleted. (TILDATUTORIAL.FormAnswer)';
CREATE UNIQUE INDEX IF NOT EXISTS FormAnswer_FormAnswer ON TILDATUTORIAL.FormAnswer ("formRefnum", "field");
CREATE INDEX IF NOT EXISTS FormAnswer_All ON TILDATUTORIAL.FormAnswer ("lastUpdated" ASC);
delete from TILDA.Key where "name" = 'TILDATUTORIAL.FORMANSWER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATUTORIAL.FORMANSWER',(select COALESCE(max("refnum"),0)+1 from TILDATUTORIAL.FormAnswer), 500, current_timestamp, current_timestamp);



create table if not exists TILDATUTORIAL.TestQuestionAnswer -- Questions and answers for multiple-choice tests
 (  "refnum"         bigint        not null   -- The primary key for this record
  , "type"           varchar(60)   not null   -- Form template type
  , "questionSeq"    integer       not null   -- Sequence of the question for the test
  , "questionId"     varchar(60)   not null   -- Question id
  , "questionLabel"  varchar(256)  not null   -- Question label
  , "answerSeq"      integer       not null   -- Sequence of the answer for the question in the test
  , "answerId"       varchar(60)   not null   -- Answer id
  , "answerLabel"    varchar(256)  not null   -- Answer label
  , "correct"        smallint      not null   -- Whether the answer is a correct one or not for that question (technically, there could be more than one)
  , "created"        timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)
  , "lastUpdated"    timestamptz   not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDATUTORIAL.TestQuestionAnswer IS E'Questions and answers for multiple-choice tests';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."type" IS E'Form template type';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."questionSeq" IS E'Sequence of the question for the test';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."questionId" IS E'Question id';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."questionLabel" IS E'Question label';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."answerSeq" IS E'Sequence of the answer for the question in the test';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."answerId" IS E'Answer id';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."answerLabel" IS E'Answer label';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."correct" IS E'Whether the answer is a correct one or not for that question (technically, there could be more than one)';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."created" IS E'The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.TestQuestionAnswer."deleted" IS E'The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)';
CREATE UNIQUE INDEX IF NOT EXISTS TestQuestionAnswer_FormAnswer ON TILDATUTORIAL.TestQuestionAnswer ("type", "questionId", "answerSeq");
-- app-level index only -- CREATE INDEX IF NOT EXISTS TestQuestionAnswer_Form ON TILDATUTORIAL.TestQuestionAnswer ("type", "questionId" ASC, "answerSeq" ASC);
delete from TILDA.Key where "name" = 'TILDATUTORIAL.TESTQUESTIONANSWER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATUTORIAL.TESTQUESTIONANSWER',(select COALESCE(max("refnum"),0)+1 from TILDATUTORIAL.TestQuestionAnswer), 500, current_timestamp, current_timestamp);



create table if not exists TILDATUTORIAL.TestAnswer -- Test answers
 (  "refnum"       bigint       not null   -- The primary key for this record
  , "formRefnum"   bigint       not null   -- The form's refnum
  , "questionId"   varchar(60)  not null   -- Question id
  , "answerId"     varchar(60)             -- Answer value
  , "timeMillis"   integer      not null   -- Time in milliseconds for the time spent answering the question
  , "correct"      smallint     not null   -- Whether the answer is correct or not
  , "created"      timestamptz  not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)
  , "lastUpdated"  timestamptz  not null DEFAULT (statement_timestamp() at time zone 'utc')   -- The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)
  , "deleted"      timestamptz             -- The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_TestAnswer_Form FOREIGN KEY ("formRefnum") REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATUTORIAL.TestAnswer IS E'Test answers';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."formRefnum" IS E'The form''s refnum';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."questionId" IS E'Question id';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."answerId" IS E'Answer value';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."timeMillis" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."correct" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."created" IS E'The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)';
COMMENT ON COLUMN TILDATUTORIAL.TestAnswer."deleted" IS E'The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)';
CREATE UNIQUE INDEX IF NOT EXISTS TestAnswer_FormAnswer ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId");
CREATE INDEX IF NOT EXISTS TestAnswer_Form ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId" ASC);
delete from TILDA.Key where "name" = 'TILDATUTORIAL.TESTANSWER';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATUTORIAL.TESTANSWER',(select COALESCE(max("refnum"),0)+1 from TILDATUTORIAL.TestAnswer), 500, current_timestamp, current_timestamp);




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Form_SAT01_PivotView as 
with T as (
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record
     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled
     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record
     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user's email
     , TILDATUTORIAL.FormAnswer."field" as "field" -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , max(TILDATUTORIAL.FormAnswer."value") as "value" -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"
     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"
 where (    TILDATUTORIAL.Form."type" = 'SAT_01'
        and TILDATUTORIAL.Form."deleted"is null
        and TILDATUTORIAL.FormAnswer."deleted"is null
       )
   and ( TILDATUTORIAL.FormAnswer."field" in ('Q1', 'Q2', 'Q3', 'Q4')
       )
 group by 1, 2, 3, 4, 5, 6
) select "formRefnum" 
       , "formFillDateTZ" 
       , "formFillDate" 
       , "formUserRefnum" 
       , "formUserEmail" 
     , MAX("value") as "value"
     , (Tilda.toInt(max("value") filter (where "field" = 'Q1') ,null))::integer as "Q1"
     , (Tilda.toInt(max("value") filter (where "field" = 'Q2') ,null))::integer as "Q2"
     , (Tilda.toInt(max("value") filter (where "field" = 'Q3') ,null))::integer as "Q3"
     , max("value") filter (where "field" = 'Q4')  as "Q4"
from T
     group by 1, 2, 3, 4, 5
;


COMMENT ON VIEW TILDATUTORIAL.Form_SAT01_PivotView IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Form_SAT01_PivotView as \nwith T as (\n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record\n     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled\n     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user''s email\n     , TILDATUTORIAL.FormAnswer."field" as "field" -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , max(TILDATUTORIAL.FormAnswer."value") as "value" -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"\n     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"\n where (    TILDATUTORIAL.Form."type" = ''SAT_01''\n        and TILDATUTORIAL.Form."deleted"is null\n        and TILDATUTORIAL.FormAnswer."deleted"is null\n       )\n   and ( TILDATUTORIAL.FormAnswer."field" in (''Q1'', ''Q2'', ''Q3'', ''Q4'')\n       )\n group by 1, 2, 3, 4, 5, 6\n) select "formRefnum" \n       , "formFillDateTZ" \n       , "formFillDate" \n       , "formUserRefnum" \n       , "formUserEmail" \n     , MAX("value") as "value"\n     , (Tilda.toInt(max("value") filter (where "field" = ''Q1'') ,null))::integer as "Q1"\n     , (Tilda.toInt(max("value") filter (where "field" = ''Q2'') ,null))::integer as "Q2"\n     , (Tilda.toInt(max("value") filter (where "field" = ''Q3'') ,null))::integer as "Q3"\n     , max("value") filter (where "field" = ''Q4'')  as "Q4"\nfrom T\n     group by 1, 2, 3, 4, 5\n;\n\n';

COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formFillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formUserRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formUserEmail" IS E'The user''s email';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q1" IS E'Q1 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q1'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q2" IS E'Q2 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q2'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q3" IS E'Q3 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q3'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q4" IS E'Q4 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q4'')';


