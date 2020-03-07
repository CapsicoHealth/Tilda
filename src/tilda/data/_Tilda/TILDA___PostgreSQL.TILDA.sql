
create schema if not exists TILDA;



create table if not exists TILDA.ZoneInfo -- blah blah
 (  "id"             character(5)  not null   -- The id for this enumeration.
  , "value"          varchar(50)   not null   -- The value for this enumeration.
  , "label"          varchar(254)  not null   -- The label for this enumeration.
  , "deactivatedTZ"  character(5)             -- Generated helper column to hold the time zone ID for 'deactivated'.
  , "deactivated"    timestamptz              -- The label for this enumeration.
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.ZoneInfo)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.ZoneInfo)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.ZoneInfo)
  , PRIMARY KEY("id")
  , CONSTRAINT fk_ZoneInfo_deactivated FOREIGN KEY ("deactivatedTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.ZoneInfo IS E'blah blah';
COMMENT ON COLUMN TILDA.ZoneInfo."id" IS E'The id for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."value" IS E'The value for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."label" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."deactivatedTZ" IS E'Generated helper column to hold the time zone ID for ''deactivated''.';
COMMENT ON COLUMN TILDA.ZoneInfo."deactivated" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."created" IS E'The timestamp for when the record was created. (TILDA.ZoneInfo)';
COMMENT ON COLUMN TILDA.ZoneInfo."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.ZoneInfo)';
COMMENT ON COLUMN TILDA.ZoneInfo."deleted" IS E'The timestamp for when the record was deleted. (TILDA.ZoneInfo)';
CREATE UNIQUE INDEX IF NOT EXISTS ZoneInfo_Id ON TILDA.ZoneInfo ("id");
CREATE UNIQUE INDEX IF NOT EXISTS ZoneInfo_Value ON TILDA.ZoneInfo ("value");
-- app-level index only -- CREATE INDEX IF NOT EXISTS ZoneInfo_All ON TILDA.ZoneInfo ("id" ASC);



create table if not exists TILDA.Key -- The table to keep track of unique keys across distributed objects/tables
 (  "refnum"          bigint        not null   -- The primary key for this record
  , "name"            varchar(128)  not null   -- The name of the table/object tracked
  , "max"             bigint        not null   -- The pre-allocated max RefNum for this table/object.
  , "count"           integer       not null   -- The size of the pre-allocation required by this table/object.
  , "created"         timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created.
  , "lastUpdated"     timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated.
  , "deleted"         timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.Key IS E'The table to keep track of unique keys across distributed objects/tables';
COMMENT ON COLUMN TILDA.Key."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Key."name" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.Key."max" IS E'The pre-allocated max RefNum for this table/object.';
COMMENT ON COLUMN TILDA.Key."count" IS E'The size of the pre-allocation required by this table/object.';
COMMENT ON COLUMN TILDA.Key."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Key."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Key."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX IF NOT EXISTS Key_Name ON TILDA.Key ("name");
-- app-level index only -- CREATE INDEX IF NOT EXISTS Key_AllByName ON TILDA.Key ("name" ASC);



create table if not exists TILDA.Mapping -- Generalized Mapping table
 (  "type"         varchar(10)    not null   -- The type this mapping is for
  , "src"          varchar(1024)  not null   -- The source value for this mapping
  , "dst"          varchar(1024)  not null   -- The the destination (mapped) value for this mapping.
  , "created"      timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Mapping)
  , "lastUpdated"  timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Mapping)
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted. (TILDA.Mapping)
 );
COMMENT ON TABLE TILDA.Mapping IS E'Generalized Mapping table';
COMMENT ON COLUMN TILDA.Mapping."type" IS E'The type this mapping is for';
COMMENT ON COLUMN TILDA.Mapping."src" IS E'The source value for this mapping';
COMMENT ON COLUMN TILDA.Mapping."dst" IS E'The the destination (mapped) value for this mapping.';
COMMENT ON COLUMN TILDA.Mapping."created" IS E'The timestamp for when the record was created. (TILDA.Mapping)';
COMMENT ON COLUMN TILDA.Mapping."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Mapping)';
COMMENT ON COLUMN TILDA.Mapping."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Mapping)';
CREATE UNIQUE INDEX IF NOT EXISTS Mapping_TypeSrcDst ON TILDA.Mapping ("type", "src", "dst");



create table if not exists TILDA.ObjectPerf -- Performance logs for the Tilda framework
 (  "schemaName"     varchar(64)   not null   -- The name of the schema tracked
  , "objectName"     varchar(64)   not null   -- The name of the table/object tracked
  , "startPeriodTZ"  character(5)  not null   -- Generated helper column to hold the time zone ID for 'startPeriod'.
  , "startPeriod"    timestamptz   not null   -- The timestamp for when the record was created.
  , "endPeriodTZ"    character(5)  not null   -- Generated helper column to hold the time zone ID for 'endPeriod'.
  , "endPeriod"      timestamptz   not null   -- The timestamp for when the record was created.
  , "selectNano"     bigint        not null DEFAULT 0   -- Blah...
  , "selectCount"    integer       not null DEFAULT 0   -- Blah...
  , "selectRecords"  integer       not null DEFAULT 0   -- Blah...
  , "insertNano"     bigint        not null DEFAULT 0   -- Blah...
  , "insertCount"    integer       not null DEFAULT 0   -- Blah...
  , "insertRecords"  integer       not null DEFAULT 0   -- Blah...
  , "updateNano"     bigint        not null DEFAULT 0   -- Blah...
  , "updateCount"    integer       not null DEFAULT 0   -- Blah...
  , "updateRecords"  integer       not null DEFAULT 0   -- Blah...
  , "deleteNano"     bigint        not null DEFAULT 0   -- Blah...
  , "deleteCount"    integer       not null DEFAULT 0   -- Blah...
  , "deleteRecords"  integer       not null DEFAULT 0   -- Blah...
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.ObjectPerf)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.ObjectPerf)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.ObjectPerf)
  , PRIMARY KEY("schemaName", "objectName", "startPeriod")
  , CONSTRAINT fk_ObjectPerf_startPeriod FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_ObjectPerf_endPeriod FOREIGN KEY ("endPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.ObjectPerf IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.ObjectPerf."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.ObjectPerf."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.ObjectPerf."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.ObjectPerf."startPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.ObjectPerf."endPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''endPeriod''.';
COMMENT ON COLUMN TILDA.ObjectPerf."endPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.ObjectPerf."selectNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."selectCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."selectRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."insertNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."insertCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."insertRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."updateNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."updateCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."updateRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."deleteNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."deleteCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."deleteRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.ObjectPerf."created" IS E'The timestamp for when the record was created. (TILDA.ObjectPerf)';
COMMENT ON COLUMN TILDA.ObjectPerf."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.ObjectPerf)';
COMMENT ON COLUMN TILDA.ObjectPerf."deleted" IS E'The timestamp for when the record was deleted. (TILDA.ObjectPerf)';
CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaByObjectStart ON TILDA.ObjectPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX IF NOT EXISTS ObjectPerf_SchemaObjectByStart ON TILDA.ObjectPerf ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.TransPerf -- Performance logs for the Tilda framework
 (  "startPeriodTZ"           character(5)  not null   -- Generated helper column to hold the time zone ID for 'startPeriod'.
  , "startPeriod"             timestamptz   not null   -- The timestamp for when the record was created.
  , "endPeriodTZ"             character(5)  not null   -- Generated helper column to hold the time zone ID for 'endPeriod'.
  , "endPeriod"               timestamptz   not null   -- The timestamp for when the record was created.
  , "commitNano"              bigint        not null DEFAULT 0   -- Blah...
  , "commitCount"             integer       not null DEFAULT 0   -- Blah...
  , "rollbackNano"            bigint        not null DEFAULT 0   -- Blah...
  , "rollbackCount"           integer       not null DEFAULT 0   -- Blah...
  , "savepointSetNano"        bigint        not null DEFAULT 0   -- Blah...
  , "savepointSetCount"       integer       not null DEFAULT 0   -- Blah...
  , "savepointCommitNano"     bigint        not null DEFAULT 0   -- Blah...
  , "savepointCommitCount"    integer       not null DEFAULT 0   -- Blah...
  , "savepointRollbackNano"   bigint        not null DEFAULT 0   -- Blah...
  , "savepointRollbackCount"  integer       not null DEFAULT 0   -- Blah...
  , "statementCloseNano"      bigint        not null DEFAULT 0   -- Blah...
  , "statementCloseCount"     integer       not null DEFAULT 0   -- Blah...
  , "connectionCloseNano"     bigint        not null DEFAULT 0   -- Blah...
  , "connectionCloseCount"    integer       not null DEFAULT 0   -- Blah...
  , "connectionGetNano"       bigint        not null DEFAULT 0   -- Blah...
  , "connectionGetCount"      integer       not null DEFAULT 0   -- Blah...
  , "tildaSetterNano"         bigint        not null DEFAULT 0   -- Blah...
  , "tildaSetterCount"        integer       not null DEFAULT 0   -- Blah...
  , "tildaToStringNano"       bigint        not null DEFAULT 0   -- Blah...
  , "tildaToStringCount"      integer       not null DEFAULT 0   -- Blah...
  , "tildaToJsonNano"         bigint        not null DEFAULT 0   -- Blah...
  , "tildaToJsonCount"        integer       not null DEFAULT 0   -- Blah...
  , "tildaToCsvNano"          bigint        not null DEFAULT 0   -- Blah...
  , "tildaToCsvCount"         integer       not null DEFAULT 0   -- Blah...
  , "created"                 timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.TransPerf)
  , "lastUpdated"             timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.TransPerf)
  , "deleted"                 timestamptz              -- The timestamp for when the record was deleted. (TILDA.TransPerf)
  , PRIMARY KEY("startPeriod")
  , CONSTRAINT fk_TransPerf_startPeriod FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_TransPerf_endPeriod FOREIGN KEY ("endPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.TransPerf IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.TransPerf."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.TransPerf."startPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TransPerf."endPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''endPeriod''.';
COMMENT ON COLUMN TILDA.TransPerf."endPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TransPerf."commitNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."commitCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."rollbackNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."rollbackCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointSetNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointSetCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointCommitNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointCommitCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointRollbackNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."savepointRollbackCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."statementCloseNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."statementCloseCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."connectionCloseNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."connectionCloseCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."connectionGetNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."connectionGetCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaSetterNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaSetterCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToStringNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToStringCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToJsonNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToJsonCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToCsvNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."tildaToCsvCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."created" IS E'The timestamp for when the record was created. (TILDA.TransPerf)';
COMMENT ON COLUMN TILDA.TransPerf."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.TransPerf)';
COMMENT ON COLUMN TILDA.TransPerf."deleted" IS E'The timestamp for when the record was deleted. (TILDA.TransPerf)';



create table if not exists TILDA.Connection -- Tilda DB Connections Configurations
 (  "active"       boolean                  -- Status Flag
  , "id"           varchar(15)   not null   -- Connection ID
  , "driver"       varchar(100)  not null   -- DB Driver
  , "db"           varchar(200)  not null   -- DB Url
  , "user"         varchar(30)   not null   -- DB User
  , "pswd"         varchar(40)   not null   -- DB Password
  , "initial"      integer       not null   -- Minimum Connections
  , "max"          integer       not null   -- Maximum Connections
  , "schemas"      text[]        not null   -- Schemas
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Connection)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Connection)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDA.Connection)
  , PRIMARY KEY("id")
 );
COMMENT ON TABLE TILDA.Connection IS E'Tilda DB Connections Configurations';
COMMENT ON COLUMN TILDA.Connection."active" IS E'Status Flag';
COMMENT ON COLUMN TILDA.Connection."id" IS E'Connection ID';
COMMENT ON COLUMN TILDA.Connection."driver" IS E'DB Driver';
COMMENT ON COLUMN TILDA.Connection."db" IS E'DB Url';
COMMENT ON COLUMN TILDA.Connection."user" IS E'DB User';
COMMENT ON COLUMN TILDA.Connection."pswd" IS E'DB Password';
COMMENT ON COLUMN TILDA.Connection."initial" IS E'Minimum Connections';
COMMENT ON COLUMN TILDA.Connection."max" IS E'Maximum Connections';
COMMENT ON COLUMN TILDA.Connection."schemas" IS E'Schemas';
COMMENT ON COLUMN TILDA.Connection."created" IS E'The timestamp for when the record was created. (TILDA.Connection)';
COMMENT ON COLUMN TILDA.Connection."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Connection)';
COMMENT ON COLUMN TILDA.Connection."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Connection)';
CREATE INDEX IF NOT EXISTS Connection_AllById ON TILDA.Connection ("id" ASC);



create table if not exists TILDA.Job -- Jobs details
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "name"         varchar(250)  not null   -- Name
  , "type"         varchar(250)             -- Job type
  , "userId"       varchar(250)             -- Job user Id
  , "dataStartTZ"  character(5)             -- Generated helper column to hold the time zone ID for 'dataStart'.
  , "dataStart"    timestamptz              -- StartTime
  , "dataEndTZ"    character(5)             -- Generated helper column to hold the time zone ID for 'dataEnd'.
  , "dataEnd"      timestamptz              -- StartTime
  , "startTZ"      character(5)  not null   -- Generated helper column to hold the time zone ID for 'start'.
  , "start"        timestamptz   not null   -- StartTime
  , "endTZ"        character(5)             -- Generated helper column to hold the time zone ID for 'end'.
  , "end"          timestamptz              -- EndTime
  , "status"       boolean                  -- Status
  , "msg"          text                     -- Message details
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Job)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Job)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDA.Job)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.Job IS E'Jobs details';
COMMENT ON COLUMN TILDA.Job."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Job."name" IS E'Name';
COMMENT ON COLUMN TILDA.Job."type" IS E'Job type';
COMMENT ON COLUMN TILDA.Job."userId" IS E'Job user Id';
COMMENT ON COLUMN TILDA.Job."dataStartTZ" IS E'Generated helper column to hold the time zone ID for ''dataStart''.';
COMMENT ON COLUMN TILDA.Job."dataStart" IS E'StartTime';
COMMENT ON COLUMN TILDA.Job."dataEndTZ" IS E'Generated helper column to hold the time zone ID for ''dataEnd''.';
COMMENT ON COLUMN TILDA.Job."dataEnd" IS E'StartTime';
COMMENT ON COLUMN TILDA.Job."startTZ" IS E'Generated helper column to hold the time zone ID for ''start''.';
COMMENT ON COLUMN TILDA.Job."start" IS E'StartTime';
COMMENT ON COLUMN TILDA.Job."endTZ" IS E'Generated helper column to hold the time zone ID for ''end''.';
COMMENT ON COLUMN TILDA.Job."end" IS E'EndTime';
COMMENT ON COLUMN TILDA.Job."status" IS E'Status';
COMMENT ON COLUMN TILDA.Job."msg" IS E'Message details';
COMMENT ON COLUMN TILDA.Job."created" IS E'The timestamp for when the record was created. (TILDA.Job)';
COMMENT ON COLUMN TILDA.Job."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Job)';
COMMENT ON COLUMN TILDA.Job."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Job)';
CREATE INDEX IF NOT EXISTS Job_JobName ON TILDA.Job ("name", "start" DESC);
CREATE INDEX IF NOT EXISTS Job_JobType ON TILDA.Job ("type", "start" DESC);
delete from TILDA.Key where "name" = 'TILDA.JOB';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.JOB',(select COALESCE(max("refnum"),0)+1 from TILDA.Job), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.JobPart -- Job part details
 (  "refnum"        bigint        not null   -- The primary key for this record
  , "jobRefnum"     bigint        not null   -- Parent Job Refnum
  , "name"          varchar(250)  not null   -- Job part name
  , "type"          varchar(250)             -- Job part type
  , "dataStartTZ"   character(5)             -- Generated helper column to hold the time zone ID for 'dataStart'.
  , "dataStart"     timestamptz              -- Job part data start
  , "dataEndTZ"     character(5)             -- Generated helper column to hold the time zone ID for 'dataEnd'.
  , "dataEnd"       timestamptz              -- Job part data end
  , "startTZ"       character(5)  not null   -- Generated helper column to hold the time zone ID for 'start'.
  , "start"         timestamptz   not null   -- Job part execution start
  , "endTZ"         character(5)             -- Generated helper column to hold the time zone ID for 'end'.
  , "end"           timestamptz              -- Job part execution end
  , "recordsCount"  integer                  -- count of database or file or ... records.
  , "status"        boolean                  -- Status flag, i.e., success=true and failure-false
  , "created"       timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.JobPart)
  , "lastUpdated"   timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.JobPart)
  , "deleted"       timestamptz              -- The timestamp for when the record was deleted. (TILDA.JobPart)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_JobPart_Job FOREIGN KEY ("jobRefnum") REFERENCES TILDA.Job ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.JobPart IS E'Job part details';
COMMENT ON COLUMN TILDA.JobPart."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JobPart."jobRefnum" IS E'Parent Job Refnum';
COMMENT ON COLUMN TILDA.JobPart."name" IS E'Job part name';
COMMENT ON COLUMN TILDA.JobPart."type" IS E'Job part type';
COMMENT ON COLUMN TILDA.JobPart."dataStartTZ" IS E'Generated helper column to hold the time zone ID for ''dataStart''.';
COMMENT ON COLUMN TILDA.JobPart."dataStart" IS E'Job part data start';
COMMENT ON COLUMN TILDA.JobPart."dataEndTZ" IS E'Generated helper column to hold the time zone ID for ''dataEnd''.';
COMMENT ON COLUMN TILDA.JobPart."dataEnd" IS E'Job part data end';
COMMENT ON COLUMN TILDA.JobPart."startTZ" IS E'Generated helper column to hold the time zone ID for ''start''.';
COMMENT ON COLUMN TILDA.JobPart."start" IS E'Job part execution start';
COMMENT ON COLUMN TILDA.JobPart."endTZ" IS E'Generated helper column to hold the time zone ID for ''end''.';
COMMENT ON COLUMN TILDA.JobPart."end" IS E'Job part execution end';
COMMENT ON COLUMN TILDA.JobPart."recordsCount" IS E'count of database or file or ... records.';
COMMENT ON COLUMN TILDA.JobPart."status" IS E'Status flag, i.e., success=true and failure-false';
COMMENT ON COLUMN TILDA.JobPart."created" IS E'The timestamp for when the record was created. (TILDA.JobPart)';
COMMENT ON COLUMN TILDA.JobPart."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.JobPart)';
COMMENT ON COLUMN TILDA.JobPart."deleted" IS E'The timestamp for when the record was deleted. (TILDA.JobPart)';
CREATE INDEX IF NOT EXISTS JobPart_Job ON TILDA.JobPart ("jobRefnum", "start" DESC);
CREATE INDEX IF NOT EXISTS JobPart_JobPartName ON TILDA.JobPart ("name", "start" DESC);
CREATE INDEX IF NOT EXISTS JobPart_JobPartType ON TILDA.JobPart ("type", "start" DESC);
delete from TILDA.Key where "name" = 'TILDA.JOBPART';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.JOBPART',(select COALESCE(max("refnum"),0)+1 from TILDA.JobPart), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.JobPartMessage -- Job part message details
 (  "refnum"         bigint       not null   -- The primary key for this record
  , "jobRefnum"      bigint       not null   -- Parent Job Refnum
  , "jobPartRefnum"  bigint                  -- Parent Job Part Refnum
  , "notify"         boolean      not null   -- Notification flag
  , "msg"            text         not null   -- Message details
  , "created"        timestamptz  not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.JobPartMessage)
  , "lastUpdated"    timestamptz  not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.JobPartMessage)
  , "deleted"        timestamptz             -- The timestamp for when the record was deleted. (TILDA.JobPartMessage)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_JobPartMessage_Job FOREIGN KEY ("jobRefnum") REFERENCES TILDA.Job ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_JobPartMessage_JobPart FOREIGN KEY ("jobPartRefnum") REFERENCES TILDA.JobPart ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.JobPartMessage IS E'Job part message details';
COMMENT ON COLUMN TILDA.JobPartMessage."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JobPartMessage."jobRefnum" IS E'Parent Job Refnum';
COMMENT ON COLUMN TILDA.JobPartMessage."jobPartRefnum" IS E'Parent Job Part Refnum';
COMMENT ON COLUMN TILDA.JobPartMessage."notify" IS E'Notification flag';
COMMENT ON COLUMN TILDA.JobPartMessage."msg" IS E'Message details';
COMMENT ON COLUMN TILDA.JobPartMessage."created" IS E'The timestamp for when the record was created. (TILDA.JobPartMessage)';
COMMENT ON COLUMN TILDA.JobPartMessage."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.JobPartMessage)';
COMMENT ON COLUMN TILDA.JobPartMessage."deleted" IS E'The timestamp for when the record was deleted. (TILDA.JobPartMessage)';
CREATE INDEX IF NOT EXISTS JobPartMessage_Job ON TILDA.JobPartMessage ("jobRefnum", "created" DESC);
CREATE INDEX IF NOT EXISTS JobPartMessage_JobPart ON TILDA.JobPartMessage ("jobPartRefnum", "created" DESC);
delete from TILDA.Key where "name" = 'TILDA.JOBPARTMESSAGE';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.JOBPARTMESSAGE',(select COALESCE(max("refnum"),0)+1 from TILDA.JobPartMessage), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.RefillPerf -- Performance logs for the Tilda Refills
 (  "schemaName"     varchar(64)   not null   -- The name of the schema tracked
  , "objectName"     varchar(64)   not null   -- The name of the table/object tracked
  , "startPeriodTZ"  character(5)  not null   -- Generated helper column to hold the time zone ID for 'startPeriod'.
  , "startPeriod"    timestamptz   not null   -- The timestamp for when the refill started.
  , "timeCreateMs"   bigint        not null   -- The time, in milliseconds, the create took.
  , "timeIndexMs"    bigint        not null   -- The time, in milliseconds, the indexing took.
  , "timeAnalyzeMs"  bigint        not null   -- The time, in milliseconds, the analyze took.
  , "timeTotalMs"    bigint        not null   -- The time, in milliseconds, the whole refill took.
  , "columnsMs"      bigint        not null   -- The list of columns that were refilled.
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.RefillPerf)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.RefillPerf)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.RefillPerf)
  , PRIMARY KEY("schemaName", "objectName", "startPeriod")
  , CONSTRAINT fk_RefillPerf_startPeriod FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.RefillPerf IS E'Performance logs for the Tilda Refills';
COMMENT ON COLUMN TILDA.RefillPerf."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.RefillPerf."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.RefillPerf."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.RefillPerf."startPeriod" IS E'The timestamp for when the refill started.';
COMMENT ON COLUMN TILDA.RefillPerf."timeCreateMs" IS E'The time, in milliseconds, the create took.';
COMMENT ON COLUMN TILDA.RefillPerf."timeIndexMs" IS E'The time, in milliseconds, the indexing took.';
COMMENT ON COLUMN TILDA.RefillPerf."timeAnalyzeMs" IS E'The time, in milliseconds, the analyze took.';
COMMENT ON COLUMN TILDA.RefillPerf."timeTotalMs" IS E'The time, in milliseconds, the whole refill took.';
COMMENT ON COLUMN TILDA.RefillPerf."columnsMs" IS E'The list of columns that were refilled.';
COMMENT ON COLUMN TILDA.RefillPerf."created" IS E'The timestamp for when the record was created. (TILDA.RefillPerf)';
COMMENT ON COLUMN TILDA.RefillPerf."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.RefillPerf)';
COMMENT ON COLUMN TILDA.RefillPerf."deleted" IS E'The timestamp for when the record was deleted. (TILDA.RefillPerf)';
CREATE INDEX IF NOT EXISTS RefillPerf_SchemaByObjectStart ON TILDA.RefillPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX IF NOT EXISTS RefillPerf_SchemaObjectByStart ON TILDA.RefillPerf ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.Maintenance -- Maintenance information
 (  "type"         varchar(64)   not null   -- The type of maintenance resource to track
  , "name"         varchar(512)  not null   -- The name of the maintenance resource to track.
  , "value"        text                     -- The value of the maintenance resource to track.
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Maintenance)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Maintenance)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDA.Maintenance)
  , PRIMARY KEY("type", "name")
 );
COMMENT ON TABLE TILDA.Maintenance IS E'Maintenance information';
COMMENT ON COLUMN TILDA.Maintenance."type" IS E'The type of maintenance resource to track';
COMMENT ON COLUMN TILDA.Maintenance."name" IS E'The name of the maintenance resource to track.';
COMMENT ON COLUMN TILDA.Maintenance."value" IS E'The value of the maintenance resource to track.';
COMMENT ON COLUMN TILDA.Maintenance."created" IS E'The timestamp for when the record was created. (TILDA.Maintenance)';
COMMENT ON COLUMN TILDA.Maintenance."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Maintenance)';
COMMENT ON COLUMN TILDA.Maintenance."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Maintenance)';



create table if not exists TILDA.Formula -- Master formula information
 (  "refnum"             bigint        not null   -- The primary key for this record
  , "location"           varchar(64)   not null   -- The name of the primary table/view this formula is defined in.
  , "location2"          varchar(64)   not null   -- The name of the secondary table/view (a derived view, a realized table), if appropriate.
  , "name"               varchar(64)   not null   -- The name of the formula/column.
  , "type"               character(3)  not null   -- The type of the formula/column value/outcome.
  , "title"              varchar(128)  not null   -- The title of the formula/column.
  , "description"        text          not null   -- The description of the formula/column.
  , "formula"            text                     -- The formula.
  , "htmlDoc"            text                     -- Pre-rendered html fragment with the full documentation for this formula.
  , "referencedColumns"  text[]                   -- The list of columns this formula depends on.
  , "created"            timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Formula)
  , "lastUpdated"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Formula)
  , "deleted"            timestamptz              -- The timestamp for when the record was deleted. (TILDA.Formula)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.Formula IS E'Master formula information';
COMMENT ON COLUMN TILDA.Formula."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Formula."location" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.Formula."location2" IS E'The name of the secondary table/view (a derived view, a realized table), if appropriate.';
COMMENT ON COLUMN TILDA.Formula."name" IS E'The name of the formula/column.';
COMMENT ON COLUMN TILDA.Formula."type" IS E'The type of the formula/column value/outcome.';
COMMENT ON COLUMN TILDA.Formula."title" IS E'The title of the formula/column.';
COMMENT ON COLUMN TILDA.Formula."description" IS E'The description of the formula/column.';
COMMENT ON COLUMN TILDA.Formula."formula" IS E'The formula.';
COMMENT ON COLUMN TILDA.Formula."htmlDoc" IS E'Pre-rendered html fragment with the full documentation for this formula.';
COMMENT ON COLUMN TILDA.Formula."referencedColumns" IS E'The list of columns this formula depends on.';
COMMENT ON COLUMN TILDA.Formula."created" IS E'The timestamp for when the record was created. (TILDA.Formula)';
COMMENT ON COLUMN TILDA.Formula."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Formula)';
COMMENT ON COLUMN TILDA.Formula."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Formula)';
CREATE UNIQUE INDEX IF NOT EXISTS Formula_Formula ON TILDA.Formula ("location", "name");
CREATE INDEX IF NOT EXISTS Formula_RefCols ON TILDA.Formula USING gin  ("referencedColumns" );
delete from TILDA.Key where "name" = 'TILDA.FORMULA';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.FORMULA',(select COALESCE(max("refnum"),0)+1 from TILDA.Formula), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.Measure -- Master Measure information
 (  "refnum"       bigint       not null   -- The primary key for this record
  , "schema"       varchar(64)  not null   -- The Schema wher ethe measure is defined.
  , "name"         varchar(64)  not null   -- The name of the measure.
  , "created"      timestamptz  not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Measure)
  , "lastUpdated"  timestamptz  not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Measure)
  , "deleted"      timestamptz             -- The timestamp for when the record was deleted. (TILDA.Measure)
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.Measure IS E'Master Measure information';
COMMENT ON COLUMN TILDA.Measure."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Measure."schema" IS E'The Schema wher ethe measure is defined.';
COMMENT ON COLUMN TILDA.Measure."name" IS E'The name of the measure.';
COMMENT ON COLUMN TILDA.Measure."created" IS E'The timestamp for when the record was created. (TILDA.Measure)';
COMMENT ON COLUMN TILDA.Measure."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Measure)';
COMMENT ON COLUMN TILDA.Measure."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Measure)';
CREATE UNIQUE INDEX IF NOT EXISTS Measure_Measure ON TILDA.Measure ("schema", "name");
delete from TILDA.Key where "name" = 'TILDA.MEASURE';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.MEASURE',(select COALESCE(max("refnum"),0)+1 from TILDA.Measure), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.MeasureFormula -- Master Measure information
 (  "measureRefnum"  bigint       not null   -- The measure.
  , "formulaRefnum"  bigint       not null   -- The parent formula.
  , "created"        timestamptz  not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.MeasureFormula)
  , "lastUpdated"    timestamptz  not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.MeasureFormula)
  , "deleted"        timestamptz             -- The timestamp for when the record was deleted. (TILDA.MeasureFormula)
  , PRIMARY KEY("measureRefnum", "formulaRefnum")
  , CONSTRAINT fk_MeasureFormula_Measure FOREIGN KEY ("measureRefnum") REFERENCES TILDA.Measure ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_MeasureFormula_Formula FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.MeasureFormula IS E'Master Measure information';
COMMENT ON COLUMN TILDA.MeasureFormula."measureRefnum" IS E'The measure.';
COMMENT ON COLUMN TILDA.MeasureFormula."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.MeasureFormula."created" IS E'The timestamp for when the record was created. (TILDA.MeasureFormula)';
COMMENT ON COLUMN TILDA.MeasureFormula."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.MeasureFormula)';
COMMENT ON COLUMN TILDA.MeasureFormula."deleted" IS E'The timestamp for when the record was deleted. (TILDA.MeasureFormula)';



create table if not exists TILDA.FormulaDependency -- Master formula dependency information
 (  "formulaRefnum"     bigint       not null   -- The parent formula.
  , "dependencyRefnum"  bigint       not null   -- The dependent formula.
  , "created"           timestamptz  not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.FormulaDependency)
  , "lastUpdated"       timestamptz  not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.FormulaDependency)
  , "deleted"           timestamptz             -- The timestamp for when the record was deleted. (TILDA.FormulaDependency)
  , PRIMARY KEY("formulaRefnum", "dependencyRefnum")
  , CONSTRAINT fk_FormulaDependency_Formula1 FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_FormulaDependency_Formula2 FOREIGN KEY ("dependencyRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.FormulaDependency IS E'Master formula dependency information';
COMMENT ON COLUMN TILDA.FormulaDependency."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaDependency."dependencyRefnum" IS E'The dependent formula.';
COMMENT ON COLUMN TILDA.FormulaDependency."created" IS E'The timestamp for when the record was created. (TILDA.FormulaDependency)';
COMMENT ON COLUMN TILDA.FormulaDependency."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.FormulaDependency)';
COMMENT ON COLUMN TILDA.FormulaDependency."deleted" IS E'The timestamp for when the record was deleted. (TILDA.FormulaDependency)';



create table if not exists TILDA.FormulaResult -- Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)
 (  "formulaRefnum"  bigint        not null   -- The parent formula.
  , "value"          varchar(100)  not null   -- The result value.
  , "description"    text          not null   -- The description of the result value.
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.FormulaResult)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.FormulaResult)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.FormulaResult)
  , PRIMARY KEY("formulaRefnum", "value")
  , CONSTRAINT fk_FormulaResult_Formula FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.FormulaResult IS E'Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)';
COMMENT ON COLUMN TILDA.FormulaResult."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaResult."value" IS E'The result value.';
COMMENT ON COLUMN TILDA.FormulaResult."description" IS E'The description of the result value.';
COMMENT ON COLUMN TILDA.FormulaResult."created" IS E'The timestamp for when the record was created. (TILDA.FormulaResult)';
COMMENT ON COLUMN TILDA.FormulaResult."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.FormulaResult)';
COMMENT ON COLUMN TILDA.FormulaResult."deleted" IS E'The timestamp for when the record was deleted. (TILDA.FormulaResult)';



create table if not exists TILDA.FailedDependencyDDLScripts -- A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.
 (  "srcSchemaName"  varchar(100)  not null   -- The result value.
  , "srcTVName"      varchar(100)  not null   -- The result value.
  , "seq"            integer       not null   -- The blah
  , "depSchemaName"  varchar(100)  not null   -- The result value.
  , "depViewName"    varchar(100)  not null   -- The result value.
  , "restoreScript"  text          not null   -- The result value.
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.FailedDependencyDDLScripts)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.FailedDependencyDDLScripts)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.FailedDependencyDDLScripts)
 );
COMMENT ON TABLE TILDA.FailedDependencyDDLScripts IS E'A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."srcSchemaName" IS E'The result value.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."srcTVName" IS E'The result value.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."seq" IS E'The blah';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."depSchemaName" IS E'The result value.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."depViewName" IS E'The result value.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."restoreScript" IS E'The result value.';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."created" IS E'The timestamp for when the record was created. (TILDA.FailedDependencyDDLScripts)';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.FailedDependencyDDLScripts)';
COMMENT ON COLUMN TILDA.FailedDependencyDDLScripts."deleted" IS E'The timestamp for when the record was deleted. (TILDA.FailedDependencyDDLScripts)';
CREATE UNIQUE INDEX IF NOT EXISTS FailedDependencyDDLScripts_DepedencySequence ON TILDA.FailedDependencyDDLScripts ("srcSchemaName", "srcTVName", "created", "seq");



create table if not exists TILDA.DateDim -- The Date dimension, capturing pre-calculated metrics on dates
 (  "dt"              date          not null   -- The Date date
  , "epoch"           bigint        not null   -- The epoch date
  , "dayName"         varchar(255)             -- Day name (i.e., Monday, Tuesday...) of the date
  , "dayOfWeek"       integer                  -- ISO 8601 day of the week (Monday=1 to Sunday=7) of the date
  , "dayOfMonth"      integer                  -- ISO 8601 day of the month (starting with 1) of the date
  , "dayOfQuarter"    integer                  -- ISO 8601 day of the quarter (starting with 1) of the date
  , "dayOfYear"       integer                  -- ISO 8601 day of the year (starting with 1) of the date
  , "weekOfMonth"     integer                  -- ISO 8601 week of the month (starting with 1) of the date
  , "weekOfYear"      integer                  -- ISO 8601 week of the year (starting with 1) of the date
  , "monthOfYear"     integer                  -- ISO 8601 month of the year (starting with 1) of the date
  , "monthName"       varchar(255)             -- Month name (i.e., January, February...) of the date.
  , "monthNameShort"  varchar(255)             -- Monday short name (i.e., Jan, Feb...) of the date.
  , "quarterOfYear"   integer                  -- ISO 8601 quarter of the year (starting with 1) of the date.
  , "quarterName"     varchar(255)             -- Quarter name (i.e., Q1, Q2...) of the date.
  , "year"            integer                  -- ISO 8601 year (1.e., 2018) of the date.
  , "mmyyyy"          character(6)             -- The mmyyyy printable version of a date.
  , "mmddyyyy"        character(8)             -- The mmddyyyy printable version of a date.
  , "yyyymmdd"        character(8)             -- The yyyymmdd sortable printable version of a date.
  , "isWeekend"       integer                  -- 1 if this is a weekend day, 0 otherwise.
  , "isBusinessDay"   integer                  -- 1 if this is a business day, 0 otherwise.
  , "isHoliday"       integer                  -- 1 if this is a holiday, 0 otherwise.
  , "holidayName"     varchar(255)             -- The name of the holiday if applicable.
  , "created"         timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.DateDim)
  , "lastUpdated"     timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.DateDim)
  , "deleted"         timestamptz              -- The timestamp for when the record was deleted. (TILDA.DateDim)
  , PRIMARY KEY("dt")
 );
COMMENT ON TABLE TILDA.DateDim IS E'The Date dimension, capturing pre-calculated metrics on dates';
COMMENT ON COLUMN TILDA.DateDim."dt" IS E'The Date date';
COMMENT ON COLUMN TILDA.DateDim."epoch" IS E'The epoch date';
COMMENT ON COLUMN TILDA.DateDim."dayName" IS E'Day name (i.e., Monday, Tuesday...) of the date';
COMMENT ON COLUMN TILDA.DateDim."dayOfWeek" IS E'ISO 8601 day of the week (Monday=1 to Sunday=7) of the date';
COMMENT ON COLUMN TILDA.DateDim."dayOfMonth" IS E'ISO 8601 day of the month (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."dayOfQuarter" IS E'ISO 8601 day of the quarter (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."dayOfYear" IS E'ISO 8601 day of the year (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."weekOfMonth" IS E'ISO 8601 week of the month (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."weekOfYear" IS E'ISO 8601 week of the year (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."monthOfYear" IS E'ISO 8601 month of the year (starting with 1) of the date';
COMMENT ON COLUMN TILDA.DateDim."monthName" IS E'Month name (i.e., January, February...) of the date.';
COMMENT ON COLUMN TILDA.DateDim."monthNameShort" IS E'Monday short name (i.e., Jan, Feb...) of the date.';
COMMENT ON COLUMN TILDA.DateDim."quarterOfYear" IS E'ISO 8601 quarter of the year (starting with 1) of the date.';
COMMENT ON COLUMN TILDA.DateDim."quarterName" IS E'Quarter name (i.e., Q1, Q2...) of the date.';
COMMENT ON COLUMN TILDA.DateDim."year" IS E'ISO 8601 year (1.e., 2018) of the date.';
COMMENT ON COLUMN TILDA.DateDim."mmyyyy" IS E'The mmyyyy printable version of a date.';
COMMENT ON COLUMN TILDA.DateDim."mmddyyyy" IS E'The mmddyyyy printable version of a date.';
COMMENT ON COLUMN TILDA.DateDim."yyyymmdd" IS E'The yyyymmdd sortable printable version of a date.';
COMMENT ON COLUMN TILDA.DateDim."isWeekend" IS E'1 if this is a weekend day, 0 otherwise.';
COMMENT ON COLUMN TILDA.DateDim."isBusinessDay" IS E'1 if this is a business day, 0 otherwise.';
COMMENT ON COLUMN TILDA.DateDim."isHoliday" IS E'1 if this is a holiday, 0 otherwise.';
COMMENT ON COLUMN TILDA.DateDim."holidayName" IS E'The name of the holiday if applicable.';
COMMENT ON COLUMN TILDA.DateDim."created" IS E'The timestamp for when the record was created. (TILDA.DateDim)';
COMMENT ON COLUMN TILDA.DateDim."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.DateDim)';
COMMENT ON COLUMN TILDA.DateDim."deleted" IS E'The timestamp for when the record was deleted. (TILDA.DateDim)';



create table if not exists TILDA.DateLimitDim -- A single row for min, max and invalid dates for the Date_Dim
 (  "invalidDate"  date  not null   -- The invalid date
  , "minDate"      date  not null   -- The min date
  , "maxDate"      date  not null   -- The max date
  , CONSTRAINT fk_DateLimitDim_InvalidDt FOREIGN KEY ("invalidDate") REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_DateLimitDim_MinDt FOREIGN KEY ("minDate") REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_DateLimitDim_MaxDt FOREIGN KEY ("maxDate") REFERENCES TILDA.DateDim ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.DateLimitDim IS E'A single row for min, max and invalid dates for the Date_Dim';
COMMENT ON COLUMN TILDA.DateLimitDim."invalidDate" IS E'The invalid date';
COMMENT ON COLUMN TILDA.DateLimitDim."minDate" IS E'The min date';
COMMENT ON COLUMN TILDA.DateLimitDim."maxDate" IS E'The max date';
CREATE UNIQUE INDEX IF NOT EXISTS DateLimitDim_InvalidDate ON TILDA.DateLimitDim ("invalidDate");




-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.FormulaResultView as 
-- 'A view of formulas and their values.'
select TILDA.FormulaResult."formulaRefnum" as "formulaRefnum" -- The parent formula.
     , TILDA.FormulaResult."value" as "value" -- The result value.
     , TILDA.FormulaResult."description" as "description" -- The description of the result value.
     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula."name" as "name" -- The name of the formula/column.
  from TILDA.FormulaResult
     inner join TILDA.Formula on TILDA.FormulaResult."formulaRefnum" = TILDA.Formula."refnum"
 where (TILDA.Formula."deleted" is null and TILDA.FormulaResult."deleted" is null)
;


COMMENT ON VIEW TILDA.FormulaResultView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.FormulaResultView as \n-- ''A view of formulas and their values.''\nselect TILDA.FormulaResult."formulaRefnum" as "formulaRefnum" -- The parent formula.\n     , TILDA.FormulaResult."value" as "value" -- The result value.\n     , TILDA.FormulaResult."description" as "description" -- The description of the result value.\n     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."name" as "name" -- The name of the formula/column.\n  from TILDA.FormulaResult\n     inner join TILDA.Formula on TILDA.FormulaResult."formulaRefnum" = TILDA.Formula."refnum"\n where (TILDA.Formula."deleted" is null and TILDA.FormulaResult."deleted" is null)\n;\n\n';

COMMENT ON COLUMN TILDA.FormulaResultView."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaResultView."value" IS E'The result value.';
COMMENT ON COLUMN TILDA.FormulaResultView."description" IS E'The description of the result value.';
COMMENT ON COLUMN TILDA.FormulaResultView."location" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.FormulaResultView."name" IS E'The name of the formula/column.';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.FormulaResultView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.FormulaDependencyView as 
-- 'A view of formulas and their direct dependencies.'
select TILDA.FormulaDependency."formulaRefnum" as "formulaRefnum" -- The parent formula.
     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula."name" as "name" -- The name of the formula/column.
     , TILDA.Formula."referencedColumns" as "referencedColumns" -- The list of columns this formula depends on.
     , TILDA.FormulaDependency."dependencyRefnum" as "dependencyRefnum" -- The dependent formula.
     , TILDA_Formula_2."name" as "dependentFormulaName" -- The name of the formula/column.
     , TILDA_Formula_2."location" as "dependentFormulaLocation" -- The name of the primary table/view this formula is defined in.
     , TILDA_Formula_2."referencedColumns" as "dependentReferencedColumns" -- The list of columns this formula depends on.
  from TILDA.FormulaDependency
     inner join TILDA.Formula on TILDA.FormulaDependency."formulaRefnum" = TILDA.Formula."refnum"
     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency."dependencyRefnum" = TILDA_Formula_2."refnum"
 where (TILDA.Formula."deleted" is null)
;


COMMENT ON VIEW TILDA.FormulaDependencyView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.FormulaDependencyView as \n-- ''A view of formulas and their direct dependencies.''\nselect TILDA.FormulaDependency."formulaRefnum" as "formulaRefnum" -- The parent formula.\n     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."name" as "name" -- The name of the formula/column.\n     , TILDA.Formula."referencedColumns" as "referencedColumns" -- The list of columns this formula depends on.\n     , TILDA.FormulaDependency."dependencyRefnum" as "dependencyRefnum" -- The dependent formula.\n     , TILDA_Formula_2."name" as "dependentFormulaName" -- The name of the formula/column.\n     , TILDA_Formula_2."location" as "dependentFormulaLocation" -- The name of the primary table/view this formula is defined in.\n     , TILDA_Formula_2."referencedColumns" as "dependentReferencedColumns" -- The list of columns this formula depends on.\n  from TILDA.FormulaDependency\n     inner join TILDA.Formula on TILDA.FormulaDependency."formulaRefnum" = TILDA.Formula."refnum"\n     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency."dependencyRefnum" = TILDA_Formula_2."refnum"\n where (TILDA.Formula."deleted" is null)\n;\n\n';

COMMENT ON COLUMN TILDA.FormulaDependencyView."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."location" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."name" IS E'The name of the formula/column.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."referencedColumns" IS E'The list of columns this formula depends on.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependencyRefnum" IS E'The dependent formula.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependentFormulaName" IS E'The name of the formula/column.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependentFormulaLocation" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependentReferencedColumns" IS E'The list of columns this formula depends on.';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.FormulaDependencyView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.MeasureFormulaView as 
-- 'A view of formulas and their dependencies.'
select TILDA.MeasureFormula."measureRefnum" as "measureRefnum" -- The measure.
     , TILDA.Measure."schema" as "measureSchema" -- The Schema wher ethe measure is defined.
     , TILDA.Measure."name" as "measureName" -- The name of the measure.
     , TILDA.Formula."refnum" as "formulaRefnum" -- The primary key for this record
     , TILDA.Formula."location" as "formulaLocation" -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula."location2" as "formulaLocation2" -- The name of the secondary table/view (a derived view, a realized table), if appropriate.
     , TILDA.Formula."name" as "formulaName" -- The name of the formula/column.
     , TILDA.Formula."title" as "title" -- The title of the formula/column.
     , TILDA.Formula."description" as "description" -- The description of the formula/column.
     , trim(TILDA.Formula."type") as "type" -- The type of the formula/column value/outcome.
     , TILDA.Formula."formula" as "formula" -- The formula.
  from TILDA.MeasureFormula
     inner join TILDA.Measure on TILDA.MeasureFormula."measureRefnum" = TILDA.Measure."refnum"
     inner join TILDA.Formula on TILDA.MeasureFormula."formulaRefnum" = TILDA.Formula."refnum"
 where (TILDA.Formula."deleted" is null and TILDA.Measure."deleted" is null)
;


COMMENT ON VIEW TILDA.MeasureFormulaView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.MeasureFormulaView as \n-- ''A view of formulas and their dependencies.''\nselect TILDA.MeasureFormula."measureRefnum" as "measureRefnum" -- The measure.\n     , TILDA.Measure."schema" as "measureSchema" -- The Schema wher ethe measure is defined.\n     , TILDA.Measure."name" as "measureName" -- The name of the measure.\n     , TILDA.Formula."refnum" as "formulaRefnum" -- The primary key for this record\n     , TILDA.Formula."location" as "formulaLocation" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."location2" as "formulaLocation2" -- The name of the secondary table/view (a derived view, a realized table), if appropriate.\n     , TILDA.Formula."name" as "formulaName" -- The name of the formula/column.\n     , TILDA.Formula."title" as "title" -- The title of the formula/column.\n     , TILDA.Formula."description" as "description" -- The description of the formula/column.\n     , trim(TILDA.Formula."type") as "type" -- The type of the formula/column value/outcome.\n     , TILDA.Formula."formula" as "formula" -- The formula.\n  from TILDA.MeasureFormula\n     inner join TILDA.Measure on TILDA.MeasureFormula."measureRefnum" = TILDA.Measure."refnum"\n     inner join TILDA.Formula on TILDA.MeasureFormula."formulaRefnum" = TILDA.Formula."refnum"\n where (TILDA.Formula."deleted" is null and TILDA.Measure."deleted" is null)\n;\n\n';

COMMENT ON COLUMN TILDA.MeasureFormulaView."measureRefnum" IS E'The measure.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."measureSchema" IS E'The Schema wher ethe measure is defined.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."measureName" IS E'The name of the measure.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."formulaRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.MeasureFormulaView."formulaLocation" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."formulaLocation2" IS E'The name of the secondary table/view (a derived view, a realized table), if appropriate.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."formulaName" IS E'The name of the formula/column.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."title" IS E'The title of the formula/column.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."description" IS E'The description of the formula/column.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."type" IS E'The type of the formula/column value/outcome.';
COMMENT ON COLUMN TILDA.MeasureFormulaView."formula" IS E'The formula.';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.MeasureFormulaView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.JobView as 
-- 'A view of the job data.'
select TILDA.Job."refnum" as "jobRefnum" -- The primary key for this record
     , TILDA.Job."name" as "jobName" -- Name
     , TILDA.Job."type" as "jobType" -- Job type
     , TILDA.Job."userId" as "jobUserId" -- Job user Id
     , trim(TILDA.Job."dataStartTZ") as "jobDataStartTZ" -- Generated helper column to hold the time zone ID for 'dataStart'.
     , TILDA.Job."dataStart" as "jobDataStart" -- StartTime
     , trim(TILDA.Job."dataEndTZ") as "jobDataEndTZ" -- Generated helper column to hold the time zone ID for 'dataEnd'.
     , TILDA.Job."dataEnd" as "jobDataEnd" -- StartTime
     , trim(TILDA.Job."startTZ") as "jobStartTZ" -- Generated helper column to hold the time zone ID for 'start'.
     , TILDA.Job."start" as "jobStart" -- StartTime
     , trim(TILDA.Job."endTZ") as "jobEndTZ" -- Generated helper column to hold the time zone ID for 'end'.
     , TILDA.Job."end" as "jobEnd" -- EndTime
     , TILDA.Job."status" as "jobStatus" -- Status
     , TILDA.Job."msg" as "jobMsg" -- Message details
     , TILDA.JobPart."name" as "jobPartName" -- Job part name
     , TILDA.JobPart."type" as "jobPartType" -- Job part type
     , trim(TILDA.JobPart."dataStartTZ") as "jobPartDataStartTZ" -- Generated helper column to hold the time zone ID for 'dataStart'.
     , TILDA.JobPart."dataStart" as "jobPartDataStart" -- Job part data start
     , trim(TILDA.JobPart."dataEndTZ") as "jobPartDataEndTZ" -- Generated helper column to hold the time zone ID for 'dataEnd'.
     , TILDA.JobPart."dataEnd" as "jobPartDataEnd" -- Job part data end
     , trim(TILDA.JobPart."startTZ") as "jobPartStartTZ" -- Generated helper column to hold the time zone ID for 'start'.
     , TILDA.JobPart."start" as "jobPartStart" -- Job part execution start
     , trim(TILDA.JobPart."endTZ") as "jobPartEndTZ" -- Generated helper column to hold the time zone ID for 'end'.
     , TILDA.JobPart."end" as "jobPartEnd" -- Job part execution end
     , TILDA.JobPart."recordsCount" as "jobPartRecordsCount" -- count of database or file or ... records.
     , TILDA.JobPart."status" as "jobPartStatus" -- Status flag, i.e., success=true and failure-false
     , TILDA.JobPartMessage."notify" as "jobPartNotify" -- Notification flag
     , TILDA.JobPartMessage."msg" as "jobPartMessage" -- Message details
  from TILDA.Job
     left  join TILDA.JobPart on TILDA.JobPart."jobRefnum" = TILDA.Job."refnum"
     left  join TILDA.JobPartMessage on TILDA.JobPartMessage."jobPartRefnum" = TILDA.JobPart."refnum"
;


COMMENT ON VIEW TILDA.JobView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.JobView as \n-- ''A view of the job data.''\nselect TILDA.Job."refnum" as "jobRefnum" -- The primary key for this record\n     , TILDA.Job."name" as "jobName" -- Name\n     , TILDA.Job."type" as "jobType" -- Job type\n     , TILDA.Job."userId" as "jobUserId" -- Job user Id\n     , trim(TILDA.Job."dataStartTZ") as "jobDataStartTZ" -- Generated helper column to hold the time zone ID for ''dataStart''.\n     , TILDA.Job."dataStart" as "jobDataStart" -- StartTime\n     , trim(TILDA.Job."dataEndTZ") as "jobDataEndTZ" -- Generated helper column to hold the time zone ID for ''dataEnd''.\n     , TILDA.Job."dataEnd" as "jobDataEnd" -- StartTime\n     , trim(TILDA.Job."startTZ") as "jobStartTZ" -- Generated helper column to hold the time zone ID for ''start''.\n     , TILDA.Job."start" as "jobStart" -- StartTime\n     , trim(TILDA.Job."endTZ") as "jobEndTZ" -- Generated helper column to hold the time zone ID for ''end''.\n     , TILDA.Job."end" as "jobEnd" -- EndTime\n     , TILDA.Job."status" as "jobStatus" -- Status\n     , TILDA.Job."msg" as "jobMsg" -- Message details\n     , TILDA.JobPart."name" as "jobPartName" -- Job part name\n     , TILDA.JobPart."type" as "jobPartType" -- Job part type\n     , trim(TILDA.JobPart."dataStartTZ") as "jobPartDataStartTZ" -- Generated helper column to hold the time zone ID for ''dataStart''.\n     , TILDA.JobPart."dataStart" as "jobPartDataStart" -- Job part data start\n     , trim(TILDA.JobPart."dataEndTZ") as "jobPartDataEndTZ" -- Generated helper column to hold the time zone ID for ''dataEnd''.\n     , TILDA.JobPart."dataEnd" as "jobPartDataEnd" -- Job part data end\n     , trim(TILDA.JobPart."startTZ") as "jobPartStartTZ" -- Generated helper column to hold the time zone ID for ''start''.\n     , TILDA.JobPart."start" as "jobPartStart" -- Job part execution start\n     , trim(TILDA.JobPart."endTZ") as "jobPartEndTZ" -- Generated helper column to hold the time zone ID for ''end''.\n     , TILDA.JobPart."end" as "jobPartEnd" -- Job part execution end\n     , TILDA.JobPart."recordsCount" as "jobPartRecordsCount" -- count of database or file or ... records.\n     , TILDA.JobPart."status" as "jobPartStatus" -- Status flag, i.e., success=true and failure-false\n     , TILDA.JobPartMessage."notify" as "jobPartNotify" -- Notification flag\n     , TILDA.JobPartMessage."msg" as "jobPartMessage" -- Message details\n  from TILDA.Job\n     left  join TILDA.JobPart on TILDA.JobPart."jobRefnum" = TILDA.Job."refnum"\n     left  join TILDA.JobPartMessage on TILDA.JobPartMessage."jobPartRefnum" = TILDA.JobPart."refnum"\n;\n\n';

COMMENT ON COLUMN TILDA.JobView."jobRefnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JobView."jobName" IS E'Name';
COMMENT ON COLUMN TILDA.JobView."jobType" IS E'Job type';
COMMENT ON COLUMN TILDA.JobView."jobUserId" IS E'Job user Id';
COMMENT ON COLUMN TILDA.JobView."jobDataStartTZ" IS E'Generated helper column to hold the time zone ID for ''dataStart''.';
COMMENT ON COLUMN TILDA.JobView."jobDataStart" IS E'StartTime';
COMMENT ON COLUMN TILDA.JobView."jobDataEndTZ" IS E'Generated helper column to hold the time zone ID for ''dataEnd''.';
COMMENT ON COLUMN TILDA.JobView."jobDataEnd" IS E'StartTime';
COMMENT ON COLUMN TILDA.JobView."jobStartTZ" IS E'Generated helper column to hold the time zone ID for ''start''.';
COMMENT ON COLUMN TILDA.JobView."jobStart" IS E'StartTime';
COMMENT ON COLUMN TILDA.JobView."jobEndTZ" IS E'Generated helper column to hold the time zone ID for ''end''.';
COMMENT ON COLUMN TILDA.JobView."jobEnd" IS E'EndTime';
COMMENT ON COLUMN TILDA.JobView."jobStatus" IS E'Status';
COMMENT ON COLUMN TILDA.JobView."jobMsg" IS E'Message details';
COMMENT ON COLUMN TILDA.JobView."jobPartName" IS E'Job part name';
COMMENT ON COLUMN TILDA.JobView."jobPartType" IS E'Job part type';
COMMENT ON COLUMN TILDA.JobView."jobPartDataStartTZ" IS E'Generated helper column to hold the time zone ID for ''dataStart''.';
COMMENT ON COLUMN TILDA.JobView."jobPartDataStart" IS E'Job part data start';
COMMENT ON COLUMN TILDA.JobView."jobPartDataEndTZ" IS E'Generated helper column to hold the time zone ID for ''dataEnd''.';
COMMENT ON COLUMN TILDA.JobView."jobPartDataEnd" IS E'Job part data end';
COMMENT ON COLUMN TILDA.JobView."jobPartStartTZ" IS E'Generated helper column to hold the time zone ID for ''start''.';
COMMENT ON COLUMN TILDA.JobView."jobPartStart" IS E'Job part execution start';
COMMENT ON COLUMN TILDA.JobView."jobPartEndTZ" IS E'Generated helper column to hold the time zone ID for ''end''.';
COMMENT ON COLUMN TILDA.JobView."jobPartEnd" IS E'Job part execution end';
COMMENT ON COLUMN TILDA.JobView."jobPartRecordsCount" IS E'count of database or file or ... records.';
COMMENT ON COLUMN TILDA.JobView."jobPartStatus" IS E'Status flag, i.e., success=true and failure-false';
COMMENT ON COLUMN TILDA.JobView."jobPartNotify" IS E'Notification flag';
COMMENT ON COLUMN TILDA.JobView."jobPartMessage" IS E'Message details';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.JobView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;

