
create schema if not exists TILDA;



create table if not exists TILDA.ZoneInfo -- blah blah
 (  `id`             STRING     not null  OPTIONS(description="The id for this enumeration.")
  , `value`          STRING     not null  OPTIONS(description="The value for this enumeration.")
  , `label`          STRING     not null  OPTIONS(description="The label for this enumeration.")
  , `deactivatedTZ`  STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'deactivated'.")
  , `deactivated`    TIMESTAMP            OPTIONS(description="The label for this enumeration.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.ZoneInfo)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.ZoneInfo)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.ZoneInfo)")
  -- PRIMARY KEY(`id`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_ZoneInfo_deactivated FOREIGN KEY (`deactivatedTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="blah blah");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS ZoneInfo_Id ON TILDA.ZoneInfo ("id");
--  CREATE UNIQUE INDEX IF NOT EXISTS ZoneInfo_Value ON TILDA.ZoneInfo ("value");
--  CREATE INDEX IF NOT EXISTS ZoneInfo_All ON TILDA.ZoneInfo ("id" ASC);



create table if not exists TILDA.Key -- The table to keep track of unique keys across distributed objects/tables
 (  `refnum`          INT64      not null  OPTIONS(description="The primary key for this record")
  , `name`            STRING     not null  OPTIONS(description="The name of the table/object tracked")
  , `max`             INT64      not null  OPTIONS(description="The pre-allocated max RefNum for this table/object.")
  , `count`           INT64      not null  OPTIONS(description="The size of the pre-allocation required by this table/object.")
  , `created`         TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created.")
  , `lastUpdated`     TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated.")
  , `deleted`         TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted.")
  -- PRIMARY KEY(`refnum`)
 )
OPTIONS (description="The table to keep track of unique keys across distributed objects/tables");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Key_Name ON TILDA.Key ("name");
--  CREATE INDEX IF NOT EXISTS Key_AllByName ON TILDA.Key ("name" ASC) where TILDA.Key."deleted" is null;



create table if not exists TILDA.MaintenanceLog -- Maintenance information
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `type`         STRING     not null  OPTIONS(description="The type of maintenance, e.g., Migration, Reorg...")
  , `schemaName`   STRING     not null  OPTIONS(description="The name of the schema for the resource.")
  , `objectName`   STRING               OPTIONS(description="The name of the resource.")
  , `objectType`   STRING               OPTIONS(description="The type of the resource.")
  , `startTimeTZ`  STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startTime'.")
  , `startTime`    TIMESTAMP  not null  OPTIONS(description="The timestamp for when the refill started.")
  , `endTimeTZ`    STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'endTime'.")
  , `endTime`      TIMESTAMP            OPTIONS(description="The timestamp for when the refill ended.")
  , `statement`    STRING               OPTIONS(description="The value of the maintenance resource to track.")
  , `action`       STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `descr`        STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.MaintenanceLog)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.MaintenanceLog)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.MaintenanceLog)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_MaintenanceLog_startTime FOREIGN KEY (`startTimeTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_MaintenanceLog_endTime FOREIGN KEY (`endTimeTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Maintenance information");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS MaintenanceLog_SchemaObjectStart ON TILDA.MaintenanceLog ("schemaName", "objectName", "startTime" DESC);
--  CREATE INDEX IF NOT EXISTS MaintenanceLog_TypeStart ON TILDA.MaintenanceLog ("type", "startTime" DESC);



create table if not exists TILDA.TransPerf -- Performance logs for the Tilda framework
 (  `startPeriodTZ`           STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startPeriod'.")
  , `startPeriod`             TIMESTAMP  not null  OPTIONS(description="The timestamp for when the record was created.")
  , `endPeriodTZ`             STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'endPeriod'.")
  , `endPeriod`               TIMESTAMP  not null  OPTIONS(description="The timestamp for when the record was created.")
  , `commitNano`              INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `commitCount`             INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `rollbackNano`            INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `rollbackCount`           INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointSetNano`        INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointSetCount`       INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointCommitNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointCommitCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointRollbackNano`   INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `savepointRollbackCount`  INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `statementCloseNano`      INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `statementCloseCount`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `connectionCloseNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `connectionCloseCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `connectionGetNano`       INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `connectionGetCount`      INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaSetterNano`         INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaSetterCount`        INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToStringNano`       INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToStringCount`      INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToJsonNano`         INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToJsonCount`        INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToCsvNano`          INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `tildaToCsvCount`         INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `created`                 TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.TransPerf)")
  , `lastUpdated`             TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.TransPerf)")
  , `deleted`                 TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.TransPerf)")
  -- PRIMARY KEY(`startPeriod`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TransPerf_startPeriod FOREIGN KEY (`startPeriodTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TransPerf_endPeriod FOREIGN KEY (`endPeriodTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Performance logs for the Tilda framework");



create table if not exists TILDA.RefillPerf -- Performance logs for the Tilda Refills
 (  `schemaName`      STRING     not null  OPTIONS(description="The name of the schema tracked")
  , `objectName`      STRING     not null  OPTIONS(description="The name of the table/object tracked")
  , `startDateIncr`   DATE                 OPTIONS(description="The date passed in for incremental refills.")
  , `startTimeTZ`     STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startTime'.")
  , `startTime`       TIMESTAMP  not null  OPTIONS(description="The timestamp for when the refill started.")
  , `endTimeTZ`       STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'endTime'.")
  , `endTime`         TIMESTAMP  not null  OPTIONS(description="The timestamp for when the refill ended.")
  , `timeInsertSec`   INT64      not null  OPTIONS(description="The time, in seconds, the inserts took.")
  , `timeDeleteSec`   INT64      not null  OPTIONS(description="The time, in seconds, the deletes took.")
  , `timeAnalyzeSec`  INT64      not null  OPTIONS(description="The time, in seconds, the analyze took.")
  , `timeTotalSec`    INT64     DEFAULT 0  not null  OPTIONS(description="The time, in seconds, the analyze took.")
  , `insertCount`     INT64      not null  OPTIONS(description="The count of inserted rows.")
  , `deleteCount`     INT64      not null  OPTIONS(description="The count of rows deleted.")
  , `created`         TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.RefillPerf)")
  , `lastUpdated`     TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.RefillPerf)")
  , `deleted`         TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.RefillPerf)")
  -- PRIMARY KEY(`schemaName`, `objectName`, `startTime`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_RefillPerf_startTime FOREIGN KEY (`startTimeTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_RefillPerf_endTime FOREIGN KEY (`endTimeTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Performance logs for the Tilda Refills");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS RefillPerf_SchemaByObjectStart ON TILDA.RefillPerf ("schemaName", "objectName" ASC, "startTime" DESC);
--  CREATE INDEX IF NOT EXISTS RefillPerf_SchemaObjectByStart ON TILDA.RefillPerf ("schemaName", "objectName", "startTime" DESC);



create table if not exists TILDA.Mapping -- Generalized Mapping table
 (  `type`         STRING     not null  OPTIONS(description="The type this mapping is for")
  , `src`          STRING     not null  OPTIONS(description="The source value for this mapping")
  , `dst`          STRING     not null  OPTIONS(description="The the destination (mapped) value for this mapping.")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Mapping)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Mapping)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Mapping)")
 )
OPTIONS (description="Generalized Mapping table");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Mapping_TypeSrcDst ON TILDA.Mapping ("type", "src", "dst");



create table if not exists TILDA.Connection -- Tilda DB Connections Configurations.
 (  `active`       BOOLEAN                  OPTIONS(description="Status Flag")
  , `id`           STRING         not null  OPTIONS(description="Connection ID")
  , `driver`       STRING         not null  OPTIONS(description="DB Driver")
  , `db`           STRING         not null  OPTIONS(description="DB Url")
  , `user`         STRING         not null  OPTIONS(description="DB User")
  , `pswd`         STRING         not null  OPTIONS(description="DB Password")
  , `initial`      INT64          not null  OPTIONS(description="Minimum Connections")
  , `max`          INT64          not null  OPTIONS(description="Maximum Connections")
  , `schemas`      ARRAY<STRING>  not null  OPTIONS(description="Schemas")
  , `created`      TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Connection)")
  , `lastUpdated`  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Connection)")
  , `deleted`      TIMESTAMP                OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Connection)")
  -- PRIMARY KEY(`id`)
 )
OPTIONS (description="Tilda DB Connections Configurations.");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Connection_AllById ON TILDA.Connection ("id" ASC);



create table if not exists TILDA.Job -- Jobs details
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `name`         STRING     not null  OPTIONS(description="Name")
  , `type`         STRING               OPTIONS(description="Job type")
  , `userId`       STRING               OPTIONS(description="Job user Id")
  , `dataStartTZ`  STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'dataStart'.")
  , `dataStart`    TIMESTAMP            OPTIONS(description="StartTime")
  , `dataEndTZ`    STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'dataEnd'.")
  , `dataEnd`      TIMESTAMP            OPTIONS(description="StartTime")
  , `startTZ`      STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'start'.")
  , `start`        TIMESTAMP  not null  OPTIONS(description="StartTime")
  , `endTZ`        STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'end'.")
  , `end`          TIMESTAMP            OPTIONS(description="EndTime")
  , `status`       BOOLEAN              OPTIONS(description="Status")
  , `msg`          STRING               OPTIONS(description="Message details")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Job)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Job)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Job)")
  -- PRIMARY KEY(`refnum`)
 )
OPTIONS (description="Jobs details");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Job_JobName ON TILDA.Job ("name", "start" DESC);
--  CREATE INDEX IF NOT EXISTS Job_JobType ON TILDA.Job ("type", "start" DESC);



create table if not exists TILDA.JobPart -- Job part details
 (  `refnum`        INT64      not null  OPTIONS(description="The primary key for this record")
  , `jobRefnum`     INT64      not null  OPTIONS(description="Parent Job Refnum")
  , `name`          STRING     not null  OPTIONS(description="Job part name")
  , `type`          STRING               OPTIONS(description="Job part type")
  , `dataStartTZ`   STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'dataStart'.")
  , `dataStart`     TIMESTAMP            OPTIONS(description="Job part data start")
  , `dataEndTZ`     STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'dataEnd'.")
  , `dataEnd`       TIMESTAMP            OPTIONS(description="Job part data end")
  , `startTZ`       STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'start'.")
  , `start`         TIMESTAMP  not null  OPTIONS(description="Job part execution start")
  , `endTZ`         STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'end'.")
  , `end`           TIMESTAMP            OPTIONS(description="Job part execution end")
  , `recordsCount`  INT64                OPTIONS(description="count of database or file or ... records.")
  , `status`        BOOLEAN              OPTIONS(description="Status flag, i.e., success=true and failure-false")
  , `created`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.JobPart)")
  , `lastUpdated`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.JobPart)")
  , `deleted`       TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.JobPart)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_JobPart_Job FOREIGN KEY (`jobRefnum`) REFERENCES TILDA.Job ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Job part details");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS JobPart_Job ON TILDA.JobPart ("jobRefnum", "start" DESC);
--  CREATE INDEX IF NOT EXISTS JobPart_JobPartName ON TILDA.JobPart ("name", "start" DESC);
--  CREATE INDEX IF NOT EXISTS JobPart_JobPartType ON TILDA.JobPart ("type", "start" DESC);



create table if not exists TILDA.JobPartMessage -- Job part message details
 (  `refnum`         INT64      not null  OPTIONS(description="The primary key for this record")
  , `jobRefnum`      INT64      not null  OPTIONS(description="Parent Job Refnum")
  , `jobPartRefnum`  INT64                OPTIONS(description="Parent Job Part Refnum")
  , `notify`         BOOLEAN    not null  OPTIONS(description="Notification flag")
  , `msg`            STRING     not null  OPTIONS(description="Message details")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.JobPartMessage)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.JobPartMessage)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.JobPartMessage)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_JobPartMessage_Job FOREIGN KEY (`jobRefnum`) REFERENCES TILDA.Job ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_JobPartMessage_JobPart FOREIGN KEY (`jobPartRefnum`) REFERENCES TILDA.JobPart ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Job part message details");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS JobPartMessage_Job ON TILDA.JobPartMessage ("jobRefnum", "created" DESC);
--  CREATE INDEX IF NOT EXISTS JobPartMessage_JobPart ON TILDA.JobPartMessage ("jobPartRefnum", "created" DESC);



create table if not exists TILDA.ObjectPerf -- Performance logs for the Tilda framework
 (  `schemaName`     STRING     not null  OPTIONS(description="The name of the schema tracked")
  , `objectName`     STRING     not null  OPTIONS(description="The name of the table/object tracked")
  , `startPeriodTZ`  STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startPeriod'.")
  , `startPeriod`    TIMESTAMP  not null  OPTIONS(description="The timestamp for when the record was created.")
  , `endPeriodTZ`    STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'endPeriod'.")
  , `endPeriod`      TIMESTAMP  not null  OPTIONS(description="The timestamp for when the record was created.")
  , `selectNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `selectCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `selectRecords`  INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `insertNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `insertCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `insertRecords`  INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `updateNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `updateCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `updateRecords`  INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `deleteNano`     INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `deleteCount`    INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `deleteRecords`  INT64     DEFAULT 0  not null  OPTIONS(description="Blah...")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.ObjectPerf)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.ObjectPerf)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.ObjectPerf)")
  -- PRIMARY KEY(`schemaName`, `objectName`, `startPeriod`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_ObjectPerf_startPeriod FOREIGN KEY (`startPeriodTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_ObjectPerf_endPeriod FOREIGN KEY (`endPeriodTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Performance logs for the Tilda framework");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaByObjectStart ON TILDA.ObjectPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
--  CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaObjectByStart ON TILDA.ObjectPerf ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.Formula -- Master formula information
 (  `refnum`             INT64          not null  OPTIONS(description="The primary key for this record")
  , `location`           STRING         not null  OPTIONS(description="The name of the primary table/view this formula is defined in.")
  , `location2`          STRING         not null  OPTIONS(description="The name of the secondary table/view (a derived view, a realized table), if appropriate.")
  , `name`               STRING         not null  OPTIONS(description="The name of the formula/column.")
  , `type`               STRING         not null  OPTIONS(description="The type of the formula/column value/outcome.")
  , `title`              STRING         not null  OPTIONS(description="The title of the formula/column.")
  , `description`        STRING         not null  OPTIONS(description="The description of the formula/column.")
  , `formula`            STRING                   OPTIONS(description="The formula.")
  , `htmlDoc`            STRING                   OPTIONS(description="Pre-rendered html fragment with the full documentation for this formula.")
  , `referencedColumns`  ARRAY<STRING>            OPTIONS(description="The list of columns this formula depends on.")
  , `created`            TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Formula)")
  , `lastUpdated`        TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Formula)")
  , `deleted`            TIMESTAMP                OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Formula)")
  -- PRIMARY KEY(`refnum`)
 )
OPTIONS (description="Master formula information");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Formula_Formula ON TILDA.Formula ("location", "name");
--  CREATE INDEX IF NOT EXISTS Formula_RefCols ON TILDA.Formula USING gin  ("referencedColumns" );



create table if not exists TILDA.Measure -- Master Measure information
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `schema`       STRING     not null  OPTIONS(description="The Schema wher ethe measure is defined.")
  , `name`         STRING     not null  OPTIONS(description="The name of the measure.")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Measure)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Measure)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Measure)")
  -- PRIMARY KEY(`refnum`)
 )
OPTIONS (description="Master Measure information");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Measure_Measure ON TILDA.Measure ("schema", "name");



create table if not exists TILDA.MeasureFormula -- Master Measure information
 (  `measureRefnum`  INT64      not null  OPTIONS(description="The measure.")
  , `formulaRefnum`  INT64      not null  OPTIONS(description="The parent formula.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.MeasureFormula)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.MeasureFormula)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.MeasureFormula)")
  -- PRIMARY KEY(`measureRefnum`, `formulaRefnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_MeasureFormula_Measure FOREIGN KEY (`measureRefnum`) REFERENCES TILDA.Measure ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_MeasureFormula_Formula FOREIGN KEY (`formulaRefnum`) REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Master Measure information");



create table if not exists TILDA.FormulaDependency -- Master formula dependency information
 (  `formulaRefnum`     INT64      not null  OPTIONS(description="The parent formula.")
  , `dependencyRefnum`  INT64      not null  OPTIONS(description="The dependent formula.")
  , `created`           TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.FormulaDependency)")
  , `lastUpdated`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.FormulaDependency)")
  , `deleted`           TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.FormulaDependency)")
  -- PRIMARY KEY(`formulaRefnum`, `dependencyRefnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_FormulaDependency_Formula1 FOREIGN KEY (`formulaRefnum`) REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_FormulaDependency_Formula2 FOREIGN KEY (`dependencyRefnum`) REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Master formula dependency information");



create table if not exists TILDA.FormulaResult -- Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)
 (  `formulaRefnum`  INT64      not null  OPTIONS(description="The parent formula.")
  , `value`          STRING     not null  OPTIONS(description="The result value.")
  , `description`    STRING     not null  OPTIONS(description="The description of the result value.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.FormulaResult)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.FormulaResult)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.FormulaResult)")
  -- PRIMARY KEY(`formulaRefnum`, `value`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_FormulaResult_Formula FOREIGN KEY (`formulaRefnum`) REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)");



create table if not exists TILDA.FailedDependencyDDLScripts -- A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.
 (  `srcSchemaName`  STRING     not null  OPTIONS(description="The result value.")
  , `srcTVName`      STRING     not null  OPTIONS(description="The result value.")
  , `seq`            INT64      not null  OPTIONS(description="The blah")
  , `depSchemaName`  STRING     not null  OPTIONS(description="The result value.")
  , `depViewName`    STRING     not null  OPTIONS(description="The result value.")
  , `restoreScript`  STRING     not null  OPTIONS(description="The result value.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.FailedDependencyDDLScripts)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.FailedDependencyDDLScripts)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.FailedDependencyDDLScripts)")
 )
OPTIONS (description="A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS FailedDependencyDDLScripts_DepedencySequence ON TILDA.FailedDependencyDDLScripts ("srcSchemaName", "srcTVName", "created", "seq");



create table if not exists TILDA.DateDim -- The Date dimension, capturing pre-calculated metrics on dates
 (  `dt`              DATE       not null  OPTIONS(description="The Date date")
  , `epoch`           INT64      not null  OPTIONS(description="The epoch date")
  , `dayName`         STRING               OPTIONS(description="Day name (i.e., Monday, Tuesday...) of the date")
  , `dayOfWeek`       INT64                OPTIONS(description="ISO 8601 day of the week (Monday=1 to Sunday=7) of the date")
  , `dayOfMonth`      INT64                OPTIONS(description="ISO 8601 day of the month (starting with 1) of the date")
  , `dayOfQuarter`    INT64                OPTIONS(description="ISO 8601 day of the quarter (starting with 1) of the date")
  , `dayOfYear`       INT64                OPTIONS(description="ISO 8601 day of the year (starting with 1) of the date")
  , `weekOfMonth`     INT64                OPTIONS(description="ISO 8601 week of the month (starting with 1) of the date")
  , `weekOfYear`      INT64                OPTIONS(description="ISO 8601 week of the year (starting with 1) of the date")
  , `month`           DATE                 OPTIONS(description="Month-truncated date.")
  , `monthOfYear`     INT64                OPTIONS(description="ISO 8601 month of the year (starting with 1) of the date")
  , `monthName`       STRING               OPTIONS(description="Month name (i.e., January, February...) of the date.")
  , `monthNameShort`  STRING               OPTIONS(description="Monday short name (i.e., Jan, Feb...) of the date.")
  , `quarterOfYear`   INT64                OPTIONS(description="ISO 8601 quarter of the year (starting with 1) of the date.")
  , `quarterName`     STRING               OPTIONS(description="Quarter name (i.e., Q1, Q2...) of the date.")
  , `year`            INT64                OPTIONS(description="ISO 8601 year (1.e., 2018) of the date.")
  , `mmyyyy`          STRING               OPTIONS(description="The mmyyyy printable version of a date.")
  , `mmddyyyy`        STRING               OPTIONS(description="The mmddyyyy printable version of a date.")
  , `yyyymmdd`        STRING               OPTIONS(description="The yyyymmdd sortable printable version of a date.")
  , `isWeekend`       INT64                OPTIONS(description="1 if this is a weekend day, 0 otherwise.")
  , `isBusinessDay`   INT64                OPTIONS(description="1 if this is a business day, 0 otherwise.")
  , `isHoliday`       INT64                OPTIONS(description="1 if this is a holiday, 0 otherwise.")
  , `holidayName`     STRING               OPTIONS(description="The name of the holiday if applicable.")
  , `created`         TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.DateDim)")
  , `lastUpdated`     TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.DateDim)")
  , `deleted`         TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.DateDim)")
  -- PRIMARY KEY(`dt`)
 )
OPTIONS (description="The Date dimension, capturing pre-calculated metrics on dates");



create table if not exists TILDA.DateLimitDim -- A single row for min, max and invalid dates for the Date_Dim
 (  `invalidDate`  DATE  not null  OPTIONS(description="The invalid date")
  , `minDate`      DATE  not null  OPTIONS(description="The min date")
  , `maxDate`      DATE  not null  OPTIONS(description="The max date")
  -- FK not supported in BQ
  -- , CONSTRAINT fk_DateLimitDim_InvalidDt FOREIGN KEY (`invalidDate`) REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_DateLimitDim_MinDt FOREIGN KEY (`minDate`) REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_DateLimitDim_MaxDt FOREIGN KEY (`maxDate`) REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="A single row for min, max and invalid dates for the Date_Dim");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS DateLimitDim_InvalidDate ON TILDA.DateLimitDim ("invalidDate");




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.FormulaResultView as 
-- 'A view of formulas and their values.'
select TILDA.FormulaResult.`formulaRefnum` as `formulaRefnum` -- The parent formula.
     , TILDA.FormulaResult.`value` as `value` -- The result value.
     , TILDA.FormulaResult.`description` as `description` -- The description of the result value.
     , TILDA.Formula.`location` as `location` -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula.`name` as `name` -- The name of the formula/column.
  from TILDA.FormulaResult
     inner join TILDA.Formula on TILDA.FormulaResult.`formulaRefnum` = TILDA.Formula.`refnum`
 where (TILDA.Formula.`deleted` is null and TILDA.FormulaResult.`deleted` is null)
;


ALTER VIEW TILDA.FormulaResultView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.FormulaResultView as \n-- ''A view of formulas and their values.''\nselect TILDA.FormulaResult.`formulaRefnum` as `formulaRefnum` -- The parent formula.\n     , TILDA.FormulaResult.`value` as `value` -- The result value.\n     , TILDA.FormulaResult.`description` as `description` -- The description of the result value.\n     , TILDA.Formula.`location` as `location` -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula.`name` as `name` -- The name of the formula/column.\n  from TILDA.FormulaResult\n     inner join TILDA.Formula on TILDA.FormulaResult.`formulaRefnum` = TILDA.Formula.`refnum`\n where (TILDA.Formula.`deleted` is null and TILDA.FormulaResult.`deleted` is null)\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.FormulaDependencyView as 
-- 'A view of formulas and their direct dependencies.'
select TILDA.FormulaDependency.`formulaRefnum` as `formulaRefnum` -- The parent formula.
     , TILDA.Formula.`location` as `location` -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula.`name` as `name` -- The name of the formula/column.
     , TILDA.Formula.`referencedColumns` as `referencedColumns` -- The list of columns this formula depends on.
     , TILDA.FormulaDependency.`dependencyRefnum` as `dependencyRefnum` -- The dependent formula.
     , TILDA_Formula_2.`name` as `dependentFormulaName` -- The name of the formula/column.
     , TILDA_Formula_2.`location` as `dependentFormulaLocation` -- The name of the primary table/view this formula is defined in.
     , TILDA_Formula_2.`referencedColumns` as `dependentReferencedColumns` -- The list of columns this formula depends on.
  from TILDA.FormulaDependency
     inner join TILDA.Formula on TILDA.FormulaDependency.`formulaRefnum` = TILDA.Formula.`refnum`
     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency.`dependencyRefnum` = TILDA_Formula_2.`refnum`
 where (TILDA.Formula.`deleted` is null)
;


ALTER VIEW TILDA.FormulaDependencyView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.FormulaDependencyView as \n-- ''A view of formulas and their direct dependencies.''\nselect TILDA.FormulaDependency.`formulaRefnum` as `formulaRefnum` -- The parent formula.\n     , TILDA.Formula.`location` as `location` -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula.`name` as `name` -- The name of the formula/column.\n     , TILDA.Formula.`referencedColumns` as `referencedColumns` -- The list of columns this formula depends on.\n     , TILDA.FormulaDependency.`dependencyRefnum` as `dependencyRefnum` -- The dependent formula.\n     , TILDA_Formula_2.`name` as `dependentFormulaName` -- The name of the formula/column.\n     , TILDA_Formula_2.`location` as `dependentFormulaLocation` -- The name of the primary table/view this formula is defined in.\n     , TILDA_Formula_2.`referencedColumns` as `dependentReferencedColumns` -- The list of columns this formula depends on.\n  from TILDA.FormulaDependency\n     inner join TILDA.Formula on TILDA.FormulaDependency.`formulaRefnum` = TILDA.Formula.`refnum`\n     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency.`dependencyRefnum` = TILDA_Formula_2.`refnum`\n where (TILDA.Formula.`deleted` is null)\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.MeasureFormulaView as 
-- 'A view of formulas and their dependencies.'
select TILDA.MeasureFormula.`measureRefnum` as `measureRefnum` -- The measure.
     , TILDA.Measure.`schema` as `measureSchema` -- The Schema wher ethe measure is defined.
     , TILDA.Measure.`name` as `measureName` -- The name of the measure.
     , TILDA.Formula.`refnum` as `formulaRefnum` -- The primary key for this record
     , TILDA.Formula.`location` as `formulaLocation` -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula.`location2` as `formulaLocation2` -- The name of the secondary table/view (a derived view, a realized table), if appropriate.
     , TILDA.Formula.`name` as `formulaName` -- The name of the formula/column.
     , TILDA.Formula.`title` as `title` -- The title of the formula/column.
     , TILDA.Formula.`description` as `description` -- The description of the formula/column.
     , TILDA.Formula.`type` as `type` -- The type of the formula/column value/outcome.
     , TILDA.Formula.`formula` as `formula` -- The formula.
  from TILDA.MeasureFormula
     inner join TILDA.Measure on TILDA.MeasureFormula.`measureRefnum` = TILDA.Measure.`refnum`
     inner join TILDA.Formula on TILDA.MeasureFormula.`formulaRefnum` = TILDA.Formula.`refnum`
 where (TILDA.Formula.`deleted` is null and TILDA.Measure.`deleted` is null)
;


ALTER VIEW TILDA.MeasureFormulaView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.MeasureFormulaView as \n-- ''A view of formulas and their dependencies.''\nselect TILDA.MeasureFormula.`measureRefnum` as `measureRefnum` -- The measure.\n     , TILDA.Measure.`schema` as `measureSchema` -- The Schema wher ethe measure is defined.\n     , TILDA.Measure.`name` as `measureName` -- The name of the measure.\n     , TILDA.Formula.`refnum` as `formulaRefnum` -- The primary key for this record\n     , TILDA.Formula.`location` as `formulaLocation` -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula.`location2` as `formulaLocation2` -- The name of the secondary table/view (a derived view, a realized table), if appropriate.\n     , TILDA.Formula.`name` as `formulaName` -- The name of the formula/column.\n     , TILDA.Formula.`title` as `title` -- The title of the formula/column.\n     , TILDA.Formula.`description` as `description` -- The description of the formula/column.\n     , TILDA.Formula.`type` as `type` -- The type of the formula/column value/outcome.\n     , TILDA.Formula.`formula` as `formula` -- The formula.\n  from TILDA.MeasureFormula\n     inner join TILDA.Measure on TILDA.MeasureFormula.`measureRefnum` = TILDA.Measure.`refnum`\n     inner join TILDA.Formula on TILDA.MeasureFormula.`formulaRefnum` = TILDA.Formula.`refnum`\n where (TILDA.Formula.`deleted` is null and TILDA.Measure.`deleted` is null)\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.JobView as 
-- 'A view of the job data.'
select TILDA.Job.`refnum` as `jobRefnum` -- The primary key for this record
     , TILDA.Job.`name` as `jobName` -- Name
     , TILDA.Job.`type` as `jobType` -- Job type
     , TILDA.Job.`userId` as `jobUserId` -- Job user Id
     , TILDA.Job.`dataStartTZ` as `jobDataStartTZ` -- Generated helper column to hold the time zone ID for 'dataStart'.
     , TILDA.Job.`dataStart` as `jobDataStart` -- StartTime
     , TILDA.Job.`dataEndTZ` as `jobDataEndTZ` -- Generated helper column to hold the time zone ID for 'dataEnd'.
     , TILDA.Job.`dataEnd` as `jobDataEnd` -- StartTime
     , TILDA.Job.`startTZ` as `jobStartTZ` -- Generated helper column to hold the time zone ID for 'start'.
     , TILDA.Job.`start` as `jobStart` -- StartTime
     , TILDA.Job.`endTZ` as `jobEndTZ` -- Generated helper column to hold the time zone ID for 'end'.
     , TILDA.Job.`end` as `jobEnd` -- EndTime
     , TILDA.Job.`status` as `jobStatus` -- Status
     , TILDA.Job.`msg` as `jobMsg` -- Message details
     , TILDA.JobPart.`name` as `jobPartName` -- Job part name
     , TILDA.JobPart.`type` as `jobPartType` -- Job part type
     , TILDA.JobPart.`dataStartTZ` as `jobPartDataStartTZ` -- Generated helper column to hold the time zone ID for 'dataStart'.
     , TILDA.JobPart.`dataStart` as `jobPartDataStart` -- Job part data start
     , TILDA.JobPart.`dataEndTZ` as `jobPartDataEndTZ` -- Generated helper column to hold the time zone ID for 'dataEnd'.
     , TILDA.JobPart.`dataEnd` as `jobPartDataEnd` -- Job part data end
     , TILDA.JobPart.`startTZ` as `jobPartStartTZ` -- Generated helper column to hold the time zone ID for 'start'.
     , TILDA.JobPart.`start` as `jobPartStart` -- Job part execution start
     , TILDA.JobPart.`endTZ` as `jobPartEndTZ` -- Generated helper column to hold the time zone ID for 'end'.
     , TILDA.JobPart.`end` as `jobPartEnd` -- Job part execution end
     , TILDA.JobPart.`recordsCount` as `jobPartRecordsCount` -- count of database or file or ... records.
     , TILDA.JobPart.`status` as `jobPartStatus` -- Status flag, i.e., success=true and failure-false
     , TILDA.JobPartMessage.`notify` as `jobPartNotify` -- Notification flag
     , TILDA.JobPartMessage.`msg` as `jobPartMessage` -- Message details
  from TILDA.Job
     left  join TILDA.JobPart on TILDA.JobPart.`jobRefnum` = TILDA.Job.`refnum`
     left  join TILDA.JobPartMessage on TILDA.JobPartMessage.`jobPartRefnum` = TILDA.JobPart.`refnum`
;


ALTER VIEW TILDA.JobView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.JobView as \n-- ''A view of the job data.''\nselect TILDA.Job.`refnum` as `jobRefnum` -- The primary key for this record\n     , TILDA.Job.`name` as `jobName` -- Name\n     , TILDA.Job.`type` as `jobType` -- Job type\n     , TILDA.Job.`userId` as `jobUserId` -- Job user Id\n     , TILDA.Job.`dataStartTZ` as `jobDataStartTZ` -- Generated helper column to hold the time zone ID for ''dataStart''.\n     , TILDA.Job.`dataStart` as `jobDataStart` -- StartTime\n     , TILDA.Job.`dataEndTZ` as `jobDataEndTZ` -- Generated helper column to hold the time zone ID for ''dataEnd''.\n     , TILDA.Job.`dataEnd` as `jobDataEnd` -- StartTime\n     , TILDA.Job.`startTZ` as `jobStartTZ` -- Generated helper column to hold the time zone ID for ''start''.\n     , TILDA.Job.`start` as `jobStart` -- StartTime\n     , TILDA.Job.`endTZ` as `jobEndTZ` -- Generated helper column to hold the time zone ID for ''end''.\n     , TILDA.Job.`end` as `jobEnd` -- EndTime\n     , TILDA.Job.`status` as `jobStatus` -- Status\n     , TILDA.Job.`msg` as `jobMsg` -- Message details\n     , TILDA.JobPart.`name` as `jobPartName` -- Job part name\n     , TILDA.JobPart.`type` as `jobPartType` -- Job part type\n     , TILDA.JobPart.`dataStartTZ` as `jobPartDataStartTZ` -- Generated helper column to hold the time zone ID for ''dataStart''.\n     , TILDA.JobPart.`dataStart` as `jobPartDataStart` -- Job part data start\n     , TILDA.JobPart.`dataEndTZ` as `jobPartDataEndTZ` -- Generated helper column to hold the time zone ID for ''dataEnd''.\n     , TILDA.JobPart.`dataEnd` as `jobPartDataEnd` -- Job part data end\n     , TILDA.JobPart.`startTZ` as `jobPartStartTZ` -- Generated helper column to hold the time zone ID for ''start''.\n     , TILDA.JobPart.`start` as `jobPartStart` -- Job part execution start\n     , TILDA.JobPart.`endTZ` as `jobPartEndTZ` -- Generated helper column to hold the time zone ID for ''end''.\n     , TILDA.JobPart.`end` as `jobPartEnd` -- Job part execution end\n     , TILDA.JobPart.`recordsCount` as `jobPartRecordsCount` -- count of database or file or ... records.\n     , TILDA.JobPart.`status` as `jobPartStatus` -- Status flag, i.e., success=true and failure-false\n     , TILDA.JobPartMessage.`notify` as `jobPartNotify` -- Notification flag\n     , TILDA.JobPartMessage.`msg` as `jobPartMessage` -- Message details\n  from TILDA.Job\n     left  join TILDA.JobPart on TILDA.JobPart.`jobRefnum` = TILDA.Job.`refnum`\n     left  join TILDA.JobPartMessage on TILDA.JobPartMessage.`jobPartRefnum` = TILDA.JobPart.`refnum`\n;\n\n');



