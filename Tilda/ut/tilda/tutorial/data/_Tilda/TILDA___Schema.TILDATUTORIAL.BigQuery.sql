
create schema if not exists TILDATUTORIAL;



create table if not exists TILDATUTORIAL.User -- Users
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `id`           STRING     not null  OPTIONS(description="The user's id")
  , `email`        STRING     not null  OPTIONS(description="The user's email")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.User)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.User)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.User)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Users");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS User_Id ON TILDATUTORIAL.User ("id");
--  CREATE UNIQUE INDEX IF NOT EXISTS User_Email ON TILDATUTORIAL.User ("email");
--  CREATE INDEX IF NOT EXISTS User_All ON TILDATUTORIAL.User ("lastUpdated" ASC);



create table if not exists TILDATUTORIAL.Form -- User-entered forms
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `userRefnum`   INT64      not null  OPTIONS(description="The user who created the form")
  , `type`         STRING     not null  OPTIONS(description="Form template type")
  , `fillDateTZ`   STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'fillDate'.")
  , `fillDate`     TIMESTAMP            OPTIONS(description="The date the form was filled")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.Form)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.Form)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.Form)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`userRefnum`) REFERENCES TILDATUTORIAL.User(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`fillDateTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
 )
OPTIONS (description="User-entered forms");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Form_Type ON TILDATUTORIAL.Form ("type", "fillDate" ASC);
--  CREATE INDEX IF NOT EXISTS Form_All ON TILDATUTORIAL.Form ("lastUpdated" ASC);



create table if not exists TILDATUTORIAL.FormAnswer -- Form answers
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `formRefnum`   INT64      not null  OPTIONS(description="The form's refnum")
  , `field`        STRING     not null  OPTIONS(description="question/field id")
  , `value`        STRING               OPTIONS(description="answer value")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.FormAnswer)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.FormAnswer)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.FormAnswer)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Form answers");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS FormAnswer_FormAnswer ON TILDATUTORIAL.FormAnswer ("formRefnum", "field");
--  CREATE INDEX IF NOT EXISTS FormAnswer_All ON TILDATUTORIAL.FormAnswer ("lastUpdated" ASC);



create table if not exists TILDATUTORIAL.TestQuestionAnswer -- Questions and answers for multiple-choice tests
 (  `refnum`         INT64      not null  OPTIONS(description="The primary key for this record")
  , `type`           STRING     not null  OPTIONS(description="Form template type")
  , `questionSeq`    INT64      not null  OPTIONS(description="Sequence of the question for the test")
  , `questionId`     STRING     not null  OPTIONS(description="Question id")
  , `questionLabel`  STRING     not null  OPTIONS(description="Question label")
  , `answerSeq`      INT64      not null  OPTIONS(description="Sequence of the answer for the question in the test")
  , `answerId`       STRING     not null  OPTIONS(description="Answer id")
  , `answerLabel`    STRING     not null  OPTIONS(description="Answer label")
  , `correct`        INT64      not null  OPTIONS(description="Whether the answer is a correct one or not for that question (technically, there could be more than one)")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Questions and answers for multiple-choice tests");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS TestQuestionAnswer_FormAnswer ON TILDATUTORIAL.TestQuestionAnswer ("type", "questionId", "answerSeq");
--  CREATE INDEX IF NOT EXISTS TestQuestionAnswer_Form ON TILDATUTORIAL.TestQuestionAnswer ("type", "questionId" ASC, "answerSeq" ASC);



create table if not exists TILDATUTORIAL.TestAnswer -- Test answers
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `formRefnum`   INT64      not null  OPTIONS(description="The form's refnum")
  , `questionId`   STRING     not null  OPTIONS(description="Question id")
  , `answerId`     STRING               OPTIONS(description="Answer value")
  , `timeMillis`   INT64      not null  OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `correct`      INT64      not null  OPTIONS(description="Whether the answer is correct or not")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Test answers");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS TestAnswer_FormAnswer ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId");
--  CREATE INDEX IF NOT EXISTS TestAnswer_Form ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId" ASC);




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Form_SAT01_PivotView as 
with T as (
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record
     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for 'formFillDate'.
     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled
     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record
     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user's email
     , TILDATUTORIAL.FormAnswer.`field` as `field` -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , max(TILDATUTORIAL.FormAnswer.`value`) as `value` -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`
     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`
 where (    TILDATUTORIAL.Form.`type` = 'SAT_01'
        and TILDATUTORIAL.Form.`deleted`is null
        and TILDATUTORIAL.FormAnswer.`deleted`is null
       )
   and ( TILDATUTORIAL.FormAnswer.`field` in ('Q1', 'Q2', 'Q3', 'Q4')
       )
 group by 1, 2, 3, 4, 5, 6
) select `formRefnum` 
       , `formFillDateTZ` 
       , `formFillDate` 
       , `formUserRefnum` 
       , `formUserEmail` 
     , MAX(`value`) as `value`
     , (Tilda.toInt(max(case when "field" = 'Q1' then `value` else null end),null))::INT64 as `Q1`
     , (Tilda.toInt(max(case when "field" = 'Q2' then `value` else null end),null))::INT64 as `Q2`
     , (Tilda.toInt(max(case when "field" = 'Q3' then `value` else null end),null))::INT64 as `Q3`
     , max(case when "field" = 'Q4' then `value` else null end) as `Q4`
from T
     group by 1, 2, 3, 4, 5
;


ALTER VIEW TILDATUTORIAL.Form_SAT01_PivotView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Form_SAT01_PivotView as \nwith T as (\n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for ''formFillDate''.\n     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled\n     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record\n     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user''s email\n     , TILDATUTORIAL.FormAnswer.`field` as `field` -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , max(TILDATUTORIAL.FormAnswer.`value`) as `value` -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`\n     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`\n where (    TILDATUTORIAL.Form.`type` = ''SAT_01''\n        and TILDATUTORIAL.Form.`deleted`is null\n        and TILDATUTORIAL.FormAnswer.`deleted`is null\n       )\n   and ( TILDATUTORIAL.FormAnswer.`field` in (''Q1'', ''Q2'', ''Q3'', ''Q4'')\n       )\n group by 1, 2, 3, 4, 5, 6\n) select `formRefnum` \n       , `formFillDateTZ` \n       , `formFillDate` \n       , `formUserRefnum` \n       , `formUserEmail` \n     , MAX(`value`) as `value`\n     , (Tilda.toInt(max(case when "field" = ''Q1'' then `value` else null end),null))::INT64 as `Q1`\n     , (Tilda.toInt(max(case when "field" = ''Q2'' then `value` else null end),null))::INT64 as `Q2`\n     , (Tilda.toInt(max(case when "field" = ''Q3'' then `value` else null end),null))::INT64 as `Q3`\n     , max(case when "field" = ''Q4'' then `value` else null end) as `Q4`\nfrom T\n     group by 1, 2, 3, 4, 5\n;\n\n');



