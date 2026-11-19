package tilda.parsing.parts.helpers;

import tilda.db.stores.DBType;
import tilda.parsing.ParserSession;

public class ValidationHelperTest
  {
    public static void main(String[] args)
      {
        for (String name : new String[] { "a", "x", "y", "ab", "A0", "_a", "__", "documentTitle", "column_123" })
          if (ValidationHelper.isValidIdentifier(name) == false)
            throw new IllegalStateException("Expected a valid identifier: " + name);

        for (String name : new String[] { null, "", "_", "1a", "$name", "name$", "name-value", "caf\u00e9" })
          if (ValidationHelper.isValidIdentifier(name) == true)
            throw new IllegalStateException("Expected an invalid identifier: " + name);

        ParserSession session = new ParserSession(null, DBType.Postgres.getSQlCodeGen());
        if (ValidationHelper.validateColumnName(session, "Object", "good_name", "Test.good_name", null) == false)
          throw new IllegalStateException("Expected a valid column name: " + session.getErrors());
        if (ValidationHelper.validateColumnName(session, "Object", "bad$name", "Test.bad$name", null) == true)
          throw new IllegalStateException("Expected a dollar sign in a column name to be rejected.");
      }
  }