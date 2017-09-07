package tilda.loader;

import tilda.db.Connection;

public interface GenericLoader
  { 
      public abstract void init(Connection C) throws Exception;
      
      public abstract String process(String i) ;
      
  }
