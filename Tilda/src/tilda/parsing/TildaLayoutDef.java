package tilda.parsing;

import com.google.gson.annotations.SerializedName;

public class TildaLayoutDef
  {
    /*@formatter:off*/
    @SerializedName("prop"      ) public String            _prop ;
    @SerializedName("label"     ) public String            _label;
    @SerializedName("group"     ) public int               _group = 0 ;
    @SerializedName("flatPrint" ) public boolean           _flatPrint = false ;
    @SerializedName("nextLine"  ) public boolean           _nextLine = false ;
//    @SerializedName("alignOn"   ) public int               _alignOn = -1 ;
    @SerializedName("subProps"  ) public TildaLayoutDef[]  _subProps = new TildaLayoutDef[] { } ;
    /*@formatter:on*/

    public static TildaLayoutDef getProp(TildaLayoutDef[] tldl, String name)
      {
        for (TildaLayoutDef tld : tldl)
          if (tld._prop.equals(name) == true)
            return tld;
        return null;
      }

    public static boolean hasNextLine(TildaLayoutDef[] tildaLayoutDefs)
      {
        if (tildaLayoutDefs != null)
          for (TildaLayoutDef tld : tildaLayoutDefs)
            if (tld._nextLine == true)
              return true;
        return false;
      }
  }
