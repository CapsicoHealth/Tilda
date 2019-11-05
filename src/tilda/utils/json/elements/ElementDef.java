package tilda.utils.json.elements;

import java.io.Writer;

public interface ElementDef
  {
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception;
  }
