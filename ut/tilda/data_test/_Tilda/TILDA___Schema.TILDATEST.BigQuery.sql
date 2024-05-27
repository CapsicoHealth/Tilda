
create schema if not exists TILDATEST;



create table if not exists TILDATEST.Test -- The table to keep track tests amd owners
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `id`           STRING     not null  OPTIONS(description="The name of the test")
  , `name`         STRING     not null  OPTIONS(description="The name of the test")
  , `test_fk`      INT64      not null  OPTIONS(description="The name of the test")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.Test)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Test)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.Test)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test_Test FOREIGN KEY (`test_fk`) REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="The table to keep track tests amd owners");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Test_Name ON TILDATEST.Test ("name");



create table if not exists TILDATEST.Test2 -- The table to keep track tests amd owners
 (  `refnum`       INT64      not null  OPTIONS(description="The primary key for this record")
  , `name`         STRING     not null  OPTIONS(description="The name of the test")
  , `test_fk`      INT64      not null  OPTIONS(description="The name of the test")
  , `created`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.Test2)")
  , `lastUpdated`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Test2)")
  , `deleted`      TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.Test2)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Test2_Test FOREIGN KEY (`test_fk`) REFERENCES TILDATEST.Test ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="The table to keep track tests amd owners");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Test2_Name ON TILDATEST.Test2 ("name");



create table if not exists TILDATEST.Testing -- blah blah
 (  `refnum`       INT64                not null  OPTIONS(description="The primary key for this record")
  , `refnum2`      ARRAY<INT64>         not null  OPTIONS(description="The person's primary key")
  , `name`         STRING               not null  OPTIONS(description="Medical system unique enterprise id")
  , `description`  STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc2`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc3`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc4`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc5`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc6`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `tops`         ARRAY<STRING>                  OPTIONS(description="The blah")
  , `tops2`        ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a2`           STRING                         OPTIONS(description="The blah")
  , `a2b`          ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a2c`          ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a3`           BOOLEAN                        OPTIONS(description="The blah")
  , `a3b`          ARRAY<BOOLEAN>                 OPTIONS(description="The blah")
  , `a4`           FLOAT64                        OPTIONS(description="The blah")
  , `a4b`          ARRAY<FLOAT64>                 OPTIONS(description="The blah")
  , `a5`           FLOAT64                        OPTIONS(description="The blah")
  , `a5b`          ARRAY<FLOAT64>                 OPTIONS(description="The blah")
  , `a6`           INT64                          OPTIONS(description="The blah")
  , `a6b`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a6c`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a6dTZ`        STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a6d'.")
  , `a6d`          TIMESTAMP                      OPTIONS(description="The blah")
  , `a7`           INT64                          OPTIONS(description="The blah")
  , `a7b`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a8bTZ`        STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a8b'.")
  , `a8b`          TIMESTAMP                      OPTIONS(description="The blah")
  , `a9TZ`         STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a9'.")
  , `a9`           TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `a9a1TZ`       STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a9a1'.")
  , `a9a1`         TIMESTAMP           DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `a9bTZ`        ARRAY<STRING>                  OPTIONS(description="Generated helper column to hold the time zone ID for 'a9b'.")
  , `a9b`          ARRAY<TIMESTAMP>               OPTIONS(description="The blah")
  , `a9c`          DATE                           OPTIONS(description="The blah")
  , `a9d`          ARRAY<DATE>                    OPTIONS(description="The blah")
  , `a10a`         INT64                          OPTIONS(description="The blah")
  , `a10b`         STRING                         OPTIONS(description="The blah")
  , `a10c`         INT64                          OPTIONS(description="The blah")
  , `a11`          NUMERIC(8,4)                   OPTIONS(description="The blah")
  , `a11b`         ARRAY<NUMERIC(6,3)>            OPTIONS(description="The blah")
  , `a11c`         NUMERIC(5,4)                   OPTIONS(description="The blah")
  , `a12`          INT64                          OPTIONS(description="The blah")
  , `a12b`         ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a13`          STRING                         OPTIONS(description="The blah")
  , `a13b`         ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a14`          JSON                           OPTIONS(description="The blah")
  , `created`      TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.Testing)")
  , `lastUpdated`  TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing)")
  , `deleted`      TIMESTAMP                      OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.Testing)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_a6d FOREIGN KEY (`a6dTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_a8b FOREIGN KEY (`a8bTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_a9 FOREIGN KEY (`a9TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_a9a1 FOREIGN KEY (`a9a1TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="blah blah");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Testing_AllByName ON TILDATEST.Testing ("name" ASC);
--  CREATE INDEX IF NOT EXISTS Testing_AllByName2 ON TILDATEST.Testing ("name" ASC);
--  CREATE INDEX IF NOT EXISTS Testing_AllByName3 ON TILDATEST.Testing ("name" DESC);
--  CREATE INDEX IF NOT EXISTS Testing_AllByName4 ON TILDATEST.Testing ("name" ASC, "description" DESC) where TILDATEST.Testing."deleted" is null and TILDATEST.Testing."name" = 'Hello' and TILDATEST.Testing."created" > '2018-01-01';



create table if not exists TILDATEST.TestingTimestamps -- blah blah
 (  `refnum`       INT64             not null  OPTIONS(description="The primary key for this record")
  , `id`           STRING            not null  OPTIONS(description="Medical system unique enterprise id")
  , `dt1TZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1'.")
  , `dt1`          TIMESTAMP                   OPTIONS(description="The blah")
  , `dt1nTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1n'.")
  , `dt1n`         TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `dt1uTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1u'.")
  , `dt1u`         TIMESTAMP        DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt1aTZ`       ARRAY<STRING>               OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1a'.")
  , `dt1a`         ARRAY<TIMESTAMP>            OPTIONS(description="The blah")
  , `rowTZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.")
  , `dt2`          TIMESTAMP                   OPTIONS(description="The blah")
  , `dt2n`         TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `dt2u`         TIMESTAMP        DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt2a`         ARRAY<TIMESTAMP>            OPTIONS(description="The blah")
  , `dt3TZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3'.")
  , `dt3`          DATETIME                    OPTIONS(description="The blah")
  , `dt3nTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3n'.")
  , `dt3n`         DATETIME         DEFAULT CURRENT_DATETIME()            OPTIONS(description="The blah")
  , `dt3uTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3u'.")
  , `dt3u`         DATETIME         DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt3aTZ`       ARRAY<STRING>               OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3a'.")
  , `dt3a`         ARRAY<DATETIME>             OPTIONS(description="The blah")
  , `dt4`          DATETIME                    OPTIONS(description="The blah")
  , `dt4n`         DATETIME         DEFAULT CURRENT_DATETIME()            OPTIONS(description="The blah")
  , `dt4u`         DATETIME         DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt4a`         ARRAY<DATETIME>             OPTIONS(description="The blah")
  , `created`      TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.TestingTimestamps)")
  , `lastUpdated`  TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps)")
  , `deleted`      TIMESTAMP                   OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt1 FOREIGN KEY (`dt1TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt1n FOREIGN KEY (`dt1nTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt1u FOREIGN KEY (`dt1uTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt2 FOREIGN KEY (`rowTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt3 FOREIGN KEY (`dt3TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt3n FOREIGN KEY (`dt3nTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_dt3u FOREIGN KEY (`dt3uTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="blah blah");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS TestingTimestamps_Id ON TILDATEST.TestingTimestamps ("id");
--  CREATE INDEX IF NOT EXISTS TestingTimestamps_AllByName ON TILDATEST.TestingTimestamps ("id" ASC);



create table if not exists TILDATEST.Testing_Cloned -- blah blah - Ready for publishing (cloned from TILDATEST.Testing)
 (  `refnum`       INT64                not null  OPTIONS(description="The primary key for this record")
  , `refnum2`      ARRAY<INT64>         not null  OPTIONS(description="The person's primary key")
  , `name`         STRING               not null  OPTIONS(description="Medical system unique enterprise id")
  , `description`  STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc2`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc3`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc4`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc5`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc6`        STRING                         OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `tops`         ARRAY<STRING>                  OPTIONS(description="The blah")
  , `tops2`        ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a2`           STRING                         OPTIONS(description="The blah")
  , `a2b`          ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a2c`          ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a3`           BOOLEAN                        OPTIONS(description="The blah")
  , `a3b`          ARRAY<BOOLEAN>                 OPTIONS(description="The blah")
  , `a4`           FLOAT64                        OPTIONS(description="The blah")
  , `a4b`          ARRAY<FLOAT64>                 OPTIONS(description="The blah")
  , `a5`           FLOAT64                        OPTIONS(description="The blah")
  , `a5b`          ARRAY<FLOAT64>                 OPTIONS(description="The blah")
  , `a6`           INT64                          OPTIONS(description="The blah")
  , `a6b`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a6c`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a6dTZ`        STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a6d'.")
  , `a6d`          TIMESTAMP                      OPTIONS(description="The blah")
  , `a7`           INT64                          OPTIONS(description="The blah")
  , `a7b`          ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a8bTZ`        STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a8b'.")
  , `a8b`          TIMESTAMP                      OPTIONS(description="The blah")
  , `a9TZ`         STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a9'.")
  , `a9`           TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `a9a1TZ`       STRING                         OPTIONS(description="Generated helper column to hold the time zone ID for 'a9a1'.")
  , `a9a1`         TIMESTAMP           DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `a9bTZ`        ARRAY<STRING>                  OPTIONS(description="Generated helper column to hold the time zone ID for 'a9b'.")
  , `a9b`          ARRAY<TIMESTAMP>               OPTIONS(description="The blah")
  , `a9c`          DATE                           OPTIONS(description="The blah")
  , `a9d`          ARRAY<DATE>                    OPTIONS(description="The blah")
  , `a10a`         INT64                          OPTIONS(description="The blah")
  , `a10b`         STRING                         OPTIONS(description="The blah")
  , `a10c`         INT64                          OPTIONS(description="The blah")
  , `a11`          NUMERIC(8,4)                   OPTIONS(description="The blah")
  , `a11b`         ARRAY<NUMERIC(6,3)>            OPTIONS(description="The blah")
  , `a11c`         NUMERIC(5,4)                   OPTIONS(description="The blah")
  , `a12`          INT64                          OPTIONS(description="The blah")
  , `a12b`         ARRAY<INT64>                   OPTIONS(description="The blah")
  , `a13`          STRING                         OPTIONS(description="The blah")
  , `a13b`         ARRAY<STRING>                  OPTIONS(description="The blah")
  , `a14`          JSON                           OPTIONS(description="The blah")
  , `created`      TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.Testing_Cloned)")
  , `lastUpdated`  TIMESTAMP           DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)")
  , `deleted`      TIMESTAMP                      OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_Cloned_a6d FOREIGN KEY (`a6dTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_Cloned_a8b FOREIGN KEY (`a8bTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_Cloned_a9 FOREIGN KEY (`a9TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_Testing_Cloned_a9a1 FOREIGN KEY (`a9a1TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="blah blah - Ready for publishing (cloned from TILDATEST.Testing)");
-- Indices are not supported for this database, so logical definition only
--  CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName ON TILDATEST.Testing_Cloned ("name" ASC);
--  CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName2 ON TILDATEST.Testing_Cloned ("name" ASC);
--  CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName3 ON TILDATEST.Testing_Cloned ("name" DESC);
--  CREATE INDEX IF NOT EXISTS Testing_Cloned_AllByName4 ON TILDATEST.Testing_Cloned ("name" ASC, "description" DESC) where TILDATEST.Testing_Cloned."deleted" is null and TILDATEST.Testing_Cloned."name" = 'Hello' and TILDATEST.Testing_Cloned."created" > '2018-01-01';



create table if not exists TILDATEST.TestingTimestamps_Cloned -- blah blah - Ready for publishing (cloned from TILDATEST.TestingTimestamps)
 (  `refnum`       INT64             not null  OPTIONS(description="The primary key for this record")
  , `id`           STRING            not null  OPTIONS(description="Medical system unique enterprise id")
  , `dt1TZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1'.")
  , `dt1`          TIMESTAMP                   OPTIONS(description="The blah")
  , `dt1nTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1n'.")
  , `dt1n`         TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `dt1uTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1u'.")
  , `dt1u`         TIMESTAMP        DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt1aTZ`       ARRAY<STRING>               OPTIONS(description="Generated helper column to hold the time zone ID for 'dt1a'.")
  , `dt1a`         ARRAY<TIMESTAMP>            OPTIONS(description="The blah")
  , `rowTZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.")
  , `dt2`          TIMESTAMP                   OPTIONS(description="The blah")
  , `dt2n`         TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()            OPTIONS(description="The blah")
  , `dt2u`         TIMESTAMP        DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt2a`         ARRAY<TIMESTAMP>            OPTIONS(description="The blah")
  , `dt3TZ`        STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3'.")
  , `dt3`          DATETIME                    OPTIONS(description="The blah")
  , `dt3nTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3n'.")
  , `dt3n`         DATETIME         DEFAULT CURRENT_DATETIME()            OPTIONS(description="The blah")
  , `dt3uTZ`       STRING                      OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3u'.")
  , `dt3u`         DATETIME         DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt3aTZ`       ARRAY<STRING>               OPTIONS(description="Generated helper column to hold the time zone ID for 'dt3a'.")
  , `dt3a`         ARRAY<DATETIME>             OPTIONS(description="The blah")
  , `dt4`          DATETIME                    OPTIONS(description="The blah")
  , `dt4n`         DATETIME         DEFAULT CURRENT_DATETIME()            OPTIONS(description="The blah")
  , `dt4u`         DATETIME         DEFAULT '1111-11-11T00:00:00Z'            OPTIONS(description="The blah")
  , `dt4a`         ARRAY<DATETIME>             OPTIONS(description="The blah")
  , `created`      TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)")
  , `lastUpdated`  TIMESTAMP        DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)")
  , `deleted`      TIMESTAMP                   OPTIONS(description="The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)")
  -- PRIMARY KEY(`refnum`)
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt1 FOREIGN KEY (`dt1TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt1n FOREIGN KEY (`dt1nTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt1u FOREIGN KEY (`dt1uTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt2 FOREIGN KEY (`rowTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt3 FOREIGN KEY (`dt3TZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt3n FOREIGN KEY (`dt3nTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
  -- FK not supported in BQ
  -- , CONSTRAINT fk_TestingTimestamps_Cloned_dt3u FOREIGN KEY (`dt3uTZ`) REFERENCES TILDA.ZoneInfo ON DELETE restrict ON UPDATE cascade
 )
OPTIONS (description="blah blah - Ready for publishing (cloned from TILDATEST.TestingTimestamps)");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS TestingTimestamps_Cloned_Id ON TILDATEST.TestingTimestamps_Cloned ("id");
--  CREATE INDEX IF NOT EXISTS TestingTimestamps_Cloned_AllByName ON TILDATEST.TestingTimestamps_Cloned ("id" ASC);



create table if not exists TILDATEST.Testing2Realized -- Realized table for view TILDATEST.Testing2View: A test view to test .* and exclude and block.
 (  `refnum`          INT64                OPTIONS(description="The primary key for this record")
  , `name`            STRING               OPTIONS(description="Medical system unique enterprise id")
  , `lastUpdated`     TIMESTAMP            OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing)")
  , `xxxLastUpdated`  TIMESTAMP            OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing)")
  , `description`     STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc2`           STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc3`           STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc4`           STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc5`           STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc6`           STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `bastille`        TIMESTAMP            OPTIONS(description="<B>Bastille Day</B>: Blah...")
  , `toto`            TIMESTAMP            OPTIONS(description="<B>Last Updated</B>: Blah...")
  , `desc2_Cat1`      FLOAT64              OPTIONS(description="<B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.")
  , `desc2_Cat2`      FLOAT64              OPTIONS(description="<B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.")
  , `desc2_Cat3`      FLOAT64              OPTIONS(description="<B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.")
 )
OPTIONS (description="Realized table for view TILDATEST.Testing2View: A test view to test .* and exclude and block.");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Testing2Realized_Refnum ON TILDATEST.Testing2Realized ("refnum");
--  CREATE INDEX IF NOT EXISTS Testing2Realized_LastUpdated ON TILDATEST.Testing2Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing3Realized -- Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.
 (  `refnum`          INT64                OPTIONS(description="The primary key for this record")
  , `name`            STRING               OPTIONS(description="Medical system unique enterprise id")
  , `lastUpdated`     TIMESTAMP            OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing)")
  , `xxxLastUpdated`  TIMESTAMP            OPTIONS(description="The timestamp for when the record was last updated. (TILDATEST.Testing)")
 )
OPTIONS (description="Realized table for view TILDATEST.Testing3View: A test view to test .* and exclude and block.");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Testing3Realized_Refnum ON TILDATEST.Testing3Realized ("refnum");
--  CREATE INDEX IF NOT EXISTS Testing3Realized_LastUpdated ON TILDATEST.Testing3Realized ("lastUpdated" DESC);



create table if not exists TILDATEST.Testing4Realized -- Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.
 (  `refnum`       INT64                OPTIONS(description="The primary key for this record")
  , `name`         STRING               OPTIONS(description="Medical system unique enterprise id")
  , `description`  STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc2`        STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc3`        STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc4`        STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc5`        STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `desc6`        STRING               OPTIONS(description="The title for a person, i.e., Mr, Miss, Mrs...")
  , `bastille`     TIMESTAMP            OPTIONS(description="<B>Bastille Day</B>: Blah...")
  , `toto`         TIMESTAMP            OPTIONS(description="<B>Last Updated</B>: Blah...")
  , `desc2_Cat1`   FLOAT64              OPTIONS(description="<B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.")
  , `desc2_Cat2`   FLOAT64              OPTIONS(description="<B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.")
  , `desc2_Cat3`   FLOAT64              OPTIONS(description="<B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.")
  , `lastUpdated`  TIMESTAMP            OPTIONS(description="<B>Always True</B>: Blah...")
 )
OPTIONS (description="Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.");
-- Indices are not supported for this database, so logical definition only
--  CREATE UNIQUE INDEX IF NOT EXISTS Testing4Realized_Refnum ON TILDATEST.Testing4Realized ("refnum");
--  CREATE INDEX IF NOT EXISTS Testing4Realized_LastUpdated ON TILDATEST.Testing4Realized ("lastUpdated" DESC);




-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.TestView as 
-- 'A join of test and user'
select TILDATEST.Test.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Test.`name` as `name` -- The name of the test
  from TILDATEST.Test
 where (TILDATEST.Test.`deleted`is null)
;


ALTER VIEW TILDATEST.TestView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.TestView as \n-- ''A join of test and user''\nselect TILDATEST.Test.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Test.`name` as `name` -- The name of the test\n  from TILDATEST.Test\n where (TILDATEST.Test.`deleted`is null)\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.TestingView as 
-- 'A test view to test aggregates.'
select TILDATEST.Testing.`name` as `name` -- Medical system unique enterprise id
     , count(TILDATEST.Testing.`refnum`) as `refnum` -- The primary key for this record
     , min(coalesce(case when a2 is not null then TILDATEST.Testing.`a2` else null end, 'AAA')) as `a2Min` -- The blah
     , max(coalesce(case when a2 is not null then TILDATEST.Testing.`a2` else null end, 'ZZZ')) as `a2Max` -- The blah
     , array_agg(TILDATEST.Testing.`a9TZ` order by TILDATEST.Testing.`lastUpdated` ASC) as `a9TZ` -- Generated helper column to hold the time zone ID for 'a9'.
     , array_agg(TILDATEST.Testing.`a9` order by TILDATEST.Testing.`lastUpdated` ASC) as `a9` -- The blah
     , array_agg(TILDATEST.Testing.`a9c`) as `a9c` -- The blah
     , first(TILDATEST.Testing.`a6` order by TILDATEST.Testing.`lastUpdated` ASC) as `a6First` -- The blah
     , last(TILDATEST.Testing.`a6` order by TILDATEST.Testing.`lastUpdated` ASC) as `a6Last` -- The blah
  from TILDATEST.Testing
 where (TILDATEST.Testing.`deleted`is null)
     group by 1
;


ALTER VIEW TILDATEST.TestingView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.TestingView as \n-- ''A test view to test aggregates.''\nselect TILDATEST.Testing.`name` as `name` -- Medical system unique enterprise id\n     , count(TILDATEST.Testing.`refnum`) as `refnum` -- The primary key for this record\n     , min(coalesce(case when a2 is not null then TILDATEST.Testing.`a2` else null end, ''AAA'')) as `a2Min` -- The blah\n     , max(coalesce(case when a2 is not null then TILDATEST.Testing.`a2` else null end, ''ZZZ'')) as `a2Max` -- The blah\n     , array_agg(TILDATEST.Testing.`a9TZ` order by TILDATEST.Testing.`lastUpdated` ASC) as `a9TZ` -- Generated helper column to hold the time zone ID for ''a9''.\n     , array_agg(TILDATEST.Testing.`a9` order by TILDATEST.Testing.`lastUpdated` ASC) as `a9` -- The blah\n     , array_agg(TILDATEST.Testing.`a9c`) as `a9c` -- The blah\n     , first(TILDATEST.Testing.`a6` order by TILDATEST.Testing.`lastUpdated` ASC) as `a6First` -- The blah\n     , last(TILDATEST.Testing.`a6` order by TILDATEST.Testing.`lastUpdated` ASC) as `a6Last` -- The blah\n  from TILDATEST.Testing\n where (TILDATEST.Testing.`deleted`is null)\n     group by 1\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.TestingTimestampsView as 
-- 'A test view to test aggregates.'
select TILDATEST.TestingTimestamps.`id` as `id` -- Medical system unique enterprise id
     , max(TILDATEST.TestingTimestamps.`dt1`) as `dt1_max` -- The blah
     , max(TILDATEST.TestingTimestamps.`dt2`) as `dt2_max` -- The blah
     , max(TILDATEST.TestingTimestamps.`dt3`) as `dt3_max` -- The blah
     , max(TILDATEST.TestingTimestamps.`dt4`) as `dt4_max` -- The blah
     , count(TILDATEST.TestingTimestamps.`dt1`) as `dt1_cnt` -- The blah
     , count(TILDATEST.TestingTimestamps.`dt2`) as `dt2_cnt` -- The blah
     , count(TILDATEST.TestingTimestamps.`dt3`) as `dt3_cnt` -- The blah
     , count(TILDATEST.TestingTimestamps.`dt4`) as `dt4_cnt` -- The blah
     , array_agg(TILDATEST.TestingTimestamps.`dt1`::VARCHAR) as `dt1_arr` -- The blah
     , array_agg(TILDATEST.TestingTimestamps.`dt2`::VARCHAR) as `dt2_arr` -- The blah
     , array_agg(TILDATEST.TestingTimestamps.`dt3`::VARCHAR) as `dt3_arr` -- The blah
     , array_agg(TILDATEST.TestingTimestamps.`dt4`::VARCHAR) as `dt4_arr` -- The blah
  from TILDATEST.TestingTimestamps
     group by 1
;


ALTER VIEW TILDATEST.TestingTimestampsView set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.TestingTimestampsView as \n-- ''A test view to test aggregates.''\nselect TILDATEST.TestingTimestamps.`id` as `id` -- Medical system unique enterprise id\n     , max(TILDATEST.TestingTimestamps.`dt1`) as `dt1_max` -- The blah\n     , max(TILDATEST.TestingTimestamps.`dt2`) as `dt2_max` -- The blah\n     , max(TILDATEST.TestingTimestamps.`dt3`) as `dt3_max` -- The blah\n     , max(TILDATEST.TestingTimestamps.`dt4`) as `dt4_max` -- The blah\n     , count(TILDATEST.TestingTimestamps.`dt1`) as `dt1_cnt` -- The blah\n     , count(TILDATEST.TestingTimestamps.`dt2`) as `dt2_cnt` -- The blah\n     , count(TILDATEST.TestingTimestamps.`dt3`) as `dt3_cnt` -- The blah\n     , count(TILDATEST.TestingTimestamps.`dt4`) as `dt4_cnt` -- The blah\n     , array_agg(TILDATEST.TestingTimestamps.`dt1`::VARCHAR) as `dt1_arr` -- The blah\n     , array_agg(TILDATEST.TestingTimestamps.`dt2`::VARCHAR) as `dt2_arr` -- The blah\n     , array_agg(TILDATEST.TestingTimestamps.`dt3`::VARCHAR) as `dt3_arr` -- The blah\n     , array_agg(TILDATEST.TestingTimestamps.`dt4`::VARCHAR) as `dt4_arr` -- The blah\n  from TILDATEST.TestingTimestamps\n     group by 1\n;\n\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing2View as 
select /*DoFormulasSuperView*/
`refnum` -- COLUMN
     , `name` -- COLUMN
     , `lastUpdated` -- COLUMN
     , `xxxLastUpdated` -- COLUMN
     , `description` -- COLUMN
     , `desc2` -- COLUMN
     , `desc3` -- COLUMN
     , `desc4` -- COLUMN
     , `desc5` -- COLUMN
     , `desc6` -- COLUMN
     -- Blah...
     , ('1789-07-14')::TIMESTAMP as `bastille`
     -- Blah...
     , ('2018-08-10')::TIMESTAMP as `toto`
     -- This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
     , (case when `desc2`  in ('a', 'b', 'c') then 1 else 0 end)::FLOAT64 as `desc2_Cat1`
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , (case when `desc2`  in ('x', 'y', 'z') then 1 else 0 end)::FLOAT64 as `desc2_Cat2`
     -- This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , (case when `desc2`  in ('x', 'y', 'z') then 1 else 0 end)::FLOAT64 as `desc2_Cat3`

 from (
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Testing.`name` as `name` -- Medical system unique enterprise id
     , TILDATEST.Testing.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing.`lastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...
  from TILDATEST.Testing
 where (TILDATEST.Testing.`deleted`is null)

      ) as T
-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN ,`lastUpdated` -- COLUMN ,`xxxLastUpdated` -- COLUMN -- `created` -- VIEW-EXCLUDED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- FORMULA ,`toto` -- FORMULA ,`desc2_Cat1` -- FORMULA ,`desc2_Cat2` -- FORMULA ,`desc2_Cat3` -- FORMULA
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
  INSERT INTO TILDATEST.Testing2Realized (`refnum`, `name`, `lastUpdated`, `xxxLastUpdated`, `description`, `desc2`, `desc3`, `desc4`, `desc5`, `desc6`, `bastille`, `toto`, `desc2_Cat1`, `desc2_Cat2`, `desc2_Cat3`)
     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN
          ,`name` -- COLUMN
          ,`lastUpdated` -- COLUMN
          ,`xxxLastUpdated` -- COLUMN
          -- `created` -- VIEW-EXCLUDED
          ,`description` -- COLUMN
          ,`desc2` -- COLUMN
          ,`desc3` -- COLUMN
          ,`desc4` -- COLUMN
          ,`desc5` -- COLUMN
          ,`desc6` -- COLUMN
          ,`bastille` -- FORMULA
          ,`toto` -- FORMULA
          ,`desc2_Cat1` -- FORMULA
          ,`desc2_Cat2` -- FORMULA
          ,`desc2_Cat3` -- FORMULA
     FROM TILDATEST.Testing2View;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing2Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
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

ALTER VIEW TILDATEST.Testing2View set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing2View as \nselect /*DoFormulasSuperView*/\n`refnum` -- COLUMN\n     , `name` -- COLUMN\n     , `lastUpdated` -- COLUMN\n     , `xxxLastUpdated` -- COLUMN\n     , `description` -- COLUMN\n     , `desc2` -- COLUMN\n     , `desc3` -- COLUMN\n     , `desc4` -- COLUMN\n     , `desc5` -- COLUMN\n     , `desc6` -- COLUMN\n     -- Blah...\n     , (''1789-07-14'')::TIMESTAMP as `bastille`\n     -- Blah...\n     , (''2018-08-10'')::TIMESTAMP as `toto`\n     -- This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.\n     , (case when `desc2`  in (''a'', ''b'', ''c'') then 1 else 0 end)::FLOAT64 as `desc2_Cat1`\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when `desc2`  in (''x'', ''y'', ''z'') then 1 else 0 end)::FLOAT64 as `desc2_Cat2`\n     -- This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , (case when `desc2`  in (''x'', ''y'', ''z'') then 1 else 0 end)::FLOAT64 as `desc2_Cat3`\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Testing.`name` as `name` -- Medical system unique enterprise id\n     , TILDATEST.Testing.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing.`lastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...\n  from TILDATEST.Testing\n where (TILDATEST.Testing.`deleted`is null)\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN ,`lastUpdated` -- COLUMN ,`xxxLastUpdated` -- COLUMN -- `created` -- VIEW-EXCLUDED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- FORMULA ,`toto` -- FORMULA ,`desc2_Cat1` -- FORMULA ,`desc2_Cat2` -- FORMULA ,`desc2_Cat3` -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing2Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing2Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing2Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing2Realized (`refnum`, `name`, `lastUpdated`, `xxxLastUpdated`, `description`, `desc2`, `desc3`, `desc4`, `desc5`, `desc6`, `bastille`, `toto`, `desc2_Cat1`, `desc2_Cat2`, `desc2_Cat3`)\n     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN\n          ,`name` -- COLUMN\n          ,`lastUpdated` -- COLUMN\n          ,`xxxLastUpdated` -- COLUMN\n          -- `created` -- VIEW-EXCLUDED\n          ,`description` -- COLUMN\n          ,`desc2` -- COLUMN\n          ,`desc3` -- COLUMN\n          ,`desc4` -- COLUMN\n          ,`desc5` -- COLUMN\n          ,`desc6` -- COLUMN\n          ,`bastille` -- FORMULA\n          ,`toto` -- FORMULA\n          ,`desc2_Cat1` -- FORMULA\n          ,`desc2_Cat2` -- FORMULA\n          ,`desc2_Cat3` -- FORMULA\n     FROM TILDATEST.Testing2View;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing2Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATEST'', ''Testing2Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing2Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing3View as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2View.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Testing2View.`name` as `name` -- Medical system unique enterprise id
     , TILDATEST.Testing2View.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing2View.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
  from TILDATEST.Testing2View
;

create or replace view TILDATMP.TILDATEST_Testing3View_R as 
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2Realized.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Testing2Realized.`name` as `name` -- Medical system unique enterprise id
     , TILDATEST.Testing2Realized.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
     , TILDATEST.Testing2Realized.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)
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
  INSERT INTO TILDATEST.Testing3Realized (`refnum`, `name`, `lastUpdated`, `xxxLastUpdated`)
     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN
          ,`name` -- COLUMN
          ,`lastUpdated` -- COLUMN
          ,`xxxLastUpdated` -- COLUMN
     FROM TILDATMP.TILDATEST_Testing3View_R;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing3Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
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

ALTER VIEW TILDATEST.Testing3View set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing3View as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Testing2View.`name` as `name` -- Medical system unique enterprise id\n     , TILDATEST.Testing2View.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2View.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2View\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing3View_R as \n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Testing2Realized.`name` as `name` -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n     , TILDATEST.Testing2Realized.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing)\n  from TILDATEST.Testing2Realized\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing3Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing3Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing3Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing3Realized (`refnum`, `name`, `lastUpdated`, `xxxLastUpdated`)\n     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN\n          ,`name` -- COLUMN\n          ,`lastUpdated` -- COLUMN\n          ,`xxxLastUpdated` -- COLUMN\n     FROM TILDATMP.TILDATEST_Testing3View_R;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing3Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATEST'', ''Testing3Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing3Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');





-- DDL META DATA VERSION 2021-09-02
create or replace view TILDATEST.Testing4View as 
select /*DoFormulasSuperView*/
`refnum` -- COLUMN
     , `name` -- COLUMN
--     `lastUpdated`  BLOCKED
--     `xxxLastUpdated`  BLOCKED
     , `description` -- COLUMN
     , `desc2` -- COLUMN
     , `desc3` -- COLUMN
     , `desc4` -- COLUMN
     , `desc5` -- COLUMN
     , `desc6` -- COLUMN
     , `bastille` -- COLUMN
     , `toto` -- COLUMN
     , `desc2_Cat1` -- COLUMN
     , `desc2_Cat2` -- COLUMN
     , `desc2_Cat3` -- COLUMN
     -- Blah...
     , (GREATEST(`lastUpdated`, `xxxLastUpdated`))::TIMESTAMP as `lastUpdated`

 from (
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2View.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Testing2View.`name` as `name` -- Medical system unique enterprise id
     , TILDATEST.Testing2View.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2View.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2View.`bastille` as `bastille` -- <B>Bastille Day</B>: Blah...
     , TILDATEST.Testing2View.`toto` as `toto` -- <B>Last Updated</B>: Blah...
     , TILDATEST.Testing2View.`desc2_Cat1` as `desc2_Cat1` -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.
     , TILDATEST.Testing2View.`desc2_Cat2` as `desc2_Cat2` -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
     , TILDATEST.Testing2View.`desc2_Cat3` as `desc2_Cat3` -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.
  from TILDATEST.Testing2View

      ) as T
-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN -- `lastUpdated` -- BLOCKED -- `xxxLastUpdated` -- BLOCKED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- COLUMN ,`toto` -- COLUMN ,`desc2_Cat1` -- COLUMN ,`desc2_Cat2` -- COLUMN ,`desc2_Cat3` -- COLUMN ,`lastUpdated` -- FORMULA
;

create or replace view TILDATMP.TILDATEST_Testing4View_R as 
select /*DoFormulasSuperView*/
`refnum` -- COLUMN
     , `name` -- COLUMN
--     `lastUpdated`  BLOCKED
--     `xxxLastUpdated`  BLOCKED
     , `description` -- COLUMN
     , `desc2` -- COLUMN
     , `desc3` -- COLUMN
     , `desc4` -- COLUMN
     , `desc5` -- COLUMN
     , `desc6` -- COLUMN
     , `bastille` -- COLUMN
     , `toto` -- COLUMN
     , `desc2_Cat1` -- COLUMN
     , `desc2_Cat2` -- COLUMN
     , `desc2_Cat3` -- COLUMN
     -- Blah...
     , (GREATEST(`lastUpdated`, `xxxLastUpdated`))::TIMESTAMP as `lastUpdated`

 from (
-- 'A test view to test .* and exclude and block.'
select TILDATEST.Testing2Realized.`refnum` as `refnum` -- The primary key for this record
     , TILDATEST.Testing2Realized.`name` as `name` -- Medical system unique enterprise id
     , TILDATEST.Testing2Realized.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)
     , TILDATEST.Testing2Realized.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...
     , TILDATEST.Testing2Realized.`bastille` as `bastille` -- <B>Bastille Day</B>: Blah...
     , TILDATEST.Testing2Realized.`toto` as `toto` -- <B>Last Updated</B>: Blah...
     , TILDATEST.Testing2Realized.`desc2_Cat1` as `desc2_Cat1` -- <B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2Realized.
     , TILDATEST.Testing2Realized.`desc2_Cat2` as `desc2_Cat2` -- <B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2Realized.
     , TILDATEST.Testing2Realized.`desc2_Cat3` as `desc2_Cat3` -- <B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2Realized.
  from TILDATEST.Testing2Realized

      ) as T
-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN -- `lastUpdated` -- BLOCKED -- `xxxLastUpdated` -- BLOCKED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- COLUMN ,`toto` -- COLUMN ,`desc2_Cat1` -- COLUMN ,`desc2_Cat2` -- COLUMN ,`desc2_Cat3` -- COLUMN ,`lastUpdated` -- FORMULA
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
  INSERT INTO TILDATEST.Testing4Realized (`refnum`, `name`, `description`, `desc2`, `desc3`, `desc4`, `desc5`, `desc6`, `bastille`, `toto`, `desc2_Cat1`, `desc2_Cat2`, `desc2_Cat3`, `lastUpdated`)
     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN
          ,`name` -- COLUMN
          -- `lastUpdated` -- BLOCKED
          -- `xxxLastUpdated` -- BLOCKED
          ,`description` -- COLUMN
          ,`desc2` -- COLUMN
          ,`desc3` -- COLUMN
          ,`desc4` -- COLUMN
          ,`desc5` -- COLUMN
          ,`desc6` -- COLUMN
          ,`bastille` -- COLUMN
          ,`toto` -- COLUMN
          ,`desc2_Cat1` -- COLUMN
          ,`desc2_Cat2` -- COLUMN
          ,`desc2_Cat3` -- COLUMN
          ,`lastUpdated` -- FORMULA
     FROM TILDATMP.TILDATEST_Testing4View_R;
  GET DIAGNOSTICS insertRowCount = ROW_COUNT;
  insertEndDt:= clock_timestamp();
  analyzeStartDt:= clock_timestamp();
  ANALYZE TILDATEST.Testing4Realized;
  analyzeEndDt:= clock_timestamp ( );
  endDt:= clock_timestamp();

  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)
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

ALTER VIEW TILDATEST.Testing4View set OPTIONS(description='-- DDL META DATA VERSION 2021-09-02\ncreate or replace view TILDATEST.Testing4View as \nselect /*DoFormulasSuperView*/\n`refnum` -- COLUMN\n     , `name` -- COLUMN\n--     `lastUpdated`  BLOCKED\n--     `xxxLastUpdated`  BLOCKED\n     , `description` -- COLUMN\n     , `desc2` -- COLUMN\n     , `desc3` -- COLUMN\n     , `desc4` -- COLUMN\n     , `desc5` -- COLUMN\n     , `desc6` -- COLUMN\n     , `bastille` -- COLUMN\n     , `toto` -- COLUMN\n     , `desc2_Cat1` -- COLUMN\n     , `desc2_Cat2` -- COLUMN\n     , `desc2_Cat3` -- COLUMN\n     -- Blah...\n     , (GREATEST(`lastUpdated`, `xxxLastUpdated`))::TIMESTAMP as `lastUpdated`\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2View.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Testing2View.`name` as `name` -- Medical system unique enterprise id\n     , TILDATEST.Testing2View.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2View.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2View.`bastille` as `bastille` -- <B>Bastille Day</B>: Blah...\n     , TILDATEST.Testing2View.`toto` as `toto` -- <B>Last Updated</B>: Blah...\n     , TILDATEST.Testing2View.`desc2_Cat1` as `desc2_Cat1` -- <B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2View.\n     , TILDATEST.Testing2View.`desc2_Cat2` as `desc2_Cat2` -- <B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n     , TILDATEST.Testing2View.`desc2_Cat3` as `desc2_Cat3` -- <B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2View.\n  from TILDATEST.Testing2View\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN -- `lastUpdated` -- BLOCKED -- `xxxLastUpdated` -- BLOCKED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- COLUMN ,`toto` -- COLUMN ,`desc2_Cat1` -- COLUMN ,`desc2_Cat2` -- COLUMN ,`desc2_Cat3` -- COLUMN ,`lastUpdated` -- FORMULA\n;\n\ncreate or replace view TILDATMP.TILDATEST_Testing4View_R as \nselect /*DoFormulasSuperView*/\n`refnum` -- COLUMN\n     , `name` -- COLUMN\n--     `lastUpdated`  BLOCKED\n--     `xxxLastUpdated`  BLOCKED\n     , `description` -- COLUMN\n     , `desc2` -- COLUMN\n     , `desc3` -- COLUMN\n     , `desc4` -- COLUMN\n     , `desc5` -- COLUMN\n     , `desc6` -- COLUMN\n     , `bastille` -- COLUMN\n     , `toto` -- COLUMN\n     , `desc2_Cat1` -- COLUMN\n     , `desc2_Cat2` -- COLUMN\n     , `desc2_Cat3` -- COLUMN\n     -- Blah...\n     , (GREATEST(`lastUpdated`, `xxxLastUpdated`))::TIMESTAMP as `lastUpdated`\n\n from (\n-- ''A test view to test .* and exclude and block.''\nselect TILDATEST.Testing2Realized.`refnum` as `refnum` -- The primary key for this record\n     , TILDATEST.Testing2Realized.`name` as `name` -- Medical system unique enterprise id\n     , TILDATEST.Testing2Realized.`lastUpdated` as `lastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized.`xxxLastUpdated` as `xxxLastUpdated` -- The timestamp for when the record was last updated. (TILDATEST.Testing) -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)\n     , TILDATEST.Testing2Realized.`description` as `description` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`desc2` as `desc2` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`desc3` as `desc3` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`desc4` as `desc4` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`desc5` as `desc5` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`desc6` as `desc6` -- The title for a person, i.e., Mr, Miss, Mrs...\n     , TILDATEST.Testing2Realized.`bastille` as `bastille` -- <B>Bastille Day</B>: Blah...\n     , TILDATEST.Testing2Realized.`toto` as `toto` -- <B>Last Updated</B>: Blah...\n     , TILDATEST.Testing2Realized.`desc2_Cat1` as `desc2_Cat1` -- <B>desc2_Cat1 Title</B>: This formula checks whether the column ''desc2'' contains the values ''a'', ''b'', ''c'' for the View TILDATEST.Testing2Realized.\n     , TILDATEST.Testing2Realized.`desc2_Cat2` as `desc2_Cat2` -- <B>desc2_Cat2 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2Realized.\n     , TILDATEST.Testing2Realized.`desc2_Cat3` as `desc2_Cat3` -- <B>desc2_Cat3 Title</B>: This formula checks whether the column ''desc2'' contains the values ''x'', ''y'', ''z'' for the View TILDATEST.Testing2Realized.\n  from TILDATEST.Testing2Realized\n\n      ) as T\n-- Realized as /*genRealizedColumnList*/`refnum` -- COLUMN ,`name` -- COLUMN -- `lastUpdated` -- BLOCKED -- `xxxLastUpdated` -- BLOCKED ,`description` -- COLUMN ,`desc2` -- COLUMN ,`desc3` -- COLUMN ,`desc4` -- COLUMN ,`desc5` -- COLUMN ,`desc6` -- COLUMN ,`bastille` -- COLUMN ,`toto` -- COLUMN ,`desc2_Cat1` -- COLUMN ,`desc2_Cat2` -- COLUMN ,`desc2_Cat3` -- COLUMN ,`lastUpdated` -- FORMULA\n;\n\n\nDROP FUNCTION IF EXISTS TILDATEST.Refill_Testing4Realized();\nCREATE OR REPLACE FUNCTION TILDATEST.Refill_Testing4Realized()\n RETURNS boolean AS $$\ndeclare\n  startDt        timestamptz;\n  insertStartDt  timestamptz;\n  insertEndDt    timestamptz;\n  deleteStartDt  timestamptz;\n  deleteEndDt    timestamptz;\n  analyzeStartDt timestamptz;\n  analyzeEndDt   timestamptz;\n  endDt          timestamptz;\n  insertRowCount bigint;\n  deleteRowCount bigint;\nBEGIN\n  startDt:= clock_timestamp();\n  TRUNCATE TILDATEST.Testing4Realized;\n  insertStartDt:= clock_timestamp();\n  INSERT INTO TILDATEST.Testing4Realized (`refnum`, `name`, `description`, `desc2`, `desc3`, `desc4`, `desc5`, `desc6`, `bastille`, `toto`, `desc2_Cat1`, `desc2_Cat2`, `desc2_Cat3`, `lastUpdated`)\n     SELECT /*genRealizedColumnList*/`refnum` -- COLUMN\n          ,`name` -- COLUMN\n          -- `lastUpdated` -- BLOCKED\n          -- `xxxLastUpdated` -- BLOCKED\n          ,`description` -- COLUMN\n          ,`desc2` -- COLUMN\n          ,`desc3` -- COLUMN\n          ,`desc4` -- COLUMN\n          ,`desc5` -- COLUMN\n          ,`desc6` -- COLUMN\n          ,`bastille` -- COLUMN\n          ,`toto` -- COLUMN\n          ,`desc2_Cat1` -- COLUMN\n          ,`desc2_Cat2` -- COLUMN\n          ,`desc2_Cat3` -- COLUMN\n          ,`lastUpdated` -- FORMULA\n     FROM TILDATMP.TILDATEST_Testing4View_R;\n  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n  insertEndDt:= clock_timestamp();\n  analyzeStartDt:= clock_timestamp();\n  ANALYZE TILDATEST.Testing4Realized;\n  analyzeEndDt:= clock_timestamp ( );\n  endDt:= clock_timestamp();\n\n  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n                        VALUES(''TILDATEST'', ''Testing4Realized'', ''UTC'', startDt, ''UTC'', endDt\n                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n                                         , COALESCE(insertRowCount, 0)\n                                         , COALESCE(deleteRowCount, 0));\n  return true;\nEND; $$\nLANGUAGE PLPGSQL;\n\n-- SELECT TILDATEST.Refill_Testing4Realized(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n');



