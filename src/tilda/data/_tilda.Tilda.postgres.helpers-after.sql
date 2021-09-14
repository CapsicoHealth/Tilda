---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- Generate common North American and international time zones
--
---------------------------------------------------------------------------------------------------
insert into TILDA.ZoneInfo ("id", "label", "value", "deactivatedTZ", "deactivated", "created", "lastUpdated")
   values ('UTC'  , 'UTC'                , 'Etc/UTC'            , null, null, current_timestamp, current_timestamp)
         ,('Zulu' , 'Zulu'               , 'Etc/Zulu'           , null, null, current_timestamp, current_timestamp)
         ,('Z'    , 'Z'                  , 'Z'                  , null, null, current_timestamp, current_timestamp)
         ,('Green', 'Greenwich'          , 'Etc/Greenwich'      , null, null, current_timestamp, current_timestamp)
         ,('CaNe' , 'Canada Newfoundland', 'Canada/Newfoundland', null, null, current_timestamp, current_timestamp)
         ,('CaAt' , 'Canada Atlantic'    , 'Canada/Atlantic'    , null, null, current_timestamp, current_timestamp)
         ,('USEa' , 'US Eastern'         , 'US/Eastern'         , null, null, current_timestamp, current_timestamp)
         ,('AmNYC', 'New York City'      , 'America/New_York'   , null, null, current_timestamp, current_timestamp)
         ,('CaEa' , 'Canada Eastern'     , 'Canada/Eastern'     , null, null, current_timestamp, current_timestamp)
         ,('USCe' , 'US Central'         , 'US/Central'         , null, null, current_timestamp, current_timestamp)
         ,('CaCe' , 'Canada Central'     , 'Canada/Central'     , null, null, current_timestamp, current_timestamp)
         ,('CaSa' , 'Canada Saskatchewan', 'Canada/Saskatchewan', null, null, current_timestamp, current_timestamp)
         ,('USAr' , 'US Arizona'         , 'US/Arizona'         , null, null, current_timestamp, current_timestamp)
         ,('USMo' , 'US Mountain'        , 'US/Mountain'        , null, null, current_timestamp, current_timestamp)
         ,('CaMo' , 'Canada Mountain'    , 'Canada/Mountain'    , null, null, current_timestamp, current_timestamp)
         ,('USPa' , 'US Pacific'         , 'US/Pacific'         , null, null, current_timestamp, current_timestamp)
         ,('AmLA' , 'Los Angeles'        , 'America/Los_Angeles', null, null, current_timestamp, current_timestamp)
         ,('CaPa' , 'Canada Pacific'     , 'Canada/Pacific'     , null, null, current_timestamp, current_timestamp)
         ,('USAl' , 'US Alaska'          , 'US/Alaska'          , null, null, current_timestamp, current_timestamp)
         ,('USHa' , 'US Hawaii'          , 'US/Hawaii'          , null, null, current_timestamp, current_timestamp)
         ,('USSa' , 'US Samoa'           , 'US/Samoa'           , null, null, current_timestamp, current_timestamp)
 on conflict("id") do update
 set "label"=EXCLUDED."label"
    ,"value"=EXCLUDED."value"
    ,"deactivatedTZ"=EXCLUDED."deactivatedTZ"
    ,"deactivated"=EXCLUDED."deactivated"
    ,"lastUpdated"=EXCLUDED."lastUpdated"
 ;

 
 
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- Generate the date dimension
--
---------------------------------------------------------------------------------------------------
truncate Tilda.DateLimitDim;
delete from Tilda.Datedim;
INSERT INTO Tilda.DateDim ("dt", "epoch", "dayName", "dayOfWeek", "dayOfMonth", "dayOfQuarter", "dayOfYear", "weekOfMonth", "weekOfYear"
                           ,"month", "monthOfYear", "monthName", "monthNameShort", "quarterOfYear", "quarterName", "year", "mmyyyy", "mmddyyyy", "yyyymmdd"
                           ,"isWeekend", "isBusinessDay", "isHoliday", "holidayName", "created", "lastUpdated", "deleted"
                           )
SELECT actualdate as "dt"
      ,EXTRACT(epoch FROM actualdate) AS "epoch"
      ,TO_CHAR(actualdate,'DAY') AS "dayName"
      ,EXTRACT(isodow FROM actualdate) AS "dayOfWeek"
      ,EXTRACT(DAY FROM actualdate) AS "dayOfMonth"
      ,EXTRACT(DAY FROM (actualdate - DATE_TRUNC('quarter',actualdate)::DATE)) AS "dayOfQuarter"
      ,EXTRACT(doy FROM actualdate) AS "dayOfYear"
      ,TO_CHAR(actualdate,'W')::INT AS "weekOfMonth"
      ,EXTRACT(week FROM actualdate) AS "weekOfYear"
      ,date_trunc('month', actualdate)::DATE AS "month"
      ,EXTRACT(MONTH FROM actualdate) AS "monthOfYear"
      ,TO_CHAR(actualdate,'MONTH') AS "monthName"
      ,TO_CHAR(actualdate,'MON') AS "monthNameShort"
      ,EXTRACT(quarter FROM actualdate) AS "quarterOfYear"
      ,'Q'|| EXTRACT(quarter FROM actualdate) AS "quarterName"
      ,EXTRACT(year FROM actualdate) AS "year"
      ,TO_CHAR(actualdate,'mmyyyy') AS "mmyyyy"
      ,TO_CHAR(actualdate,'mmddyyyy') AS "mmddyyyy"
      ,TO_CHAR(actualdate,'yyyymmdd') AS "yyyymmdd"
      ,CASE
         WHEN EXTRACT(isodow FROM actualdate) IN (6,7) THEN 1
         ELSE 0
       END AS "isWeekend"
      ,CASE 
         WHEN EXTRACT(isodow FROM actualdate) in (1,5) THEN 1
         ELSE 0
       END AS "isBusinessDay"
      ,null AS "isHoliday"
      ,null AS "holidayName"
      ,current_timestamp as "created"
      ,current_timestamp as "lastUpdated"
      ,null as  "deleted"
FROM (select generate_series('1889-01-01'::date, '2089-12-31'::date, '1 day'::interval) as actualdate
                     -- Eiffel Tower (the French celebrate every centuries on '89)
        union 
      select '1789-07-14'::DATE -- Start of French Revolution...
     ) X
ON CONFLICT ("dt") DO NOTHING;
analyze tilda.datedim;

---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- Helper function for date lookup
--
---------------------------------------------------------------------------------------------------
insert into Tilda.DateLimitDim ("invalidDate", "minDate", "maxDate")
SELECT '1789-07-14' AS "invalidDate"
      ,min(dateDim.dt) FILTER (WHERE dateDim.dt <> '1789-07-14') AS "minDate"
      ,max(dateDim.dt) FILTER (WHERE dateDim.dt <> '1789-07-14') AS "maxDate"
 FROM Tilda.DateDim;

-- Returns an integer version of a date for datawarehouse pk, and handle null values or 
-- values out of range, as per DateLimit_Dim to 1789-07-14.
CREATE OR REPLACE FUNCTION Tilda.isInvalidDate("dt" DATE)
  RETURNS BOOLEAN AS
    'select dt = ''2017-07-14'';'
  LANGUAGE sql IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.isInvalidDate("dt" TIMESTAMP)
  RETURNS BOOLEAN AS
    'select date_trunc(''day'', dt) = ''2017-07-14'';'
  LANGUAGE sql IMMUTABLE;

CREATE OR REPLACE FUNCTION Tilda.isInvalidDate("dt" TIMESTAMP WITH TIME ZONE)
  RETURNS BOOLEAN AS
    'select date_trunc(''day'', dt) = ''2017-07-14'';'
  LANGUAGE sql IMMUTABLE;


  
  
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- Helper Formula dependency view
--
---------------------------------------------------------------------------------------------------

CREATE OR REPLACE VIEW Tilda.FormulaDependencyFullView as
with recursive R("formulaRefnum", "formulaLocation", "formulaName", "formulaDependencies", "columnDependencies") as (
select FormulaDependencyView."formulaRefnum", "location" as "formulaLocation", "name" as "formulaName", ARRAY["dependentFormulaLocation"||'.'||"dependentFormulaName"] as "formulaDependencies", "referencedColumns" as "columnDependencies"
  from Tilda.FormulaDependencyView
UNION
select FormulaDependencyView."formulaRefnum", "location" as "formulaLocation", "name" as "formulaName", ARRAY["dependentFormulaLocation"||'.'||"dependentFormulaName"] || R."formulaDependencies", "dependentReferencedColumns"||R."columnDependencies"
  from Tilda.FormulaDependencyView
     join R on R."formulaRefnum" = FormulaDependencyView."dependencyRefnum"
)
select distinct * 
  from R
;


---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
-- cleanup of old tables.
--
---------------------------------------------------------------------------------------------------
drop table if exists tilda.job_detail;
drop table if exists tilda.jobs;
