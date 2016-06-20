package tilda.grammar;

import java.util.List;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.utils.CollectionUtil;

public final class ColDefs {
	public final static List<ColumnDefinition> _COLS = CollectionUtil.toList(new ColumnDefinition[] {
            ColumnDefinition.Create("DESYNPUF_ID"            , ColumnType.STRING  , false, false, "")
           ,ColumnDefinition.Create("CLM_ADMSN_DT"           , ColumnType.DATETIME, false, true, "")
           ,ColumnDefinition.Create("CLM_FROM_DT"            , ColumnType.DATETIME, false, true, "")
           ,ColumnDefinition.Create("CLM_THRU_DT"            , ColumnType.DATETIME, false, true, "")
           ,ColumnDefinition.Create("CLM_PMT_AMT"            , ColumnType.FLOAT   , false, true, "")
           ,ColumnDefinition.Create("PRVDR_CLASS"            , ColumnType.STRING  , false, true, "")
           ,ColumnDefinition.Create("CLM_TYPE"               , ColumnType.CHAR    , false, true, "")
           ,ColumnDefinition.Create("PRIMARY_ICD9_DGNS_CD"   , ColumnType.STRING  , false, true, "")
           ,ColumnDefinition.Create("SECONDARY_ICD9_DGNS_CD" , ColumnType.STRING  , false, true, "")
           ,ColumnDefinition.Create("PRIMARY_ICD9_PRCDR_CD"  , ColumnType.STRING  , false, true, "")
           ,ColumnDefinition.Create("SECONDARY_ICD9_PRCDR_CD", ColumnType.STRING  , false, true, "")
           ,ColumnDefinition.Create("CLM_UTLZTN_DAY_CNT"     , ColumnType.INTEGER , false, true, "")
           ,ColumnDefinition.Create("BENE_DEATH_DT"          , ColumnType.DATETIME, false, true, "")
           ,ColumnDefinition.Create("BENE_BIRTH_DT"          , ColumnType.DATETIME, false, true, "")
           ,ColumnDefinition.Create("BENE_SEX_IDENT_CD"      , ColumnType.INTEGER , false, true, "")
           ,ColumnDefinition.Create("SP_STATE_CODE"          , ColumnType.INTEGER , false, true, "")
     });

}
