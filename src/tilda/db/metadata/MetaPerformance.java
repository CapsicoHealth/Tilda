package tilda.db.metadata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

public final class MetaPerformance
  {
    static final Logger LOG               = LogManager.getLogger(MetaPerformance.class.getName());

    public static int   _TableColumnCount = 0;
    public static long  _TableColumnNano  = 0;
    public static int   _ViewColumnCount  = 0;
    public static long  _ViewColumnNano   = 0;
    public static int   _FKOutCount       = 0;
    public static long  _FKOutNano        = 0;
    public static int   _FKInCount        = 0;
    public static long  _FKInNano         = 0;
    public static int   _IndexCount       = 0;
    public static long  _IndexNano        = 0;
    public static int   _PKCount          = 0;
    public static long  _PKNano           = 0;
    public static int   _SchemaCount      = 0;
    public static long  _SchemaNano       = 0;
    public static int   _TableCount       = 0;
    public static long  _TableNano        = 0;
    public static int   _ViewCount        = 0;
    public static long  _ViewNano         = 0;

    public static void print()
      {
        long total = _SchemaNano+_TableNano+_TableColumnNano+_PKNano+_FKOutNano+_FKInNano+_IndexNano;//+_ViewNano+_ViewColumnNano;
        LOG.debug("\nSchemas: " + _SchemaCount + " in " + DurationUtil.printDurationMilliSeconds(_SchemaNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _SchemaNano)+"%"
        + "\nTables: " + _TableCount + " in " + DurationUtil.printDurationMilliSeconds(_TableNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _TableNano)+"%"
        + "\nTableColumns: " + _TableColumnCount + " in " + DurationUtil.printDurationMilliSeconds(_TableColumnNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _TableColumnNano)+"%"
        + "\nPK: " + _PKCount + " in " + DurationUtil.printDurationMilliSeconds(_PKNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _PKNano)+"%"
        + "\nFK-Out: " + _FKOutCount + " in " + DurationUtil.printDurationMilliSeconds(_FKOutNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _FKOutNano)+"%"
        + "\nFK-In: " + _FKInCount + " in " + DurationUtil.printDurationMilliSeconds(_FKInNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _FKInNano)+"%"
        + "\nIndices: " + _IndexCount + " in " + DurationUtil.printDurationMilliSeconds(_IndexNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _IndexNano)+"%"
        + "\nViews: " + _ViewCount + " in " + DurationUtil.printDurationMilliSeconds(_ViewNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _ViewNano)+"%"
//        + "\nViewColumns: " + _ViewColumnCount + " in " + DurationUtil.printDurationMilliSeconds(_ViewColumnNano)+" or "+NumberFormatUtil.printPercentWith1Dec(total, _ViewColumnNano)+"%"
        + "\n----------------------------------------------------------------------------"
        + "\nTotal: "+DurationUtil.printDurationMilliSeconds(total)
        + "\n"
        );
      }
  }
