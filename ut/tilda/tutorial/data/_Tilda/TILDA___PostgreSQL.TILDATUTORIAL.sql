
create schema if not exists TILDATUTORIAL;



create table if not exists TILDATUTORIAL.User -- Users
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "id"           varchar(40)   not null   -- The user's id
  , "email"        varchar(255)  not null   -- The user's email
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATUTORIAL.User)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATUTORIAL.User)
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
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATUTORIAL.Form)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATUTORIAL.Form)
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
  , "created"      timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATUTORIAL.FormAnswer)
  , "lastUpdated"  timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATUTORIAL.FormAnswer)
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
  , "correct"        boolean       not null   -- Whether the answer is a correct one or not for that question (technically, there could be more than one)
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)
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
  , "correct"      boolean      not null   -- Whether the answer is correct or not
  , "created"      timestamptz  not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)
  , "lastUpdated"  timestamptz  not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)
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



create table if not exists TILDATUTORIAL.Test_XYZ_Realized -- Realized table for view TILDATUTORIAL.Test_XYZ_PivotView: A pivoted view of XYZ forms
 (  "formRefnum"       bigint            not null   -- The primary key for this record (from TILDATUTORIAL.Test_XYZ_PivotView.formRefnum)
  , "formType"         varchar(40)                  -- Form template type (from TILDATUTORIAL.Test_XYZ_PivotView.formType)
  , "formFillDateTZ"   varchar(10)                  -- Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_PivotView.formFillDateTZ)
  , "formFillDate"     timestamptz                  -- The date the form was filled (from TILDATUTORIAL.Test_XYZ_PivotView.formFillDate)
  , "formUserRefnum"   bigint                       -- The primary key for this record (from TILDATUTORIAL.Test_XYZ_PivotView.formUserRefnum)
  , "formUserEmail"    varchar(255)                 -- The user's email (from TILDATUTORIAL.Test_XYZ_PivotView.formUserEmail)
  , "countCorrect"     bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_PivotView.countCorrect)
  , "countIncorrect"   bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_PivotView.countIncorrect)
  , "timeMillisTotal"  bigint                       -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisTotal)
  , "timeMillisAvg"    double precision             -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisAvg)
  , "timeMillisMin"    integer                      -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisMin)
  , "QX_correct"       boolean                      -- Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QX') (from TILDATUTORIAL.Test_XYZ_PivotView.QX_correct)
  , "QX_timeMillis"    integer                      -- Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QX') (from TILDATUTORIAL.Test_XYZ_PivotView.QX_timeMillis)
  , "QY_correct"       boolean                      -- Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QY') (from TILDATUTORIAL.Test_XYZ_PivotView.QY_correct)
  , "QY_timeMillis"    integer                      -- Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QY') (from TILDATUTORIAL.Test_XYZ_PivotView.QY_timeMillis)
  , "QZ_correct"       boolean                      -- Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QZ') (from TILDATUTORIAL.Test_XYZ_PivotView.QZ_correct)
  , "QZ_timeMillis"    integer                      -- Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QZ') (from TILDATUTORIAL.Test_XYZ_PivotView.QZ_timeMillis)
  , PRIMARY KEY("formRefnum")
  , CONSTRAINT fk_Test_XYZ_Realized_Form FOREIGN KEY ("formRefnum") REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Test_XYZ_Realized_User FOREIGN KEY ("formUserRefnum") REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATUTORIAL.Test_XYZ_Realized IS E'Realized table for view TILDATUTORIAL.Test_XYZ_PivotView: A pivoted view of XYZ forms';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formRefnum" IS E'The primary key for this record (from TILDATUTORIAL.Test_XYZ_PivotView.formRefnum)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formType" IS E'Form template type (from TILDATUTORIAL.Test_XYZ_PivotView.formType)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''formFillDate''. (from TILDATUTORIAL.Test_XYZ_PivotView.formFillDateTZ)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formFillDate" IS E'The date the form was filled (from TILDATUTORIAL.Test_XYZ_PivotView.formFillDate)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formUserRefnum" IS E'The primary key for this record (from TILDATUTORIAL.Test_XYZ_PivotView.formUserRefnum)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."formUserEmail" IS E'The user''s email (from TILDATUTORIAL.Test_XYZ_PivotView.formUserEmail)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."countCorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_PivotView.countCorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."countIncorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_PivotView.countIncorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."timeMillisTotal" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisTotal)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."timeMillisAvg" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisAvg)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."timeMillisMin" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_PivotView.timeMillisMin)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QX_correct" IS E'Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QX'') (from TILDATUTORIAL.Test_XYZ_PivotView.QX_correct)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QX_timeMillis" IS E'Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QX'') (from TILDATUTORIAL.Test_XYZ_PivotView.QX_timeMillis)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QY_correct" IS E'Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QY'') (from TILDATUTORIAL.Test_XYZ_PivotView.QY_correct)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QY_timeMillis" IS E'Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QY'') (from TILDATUTORIAL.Test_XYZ_PivotView.QY_timeMillis)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QZ_correct" IS E'Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QZ'') (from TILDATUTORIAL.Test_XYZ_PivotView.QZ_correct)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Realized."QZ_timeMillis" IS E'Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QZ'') (from TILDATUTORIAL.Test_XYZ_PivotView.QZ_timeMillis)';
CREATE INDEX IF NOT EXISTS Test_XYZ_Realized_User ON TILDATUTORIAL.Test_XYZ_Realized ("formUserRefnum", "formFillDate" DESC);
CREATE INDEX IF NOT EXISTS Test_XYZ_Realized_Type ON TILDATUTORIAL.Test_XYZ_Realized ("formType", "formFillDate" DESC);



create table if not exists TILDATUTORIAL.Test_Realized -- Realized table for view TILDATUTORIAL.Test_View: A pivoted view of SAT_01 forms
 (  "type"                  varchar(40)       not null   -- Form template type (from TILDATUTORIAL.Test_View.type)
  , "testCount"             bigint                       -- The primary key for this record (from TILDATUTORIAL.Test_View.testCount)
  , "testFirstTZ"           varchar(10)                  -- Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)
  , "testFirst"             timestamptz                  -- The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)
  , "testLastTZ"            varchar(10)                  -- Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)
  , "testLast"              timestamptz                  -- The date the form was filled (from TILDATUTORIAL.Test_View.testLast)
  , "userCount"             bigint                       -- The primary key for this record (from TILDATUTORIAL.Test_View.userCount)
  , "answerCount"           bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)
  , "answerCountCorrect"    bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)
  , "answerCountIncorrect"  bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)
  , "timeMillisTotal"       bigint                       -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)
  , "timeMillisAvg"         double precision             -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)
  , "timeMillisMin"         integer                      -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)
  , "timeMillisMax"         integer                      -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)
  , PRIMARY KEY("type")
 );
COMMENT ON TABLE TILDATUTORIAL.Test_Realized IS E'Realized table for view TILDATUTORIAL.Test_View: A pivoted view of SAT_01 forms';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."type" IS E'Form template type (from TILDATUTORIAL.Test_View.type)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."testCount" IS E'The primary key for this record (from TILDATUTORIAL.Test_View.testCount)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."testFirstTZ" IS E'Generated helper column to hold the time zone ID for ''testFirst''. (from TILDATUTORIAL.Test_View.testFirstTZ)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."testFirst" IS E'The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."testLastTZ" IS E'Generated helper column to hold the time zone ID for ''testLast''. (from TILDATUTORIAL.Test_View.testLastTZ)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."testLast" IS E'The date the form was filled (from TILDATUTORIAL.Test_View.testLast)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."userCount" IS E'The primary key for this record (from TILDATUTORIAL.Test_View.userCount)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."answerCount" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."answerCountCorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."answerCountIncorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."timeMillisTotal" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."timeMillisAvg" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."timeMillisMin" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)';
COMMENT ON COLUMN TILDATUTORIAL.Test_Realized."timeMillisMax" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)';



create table if not exists TILDATUTORIAL.Test_XYZ_Analytics_Realized -- Realized table for view TILDATUTORIAL.Test_XYZ_Analytics_View: A view of XYZ forms with analytics
 (  "formRefnum"              bigint            not null   -- The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)
  , "formType"                varchar(40)                  -- Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)
  , "formFillDateTZ"          varchar(10)                  -- Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)
  , "formFillDate"            timestamptz                  -- The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)
  , "formUserRefnum"          bigint                       -- The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)
  , "formUserEmail"           varchar(255)                 -- The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)
  , "formCountCorrect"        bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)
  , "formTimeMillisTotal"     bigint                       -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)
  , "testCount"               bigint                       -- The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)
  , "testAnswerCountCorrect"  bigint                       -- Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)
  , "testTimeMillisAvg"       double precision             -- Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)
  , "isPassed"                integer                      -- Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)
  , "tookLongerThanAverage"   integer                      -- Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)
  , "wasChallenging"          integer                      -- Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)
  , PRIMARY KEY("formRefnum")
  , CONSTRAINT fk_Test_XYZ_Analytics_Realized_Form FOREIGN KEY ("formRefnum") REFERENCES TILDATUTORIAL.Form ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Test_XYZ_Analytics_Realized_User FOREIGN KEY ("formUserRefnum") REFERENCES TILDATUTORIAL.User ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATUTORIAL.Test_XYZ_Analytics_Realized IS E'Realized table for view TILDATUTORIAL.Test_XYZ_Analytics_View: A view of XYZ forms with analytics';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formRefnum" IS E'The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType" IS E'Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''formFillDate''. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate" IS E'The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum" IS E'The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail" IS E'The user''s email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount" IS E'The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect" IS E'Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg" IS E'Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed" IS E'Formula column ''<B>Test Passed</B>'' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage" IS E'Formula column ''<B>Test Took Longer Than Average</B>'' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging" IS E'Formula column ''<B>Test Was Challenging</B>'' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)';
CREATE INDEX IF NOT EXISTS Test_XYZ_Analytics_Realized_User ON TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formUserRefnum", "formFillDate" DESC);
CREATE INDEX IF NOT EXISTS Test_XYZ_Analytics_Realized_Type ON TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formType", "formFillDate" DESC);




-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATUTORIAL.Form_SAT01_PivotView as 
with T as (
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record
     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled
     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record
     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user's email
     , TILDATUTORIAL.FormAnswer."field" as "field" -- question/field id
     , max(TILDATUTORIAL.FormAnswer."value") as "value" -- answer value
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"
     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"
 where (    TILDATUTORIAL.Form."type" = 'SAT_01'
        and TILDATUTORIAL.Form."deleted" is null
        and TILDATUTORIAL.FormAnswer."deleted" is null
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
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q1') ,null))::integer as "Q1"
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q2') ,null))::integer as "Q2"
     , (Tilda.toInt(MAX("value") filter (where "field"= 'Q3') ,null))::integer as "Q3"
     , MAX("value") filter (where "field"= 'Q4')  as "Q4"
from T
     group by 1, 2, 3, 4, 5
;


COMMENT ON VIEW TILDATUTORIAL.Form_SAT01_PivotView IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATUTORIAL.Form_SAT01_PivotView as \nwith T as (\n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record\n     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled\n     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user''s email\n     , TILDATUTORIAL.FormAnswer."field" as "field" -- question/field id\n     , max(TILDATUTORIAL.FormAnswer."value") as "value" -- answer value\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"\n     left  join TILDATUTORIAL.FormAnswer on TILDATUTORIAL.FormAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"\n where (    TILDATUTORIAL.Form."type" = ''SAT_01''\n        and TILDATUTORIAL.Form."deleted" is null\n        and TILDATUTORIAL.FormAnswer."deleted" is null\n       )\n   and ( TILDATUTORIAL.FormAnswer."field" in (''Q1'', ''Q2'', ''Q3'', ''Q4'')\n       )\n group by 1, 2, 3, 4, 5, 6\n) select "formRefnum" \n       , "formFillDateTZ" \n       , "formFillDate" \n       , "formUserRefnum" \n       , "formUserEmail" \n     , MAX("value") as "value"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q1'') ,null))::integer as "Q1"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q2'') ,null))::integer as "Q2"\n     , (Tilda.toInt(MAX("value") filter (where "field"= ''Q3'') ,null))::integer as "Q3"\n     , MAX("value") filter (where "field"= ''Q4'')  as "Q4"\nfrom T\n     group by 1, 2, 3, 4, 5\n;\n\n';

COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formFillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formUserRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."formUserEmail" IS E'The user''s email';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q1" IS E'Q1 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q1'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q2" IS E'Q2 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q2'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q3" IS E'Q3 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q3'')';
COMMENT ON COLUMN TILDATUTORIAL.Form_SAT01_PivotView."Q4" IS E'Q4 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field=''Q4'')';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATUTORIAL.Form_SAT01_PivotView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATUTORIAL.Test_XYZ_PivotView as 
with T as (
-- 'A pivoted view of XYZ forms'
select TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record
     , TILDATUTORIAL.Form."type" as "formType" -- Form template type
     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled
     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record
     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user's email
     , TILDATUTORIAL.TestAnswer."questionId" as "questionId" -- Question id
     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = true) as "countCorrect" -- Whether the answer is correct or not
     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = false) as "countIncorrect" -- Whether the answer is correct or not
     , sum(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisTotal" -- Time in milliseconds for the time spent answering the question
     , avg(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisAvg" -- Time in milliseconds for the time spent answering the question
     , min(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMin" -- Time in milliseconds for the time spent answering the question
     , max(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMax" -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"
     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"
 where (    TILDATUTORIAL.Form."type" = 'XYZ'
        and TILDATUTORIAL.Form."deleted" is null
        and TILDATUTORIAL.TestAnswer."deleted" is null
       )
   and ( TILDATUTORIAL.TestAnswer."questionId" in ('QX', 'QY', 'QZ')
       )
 group by 1, 2, 3, 4, 5, 6, 7
) select "formRefnum" 
       , "formType" 
       , "formFillDateTZ" 
       , "formFillDate" 
       , "formUserRefnum" 
       , "formUserEmail" 
     , SUM("countCorrect") as "countCorrect"
     , SUM("countIncorrect") as "countIncorrect"
     , SUM("timeMillisTotal") as "timeMillisTotal"
     , AVG("timeMillisAvg") as "timeMillisAvg"
     , MIN("timeMillisMin") as "timeMillisMin"
     , MAX("timeMillisMax") as "timeMillisMax"
     , MIN("correct") as "correct"
     , MIN("correct") filter (where "questionId"= 'QX')  as "QX_correct"
     , MAX("timeMillisMax") filter (where "questionId"= 'QX')  as "QX_timeMillis"
     , MIN("correct") filter (where "questionId"= 'QY')  as "QY_correct"
     , MAX("timeMillisMax") filter (where "questionId"= 'QY')  as "QY_timeMillis"
     , MIN("correct") filter (where "questionId"= 'QZ')  as "QZ_correct"
     , MAX("timeMillisMax") filter (where "questionId"= 'QZ')  as "QZ_timeMillis"
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
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_XYZ_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_XYZ_Realized ("formRefnum", "formType", "formFillDateTZ", "formFillDate", "formUserRefnum", "formUserEmail", "countCorrect", "countIncorrect", "timeMillisTotal", "timeMillisAvg", "timeMillisMin", "QX_correct", "QX_timeMillis", "QY_correct", "QY_timeMillis", "QZ_correct", "QZ_timeMillis")
     SELECT /*genRealizedColumnList*/"formRefnum" -- COLUMN
          ,"formType" -- COLUMN
          ,"formFillDateTZ" -- COLUMN
          ,"formFillDate" -- COLUMN
          ,"formUserRefnum" -- COLUMN
          ,"formUserEmail" -- COLUMN
          ,"countCorrect" -- COLUMN
          ,"countIncorrect" -- COLUMN
          ,"timeMillisTotal" -- COLUMN
          ,"timeMillisAvg" -- COLUMN
          ,"timeMillisMin" -- COLUMN
          , "QX_correct" -- PIVOT COLUMN
          , "QX_timeMillis" -- PIVOT COLUMN
          , "QY_correct" -- PIVOT COLUMN
          , "QY_timeMillis" -- PIVOT COLUMN
          , "QZ_correct" -- PIVOT COLUMN
          , "QZ_timeMillis" -- PIVOT COLUMN
     FROM TILDATUTORIAL.Test_XYZ_PivotView;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_XYZ_Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATUTORIAL', 'Test_XYZ_Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATUTORIAL.Test_XYZ_PivotView IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATUTORIAL.Test_XYZ_PivotView as \nwith T as (\n-- ''A pivoted view of XYZ forms''\nselect TILDATUTORIAL.Form."refnum" as "formRefnum" -- The primary key for this record\n     , TILDATUTORIAL.Form."type" as "formType" -- Form template type\n     , trim(TILDATUTORIAL.Form."fillDateTZ") as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , TILDATUTORIAL.Form."fillDate" as "formFillDate" -- The date the form was filled\n     , TILDATUTORIAL.User."refnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATUTORIAL.User."email" as "formUserEmail" -- The user''s email\n     , TILDATUTORIAL.TestAnswer."questionId" as "questionId" -- Question id\n     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = true) as "countCorrect" -- Whether the answer is correct or not\n     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = false) as "countIncorrect" -- Whether the answer is correct or not\n     , sum(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisTotal" -- Time in milliseconds for the time spent answering the question\n     , avg(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisAvg" -- Time in milliseconds for the time spent answering the question\n     , min(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMin" -- Time in milliseconds for the time spent answering the question\n     , max(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMax" -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"\n     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"\n where (    TILDATUTORIAL.Form."type" = ''XYZ''\n        and TILDATUTORIAL.Form."deleted" is null\n        and TILDATUTORIAL.TestAnswer."deleted" is null\n       )\n   and ( TILDATUTORIAL.TestAnswer."questionId" in (''QX'', ''QY'', ''QZ'')\n       )\n group by 1, 2, 3, 4, 5, 6, 7\n) select "formRefnum" \n       , "formType" \n       , "formFillDateTZ" \n       , "formFillDate" \n       , "formUserRefnum" \n       , "formUserEmail" \n     , SUM("countCorrect") as "countCorrect"\n     , SUM("countIncorrect") as "countIncorrect"\n     , SUM("timeMillisTotal") as "timeMillisTotal"\n     , AVG("timeMillisAvg") as "timeMillisAvg"\n     , MIN("timeMillisMin") as "timeMillisMin"\n     , MAX("timeMillisMax") as "timeMillisMax"\n     , MIN("correct") as "correct"\n     , MIN("correct") filter (where "questionId"= ''QX'')  as "QX_correct"\n     , MAX("timeMillisMax") filter (where "questionId"= ''QX'')  as "QX_timeMillis"\n     , MIN("correct") filter (where "questionId"= ''QY'')  as "QY_correct"\n     , MAX("timeMillisMax") filter (where "questionId"= ''QY'')  as "QY_timeMillis"\n     , MIN("correct") filter (where "questionId"= ''QZ'')  as "QZ_correct"\n     , MAX("timeMillisMax") filter (where "questionId"= ''QZ'')  as "QZ_timeMillis"\nfrom T\n     group by 1, 2, 3, 4, 5, 6\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_XYZ_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_XYZ_Realized ("formRefnum", "formType", "formFillDateTZ", "formFillDate", "formUserRefnum", "formUserEmail", "countCorrect", "countIncorrect", "timeMillisTotal", "timeMillisAvg", "timeMillisMin", "QX_correct", "QX_timeMillis", "QY_correct", "QY_timeMillis", "QZ_correct", "QZ_timeMillis")\n     SELECT /*genRealizedColumnList*/"formRefnum" -- COLUMN\n          ,"formType" -- COLUMN\n          ,"formFillDateTZ" -- COLUMN\n          ,"formFillDate" -- COLUMN\n          ,"formUserRefnum" -- COLUMN\n          ,"formUserEmail" -- COLUMN\n          ,"countCorrect" -- COLUMN\n          ,"countIncorrect" -- COLUMN\n          ,"timeMillisTotal" -- COLUMN\n          ,"timeMillisAvg" -- COLUMN\n          ,"timeMillisMin" -- COLUMN\n          , "QX_correct" -- PIVOT COLUMN\n          , "QX_timeMillis" -- PIVOT COLUMN\n          , "QY_correct" -- PIVOT COLUMN\n          , "QY_timeMillis" -- PIVOT COLUMN\n          , "QZ_correct" -- PIVOT COLUMN\n          , "QZ_timeMillis" -- PIVOT COLUMN\n     FROM TILDATUTORIAL.Test_XYZ_PivotView;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_XYZ_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATUTORIAL'', ''Test_XYZ_Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formType" IS E'Form template type';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formFillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formUserRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."formUserEmail" IS E'The user''s email';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."countCorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."countIncorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."timeMillisTotal" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."timeMillisAvg" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."timeMillisMin" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QX_correct" IS E'Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QX'')';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QY_correct" IS E'Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QY'')';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QZ_correct" IS E'Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId=''QZ'')';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QX_timeMillis" IS E'Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QX'')';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QY_timeMillis" IS E'Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QY'')';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_PivotView."QZ_timeMillis" IS E'Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId=''QZ'')';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATUTORIAL.Test_XYZ_PivotView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATUTORIAL.Test_View as 
-- 'A pivoted view of SAT_01 forms'
select TILDATUTORIAL.Form."type" as "type" -- Form template type
     , count(distinct TILDATUTORIAL.Form."refnum") as "testCount" -- The primary key for this record
     , first(trim(TILDATUTORIAL.Form."fillDateTZ") order by TILDATUTORIAL.Form."fillDate" ASC) as "testFirstTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , first(TILDATUTORIAL.Form."fillDate" order by TILDATUTORIAL.Form."fillDate" ASC) as "testFirst" -- The date the form was filled
     , last(trim(TILDATUTORIAL.Form."fillDateTZ") order by TILDATUTORIAL.Form."fillDate" ASC) as "testLastTZ" -- Generated helper column to hold the time zone ID for 'fillDate'.
     , last(TILDATUTORIAL.Form."fillDate" order by TILDATUTORIAL.Form."fillDate" ASC) as "testLast" -- The date the form was filled
     , count(distinct TILDATUTORIAL.User."refnum") as "userCount" -- The primary key for this record
     , count(TILDATUTORIAL.TestAnswer."correct") as "answerCount" -- Whether the answer is correct or not
     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = true) as "answerCountCorrect" -- Whether the answer is correct or not
     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = false) as "answerCountIncorrect" -- Whether the answer is correct or not
     , sum(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisTotal" -- Time in milliseconds for the time spent answering the question
     , avg(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisAvg" -- Time in milliseconds for the time spent answering the question
     , min(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMin" -- Time in milliseconds for the time spent answering the question
     , max(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMax" -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Form
     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"
     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"
 where (    TILDATUTORIAL.Form."deleted" is null
        and TILDATUTORIAL.TestAnswer."deleted" is null
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
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_Realized ("type", "testCount", "testFirstTZ", "testFirst", "testLastTZ", "testLast", "userCount", "answerCount", "answerCountCorrect", "answerCountIncorrect", "timeMillisTotal", "timeMillisAvg", "timeMillisMin", "timeMillisMax")
     SELECT /*genRealizedColumnList*/"type" -- COLUMN
          -- "fillDateTZ" -- VIEW-EXCLUDED
          -- "fillDate" -- VIEW-EXCLUDED
          ,"testCount" -- COLUMN
          ,"testFirstTZ" -- COLUMN
          ,"testFirst" -- COLUMN
          ,"testLastTZ" -- COLUMN
          ,"testLast" -- COLUMN
          ,"userCount" -- COLUMN
          ,"answerCount" -- COLUMN
          ,"answerCountCorrect" -- COLUMN
          ,"answerCountIncorrect" -- COLUMN
          ,"timeMillisTotal" -- COLUMN
          ,"timeMillisAvg" -- COLUMN
          ,"timeMillisMin" -- COLUMN
          ,"timeMillisMax" -- COLUMN
     FROM TILDATUTORIAL.Test_View;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATUTORIAL', 'Test_Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATUTORIAL.Test_View IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATUTORIAL.Test_View as \n-- ''A pivoted view of SAT_01 forms''\nselect TILDATUTORIAL.Form."type" as "type" -- Form template type\n     , count(distinct TILDATUTORIAL.Form."refnum") as "testCount" -- The primary key for this record\n     , first(trim(TILDATUTORIAL.Form."fillDateTZ") order by TILDATUTORIAL.Form."fillDate" ASC) as "testFirstTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , first(TILDATUTORIAL.Form."fillDate" order by TILDATUTORIAL.Form."fillDate" ASC) as "testFirst" -- The date the form was filled\n     , last(trim(TILDATUTORIAL.Form."fillDateTZ") order by TILDATUTORIAL.Form."fillDate" ASC) as "testLastTZ" -- Generated helper column to hold the time zone ID for ''fillDate''.\n     , last(TILDATUTORIAL.Form."fillDate" order by TILDATUTORIAL.Form."fillDate" ASC) as "testLast" -- The date the form was filled\n     , count(distinct TILDATUTORIAL.User."refnum") as "userCount" -- The primary key for this record\n     , count(TILDATUTORIAL.TestAnswer."correct") as "answerCount" -- Whether the answer is correct or not\n     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = true) as "answerCountCorrect" -- Whether the answer is correct or not\n     , count(TILDATUTORIAL.TestAnswer."correct") filter(where correct = false) as "answerCountIncorrect" -- Whether the answer is correct or not\n     , sum(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisTotal" -- Time in milliseconds for the time spent answering the question\n     , avg(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisAvg" -- Time in milliseconds for the time spent answering the question\n     , min(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMin" -- Time in milliseconds for the time spent answering the question\n     , max(TILDATUTORIAL.TestAnswer."timeMillis") as "timeMillisMax" -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Form\n     inner join TILDATUTORIAL.User on TILDATUTORIAL.Form."userRefnum" = TILDATUTORIAL.User."refnum"\n     left  join TILDATUTORIAL.TestAnswer on TILDATUTORIAL.TestAnswer."formRefnum" = TILDATUTORIAL.Form."refnum"\n where (    TILDATUTORIAL.Form."deleted" is null\n        and TILDATUTORIAL.TestAnswer."deleted" is null\n       )\n     group by 1\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_Realized ("type", "testCount", "testFirstTZ", "testFirst", "testLastTZ", "testLast", "userCount", "answerCount", "answerCountCorrect", "answerCountIncorrect", "timeMillisTotal", "timeMillisAvg", "timeMillisMin", "timeMillisMax")\n     SELECT /*genRealizedColumnList*/"type" -- COLUMN\n          -- "fillDateTZ" -- VIEW-EXCLUDED\n          -- "fillDate" -- VIEW-EXCLUDED\n          ,"testCount" -- COLUMN\n          ,"testFirstTZ" -- COLUMN\n          ,"testFirst" -- COLUMN\n          ,"testLastTZ" -- COLUMN\n          ,"testLast" -- COLUMN\n          ,"userCount" -- COLUMN\n          ,"answerCount" -- COLUMN\n          ,"answerCountCorrect" -- COLUMN\n          ,"answerCountIncorrect" -- COLUMN\n          ,"timeMillisTotal" -- COLUMN\n          ,"timeMillisAvg" -- COLUMN\n          ,"timeMillisMin" -- COLUMN\n          ,"timeMillisMax" -- COLUMN\n     FROM TILDATUTORIAL.Test_View;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATUTORIAL'', ''Test_Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATUTORIAL.Test_View."type" IS E'Form template type';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."testCount" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."testFirstTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."testFirst" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."testLastTZ" IS E'Generated helper column to hold the time zone ID for ''fillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."testLast" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."userCount" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."answerCount" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."answerCountCorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."answerCountIncorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."timeMillisTotal" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."timeMillisAvg" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."timeMillisMin" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_View."timeMillisMax" IS E'Time in milliseconds for the time spent answering the question';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATUTORIAL.Test_View' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATUTORIAL.Test_XYZ_Analytics_View as 
select /*DoFormulasSuperView*/
"formRefnum" -- COLUMN
     , "formType" -- COLUMN
     , "formFillDateTZ" -- COLUMN
     , "formFillDate" -- COLUMN
     , "formUserRefnum" -- COLUMN
     , "formUserEmail" -- COLUMN
     , "formCountCorrect" -- COLUMN
     , "formTimeMillisTotal" -- COLUMN
     , "testCount" -- COLUMN
     , "testAnswerCountCorrect" -- COLUMN
     , "testTimeMillisAvg" -- COLUMN
     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.
     , (coalesce("formCountCorrect", 0) >= 2)::integer as "isPassed"
     -- Whether the test took longer that the average time spent across all tests.
     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::integer as "tookLongerThanAverage"
     -- Whether the test was challenging in that:<LI>
     --   <LI>it was passed,</LI>
     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>
     -- </UL>
     , ((coalesce("formCountCorrect", 0) >= 2)::integer=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::integer as "wasChallenging"

 from (
-- 'A view of XYZ forms with analytics'
select TILDATUTORIAL.Test_XYZ_PivotView."formRefnum" as "formRefnum" -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_PivotView."formType" as "formType" -- Form template type
     , TILDATUTORIAL.Test_XYZ_PivotView."formFillDateTZ" as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'formFillDate'.
     , TILDATUTORIAL.Test_XYZ_PivotView."formFillDate" as "formFillDate" -- The date the form was filled
     , TILDATUTORIAL.Test_XYZ_PivotView."formUserRefnum" as "formUserRefnum" -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_PivotView."formUserEmail" as "formUserEmail" -- The user's email
     , TILDATUTORIAL.Test_XYZ_PivotView."countCorrect" as "formCountCorrect" -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_XYZ_PivotView."timeMillisTotal" as "formTimeMillisTotal" -- Time in milliseconds for the time spent answering the question
     , TILDATUTORIAL.Test_View."testCount" as "testCount" -- The primary key for this record
     , TILDATUTORIAL.Test_View."answerCountCorrect" as "testAnswerCountCorrect" -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_View."timeMillisAvg" as "testTimeMillisAvg" -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Test_XYZ_PivotView
     inner join TILDATUTORIAL.Test_View on Test_View."type" = Test_XYZ_PivotView."formType"

      ) as T
-- Realized as /*genRealizedColumnList*/"formRefnum" -- COLUMN ,"formType" -- COLUMN ,"formFillDateTZ" -- COLUMN ,"formFillDate" -- COLUMN ,"formUserRefnum" -- COLUMN ,"formUserEmail" -- COLUMN ,"formCountCorrect" -- COLUMN ,"formTimeMillisTotal" -- COLUMN ,"testCount" -- COLUMN ,"testAnswerCountCorrect" -- COLUMN ,"testTimeMillisAvg" -- COLUMN ,"isPassed" -- FORMULA ,"tookLongerThanAverage" -- FORMULA ,"wasChallenging" -- FORMULA
;

create or replace view TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R as 
select /*DoFormulasSuperView*/
"formRefnum" -- COLUMN
     , "formType" -- COLUMN
     , "formFillDateTZ" -- COLUMN
     , "formFillDate" -- COLUMN
     , "formUserRefnum" -- COLUMN
     , "formUserEmail" -- COLUMN
     , "formCountCorrect" -- COLUMN
     , "formTimeMillisTotal" -- COLUMN
     , "testCount" -- COLUMN
     , "testAnswerCountCorrect" -- COLUMN
     , "testTimeMillisAvg" -- COLUMN
     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.
     , (coalesce("formCountCorrect", 0) >= 2)::integer as "isPassed"
     -- Whether the test took longer that the average time spent across all tests.
     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::integer as "tookLongerThanAverage"
     -- Whether the test was challenging in that:<LI>
     --   <LI>it was passed,</LI>
     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>
     -- </UL>
     , ((coalesce("formCountCorrect", 0) >= 2)::integer=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::integer as "wasChallenging"

 from (
-- 'A view of XYZ forms with analytics'
select TILDATUTORIAL.Test_XYZ_Realized."formRefnum" as "formRefnum" -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_Realized."formType" as "formType" -- Form template type
     , TILDATUTORIAL.Test_XYZ_Realized."formFillDateTZ" as "formFillDateTZ" -- Generated helper column to hold the time zone ID for 'formFillDate'.
     , TILDATUTORIAL.Test_XYZ_Realized."formFillDate" as "formFillDate" -- The date the form was filled
     , TILDATUTORIAL.Test_XYZ_Realized."formUserRefnum" as "formUserRefnum" -- The primary key for this record
     , TILDATUTORIAL.Test_XYZ_Realized."formUserEmail" as "formUserEmail" -- The user's email
     , TILDATUTORIAL.Test_XYZ_Realized."countCorrect" as "formCountCorrect" -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_XYZ_Realized."timeMillisTotal" as "formTimeMillisTotal" -- Time in milliseconds for the time spent answering the question
     , TILDATUTORIAL.Test_Realized."testCount" as "testCount" -- The primary key for this record
     , TILDATUTORIAL.Test_Realized."answerCountCorrect" as "testAnswerCountCorrect" -- Whether the answer is correct or not
     , TILDATUTORIAL.Test_Realized."timeMillisAvg" as "testTimeMillisAvg" -- Time in milliseconds for the time spent answering the question
  from TILDATUTORIAL.Test_XYZ_Realized
     inner join TILDATUTORIAL.Test_Realized on TILDATUTORIAL.Test_Realized."type" = TILDATUTORIAL.Test_XYZ_Realized."formType"

      ) as T
-- Realized as /*genRealizedColumnList*/"formRefnum" -- COLUMN ,"formType" -- COLUMN ,"formFillDateTZ" -- COLUMN ,"formFillDate" -- COLUMN ,"formUserRefnum" -- COLUMN ,"formUserEmail" -- COLUMN ,"formCountCorrect" -- COLUMN ,"formTimeMillisTotal" -- COLUMN ,"testCount" -- COLUMN ,"testAnswerCountCorrect" -- COLUMN ,"testTimeMillisAvg" -- COLUMN ,"isPassed" -- FORMULA ,"tookLongerThanAverage" -- FORMULA ,"wasChallenging" -- FORMULA
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
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATUTORIAL.Test_XYZ_Analytics_Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formRefnum", "formType", "formFillDateTZ", "formFillDate", "formUserRefnum", "formUserEmail", "formCountCorrect", "formTimeMillisTotal", "testCount", "testAnswerCountCorrect", "testTimeMillisAvg", "isPassed", "tookLongerThanAverage", "wasChallenging")
     SELECT /*genRealizedColumnList*/"formRefnum" -- COLUMN
          ,"formType" -- COLUMN
          ,"formFillDateTZ" -- COLUMN
          ,"formFillDate" -- COLUMN
          ,"formUserRefnum" -- COLUMN
          ,"formUserEmail" -- COLUMN
          ,"formCountCorrect" -- COLUMN
          ,"formTimeMillisTotal" -- COLUMN
          ,"testCount" -- COLUMN
          ,"testAnswerCountCorrect" -- COLUMN
          ,"testTimeMillisAvg" -- COLUMN
          ,"isPassed" -- FORMULA
          ,"tookLongerThanAverage" -- FORMULA
          ,"wasChallenging" -- FORMULA
     FROM TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATUTORIAL.Test_XYZ_Analytics_Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATUTORIAL', 'Test_XYZ_Analytics_Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATUTORIAL.Test_XYZ_Analytics_View IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATUTORIAL.Test_XYZ_Analytics_View as \nselect /*DoFormulasSuperView*/\n"formRefnum" -- COLUMN\n     , "formType" -- COLUMN\n     , "formFillDateTZ" -- COLUMN\n     , "formFillDate" -- COLUMN\n     , "formUserRefnum" -- COLUMN\n     , "formUserEmail" -- COLUMN\n     , "formCountCorrect" -- COLUMN\n     , "formTimeMillisTotal" -- COLUMN\n     , "testCount" -- COLUMN\n     , "testAnswerCountCorrect" -- COLUMN\n     , "testTimeMillisAvg" -- COLUMN\n     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.\n     , (coalesce("formCountCorrect", 0) >= 2)::integer as "isPassed"\n     -- Whether the test took longer that the average time spent across all tests.\n     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::integer as "tookLongerThanAverage"\n     -- Whether the test was challenging in that:<LI>\n     --   <LI>it was passed,</LI>\n     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>\n     -- </UL>\n     , ((coalesce("formCountCorrect", 0) >= 2)::integer=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::integer as "wasChallenging"\n\n from (\n-- ''A view of XYZ forms with analytics''\nselect TILDATUTORIAL.Test_XYZ_PivotView."formRefnum" as "formRefnum" -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_PivotView."formType" as "formType" -- Form template type\n     , TILDATUTORIAL.Test_XYZ_PivotView."formFillDateTZ" as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''formFillDate''.\n     , TILDATUTORIAL.Test_XYZ_PivotView."formFillDate" as "formFillDate" -- The date the form was filled\n     , TILDATUTORIAL.Test_XYZ_PivotView."formUserRefnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_PivotView."formUserEmail" as "formUserEmail" -- The user''s email\n     , TILDATUTORIAL.Test_XYZ_PivotView."countCorrect" as "formCountCorrect" -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_XYZ_PivotView."timeMillisTotal" as "formTimeMillisTotal" -- Time in milliseconds for the time spent answering the question\n     , TILDATUTORIAL.Test_View."testCount" as "testCount" -- The primary key for this record\n     , TILDATUTORIAL.Test_View."answerCountCorrect" as "testAnswerCountCorrect" -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_View."timeMillisAvg" as "testTimeMillisAvg" -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Test_XYZ_PivotView\n     inner join TILDATUTORIAL.Test_View on Test_View."type" = Test_XYZ_PivotView."formType"\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"formRefnum" -- COLUMN ,"formType" -- COLUMN ,"formFillDateTZ" -- COLUMN ,"formFillDate" -- COLUMN ,"formUserRefnum" -- COLUMN ,"formUserEmail" -- COLUMN ,"formCountCorrect" -- COLUMN ,"formTimeMillisTotal" -- COLUMN ,"testCount" -- COLUMN ,"testAnswerCountCorrect" -- COLUMN ,"testTimeMillisAvg" -- COLUMN ,"isPassed" -- FORMULA ,"tookLongerThanAverage" -- FORMULA ,"wasChallenging" -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R as \nselect /*DoFormulasSuperView*/\n"formRefnum" -- COLUMN\n     , "formType" -- COLUMN\n     , "formFillDateTZ" -- COLUMN\n     , "formFillDate" -- COLUMN\n     , "formUserRefnum" -- COLUMN\n     , "formUserEmail" -- COLUMN\n     , "formCountCorrect" -- COLUMN\n     , "formTimeMillisTotal" -- COLUMN\n     , "testCount" -- COLUMN\n     , "testAnswerCountCorrect" -- COLUMN\n     , "testTimeMillisAvg" -- COLUMN\n     -- Whether the test was passed or not by answering at least 2 out of the 3 questions.\n     , (coalesce("formCountCorrect", 0) >= 2)::integer as "isPassed"\n     -- Whether the test took longer that the average time spent across all tests.\n     , (coalesce("formTimeMillisTotal", 0) > coalesce("testTimeMillisAvg", 0))::integer as "tookLongerThanAverage"\n     -- Whether the test was challenging in that:<LI>\n     --   <LI>it was passed,</LI>\n     --   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>\n     -- </UL>\n     , ((coalesce("formCountCorrect", 0) >= 2)::integer=1 AND coalesce("testAnswerCountCorrect", 0) < coalesce("testCount", 0)*3/2)::integer as "wasChallenging"\n\n from (\n-- ''A view of XYZ forms with analytics''\nselect TILDATUTORIAL.Test_XYZ_Realized."formRefnum" as "formRefnum" -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_Realized."formType" as "formType" -- Form template type\n     , TILDATUTORIAL.Test_XYZ_Realized."formFillDateTZ" as "formFillDateTZ" -- Generated helper column to hold the time zone ID for ''formFillDate''.\n     , TILDATUTORIAL.Test_XYZ_Realized."formFillDate" as "formFillDate" -- The date the form was filled\n     , TILDATUTORIAL.Test_XYZ_Realized."formUserRefnum" as "formUserRefnum" -- The primary key for this record\n     , TILDATUTORIAL.Test_XYZ_Realized."formUserEmail" as "formUserEmail" -- The user''s email\n     , TILDATUTORIAL.Test_XYZ_Realized."countCorrect" as "formCountCorrect" -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_XYZ_Realized."timeMillisTotal" as "formTimeMillisTotal" -- Time in milliseconds for the time spent answering the question\n     , TILDATUTORIAL.Test_Realized."testCount" as "testCount" -- The primary key for this record\n     , TILDATUTORIAL.Test_Realized."answerCountCorrect" as "testAnswerCountCorrect" -- Whether the answer is correct or not\n     , TILDATUTORIAL.Test_Realized."timeMillisAvg" as "testTimeMillisAvg" -- Time in milliseconds for the time spent answering the question\n  from TILDATUTORIAL.Test_XYZ_Realized\n     inner join TILDATUTORIAL.Test_Realized on TILDATUTORIAL.Test_Realized."type" = TILDATUTORIAL.Test_XYZ_Realized."formType"\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"formRefnum" -- COLUMN ,"formType" -- COLUMN ,"formFillDateTZ" -- COLUMN ,"formFillDate" -- COLUMN ,"formUserRefnum" -- COLUMN ,"formUserEmail" -- COLUMN ,"formCountCorrect" -- COLUMN ,"formTimeMillisTotal" -- COLUMN ,"testCount" -- COLUMN ,"testAnswerCountCorrect" -- COLUMN ,"testTimeMillisAvg" -- COLUMN ,"isPassed" -- FORMULA ,"tookLongerThanAverage" -- FORMULA ,"wasChallenging" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized();\nCREATE OR REPLACE FUNCTION TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATUTORIAL.Test_XYZ_Analytics_Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATUTORIAL.Test_XYZ_Analytics_Realized ("formRefnum", "formType", "formFillDateTZ", "formFillDate", "formUserRefnum", "formUserEmail", "formCountCorrect", "formTimeMillisTotal", "testCount", "testAnswerCountCorrect", "testTimeMillisAvg", "isPassed", "tookLongerThanAverage", "wasChallenging")\n     SELECT /*genRealizedColumnList*/"formRefnum" -- COLUMN\n          ,"formType" -- COLUMN\n          ,"formFillDateTZ" -- COLUMN\n          ,"formFillDate" -- COLUMN\n          ,"formUserRefnum" -- COLUMN\n          ,"formUserEmail" -- COLUMN\n          ,"formCountCorrect" -- COLUMN\n          ,"formTimeMillisTotal" -- COLUMN\n          ,"testCount" -- COLUMN\n          ,"testAnswerCountCorrect" -- COLUMN\n          ,"testTimeMillisAvg" -- COLUMN\n          ,"isPassed" -- FORMULA\n          ,"tookLongerThanAverage" -- FORMULA\n          ,"wasChallenging" -- FORMULA\n     FROM TILDATMP.TILDATUTORIAL_Test_XYZ_Analytics_View_R;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATUTORIAL.Test_XYZ_Analytics_Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATUTORIAL'', ''Test_XYZ_Analytics_Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATUTORIAL.Refill_Test_XYZ_Analytics_Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formType" IS E'Form template type';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ" IS E'Generated helper column to hold the time zone ID for ''formFillDate''.';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate" IS E'The date the form was filled';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formUserRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formUserEmail" IS E'The user''s email';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formCountCorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."formTimeMillisTotal" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."testCount" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."testAnswerCountCorrect" IS E'Whether the answer is correct or not';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."testTimeMillisAvg" IS E'Time in milliseconds for the time spent answering the question';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed" IS E'The calculated formula: Whether the test was passed or not by answering at least 2 out of the 3 questions.';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage" IS E'The calculated formula: Whether the test took longer that the average time spent across all tests.';
COMMENT ON COLUMN TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging" IS E'The calculated formula: Whether the test was challenging in that:<LI>\n  <LI>it was passed,</LI>\n  <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>\n</UL>';

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 3)-3;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDATUTORIAL.Test_XYZ_Analytics_View', 'TILDATUTORIAL.Test_XYZ_Analytics_Realized', 'isPassed', 'INT', 'Test Passed', 'Whether the test was passed or not by answering at least 2 out of the 3 questions.', 'formCountCorrect >= 2', '<B>N/A</B>', ARRAY['TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect'], current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDATUTORIAL.Test_XYZ_Analytics_View', 'TILDATUTORIAL.Test_XYZ_Analytics_Realized', 'tookLongerThanAverage', 'INT', 'Test Took Longer Than Average', 'Whether the test took longer that the average time spent across all tests.', 'formTimeMillisTotal > testTimeMillisAvg', '<B>N/A</B>', ARRAY['TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal', 'TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg'], current_timestamp, current_timestamp, null)
          ,(k+2, 'TILDATUTORIAL.Test_XYZ_Analytics_View', 'TILDATUTORIAL.Test_XYZ_Analytics_Realized', 'wasChallenging', 'INT', 'Test Was Challenging', 'Whether the test was challenging in that:<LI>
  <LI>it was passed,</LI>
  <LI>and overall, less than a third of answers across all tests were answered correctly.</LI>
</UL>', '    isPassed=1
AND testAnswerCountCorrect < testCount*3/2', '<B>N/A</B>', ARRAY['TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect', 'TILDATUTORIAL.Test_XYZ_Analytics_View.testCount'], current_timestamp, current_timestamp, null)
  ON CONFLICT("location", "name") DO UPDATE
    SET "location2" = EXCLUDED."location2"
      , "type" = EXCLUDED."type"
      , "title" = EXCLUDED."title"
      , "description" = EXCLUDED."description"
      , "formula" = EXCLUDED."formula"
      , "htmlDoc" = EXCLUDED."htmlDoc"
      , "referencedColumns" = EXCLUDED."referencedColumns"
      , "lastUpdated" = current_timestamp
      , "deleted" = null
   ;
UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View' AND "lastUpdated" < ts;

INSERT INTO TILDA.FormulaResult ("formulaRefnum", "value", "description", "created", "lastUpdated", "deleted")
    VALUES ((select refnum from TILDA.Formula where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View' AND "name" = 'wasChallenging'), '0', 'The test was not challenging', current_timestamp, current_timestamp, null)
          ,((select refnum from TILDA.Formula where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View' AND "name" = 'wasChallenging'), '1', 'The test was challenging', current_timestamp, current_timestamp, null)
  ON CONFLICT("formulaRefnum", "value") DO UPDATE
    SET "description" = EXCLUDED."description"
      , "lastUpdated" = current_timestamp
      , "deleted" = null
   ;
UPDATE TILDA.FormulaResult
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View'
                                and "deleted" is not null
                            );

INSERT INTO TILDA.FormulaDependency("formulaRefnum", "dependencyRefnum", "created", "lastUpdated", "deleted")
    VALUES ( (select refnum from TILDA.Formula where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View' AND "name" = 'wasChallenging')
            ,(select refnum from TILDA.Formula where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View' AND "name" = 'isPassed')
            ,current_timestamp, current_timestamp, null
           )
  ON CONFLICT("formulaRefnum", "dependencyRefnum") DO UPDATE
    SET "lastUpdated" = current_timestamp
      , "deleted" = null
   ;
UPDATE TILDA.FormulaDependency
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View'
                                and "deleted" is not null
                            );

select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', 0)-0;


DELETE FROM TILDA.MeasureFormula
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATUTORIAL.Test_XYZ_Analytics_View'
                                and "deleted" is not null
                            );

UPDATE TILDA.Measure
   set deleted = current_timestamp
 where "refnum" not in (select "measureRefnum" from TILDA.MeasureFormula)
 ;

END; $$
LANGUAGE PLPGSQL;

