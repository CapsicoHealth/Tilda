package tilda.db.metadata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

/**
 * Tracks where time is spent when loading database metadata. The counters are static and cumulative, so callers
 * that load metadata from several databases in sequence (e.g., a Postgres pool then a BigQuery pool) must call
 * {@link #reset()} before each load and {@link #print(String, long)} after, so each database is reported on its own.
 * <P>
 * Each bucket is meant to be <B>exclusive</B>, i.e., the sum of all buckets must not exceed the wall-clock time. In particular,
 * the 'Tables' bucket excludes the per-table foreign key lookups (which have their own buckets), and the report
 * shows the wall-clock time and the unaccounted remainder so any untracked work stands out.
 */
public final class MetaPerformance
  {
    static final Logger LOG                   = LogManager.getLogger(MetaPerformance.class.getName());

    public static int   _TableColumnCount     = 0;
    public static long  _TableColumnNano      = 0;
    public static int   _ViewColumnCount      = 0;
    public static long  _ViewColumnNano       = 0;
    public static int   _FKOutCount           = 0;
    public static long  _FKOutNano            = 0;
    public static int   _FKInCount            = 0;
    public static long  _FKInNano             = 0;
    public static int   _IndexCount           = 0;
    public static long  _IndexNano            = 0;
    public static int   _PKCount              = 0;
    public static long  _PKNano               = 0;
    public static int   _SchemaCount          = 0;
    public static long  _SchemaNano           = 0;
    public static int   _TableCount           = 0;
    public static long  _TableNano            = 0;
    public static int   _ViewCount            = 0;
    public static long  _ViewNano             = 0;
    /** Time spent listing the tables/views of schemas (JDBC getTables call). */
    public static int   _TableListCount       = 0;
    public static long  _TableListNano        = 0;
    /** Time spent in the database-specific bulk schema metadata queries (table descriptions, column defaults, cluster columns, bulk vector indices...). */
    public static int   _SchemaMetadataCount  = 0;
    public static long  _SchemaMetadataNano   = 0;
    /** Time spent loading vector index metadata (per table only: the bulk version is part of the schema metadata queries). */
    public static int   _VectorIndexCount     = 0;
    public static long  _VectorIndexNano      = 0;

    public static void reset()
      {
        _TableColumnCount = 0;
        _TableColumnNano = 0;
        _ViewColumnCount = 0;
        _ViewColumnNano = 0;
        _FKOutCount = 0;
        _FKOutNano = 0;
        _FKInCount = 0;
        _FKInNano = 0;
        _IndexCount = 0;
        _IndexNano = 0;
        _PKCount = 0;
        _PKNano = 0;
        _SchemaCount = 0;
        _SchemaNano = 0;
        _TableCount = 0;
        _TableNano = 0;
        _ViewCount = 0;
        _ViewNano = 0;
        _TableListCount = 0;
        _TableListNano = 0;
        _SchemaMetadataCount = 0;
        _SchemaMetadataNano = 0;
        _VectorIndexCount = 0;
        _VectorIndexNano = 0;
      }

    public static void print()
      {
        print(null, -1);
      }

    private static String line(String label, int count, long nano, long total)
      {
        return "\n" + label + ": " + count + " in " + DurationUtil.printDurationMilliSeconds(nano) + " or " + NumberFormatUtil.printPercentWith1Dec(total, nano) + "%";
      }

    /**
     * Prints the metadata loading performance report.
     *
     * @param label an optional label identifying what was loaded (e.g., the connection pool name)
     * @param wallNano the wall-clock time spent loading, in nanoseconds, or a negative value if unknown. If known, the report
     *        includes the portion of the wall-clock time not accounted for by any bucket.
     */
    public static void print(String label, long wallNano)
      {
        long total = _SchemaNano + _TableListNano + _SchemaMetadataNano + _TableNano + _TableColumnNano + _PKNano + _FKOutNano + _FKInNano + _IndexNano + _VectorIndexNano;// +_ViewNano+_ViewColumnNano;
        StringBuilder Str = new StringBuilder();
        Str.append("\nMetadata loading performance").append(label == null ? "" : " for " + label);
        Str.append(line("Schemas", _SchemaCount, _SchemaNano, total));
        Str.append(line("TableList", _TableListCount, _TableListNano, total));
        Str.append(line("SchemaMetadataQueries", _SchemaMetadataCount, _SchemaMetadataNano, total));
        Str.append(line("Tables", _TableCount, _TableNano, total));
        Str.append(line("TableColumns", _TableColumnCount, _TableColumnNano, total));
        Str.append(line("PK", _PKCount, _PKNano, total));
        Str.append(line("FK-Out", _FKOutCount, _FKOutNano, total));
        Str.append(line("FK-In", _FKInCount, _FKInNano, total));
        Str.append(line("Indices", _IndexCount, _IndexNano, total));
        Str.append(line("VectorIndices", _VectorIndexCount, _VectorIndexNano, total));
        Str.append(line("Views", _ViewCount, _ViewNano, total));
        // Str.append(line("ViewColumns", _ViewColumnCount, _ViewColumnNano, total));
        Str.append("\n----------------------------------------------------------------------------");
        Str.append("\nTotal tracked: ").append(DurationUtil.printDurationMilliSeconds(total));
        if (wallNano >= 0)
          Str.append("\nWall clock: ").append(DurationUtil.printDurationMilliSeconds(wallNano))
          .append(" (unaccounted: ").append(DurationUtil.printDurationMilliSeconds(Math.max(0, wallNano - total))).append(")");
        Str.append("\n");
        LOG.debug(Str.toString());
      }
  }