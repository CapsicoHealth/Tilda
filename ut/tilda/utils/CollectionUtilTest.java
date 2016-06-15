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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CollectionUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(CollectionUtilTest.class.getName());

    public static void main(String[] args)
      {
        Test3ListToArray();
        Test3SetToArray();
        Test3ArrayToListAndSet();
        Test1();
        Test2();
      }

    private static void Test1()
      {
        List<String> L1 = new ArrayList<String>();
        L1.add("abc1");
        L1.add("abc2");
        L1.add("abc3");
        L1.add("abc4");

        List<Object> L2 = new ArrayList<Object>();
        L2.add("abc1");
        L2.add("abc2");
        L2.add("abc3");
        L2.add("abc4");


        Object[] A = new Object[0];
        LOG.debug(L1.getClass().getCanonicalName() + " -> " + A.getClass().getCanonicalName());
        A = CollectionUtil.toObjectArray(L1);
        for (Object o : A)
          LOG.debug("   " + o.toString());
        LOG.debug(L2.getClass().getCanonicalName() + " -> " + A.getClass().getCanonicalName());
        A = CollectionUtil.toObjectArray(L2);
        for (Object o : A)
          LOG.debug("   " + o.toString());
      }

    private static void Test2()
      {
        String[] A = new String[] { "abc1", "abc2", "abc3"
        };
        List<String> L = CollectionUtil.toList(A);
        if (L != null)
         LOG.debug(L);
      }


    static final int _Size       = 20;
    static final int _Iterations = 10000000;


    private static Object[] toObjectArrayNative(List<?> L)
      {
        if (L == null)
          return null;
        return L.toArray(new Object[L.size()]);
      }

    private static Object[] toObjectArrayCustom(List<?> L)
      {
        if (L == null)
          return null;
        Object[] A = new Object[L.size()];
        for (int i = 0; i < L.size(); ++i)
          A[i] = L.get(i);
        return A;
      }

    private static void Test3ListToArray()
      {
        List<String> L = new ArrayList<String>();
        for (int i = 1; i < _Size; ++i)
          L.add("abc" + i);

        LOG.debug("");
        long T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toObjectArrayNative(L);
        LOG.debug("toObjectArrayNative(List): " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");

        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toObjectArrayCustom(L);
        LOG.debug("toObjectArrayCustom(List): " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");
      }

    private static Object[] toObjectArrayNative(Set<?> S)
      {
        if (S == null)
          return null;
        return S.toArray(new Object[S.size()]);
      }

    private static Object[] toObjectArrayCustom(Set<?> S)
      {
        if (S == null)
          return null;
        Object[] A = new Object[S.size()];
        int i = -1;
        for (Object o : S)
          A[++i] = o;
        return A;
      }

    private static void Test3SetToArray()
      {
        Set<String> S = new HashSet<String>();
        for (int i = 1; i < _Size; ++i)
          S.add("abc" + i);

        LOG.debug("");
        long T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toObjectArrayNative(S);
        LOG.debug("toObjectArrayNative(Set): " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");

        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toObjectArrayCustom(S);
        LOG.debug("toObjectArrayCustom(Set): " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");
      }

    private static <T> List<T> toListNativeCollections(T[] A)
      {
        List<T> L = new ArrayList<T>();
        Collections.addAll(L, A);
        return L;
      }

    private static <T> List<T> toListNativeArrays(T[] A)
      {
        return Arrays.asList(A);
      }

    private static <T> List<T> toListCustom(T[] A)
      {
        List<T> L = new ArrayList<T>();
        if (A != null)
          for (T a : A)
            L.add(a);
        return L;
      }

    private static <T> Set<T> toSetNative(T[] A)
      {
        Set<T> S = new HashSet<T>();
        Collections.addAll(S, A);
        return S;
      }

    private static <T> Set<T> toSetCustom(T[] A)
      {
        Set<T> S = new HashSet<T>();
        if (A != null)
          for (T a : A)
            S.add(a);
        return S;
      }


    private static void Test3ArrayToListAndSet()
      {

        String[] A = new String[25];
        for (int i = 1; i < _Size; ++i)
          A[i] = "abc" + i;

        LOG.debug("");
        long T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toListNativeCollections(A);
        LOG.debug("toListNativeCollections: " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");

        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toListNativeArrays(A);
        LOG.debug("toListNativeArrays     : " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");

        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toListCustom(A);
        LOG.debug("toListCustom           : " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");


        LOG.debug("");
        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toSetNative(A);
        LOG.debug("toSetNative: " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");

        T0 = System.nanoTime();
        for (int i = 0; i < _Iterations; ++i)
          toSetCustom(A);
        LOG.debug("toSetCustom: " + DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, _Iterations) + " iterations/s");
      }

  }
