package tilda;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class MigrateTest
  {
    @Test
    public void migrateUtilityShouldPrintLogMessageOnCancel()
      {
        System.setIn(new ByteArrayInputStream("no\n".getBytes()));
        Migrate.main(null);
      }

  }
