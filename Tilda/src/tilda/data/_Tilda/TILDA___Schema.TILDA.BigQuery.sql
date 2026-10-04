
create schema if not exists TILDA;



create table if not exists TILDA.MaintenanceLog -- Maintenance information
 (  `refnum`         INT64      not null  OPTIONS(description="The primary key for this record")
  , `type`           STRING     not null  OPTIONS(description="The type of maintenance, e.g., Migration, Reorg...")
  , `schemaName`     STRING     not null  OPTIONS(description="The name of the schema for the resource.")
  , `objectName`     STRING               OPTIONS(description="The name of the resource.")
  , `objectType`     STRING               OPTIONS(description="The type of the resource.")
  , `action`         STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `startTimeTZ`    STRING     not null  OPTIONS(description="Generated helper column to hold the time zone ID for 'startTime'.")
  , `startTime`      TIMESTAMP  not null  OPTIONS(description="The timestamp for when the refill started.")
  , `endTimeTZ`      STRING               OPTIONS(description="Generated helper column to hold the time zone ID for 'endTime'.")
  , `endTime`        TIMESTAMP            OPTIONS(description="The timestamp for when the refill ended.")
  , `statement`      STRING               OPTIONS(description="The value of the maintenance resource to track.")
  , `statementHash`  STRING               OPTIONS(description="SHA-256 hash of the maintenance statement for staleness checks.")
  , `descr`          STRING               OPTIONS(description="The name of the maintenance resource to track.")
  , `created`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was created. (TILDA.MaintenanceLog)")
  , `lastUpdated`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP()  not null  OPTIONS(description="The timestamp for when the record was last updated. (TILDA.MaintenanceLog)")
  , `deleted`        TIMESTAMP            OPTIONS(description="The timestamp for when the record was deleted. (TILDA.MaintenanceLog)")
  , PRIMARY KEY(`refnum`) NOT ENFORCED
 )
OPTIONS (description="Maintenance information");

-- Indices are not supported for this database, so logical definition only
-- app-level index only -- Index 'MaintenanceLog_SchemaObjectStart' on TILDA.MaintenanceLog("schemaName", "objectName") order by , "startTime" DESC
-- app-level index only -- Index 'MaintenanceLog_TypeStart' on TILDA.MaintenanceLog("type") order by , "startTime" DESC



