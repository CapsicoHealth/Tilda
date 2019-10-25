
package tilda.data._Tilda;

import java.time.*;
import java.util.*;
import java.math.*;

import org.apache.logging.log4j.*;
import com.google.gson.annotations.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;
import tilda.utils.json.*;


@SuppressWarnings({ "unused" })
public class TILDA__TRANSPERF_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__TRANSPERF_Json.class.getName());

   protected TILDA__TRANSPERF_Json() { }

   /*@formatter:off*/
   @SerializedName("startPeriod"           ) public String  Str_startPeriod           ;
   transient                                 public ZonedDateTime  _startPeriod           ;
   @SerializedName("endPeriod"             ) public String  Str_endPeriod             ;
   transient                                 public ZonedDateTime  _endPeriod             ;
   @SerializedName("commitNano"            ) public Long  _commitNano            ;
   @SerializedName("commitCount"           ) public Integer  _commitCount           ;
   @SerializedName("rollbackNano"          ) public Long  _rollbackNano          ;
   @SerializedName("rollbackCount"         ) public Integer  _rollbackCount         ;
   @SerializedName("savepointSetNano"      ) public Long  _savepointSetNano      ;
   @SerializedName("savepointSetCount"     ) public Integer  _savepointSetCount     ;
   @SerializedName("savepointCommitNano"   ) public Long  _savepointCommitNano   ;
   @SerializedName("savepointCommitCount"  ) public Integer  _savepointCommitCount  ;
   @SerializedName("savepointRollbackNano" ) public Long  _savepointRollbackNano ;
   @SerializedName("savepointRollbackCount") public Integer  _savepointRollbackCount;
   @SerializedName("statementCloseNano"    ) public Long  _statementCloseNano    ;
   @SerializedName("statementCloseCount"   ) public Integer  _statementCloseCount   ;
   @SerializedName("connectionCloseNano"   ) public Long  _connectionCloseNano   ;
   @SerializedName("connectionCloseCount"  ) public Integer  _connectionCloseCount  ;
   @SerializedName("connectionGetNano"     ) public Long  _connectionGetNano     ;
   @SerializedName("connectionGetCount"    ) public Integer  _connectionGetCount    ;
   @SerializedName("tildaSetterNano"       ) public Long  _tildaSetterNano       ;
   @SerializedName("tildaSetterCount"      ) public Integer  _tildaSetterCount      ;
   @SerializedName("tildaToStringNano"     ) public Long  _tildaToStringNano     ;
   @SerializedName("tildaToStringCount"    ) public Integer  _tildaToStringCount    ;
   @SerializedName("tildaToJsonNano"       ) public Long  _tildaToJsonNano       ;
   @SerializedName("tildaToJsonCount"      ) public Integer  _tildaToJsonCount      ;
   @SerializedName("tildaToCsvNano"        ) public Long  _tildaToCsvNano        ;
   @SerializedName("tildaToCsvCount"       ) public Integer  _tildaToCsvCount       ;
   /*@formatter:on*/

   public tilda.data.TransPerf_Data write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(Str_startPeriod           ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TransPerf.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _startPeriod            = DateTimeUtil.parsefromJSON(Str_startPeriod           );
      if (   _startPeriod            == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TransPerf.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_endPeriod             ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TransPerf.endPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _endPeriod              = DateTimeUtil.parsefromJSON(Str_endPeriod             );
      if (   _endPeriod              == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TransPerf.endPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (_commitNano             == null)
       _commitNano=0l;
      if (_commitCount            == null)
       _commitCount=0;
      if (_rollbackNano           == null)
       _rollbackNano=0l;
      if (_rollbackCount          == null)
       _rollbackCount=0;
      if (_savepointSetNano       == null)
       _savepointSetNano=0l;
      if (_savepointSetCount      == null)
       _savepointSetCount=0;
      if (_savepointCommitNano    == null)
       _savepointCommitNano=0l;
      if (_savepointCommitCount   == null)
       _savepointCommitCount=0;
      if (_savepointRollbackNano  == null)
       _savepointRollbackNano=0l;
      if (_savepointRollbackCount == null)
       _savepointRollbackCount=0;
      if (_statementCloseNano     == null)
       _statementCloseNano=0l;
      if (_statementCloseCount    == null)
       _statementCloseCount=0;
      if (_connectionCloseNano    == null)
       _connectionCloseNano=0l;
      if (_connectionCloseCount   == null)
       _connectionCloseCount=0;
      if (_connectionGetNano      == null)
       _connectionGetNano=0l;
      if (_connectionGetCount     == null)
       _connectionGetCount=0;
      if (_tildaSetterNano        == null)
       _tildaSetterNano=0l;
      if (_tildaSetterCount       == null)
       _tildaSetterCount=0;
      if (_tildaToStringNano      == null)
       _tildaToStringNano=0l;
      if (_tildaToStringCount     == null)
       _tildaToStringCount=0;
      if (_tildaToJsonNano        == null)
       _tildaToJsonNano=0l;
      if (_tildaToJsonCount       == null)
       _tildaToJsonCount=0;
      if (_tildaToCsvNano         == null)
       _tildaToCsvNano=0l;
      if (_tildaToCsvCount        == null)
       _tildaToCsvCount=0;

      tilda.data.TransPerf_Data Obj = tilda.data.TransPerf_Factory.create(_startPeriod, _endPeriod);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.TransPerf_Factory.lookupByPrimaryKey(_startPeriod);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.TransPerf object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.TransPerf_Data Obj) throws Exception
    {
      if (_startPeriod           != null) Obj.setStartPeriod           (_startPeriod           );
      if (_endPeriod             != null) Obj.setEndPeriod             (_endPeriod             );
      if (_commitNano            != null) Obj.setCommitNano            (_commitNano            );
      if (_commitCount           != null) Obj.setCommitCount           (_commitCount           );
      if (_rollbackNano          != null) Obj.setRollbackNano          (_rollbackNano          );
      if (_rollbackCount         != null) Obj.setRollbackCount         (_rollbackCount         );
      if (_savepointSetNano      != null) Obj.setSavepointSetNano      (_savepointSetNano      );
      if (_savepointSetCount     != null) Obj.setSavepointSetCount     (_savepointSetCount     );
      if (_savepointCommitNano   != null) Obj.setSavepointCommitNano   (_savepointCommitNano   );
      if (_savepointCommitCount  != null) Obj.setSavepointCommitCount  (_savepointCommitCount  );
      if (_savepointRollbackNano != null) Obj.setSavepointRollbackNano (_savepointRollbackNano );
      if (_savepointRollbackCount!= null) Obj.setSavepointRollbackCount(_savepointRollbackCount);
      if (_statementCloseNano    != null) Obj.setStatementCloseNano    (_statementCloseNano    );
      if (_statementCloseCount   != null) Obj.setStatementCloseCount   (_statementCloseCount   );
      if (_connectionCloseNano   != null) Obj.setConnectionCloseNano   (_connectionCloseNano   );
      if (_connectionCloseCount  != null) Obj.setConnectionCloseCount  (_connectionCloseCount  );
      if (_connectionGetNano     != null) Obj.setConnectionGetNano     (_connectionGetNano     );
      if (_connectionGetCount    != null) Obj.setConnectionGetCount    (_connectionGetCount    );
      if (_tildaSetterNano       != null) Obj.setTildaSetterNano       (_tildaSetterNano       );
      if (_tildaSetterCount      != null) Obj.setTildaSetterCount      (_tildaSetterCount      );
      if (_tildaToStringNano     != null) Obj.setTildaToStringNano     (_tildaToStringNano     );
      if (_tildaToStringCount    != null) Obj.setTildaToStringCount    (_tildaToStringCount    );
      if (_tildaToJsonNano       != null) Obj.setTildaToJsonNano       (_tildaToJsonNano       );
      if (_tildaToJsonCount      != null) Obj.setTildaToJsonCount      (_tildaToJsonCount      );
      if (_tildaToCsvNano        != null) Obj.setTildaToCsvNano        (_tildaToCsvNano        );
      if (_tildaToCsvCount       != null) Obj.setTildaToCsvCount       (_tildaToCsvCount       );
    }

   public String toString()
    {
      return
             "startPeriod"           + (_startPeriod            == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_startPeriod))
         + "; endPeriod"             + (_endPeriod              == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_endPeriod))
         + "; commitNano"            + (_commitNano             == null ? ": NULL" : ": " + _commitNano            )
         + "; commitCount"           + (_commitCount            == null ? ": NULL" : ": " + _commitCount           )
         + "; rollbackNano"          + (_rollbackNano           == null ? ": NULL" : ": " + _rollbackNano          )
         + "; rollbackCount"         + (_rollbackCount          == null ? ": NULL" : ": " + _rollbackCount         )
         + "; savepointSetNano"      + (_savepointSetNano       == null ? ": NULL" : ": " + _savepointSetNano      )
         + "; savepointSetCount"     + (_savepointSetCount      == null ? ": NULL" : ": " + _savepointSetCount     )
         + "; savepointCommitNano"   + (_savepointCommitNano    == null ? ": NULL" : ": " + _savepointCommitNano   )
         + "; savepointCommitCount"  + (_savepointCommitCount   == null ? ": NULL" : ": " + _savepointCommitCount  )
         + "; savepointRollbackNano" + (_savepointRollbackNano  == null ? ": NULL" : ": " + _savepointRollbackNano )
         + "; savepointRollbackCount"+ (_savepointRollbackCount == null ? ": NULL" : ": " + _savepointRollbackCount)
         + "; statementCloseNano"    + (_statementCloseNano     == null ? ": NULL" : ": " + _statementCloseNano    )
         + "; statementCloseCount"   + (_statementCloseCount    == null ? ": NULL" : ": " + _statementCloseCount   )
         + "; connectionCloseNano"   + (_connectionCloseNano    == null ? ": NULL" : ": " + _connectionCloseNano   )
         + "; connectionCloseCount"  + (_connectionCloseCount   == null ? ": NULL" : ": " + _connectionCloseCount  )
         + "; connectionGetNano"     + (_connectionGetNano      == null ? ": NULL" : ": " + _connectionGetNano     )
         + "; connectionGetCount"    + (_connectionGetCount     == null ? ": NULL" : ": " + _connectionGetCount    )
         + "; tildaSetterNano"       + (_tildaSetterNano        == null ? ": NULL" : ": " + _tildaSetterNano       )
         + "; tildaSetterCount"      + (_tildaSetterCount       == null ? ": NULL" : ": " + _tildaSetterCount      )
         + "; tildaToStringNano"     + (_tildaToStringNano      == null ? ": NULL" : ": " + _tildaToStringNano     )
         + "; tildaToStringCount"    + (_tildaToStringCount     == null ? ": NULL" : ": " + _tildaToStringCount    )
         + "; tildaToJsonNano"       + (_tildaToJsonNano        == null ? ": NULL" : ": " + _tildaToJsonNano       )
         + "; tildaToJsonCount"      + (_tildaToJsonCount       == null ? ": NULL" : ": " + _tildaToJsonCount      )
         + "; tildaToCsvNano"        + (_tildaToCsvNano         == null ? ": NULL" : ": " + _tildaToCsvNano        )
         + "; tildaToCsvCount"       + (_tildaToCsvCount        == null ? ": NULL" : ": " + _tildaToCsvCount       )
         + ";";
    }

 }
