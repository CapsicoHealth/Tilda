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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JSONUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(JSONUtilTest.class.getName());

    public static void main(String[] args)
      {
        try
          {
            Test1();
          }
        catch (IOException e)
          {
            e.printStackTrace();
          }
      }

    public static <T> void PrintPrimitiveArray(Writer Out, T[] a)
      throws IOException
      {
        Out.write("[");
        boolean First = true;
        for (T i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(",");
            Out.write(((Object) i).toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, boolean[] a)
      throws IOException
      {
        PrintPrimitiveArray(Out, CollectionUtil.toObjectArray(a));
      }

    public static <T> void Print2(Writer Out, boolean[] a)
      throws IOException
      {
        Out.write("[");
        boolean First = true;
        for (boolean i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(",");
            Out.write(Boolean.toString(i));
          }
        Out.write("]");
      }

    private static void Test1()
      throws IOException
      {
        boolean[] A = new boolean[] { true, true, false, true, false, false, true, true, true, false, true, true, false, true, false, false, true, true, true, false, true, true, false, true, false, false, true, true, true,
            false, true, true, false, true, false, false, true, true, true, false, true, true, false, true, false, false, true, true, true, false, true, true, false, true, false, false, true, true, true, false, true, true,
            false, true, false, false, true, true, true, false, true, true, false, true, false, false, true, true, true, false
        };
          {
            long T0 = System.nanoTime();
            for (int i = 0; i < 1000; ++i)
              {
                StringWriter Str = new StringWriter();
                PrintWriter Out = new PrintWriter(Str);
                for (int j = 0; j < 1000; ++j)
                  {
                    Print(Out, A);
                  }
              }
            System.out.println("Print1 (via generics and casting): " + DurationUtil.PrintDuration(System.nanoTime() - T0));
          }
          {
            long T0 = System.nanoTime();
            for (int i = 0; i < 1000; ++i)
              {
                StringWriter Str = new StringWriter();
                PrintWriter Out = new PrintWriter(Str);
                for (int j = 0; j < 1000; ++j)
                  {
                    Print2(Out, A);
                  }
              }
            System.out.println("Print2 (no casting): " + DurationUtil.PrintDuration(System.nanoTime() - T0));
          }
      }
  }
