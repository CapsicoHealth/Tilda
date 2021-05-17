
create schema if not exists TILDATEST;



create table if not exists TILDATEST.Test -- The table to keep track tests amd owners
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "id"           varchar(128)  not null   -- The name of the test
  , "name"         varchar(128)  not null   -- The name of the test
  , "test_fk"      bigint        not null   -- The name of the test
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Test)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Test)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.Test)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Test_Test FOREIGN KEY ("test_fk") REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Test IS E'The table to keep track tests amd owners';
COMMENT ON COLUMN TILDATEST.Test."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Test."id" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."name" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."test_fk" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test."created" IS E'The timestamp for when the record was created. (TILDATEST.Test)';
COMMENT ON COLUMN TILDATEST.Test."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Test)';
COMMENT ON COLUMN TILDATEST.Test."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Test)';
CREATE UNIQUE INDEX IF NOT EXISTS Test_Name ON TILDATEST.Test ("name");
delete from TILDA.Key where "name" = 'TILDATEST.TEST';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TEST',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Test), 250, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Test2 -- The table to keep track tests amd owners
 (  "refnum"       bigint        not null   -- The primary key for this record
  , "name"         varchar(128)  not null   -- The name of the test
  , "test_fk"      bigint        not null   -- The name of the test
  , "created"      timestamptz   not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Test2)
  , "lastUpdated"  timestamptz   not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Test2)
  , "deleted"      timestamptz              -- The timestamp for when the record was deleted. (TILDATEST.Test2)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Test2_Test FOREIGN KEY ("test_fk") REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Test2 IS E'The table to keep track tests amd owners';
COMMENT ON COLUMN TILDATEST.Test2."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Test2."name" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test2."test_fk" IS E'The name of the test';
COMMENT ON COLUMN TILDATEST.Test2."created" IS E'The timestamp for when the record was created. (TILDATEST.Test2)';
COMMENT ON COLUMN TILDATEST.Test2."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Test2)';
COMMENT ON COLUMN TILDATEST.Test2."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Test2)';
CREATE UNIQUE INDEX IF NOT EXISTS Test2_Name ON TILDATEST.Test2 ("name");
delete from TILDA.Key where "name" = 'TILDATEST.TEST2';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TEST2',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Test2), 250, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Testing -- blah blah
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
  , "a6dTZ"        character(5)                   -- Generated helper column to hold the time zone ID for 'a6d'.
  , "a6d"          timestamptz                    -- The blah
  , "a7"           integer                        -- The blah
  , "a7b"          integer[]                      -- The blah
  , "a8"           BYTEA                          -- The blah
  , "a8bTZ"        character(5)                   -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"          timestamptz                    -- The blah
  , "a9TZ"         character(5)                   -- Generated helper column to hold the time zone ID for 'a9'.
  , "a9"           timestamptz                  DEFAULT now()   -- The blah
  , "a9a1TZ"       character(5)                   -- Generated helper column to hold the time zone ID for 'a9a1'.
  , "a9a1"         timestamptz                  DEFAULT '1111-11-11T00:00:00Z'   -- The blah
  , "a9bTZ"        text[]                         -- Generated helper column to hold the time zone ID for 'a9b'.
  , "a9b"          timestamptz[]                  -- The blah
  , "a9c"          date                           -- The blah
  , "a9d"          date[]                         -- The blah
  , "a10a"         integer                        -- The blah
  , "a10b"         varchar(10)                    -- The blah
  , "a10c"         integer                        -- The blah
  , "a11"          numeric(8,4)                   -- The blah
  , "a11b"         numeric(6,3)[]                 -- The blah
  , "a11c"         numeric(5,0)                   -- The blah
  , "a12"          smallint                       -- The blah
  , "a12b"         smallint[]                     -- The blah
  , "a13"          UUID                           -- The blah
  , "a13b"         UUID[]                         -- The blah
  , "created"      timestamptz         not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Testing)
  , "lastUpdated"  timestamptz         not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  , "deleted"      timestamptz                    -- The timestamp for when the record was deleted. (TILDATEST.Testing)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Testing_a6d FOREIGN KEY ("a6dTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a8b FOREIGN KEY ("a8bTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a9 FOREIGN KEY ("a9TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_a9a1 FOREIGN KEY ("a9a1TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Testing IS E'blah blah';
COMMENT ON COLUMN TILDATEST.Testing."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing."refnum2" IS E'The person''s primary key';
COMMENT ON COLUMN TILDATEST.Testing."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing."tops" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."tops2" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a2" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a2b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a2c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a3" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a3b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a4" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a4b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a5" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a5b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a6" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a6b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a6c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a6dTZ" IS E'Generated helper column to hold the time zone ID for ''a6d''.';
COMMENT ON COLUMN TILDATEST.Testing."a6d" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a7" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a7b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a8" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDATEST.Testing."a8b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDATEST.Testing."a9" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a9a1TZ" IS E'Generated helper column to hold the time zone ID for ''a9a1''.';
COMMENT ON COLUMN TILDATEST.Testing."a9a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a9bTZ" IS E'Generated helper column to hold the time zone ID for ''a9b''.';
COMMENT ON COLUMN TILDATEST.Testing."a9b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a9c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a9d" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a10a" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a10b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a10c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a11" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a11b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a11c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a12" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a12b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a13" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."a13b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing."created" IS E'The timestamp for when the record was created. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Testing)';
-- app-level index only -- CREATE INDEX IF NOT EXISTS Testing_AllByName ON TILDATEST.Testing ("name" ASC);
CREATE INDEX IF NOT EXISTS Testing_AllByName2 ON TILDATEST.Testing ("name" ASC);
CREATE INDEX IF NOT EXISTS Testing_AllByName3 ON TILDATEST.Testing ("name" DESC);
CREATE INDEX IF NOT EXISTS Testing_AllByName4 ON TILDATEST.Testing ("name" ASC, "description" DESC) where TILDATEST.Testing."deleted" is null and TILDATEST.Testing."name" = 'Hello' and TILDATEST.Testing."created" > '2018-01-01';
delete from TILDA.Key where "name" = 'TILDATEST.TESTING';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TESTING',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Testing), 25000, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Testing_Cloned -- blah blah - Ready for publishing (cloned from TILDATEST.Testing)
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
  , "a6dTZ"        character(5)                   -- Generated helper column to hold the time zone ID for 'a6d'.
  , "a6d"          timestamptz                    -- The blah
  , "a7"           integer                        -- The blah
  , "a7b"          integer[]                      -- The blah
  , "a8"           BYTEA                          -- The blah
  , "a8bTZ"        character(5)                   -- Generated helper column to hold the time zone ID for 'a8b'.
  , "a8b"          timestamptz                    -- The blah
  , "a9TZ"         character(5)                   -- Generated helper column to hold the time zone ID for 'a9'.
  , "a9"           timestamptz                  DEFAULT now()   -- The blah
  , "a9a1TZ"       character(5)                   -- Generated helper column to hold the time zone ID for 'a9a1'.
  , "a9a1"         timestamptz                  DEFAULT '1111-11-11T00:00:00Z'   -- The blah
  , "a9bTZ"        text[]                         -- Generated helper column to hold the time zone ID for 'a9b'.
  , "a9b"          timestamptz[]                  -- The blah
  , "a9c"          date                           -- The blah
  , "a9d"          date[]                         -- The blah
  , "a10a"         integer                        -- The blah
  , "a10b"         varchar(10)                    -- The blah
  , "a10c"         integer                        -- The blah
  , "a11"          numeric(8,4)                   -- The blah
  , "a11b"         numeric(6,3)[]                 -- The blah
  , "a11c"         numeric(5,0)                   -- The blah
  , "a12"          smallint                       -- The blah
  , "a12b"         smallint[]                     -- The blah
  , "a13"          UUID                           -- The blah
  , "a13b"         UUID[]                         -- The blah
  , "created"      timestamptz         not null DEFAULT now()   -- The timestamp for when the record was created. (TILDATEST.Testing_Cloned)
  , "lastUpdated"  timestamptz         not null DEFAULT now()   -- The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)
  , "deleted"      timestamptz                    -- The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)
  , PRIMARY KEY("refnum")
  , CONSTRAINT fk_Testing_Cloned_a6d FOREIGN KEY ("a6dTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_Cloned_a8b FOREIGN KEY ("a8bTZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_Cloned_a9 FOREIGN KEY ("a9TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  , CONSTRAINT fk_Testing_Cloned_a9a1 FOREIGN KEY ("a9a1TZ") REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 );
COMMENT ON TABLE TILDATEST.Testing_Cloned IS E'blah blah - Ready for publishing (cloned from TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."refnum2" IS E'The person''s primary key';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."tops" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."tops2" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a2" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a2b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a2c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a3" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a3b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a4" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a4b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a5" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a5b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a6" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a6b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a6c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a6dTZ" IS E'Generated helper column to hold the time zone ID for ''a6d''.';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a6d" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a7" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a7b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a8" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a8b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9a1TZ" IS E'Generated helper column to hold the time zone ID for ''a9a1''.';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9bTZ" IS E'Generated helper column to hold the time zone ID for ''a9b''.';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a9d" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a10a" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a10b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a10c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a11" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a11b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a11c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a12" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a12b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a13" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."a13b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."created" IS E'The timestamp for when the record was created. (TILDATEST.Testing_Cloned)';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)';
COMMENT ON COLUMN TILDATEST.Testing_Cloned."deleted" IS E'The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)';
-- app-level index only -- CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName ON TILDATEST.Testing_Cloned ("name" ASC);
CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName2 ON TILDATEST.Testing_Cloned ("name" ASC);
CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName3 ON TILDATEST.Testing_Cloned ("name" DESC);
CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName4 ON TILDATEST.Testing_Cloned ("name" ASC, "description" DESC) where TILDATEST.Testing_Cloned."deleted" is null and TILDATEST.Testing_Cloned."name" = 'Hello' and TILDATEST.Testing_Cloned."created" > '2018-01-01';
delete from TILDA.Key where "name" = 'TILDATEST.TESTING_CLONED';
insert into TILDA.Key ("refnum", "name", "max", "count", "created", "lastUpdated") values ((select COALESCE(max("refnum"),0)+1 from TILDA.Key), 'TILDATEST.TESTING_CLONED',(select COALESCE(max("refnum"),0)+1 from TILDATEST.Testing_Cloned), 25000, current_timestamp, current_timestamp);



create table if not exists TILDATEST.Testing2Realized -- Realized table for view TILDATEST.Testing2View: A test view to test .* and exclude and block.
 (  "refnum"          bigint                         -- The primary key for this record (from TILDATEST.Testing2View.refnum)
  , "name"            varchar(10)                    -- Medical system unique enterprise id (from TILDATEST.Testing2View.name)
  , "lastUpdated"     timestamptz                    -- The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.lastUpdated)
  , "xxxLastUpdated"  timestamptz                    -- The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.xxxLastUpdated)
  , "a1"              INTEGER                        -- The blah (from TILDATEST.Testing2View.a1)
  , "a3b"             boolean[]                      -- The blah (from TILDATEST.Testing2View.a3b)
  , "a4"              double precision               -- The blah (from TILDATEST.Testing2View.a4)
  , "a4b"             double precision[]             -- The blah (from TILDATEST.Testing2View.a4b)
  , "a5"              real                           -- The blah (from TILDATEST.Testing2View.a5)
  , "a5b"             real[]                         -- The blah (from TILDATEST.Testing2View.a5b)
  , "a7"              integer                        -- The blah (from TILDATEST.Testing2View.a7)
  , "a7b"             integer[]                      -- The blah (from TILDATEST.Testing2View.a7b)
  , "a8"              BYTEA                          -- The blah (from TILDATEST.Testing2View.a8)
  , "a8bTZ"           varchar(10)                    -- Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing2View.a8bTZ)
  , "a8b"             timestamptz                    -- The blah (from TILDATEST.Testing2View.a8b)
  , "a10a"            integer                        -- The blah (from TILDATEST.Testing2View.a10a)
  , "a10b"            varchar(10)                    -- The blah (from TILDATEST.Testing2View.a10b)
  , "a10c"            integer                        -- The blah (from TILDATEST.Testing2View.a10c)
  , "a11"             numeric(8,4)                   -- The blah (from TILDATEST.Testing2View.a11)
  , "a11b"            numeric(6,3)[]                 -- The blah (from TILDATEST.Testing2View.a11b)
  , "a11c"            numeric(5,0)                   -- The blah (from TILDATEST.Testing2View.a11c)
  , "a12"             smallint                       -- The blah (from TILDATEST.Testing2View.a12)
  , "a12b"            smallint[]                     -- The blah (from TILDATEST.Testing2View.a12b)
  , "a13"             UUID                           -- The blah (from TILDATEST.Testing2View.a13)
  , "a13b"            UUID[]                         -- The blah (from TILDATEST.Testing2View.a13b)
  , "description"     varchar(250)                   -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.description)
  , "desc2"           varchar(3000)                  -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc2)
  , "desc3"           text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc3)
  , "desc4"           text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc4)
  , "desc5"           text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc5)
  , "desc6"           text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc6)
  , "a3"              boolean                        -- Formula column '<B>Not A3</B>' (from TILDATEST.Testing2View.a3)
  , "bastille"        timestamptz                    -- Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing2View.bastille)
  , "toto"            timestamptz                    -- Formula column '<B>Last Updated</B>' (from TILDATEST.Testing2View.toto)
  , "desc2_Cat1"      double precision               -- Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing2View.desc2_Cat1)
  , "desc2_Cat2"      double precision               -- Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing2View.desc2_Cat2)
  , "desc2_Cat3"      double precision               -- Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing2View.desc2_Cat3)
  , "a7_Cat4"         double precision               -- Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing2View.a7_Cat4)
  , "a7_Cat5"         double precision               -- Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing2View.a7_Cat5)
  , "a5_null"         integer                        -- Formula column '<B>Null a5</B>' (from TILDATEST.Testing2View.a5_null)
  , "a6_null"         integer                        -- Formula column '<B>Null a6</B>' (from TILDATEST.Testing2View.a6_null)
  , "a7_null"         integer                        -- Formula column '<B>Null a7</B>' (from TILDATEST.Testing2View.a7_null)
  , "a8_null"         integer                        -- Formula column '<B>Null a8</B>' (from TILDATEST.Testing2View.a8_null)
 );
COMMENT ON TABLE TILDATEST.Testing2Realized IS E'Realized table for view TILDATEST.Testing2View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."refnum" IS E'The primary key for this record (from TILDATEST.Testing2View.refnum)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."name" IS E'Medical system unique enterprise id (from TILDATEST.Testing2View.name)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.lastUpdated)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.xxxLastUpdated)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a1" IS E'The blah (from TILDATEST.Testing2View.a1)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a3b" IS E'The blah (from TILDATEST.Testing2View.a3b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a4" IS E'The blah (from TILDATEST.Testing2View.a4)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a4b" IS E'The blah (from TILDATEST.Testing2View.a4b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a5" IS E'The blah (from TILDATEST.Testing2View.a5)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a5b" IS E'The blah (from TILDATEST.Testing2View.a5b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7" IS E'The blah (from TILDATEST.Testing2View.a7)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7b" IS E'The blah (from TILDATEST.Testing2View.a7b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a8" IS E'The blah (from TILDATEST.Testing2View.a8)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''. (from TILDATEST.Testing2View.a8bTZ)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a8b" IS E'The blah (from TILDATEST.Testing2View.a8b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a10a" IS E'The blah (from TILDATEST.Testing2View.a10a)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a10b" IS E'The blah (from TILDATEST.Testing2View.a10b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a10c" IS E'The blah (from TILDATEST.Testing2View.a10c)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a11" IS E'The blah (from TILDATEST.Testing2View.a11)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a11b" IS E'The blah (from TILDATEST.Testing2View.a11b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a11c" IS E'The blah (from TILDATEST.Testing2View.a11c)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a12" IS E'The blah (from TILDATEST.Testing2View.a12)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a12b" IS E'The blah (from TILDATEST.Testing2View.a12b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a13" IS E'The blah (from TILDATEST.Testing2View.a13)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a13b" IS E'The blah (from TILDATEST.Testing2View.a13b)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.description)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc2)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc3)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc4)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc5)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc6)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a3" IS E'Formula column ''<B>Not A3</B>'' (from TILDATEST.Testing2View.a3)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."bastille" IS E'Formula column ''<B>Bastille Day</B>'' (from TILDATEST.Testing2View.bastille)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."toto" IS E'Formula column ''<B>Last Updated</B>'' (from TILDATEST.Testing2View.toto)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>'' (from TILDATEST.Testing2View.desc2_Cat1)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>'' (from TILDATEST.Testing2View.desc2_Cat2)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>'' (from TILDATEST.Testing2View.desc2_Cat3)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>'' (from TILDATEST.Testing2View.a7_Cat4)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>'' (from TILDATEST.Testing2View.a7_Cat5)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a5_null" IS E'Formula column ''<B>Null a5</B>'' (from TILDATEST.Testing2View.a5_null)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a6_null" IS E'Formula column ''<B>Null a6</B>'' (from TILDATEST.Testing2View.a6_null)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_null" IS E'Formula column ''<B>Null a7</B>'' (from TILDATEST.Testing2View.a7_null)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a8_null" IS E'Formula column ''<B>Null a8</B>'' (from TILDATEST.Testing2View.a8_null)';
CREATE UNIQUE INDEX IF NOT EXISTS Testing2Realized_Refnum ON TILDATEST.Testing2Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing2Realized_LastUpdated ON TILDATEST.Testing2Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing3Realized -- Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.
 (  "refnum"          bigint                  -- The primary key for this record (from TILDATEST.Testing3View.refnum)
  , "name"            varchar(10)             -- Medical system unique enterprise id (from TILDATEST.Testing3View.name)
  , "a8bTZ"           varchar(10)             -- Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing3View.a8bTZ)
  , "a8b"             timestamptz             -- The blah (from TILDATEST.Testing3View.a8b)
  , "lastUpdated"     timestamptz             -- The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing3View.lastUpdated)
  , "xxxLastUpdated"  timestamptz             -- The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing3View.xxxLastUpdated)
 );
COMMENT ON TABLE TILDATEST.Testing3Realized IS E'Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing3Realized."refnum" IS E'The primary key for this record (from TILDATEST.Testing3View.refnum)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."name" IS E'Medical system unique enterprise id (from TILDATEST.Testing3View.name)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''. (from TILDATEST.Testing3View.a8bTZ)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."a8b" IS E'The blah (from TILDATEST.Testing3View.a8b)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing3View.lastUpdated)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing3View.xxxLastUpdated)';
CREATE UNIQUE INDEX IF NOT EXISTS Testing3Realized_Refnum ON TILDATEST.Testing3Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing3Realized_LastUpdated ON TILDATEST.Testing3Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing4Realized -- Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.
 (  "refnum"       bigint                         -- The primary key for this record (from TILDATEST.Testing4View.refnum)
  , "name"         varchar(10)                    -- Medical system unique enterprise id (from TILDATEST.Testing4View.name)
  , "a1"           INTEGER                        -- The blah (from TILDATEST.Testing4View.a1)
  , "a3b"          boolean[]                      -- The blah (from TILDATEST.Testing4View.a3b)
  , "a4"           double precision               -- The blah (from TILDATEST.Testing4View.a4)
  , "a4b"          double precision[]             -- The blah (from TILDATEST.Testing4View.a4b)
  , "a5"           real                           -- The blah (from TILDATEST.Testing4View.a5)
  , "a5b"          real[]                         -- The blah (from TILDATEST.Testing4View.a5b)
  , "a7"           integer                        -- The blah (from TILDATEST.Testing4View.a7)
  , "a7b"          integer[]                      -- The blah (from TILDATEST.Testing4View.a7b)
  , "a8"           BYTEA                          -- The blah (from TILDATEST.Testing4View.a8)
  , "a8bTZ"        varchar(10)                    -- Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)
  , "a8b"          timestamptz                    -- The blah (from TILDATEST.Testing4View.a8b)
  , "a10a"         integer                        -- The blah (from TILDATEST.Testing4View.a10a)
  , "a10b"         varchar(10)                    -- The blah (from TILDATEST.Testing4View.a10b)
  , "a10c"         integer                        -- The blah (from TILDATEST.Testing4View.a10c)
  , "a11"          numeric(8,4)                   -- The blah (from TILDATEST.Testing4View.a11)
  , "a11b"         numeric(6,3)[]                 -- The blah (from TILDATEST.Testing4View.a11b)
  , "a11c"         numeric(5,0)                   -- The blah (from TILDATEST.Testing4View.a11c)
  , "a12"          smallint                       -- The blah (from TILDATEST.Testing4View.a12)
  , "a12b"         smallint[]                     -- The blah (from TILDATEST.Testing4View.a12b)
  , "a13"          UUID                           -- The blah (from TILDATEST.Testing4View.a13)
  , "a13b"         UUID[]                         -- The blah (from TILDATEST.Testing4View.a13b)
  , "description"  varchar(250)                   -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)
  , "desc2"        varchar(3000)                  -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)
  , "desc3"        text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)
  , "desc4"        text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)
  , "desc5"        text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)
  , "desc6"        text                           -- The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)
  , "bastille"     timestamptz                    -- Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)
  , "toto"         timestamptz                    -- Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)
  , "desc2_Cat1"   double precision               -- Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)
  , "desc2_Cat2"   double precision               -- Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)
  , "desc2_Cat3"   double precision               -- Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)
  , "a7_Cat4"      double precision               -- Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)
  , "a7_Cat5"      double precision               -- Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)
  , "a5_null"      integer                        -- Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)
  , "a6_null"      integer                        -- Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)
  , "a7_null"      integer                        -- Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)
  , "a8_null"      integer                        -- Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)
  , "a3"           boolean                        -- Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)
  , "lastUpdated"  timestamptz                    -- Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)
 );
COMMENT ON TABLE TILDATEST.Testing4Realized IS E'Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."refnum" IS E'The primary key for this record (from TILDATEST.Testing4View.refnum)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."name" IS E'Medical system unique enterprise id (from TILDATEST.Testing4View.name)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a1" IS E'The blah (from TILDATEST.Testing4View.a1)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a3b" IS E'The blah (from TILDATEST.Testing4View.a3b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a4" IS E'The blah (from TILDATEST.Testing4View.a4)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a4b" IS E'The blah (from TILDATEST.Testing4View.a4b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a5" IS E'The blah (from TILDATEST.Testing4View.a5)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a5b" IS E'The blah (from TILDATEST.Testing4View.a5b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7" IS E'The blah (from TILDATEST.Testing4View.a7)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7b" IS E'The blah (from TILDATEST.Testing4View.a7b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a8" IS E'The blah (from TILDATEST.Testing4View.a8)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''. (from TILDATEST.Testing4View.a8bTZ)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a8b" IS E'The blah (from TILDATEST.Testing4View.a8b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a10a" IS E'The blah (from TILDATEST.Testing4View.a10a)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a10b" IS E'The blah (from TILDATEST.Testing4View.a10b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a10c" IS E'The blah (from TILDATEST.Testing4View.a10c)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a11" IS E'The blah (from TILDATEST.Testing4View.a11)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a11b" IS E'The blah (from TILDATEST.Testing4View.a11b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a11c" IS E'The blah (from TILDATEST.Testing4View.a11c)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a12" IS E'The blah (from TILDATEST.Testing4View.a12)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a12b" IS E'The blah (from TILDATEST.Testing4View.a12b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a13" IS E'The blah (from TILDATEST.Testing4View.a13)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a13b" IS E'The blah (from TILDATEST.Testing4View.a13b)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."bastille" IS E'Formula column ''<B>Bastille Day</B>'' (from TILDATEST.Testing4View.bastille)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."toto" IS E'Formula column ''<B>Last Updated</B>'' (from TILDATEST.Testing4View.toto)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>'' (from TILDATEST.Testing4View.desc2_Cat1)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>'' (from TILDATEST.Testing4View.desc2_Cat2)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>'' (from TILDATEST.Testing4View.desc2_Cat3)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>'' (from TILDATEST.Testing4View.a7_Cat4)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>'' (from TILDATEST.Testing4View.a7_Cat5)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a5_null" IS E'Formula column ''<B>Null a5</B>'' (from TILDATEST.Testing4View.a5_null)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a6_null" IS E'Formula column ''<B>Null a6</B>'' (from TILDATEST.Testing4View.a6_null)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_null" IS E'Formula column ''<B>Null a7</B>'' (from TILDATEST.Testing4View.a7_null)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a8_null" IS E'Formula column ''<B>Null a8</B>'' (from TILDATEST.Testing4View.a8_null)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a3" IS E'Formula column ''<B>Always True</B>'' (from TILDATEST.Testing4View.a3)';
COMMENT ON COLUMN TILDATEST.Testing4Realized."lastUpdated" IS E'Formula column ''<B>Always True</B>'' (from TILDATEST.Testing4View.lastUpdated)';
CREATE UNIQUE INDEX IF NOT EXISTS Testing4Realized_Refnum ON TILDATEST.Testing4Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing4Realized_LastUpdated ON TILDATEST.Testing4Realized ("lastUpdated" DESC);




-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATEST.TestView as 
-- 'A join of test and user'
select TILDATEST.Test."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Test."name" as "name" -- The name of the test
  from TILDATEST.Test
 where (TILDATEST.Test."deleted" is null)
;


COMMENT ON VIEW TILDATEST.TestView IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATEST.TestView as \n-- ''A join of test and user''\nselect TILDATEST.Test."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Test."name" as "name" -- The name of the test\n  from TILDATEST.Test\n where (TILDATEST.Test."deleted" is null)\n;\n\n';

COMMENT ON COLUMN TILDATEST.TestView."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.TestView."name" IS E'The name of the test';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.TestView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATEST.TestingView as 
-- 'A test view to test aggregates.'
select TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id
     , count(TILDATEST.Testing."refnum") as "refnum" -- The primary key for this record
     , min(coalesce(TILDATEST.Testing."a2", 'AAA')) filter(where a2 is not null) as "a2Min" -- The blah
     , max(coalesce(TILDATEST.Testing."a2", 'ZZZ')) filter(where a2 is not null) as "a2Max" -- The blah
     , array_agg(trim(TILDATEST.Testing."a9TZ") order by TILDATEST.Testing."lastUpdated" ASC) as "a9TZ" -- Generated helper column to hold the time zone ID for 'a9'.
     , array_agg(TILDATEST.Testing."a9" order by TILDATEST.Testing."lastUpdated" ASC) as "a9" -- The blah
     , array_agg(TILDATEST.Testing."a9c") as "a9c" -- The blah
     , first(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6First" -- The blah
     , last(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6Last" -- The blah
  from TILDATEST.Testing
 where (TILDATEST.Testing."deleted" is null)
     group by 1
;


COMMENT ON VIEW TILDATEST.TestingView IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATEST.TestingView as \n-- ''A test view to test aggregates.''\nselect TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id\n     , count(TILDATEST.Testing."refnum") as "refnum" -- The primary key for this record\n     , min(coalesce(TILDATEST.Testing."a2", ''AAA'')) filter(where a2 is not null) as "a2Min" -- The blah\n     , max(coalesce(TILDATEST.Testing."a2", ''ZZZ'')) filter(where a2 is not null) as "a2Max" -- The blah\n     , array_agg(trim(TILDATEST.Testing."a9TZ") order by TILDATEST.Testing."lastUpdated" ASC) as "a9TZ" -- Generated helper column to hold the time zone ID for ''a9''.\n     , array_agg(TILDATEST.Testing."a9" order by TILDATEST.Testing."lastUpdated" ASC) as "a9" -- The blah\n     , array_agg(TILDATEST.Testing."a9c") as "a9c" -- The blah\n     , first(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6First" -- The blah\n     , last(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6Last" -- The blah\n  from TILDATEST.Testing\n where (TILDATEST.Testing."deleted" is null)\n     group by 1\n;\n\n';

COMMENT ON COLUMN TILDATEST.TestingView."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.TestingView."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.TestingView."a2Min" IS E'The blah';
COMMENT ON COLUMN TILDATEST.TestingView."a2Max" IS E'The blah';
COMMENT ON COLUMN TILDATEST.TestingView."a9TZ" IS E'Generated helper column to hold the time zone ID for ''a9''.';
COMMENT ON COLUMN TILDATEST.TestingView."a9" IS E'The blah';
COMMENT ON COLUMN TILDATEST.TestingView."a9c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.TestingView."a6First" IS E'The blah';
COMMENT ON COLUMN TILDATEST.TestingView."a6Last" IS E'The blah';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.TestingView' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATEST.Testing2View as 
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
     , "a10a" -- COLUMN
     , "a10b" -- COLUMN
     , "a10c" -- COLUMN
     , "a11" -- COLUMN
     , "a11b" -- COLUMN
     , "a11c" -- COLUMN
     , "a12" -- COLUMN
     , "a12b" -- COLUMN
     , "a13" -- COLUMN
     , "a13b" -- COLUMN
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
     -- This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
     , (case when "desc2"  in ('a', 'b', 'c') then 1 else 0 end)::double precision as "desc2_Cat1"
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , (case when "desc2"  in ('x', 'y', 'z') then 1 else 0 end)::double precision as "desc2_Cat2"
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , (case when "desc2"  in ('x', 'y', 'z') then 1 else 0 end)::double precision as "desc2_Cat3"
     -- This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
     , (case when coalesce("a7", 0) >= 0.0 and coalesce("a7", 0) < 10.0 then 1 else 0 end)::double precision as "a7_Cat4"
     -- This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
     , (case when coalesce("a7", 0) >= 10.0 and coalesce("a7", 0) < 20.0 then 1 else 0 end)::double precision as "a7_Cat5"
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
select TILDATEST.Testing."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing."a1" as "a1" -- The blah
     , TILDATEST.Testing."a3" as "a3" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a3b" as "a3b" -- The blah
     , TILDATEST.Testing."a4" as "a4" -- The blah
     , TILDATEST.Testing."a4b" as "a4b" -- The blah
     , TILDATEST.Testing."a5" as "a5" -- The blah
     , TILDATEST.Testing."a5b" as "a5b" -- The blah
     , TILDATEST.Testing."a6" as "a6" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a6b" as "a6b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a6c" as "a6c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , trim(TILDATEST.Testing."a6dTZ") as "a6dTZ" -- Generated helper column to hold the time zone ID for 'a6d'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a6d" as "a6d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a7" as "a7" -- The blah
     , TILDATEST.Testing."a7b" as "a7b" -- The blah
     , TILDATEST.Testing."a8" as "a8" -- The blah
     , trim(TILDATEST.Testing."a8bTZ") as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDATEST.Testing."a8b" as "a8b" -- The blah
     , trim(TILDATEST.Testing."a9TZ") as "a9TZ" -- Generated helper column to hold the time zone ID for 'a9'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9" as "a9" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , trim(TILDATEST.Testing."a9a1TZ") as "a9a1TZ" -- Generated helper column to hold the time zone ID for 'a9a1'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9a1" as "a9a1" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9bTZ" as "a9bTZ" -- Generated helper column to hold the time zone ID for 'a9b'. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9b" as "a9b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9c" as "a9c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a9d" as "a9d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing."a10a" as "a10a" -- The blah
     , TILDATEST.Testing."a10b" as "a10b" -- The blah
     , TILDATEST.Testing."a10c" as "a10c" -- The blah
     , TILDATEST.Testing."a11" as "a11" -- The blah
     , TILDATEST.Testing."a11b" as "a11b" -- The blah
     , TILDATEST.Testing."a11c" as "a11c" -- The blah
     , TILDATEST.Testing."a12" as "a12" -- The blah
     , TILDATEST.Testing."a12b" as "a12b" -- The blah
     , TILDATEST.Testing."a13" as "a13" -- The blah
     , TILDATEST.Testing."a13b" as "a13b" -- The blah
     , TILDATEST.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
  from TILDATEST.Testing
 where (TILDATEST.Testing."deleted" is null)

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"a1" -- COLUMN -- "a3" -- BLOCKED ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN -- "a6" -- BLOCKED -- "a6b" -- BLOCKED -- "a6c" -- BLOCKED -- "a6dTZ" -- BLOCKED -- "a6d" -- BLOCKED ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN -- "a9TZ" -- BLOCKED -- "a9" -- BLOCKED -- "a9a1TZ" -- BLOCKED -- "a9a1" -- BLOCKED -- "a9bTZ" -- BLOCKED -- "a9b" -- BLOCKED -- "a9c" -- BLOCKED -- "a9d" -- BLOCKED ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA ,"a8_null" -- FORMULA
;


DROP FUNCTION IF EXISTS TILDATEST.Refill_Testing2Realized();
CREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing2Realized()
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
  TRUNCATE TILDATEST.Testing2Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10a", "a10b", "a10c", "a11", "a11b", "a11c", "a12", "a12b", "a13", "a13b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null")
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
          ,"a10a" -- COLUMN
          ,"a10b" -- COLUMN
          ,"a10c" -- COLUMN
          ,"a11" -- COLUMN
          ,"a11b" -- COLUMN
          ,"a11c" -- COLUMN
          ,"a12" -- COLUMN
          ,"a12b" -- COLUMN
          ,"a13" -- COLUMN
          ,"a13b" -- COLUMN
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
     FROM TILDATEST.Testing2View;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing2Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing2Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing2View IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATEST.Testing2View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n     , "lastUpdated" -- COLUMN\n     , "xxxLastUpdated" -- COLUMN\n     , "a1" -- COLUMN\n--     "a3"  BLOCKED\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n--     "a6"  BLOCKED\n--     "a6b"  BLOCKED\n--     "a6c"  BLOCKED\n--     "a6dTZ"  BLOCKED\n--     "a6d"  BLOCKED\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n--     "a9TZ"  BLOCKED\n--     "a9"  BLOCKED\n--     "a9a1TZ"  BLOCKED\n--     "a9a1"  BLOCKED\n--     "a9bTZ"  BLOCKED\n--     "a9b"  BLOCKED\n--     "a9c"  BLOCKED\n--     "a9d"  BLOCKED\n     , "a10a" -- COLUMN\n     , "a10b" -- COLUMN\n     , "a10c" -- COLUMN\n     , "a11" -- COLUMN\n     , "a11b" -- COLUMN\n     , "a11c" -- COLUMN\n     , "a12" -- COLUMN\n     , "a12b" -- COLUMN\n     , "a13" -- COLUMN\n     , "a13b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n     -- Blah...\n     , (NOT "a3")::boolean as "a3"\n     -- Blah...\n     , (''1789-07-14'')::timestamptz as "bastille"\n     -- Blah...\n     , (''2018-08-10'')::timestamptz as "toto"\n     -- This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''a'', ''b'', ''c'') then 1 else 0 end)::double precision as "desc2_Cat1"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double precision as "desc2_Cat2"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double precision as "desc2_Cat3"\n     -- This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.\n     , (case when coalesce("a7", 0) >= 0.0 and coalesce("a7", 0) < 10.0 then 1 else 0 end)::double precision as "a7_Cat4"\n     -- This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.\n     , (case when coalesce("a7", 0) >= 10.0 and coalesce("a7", 0) < 20.0 then 1 else 0 end)::double precision as "a7_Cat5"\n     -- Whether a5 is null or not\n     , (case when "a5" is null then 1 when "a5" is not null then 0 end)::integer as "a5_null"\n     -- Whether a6 is null or not\n     , (case when "a6" is null then 1 when "a6" is not null then 0 end)::integer as "a6_null"\n     -- Whether a7 is null or not\n     , (case when "a7" is null then 1 when "a7" is not null then 0 end)::integer as "a7_null"\n     -- Whether a8 is null or not\n     , (case when "a8" is null then 1 when "a8" is not null then 0 end)::integer as "a8_null"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing."a1" as "a1" -- The blah\n     , TILDATEST.Testing."a3" as "a3" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a3b" as "a3b" -- The blah\n     , TILDATEST.Testing."a4" as "a4" -- The blah\n     , TILDATEST.Testing."a4b" as "a4b" -- The blah\n     , TILDATEST.Testing."a5" as "a5" -- The blah\n     , TILDATEST.Testing."a5b" as "a5b" -- The blah\n     , TILDATEST.Testing."a6" as "a6" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a6b" as "a6b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a6c" as "a6c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , trim(TILDATEST.Testing."a6dTZ") as "a6dTZ" -- Generated helper column to hold the time zone ID for ''a6d''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a6d" as "a6d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a7" as "a7" -- The blah\n     , TILDATEST.Testing."a7b" as "a7b" -- The blah\n     , TILDATEST.Testing."a8" as "a8" -- The blah\n     , trim(TILDATEST.Testing."a8bTZ") as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDATEST.Testing."a8b" as "a8b" -- The blah\n     , trim(TILDATEST.Testing."a9TZ") as "a9TZ" -- Generated helper column to hold the time zone ID for ''a9''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9" as "a9" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , trim(TILDATEST.Testing."a9a1TZ") as "a9a1TZ" -- Generated helper column to hold the time zone ID for ''a9a1''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9a1" as "a9a1" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9bTZ" as "a9bTZ" -- Generated helper column to hold the time zone ID for ''a9b''. -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9b" as "a9b" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9c" as "a9c" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a9d" as "a9d" -- The blah -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing."a10a" as "a10a" -- The blah\n     , TILDATEST.Testing."a10b" as "a10b" -- The blah\n     , TILDATEST.Testing."a10c" as "a10c" -- The blah\n     , TILDATEST.Testing."a11" as "a11" -- The blah\n     , TILDATEST.Testing."a11b" as "a11b" -- The blah\n     , TILDATEST.Testing."a11c" as "a11c" -- The blah\n     , TILDATEST.Testing."a12" as "a12" -- The blah\n     , TILDATEST.Testing."a12b" as "a12b" -- The blah\n     , TILDATEST.Testing."a13" as "a13" -- The blah\n     , TILDATEST.Testing."a13b" as "a13b" -- The blah\n     , TILDATEST.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n  from TILDATEST.Testing\n where (TILDATEST.Testing."deleted" is null)\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"a1" -- COLUMN -- "a3" -- BLOCKED ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN -- "a6" -- BLOCKED -- "a6b" -- BLOCKED -- "a6c" -- BLOCKED -- "a6dTZ" -- BLOCKED -- "a6d" -- BLOCKED ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN -- "a9TZ" -- BLOCKED -- "a9" -- BLOCKED -- "a9a1TZ" -- BLOCKED -- "a9a1" -- BLOCKED -- "a9bTZ" -- BLOCKED -- "a9b" -- BLOCKED -- "a9c" -- BLOCKED -- "a9d" -- BLOCKED ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA ,"a8_null" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing2Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing2Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing2Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10a", "a10b", "a10c", "a11", "a11b", "a11c", "a12", "a12b", "a13", "a13b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n          -- "created" -- VIEW-EXCLUDED\n          ,"a1" -- COLUMN\n          -- "a3" -- BLOCKED\n          ,"a3b" -- COLUMN\n          ,"a4" -- COLUMN\n          ,"a4b" -- COLUMN\n          ,"a5" -- COLUMN\n          ,"a5b" -- COLUMN\n          -- "a6" -- BLOCKED\n          -- "a6b" -- BLOCKED\n          -- "a6c" -- BLOCKED\n          -- "a6dTZ" -- BLOCKED\n          -- "a6d" -- BLOCKED\n          ,"a7" -- COLUMN\n          ,"a7b" -- COLUMN\n          ,"a8" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          -- "a9TZ" -- BLOCKED\n          -- "a9" -- BLOCKED\n          -- "a9a1TZ" -- BLOCKED\n          -- "a9a1" -- BLOCKED\n          -- "a9bTZ" -- BLOCKED\n          -- "a9b" -- BLOCKED\n          -- "a9c" -- BLOCKED\n          -- "a9d" -- BLOCKED\n          ,"a10a" -- COLUMN\n          ,"a10b" -- COLUMN\n          ,"a10c" -- COLUMN\n          ,"a11" -- COLUMN\n          ,"a11b" -- COLUMN\n          ,"a11c" -- COLUMN\n          ,"a12" -- COLUMN\n          ,"a12b" -- COLUMN\n          ,"a13" -- COLUMN\n          ,"a13b" -- COLUMN\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"bastille" -- FORMULA\n          ,"toto" -- FORMULA\n          ,"desc2_Cat1" -- FORMULA\n          ,"desc2_Cat2" -- FORMULA\n          ,"desc2_Cat3" -- FORMULA\n          ,"a7_Cat4" -- FORMULA\n          ,"a7_Cat5" -- FORMULA\n          ,"a5_null" -- FORMULA\n          ,"a6_null" -- FORMULA\n          ,"a7_null" -- FORMULA\n          ,"a8_null" -- FORMULA\n     FROM TILDATEST.Testing2View;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing2Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing2Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing2View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing2View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing2View."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing2View."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing2View."a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a3b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a4" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a4b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a5" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a5b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a7" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a7b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a8" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDATEST.Testing2View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a10a" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a10b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a10c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a11" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a11b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a11c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a12" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a12b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a13" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."a13b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing2View."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2View."a3" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2View."bastille" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2View."toto" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2View."desc2_Cat1" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2View."desc2_Cat2" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2View."desc2_Cat3" IS E'The calculated formula: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2View."a7_Cat4" IS E'The calculated formula: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.';
COMMENT ON COLUMN TILDATEST.Testing2View."a7_Cat5" IS E'The calculated formula: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.';
COMMENT ON COLUMN TILDATEST.Testing2View."a5_null" IS E'The calculated formula: Whether a5 is null or not';
COMMENT ON COLUMN TILDATEST.Testing2View."a6_null" IS E'The calculated formula: Whether a6 is null or not';
COMMENT ON COLUMN TILDATEST.Testing2View."a7_null" IS E'The calculated formula: Whether a7 is null or not';
COMMENT ON COLUMN TILDATEST.Testing2View."a8_null" IS E'The calculated formula: Whether a8 is null or not';

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 12)-12;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a3', 'BOL', 'Not A3', 'Blah...', 'NOT a3', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a3'], current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'bastille', 'DTM', 'Bastille Day', 'Blah...', '''1789-07-14''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+2, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'toto', 'DTM', 'Last Updated', 'Blah...', '''2018-08-10''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+3, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat1', 'DBL', 'desc2_Cat1 Title', 'This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''a'', ''b'', ''c'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+4, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat2', 'DBL', 'desc2_Cat2 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+5, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat3', 'DBL', 'desc2_Cat3 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+6, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_Cat4', 'DBL', 'a7_Cat4 Title', 'This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.', 'case when a7 >= 0.0 and a7 < 10.0 then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+7, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_Cat5', 'DBL', 'a7_Cat5 Title', 'This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.', 'case when a7 >= 10.0 and a7 < 20.0 then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+8, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a5_null', 'INT', 'Null a5', 'Whether a5 is null or not', 'case when a5 is null then 1
     when a5 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a5'], current_timestamp, current_timestamp, null)
          ,(k+9, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a6_null', 'INT', 'Null a6', 'Whether a6 is null or not', 'case when a6 is null then 1
     when a6 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a6'], current_timestamp, current_timestamp, null)
          ,(k+10, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_null', 'INT', 'Null a7', 'Whether a7 is null or not', 'case when a7 is null then 1
     when a7 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a7'], current_timestamp, current_timestamp, null)
          ,(k+11, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a8_null', 'INT', 'Null a8', 'Whether a8 is null or not', 'case when a8 is null then 1
     when a8 is not null then 0
end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.a8'], current_timestamp, current_timestamp, null)
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
UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.Testing2View' AND "lastUpdated" < ts;

UPDATE TILDA.FormulaResult
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing2View'
                                and "deleted" is not null
                            );

UPDATE TILDA.FormulaDependency
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing2View'
                                and "deleted" is not null
                            );

select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', 0)-0;


DELETE FROM TILDA.MeasureFormula
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing2View'
                                and "deleted" is not null
                            );

UPDATE TILDA.Measure
   set deleted = current_timestamp
 where "refnum" not in (select "measureRefnum" from TILDA.MeasureFormula)
 ;

END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATEST.Testing3View as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDATEST.Testing2View."a8b" as "a8b" -- The blah
     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  from TILDATEST.Testing2View
;

create or replace view TILDATMP.TILDATEST_Testing3View_R as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDATEST.Testing2Realized."a8b" as "a8b" -- The blah
     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  from TILDATEST.Testing2Realized
;


DROP FUNCTION IF EXISTS TILDATEST.Refill_Testing3Realized();
CREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing3Realized()
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
  TRUNCATE TILDATEST.Testing3Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing3Realized ("refnum", "name", "a8bTZ", "a8b", "lastUpdated", "xxxLastUpdated")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          ,"a8bTZ" -- COLUMN
          ,"a8b" -- COLUMN
          ,"lastUpdated" -- COLUMN
          ,"xxxLastUpdated" -- COLUMN
     FROM TILDATMP.TILDATEST_Testing3View_R;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing3Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing3Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing3View IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATEST.Testing3View as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDATEST.Testing2View."a8b" as "a8b" -- The blah\n     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2View\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing3View_R as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDATEST.Testing2Realized."a8b" as "a8b" -- The blah\n     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2Realized\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing3Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing3Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing3Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing3Realized ("refnum", "name", "a8bTZ", "a8b", "lastUpdated", "xxxLastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n     FROM TILDATMP.TILDATEST_Testing3View_R;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing3Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing3Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing3View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing3View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing3View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDATEST.Testing3View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing3View."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing3View."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';

DO $$
-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.
DECLARE
  ts timestamp;
BEGIN
  select into ts current_timestamp;
  UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.Testing3View' AND "lastUpdated" < ts;
END; $$
LANGUAGE PLPGSQL;



-- DDL META DATA VERSION 2020-12-25
create or replace view TILDATEST.Testing4View as 
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
     , "a10a" -- COLUMN
     , "a10b" -- COLUMN
     , "a10c" -- COLUMN
     , "a11" -- COLUMN
     , "a11b" -- COLUMN
     , "a11c" -- COLUMN
     , "a12" -- COLUMN
     , "a12b" -- COLUMN
     , "a13" -- COLUMN
     , "a13b" -- COLUMN
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
select TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View."a1" as "a1" -- The blah
     , TILDATEST.Testing2View."a3b" as "a3b" -- The blah
     , TILDATEST.Testing2View."a4" as "a4" -- The blah
     , TILDATEST.Testing2View."a4b" as "a4b" -- The blah
     , TILDATEST.Testing2View."a5" as "a5" -- The blah
     , TILDATEST.Testing2View."a5b" as "a5b" -- The blah
     , TILDATEST.Testing2View."a7" as "a7" -- The blah
     , TILDATEST.Testing2View."a7b" as "a7b" -- The blah
     , TILDATEST.Testing2View."a8" as "a8" -- The blah
     , TILDATEST.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDATEST.Testing2View."a8b" as "a8b" -- The blah
     , TILDATEST.Testing2View."a10a" as "a10a" -- The blah
     , TILDATEST.Testing2View."a10b" as "a10b" -- The blah
     , TILDATEST.Testing2View."a10c" as "a10c" -- The blah
     , TILDATEST.Testing2View."a11" as "a11" -- The blah
     , TILDATEST.Testing2View."a11b" as "a11b" -- The blah
     , TILDATEST.Testing2View."a11c" as "a11c" -- The blah
     , TILDATEST.Testing2View."a12" as "a12" -- The blah
     , TILDATEST.Testing2View."a12b" as "a12b" -- The blah
     , TILDATEST.Testing2View."a13" as "a13" -- The blah
     , TILDATEST.Testing2View."a13b" as "a13b" -- The blah
     , TILDATEST.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."a3" as "a3" -- Formula column '<B>Not A3</B>' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View."bastille" as "bastille" -- Formula column '<B>Bastille Day</B>'
     , TILDATEST.Testing2View."toto" as "toto" -- Formula column '<B>Last Updated</B>'
     , TILDATEST.Testing2View."desc2_Cat1" as "desc2_Cat1" -- Formula column '<B>desc2_Cat1 Title</B>'
     , TILDATEST.Testing2View."desc2_Cat2" as "desc2_Cat2" -- Formula column '<B>desc2_Cat2 Title</B>'
     , TILDATEST.Testing2View."desc2_Cat3" as "desc2_Cat3" -- Formula column '<B>desc2_Cat3 Title</B>'
     , TILDATEST.Testing2View."a7_Cat4" as "a7_Cat4" -- Formula column '<B>a7_Cat4 Title</B>'
     , TILDATEST.Testing2View."a7_Cat5" as "a7_Cat5" -- Formula column '<B>a7_Cat5 Title</B>'
     , TILDATEST.Testing2View."a5_null" as "a5_null" -- Formula column '<B>Null a5</B>'
     , TILDATEST.Testing2View."a6_null" as "a6_null" -- Formula column '<B>Null a6</B>'
     , TILDATEST.Testing2View."a7_null" as "a7_null" -- Formula column '<B>Null a7</B>'
     , TILDATEST.Testing2View."a8_null" as "a8_null" -- Formula column '<B>Null a8</B>'
  from TILDATEST.Testing2View

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
;

create or replace view TILDATMP.TILDATEST_Testing4View_R as 
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
     , "a10a" -- COLUMN
     , "a10b" -- COLUMN
     , "a10c" -- COLUMN
     , "a11" -- COLUMN
     , "a11b" -- COLUMN
     , "a11c" -- COLUMN
     , "a12" -- COLUMN
     , "a12b" -- COLUMN
     , "a13" -- COLUMN
     , "a13b" -- COLUMN
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
select TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized."a1" as "a1" -- The blah
     , TILDATEST.Testing2Realized."a3b" as "a3b" -- The blah
     , TILDATEST.Testing2Realized."a4" as "a4" -- The blah
     , TILDATEST.Testing2Realized."a4b" as "a4b" -- The blah
     , TILDATEST.Testing2Realized."a5" as "a5" -- The blah
     , TILDATEST.Testing2Realized."a5b" as "a5b" -- The blah
     , TILDATEST.Testing2Realized."a7" as "a7" -- The blah
     , TILDATEST.Testing2Realized."a7b" as "a7b" -- The blah
     , TILDATEST.Testing2Realized."a8" as "a8" -- The blah
     , TILDATEST.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for 'a8b'.
     , TILDATEST.Testing2Realized."a8b" as "a8b" -- The blah
     , TILDATEST.Testing2Realized."a10a" as "a10a" -- The blah
     , TILDATEST.Testing2Realized."a10b" as "a10b" -- The blah
     , TILDATEST.Testing2Realized."a10c" as "a10c" -- The blah
     , TILDATEST.Testing2Realized."a11" as "a11" -- The blah
     , TILDATEST.Testing2Realized."a11b" as "a11b" -- The blah
     , TILDATEST.Testing2Realized."a11c" as "a11c" -- The blah
     , TILDATEST.Testing2Realized."a12" as "a12" -- The blah
     , TILDATEST.Testing2Realized."a12b" as "a12b" -- The blah
     , TILDATEST.Testing2Realized."a13" as "a13" -- The blah
     , TILDATEST.Testing2Realized."a13b" as "a13b" -- The blah
     , TILDATEST.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."a3" as "a3" -- Formula column '<B>Not A3</B>' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized."bastille" as "bastille" -- Formula column '<B>Bastille Day</B>'
     , TILDATEST.Testing2Realized."toto" as "toto" -- Formula column '<B>Last Updated</B>'
     , TILDATEST.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- Formula column '<B>desc2_Cat1 Title</B>'
     , TILDATEST.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- Formula column '<B>desc2_Cat2 Title</B>'
     , TILDATEST.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- Formula column '<B>desc2_Cat3 Title</B>'
     , TILDATEST.Testing2Realized."a7_Cat4" as "a7_Cat4" -- Formula column '<B>a7_Cat4 Title</B>'
     , TILDATEST.Testing2Realized."a7_Cat5" as "a7_Cat5" -- Formula column '<B>a7_Cat5 Title</B>'
     , TILDATEST.Testing2Realized."a5_null" as "a5_null" -- Formula column '<B>Null a5</B>'
     , TILDATEST.Testing2Realized."a6_null" as "a6_null" -- Formula column '<B>Null a6</B>'
     , TILDATEST.Testing2Realized."a7_null" as "a7_null" -- Formula column '<B>Null a7</B>'
     , TILDATEST.Testing2Realized."a8_null" as "a8_null" -- Formula column '<B>Null a8</B>'
  from TILDATEST.Testing2Realized

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
;


DROP FUNCTION IF EXISTS TILDATEST.Refill_Testing4Realized();
CREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing4Realized()
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
  TRUNCATE TILDATEST.Testing4Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing4Realized ("refnum", "name", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10a", "a10b", "a10c", "a11", "a11b", "a11c", "a12", "a12b", "a13", "a13b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null", "a3", "lastUpdated")
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
          ,"a10a" -- COLUMN
          ,"a10b" -- COLUMN
          ,"a10c" -- COLUMN
          ,"a11" -- COLUMN
          ,"a11b" -- COLUMN
          ,"a11c" -- COLUMN
          ,"a12" -- COLUMN
          ,"a12b" -- COLUMN
          ,"a13" -- COLUMN
          ,"a13b" -- COLUMN
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
     FROM TILDATMP.TILDATEST_Testing4View_R;
  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing4Realized;
  analyzeEndDt:= clock_timestamp ( );

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing4Realized', 'UTC', startDt, 'UTC', clock_timestamp()
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing4View IS E'-- DDL META DATA VERSION 2020-12-25\ncreate or replace view TILDATEST.Testing4View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "a1" -- COLUMN\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n     , "a10a" -- COLUMN\n     , "a10b" -- COLUMN\n     , "a10c" -- COLUMN\n     , "a11" -- COLUMN\n     , "a11b" -- COLUMN\n     , "a11c" -- COLUMN\n     , "a12" -- COLUMN\n     , "a12b" -- COLUMN\n     , "a13" -- COLUMN\n     , "a13b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     , "a8_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."a1" as "a1" -- The blah\n     , TILDATEST.Testing2View."a3b" as "a3b" -- The blah\n     , TILDATEST.Testing2View."a4" as "a4" -- The blah\n     , TILDATEST.Testing2View."a4b" as "a4b" -- The blah\n     , TILDATEST.Testing2View."a5" as "a5" -- The blah\n     , TILDATEST.Testing2View."a5b" as "a5b" -- The blah\n     , TILDATEST.Testing2View."a7" as "a7" -- The blah\n     , TILDATEST.Testing2View."a7b" as "a7b" -- The blah\n     , TILDATEST.Testing2View."a8" as "a8" -- The blah\n     , TILDATEST.Testing2View."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDATEST.Testing2View."a8b" as "a8b" -- The blah\n     , TILDATEST.Testing2View."a10a" as "a10a" -- The blah\n     , TILDATEST.Testing2View."a10b" as "a10b" -- The blah\n     , TILDATEST.Testing2View."a10c" as "a10c" -- The blah\n     , TILDATEST.Testing2View."a11" as "a11" -- The blah\n     , TILDATEST.Testing2View."a11b" as "a11b" -- The blah\n     , TILDATEST.Testing2View."a11c" as "a11c" -- The blah\n     , TILDATEST.Testing2View."a12" as "a12" -- The blah\n     , TILDATEST.Testing2View."a12b" as "a12b" -- The blah\n     , TILDATEST.Testing2View."a13" as "a13" -- The blah\n     , TILDATEST.Testing2View."a13b" as "a13b" -- The blah\n     , TILDATEST.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."a3" as "a3" -- Formula column ''<B>Not A3</B>'' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."bastille" as "bastille" -- Formula column ''<B>Bastille Day</B>''\n     , TILDATEST.Testing2View."toto" as "toto" -- Formula column ''<B>Last Updated</B>''\n     , TILDATEST.Testing2View."desc2_Cat1" as "desc2_Cat1" -- Formula column ''<B>desc2_Cat1 Title</B>''\n     , TILDATEST.Testing2View."desc2_Cat2" as "desc2_Cat2" -- Formula column ''<B>desc2_Cat2 Title</B>''\n     , TILDATEST.Testing2View."desc2_Cat3" as "desc2_Cat3" -- Formula column ''<B>desc2_Cat3 Title</B>''\n     , TILDATEST.Testing2View."a7_Cat4" as "a7_Cat4" -- Formula column ''<B>a7_Cat4 Title</B>''\n     , TILDATEST.Testing2View."a7_Cat5" as "a7_Cat5" -- Formula column ''<B>a7_Cat5 Title</B>''\n     , TILDATEST.Testing2View."a5_null" as "a5_null" -- Formula column ''<B>Null a5</B>''\n     , TILDATEST.Testing2View."a6_null" as "a6_null" -- Formula column ''<B>Null a6</B>''\n     , TILDATEST.Testing2View."a7_null" as "a7_null" -- Formula column ''<B>Null a7</B>''\n     , TILDATEST.Testing2View."a8_null" as "a8_null" -- Formula column ''<B>Null a8</B>''\n  from TILDATEST.Testing2View\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing4View_R as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "a1" -- COLUMN\n     , "a3b" -- COLUMN\n     , "a4" -- COLUMN\n     , "a4b" -- COLUMN\n     , "a5" -- COLUMN\n     , "a5b" -- COLUMN\n     , "a7" -- COLUMN\n     , "a7b" -- COLUMN\n     , "a8" -- COLUMN\n     , "a8bTZ" -- COLUMN\n     , "a8b" -- COLUMN\n     , "a10a" -- COLUMN\n     , "a10b" -- COLUMN\n     , "a10c" -- COLUMN\n     , "a11" -- COLUMN\n     , "a11b" -- COLUMN\n     , "a11c" -- COLUMN\n     , "a12" -- COLUMN\n     , "a12b" -- COLUMN\n     , "a13" -- COLUMN\n     , "a13b" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     , "a8_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."a1" as "a1" -- The blah\n     , TILDATEST.Testing2Realized."a3b" as "a3b" -- The blah\n     , TILDATEST.Testing2Realized."a4" as "a4" -- The blah\n     , TILDATEST.Testing2Realized."a4b" as "a4b" -- The blah\n     , TILDATEST.Testing2Realized."a5" as "a5" -- The blah\n     , TILDATEST.Testing2Realized."a5b" as "a5b" -- The blah\n     , TILDATEST.Testing2Realized."a7" as "a7" -- The blah\n     , TILDATEST.Testing2Realized."a7b" as "a7b" -- The blah\n     , TILDATEST.Testing2Realized."a8" as "a8" -- The blah\n     , TILDATEST.Testing2Realized."a8bTZ" as "a8bTZ" -- Generated helper column to hold the time zone ID for ''a8b''.\n     , TILDATEST.Testing2Realized."a8b" as "a8b" -- The blah\n     , TILDATEST.Testing2Realized."a10a" as "a10a" -- The blah\n     , TILDATEST.Testing2Realized."a10b" as "a10b" -- The blah\n     , TILDATEST.Testing2Realized."a10c" as "a10c" -- The blah\n     , TILDATEST.Testing2Realized."a11" as "a11" -- The blah\n     , TILDATEST.Testing2Realized."a11b" as "a11b" -- The blah\n     , TILDATEST.Testing2Realized."a11c" as "a11c" -- The blah\n     , TILDATEST.Testing2Realized."a12" as "a12" -- The blah\n     , TILDATEST.Testing2Realized."a12b" as "a12b" -- The blah\n     , TILDATEST.Testing2Realized."a13" as "a13" -- The blah\n     , TILDATEST.Testing2Realized."a13b" as "a13b" -- The blah\n     , TILDATEST.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."a3" as "a3" -- Formula column ''<B>Not A3</B>'' -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."bastille" as "bastille" -- Formula column ''<B>Bastille Day</B>''\n     , TILDATEST.Testing2Realized."toto" as "toto" -- Formula column ''<B>Last Updated</B>''\n     , TILDATEST.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- Formula column ''<B>desc2_Cat1 Title</B>''\n     , TILDATEST.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- Formula column ''<B>desc2_Cat2 Title</B>''\n     , TILDATEST.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- Formula column ''<B>desc2_Cat3 Title</B>''\n     , TILDATEST.Testing2Realized."a7_Cat4" as "a7_Cat4" -- Formula column ''<B>a7_Cat4 Title</B>''\n     , TILDATEST.Testing2Realized."a7_Cat5" as "a7_Cat5" -- Formula column ''<B>a7_Cat5 Title</B>''\n     , TILDATEST.Testing2Realized."a5_null" as "a5_null" -- Formula column ''<B>Null a5</B>''\n     , TILDATEST.Testing2Realized."a6_null" as "a6_null" -- Formula column ''<B>Null a6</B>''\n     , TILDATEST.Testing2Realized."a7_null" as "a7_null" -- Formula column ''<B>Null a7</B>''\n     , TILDATEST.Testing2Realized."a8_null" as "a8_null" -- Formula column ''<B>Null a8</B>''\n  from TILDATEST.Testing2Realized\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"a1" -- COLUMN ,"a3b" -- COLUMN ,"a4" -- COLUMN ,"a4b" -- COLUMN ,"a5" -- COLUMN ,"a5b" -- COLUMN ,"a7" -- COLUMN ,"a7b" -- COLUMN ,"a8" -- COLUMN ,"a8bTZ" -- COLUMN ,"a8b" -- COLUMN ,"a10a" -- COLUMN ,"a10b" -- COLUMN ,"a10c" -- COLUMN ,"a11" -- COLUMN ,"a11b" -- COLUMN ,"a11c" -- COLUMN ,"a12" -- COLUMN ,"a12b" -- COLUMN ,"a13" -- COLUMN ,"a13b" -- COLUMN ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a8_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing4Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing4Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing4Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing4Realized ("refnum", "name", "a1", "a3b", "a4", "a4b", "a5", "a5b", "a7", "a7b", "a8", "a8bTZ", "a8b", "a10a", "a10b", "a10c", "a11", "a11b", "a11c", "a12", "a12b", "a13", "a13b", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a8_null", "a3", "lastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          -- "lastUpdated" -- BLOCKED\n          -- "xxxLastUpdated" -- BLOCKED\n          ,"a1" -- COLUMN\n          ,"a3b" -- COLUMN\n          ,"a4" -- COLUMN\n          ,"a4b" -- COLUMN\n          ,"a5" -- COLUMN\n          ,"a5b" -- COLUMN\n          ,"a7" -- COLUMN\n          ,"a7b" -- COLUMN\n          ,"a8" -- COLUMN\n          ,"a8bTZ" -- COLUMN\n          ,"a8b" -- COLUMN\n          ,"a10a" -- COLUMN\n          ,"a10b" -- COLUMN\n          ,"a10c" -- COLUMN\n          ,"a11" -- COLUMN\n          ,"a11b" -- COLUMN\n          ,"a11c" -- COLUMN\n          ,"a12" -- COLUMN\n          ,"a12b" -- COLUMN\n          ,"a13" -- COLUMN\n          ,"a13b" -- COLUMN\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          -- "a3" -- BLOCKED\n          ,"bastille" -- COLUMN\n          ,"toto" -- COLUMN\n          ,"desc2_Cat1" -- COLUMN\n          ,"desc2_Cat2" -- COLUMN\n          ,"desc2_Cat3" -- COLUMN\n          ,"a7_Cat4" -- COLUMN\n          ,"a7_Cat5" -- COLUMN\n          ,"a5_null" -- COLUMN\n          ,"a6_null" -- COLUMN\n          ,"a7_null" -- COLUMN\n          ,"a8_null" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"lastUpdated" -- FORMULA\n     FROM TILDATMP.TILDATEST_Testing4View_R;\n  insertEndDt:= clock_timestamp();  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing4Realized;\n  analyzeEndDt:= clock_timestamp ( );\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing4Realized'', ''UTC'', startDt, ''UTC'', clock_timestamp()\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0), COALESCE(insertRowCount, 0), COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing4View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing4View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing4View."a1" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a3b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a4" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a4b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a5" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a5b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a7" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a7b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a8" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a8bTZ" IS E'Generated helper column to hold the time zone ID for ''a8b''.';
COMMENT ON COLUMN TILDATEST.Testing4View."a8b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a10a" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a10b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a10c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a11" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a11b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a11c" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a12" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a12b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a13" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."a13b" IS E'The blah';
COMMENT ON COLUMN TILDATEST.Testing4View."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."bastille" IS E'Formula column ''<B>Bastille Day</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."toto" IS E'Formula column ''<B>Last Updated</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat1" IS E'Formula column ''<B>desc2_Cat1 Title</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat2" IS E'Formula column ''<B>desc2_Cat2 Title</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat3" IS E'Formula column ''<B>desc2_Cat3 Title</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_Cat4" IS E'Formula column ''<B>a7_Cat4 Title</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_Cat5" IS E'Formula column ''<B>a7_Cat5 Title</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a5_null" IS E'Formula column ''<B>Null a5</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a6_null" IS E'Formula column ''<B>Null a6</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_null" IS E'Formula column ''<B>Null a7</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a8_null" IS E'Formula column ''<B>Null a8</B>''';
COMMENT ON COLUMN TILDATEST.Testing4View."a3" IS E'The calculated formula: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4View."lastUpdated" IS E'The calculated formula: Blah...';

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 2)-2;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDATEST.Testing4View', 'TILDATEST.Testing4Realized', 'a3', 'BOL', 'Always True', 'Blah...', 'NOT a3 OR A3', '<B>N/A</B>', ARRAY['TILDATEST.Testing4View.a3'], current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDATEST.Testing4View', 'TILDATEST.Testing4Realized', 'lastUpdated', 'DTM', 'Always True', 'Blah...', 'GREATEST(lastUpdated, xxxLastUpdated)', '<B>N/A</B>', ARRAY['TILDATEST.Testing4View.lastUpdated', 'TILDATEST.Testing4View.xxxLastUpdated'], current_timestamp, current_timestamp, null)
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
UPDATE TILDA.Formula set deleted = current_timestamp where "location" = 'TILDATEST.Testing4View' AND "lastUpdated" < ts;

UPDATE TILDA.FormulaResult
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing4View'
                                and "deleted" is not null
                            );

UPDATE TILDA.FormulaDependency
   set deleted = current_timestamp
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing4View'
                                and "deleted" is not null
                            );

select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', 0)-0;


DELETE FROM TILDA.MeasureFormula
 where "formulaRefnum" in (select refnum
                               from TILDA.Formula
                              where "location" = 'TILDATEST.Testing4View'
                                and "deleted" is not null
                            );

UPDATE TILDA.Measure
   set deleted = current_timestamp
 where "refnum" not in (select "measureRefnum" from TILDA.MeasureFormula)
 ;

END; $$
LANGUAGE PLPGSQL;

