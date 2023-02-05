/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.MaintenanceLog_Data;
import tilda.data.MaintenanceLog_Factory;
import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.QueryDetails;
import tilda.db.config.ConnDefs;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.migration.Migrator;
import tilda.parsing.parts.Schema;
import tilda.utils.AsciiArt;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class Reorg
  {
    static final Logger LOG = LogManager.getLogger(Reorg.class.getName());

    public static void main(String[] args)
      {
        LOG.info("");
        LOG.info("Tilda reorg utility");
        LOG.info("   This utility will take a variety of parameters to indicate the minimum size in MB or GB of a table for reorg, a retry count ");
        LOG.info("   before moving on, and then optionaly a schema and possibly a table name.");
        LOG.info("   If interrupted for any reason, the utility can be rerun with only the '-resume' flag and it will resume processing");
        LOG.info("   where it left off last.");
        LOG.info("   For example: reorg -retry 4 -minSize 1024MB");
        LOG.info("                reorg -retry 4 -minSize 1GB ");
        LOG.info("                reorg MYSCHEMA");
        LOG.info("                reorg MYSCHEMA MyTable");
        LOG.info("                reorg -resume");
        LOG.info("   By default, -retry is 5 and -minSize is 1GB.");
        LOG.info("");
        Params p = new Params(args);
        int processed = 0;
        List<WorkItem> failures = new ArrayList<WorkItem>();
        long TS = System.nanoTime();
        try
          {
            ConnDefs._SKIP_TILDA_LOADING = true; // Skip loading Tilda infrastructure since we are 100% JDBC-based DB meta-data only.
            Connection C = ConnectionPool.get("MAIN");
            ZoneInfo_Factory.initMappings(C);
            DatabaseMeta DBM = new DatabaseMeta();
            DBM.load(C, p._schemaName, p._taleName, new String[] { "information_schema", "pg_catalog"
            });
            List<WorkItem> workList = readFromSerializedFile();
            boolean resume = workList.isEmpty() == false; // resume from previous run
            for (SchemaMeta SM : DBM.getSchemaMetas())
              for (TableMeta TM : SM.getTableMetas())
                {
                  WorkItem WI = WorkItem.getItem(workList, TM);
                  if (WI != null)
                    WI._tries = 0;
                  else if (resume == false)
                    workList.add(new WorkItem(TM));
                  else
                    {
                      LOG.debug("Table " + TM.getFullNameFormatted() + " has already been processsed on previous run.");
                      ++processed;
                    }
                }
            // testComparatorPerformance(workList); // Performance test showing Comparator class better than lambda implementation.
            workList.sort(new WorkItem.Cmprtr1());

            LOG.debug("\n****************************************************************************************************************\n"
            + "**  There were " + processed + " table(s) found which had already been pre-processed.\n"
            + "**  There are " + workList.size() + " table(s) found which need to be processed.\n"
            + "****************************************************************************************************************");
            // Deque<WorkItem> workQueue = new ArrayDeque<WorkItem>(workList);
            processed = 0;
            if (p._verbose == true)
              QueryDetails.setWarningsCollection(true);
            while (workList.isEmpty() == false)
              {
                ZonedDateTime startZDT = DateTimeUtil.nowLocal();
                WorkItem wi = workList.remove(0); // tries to process head of the queue
                // Things like cluster or vacuum cannot run in transactions, so must set auto-commit to true.
                C.setAutoCommit(true);
                if (wi.process(C) == false) // fail!
                  {
                    if (wi._tries < p._retry) // if we have more tries, increment and add back
                      {
                        ++wi._tries;
                        workList.add(wi);
                      }
                    else
                      {
                        failures.add(wi); // ran out of tries, take out of main queue and move to failure list
                      }
                  }
                else
                  {
                    C.setAutoCommit(false); // back to false for regular stuff.
                    /*@formatter:off*/
                    String action = TextUtil.isNullOrEmpty(wi._IndexName) == false ? MaintenanceLog_Data._actionCluster : MaintenanceLog_Data._actionVacuum;
                    MaintenanceLog_Data M = MaintenanceLog_Factory.create(C, MaintenanceLog_Data._typeOptimize, wi._SchemaName, wi._TableName
                                                                           , startZDT, DateTimeUtil.nowLocal()
                                                                           , action, MaintenanceLog_Data._objectTypeTable
                                                                           , QueryDetails.getLastQuerySecure(), QueryDetails.getLastQueryWarnings()
                                                                          );
                    /*@formatter:on*/
                    if (M.write(C) == false)
                      throw new Exception("Cannot write MaintenanceLog record to DB.");
                    C.commit();
                    ++processed;
                  }
                writeToSerializedFile(workList);
              }
            if (workList.isEmpty() == true && failures.isEmpty() == false)
              writeToSerializedFile(failures);
          }
        catch (Throwable E)
          {
            LOG.error("\n"
            + "          ======================================================================================\n"
            + AsciiArt.Error("               ")
            + "\n"
            + "                                Cannot Reorg The Database/Schema/Table.\n"
            + "          ======================================================================================\n", E);
            System.exit(-1);
          }

        TS = System.nanoTime() - TS;
        LOG.info("\n"
        + "          ================================================================================================\n"
        + AsciiArt.Woohoo("                           ")
        + "\n"
        + "               There were " + processed + " table(s) that were reorged successfully (with " + failures.size() + " failures\n"
        + "               Took " + DurationUtil.printDuration(TS) + ", or " + DurationUtil.printPerformancePerMinute(TS, processed + failures.size()) + " tables/mn\n"
        + "          ================================================================================================");
      }


    protected static List<WorkItem> readFromSerializedFile()
    throws IOException
      {
        // Trying to fake out transactional file handling
        List<WorkItem> workList = new ArrayList<WorkItem>();
        File F = new File(FileUtil.getUserHome() + File.separatorChar + ".tilda-reorg.bin");
        if (F.exists() == false)
          F = new File(FileUtil.getUserHome() + File.separatorChar + ".tilda-reorg.tmp");
        if (F.exists() == false)
          return workList;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(F)))
          {
            workList = (List<WorkItem>) ois.readObject();
          }
        catch (Exception E)
          {
            LOG.debug("Some error occurred while reading from the file " + F.getCanonicalPath() + ":\n", E);
          }

        return workList;
      }

    protected static void writeToSerializedFile(List<WorkItem> worklist)
    throws IOException
      {
        File F = new File(FileUtil.getUserHome() + File.separatorChar + ".tilda-reorg.tmp");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(F)))
          {
            oos.writeObject(worklist);
            // Trying to fake out transactional file handling
            File newF = new File(FileUtil.getUserHome() + File.separatorChar + ".tilda-reorg.bin");
            newF.delete();
            F.renameTo(newF);
          }
        catch (Exception E)
          {
            LOG.debug("Some error occurred while writing to the file " + F.getCanonicalPath() + ":\n", E);
          }
      }


    /**
     * Basic performance test of old-style Comparator (class) vs new-style (lambda expression).
     * We are seeing between 50% and 100% performance degradation ocross multiple runs when using lambda...
     * 0125.111923.371#main D Reorg| Old-style Comparator class definiton: 674 items, 10 times -> 420,312.18 items/s
     * 0125.111923.381#main D Reorg| New-style Comparator class definiton: 674 items, 10 times -> 694,594.73 items/s
     * 
     * @param workList
     */
    protected static void testComparatorPerformance(List<WorkItem> workList)
      {
        final int iterations = 10;
        long ns = 0;
        Comparator<WorkItem> Cmprtr1 = new WorkItem.Cmprtr1();
        List<WorkItem> newWorkList = null;
        for (int i = 0; i < iterations; ++i)
          {
            newWorkList = new ArrayList<WorkItem>(workList);
            long TS = System.nanoTime();
            newWorkList.sort(Cmprtr1);
            ns += System.nanoTime() - TS;
          }
        LOG.debug("Old-style Comparator class definiton: " + newWorkList.size() + " items, " + iterations + " times -> " + DurationUtil.printPerformancePerSecond(ns, newWorkList.size() * iterations) + " items/s ");

        ns = 0;
        for (int i = 0; i < iterations; ++i)
          {
            newWorkList = new ArrayList<WorkItem>(workList);
            long TS = System.nanoTime();
            newWorkList.sort(WorkItem.Cmprtr2);
            ns += System.nanoTime() - TS;
          }
        LOG.debug("New-style Comparator class definiton: " + newWorkList.size() + " items, " + iterations + " times -> " + DurationUtil.printPerformancePerSecond(ns, newWorkList.size() * iterations) + " items/s ");
      }

    protected static class Params
      {
        public final int     _retry;
        public final int     _minSize;
        public final boolean _verbose;
        public final boolean _full;
        public final boolean _resume;
        public final String  _schemaName;
        public final String  _taleName;

        public Params(String[] args)
          {
            _retry = 5;
            _minSize = 1024;
            _verbose = true;
            _full = false;
            _resume = false;
            _schemaName = null;
            _taleName = null;
          }
      }

    protected static class WorkItem implements Serializable
      {
        private static final long serialVersionUID = 1L;
        public final String       _SchemaName;
        public final String       _TableName;
        public final String       _FullNameLowerCase;
        public final String       _IndexName;
        public int                _tries;

        public WorkItem(TableMeta TM)
          {
            _SchemaName = TM._SchemaName;
            _TableName = TM._TableName;
            _FullNameLowerCase = TM.getFullNameLowerCase();
            IndexMeta IM = TM.getClusterIndex();
            _IndexName = IM == null ? null : IM._Name;
            _tries = 0;
          }

        public static WorkItem getItem(List<WorkItem> workList, TableMeta TM)
          {
            for (WorkItem WI : workList)
              if (WI._FullNameLowerCase.equals(TM.getFullNameLowerCase()) == true)
                return WI;
            return null;
          }

        public boolean process(Connection con)
          {
            try
              {
                ZonedDateTime startZDT = DateTimeUtil.nowLocal();
                return con.reorgTable(_SchemaName, _TableName, _IndexName, true, false);
              }
            catch (Throwable T)
              {
                LOG.debug("Reorg operation failed:\n", T);
              }
            return false;
          }

        public static class Cmprtr1 implements Comparator<WorkItem>
          {
            @Override
            public int compare(WorkItem o1, WorkItem o2)
              {
                return o1._FullNameLowerCase.compareTo(o2._FullNameLowerCase);
              }
          }

        public static Comparator<WorkItem> Cmprtr2 = (WorkItem o1, WorkItem o2) -> o1._FullNameLowerCase.compareTo(o2._FullNameLowerCase);
      }
  }
