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
import java.time.ZonedDateTime;
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

import tilda.db.JDBCHelper;

public class TextUtil
  {
    protected static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    public static void PrintStringsCommaDelimited(PrintStream Out, List<String> Strings, String Quotable)
      {
        boolean First = true;
        for (String Str : Strings)
          {
            if (First == true)
             First = false;
            else
             Out.print(",");
            if (Quotable != null)
              Out.print(Quotable);
            Out.print(Str);
            if (Quotable != null)
              Out.print(Quotable);
          }
      }

    /**
     * Useful methods when creating string constants you don't want to be considered as compile-time constants (i.e.,
     * not be inlined in referring code).
     * 
     * @param Str The String to process
     * @return The string passed in, unchanged.
     */
    public static String Identity(String Str)
      {
        return Str;
      }

    public static final String Quote(String S, char Q)
      {
        return Q + S + Q;
      }

    public static final String QuoteSingle(String S)
      {
        return '\'' + S + '\'';
      }

    public static final String QuoteDouble(String S)
      {
        return '"' + S + '"';
      }

    public static final String EscapeSingleQuoteBaseForSQL(String S)
      {
        StringBuilder X = new StringBuilder(S.length() + 8);
        EscapeSingleQuoteForSQL(X, S, "", "");
        return X.toString();
      }

    public static final String EscapeSingleQuoteForSQL(String S)
      {
        StringBuilder X = new StringBuilder();
        EscapeSingleQuoteForSQL(X, S, "'", "'");
        return X.toString();
      }

    public static final void EscapeSingleQuoteForSQL(StringBuilder X, String S)
      {
        EscapeSingleQuoteForSQL(X, S, "'", "'");
      }
    

    public static final void EscapeSingleQuoteForSQL(StringBuilder X, String[] S, boolean First)
      {
        if (S != null)
          for (String s : S)
            {
              if (s==null)
               continue;
              if (First == true)
                First = false;
              else
                X.append(", ");
              EscapeSingleQuoteForSQL(X, s);
            }
      }

    public static final <T> void EscapeSingleQuoteForSQL(StringBuilder X, Collection<T> Strs, boolean First)
      {
        if (Strs != null)
          for (T s : Strs)
            {
              if (s==null)
               continue;
              if (First == true)
                First = false;
              else
                X.append(", ");
              EscapeSingleQuoteForSQL(X, s.toString());
            }
      }

    public static final void EscapeSingleQuoteForSQL(StringBuilder X, String S, String Before, String End)
      {
        if (Before != null)
          X.append(Before);

        if (S != null)
          {
            int l = S.length();
            char[] s = S.toCharArray();
            int i = 0;
            int j = 0;
            while (j < l && s[j] != '\'')
              ++j;
            while (j < l)
              {
                ++j;
                X.append(s, i, j - i).append('\'');
                i = j;
                while (j < l && s[j] != '\'')
                  ++j;
              }
            X.append(s, i, l - i);
          }

        if (End != null)
          X.append(End);
      }

    public static final String EscapeDoubleQuoteWithSlash(String S, String BeforeAndAfter, boolean Double)
      {
        StringBuilder X = new StringBuilder();
        EscapeSomethingWithSlash(X, '"', S, BeforeAndAfter, BeforeAndAfter, Double);
        return X.toString();
      }

    public static final String EscapeDoubleQuoteWithSlash(String S)
      {
        StringBuilder X = new StringBuilder();
        EscapeSomethingWithSlash(X, '"', S, "\"", "\"", false);
        return X.toString();
      }

    public static final void EscapeDoubleQuoteWithSlash(StringBuilder X, String S)
      {
        EscapeSomethingWithSlash(X, '"', S, "\"", "\"", false);
      }

    public static final void EscapeDoubleQuoteWithSlash(StringBuilder X, String S, String Before, String End)
      {
        EscapeSomethingWithSlash(X, '"', S, Before, End, false);
      }
    
    public static final String EscapeDoubleQuoteForCSV(String S)
      {
        StringBuilder X = new StringBuilder();
        EscapeSomethingWithSomething(X, '"', "\"", S, "\"", "\"");
        return X.toString();
      }

    public static final String EscapeSingleQuoteWithSlashDouble(String S)
      {
        StringBuilder X = new StringBuilder();
        EscapeSomethingWithSlash(X, '\'', S, "'", "'", true);
        return X.toString();
      }

    public static final String EscapeSingleQuoteWithSlash(String S)
      {
        StringBuilder X = new StringBuilder();
        EscapeSomethingWithSlash(X, '\'', S, "'", "'", false);
        return X.toString();
      }

    public static final void EscapeSingleQuoteWithSlash(StringBuilder X, String S)
      {
        EscapeSomethingWithSlash(X, '\'', S, "'", "'", false);
      }

    public static final void EscapeSingleQuoteWithSlash(StringBuilder X, String S, String Before, String End)
      {
        EscapeSomethingWithSlash(X, '\'', S, Before, End, false);
      }

    public static final void EscapeAllQuotesWithSlash(StringBuilder X, String S)
      {
        EscapeAllQuotesWithSlash(X, S, "\"", "\"");
      }

    public static final void EscapeAllQuotesWithSlash(StringBuilder X, String S, String Before, String End)
      {
        StringBuilder XX = new StringBuilder(128);
        EscapeSomethingWithSlash(XX, '"', S, null, null, false);
        EscapeSomethingWithSlash(X, '\'', XX.toString(), Before, End, false);
      }

    public static final void EscapeSomethingWithSlash(StringBuilder X, char Something, String S, String Before, String End, boolean Double)
      {
        EscapeSomethingWithSomething(X, Something, Double ? "\\\\\\" : "\\", S, Before, End);
      }
    
    private static final void EscapeSomethingWithSomething(StringBuilder X, char Something1, String Something2, String S, String Before, String End)
      {
        if (Before != null)
          {
            X.append(Before);
          }
        if (S != null)
          {
            int l = S.length();
            char[] s = S.toCharArray();
            int i = 0;
            int j = 0;
            while (j < l && s[j] != Something1)
              ++j;
            while (j < l)
              {
                X.append(s, i, j - i).append(Something2).append(Something1);
                ++j;
                i = j;
                while (j < l && s[j] != Something1)
                  ++j;
              }
            X.append(s, i, l - i);
          }

        if (End != null)
          {
            X.append(End);
          }
      }
    

    public static final String EscapeHTMLQuotes(String S)
      {
        return EscapeHTMLJavaScriptQuotes(S, "\"");
      }

    public static final String EscapeJavaScriptQuotes(String S)
      {
        return EscapeHTMLJavaScriptQuotes(S, "'");
      }

    public static final String EscapeHTMLJavaScriptQuotes(String S)
      {
        return EscapeHTMLJavaScriptQuotes(S, "");
      }

    public static final String EscapeHTMLJavaScriptQuotes(String S, String BeforeAfter)
      {
        if (S == null)
          return BeforeAfter + BeforeAfter;
        StringBuilder X = new StringBuilder(128);
        X.append(BeforeAfter);

        int len = S.length();
        char[] s = S.toCharArray();
        int i = 0;
        int j = 0;
        while (j < len && s[j] != '"' && s[j] != '\'' && s[j] != '\n' && s[j] != '\r' && s[j] != '\\' && s[j] != '<')
          ++j;
        if (j >= len)
          {
            X.append(S);
            X.append(BeforeAfter);
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
        X.append(BeforeAfter);
        return X.toString();
      }

    public static boolean isNullOrEmpty(String Str)
      {
        if (Str != null && Str.isEmpty() == false)
          for (int i = 0; i < Str.length(); ++i)
            if (Character.isWhitespace(Str.charAt(i)) == false)
              return false;
        return true;
      }

    public static final String SearchReplace(String Str, String Search, String Replace)
      {
        if (Str == null)
          return Str;
        int i = 0;
        int j = Str.indexOf(Search);
        if (j == -1)
          return Str;

        char[] S = Str.toCharArray();
        StringBuilder X = new StringBuilder(256);

        while (j != -1)
          {
            X.append(S, i, j - i).append(Replace);
            i = j + Search.length();
            j = Str.indexOf(Search, i);
          }
        return X.append(S, i, S.length - i).toString();
      }

    public static final StringBuilder SearchReplace(StringBuilder StrBuf, String Str, String Search, String Replace)
      {
        if (Str == null)
          return StrBuf;
        int i = 0;
        int j = Str.indexOf(Search);
        if (j == -1)
          return StrBuf.append(Str);

        char[] S = Str.toCharArray();
        while (j != -1)
          {
            StrBuf.append(S, i, j - i).append(Replace);
            i = j + Search.length();
            j = Str.indexOf(Search, i);
          }
        return StrBuf.append(S, i, S.length - i);
      }

    public static final Writer SearchReplace(Writer Out, String Str, String Search, String Replace)
      throws IOException
      {
        if (Str == null)
          return Out;
        int i = 0;
        int j = Str.indexOf(Search);
        if (j == -1)
          {
            Out.write(Str);
            return Out;
          }

        char[] S = Str.toCharArray();
        while (j != -1)
          {
            Out.write(S, i, j - i);
            Out.write(Replace);
            i = j + Search.length();
            j = Str.indexOf(Search, i);
          }
        Out.write(S, i, S.length - i);
        return Out;
      }

    public static String RemoveElement(int Index, String Vals, char Separator)
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

    public static int FindElement(String V, String Vals, char Separator)
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
    
    public static int FindElement(String[] A, String Val, boolean IgnoreCase, int Start)
      {
        for (int i = Start; i < A.length; ++i)
          {
            String Str = A[i];
            if (Str == null)
              continue;
            if (IgnoreCase == true && Str.equalsIgnoreCase(Val) == true || IgnoreCase == false && Str.equals(Val) == true)
              return i;
          }
        return -1;
      }
    
    public static int FindElement(String[][] A, String Val, int pos, boolean IgnoreCase, int Start)
      {
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
    

    public static String GetElement(int Index, String Vals, char Separator)
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


    public static String ToShortDollarStr(double Value)
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

    public static int Count(String Src, char c)
      {
        int count = 0;
        int i = -1;
        while ((i = Src.indexOf(c, i + 1)) != -1)
          ++count;
        return count;
      }

    public static int Count(String Src, String c)
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

    public static String ProcessTextToHTMLParagraphs(String Text, String StyleClass)
      {
        Text = Text.replace("<br>", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("<BR>", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("\r\n", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("\n", "</P><P class='" + StyleClass + "'>");
        Text = Text.replace("<P class='" + StyleClass + "'></P>", "\n<P class='" + StyleClass + "_SEP'> </P>\n");
        Text = Text.replace("</P><P class=", "</P>\n<P class=");
        return "<P class='" + StyleClass + "'>" + Text + "</P>";
      }

    public static String NoNullPrint(String Val, String Default)
      {
        return Val == null ? Default : Val;
      }
    public static String NoNullOrEmptyPrint(String Val, String Default)
      {
        return isNullOrEmpty(Val) == true ? Default : Val;
      }

    /**
     * Takes a string and rewrites it by replacing all special characters with an '_'. Special characters include
     * ' ', '*', '\'', '/', '"', ':', ';', ',', '.', '%', '+', '&', '=', '?'
     */
    public static String SanitizeName(String Name)
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
                  C[i] = '_';
              }
          }
        return new String(C);
      }


    /**
     * Takes a string and rewrites it in lower case, and removing all non alpha-numeric characters. For example
     * "This is * TEST" becomes "thisistest"
     */
    public static String SimplifyName(String Name)
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
            Str.append(EscapeJavaScriptQuotes(v));
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

    public static String ReplaceAccentedCharacters(String Str)
      {
        char[] Chars = Str.toCharArray();
        for (int i = 0; i < Chars.length; ++i)
          {
            char c = isAccentedCharacter(Chars[i]);
            if (c != Character.UNASSIGNED)
              Chars[i] = c;
          }
        return new String(Chars);
      }

    public static char RemoveAccent(char c)
      {
        char ch = isAccentedCharacter(c);
        if (ch != Character.UNASSIGNED)
          System.out.println("Character: " + c + "; Unaccented: " + ch);
        return ch == Character.UNASSIGNED ? c : ch;
      }

    public static String ReplaceAccentedCharactersWithWebSpecialCharacters(String Str)
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

    public static String ConvertWebSpecialCharacters(String Str)
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

    public static String[] Unique(String[] strings)
      {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < strings.length; i++)
          {
            String name = strings[i].toLowerCase();
            set.add(name);
          }
        return set.toArray(new String[0]);
      }

    public static void Print(String[] StrArray, StringBuilder s)
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
            s.append(str);
          }
      }

    public static String Print(String[][] A, int pos)
    {
      StringBuilder s = new StringBuilder();
      Print(A, pos, s);
      return s.toString();
    }
    
    public static void Print(String[][] StrArray, int pos, StringBuilder s)
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

    public static final String Print(Iterator<?> I)
      {
        StringBuilder s = new StringBuilder();
        Print(I, s);
        return s.toString();
      }
    public static final void Print(Iterator<?> I, StringBuilder s)
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
            if (O==null)
             s.append("null");
            else
             s.append(O.getClass()==ZonedDateTime.class ? DateTimeUtil.printDateTimeCompact((ZonedDateTime)O, true, true) : O.toString());
          }
      }
    
    public static final void PrintWithQuotes(String[] StrArray, StringBuilder s)
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

    public static final String Print(String[] StrArray)
      {
        StringBuilder Str = new StringBuilder();
        Print(StrArray, Str);
        return Str.toString();
      }


    /**
     * Prints Str is it is not null and not empty. Otherwise, prints Default.
     * 
     * @param Str
     * @param Default
     * @return
     * @see #isNullOrEmpty(String)
     */
    public static final String Print(String Str, String Default)
      {
        return isNullOrEmpty(Str) == false ? Str : Default;
      }


    public static final void EscapeXML(PrintWriter Out, String Str)
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

    public static final void EscapeXML(PrintStream Out, String Str)
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


    public static final void PrintXMLTag(PrintWriter Out, String Lead, String Tag, String Content)
      {
        if (isNullOrEmpty(Content) == false)
          {
            Out.print(Lead);
            Out.print("<");
            Out.print(Tag);
            Out.print(">");
            EscapeXML(Out, Content);
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
     * Splits a string based on Splitter using the String.split() method. Additionally, calls trim() on all results.
     * 
     * @param Source
     * @param Splitter
     * @return
     */
    public static final String[] TrimSplit(String Source, String Splitter)
      {
        String[] S = Source.split(Splitter);
        for (int i = 0; i < S.length; ++i)
          {
            S[i] = S[i].trim();
          }
        return S;
      }

    public static final String StreamToString(InputStream In)
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


    public static final void PrintExceptionMessages(StringBuilder Str, boolean HTML, Throwable T, boolean PrintCauseToo)
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

    public static final void PrintException(StringBuilder Str, boolean HTML, Throwable T, boolean PrintCauseToo)
      {
        if (PrintCauseToo == true && T.getCause() != null)
          {
            PrintException(Str, HTML, T.getCause());
            if (HTML == true)
              Str.append("<BR>");
            Str.append("\n");
          }
        PrintException(Str, HTML, T);
      }

    protected static final void PrintException(StringBuilder Str, boolean HTML, Throwable T)
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

    public static final String Merge(String Set1, String Set2, String Separator)
      {
        return Merge(Set1, Set2, Separator, Separator, true, false);
      }

    public static final String Merge(String Set1, String Set2, String SeparatorRegEx, String SeparatorStr, boolean TrailingSeparator, boolean Trim)
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
    
    public static final boolean indexOf(String Str, String[] A)
      {
        if (Str == null || A == null)
         return false;
        for (String s : A)
          if (Str.indexOf(s) != -1)
           return true;
        return false;
      }
    

    public static final boolean Equals(String S1, String S2)
      {
        if (S1 == null && S2 == null)
          return true;
        if (S1 == null || S2 == null)
          return false;
        return S1.equals(S2);
      }

    public static final String GenerateLead(char C, int Level)
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < Level; ++i)
          Str.append(C);
        return Str.toString();
      }

    public static final String Print(int[] Integers, String Post)
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

    public static final String[] Split(String Str, String SeparatorRegEx)
      {
        return isNullOrEmpty(Str) == true ? null : Str.split(SeparatorRegEx);
      }

    public static final String Print(List<?> L, String Separator)
      {
        if (L == null || L.isEmpty() == true)
          return null;
        StringBuilder Str = new StringBuilder();
        for (Object o : L)
          {
            if (Str.length() != 0)
              Str.append(Separator);
            Str.append(o.toString());
          }
        return Str.toString();
      }



    /**
     * Allows for rhs to start and/or end with a '*' character for a partial equal against lhs
     * 
     * @param lhs a string that must not be null.
     * @param rhs a string that may be null (method will return false)
     * @return true if there is a match.
     */
    public static final boolean StarEqual(String lhs, String rhs)
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

    public static final boolean StarEqualIgnoreCase(String lhs, String rhs)
      {
        if (rhs == null)
          return false;
        return StarEqual(lhs.toLowerCase(), rhs.toLowerCase());
      }

    /**
     * This is an expensive function, so cache results please
     * 
     * @param Str
     * @return
     */
    public static final String SemiMask(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() <= 4)
          return "***";
        return SemiMask(Str, (Str.length() / 10) + 3);
      }

    private static final String SemiMask(String Str, int m)
      {
        StringBuilder S = new StringBuilder();
        for (int i = 0; i < Str.length(); ++i)
          S.append(i == Str.length() - 1 || i % m == 0 ? Str.charAt(i) : '*');
        return S.toString();
      }


    public static final String CapitalizeEachWord(String Str)
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

    public static final String StandardizeFullName(String Title, String Last, String First, String Middle)
      {
        Title = isNullOrEmpty(Title) ? "" : Title+" ";
        Last = isNullOrEmpty(Last) ? "" : Last.trim().toUpperCase();
        First = isNullOrEmpty(First) ? "" : CapitalizeEachWord(First.trim());
        Middle = isNullOrEmpty(Middle) ? "" : " " + Character.toUpperCase(Middle.trim().charAt(0)) + ".";

        return Title + Last + ", " + First + Middle;
      }

    public static final String MaskName(String Last, String First, long RefNum)
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

    public static final String MaskName(String StandardFullName, long RefNum)
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


    public static final String CapitalizeFirstCharacter(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() == 1)
         return ""+Character.toUpperCase(Str.charAt(0));
        return Character.toUpperCase(Str.charAt(0))+Str.substring(1);
      }

    public static final String NormalCapitalization(String Str)
      {
        if (isNullOrEmpty(Str) == true)
          return null;
        if (Str.length() == 1)
         return ""+Character.toUpperCase(Str.charAt(0));
        return Character.toUpperCase(Str.charAt(0))+Str.substring(1).toLowerCase();
      }
    
    
    public static final void ListPrint(StringBuilder Str, String Sep, String Val)
      {
        if (isNullOrEmpty(Val) == false)
          {
            if (Str.length() != 0)
              Str.append(Sep);
            Str.append(Val);
          }
      }

    public static final void SortDoubleDimensionArray(String StrArr[][])
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

    public static final String SortAndConcatenateStringArray(String StrArray[], String Separator)
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

    public static final String RemoveTokenFromArray(String Source[], String DeleteToken)
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


    public static final boolean PrintSQLIn(StringBuilder Str, String Start, String CommaSeparatedList, String End)
      {
        String[] Parts = Split(CommaSeparatedList, "\\s*,\\s*");
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
            EscapeSingleQuoteForSQL(Str, s);
          }
        if (First == false)
          Str.append(End);
        return !First;
      }

    public static final boolean PrintSQLLike(StringBuilder Str, String Start, String ColumnName, String CommaSeparatedList, String BooleanOperator)
      {
        String[] Parts = Split(CommaSeparatedList, "\\s*,\\s*");
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
            EscapeSingleQuoteForSQL(Str, s, "'%", "%'");
          }
        if (First == false)
          Str.append(")");
        return !First;
      }

    public static final String AsNonBreakingHTML(String str)
      {
        return str.replaceAll("\\s", "&nbsp;");
      }


    public static final boolean toBoolean(String val)
      {
        return val != null && (val.equals("1") || val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("T") || val.equalsIgnoreCase("YES") || val.equalsIgnoreCase("TRUE"));
      }

    public static final String EscapeForRegex(String s)
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
          Str.append("\\").append(s.charAt(i));

        return Str.toString();
      }

    public static final boolean CrudeStringValidation(String Str, char Delimiter, char Escape)
      {
        Pattern P = Pattern.compile("^\\"+Escape+"\\"+Delimiter);
        Matcher m = P.matcher(Str);
        int count = 0;
        while (m.matches() == true)
         {
           ++count;
         }
        return count%2 == 0;
      }
    
    /** Truncates the string and adds "..." if it is bigger than MaxLen */
    public static final String toMaxLength(String Str, int MaxLen)
      {
        return Str == null || Str.length() <= MaxLen ? Str : Str.substring(0, MaxLen - 3) + "...";
      }

    public static final String PrintVariableStr(String Value)
     {
       return PrintVariableStr(Value, 100);      
     }
    
    public static final String PrintVariableStr(String Value, int MaxLen)
     {
       return "["+ (Value == null ? 0 : Value.length())+"] "+toMaxLength(Value, MaxLen);      
     }
    

  }
