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

package tilda.migration.actions;

import java.util.List;
import java.util.Map;
import java.time.ZonedDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.MaintenanceLog_Data;
import tilda.data.MaintenanceLog_Factory;
import tilda.db.Connection;
import tilda.db.JDBCHelper;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.stores.DBType;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.DBCompatibility;
import tilda.parsing.parts.Schema;
import tilda.utils.DateTimeUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class TildaExtraDDL extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaExtraDDL.class.getName());

    private final String _DatabaseId;
    private final Map<String, MaintenanceLog_Factory.ScriptHistory> _LatestHistory;
    private boolean _HashBackfill = false;
    private String _BackfillHash;

    public TildaExtraDDL(Schema S, String resourceName, Map<String, MaintenanceLog_Factory.ScriptHistory> latestHistory)
      throws Exception
      {
        super(S._Name, getResourcePath(S, resourceName), false, MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript);
        _DatabaseId = getDatabaseId(resourceName);
        _LatestHistory = latestHistory;
      }

    public static String getResourcePath(Schema S, String resourceName)
    throws Exception
      {
        return FileUtil.getBasePathFromFileOrResource(S._ResourceName) + resourceName;
      }

    enum HistoryStatus
      {
        MISSING, CURRENT, STALE, LEGACY_MATCH
      }

    static HistoryStatus checkHistory(MaintenanceLog_Factory.ScriptHistory history, String statement)
    throws Exception
      {
        if (history == null)
          return HistoryStatus.MISSING;
        String statementHash = MaintenanceLog_Factory.hashStatement(statement);
        if (TextUtil.isNullOrEmpty(history._StatementHash) == false)
          return statementHash.equals(history._StatementHash) == true ? HistoryStatus.CURRENT : HistoryStatus.STALE;
        return history._Statement != null && history._Statement.trim().equals(statement.trim()) == true ? HistoryStatus.LEGACY_MATCH : HistoryStatus.STALE;
      }

    private static String getDatabaseId(String resourceName)
    throws Exception
      {
        String[] parts = resourceName.split("\\.", 4);
        if (parts.length != 4 || "_tilda".equalsIgnoreCase(parts[0]) == false || parts[3].toLowerCase(java.util.Locale.ROOT).endsWith(".sql") == false)
          throw new Exception("Extra DDL resource '" + resourceName + "' must follow the format '_tilda.<schemaName>.<dbName>.<scriptName>.sql'.");
        String databaseId = DBCompatibility.resolveBackendId(parts[2]);
        if (databaseId == null)
          throw new Exception("Extra DDL resource '" + resourceName + "' specifies an unknown database; expected postgres, bigquery, or sqlserver.");
        return databaseId;
      }

    public static boolean matchesDatabase(String resourceName, DBType DB)
    throws Exception
      {
        return getDatabaseId(resourceName).equals(DBCompatibility.canonicalizeBackendId(DB.getName()));
      }

    private boolean matchesDatabase(Connection C)
      {
        return _DatabaseId.equals(DBCompatibility.canonicalizeBackendId(C.getDBType().getName()));
      }
    
    public boolean process(Connection C)
    throws Exception
      {
        if (matchesDatabase(C) == false)
          return true;
        if (_HashBackfill == true)
          return true;
        if (JDBCHelper.isRehearsal() == false)
         LOG.debug(getDescription());

        String statement = FileUtil.getFileOfResourceContents(_TableViewName);
        if (TextUtil.isNullOrEmpty(statement) == true)
          return true;

        return C.executeDDL(_SchemaName, _TableViewName, statement);
      }

    public MaintenanceLog_Data createHashBackfillLog(Connection C)
    throws Exception
      {
        if (_HashBackfill == false)
          throw new IllegalStateException("No hash backfill is pending for migration script '" + _TableViewName + "'.");
        ZonedDateTime now = DateTimeUtil.nowUTC();
        MaintenanceLog_Data M = MaintenanceLog_Factory.create(C, MaintenanceLog_Data._typeMigration, _SchemaName, _TableViewName
                                                              , now, now, MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript
                                                              , null, "Backfilled SHA-256 hash for existing migration script history.");
        M.setStatementHash(_BackfillHash);
        return M;
      }

    @Override
    public String getDescription()
      {
        if (_HashBackfill == true)
          return "Updating migration script tracking with SHA-256 hash for external DDL script '" + _TableViewName + "' on schema '" + _SchemaName + "'";
        return "Running an extra external DDL script '" + _TableViewName + "' on schema '" + _SchemaName + "'";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        if (matchesDatabase(C) == false)
          return false;
        // When run for the first time, some tables may not exist yet.
        if (DBMeta.getTableMeta(MaintenanceLog_Factory.SCHEMA_LABEL, MaintenanceLog_Factory.TABLENAME_LABEL) == null)
          return true;
        String statement = FileUtil.getFileOfResourceContents(_TableViewName);
        if (TextUtil.isNullOrEmpty(statement) == true)
          throw new Exception("Cannot find external DDL script '" + _TableViewName + "'.");
        MaintenanceLog_Factory.ScriptHistory M = _LatestHistory.get(_TableViewName);
        HistoryStatus Status = checkHistory(M, statement);
        if (Status == HistoryStatus.CURRENT)
          return false;
        if (Status == HistoryStatus.LEGACY_MATCH)
          {
            _HashBackfill = true;
            _BackfillHash = MaintenanceLog_Factory.hashStatement(statement);
          }
        return true;
      }

    public boolean isHashBackfill()
      {
        return _HashBackfill;
      }
  }
