package tilda.utils.json.elements;

import java.io.Writer;

import tilda.utils.CollectionUtil;
import tilda.utils.json.JSONUtil;

public class ElementFloatArray implements ElementDef
  {
    public ElementFloatArray(String Name, float[] Val)
      {
        _Name = Name;
        _Val = Val;
      }
    public ElementFloatArray(String Name, Float[] Val)
      {
        _Name = Name;
        _Val = CollectionUtil.toPrimitiveArray(Val);
      }

    protected final String _Name;
    protected final float[] _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.print(Out, _Name, FirstElement, _Val);
      }
  }
