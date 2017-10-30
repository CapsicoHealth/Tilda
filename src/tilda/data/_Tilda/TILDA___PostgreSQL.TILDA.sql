
create schema if not exists TILDA;



create table if not exists TILDA.ZONEINFO -- blah blah
 (  "id"             character(5)  not null   -- The id for this enumeration.
  , "value"          varchar(50)   not null   -- The value for this enumeration.
  , "label"          varchar(254)  not null   -- The label for this enumeration.
  , "deactivatedTZ"  character(5)             -- Generated helper column to hold the time zone ID for 'deactivated'.
  , "deactivated"    timestamptz              -- The label for this enumeration.
  , "created"        timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("id")
  , FOREIGN KEY ("deactivatedTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.ZONEINFO IS E'blah blah';
COMMENT ON COLUMN TILDA.ZONEINFO."id" IS E'The id for this enumeration.';
COMMENT ON COLUMN TILDA.ZONEINFO."value" IS E'The value for this enumeration.';
COMMENT ON COLUMN TILDA.ZONEINFO."label" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZONEINFO."deactivatedTZ" IS E'Generated helper column to hold the time zone ID for ''deactivated''.';
COMMENT ON COLUMN TILDA.ZONEINFO."deactivated" IS E'The label for this enumeration.';
COMMENT ON COLUMN TILDA.ZONEINFO."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.ZONEINFO."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.ZONEINFO."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX ZONEINFO_Id ON TILDA.ZONEINFO ("id");
CREATE UNIQUE INDEX ZONEINFO_Value ON TILDA.ZONEINFO ("value");
-- app-level index only -- CREATE INDEX ZONEINFO_All ON TILDA.ZONEINFO ("id" ASC);



create table if not exists TILDA.KEY -- The table to keep track of unique keys across distributed objects/tables
 (  "refnum"          bigint        not null   -- The primary key for this record
  , "name"            varchar(128)  not null   -- The name of the table/object tracked
  , "max"             bigint        not null   -- The pre-allocated max RefNum for this table/object.
  , "count"           integer       not null   -- The size of the pre-allocation required by this table/object.
  , "created"         timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"     timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"         timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.KEY IS E'The table to keep track of unique keys across distributed objects/tables';
COMMENT ON COLUMN TILDA.KEY."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.KEY."name" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.KEY."max" IS E'The pre-allocated max RefNum for this table/object.';
COMMENT ON COLUMN TILDA.KEY."count" IS E'The size of the pre-allocation required by this table/object.';
COMMENT ON COLUMN TILDA.KEY."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.KEY."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.KEY."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX KEY_Name ON TILDA.KEY ("name");
-- app-level index only -- CREATE INDEX KEY_AllByName ON TILDA.KEY ("name" ASC);



create table if not exists TILDA.MAPPING -- Performance logs for the Tilda framework
 (  "type"         character(10)  not null   -- The type this mapping is for
  , "src"          varchar(1024)  not null   -- The source value for this mapping
  , "dst"          varchar(1024)  not null   -- The the destination (mapped) value for this mapping.
  , "created"      timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted.
 );
COMMENT ON TABLE TILDA.MAPPING IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.MAPPING."type" IS E'The type this mapping is for';
COMMENT ON COLUMN TILDA.MAPPING."src" IS E'The source value for this mapping';
COMMENT ON COLUMN TILDA.MAPPING."dst" IS E'The the destination (mapped) value for this mapping.';
COMMENT ON COLUMN TILDA.MAPPING."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.MAPPING."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.MAPPING."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX MAPPING_TypeSrcDst ON TILDA.MAPPING ("type", "src", "dst");



create table if not exists TILDA.OBJECTPERF -- Performance logs for the Tilda framework
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
  , FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
  , FOREIGN KEY ("endPeriodTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.OBJECTPERF IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.OBJECTPERF."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.OBJECTPERF."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.OBJECTPERF."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.OBJECTPERF."startPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.OBJECTPERF."endPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''endPeriod''.';
COMMENT ON COLUMN TILDA.OBJECTPERF."endPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.OBJECTPERF."selectNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."selectCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."selectRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."insertNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."insertCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."insertRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."updateNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."updateCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."updateRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."deleteNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."deleteCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."deleteRecords" IS E'Blah...';
COMMENT ON COLUMN TILDA.OBJECTPERF."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.OBJECTPERF."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.OBJECTPERF."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX OBJECTPERF_SchemaByObjectStart ON TILDA.OBJECTPERF ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX OBJECTPERF_SchemaObjectByStart ON TILDA.OBJECTPERF ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.TRANSPERF -- Performance logs for the Tilda framework
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
  , FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
  , FOREIGN KEY ("endPeriodTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.TRANSPERF IS E'Performance logs for the Tilda framework';
COMMENT ON COLUMN TILDA.TRANSPERF."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.TRANSPERF."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.TRANSPERF."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.TRANSPERF."startPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TRANSPERF."endPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''endPeriod''.';
COMMENT ON COLUMN TILDA.TRANSPERF."endPeriod" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TRANSPERF."commitNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TRANSPERF."commitCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TRANSPERF."rollbackNano" IS E'Blah...';
COMMENT ON COLUMN TILDA.TRANSPERF."rollbackCount" IS E'Blah...';
COMMENT ON COLUMN TILDA.TRANSPERF."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TRANSPERF."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.TRANSPERF."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX TRANSPERF_AllBySchemaName ON TILDA.TRANSPERF ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX TRANSPERF_AllByObjectName ON TILDA.TRANSPERF ("schemaName", "objectName", "startPeriod" DESC);



create table if not exists TILDA.TESTING -- blah blah
 (  "refnum"       bigint              not null   -- The primary key for this record
  , "refnum2"      bigint[]            not null   -- The person's primary key
  , "name"         character(10)       not null   -- Medical system unique enterprise id
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
  , "created"      timestamptz         not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz         not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz                    -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
  , FOREIGN KEY ("a9TZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.TESTING IS E'blah blah';
COMMENT ON COLUMN TILDA.TESTING."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.TESTING."refnum2" IS E'The person''s primary key';
COMMENT ON COLUMN TILDA.TESTING."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDA.TESTING."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDA.TESTING."tops" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."tops2" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a1" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a2" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a2b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a2c" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a3" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a3b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a4" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a4b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a5" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a5b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a6" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a6b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a6c" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a7" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a7b" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a8" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDA.TESTING."a9" IS E'The blah';
COMMENT ON COLUMN TILDA.TESTING."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.TESTING."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.TESTING."deleted" IS E'The timestamp for when the record was deleted.';
-- app-level index only -- CREATE INDEX TESTING_AllByName ON TILDA.TESTING ("name" ASC);
CREATE INDEX TESTING_AllByName2 ON TILDA.TESTING ("name" ASC);
CREATE INDEX TESTING_AllByName3 ON TILDA.TESTING ("name" ASC);
delete from TILDA.KEY where "name" = 'TILDA.TESTING';
insert into TILDA.KEY ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.KEY), 'TILDA.TESTING',(select COALESCE(max("refnum"),0)+1 from TILDA.TESTING), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.CONNECTION -- Tilda DB Connections Configurations
 (  "active"       boolean                   -- Status Flag
  , "id"           character(15)  not null   -- Connection ID
  , "driver"       varchar(100)   not null   -- DB Driver
  , "db"           varchar(200)   not null   -- DB Url
  , "user"         varchar(30)    not null   -- DB User
  , "pswd"         varchar(40)    not null   -- DB Password
  , "initial"      integer        not null   -- Minimum Connections
  , "max"          integer        not null   -- Maximum Connections
  , "schemas"      text[]         not null   -- Schemas
  , "created"      timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"  timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"      timestamptz               -- The timestamp for when the record was deleted.
  , PRIMARY KEY("id")
 );
COMMENT ON TABLE TILDA.CONNECTION IS E'Tilda DB Connections Configurations';
COMMENT ON COLUMN TILDA.CONNECTION."active" IS E'Status Flag';
COMMENT ON COLUMN TILDA.CONNECTION."id" IS E'Connection ID';
COMMENT ON COLUMN TILDA.CONNECTION."driver" IS E'DB Driver';
COMMENT ON COLUMN TILDA.CONNECTION."db" IS E'DB Url';
COMMENT ON COLUMN TILDA.CONNECTION."user" IS E'DB User';
COMMENT ON COLUMN TILDA.CONNECTION."pswd" IS E'DB Password';
COMMENT ON COLUMN TILDA.CONNECTION."initial" IS E'Minimum Connections';
COMMENT ON COLUMN TILDA.CONNECTION."max" IS E'Maximum Connections';
COMMENT ON COLUMN TILDA.CONNECTION."schemas" IS E'Schemas';
COMMENT ON COLUMN TILDA.CONNECTION."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.CONNECTION."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.CONNECTION."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX CONNECTION_AllById ON TILDA.CONNECTION ("id" ASC);



create table if not exists TILDA.JOB -- Kettle Jobs
 (  "refnum"         bigint         not null   -- The primary key for this record
  , "name"           varchar(50)               -- Job Name
  , "startTimeTZ"    character(5)              -- Generated helper column to hold the time zone ID for 'startTime'.
  , "startTime"      timestamptz               -- StartTime
  , "endTimeTZ"      character(5)              -- Generated helper column to hold the time zone ID for 'endTime'.
  , "endTime"        timestamptz               -- EndTime
  , "totalRecords"   integer                   -- TotalRecords
  , "status"         varchar(200)              -- Status
  , "error"          varchar(1000)             -- Error
  , "threadsCount"   integer        not null   -- Thread count
  , "isInsert"       boolean        not null   -- Insert or upsert?
  , "truncateTable"  boolean        not null   -- Truncate table
  , "connectionId"   character(15)  not null   -- Connection Details
  , "created"        timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz               -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
  , FOREIGN KEY ("startTimeTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
  , FOREIGN KEY ("endTimeTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.JOB IS E'Kettle Jobs';
COMMENT ON COLUMN TILDA.JOB."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JOB."name" IS E'Job Name';
COMMENT ON COLUMN TILDA.JOB."startTimeTZ" IS E'Generated helper column to hold the time zone ID for ''startTime''.';
COMMENT ON COLUMN TILDA.JOB."startTime" IS E'StartTime';
COMMENT ON COLUMN TILDA.JOB."endTimeTZ" IS E'Generated helper column to hold the time zone ID for ''endTime''.';
COMMENT ON COLUMN TILDA.JOB."endTime" IS E'EndTime';
COMMENT ON COLUMN TILDA.JOB."totalRecords" IS E'TotalRecords';
COMMENT ON COLUMN TILDA.JOB."status" IS E'Status';
COMMENT ON COLUMN TILDA.JOB."error" IS E'Error';
COMMENT ON COLUMN TILDA.JOB."threadsCount" IS E'Thread count';
COMMENT ON COLUMN TILDA.JOB."isInsert" IS E'Insert or upsert?';
COMMENT ON COLUMN TILDA.JOB."truncateTable" IS E'Truncate table';
COMMENT ON COLUMN TILDA.JOB."connectionId" IS E'Connection Details';
COMMENT ON COLUMN TILDA.JOB."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.JOB."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.JOB."deleted" IS E'The timestamp for when the record was deleted.';
delete from TILDA.KEY where "name" = 'TILDA.JOB';
insert into TILDA.KEY ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.KEY), 'TILDA.JOB',(select COALESCE(max("refnum"),0)+1 from TILDA.JOB), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.JOBFILE -- Job File Info
 (  "refnum"                  bigint        not null   -- The primary key for this record
  , "jobRefnum"               bigint        not null   -- Job Foreign key
  , "fileName"                varchar(200)  not null   -- Zip FileName
  , "fileRecords"             integer                  -- Number of records loaded into DB
  , "fileProcessStartTimeTZ"  character(5)             -- Generated helper column to hold the time zone ID for 'fileProcessStartTime'.
  , "fileProcessStartTime"    timestamptz              -- FileProcessStartTime
  , "fileProcessEndTimeTZ"    character(5)             -- Generated helper column to hold the time zone ID for 'fileProcessEndTime'.
  , "fileProcessEndTime"      timestamptz              -- FileProcessEndTime
  , "created"                 timestamptz   not null   -- The timestamp for when the record was created.
  , "lastUpdated"             timestamptz   not null   -- The timestamp for when the record was last updated.
  , "deleted"                 timestamptz              -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
  , FOREIGN KEY ("fileProcessStartTimeTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
  , FOREIGN KEY ("fileProcessEndTimeTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.JOBFILE IS E'Job File Info';
COMMENT ON COLUMN TILDA.JOBFILE."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JOBFILE."jobRefnum" IS E'Job Foreign key';
COMMENT ON COLUMN TILDA.JOBFILE."fileName" IS E'Zip FileName';
COMMENT ON COLUMN TILDA.JOBFILE."fileRecords" IS E'Number of records loaded into DB';
COMMENT ON COLUMN TILDA.JOBFILE."fileProcessStartTimeTZ" IS E'Generated helper column to hold the time zone ID for ''fileProcessStartTime''.';
COMMENT ON COLUMN TILDA.JOBFILE."fileProcessStartTime" IS E'FileProcessStartTime';
COMMENT ON COLUMN TILDA.JOBFILE."fileProcessEndTimeTZ" IS E'Generated helper column to hold the time zone ID for ''fileProcessEndTime''.';
COMMENT ON COLUMN TILDA.JOBFILE."fileProcessEndTime" IS E'FileProcessEndTime';
COMMENT ON COLUMN TILDA.JOBFILE."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.JOBFILE."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.JOBFILE."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX JOBFILE_Job_Refnum ON TILDA.JOBFILE ("jobRefnum");
delete from TILDA.KEY where "name" = 'TILDA.JOBFILE';
insert into TILDA.KEY ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.KEY), 'TILDA.JOBFILE',(select COALESCE(max("refnum"),0)+1 from TILDA.JOBFILE), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.JOB_MESSAGE -- Job Messages
 (  "refnum"         bigint         not null   -- The primary key for this record
  , "jobFileRefnum"  bigint         not null   -- JobFile Foreign key
  , "message"        varchar(1000)  not null   -- Message
  , "isError"        boolean        not null   -- Boolean flag to identify message type -- error or success
  , "created"        timestamptz    not null   -- The timestamp for when the record was created.
  , "lastUpdated"    timestamptz    not null   -- The timestamp for when the record was last updated.
  , "deleted"        timestamptz               -- The timestamp for when the record was deleted.
  , PRIMARY KEY("refnum")
 );
COMMENT ON TABLE TILDA.JOB_MESSAGE IS E'Job Messages';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."jobFileRefnum" IS E'JobFile Foreign key';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."message" IS E'Message';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."isError" IS E'Boolean flag to identify message type -- error or success';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.JOB_MESSAGE."deleted" IS E'The timestamp for when the record was deleted.';
CREATE UNIQUE INDEX JOB_MESSAGE_JobFile_Refnum ON TILDA.JOB_MESSAGE ("refnum", "jobFileRefnum");
delete from TILDA.KEY where "name" = 'TILDA.JOB_MESSAGE';
insert into TILDA.KEY ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.KEY), 'TILDA.JOB_MESSAGE',(select COALESCE(max("refnum"),0)+1 from TILDA.JOB_MESSAGE), 250, current_timestamp, current_timestamp);



create table if not exists TILDA.REFILLPERF -- Performance logs for the Tilda Refills
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
  , FOREIGN KEY ("startPeriodTZ") REFERENCES TILDA.ZONEINFO ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDA.REFILLPERF IS E'Performance logs for the Tilda Refills';
COMMENT ON COLUMN TILDA.REFILLPERF."schemaName" IS E'The name of the schema tracked';
COMMENT ON COLUMN TILDA.REFILLPERF."objectName" IS E'The name of the table/object tracked';
COMMENT ON COLUMN TILDA.REFILLPERF."startPeriodTZ" IS E'Generated helper column to hold the time zone ID for ''startPeriod''.';
COMMENT ON COLUMN TILDA.REFILLPERF."startPeriod" IS E'The timestamp for when the refill started.';
COMMENT ON COLUMN TILDA.REFILLPERF."timeCreateMs" IS E'The time, in milliseconds, the create took.';
COMMENT ON COLUMN TILDA.REFILLPERF."timeIndexMs" IS E'The time, in milliseconds, the indexing took.';
COMMENT ON COLUMN TILDA.REFILLPERF."timeAnalyzeMs" IS E'The time, in milliseconds, the analyze took.';
COMMENT ON COLUMN TILDA.REFILLPERF."timeTotalMs" IS E'The time, in milliseconds, the whole refill took.';
COMMENT ON COLUMN TILDA.REFILLPERF."columnsMs" IS E'The list of columns that were refilled.';
COMMENT ON COLUMN TILDA.REFILLPERF."created" IS E'The timestamp for when the record was created.';
COMMENT ON COLUMN TILDA.REFILLPERF."lastUpdated" IS E'The timestamp for when the record was last updated.';
COMMENT ON COLUMN TILDA.REFILLPERF."deleted" IS E'The timestamp for when the record was deleted.';
CREATE INDEX REFILLPERF_SchemaByObjectStart ON TILDA.REFILLPERF ("schemaName", "objectName" ASC, "startPeriod" DESC);
-- app-level index only -- CREATE INDEX REFILLPERF_SchemaObjectByStart ON TILDA.REFILLPERF ("schemaName", "objectName", "startPeriod" DESC);


