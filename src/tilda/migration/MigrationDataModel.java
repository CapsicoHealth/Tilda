package tilda.migration;

import java.util.List;

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
