package tilda.utils;

import java.util.List;

import tilda.db.Connection;
import tilda.migration.MigrationScript;

public class MigrationDataModel
  {

    Connection Connection;
    int ActionCount;
    List<MigrationScript> Scripts;
    
    public MigrationDataModel(Connection C, int ActionCount, List<MigrationScript> Scripts) 
      { 
        this.Connection = C;
        this.ActionCount = ActionCount;
        this.Scripts = Scripts;
      }
    
    public int getActionCount() {
      return this.ActionCount;
    }
    
    public List<MigrationScript> getMigrationScripts() {
      return this.Scripts;
    }

    public Connection getConnection() {
      return this.Connection;
    }
  }
