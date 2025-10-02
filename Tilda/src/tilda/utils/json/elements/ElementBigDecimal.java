package tilda.utils.json.elements;

import java.io.Writer;
import java.math.BigDecimal;

import tilda.utils.json.JSONUtil;

public class ElementBigDecimal implements ElementDef
  {
    public ElementBigDecimal(String name, BigDecimal val)
      {
        this(name, val, -1);
      }

    public ElementBigDecimal(String name, BigDecimal val, int decimals)
      {
        _name = name;
        _val = val;
        _decimals = decimals;
      }

    protected final String     _name;
    protected final BigDecimal _val;
    protected final int        _decimals;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        // Out.write(Header);
        JSONUtil.print(Out, _name, FirstElement, _val, _decimals);
      }
  }
