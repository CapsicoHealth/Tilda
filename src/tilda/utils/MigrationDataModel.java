package tilda.utils;

import java.util.List;

import tilda.db.Connection;
import tilda.migration.MigrationScript;

public class MigrationDataModel
  {
    int ActionCount;
    List<MigrationScript> Scripts;
    
    public MigrationDataModel(int ActionCount, List<MigrationScript> Scripts) 
      { 
        this.ActionCount = ActionCount;
        this.Scripts = Scripts;
      }
    
    // Getters
    public int getActionCount()
      {
        return this.ActionCount;
      }
    
    public List<MigrationScript> getMigrationScripts() 
      {
        return this.Scripts;
      }
  }
