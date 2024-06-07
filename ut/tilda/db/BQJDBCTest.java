package tilda.db;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BQJDBCTest
  {
    public static void main(String[] args)
    throws Exception
      {
        final String projectId = "capsico-datacommons";
        final String accountEmail = "datacommons-readonly@capsico-datacommons.iam.gserviceaccount.com";
        final String accountKeyFile = "C:\\Users\\LaurentHasson\\.gcp\\capsico-datacommons.e37fa0a2af3a.bq.json";
        Class.forName("com.simba.googlebigquery.jdbc.Driver");
        java.sql.Connection C = DriverManager.getConnection(
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
        +"ProjectId="+projectId+";"
        +"OAuthType=0;"
        +"OAuthServiceAcctEmail="+accountEmail+";"
        +"OAuthPvtKeyPath="+accountKeyFile+";"
        );
        final String schemaName = "CODESMASTER";
        final String tableName = "CodesLOINC";
        DatabaseMetaData meta = C.getMetaData();
        ResultSet RS1 = meta.getTables(null, schemaName, tableName, null);
        while (RS1.next() != false)
          {
            System.out.println("Table CODESMASTER.CodesLOINC");
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
