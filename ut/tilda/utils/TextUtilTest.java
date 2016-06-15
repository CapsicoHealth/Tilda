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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(TextUtilTest.class.getName());

    public static void main(String[] args)
      {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
      }

    private static void Test5()
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
            System.out.println("Type-based toString(): " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("cast-based toString(): " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("PrintWriter.print: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("PrintWriter.write: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("All 3 parts separate litteral: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("All 3 parts together in single litteral: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
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
            System.out.println("All 3 parts separate as constants: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
          }

      }

    private static void Test1()
      {
        String Str = "update TILDA.KEY set TILDA.KEY.\"max\"=TILDA.KEY.\"max\"+TILDA.KEY.\"count\"";
        String TableName = "TILDA.KEY";
        long T0 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i)
          {
            TextUtil.SearchReplace(Str, TableName + ".", "");
          }
        System.out.println("TextUtil.SearchReplace: " + DurationUtil.PrintDuration(System.nanoTime() - T0));

        T0 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i)
          {
            Str.replaceAll(TableName.replaceAll("\\.", "\\.") + ".", "");
          }
        System.out.println("String.replaceAll: " + DurationUtil.PrintDuration(System.nanoTime() - T0));
      }
  }
