CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar)
  RETURNS varchar
  IMMUTABLE LANGUAGE SQL AS
'SELECT dst from TILDA.MAPPING where type=$1 and src=upper($2)';
