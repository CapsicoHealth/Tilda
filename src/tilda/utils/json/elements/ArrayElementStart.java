package tilda.utils.json.elements;

import java.io.Writer;

public class ArrayElementStart implements ElementDef
  {
    public ArrayElementStart(String Name)
      {
        _Name = Name;
      }

    protected final String _Name;

    @Override
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception
      {
        Out.write(Header);
        Out.write(FirstElement == false ? ", {" : "  {");
      }
  }
