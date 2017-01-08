package tilda.generation.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;

public class FuckThat
  {
    protected static final Logger LOG = LogManager.getLogger(FuckThat.class.getName());

    public FuckThat(ViewColumn VC, Column C, int SequenceOrder, boolean implicitFKImport)
      {
        _VC = VC;
        _C = C;
        _SequenceOrder = SequenceOrder;
        _implicitFKImport = implicitFKImport;
        _PK = C._PrimaryKey == true ? C._ParentObject._PrimaryKey : null;
        for (ForeignKey FK : C._ParentObject._ForeignKeys)
          {
            // LOG.debug("Looking at FK " + FK._Name);
            boolean Found = false;
            for (Column fkcol : FK._SrcColumnObjs)
              {
                // LOG.debug("Comparing " + C.getFullName() + " with " + fkcol.getFullName());
                if (C.getFullName().equals(fkcol.getFullName()) == true)
                  {
                    Found = true;
                    break;
                  }
              }
            if (Found == true)
              _FKs.add(FK);
          }
      }

    public final ViewColumn       _VC;
    public final int              _SequenceOrder;
    public final boolean          _implicitFKImport;
    public final Column           _C;
    public final PrimaryKey       _PK;
    public final List<ForeignKey> _FKs = new ArrayList<ForeignKey>();

    public static List<FuckThat> ScanView(View V)
      {
        List<FuckThat> FuckList = new ArrayList<FuckThat>();
        int i = -1;
        Set<String> TableNames = new HashSet<String>();
        for (ViewColumn VC : V._ViewColumns)
          {
            ++i;
            Column C = VC.getSameAsRoot();
            if (C == null || C._FrameworkManaged == true || C._Mode == ColumnMode.CALCULATED) // for counts and calculated fields where there is no mapping to an actual column.
              continue;
            // LOG.debug(" - " + VC.getShortName() + " as " + VC._SameAsObj.getShortName());
            if (VC.getShortName().equalsIgnoreCase("patients.score.name") == true)
              {
                LOG.debug("xxx");
              }
            FuckThat FT = new FuckThat(VC, C, i, false);
            if (FT._PK != null)
              TableNames.add(VC._SameAsObj._ParentObject.getShortName());
            else if (FT._PK == null && C == VC._SameAsObj) // not a PK and was first-level field
              {
                if (TableNames.add(VC._SameAsObj._ParentObject.getShortName()) == true && VC._SameAsObj._ParentObject._PrimaryKey != null)
                  {
                    for (Column col : VC._SameAsObj._ParentObject._PrimaryKey._ColumnObjs)
                      {
                        FuckThat FT2 = new FuckThat(VC, col, i, true);
                        FuckList.add(FT2);
                      }
                  }
              }
            if (FT.isBoring() == false)
              FuckList.add(FT);
          }

        LOG.debug("\n\nDETAILS for view " + V.getShortName());
        for (FuckThat FT : FuckList)
          {
            boolean Printed = false;
            if (FT._PK != null)
              {
                LOG.debug(FT._VC._SameAsObj.getShortName() + "(" + FT._SequenceOrder + ") as " + FT._VC._Name + "      --> " + FT._C.getShortName() + " is " + (FT._implicitFKImport == true ? "an implicitly imported" : "a") + " primary key");
                Printed = true;
              }
            for (ForeignKey FK : FT._FKs)
              {
                LOG.debug(FT._VC._SameAsObj.getShortName() + "(" + FT._SequenceOrder + ") as " + FT._VC._Name + "      --> " + FT._C.getShortName() + " is part of " + (FT._implicitFKImport == true ? "an implicitly imported" : "a") + " FK " + FK._Name + " to " + FK._DestObjectObj.getShortName());
                Printed = true;
              }
          }
        LOG.debug("---------------------------------------------------\n");

        return FuckList;
      }


    public static ForeignKey getClosestFKTable(List<FuckThat> FuckList, View V, Object T, int columnSequenceOrder)
      {
        LOG.debug("Searching for FK to/from " + T.getShortName() + " from view column #" + columnSequenceOrder);
        if (T.getShortName().equals("PATIENTS.PATIENTVIEW") == true)
          {
            LOG.debug("xxx");
          }
        int i = FuckList.size() - 1;
        while (FuckList.get(i)._SequenceOrder >= columnSequenceOrder && i >= 0)
          --i;
        while (i >= 0)
          {
            FuckThat FT = FuckList.get(i--);
            if (FT.isBoring() == true)
              continue;
            LOG.debug("   Examining info from " + FT._VC.getShortName() + " as " + FT._C.getShortName() + " (" + FT._SequenceOrder + ")");
            if (FT._VC.getShortName().equalsIgnoreCase("DATAMART.HISANSWERPIVOTVIEW.assessmentRefnum") == true)
              {
                LOG.debug("xxx");
              }

            List<ForeignKey> PotentialFKs = new ArrayList<ForeignKey>();
            for (ForeignKey FK : FT._C._ParentObject._ForeignKeys)
              {
                LOG.debug("      Looking at FK " + FK._Name + " from " + FK._ParentObject.getFullName() + " to " + FK._DestObjectObj.getFullName() + " (->" + T.getFullName() + ")");
                if (FK._DestObjectObj.getFullName().equals(T.getFullName()) == true)
                  PotentialFKs.add(FK);
              }
            if (PotentialFKs.isEmpty() == false)
              {
                ForeignKey FK = FuckThat.pickMostRecentFKPart1(PotentialFKs, V, columnSequenceOrder);
                if (FK != null)
                  {
                    LOG.debug("WOOHOO! Picked " + FK._Name);
                    return FK;
                  }
                return null;
              }

            if (FT._PK != null)
              {
                PotentialFKs.clear();
                for (ForeignKey FK : T._ForeignKeys)
                  {
                    LOG.debug("      Looking at FK " + FK._Name + " to " + FK._DestObjectObj.getShortName() + " from " + FK._ParentObject.getShortName());
                    if (FK._DestObjectObj.getFullName().equals(FT._C._ParentObject.getFullName()) == true)
                      PotentialFKs.add(FK);
                  }
                if (PotentialFKs.isEmpty() == false)
                  {
                    ForeignKey FK = FuckThat.pickMostRecentFKPart2(PotentialFKs, columnSequenceOrder);
                    if (FK == null)
                      throw new Error("FK could not be resolved!");
                    LOG.debug("WOOHOO! Picked " + FK._Name);
                    return FK;
                  }
              }
          }
        return null;
      }

    private static ForeignKey pickMostRecentFKPart1(List<ForeignKey> potentialFKs, View V, int columnSequenceOrder)
      {
        if (potentialFKs.size() == 1)
          return potentialFKs.get(0);
        int MostRecentSequenceOrder = -1;
        ForeignKey MostRecentFK = null;
        for (ForeignKey FK : potentialFKs)
          {
            for (Column C : FK._SrcColumnObjs)
              {
                LOG.debug("      FK " + FK._Name + ": " + C.getShortName() + "(" + C.getSequenceOrder() + ")");
                int i = -1;
                for (ViewColumn VC : V._ViewColumns)
                  {
                    ++i;
                    Column sameAsRoot = VC.getSameAsRoot();
                    if (sameAsRoot != null && sameAsRoot.getFullName().equals(C.getFullName()) == true)
                      {
                        if (i < columnSequenceOrder && i > MostRecentSequenceOrder)
                          {
                            MostRecentSequenceOrder = i;
                            MostRecentFK = FK;
                            LOG.debug("            --> Original sequence order:" + i);
                          }
                      }
                  }
              }
          }
        return MostRecentFK;
      }

    private static ForeignKey pickMostRecentFKPart2(List<ForeignKey> potentialFKs, int columnSequenceOrder)
      {
        if (potentialFKs.size() == 1)
          return potentialFKs.get(0);
        int MostRecentSequenceOrder = -1;
        ForeignKey MostRecentFK = null;
        for (ForeignKey FK : potentialFKs)
          {
            for (Column C : FK._SrcColumnObjs)
              {
                if (C.getSequenceOrder() < columnSequenceOrder && C.getSequenceOrder() > MostRecentSequenceOrder)
                  {
                    MostRecentSequenceOrder = C.getSequenceOrder();
                    MostRecentFK = FK;
                  }
              }
          }
        return MostRecentFK;
      }

    private boolean isBoring()
      {
        return _PK == null && _FKs.isEmpty() == true;
      }


  }
