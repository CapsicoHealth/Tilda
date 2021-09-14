package tilda.utils.json.elements;

import java.io.Writer;

public interface ElementDef
  {
    public void print(Writer Out, boolean FirstElement, String Header)
    throws Exception;
    
    public static enum NestingStatus { START, END, NONE };

    default public NestingStatus getNestingStatus() { return NestingStatus.NONE;} 
  }
