
create schema if not exists TILDA;



create table if not exists TILDA.ZoneInfo -- blah blah
 (  "id"             character(5)  not null   -- The id for this enumeration.
  , "value"          varchar(50)   not null   -- The value for this enumeration.
  , "label"          varchar(254)  not null   -- The label for this enumeration.
  , "deactivatedTZ"  character(5)             -- Generated helper column to hold the time zone ID for 'deactivated'.
  , "deactivated"    timestamptz              -- The label for this enumeration.
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("id")
  , CONSTRAINT fk_ZoneInfo_deactivated FOREIGN KEY ("deactivatedTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.ZoneInfo IS E'blah blah';
COMMENT ON COLUMN TILDA.ZoneInfo."id" IS E'The id for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."value" IS E'The value for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."label" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."deactivatedTZ" IS E'Generated helper column to hold the time zone ID for ''deactivated''.';
COMMENT ON COLUMN TILDA.ZoneInfo."deactivated" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZoneInfo."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.ZoneInfo."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.ZoneInfo."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX ZoneInfo_Id ON TILDA.ZoneInfo ("id");
CREATE UNIQUE INDEX ZoneInfo_Value ON TILDA.ZoneInfo ("value");
-- app-level index only -- CREATE INDEX ZoneInfo_All ON TILDA.ZoneInfo ("id" ASC);



create table if not exists TILDA.Key -- The table to keep track of unique keys across distributed objects/tables
 (  "refnum"          bigint        not null   -- The primary key for this record
  , "name"            varchar(128)  not null   -- The name of the table/object tracked
  , "max"             bigint        not null   -- The pre-allocated max RefNum for this table/object.
  , "count"           integer       not null   -- The size of the pre-allocation required by this table/object.
  , "created"         timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"     timestamptz   not null   -- The timestamp for when the record was last updated.
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
  , "created"      timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted.
 );
COMMENT ON TABLE TILDA.Mapping IS E'Generalized Mapping table';
COMMENT ON COLUMN TILDA.Mapping."type" IS E'The type this mapping is for';
COMMENT ON COLUMN TILDA.Mapping."src" IS E'The source value for this mapping';
COMMENT ON COLUMN TILDA.Mapping."dst" IS E'The the destination (mapped) value for this mapping.';
COMMENT ON COLUMN TILDA.Mapping."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Mapping."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Mapping."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX Mapping_TypeSrcDst ON TILDA.Mapping ("type", "src", "dst");



create table if not exists TILDA.ObjectPerf -- Performance logs for the Tilda framework
 (  "schemaName"     varchar(64)   not null   -- The name of the schema tracked
  , "objectName"     varchar(64)   not null   -- The name of the table/object tracked
  , "startPeriodTZ"  character(5)  not null   -- Generated helper column to hold the time zone ID for 'startPeriod'.
  , "startPeriod"    timestamptz   not null   -- The timestamp for when the record was created.
  , "endPeriodTZ"    character(5)  not null   -- Generated helper column to hold the time zone ID for 'endPeriod'.
  , "endPeriod"      timestamptz   not null   -- The timestamp for when the record was created.
  , "selectNano"     bigint        not null   -- Blah...
  , "selectCount"    bigint        not null   -- Blah...
  , "selectRecords"  bigint        not null   -- Blah...
  , "insertNano"     bigint        not null   -- Blah...
  , "insertCount"    bigint        not null   -- Blah...
  , "insertRecords"  bigint        not null   -- Blah...
  , "updateNano"     bigint        not null   -- Blah...
  , "updateCount"    bigint        not null   -- Blah...
  , "updateRecords"  bigint        not null   -- Blah...
  , "deleteNano"     bigint        not null   -- Blah...
  , "deleteCount"    bigint        not null   -- Blah...
  , "deleteRecords"  bigint        not null   -- Blah...
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
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
COMMENT ON COLUMN TILDA.ObjectPerf."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.ObjectPerf."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.ObjectPerf."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX ObjectPerf_SchemaByObjectStart ON TILDA.ObjectPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX ObjectPerf_SchemaObjectByStart ON TILDA.ObjectPerf ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.TransPerf -- Performance logs for the Tilda framework
 (  "schemaName"     varchar(64)   not null   -- The name of the schema tracked
  , "objectName"     varchar(64)   not null   -- The name of the table/object tracked
  , "startPeriodTZ"  character(5)  not null   -- Generated helper column to hold the time zone ID for 'startPeriod'.
  , "startPeriod"    timestamptz   not null   -- The timestamp for when the record was created.
  , "endPeriodTZ"    character(5)  not null   -- Generated helper column to hold the time zone ID for 'endPeriod'.
  , "endPeriod"      timestamptz   not null   -- The timestamp for when the record was created.
  , "commitNano"     bigint        not null   -- Blah...
  , "commitCount"    bigint        not null   -- Blah...
  , "rollbackNano"   bigint        not null   -- Blah...
  , "rollbackCount"  bigint        not null   -- Blah...
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("schemaName", "objectName", "startPeriod")
  , CONSTRAINT fk_TransPerf_startPeriod FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_TransPerf_endPeriod FOREIGN KEY ("endPeriodTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.TransPerf IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.TransPerf."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.TransPerf."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.TransPerf."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.TransPerf."startPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TransPerf."endPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''endPeriod''.';
COMMENT ON COLUMN TILDA.TransPerf."endPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TransPerf."commitNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."commitCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."rollbackNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."rollbackCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TransPerf."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TransPerf."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.TransPerf."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX TransPerf_AllBySchemaName ON TILDA.TransPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX TransPerf_AllByObjectName ON TILDA.TransPerf ("schemaName", "objectName", "startPeriod" DESC);



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
  , "created"      timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted.
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
COMMENT ON COLUMN TILDA.Connection."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Connection."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Connection."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX Connection_AllById ON TILDA.Connection ("id" ASC);



create table if not exists TILDA.Jobs -- Kettle Jobs
 (  "Id"            integer        not null   -- Id
  , "Name"          varchar(120)              -- Name
  , "StartTimeTZ"   character(5)              -- Generated helper column to hold the time zone ID for 'StartTime'.
  , "StartTime"     timestamptz               -- StartTime
  , "EndTimeTZ"     character(5)              -- Generated helper column to hold the time zone ID for 'EndTime'.
  , "EndTime"       timestamptz               -- EndTime
  , "TotalRecords"  integer                   -- TotalRecords
  , "Status"        varchar(200)              -- Status
  , "Error"         varchar(1000)             -- Error
  , "created"       timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"   timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"       timestamptz               -- The timestamp for when the record was deleted.
  , CONSTRAINT fk_Jobs_StartTime FOREIGN KEY ("StartTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Jobs_EndTime FOREIGN KEY ("EndTimeTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.Jobs IS E'Kettle Jobs';
COMMENT ON COLUMN TILDA.Jobs."Id" IS E'Id';
COMMENT ON COLUMN TILDA.Jobs."Name" IS E'Name';
COMMENT ON COLUMN TILDA.Jobs."StartTimeTZ" IS E'Generated helper column to hold the time zone ID for ''StartTime''.';
COMMENT ON COLUMN TILDA.Jobs."StartTime" IS E'StartTime';
COMMENT ON COLUMN TILDA.Jobs."EndTimeTZ" IS E'Generated helper column to hold the time zone ID for ''EndTime''.';
COMMENT ON COLUMN TILDA.Jobs."EndTime" IS E'EndTime';
COMMENT ON COLUMN TILDA.Jobs."TotalRecords" IS E'TotalRecords';
COMMENT ON COLUMN TILDA.Jobs."Status" IS E'Status';
COMMENT ON COLUMN TILDA.Jobs."Error" IS E'Error';
COMMENT ON COLUMN TILDA.Jobs."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Jobs."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Jobs."deleted" IS E'The timestamp for when the record was deleted.';
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
  , "created"                 timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"             timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"                 timestamptz               -- The timestamp for when the record was deleted.
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
COMMENT ON COLUMN TILDA.Job_Detail."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Job_Detail."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Job_Detail."deleted" IS E'The timestamp for when the record was deleted.';
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
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
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
COMMENT ON COLUMN TILDA.RefillPerf."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.RefillPerf."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.RefillPerf."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX RefillPerf_SchemaByObjectStart ON TILDA.RefillPerf ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX RefillPerf_SchemaObjectByStart ON TILDA.RefillPerf ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.Maintenance -- Maintenance information
 (  "type"         varchar(64)   not null   -- The type of maintenance resource to track
  , "name"         varchar(512)  not null   -- The name of the maintenance resource to track.
  , "value"        text                     -- The value of the maintenance resource to track.
  , "created"      timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("type", "name")
 );
COMMENT ON TABLE TILDA.Maintenance IS E'Maintenance information';
COMMENT ON COLUMN TILDA.Maintenance."type" IS E'The type of maintenance resource to track';
COMMENT ON COLUMN TILDA.Maintenance."name" IS E'The name of the maintenance resource to track.';
COMMENT ON COLUMN TILDA.Maintenance."value" IS E'The value of the maintenance resource to track.';
COMMENT ON COLUMN TILDA.Maintenance."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Maintenance."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Maintenance."deleted" IS E'The timestamp for when the record was deleted.';



create table if not exists TILDA.Formula -- Master formula information
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "location"     varchar(64)   not null   -- The name of the primary table/view this formula is defined in.
  , "location2"    varchar(64)   not null   -- The name of the secondary table/view (a derived view, a realized table), if appropriate.
  , "name"         varchar(64)   not null   -- The name of the formula/column.
  , "type"         character(3)  not null   -- The type of the formula/column value/outcome.
  , "title"        varchar(128)  not null   -- The title of the formula/column.
  , "description"  text          not null   -- The description of the formula/column.
  , "formula"      text                     -- The formula.
  , "htmlDoc"      text                     -- Pre-rendered html fragment with the full documentation for this formula.
  , "created"      timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted.
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
COMMENT ON COLUMN TILDA.Formula."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Formula."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Formula."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX Formula_Formula ON TILDA.Formula ("location", "name");
delete from TILDA.Key where "name" = 'TILDA.FORMULA';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.FORMULA',(select COALESCE(max("refnum"),0)+1 from TILDA.Formula), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.Measure -- Master Measure information
 (  "refnum"       bigint       not null   -- The primary key for this record
  , "schema"       varchar(64)  not null   -- The Schema wher ethe measure is defined.
  , "name"         varchar(64)  not null   -- The name of the measure.
  , "created"      timestamptz  not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz  not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz             -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.Measure IS E'Master Measure information';
COMMENT ON COLUMN TILDA.Measure."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.Measure."schema" IS E'The Schema wher ethe measure is defined.';
COMMENT ON COLUMN TILDA.Measure."name" IS E'The name of the measure.';
COMMENT ON COLUMN TILDA.Measure."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Measure."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Measure."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX Measure_Measure ON TILDA.Measure ("schema", "name");
delete from TILDA.Key where "name" = 'TILDA.MEASURE';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.MEASURE',(select COALESCE(max("refnum"),0)+1 from TILDA.Measure), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.MeasureFormula -- Master Measure information
 (  "measureRefnum"  bigint       not null   -- The measure.
  , "formulaRefnum"  bigint       not null   -- The parent formula.
  , "created"        timestamptz  not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz  not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz             -- The timestamp for when the record was deleted.
  , PRIMARY KEY("measureRefnum", "formulaRefnum")
  , CONSTRAINT fk_MeasureFormula_Measure FOREIGN KEY ("measureRefnum") REFERENCES TILDA.Measure ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_MeasureFormula_Formula FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.MeasureFormula IS E'Master Measure information';
COMMENT ON COLUMN TILDA.MeasureFormula."measureRefnum" IS E'The measure.';
COMMENT ON COLUMN TILDA.MeasureFormula."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.MeasureFormula."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.MeasureFormula."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.MeasureFormula."deleted" IS E'The timestamp for when the record was deleted.';



create table if not exists TILDA.FormulaDependency -- Master formula dependency information
 (  "formulaRefnum"     bigint       not null   -- The parent formula.
  , "dependencyRefnum"  bigint       not null   -- The dependent formula.
  , "created"           timestamptz  not null   -- The timestamp for when the record was created.
  , "lastUpdated"       timestamptz  not null   -- The timestamp for when the record was last updated.
  , "deleted"           timestamptz             -- The timestamp for when the record was deleted.
  , PRIMARY KEY("formulaRefnum", "dependencyRefnum")
  , CONSTRAINT fk_FormulaDependency_Formula1 FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_FormulaDependency_Formula2 FOREIGN KEY ("dependencyRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.FormulaDependency IS E'Master formula dependency information';
COMMENT ON COLUMN TILDA.FormulaDependency."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaDependency."dependencyRefnum" IS E'The dependent formula.';
COMMENT ON COLUMN TILDA.FormulaDependency."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.FormulaDependency."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.FormulaDependency."deleted" IS E'The timestamp for when the record was deleted.';



create table if not exists TILDA.FormulaResult -- Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)
 (  "formulaRefnum"  bigint        not null   -- The parent formula.
  , "value"          varchar(100)  not null   -- The result value.
  , "description"    text          not null   -- The description of the result value.
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("formulaRefnum", "value")
  , CONSTRAINT fk_FormulaResult_Formula FOREIGN KEY ("formulaRefnum") REFERENCES TILDA.Formula ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.FormulaResult IS E'Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)';
COMMENT ON COLUMN TILDA.FormulaResult."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaResult."value" IS E'The result value.';
COMMENT ON COLUMN TILDA.FormulaResult."description" IS E'The description of the result value.';
COMMENT ON COLUMN TILDA.FormulaResult."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.FormulaResult."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.FormulaResult."deleted" IS E'The timestamp for when the record was deleted.';



create table if not exists TILDA.Testing -- blah blah
 (  "refnum"       bigint              not null   -- The primary key for this record
  , "refnum2"      bigint[]            not null   -- The person's primary key
  , "name"         varchar(10)         not null   -- Medical system unique enterprise id
  , "description"  varchar(250)                   -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"        varchar(3000)                  -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"        text                           -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"        text                           -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"        text                           -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"        text                           -- The title for a person, i.e., Mr, Miss, Mrs...
  , "tops"         text[]                         -- The blah
  , "tops2"        text[]                         -- The blah
  , "a1"           INTEGER                        -- The blah
  , "a2"           character                      -- The blah
  , "a2b"          character[]                    -- The blah
  , "a2c"          character[]                    -- The blah
  , "a3"           boolean                        -- The blah
  , "a3b"          boolean[]                      -- The blah
  , "a4"           double precision               -- The blah
  , "a4b"          double precision[]             -- The blah
  , "a5"           real                           -- The blah
  , "a5b"          real[]                         -- The blah
  , "a6"           bigint                         -- The blah
  , "a6b"          bigint[]                       -- The blah
  , "a6c"          bigint[]                       -- The blah
  , "a7"           integer                        -- The blah
  , "a7b"          integer[]                      -- The blah
  , "a8"           BYTEA                          -- The blah
  , "a9TZ"         character(5)                   -- Generated helper column to hold the time zone ID for 'a9'.
  , "a9"           timestamptz                    -- The blah
  , "a9bTZ"        text[]                         -- Generated helper column to hold the time zone ID for 'a9b'.
  , "a9b"          timestamptz[]                  -- The blah
  , "a9c"          date                           -- The blah
  , "a9d"          date[]                         -- The blah
  , "created"      timestamptz         not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz         not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz                    -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Testing_a9 FOREIGN KEY ("a9TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
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
COMMENT ON COLUMN TILDA.Testing."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDA.Testing."a9" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9bTZ" IS E'Generated helper column to hold the time zone ID for ''a9b''.';
COMMENT ON COLUMN TILDA.Testing."a9b" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9c" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."a9d" IS E'The blah';
COMMENT ON COLUMN TILDA.Testing."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Testing."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Testing."deleted" IS E'The timestamp for when the record was deleted.';
-- app-level index only -- CREATE INDEX Testing_AllByName ON TILDA.Testing ("name" ASC);
CREATE INDEX Testing_AllByName2 ON TILDA.Testing ("name" ASC);
CREATE INDEX Testing_AllByName3 ON TILDA.Testing ("name" DESC);
CREATE INDEX Testing_AllByName4 ON TILDA.Testing ("name" ASC, "description" DESC);
delete from TILDA.Key where "name" = 'TILDA.TESTING';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDA.TESTING',(select COALESCE(max("refnum"),0)+1 from TILDA.Testing), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.Testing2 -- Testing
 (  "t1"           character(2)  not null   -- State code
  , "t2"           varchar(60)   not null   -- State name
  , "created"      timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted.
 );
COMMENT ON TABLE TILDA.Testing2 IS E'Testing';
COMMENT ON COLUMN TILDA.Testing2."t1" IS E'State code';
COMMENT ON COLUMN TILDA.Testing2."t2" IS E'State name';
COMMENT ON COLUMN TILDA.Testing2."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.Testing2."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.Testing2."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX Testing2_T1 ON TILDA.Testing2 ("t1");




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

COMMENT ON VIEW TILDA.FormulaResultView IS E'create or replace view TILDA.FormulaResultView as \n-- ''A view of formulas and their values.''\nselect TILDA.FormulaResult."formulaRefnum" as "formulaRefnum" -- The parent formula.\n     , TILDA.FormulaResult."value" as "value" -- The result value.\n     , TILDA.FormulaResult."description" as "description" -- The description of the result value.\n     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."name" as "name" -- The name of the formula/column.\n  from TILDA.FormulaResult\n     inner join TILDA.Formula on TILDA.FormulaResult."formulaRefnum" = TILDA.Formula."refnum"\n where (TILDA.Formula."deleted" is null and TILDA.FormulaResult."deleted" is null)\n;\n';

COMMENT ON COLUMN TILDA.FormulaResultView."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaResultView."value" IS E'The result value.';
COMMENT ON COLUMN TILDA.FormulaResultView."description" IS E'The description of the result value.';
COMMENT ON COLUMN TILDA.FormulaResultView."location" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.FormulaResultView."name" IS E'The name of the formula/column.';




create or replace view TILDA.FormulaDependencyView as 
-- 'A view of formulas and their dependencies.'
select TILDA.FormulaDependency."formulaRefnum" as "formulaRefnum" -- The parent formula.
     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.
     , TILDA.Formula."name" as "name" -- The name of the formula/column.
     , TILDA.FormulaDependency."dependencyRefnum" as "dependencyRefnum" -- The dependent formula.
     , TILDA_Formula_2."name" as "dependentFormulaName" -- The name of the formula/column.
  from TILDA.FormulaDependency
     inner join TILDA.Formula on TILDA.FormulaDependency."formulaRefnum" = TILDA.Formula."refnum"
     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency."dependencyRefnum" = TILDA_Formula_2."refnum"
 where (TILDA.Formula."deleted" is null)
;

COMMENT ON VIEW TILDA.FormulaDependencyView IS E'create or replace view TILDA.FormulaDependencyView as \n-- ''A view of formulas and their dependencies.''\nselect TILDA.FormulaDependency."formulaRefnum" as "formulaRefnum" -- The parent formula.\n     , TILDA.Formula."location" as "location" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."name" as "name" -- The name of the formula/column.\n     , TILDA.FormulaDependency."dependencyRefnum" as "dependencyRefnum" -- The dependent formula.\n     , TILDA_Formula_2."name" as "dependentFormulaName" -- The name of the formula/column.\n  from TILDA.FormulaDependency\n     inner join TILDA.Formula on TILDA.FormulaDependency."formulaRefnum" = TILDA.Formula."refnum"\n     inner join TILDA.Formula as TILDA_Formula_2 on TILDA.FormulaDependency."dependencyRefnum" = TILDA_Formula_2."refnum"\n where (TILDA.Formula."deleted" is null)\n;\n';

COMMENT ON COLUMN TILDA.FormulaDependencyView."formulaRefnum" IS E'The parent formula.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."location" IS E'The name of the primary table/view this formula is defined in.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."name" IS E'The name of the formula/column.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependencyRefnum" IS E'The dependent formula.';
COMMENT ON COLUMN TILDA.FormulaDependencyView."dependentFormulaName" IS E'The name of the formula/column.';




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

COMMENT ON VIEW TILDA.MeasureFormulaView IS E'create or replace view TILDA.MeasureFormulaView as \n-- ''A view of formulas and their dependencies.''\nselect TILDA.MeasureFormula."measureRefnum" as "measureRefnum" -- The measure.\n     , TILDA.Measure."schema" as "measureSchema" -- The Schema wher ethe measure is defined.\n     , TILDA.Measure."name" as "measureName" -- The name of the measure.\n     , TILDA.Formula."refnum" as "formulaRefnum" -- The primary key for this record\n     , TILDA.Formula."location" as "formulaLocation" -- The name of the primary table/view this formula is defined in.\n     , TILDA.Formula."location2" as "formulaLocation2" -- The name of the secondary table/view (a derived view, a realized table), if appropriate.\n     , TILDA.Formula."name" as "formulaName" -- The name of the formula/column.\n     , TILDA.Formula."title" as "title" -- The title of the formula/column.\n     , TILDA.Formula."description" as "description" -- The description of the formula/column.\n     , trim(TILDA.Formula."type") as "type" -- The type of the formula/column value/outcome.\n     , TILDA.Formula."formula" as "formula" -- The formula.\n  from TILDA.MeasureFormula\n     inner join TILDA.Measure on TILDA.MeasureFormula."measureRefnum" = TILDA.Measure."refnum"\n     inner join TILDA.Formula on TILDA.MeasureFormula."formulaRefnum" = TILDA.Formula."refnum"\n where (TILDA.Formula."deleted" is null and TILDA.Measure."deleted" is null)\n;\n';

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




create or replace view TILDA.TestingView as 
-- 'A view of formulas and their dependencies.'
select TILDA.Testing."name" as "name" -- Medical system unique enterprise id
     , count(TILDA.Testing."refnum") as "refnum" -- The primary key for this record
     , coalesce(min(TILDA.Testing."a2") filter(where a2 is not null), 'AAA') as "a2Min" -- The blah
     , coalesce(max(TILDA.Testing."a2") filter(where a2 is not null), 'ZZZ') as "a2Max" -- The blah
     , array_agg(TILDA.Testing."a9") as "a9" -- The blah
     , array_agg(distinct TILDA.Testing."a9c") as "a9c" -- The blah
  from TILDA.Testing
 where (TILDA.Testing."deleted" is null)
     group by TILDA.Testing."name"
;

COMMENT ON VIEW TILDA.TestingView IS E'create or replace view TILDA.TestingView as \n-- ''A view of formulas and their dependencies.''\nselect TILDA.Testing."name" as "name" -- Medical system unique enterprise id\n     , count(TILDA.Testing."refnum") as "refnum" -- The primary key for this record\n     , coalesce(min(TILDA.Testing."a2") filter(where a2 is not null), ''AAA'') as "a2Min" -- The blah\n     , coalesce(max(TILDA.Testing."a2") filter(where a2 is not null), ''ZZZ'') as "a2Max" -- The blah\n     , array_agg(TILDA.Testing."a9") as "a9" -- The blah\n     , array_agg(distinct TILDA.Testing."a9c") as "a9c" -- The blah\n  from TILDA.Testing\n where (TILDA.Testing."deleted" is null)\n     group by TILDA.Testing."name"\n;\n';

COMMENT ON COLUMN TILDA.TestingView."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.TestingView."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.TestingView."a2Min" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a2Max" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a9" IS E'The blah';
COMMENT ON COLUMN TILDA.TestingView."a9c" IS E'The blah';


