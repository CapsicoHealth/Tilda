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
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;

public class TextUtil
  {
    protected static final Logger LOG = LogManager.getLogger(TextUtil.class.getName());

    /**
     * Useful methods when creating string constants you don't want to be considered as compile-time constants (i.e.,
     * not be inlined in referring code).
     * 
     * @param str The String to process
     * @return The string passed in, unchanged.
     */
    public static String identity(String str)
      {
        return str;
      }

    /**
     * Escapes a string for SQL, including surrounding single quotes
     * <P>
     * Escapes a String value suitable for SQL generation including surrounding quotes, i.e., "John's Toe" -> "'John''s Toe'". Internally,
     * this method creates a StringBuilder and calls {@link #escapeSingleQuoteForSQL(StringBuilder, String)}.
     * If you are performance conscious and already working with a StringBuilder, use that other method instead.
     * 
     * @param str
     * @return a string where the string is surrounded by a single quote and any single quote included is duplicated so as to make the result suitable to be used in an SQL query.
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static final String escapeSingleQuoteForSQL(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeSingleQuoteForSQL(X, str, "'", "'");
        return X.toString();
      }

    /**
     * Escapes a string for SQL, including surrounding single quotes.
     * <P>
     * Escapes a String value suitable for SQL generation including surrounding quotes, i.e., "John's Toe" -> "'John''s Toe'" and
     * appends it to the StringBuilder provided.
     * 
     * @param x The StringBuilder to append the escaped string to
     * @param str The string to escape
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static final void escapeSingleQuoteForSQL(StringBuilder x, String str)
      {
        escapeSingleQuoteForSQL(x, str, "'", "'");
      }


    /**
     * Escapes an array of string for SQL, including surrounding single quotes, comma-separated.
     * <p>
     * Escapes string values suitable for SQL generation including surrounding quotes, i.e., "John's Toe" -> "'John''s Toe'" and
     * appends it to the StringBuilder provided separating them by commas (suitable for an "in" for example). Another version of
     * this method, {@link #escapeSingleQuoteForSQL(String[], boolean)} is available that doesn't need a StringBuilder but which
     * is less efficient.
     *
     * @param x The StringBuilder to append the comma-separated escaped string sto
     * @param strs An array of Strings
     * @param first whether this is the first printing in a list (should not start with a comma), or part of a series of call
     *          where the first part of the list has already occurred.
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static final void escapeSingleQuoteForSQL(StringBuilder x, String[] strs, boolean first)
      {
        if (strs != null)
          for (String s : strs)
            {
              if (s == null)
                continue;
              if (first == true)
                first = false;
              else
                x.append(", ");
              escapeSingleQuoteForSQL(x, s);
            }
      }

    /**
     * Escapes an array of string for SQL, including surrounding single quotes, comma-separated.
     * <p>
     * This method behaves similarly to {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)} but
     * creates an internal SrringBuilder and returns the escaped values directly. This doesn't perform as well
     * as that other method, but is useful in simpler settings where you might not be working already with
     * a StringBuilder. Otherwise, the other method is preferred and more efficient.
     * 
     * @param strs An array of strings to escape.
     * @param first whether this is the first part of a list (not starting with a comma), or a subsequent
     *          part of a list, which should start with a comma.
     * @return The comma-separated list of escaped strings suitable for an SQL "in" for example.
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static final String escapeSingleQuoteForSQL(String[] strs, boolean first)
      {
        StringBuilder Str = new StringBuilder();
        escapeSingleQuoteForSQL(Str, strs, first);
        return Str.toString();
      }


    /**
     * Escapes a list of chars for SQL, including surrounding single quotes, comma-separated.
     * <p>
     * Escapes char values suitable for SQL generation including surrounding quotes, i.e., "'" -> "''''" and
     * appends it to the StringBuilder provided separating them by commas (suitable for an "in" for example).
     *
     * @param x The StringBuilder to append the comma-separated escaped string sto
     * @param chars An array of char
     * @param first whether this is the first printing in a list (should not start with a comma), or part of a series of call
     *          where the first part of the list has already occurred.
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static void escapeSingleQuoteForSQL(StringBuilder x, char[] chars, boolean first)
      {
        if (chars != null)
          for (char s : chars)
            {
              if (first == true)
                first = false;
              else
                x.append(", ");
              if (s == '\'')
                x.append("''''");
              else
                x.append("'").append(s).append("'");
            }
      }

    /**
     * Escapes a collection of objects' toString() for SQL, including surrounding single quotes, comma-separated.
     * <p>
     * This method behaves similarly to {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)} but
     * creates an internal SrringBuilder and returns the escaped values directly. This doesn't perform as well
     * as that other method, but is useful in simpler settings where you might not be working already with
     * a StringBuilder. Otherwise, the other method is preferred and more efficient.
     * 
     * @param s An array of strings to escape.
     * @param first whether this is the first part of a list (not starting with a comma), or a subsequent
     *          part of a list, which should start with a comma.
     * @return The comma-separated list of escaped strings suitable for an SQL "in" for example.
     * 
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String)}
     * @see {@link #escapeSingleQuoteForSQL(String)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(String[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, char[], boolean)}
     * @see {@link #escapeSingleQuoteForSQL(StringBuilder, Collection, boolean)}
     */
    public static final <T> void escapeSingleQuoteForSQL(StringBuilder x, Collection<T> strs, boolean first)
      {
        if (strs != null)
          for (T s : strs)
            {
              if (s == null)
                continue;
              if (first == true)
                first = false;
              else
                x.append(", ");
              escapeSingleQuoteForSQL(x, s.toString());
            }
      }

    private static final void escapeSingleQuoteForSQL(StringBuilder x, String str, String before, String end)
      {
        if (before != null)
          x.append(before);

        if (str != null)
          {
            int l = str.length();
            char[] s = str.toCharArray();
            int i = 0;
            int j = 0;
            while (j < l && s[j] != '\'')
              ++j;
            while (j < l)
              {
                ++j;
                x.append(s, i, j - i).append('\'');
                i = j;
                while (j < l && s[j] != '\'')
                  ++j;
              }
            x.append(s, i, l - i);
          }

        if (end != null)
          x.append(end);
      }



    public static final String escapeDoubleQuoteWithSlash(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeSomethingWithSlash(X, '"', str, "\"", "\"", false);
        return X.toString();
      }

    public static final void escapeDoubleQuoteWithSlash(StringBuilder x, String str)
      {
        escapeSomethingWithSlash(x, '"', str, "\"", "\"", false);
      }

    public static final String escapeDoubleQuoteForCSV(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeDoubleQuoteForCSV(X, str);
        return X.toString();
      }

    public static final void escapeDoubleQuoteForCSV(StringBuilder x, String str)
      {
        escapeSomethingWithSomething(x, '"', "\"", str, "\"", "\"");
      }

    public static final String escapeSingleQuoteWithSlashDouble(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeSomethingWithSlash(X, '\'', str, "'", "'", true);
        return X.toString();
      }

    public static final String escapeSingleQuoteWithSlash(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeSomethingWithSlash(X, '\'', str, "'", "'", false);
        return X.toString();
      }

    public static final void escapeSingleQuoteWithSlash(StringBuilder x, String str)
      {
        escapeSomethingWithSlash(x, '\'', str, "'", "'", false);
      }
    
    public static final void escapeAllQuotesWithSlash(StringBuilder x, String str)
      {
        escapeAllQuotesWithSlash(x, str, "\"", "\"");
      }

    private static final void escapeAllQuotesWithSlash(StringBuilder x, String str, String before, String end)
      {
        StringBuilder XX = new StringBuilder(128);
        escapeSomethingWithSlash(XX, '"', str, null, null, false);
        escapeSomethingWithSlash(x, '\'', XX.toString(), before, end, false);
      }

    public static final String escapeBacktickWithSlash(String str)
      {
        StringBuilder X = new StringBuilder();
        escapeSomethingWithSlash(X, '`', str, "`", "`", false);
        return X.toString();
      }

    public static final void escapeBacktickWithSlash(StringBuilder x, String str)
      {
        escapeSomethingWithSlash(x, '`', str, "`", "`", false);
      }
    
    private static final void escapeSomethingWithSlash(StringBuilder x, char something, String str, String before, String end, boolean doubleEscape)
      {
        escapeSomethingWithSomething(x, something, doubleEscape ? "\\\\\\" : "\\", str, before, end);
      }

    private static final void escapeSomethingWithSomething(StringBuilder x, char c, String something2, String str, String before, String end)
      {
        if (before != null)
          {
            x.append(before);
          }
        if (str != null)
          {
            int l = str.length();
            char[] s = str.toCharArray();
            int i = 0;
            int j = 0;
            while (j < l && s[j] != c)
              ++j;
            while (j < l)
              {
                x.append(s, i, j - i).append(something2).append(c);
                ++j;
                i = j;
                while (j < l && s[j] != c)
                  ++j;
              }
            x.append(s, i, l - i);
          }

        if (end != null)
          {
            x.append(end);
          }
      }


    public static final String escapeHTMLQuotes(String str)
      {
        return escapeHTMLJavaScriptQuotes(str, "\"");
      }

    public static final String escapeJavaScriptQuotes(String str)
      {
        return escapeHTMLJavaScriptQuotes(str, "'");
      }

    public static final String escapeHTMLJavaScriptQuotes(String str)
      {
        return escapeHTMLJavaScriptQuotes(str, "");
      }

    public static final String escapeHTMLJavaScriptQuotes(String str, String beforeAfter)
      {
        if (str == null)
          return beforeAfter + beforeAfter;
        StringBuilder X = new StringBuilder(128);
        X.append(beforeAfter);

        int len = str.length();
        char[] s = str.toCharArray();
        int i = 0;
        int j = 0;
        while (j < len && s[j] != '"' && s[j] != '\'' && s[j] != '\n' && s[j] != '\r' && s[j] != '\\' && s[j] != '<')
          ++j;
        if (j >= len)
          {
            X.append(str);
            X.append(beforeAfter);
            return X.toString();
          }
        else
          do
            {
              char c = s[j];
              X.append(s, i, j - i).append(c == '"' ? "&quot;" : c == '\'' ? "&#39;" : c == '\n' ? "\\n" : c == '\\' ? "\\\\" : c == '<' ? "&lt;" : "");
              i = ++j;
              while (j < len && s[j] != '"' && s[j] != '\'' && s[j] != '\n' && s[j] != '\r' && s[j] != '\\' && s[j] != '<')
                ++j;
            } while (j < len);

        X.append(s, i, len - i);
        X.append(beforeAfter);
        return X.toString();
      }

    /**
     * Checks if a String is NULL or made up only of white spaces (as per {@link Character#isWhitespace(char)}.
     * 
     * @param str
     * @return true if the string is null or empty
     */
    public static boolean isNullOrEmpty(String str)
      {
        if (str != null && str.isEmpty() == false)
          for (int i = 0; i < str.length(); ++i)
            if (Character.isWhitespace(str.charAt(i)) == false)
              return false;
        return true;
      }

    /**
     * Checks if an array of Strings is NULL, empty, or made up of Strings that are themselves null or empty (as per {@link #isNullOrEmpty(String)}.
     * 
     * @param strings
     * @return true if the array is null or empty, or only contains strings that are themselves null or empty.
     */
    public static boolean isNullOrEmpty(String[] strings)
      {
        if (strings != null)
          for (String s : strings)
            if (TextUtil.isNullOrEmpty(s) == false)
              return false;
        return true;
      }

    /**
     * Checks if an list of Strings is NULL, empty, or made up of Strings that are themselves null or empty (as per {@link #isNullOrEmpty(String)}.
     * 
     * @param strings
     * @return true if the list is null or empty, or only contains strings that are themselves null or empty.
     */
    public static boolean isNullOrEmpty(List<String> strings)
      {
        if (strings != null)
          for (String s : strings)
            if (TextUtil.isNullOrEmpty(s) == false)
              return false;
        return true;
      }


    /**
     * A search-and-replace method that can be in most cases about 3x faster than the built in {@link String#replaceAll(String, String)}, and
     * doesn't use regexes.
     * <p>
     * See test case in TextUtilTest.Test_SearchReplace() for performance analysis.
     * 
     * @param str
     * @param search
     * @param replace
     * @return The string with the search substring replaced by the replace string.
     */
    public static final String searchReplace(String str, String search, String replace)
      {
        if (str == null)
          return str;
        int i = 0;
        int j = str.indexOf(search);
        if (j == -1)
          return str;

        char[] S = str.toCharArray();
        StringBuilder X = new StringBuilder(256);

        while (j != -1)
          {
            X.append(S, i, j - i).append(replace);
            i = j + search.length();
            j = str.indexOf(search, i);
          }
        return X.append(S, i, S.length - i).toString();
      }

    /**
     * A search-and-replace method similar to {@link #searchReplace(String, String, String)} but which outputs the results to a StringBuilder.
     * 
     * @param x
     * @param str
     * @param search
     * @param replace
     * @return The StringBuilder passed in.
     */
    public static final StringBuilder searchReplace(StringBuilder x, String str, String search, String replace)
      {
        if (str == null)
          return x;
        int i = 0;
        int j = str.indexOf(search);
        if (j == -1)
          return x.append(str);

        char[] S = str.toCharArray();
        while (j != -1)
          {
            x.append(S, i, j - i).append(replace);
            i = j + search.length();
            j = str.indexOf(search, i);
          }
        return x.append(S, i, S.length - i);
      }

    /**
     * A search-and-replace method similar to {@link #searchReplace(String, String, String)} but which outputs the results to a Writer.
     * 
     * @param x
     * @param str
     * @param search
     * @param replace
     * @return The Writer passed in
     * @throws IOException
     */
    public static final Writer searchReplace(Writer x, String str, String search, String replace)
    throws IOException
      {
        if (str == null)
          return x;
        int i = 0;
        int j = str.indexOf(search);
        if (j == -1)
          {
            x.write(str);
            return x;
          }

        char[] S = str.toCharArray();
        while (j != -1)
          {
            x.write(S, i, j - i);
            x.write(replace);
            i = j + search.length();
            j = str.indexOf(search, i);
          }
        x.write(S, i, S.length - i);
        return x;
      }

    public static String removeElement(int Index, String Vals, char Separator)
      {
        int Pos = 0;
        for (int i = 0; i < Index; ++i)
          {
            Pos = Vals.indexOf(Separator, Pos);
            if (Pos == -1)
              {
                return null;
              }
            ++Pos;
          }
        int Pos2 = Vals.indexOf(Separator, Pos);
        if (Pos2 == -1)
          return Pos == 0 ? "" : Vals.substring(0, Pos - 1);
        return Vals.substring(0, Pos) + Vals.substring(Pos2 + 1);
      }

    public static int findElement(String V, String Vals, char Separator)
      {
        if (V == null || Vals == null)
          return -1;
        int Index = 0;
        int i = 0;
        int j = Vals.indexOf(Separator, i);
        while (j != -1)
          {
            String RN = Vals.substring(i, j).trim();
            if (RN.equals(V) == true)
              break;
            i = j + 1;
            j = Vals.indexOf(Separator, i);
            ++Index;
          }
        if (j == -1)
          {
            String RN = Vals.substring(i).trim();
            if (RN.equals(V) == false)
              Index = -1;
          }
        return Index;
      }

    
    /**
     * Returns whether A contains Val (strict equal case sensitive or not based on IgnoreCase).
     * 
     * @param A
     * @param val
     * @param ignoreCase
     * @param start
     * @return
     */
    public static final boolean contains(String[] A, String val, boolean ignoreCase, int start)
      {
        return findElement(A, val, ignoreCase, start) >= 0;
      }
    
    /**
     * Returns the index in A that matched the value of Val (strict equal case sensitive or not based on IgnoreCase).
     * If no match is found, returns -1;
     * 
     * @param A
     * @param val
     * @param ignoreCase
     * @param start
     * @return
     */
    public static int findElement(String[] A, String val, boolean ignoreCase, int start)
      {
        if (A == null)
          return -1;
        for (int i = start; i < A.length; ++i)
          {
            String str = A[i];
            if (str == null)
              continue;
            if (ignoreCase == true && str.equalsIgnoreCase(val) == true || ignoreCase == false && str.equals(val) == true)
              return i;
          }
        return -1;
      }

    /**
     * Returns the index in A that matched the value of Val, either as a startsWith, if the element in A ends in '*', or
     * a endsWith if the element in A starts with a '*', or a strict equal otherwise. The comparison is case-sensitive
     * or not based on IgnoreCase. -1 is returned is no match is found. If there are multiple matches (for example
     * comparing "aaaa" with "a*" and "aa*", only the first one will be returned.
     * 
     * @param A
     * @param Val
     * @param IgnoreCase
     * @param Start
     * @return
     */
    public static int findStarElement(String[] A, String Val, boolean IgnoreCase, int Start)
      {
        if (A == null || Val == null)
          return -1;
        if (IgnoreCase == true)
          Val = Val.toLowerCase();
        for (int i = Start; i < A.length; ++i)
          {
            String Str = A[i];
            if (Str == null)
              continue;
            if (IgnoreCase == true)
              Str = Str.toLowerCase();
            if (Str.length() > 1 && Str.endsWith("*") == true && Str.startsWith("*") == true)
              {
                if (Val.indexOf(Str.substring(1, Str.length() - 1)) != -1)
                  return i;
              }
            if (Str.endsWith("*") == true)
              {
                if (Val.startsWith(Str.substring(0, Str.length() - 1)) == true)
                  return i;
              }
            else if (Str.startsWith("*") == true)
              {
                if (Val.endsWith(Str.substring(1)) == true)
                  return i;
              }
            else if (Str.equals(Val) == true)
              return i;
          }
        return -1;
      }


    public static int findElement(String[][] A, String Val, int pos, boolean IgnoreCase, int Start)
      {
        if (A == null)
          return -1;
        for (int i = Start; i < A.length; ++i)
          {
            String Str = A[i][pos];
            if (Str == null)
              continue;
            if (IgnoreCase == true && Str.equalsIgnoreCase(Val) == true || IgnoreCase == false && Str.equals(Val) == true)
              return i;
          }
        return -1;
      }


    public static String getElement(int Index, String Vals, char Separator)
      {
        int Pos = 0;
        for (int i = 0; i < Index; ++i)
          {
            Pos = Vals.indexOf(Separator, Pos);
            if (Pos == -1)
              {
                return null;
              }
            ++Pos;
          }
        int Pos2 = Vals.indexOf(Separator, Pos);
        return Pos2 == -1 ? Vals.substring(Pos) : Vals.substring(Pos, Pos2);
      }


    public static String toShortDollarStr(double Value)
      {
        char C = ' ';
        if (Value >= 1000000000)
          {
            Value = Value / 100000000.0;
            C = 'B';
          }
        else if (Value >= 1000000)
          {
            Value = Value / 100000.0;
            C = 'M';
          }
        else if (Value >= 1000)
          {
            Value = Value / 100.0;
            C = 'K';
          }
        else
          {
            Value = Value * 10;
          }

        Value = Math.round(Value);
        Value = Value / 10.0;
        String Str = "$" + Value;
        if (Str.endsWith(".0") == true)
          Str = Str.substring(0, Str.length() - 2);
        return Str + C;
      }

    public static int count(String Src, char c)
      {
        int count = 0;
        int i = -1;
        while ((i = Src.indexOf(c, i + 1)) != -1)
          ++count;
        return count;
      }

    public static int count(String Src, String c)
      {
        int count = 0;
        int i = -c.length();
        while ((i = Src.indexOf(c, i + c.length())) != -1)
          ++count;
        return count;
      }


    public static boolean isAllLetters(String Str)
      {
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false && c != '_' && c != '.' && c != '-')
              return false;
          }
        return true;
      }

    public static boolean isAllDigits(String Str)
      {
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (Character.isDigit(c) == false && Character.isSpaceChar(c) == false && c != '_' && c != '.' && c != '-')
              return false;
          }
        return true;
      }

/*
    public static boolean isAllJavaIdentifier(String Str)
      {
        if (Str == null)
          return true;
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (Character.isJavaIdentifierPart(c) == false)
              return false;
          }
        return true;
      }
*/
    public static boolean isJavaIdentifier(String Str)
      {
        if (Str == null || Str.length() == 0 || Character.isJavaIdentifierStart(Str.charAt(0)) == false)
          return false;

        for (int i = 1; i < Str.length(); i++)
          {
            if (Character.isJavaIdentifierPart(Str.charAt(i)) == false)
              return false;
          }
        return true;
      }

    public static boolean isJavaIdentifierWithSpacesAndDashes(String Str)
      {
        if (Str == null || Str.length() == 0 || Character.isJavaIdentifierStart(Str.charAt(0)) == false)
          return false;

        for (int i = 1; i < Str.length(); i++)
          {
            if (Character.isJavaIdentifierPart(Str.charAt(i)) == false && Str.charAt(i) != ' ' && Str.charAt(i) != '-')
              return false;
          }
        return true;
      }
    
    public static String processTextToHTMLParagraphs(String Text, String StyleClass)
      {
        Text = Text.replace("<br>", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("<BR>", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("\r\n", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("\n", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("<P class='" + StyleClass + "'></P>", "\n<P class='" + StyleClass + "_SEP'> </P>\n");
        Text = Text.replace("</P><P class=", "</P>\n<P class=");
        return "<P class='" + StyleClass + "'>" + Text + "</P>";
      }

    public static String noNullPrint(String Val, String Default)
      {
        return Val == null ? Default : Val;
      }

    public static String noNullOrEmptyPrint(String Val, String Default)
      {
        return isNullOrEmpty(Val) == true ? Default : Val;
      }

    /**
     * Takes a string and rewrites it by replacing all special characters with an '_'. Special characters include
     * ' ', '*', '\'', '/', '"', ':', ';', ',', '.', '%', '+', '&', '=', '?', '-', '(', ')', '[', ']', '{', '}'
     */
    public static String sanitizeName(String Name)
      {
        char C[] = Name.toCharArray();
        for (int i = 0; i < C.length; ++i)
          {
            switch (C[i])
              {
                case ' ':
                case '*':
                case '\'':
                case '/':
                case '"':
                case ':':
                case ';':
                case ',':
                case '.':
                case '%':
                case '+':
                case '&':
                case '=':
                case '?':
                case '-':
                case '(':
                case ')':
                case '[':
                case ']':
                case '{':
                case '}':
                  C[i] = '_';
              }
          }
        return new String(C);
      }


    /**
     * Takes a string and rewrites it in lower case, and removing all non alpha-numeric characters. For example
     * "This is * TEST" becomes "thisistest"
     */
    public static String simplifyName(String Name)
      {
        if (Name == null)
          return null;
        StringBuilder Str = new StringBuilder(Name.length());
        char C[] = Name.toCharArray();
        for (char c : C)
          {
            if (Character.isLetterOrDigit(c) == false)
              continue;
            Str.append(Character.toLowerCase(c));
          }
        return Str.toString();
      }

    public static String toJavascriptArray(String[][] Vals)
      {
        StringBuilder Str = new StringBuilder();
        return toJavascriptArray(Str, Vals).toString();
      }

    public static StringBuilder toJavascriptArray(StringBuilder Str, String[][] Vals)
      {
        boolean First = true;
        for (String[] v : Vals)
          {
            if (First == true)
              First = false;
            else
              Str.append(",");
            Str.append("[");
            toJavascriptArray(Str, v);
            Str.append("]");
          }
        return Str;
      }

    public static String toJavascriptArray(String[] Vals)
      {
        StringBuilder Str = new StringBuilder();
        return toJavascriptArray(Str, Vals).toString();
      }

    public static StringBuilder toJavascriptArray(StringBuilder Str, String[] Vals)
      {
        boolean First = true;
        for (String v : Vals)
          {
            if (First == true)
              First = false;
            else
              Str.append(",");
            Str.append(escapeJavaScriptQuotes(v));
          }
        return Str;
      }

    public final static String ACCENTEDCHARS = "�A�A�A�A�A�A�C�E�E�E�E�I�I�I�I�N�O�O�O�O�O�O\u0164T�U�U�U�U�Y�O�A�A";

    public static char isAccentedCharacter(char c)
      {
        int p = ACCENTEDCHARS.indexOf(Character.toUpperCase(c));
        if (p != -1 && p % 2 == 0)
          return Character.isLowerCase(c) ? Character.toLowerCase(ACCENTEDCHARS.charAt(p + 1)) : ACCENTEDCHARS.charAt(p + 1);
        return Character.UNASSIGNED;
      }

    /*
     * public static String replaceAccentedCharacters(String Str)
     * {
     * char[] Chars = Str.toCharArray();
     * for (int i = 0; i < Chars.length; ++i)
     * {
     * char c = isAccentedCharacter(Chars[i]);
     * if (c != Character.UNASSIGNED)
     * Chars[i] = c;
     * }
     * return new String(Chars);
     * }
     */
    static Pattern _UNICODE_MARKS = Pattern.compile("\\p{M}");

    public static String replaceAccentedCharacters(String str)
      {
        if (str == null)
          return null;
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        return _UNICODE_MARKS.matcher(str).replaceAll("");
      }

    public static char removeAccent(char c)
      {
        char ch = isAccentedCharacter(c);
        if (ch != Character.UNASSIGNED)
          System.out.println("Character: " + c + "; Unaccented: " + ch);
        return ch == Character.UNASSIGNED ? c : ch;
      }

    public static String replaceAccentedCharactersWithWebSpecialCharacters(String Str)
      {
        for (int i = 0; i < ACCENTEDCHARS.length(); i += 2)
          {
            char c = ACCENTEDCHARS.charAt(i);
            Str = Str.replace("" + c, "&#" + ((int) c) + ";");
            c = Character.toLowerCase(c);
            Str = Str.replace("" + c, "&#" + ((int) c) + ";");
          }
        return Str;
      }


    protected static final String[][] WEBSPECIALCHARS = { { "eacute", "e"
        }, { "aacute", "a"
        }, { "egrave", "e"
        }, { "agrave", "a"
        }
    };

    public static String convertWebSpecialCharacters(String Str)
      {
        StringBuilder Buf = new StringBuilder(Str.length());

        Pattern P = Pattern.compile("&[0-9a-z#]+;");
        Matcher M = P.matcher(Str);
        int i = 0;
        while (M.find() == true)
          {
            String match = M.group().substring("&".length(), M.group().length() - 1);
            if (match.charAt(0) == '#')
              {
                int CharValue = Integer.parseInt(match.substring(1));
                Buf.append(Str.substring(i, M.start())).append((char) CharValue);
              }
            else
              {
                match = match.toLowerCase();
                for (String[] s : WEBSPECIALCHARS)
                  {
                    if (s[0].equals(match) == true)
                      {
                        Buf.append(Str.substring(i, M.start())).append(s[1]);
                        continue;
                      }
                  }
              }
            i = M.end();
          }
        if (i < Str.length())
          Buf.append(Str.substring(i));

        return Buf.toString();
      }

    public static String[] unique(String[] strings)
      {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < strings.length; i++)
          {
            String name = strings[i].toLowerCase();
            set.add(name);
          }
        return set.toArray(new String[0]);
      }

    public static void print(String[] strArray, StringBuilder s)
      {
        print(strArray, ", ", s);
      }
    
    public static void print(String[] strArray, String separator, StringBuilder s)
      {
        if (strArray == null)
          return;
        boolean First = true;
        for (String str : strArray)
          {
            if (First == true)
              First = false;
            else
              s.append(separator);
            s.append(str);
          }
      }

    /**
     * Prints a list of strings in a comma-separated list of items to be used in Java code gen. For example, passing ["a\"", "b"]
     * will generate "a\"", "b", i.e., double quotes in passed strings will be escaped.
     * 
     * @param StrArray
     * @param s
     */
    public static void printJavaStringArray(String[] StrArray, StringBuilder s)
      {
        if (StrArray == null)
          return;
        boolean First = true;
        for (String str : StrArray)
          {
            if (First == true)
              First = false;
            else
              s.append(", ");
            s.append(TextUtil.escapeDoubleQuoteWithSlash(str));
          }
      }

    /**
     * Prints a list of strings in a comma-separated list of items to be used in Java code gen. For example, passing ["a\"", "b"]
     * will generate "a\"", "b", i.e., double quotes in passed strings will be escaped.
     * 
     * @param StrArray
     * @param s
     */
    public static String printJavaStringArray(String[] StrArray)
      {
        StringBuilder str = new StringBuilder();
        printJavaStringArray(StrArray, str);
        return str.toString();
      }


    public static String print(String[][] A, int pos)
      {
        StringBuilder s = new StringBuilder();
        print(A, pos, s);
        return s.toString();
      }

    public static void print(String[][] StrArray, int pos, StringBuilder s)
      {
        if (StrArray == null)
          return;
        boolean First = true;
        for (String[] str : StrArray)
          {
            if (First == true)
              First = false;
            else
              s.append(", ");
            s.append(str[pos]);
          }
      }

    public static final String print(Iterator<?> I)
      {
        StringBuilder s = new StringBuilder();
        print(I, s);
        return s.toString();
      }

    public static final String print(Iterator<?> I, String separator)
      {
        if (I == null)
          return null;
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        while (I.hasNext() == true)
          {
            Object O = I.next();
            if (First == true)
              First = false;
            else
              Str.append(separator);
            if (O == null)
              Str.append("null");
            else
              Str.append(O.getClass() == ZonedDateTime.class ? DateTimeUtil.printDateTimeCompact((ZonedDateTime) O, true, true) : O.toString());
          }
        return Str.toString();
      }


    public static final void print(Iterator<?> I, StringBuilder s)
      {
        if (I == null)
          return;
        boolean First = true;
        while (I.hasNext() == true)
          {
            Object O = I.next();
            if (First == true)
              First = false;
            else
              s.append(", ");
            if (O == null)
              s.append("null");
            else
              s.append(O.getClass() == ZonedDateTime.class ? DateTimeUtil.printDateTimeCompact((ZonedDateTime) O, true, true) : O.toString());
          }
      }

    public static final void printWithQuotes(String[] StrArray, StringBuilder s)
      {
        if (StrArray == null)
          return;
        boolean First = true;
        for (String str : StrArray)
          {
            if (First == true)
              First = false;
            else
              s.append(", ");
            s.append("'");
            s.append(str);
            s.append("'");
          }
      }

    public static final String print(String[] strArray)
      {
        return print(strArray, ", ");
      }

    public static final String print(String[] strArray, String separator)
      {
        StringBuilder str = new StringBuilder();
        print(strArray, separator, str);
        return str.toString();
      }


    /**
     * Prints Str is it is not null and not empty. Otherwise, prints Default.
     * 
     * @param Str
     * @param Default
     * @return
     * @see #isNullOrEmpty(String)
     */
    public static final String print(String Str, String Default)
      {
        return isNullOrEmpty(Str) == false ? Str : Default;
      }


    /**
     * Writes the Str string in a way that makes it compatible with XML, i.e.:
     * <UL>
     * <LI>&lt; and &gt; are escaped as &amp;lt; and &amp;gt;
     * <LI>&amp; is escaped to &amp;amp;
     * <LI>" and ' are escaped to &amp;quot; and &amp;apos;
     * </UL>
     * 
     * @param Out
     * @param Str
     */
    public static final void escapeXML(PrintWriter Out, String Str)
      {
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (c == '<')
              Out.print("&lt;");
            else if (c == '&')
              Out.print("&amp;");
            else if (c == '>')
              Out.print("&gt;");
            else if (c == '"')
              Out.print("&quot;");
            else if (c == '\'')
              Out.print("&apos;");
            else
              Out.print(c);
          }
      }

    /**
     * Same as {@link #escapeXML(PrintWriter, String)} but with a PrintStream.
     * 
     * @param Out
     * @param Str
     */
    public static final void escapeXML(PrintStream Out, String Str)
      {
        if (Str == null)
          return;
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (c == '<')
              Out.print("&lt;");
            else if (c == '&')
              Out.print("&amp;");
            else if (c == '>')
              Out.print("&gt;");
            else if (c == '"')
              Out.print("&quot;");
            else if (c == '\'')
              Out.print("&apos;");
            else
              Out.print(c);
          }
      }

    // public static final String escapeXML1(String Str)
    // {
    // if (Str == null)
    // return null;
    // StringBuilderWriter SBW = new StringBuilderWriter();
    // PrintWriter Out = new PrintWriter(SBW);
    // escapeXML(Out, Str);
    // Out.flush();
    // Out.close();
    // return SBW.getBuilder().toString();
    // }

    /**
     * Same as {@link #escapeXML(PrintWriter, String)} but returning a direct String.<BR>
     * <BR>
     * Note: FYI that it seems bad form to copy/paste the same logic instead of reusing, but
     * the escapeXML1 version is about 5 times slower.
     * 
     * @param Out
     * @param Str
     */
    public static final String escapeXML(String Str)
      {
        if (Str == null)
          return Str;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            switch(c)
             {
               case '<': s.append("&lt;"); break;
               case '&': s.append("&amp;"); break;
               case '>': s.append("&gt;"); break;
               case '"': s.append("&quot;"); break;
               case '\'': s.append("&apos;"); break;
               default: s.append(c);
             }
          }
        return s.toString();
      }


    public static final void printXMLTag(PrintWriter Out, String Lead, String Tag, String Content)
      {
        if (isNullOrEmpty(Content) == false)
          {
            Out.print(Lead);
            Out.print("<");
            Out.print(Tag);
            Out.print(">");
            escapeXML(Out, Content);
            Out.print("</");
            Out.print(Tag);
            Out.println(">");
          }
      }

    protected static final Pattern RTF_CELL_PATTERN = Pattern.compile("\\\\cell\\W|\\}\\{\\\\");

    public static final String RTF2TXT(String Str)
    throws IOException, BadLocationException
      {
        if (Str != null && Str.startsWith("{\\rtf1") == true)
          {
            // There is a "questionable" bug in the RTF-to-Text routine in the Java library. With tables, text in
            // adjacent cells are concatenated without any
            // spacing. So, for example, a table with a cell containing "abc" followed by another call containing "123",
            // after conversion, you'll get "abc123".
            // With this hack, we capture the RTF cell delimiter "\cell$" and replace it with ". \cell$". This will
            // separate text in cells from other text and will
            // allow text processing to give better results.
            Str = RTF_CELL_PATTERN.matcher(Str).replaceAll(". $0");
            RTFEditorKit RTF = new RTFEditorKit();
            Document doc = RTF.createDefaultDocument();
            RTF.read(new StringReader(Str), doc, 0);
            Str = doc.getText(0, doc.getLength());
          }
        return Str;
      }

    protected static final Pattern HTML_NEWLINE_PATTERN = Pattern.compile("<\\s*(TD|BR|DIV|P)\\s*[^>]*>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    protected static final Pattern HTML_TAG_PATTERN     = Pattern.compile("(</?[^>]+>)+", Pattern.DOTALL);

    /**
     * This method used a reg-ex based poor-man's version of parsing out text from an HTML document by removing
     * some tags and replacing things like TD, DIV, BR , P etc... with new lines. This worked 8y ago when we did this
     * but today, with more modern HTML, this is insufficient.<BR>
     * <BR>
     * Instead, use the JSoup API, or the passthrough {@link #HTML2TXT(String, boolean)} method.
     * 
     * @param Str
     * @return
     */
    @Deprecated
    public static final String HTML2TXT(String Str)
      {
        if (isNullOrEmpty(Str) == false)
          {
            Str = HTML_NEWLINE_PATTERN.matcher(Str).replaceAll("\\\n");
            Str = HTML_TAG_PATTERN.matcher(Str).replaceAll(" ");
          }
        return Str;
      }

    /**
     * Passthrough method that uses the JSoup API to extract the Text from an HTML document
     * @param html the html document
     * @param normalized whether normalized or non-normalized text content should be returned (as per the JSoup API)
     * @return the text contents from the HTML documentation.
     */
    public static final String HTML2TXT(String html, boolean normalized)
      {
        return isNullOrEmpty(html) == true ? html : normalized ? Jsoup.parse(html).text() : Jsoup.parse(html).wholeText();
      }

    public static final String streamToString(InputStream In)
    throws IOException
      {
        StringBuilder Str = new StringBuilder();
        byte[] buf = new byte[4096];
        int count;
        while ((count = In.read(buf)) != -1)
          {
            for (int i = 0; i < count; ++i)
              Str.append((char) buf[i]);
          }
        return Str.toString();
      }


    public static final void printExceptionMessages(StringBuilder Str, boolean HTML, Throwable T, boolean PrintCauseToo)
      {
        if (HTML == true)
          Str.append("<PRE style=\"font-size: 75%;\">\n");
        if (PrintCauseToo == true && T.getCause() != null)
          {
            Str.append(T.getCause().getClass().getName()).append(": ").append(T.getCause().getMessage()).append("\n");
          }
        Str.append(T.getClass().getName()).append(": ").append(T.getMessage()).append("\n");
        if (HTML == true)
          Str.append("</PRE>\n");
      }

    public static final void printException(StringBuilder Str, boolean HTML, Throwable T, boolean PrintCauseToo)
      {
        if (PrintCauseToo == true && T.getCause() != null)
          {
            printException(Str, HTML, T.getCause());
            if (HTML == true)
              Str.append("<BR>");
            Str.append("\n");
          }
        printException(Str, HTML, T);
      }

    protected static final void printException(StringBuilder Str, boolean HTML, Throwable T)
      {
        if (HTML == true)
          Str.append("<PRE style=\"font-size: 75%;\"><B>");
        Str.append(T.getClass().getName()).append(": ").append(T.getMessage());
        if (HTML == true)
          Str.append("</B>");
        Str.append("\n");
        int i = 0;
        for (StackTraceElement s : T.getStackTrace())
          {
            Str.append("     ").append(s.toString()).append("\n");
            if (++i == 25)
              break;
          }
        if (HTML == true)
          Str.append("</PRE>\n");
      }

    public static final boolean isLowerCase(String Str)
      {
        if (Str == null)
          return true;
        for (char c : Str.toCharArray())
          {
            if (Character.isLetter(c) == true && Character.isLowerCase(c) == false)
              return false;
          }
        return true;
      }

    public static final String merge(String Set1, String Set2, String Separator)
      {
        return merge(Set1, Set2, Separator, Separator, true, false);
      }

    public static final String merge(String Set1, String Set2, String SeparatorRegEx, String SeparatorStr, boolean TrailingSeparator, boolean Trim)
      {
        if (Set1 == null)
          return Set2;
        if (Set2 == null)
          return Set1;

        boolean Start = Set1.startsWith(SeparatorStr) == true || Set2.startsWith(SeparatorStr) == true;
        Map<String, String> M = new HashMap<String, String>();
        String[] A = Set1.split(SeparatorRegEx);
        for (String s : A)
          {
            if (isNullOrEmpty(s) == true)
              continue;
            if (Trim == true)
              s = s.trim();
            M.put(s, s);
          }
        A = Set2.split(SeparatorRegEx);
        for (String s : A)
          {
            if (isNullOrEmpty(s) == true)
              continue;
            if (Trim == true)
              s = s.trim();
            M.put(s, s);
          }
        StringBuilder Str = new StringBuilder();
        if (Start == true)
          Str.append(SeparatorStr);
        for (Entry<String, String> e : M.entrySet())
          Str.append(e.getValue()).append(SeparatorStr);

        return TrailingSeparator == true || Str.length() == 0 ? Str.toString() : Str.substring(0, Str.length() - SeparatorStr.length());
      }

    public static final int indexOf(char[] buff, char c, int i)
      {
        while (i < buff.length && buff[i] != c)
          ++i;
        return i == buff.length ? -1 : i;
      }

    public static final int indexOfNoNewLine(char[] buff, char c, int i)
      {
        while (i < buff.length && buff[i] != c && buff[i] != '\n')
          ++i;
        return i == buff.length ? -1 : i;
      }

    public static final int indexOfEndOfQuotedString(char[] buff, int i)
      {
        while (true)
          {
            while (i < buff.length && buff[i] != '"')
              ++i;
            if (i + 1 < buff.length)
              {
                if (buff[i + 1] != '"')
                  return i + 1;
                i += 2;
              }
            if (i >= buff.length - 1)
              return -1;
          }
      }

    /**
     * Returns true if any element in A matches an indexOf query on Str
     * @param Str
     * @param A
     * @return
     */
    public static final boolean indexOf(String Str, String[] A)
      {
        if (Str == null || A == null)
          return false;
        for (String s : A)
          if (Str.indexOf(s) != -1)
            return true;
        return false;
      }


    public static final boolean equals(String S1, String S2)
      {
        if (S1 == null && S2 == null)
          return true;
        if (S1 == null || S2 == null)
          return false;
        return S1.equals(S2);
      }

    public static final String generateLead(char C, int Level)
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < Level; ++i)
          Str.append(C);
        return Str.toString();
      }

    public static final String print(int[] Integers, String Post)
      {
        StringBuilder Str = new StringBuilder();
        for (int i : Integers)
          {
            Str.append(", ").append(i);
            if (isNullOrEmpty(Post) == false)
              Str.append(Post);
          }
        return Str.length() == 0 ? "" : Str.substring(2);
      }

    /**
     * Splits a string based on separator regex using the standard String.split() method. Implements a null-or-empty check
     * on Str and returns null if true. Additionally, calls trim() on all results if Trim is true, and removes empties
     * from the final result if RemoveEmpties is true.
     * 
     * @param Str
     * @param SeparatorRegEx
     * @param Trim
     * @param RemoveEmpties
     * @return
     */
    public static final String[] split(String Str, String SeparatorRegEx, boolean Trim, boolean RemoveEmpties)
      {
        if (TextUtil.isNullOrEmpty(Str) == true)
          return null;
        List<String> L = new ArrayList<String>();
        String[] SplitArray = Str.split(SeparatorRegEx);
        for (String s : SplitArray)
          {
            if (RemoveEmpties == true && TextUtil.isNullOrEmpty(s) == true)
              continue;
            L.add(s != null && Trim == true ? s.trim() : s);
          }
        return CollectionUtil.toStringArray(L);
      }

    /**
     * Splits a string based on separator regex using the standard String.split() method. Implements a null-or-empty check
     * on Str and returns null if true.
     * 
     * @param Str
     * @param SeparatorRegEx
     * @return
     */
    public static final String[] split(String str, String separatorRegEx)
      {
        return isNullOrEmpty(str) == true ? null : str.split(separatorRegEx);
      }

    public static final String print(List<?> L, String separator)
      {
        return L == null ? null : print(L.iterator(), separator);
      }



    /**
     * Allows for rhs to start and/or end with a '*' character for a partial equal against lhs
     * 
     * @param lhs a string that must not be null.
     * @param rhs a string that may be null (method will return false)
     * @return true if there is a match.
     */
    public static final boolean starEqual(String lhs, String rhs)
      {
        if (rhs == null)
          return false;
        boolean StartsWith = rhs.startsWith("*") == true;
        boolean EndsWith = rhs.endsWith("*") == true;
        if (StartsWith == true && EndsWith == true)
          return lhs.contains(rhs.substring(1, rhs.length() - 1));
        if (StartsWith == true)
          return lhs.endsWith(rhs.substring(1));
        if (EndsWith == true)
          return lhs.startsWith(rhs.substring(0, rhs.length() - 1));
        return lhs.equals(rhs);
      }

    public static final boolean starEqualIgnoreCase(String lhs, String rhs)
      {
        if (rhs == null)
          return false;
        return starEqual(lhs.toLowerCase(), rhs.toLowerCase());
      }

    /**
     * This is an expensive function, so cache results please
     * 
     * @param Str
     * @return
     */
    public static final String semiMask(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() <= 4)
          return "***";
        return semiMask(Str, (Str.length() / 10) + 3);
      }

    private static final String semiMask(String Str, int m)
      {
        StringBuilder S = new StringBuilder();
        for (int i = 0; i < Str.length(); ++i)
          S.append(i == Str.length() - 1 || i % m == 0 ? Str.charAt(i) : '*');
        return S.toString();
      }


    public static final String capitalizeEachWord(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        Str = Str.trim();
        boolean first = true;
        char[] str = Str.toCharArray();
        for (int i = 0; i < str.length; ++i)
          {
            char c = str[i];
            str[i] = (first == true && (i == 0 || i > 0 && str[i - 1] != '\'')) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            first = Character.isAlphabetic(c) == false;
          }
        return new String(str);
      }

    /**
     * Returns a standardized name string as "[title] UPPER([last]), CAPITALIZED([first]) UPPER(FIRST_CHAR([middle])).".
     * If both [last] and [first] are null or empty, a null string is returned. If one of them is null or empty, the output
     * is adapted as necessary, i.e., "[title] CAPITALIZED([first]) UPPER(FIRST_CHAR([middle]))." or "[title] <UPPER[last]] UPPER(FIRST_CHAR([middle])).".
     * The [title] and [middle] parts are omitted if null or empty.
     * @param Title
     * @param Last
     * @param First
     * @param Middle
     * @return
     */
    public static final String standardizeFullName(String Title, String Last, String First, String Middle)
      {
        Title = isNullOrEmpty(Title) ? "" : Title + " ";
        Last = isNullOrEmpty(Last) ? null : Last.trim().toUpperCase();
        First = isNullOrEmpty(First) ? null : capitalizeEachWord(First.trim());
        Middle = isNullOrEmpty(Middle) ? "" : " " + Character.toUpperCase(Middle.trim().charAt(0)) + ".";

        return Last == null && First == null ? null
                                             : Title + (Last==null ? "" : (Last + (First == null ? "" : ", "))) + (First==null ? "" : First) + Middle
               ;
      }

    public static final String maskName(String Last, String First, long RefNum)
      {
        String MaskedName = (isNullOrEmpty(First) == true ? "" : Character.toUpperCase(First.charAt(0)) + "") + (isNullOrEmpty(Last) == true ? "" : Character.toUpperCase(Last.charAt(0)) + "");
        if (MaskedName.length() == 0)
          MaskedName = "Person";
        if (RefNum != 0 && RefNum != SystemValues.EVIL_VALUE)
          MaskedName += "_" + RefNum;
        else
          MaskedName += " ###";
        return MaskedName;
      }

    public static final String maskName(String StandardFullName, long RefNum)
      {
        String[] Parts = StandardFullName.split("\\s*,\\s*|\\s");
        String Last = Parts.length > 0 ? Parts[0] : "";
        String First = Parts.length > 1 ? Parts[1] : "";

        String MaskedName = (isNullOrEmpty(First) == true ? "" : Character.toUpperCase(First.charAt(0)) + "") + (isNullOrEmpty(Last) == true ? "" : Character.toUpperCase(Last.charAt(0)) + "");
        if (MaskedName.length() == 0)
          MaskedName = "Patient";
        if (RefNum != 0 && RefNum != SystemValues.EVIL_VALUE)
          MaskedName += "_" + RefNum;
        else
          MaskedName += " ###";
        return MaskedName;
      }


    public static final String capitalizeFirstCharacter(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() == 1)
          return "" + Character.toUpperCase(Str.charAt(0));
        return Character.toUpperCase(Str.charAt(0)) + Str.substring(1);
      }

    public static final String normalCapitalization(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() == 1)
          return "" + Character.toUpperCase(Str.charAt(0));
        return Character.toUpperCase(Str.charAt(0)) + Str.substring(1).toLowerCase();
      }


    public static final void listPrint(StringBuilder Str, String Sep, String Val)
      {
        if (isNullOrEmpty(Val) == false)
          {
            if (Str.length() != 0)
              Str.append(Sep);
            Str.append(Val);
          }
      }

    public static final void sortDoubleDimensionArray(String StrArr[][])
      {
        if (StrArr != null)
          {
            Arrays.sort(StrArr, new Comparator<String[]>()
              {
                @Override
                public int compare(final String[] entry1, final String[] entry2)
                  {
                    final String val1 = entry1[0];
                    final String val2 = entry2[0];
                    return val1.compareTo(val2);
                  }
              });
          }
      }

    public static final String sortAndConcatenateStringArray(String StrArray[], String Separator)
      {
        String Result = null;
        if (StrArray != null && Separator != null)
          {
            Arrays.sort(StrArray);
            StringBuilder Str = new StringBuilder();
            for (int i = 0; i < StrArray.length; ++i)
              {
                if (i == 0)
                  Str.append(StrArray[i]);
                else
                  Str.append(Separator).append(StrArray[i]);
              }
            Result = Str.toString();
          }
        return Result;
      }

    public static final String removeTokenFromArray(String Source[], String DeleteToken)
      {
        String Result = null;
        if (Source != null)
          {
            StringBuilder Str = new StringBuilder();
            for (int i = 0; i < Source.length; ++i)
              {
                if (Source[i].equalsIgnoreCase(DeleteToken) == false)
                  Str.append(",").append(Source[i]);
              }
            if (Str != null && Str.length() > 0)
              Str.deleteCharAt(0);

            Result = Str.toString();
          }
        return Result;
      }

    public static final String toLettersAndDigits(String Str)
      {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Str.length(); ++i)
          {
            char c = Str.charAt(i);
            if (Character.isLetterOrDigit(c) == true)
              s.append(c);
          }
        return s.toString();
      }


    public static final String printSQLIn(String Start, String CommaSeparatedList, String End)
     {
       StringBuilder str = new StringBuilder();
       printSQLIn(str, Start, CommaSeparatedList, End);
       return str.toString();
     }
    public static final boolean printSQLIn(StringBuilder Str, String Start, String CommaSeparatedList, String End)
      {
        String[] Parts = split(CommaSeparatedList, "\\s*,\\s*");
        if (Parts == null || Parts.length == 0)
          return false;
        boolean First = true;
        for (String s : Parts)
          {
            if (isNullOrEmpty(s) == true)
              continue;
            if (First == true)
              {
                Str.append(Start);
                First = false;
              }
            else
              Str.append(", ");
            escapeSingleQuoteForSQL(Str, s);
          }
        if (First == false)
          Str.append(End);
        return !First;
      }

    public static final String printSQLLike(String Start, String ColumnName, String CommaSeparatedList, String BooleanOperator)
      {
        StringBuilder str = new StringBuilder();
        printSQLLike(str, Start, ColumnName, CommaSeparatedList, BooleanOperator);
        return str.toString();
      }

    public static final boolean printSQLLike(StringBuilder Str, String Start, String ColumnName, String CommaSeparatedList, String BooleanOperator)
      {
        String[] Parts = split(CommaSeparatedList, "\\s*,\\s*");
        if (Parts == null || Parts.length == 0)
          return false;
        boolean First = true;
        for (String s : Parts)
          {
            if (isNullOrEmpty(s) == true)
              continue;
            if (First == true)
              {
                Str.append(" ").append(Start).append(" (").append(ColumnName).append(" like ");
                First = false;
              }
            else
              Str.append(" ").append(BooleanOperator).append(" ").append(ColumnName).append(" like ");
            escapeSingleQuoteForSQL(Str, s, "'%", "%'");
          }
        if (First == false)
          Str.append(")");
        return !First;
      }

    public static final String asNonBreakingHTML(String str)
      {
        return str.replaceAll("\\s", "&nbsp;");
      }


    public static final boolean toBoolean(String val)
      {
        return val != null && (val.equals("1") || val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("T") || val.equalsIgnoreCase("YES") || val.equalsIgnoreCase("TRUE"));
      }

    public static final String escapeForRegex(String s)
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
          Str.append("\\").append(s.charAt(i));

        return Str.toString();
      }

    public static final boolean crudeStringValidation(String Str, char Delimiter, char Escape)
      {
        Pattern P = Pattern.compile("^\\" + Escape + "\\" + Delimiter);
        Matcher m = P.matcher(Str);
        int count = 0;
        while (m.matches() == true)
          {
            ++count;
          }
        return count % 2 == 0;
      }

    /** Truncates the string and adds "..." if it is bigger than MaxLen */
    public static final String toMaxLength(String Str, int MaxLen)
      {
        return Str == null || Str.length() <= MaxLen ? Str : Str.substring(0, MaxLen - 3) + "...";
      }

    public static final String printVariableStr(String Value)
      {
        return printVariableStr(Value, 100);
      }

    public static final String printVariableStr(String Value, int MaxLen)
      {
        return "[" + (Value == null ? 0 : Value.length()) + "] " + toMaxLength(Value, MaxLen);
      }

    public static String trim(String Str)
      {
        return Str == null ? null : Str.trim();
      }

    public static String joinTrim(String[] A, String Separator)
      {
        if (A == null)
          return null;
        StringBuilder Str = new StringBuilder();
        for (String a : A)
          {
            if (TextUtil.isNullOrEmpty(a) == true)
              continue;

            if (Str.length() != 0)
              Str.append(Separator);
            Str.append(a.trim());
          }
        return Str.toString();
      }

    /**
     * Takes a string with a regex-based separator (e.g., \s+) and turns it into an array
     * of '%token%'. So 'a, b, c' with '(\s*,\s*)|\s+' will return ['%a%','%b%','%c%]
     * 
     * @param Val
     * @param splitRegex
     * @param lowerCase
     * @return
     */
    public static String[] partsSqlLike(String Val, String splitRegex, boolean lowerCase)
      {
        if (Val == null)
          return null;
        if (TextUtil.isNullOrEmpty(splitRegex) == true)
          return new String[] { Val
          };
        String[] Parts = Val.split(splitRegex);
        for (int i = 0; i < Parts.length; ++i)
          {
            String s = Parts[i];
            if (s != null)
              Parts[i] = "%" + (lowerCase == false ? s : s.toLowerCase()) + "%";
          }
        return Parts;
      }


    public static String printJsonQuotedStringValue(String v)
      {
        if (v == null || v.equals("null") == true || v.equals("undefined") == true)
          return "null";

        StringBuilder Str = new StringBuilder();
        Str.append("\"");
        for (int i = 0; i < v.length(); ++i)
          {
            char c = v.charAt(i);
            Str.append(c == '\n' ? "\\n" : c == '\r' ? "\\r" : c == '"' ? "\\\"" : c == '\\' ? "\\\\" : "" + c);
          }
        Str.append("\"");
        return Str.toString();
      }

    /**
     * Takes a string array and changes the array values to be sql likes, i.e., '%'+parts[i]+'%'
     * 
     * @param parts
     */
    public static void partsSqlLike(String[] parts)
      {
        if (parts != null)
          for (int i = 0; i < parts.length; ++i)
            parts[i] = '%' + parts[i] + '%';
      }

    /**
     * Returns a new Iterator on a list where all incoming values have been replaced by the mask
     * @param <T>
     * @param I
     * @param val
     * @return
     */
    public static <T> Iterator<T> mask(Iterator<T> I, T val)
      {
        List<T> L = new ArrayList<T>();
        while (I.hasNext() == true)
          L.add(val);
        return L.iterator();
      }

    public static <T> T[] mask(T[] A, T val)
      {
        T[] arr = (T[]) new Object[A.length];
        for (int i = 0; i < A.length; ++i)
          arr[i] = val;
        return arr;
      }
  }
