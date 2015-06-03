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

import java.sql.SQLException;
import java.util.ArrayList;
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
        if (L == null)
          return EMPTY_OBJECT_O;
        Object[] A = new Object[L.size()];
        for (int i = 0; i < L.size(); ++i)
          A[i] = L.get(i);
        return A;
      }

    public static Object[] toObjectArray(Set<?> S)
      {
        if (S == null)
          return EMPTY_OBJECT_O;
        Object[] A = new Object[S.size()];
        int i = -1;
        for (Object o : S)
          A[++i] = o;
        return A;
      }

    public static <T> List<T> toList(T[] A)
      throws SQLException
      {
        List<T> L = new ArrayList<T>();
        for (T t : A)
          L.add(t);
        return L;
      }

    public static <T> Set<T> toSet(T[] A)
      throws SQLException
      {
        Set<T> L = new HashSet<T>();
        for (T t : A)
          L.add(t);
        return L;
      }
    
    
    public static <T> List<T> toList(Iterator<T> I)
      {
        if (I == null)
         return null;
        List<T> L = new ArrayList<T>();
        while (I.hasNext() == true)
          L.add(I.next());
        return L;
      }

    /**
     * Checks if both sets are equal, i.e., they are both null, or they are both not null and of equal size,
     * and contain the same elements. The method checks the equals method on each element.
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
       String[] NewA = new String[A.length+1];
       System.arraycopy(A, 0, NewA, 1, A.length);
       NewA[0] = Str;
       return NewA;
     }
    public static String[] append(String[] A, String Str)
      {
        String[] NewA = new String[A.length+1];
        System.arraycopy(A, 0, NewA, 0, A.length);
        NewA[A.length] = Str;
        return NewA;
      }


  }
