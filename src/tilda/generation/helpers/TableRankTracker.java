package tilda.generation.helpers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.FrameworkSourcedType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.utils.PaddingUtil;

public class TableRankTracker
  {
    protected static final Logger LOG = LogManager.getLogger(TableRankTracker.class.getName());

    public TableRankTracker(Object O, int V)
      {
        _O = O;
        _N = O.getShortName();
        _V = V;
      }

    public final Object _O;
    public final String _N;
    public final int    _V;

    public String getFullName()
      {
        return _V == 1 ? _N : _N.replace(".", "_") + "_" + _V;
      }

    public static TableRankTracker getElementFromLast(Deque<TableRankTracker> TRTD, Object O)
      {
        Set<String> TableNames = new HashSet<String>();
        return getElementFromLast(TRTD, O, TableNames, 0);
      }

    public static TableRankTracker getElementFromLast(Deque<TableRankTracker> TRTD, Object O, Set<String> TableNames, int Level)
      {
        Iterator<TableRankTracker> I = TRTD.descendingIterator();
        while (I.hasNext() == true)
          {
            TableRankTracker TI = I.next();
            if (TI._O.getFullName().equals(O.getFullName()) == true)
              return TI;
            if (TI._O._FST == FrameworkSourcedType.VIEW)
              {
                View SubV = TI._O._ParentSchema.getSourceView(TI._O);
                if (SubV._PK != null && SubV._PK._ColumnObjs.get(0)._ParentObject.getFullName().equals(O.getFullName()) == true)
                  return TI;
/*                
                Deque<TableRankTracker> SubTRTD = new ArrayDeque<TableRankTracker>();
                for (ViewColumn VC : SubV._ViewColumns)
                  {
                    if (TableNames.add(VC._SameAsObj._ParentObject.getFullName()) == true)
                      SubTRTD.add(new TableRankTracker(VC._SameAsObj._ParentObject, 1));
                  }
                if (getElementFromLast(SubTRTD, O, TableNames, Level + 1) != null)
                  return TI;
*/
              }
          }
        return null;
      }

    public static String PrintTableNames(Deque<TableRankTracker> TRTD)
      {
        StringBuilder Str = new StringBuilder();
        Iterator<TableRankTracker> I = TRTD.descendingIterator();
        while (I.hasNext() == true)
          {
            TableRankTracker TI = I.next();
            if (Str.length() > 0)
              Str.append(", ");
            Str.append(TI.getFullName());
          }
        return Str.toString();
      }

    public static int findFKDeep(Deque<TableRankTracker> TRTD, Object O, List<Column> FKSourceCols, View V, int columnCount)
    throws Exception
      {
        Set<String> TableNames = new HashSet<String>();
        return findFKDeep(TRTD, O, FKSourceCols, V, columnCount, TableNames, 0);
      }

    public static int findFKDeep(Deque<TableRankTracker> TRTD, Object O, List<Column> FKSourceCols, View V, int columnCount, Set<String> TableNames, int Level)
    throws Exception
      {
        Iterator<TableRankTracker> I = TRTD.descendingIterator();
        int i = TRTD.size();
        while (I.hasNext() == true)
          {
            TableRankTracker TI = I.next();
            --i;
            if (TI._O._FST == FrameworkSourcedType.VIEW) // go down the rabbit hole
              {
                View SubV = TI._O._ParentSchema.getSourceView(TI._O);
                Deque<TableRankTracker> SubTRTD = new ArrayDeque<TableRankTracker>();
                for (ViewColumn VC : SubV._ViewColumns)
                  {
                    if (TableNames.add(VC._SameAsObj._ParentObject.getFullName()) == true)
                      SubTRTD.add(new TableRankTracker(VC._SameAsObj._ParentObject, 1));
                  }
                if (SubTRTD.isEmpty() == false)
                  {
                    LOG.debug(PaddingUtil.getPad(Level * 3) + "Checking referenced view " + TI._O.getShortName());
                    if (findFKDeep(SubTRTD, O, FKSourceCols, V, columnCount, TableNames, Level + 1) != -1)
                      {
                        LOG.debug(PaddingUtil.getPad(Level * 3) + "Got it from a sub-table!");
                        return i;
                      }
                  }
              }
            else
              {
                LOG.debug(PaddingUtil.getPad(Level * 3) + "Checking referenced table " + TI._O.getShortName());
                if (TI._O.getFullName().equals(O.getFullName()) == true)
                  {
                    LOG.debug(PaddingUtil.getPad(Level * 3) + "Got it! Now searching for nearest column from table " + O.getShortName() + ".");
                    if (Level == 0)
                      {
                        while (columnCount >= 0)
                          {
                            ViewColumn VC = V._ViewColumns.get(columnCount);
                            if (VC._SameAsObj._ParentObject.getFullName().equals(O.getFullName()) == true)
                             return columnCount;
                            --columnCount;
                          }

                      }
                    else if (recurseStuff(V, O, columnCount, FKSourceCols) != -1)
                      return columnCount;
                  }
              }
          }
        return -1;
      }

    private static int recurseStuff(View V, Object O, int columnStart, List<Column> FKSourceCols)
      {
        while (columnStart >= 0)
          {
            ViewColumn VC = V._ViewColumns.get(columnStart);
            LOG.debug("   Checking view column " + VC.getShortName() + " (" + columnStart + ") from  sameAs " + VC._SameAsObj.getShortName());
            if (VC._SameAsObj._ParentObject._FST == FrameworkSourcedType.VIEW)
              {
                View SubV = V._ParentSchema.getSourceView(VC._SameAsObj._ParentObject);
                if (recurseStuff(SubV, O, SubV._ViewColumns.size() - 1, FKSourceCols) != -1)
                  return columnStart;
              }
            else if (CheckColIn(VC._SameAsObj, FKSourceCols) == true && VC._SameAsObj._ParentObject.getFullName().equals(O.getFullName()) == true)
              return columnStart;
            --columnStart;
          }
        return -1;
      }

    private static boolean CheckColIn(Column Col, List<Column> Columns)
      {
        for (Column C : Columns)
          if (C.getFullName().equals(Col.getFullName()) == true)
            return true;
        return false;
      }

    public static ForeignKey getClosestFKTable(Deque<TableRankTracker> TRTD, Object O, View V, int columnCount)
    throws Exception
      {
        List<ForeignKey> FKs = new ArrayList<ForeignKey>();

        LOG.debug("\nChecking FK to/from " + O.getShortName() + " based on view column " + V._ViewColumns.get(columnCount).getShortName() + " mapped to " + V._ViewColumns.get(columnCount)._SameAsObj.getShortName());
        Iterator<TableRankTracker> I = TRTD.descendingIterator();
        while (I.hasNext() == true)
          {
            TableRankTracker TI = I.next();
            if (TI._O.getFullName().equals(O.getFullName()) == true)
              continue;
            TableRankTracker.getAllForeignMatchingKeys(O, FKs, TI);
          }
        LOG.debug("Found " + FKs.size() + " FK(s)");

        ForeignKey MostRecentFK = null;
        int MostRecentFKPos = -1;
        LOG.debug("Searching for FK to/from " + O.getShortName());
        for (ForeignKey FK : FKs)
          {
            Object FKObj = O.getFullName().equals(FK._ParentObject.getFullName()) == true || O._FST == FrameworkSourcedType.VIEW
            ? FK._DestObjectObj
            : O.getFullName().equals(FK._ParentObject.getFullName()) == true
            ? FK._ParentObject
            : O;
            List<Column> FKColumns = FKObj.getFullName().equals(FK._ParentObject.getFullName()) == true ? FK._SrcColumnObjs : FK._DestObjectObj._PrimaryKey._ColumnObjs;
            LOG.debug("Examining FK " + FK._Name + ": " + FK._ParentObject.getShortName() + " -> " + FK._DestObjectObj.getShortName());
            LOG.debug("   Picked Obj: " + FKObj.getShortName());
            LOG.debug("   Picked FK columns: " + Column.PrintColumnList(FKColumns));
            int pos = TableRankTracker.findFKDeep(TRTD, FKObj, FKColumns, V, columnCount);
            LOG.debug("   Most recent reference to " + FKObj.getShortName() + " as pos :" + pos + ".");
            if (pos == -1 && MostRecentFKPos == -1)
              throw new Exception("The view " + V.getShortName() + " uses columns from table " + FK._DestObjectObj.getShortName() + " and no foreign key can be found to/from " + O.getShortName() + ".");
            LOG.debug(" --> Found FK " + FK._Name + ": " + Column.PrintColumnList(FK._SrcColumnObjs));
            if (pos > MostRecentFKPos)
              {
                MostRecentFKPos = pos;
                MostRecentFK = FK;
                LOG.debug("   This is now the new most-recent FK.");
              }
          }
        if (MostRecentFK != null)
          {
            LOG.debug(" --> PICKED FK " + MostRecentFK._Name + ": " + Column.PrintColumnList(MostRecentFK._SrcColumnObjs));
          }

        return MostRecentFK;
      }

    private static void getAllForeignMatchingKeys(Object O, List<ForeignKey> FKs, TableRankTracker TI)
      {
        Set<String> TableNames = new HashSet<String>();
        getAllForeignMatchingKeys(O, FKs, TI, TableNames, 0);
      }

    private static void getAllForeignMatchingKeys(Object O, List<ForeignKey> FKs, TableRankTracker TI, Set<String> TableNames, int Level)
      {
        if (TI._O._FST == FrameworkSourcedType.VIEW || O._FST == FrameworkSourcedType.VIEW)
          {
            boolean TI_View = TI._O._FST == FrameworkSourcedType.VIEW;
            LOG.debug(PaddingUtil.getPad(Level * 3) + "Checking referenced view (" + (TI_View ? "TI" : "O") + ") " + (TI_View ? TI._O : O).getShortName());
            View SubV = TI_View ? TI._O._ParentSchema.getSourceView(TI._O)
            : O._ParentSchema.getSourceView(O);
            for (ViewColumn VC : SubV._ViewColumns)
              {
                if (TableNames.add(VC._SameAsObj._ParentObject.getFullName()) == true)
                  getAllForeignMatchingKeys(TI_View ? O : TI._O, FKs, new TableRankTracker(VC._SameAsObj._ParentObject, 1), TableNames, Level + 1);
              }
          }
        else
          {
            LOG.debug(PaddingUtil.getPad(Level * 3) + "Checking to " + TI._O.getShortName());
            for (ForeignKey FK : O._ForeignKeys)
              if (FK._DestObjectObj.getFullName().equals(TI._O.getFullName()) == true)
                {
                  LOG.debug(PaddingUtil.getPad(Level * 3) + "  --> Found FK to " + TI._O.getShortName() + " from " + O.getShortName());
                  FKs.add(FK);
                }
            LOG.debug(PaddingUtil.getPad(Level * 3) + "Checking from " + TI._O.getShortName());
            for (ForeignKey FK : TI._O._ForeignKeys)
              if (FK._DestObjectObj.getFullName().equals(O.getFullName()) == true)
                {
                  LOG.debug(PaddingUtil.getPad(Level * 3) + "  --> Found FK " + FK._Name + " from " + TI._O.getShortName() + " to " + O.getShortName());
                  FKs.add(FK);
                }
          }
      }

  }
