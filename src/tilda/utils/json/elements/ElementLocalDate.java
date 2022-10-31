package tilda.utils.json.elements;

import java.io.Writer;
import java.time.LocalDate;

import tilda.utils.json.JSONUtil;

public class ElementLocalDate implements ElementDef
  {
    public ElementLocalDate(String Name, LocalDate Val)
      {
        _Name = Name;
        _Val = Val;
      }

    protected final String    _Name;
    protected final LocalDate _Val;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        // Out.write(Header);
        JSONUtil.print(Out, _Name, FirstElement, _Val);
      }
  }
