package tilda.utils.json.elements;

import java.io.Writer;
import java.util.UUID;

import tilda.utils.json.JSONUtil;

public class ElementUUID implements ElementDef
  {
    public ElementUUID(String Name, UUID Val)
      {
        _Name = Name;
        _Val = Val;
      }

    protected final String _Name;
    protected final UUID   _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        // Out.write(Header);
        JSONUtil.print(Out, _Name, FirstElement, _Val);
      }
  }
