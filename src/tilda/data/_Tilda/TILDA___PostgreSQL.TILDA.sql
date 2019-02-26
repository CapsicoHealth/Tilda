
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
CREATE UNIQUE INDEX ZoneInfo_Id ON TILDA.ZoneInfo ("id");
CREATE UNIQUE INDEX ZoneInfo_Value ON TILDA.ZoneInfo ("value");
-- app-level index only -- CREATE INDEX ZoneInfo_All ON TILDA.ZoneInfo ("id" ASC);



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
CREATE UNIQUE INDEX Key_Name ON TILDA.Key ("name");
-- app-level index only -- CREATE INDEX Key_AllByName ON TILDA.Key ("name" ASC);



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
CREATE UNIQUE INDEX Mapping_TypeSrcDst ON TILDA.Mapping ("type", "src", "dst");



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
CREATE INDEX ObjectPerf_SchemaByObjectStart ON TILDA.ObjectPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX ObjectPerf_SchemaObjectByStart ON TILDA.ObjectPerf ("schemaName", "objectName", "startPeriod" DESC);



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
CREATE INDEX Connection_AllById ON TILDA.Connection ("id" ASC);



create table if not exists TILDA.Jobs -- Jobs
 (  "Id"            integer        not null   -- Id
  , "Name"          varchar(120)              -- Name
  , "StartTimeTZ"   character(5)              -- Generated helper column to hold the time zone ID for 'StartTime'.
  , "StartTime"     timestamptz               -- StartTime
  , "EndTimeTZ"     character(5)              -- Generated helper column to hold the time zone ID for 'EndTime'.
  , "EndTime"       timestamptz               -- EndTime
  , "TotalRecords"  integer                   -- TotalRecords
  , "Status"        varchar(200)              -- Status
  , "Error"         varchar(1000)             -- Error
  , "created"       timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Jobs)
  , "lastUpdated"   timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Jobs)
  , "deleted"       timestamptz               -- The timestamp for when the record was deleted. (TILDA.Jobs)
  , CONSTRAINT fk_Jobs_StartTime FOREIGN KEY ("StartTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Jobs_EndTime FOREIGN KEY ("EndTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.Jobs IS E'Jobs';
COMMENT ON COLUMN TILDA.Jobs."Id" IS E'Id';
COMMENT ON COLUMN TILDA.Jobs."Name" IS E'Name';
COMMENT ON COLUMN TILDA.Jobs."StartTimeTZ" IS E'Generated helper column to hold the time zone ID for ''StartTime''.';
COMMENT ON COLUMN TILDA.Jobs."StartTime" IS E'StartTime';
COMMENT ON COLUMN TILDA.Jobs."EndTimeTZ" IS E'Generated helper column to hold the time zone ID for ''EndTime''.';
COMMENT ON COLUMN TILDA.Jobs."EndTime" IS E'EndTime';
COMMENT ON COLUMN TILDA.Jobs."TotalRecords" IS E'TotalRecords';
COMMENT ON COLUMN TILDA.Jobs."Status" IS E'Status';
COMMENT ON COLUMN TILDA.Jobs."Error" IS E'Error';
COMMENT ON COLUMN TILDA.Jobs."created" IS E'The timestamp for when the record was created. (TILDA.Jobs)';
COMMENT ON COLUMN TILDA.Jobs."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Jobs)';
COMMENT ON COLUMN TILDA.Jobs."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Jobs)';
CREATE UNIQUE INDEX Jobs_Job_Id ON TILDA.Jobs ("Id");



create table if not exists TILDA.Job_Detail -- Job Detail
 (  "Id"                      integer        not null   -- Id
  , "Job_Id"                  integer        not null   -- Job Id
  , "FileName"                varchar(200)              -- FileName
  , "FileRecords"             integer                   -- FileRecords
  , "FileProcessStartTimeTZ"  character(5)              -- Generated helper column to hold the time zone ID for 'FileProcessStartTime'.
  , "FileProcessStartTime"    timestamptz               -- FileProcessStartTime
  , "FileProcessEndTimeTZ"    character(5)              -- Generated helper column to hold the time zone ID for 'FileProcessEndTime'.
  , "FileProcessEndTime"      timestamptz               -- FileProcessEndTime
  , "Status"                  varchar(200)              -- Status
  , "Error"                   varchar(1000)             -- Error
  , "created"                 timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Job_Detail)
  , "lastUpdated"             timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Job_Detail)
  , "deleted"                 timestamptz               -- The timestamp for when the record was deleted. (TILDA.Job_Detail)
  , CONSTRAINT fk_Job_Detail_FileProcessStartTime FOREIGN KEY ("FileProcessStartTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Job_Detail_FileProcessEndTime FOREIGN KEY ("FileProcessEndTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.Job_Detail IS E'Job Detail';
COMMENT ON COLUMN TILDA.Job_Detail."Id" IS E'Id';
COMMENT ON COLUMN TILDA.Job_Detail."Job_Id" IS E'Job Id';
COMMENT ON COLUMN TILDA.Job_Detail."FileName" IS E'FileName';
COMMENT ON COLUMN TILDA.Job_Detail."FileRecords" IS E'FileRecords';
COMMENT ON COLUMN TILDA.Job_Detail."FileProcessStartTimeTZ" IS E'Generated helper column to hold the time zone ID for ''FileProcessStartTime''.';
COMMENT ON COLUMN TILDA.Job_Detail."FileProcessStartTime" IS E'FileProcessStartTime';
COMMENT ON COLUMN TILDA.Job_Detail."FileProcessEndTimeTZ" IS E'Generated helper column to hold the time zone ID for ''FileProcessEndTime''.';
COMMENT ON COLUMN TILDA.Job_Detail."FileProcessEndTime" IS E'FileProcessEndTime';
COMMENT ON COLUMN TILDA.Job_Detail."Status" IS E'Status';
COMMENT ON COLUMN TILDA.Job_Detail."Error" IS E'Error';
COMMENT ON COLUMN TILDA.Job_Detail."created" IS E'The timestamp for when the record was created. (TILDA.Job_Detail)';
COMMENT ON COLUMN TILDA.Job_Detail."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Job_Detail)';
COMMENT ON COLUMN TILDA.Job_Detail."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Job_Detail)';
CREATE UNIQUE INDEX Job_Detail_Job_File_Id ON TILDA.Job_Detail ("Id", "Job_Id");



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
CREATE INDEX RefillPerf_SchemaByObjectStart ON TILDA.RefillPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX RefillPerf_SchemaObjectByStart ON TILDA.RefillPerf ("schemaName", "objectName", "startPeriod" DESC);



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
CREATE UNIQUE INDEX Formula_Formula ON TILDA.Formula ("location", "name");
CREATE INDEX Formula_RefCols ON TILDA.Formula USING gin  ("referencedColumns" );
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
CREATE UNIQUE INDEX Measure_Measure ON TILDA.Measure ("schema", "name");
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



create table if not exists TILDA.DependencyDDLDummyTable -- A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.
 (  "srcSchemaName"  varchar(100)  not null   -- The result value.
  , "srcTVName"      varchar(100)  not null   -- The result value.
  , "seq"            integer       not null   -- The blah
  , "depSchemaName"  varchar(100)  not null   -- The result value.
  , "depViewName"    varchar(100)  not null   -- The result value.
  , "restoreScript"  text          not null   -- The result value.
  , "created"        timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.DependencyDDLDummyTable)
  , "lastUpdated"    timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.DependencyDDLDummyTable)
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted. (TILDA.DependencyDDLDummyTable)
 );
COMMENT ON TABLE TILDA.DependencyDDLDummyTable IS E'A dummy Table created to generate JavaCode to handle results from the Tilda.getDependenciesDDLs() function output.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."srcSchemaName" IS E'The result value.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."srcTVName" IS E'The result value.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."seq" IS E'The blah';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."depSchemaName" IS E'The result value.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."depViewName" IS E'The result value.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."restoreScript" IS E'The result value.';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."created" IS E'The timestamp for when the record was created. (TILDA.DependencyDDLDummyTable)';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.DependencyDDLDummyTable)';
COMMENT ON COLUMN TILDA.DependencyDDLDummyTable."deleted" IS E'The timestamp for when the record was deleted. (TILDA.DependencyDDLDummyTable)';
CREATE UNIQUE INDEX DependencyDDLDummyTable_DepedencySequence ON TILDA.DependencyDDLDummyTable ("srcSchemaName", "srcTVName", "seq");
CREATE UNIQUE INDEX DependencyDDLDummyTable_DepedencySTV ON TILDA.DependencyDDLDummyTable ("srcSchemaName", "srcTVName", "depSchemaName", "depViewName");



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
CREATE UNIQUE INDEX DateLimitDim_InvalidDate ON TILDA.DateLimitDim ("invalidDate");



create table if not exists TILDA.Testing -- blah blah
 (  "refnum"       bigint         not null   -- The primary key for this record
  , "refnum2"      bigint[]       not null   -- The person's primary key
  , "name"         varchar(10)    not null   -- Medical system unique enterprise id
  , "description"  varchar(250)              -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"        varchar(3000)             -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "tops"         text[]                    -- The blah
  , "tops2"        text[]                    -- The blah
  , "a1"           INTEGER                   -- The blah
  , "a2"           character                 -- The blah
  , "a2b"          character[]               -- The blah
  , "a2c"          character[]               -- The blah
  , "a3"           boolean                   -- The blah
  , "a3b"          boolean[]                 -- The blah
  , "a4"           double                    -- The blah
  , "a4b"          double[]                  -- The blah
  , "a5"           real                      -- The blah
  , "a5b"          real[]                    -- The blah
  , "a6"           bigint                    -- The blah
  , "a6b"          bigint[]                  -- The blah
  , "a6c"          bigint[]                  -- The blah
  , "a6dTZ"        character(5)              -- Generated helper column to hold the time zone ID for 'a6d'.
  , "a6d"          timestamptz               -- The blah
  , "a7"           integer                   -- The blah
  , "a7b"          integer[]                 -- The blah
  , "a8"           BYTEA                     -- The blah
  , "a8bTZ"        character(5)              -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"          timestamptz               -- The blah
  , "a9TZ"         character(5)              -- Generated helper column to hold the time zone ID for 'a9'.
  , "a9"           timestamptz             DEFAULT now()   -- The blah
  , "a9a1TZ"       character(5)              -- Generated helper column to hold the time zone ID for 'a9a1'.
  , "a9a1"         timestamptz             DEFAULT '1111-11-11T00:00:00Z'   -- The blah
  , "a9bTZ"        text[]                    -- Generated helper column to hold the time zone ID for 'a9b'.
  , "a9b"          timestamptz[]             -- The blah
  , "a9c"          date                      -- The blah
  , "a9d"          date[]                    -- The blah
  , "a10"          smallint                  -- The blah
  , "a10b"         smallint[]                -- The blah
  , "created"      timestamptz    not null DEFAULT now()   -- The timestamp for when the record was created. (TILDA.Testing)
  , "lastUpdated"  timestamptz    not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Testing)
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted. (TILDA.Testing)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Testing_a6d FOREIGN KEY ("a6dTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a8b FOREIGN KEY ("a8bTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a9 FOREIGN KEY ("a9TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a9a1 FOREIGN KEY ("a9a1TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.Testing IS E'blah blah';
COMMENT ON COLUMN TILDA.Testing."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing."refnum2" IS E'The person''s primary key';
COMMENT ON COLUMN TILDA.Testing."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing."tops" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."tops2" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a2" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a2b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a2c" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a3" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a6" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a6b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a6c" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a6dTZ" IS E'Generated helper column to hold the time zone ID for ''a6d''.';
COMMENT ON COLUMN TILDA.Testing."a6d" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDA.Testing."a9" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9a1TZ" IS E'Generated helper column to hold the time zone ID for ''a9a1''.';
COMMENT ON COLUMN TILDA.Testing."a9a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9bTZ" IS E'Generated helper column to hold the time zone ID for ''a9b''.';
COMMENT ON COLUMN TILDA.Testing."a9b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9c" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9d" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a10" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a10b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."created" IS E'The timestamp for when the record was created. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing."deleted" IS E'The timestamp for when the record was deleted. (TILDA.Testing)';
-- app-level index only -- CREATE INDEX Testing_AllByName ON TILDA.Testing ("name" ASC);
CREATE INDEX Testing_AllByName2 ON TILDA.Testing ("name" ASC);
CREATE INDEX Testing_AllByName3 ON TILDA.Testing ("name" DESC);
CREATE INDEX Testing_AllByName4 ON TILDA.Testing ("name" ASC, "description" DESC);
delete from TILDA.Key where "name" = 'TILDA.TESTING';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.TESTING',(select COALESCE(max("refnum"),0)+1 from TILDA.Testing), 25000, current_timestamp, current_timestamp);



create table if not exists TILDA.Testing2Realized -- Realized table for view TILDA.Testing2View: A test view to test .* and exclude and block.
 (  "refnum"          bigint         not null   -- The primary key for this record
  , "name"            varchar(10)               -- Medical system unique enterprise id
  , "lastUpdated"     timestamptz             DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Testing)
  , "xxxLastUpdated"  timestamptz             DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Testing)
  , "a1"              INTEGER                   -- The blah
  , "a3b"             boolean[]                 -- The blah
  , "a4"              double                    -- The blah
  , "a4b"             double[]                  -- The blah
  , "a5"              real                      -- The blah
  , "a5b"             real[]                    -- The blah
  , "a7"              integer                   -- The blah
  , "a7b"             integer[]                 -- The blah
  , "a8"              BYTEA                     -- The blah
  , "a8bTZ"           character(5)              -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"             timestamptz               -- The blah
  , "a10"             smallint                  -- The blah
  , "a10b"            smallint[]                -- The blah
  , "description"     varchar(250)              -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"           varchar(3000)             -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"           text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"           text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"           text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"           text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "a3"              boolean                   -- Formula column '<B>Not A3</B>'
  , "bastille"        timestamptz               -- Formula column '<B>Bastille Day</B>'
  , "toto"            timestamptz               -- Formula column '<B>Last Updated</B>'
  , "desc2_Cat1"      double                    -- Formula column '<B>desc2_Cat1 Title</B>'
  , "desc2_Cat2"      double                    -- Formula column '<B>desc2_Cat2 Title</B>'
  , "desc2_Cat3"      double                    -- Formula column '<B>desc2_Cat3 Title</B>'
  , "a7_Cat4"         double                    -- Formula column '<B>a7_Cat4 Title</B>'
  , "a7_Cat5"         double                    -- Formula column '<B>a7_Cat5 Title</B>'
  , "a5_null"         integer                   -- Formula column '<B>Null a5</B>'
  , "a6_null"         integer                   -- Formula column '<B>Null a6</B>'
  , "a7_null"         integer                   -- Formula column '<B>Null a7</B>'
  , "a8_null"         integer                   -- Formula column '<B>Null a8</B>'
 );
COMMENT ON TABLE TILDA.Testing2Realized IS E'Realized table for view TILDA.Testing2View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDA.Testing2Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing2Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing2Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing2Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing2Realized."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing2Realized."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a10" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."a10b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2Realized."a3" IS E'Formula column ''<B>Not A3</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."bastille" IS E'Formula column ''<B>Bastille Day</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."toto" IS E'Formula column ''<B>Last Updated</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a5_null" IS E'Formula column ''<B>Null a5</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a6_null" IS E'Formula column ''<B>Null a6</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a7_null" IS E'Formula column ''<B>Null a7</B>''';
COMMENT ON COLUMN TILDA.Testing2Realized."a8_null" IS E'Formula column ''<B>Null a8</B>''';
CREATE UNIQUE INDEX Testing2Realized_Refnum ON TILDA.Testing2Realized ("refnum");
CREATE INDEX Testing2Realized_LastUpdated ON TILDA.Testing2Realized ("lastUpdated" DESC);



create table if not exists TILDA.Testing3Realized -- Realized table for view TILDA.Testing3View: A test view to test .* and exclude and block.
 (  "refnum"          bigint        not null   -- The primary key for this record
  , "name"            varchar(10)              -- Medical system unique enterprise id
  , "a8bTZ"           character(5)             -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"             timestamptz              -- The blah
  , "lastUpdated"     timestamptz            DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Testing)
  , "xxxLastUpdated"  timestamptz            DEFAULT now()   -- The timestamp for when the record was last updated. (TILDA.Testing)
 );
COMMENT ON TABLE TILDA.Testing3Realized IS E'Realized table for view TILDA.Testing3View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDA.Testing3Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing3Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing3Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing3Realized."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing3Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing3Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
CREATE UNIQUE INDEX Testing3Realized_Refnum ON TILDA.Testing3Realized ("refnum");
CREATE INDEX Testing3Realized_LastUpdated ON TILDA.Testing3Realized ("lastUpdated" DESC);



create table if not exists TILDA.Testing4Realized -- Realized table for view TILDA.Testing4View: A test view to test .* and exclude and block.
 (  "refnum"       bigint         not null   -- The primary key for this record
  , "name"         varchar(10)               -- Medical system unique enterprise id
  , "a1"           INTEGER                   -- The blah
  , "a3b"          boolean[]                 -- The blah
  , "a4"           double                    -- The blah
  , "a4b"          double[]                  -- The blah
  , "a5"           real                      -- The blah
  , "a5b"          real[]                    -- The blah
  , "a7"           integer                   -- The blah
  , "a7b"          integer[]                 -- The blah
  , "a8"           BYTEA                     -- The blah
  , "a8bTZ"        character(5)              -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"          timestamptz               -- The blah
  , "a10"          smallint                  -- The blah
  , "a10b"         smallint[]                -- The blah
  , "description"  varchar(250)              -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"        varchar(3000)             -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"        text                      -- The title for a person, i.e., Mr, Miss, Mrs...
  , "bastille"     timestamptz               -- Formula column '<B>Bastille Day</B>'
  , "toto"         timestamptz               -- Formula column '<B>Last Updated</B>'
  , "desc2_Cat1"   double                    -- Formula column '<B>desc2_Cat1 Title</B>'
  , "desc2_Cat2"   double                    -- Formula column '<B>desc2_Cat2 Title</B>'
  , "desc2_Cat3"   double                    -- Formula column '<B>desc2_Cat3 Title</B>'
  , "a7_Cat4"      double                    -- Formula column '<B>a7_Cat4 Title</B>'
  , "a7_Cat5"      double                    -- Formula column '<B>a7_Cat5 Title</B>'
  , "a5_null"      integer                   -- Formula column '<B>Null a5</B>'
  , "a6_null"      integer                   -- Formula column '<B>Null a6</B>'
  , "a7_null"      integer                   -- Formula column '<B>Null a7</B>'
  , "a8_null"      integer                   -- Formula column '<B>Null a8</B>'
  , "a3"           boolean                   -- Formula column '<B>Always True</B>'
  , "lastUpdated"  timestamptz               -- Formula column '<B>Always True</B>'
 );
COMMENT ON TABLE TILDA.Testing4Realized IS E'Realized table for view TILDA.Testing4View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDA.Testing4Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing4Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing4Realized."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing4Realized."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a10" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."a10b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4Realized."bastille" IS E'Formula column ''<B>Bastille Day</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."toto" IS E'Formula column ''<B>Last Updated</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a5_null" IS E'Formula column ''<B>Null a5</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a6_null" IS E'Formula column ''<B>Null a6</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a7_null" IS E'Formula column ''<B>Null a7</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a8_null" IS E'Formula column ''<B>Null a8</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."a3" IS E'Formula column ''<B>Always True</B>''';
COMMENT ON COLUMN TILDA.Testing4Realized."lastUpdated" IS E'Formula column ''<B>Always True</B>''';
CREATE UNIQUE INDEX Testing4Realized_Refnum ON TILDA.Testing4Realized ("refnum");
CREATE INDEX Testing4Realized_LastUpdated ON TILDA.Testing4Realized ("lastUpdated" DESC);




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
create or replace view TILDA.TestingView as 
-- 'A test view to test aggregates.'
select TILDA.Testing."name" as "name" -- Medical system unique enterprise id
     , count(TILDA.Testing."refnum") as "refnum" -- The primary key for this record
     , coalesce(min(TILDA.Testing."a2") filter(where a2 is not null), 'AAA') as "a2Min" -- The blah
     , coalesce(max(TILDA.Testing."a2") filter(where a2 is not null), 'ZZZ') as "a2Max" -- The blah
     , array_agg(TILDA.Testing."a9" order by "lastUpdated" ASC) as "a9" -- The blah
     , array_agg(TILDA.Testing."a9c") as "a9c" -- The blah
     , first(TILDA.Testing."a6" order by "lastUpdated" ASC) as "a6First" -- The blah
     , last(TILDA.Testing."a6" order by "lastUpdated" ASC) as "a6Last" -- The blah
  from TILDA.Testing
 where (TILDA.Testing."deleted" is null)
     group by TILDA.Testing."name"
;


COMMENT ON VIEW TILDA.TestingView IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.TestingView as \n-- ''A test view to test aggregates.''\nselect TILDA.Testing."name" as "name" -- Medical system unique enterprise id\n     , count(TILDA.Testing."refnum") as "refnum" -- The primary key for this record\n     , coalesce(min(TILDA.Testing."a2") filter(where a2 is not null), ''AAA'') as "a2Min" -- The blah\n     , coalesce(max(TILDA.Testing."a2") filter(where a2 is not null), ''ZZZ'') as "a2Max" -- The blah\n     , array_agg(TILDA.Testing."a9" order by "lastUpdated" ASC) as "a9" -- The blah\n     , array_agg(TILDA.Testing."a9c") as "a9c" -- The blah\n     , first(TILDA.Testing."a6" order by "lastUpdated" ASC) as "a6First" -- The blah\n     , last(TILDA.Testing."a6" order by "lastUpdated" ASC) as "a6Last" -- The blah\n  from TILDA.Testing\n where (TILDA.Testing."deleted" is null)\n     group by TILDA.Testing."name"\n;\n\n';

COMMENT ON COLUMN TILDA.TestingView."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.TestingView."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.TestingView."a2Min" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a2Max" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a9" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a9c" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a6First" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a6Last" IS E'The blah';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.TestingView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.Testing2View as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
     , "lastUpdated" -- COLUMN
     , "xxxLastUpdated" -- COLUMN
     , "a1" -- COLUMN
--     "a3"  BLOCKED
     , "a3b" -- COLUMN
     , "a4" -- COLUMN
     , "a4b" -- COLUMN
     , "a5" -- COLUMN
     , "a5b" -- COLUMN
--     "a6"  BLOCKED
--     "a6b"  BLOCKED
--     "a6c"  BLOCKED
--     "a6dTZ"  BLOCKED
--     "a6d"  BLOCKED
     , "a7" -- COLUMN
     , "a7b" -- COLUMN
     , "a8" -- COLUMN
     , "a8bTZ" -- COLUMN
     , "a8b" -- COLUMN
--     "a9TZ"  BLOCKED
--     "a9"  BLOCKED
--     "a9a1TZ"  BLOCKED
--     "a9a1"  BLOCKED
--     "a9bTZ"  BLOCKED
--     "a9b"  BLOCKED
--     "a9c"  BLOCKED
--     "a9d"  BLOCKED
     , "a10" -- COLUMN
     , "a10b" -- COLUMN
     , "description" -- COLUMN
     , "desc2" -- COLUMN
     , "desc3" -- COLUMN
     , "desc4" -- COLUMN
     , "desc5" -- COLUMN
     , "desc6" -- COLUMN
     -- Blah...
     , (NOT "a3")::boolean as "a3"
     -- Blah...
     , ('1789-07-14')::timestamptz as "bastille"
     -- Blah...
     , ('2018-08-10')::timestamptz as "toto"
     -- This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDA.Testing2View.
     , (case when "desc2"  in ('a', 'b', 'c') then 1 else 0 end)::double as "desc2_Cat1"
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDA.Testing2View.
     , (case when "desc2"  in ('x', 'y', 'z') then 1 else 0 end)::double as "desc2_Cat2"
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDA.Testing2View.
     , (case when "desc2"  in ('x', 'y', 'z') then 1 else 0 end)::double as "desc2_Cat3"
     -- This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
     , (case when coalesce("a7", 0) >= 0.0 and coalesce("a7", 0) < 10.0 then 1 else 0 end)::double as "a7_Cat4"
     -- This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
     , (case when coalesce("a7", 0) >= 10.0 and coalesce("a7", 0) < 20.0 then 1 else 0 end)::double as "a7_Cat5"
     -- Whether a5 is null or not
     , (case when "a5" is null then 1 when "a5" is not null then 0 end)::integer as "a5_null"
     -- Whether a6 is null or not
     , (case when "a6" is null then 1 when "a6" is not null then 0 end)::integer as "a6_null"
     -- Whether a7 is null or not
     , (case when "a7" is null then 1 when "a7" is not null then 0 end)::integer as "a7_null"
     -- Whether a8 is null or not
     , (case when "a8" is null then 1 when "a8" is not null then 0 end)::integer as "a8_null"

 from (
-- 'A test view to test .* and exclude and block.'
select TILDA.Testing."refnum" as "refnum" -- The primary key for this record
     , TILDA.Testing."name" as "name" -- Medical system unique enterprise id
     , TILDA.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
     , TILDA.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
     , TILDA.Testing."a1" as "a1" -- The blah
     , TILDA.Testing."a3" as "a3" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a3b" as "a3b" -- The blah
     , TILDA.Testing."a4" as "a4" -- The blah
     , TILDA.Testing."a4b" as "a4b" -- The blah
     , TILDA.Testing."a5" as "a5" -- The blah
     , TILDA.Testing."a5b" as "a5b" -- The blah
     , TILDA.Testing."a6" as "a6" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a6b" as "a6b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a6c" as "a6c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , trim(TILDA.Testing."a6dTZ") as "a6dTZ" -- Generated helper column to hold the time zone ID for 'a6d'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a6d" as "a6d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a7" as "a7" -- The blah
     , TILDA.Testing."a7b" as "a7b" -- The blah
     , TILDA.Testing."a8" as "a8" -- The blah
     , trim(TILDA.Testing."a8bTZ") as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDA.Testing."a8b" as "a8b" -- The blah
     , trim(TILDA.Testing."a9TZ") as "a9TZ" -- Generated helper column to hold the time zone ID for 'a9'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9" as "a9" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , trim(TILDA.Testing."a9a1TZ") as "a9a1TZ" -- Generated helper column to hold the time zone ID for 'a9a1'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9a1" as "a9a1" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9bTZ" as "a9bTZ" -- Generated helper column to hold the time zone ID for 'a9b'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9b" as "a9b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9c" as "a9c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a9d" as "a9d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing."a10" as "a10" -- The blah
     , TILDA.Testing."a10b" as "a10b" -- The blah
     , TILDA.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
  from TILDA.Testing
 where (TILDA.Testing."deleted" is null)

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"a1" -- COLUMN -- "a3" -- BLOCKED ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN -- "a6" -- BLOCKED -- "a6b" -- BLOCKED -- "a6c" -- BLOCKED -- "a6dTZ" -- BLOCKED -- "a6d" -- BLOCKED ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN -- "a9TZ" -- BLOCKED -- "a9" -- BLOCKED -- "a9a1TZ" -- BLOCKED -- "a9a1" -- BLOCKED -- "a9bTZ" -- BLOCKED -- "a9b" -- BLOCKED -- "a9c" -- BLOCKED -- "a9d" -- BLOCKED ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA ,"a8_null" -- FORMULA
;


DROP FUNCTION IF EXISTS TILDA.Refill_Testing2Realized();
CREATE OR REPLACE FUNCTION TILDA.Refill_Testing2Realized()
 RETURNS boolean AS $$
BEGIN
  TRUNCATE TILDA.Testing2Realized;
  INSERT INTO TILDA.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10", "a10b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          ,"lastUpdated" -- COLUMN
          ,"xxxLastUpdated" -- COLUMN
          -- "created" -- VIEW-EXCLUDED
          ,"a1" -- COLUMN
          -- "a3" -- BLOCKED
          ,"a3b" -- COLUMN
          ,"a4" -- COLUMN
          ,"a4b" -- COLUMN
          ,"a5" -- COLUMN
          ,"a5b" -- COLUMN
          -- "a6" -- BLOCKED
          -- "a6b" -- BLOCKED
          -- "a6c" -- BLOCKED
          -- "a6dTZ" -- BLOCKED
          -- "a6d" -- BLOCKED
          ,"a7" -- COLUMN
          ,"a7b" -- COLUMN
          ,"a8" -- COLUMN
          ,"a8bTZ" -- COLUMN
          ,"a8b" -- COLUMN
          -- "a9TZ" -- BLOCKED
          -- "a9" -- BLOCKED
          -- "a9a1TZ" -- BLOCKED
          -- "a9a1" -- BLOCKED
          -- "a9bTZ" -- BLOCKED
          -- "a9b" -- BLOCKED
          -- "a9c" -- BLOCKED
          -- "a9d" -- BLOCKED
          ,"a10" -- COLUMN
          ,"a10b" -- COLUMN
          ,"description" -- COLUMN
          ,"desc2" -- COLUMN
          ,"desc3" -- COLUMN
          ,"desc4" -- COLUMN
          ,"desc5" -- COLUMN
          ,"desc6" -- COLUMN
          ,"a3" -- FORMULA
          ,"bastille" -- FORMULA
          ,"toto" -- FORMULA
          ,"desc2_Cat1" -- FORMULA
          ,"desc2_Cat2" -- FORMULA
          ,"desc2_Cat3" -- FORMULA
          ,"a7_Cat4" -- FORMULA
          ,"a7_Cat5" -- FORMULA
          ,"a5_null" -- FORMULA
          ,"a6_null" -- FORMULA
          ,"a7_null" -- FORMULA
          ,"a8_null" -- FORMULA
     FROM TILDA.Testing2View;
  ANALYZE TILDA.Testing2Realized;
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDA.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDA.Testing2View IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.Testing2View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n     , "lastUpdated" -- COLUMN\n     , "xxxLastUpdated" -- COLUMN\n     , "a1" -- COLUMN\n--     "a3"  BLOCKED\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n--     "a6"  BLOCKED\n--     "a6b"  BLOCKED\n--     "a6c"  BLOCKED\n--     "a6dTZ"  BLOCKED\n--     "a6d"  BLOCKED\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n--     "a9TZ"  BLOCKED\n--     "a9"  BLOCKED\n--     "a9a1TZ"  BLOCKED\n--     "a9a1"  BLOCKED\n--     "a9bTZ"  BLOCKED\n--     "a9b"  BLOCKED\n--     "a9c"  BLOCKED\n--     "a9d"  BLOCKED\n     , "a10" -- COLUMN\n     , "a10b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n     -- Blah...\n     , (NOT "a3")::boolean as "a3"\n     -- Blah...\n     , (''1789-07-14'')::timestamptz as "bastille"\n     -- Blah...\n     , (''2018-08-10'')::timestamptz as "toto"\n     -- This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDA.Testing2View.\n     , (case when "desc2"  in (''a'', ''b'', ''c'') then 1 else 0 end)::double as "desc2_Cat1"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double as "desc2_Cat2"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double as "desc2_Cat3"\n     -- This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.\n     , (case when coalesce("a7", 0) >= 0.0 and coalesce("a7", 0) < 10.0 then 1 else 0 end)::double as "a7_Cat4"\n     -- This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.\n     , (case when coalesce("a7", 0) >= 10.0 and coalesce("a7", 0) < 20.0 then 1 else 0 end)::double as "a7_Cat5"\n     -- Whether a5 is null or not\n     , (case when "a5" is null then 1 when "a5" is not null then 0 end)::integer as "a5_null"\n     -- Whether a6 is null or not\n     , (case when "a6" is null then 1 when "a6" is not null then 0 end)::integer as "a6_null"\n     -- Whether a7 is null or not\n     , (case when "a7" is null then 1 when "a7" is not null then 0 end)::integer as "a7_null"\n     -- Whether a8 is null or not\n     , (case when "a8" is null then 1 when "a8" is not null then 0 end)::integer as "a8_null"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDA.Testing."refnum" as "refnum" -- The primary key for this record\n     , TILDA.Testing."name" as "name" -- Medical system unique enterprise id\n     , TILDA.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n     , TILDA.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n     , TILDA.Testing."a1" as "a1" -- The blah\n     , TILDA.Testing."a3" as "a3" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a3b" as "a3b" -- The blah\n     , TILDA.Testing."a4" as "a4" -- The blah\n     , TILDA.Testing."a4b" as "a4b" -- The blah\n     , TILDA.Testing."a5" as "a5" -- The blah\n     , TILDA.Testing."a5b" as "a5b" -- The blah\n     , TILDA.Testing."a6" as "a6" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a6b" as "a6b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a6c" as "a6c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , trim(TILDA.Testing."a6dTZ") as "a6dTZ" -- Generated helper column to hold the time zone ID for ''a6d''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a6d" as "a6d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a7" as "a7" -- The blah\n     , TILDA.Testing."a7b" as "a7b" -- The blah\n     , TILDA.Testing."a8" as "a8" -- The blah\n     , trim(TILDA.Testing."a8bTZ") as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDA.Testing."a8b" as "a8b" -- The blah\n     , trim(TILDA.Testing."a9TZ") as "a9TZ" -- Generated helper column to hold the time zone ID for ''a9''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9" as "a9" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , trim(TILDA.Testing."a9a1TZ") as "a9a1TZ" -- Generated helper column to hold the time zone ID for ''a9a1''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9a1" as "a9a1" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9bTZ" as "a9bTZ" -- Generated helper column to hold the time zone ID for ''a9b''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9b" as "a9b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9c" as "a9c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a9d" as "a9d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing."a10" as "a10" -- The blah\n     , TILDA.Testing."a10b" as "a10b" -- The blah\n     , TILDA.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n  from TILDA.Testing\n where (TILDA.Testing."deleted" is null)\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"a1" -- COLUMN -- "a3" -- BLOCKED ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN -- "a6" -- BLOCKED -- "a6b" -- BLOCKED -- "a6c" -- BLOCKED -- "a6dTZ" -- BLOCKED -- "a6d" -- BLOCKED ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN -- "a9TZ" -- BLOCKED -- "a9" -- BLOCKED -- "a9a1TZ" -- BLOCKED -- "a9a1" -- BLOCKED -- "a9bTZ" -- BLOCKED -- "a9b" -- BLOCKED -- "a9c" -- BLOCKED -- "a9d" -- BLOCKED ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA ,"a8_null" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDA.Refill_Testing2Realized();\nCREATE OR REPLACE FUNCTION TILDA.Refill_Testing2Realized()\n RETURNS boolean AS $$\nBEGIN\n  TRUNCATE TILDA.Testing2Realized;\n  INSERT INTO TILDA.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10", "a10b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n          -- "created" -- VIEW-EXCLUDED\n          ,"a1" -- COLUMN\n          -- "a3" -- BLOCKED\n          ,"a3b" -- COLUMN\n          ,"a4" -- COLUMN\n          ,"a4b" -- COLUMN\n          ,"a5" -- COLUMN\n          ,"a5b" -- COLUMN\n          -- "a6" -- BLOCKED\n          -- "a6b" -- BLOCKED\n          -- "a6c" -- BLOCKED\n          -- "a6dTZ" -- BLOCKED\n          -- "a6d" -- BLOCKED\n          ,"a7" -- COLUMN\n          ,"a7b" -- COLUMN\n          ,"a8" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          -- "a9TZ" -- BLOCKED\n          -- "a9" -- BLOCKED\n          -- "a9a1TZ" -- BLOCKED\n          -- "a9a1" -- BLOCKED\n          -- "a9bTZ" -- BLOCKED\n          -- "a9b" -- BLOCKED\n          -- "a9c" -- BLOCKED\n          -- "a9d" -- BLOCKED\n          ,"a10" -- COLUMN\n          ,"a10b" -- COLUMN\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"bastille" -- FORMULA\n          ,"toto" -- FORMULA\n          ,"desc2_Cat1" -- FORMULA\n          ,"desc2_Cat2" -- FORMULA\n          ,"desc2_Cat3" -- FORMULA\n          ,"a7_Cat4" -- FORMULA\n          ,"a7_Cat5" -- FORMULA\n          ,"a5_null" -- FORMULA\n          ,"a6_null" -- FORMULA\n          ,"a7_null" -- FORMULA\n          ,"a8_null" -- FORMULA\n     FROM TILDA.Testing2View;\n  ANALYZE TILDA.Testing2Realized;\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDA.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDA.Testing2View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing2View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing2View."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing2View."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing2View."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing2View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a10" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."a10b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing2View."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing2View."a3" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDA.Testing2View."bastille" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDA.Testing2View."toto" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDA.Testing2View."desc2_Cat1" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDA.Testing2View.';
COMMENT ON COLUMN TILDA.Testing2View."desc2_Cat2" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.';
COMMENT ON COLUMN TILDA.Testing2View."desc2_Cat3" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.';
COMMENT ON COLUMN TILDA.Testing2View."a7_Cat4" IS E'The calculated formula: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.';
COMMENT ON COLUMN TILDA.Testing2View."a7_Cat5" IS E'The calculated formula: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.';
COMMENT ON COLUMN TILDA.Testing2View."a5_null" IS E'The calculated formula: Whether a5 is null or not';
COMMENT ON COLUMN TILDA.Testing2View."a6_null" IS E'The calculated formula: Whether a6 is null or not';
COMMENT ON COLUMN TILDA.Testing2View."a7_null" IS E'The calculated formula: Whether a7 is null or not';
COMMENT ON COLUMN TILDA.Testing2View."a8_null" IS E'The calculated formula: Whether a8 is null or not';

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 12)-12;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a3', 'BOL', 'Not A3', 'Blah...', 'NOT a3', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a3'], current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'bastille', 'DTM', 'Bastille Day', 'Blah...', '''1789-07-14''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+2, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'toto', 'DTM', 'Last Updated', 'Blah...', '''2018-08-10''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+3, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'desc2_Cat1', 'DBL', 'desc2_Cat1 Title', 'This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDA.Testing2View.', 'case when desc2  in (''a'', ''b'', ''c'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+4, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'desc2_Cat2', 'DBL', 'desc2_Cat2 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+5, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'desc2_Cat3', 'DBL', 'desc2_Cat3 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDA.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+6, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a7_Cat4', 'DBL', 'a7_Cat4 Title', 'This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.', 'case when a7 >= 0.0 and a7 < 10.0 then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+7, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a7_Cat5', 'DBL', 'a7_Cat5 Title', 'This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.', 'case when a7 >= 10.0 and a7 < 20.0 then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+8, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a5_null', 'INT', 'Null a5', 'Whether a5 is null or not', 'case when a5 is null then 1
     when a5 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a5'], current_timestamp, current_timestamp, null)
          ,(k+9, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a6_null', 'INT', 'Null a6', 'Whether a6 is null or not', 'case when a6 is null then 1
     when a6 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a6'], current_timestamp, current_timestamp, null)
          ,(k+10, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a7_null', 'INT', 'Null a7', 'Whether a7 is null or not', 'case when a7 is null then 1
     when a7 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+11, 'TILDA.Testing2View', 'TILDA.Testing2Realized', 'a8_null', 'INT', 'Null a8', 'Whether a8 is null or not', 'case when a8 is null then 1
     when a8 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDA.Testing2View.a8'], current_timestamp, current_timestamp, null)
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
UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.Testing2View' AND "lastUpdated" < ts;

UPDATE TILDA.FormulaResult
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing2View'
                                and "deleted" is not null
                            );

UPDATE TILDA.FormulaDependency
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing2View'
                                and "deleted" is not null
                            );

select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', 0)-0;


DELETE FROM TILDA.MeasureFormula
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing2View'
                                and "deleted" is not null
                            );

UPDATE TILDA.Measure
   set deleted = current_timestamp
 where "refnum" not in (select "measureRefnum" from TILDA.MeasureFormula)
 ;

END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.Testing3View as 
-- 'A test view to test .* and exclude and block.'
select TILDA.Testing2View."refnum" as "refnum" -- The primary key for this record
     , TILDA.Testing2View."name" as "name" -- Medical system unique enterprise id
     , TILDA.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDA.Testing2View."a8b" as "a8b" -- The blah
     , TILDA.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
     , TILDA.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
  from TILDA.Testing2View
;

create or replace view TILDATMP.TILDA_Testing3View_R as 
-- 'A test view to test .* and exclude and block.'
select TILDA.Testing2Realized."refnum" as "refnum" -- The primary key for this record
     , TILDA.Testing2Realized."name" as "name" -- Medical system unique enterprise id
     , TILDA.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDA.Testing2Realized."a8b" as "a8b" -- The blah
     , TILDA.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
     , TILDA.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)
  from TILDA.Testing2Realized
;


DROP FUNCTION IF EXISTS TILDA.Refill_Testing3Realized();
CREATE OR REPLACE FUNCTION TILDA.Refill_Testing3Realized()
 RETURNS boolean AS $$
BEGIN
  TRUNCATE TILDA.Testing3Realized;
  INSERT INTO TILDA.Testing3Realized ("refnum", "name", "a8bTZ", "a8b", "lastUpdated", "xxxLastUpdated")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          ,"a8bTZ" -- COLUMN
          ,"a8b" -- COLUMN
          ,"lastUpdated" -- COLUMN
          ,"xxxLastUpdated" -- COLUMN
     FROM TILDATMP.TILDA_Testing3View_R;
  ANALYZE TILDA.Testing3Realized;
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDA.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDA.Testing3View IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.Testing3View as \n-- ''A test view to test .* and exclude and block.''\nselect TILDA.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDA.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDA.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDA.Testing2View."a8b" as "a8b" -- The blah\n     , TILDA.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n     , TILDA.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n  from TILDA.Testing2View\n;\n\ncreate or replace view TILDATMP.TILDA_Testing3View_R as \n-- ''A test view to test .* and exclude and block.''\nselect TILDA.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDA.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDA.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDA.Testing2Realized."a8b" as "a8b" -- The blah\n     , TILDA.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n     , TILDA.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing)\n  from TILDA.Testing2Realized\n;\n\n\nDROP FUNCTION IF EXISTS TILDA.Refill_Testing3Realized();\nCREATE OR REPLACE FUNCTION TILDA.Refill_Testing3Realized()\n RETURNS boolean AS $$\nBEGIN\n  TRUNCATE TILDA.Testing3Realized;\n  INSERT INTO TILDA.Testing3Realized ("refnum", "name", "a8bTZ", "a8b", "lastUpdated", "xxxLastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n     FROM TILDATMP.TILDA_Testing3View_R;\n  ANALYZE TILDA.Testing3Realized;\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDA.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDA.Testing3View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing3View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing3View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing3View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing3View."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';
COMMENT ON COLUMN TILDA.Testing3View."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDA.Testing)';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.Testing3View' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2019-01-09
create or replace view TILDA.Testing4View as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
--     "lastUpdated"  BLOCKED
--     "xxxLastUpdated"  BLOCKED
     , "a1" -- COLUMN
     , "a3b" -- COLUMN
     , "a4" -- COLUMN
     , "a4b" -- COLUMN
     , "a5" -- COLUMN
     , "a5b" -- COLUMN
     , "a7" -- COLUMN
     , "a7b" -- COLUMN
     , "a8" -- COLUMN
     , "a8bTZ" -- COLUMN
     , "a8b" -- COLUMN
     , "a10" -- COLUMN
     , "a10b" -- COLUMN
     , "description" -- COLUMN
     , "desc2" -- COLUMN
     , "desc3" -- COLUMN
     , "desc4" -- COLUMN
     , "desc5" -- COLUMN
     , "desc6" -- COLUMN
--     "a3"  BLOCKED
     , "bastille" -- COLUMN
     , "toto" -- COLUMN
     , "desc2_Cat1" -- COLUMN
     , "desc2_Cat2" -- COLUMN
     , "desc2_Cat3" -- COLUMN
     , "a7_Cat4" -- COLUMN
     , "a7_Cat5" -- COLUMN
     , "a5_null" -- COLUMN
     , "a6_null" -- COLUMN
     , "a7_null" -- COLUMN
     , "a8_null" -- COLUMN
     -- Blah...
     , (NOT "a3" OR A3)::boolean as "a3"
     -- Blah...
     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"

 from (
-- 'A test view to test .* and exclude and block.'
select TILDA.Testing2View."refnum" as "refnum" -- The primary key for this record
     , TILDA.Testing2View."name" as "name" -- Medical system unique enterprise id
     , TILDA.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2View."a1" as "a1" -- The blah
     , TILDA.Testing2View."a3b" as "a3b" -- The blah
     , TILDA.Testing2View."a4" as "a4" -- The blah
     , TILDA.Testing2View."a4b" as "a4b" -- The blah
     , TILDA.Testing2View."a5" as "a5" -- The blah
     , TILDA.Testing2View."a5b" as "a5b" -- The blah
     , TILDA.Testing2View."a7" as "a7" -- The blah
     , TILDA.Testing2View."a7b" as "a7b" -- The blah
     , TILDA.Testing2View."a8" as "a8" -- The blah
     , TILDA.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDA.Testing2View."a8b" as "a8b" -- The blah
     , TILDA.Testing2View."a10" as "a10" -- The blah
     , TILDA.Testing2View."a10b" as "a10b" -- The blah
     , TILDA.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2View."a3" as "a3" -- Formula column '<B>Not A3</B>' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2View."bastille" as "bastille" -- Formula column '<B>Bastille Day</B>'
     , TILDA.Testing2View."toto" as "toto" -- Formula column '<B>Last Updated</B>'
     , TILDA.Testing2View."desc2_Cat1" as "desc2_Cat1" -- Formula column '<B>desc2_Cat1 Title</B>'
     , TILDA.Testing2View."desc2_Cat2" as "desc2_Cat2" -- Formula column '<B>desc2_Cat2 Title</B>'
     , TILDA.Testing2View."desc2_Cat3" as "desc2_Cat3" -- Formula column '<B>desc2_Cat3 Title</B>'
     , TILDA.Testing2View."a7_Cat4" as "a7_Cat4" -- Formula column '<B>a7_Cat4 Title</B>'
     , TILDA.Testing2View."a7_Cat5" as "a7_Cat5" -- Formula column '<B>a7_Cat5 Title</B>'
     , TILDA.Testing2View."a5_null" as "a5_null" -- Formula column '<B>Null a5</B>'
     , TILDA.Testing2View."a6_null" as "a6_null" -- Formula column '<B>Null a6</B>'
     , TILDA.Testing2View."a7_null" as "a7_null" -- Formula column '<B>Null a7</B>'
     , TILDA.Testing2View."a8_null" as "a8_null" -- Formula column '<B>Null a8</B>'
  from TILDA.Testing2View

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
;

create or replace view TILDATMP.TILDA_Testing4View_R as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
--     "lastUpdated"  BLOCKED
--     "xxxLastUpdated"  BLOCKED
     , "a1" -- COLUMN
     , "a3b" -- COLUMN
     , "a4" -- COLUMN
     , "a4b" -- COLUMN
     , "a5" -- COLUMN
     , "a5b" -- COLUMN
     , "a7" -- COLUMN
     , "a7b" -- COLUMN
     , "a8" -- COLUMN
     , "a8bTZ" -- COLUMN
     , "a8b" -- COLUMN
     , "a10" -- COLUMN
     , "a10b" -- COLUMN
     , "description" -- COLUMN
     , "desc2" -- COLUMN
     , "desc3" -- COLUMN
     , "desc4" -- COLUMN
     , "desc5" -- COLUMN
     , "desc6" -- COLUMN
--     "a3"  BLOCKED
     , "bastille" -- COLUMN
     , "toto" -- COLUMN
     , "desc2_Cat1" -- COLUMN
     , "desc2_Cat2" -- COLUMN
     , "desc2_Cat3" -- COLUMN
     , "a7_Cat4" -- COLUMN
     , "a7_Cat5" -- COLUMN
     , "a5_null" -- COLUMN
     , "a6_null" -- COLUMN
     , "a7_null" -- COLUMN
     , "a8_null" -- COLUMN
     -- Blah...
     , (NOT "a3" OR A3)::boolean as "a3"
     -- Blah...
     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"

 from (
-- 'A test view to test .* and exclude and block.'
select TILDA.Testing2Realized."refnum" as "refnum" -- The primary key for this record
     , TILDA.Testing2Realized."name" as "name" -- Medical system unique enterprise id
     , TILDA.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2Realized."a1" as "a1" -- The blah
     , TILDA.Testing2Realized."a3b" as "a3b" -- The blah
     , TILDA.Testing2Realized."a4" as "a4" -- The blah
     , TILDA.Testing2Realized."a4b" as "a4b" -- The blah
     , TILDA.Testing2Realized."a5" as "a5" -- The blah
     , TILDA.Testing2Realized."a5b" as "a5b" -- The blah
     , TILDA.Testing2Realized."a7" as "a7" -- The blah
     , TILDA.Testing2Realized."a7b" as "a7b" -- The blah
     , TILDA.Testing2Realized."a8" as "a8" -- The blah
     , TILDA.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDA.Testing2Realized."a8b" as "a8b" -- The blah
     , TILDA.Testing2Realized."a10" as "a10" -- The blah
     , TILDA.Testing2Realized."a10b" as "a10b" -- The blah
     , TILDA.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDA.Testing2Realized."a3" as "a3" -- Formula column '<B>Not A3</B>' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDA.Testing2Realized."bastille" as "bastille" -- Formula column '<B>Bastille Day</B>'
     , TILDA.Testing2Realized."toto" as "toto" -- Formula column '<B>Last Updated</B>'
     , TILDA.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- Formula column '<B>desc2_Cat1 Title</B>'
     , TILDA.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- Formula column '<B>desc2_Cat2 Title</B>'
     , TILDA.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- Formula column '<B>desc2_Cat3 Title</B>'
     , TILDA.Testing2Realized."a7_Cat4" as "a7_Cat4" -- Formula column '<B>a7_Cat4 Title</B>'
     , TILDA.Testing2Realized."a7_Cat5" as "a7_Cat5" -- Formula column '<B>a7_Cat5 Title</B>'
     , TILDA.Testing2Realized."a5_null" as "a5_null" -- Formula column '<B>Null a5</B>'
     , TILDA.Testing2Realized."a6_null" as "a6_null" -- Formula column '<B>Null a6</B>'
     , TILDA.Testing2Realized."a7_null" as "a7_null" -- Formula column '<B>Null a7</B>'
     , TILDA.Testing2Realized."a8_null" as "a8_null" -- Formula column '<B>Null a8</B>'
  from TILDA.Testing2Realized

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
;


DROP FUNCTION IF EXISTS TILDA.Refill_Testing4Realized();
CREATE OR REPLACE FUNCTION TILDA.Refill_Testing4Realized()
 RETURNS boolean AS $$
BEGIN
  TRUNCATE TILDA.Testing4Realized;
  INSERT INTO TILDA.Testing4Realized ("refnum", "name", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10", "a10b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null", "a3", "lastUpdated")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          -- "lastUpdated" -- BLOCKED
          -- "xxxLastUpdated" -- BLOCKED
          ,"a1" -- COLUMN
          ,"a3b" -- COLUMN
          ,"a4" -- COLUMN
          ,"a4b" -- COLUMN
          ,"a5" -- COLUMN
          ,"a5b" -- COLUMN
          ,"a7" -- COLUMN
          ,"a7b" -- COLUMN
          ,"a8" -- COLUMN
          ,"a8bTZ" -- COLUMN
          ,"a8b" -- COLUMN
          ,"a10" -- COLUMN
          ,"a10b" -- COLUMN
          ,"description" -- COLUMN
          ,"desc2" -- COLUMN
          ,"desc3" -- COLUMN
          ,"desc4" -- COLUMN
          ,"desc5" -- COLUMN
          ,"desc6" -- COLUMN
          -- "a3" -- BLOCKED
          ,"bastille" -- COLUMN
          ,"toto" -- COLUMN
          ,"desc2_Cat1" -- COLUMN
          ,"desc2_Cat2" -- COLUMN
          ,"desc2_Cat3" -- COLUMN
          ,"a7_Cat4" -- COLUMN
          ,"a7_Cat5" -- COLUMN
          ,"a5_null" -- COLUMN
          ,"a6_null" -- COLUMN
          ,"a7_null" -- COLUMN
          ,"a8_null" -- COLUMN
          ,"a3" -- FORMULA
          ,"lastUpdated" -- FORMULA
     FROM TILDATMP.TILDA_Testing4View_R;
  ANALYZE TILDA.Testing4Realized;
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDA.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDA.Testing4View IS E'-- DDL META DATA VERSION 2019-01-09\ncreate or replace view TILDA.Testing4View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "a1" -- COLUMN\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n     , "a10" -- COLUMN\n     , "a10b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     , "a8_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDA.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDA.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDA.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2View."a1" as "a1" -- The blah\n     , TILDA.Testing2View."a3b" as "a3b" -- The blah\n     , TILDA.Testing2View."a4" as "a4" -- The blah\n     , TILDA.Testing2View."a4b" as "a4b" -- The blah\n     , TILDA.Testing2View."a5" as "a5" -- The blah\n     , TILDA.Testing2View."a5b" as "a5b" -- The blah\n     , TILDA.Testing2View."a7" as "a7" -- The blah\n     , TILDA.Testing2View."a7b" as "a7b" -- The blah\n     , TILDA.Testing2View."a8" as "a8" -- The blah\n     , TILDA.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDA.Testing2View."a8b" as "a8b" -- The blah\n     , TILDA.Testing2View."a10" as "a10" -- The blah\n     , TILDA.Testing2View."a10b" as "a10b" -- The blah\n     , TILDA.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2View."a3" as "a3" -- Formula column ''<B>Not A3</B>'' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2View."bastille" as "bastille" -- Formula column ''<B>Bastille Day</B>''\n     , TILDA.Testing2View."toto" as "toto" -- Formula column ''<B>Last Updated</B>''\n     , TILDA.Testing2View."desc2_Cat1" as "desc2_Cat1" -- Formula column ''<B>desc2_Cat1 Title</B>''\n     , TILDA.Testing2View."desc2_Cat2" as "desc2_Cat2" -- Formula column ''<B>desc2_Cat2 Title</B>''\n     , TILDA.Testing2View."desc2_Cat3" as "desc2_Cat3" -- Formula column ''<B>desc2_Cat3 Title</B>''\n     , TILDA.Testing2View."a7_Cat4" as "a7_Cat4" -- Formula column ''<B>a7_Cat4 Title</B>''\n     , TILDA.Testing2View."a7_Cat5" as "a7_Cat5" -- Formula column ''<B>a7_Cat5 Title</B>''\n     , TILDA.Testing2View."a5_null" as "a5_null" -- Formula column ''<B>Null a5</B>''\n     , TILDA.Testing2View."a6_null" as "a6_null" -- Formula column ''<B>Null a6</B>''\n     , TILDA.Testing2View."a7_null" as "a7_null" -- Formula column ''<B>Null a7</B>''\n     , TILDA.Testing2View."a8_null" as "a8_null" -- Formula column ''<B>Null a8</B>''\n  from TILDA.Testing2View\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDA_Testing4View_R as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "a1" -- COLUMN\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n     , "a10" -- COLUMN\n     , "a10b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     , "a8_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDA.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDA.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDA.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDA.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2Realized."a1" as "a1" -- The blah\n     , TILDA.Testing2Realized."a3b" as "a3b" -- The blah\n     , TILDA.Testing2Realized."a4" as "a4" -- The blah\n     , TILDA.Testing2Realized."a4b" as "a4b" -- The blah\n     , TILDA.Testing2Realized."a5" as "a5" -- The blah\n     , TILDA.Testing2Realized."a5b" as "a5b" -- The blah\n     , TILDA.Testing2Realized."a7" as "a7" -- The blah\n     , TILDA.Testing2Realized."a7b" as "a7b" -- The blah\n     , TILDA.Testing2Realized."a8" as "a8" -- The blah\n     , TILDA.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDA.Testing2Realized."a8b" as "a8b" -- The blah\n     , TILDA.Testing2Realized."a10" as "a10" -- The blah\n     , TILDA.Testing2Realized."a10b" as "a10b" -- The blah\n     , TILDA.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDA.Testing2Realized."a3" as "a3" -- Formula column ''<B>Not A3</B>'' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDA.Testing2Realized."bastille" as "bastille" -- Formula column ''<B>Bastille Day</B>''\n     , TILDA.Testing2Realized."toto" as "toto" -- Formula column ''<B>Last Updated</B>''\n     , TILDA.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- Formula column ''<B>desc2_Cat1 Title</B>''\n     , TILDA.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- Formula column ''<B>desc2_Cat2 Title</B>''\n     , TILDA.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- Formula column ''<B>desc2_Cat3 Title</B>''\n     , TILDA.Testing2Realized."a7_Cat4" as "a7_Cat4" -- Formula column ''<B>a7_Cat4 Title</B>''\n     , TILDA.Testing2Realized."a7_Cat5" as "a7_Cat5" -- Formula column ''<B>a7_Cat5 Title</B>''\n     , TILDA.Testing2Realized."a5_null" as "a5_null" -- Formula column ''<B>Null a5</B>''\n     , TILDA.Testing2Realized."a6_null" as "a6_null" -- Formula column ''<B>Null a6</B>''\n     , TILDA.Testing2Realized."a7_null" as "a7_null" -- Formula column ''<B>Null a7</B>''\n     , TILDA.Testing2Realized."a8_null" as "a8_null" -- Formula column ''<B>Null a8</B>''\n  from TILDA.Testing2Realized\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10" -- COLUMN ,"a10b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDA.Refill_Testing4Realized();\nCREATE OR REPLACE FUNCTION TILDA.Refill_Testing4Realized()\n RETURNS boolean AS $$\nBEGIN\n  TRUNCATE TILDA.Testing4Realized;\n  INSERT INTO TILDA.Testing4Realized ("refnum", "name", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10", "a10b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null", "a3", "lastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          -- "lastUpdated" -- BLOCKED\n          -- "xxxLastUpdated" -- BLOCKED\n          ,"a1" -- COLUMN\n          ,"a3b" -- COLUMN\n          ,"a4" -- COLUMN\n          ,"a4b" -- COLUMN\n          ,"a5" -- COLUMN\n          ,"a5b" -- COLUMN\n          ,"a7" -- COLUMN\n          ,"a7b" -- COLUMN\n          ,"a8" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          ,"a10" -- COLUMN\n          ,"a10b" -- COLUMN\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          -- "a3" -- BLOCKED\n          ,"bastille" -- COLUMN\n          ,"toto" -- COLUMN\n          ,"desc2_Cat1" -- COLUMN\n          ,"desc2_Cat2" -- COLUMN\n          ,"desc2_Cat3" -- COLUMN\n          ,"a7_Cat4" -- COLUMN\n          ,"a7_Cat5" -- COLUMN\n          ,"a5_null" -- COLUMN\n          ,"a6_null" -- COLUMN\n          ,"a7_null" -- COLUMN\n          ,"a8_null" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"lastUpdated" -- FORMULA\n     FROM TILDATMP.TILDA_Testing4View_R;\n  ANALYZE TILDA.Testing4Realized;\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDA.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDA.Testing4View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Testing4View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.Testing4View."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDA.Testing4View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a10" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."a10b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing4View."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.Testing4View."bastille" IS E'Formula column ''<B>Bastille Day</B>''';
COMMENT ON COLUMN TILDA.Testing4View."toto" IS E'Formula column ''<B>Last Updated</B>''';
COMMENT ON COLUMN TILDA.Testing4View."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4View."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4View."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a5_null" IS E'Formula column ''<B>Null a5</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a6_null" IS E'Formula column ''<B>Null a6</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a7_null" IS E'Formula column ''<B>Null a7</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a8_null" IS E'Formula column ''<B>Null a8</B>''';
COMMENT ON COLUMN TILDA.Testing4View."a3" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDA.Testing4View."lastUpdated" IS E'The calculated formula: Blah...';

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 2)-2;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDA.Testing4View', 'TILDA.Testing4Realized', 'a3', 'BOL', 'Always True', 'Blah...', 'NOT a3 OR A3', '<B>N/A</B>', ARRAY['TILDA.Testing4View.a3'], current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDA.Testing4View', 'TILDA.Testing4Realized', 'lastUpdated', 'DTM', 'Always True', 'Blah...', 'GREATEST(lastUpdated, xxxLastUpdated)', '<B>N/A</B>', ARRAY['TILDA.Testing4View.lastUpdated', 'TILDA.Testing4View.xxxLastUpdated'], current_timestamp, current_timestamp, null)
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
UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDA.Testing4View' AND "lastUpdated" < ts;

UPDATE TILDA.FormulaResult
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing4View'
                                and "deleted" is not null
                            );

UPDATE TILDA.FormulaDependency
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing4View'
                                and "deleted" is not null
                            );

select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', 0)-0;


DELETE FROM TILDA.MeasureFormula
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDA.Testing4View'
                                and "deleted" is not null
                            );

UPDATE TILDA.Measure
   set deleted = current_timestamp
 where "refnum" not in (select "measureRefnum" from TILDA.MeasureFormula)
 ;

END; $$
LANGUAGE PLPGSQL;

