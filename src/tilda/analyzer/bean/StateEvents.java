package tilda.analyzer.bean;

import java.util.ArrayList;
import java.util.List;

public class StateEvents
  {
      public final String _Type;
      
      public StateEvents(String Type)
      {
        _Type = Type;
      }
      
      private static List<String> values = new ArrayList<String>();
      
      public boolean hasNext(){
        return values.size() >0;
      }
      public String values()
      {
        return values.get(0);
      }
      public boolean add(String S)
      {
        return values.add(S);
      }
      public boolean remove(String S)
      {
        return values.remove(S);
      }
  }
