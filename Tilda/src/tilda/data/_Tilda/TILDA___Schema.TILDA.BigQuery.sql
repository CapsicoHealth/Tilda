
create schema if not exists TILDA;



create table if not exists TILDA.ZoneInfo -- blah blah
 (  `id`             STRING     not null  OPTIONS(description="The id for this enumeration.")
  , `value`          STRING     not null  OPTIONS(description="The value for this enumeration.")
  , `label`          STRING     not null  OPTIONS(description="The label for this enumeration.")
  , `deactivatedTZ`  STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'deactivated'.")
  , `deactivated`    TIMESTAMP            OPTIONS(description="The datetime when this enumeration was deactivated.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.ZoneInfo)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.ZoneInfo)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.ZoneInfo)")
  , PRIMARY KEY(`id`) NOT ENFORCED
  , FOREIGN KEY (`deactivatedTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
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
  , PRIMARY KEY(`refnum`) NOT ENFORCED
 )
OPTIONS (description="The table to keep track of unique keys across distributed objects/tables");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Key_Name ON TILDA.Key ("name");
--  CREATE INDEX IF NOT EXISTS Key_AllByName ON TILDA.Key ("name" ASC) where TILDA.Key."deleted" is null;



create table if not exists TILDA.Catalog -- Master catalog information
 (  `refnum`              INT64          not null  OPTIONS(description="The primary key for this record")
  , `schemaName`          STRING         not null  OPTIONS(description="The name of the schema this column is defined in.")
  , `tableViewName`       STRING         not null  OPTIONS(description="The name of the primary table/view this column is defined in.")
  , `columnName`          STRING         not null  OPTIONS(description="The name of the column.")
  , `type`                STRING         not null  OPTIONS(description="The type of the column.")
  , `nullable`            BOOLEAN                  OPTIONS(description="Whether the collumn is a nullable or not null.")
  , `collection`          BOOLEAN                  OPTIONS(description="Whether the collumn is a collection/array.")
  , `description`         STRING         not null  OPTIONS(description="The description of the column.")
  , `tableViewName2`      STRING                   OPTIONS(description="The name of the secondary table/view (a derived view, a realized table), if applicable.")
  , `aggregate`           STRING                   OPTIONS(description="The aggregate type of the column, if any.")
  , `title`               STRING                   OPTIONS(description="The title of the formula/expression that may be associated with this column.")
  , `formula`             STRING                   OPTIONS(description="The expression/formula that may be associated with this column.")
  , `measure`             BOOLEAN                  OPTIONS(description="Whether this column is a formula defined as a measure or not.")
  , `htmlDoc`             STRING                   OPTIONS(description="Pre-rendered html fragment with the full documentation for this formula.")
  , `referencedColumns`   ARRAY<STRING>            OPTIONS(description="The list of columns this formula depends on.")
  , `referencedFormulas`  ARRAY<STRING>            OPTIONS(description="The list of columns this formula depends on.")
  , `created`             TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.Catalog)")
  , `lastUpdated`         TIMESTAMP     DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.Catalog)")
  , `deleted`             TIMESTAMP                OPTIONS(description="The timestamp for when the record was deleted. (TILDA.Catalog)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Master catalog information");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Catalog_Column ON TILDA.Catalog ("schemaName", "tableViewName", "columnName");
--  CREATE INDEX IF NOT EXISTS Catalog_RefColumns ON TILDA.Catalog USING gin  ("referencedColumns" );
--  CREATE INDEX IF NOT EXISTS Catalog_RefFormulas ON TILDA.Catalog USING gin  ("referencedFormulas" );



create table if not exists TILDA.CatalogFormulaResult -- Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)
 (  `formulaRefnum`  INT64      not null  OPTIONS(description="The parent formula.")
  , `value`          STRING     not null  OPTIONS(description="The result value.")
  , `description`    STRING     not null  OPTIONS(description="The description of the result value.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.CatalogFormulaResult)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)")
  , PRIMARY KEY(`formulaRefnum`, `value`) NOT ENFORCED
  , FOREIGN KEY (`formulaRefnum`) REFERENCES TILDA.Catalog(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)");



create table if not exists TILDA.MaintenanceLog -- Maintenance information
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `type`         STRING     not null  OPTIONS(description="The type of maintenance, e.g., Migration, Reorg...")
  , `schemaName`   STRING     not null  OPTIONS(description="The name of the schema for the resource.")
  , `objectName`   STRING               OPTIONS(description="The name of the resource.")
  , `objectType`   STRING               OPTIONS(description="The type of the resource.")
  , `action`       STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `startTimeTZ`  STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startTime'.")
  , `startTime`    TIMESTAMP  not null  OPTIONS(description="The timestamp for when the refill started.")
  , `endTimeTZ`    STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'endTime'.")
  , `endTime`      TIMESTAMP            OPTIONS(description="The timestamp for when the refill ended.")
  , `statement`    STRING               OPTIONS(description="The value of the maintenance resource to track.")
  , `descr`        STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.MaintenanceLog)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.MaintenanceLog)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.MaintenanceLog)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`startTimeTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
  , FOREIGN KEY (`endTimeTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
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
  , PRIMARY KEY(`startPeriod`) NOT ENFORCED
  , FOREIGN KEY (`startPeriodTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
  , FOREIGN KEY (`endPeriodTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
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
  , PRIMARY KEY(`schemaName`, `objectName`, `startTime`) NOT ENFORCED
  , FOREIGN KEY (`startTimeTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
  , FOREIGN KEY (`endTimeTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
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
  , PRIMARY KEY(`id`) NOT ENFORCED
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
  , PRIMARY KEY(`refnum`) NOT ENFORCED
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
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`jobRefnum`) REFERENCES TILDA.Job(`refnum`) NOT ENFORCED
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
  , PRIMARY KEY(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`jobRefnum`) REFERENCES TILDA.Job(`refnum`) NOT ENFORCED
  , FOREIGN KEY (`jobPartRefnum`) REFERENCES TILDA.JobPart(`refnum`) NOT ENFORCED
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
  , PRIMARY KEY(`schemaName`, `objectName`, `startPeriod`) NOT ENFORCED
  , FOREIGN KEY (`startPeriodTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
  , FOREIGN KEY (`endPeriodTZ`) REFERENCES TILDA.ZoneInfo(`id`) NOT ENFORCED
 )
OPTIONS (description="Performance logs for the Tilda framework");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaByObjectStart ON TILDA.ObjectPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
--  CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaObjectByStart ON TILDA.ObjectPerf ("schemaName", "objectName", "startPeriod" DESC);



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
  , PRIMARY KEY(`dt`) NOT ENFORCED
 )
OPTIONS (description="The Date dimension, capturing pre-calculated metrics on dates");



create table if not exists TILDA.DateLimitDim -- A single row for min, max and invalid dates for the Date_Dim
 (  `invalidDate`  DATE  not null  OPTIONS(description="The invalid date, e.g., '1111-11-11'.")
  , `minDate`      DATE  not null  OPTIONS(description="The min date included in the DIM")
  , `maxDate`      DATE  not null  OPTIONS(description="The max date included in the DIM")
  , FOREIGN KEY (`invalidDate`) REFERENCES TILDA.DateDim(`dt`) NOT ENFORCED
  , FOREIGN KEY (`minDate`) REFERENCES TILDA.DateDim(`dt`) NOT ENFORCED
  , FOREIGN KEY (`maxDate`) REFERENCES TILDA.DateDim(`dt`) NOT ENFORCED
 )
OPTIONS (description="A single row for min, max and invalid dates for the Date_Dim");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS DateLimitDim_InvalidDate ON TILDA.DateLimitDim ("invalidDate");




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.FormulaResultView as 
-- 'A view of formulas and their values.'
select TILDA.CatalogFormulaResult.`formulaRefnum` as `formulaRefnum` -- The parent formula.
     , TILDA.CatalogFormulaResult.`value` as `value` -- The result value.
     , TILDA.CatalogFormulaResult.`description` as `description` -- The description of the result value.
     , TILDA.Catalog.`schemaName` as `schemaName` -- The name of the schema this column is defined in.
     , TILDA.Catalog.`tableViewName` as `tableViewName` -- The name of the primary table/view this column is defined in.
     , TILDA.Catalog.`columnName` as `columnName` -- The name of the column.
  from TILDA.CatalogFormulaResult
     inner join TILDA.Catalog on TILDA.CatalogFormulaResult.`formulaRefnum` = TILDA.Catalog.`refnum`
 where (TILDA.Catalog.`deleted`is null and TILDA.CatalogFormulaResult.`deleted`is null)
;


ALTER VIEW TILDA.FormulaResultView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.FormulaResultView as \n-- ''A view of formulas and their values.''\nselect TILDA.CatalogFormulaResult.`formulaRefnum` as `formulaRefnum` -- The parent formula.\n     , TILDA.CatalogFormulaResult.`value` as `value` -- The result value.\n     , TILDA.CatalogFormulaResult.`description` as `description` -- The description of the result value.\n     , TILDA.Catalog.`schemaName` as `schemaName` -- The name of the schema this column is defined in.\n     , TILDA.Catalog.`tableViewName` as `tableViewName` -- The name of the primary table/view this column is defined in.\n     , TILDA.Catalog.`columnName` as `columnName` -- The name of the column.\n  from TILDA.CatalogFormulaResult\n     inner join TILDA.Catalog on TILDA.CatalogFormulaResult.`formulaRefnum` = TILDA.Catalog.`refnum`\n where (TILDA.Catalog.`deleted`is null and TILDA.CatalogFormulaResult.`deleted`is null)\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDA.JobView as 
-- 'A view of the job data.'
select TILDA.Job.`refnum` as `jobRefnum` -- The primary key for this record
     , TILDA.Job.`name` as `jobName` -- Name
     , TILDA.Job.`type` as `jobType` -- Job type
     , TILDA.Job.`userId` as `jobUserId` -- Job user Id
     , TILDA.Job.`dataStartTZ` as `jobDataStartTZ` -- Generated helper column to hold the time zone ID for 'jobDataStart'.
     , TILDA.Job.`dataStart` as `jobDataStart` -- StartTime
     , TILDA.Job.`dataEndTZ` as `jobDataEndTZ` -- Generated helper column to hold the time zone ID for 'jobDataEnd'.
     , TILDA.Job.`dataEnd` as `jobDataEnd` -- StartTime
     , TILDA.Job.`startTZ` as `jobStartTZ` -- Generated helper column to hold the time zone ID for 'jobStart'.
     , TILDA.Job.`start` as `jobStart` -- StartTime
     , TILDA.Job.`endTZ` as `jobEndTZ` -- Generated helper column to hold the time zone ID for 'jobEnd'.
     , TILDA.Job.`end` as `jobEnd` -- EndTime
     , TILDA.Job.`status` as `jobStatus` -- Status
     , TILDA.Job.`msg` as `jobMsg` -- Message details
     , TILDA.JobPart.`name` as `jobPartName` -- Job part name
     , TILDA.JobPart.`type` as `jobPartType` -- Job part type
     , TILDA.JobPart.`dataStartTZ` as `jobPartDataStartTZ` -- Generated helper column to hold the time zone ID for 'jobPartDataStart'.
     , TILDA.JobPart.`dataStart` as `jobPartDataStart` -- Job part data start
     , TILDA.JobPart.`dataEndTZ` as `jobPartDataEndTZ` -- Generated helper column to hold the time zone ID for 'jobPartDataEnd'.
     , TILDA.JobPart.`dataEnd` as `jobPartDataEnd` -- Job part data end
     , TILDA.JobPart.`startTZ` as `jobPartStartTZ` -- Generated helper column to hold the time zone ID for 'jobPartStart'.
     , TILDA.JobPart.`start` as `jobPartStart` -- Job part execution start
     , TILDA.JobPart.`endTZ` as `jobPartEndTZ` -- Generated helper column to hold the time zone ID for 'jobPartEnd'.
     , TILDA.JobPart.`end` as `jobPartEnd` -- Job part execution end
     , TILDA.JobPart.`recordsCount` as `jobPartRecordsCount` -- count of database or file or ... records.
     , TILDA.JobPart.`status` as `jobPartStatus` -- Status flag, i.e., success=true and failure-false
     , TILDA.JobPartMessage.`notify` as `jobPartNotify` -- Notification flag
     , TILDA.JobPartMessage.`msg` as `jobPartMessage` -- Message details
  from TILDA.Job
     left  join TILDA.JobPart on TILDA.JobPart.`jobRefnum` = TILDA.Job.`refnum`
     left  join TILDA.JobPartMessage on TILDA.JobPartMessage.`jobPartRefnum` = TILDA.JobPart.`refnum`
;


ALTER VIEW TILDA.JobView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDA.JobView as \n-- ''A view of the job data.''\nselect TILDA.Job.`refnum` as `jobRefnum` -- The primary key for this record\n     , TILDA.Job.`name` as `jobName` -- Name\n     , TILDA.Job.`type` as `jobType` -- Job type\n     , TILDA.Job.`userId` as `jobUserId` -- Job user Id\n     , TILDA.Job.`dataStartTZ` as `jobDataStartTZ` -- Generated helper column to hold the time zone ID for ''jobDataStart''.\n     , TILDA.Job.`dataStart` as `jobDataStart` -- StartTime\n     , TILDA.Job.`dataEndTZ` as `jobDataEndTZ` -- Generated helper column to hold the time zone ID for ''jobDataEnd''.\n     , TILDA.Job.`dataEnd` as `jobDataEnd` -- StartTime\n     , TILDA.Job.`startTZ` as `jobStartTZ` -- Generated helper column to hold the time zone ID for ''jobStart''.\n     , TILDA.Job.`start` as `jobStart` -- StartTime\n     , TILDA.Job.`endTZ` as `jobEndTZ` -- Generated helper column to hold the time zone ID for ''jobEnd''.\n     , TILDA.Job.`end` as `jobEnd` -- EndTime\n     , TILDA.Job.`status` as `jobStatus` -- Status\n     , TILDA.Job.`msg` as `jobMsg` -- Message details\n     , TILDA.JobPart.`name` as `jobPartName` -- Job part name\n     , TILDA.JobPart.`type` as `jobPartType` -- Job part type\n     , TILDA.JobPart.`dataStartTZ` as `jobPartDataStartTZ` -- Generated helper column to hold the time zone ID for ''jobPartDataStart''.\n     , TILDA.JobPart.`dataStart` as `jobPartDataStart` -- Job part data start\n     , TILDA.JobPart.`dataEndTZ` as `jobPartDataEndTZ` -- Generated helper column to hold the time zone ID for ''jobPartDataEnd''.\n     , TILDA.JobPart.`dataEnd` as `jobPartDataEnd` -- Job part data end\n     , TILDA.JobPart.`startTZ` as `jobPartStartTZ` -- Generated helper column to hold the time zone ID for ''jobPartStart''.\n     , TILDA.JobPart.`start` as `jobPartStart` -- Job part execution start\n     , TILDA.JobPart.`endTZ` as `jobPartEndTZ` -- Generated helper column to hold the time zone ID for ''jobPartEnd''.\n     , TILDA.JobPart.`end` as `jobPartEnd` -- Job part execution end\n     , TILDA.JobPart.`recordsCount` as `jobPartRecordsCount` -- count of database or file or ... records.\n     , TILDA.JobPart.`status` as `jobPartStatus` -- Status flag, i.e., success=true and failure-false\n     , TILDA.JobPartMessage.`notify` as `jobPartNotify` -- Notification flag\n     , TILDA.JobPartMessage.`msg` as `jobPartMessage` -- Message details\n  from TILDA.Job\n     left  join TILDA.JobPart on TILDA.JobPart.`jobRefnum` = TILDA.Job.`refnum`\n     left  join TILDA.JobPartMessage on TILDA.JobPartMessage.`jobPartRefnum` = TILDA.JobPart.`refnum`\n;\n\n');



