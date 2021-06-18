package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementRaw implements ElementDef
  {
    public ElementRaw(String Name, String JsonRawValue)
      {
        _Name = Name;
        _Val = JsonRawValue;
      }

    protected final String _Name;
    protected final String _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.printRawObject(Out, _Name, FirstElement, _Val);
      }
  }
