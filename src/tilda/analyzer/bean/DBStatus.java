package tilda.analyzer.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class DBStatus
  {
    private static final String DB_FILE_STATUS = "DBSTATUS.txt";

    public DBStatus(String FilePath)
      {
        _FilePath = FilePath + "/" + DB_FILE_STATUS;
      }

    private String _FilePath = null;

    public void Load(Database DB)
    throws FileNotFoundException, IOException
      {
        File file = new File(_FilePath);
        if (file.exists() == false)
          return;

        FileReader DBFR = new FileReader(_FilePath);
        BufferedReader BReader = new BufferedReader(DBFR);
        String Str = null;

        // String PreviousSchema = null;
        // String PreviousTable = null;
        // String PreviousColumn = null;

        while ((Str = BReader.readLine()) != null)
          {
            String NameValuePair[] = Str.split(":");
            String ValueP = NameValuePair[1];

            if (TextUtil.isNullOrEmpty(ValueP) == true)
              continue;

            String[] ValuePair = ValueP.split(",");
            String Value = ValuePair[0];
            String Status = ValuePair[1];

            DBObject obj = DB.getDBObject(Value);

            if (obj != null && Status.equalsIgnoreCase("COMPLETED"))
              {
                obj.setCompleted();
              }
            if (obj != null && Status.equalsIgnoreCase("STARTED"))
              {
                obj.setStarted();
              }

            // if(Name.equalsIgnoreCase("SCHEMA"))
            // {
            // if(PreviousSchema != null )
            // {
            // DBObject obj = DBMap.get(Value);
            // if(obj !=null)obj.setCompleted();
            // }
            // PreviousSchema = Value;
            // }
            // else if(Name.equalsIgnoreCase("TABLE"))
            // {
            // if(PreviousTable != null )
            // {
            // DBObject obj = DBMap.get(Value);
            // if(obj !=null)obj.setCompleted();
            // }
            // PreviousTable =Value;
            // }
            // else if(Name.equalsIgnoreCase("COLUMN"))
            // {
            // if(PreviousColumn != null )
            // {
            // DBObject obj = DBMap.get(Value);
            // if(obj !=null)obj.setCompleted();
            // }
            // PreviousColumn = Value;
            // }
          }
        BReader.close();
      }

    public void Update(Database DB, String Status)
    throws Exception
      {
        PrintWriter Out = FileUtil.getBufferedPrintWriter(_FilePath, true);
        try
          {

            Out.println(Status);
          }
        finally
          {
            Out.flush();
            Out.close();
          }
      }
  }
