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

package tilda.db;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.processors.RecordProcessor;
import tilda.db.stores.DBType;
import tilda.enums.TransactionType;
import tilda.performance.PerfTracker;
import tilda.utils.AnsiUtil;
import tilda.utils.SystemValues;


public final class Connection
  {
    static final Logger LOG = LogManager.getLogger(Connection.class.getName());

    public Connection(java.sql.Connection C)
      throws Exception, SQLException
      {
        _C = C;
        _Url = _C.getMetaData().getURL();
        // LDH-NOTE: YEAH YEAH.... This is ugly!!! Need a virtual constructor pattern here.
        _DB = _Url.startsWith("jdbc:postgresql:") ? DBType.Postgres
            : _Url.startsWith("jdbc:sqlserver:") ? DBType.SQLServer
                : _Url.startsWith("jdbc:db2:") ? DBType.DB2
                    : null;
        if (_DB == null)
          throw new Exception("Can't find the DBType based on URL " + _Url);
        _PoolId = _C.toString();
      }

    public Connection(java.sql.Connection C, String PoolId)
      throws Exception, SQLException
      {
        this(C);
        _PoolId = PoolId + " ---- (#" + _PoolId+")";
      }


    protected String              _PoolId;
    protected java.sql.Connection _C;
    protected DBType              _DB;
    protected String              _Url;

    public final String getURL()
      {
        return _Url;
      }

    /**
     * Wrapper to {@link java.sql.Connection#commit()} with extra logging and performance tracking
     * 
     * @return
     * @return an SQException (instead of throwing) if one happens.
     * @throws SQLException 
     */
    public final void commit() throws SQLException
      {
        try
          {
            LOG.info("---------- "+AnsiUtil.NEGATIVE+"C O M M I T"+AnsiUtil.NEGATIVE_OFF+" ----------------------------------- " + _PoolId + " ------------------------------");
            long T0 = System.nanoTime();
            _C.commit();
            _SavePoints.clear();
            PerfTracker.add(TransactionType.COMMIT, System.nanoTime() - T0);
          }
        catch (SQLException E)
          {
            LOG.error(AnsiUtil.NEGATIVE+">>>>>>>>>>>>>>>"+AnsiUtil.NEGATIVE_OFF+"  F A I L U R E   C O M M I T  "+AnsiUtil.NEGATIVE+"<<<<<<<<<<<<<<<"+AnsiUtil.NEGATIVE_OFF);
            LOG.catching(E);
            LOG.error(SystemValues.NEWLINEx2);
            _SavePoints.clear();
            throw E;
          }
      }

    /**
     * Wrapper to {@link java.sql.Connection#rollback()} with extra logging and performance tracking
     * 
     * @return an SQException (instead of throwing) if one happens.
     */
    public final void rollback() throws SQLException
      {
        try
          {
            LOG.info("---------- "+AnsiUtil.NEGATIVE+"R O L L B A C K"+AnsiUtil.NEGATIVE_OFF+" ------------------------------- " + _PoolId + " ------------------------------");
            long T0 = System.nanoTime();
            _C.rollback();
            _SavePoints.clear();
            PerfTracker.add(TransactionType.ROLLBACK, System.nanoTime() - T0);
          }
        catch (SQLException E)
          {
            LOG.error(AnsiUtil.NEGATIVE+">>>>>>>>>>>>>>>"+AnsiUtil.NEGATIVE_OFF+"  F A I L U R E   R O L L B A C K  "+AnsiUtil.NEGATIVE+"<<<<<<<<<<<<<<<"+AnsiUtil.NEGATIVE_OFF);
            LOG.catching(E);
            LOG.error(SystemValues.NEWLINEx2);
            _SavePoints.clear();
            throw E;
          }
      }

    /**
     * Wrapper to {@link #commit()} or {@link #rollback()} based on parameter
     * 
     * @param Commit true if commit is needed, or false if rollback
     * @return an SQException (instead of throwing) if one happens.
     * @throws SQLException 
     */
    public final void CommitRollbackConnection(boolean Commit) throws SQLException
      {
        if(Commit == true)
         commit();
        else
         rollback();
      }

    /**
     * Wrapper to {@link java.sql.Connection#close()} with extra logging and performance tracking
     * 
     * @return an SQException (instead of throwing) if one happens.
     * @throws SQLException 
     */
    public final void close() throws SQLException
      {
        try
          {
            if (_C.toString() == _PoolId)
              LOG.info("---------- C L O S I N G   C O N N E C T I O N ------- " + _PoolId + " ----------");
            else
              LOG.info("---------- R E T U R N I N G   C O N N E C T I O N ------- " + _PoolId + " ----------");
            long T0 = System.nanoTime();
            _C.close();
            _SavePoints.clear();
            PerfTracker.add(TransactionType.CONNECTION_CLOSE, System.nanoTime() - T0);
            _C = null;
          }
        catch (SQLException E)
          {
            LOG.error(AnsiUtil.NEGATIVE+">>>>>>>>>>>>>>>"+AnsiUtil.NEGATIVE_OFF+"  F A I L U R E   C L O S I N G   C O N N E C T I O N  "+AnsiUtil.NEGATIVE+"<<<<<<<<<<<<<<<"+AnsiUtil.NEGATIVE_OFF, E);
            LOG.catching(E);
            LOG.error(SystemValues.NEWLINEx2);
            _SavePoints.clear();
            _C = null;
            throw E;
          }
      }

    /**
     * Straight wrapper to {@link java.sql.Connection#createStatement()}
     * 
     * @return
     * @throws SQLException
     */
    public final Statement createStatement()
      throws SQLException
      {
        return _C.createStatement();
      }


    public String getIsolation()
      throws SQLException
      {
        switch (_C.getTransactionIsolation())
          {
            case java.sql.Connection.TRANSACTION_NONE:
              return "TRANSACTION_NONE";
            case java.sql.Connection.TRANSACTION_READ_UNCOMMITTED:
              return "TRANSACTION_READ_UNCOMMITTED";
            case java.sql.Connection.TRANSACTION_READ_COMMITTED:
              return "TRANSACTION_READ_COMMITTED";
            case java.sql.Connection.TRANSACTION_REPEATABLE_READ:
              return "TRANSACTION_REPEATABLE_READ";
            case java.sql.Connection.TRANSACTION_SERIALIZABLE:
              return "TRANSACTION_SERIALIZABLE";
            default:
              return "TRANSACTION_UNKNOWN";
          }
      }

    /**
     * Straight wrapper to {@link java.sql.Connection#prepareStatement(String)}
     * 
     * @return
     * @throws SQLException
     */
    public PreparedStatement prepareStatement(String Q)
      throws SQLException
      {
        return _C.prepareStatement(Q);
      }

    public boolean isErrNoData(String SQLState, int ErrorCode)
      throws SQLException
      {
        return _DB.isErrNoData(SQLState, ErrorCode);
      }

    public String getCurrentTimestampStr()
      throws SQLException
      {
        return _DB.getCurrentTimestampStr();
      }

    public boolean getSelectSubsettingClause(StringBuilder Str, int Start, int Size)
      throws SQLException
      {
        return _DB.getSelectSubsettingClause(Str, Start, Size);
      }


    public boolean isLockOrConnectionError(Throwable T)
      throws SQLException
      {
        if (T == null)
          return false;

        if (T instanceof SQLException == false)
          {
            T = T.getCause();
            if (T == null || T instanceof SQLException == false)
              return false;
          }

        if (T.getMessage() == null)
          return false;

        return _DB.isLockOrConnectionError((SQLException) T);
      }


    public int ExecuteSelect(String TableName, String Query, RecordProcessor RP)
      throws Exception
      {
        return JDBCHelper.ExecuteSelect(_C, TableName, Query, RP, 0, 0);
      }

    /**
     * Executes a query with a record processor, starting at Start (0 is beginning), and for Size records.
     */
    public int ExecuteSelect(String TableName, String Query, RecordProcessor RP, int Start, int Size)
      throws Exception
      {
        return JDBCHelper.ExecuteSelect(_C, TableName, Query, RP, Start, Size);
      }

    public int ExecuteUpdate(String TableName, String Query)
      throws Exception
      {
//        if (_DB.FullIdentifierOnUpdate() == true)
//          {
//            LOG.debug("TILDA("+AnsiUtil.NEGATIVE + TableName + AnsiUtil.NEGATIVE_OFF+") Original query: " + Query);
//            Query = TextUtil.SearchReplace(Query, TableName+".", "");
//          }
        return JDBCHelper.ExecuteUpdate(_C, TableName, Query);
      }

    public Array createArrayOf(String TypeName, Object[] A)
      throws SQLException
      {
        return _C.createArrayOf(TypeName, A);
      }
    
    public Array createArrayOf(String TypeName, Set<?> A)
        throws SQLException
        {
          return _C.createArrayOf(TypeName, A.toArray());
        }
    public Array createArrayOf(String TypeName, List<?> A)
        throws SQLException
        {
          return _C.createArrayOf(TypeName, A.toArray());
        }
    
    Deque<Savepoint> _SavePoints = new ArrayDeque<Savepoint>();

    public void setSavepoint()
      throws SQLException
      {
        long T0 = System.nanoTime();
        _SavePoints.add(_C.setSavepoint());
        PerfTracker.add(TransactionType.SAVEPOINT_SET, System.nanoTime() - T0);
      }

    public void releaseSavepoint(boolean commit)
      throws SQLException
      {
        if (_SavePoints.isEmpty() == true)
         return;
        
        long T0 = System.nanoTime();
        if (commit == true)
          {
            _C.releaseSavepoint(_SavePoints.pop());
            PerfTracker.add(TransactionType.SAVEPOINT_COMMIT, System.nanoTime() - T0);
          }
        else
          {
            _C.rollback(_SavePoints.pop());
            PerfTracker.add(TransactionType.SAVEPOINT_ROLLBACK, System.nanoTime() - T0);
          }
      }
  }
