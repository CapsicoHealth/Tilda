CREATE OR REPLACE FUNCTION TILDA.In(v text[], vals text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v integer[], vals integer[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.In(v bigint[], vals bigint[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v && vals;';

CREATE OR REPLACE FUNCTION TILDA.toInt(str varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN case when str is null then val else str::integer end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toInt(str1 varchar, str2 varchar, str3 varchar, val integer)
RETURNS integer AS $$
BEGIN
  RETURN coalesce(Tilda.toInt(str1, null), Tilda.toInt(str2, null), Tilda.toInt(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.toDouble(str varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN case when str is null then val else str::double precision end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDouble(str1 varchar, str2 varchar, str3 varchar, val double precision)
RETURNS double precision AS $$
BEGIN
  RETURN coalesce(Tilda.toDouble(str1, null), Tilda.toDouble(str2, null), Tilda.toDouble(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.toDate(str varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN case when str is null then val else str::Date end;
EXCEPTION WHEN OTHERS THEN
  RETURN val;
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
CREATE OR REPLACE FUNCTION TILDA.toDate(str1 varchar, str2 varchar, str3 varchar, val Date)
RETURNS Date AS $$
BEGIN
  RETURN coalesce(Tilda.toDate(str1, null), Tilda.toDate(str2, null), Tilda.toDate(str3, val));
END;
$$ LANGUAGE plpgsql IMMUTABLE;


CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text)
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like val);';
CREATE OR REPLACE FUNCTION TILDA.Like(v text[], val text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select exists (select * from unnest(v) x_ where x_ like ANY(val));';
CREATE OR REPLACE FUNCTION TILDA.Like(v text, val text[])
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
  'select v like ANY(val);';


CREATE OR REPLACE FUNCTION TILDA.getKeyBatch(t text, c integer) RETURNS TABLE (min_key_inclusive bigint, max_key_exclusive bigint) AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t;
  SELECT "max" into val from TILDA.Key where "name"=t;
  return query select val-c as min_key_inclusive, val as max_key_exclusive;
END; $$
LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION TILDA.getKeyBatchAsMaxExclusive(t text, c integer) RETURNS bigint AS $$
DECLARE
  val bigint;
BEGIN
  UPDATE TILDA.Key set "max"="max"+c where "name"=t;
  SELECT "max" into val from TILDA.Key where "name"=t;
  return val;
END; $$
LANGUAGE PLPGSQL;


DROP CAST IF EXISTS (text AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(text)
  RETURNS text[]
  IMMUTABLE LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (text AS text[]) WITH FUNCTION TILDA.strToArray(text) as Implicit;

DROP CAST IF EXISTS (varchar AS text[]);
CREATE OR REPLACE FUNCTION TILDA.strToArray(varchar)
  RETURNS text[]
  IMMUTABLE LANGUAGE SQL AS
'SELECT regexp_split_to_array($1, ''``'');';
CREATE CAST (varchar AS text[]) WITH FUNCTION TILDA.strToArray(varchar) as Implicit;


CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz, boolean)
  RETURNS integer
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''days'', $2 - $1)::integer+(case $3 or $2 < $1 when true then 0 else 1 end);';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz, boolean) IS 'Computes the number of days between 2 dates ''start'' and ''end''. The third parameter indicates whether the midnight rule should be applied or not. If true, the number of days between 2016-12-01 and 2016-12-02 for example will be 1 (i.e., one mignight passed). If false, the returned count will be 2.';


CREATE OR REPLACE FUNCTION TILDA.daysBetween(timestamptz, timestamptz)
  RETURNS integer
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''days'', $2 - $1)::integer+1;';
COMMENT ON FUNCTION TILDA.DaysBetween(timestamptz, timestamptz) IS 'Computes the number of days between 2 dates ''start'' and ''end''. This function is the same as TILDA.DaysBetween(timestamptz, timestamptz, boolean) but with the third parapeter defaulted to false, i.e., the number of days between 2016-12-01 and 2016-12-02 is 2.';


CREATE OR REPLACE FUNCTION TILDA.monthsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*12+date_part(''month'', age($2, $1))+date_part(''days'', age($2, $1))/30.0;';
COMMENT ON FUNCTION TILDA.MonthsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of months between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 30th part of a month no matter which month it is.';


CREATE OR REPLACE FUNCTION TILDA.quartersBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))*4+date_part(''month'', age($2, $1))/3.0+date_part(''days'', age($2, $1))/91.0;';
COMMENT ON FUNCTION TILDA.QuartersBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of quarters between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 91st part of a quarter no matter which quarter it is.';


CREATE OR REPLACE FUNCTION TILDA.yearsBetween(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1))+date_part(''month'', age($2, $1))/12.0+date_part(''days'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.YearsBetween(timestamptz, timestamptz) IS 'Computes the aproximate number of years between 2 dates ''start'' and ''end''. It''s approximate because fractional days are computed as a 365th part of a year no matter which year it is.';


CREATE OR REPLACE FUNCTION TILDA.age(timestamptz, timestamptz)
  RETURNS float
  IMMUTABLE LANGUAGE SQL AS
'SELECT date_part(''year'', age($2, $1)) + date_part(''month'', age($2, $1))/12.0 + date_part(''day'', age($2, $1))/365.0;';
COMMENT ON FUNCTION TILDA.Age(timestamptz, timestamptz) IS 'Computes the age in years between 2 dates ''start'' and ''end'' with decimal places, so 1.25 years is 1y and 3 months. It is not 100% accurate as we use a simple 1y=365 days calculation. Use Tilda.DaysBetween if you want accurate days-based calculations.';


CREATE OR REPLACE FUNCTION TILDA.ageBetween(timestamptz, timestamptz, float, float)
  RETURNS boolean
  IMMUTABLE LANGUAGE SQL AS
'SELECT TILDA.Age($1, $2) >= $3 AND TILDA.Age($1, $2) < $4';


CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar)
  RETURNS varchar
  IMMUTABLE LANGUAGE SQL AS
'SELECT dst from TILDA.MAPPING where type=$1 and src=upper($2)';


CREATE OR REPLACE FUNCTION TILDA.first_agg (anyelement, anyelement)
RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$
        SELECT $1;
$$;
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_proc WHERE proname = 'first' AND proisagg=true) THEN
CREATE AGGREGATE public.FIRST (
        sfunc    = TILDA.first_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;
 
CREATE OR REPLACE FUNCTION TILDA.last_agg ( anyelement, anyelement )
RETURNS anyelement LANGUAGE SQL IMMUTABLE STRICT AS $$
        SELECT $2;
$$;
DO $$ BEGIN
if not exists (SELECT 1 FROM pg_proc WHERE proname = 'last' AND proisagg=true) THEN
CREATE AGGREGATE public.LAST (
        sfunc    = TILDA.last_agg,
        basetype = anyelement,
        stype    = anyelement
);
END IF;
END $$;


CREATE extension if not exists tablefunc;
