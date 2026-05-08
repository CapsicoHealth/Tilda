package tilda.performance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

public class ProcessorPerformanceTracker
  {
    protected static final Logger LOG = LogManager.getLogger(ProcessorPerformanceTracker.class.getName());

    public ProcessorPerformanceTracker()
      {
        start = System.nanoTime();
      }

    public long start;
    public long setupTimeNano     = 0;             
    public long dbSelectTimeNano  = 0;
    public long dbDeleteTimeNano  = 0;
    public long dbInsertTimeNano  = 0;
    public long dbCommitTimeNano  = 0;
    public long dbAnalyzeTimeNano = 0;
    public long procTimeNano      = 0;
    public long totalInputCount   = 0;
    public long totalOutputCount  = 0;

    public void logPerformance()
      {
        long TS2 = System.nanoTime() - start;
        LOG.info("Processed a total of " + totalInputCount + " input records in " + DurationUtil.printDuration(TS2) + " (" + DurationUtil.printPerformancePerSecond(TS2, totalInputCount) + " records/s)");
        LOG.info("Processed a total of " + totalOutputCount + " output records in " + DurationUtil.printDuration(TS2) + " (" + DurationUtil.printPerformancePerSecond(TS2, totalOutputCount) + " records/s)");
        LOG.info("   Setup Time     : " + NumberFormatUtil.printPercentWith1Dec(TS2, setupTimeNano) + "%");
        LOG.info("   DB Select Time : " + NumberFormatUtil.printPercentWith1Dec(TS2, dbSelectTimeNano) + "%");
        LOG.info("   DB Delete Time : " + NumberFormatUtil.printPercentWith1Dec(TS2, dbDeleteTimeNano) + "%");
        LOG.info("   DB Insert Time : " + NumberFormatUtil.printPercentWith1Dec(TS2, dbInsertTimeNano) + "%");
        LOG.info("   DB Commit Time : " + NumberFormatUtil.printPercentWith1Dec(TS2, dbCommitTimeNano) + "%");
        LOG.info("   DB Analyze Time: " + NumberFormatUtil.printPercentWith1Dec(TS2, dbAnalyzeTimeNano) + "%");
        LOG.info("   Processing Time: " + NumberFormatUtil.printPercentWith1Dec(TS2, procTimeNano) + "%");
        LOG.info("   Misc Time: " + NumberFormatUtil.printPercentWith1Dec(TS2, TS2 - setupTimeNano - dbAnalyzeTimeNano - procTimeNano - dbSelectTimeNano - dbDeleteTimeNano - dbInsertTimeNano - dbCommitTimeNano) + "%");

      }
  }
