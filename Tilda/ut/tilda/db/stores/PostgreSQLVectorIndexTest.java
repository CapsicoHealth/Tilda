package tilda.db.stores;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import tilda.enums.ColumnType;
import tilda.db.stores.BigQuery;
import tilda.generation.Generator;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Index.Details;
import tilda.parsing.parts.Index.Option;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Schema;

public class PostgreSQLVectorIndexTest
  {
    public static void main(String[] args)
    throws Exception
      {
        assertContains(createDDL(index()), "USING ivfflat (\"embedding\" vector_l2_ops) WITH (lists=1000)");
        assertContains(createDDL(index("cosine", "ivfflat", details(option("lists", "64")))), "USING ivfflat (\"embedding\" vector_cosine_ops) WITH (lists=64)");
        assertContains(createDDL(index("dot", "hnsw", details())), "USING hnsw (\"embedding\" vector_ip_ops) WITH (m=16, ef_construction=200)");
        assertContains(createDDL(index("l1", "hnsw", details())), "vector_l1_ops");
        assertContains(createDDL(indexWithVectorType("halfvec", "cosine", "hnsw", details())), "halfvec_cosine_ops");
        assertContains(createDDL(indexWithVectorType("bit", "hamming", "ivfflat", details())), "bit_hamming_ops");
        assertContains(createDDL(indexWithVectorType("bit", "jaccard", "hnsw", details())), "bit_jaccard_ops");
        assertContains(createDDL(indexWithVectorType("sparsevec", "dot", "hnsw", details())), "sparsevec_ip_ops");
        assertContains(createDDL(index("euclidean", "hnsw", details(option("m", "24"), option("ef_construction", "300")))), "WITH (m=24, ef_construction=300)");
        Details defaulted = details();
        Index defaultedIndex = index(defaulted);
        createDDL(defaultedIndex);
        if (defaulted._Options != null && defaulted._Options.isEmpty() == false || defaultedIndex._Vector._Algorithm != null || defaultedIndex._Vector._Distance != null)
          throw new IllegalStateException("PostgreSQL generation mutated parsed vector settings while applying defaults.");
        assertFails(index("cosine", "ivfflat", details(option("lists", "zero"))), "invalid positive integer");
        assertFails(index("cosine", "hnsw", details(option("lists", "10"))), "unsupported hnsw option");
        assertFails(index("invalid", "ivfflat", details()), "unsupported PostgreSQL vector distance");
        assertFails(index("cosine", "invalid", details()), "unsupported PostgreSQL vector algorithm");
        assertFails(index("l1", "ivfflat", details()), "Supported distances: euclidean, dot, cosine.");
        assertFails(indexWithVectorType("bit", "jaccard", "ivfflat", details()), "Supported distances: hamming.");
        assertFails(indexWithVectorType("sparsevec", "euclidean", "ivfflat", details()), "Supported distances: hnsw: euclidean, dot, cosine, l1.");

        Details unknownDatabase = details();
        unknownDatabase._Db = "not-a-database";
        assertFails(index("cosine", unknownDatabase), "unrecognized database in details");
        Details wildcard = details();
        wildcard._Db = "*";
        assertFails(index(wildcard, details()), "cannot mix a '*' detail");

        Index legacy = index("cosine", "ivfflat", details());
        legacy._IndexColumnModifiers.put("embedding", "(type=ivfflat;operator=vector_cosine_ops;lists=100;)");
        assertFails(legacy, "retired vector column-modifier syntax");

        assertContains(createBigQueryDDL(index("dot", "ivf", bigQueryDetails(option("num_lists", "64")))),
        "CREATE VECTOR INDEX IF NOT EXISTS `Document_Embedding` ON `Document`(`embedding`) OPTIONS (index_type = 'IVF', distance_type = 'DOT_PRODUCT', ivf_options = '{\"num_lists\":64}')");
        assertNotContains(createBigQueryTableDDL(index("cosine", "ivf", bigQueryDetails()), false), "CREATE VECTOR INDEX");
        assertContains(createBigQueryTableDDL(index("cosine", "ivf", bigQueryDetails()), true), "CREATE VECTOR INDEX");
        String vectorDataCheck = BigQuery.buildVectorIndexDataCheckQuery("Document", "embedding");
        assertContains(vectorDataCheck, "`embedding` IS NOT NULL AND ARRAY_LENGTH(`embedding`) > 0");
        assertContains(vectorDataCheck, "NOT EXISTS (SELECT 1 FROM UNNEST(`embedding`) AS element WHERE element IS NULL)");
        assertContains(createBigQueryDDL(index("cosine", "tree_ah", bigQueryDetails(option("leaf_node_embedding_count", "500"), option("normalization_type", "l2")))),
        "index_type = 'TREE_AH', distance_type = 'COSINE', tree_ah_options = '{\"leaf_node_embedding_count\":500, \"normalization_type\":\"L2\"}'");
        Index sharedDistance = index("cosine", details(), bigQueryDetails());
        assertContains(createDDL(sharedDistance), "vector_cosine_ops");
        assertContains(createBigQueryDDL(sharedDistance), "distance_type = 'COSINE'");
        Index sharedIvf = index("cosine", "ivf", details(), bigQueryDetails());
        assertContains(createDDL(sharedIvf), "USING ivfflat");
        assertContains(createBigQueryDDL(sharedIvf), "index_type = 'IVF'");
        assertParserValid(sharedIvf);

        Index perDatabaseAlgorithms = index("cosine", detailsWithAlgorithm("hnsw"), bigQueryDetailsWithAlgorithm("tree_ah"));
        assertContains(createDDL(perDatabaseAlgorithms), "USING hnsw");
        assertContains(createBigQueryDDL(perDatabaseAlgorithms), "index_type = 'TREE_AH'");
        assertParserValid(perDatabaseAlgorithms);

        Details conflictingDetail = detailsWithAlgorithm("hnsw");
        Index conflictingAlgorithms = index("cosine", "ivf", conflictingDetail);
        assertFails(conflictingAlgorithms, "cannot specify both vector.algorithm");
        assertParserFails(conflictingAlgorithms, "both vector.algorithm and a vector.details[].algorithm");
        assertParserFails(index("cosine", "hnsw", details(), bigQueryDetails()), "not supported by database 'bigquery'");
        assertParserFails(index("cosine", detailsWithAlgorithm("hnsw"), bigQueryDetails()), "a vector.details entry is missing its algorithm");

        String defaultBigQueryDDL = createBigQueryDDL(index(bigQueryDetails()));
        assertContains(defaultBigQueryDDL, "distance_type = 'EUCLIDEAN'");
        assertContains(defaultBigQueryDDL, "index_type = 'IVF'");
        assertContains(defaultBigQueryDDL, "ivf_options = '{\"num_lists\":1000}'");

        Index escaped = index("euclidean", "ivf", bigQueryDetails());
        escaped._Parent._OriginalName = "Doc`ument";
        assertContains(createBigQueryDDL(escaped), "`Doc\\`ument_Embedding` ON `Doc\\`ument`");
        assertBigQueryFails(index(), "requires a vector.details entry for BigQuery");
        assertBigQueryFails(index("hamming", "ivf", bigQueryDetails()), "unsupported BigQuery vector distance");
        assertBigQueryFails(index("cosine", "hnsw", bigQueryDetails()), "unsupported BigQuery vector algorithm");
        assertBigQueryFails(index("cosine", "ivf", bigQueryDetails(option("num_lists", "5001"))), "Expected an integer from 1 through 5000");
        assertBigQueryFails(index("cosine", "ivf", bigQueryDetails(option("num_lists", "nope"))), "Expected an integer from 1 through 5000");
        assertBigQueryFails(index("cosine", "ivf", bigQueryDetails(option("lists", "10"))), "unsupported BigQuery ivf option 'lists'");
        assertBigQueryFails(index("cosine", "ivf", bigQueryDetails(option("num_lists", "10"), option("NUM_LISTS", "20"))), "duplicate BigQuery vector option");
        assertBigQueryFails(index("cosine", "tree_ah", bigQueryDetails(option("leaf_node_embedding_count", "499"))), "Expected an integer from 500 through");
        assertBigQueryFails(index("cosine", "tree_ah", bigQueryDetails(option("normalization_type", "l1"))), "unsupported BigQuery normalization_type");

        Index logicalOnly = index("euclidean", "ivf", bigQueryDetails());
        logicalOnly._Db = false;
        String logicalDDL = createBigQueryDDL(logicalOnly);
        assertContains(logicalDDL, "app-level VECTOR index only");
        assertNotContains(logicalDDL, "CREATE VECTOR INDEX");
      }

    private static String createDDL(Index index)
    throws Exception
      {
        return new PostgreSQL().alterTableAddIndexDDL(index);
      }

    private static String createBigQueryDDL(Index index)
    throws Exception
      {
        return new BigQuery().alterTableAddIndexDDL(index);
      }

    private static String createBigQueryTableDDL(Index index, boolean inlineVectorIndices)
    throws Exception
      {
        Object object = (Object) index._Parent;
        object._Description = "Document embeddings";
        object._ParentSchema = new Schema();
        object._ParentSchema._Name = "GENAI_EMBEDDINGS";
        Column column = index._ColumnObjs.get(0);
        column._Description = "Embedding values";
        column._Nullable = true;
        object._Columns.add(column);
        object._Indices.add(index);

        StringWriter sql = new StringWriter();
        PrintWriter out = new PrintWriter(sql);
        Generator.getTableDDL(new BigQuery().getSQlCodeGen(), out, object, true, false, inlineVectorIndices);
        out.flush();
        return sql.toString();
      }

    private static Index index(Details... details)
      {
        return index(null, null, details);
      }

    private static Index index(String distance, Details... details)
      {
        return index(distance, null, details);
      }

    private static Index index(String distance, String algorithm, Details... details)
      {
        return indexWithVectorType(null, distance, algorithm, details);
      }

    private static Index indexWithVectorType(String typeModifier, String distance, Details... details)
      {
        return indexWithVectorType(typeModifier, distance, null, details);
      }

    private static Index indexWithVectorType(String typeModifier, String distance, String algorithm, Details... details)
      {
        Object object = new Object();
        object._Name = "Document";
        object._OriginalName = "Document";

        Index index = new Index();
        index._Name = "Embedding";
        index._Parent = object;
        index._Unique = false;
        index._ColumnObjs.add(new VectorColumn("embedding", typeModifier));
        index._Vector = new Index.Vector();
        index._Vector._Distance = distance;
        index._Vector._Algorithm = algorithm;
        index._Vector._Details = details == null ? null : Arrays.asList(details);
        return index;
      }

    private static Details details(Option... options)
      {
        Details details = new Details();
        details._Db = "postgres";
        details._Options = options == null ? null : Arrays.asList(options);
        return details;
      }

    private static Details bigQueryDetails(Option... options)
      {
        Details details = details(options);
        details._Db = "bigquery";
        return details;
      }

    private static Details detailsWithAlgorithm(String algorithm, Option... options)
      {
        Details details = details(options);
        details._Algorithm = algorithm;
        return details;
      }

    private static Details bigQueryDetailsWithAlgorithm(String algorithm, Option... options)
      {
        Details details = bigQueryDetails(options);
        details._Algorithm = algorithm;
        return details;
      }

    private static void assertParserValid(Index index)
      {
        ParserSession session = parserSessionFor(index);
        if (index.validate(session, index._Parent) == false || session.getErrorCount() != 0)
          throw new IllegalStateException("Expected index validation to succeed, but got: " + session.getErrors());
      }

    private static void assertParserFails(Index index, String expectedMessage)
      {
        ParserSession session = parserSessionFor(index);
        index.validate(session, index._Parent);
        for (String error : session.getErrors())
          if (error.contains(expectedMessage) == true)
            return;
        throw new IllegalStateException("Expected index validation error containing '" + expectedMessage + "', but got: " + session.getErrors());
      }

    private static ParserSession parserSessionFor(Index index)
      {
        index._Columns = new String[] { "embedding" };
        ((Object) index._Parent)._Columns.add(index._ColumnObjs.get(0));
        return new ParserSession(null, DBType.Postgres.getSQlCodeGen());
      }

    private static Option option(String name, String value)
      {
        Option option = new Option();
        option._Option = name;
        option._Value = value;
        return option;
      }

    private static void assertContains(String actual, String expected)
      {
        if (actual.contains(expected) == false)
          throw new IllegalStateException("Expected DDL to contain '" + expected + "' but got: " + actual);
      }

    private static void assertNotContains(String actual, String unexpected)
      {
        if (actual.contains(unexpected) == true)
          throw new IllegalStateException("Expected DDL not to contain '" + unexpected + "' but got: " + actual);
      }

    private static void assertFails(Index index, String expectedMessage)
    throws Exception
      {
        try
          {
            createDDL(index);
            throw new IllegalStateException("Expected PostgreSQL index generation to fail with '" + expectedMessage + "'.");
          }
        catch (Exception e)
          {
            if (e.getMessage() == null || e.getMessage().contains(expectedMessage) == false)
              throw e;
          }
      }

    private static void assertBigQueryFails(Index index, String expectedMessage)
    throws Exception
      {
        try
          {
            createBigQueryDDL(index);
            throw new IllegalStateException("Expected BigQuery vector index generation to fail with '" + expectedMessage + "'.");
          }
        catch (Exception e)
          {
            if (e.getMessage() == null || e.getMessage().contains(expectedMessage) == false)
              throw e;
          }
      }

    private static class VectorColumn extends Column
      {
        VectorColumn(String name, String typeModifier)
          {
            _Name = name;
            _Type = ColumnType.VECTOR;
            _typeModifier = typeModifier;
          }

        @Override
        public boolean hasBeenValidatedSuccessfully()
          {
            return true;
          }
      }
  }
