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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.JDBCHelper;

public class CollectionUtil
  {
    protected static final Logger    LOG             = LogManager.getLogger(JDBCHelper.class.getName());

    protected static final Boolean[] EMPTY_BOOLEAN_O = {};

    public static Boolean[] toObjectArray(boolean[] a)
      {
        if (a == null)
          return EMPTY_BOOLEAN_O;
        Boolean[] A = new Boolean[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final boolean[] EMPTY_BOOLEAN_P = {};

    public static boolean[] toPrimitiveArray(Boolean[] a)
      {
        if (a == null)
          return EMPTY_BOOLEAN_P;
        boolean[] A = new boolean[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }


    protected static final Integer[] EMPTY_INTEGER_O = {};

    public static Integer[] toObjectArray(int[] a)
      {
        if (a == null)
          return EMPTY_INTEGER_O;
        Integer[] A = new Integer[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final int[] EMPTY_INTEGER_P = {};

    public static int[] toPrimitiveArray(Integer[] a)
      {
        if (a == null)
          return EMPTY_INTEGER_P;
        int[] A = new int[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }


    protected static final Long[] EMPTY_LONG_O = {};

    public static Long[] toObjectArray(long[] a)
      {
        if (a == null)
          return EMPTY_LONG_O;
        Long[] A = new Long[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final long[] EMPTY_LONG_P = {};

    public static long[] toPrimitiveArray(Long[] a)
      {
        if (a == null)
          return EMPTY_LONG_P;
        long[] A = new long[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }


    protected static final Float[] EMPTY_FLOAT_O = {};

    public static Float[] toObjectArray(float[] a)
      {
        if (a == null)
          return EMPTY_FLOAT_O;
        Float[] A = new Float[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final float[] EMPTY_FLOAT_P = {};

    public static float[] toPrimitiveArray(Float[] a)
      {
        if (a == null)
          return EMPTY_FLOAT_P;
        float[] A = new float[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final Double[] EMPTY_DOUBLE_O = {};

    public static Double[] toObjectArray(double[] a)
      {
        if (a == null)
          return EMPTY_DOUBLE_O;
        Double[] A = new Double[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final double[] EMPTY_DOUBLE_P = {};

    public static double[] toPrimitiveArray(Double[] a)
      {
        if (a == null)
          return EMPTY_DOUBLE_P;
        double[] A = new double[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final Character[] EMPTY_CHARACTER_O = {};

    public static Character[] toObjectArray(char[] a)
      {
        if (a == null)
          return EMPTY_CHARACTER_O;
        Character[] A = new Character[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final char[] EMPTY_CHARACTER_P = {};

    public static char[] toPrimitiveArray(Character[] a)
      {
        if (a == null)
          return EMPTY_CHARACTER_P;
        char[] A = new char[a.length];
        for (int i = 0; i < a.length; ++i)
          A[i] = a[i];
        return A;
      }

    protected static final Object[] EMPTY_OBJECT_O = {};

    public static Object[] toObjectArray(List<?> L)
      {
        // LDH-NOTE: tried the implementation with a loop and it's about 30% slower. So, keeping the native impl.
        // See CollectionUtilTest.

        if (L == null)
          return EMPTY_OBJECT_O;
        return L.toArray(new Object[L.size()]);
      }

    public static Object[] toObjectArray(Set<?> S)
      {
        // LDH-NOTE: tried the implementation using "return S.toArray(new Object[S.size()]);".
        // Looping manually is over 100% faster!!! Sick and tired of native Java impl slower than hand-coded!
        // Surprising that the native performance for Sets is so bad compared to Lists.
        // See CollectionUtilTest.

        if (S == null)
          return EMPTY_OBJECT_O;
        Object[] A = new Object[S.size()];
        int i = -1;
        for (Object o : S)
          A[++i] = o;
        return A;
      }

    public static <T> List<T> toList(T[] A)
      {
        // LDH-NOTE: Native (Collections) and custom (through loop) implementations perform about the same.
        // When using Arrays.asList(), performance is horrible.
        // See CollectionUtilTest.

        List<T> L = new ArrayList<T>();
        if (A != null)
         Collections.addAll(L, A);
        return L;
      }

    public static List<Integer> toList(int[] A)
      {
        List<Integer> L = new ArrayList<Integer>();
        if (A != null)
          for (int t : A)
            L.add(t);
        return L;
      }

    public static List<Long> toList(long[] A)
      {
        List<Long> L = new ArrayList<Long>();
        if (A != null)
          for (long t : A)
            L.add(t);
        return L;
      }

    public static List<Float> toList(float[] A)
      {
        List<Float> L = new ArrayList<Float>();
        if (A != null)
          for (float t : A)
            L.add(t);
        return L;
      }

    public static List<Double> toList(double[] A)
      {
        List<Double> L = new ArrayList<Double>();
        if (A != null)
          for (double t : A)
            L.add(t);
        return L;
      }

    public static List<Character> toList(char[] A)
      {
        List<Character> L = new ArrayList<Character>();
        if (A != null)
          for (char t : A)
            L.add(t);
        return L;
      }
    
    public static List<Byte> toList(byte[] A)
      {
        List<Byte> L = new ArrayList<Byte>();
        if (A != null)
          for (byte t : A)
            L.add(t);
        return L;
      }
    
    public static List<Short> toList(short[] A)
      {
        List<Short> L = new ArrayList<Short>();
        if (A != null)
          for (short t : A)
            L.add(t);
        return L;
      }
    
    

    public static List<Boolean> toList(boolean[] A)
      {
        List<Boolean> L = new ArrayList<Boolean>();
        if (A != null)
          for (boolean t : A)
            L.add(t);
        return L;
      }

    public static <T> List<T> toList(Iterator<T> I)
      {
        List<T> L = new ArrayList<T>();
        if (I != null)
          while (I.hasNext() == true)
            L.add(I.next());
        return L;
      }
    
    public static List<?> toList(Object A) throws Exception
      {
        if (A == null)
         return null;
        Class<?> C = A.getClass();
        if (C.isArray() == false)
         throw new Exception("Parameter A is not an array");
        
        if (C == int    [].class) return toList((int    [])A);
        if (C == long   [].class) return toList((long   [])A);
        if (C == float  [].class) return toList((float  [])A);
        if (C == double [].class) return toList((double [])A);
        if (C == boolean[].class) return toList((boolean[])A);
        if (C == char   [].class) return toList((char   [])A);
        if (C == byte   [].class) return toList((byte   [])A);
        if (C == short  [].class) return toList((short  [])A);
        
        return toList((Object[])A);
      }
    


    public static <T> Set<T> toSet(T[] A)
      {
        // LDH-NOTE: tried the implementation using "Collections.addAll" like for the equivalent toList(T[]) method,
        // but the native implementation for Sets is once again lagging in performance
        // Surprising that the native performance for Sets is so bad compared to Lists.
        // See CollectionUtilTest.

        Set<T> S = new HashSet<T>();
        if (A != null)
          for (T a : A)
            S.add(a);
        return S;
      }

    public static Set<Integer> toSet(int[] A)
      {
        Set<Integer> L = new HashSet<Integer>();
        if (A != null)
          for (int t : A)
            L.add(t);
        return L;
      }

    public static Set<Long> toSet(long[] A)
      {
        Set<Long> L = new HashSet<Long>();
        if (A != null)
          for (long t : A)
            L.add(t);
        return L;
      }

    public static Set<Float> toSet(float[] A)
      {
        Set<Float> L = new HashSet<Float>();
        if (A != null)
          for (float t : A)
            L.add(t);
        return L;
      }

    public static Set<Double> toSet(double[] A)
      {
        Set<Double> L = new HashSet<Double>();
        if (A != null)
          for (double t : A)
            L.add(t);
        return L;
      }

    public static Set<Character> toSet(char[] A)
      {
        Set<Character> L = new HashSet<Character>();
        if (A != null)
          for (char t : A)
            L.add(t);
        return L;
      }

    public static Set<Boolean> toSet(boolean[] A)
      {
        Set<Boolean> L = new HashSet<Boolean>();
        if (A != null)
          for (boolean t : A)
            L.add(t);
        return L;
      }
    
    public static Set<Byte> toSet(byte[] A)
      {
        Set<Byte> L = new HashSet<Byte>();
        if (A != null)
          for (byte t : A)
            L.add(t);
        return L;
      }
    
    public static Set<Short> toSet(short[] A)
      {
        Set<Short> L = new HashSet<Short>();
        if (A != null)
          for (short t : A)
            L.add(t);
        return L;
      }

    
    public static <T> Set<T> toSet(Iterator<T> I)
      {
        Set<T> L = new HashSet<T>();
        if (I != null)
          while (I.hasNext() == true)
            L.add(I.next());
        return L;
      }
    
    public static Set<?> toSet(Object A) throws Exception
      {
        if (A == null)
         return null;
        Class<?> C = A.getClass();
        if (C.isArray() == false)
         throw new Exception("Parameter A is not an array");
        
        if (C == int    [].class) return toSet((int    [])A);
        if (C == long   [].class) return toSet((long   [])A);
        if (C == float  [].class) return toSet((float  [])A);
        if (C == double [].class) return toSet((double [])A);
        if (C == boolean[].class) return toSet((boolean[])A);
        if (C == char   [].class) return toSet((char   [])A);
        if (C == byte   [].class) return toSet((byte   [])A);
        if (C == short  [].class) return toSet((short  [])A);
        
        return toSet((Object[])A);
      }
    


    /**
     * Checks if both sets are equal, i.e., they are both null, or they are both not null and of equal size,
     * and contain the same elements. The method checks the equals method on each element.
     * 
     * @param a
     * @param b
     * @return
     */
    public static <T> boolean equals(Set<T> a, Set<T> b)
      {
        if (a == null && b == null)
          return true;
        if (a == null || b == null || a.size() != b.size())
          return false;

        for (T x : a)
          if (b.contains(x) == false)
            return false;

        return true;
      }

    /**
     * Checks if both lists are equal, i.e., they are both null, or they are both not null and of equal size,
     * and contain the same elements in the same positions. The method checks the equals method on each element.
     * 
     * @param a
     * @param b
     * @return
     */
    public static <T> boolean equals(List<T> a, List<T> b)
      {
        if (a == null && b == null)
          return true;
        if (a == null || b == null || a.size() != b.size())
          return false;

        for (int i = 0; i < a.size(); ++i)
          if (a.get(i).equals(b.get(i)) == false)
            return false;

        return true;
      }

    public static String[] prepend(String[] A, String Str)
      {
        String[] NewA = new String[A.length + 1];
        System.arraycopy(A, 0, NewA, 1, A.length);
        NewA[0] = Str;
        return NewA;
      }

    public static String[] append(String[] A, String Str)
      {
        String[] NewA = new String[A.length + 1];
        System.arraycopy(A, 0, NewA, 0, A.length);
        NewA[A.length] = Str;
        return NewA;
      }
    
    public static <T> List<T> append(List<T> L, T[] A)
      {
        if (A == null || L == null)
         return L;
        for (T t : A)
         L.add(t);
        return L;
      }

    public static int[] toIntArray(String[] v)
    throws Exception
      {
        int[] result = new int[v.length];
        for (int i = 0; i < v.length; ++i)
          {
            result[i] = ParseUtil.parseInteger(v[i], SystemValues.EVIL_VALUE);
            if (result[i] == SystemValues.EVIL_VALUE)
              throw new Exception("Invalid integer value #" + i + " coming in as " + v[i] + ".");
          }
        return result;
      }

    public static long[] toLongArray(String[] v)
    throws Exception
      {
        long[] result = new long[v.length];
        for (int i = 0; i < v.length; ++i)
          {
            result[i] = ParseUtil.parseLong(v[i], SystemValues.EVIL_VALUE);
            if (result[i] == SystemValues.EVIL_VALUE)
              throw new Exception("Invalid long value #" + i + " coming in as " + v[i] + ".");
          }
        return result;
      }

    public static float[] toFloatArray(String[] v)
    throws Exception
      {
        float[] result = new float[v.length];
        for (int i = 0; i < v.length; ++i)
          {
            result[i] = ParseUtil.parseFloat(v[i], SystemValues.EVIL_VALUE);
            if (result[i] == SystemValues.EVIL_VALUE)
              throw new Exception("Invalid float value #" + i + " coming in as " + v[i] + ".");
          }
        return result;
      }

    public static double[] toDoubleArray(String[] v)
    throws Exception
      {
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; ++i)
          {
            result[i] = ParseUtil.parseDouble(v[i], SystemValues.EVIL_VALUE);
            if (result[i] == SystemValues.EVIL_VALUE)
              throw new Exception("Invalid double value #" + i + " coming in as " + v[i] + ".");
          }
        return result;
      }

    public static char[] toCharArray(String[] v)
    throws Exception
      {
        char[] result = new char[v.length];
        for (int i = 0; i < v.length; ++i)
          {
            if (v[i].length() != 1)
              throw new Exception("Invalid char value #" + i + " coming in as " + v[i] + ".");
            result[i] = v[i].charAt(0);
          }
        return result;
      }
  }
