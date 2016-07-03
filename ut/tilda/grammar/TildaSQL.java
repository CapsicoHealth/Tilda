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

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.types.ColumnDefinition;
import tilda.types.Type_CharPrimitiveNull;
import tilda.types.Type_DatetimePrimitiveNull;
import tilda.types.Type_FloatPrimitiveNull;
import tilda.types.Type_IntegerPrimitive;
import tilda.types.Type_IntegerPrimitiveNull;
import tilda.types.Type_StringCollectionNull;
import tilda.types.Type_StringPrimitiveNull;
import tilda.utils.CollectionUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.SystemValues;

public class TildaSQL
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());

    public static class TestObject
      {
        public char getCLM_TYPE()
          {
            return 'I';
          }

        public String getPRVDR_CLASS()
          {
            return "Abc";
          }

        public String getPRIMARY_ICD9_DGNS_CD()
          {
            return "410.11";
          }

        public List<String> getSECONDARY_ICD9_DGNS_CD()
          {
            return null;
          }

        public String getPRIMARY_ICD9_PRCDR_CD()
          {
            return null;
          }

        public ZonedDateTime getBENE_BIRTH_DT()
          {
            return DateTimeUtil.parsefromJSON("2001-03-11");
          }

        public float getCLM_PMT_AMT()
          {
            return 2500;
          }
      }
    
    
   /*@formatter:off*/
    protected static List<ColumnDefinition> _COLS = CollectionUtil.toList(new ColumnDefinition[] {
           ColumnDefinition.Create("DESYNPUF_ID"       , ColumnType.STRING  , false, false, "De-identified patient id")
          ,ColumnDefinition.Create("CLM_ADMSN_DT"      , ColumnType.DATETIME, false, true , "Claim admission date")
          ,ColumnDefinition.Create("CLM_FROM_DT"       , ColumnType.DATETIME, false, true , "Claim start date")
          ,ColumnDefinition.Create("NCH_BENE_DSCHRG_DT", ColumnType.DATETIME, false, true , "Claim discharge date")
          ,ColumnDefinition.Create("CLM_THRU_DT"       , ColumnType.DATETIME, false, true , "Claim end date")

       ,new Type_FloatPrimitiveNull   ("CMS", "CLAIMSBENEFICIARYVIEW", "CLM_PMT_AMT"            , 7, ""),
        new Type_StringPrimitiveNull  ("CMS", "CLAIMSBENEFICIARYVIEW", "PRVDR_CLASS"            , 10, ""), 
        new Type_CharPrimitiveNull    ("CMS", "CLAIMSBENEFICIARYVIEW", "CLM_TYPE"               , 11, ""),
        new Type_StringPrimitiveNull  ("CMS", "CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_DGNS_CD"   , 12, ""), 
        new Type_StringCollectionNull ("CMS", "CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_DGNS_CD" , 13, ""),
        new Type_StringPrimitiveNull  ("CMS", "CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_PRCDR_CD"  , 14, ""), 
        new Type_StringCollectionNull ("CMS", "CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_PRCDR_CD", 15, ""),
        new Type_IntegerPrimitiveNull ("CMS", "CLAIMSBENEFICIARYVIEW", "CLM_UTLZTN_DAY_CNT"     , 16, ""), 
        new Type_StringPrimitiveNull  ("CMS", "CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DTTZ"        , 17, ""),
        new Type_DatetimePrimitiveNull("CMS", "CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DT"          , 18, ""), 
        new Type_DatetimePrimitiveNull("CMS", "CLAIMSBENEFICIARYVIEW", "BENE_BIRTH_DT"          , 20, ""), 
        new Type_IntegerPrimitive     ("CMS", "CLAIMSBENEFICIARYVIEW", "BENE_SEX_IDENT_CD"      , 21, ""),
        new Type_IntegerPrimitive     ("CMS", "CLAIMSBENEFICIARYVIEW", "SP_STATE_CODE"          , 22, "")
    });
   /*@formatter:on*/



    public static void main(String[] args)
    throws Exception
      {
        SystemValues.autoInit();

        LOG.debug("");
        LOG.debug("");
        LOG.debug("=== TEST 1 =============================================================================================================");
        toto1();

        LOG.debug("");
        LOG.debug("");
        LOG.debug("=== TEST 2 =============================================================================================================");
        toto2();

        LOG.debug("");
        LOG.debug("");
        LOG.debug("=== TEST 3 =============================================================================================================");
        toto3();
      }


    private static void toto1()
      {
        String[] Expressions = { "toto = 'dodo'"
            // ,"toto = CURRENT_TIME"
            // ,"toto <= TIMESTAMP_TOMORROW_LAST"
            // ,"toto = tata"
            // ,"toto > tata"
            // ,"toto > tata-1"
            // ,"toto > 2*tata-1"
            // ,"toto=1 AND tata=2 AND titi=3"
            // ,"toto=1 AND (tata=2 OR tata=3 OR tata=4 OR tata=5) AND (titi=1 OR titi <>10)"
            // ,"(1+2)*5-4/2 >= 3*(1+toto)/tata"
            // ," papa.secondaryDischargeICD9 = '3001-03-11T22:00:30+00:00'"+SystemValues.NEWLINE
            // +"OR papa.secondaryDischargeICD9 = '2001-14-11T22:00:30+00:00'"+SystemValues.NEWLINE
            // +"OR papa.secondaryDischargeICD9 = '2001-03-44T22:00:30+00:00'"+SystemValues.NEWLINE
            // +"OR papa.secondaryDischargeICD9 = '2001-03-11T32:00:30+00:00'"+SystemValues.NEWLINE
            // +"OR papa.secondaryDischargeICD9 == '2001-03-11T22:70:30+00:00'"+SystemValues.NEWLINE
            // +"OR papa.secondaryDischargeICD9 == '2001-03-11T22:00:70+00:00'"+SystemValues.NEWLINE
            // ,"toto.acadabra >= 3*(1+?{var1})/?{var2} && gogo.barilla > gaga.panzani and (gigi.date > CURRENT_TIMESTAMP OR gugu.deleted > '2016-01-01' OR titi >=
            // TIMESTAMP_TODAY)"
            , "@    CLM_TYPE == 'I' " + SystemValues.NEWLINE
            + " AND PRVDR_CLASS = 'Abc' " + SystemValues.NEWLINE
            + " AND (    ( PRIMARY_ICD9_DGNS_CD   LIKE '410.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '410._2' )" + SystemValues.NEWLINE
            + "       OR ( SECONDARY_ICD9_DGNS_CD LIKE '410.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '410._2' )" + SystemValues.NEWLINE
            // + " OR PRIMARY_ICD9_DGNS_CD+PRIMARY_ICD9_PRCDR_CD in ('428.5', '428.54', '1')" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
            + " AND PRIMARY_ICD9_PRCDR_CD not in ('234.23', '11.22')" + SystemValues.NEWLINE
            // +" AND tawa(secondaryDischargeICD9, 12) = 1"+SystemValues.NEWLINE
            // +" AND lower(secondaryDischargeICD9) == 'abc'"+SystemValues.NEWLINE
            + "  AND (   BENE_BIRTH_DT = '2001-03-11'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-03-11T22:00'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-06-11T22:00:30'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-03-11T22:00:30+00:00'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = CURRENT_TIMESTAMP" + SystemValues.NEWLINE
            + "       OR (    BENE_BIRTH_DT >= TIMESTAMP_TODAY" + SystemValues.NEWLINE
            + "           AND BENE_BIRTH_DT < TIMESTAMP_TOMORROW LAST" + SystemValues.NEWLINE
            + "          )" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
            + " AND (    CLM_PMT_AMT >= 2*BENE_SEX_IDENT_CD+?{var1}" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
        };

        for (int i = 0; i < Expressions.length; ++i)
          {
            String Expr = Expressions[i];
            boolean display = Expr.startsWith("@") == true; // If the expression's first char is '@', we'll display the parse tree and results.
            if (display == true)
              Expr = Expr.substring(1);
            LOG.debug("\n\n\n----------------------------------------------------------------------------------");
            LOG.debug("Parsing base expression " + i + ".");
            LOG.debug("    --> " + Expr);
            // Expression parsing
            TildaSQLValidator Validator = new TildaSQLValidator(Expr);
            if (Validator.getParserSyntaxErrors() != 0)
              {
                LOG.error("    --> Base expression " + i + " failed with " + Validator.getParserSyntaxErrors() + " errors.");
                continue;
              }
            LOG.debug("SUCCESS parsing base expression");
            if (display == false)
              continue;

            // Expression validation and Java code gen
            WhereClauseCodeGenJava WC_CG = new WhereClauseCodeGenJava();
            Validator.setCodeGen(WC_CG);
            Validator.setColumnEnvironment(_COLS);
            Validator.validate();
            Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
            if (I != null)
              {
                LOG.error("Some errors occurred validating the base expression");
                while (I.hasNext() == true)
                  LOG.error("        " + I.next());
                continue;
              }
            LOG.debug("SUCCESS validating base expression");
            LOG.debug("   --> " + WC_CG._CodeGen.toString());

            // Meta expression parsing
            TildaCompositionValidator Validator2 = new TildaCompositionValidator("wc1 or wc2", CollectionUtil.toList(new String[] { "wc1", "wc2"
            }));
            if (Validator2.getParserSyntaxErrors() != 0)
              {
                LOG.error("    --> Composition expression failed with " + Validator2.getParserSyntaxErrors() + " errors.");
                continue;
              }
            LOG.debug("SUCCESS parsing composition expression");

            // Meta expression validation and Java code gen
            WhereClauseCompositionCodeGenJava WCC_CG = new WhereClauseCompositionCodeGenJava();
            Validator2.setCodeGen(WCC_CG);
            Validator2.validate();
            I = Validator.getValidationErrors().getErrors();
            if (I != null)
              {
                LOG.error("Some Validation errors occurred");
                while (I.hasNext() == true)
                  LOG.error("        " + I.next());
                continue;
              }
            LOG.debug("SUCCESS validating composition expression");
            LOG.debug("   --> " + WCC_CG._CodeGen.toString());
          }
      }


    public static void toto2()
      {
        String Expr = "     CLM_TYPE >= 'I' " + SystemValues.NEWLINE
        + " AND PRVDR_CLASS = 'Abc' " + SystemValues.NEWLINE
        + " AND PRVDR_CLASS = CLM_TYPE " + SystemValues.NEWLINE
        + " AND (    ( PRIMARY_ICD9_DGNS_CD   LIKE '410.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '410._2' )" + SystemValues.NEWLINE
        + "       OR ( SECONDARY_ICD9_DGNS_CD LIKE '410.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '410._2' )" + SystemValues.NEWLINE
        + "       OR PRIMARY_ICD9_DGNS_CD+PRIMARY_ICD9_PRCDR_CD in ('428.5', '428.54', '1')" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        + " AND PRIMARY_ICD9_PRCDR_CD not in ('234.23', '11.22')" + SystemValues.NEWLINE
        + "  AND (   BENE_BIRTH_DT = '2001-03-11'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = '2001-03-11T22:00'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = '2001-03-11T22:00:30+00:00'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = CURRENT_TIMESTAMP" + SystemValues.NEWLINE
        + "       OR (    BENE_BIRTH_DT >= TIMESTAMP_TODAY" + SystemValues.NEWLINE
        + "           AND BENE_BIRTH_DT < TIMESTAMP_TOMORROW LAST" + SystemValues.NEWLINE
        + "          )" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        + " AND (    CLM_PMT_AMT >= 2*((5+(?{var1}+1)))" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE;

        TildaSQLValidator Validator = new TildaSQLValidator(Expr);
        Validator.setColumnEnvironment(_COLS);

        if (Validator.getParserSyntaxErrors() != 0)
          {
            LOG.error("    --> " + Validator.getParserSyntaxErrors() + " ERROR(S).");
            return;
          }
        LOG.debug("SUCCESS Parsing");
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

    public static void toto3()
    throws Exception
      {
        String Expr1 = "     CLM_TYPE == 'I' " + SystemValues.NEWLINE
        + " AND PRVDR_CLASS = 'Abc' " + SystemValues.NEWLINE
        + " AND (    CLM_PMT_AMT >= 2*?{var1}" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        + " AND (    ( PRIMARY_ICD9_DGNS_CD   LIKE '410.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '410._2' )" + SystemValues.NEWLINE
        + "       OR ( SECONDARY_ICD9_DGNS_CD LIKE '410.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '410._2' )" + SystemValues.NEWLINE
        + "       OR PRIMARY_ICD9_DGNS_CD+PRIMARY_ICD9_PRCDR_CD in ('428.5', '428.54', '1')" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        + " AND PRIMARY_ICD9_PRCDR_CD not in ('234.23', '11.22')" + SystemValues.NEWLINE
        + "  AND (   BENE_BIRTH_DT = '2001-03-11'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = '2001-03-11T22:00'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = '2001-03-11T22:00:30+00:00'" + SystemValues.NEWLINE
        + "       OR BENE_BIRTH_DT = CURRENT_TIMESTAMP" + SystemValues.NEWLINE
        + "       OR (    BENE_BIRTH_DT >= TIMESTAMP_TODAY" + SystemValues.NEWLINE
        + "           AND BENE_BIRTH_DT < TIMESTAMP_TOMORROW LAST" + SystemValues.NEWLINE
        + "          )" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        ;

        String Expr2 = "     CLM_TYPE == 'I' " + SystemValues.NEWLINE
        + " AND PRVDR_CLASS = 'Abc' " + SystemValues.NEWLINE
        + " AND PRVDR_CLASS = CLM_TYPE " + SystemValues.NEWLINE
        + " AND (    ( PRIMARY_ICD9_DGNS_CD   LIKE '428.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '428._2' )" + SystemValues.NEWLINE
        + "       OR ( SECONDARY_ICD9_DGNS_CD LIKE '428.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '428._2' )" + SystemValues.NEWLINE
        + "       OR PRIMARY_ICD9_DGNS_CD+PRIMARY_ICD9_PRCDR_CD in ('428.5', '428.54', '143.34')" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE
        + " AND PRIMARY_ICD9_PRCDR_CD not in ('234.23', '11.22')" + SystemValues.NEWLINE
        + " AND CLM_PMT_AMT >= 10" + SystemValues.NEWLINE;

        String Expr3 = "    ( PRIMARY_ICD9_DGNS_CD   LIKE '428.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '428._2' )" + SystemValues.NEWLINE
        + " OR ( SECONDARY_ICD9_DGNS_CD LIKE '428.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '428._2' )" + SystemValues.NEWLINE;
        
        long T0 = System.nanoTime();
        WhereClauseCompositionClassGenerator WCC_CG = new WhereClauseCompositionClassGenerator("WhereClauseSet1", TestObject.class);
        WCC_CG.addWhereClauseDef("wc1", Expr1, _COLS);
        WCC_CG.addWhereClauseDef("wc2", Expr2, _COLS);
        WCC_CG.addWhereClauseDef("wc3", Expr3, _COLS);
        WCC_CG.setCompositionExpression("wc1 and wc2 and wc3");
        LOG.debug("Parsing time: " + DurationUtil.PrintDuration(System.nanoTime() - T0) + ".");

        T0 = System.nanoTime();
        CompiledWhereClause CWC = WCC_CG.gen("tilda._gen.cwc");
        LOG.debug("Compile time: " + DurationUtil.PrintDuration(System.nanoTime() - T0) + ".");

        T0 = System.nanoTime();
        int MaxCount = 100000;
        for (int j = 0; j < MaxCount; ++j)
          {
            boolean x = CWC.run(new TestObject(), 10);
            if (j % 10000 == 0)
              LOG.debug("Run " + (j + 1) + ": " + x);
          }
        long RunTime = System.nanoTime() - T0;
        LOG.debug("Run TRUE time: " + DurationUtil.PrintDuration(RunTime) + " at " + DurationUtil.PrintPerformancePerMinute(RunTime, MaxCount) + " rules/mn");
        

        T0 = System.nanoTime();
        for (int j = 0; j < MaxCount; ++j)
          {
            boolean x = CWC.run(new TestObject(), 1000000);
            if (j % 10000 == 0)
              LOG.debug("Run " + (j + 1) + ": " + x);
          }
        RunTime = System.nanoTime() - T0;
        LOG.debug("Run FALSE time: " + DurationUtil.PrintDuration(RunTime) + " at " + DurationUtil.PrintPerformancePerMinute(RunTime, MaxCount) + " rules/mn");
        
      }


    public static void toto4()
    throws Exception
      {
        // TildaSQLTreePrinter w1 = new TildaSQLTreePrinter(parser);
        // ParseTreeWalker.DEFAULT.walk(w1, tree);
        // LOG.debug("expr: " + Expr);
        // LOG.debug(w1._ParseTreeStr.toString());
      }

  }
