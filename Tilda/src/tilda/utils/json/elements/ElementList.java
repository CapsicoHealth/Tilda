package tilda.utils.json.elements;

import java.io.Writer;
import java.time.ZonedDateTime;
import java.util.List;

import tilda.interfaces.JSONable;
import tilda.utils.json.JSONUtil;

public class ElementList implements ElementDef
  {
    public ElementList(String Name, List<? extends JSONable> Val, String JsonExportName)
      {
        _Name = Name;
        _Val = Val;
        _JsonExportName = JsonExportName;
        _SyncToken = null;
      }
    // public ElementList(String Name, List<? extends JSONable> Val, String JsonExportName, ZonedDateTime SyncToken)
    // {
    // _Name = Name;
    // _Val = Val;
    // _JsonExportName = JsonExportName;
    // _SyncToken = SyncToken;
    // }

    protected final String                   _Name;
    protected final List<? extends JSONable> _Val;
    protected final String                   _JsonExportName;
    protected final ZonedDateTime            _SyncToken;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        if (_SyncToken == null)
          JSONUtil.print(Out, _Name, _JsonExportName, FirstElement, _Val, Header);
      }
  }
