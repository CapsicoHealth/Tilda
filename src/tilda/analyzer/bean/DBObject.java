package tilda.analyzer.bean;

import tilda.db.Connection;

public interface DBObject
  {
    public void setCompleted();
    public boolean getCompleted();
    public String getName();
    public String getFullyQualifiedName();
    public boolean performTask(Connection C);
    public String getFileName(int part);
    public boolean getStarted();
    public void setStarted();
    public String getJsonFileName();
  }
