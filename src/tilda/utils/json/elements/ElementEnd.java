package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementEnd implements ElementDef
  {
    public ElementEnd(String Name)
      {
        _Name = Name;
      }

    protected final String _Name;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
//        Out.write(Header);
        JSONUtil.startend(Out, '}');
        JSONUtil.newline(Out);
      }

    @Override
    public NestingStatus getNestingStatus()
      {
        return NestingStatus.END;
      }
  }
