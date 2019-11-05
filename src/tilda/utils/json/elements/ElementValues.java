package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementValues implements ElementDef
  {
    public ElementValues(String Name, String[][] Val)
      {
        _Name = Name;
        _Val = Val;
      }

    protected final String     _Name;
    protected final String[][] _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.print(Out, _Name, FirstElement, _Val, Header);
      }
  }
