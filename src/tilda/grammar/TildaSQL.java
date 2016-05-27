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
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.SystemValues;

public class TildaSQL
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());

    public static void main(String[] args)
    throws Exception
      {
        SystemValues.autoInit();
        
        String[] Expressions = {"toto = 'dodo'"
//                               ,"toto = CURRENT_TIME"
//                               ,"toto <= TIMESTAMP_TOMORROW_LAST"
//                               ,"toto = tata"
//                               ,"toto > tata"
//                               ,"toto > tata-1"
//                               ,"toto > 2*tata-1"
//                               ,"toto=1 AND tata=2 AND titi=3"
//                               ,"toto=1 AND (tata=2 OR tata=3 OR tata=4 OR tata=5) AND (titi=1 OR titi <>10)"
//                               ,"(1+2)*5-4/2 >= 3*(1+toto)/tata"
                               ,"@toto.acadabra >= 3*(1+?{var1})/?{var2} && gogo.barilla > gaga.panzani and (gigi.date > CURRENT_TIMESTAMP OR gugu.deleted > '2016-01-01' OR titi >= TIMESTAMP_TODAY)"
//                               ,"     (toto.daysPostEpisode+1)*2 <= 7-toto.xyz "+SystemValues.NEWLINE
//                                 +" AND (    ( principalDischargeICD9 LIKE '410.%' AND  principalDischargeICD9 NOT LIKE '410._2' )"+SystemValues.NEWLINE
//                                 +"       OR ( secondaryDischargeICD9 LIKE '410.%' AND  secondaryDischargeICD9 NOT LIKE '410._2' )"+SystemValues.NEWLINE
//                                 +"     )"+SystemValues.NEWLINE
//                                 +" AND tawa(secondaryDischargeICD9, 12) = 1"+SystemValues.NEWLINE  
//                                 +" AND lower(secondaryDischargeICD9) == 'abc'"+SystemValues.NEWLINE  
//                                 +" AND (    papa.secondaryDischargeICD9 == '2001-03-11'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-06-11T22:00:30'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00:30+00:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '3001-03-11T22:00:30+00:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-14-11T22:00:30+00:00'"+SystemValues.NEWLINE
//                                 +"        OR papa.secondaryDischargeICD9 == '2001-03-44T22:00:30+00:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-03-11T32:00:30+00:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:70:30+00:00'"+SystemValues.NEWLINE
//                                 +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00:70+00:00'"+SystemValues.NEWLINE
//                                 +"     )"+SystemValues.NEWLINE
//                                 +" AND (    papa.count1 > 2*(papa.count2+5+?{var1}+1)"+SystemValues.NEWLINE
//                                 +"     )"+SystemValues.NEWLINE
                               };
        
        List<String> Failures = new ArrayList<String>();
        for (int i = 0; i < Expressions.length; ++i)
         {
           String Expr = Expressions[i];
           boolean display = Expr.startsWith("@") == true; // If the expression's first char is '@', we'll display the parse tree and results.
           if (display == true)
            Expr = Expr.substring(1); 
           LOG.debug("\n\n\n----------------------------------------------------------------------------------");
           LOG.debug("Parsing expression "+i+".");
           LOG.debug("    --> "+Expr);
           ANTLRInputStream in = new ANTLRInputStream(Expr);
           TildaSQLLexer lexer = new TildaSQLLexer(in);
           CommonTokenStream tokens = new CommonTokenStream(lexer);
           TildaSQLParser parser = new TildaSQLParser(tokens);
           ParseTree tree = parser.where();
           
           if (parser.getNumberOfSyntaxErrors() == 0)
            LOG.debug("SUCCESS");
           else
             {
               Failures.add("Expression "+i+" failed with "+parser.getNumberOfSyntaxErrors()+" errors.");
               LOG.error("    --> "+parser.getNumberOfSyntaxErrors()+" ERROR(S).");
             }
           if (display == true)
             {
               TildaSQLTreePrinter w1 = new TildaSQLTreePrinter(parser);
               ParseTreeWalker.DEFAULT.walk(w1, tree);
               LOG.debug("expr: "+Expr);
               LOG.debug(w1._ParseTreeStr.toString());
               
               TildaSQLCodeGen w2 = new TildaSQLCodeGen(parser);
               ParseTreeWalker.DEFAULT.walk(w2, tree);
               LOG.debug("expr: "+Expr);
               LOG.debug(w2._CodeGen.toString());
             }
         }

        LOG.debug("\n\n\n========================================================================================================");
        if (Failures.isEmpty() == false)
         {
           LOG.error("One or more expressions failed:");
           for (String str : Failures)
             LOG.error("    "+str);
         }
        else
         {
           LOG.debug("Success.");
         }
        
      }
 }
