-------------------------------------------------------------------------------------------
-- TILDA Mapping helper functions
CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar)
  RETURNS varchar
  IMMUTABLE LANGUAGE SQL AS
'SELECT dst from TILDA.MAPPING where type=$1 and src=upper($2)';

CREATE OR REPLACE FUNCTION TILDA.map(varchar, varchar, varchar)
  RETURNS varchar
  IMMUTABLE LANGUAGE SQL AS
'SELECT coalesce(TILDA.map($1, $2), $3)';
