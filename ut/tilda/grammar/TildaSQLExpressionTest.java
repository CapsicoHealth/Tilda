/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.grammar;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.utils.CollectionUtil;
import tilda.utils.SystemValues;

public class TildaSQLExpressionTest
  {
    protected static final Logger           LOG   = LogManager.getLogger(TildaSQLExpressionTest.class.getName());

    // Meta-data about the sample object used in the test rules.
    /*@formatter:off*/
    protected static List<ColumnDefinition> _COLS = CollectionUtil.toList(new ColumnDefinition[] {
           ColumnDefinition.Create(null, null, "DESYNPUF_ID"            , ColumnType.STRING  , false, false, "De-identified patient id")
          ,ColumnDefinition.Create(null, null, "CLM_FROM_DT"            , ColumnType.DATETIME, false, true , "Claim start date")
          ,ColumnDefinition.Create(null, null, "CLM_THRU_DT"            , ColumnType.DATETIME, false, true , "Claim end date")
          ,ColumnDefinition.Create(null, null, "CLM_PMT_AMT"            , ColumnType.FLOAT   , false, true , "Claim payment")
          ,ColumnDefinition.Create(null, null, "PRVDR_CLASS"            , ColumnType.STRING  , false, true , "Provider class")
          ,ColumnDefinition.Create(null, null, "CLM_TYPE"               , ColumnType.CHAR    , false, false, "Claim type")
          ,ColumnDefinition.Create(null, null, "PRIMARY_ICD9_DGNS_CD"   , ColumnType.STRING  , false, true , "Primary ICD9 diagnosis code")
          ,ColumnDefinition.Create(null, null, "SECONDARY_ICD9_DGNS_CD" , ColumnType.STRING  , true , true , "Secondary ICD9 diagnosis codes")
          ,ColumnDefinition.Create(null, null, "PRIMARY_ICD9_PRCDR_CD"  , ColumnType.STRING  , false, true , "Primary ICD9 procedure code")
          ,ColumnDefinition.Create(null, null, "SECONDARY_ICD9_PRCDR_CD", ColumnType.STRING  , true , true , "Secondary ICD9 procedure codes")
          ,ColumnDefinition.Create(null, null, "BENE_BIRTH_DT"          , ColumnType.DATETIME, false, true , "Beneficiary date of birth")
          ,ColumnDefinition.Create(null, null, "BENE_DEATH_DT"          , ColumnType.DATETIME, false, true , "Beneficiary date of death")
          ,ColumnDefinition.Create(null, null, "BENE_SEX_IDENT_CD"      , ColumnType.CHAR    , false, true , "Beneficiary gender")
    });
   /*@formatter:on*/


    public static void main(String[] args)
    throws Exception
      {
        SystemValues.autoInit();

        LOG.debug("");
        LOG.debug("");
        LOG.debug("=== TEST 1 =============================================================================================================");
        toto();
      }


    /**
     * Defining and validating a complex rule.
     */
    public static void toto()
      {
        String Expr = "case when DaysBetween(BENE_BIRTH_DT, TIMESTAMP_TODAY) > 65\n"
                     +"          then 5 + DaysBetween(BENE_BIRTH_DT, BENE_DEATH_DT)\n"
                     +"     when Len(DESYNPUF_ID) < 10\n"
                     +"          then Len(DESYNPUF_ID||DESYNPUF_ID||DESYNPUF_ID) \n"
                     +"     else '12345'||true\n"
                     +"end"
                    ;

        TildaSQLValidator Validator = new TildaSQLValidator(Expr, false);
        if (Validator.getParserSyntaxErrors() != 0)
          {
            LOG.error("\n"+Validator.PrintParseTree());
            LOG.error("    --> " + Validator.getParserSyntaxErrors() + " ERROR(S).");
            return;
          }
        LOG.debug("SUCCESS Parsing");
        Validator.setColumnEnvironment(_COLS);
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I == null)
          LOG.debug("SUCCESS Validating");
        else
          {
            LOG.error("Some Validation errors occurred");
            while (I.hasNext() == true)
              LOG.error("        " + I.next());
            return;
          }
      }

  }
