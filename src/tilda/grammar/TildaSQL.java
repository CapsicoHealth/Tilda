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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
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
import tilda.utils.DurationUtil;
import tilda.utils.SystemValues;

public class TildaSQL
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());

    public static void main(String[] args)
    throws Exception
      {
        SystemValues.autoInit();

        List<ColumnDefinition> Cols = CollectionUtil.toList(new ColumnDefinition[] {
              new Type_StringPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "DESYNPUF_ID", 0)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_ADMSN_DTTZ", 1)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_ADMSN_DT", 2)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_FROM_DTTZ", 3)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_FROM_DT", 4)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "NCH_BENE_DSCHRG_DTTZ", 5)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "NCH_BENE_DSCHRG_DT", 6)
            , new Type_FloatPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_PMT_AMT", 7)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_THRU_DTTZ", 8)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_THRU_DT", 9)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "PRVDR_CLASS", 10)
            , new Type_CharPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_TYPE", 11)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_DGNS_CD", 12)
            , new Type_StringCollectionNull("CMS.CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_DGNS_CD", 13)
            , new Type_StringPrimitiveNull ("CMS.CLAIMSBENEFICIARYVIEW", "PRIMARY_ICD9_PRCDR_CD"  , 14)
            , new Type_StringCollectionNull("CMS.CLAIMSBENEFICIARYVIEW", "SECONDARY_ICD9_PRCDR_CD", 15)
            , new Type_IntegerPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "CLM_UTLZTN_DAY_CNT", 16)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DTTZ", 17)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_DEATH_DT", 18)
            , new Type_StringPrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_BIRTH_DTTZ", 19)
            , new Type_DatetimePrimitiveNull("CMS.CLAIMSBENEFICIARYVIEW", "BENE_BIRTH_DT", 20)
            , new Type_IntegerPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "BENE_SEX_IDENT_CD", 21)
            , new Type_IntegerPrimitive("CMS.CLAIMSBENEFICIARYVIEW", "SP_STATE_CODE", 22)
          });

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
            , "@    CLM_TYPE = 'I' " + SystemValues.NEWLINE
            + " AND PRVDR_CLASS = 'Abc' " + SystemValues.NEWLINE
            + " AND (    ( PRIMARY_ICD9_DGNS_CD   LIKE '410.%' AND  PRIMARY_ICD9_DGNS_CD   NOT LIKE '410._2' )" + SystemValues.NEWLINE
            + "       OR ( SECONDARY_ICD9_DGNS_CD LIKE '410.%' AND  SECONDARY_ICD9_DGNS_CD NOT LIKE '410._2' )" + SystemValues.NEWLINE
            + "       OR PRIMARY_ICD9_DGNS_CD+PRIMARY_ICD9_PRCDR_CD in ('428.5', '428.54', '1')" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
            + " AND PRIMARY_ICD9_PRCDR_CD not in ('234.23', '11.22')" + SystemValues.NEWLINE
            // +" AND tawa(secondaryDischargeICD9, 12) = 1"+SystemValues.NEWLINE
            // +" AND lower(secondaryDischargeICD9) == 'abc'"+SystemValues.NEWLINE
            + "  AND (   BENE_BIRTH_DT = '2001-03-11'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-03-11T22:00'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-06-11T22:00:30'" + SystemValues.NEWLINE
            + "       OR BENE_BIRTH_DT = '2001-03-11T22:00:30+00:00'" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
            + " AND (    CLM_PMT_AMT > 2*((5+(?{var1}+1)))" + SystemValues.NEWLINE
            + "     )" + SystemValues.NEWLINE
        };

        List<String> Failures = new ArrayList<String>();
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
            ANTLRInputStream in = new ANTLRInputStream(Expr);
            TildaSQLLexer lexer = new TildaSQLLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TildaSQLParser parser = new TildaSQLParser(tokens);
            ParseTree tree = parser.where();

            if (parser.getNumberOfSyntaxErrors() == 0)
              LOG.debug("SUCCESS Parsing");
            else
              {
                Failures.add("Expression " + i + " failed with " + parser.getNumberOfSyntaxErrors() + " errors.");
                LOG.error("    --> " + parser.getNumberOfSyntaxErrors() + " ERROR(S).");
              }
            if (display == true)
              {
                // TildaSQLTreePrinter w1 = new TildaSQLTreePrinter(parser);
                // ParseTreeWalker.DEFAULT.walk(w1, tree);
                // LOG.debug("expr: " + Expr);
                // LOG.debug(w1._ParseTreeStr.toString());

                TildaSQLListenerValidator w2 = new TildaSQLListenerValidator();
                CodeGenTildaJavaExpression CG = new CodeGenTildaJavaExpression();
                w2.setColumnEnvironment(Cols);
                w2.setCodeGen(CG);
                ParseTreeWalker.DEFAULT.walk(w2, tree);
                Iterator<String> I = w2.getErrors().getErrors();
                // LOG.debug("expr: " + Expr);
                if (I != null)
                  {
                    LOG.error("Some Validation errors occurred");
                    while (I.hasNext() == true)
                      LOG.error("        " + I.next());
                  }
                LOG.debug(CG._CodeGen.toString());
              }

            LOG.debug("Took: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
          }

        LOG.debug("\n\n\n========================================================================================================");
        if (Failures.isEmpty() == false)
          {
            LOG.error("One or more expressions failed:");
            for (String str : Failures)
              LOG.error("    " + str);
          }
        else
          {
            LOG.debug("Success.");
          }

      }
  }
