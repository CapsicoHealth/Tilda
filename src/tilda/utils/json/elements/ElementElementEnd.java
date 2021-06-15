package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.json.JSONUtil;

public class ElementElementEnd implements ElementDef
  {
    public ElementElementEnd()
      {
      }

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.startend(Out, '}');
        JSONUtil.newline(Out);
      }
  }
