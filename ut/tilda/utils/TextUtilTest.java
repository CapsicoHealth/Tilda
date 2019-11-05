/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(TextUtilTest.class.getName());

    public static void main(String[] args)
      {
//        Test_SimplifyName();
        Test_SearchReplace();
//        Test2();
//        Test3();
//        Test4();
//        Test_Perf_toString_type_vs_cast();
//          Test_FindLikeElement();
//          Test_Perf_endsWith_vs_charAt();
//          Test_isNullOrEmpty();
      }

    private static void Test_isNullOrEmpty()
      {
        String S0 = null;
        String S1 = "";
        String S2 = "    ";
        
        String[] A0 = null;
        String[] A1 = new String[0];
        String[] A2 = new String[1];
        String[] A3 = new String[] {S0};
        String[] A4 = new String[] {S1};
        String[] A5 = new String[] {S0, S1, S2};
        String[] A6 = new String[] {S0, S1, S2, "aaa"};
        
        List<String> L0 = CollectionUtil.toList(A0);
        List<String> L1 = CollectionUtil.toList(A1);
        List<String> L2 = CollectionUtil.toList(A2);
        List<String> L3 = CollectionUtil.toList(A3);
        List<String> L4 = CollectionUtil.toList(A4);
        List<String> L5 = CollectionUtil.toList(A5);
        List<String> L6 = CollectionUtil.toList(A6);
        
        if (TextUtil.isNullOrEmpty(L0) == false) LOG.error("L0 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L1) == false) LOG.error("L1 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L2) == false) LOG.error("L2 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L3) == false) LOG.error("L3 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L4) == false) LOG.error("L4 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L5) == false) LOG.error("L5 is not null or empty!");
        if (TextUtil.isNullOrEmpty(L6) == true) LOG.error("L6 is null or empty!");
        
        LOG.debug("Tests for isNullOrEmpty all passed");
        
      }

    private static void Test_Perf_endsWith_vs_charAt()
      {
        String[] A = new String[1000000];
        System.out.println("Initializing Test_Perf_endsWith_vs_charAt with "+NumberFormatUtil.printWith000Sep(A.length)+" elements");
        for (int i = 0; i < A.length; ++i)
         A[i] = (i%10 == 0 ? "*":"")+EncryptionUtil.getToken(RandomUtil.pick(10, 100))+(i%5 == 0 && i%10 != 0 ? "*":"");

        System.out.println("Starting test cases");
        long T0 = System.nanoTime();
        int count = 0;
        for (int i = 0; i < A.length; ++i)
          {        
            if (A[i].endsWith("*") == true)
             ++count;
          }
        System.out.println("count: "+count+"; endsWith: " + DurationUtil.printDuration(System.nanoTime() - T0));

        T0 = System.nanoTime();
        count = 0;
        for (int i = 0; i < A.length; ++i)
          {        
            if (A[i].charAt(A[i].length()-1) == '*')
             ++count;
          }              
        System.out.println("count: "+count+"; charAt(length-1): " + DurationUtil.printDuration(System.nanoTime() - T0));
        
        T0 = System.nanoTime();
        count = 0;
        for (int i = 0; i < A.length; ++i)
          {        
            if (A[i].startsWith("*") == true)
             ++count;
          }
        System.out.println("count: "+count+"; startsWith: " + DurationUtil.printDuration(System.nanoTime() - T0));

        T0 = System.nanoTime();
        count = 0;
        for (int i = 0; i < A.length; ++i)
          {        
            if (A[i].charAt(0) == '*')
             ++count;
          }              
        System.out.println("charAt(0): " + DurationUtil.printDuration(System.nanoTime() - T0));

      }
    

    private static void Test_FindLikeElement()
      {
        String[] A = {"abc", "def", "aaa*", "xyz", "xyz*"};
        String[] ValArray = {"abc", "a", "aaa", "aaaaaaaaaaaaaa", "aaaa", "xyz123", "xyz"};
        int PosArray[] = {0, -1, 2, 2, 2, 4, 3};
        
        for (int i = 0; i < ValArray.length; ++i)
          {
            int pos = TextUtil.findStarElement(A, ValArray[i], false, 0);
            String Msg = "i: "+i+"; Val: "+ValArray[i]+"; Pos: "+pos+"; ExpectedPos: "+PosArray[i]+"; Status: "+(pos == PosArray[i] ? "OK":"ERROR");
            if (pos == PosArray[i])
             LOG.debug(Msg);
             else               
             LOG.error(Msg);
          }
        
        
        for (int i = 0; i < ValArray.length; ++i)
          ValArray[i] = ValArray[i].toUpperCase();
        
        for (int i = 0; i < ValArray.length; ++i)
          {
            int pos = TextUtil.findStarElement(A, ValArray[i], true, 0);
            String Msg = "i: "+i+"; Val: "+ValArray[i]+"; Pos: "+pos+"; ExpectedPos: "+PosArray[i]+"; Status: "+(pos == PosArray[i] ? "OK":"ERROR");
            if (pos == PosArray[i])
             LOG.debug(Msg);
             else               
             LOG.error(Msg);
          }
        
        PosArray = new int[] {-1, -1, -1, -1,-1, -1, -1};
        for (int i = 0; i < ValArray.length; ++i)
          {
            int pos = TextUtil.findStarElement(A, ValArray[i], false, 0);
            String Msg = "i: "+i+"; Val: "+ValArray[i]+"; Pos: "+pos+"; ExpectedPos: "+PosArray[i]+"; Status: "+(pos == PosArray[i] ? "OK":"ERROR");
            if (pos == PosArray[i])
             LOG.debug(Msg);
             else               
             LOG.error(Msg);
          }
        
        
      }

    private static void Test_Perf_toString_type_vs_cast()
      {
          {
            long T0 = System.nanoTime();
            StringBuilder Str = new StringBuilder();
            for (int i = 0; i < 100000; ++i)
              {
                Str.append(Boolean.toString(true));
                Str.append(Integer.toString(1233463576));
                Str.append(Double.toString(235625624.256));
              }
            System.out.println("Type-based toString(): " + DurationUtil.printDuration(System.nanoTime() - T0));
          }

          {
            long T0 = System.nanoTime();
            StringBuilder Str = new StringBuilder();
            for (int i = 0; i < 100000; ++i)
              {
                Str.append(((Boolean)true).toString());
                Str.append(((Integer)1233463576).toString());
                Str.append(((Double)235625624.256).toString());
              }
            System.out.println("cast-based toString(): " + DurationUtil.printDuration(System.nanoTime() - T0));
          }
      }

    private static void Test4()
      {
        boolean[] b = new boolean[] { true, true, false, true, false, false, false
        };
        int[] i = new int[] { 1, 2, 4, 3, 6, 7, 9, 5, 8
        };
        char[] c = new char[] { 'a', 'f', 'r', 'g', 'y', 'h'
        };
        double[] d = new double[] { 1.32, 45.3, 432.24, 4.5, 5.12, 6.6576
        };
        String[] s = new String[] { "aaaaa", "bb\"bb", "ccc\'ccc", "dd\"ddd"
        };

        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(s));
      }

    private static void Test3()
      {
          {
            long T0 = System.nanoTime();
            for (int i = 0; i < 10000; ++i)
              {
                StringWriter Str = new StringWriter();
                PrintWriter Out = new PrintWriter(Str);
                for (int j = 0; j < 10000; ++j)
                  {
                    Out.print(", ");
                    Out.print("1234567890");
                    Out.print("=?");
                  }
              }
            System.out.println("PrintWriter.print: " + DurationUtil.printDuration(System.nanoTime() - T0));
          }
          {
            long T0 = System.nanoTime();
            for (int i = 0; i < 10000; ++i)
              {
                StringWriter Str = new StringWriter();
                PrintWriter Out = new PrintWriter(Str);
                for (int j = 0; j < 10000; ++j)
                  {
                    Out.write(", ");
                    Out.write("1234567890");
                    Out.write("=?");
                  }
              }
            System.out.println("PrintWriter.write: " + DurationUtil.printDuration(System.nanoTime() - T0));
          }
      }

    private static void Test2()
      {

        final String CommaSpace = ", ";
        final String Txt = "1234567890";
        final String EqualsQuestion = "=?";

          {
            StringBuilder Str = new StringBuilder();
            long T0 = System.nanoTime();
            for (int i = 0; i < 1000000; ++i)
              {
                for (int j = 0; j < 1000; ++j)
                  Str.append(", ").append("1234567890").append("=?");
                Str.setLength(0);
              }
            System.out.println("All 3 parts separate litteral: " + DurationUtil.printDuration(System.nanoTime() - T0));
          }

          {
            StringBuilder Str = new StringBuilder();
            long T0 = System.nanoTime();
            for (int i = 0; i < 1000000; ++i)
              {
                for (int j = 0; j < 1000; ++j)
                  Str.append(", 1234567890=?");
                Str.setLength(0);
              }
            System.out.println("All 3 parts together in single litteral: " + DurationUtil.printDuration(System.nanoTime() - T0));
          }

          {
            StringBuilder Str = new StringBuilder();
            long T0 = System.nanoTime();
            for (int i = 0; i < 1000000; ++i)
              {
                for (int j = 0; j < 1000; ++j)
                  Str.append(CommaSpace).append(Txt).append(EqualsQuestion);
                Str.setLength(0);
              }
            System.out.println("All 3 parts separate as constants: " + DurationUtil.printDuration(System.nanoTime() - T0));
          }

      }

    private static void Test_SearchReplace()
      {
        String Str = "update TILDA.KEY set TILDA.KEY.\"max\"=TILDA.KEY.\"max\"+TILDA.KEY.\"count\"";
        String TableName = "TILDA.KEY.";
        long T0 = System.nanoTime();
        int runs = 10_000_000;
        for (int i = 0; i < runs; ++i)
          {
            TextUtil.searchReplace(Str, TableName, "");
          }
        System.out.println("TextUtil.SearchReplace: " + DurationUtil.printDuration(System.nanoTime() - T0));

        T0 = System.nanoTime();
        TableName = "TILDA\\.KEY\\.";
        for (int i = 0; i < runs; ++i)
          {
            Str.replaceAll(TableName, "");
          }
        System.out.println("String.replaceAll: " + DurationUtil.printDuration(System.nanoTime() - T0));
      }
    
    
    
    
    
    public static String SimplifyName_Custom1(String Name)
      {
        if (Name == null)
          return null;
        StringBuilder Str = new StringBuilder(Name.length());
        char C[] = Name.toCharArray();
        for (char c : C)
          {
            if (Character.isLetterOrDigit(c) == true)
             Str.append(Character.toLowerCase(c));
          }
        return Str.toString();
      }
    public static String SimplifyName_Custom2(String Name)
      {
        if (Name == null)
          return null;
        StringBuilder Str = new StringBuilder(Name.length());
        for (int i = 0; i < Name.length(); ++i)
          {
            char c = Name.charAt(i);
            if (Character.isLetterOrDigit(c) == true)
             Str.append(Character.toLowerCase(c));
          }
        return Str.toString();
      }
    public static String SimplifyName_Regex1(String Name)
      {
        if (Name == null)
          return null;
        return Name.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
      }
    protected static Pattern P = Pattern.compile("([^A-Za-z0-9]+)");
    public static String SimplifyName_Regex2(String Name)
      {
        if (Name == null)
          return null;
        Matcher M = P.matcher(Name);
        StringBuilder Str = new StringBuilder();
        int pos = 0;
        while (M.find() == true)
          {
            if (pos != M.start())
             Str.append(Name.substring(pos, M.start()));
            pos=M.end();
          }
        if (pos < Name.length())
         Str.append(Name.substring(pos, Name.length()));

        return Str.toString().toLowerCase();
      }
    public static String SimplifyName_Regex3(String Name)
      {
        if (Name == null)
          return null;
        Matcher M = P.matcher(Name);
        StringBuffer Str = new StringBuffer();
        while (M.find() == true)
          M.appendReplacement(Str, "");
        M.appendTail(Str);
        return Str.toString().toLowerCase();
      }
    public static String SimplifyName_Regex4(String Name)
      {
        if (Name == null)
          return null;
        return P.matcher(Name).replaceAll("").toLowerCase();
      }
    
    private static void Test_SimplifyName()
     {
       String test = "      This is a 475 a long *&*   test, and with #$^# lots of @#%@weird chars.   ";
       
       String VCustom1 = SimplifyName_Custom1(test);
       String VCustom2 = SimplifyName_Custom2(test);
       String VRegex1  = SimplifyName_Regex1 (test);
       String VRegex2  = SimplifyName_Regex2 (test);
       String VRegex3  = SimplifyName_Regex3 (test);
       String VRegex4  = SimplifyName_Regex4 (test);
       
       if (VCustom1.equals(VCustom2) == false)
         {
           LOG.error("ERROR: VCustom1 = '"+VCustom1+"'.");
           LOG.error("ERROR: VCustom2 = '"+VCustom2+"'.");
         }

       if (VCustom1.equals(VRegex1) == false)
         {
           LOG.error("ERROR: VCustom1 = '"+VCustom1+"'.");
           LOG.error("ERROR: VRegex1  = '"+VRegex1+"'.");
         }
       if (VCustom1.equals(VRegex2) == false)
         {
           LOG.error("ERROR: VCustom1 = '"+VCustom1+"'.");
           LOG.error("ERROR: VRegex1  = '"+VRegex2+"'.");
         }
       if (VCustom1.equals(VRegex3) == false)
         {
           LOG.error("ERROR: VCustom1 = '"+VCustom1+"'.");
           LOG.error("ERROR: VRegex3  = '"+VRegex3+"'.");
         }
       if (VCustom1.equals(VRegex4) == false)
         {
           LOG.error("ERROR: VCustom1 = '"+VCustom1+"'.");
           LOG.error("ERROR: VRegex4  = '"+VRegex4+"'.");
         }
       
       final int count = 1000000;
       
       long T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Custom1(test);
         }
       LOG.info("SimplifyName_Custom1: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");

       T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Custom2(test);
         }
       LOG.info("SimplifyName_Custom2: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");
       
       T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Regex1(test);
         }
       LOG.info("SimplifyName_Regex1: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");
       
       T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Regex2(test);
         }
       LOG.info("SimplifyName_Regex2: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");
       
       T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Regex3(test);
         }
       LOG.info("SimplifyName_Regex3: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");
       
       T0 = System.nanoTime();
       for (int i = 0; i < count; ++i)
         {
           SimplifyName_Regex4(test);
         }
       LOG.info("SimplifyName_Regex4: " + DurationUtil.printPerformancePerSecond(System.nanoTime() - T0, count)+" ops.");
     }
  }
