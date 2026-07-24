package tilda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.MailUtil;
import tilda.utils.NumberFormatUtil;


public class SmartCopy
  {
    public SmartCopy()
      {
      }

    private static class Stats
      {
        public int  _TotalFolderCount;
        public int  _TotalFileCount;
        public int  _DeletedFileCount;
        public int  _CopiedFileCount;
        public long _CopiedByteCount;
        public long _CopiedByteNano;
      }

    public static void Copy(File Src, File Dest, Stats S, File DiffDel, List<String> Excludes, boolean Recurse)
    throws Exception
      {
        // System.out.println ();
        System.out.println("     Source Folder: '" + Src.getAbsolutePath() + "'.");
        // System.out.println("Destination Folder: '"+Dest.getAbsolutePath()+"'.");
        // System.out.println("----------------------------------------------------------------------------------------------------------");
        String[] Files = Src.list();
        List<File> SubDirs = new ArrayList<File>();
        if (Files != null)
          {
            boolean First = true;
            for (String FileName : Files)
              {
                File SrcF = new File(Src.getAbsolutePath() + "\\" + FileName);
                if (isExcluded(SrcF, Excludes) == true)
                  continue;
                if (SrcF.isDirectory() == true)
                  {
                    SubDirs.add(SrcF);
                    ++S._TotalFolderCount;
                    continue;
                  }
                ++S._TotalFileCount;
                File DestF = new File(Dest.getAbsolutePath() + "\\" + SrcF.getName());
                long SrcSize = SrcF.length();
                long DestSize = DestF.length();
                long DestLastModified = DestF.lastModified();
                long SrcLastModified = SrcF.lastModified();

                if (DestF.exists() == true
                && SrcSize == DestSize
                && SrcLastModified - DestLastModified <= (DestLastModified % 1000 == 0 ? SrcLastModified % 1000 : 0) // Some NAS don't keep milliseconds, so need to check!!!
                )
                  continue;
                if (First == true)
                  {
                    System.out.println("Destination Folder: '" + Dest.getAbsolutePath() + "'.");
                    First = false;
                  }
                ZonedDateTime Cal = DateTimeUtil.newUTC(SrcF.lastModified());
                String SrcCal = DateTimeUtil.printDateTimeForSQL(Cal);

                Cal = DateTimeUtil.newUTC(DestF.lastModified());
                String DestCal = DateTimeUtil.printDateTimeForSQL(Cal);

                long T0 = System.nanoTime();
                if (FileUtil.fileCopyNIO(SrcF, DestF) == true)
                  {
                    S._CopiedByteCount += SrcF.length();
                    T0 = System.nanoTime() - T0;
                    S._CopiedByteNano += T0;
                    DestF.setLastModified(SrcF.lastModified());
                    String Perf = DurationUtil.printPerformancePerMinute(T0, SrcSize / (1024.0 * 1024.0));
                    System.out.println("        " + DestF.getAbsolutePath()
                    + "      at " + Perf + "MB/mn  (src: " + NumberFormatUtil.printWith2DecAnd000Sep(SrcSize / 1024.0) + "KB, " + SrcCal
                    + "; dest: " + NumberFormatUtil.printWith2DecAnd000Sep(DestSize / 1024.0) + "KB, " + DestCal + ";)");
                    ++S._CopiedFileCount;
                  }
                else
                  {
                    System.out.println("   ERR: " + SrcF.getAbsolutePath() + " could not be copied to " + DestF.getAbsolutePath() + ".");
                  }
                SrcF = null;
              }
          }
        // if (CopiedFiles != 0)
        // System.out.println(" Copied Files: "+CopiedFiles+".");

        if (Recurse == true)
          for (File Dir : SubDirs)
            {
              File NewDest = FileUtil.dirSafeCreate(Dest.getAbsolutePath() + "\\" + Dir.getName());
              File NewDiffDel = DiffDel == null ? null : new File(DiffDel.getAbsolutePath() + "\\" + Dir.getName());
              Copy(Dir, NewDest, S, NewDiffDel, Excludes, Recurse);
            }

        if (DiffDel != null)
          MoveDeletedFiles(Src, Dest, S, DiffDel, Excludes);
      }

    private static boolean isExcluded(File F, List<String> Excludes)
      {
        String Name = F.getName();
        // String FullName = F.getAbsolutePath();
        for (String Str : Excludes)
          {
            if (Str.startsWith("*") == true && Name.endsWith(Str.substring(1, Str.length())) == true)
              return true;
            if (Str.endsWith("*") == true && Name.startsWith(Str.substring(0, Str.length() - 1)) == true)
              return true;
            int i = Str.indexOf('*');
            if (i != -1 && Name.startsWith(Str.substring(0, i)) == true && Name.endsWith(Str.substring(i + 1, Str.length())) == true)
              return true;
            if (Name.indexOf(Str) != -1)
              return true;
          }
        return false;
      }

    private static void MoveDeletedFiles(File Src, File Dest, Stats S, File DiffDel, List<String> Excludes)
    throws Exception
      {
        String[] Files = Dest.list();
        if (Files != null)
          {
            boolean DiffDelCreated = false;
            for (String FileName : Files)
              {
                File DestF = new File(Dest.getAbsolutePath() + "\\" + FileName);
                File SrcF = new File(Src.getAbsolutePath() + "\\" + DestF.getName());
                if (SrcF.exists() == true && isExcluded(SrcF, Excludes) == false)
                  continue;
                if (DiffDelCreated == false)
                  {
                    DiffDel = FileUtil.dirSafeCreate(DiffDel.getAbsolutePath());
                    DiffDelCreated = true;
                  }
                File DiffDestF = new File(DiffDel.getAbsolutePath() + "\\" + FileName);
                if (DiffDestF.exists() == true)
                  {
                    DiffDestF = FileUtil.autoRenameAndCreate(DiffDestF.getAbsolutePath());
                  }
                ++S._DeletedFileCount;
                if (DestF.renameTo(DiffDestF) == false)
                  {
                    System.out.println("   ERR: " + DestF.getAbsolutePath() + " could not be moved to " + DiffDestF.getAbsolutePath() + ".");
                  }
              }
          }
      }

    public static void main(String[] args)
      {
        System.out.println("SmartCopy: <SourceFolder> <DestinationFolder> (-d)? (-nr)? (-x <ExcludeListFile>)? (-mail <SmtpInfo> <SmtpUser> <SmtpPswd>)?");
        System.out.println("          - if <DestinationFolder> does not exist, it will be created automatically");
        System.out.println("          - Copies all files from the source folder and all subfolders into the destination folder. Only copies newer files.");
        System.out.println("          - if -d is specified, does a diff of deleted files and puts them in a parallel dir structure \"<DestinationFolder> [DEL]\".");
        System.out.println("          - if -nr is specified, only copies the files from the main level, without recursing into sub folders.");
        System.out.println("          - if -x <ExcludeListFile> is provided, works like /EXCLUDE option in xcopy");
        System.out.println("          - if -mail <SmtpInfo> <SmtpUser> <SmtpPswd> is provided, sends out a summary email of the run, with SmtpInfo of the form smtp.mydomain.com:25:ssl to use port 25 and turn on ssl.");
        if (args.length <= 2 || args.length > 10)
          {
            System.out.println("ERROR: Invalid number of parameters. At least 2 are needed, 4 max.");
            System.exit(-1);
            return;
          }

        File Src = new File(args[0]);
        File Dest = new File(args[1]);
        File DiffDel = null;
        List<String> Excludes = new ArrayList<String>();
        String SmtpInfo = null;
        String SmtpUser = null;
        String SmtpPswd = null;
        boolean Recurse = true;

        int i = 1;
        while (++i < args.length)
          {
            System.out.println("Looking at param " + args[i] + ".");
            if (args[i].equals("-d") == true)
              DiffDel = new File(args[1] + " [DEL]");
            else if (args[i].equals("-x") == true)
              {
                ++i;
                if (i >= args.length)
                  {
                    System.out.println("Parameter '-x' found without a following file name");
                    System.exit(-1);
                    return;
                  }
                BufferedReader In = null;
                try
                  {
                    In = new BufferedReader(new FileReader(args[i]));
                    String Str;
                    while ((Str = In.readLine()) != null)
                      {
                        Str = Str.trim();
                        if (Str.length() != 0 && Str.startsWith("#") == false)
                          Excludes.add(Str);
                      }
                  }
                catch (Exception E)
                  {
                    System.err.println(E);
                    System.exit(-1);
                    return;
                  }
                finally
                  {
                    if (In != null)
                      try
                        {
                          In.close();
                        }
                      catch (Exception E)
                        {
                          System.err.println(E);
                        }
                  }
              }
            else if (args[i].equals("-mail") == true)
              {
                if (i + 3 >= args.length)
                  {
                    System.out.println("Parameter '-mail' found without following SmtpInfo, SmtpUser and SmtpPassword parameters");
                    System.exit(-1);
                    return;
                  }
                SmtpInfo = args[++i];
                SmtpUser = args[++i];
                SmtpPswd = args[++i];
              }
            else if (args[i].equals("-nr") == true)
              {
                Recurse = false;
              }
            else
              {
                System.out.println("Invalid command line parameter " + args[i] + ".");
                System.exit(-1);
                return;
              }
          }

        if (Src.exists() == false)
          {
            System.out.println("ERROR: Folder '" + Src.getAbsolutePath() + "' cannot be found.");
            System.exit(-1);
            return;
          }
        if (Src.isDirectory() == false)
          {
            System.out.println("ERROR: '" + Src.getAbsolutePath() + "' does not seem to be a folder.");
            System.exit(-1);
            return;
          }

        if (Dest.exists() == true)
          {
            if (Dest.isDirectory() == false)
              {
                System.out.println("ERROR: Folder '" + Dest.getAbsolutePath() + "' does not seem to be a folder.");
                System.exit(-1);
                return;
              }
          }
        else if (Dest.mkdirs() == false)
          {
            System.out.println("ERROR: Cannot create destination folder '" + Dest.getAbsolutePath() + "'.");
            System.exit(-1);
            return;
          }

        long T0 = System.nanoTime();
        Stats S = new Stats();
        try
          {
            Copy(Src, Dest, S, DiffDel, Excludes, Recurse);
            ++S._TotalFolderCount;
            long TotalTime = System.nanoTime() - T0;
            System.out.println("Inspected " + S._TotalFolderCount + " folders and " + S._TotalFileCount + " files in " + DurationUtil.printDuration(TotalTime) + " at "
            + DurationUtil.printPerformancePerMinute(TotalTime, S._TotalFileCount) + " files/mn");
            System.out.println("Moved " + S._DeletedFileCount + " files to DEL folders");
            System.out.println("Copied " + S._CopiedFileCount + " files and transferred " + (S._CopiedByteCount / (1024 * 1024)) + " MBs in " + DurationUtil.printDuration(S._CopiedByteNano) + " at "
            + DurationUtil.printPerformancePerMinute(S._CopiedByteNano, S._CopiedByteCount / (1024.0 * 1024)) + " MBs/mn");

            if (SmtpInfo != null)
              {
                System.out.println("Sending an email");
                String Message = "<BR>"
                + "Backup of " + Src.getAbsolutePath() + ".<BR>"
                + "Completed at " + DateTimeUtil.printDateTime(DateTimeUtil.nowLocal()) + ".<BR>"
                + "Runtime of " + DurationUtil.printDuration(TotalTime) + ".<BR>"
                + "<BR>"
                + "<TABLE border=\"0\" cellpadding=\"10px\">"
                + "<TR><TD><B>Total Folders</B></TD><TD>" + S._TotalFolderCount + "</TD></TR>"
                + "<TR><TD><B>Total Files</B></TD><TD>" + S._TotalFileCount + "</TD><TD>" + DurationUtil.printDuration(TotalTime) + "</TD><TD>" + DurationUtil.printPerformancePerMinute(TotalTime, S._TotalFileCount)
                + " files/mn</TD></TR>"
                + "<TR><TD><B>Deleted Files</B></TD><TD>" + S._DeletedFileCount + "</TD></TR>"
                + "<TR><TD><B>Copied Files</B></TD><TD>" + S._CopiedFileCount + "</TD><TD>" + DurationUtil.printDuration(S._CopiedByteNano) + "</TD><TD>"
                + DurationUtil.printPerformancePerMinute(S._CopiedByteNano, S._CopiedByteCount / (1024 * 1024.0)) + " MBs/mn</TD></TR>"
                + "</TABLE>"
                + "<BR>";
                MailUtil.send(SmtpInfo, SmtpUser, SmtpPswd, new String[] { SmtpUser }, null, null, "Completed backup of " + Src.getAbsolutePath(), Message, false, false);
              }
            System.out.println();
            System.out.println("Program finished successfully");
          }
        catch (Exception E)
          {
            E.printStackTrace(System.out);
            long TotalTime = System.nanoTime() - T0;
            if (SmtpInfo != null)
              {
                System.out.println("Sending an email");
                String Message = "<BR>"
                + "The backup utility on " + Src.getAbsolutePath() + " completed with an ERROR at " + DateTimeUtil.printDateTime(DateTimeUtil.nowLocal()) + " after " + DurationUtil.printDuration(TotalTime) + "<BR>."
                + "<BR>"
                + "<CODE>" + E.toString() + "</CODE>"
                + "<BR>";
                MailUtil.send(SmtpInfo, SmtpUser, SmtpPswd, new String[] { SmtpUser }, null, null, "### F A I L E D  -> backup of " + Src.getAbsolutePath(), Message, true, false);
              }
            System.out.println();
            System.out.println("Program finished with errors");
            System.exit(-1);
            return;
          }
      }
  }
