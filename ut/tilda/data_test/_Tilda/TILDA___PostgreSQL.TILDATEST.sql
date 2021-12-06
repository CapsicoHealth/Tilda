
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
 (  "refnum"          bigint                       -- The primary key for this record
  , "name"            varchar(10)                  -- Medical system unique enterprise id
  , "lastUpdated"     timestamptz                  -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  , "xxxLastUpdated"  timestamptz                  -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  , "description"     varchar(250)                 -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"           varchar(3000)                -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"           text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"           text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"           text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"           text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "a3"              boolean                      -- <B>Not A3</B>: Blah...
  , "bastille"        timestamptz                  -- <B>Bastille Day</B>: Blah...
  , "toto"            timestamptz                  -- <B>Last Updated</B>: Blah...
  , "desc2_Cat1"      double precision             -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
  , "desc2_Cat2"      double precision             -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
  , "desc2_Cat3"      double precision             -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
  , "a7_Cat4"         double precision             -- <B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
  , "a7_Cat5"         double precision             -- <B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
  , "a5_null"         integer                      -- <B>Null a5</B>: Whether a5 is null or not
  , "a6_null"         integer                      -- <B>Null a6</B>: Whether a6 is null or not
  , "a7_null"         integer                      -- <B>Null a7</B>: Whether a7 is null or not
 );
COMMENT ON TABLE TILDATEST.Testing2Realized IS E'Realized table for view TILDATEST.Testing2View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing2Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing2Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing2Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a3" IS E'<B>Not A3</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."bastille" IS E'<B>Bastille Day</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."toto" IS E'<B>Last Updated</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat1" IS E'<B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat2" IS E'<B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."desc2_Cat3" IS E'<B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_Cat4" IS E'<B>a7_Cat4 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_Cat5" IS E'<B>a7_Cat5 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a5_null" IS E'<B>Null a5</B>: Whether a5 is null or not';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a6_null" IS E'<B>Null a6</B>: Whether a6 is null or not';
COMMENT ON COLUMN TILDATEST.Testing2Realized."a7_null" IS E'<B>Null a7</B>: Whether a7 is null or not';
CREATE UNIQUE INDEX IF NOT EXISTS Testing2Realized_Refnum ON TILDATEST.Testing2Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing2Realized_LastUpdated ON TILDATEST.Testing2Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing3Realized -- Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.
 (  "refnum"          bigint                  -- The primary key for this record
  , "name"            varchar(10)             -- Medical system unique enterprise id
  , "lastUpdated"     timestamptz             -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  , "xxxLastUpdated"  timestamptz             -- The timestamp for when the record was last updated. (TILDATEST.Testing)
 );
COMMENT ON TABLE TILDATEST.Testing3Realized IS E'Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing3Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing3Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing3Realized."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing3Realized."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
CREATE UNIQUE INDEX IF NOT EXISTS Testing3Realized_Refnum ON TILDATEST.Testing3Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing3Realized_LastUpdated ON TILDATEST.Testing3Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing4Realized -- Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.
 (  "refnum"       bigint                       -- The primary key for this record
  , "name"         varchar(10)                  -- Medical system unique enterprise id
  , "description"  varchar(250)                 -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc2"        varchar(3000)                -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc3"        text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc4"        text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc5"        text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "desc6"        text                         -- The title for a person, i.e., Mr, Miss, Mrs...
  , "bastille"     timestamptz                  -- <B>Bastille Day</B>: Blah...
  , "toto"         timestamptz                  -- <B>Last Updated</B>: Blah...
  , "desc2_Cat1"   double precision             -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
  , "desc2_Cat2"   double precision             -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
  , "desc2_Cat3"   double precision             -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
  , "a7_Cat4"      double precision             -- <B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
  , "a7_Cat5"      double precision             -- <B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
  , "a5_null"      integer                      -- <B>Null a5</B>: Whether a5 is null or not
  , "a6_null"      integer                      -- <B>Null a6</B>: Whether a6 is null or not
  , "a7_null"      integer                      -- <B>Null a7</B>: Whether a7 is null or not
  , "a3"           boolean                      -- <B>Always True</B>: Blah...
  , "lastUpdated"  timestamptz                  -- <B>Always True</B>: Blah...
 );
COMMENT ON TABLE TILDATEST.Testing4Realized IS E'Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing4Realized."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing4Realized."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."bastille" IS E'<B>Bastille Day</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."toto" IS E'<B>Last Updated</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat1" IS E'<B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat2" IS E'<B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."desc2_Cat3" IS E'<B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_Cat4" IS E'<B>a7_Cat4 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_Cat5" IS E'<B>a7_Cat5 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a5_null" IS E'<B>Null a5</B>: Whether a5 is null or not';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a6_null" IS E'<B>Null a6</B>: Whether a6 is null or not';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a7_null" IS E'<B>Null a7</B>: Whether a7 is null or not';
COMMENT ON COLUMN TILDATEST.Testing4Realized."a3" IS E'<B>Always True</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4Realized."lastUpdated" IS E'<B>Always True</B>: Blah...';
CREATE UNIQUE INDEX IF NOT EXISTS Testing4Realized_Refnum ON TILDATEST.Testing4Realized ("refnum");
CREATE INDEX IF NOT EXISTS Testing4Realized_LastUpdated ON TILDATEST.Testing4Realized ("lastUpdated" DESC);




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.TestView as 
-- 'A join of test and user'
select TILDATEST.Test."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Test."name" as "name" -- The name of the test
  from TILDATEST.Test
 where (TILDATEST.Test."deleted" is null)
;


COMMENT ON VIEW TILDATEST.TestView IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.TestView as \n-- ''A join of test and user''\nselect TILDATEST.Test."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Test."name" as "name" -- The name of the test\n  from TILDATEST.Test\n where (TILDATEST.Test."deleted" is null)\n;\n\n';

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



-- DDL META DATA VERSION 2021-09-02
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


COMMENT ON VIEW TILDATEST.TestingView IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.TestingView as \n-- ''A test view to test aggregates.''\nselect TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id\n     , count(TILDATEST.Testing."refnum") as "refnum" -- The primary key for this record\n     , min(coalesce(TILDATEST.Testing."a2", ''AAA'')) filter(where a2 is not null) as "a2Min" -- The blah\n     , max(coalesce(TILDATEST.Testing."a2", ''ZZZ'')) filter(where a2 is not null) as "a2Max" -- The blah\n     , array_agg(trim(TILDATEST.Testing."a9TZ") order by TILDATEST.Testing."lastUpdated" ASC) as "a9TZ" -- Generated helper column to hold the time zone ID for ''a9''.\n     , array_agg(TILDATEST.Testing."a9" order by TILDATEST.Testing."lastUpdated" ASC) as "a9" -- The blah\n     , array_agg(TILDATEST.Testing."a9c") as "a9c" -- The blah\n     , first(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6First" -- The blah\n     , last(TILDATEST.Testing."a6" order by TILDATEST.Testing."lastUpdated" ASC) as "a6Last" -- The blah\n  from TILDATEST.Testing\n where (TILDATEST.Testing."deleted" is null)\n     group by 1\n;\n\n';

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



-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing2View as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
     , "lastUpdated" -- COLUMN
     , "xxxLastUpdated" -- COLUMN
     , "description" -- COLUMN
     , "desc2" -- COLUMN
     , "desc3" -- COLUMN
     , "desc4" -- COLUMN
     , "desc5" -- COLUMN
     , "desc6" -- COLUMN
     -- Blah...
     , (NOT a3)::boolean as "a3"
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
     , (case when a7 >= 0.0 and a7 < 10.0 then 1 else 0 end)::double precision as "a7_Cat4"
     -- This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
     , (case when a7 >= 10.0 and a7 < 20.0 then 1 else 0 end)::double precision as "a7_Cat5"
     -- Whether a5 is null or not
     , (case when a5 is null then 1 when a5 is not null then 0 end)::integer as "a5_null"
     -- Whether a6 is null or not
     , (case when a6 is null then 1 when a6 is not null then 0 end)::integer as "a6_null"
     -- Whether a7 is null or not
     , (case when a7 is null then 1 when a7 is not null then 0 end)::integer as "a7_null"

 from (
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
  from TILDATEST.Testing
 where (TILDATEST.Testing."deleted" is null)

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA
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
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATEST.Testing2Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          ,"lastUpdated" -- COLUMN
          ,"xxxLastUpdated" -- COLUMN
          -- "created" -- VIEW-EXCLUDED
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
     FROM TILDATEST.Testing2View;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing2Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing2Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing2View IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing2View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n     , "lastUpdated" -- COLUMN\n     , "xxxLastUpdated" -- COLUMN\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n     -- Blah...\n     , (NOT a3)::boolean as "a3"\n     -- Blah...\n     , (''1789-07-14'')::timestamptz as "bastille"\n     -- Blah...\n     , (''2018-08-10'')::timestamptz as "toto"\n     -- This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''a'', ''b'', ''c'') then 1 else 0 end)::double precision as "desc2_Cat1"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double precision as "desc2_Cat2"\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when "desc2"  in (''x'', ''y'', ''z'') then 1 else 0 end)::double precision as "desc2_Cat3"\n     -- This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.\n     , (case when a7 >= 0.0 and a7 < 10.0 then 1 else 0 end)::double precision as "a7_Cat4"\n     -- This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.\n     , (case when a7 >= 10.0 and a7 < 20.0 then 1 else 0 end)::double precision as "a7_Cat5"\n     -- Whether a5 is null or not\n     , (case when a5 is null then 1 when a5 is not null then 0 end)::integer as "a5_null"\n     -- Whether a6 is null or not\n     , (case when a6 is null then 1 when a6 is not null then 0 end)::integer as "a6_null"\n     -- Whether a7 is null or not\n     , (case when a7 is null then 1 when a7 is not null then 0 end)::integer as "a7_null"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing."lastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n  from TILDATEST.Testing\n where (TILDATEST.Testing."deleted" is null)\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN ,"lastUpdated" -- COLUMN ,"xxxLastUpdated" -- COLUMN -- "created" -- VIEW-EXCLUDED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN ,"a3" -- FORMULA ,"bastille" -- FORMULA ,"toto" -- FORMULA ,"desc2_Cat1" -- FORMULA ,"desc2_Cat2" -- FORMULA ,"desc2_Cat3" -- FORMULA ,"a7_Cat4" -- FORMULA ,"a7_Cat5" -- FORMULA ,"a5_null" -- FORMULA ,"a6_null" -- FORMULA ,"a7_null" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing2Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing2Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing2Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing2Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "a3", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n          -- "created" -- VIEW-EXCLUDED\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"bastille" -- FORMULA\n          ,"toto" -- FORMULA\n          ,"desc2_Cat1" -- FORMULA\n          ,"desc2_Cat2" -- FORMULA\n          ,"desc2_Cat3" -- FORMULA\n          ,"a7_Cat4" -- FORMULA\n          ,"a7_Cat5" -- FORMULA\n          ,"a5_null" -- FORMULA\n          ,"a6_null" -- FORMULA\n          ,"a7_null" -- FORMULA\n     FROM TILDATEST.Testing2View;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing2Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing2Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing2View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing2View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing2View."lastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
COMMENT ON COLUMN TILDATEST.Testing2View."xxxLastUpdated" IS E'The timestamp for when the record was last updated. (TILDATEST.Testing)';
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

DO $$
-- This view has formulas and we need to update all its meta-data.
DECLARE
  k bigint;
  ts timestamp;
BEGIN
  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', 11)-11;
  select into ts current_timestamp;

INSERT INTO TILDA.Formula ("refnum", "location", "location2", "name", "type", "title", "description", "formula", "htmlDoc", "referencedColumns", "created", "lastUpdated", "deleted")
    VALUES (k+0, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a3', 'BOL', 'Not A3', 'Blah...', 'NOT a3', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+1, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'bastille', 'DTM', 'Bastille Day', 'Blah...', '''1789-07-14''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+2, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'toto', 'DTM', 'Last Updated', 'Blah...', '''2018-08-10''', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+3, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat1', 'DBL', 'desc2_Cat1 Title', 'This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''a'', ''b'', ''c'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+4, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat2', 'DBL', 'desc2_Cat2 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+5, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'desc2_Cat3', 'DBL', 'desc2_Cat3 Title', 'This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.', 'case when desc2  in (''x'', ''y'', ''z'') then 1 else 0 end', '<B>N/A</B>', ARRAY['TILDATEST.Testing2View.desc2'], current_timestamp, current_timestamp, null)
          ,(k+6, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_Cat4', 'DBL', 'a7_Cat4 Title', 'This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.', 'case when a7 >= 0.0 and a7 < 10.0 then 1 else 0 end', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+7, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_Cat5', 'DBL', 'a7_Cat5 Title', 'This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.', 'case when a7 >= 10.0 and a7 < 20.0 then 1 else 0 end', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+8, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a5_null', 'INT', 'Null a5', 'Whether a5 is null or not', 'case when a5 is null then 1
     when a5 is not null then 0
end', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+9, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a6_null', 'INT', 'Null a6', 'Whether a6 is null or not', 'case when a6 is null then 1
     when a6 is not null then 0
end', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
          ,(k+10, 'TILDATEST.Testing2View', 'TILDATEST.Testing2Realized', 'a7_null', 'INT', 'Null a7', 'Whether a7 is null or not', 'case when a7 is null then 1
     when a7 is not null then 0
end', '<B>N/A</B>', null, current_timestamp, current_timestamp, null)
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

INSERT INTO TILDA.FormulaDependency("formulaRefnum", "dependencyRefnum", "created", "lastUpdated", "deleted")
    VALUES ( (select refnum from TILDA.Formula where "location" = 'TILDATEST.Testing2View' AND "name" = 'a3')
            ,(select refnum from TILDA.Formula where "location" = 'TILDATEST.Testing2View' AND "name" = 'a3')
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



-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing3View as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id
     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  from TILDATEST.Testing2View
;

create or replace view TILDATMP.TILDATEST_Testing3View_R as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record
     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id
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
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATEST.Testing3Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing3Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          ,"lastUpdated" -- COLUMN
          ,"xxxLastUpdated" -- COLUMN
     FROM TILDATMP.TILDATEST_Testing3View_R;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing3Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing3Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing3View IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing3View as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2View\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing3View_R as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2Realized\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing3Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing3Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing3Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing3Realized ("refnum", "name", "lastUpdated", "xxxLastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          ,"lastUpdated" -- COLUMN\n          ,"xxxLastUpdated" -- COLUMN\n     FROM TILDATMP.TILDATEST_Testing3View_R;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing3Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing3Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing3View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing3View."name" IS E'Medical system unique enterprise id';
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



-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing4View as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
--     "lastUpdated"  BLOCKED
--     "xxxLastUpdated"  BLOCKED
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
     , TILDATEST.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View."a3" as "a3" -- <B>Not A3</B>: Blah... -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View."bastille" as "bastille" -- <B>Bastille Day</B>: Blah...
     , TILDATEST.Testing2View."toto" as "toto" -- <B>Last Updated</B>: Blah...
     , TILDATEST.Testing2View."desc2_Cat1" as "desc2_Cat1" -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
     , TILDATEST.Testing2View."desc2_Cat2" as "desc2_Cat2" -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , TILDATEST.Testing2View."desc2_Cat3" as "desc2_Cat3" -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , TILDATEST.Testing2View."a7_Cat4" as "a7_Cat4" -- <B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
     , TILDATEST.Testing2View."a7_Cat5" as "a7_Cat5" -- <B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
     , TILDATEST.Testing2View."a5_null" as "a5_null" -- <B>Null a5</B>: Whether a5 is null or not
     , TILDATEST.Testing2View."a6_null" as "a6_null" -- <B>Null a6</B>: Whether a6 is null or not
     , TILDATEST.Testing2View."a7_null" as "a7_null" -- <B>Null a7</B>: Whether a7 is null or not
  from TILDATEST.Testing2View

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
;

create or replace view TILDATMP.TILDATEST_Testing4View_R as 
select /*DoFormulasSuperView*/
"refnum" -- COLUMN
     , "name" -- COLUMN
--     "lastUpdated"  BLOCKED
--     "xxxLastUpdated"  BLOCKED
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
     , TILDATEST.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized."a3" as "a3" -- <B>Not A3</B>: Blah... -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized."bastille" as "bastille" -- <B>Bastille Day</B>: Blah...
     , TILDATEST.Testing2Realized."toto" as "toto" -- <B>Last Updated</B>: Blah...
     , TILDATEST.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2Realized.
     , TILDATEST.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2Realized.
     , TILDATEST.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2Realized.
     , TILDATEST.Testing2Realized."a7_Cat4" as "a7_Cat4" -- <B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.
     , TILDATEST.Testing2Realized."a7_Cat5" as "a7_Cat5" -- <B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.
     , TILDATEST.Testing2Realized."a5_null" as "a5_null" -- <B>Null a5</B>: Whether a5 is null or not
     , TILDATEST.Testing2Realized."a6_null" as "a6_null" -- <B>Null a6</B>: Whether a6 is null or not
     , TILDATEST.Testing2Realized."a7_null" as "a7_null" -- <B>Null a7</B>: Whether a7 is null or not
  from TILDATEST.Testing2Realized

      ) as T
-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA
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
  endDt          timestamptz;
  insertRowCount bigint;
  deleteRowCount bigint;
BEGIN
  startDt:= clock_timestamp();
  TRUNCATE TILDATEST.Testing4Realized;
  insertStartDt:= clock_timestamp();
  INSERT INTO TILDATEST.Testing4Realized ("refnum", "name", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a3", "lastUpdated")
     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN
          ,"name" -- COLUMN
          -- "lastUpdated" -- BLOCKED
          -- "xxxLastUpdated" -- BLOCKED
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
          ,"a3" -- FORMULA
          ,"lastUpdated" -- FORMULA
     FROM TILDATMP.TILDATEST_Testing4View_R;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing4Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")
                        VALUES('TILDATEST', 'Testing4Realized', 'UTC', startDt, 'UTC', endDt
                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)
                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)
                                         , COALESCE(insertRowCount, 0)
                                         , COALESCE(deleteRowCount, 0));
  return true;
END; $$
LANGUAGE PLPGSQL;

-- SELECT TILDATEST.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!

COMMENT ON VIEW TILDATEST.Testing4View IS E'-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing4View as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2View."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2View."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View."a3" as "a3" -- <B>Not A3</B>: Blah... -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View."bastille" as "bastille" -- <B>Bastille Day</B>: Blah...\n     , TILDATEST.Testing2View."toto" as "toto" -- <B>Last Updated</B>: Blah...\n     , TILDATEST.Testing2View."desc2_Cat1" as "desc2_Cat1" -- <B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.\n     , TILDATEST.Testing2View."desc2_Cat2" as "desc2_Cat2" -- <B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , TILDATEST.Testing2View."desc2_Cat3" as "desc2_Cat3" -- <B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , TILDATEST.Testing2View."a7_Cat4" as "a7_Cat4" -- <B>a7_Cat4 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.\n     , TILDATEST.Testing2View."a7_Cat5" as "a7_Cat5" -- <B>a7_Cat5 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.\n     , TILDATEST.Testing2View."a5_null" as "a5_null" -- <B>Null a5</B>: Whether a5 is null or not\n     , TILDATEST.Testing2View."a6_null" as "a6_null" -- <B>Null a6</B>: Whether a6 is null or not\n     , TILDATEST.Testing2View."a7_null" as "a7_null" -- <B>Null a7</B>: Whether a7 is null or not\n  from TILDATEST.Testing2View\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing4View_R as \nselect /*DoFormulasSuperView*/\n"refnum" -- COLUMN\n     , "name" -- COLUMN\n--     "lastUpdated"  BLOCKED\n--     "xxxLastUpdated"  BLOCKED\n     , "description" -- COLUMN\n     , "desc2" -- COLUMN\n     , "desc3" -- COLUMN\n     , "desc4" -- COLUMN\n     , "desc5" -- COLUMN\n     , "desc6" -- COLUMN\n--     "a3"  BLOCKED\n     , "bastille" -- COLUMN\n     , "toto" -- COLUMN\n     , "desc2_Cat1" -- COLUMN\n     , "desc2_Cat2" -- COLUMN\n     , "desc2_Cat3" -- COLUMN\n     , "a7_Cat4" -- COLUMN\n     , "a7_Cat5" -- COLUMN\n     , "a5_null" -- COLUMN\n     , "a6_null" -- COLUMN\n     , "a7_null" -- COLUMN\n     -- Blah...\n     , (NOT "a3" OR A3)::boolean as "a3"\n     -- Blah...\n     , (GREATEST("lastUpdated", "xxxLastUpdated"))::timestamptz as "lastUpdated"\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized."refnum" as "refnum" -- The primary key for this record\n     , TILDATEST.Testing2Realized."name" as "name" -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized."lastUpdated" as "lastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."xxxLastUpdated" as "xxxLastUpdated" -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."description" as "description" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc2" as "desc2" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc3" as "desc3" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc4" as "desc4" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc5" as "desc5" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."desc6" as "desc6" -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized."a3" as "a3" -- <B>Not A3</B>: Blah... -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized."bastille" as "bastille" -- <B>Bastille Day</B>: Blah...\n     , TILDATEST.Testing2Realized."toto" as "toto" -- <B>Last Updated</B>: Blah...\n     , TILDATEST.Testing2Realized."desc2_Cat1" as "desc2_Cat1" -- <B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2Realized.\n     , TILDATEST.Testing2Realized."desc2_Cat2" as "desc2_Cat2" -- <B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2Realized.\n     , TILDATEST.Testing2Realized."desc2_Cat3" as "desc2_Cat3" -- <B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2Realized.\n     , TILDATEST.Testing2Realized."a7_Cat4" as "a7_Cat4" -- <B>a7_Cat4 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.\n     , TILDATEST.Testing2Realized."a7_Cat5" as "a7_Cat5" -- <B>a7_Cat5 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.\n     , TILDATEST.Testing2Realized."a5_null" as "a5_null" -- <B>Null a5</B>: Whether a5 is null or not\n     , TILDATEST.Testing2Realized."a6_null" as "a6_null" -- <B>Null a6</B>: Whether a6 is null or not\n     , TILDATEST.Testing2Realized."a7_null" as "a7_null" -- <B>Null a7</B>: Whether a7 is null or not\n  from TILDATEST.Testing2Realized\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/"refnum" -- COLUMN ,"name" -- COLUMN -- "lastUpdated" -- BLOCKED -- "xxxLastUpdated" -- BLOCKED ,"description" -- COLUMN ,"desc2" -- COLUMN ,"desc3" -- COLUMN ,"desc4" -- COLUMN ,"desc5" -- COLUMN ,"desc6" -- COLUMN -- "a3" -- BLOCKED ,"bastille" -- COLUMN ,"toto" -- COLUMN ,"desc2_Cat1" -- COLUMN ,"desc2_Cat2" -- COLUMN ,"desc2_Cat3" -- COLUMN ,"a7_Cat4" -- COLUMN ,"a7_Cat5" -- COLUMN ,"a5_null" -- COLUMN ,"a6_null" -- COLUMN ,"a7_null" -- COLUMN ,"a3" -- FORMULA ,"lastUpdated" -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing4Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing4Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing4Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing4Realized ("refnum", "name", "description", "desc2", "desc3", "desc4", "desc5", "desc6", "bastille", "toto", "desc2_Cat1", "desc2_Cat2", "desc2_Cat3", "a7_Cat4", "a7_Cat5", "a5_null", "a6_null", "a7_null", "a3", "lastUpdated")\n     SELECT /*genRealizedColumnList*/"refnum" -- COLUMN\n          ,"name" -- COLUMN\n          -- "lastUpdated" -- BLOCKED\n          -- "xxxLastUpdated" -- BLOCKED\n          ,"description" -- COLUMN\n          ,"desc2" -- COLUMN\n          ,"desc3" -- COLUMN\n          ,"desc4" -- COLUMN\n          ,"desc5" -- COLUMN\n          ,"desc6" -- COLUMN\n          -- "a3" -- BLOCKED\n          ,"bastille" -- COLUMN\n          ,"toto" -- COLUMN\n          ,"desc2_Cat1" -- COLUMN\n          ,"desc2_Cat2" -- COLUMN\n          ,"desc2_Cat3" -- COLUMN\n          ,"a7_Cat4" -- COLUMN\n          ,"a7_Cat5" -- COLUMN\n          ,"a5_null" -- COLUMN\n          ,"a6_null" -- COLUMN\n          ,"a7_null" -- COLUMN\n          ,"a3" -- FORMULA\n          ,"lastUpdated" -- FORMULA\n     FROM TILDATMP.TILDATEST_Testing4View_R;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing4Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf("schemaName", "objectName", "startTimeTZ", "startTime", "endTimeTZ", "endTime", "timeInsertSec", "timeDeleteSec", "timeAnalyzeSec", "timeTotalSec", "insertCount", "deleteCount")\n                        VALUES(''TILDATEST'', ''Testing4Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n';

COMMENT ON COLUMN TILDATEST.Testing4View."refnum" IS E'The primary key for this record';
COMMENT ON COLUMN TILDATEST.Testing4View."name" IS E'Medical system unique enterprise id';
COMMENT ON COLUMN TILDATEST.Testing4View."description" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc3" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc4" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc5" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc6" IS E'The title for a person, i.e., Mr, Miss, Mrs...';
COMMENT ON COLUMN TILDATEST.Testing4View."bastille" IS E'<B>Bastille Day</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4View."toto" IS E'<B>Last Updated</B>: Blah...';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat1" IS E'<B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat2" IS E'<B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4View."desc2_Cat3" IS E'<B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_Cat4" IS E'<B>a7_Cat4 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 0.0 and 10.0.';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_Cat5" IS E'<B>a7_Cat5 Title</B>: This formula checks whether the column ''a7'' value falls in the range of 10.0 and 20.0.';
COMMENT ON COLUMN TILDATEST.Testing4View."a5_null" IS E'<B>Null a5</B>: Whether a5 is null or not';
COMMENT ON COLUMN TILDATEST.Testing4View."a6_null" IS E'<B>Null a6</B>: Whether a6 is null or not';
COMMENT ON COLUMN TILDATEST.Testing4View."a7_null" IS E'<B>Null a7</B>: Whether a7 is null or not';
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

