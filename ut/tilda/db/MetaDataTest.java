package tilda.db;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaDataTest
  {
    public static void main(String[] args)
    throws Exception
      {
        Class.forName("org.postgresql.Driver");
        java.sql.Connection C = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pepper", "postgres", args[0]);
        final String schemaName = "people";
        final String tableName = "contact";
        DatabaseMetaData meta = C.getMetaData();
        ResultSet RS1 = meta.getTables(null, schemaName, tableName, null);
        while (RS1.next() != false)
          {
            System.out.println("Table PEOPLE.Contact");
            printResult(RS1, "   ");
            ResultSet RS2 = meta.getColumns(null, schemaName, tableName, null);
            System.out.println("   Columns:");
            while (RS2.next() != false)
              printResult(RS2, "      ");
          }
      }

    protected static void printResult(ResultSet RS, String header)
    throws SQLException
      {
        StringBuilder str = new StringBuilder(header);
        int count = RS.getMetaData().getColumnCount();
        for (int i = 1; i <= count; ++i)
         str.append(RS.getMetaData().getColumnName(i) + ":" + RS.getString(i) + "; ");
        System.out.println(str.toString());
      }
  }
