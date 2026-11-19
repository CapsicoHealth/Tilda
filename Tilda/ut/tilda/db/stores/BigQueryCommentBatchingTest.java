package tilda.db.stores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BigQueryCommentBatchingTest
  {
    @Test
    public void splitsFortyColumnCommentsIntoEightOrderedBatches()
      {
        List<String> statements = new ArrayList<String>();
        for (int i = 0; i < 40; ++i)
          statements.add("ALTER TABLE T ALTER COLUMN c" + i + " SET OPTIONS (description=\"d\");");

        List<String> batches = BigQuery.batchCommentStatements(statements, 5);

        assertEquals(8, batches.size());
        for (int i = 0; i < batches.size(); ++i)
          {
            String[] batchStatements = batches.get(i).split("\\n");
            assertEquals(5, batchStatements.length);
            assertTrue(batchStatements[0].contains("c" + (i * 5) + " "));
            assertTrue(batchStatements[4].contains("c" + (i * 5 + 4) + " "));
          }
      }

    @Test
    public void tableCommentCountsTowardBatchLimit()
      {
        List<String> statements = new ArrayList<String>();
        statements.add("ALTER TABLE T SET OPTIONS (description=\"table\");");
        for (int i = 0; i < 40; ++i)
          statements.add("ALTER TABLE T ALTER COLUMN c" + i + " SET OPTIONS (description=\"d\");");

        List<String> batches = BigQuery.batchCommentStatements(statements, 5);

        assertEquals(9, batches.size());
        assertEquals(5, batches.get(0).split("\\n").length);
        assertEquals(1, batches.get(8).split("\\n").length);
        assertTrue(batches.get(0).startsWith("ALTER TABLE T SET OPTIONS"));
      }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsNonPositiveBatchSize()
      {
        BigQuery.batchCommentStatements(new ArrayList<String>(), 0);
      }
  }