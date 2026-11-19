package tilda.db.stores;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;

import tilda.enums.ColumnType;
import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.generation.java8.Helper;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.IndexTemplate;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;

public class PostgreSQLFullTextIndexTest
  {
    public static void main(String[] args)
    throws Exception
      {
        assertGeneratedDDL();
        assertGeneratedLookup();
        assertViewSearchGeneration();
        assertParserValidation();
      }

    private static void assertViewSearchGeneration()
    throws Exception
      {
        Schema schema = new Schema();
        schema._Package = "tilda.genai";
        schema._Name = "GENAI_EMBEDDINGS";
        Object view = new Object();
        view._Name = "DocumentView";
        view._OriginalName = "DocumentView";
        view._Prefix = "";
        view._ParentSchema = schema;

        Index fullTextIndex = fullTextIndex();
        SubWhereClause fullText = searchQuery("DocumentSearch", "fulltext", fullTextIndex, "__TILDA_SEARCH_FT");
        fullText._ParentObject = view;
        view._Queries.add(fullText);

        GeneratorSession generator = new GeneratorSession("java", 8, -1, "postgres", 15, -1);
        StringWriter method = new StringWriter();
        generator.getGenTildaFactory().genMethodLookupWhereQuery(new PrintWriter(method), generator, fullText, 0);
        assertContains(method.toString(), "lookupWhereDocumentSearch(Connection C, String query, int maxCount)");
        assertContains(method.toString(), "readMany(C, 0, RPI, null, query, 0, maxCount)");

        StringWriter where = new StringWriter();
        Helper.SwitchLookupIdWhereClauses(new PrintWriter(where), generator, view, "", false);
        assertContains(where.toString(), "C.getFullColumnVar(S, \"GENAI_EMBEDDINGS\", \"DocumentView\", \"__TILDA_SEARCH_FT\")");
        assertContains(where.toString(), "websearch_to_tsquery('english', ?)");
        assertContains(where.toString(), "__TILDA_SEARCH_FT");

        StringWriter bindings = new StringWriter();
        Helper.SwitchLookupIdPreparedStatement(new PrintWriter(bindings), generator, view, "", false, true, false);
        String queryBinding = "PS.setString(++i, (String) ExtraParams);";
        if (countOccurrences(bindings.toString(), queryBinding) != 2)
          throw new IllegalStateException("Expected view fulltext to bind query text twice, got: " + bindings);

        SubWhereClause copied = new SubWhereClause(fullText);
        if (copied._ResolvedSearchIndex != fullTextIndex || copied._SearchArtifactColumnName.equals(fullText._SearchArtifactColumnName) == false)
          throw new IllegalStateException("Resolved search metadata was not preserved when copying the query.");

        Index vectorIndex = new Index();
        vectorIndex._Name = "DocumentEmbedding";
        vectorIndex._Vector = new Index.Vector();
        vectorIndex._Vector._Distance = "cosine";
        Column vectorColumn = new Column("embedding", ColumnType.VECTOR, "embedding");
        vectorIndex._ColumnObjs.add(vectorColumn);
        SubWhereClause vector = searchQuery("NearestDocuments", "vector", vectorIndex, "__TILDA_SEARCH_VEC");
        vector._ParentObject = view;
        view._Queries.clear();
        view._Queries.add(vector);

        method = new StringWriter();
        generator.getGenTildaFactory().genMethodLookupWhereQuery(new PrintWriter(method), generator, vector, 1);
        assertContains(method.toString(), "lookupWhereNearestDocuments(Connection C, float[] query, int maxCount)");

        where = new StringWriter();
        Helper.SwitchLookupIdWhereClauses(new PrintWriter(where), generator, view, "", false);
        assertContains(where.toString(), " <=> cast(? as vector)");

        bindings = new StringWriter();
        Helper.SwitchLookupIdPreparedStatement(new PrintWriter(bindings), generator, view, "", false, true, false);
        assertContains(bindings.toString(), "java.util.Arrays.toString((float[]) ExtraParams)");

        View sqlView = new View();
        sqlView._Name = "DocumentView";
        sqlView._Description = "Document search view";
        sqlView._ParentSchema = schema;
        Column identityColumn = new Column("id", ColumnType.INTEGER, "identifier");
        Object source = (Object) fullTextIndex._Parent;
        identityColumn._ParentObject = source;
        source._Columns.add(identityColumn);
        ViewColumn viewId = new ViewColumn();
        viewId._Name = "id";
        viewId._SameAs = "id";
        viewId._SameAsObj = identityColumn;
        viewId._ParentView = sqlView;
        sqlView._ViewColumns.add(viewId);
        SubWhereClause sqlQuery = searchQuery("DocumentSearch", "fulltext", fullTextIndex, "__TILDA_SEARCH_FT");
        sqlQuery._SearchIdentityViewColumn = viewId;
        sqlView._Queries.add(sqlQuery);
        StringWriter ddl = new StringWriter();
        DBType.Postgres.getSQlCodeGen().genDDL(new PrintWriter(ddl), sqlView);
        String viewSql = ddl.toString();
        if (viewSql.indexOf("as \"__TILDA_SEARCH_FT\"") < viewSql.indexOf("as \"id\"") || viewSql.contains("as \"__TILDA_SEARCH_FT\"") == false)
          throw new IllegalStateException("Expected the hidden search artifact after visible columns: " + viewSql);
        assertContains(viewSql, "\"search_tsv\" as \"__TILDA_SEARCH_FT\"");
        assertContains(methodGuard(fullText, generator), "instanceof tilda.db.stores.PostgreSQL");
      }

    private static String methodGuard(SubWhereClause query, GeneratorSession generator)
      {
        StringWriter method = new StringWriter();
        generator.getGenTildaFactory().genMethodLookupWhereQuery(new PrintWriter(method), generator, query, 0);
        return method.toString();
      }

    private static SubWhereClause searchQuery(String name, String kind, Index index, String artifact)
      {
        SubWhereClause query = new SubWhereClause();
        query._Name = name;
        query._Description = name;
        query._FullTextIndex = "Document." + index._Name;
        if ("vector".equals(kind) == true)
          {
            query._FullTextIndex = null;
            query._VectorIndex = "Document." + index._Name;
          }
        query._ResolvedSearchIndex = index;
        query._SearchSourceObject = (Object) index._Parent;
        query._SearchArtifactColumnName = artifact;
        return query;
      }

    private static void assertGeneratedDDL()
    throws Exception
      {
        Index index = fullTextIndex();
        StringWriter sql = new StringWriter();
        PrintWriter out = new PrintWriter(sql);
        Generator.getTableDDL(DBType.Postgres.getSQlCodeGen(), out, (Object) index._Parent, true, false);
        out.flush();
        String ddl = sql.toString();
        assertContains(ddl, "\"search_tsv\" tsvector GENERATED ALWAYS AS (to_tsvector('english'::regconfig, coalesce(\"documentTitle\", '') || ' ' || coalesce(\"documentDescription\", ''))) STORED");
        assertContains(ddl, "CREATE INDEX IF NOT EXISTS Document_DocumentSearch ON GENAI_EMBEDDINGS.Document USING GIN (\"search_tsv\")");
        if (((Object) index._Parent)._Columns.size() != 2)
          throw new IllegalStateException("The generated tsvector artifact must not become a Tilda application column.");

        StringWriter bigQuerySql = new StringWriter();
        Generator.getTableDDL(DBType.BigQuery.getSQlCodeGen(), new PrintWriter(bigQuerySql), (Object) index._Parent, true, false);
        if (bigQuerySql.toString().contains("search_tsv") == true || bigQuerySql.toString().contains("Document_DocumentSearch") == true)
          throw new IllegalStateException("BigQuery DDL must omit PostgreSQL fulltext artifacts: " + bigQuerySql);

        index.getFullTextDetails("postgres")._Configuration = "custom'config";
        assertContains(PostgreSQL.getFullTextColumnDefinition(index), "to_tsvector('custom''config'::regconfig");
      }

    private static void assertGeneratedLookup()
    throws Exception
      {
        Index index = fullTextIndex();
        GeneratorSession generator = new GeneratorSession("java", 8, -1, "postgres", 15, -1);
        StringWriter method = new StringWriter();
        generator.getGenTildaFactory().genMethodLookupWhereIndex(new PrintWriter(method), generator, index, 0);
        assertContains(method.toString(), "lookupWhereDocumentSearch(Connection C, String query, int maxCount)");
        assertContains(method.toString(), "instanceof tilda.db.stores.PostgreSQL");
        assertContains(method.toString(), "maxCount cannot be negative");
        assertContains(method.toString(), "maxCount is too large");
        assertContains(method.toString(), "readMany(C, 0, RPI, null, query, 0, maxCount)");

        StringWriter where = new StringWriter();
        Helper.SwitchLookupIdWhereClauses(new PrintWriter(where), generator, (Object) index._Parent, "", false);
        assertContains(where.toString(), "websearch_to_tsquery('english', ?)");
        assertContains(where.toString(), "ts_rank(");
        assertContains(where.toString(), "order by ts_rank(");

        StringWriter bindings = new StringWriter();
        Helper.SwitchLookupIdPreparedStatement(new PrintWriter(bindings), generator, (Object) index._Parent, "", false, true, false);
        String queryBinding = "PS.setString(++i, (String) ExtraParams);";
        if (countOccurrences(bindings.toString(), queryBinding) != 2)
          throw new IllegalStateException("Expected the query to be bound for both matching and ranking, got: " + bindings);
      }

    private static void assertParserValidation()
    throws Exception
      {
        Index parsed = fullTextIndex();
        parsed._FullText = new Gson().fromJson("{\"details\":[{\"db\":\"postgres\",\"tsvectorColumn\":\"search_tsv\",\"configuration\":\"english\"}]}", Index.FullText.class);
        validate(parsed, true, null);

        Index flat = fullTextIndex();
        flat._FullText = new Gson().fromJson("{\"db\":\"postgres\",\"tsvectorColumn\":\"search_tsv\"}", Index.FullText.class);
        validate(flat, false, "non-empty 'fulltext.details'");

        Index duplicate = fullTextIndex();
        duplicate._FullText._Details = java.util.Arrays.asList(duplicate.getFullTextDetails("postgres"), duplicate.getFullTextDetails("postgres"));
        validate(duplicate, false, "duplicate fulltext details");

        Index wildcard = fullTextIndex();
        wildcard.getFullTextDetails("postgres")._Db = "*";
        validate(wildcard, false, "exactly 'postgres'");

        Index valid = fullTextIndex();
        valid.getFullTextDetails("postgres")._Configuration = null;
        validate(valid, true, null);
        if ("english".equals(valid.getFullTextDetails("postgres")._Configuration) == false || valid._Unique == true)
          throw new IllegalStateException("Full-text defaults were not applied as expected.");

        Index simple = fullTextIndex();
        simple.getFullTextDetails("postgres")._Configuration = "pg_catalog.simple";
        validate(simple, true, null);

        Index unsupportedBackend = fullTextIndex();
        unsupportedBackend.getFullTextDetails("postgres")._Db = "bigquery";
        validate(unsupportedBackend, false, "exactly 'postgres'");

        Index invalidConfig = fullTextIndex();
        invalidConfig.getFullTextDetails("postgres")._Configuration = "english'); DROP TABLE documents; --";
        validate(invalidConfig, false, "invalid PostgreSQL text-search configuration");

        Index invalidSource = fullTextIndex();
        invalidSource._Columns = new String[] { "id" };
        Column identityColumn = new Column("id", ColumnType.INTEGER, "identifier");
        identityColumn._TypeStr = "INTEGER";
        ((Object) invalidSource._Parent)._Columns.add(identityColumn);
        validate(invalidSource, false, "must be a scalar STRING column");

        Index vectorConflict = fullTextIndex();
        vectorConflict._Vector = new Index.Vector();
        validate(vectorConflict, false, "both 'fulltext' and 'vector'");

        Index index = fullTextIndex();
        IndexTemplate template = new IndexTemplate();
        template._Name = "TemplateSearch";
        template._Columns = new String[] { "documentTitle" };
        template._FullText = index._FullText;
        ParserSession session = new ParserSession(null, DBType.Postgres.getSQlCodeGen());
        template.validate(session, index._Parent);
        if (session.getErrors().stream().noneMatch(error -> error.contains("cannot define 'fulltext'")))
          throw new IllegalStateException("Expected fulltext index templates to be rejected explicitly, but got: " + session.getErrors());
      }

    private static Index fullTextIndex()
      {
        Object object = new Object();
        object._Name = "Document";
        object._OriginalName = "Document";
        object._Prefix = "";
        object._Description = "Document search";
        object._ParentSchema = new Schema();
        object._ParentSchema._Name = "GENAI_EMBEDDINGS";
        Column title = new Column("documentTitle", ColumnType.STRING, "title");
        title._TypeStr = "STRING";
        title._Size = 1024;
        title._Nullable = true;
        object._Columns.add(title);
        Column description = new Column("documentDescription", ColumnType.STRING, "description");
        description._TypeStr = "STRING";
        description._Size = 1024;
        description._Nullable = true;
        object._Columns.add(description);

        Index index = new Index();
        index._Name = "DocumentSearch";
        index._Columns = new String[] { "documentTitle", "documentDescription" };
        index._Parent = object;
        index._FullText = new Index.FullText();
        Index.FullTextDetails detail = new Index.FullTextDetails();
        detail._Db = "postgres";
        detail._TsvectorColumn = "search_tsv";
        detail._Configuration = "english";
        index._FullText._Details = java.util.Arrays.asList(detail);
        object._Indices.add(index);
        return index;
      }

    private static void validate(Index index, boolean expectedValid, String expectedError)
    throws Exception
      {
        ParserSession session = new ParserSession(null, DBType.Postgres.getSQlCodeGen());
        Object parent = (Object) index._Parent;
        parent._ParentSchema._Conventions.validate(session, parent._ParentSchema);
        for (Column column : parent._Columns)
          column.validate(session, parent);
        boolean valid = index.validate(session, index._Parent);
        if (valid != expectedValid)
          throw new IllegalStateException("Expected full-text validation result " + expectedValid + " but got " + valid + ": " + session.getErrors());
        if (expectedError != null)
          for (String error : session.getErrors())
            if (error.contains(expectedError) == true)
              return;
        if (expectedError != null)
          throw new IllegalStateException("Expected validation error containing '" + expectedError + "' but got " + session.getErrors());
      }

    private static void assertContains(String actual, String expected)
      {
        if (actual.contains(expected) == false)
          throw new IllegalStateException("Expected output to contain '" + expected + "' but got: " + actual);
      }

    private static int countOccurrences(String value, String target)
      {
        int count = 0;
        int index = 0;
        while ((index = value.indexOf(target, index)) != -1)
          {
            ++count;
            index += target.length();
          }
        return count;
      }
  }