package tilda;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MigrateTest
  {
    
    protected static final Logger LOG = LogManager.getLogger(MigrateTest.class.getName());
    
    public static void main(String[] args)
      {
        testMigrate();
        //testMigrateCancel();
      }
    
    
    public static void testMigrate()
      {
        LOG.warn("===> Testing Migrate Utility Launcher");
        Migrate.setIsTesting(true);
        Migrate.main(null);        
      }

    public static void testMigrateCancel()
      {
        LOG.warn("===> Testing Migrate Utility Launcher with Input = 'no'");
        Migrate.setIsTesting(true);
        System.setIn(new ByteArrayInputStream("no\n".getBytes()));
        Migrate.main(null);        
      }

  }
