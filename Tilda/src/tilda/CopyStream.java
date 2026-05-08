package tilda;

import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Struct;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class CopyStream {
	 private static final String url = "jdbc:postgresql://localhost:5433/Mydb";
	 private static final String user = "postgres";
	 private static final String password = "postgres";
	 public static void main(String[] args)	  throws Exception
		      {			
		    long ts = System.nanoTime();
		    final String projectId = "automated-shape-401201";
	        final String accountEmail = "34370395023-compute@developer.gserviceaccount.com";
	        final String accountKeyFile = "/Users/eshaansingh/Downloads/automated-shape-401201-735c5f0347a9.json";
	        Class.forName("com.simba.googlebigquery.jdbc.Driver");
	        java.sql.Connection C = DriverManager.getConnection(
	        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
	        +"ProjectId="+projectId+";"
	        +"OAuthType=0;"
	        +"OAuthServiceAcctEmail="+accountEmail+";"
	        +"OAuthPvtKeyPath="+accountKeyFile+";"
	        );
	        long ts1 = System.nanoTime();
	        final String schemaName = "testing";
	        final String tableName = "covid19_open_data";
	        DatabaseMetaData meta = C.getMetaData();
	        
	        PreparedStatement pstmt = C.prepareStatement("SELECT *  FROM `automated-shape-401201.covid_19_data_edit.covid19_open_data_copy`;");//need to remove limit from this statement
	        
	        ResultSet rs = pstmt.executeQuery();
	        System.out.println("Query Results \n");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int colcount = rsmd.getColumnCount();
			
	   
	        String colTypes[] = new String[colcount];
	        StringBuilder insertQuery = new StringBuilder();
            for (int i = 1; i <= colcount; i++) {
                insertQuery.append(rsmd.getColumnName(i));
                colTypes[i-1] = rsmd.getColumnTypeName(i);   
                if (i < colcount) {
                    insertQuery.append(", ");
                }
            }
            
            Class.forName("org.postgresql.Driver");
			Connection Conn = DriverManager.getConnection(url, user, password);
			int m = 0;
			int currentBatchSize = 10000;	
			CopyManager copyManager = new CopyManager((BaseConnection) Conn);
			String copyQuery = "COPY testing.covid19_open_data( " +insertQuery.toString() + ") FROM STDIN CSV DELIMITER ','";
			StringBuilder rowData = new StringBuilder();
			long tCopy = 0;
			while (rs.next()) {
			    for (int i = 1; i <= colcount; i++) {
			        if (rs.getObject(i) == null) 
			        {
			            rowData.append("");
			        } 
			        else 
			        {
			        if (colTypes[i - 1].equals("STRING") || colTypes[i - 1].equals("DATE")) {
			            rowData.append("'");
			        	rowData.append(rs.getString(i));
			        	rowData.append("'");
			        } else if (colTypes[i - 1].equals("INT64")) {
			            rowData.append(rs.getLong(i));
			        } else if (colTypes[i - 1].equals("FLOAT64")) {
			            rowData.append(rs.getFloat(i));
			        } else if (colTypes[i - 1].equals("ARRAY")) {
			        	Array arr = rs.getArray(i);
			            Object[] arrValues = (Object[]) arr.getArray();
			            StringBuilder sb = new StringBuilder();
			            sb.append("{");
			            for (int j = 0; j < arrValues.length; j++) {
			                sb.append(arrValues[j]);
			                if (j != arrValues.length - 1) {
			                    sb.append(",");
			                }
			            }
			            sb.append("}");
			            rowData.append(sb.toString());
			        } else if (colTypes[i - 1].equals("BIGNUMERIC") || colTypes[i - 1].equals("NUMERIC")) {
			        	rowData.append(rs.getBigDecimal(i));
			        }  else if (colTypes[i - 1].equals("JSON")) {
			        	String json = rs.getString(i);
			            rowData.append("'");
			            rowData.append(json);
			            rowData.append("'");
			        }  else if (colTypes[i - 1].equals("STRUCT")) {
			        	Struct struct = (Struct) rs.getObject(i);
			            rowData.append("'");
			            rowData.append(struct.toString());
			            rowData.append("'");
			        }
			        else
			        {
			        	throw new Exception("Invalid Type" + colTypes[i-1]);
			        }  
			    }
			        if (i != colcount) {
			            rowData.append(",");
			        }
			}
			    rowData.append("\n");
			    m++;
			    if (m % currentBatchSize == 0 || rs.isLast()) {
			    	 	String data = rowData.toString();
			    		long t0 = System.nanoTime();
			    		copyManager.copyIn(copyQuery, new BufferedReader(new StringReader(data)));
			    		
			    		tCopy += System.nanoTime() - t0;
			    		rowData.setLength(0);  
			    }
			    if (m % 1000000 == 0) {
			    	long elapsedTime = (System.nanoTime() - ts1) / 1000000000;
		            double elapsedTimeInMinutes = (double) elapsedTime / 60.0;
		            System.out.println("Loaded " + m + " records in " + elapsedTimeInMinutes + " minutes");
		            System.out.println("Time spent in copy command = " + (tCopy/1000000000)/60.0 + " minutes");
			    }  
			}
			String data = rowData.toString();
			copyManager.copyIn(copyQuery, new BufferedReader(new StringReader(data)));
			long elapsedTime = (System.nanoTime() - ts1) / 1000000000;
            double elapsedTimeInMinutes = (double) elapsedTime / 60.0;
            System.out.println("------------------------------------------");
            System.out.println("Finished loading " + m + " records in " + elapsedTimeInMinutes + " minutes");
			rs.close();
			Conn.close();
			C.close();
}
}