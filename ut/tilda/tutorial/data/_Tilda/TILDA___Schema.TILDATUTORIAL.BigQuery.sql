
create schema if not exists TILDATUTORIAL;



create table if not exists TILDATUTORIAL.User -- Users
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `id`           STRING     not null  OPTIONS(description="The user's id")
  , `email`        STRING     not null  OPTIONS(description="The user's email")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.User)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.User)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.User)")
  -- PRIMARY KEY(`refnum`)
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
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Form_User FOREIGN KEY (`userRefnum`) REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Form_fillDate FOREIGN KEY (`fillDateTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
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
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_FormAnswer_Form FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
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
  , `correct`        BOOLEAN    not null  OPTIONS(description="Whether the answer is a correct one or not for that question (technically, there could be more than one)")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)")
  -- PRIMARY KEY(`refnum`)
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
  , `correct`      BOOLEAN    not null  OPTIONS(description="Whether the answer is correct or not")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestAnswer_Form FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Test answers");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS TestAnswer_FormAnswer ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId");
--  CREATE INDEX IF NOT EXISTS TestAnswer_Form ON TILDATUTORIAL.TestAnswer ("formRefnum", "questionId" ASC);



create table if not exists TILDATUTORIAL.Test_XYZ_Realized -- Realized table for view TILDATUTORIAL.Test_XYZ_PivotView: A pivoted view of XYZ forms
 (  `formRefnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `formType`         STRING               OPTIONS(description="Form template type")
  , `formFillDateTZ`   STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'formFillDate'.")
  , `formFillDate`     TIMESTAMP            OPTIONS(description="The date the form was filled")
  , `formUserRefnum`   INT64                OPTIONS(description="The primary key for this record")
  , `formUserEmail`    STRING               OPTIONS(description="The user's email")
  , `countCorrect`     INT64                OPTIONS(description="Whether the answer is correct or not")
  , `countIncorrect`   INT64                OPTIONS(description="Whether the answer is correct or not")
  , `timeMillisTotal`  INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `timeMillisAvg`    FLOAT64              OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `timeMillisMin`    INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `QX_correct`       BOOLEAN              OPTIONS(description="Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QX')")
  , `QX_timeMillis`    INT64                OPTIONS(description="Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QX')")
  , `QY_correct`       BOOLEAN              OPTIONS(description="Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QY')")
  , `QY_timeMillis`    INT64                OPTIONS(description="Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QY')")
  , `QZ_correct`       BOOLEAN              OPTIONS(description="Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QZ')")
  , `QZ_timeMillis`    INT64                OPTIONS(description="Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QZ')")
  -- PRIMARY KEY(`formRefnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test_XYZ_Realized_Form FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test_XYZ_Realized_User FOREIGN KEY (`formUserRefnum`) REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Realized table for view TILDATUTORIAL.Test_XYZ_PivotView: A pivoted view of XYZ forms");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Test_XYZ_Realized_User ON TILDATUTORIAL.Test_XYZ_Realized ("formUserRefnum", "formFillDate" DESC);
--  CREATE INDEX IF NOT EXISTS Test_XYZ_Realized_Type ON TILDATUTORIAL.Test_XYZ_Realized ("formType", "formFillDate" DESC);



create table if not exists TILDATUTORIAL.Test_Realized -- Realized table for view TILDATUTORIAL.Test_View: A pivoted view of SAT_01 forms
 (  `type`                  STRING     not null  OPTIONS(description="Form template type")
  , `testCount`             INT64                OPTIONS(description="The primary key for this record")
  , `testFirstTZ`           STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'testFirst'.")
  , `testFirst`             TIMESTAMP            OPTIONS(description="The date the form was filled")
  , `testLastTZ`            STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'testLast'.")
  , `testLast`              TIMESTAMP            OPTIONS(description="The date the form was filled")
  , `userCount`             INT64                OPTIONS(description="The primary key for this record")
  , `answerCount`           INT64                OPTIONS(description="Whether the answer is correct or not")
  , `answerCountCorrect`    INT64                OPTIONS(description="Whether the answer is correct or not")
  , `answerCountIncorrect`  INT64                OPTIONS(description="Whether the answer is correct or not")
  , `timeMillisTotal`       INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `timeMillisAvg`         FLOAT64              OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `timeMillisMin`         INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `timeMillisMax`         INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  -- PRIMARY KEY(`type`)
 )
OPTIONS (description="Realized table for view TILDATUTORIAL.Test_View: A pivoted view of SAT_01 forms");



create table if not exists TILDATUTORIAL.Test_XYZ_Analytics_Realized -- Realized table for view TILDATUTORIAL.Test_XYZ_Analytics_View: A view of XYZ forms with analytics
 (  `formRefnum`              INT64      not null  OPTIONS(description="The primary key for this record")
  , `formType`                STRING               OPTIONS(description="Form template type")
  , `formFillDateTZ`          STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'formFillDate'.")
  , `formFillDate`            TIMESTAMP            OPTIONS(description="The date the form was filled")
  , `formUserRefnum`          INT64                OPTIONS(description="The primary key for this record")
  , `formUserEmail`           STRING               OPTIONS(description="The user's email")
  , `formCountCorrect`        INT64                OPTIONS(description="Whether the answer is correct or not")
  , `formTimeMillisTotal`     INT64                OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `testCount`               INT64                OPTIONS(description="The primary key for this record")
  , `testAnswerCountCorrect`  INT64                OPTIONS(description="Whether the answer is correct or not")
  , `testTimeMillisAvg`       FLOAT64              OPTIONS(description="Time in milliseconds for the time spent answering the question")
  , `isPassed`                INT64                OPTIONS(description="<B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.")
  , `tookLongerThanAverage`   INT64                OPTIONS(description="<B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.")
  , `wasChallenging`          INT64                OPTIONS(description="<B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL>")
  -- PRIMARY KEY(`formRefnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test_XYZ_Analytics_Realized_Form FOREIGN KEY (`formRefnum`) REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test_XYZ_Analytics_Realized_User FOREIGN KEY (`formUserRefnum`) REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Realized table for view TILDATUTORIAL.Test_XYZ_Analytics_View: A view of XYZ forms with analytics");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Test_XYZ_Analytics_Realized_User ON TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formUserRefnum", "formFillDate" DESC);
--  CREATE INDEX IF NOT EXISTS Test_XYZ_Analytics_Realized_Type ON TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formType", "formFillDate" DESC);




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Form_SAT01_PivotView as 
with T as (
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record
     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled
     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record
     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user's email
     , TILDATUTORIAL.FormAnswer.`field` as `field` -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , max(TILDATUTORIAL.FormAnswer.`value`) as `value` -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`
     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`
 where (    TILDATUTORIAL.Form.`type` = 'SAT_01'
        and TILDATUTORIAL.Form.`deleted` is null
        and TILDATUTORIAL.FormAnswer.`deleted` is null
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


ALTER VIEW TILDATUTORIAL.Form_SAT01_PivotView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Form_SAT01_PivotView as \nwith T as (\n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled\n     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record\n     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user''s email\n     , TILDATUTORIAL.FormAnswer.`field` as `field` -- question/field id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , max(TILDATUTORIAL.FormAnswer.`value`) as `value` -- answer value -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`\n     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`\n where (    TILDATUTORIAL.Form.`type` = ''SAT_01''\n        and TILDATUTORIAL.Form.`deleted` is null\n        and TILDATUTORIAL.FormAnswer.`deleted` is null\n       )\n   and ( TILDATUTORIAL.FormAnswer.`field` in (''Q1'', ''Q2'', ''Q3'', ''Q4'')\n       )\n group by 1, 2, 3, 4, 5, 6\n) select `formRefnum` \n       , `formFillDateTZ` \n       , `formFillDate` \n       , `formUserRefnum` \n       , `formUserEmail` \n     , MAX(`value`) as `value`\n     , (Tilda.toInt(max(case when "field" = ''Q1'' then `value` else null end),null))::INT64 as `Q1`\n     , (Tilda.toInt(max(case when "field" = ''Q2'' then `value` else null end),null))::INT64 as `Q2`\n     , (Tilda.toInt(max(case when "field" = ''Q3'' then `value` else null end),null))::INT64 as `Q3`\n     , max(case when "field" = ''Q4'' then `value` else null end) as `Q4`\nfrom T\n     group by 1, 2, 3, 4, 5\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Test_XYZ_PivotView as 
with T as (
-- 'A pivoted view of XYZ forms'
select TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record
     , TILDATUTORIAL.Form.`type` as `formType` -- Form template type
     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled
     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record
     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user's email
     , TILDATUTORIAL.TestAnswer.`questionId` as `questionId` -- Question id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , count(case when correct = true then TILDATUTORIAL.TestAnswer.`correct` else null end) as `countCorrect` -- Whether the answer is correct or not
     , count(case when correct = false then TILDATUTORIAL.TestAnswer.`correct` else null end) as `countIncorrect` -- Whether the answer is correct or not
     , sum(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisTotal` -- Time in milliseconds for the time spent answering the question
     , avg(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisAvg` -- Time in milliseconds for the time spent answering the question
     , min(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMin` -- Time in milliseconds for the time spent answering the question
     , max(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMax` -- Time in milliseconds for the time spent answering the question -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`
     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`
 where (    TILDATUTORIAL.Form.`type` = 'XYZ'
        and TILDATUTORIAL.Form.`deleted` is null
        and TILDATUTORIAL.TestAnswer.`deleted` is null
       )
   and ( TILDATUTORIAL.TestAnswer.`questionId` in ('QX', 'QY', 'QZ')
       )
 group by 1, 2, 3, 4, 5, 6, 7
) select `formRefnum` 
       , `formType` 
       , `formFillDateTZ` 
       , `formFillDate` 
       , `formUserRefnum` 
       , `formUserEmail` 
     , SUM(`countCorrect`) as `countCorrect`
     , SUM(`countIncorrect`) as `countIncorrect`
     , SUM(`timeMillisTotal`) as `timeMillisTotal`
     , MIN(`timeMillisMin`) as `timeMillisMin`
     , MAX(`timeMillisMax`) as `timeMillisMax`
     , MIN(`correct`) as `correct`
     , min(case when "questionId" = 'QX' then `correct` else null end) as `QX_correct`
     , max(case when "questionId" = 'QX' then `timeMillisMax` else null end) as `QX_timeMillis`
     , min(case when "questionId" = 'QY' then `correct` else null end) as `QY_correct`
     , max(case when "questionId" = 'QY' then `timeMillisMax` else null end) as `QY_timeMillis`
     , min(case when "questionId" = 'QZ' then `correct` else null end) as `QZ_correct`
     , max(case when "questionId" = 'QZ' then `timeMillisMax` else null end) as `QZ_timeMillis`
from T
     group by 1, 2, 3, 4, 5, 6
;


DROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Realized();
CREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Realized()
 RETURNS boolean AS $$
declare
  startDt        timestamptz;
  insertStartDt  timestamptz;
  insertEndDt    timestamptz;
  deleteStartDt  timestamptz;
  deleteEndDt    timestamptz;
  analyzeStartDt timestamptz;
  analyzeEndDt   timestamptz;
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_XYZ_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_XYZ_Realized (`formRefnum`, `formType`, `formFillDateTZ`, `formFillDate`, `formUserRefnum`, `formUserEmail`, `countCorrect`, `countIncorrect`, `timeMillisTotal`, `timeMillisAvg`, `timeMillisMin`, `QX_correct`, `QX_timeMillis`, `QY_correct`, `QY_timeMillis`, `QZ_correct`, `QZ_timeMillis`)
     SELECT /*genRealizedColumnList*/`formRefnum` -- COLUMN
          ,`formType` -- COLUMN
          ,`formFillDateTZ` -- COLUMN
          ,`formFillDate` -- COLUMN
          ,`formUserRefnum` -- COLUMN
          ,`formUserEmail` -- COLUMN
          -- `questionId` -- BLOCKED
          ,`countCorrect` -- COLUMN
          ,`countIncorrect` -- COLUMN
          ,`timeMillisTotal` -- COLUMN
          ,`timeMillisAvg` -- COLUMN
          ,`timeMillisMin` -- COLUMN
          -- `timeMillisMax` -- BLOCKED
          -- `correct` -- BLOCKED
          , `QX_correct` -- PIVOT COLUMN
          , `QX_timeMillis` -- PIVOT COLUMN
          , `QY_correct` -- PIVOT COLUMN
          , `QY_timeMillis` -- PIVOT COLUMN
          , `QZ_correct` -- PIVOT COLUMN
          , `QZ_timeMillis` -- PIVOT COLUMN
     FROM TILDATUTORIAL.Test_XYZ_PivotView;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_XYZ_Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
                        VALUES('TILDATUTORIAL', 'Test_XYZ_Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

ALTER VIEW TILDATUTORIAL.Test_XYZ_PivotView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Test_XYZ_PivotView as \nwith T as (\n-- ''A pivoted view of XYZ forms''\nselect TILDATUTORIAL.Form.`refnum` as `formRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Form.`type` as `formType` -- Form template type\n     , TILDATUTORIAL.Form.`fillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATUTORIAL.Form.`fillDate` as `formFillDate` -- The date the form was filled\n     , TILDATUTORIAL.User.`refnum` as `formUserRefnum` -- The primary key for this record\n     , TILDATUTORIAL.User.`email` as `formUserEmail` -- The user''s email\n     , TILDATUTORIAL.TestAnswer.`questionId` as `questionId` -- Question id -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , count(case when correct = true then TILDATUTORIAL.TestAnswer.`correct` else null end) as `countCorrect` -- Whether the answer is correct or not\n     , count(case when correct = false then TILDATUTORIAL.TestAnswer.`correct` else null end) as `countIncorrect` -- Whether the answer is correct or not\n     , sum(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisTotal` -- Time in milliseconds for the time spent answering the question\n     , avg(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisAvg` -- Time in milliseconds for the time spent answering the question\n     , min(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMin` -- Time in milliseconds for the time spent answering the question\n     , max(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMax` -- Time in milliseconds for the time spent answering the question -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`\n     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`\n where (    TILDATUTORIAL.Form.`type` = ''XYZ''\n        and TILDATUTORIAL.Form.`deleted` is null\n        and TILDATUTORIAL.TestAnswer.`deleted` is null\n       )\n   and ( TILDATUTORIAL.TestAnswer.`questionId` in (''QX'', ''QY'', ''QZ'')\n       )\n group by 1, 2, 3, 4, 5, 6, 7\n) select `formRefnum` \n       , `formType` \n       , `formFillDateTZ` \n       , `formFillDate` \n       , `formUserRefnum` \n       , `formUserEmail` \n     , SUM(`countCorrect`) as `countCorrect`\n     , SUM(`countIncorrect`) as `countIncorrect`\n     , SUM(`timeMillisTotal`) as `timeMillisTotal`\n     , MIN(`timeMillisMin`) as `timeMillisMin`\n     , MAX(`timeMillisMax`) as `timeMillisMax`\n     , MIN(`correct`) as `correct`\n     , min(case when "questionId" = ''QX'' then `correct` else null end) as `QX_correct`\n     , max(case when "questionId" = ''QX'' then `timeMillisMax` else null end) as `QX_timeMillis`\n     , min(case when "questionId" = ''QY'' then `correct` else null end) as `QY_correct`\n     , max(case when "questionId" = ''QY'' then `timeMillisMax` else null end) as `QY_timeMillis`\n     , min(case when "questionId" = ''QZ'' then `correct` else null end) as `QZ_correct`\n     , max(case when "questionId" = ''QZ'' then `timeMillisMax` else null end) as `QZ_timeMillis`\nfrom T\n     group by 1, 2, 3, 4, 5, 6\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_XYZ_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_XYZ_Realized (`formRefnum`, `formType`, `formFillDateTZ`, `formFillDate`, `formUserRefnum`, `formUserEmail`, `countCorrect`, `countIncorrect`, `timeMillisTotal`, `timeMillisAvg`, `timeMillisMin`, `QX_correct`, `QX_timeMillis`, `QY_correct`, `QY_timeMillis`, `QZ_correct`, `QZ_timeMillis`)\n     SELECT /*genRealizedColumnList*/`formRefnum` -- COLUMN\n          ,`formType` -- COLUMN\n          ,`formFillDateTZ` -- COLUMN\n          ,`formFillDate` -- COLUMN\n          ,`formUserRefnum` -- COLUMN\n          ,`formUserEmail` -- COLUMN\n          -- `questionId` -- BLOCKED\n          ,`countCorrect` -- COLUMN\n          ,`countIncorrect` -- COLUMN\n          ,`timeMillisTotal` -- COLUMN\n          ,`timeMillisAvg` -- COLUMN\n          ,`timeMillisMin` -- COLUMN\n          -- `timeMillisMax` -- BLOCKED\n          -- `correct` -- BLOCKED\n          , `QX_correct` -- PIVOT COLUMN\n          , `QX_timeMillis` -- PIVOT COLUMN\n          , `QY_correct` -- PIVOT COLUMN\n          , `QY_timeMillis` -- PIVOT COLUMN\n          , `QZ_correct` -- PIVOT COLUMN\n          , `QZ_timeMillis` -- PIVOT COLUMN\n     FROM TILDATUTORIAL.Test_XYZ_PivotView;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_XYZ_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATUTORIAL'', ''Test_XYZ_Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Test_View as 
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form.`type` as `type` -- Form template type
     , count(distinct TILDATUTORIAL.Form.`refnum`) as `testCount` -- The primary key for this record
     , first(TILDATUTORIAL.Form.`fillDateTZ` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testFirstTZ` -- Generated helper column to hold the time zone ID for 'fillDate'.
     , first(TILDATUTORIAL.Form.`fillDate` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testFirst` -- The date the form was filled
     , last(TILDATUTORIAL.Form.`fillDateTZ` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testLastTZ` -- Generated helper column to hold the time zone ID for 'fillDate'.
     , last(TILDATUTORIAL.Form.`fillDate` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testLast` -- The date the form was filled
     , count(distinct TILDATUTORIAL.User.`refnum`) as `userCount` -- The primary key for this record
     , count(TILDATUTORIAL.TestAnswer.`correct`) as `answerCount` -- Whether the answer is correct or not
     , count(case when correct = true then TILDATUTORIAL.TestAnswer.`correct` else null end) as `answerCountCorrect` -- Whether the answer is correct or not
     , count(case when correct = false then TILDATUTORIAL.TestAnswer.`correct` else null end) as `answerCountIncorrect` -- Whether the answer is correct or not
     , sum(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisTotal` -- Time in milliseconds for the time spent answering the question
     , avg(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisAvg` -- Time in milliseconds for the time spent answering the question
     , min(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMin` -- Time in milliseconds for the time spent answering the question
     , max(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMax` -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`
     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`
 where (    TILDATUTORIAL.Form.`deleted` is null
        and TILDATUTORIAL.TestAnswer.`deleted` is null
       )
     group by 1
;


DROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_Realized();
CREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_Realized()
 RETURNS boolean AS $$
declare
  startDt        timestamptz;
  insertStartDt  timestamptz;
  insertEndDt    timestamptz;
  deleteStartDt  timestamptz;
  deleteEndDt    timestamptz;
  analyzeStartDt timestamptz;
  analyzeEndDt   timestamptz;
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_Realized (`type`, `testCount`, `testFirstTZ`, `testFirst`, `testLastTZ`, `testLast`, `userCount`, `answerCount`, `answerCountCorrect`, `answerCountIncorrect`, `timeMillisTotal`, `timeMillisAvg`, `timeMillisMin`, `timeMillisMax`)
     SELECT /*genRealizedColumnList*/`type` -- COLUMN
          -- `fillDateTZ` -- VIEW-EXCLUDED
          -- `fillDate` -- VIEW-EXCLUDED
          ,`testCount` -- COLUMN
          ,`testFirstTZ` -- COLUMN
          ,`testFirst` -- COLUMN
          ,`testLastTZ` -- COLUMN
          ,`testLast` -- COLUMN
          ,`userCount` -- COLUMN
          ,`answerCount` -- COLUMN
          ,`answerCountCorrect` -- COLUMN
          ,`answerCountIncorrect` -- COLUMN
          ,`timeMillisTotal` -- COLUMN
          ,`timeMillisAvg` -- COLUMN
          ,`timeMillisMin` -- COLUMN
          ,`timeMillisMax` -- COLUMN
     FROM TILDATUTORIAL.Test_View;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
                        VALUES('TILDATUTORIAL', 'Test_Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

ALTER VIEW TILDATUTORIAL.Test_View set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Test_View as \n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form.`type` as `type` -- Form template type\n     , count(distinct TILDATUTORIAL.Form.`refnum`) as `testCount` -- The primary key for this record\n     , first(TILDATUTORIAL.Form.`fillDateTZ` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testFirstTZ` -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , first(TILDATUTORIAL.Form.`fillDate` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testFirst` -- The date the form was filled\n     , last(TILDATUTORIAL.Form.`fillDateTZ` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testLastTZ` -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , last(TILDATUTORIAL.Form.`fillDate` order by TILDATUTORIAL.Form.`fillDate` ASC) as `testLast` -- The date the form was filled\n     , count(distinct TILDATUTORIAL.User.`refnum`) as `userCount` -- The primary key for this record\n     , count(TILDATUTORIAL.TestAnswer.`correct`) as `answerCount` -- Whether the answer is correct or not\n     , count(case when correct = true then TILDATUTORIAL.TestAnswer.`correct` else null end) as `answerCountCorrect` -- Whether the answer is correct or not\n     , count(case when correct = false then TILDATUTORIAL.TestAnswer.`correct` else null end) as `answerCountIncorrect` -- Whether the answer is correct or not\n     , sum(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisTotal` -- Time in milliseconds for the time spent answering the question\n     , avg(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisAvg` -- Time in milliseconds for the time spent answering the question\n     , min(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMin` -- Time in milliseconds for the time spent answering the question\n     , max(TILDATUTORIAL.TestAnswer.`timeMillis`) as `timeMillisMax` -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form.`userRefnum` = TILDATUTORIAL.User.`refnum`\n     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer.`formRefnum` = TILDATUTORIAL.Form.`refnum`\n where (    TILDATUTORIAL.Form.`deleted` is null\n        and TILDATUTORIAL.TestAnswer.`deleted` is null\n       )\n     group by 1\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_Realized (`type`, `testCount`, `testFirstTZ`, `testFirst`, `testLastTZ`, `testLast`, `userCount`, `answerCount`, `answerCountCorrect`, `answerCountIncorrect`, `timeMillisTotal`, `timeMillisAvg`, `timeMillisMin`, `timeMillisMax`)\n     SELECT /*genRealizedColumnList*/`type` -- COLUMN\n          -- `fillDateTZ` -- VIEW-EXCLUDED\n          -- `fillDate` -- VIEW-EXCLUDED\n          ,`testCount` -- COLUMN\n          ,`testFirstTZ` -- COLUMN\n          ,`testFirst` -- COLUMN\n          ,`testLastTZ` -- COLUMN\n          ,`testLast` -- COLUMN\n          ,`userCount` -- COLUMN\n          ,`answerCount` -- COLUMN\n          ,`answerCountCorrect` -- COLUMN\n          ,`answerCountIncorrect` -- COLUMN\n          ,`timeMillisTotal` -- COLUMN\n          ,`timeMillisAvg` -- COLUMN\n          ,`timeMillisMin` -- COLUMN\n          ,`timeMillisMax` -- COLUMN\n     FROM TILDATUTORIAL.Test_View;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATUTORIAL'', ''Test_Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATUTORIAL.Test_XYZ_Analytics_View as 
select /*DoFormulasSuperView*/
`formRefnum` -- COLUMN
     , `formType` -- COLUMN
     , `formFillDateTZ` -- COLUMN
     , `formFillDate` -- COLUMN
     , `formUserRefnum` -- COLUMN
     , `formUserEmail` -- COLUMN
     , `formCountCorrect` -- COLUMN
     , `formTimeMillisTotal` -- COLUMN
     , `testCount` -- COLUMN
     , `testAnswerCountCorrect` -- COLUMN
     , `testTimeMillisAvg` -- COLUMN
     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.
     , (coalesce("formCountCorrect", 0) >= 2)::INT64 as `isPassed`
     -- Whether the test took longer that the average time spent across all tests.
     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::INT64 as `tookLongerThanAverage`
     -- Whether the test was challenging in that:<LI>
     --   <LI>it was passed,</LI>
     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>
     -- </UL>
     , ((coalesce("formCountCorrect", 0) >= 2)::INT64=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::INT64 as `wasChallenging`

 from (
-- 'A view of XYZ forms with analytics'
select TILDATUTORIAL.Test_XYZ_PivotView.`formRefnum` as `formRefnum` -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_PivotView.`formType` as `formType` -- Form template type
     , TILDATUTORIAL.Test_XYZ_PivotView.`formFillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for 'formFillDate'.
     , TILDATUTORIAL.Test_XYZ_PivotView.`formFillDate` as `formFillDate` -- The date the form was filled
     , TILDATUTORIAL.Test_XYZ_PivotView.`formUserRefnum` as `formUserRefnum` -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_PivotView.`formUserEmail` as `formUserEmail` -- The user's email
     , TILDATUTORIAL.Test_XYZ_PivotView.`countCorrect` as `formCountCorrect` -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_XYZ_PivotView.`timeMillisTotal` as `formTimeMillisTotal` -- Time in milliseconds for the time spent answering the question
     , TILDATUTORIAL.Test_View.`testCount` as `testCount` -- The primary key for this record
     , TILDATUTORIAL.Test_View.`answerCountCorrect` as `testAnswerCountCorrect` -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_View.`timeMillisAvg` as `testTimeMillisAvg` -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Test_XYZ_PivotView
     inner join TILDATUTORIAL.Test_View on Test_View.`type` = Test_XYZ_PivotView.`formType`

      ) as T
-- Realized as /*genRealizedColumnList*/`formRefnum` -- COLUMN ,`formType` -- COLUMN ,`formFillDateTZ` -- COLUMN ,`formFillDate` -- COLUMN ,`formUserRefnum` -- COLUMN ,`formUserEmail` -- COLUMN ,`formCountCorrect` -- COLUMN ,`formTimeMillisTotal` -- COLUMN ,`testCount` -- COLUMN ,`testAnswerCountCorrect` -- COLUMN ,`testTimeMillisAvg` -- COLUMN ,`isPassed` -- FORMULA ,`tookLongerThanAverage` -- FORMULA ,`wasChallenging` -- FORMULA
;

create or replace view TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R as 
select /*DoFormulasSuperView*/
`formRefnum` -- COLUMN
     , `formType` -- COLUMN
     , `formFillDateTZ` -- COLUMN
     , `formFillDate` -- COLUMN
     , `formUserRefnum` -- COLUMN
     , `formUserEmail` -- COLUMN
     , `formCountCorrect` -- COLUMN
     , `formTimeMillisTotal` -- COLUMN
     , `testCount` -- COLUMN
     , `testAnswerCountCorrect` -- COLUMN
     , `testTimeMillisAvg` -- COLUMN
     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.
     , (coalesce("formCountCorrect", 0) >= 2)::INT64 as `isPassed`
     -- Whether the test took longer that the average time spent across all tests.
     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::INT64 as `tookLongerThanAverage`
     -- Whether the test was challenging in that:<LI>
     --   <LI>it was passed,</LI>
     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>
     -- </UL>
     , ((coalesce("formCountCorrect", 0) >= 2)::INT64=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::INT64 as `wasChallenging`

 from (
-- 'A view of XYZ forms with analytics'
select TILDATUTORIAL.Test_XYZ_Realized.`formRefnum` as `formRefnum` -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_Realized.`formType` as `formType` -- Form template type
     , TILDATUTORIAL.Test_XYZ_Realized.`formFillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for 'formFillDate'.
     , TILDATUTORIAL.Test_XYZ_Realized.`formFillDate` as `formFillDate` -- The date the form was filled
     , TILDATUTORIAL.Test_XYZ_Realized.`formUserRefnum` as `formUserRefnum` -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_Realized.`formUserEmail` as `formUserEmail` -- The user's email
     , TILDATUTORIAL.Test_XYZ_Realized.`countCorrect` as `formCountCorrect` -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_XYZ_Realized.`timeMillisTotal` as `formTimeMillisTotal` -- Time in milliseconds for the time spent answering the question
     , TILDATUTORIAL.Test_Realized.`testCount` as `testCount` -- The primary key for this record
     , TILDATUTORIAL.Test_Realized.`answerCountCorrect` as `testAnswerCountCorrect` -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_Realized.`timeMillisAvg` as `testTimeMillisAvg` -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Test_XYZ_Realized
     inner join TILDATUTORIAL.Test_Realized on TILDATUTORIAL.Test_Realized.`type` = TILDATUTORIAL.Test_XYZ_Realized.`formType`

      ) as T
-- Realized as /*genRealizedColumnList*/`formRefnum` -- COLUMN ,`formType` -- COLUMN ,`formFillDateTZ` -- COLUMN ,`formFillDate` -- COLUMN ,`formUserRefnum` -- COLUMN ,`formUserEmail` -- COLUMN ,`formCountCorrect` -- COLUMN ,`formTimeMillisTotal` -- COLUMN ,`testCount` -- COLUMN ,`testAnswerCountCorrect` -- COLUMN ,`testTimeMillisAvg` -- COLUMN ,`isPassed` -- FORMULA ,`tookLongerThanAverage` -- FORMULA ,`wasChallenging` -- FORMULA
;


DROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized();
CREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized()
 RETURNS boolean AS $$
declare
  startDt        timestamptz;
  insertStartDt  timestamptz;
  insertEndDt    timestamptz;
  deleteStartDt  timestamptz;
  deleteEndDt    timestamptz;
  analyzeStartDt timestamptz;
  analyzeEndDt   timestamptz;
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_XYZ_Analytics_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_XYZ_Analytics_Realized (`formRefnum`, `formType`, `formFillDateTZ`, `formFillDate`, `formUserRefnum`, `formUserEmail`, `formCountCorrect`, `formTimeMillisTotal`, `testCount`, `testAnswerCountCorrect`, `testTimeMillisAvg`, `isPassed`, `tookLongerThanAverage`, `wasChallenging`)
     SELECT /*genRealizedColumnList*/`formRefnum` -- COLUMN
          ,`formType` -- COLUMN
          ,`formFillDateTZ` -- COLUMN
          ,`formFillDate` -- COLUMN
          ,`formUserRefnum` -- COLUMN
          ,`formUserEmail` -- COLUMN
          ,`formCountCorrect` -- COLUMN
          ,`formTimeMillisTotal` -- COLUMN
          ,`testCount` -- COLUMN
          ,`testAnswerCountCorrect` -- COLUMN
          ,`testTimeMillisAvg` -- COLUMN
          ,`isPassed` -- FORMULA
          ,`tookLongerThanAverage` -- FORMULA
          ,`wasChallenging` -- FORMULA
     FROM TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_XYZ_Analytics_Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
                        VALUES('TILDATUTORIAL', 'Test_XYZ_Analytics_Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

ALTER VIEW TILDATUTORIAL.Test_XYZ_Analytics_View set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATUTORIAL.Test_XYZ_Analytics_View as \nselect /*DoFormulasSuperView*/\n`formRefnum` -- COLUMN\n     , `formType` -- COLUMN\n     , `formFillDateTZ` -- COLUMN\n     , `formFillDate` -- COLUMN\n     , `formUserRefnum` -- COLUMN\n     , `formUserEmail` -- COLUMN\n     , `formCountCorrect` -- COLUMN\n     , `formTimeMillisTotal` -- COLUMN\n     , `testCount` -- COLUMN\n     , `testAnswerCountCorrect` -- COLUMN\n     , `testTimeMillisAvg` -- COLUMN\n     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.\n     , (coalesce("formCountCorrect", 0) >= 2)::INT64 as `isPassed`\n     -- Whether the test took longer that the average time spent across all tests.\n     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::INT64 as `tookLongerThanAverage`\n     -- Whether the test was challenging in that:<LI>\n     --   <LI>it was passed,</LI>\n     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>\n     -- </UL>\n     , ((coalesce("formCountCorrect", 0) >= 2)::INT64=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::INT64 as `wasChallenging`\n\n from (\n-- ''A view of XYZ forms with analytics''\nselect TILDATUTORIAL.Test_XYZ_PivotView.`formRefnum` as `formRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_PivotView.`formType` as `formType` -- Form template type\n     , TILDATUTORIAL.Test_XYZ_PivotView.`formFillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for ''formFillDate''.\n     , TILDATUTORIAL.Test_XYZ_PivotView.`formFillDate` as `formFillDate` -- The date the form was filled\n     , TILDATUTORIAL.Test_XYZ_PivotView.`formUserRefnum` as `formUserRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_PivotView.`formUserEmail` as `formUserEmail` -- The user''s email\n     , TILDATUTORIAL.Test_XYZ_PivotView.`countCorrect` as `formCountCorrect` -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_XYZ_PivotView.`timeMillisTotal` as `formTimeMillisTotal` -- Time in milliseconds for the time spent answering the question\n     , TILDATUTORIAL.Test_View.`testCount` as `testCount` -- The primary key for this record\n     , TILDATUTORIAL.Test_View.`answerCountCorrect` as `testAnswerCountCorrect` -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_View.`timeMillisAvg` as `testTimeMillisAvg` -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Test_XYZ_PivotView\n     inner join TILDATUTORIAL.Test_View on Test_View.`type` = Test_XYZ_PivotView.`formType`\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/`formRefnum` -- COLUMN ,`formType` -- COLUMN ,`formFillDateTZ` -- COLUMN ,`formFillDate` -- COLUMN ,`formUserRefnum` -- COLUMN ,`formUserEmail` -- COLUMN ,`formCountCorrect` -- COLUMN ,`formTimeMillisTotal` -- COLUMN ,`testCount` -- COLUMN ,`testAnswerCountCorrect` -- COLUMN ,`testTimeMillisAvg` -- COLUMN ,`isPassed` -- FORMULA ,`tookLongerThanAverage` -- FORMULA ,`wasChallenging` -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R as \nselect /*DoFormulasSuperView*/\n`formRefnum` -- COLUMN\n     , `formType` -- COLUMN\n     , `formFillDateTZ` -- COLUMN\n     , `formFillDate` -- COLUMN\n     , `formUserRefnum` -- COLUMN\n     , `formUserEmail` -- COLUMN\n     , `formCountCorrect` -- COLUMN\n     , `formTimeMillisTotal` -- COLUMN\n     , `testCount` -- COLUMN\n     , `testAnswerCountCorrect` -- COLUMN\n     , `testTimeMillisAvg` -- COLUMN\n     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.\n     , (coalesce("formCountCorrect", 0) >= 2)::INT64 as `isPassed`\n     -- Whether the test took longer that the average time spent across all tests.\n     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::INT64 as `tookLongerThanAverage`\n     -- Whether the test was challenging in that:<LI>\n     --   <LI>it was passed,</LI>\n     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>\n     -- </UL>\n     , ((coalesce("formCountCorrect", 0) >= 2)::INT64=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::INT64 as `wasChallenging`\n\n from (\n-- ''A view of XYZ forms with analytics''\nselect TILDATUTORIAL.Test_XYZ_Realized.`formRefnum` as `formRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_Realized.`formType` as `formType` -- Form template type\n     , TILDATUTORIAL.Test_XYZ_Realized.`formFillDateTZ` as `formFillDateTZ` -- Generated helper column to hold the time zone ID for ''formFillDate''.\n     , TILDATUTORIAL.Test_XYZ_Realized.`formFillDate` as `formFillDate` -- The date the form was filled\n     , TILDATUTORIAL.Test_XYZ_Realized.`formUserRefnum` as `formUserRefnum` -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_Realized.`formUserEmail` as `formUserEmail` -- The user''s email\n     , TILDATUTORIAL.Test_XYZ_Realized.`countCorrect` as `formCountCorrect` -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_XYZ_Realized.`timeMillisTotal` as `formTimeMillisTotal` -- Time in milliseconds for the time spent answering the question\n     , TILDATUTORIAL.Test_Realized.`testCount` as `testCount` -- The primary key for this record\n     , TILDATUTORIAL.Test_Realized.`answerCountCorrect` as `testAnswerCountCorrect` -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_Realized.`timeMillisAvg` as `testTimeMillisAvg` -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Test_XYZ_Realized\n     inner join TILDATUTORIAL.Test_Realized on TILDATUTORIAL.Test_Realized.`type` = TILDATUTORIAL.Test_XYZ_Realized.`formType`\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/`formRefnum` -- COLUMN ,`formType` -- COLUMN ,`formFillDateTZ` -- COLUMN ,`formFillDate` -- COLUMN ,`formUserRefnum` -- COLUMN ,`formUserEmail` -- COLUMN ,`formCountCorrect` -- COLUMN ,`formTimeMillisTotal` -- COLUMN ,`testCount` -- COLUMN ,`testAnswerCountCorrect` -- COLUMN ,`testTimeMillisAvg` -- COLUMN ,`isPassed` -- FORMULA ,`tookLongerThanAverage` -- FORMULA ,`wasChallenging` -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_XYZ_Analytics_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_XYZ_Analytics_Realized (`formRefnum`, `formType`, `formFillDateTZ`, `formFillDate`, `formUserRefnum`, `formUserEmail`, `formCountCorrect`, `formTimeMillisTotal`, `testCount`, `testAnswerCountCorrect`, `testTimeMillisAvg`, `isPassed`, `tookLongerThanAverage`, `wasChallenging`)\n     SELECT /*genRealizedColumnList*/`formRefnum` -- COLUMN\n          ,`formType` -- COLUMN\n          ,`formFillDateTZ` -- COLUMN\n          ,`formFillDate` -- COLUMN\n          ,`formUserRefnum` -- COLUMN\n          ,`formUserEmail` -- COLUMN\n          ,`formCountCorrect` -- COLUMN\n          ,`formTimeMillisTotal` -- COLUMN\n          ,`testCount` -- COLUMN\n          ,`testAnswerCountCorrect` -- COLUMN\n          ,`testTimeMillisAvg` -- COLUMN\n          ,`isPassed` -- FORMULA\n          ,`tookLongerThanAverage` -- FORMULA\n          ,`wasChallenging` -- FORMULA\n     FROM TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_XYZ_Analytics_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATUTORIAL'', ''Test_XYZ_Analytics_Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');



