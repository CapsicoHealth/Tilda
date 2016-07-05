
package tilda.data._Tilda;

import java.io.IOException;
import java.io.Writer;
import java.time.ZonedDateTime;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.SyncStatus;
import tilda.enums.TransactionType;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({ "unused" })
public class TILDA__TESTING_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__TESTING_Json.class.getName());

   protected TILDA__TESTING_Json() { }

   /*@formatter:off*/
   @SerializedName("refnum2"    ) public List<Long>  _refnum2    ;
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("description") public String  _description;
   @SerializedName("desc2"      ) public String  _desc2      ;
   @SerializedName("desc3"      ) public String  _desc3      ;
   @SerializedName("desc4"      ) public String  _desc4      ;
   @SerializedName("desc5"      ) public String  _desc5      ;
   @SerializedName("desc6"      ) public String  _desc6      ;
   @SerializedName("tops"       ) public List<String>  _tops       ;
   @SerializedName("tops2"      ) public Set <String>  _tops2      ;
   @SerializedName("a1"         ) public Integer  _a1         ;
   @SerializedName("a2"         ) public Character  _a2         ;
   @SerializedName("a2b"        ) public List<Character>  _a2b        ;
   @SerializedName("a2c"        ) public Set <Character>  _a2c        ;
   @SerializedName("a3"         ) public Boolean  _a3         ;
   @SerializedName("a3b"        ) public List<Boolean>  _a3b        ;
   @SerializedName("a4"         ) public Double  _a4         ;
   @SerializedName("a4b"        ) public List<Double>  _a4b        ;
   @SerializedName("a5"         ) public Float  _a5         ;
   @SerializedName("a5b"        ) public List<Float>  _a5b        ;
   @SerializedName("a6"         ) public Long  _a6         ;
   @SerializedName("a6b"        ) public List<Long>  _a6b        ;
   @SerializedName("a6c"        ) public Set <Long>  _a6c        ;
   @SerializedName("a7"         ) public Integer  _a7         ;
   @SerializedName("a7b"        ) public List<Integer>  _a7b        ;
   @SerializedName("a8"         ) public byte[]  _a8         ;
   @SerializedName("a9"         ) public String  Str_a9         ;
   transient                      public ZonedDateTime  _a9         ;
   /*@formatter:on*/

   public tilda.data.Testing_Data Write(Connection C) throws Exception
    {
      if (_refnum2     == null || _refnum2    .isEmpty() == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TESTING.refnum2' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TESTING.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_a9         ) == false)
       {
         _a9          = DateTimeUtil.parsefromJSON(Str_a9         );
         if (   _a9          == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.TESTING.a9' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.Testing_Data Obj = tilda.data.Testing_Factory.Create(_refnum2, _name);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.TESTING object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.Testing_Data Obj) throws Exception
    {
      if (_refnum2    != null) Obj.setRefnum2    (_refnum2    );
      if (_name       != null) Obj.setName       (_name       );
      if (_description!= null) Obj.setDescription(_description);
      if (_desc2      != null) Obj.setDesc2      (_desc2      );
      if (_desc3      != null) Obj.setDesc3      (_desc3      );
      if (_desc4      != null) Obj.setDesc4      (_desc4      );
      if (_desc5      != null) Obj.setDesc5      (_desc5      );
      if (_desc6      != null) Obj.setDesc6      (_desc6      );
      if (_tops       != null) Obj.setTops       (_tops       );
      if (_tops2      != null) Obj.setTops2      (_tops2      );
      if (_a1         != null) Obj.setA1         (_a1         );
      if (_a2         != null) Obj.setA2         (_a2         );
      if (_a2b        != null) Obj.setA2b        (_a2b        );
      if (_a2c        != null) Obj.setA2c        (_a2c        );
      if (_a3         != null) Obj.setA3         (_a3         );
      if (_a3b        != null) Obj.setA3b        (_a3b        );
      if (_a4         != null) Obj.setA4         (_a4         );
      if (_a4b        != null) Obj.setA4b        (_a4b        );
      if (_a5         != null) Obj.setA5         (_a5         );
      if (_a5b        != null) Obj.setA5b        (_a5b        );
      if (_a6         != null) Obj.setA6         (_a6         );
      if (_a6b        != null) Obj.setA6b        (_a6b        );
      if (_a6c        != null) Obj.setA6c        (_a6c        );
      if (_a7         != null) Obj.setA7         (_a7         );
      if (_a7b        != null) Obj.setA7b        (_a7b        );
      if (_a8         != null) Obj.setA8         (_a8         );
      if (_a9         != null) Obj.setA9         (_a9         );
    }

   public String toString()
    {
      return
             "refnum2"    + (_refnum2     == null ? ": NULL" : ": " + _refnum2    )
         + "; name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+_name)
         + "; description"+ (_description == null ? ": NULL" : "(" + (_description == null ? 0 : _description.length())+"): "+(_description == null || _description.length() < 100 ? _description : _description.substring(0, 100)+"..."))
         + "; desc2"      + (_desc2       == null ? ": NULL" : "(" + (_desc2       == null ? 0 : _desc2      .length())+"): "+(_desc2       == null || _desc2      .length() < 100 ? _desc2       : _desc2      .substring(0, 100)+"..."))
         + "; desc3"      + (_desc3       == null ? ": NULL" : "(" + (_desc3       == null ? 0 : _desc3      .length())+"): "+(_desc3       == null || _desc3      .length() < 100 ? _desc3       : _desc3      .substring(0, 100)+"..."))
         + "; desc4"      + (_desc4       == null ? ": NULL" : "(" + (_desc4       == null ? 0 : _desc4      .length())+"): "+(_desc4       == null || _desc4      .length() < 100 ? _desc4       : _desc4      .substring(0, 100)+"..."))
         + "; desc5"      + (_desc5       == null ? ": NULL" : "(" + (_desc5       == null ? 0 : _desc5      .length())+"): "+(_desc5       == null || _desc5      .length() < 100 ? _desc5       : _desc5      .substring(0, 100)+"..."))
         + "; desc6"      + (_desc6       == null ? ": NULL" : "(" + (_desc6       == null ? 0 : _desc6      .length())+"): "+(_desc6       == null || _desc6      .length() < 100 ? _desc6       : _desc6      .substring(0, 100)+"..."))
         + "; tops"       + (_tops        == null ? ": NULL" : ": " + _tops       )
         + "; tops2"      + (_tops2       == null ? ": NULL" : ": " + _tops2      )
         + "; a1"         + (_a1          == null ? ": NULL" : ": " + _a1         )
         + "; a2"         + (_a2          == null ? ": NULL" : ": " + _a2         )
         + "; a2b"        + (_a2b         == null ? ": NULL" : ": " + _a2b        )
         + "; a2c"        + (_a2c         == null ? ": NULL" : ": " + _a2c        )
         + "; a3"         + (_a3          == null ? ": NULL" : ": " + _a3         )
         + "; a3b"        + (_a3b         == null ? ": NULL" : ": " + _a3b        )
         + "; a4"         + (_a4          == null ? ": NULL" : ": " + _a4         )
         + "; a4b"        + (_a4b         == null ? ": NULL" : ": " + _a4b        )
         + "; a5"         + (_a5          == null ? ": NULL" : ": " + _a5         )
         + "; a5b"        + (_a5b         == null ? ": NULL" : ": " + _a5b        )
         + "; a6"         + (_a6          == null ? ": NULL" : ": " + _a6         )
         + "; a6b"        + (_a6b         == null ? ": NULL" : ": " + _a6b        )
         + "; a6c"        + (_a6c         == null ? ": NULL" : ": " + _a6c        )
         + "; a7"         + (_a7          == null ? ": NULL" : ": " + _a7         )
         + "; a7b"        + (_a7b         == null ? ": NULL" : ": " + _a7b        )
         + "; a8"         + (_a8          == null ? ": NULL" : ": " + _a8         )
         + "; a9"         + (_a9          == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_a9))
         + ";";
    }

   public static void toJSONAAA(Writer Out, List<tilda.data.Testing_Data> L, String Lead, boolean FullList) throws IOException
    {
      if (L == null || L.size() == 0) return;
      if (FullList == true)
       Out.write("[\n");
      boolean First = true;
      for (tilda.data.Testing_Data O : L)
       if (O!=null)
        {
          Out.write(Lead);
          if (First == false) Out.write(","); else { Out.write(" "); First = false; }
          toJSONAAA(Out, O, true);
          Out.write("\n");
        }
      if (FullList == true)
       { 
          Out.write(Lead);
          Out.write("]\n");
       } 
    }

   public static void toJSONAAA(Writer Out, tilda.data.Testing_Data ObjApp, boolean FullObject) throws IOException
    {
      long T0 = System.nanoTime();
      tilda.data._Tilda.TILDA__TESTING Obj = (tilda.data._Tilda.TILDA__TESTING) ObjApp;
      if (FullObject == true)
       Out.write("{");

        JSONUtil.Print(Out, "refnum", true, Obj.getRefnum());

        JSONUtil.Print(Out, "refnum2", false, Obj._refnum2.toArray(new Long[Obj._refnum2.size()]));

        JSONUtil.Print(Out, "name", false, Obj.getName());

      if (Obj.isNullDescription() == false && Obj.getDescription() != null)
        JSONUtil.Print(Out, "description", false, Obj.getDescription());

      if (Obj.isNullDesc2() == false && Obj.getDesc2() != null)
        JSONUtil.Print(Out, "desc2", false, Obj.getDesc2());

      if (Obj.isNullDesc3() == false && Obj.getDesc3() != null)
        JSONUtil.Print(Out, "desc3", false, Obj.getDesc3());

      if (Obj.isNullDesc4() == false && Obj.getDesc4() != null)
        JSONUtil.Print(Out, "desc4", false, Obj.getDesc4());

      if (Obj.isNullDesc5() == false && Obj.getDesc5() != null)
        JSONUtil.Print(Out, "desc5", false, Obj.getDesc5());

      if (Obj.isNullDesc6() == false && Obj.getDesc6() != null)
        JSONUtil.Print(Out, "desc6", false, Obj.getDesc6());

      if (Obj.isNullTops() == false && Obj.getTops() != null)
        JSONUtil.Print(Out, "tops", false, Obj._tops.toArray(new String[Obj._tops.size()]));

      if (Obj.isNullTops2() == false && Obj.getTops2() != null)
        JSONUtil.Print(Out, "tops2", false, Obj._tops2.toArray(new String[Obj._tops2.size()]));

      if (Obj.isNullA1() == false)
        JSONUtil.Print(Out, "a1", false, Obj.getA1());

      if (Obj.isNullA2() == false)
        JSONUtil.Print(Out, "a2", false, Obj.getA2());

      if (Obj.isNullA2b() == false && Obj.getA2b() != null)
        JSONUtil.Print(Out, "a2b", false, Obj._a2b.toArray(new Character[Obj._a2b.size()]));

      if (Obj.isNullA2c() == false && Obj.getA2c() != null)
        JSONUtil.Print(Out, "a2c", false, Obj._a2c.toArray(new Character[Obj._a2c.size()]));

      if (Obj.isNullA3() == false)
        JSONUtil.Print(Out, "a3", false, Obj.getA3());

      if (Obj.isNullA3b() == false && Obj.getA3b() != null)
        JSONUtil.Print(Out, "a3b", false, Obj._a3b.toArray(new Boolean[Obj._a3b.size()]));

      if (Obj.isNullA4() == false)
        JSONUtil.Print(Out, "a4", false, Obj.getA4());

      if (Obj.isNullA4b() == false && Obj.getA4b() != null)
        JSONUtil.Print(Out, "a4b", false, Obj._a4b.toArray(new Double[Obj._a4b.size()]));

      if (Obj.isNullA5() == false)
        JSONUtil.Print(Out, "a5", false, Obj.getA5());

      if (Obj.isNullA5b() == false && Obj.getA5b() != null)
        JSONUtil.Print(Out, "a5b", false, Obj._a5b.toArray(new Float[Obj._a5b.size()]));

      if (Obj.isNullA6() == false)
        JSONUtil.Print(Out, "a6", false, Obj.getA6());

      if (Obj.isNullA6b() == false && Obj.getA6b() != null)
        JSONUtil.Print(Out, "a6b", false, Obj._a6b.toArray(new Long[Obj._a6b.size()]));

      if (Obj.isNullA6c() == false && Obj.getA6c() != null)
        JSONUtil.Print(Out, "a6c", false, Obj._a6c.toArray(new Long[Obj._a6c.size()]));

      if (Obj.isNullA7() == false)
        JSONUtil.Print(Out, "a7", false, Obj.getA7());

      if (Obj.isNullA7b() == false && Obj.getA7b() != null)
        JSONUtil.Print(Out, "a7b", false, Obj._a7b.toArray(new Integer[Obj._a7b.size()]));

      if (Obj.isNullA9() == false && Obj.getA9() != null)
        JSONUtil.Print(Out, "a9", false, Obj.getA9());

        JSONUtil.Print(Out, "created", false, Obj.getCreated());

        JSONUtil.Print(Out, "lastUpdated", false, Obj.getLastUpdated());

      if (FullObject == true)
       Out.write(" }\n");
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

   public static void toJSONBBB(Writer Out, List<tilda.data.Testing_Data> L, String Lead, boolean FullList) throws IOException
    {
      if (L == null || L.size() == 0) return;
      if (FullList == true)
       Out.write("[\n");
      boolean First = true;
      for (tilda.data.Testing_Data O : L)
       if (O!=null)
        {
          Out.write(Lead);
          if (First == false) Out.write(","); else { Out.write(" "); First = false; }
          toJSONBBB(Out, O, true);
          Out.write("\n");
        }
      if (FullList == true)
       { 
          Out.write(Lead);
          Out.write("]\n");
       } 
    }

   public static void toJSONBBB(Writer Out, tilda.data.Testing_Data ObjApp, boolean FullObject) throws IOException
    {
      long T0 = System.nanoTime();
      tilda.data._Tilda.TILDA__TESTING Obj = (tilda.data._Tilda.TILDA__TESTING) ObjApp;
      if (FullObject == true)
       Out.write("{");

        JSONUtil.Print(Out, "refnum", true, Obj.getRefnum());

        JSONUtil.Print(Out, "refnum2", false, Obj._refnum2.toArray(new Long[Obj._refnum2.size()]));

        JSONUtil.Print(Out, "name", false, Obj.getName());

      if (Obj.isNullDescription() == false && Obj.getDescription() != null)
        JSONUtil.Print(Out, "description", false, Obj.getDescription());

      if (Obj.isNullDesc2() == false && Obj.getDesc2() != null)
        JSONUtil.Print(Out, "desc2", false, Obj.getDesc2());

      if (Obj.isNullDesc3() == false && Obj.getDesc3() != null)
        JSONUtil.Print(Out, "desc3", false, Obj.getDesc3());

      if (FullObject == true)
       Out.write(" }\n");
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
