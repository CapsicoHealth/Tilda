package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementArrayStart implements ElementDef
  {
    public ElementArrayStart(String Name)
      {
        _Name = Name;
      }

    protected final String _Name;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.printArrayStart(Out, _Name, FirstElement, Header);
        JSONUtil.newline(Out);
      }

    @Override
    public NestingStatus getNestingStatus()
      {
        return NestingStatus.START;
      }
  }
