package tilda.parsing.parts;

import tilda.db.stores.DBType;
import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;

public class ViewIndexSearchTest
  {
    public static void main(String[] args)
      {
        assertFullTextResolution();
        assertMissingIdentityRejected();
        assertWrongIndexKindRejected();
        assertVectorResolution();
        assertMarkerPlacementRejected();
      }

    private static void assertFullTextResolution()
      {
        Fixture fixture = new Fixture(false);
        ParserSession session = fixture.session();
        if (fixture.query.validate(session, fixture.view, "View", true) == false)
          throw new IllegalStateException("A marker-only fulltext query should pass structural validation: " + session.getErrors());
        fixture.view.validateIndexSearchQueries(session);
        if (session.getErrorCount() != 0)
          throw new IllegalStateException("A valid direct-table fulltext search was rejected: " + session.getErrors());
        if (fixture.query._ResolvedSearchIndex != fixture.fullTextIndex
        || fixture.query._SearchSourceObject != fixture.table
        || fixture.query._SearchIdentityViewColumn != fixture.identityViewColumn
        || fixture.query._SearchArtifactColumnName == null)
          throw new IllegalStateException("Fulltext search metadata was not resolved onto the view query.");
      }

    private static void assertMissingIdentityRejected()
      {
        Fixture fixture = new Fixture(false);
        fixture.view._ViewColumns.clear();
        ParserSession session = fixture.session();
        fixture.view.validateIndexSearchQueries(session);
        if (session.getErrors().stream().noneMatch(error -> error.contains("must select a complete primary or unique key")))
          throw new IllegalStateException("A view without a projected source identity was not rejected: " + session.getErrors());
      }

    private static void assertWrongIndexKindRejected()
      {
        Fixture fixture = new Fixture(false);
        fixture.query._VectorIndex = "Document.DocumentSearch";
        fixture.query._FullTextIndex = null;
        ParserSession session = fixture.session();
        fixture.view.validateIndexSearchQueries(session);
        if (session.getErrors().stream().noneMatch(error -> error.contains("which is not a vector index")))
          throw new IllegalStateException("A vector marker referencing a fulltext index was not rejected: " + session.getErrors());
      }

    private static void assertVectorResolution()
      {
        Fixture fixture = new Fixture(true);
        ParserSession session = fixture.session();
        if (fixture.query.validate(session, fixture.view, "View", true) == false)
          throw new IllegalStateException("A marker-only vector query should pass structural validation: " + session.getErrors());
        fixture.view.validateIndexSearchQueries(session);
        if (session.getErrorCount() != 0 || fixture.query._ResolvedSearchIndex != fixture.vectorIndex)
          throw new IllegalStateException("A valid direct-table vector search was rejected: " + session.getErrors());
      }

    private static void assertMarkerPlacementRejected()
      {
        Fixture fixture = new Fixture(false);
        ParserSession session = fixture.session();
        if (fixture.query.validate(session, fixture.table, "Object", true) == true
        || session.getErrors().stream().noneMatch(error -> error.contains("only as a top-level named view query")))
          throw new IllegalStateException("An object-level search marker was not rejected: " + session.getErrors());

        fixture = new Fixture(false);
        session = fixture.session();
        if (fixture.query.validate(session, fixture.view, "View", false) == true
        || session.getErrors().stream().noneMatch(error -> error.contains("only as a top-level named view query")))
          throw new IllegalStateException("A view subquery search marker was not rejected: " + session.getErrors());
      }

    private static class Fixture
      {
        final Schema schema = new Schema();
        final Object table = new Object();
        final View view = new View();
        final ViewColumn identityViewColumn = new ViewColumn();
        final Index fullTextIndex = new Index();
        final Index vectorIndex = new Index();
        final SubWhereClause query = new SubWhereClause();

        Fixture(boolean vector)
          {
            schema._Package = "tilda.searchtest";
            schema._Name = "SEARCH";
            table._Name = "Document";
            table._OriginalName = "Document";
            table._Prefix = "";
            table._Description = "Documents";
            table._ParentSchema = schema;
            schema._Objects.add(table);

            Column identityColumn = new Column("id", ColumnType.INTEGER, "Identifier");
            identityColumn._ParentObject = table;
            identityColumn._Nullable = false;
            table._Columns.add(identityColumn);

            Index unique = new Index();
            unique._Name = "DocumentKey";
            unique._Unique = true;
            unique._Db = true;
            unique._ColumnObjs.add(identityColumn);
            table._Indices.add(unique);

            fullTextIndex._Name = "DocumentSearch";
            fullTextIndex._Parent = table;
            fullTextIndex._Db = true;
            fullTextIndex._FullText = new Index.FullText();
            Index.FullTextDetails detail = new Index.FullTextDetails();
            detail._Db = "postgres";
            detail._TsvectorColumn = "search_tsv";
            detail._Configuration = "english";
            fullTextIndex._FullText._Details = java.util.Arrays.asList(detail);
            table._Indices.add(fullTextIndex);

            Column embedding = new Column("embedding", ColumnType.VECTOR, "Embedding");
            embedding._ParentObject = table;
            embedding._Nullable = true;
            vectorIndex._Name = "DocumentEmbedding";
            vectorIndex._Parent = table;
            vectorIndex._Db = true;
            vectorIndex._Vector = new Index.Vector();
            vectorIndex._Vector._Distance = "cosine";
            vectorIndex._ColumnObjs.add(embedding);
            table._Indices.add(vectorIndex);

            view._Name = "DocumentView";
            view._ParentSchema = schema;
            view._Description = "Document view";
            identityViewColumn._Name = "id";
            identityViewColumn._SameAs = "Document.id";
            identityViewColumn._SameAsObj = identityColumn;
            identityViewColumn._ParentView = view;
            view._ViewColumns.add(identityViewColumn);

            query._Name = vector ? "NearestDocuments" : "DocumentSearch";
            query._Description = "Search documents";
            query._FullTextIndex = vector ? null : "Document.DocumentSearch";
            query._VectorIndex = vector ? "Document.DocumentEmbedding" : null;
            view._Queries.add(query);
          }

        ParserSession session()
          {
            ParserSession session = new ParserSession(schema, DBType.Postgres.getSQlCodeGen());
            session.addDependencySchema(schema);
            return session;
          }
      }
  }
