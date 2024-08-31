package tilda.utils.json.elements;

import java.io.Writer;
import java.time.ZonedDateTime;

import tilda.utils.json.JSONUtil;

public class ElementZonedDateTime implements ElementDef
  {
    public ElementZonedDateTime(String Name, ZonedDateTime Val)
      {
        _Name = Name;
        _Val = Val;
      }

    protected final String        _Name;
    protected final ZonedDateTime _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
//        Out.write(Header);
        JSONUtil.print(Out, _Name, FirstElement, _Val);
      }
  }
