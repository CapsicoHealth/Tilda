package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementLongArray implements ElementDef
  {
    public ElementLongArray(String Name, long[] Val)
      {
        _Name = Name;
        _Val = Val;
      }

    protected final String _Name;
    protected final long[] _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        Out.write(Header);
        JSONUtil.print(Out, _Name, FirstElement, _Val);
      }
  }
