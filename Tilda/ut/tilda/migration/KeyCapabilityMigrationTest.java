package tilda.migration;

import java.util.ArrayList;
import java.util.List;

import tilda.db.stores.DBType;

public class KeyCapabilityMigrationTest
  {
    public static void main(String[] args)
    throws Exception
      {
        List<MigrationAction> actions = new ArrayList<MigrationAction>();
        Migrator.handleKeys(null, actions, null, null, null, "bigquery", DBType.BigQuery);
        if (actions.isEmpty() == false)
          throw new IllegalStateException("BigQuery should not plan primary-key or foreign-key migration actions.");
      }
  }