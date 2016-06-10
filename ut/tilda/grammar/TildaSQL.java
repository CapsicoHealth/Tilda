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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.types.ColumnDefinition;
import tilda.types.Type_CharPrimitiveNull;
import tilda.types.Type_DatetimePrimitiveNull;
import tilda.types.Type_FloatPrimitiveNull;
import tilda.types.Type_IntegerPrimitive;
import tilda.types.Type_IntegerPrimitiveNull;
import tilda.types.Type_StringCollectionNull;
import tilda.types.Type_StringPrimitive;
import tilda.types.Type_StringPrimitiveNull;
import tilda.utils.CollectionUtil;
import tilda.utils.CompareUtil;
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
            return 20;
          }
      }

    protected static List<ColumnDefinition> _COLS = CollectionUtil.toList(new ColumnDefinition[] {
        new Type_StringPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "DESYNPUF_ID", 0), new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_ADMSN_DTTZ", 1),
        new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_ADMSN_DT", 2), new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_FROM_DTTZ", 3),
        new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_FROM_DT", 4), new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "NCH_BENE_DSCHRG_DTTZ", 5),
        new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "NCH_BENE_DSCHRG_DT", 6), new Type_FloatPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_PMT_AMT", 7),
        new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_THRU_DTTZ", 8), new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_THRU_DT", 9),
        new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "PRVDR_CLASS", 10), new Type_CharPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_TYPE", 11),
        new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_DGNS_CD", 12), new Type_StringCollectionNull("CMS.CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_DGNS_CD", 13),
        new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_PRCDR_CD", 14), new Type_StringCollectionNull("CMS.CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_PRCDR_CD", 15),
        new Type_IntegerPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_UTLZTN_DAY_CNT", 16), new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DTTZ", 17),
        new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DT", 18), new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_BIRTH_DTTZ", 19),
        new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_BIRTH_DT", 20), new Type_IntegerPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "BENE_SEX_IDENT_CD", 21),
        new Type_IntegerPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "SP_STATE_CODE", 22)
    });



    public static void main(String[] args)
    throws Exception
      {
        SystemValues.autoInit();

        // toto();

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
            + " AND (    CLM_PMT_AMT >= 2*(6+?{var1})" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
        };

        for (int i = 0; i < Expressions.length; ++i)
          {
            String Expr = Expressions[i];
            boolean display = Expr.startsWith("@") == true; // If the expression's first char is '@', we'll display the parse tree and results.
            if (display == true)
              Expr = Expr.substring(1);
            LOG.debug("\n\n\n----------------------------------------------------------------------------------");
            LOG.debug("Parsing expression " + i + ".");
            LOG.debug("    --> " + Expr);
            long T0 = System.nanoTime();
            long TCompile = 0;
            TildaSQLValidator Validator = new TildaSQLValidator(Expr);
            if (Validator.getParserSyntaxErrors() != 0)
              {
                LOG.error("    --> Expression " + i + " failed with " + Validator.getParserSyntaxErrors() + " errors.");
              }
            else
              {
                LOG.debug("SUCCESS Parsing");
                if (display == true)
                  {
                    // TildaSQLTreePrinter w1 = new TildaSQLTreePrinter(parser);
                    // ParseTreeWalker.DEFAULT.walk(w1, tree);
                    // LOG.debug("expr: " + Expr);
                    // LOG.debug(w1._ParseTreeStr.toString());

                    WhereClauseCodeGenJava CG = new WhereClauseCodeGenJava("Rule1");
                    Validator.setCodeGen(CG);
                    Validator.setColumnEnvironment(_COLS);
                    Validator.validate();
                    LOG.debug(CG._CodeGen.toString());
                    Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
                    if (I != null)
                      {
                        LOG.error("Some Validation errors occurred");
                        while (I.hasNext() == true)
                          LOG.error("        " + I.next());
                      }
                    else
                      {
                        TildaCompositionValidator Validator2 = new TildaCompositionValidator("wc1 and wc2", CollectionUtil.toList(new String[] { "wc1", "wc2"}));
                        if (Validator2.getParserSyntaxErrors() != 0)
                          {
                            LOG.error("    --> Composition expression failed with " + Validator2.getParserSyntaxErrors() + " errors.");
                          }
                        else
                          {
                            WhereClauseCompositionCodeGenJava CG2 = new WhereClauseCompositionCodeGenJava();
                            Validator2.setCodeGen(CG2);
                            Validator2.validate();
                            LOG.debug(CG2._CodeGen.toString());
                            I = Validator.getValidationErrors().getErrors();
                            if (I != null)
                              {
                                LOG.error("Some Validation errors occurred");
                                while (I.hasNext() == true)
                                  LOG.error("        " + I.next());
                              }
                            else
                              {
                                WhereClauseCompositionClassGenerator WCCG = new WhereClauseCompositionClassGenerator(CG2._CodeGen.toString());
                                WCCG.addWhereClauseDef("wc1", CG._CodeGen.toString());
                                WCCG.addWhereClauseDef("wc2", CG._CodeGen.toString());
                                long T1 = System.nanoTime();
                                CompiledWhereClause CWC = WCCG.gen("tilda._gen.cwc", CG.getName(), TestObject.class);
                                TCompile += System.nanoTime() - T1;
                                int MaxCount = 100000;
                                for (int j = 0; j < MaxCount; ++j)
                                  {
                                    boolean x = CWC.run(new TestObject(), j);
                                    // LOG.debug(" Run "+(j+1)+": " + x);
                                  }
                                T0 = System.nanoTime() - T0;
                                LOG.debug("Total   time: " + DurationUtil.PrintDuration(T0) + " at " + DurationUtil.PrintPerformancePerMinute(T0, MaxCount) + " rules/mn");
                                LOG.debug("Compile time: " + DurationUtil.PrintDuration(TCompile) + " at " + DurationUtil.PrintPerformancePerMinute(TCompile, MaxCount) + " rules/mn");
                                LOG.debug("Other   time: " + DurationUtil.PrintDuration(T0 - TCompile) + " at " + DurationUtil.PrintPerformancePerMinute(T0 - TCompile, MaxCount) + " rules/mn");
                              }
                          }
                      }
                  }
              }
          }
      }


    public static void toto()
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
        + " AND (    CLM_PMT_AMTr >= 2*((5+(?{var1}+1)))" + SystemValues.NEWLINE
        + "     )" + SystemValues.NEWLINE;

        TildaSQLValidator Validator = new TildaSQLValidator(Expr);
        Validator.setColumnEnvironment(_COLS);

        if (Validator.getParserSyntaxErrors() != 0)
          LOG.error("    --> " + Validator.getParserSyntaxErrors() + " ERROR(S).");
        else
          {
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
              }
          }
      }
  }
