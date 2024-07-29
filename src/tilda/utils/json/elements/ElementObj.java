package tilda.utils.json.elements;

import java.io.Writer;

import tilda.interfaces.JSONable;
import tilda.utils.json.JSONUtil;

public class ElementObj implements ElementDef
  {
    public ElementObj(String Name, JSONable Val, String JsonExportName, boolean fullObject)
      {
        _Name = Name;
        _Val = Val;
        _JsonExportName = JsonExportName;
        _fullObject = fullObject;
      }

    protected final String   _Name;
    protected final JSONable _Val;
    protected final String   _JsonExportName;
    protected final boolean   _fullObject;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        JSONUtil.print(Out, _Name, _JsonExportName, FirstElement, _Val, Header, _fullObject);
      }
  }
