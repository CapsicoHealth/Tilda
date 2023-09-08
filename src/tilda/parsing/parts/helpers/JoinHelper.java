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

package tilda.parsing.parts.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.JoinType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.utils.TextUtil;

public class JoinHelper
  {
    static final Logger LOG = LogManager.getLogger(JoinHelper.class.getName());

    protected static class RefDef
      {
        protected RefDef(ViewColumn vc)
          {
            _vc = vc;
            _signature = signature(vc._SameAsObj._ParentObject, vc._As);
          }

        protected final ViewColumn _vc;
        protected final String     _signature;

        protected boolean equals(RefDef rhs)
          {
            return _signature.equals(rhs._signature);
          }

        public String toString()
          {
            return _signature;
          }

        protected static String signature(Base ref, String as)
          {
            return ref.getShortName() + (TextUtil.isNullOrEmpty(as) == true ? "" : " as " + as);
          }

        protected static int findRef(List<RefDef> refs, RefDef ref)
          {
            for (int i = 0; i < refs.size(); ++i)
              if (refs.get(i) == ref)
                return i;
            return -1;
          }

        protected static void duplicateFKError(ParserSession PS, ForeignKey FK, ForeignKey fk, RefDef ref)
          {
            PS.AddError("View '" + ref._vc._ParentView.getFullName()
            + "' defines ViewColumn '" + ref._vc.getName()
            + "' referencing '" + ref._vc._SameAsObj._ParentObject.getFullName()
            + "' which has at least two foreign key matches in available tables/views ["
            + fk._ParentObject.getShortName() + ": " + TextUtil.print(fk._SrcColumns) + "]"
            + " and [" + FK._ParentObject.getShortName() + ": " + TextUtil.print(FK._SrcColumns) + "]."
            + " Please provide an explicit join.");
          }

        /**
         * The auto-join logic for Tilda is to look for the nearest previously referenced table
         * and check if there is an FK either forward or backward. For example:<BR>
         * <UL>
         * <LI>TableA.a1</LI>
         * <LI>TableA.a2</LI>
         * <LI>TableB.b1</LI>
         * <LI>TableB.b2</LI>
         * <LI>TableC.c1</LI>
         * <LI>TableC.c2</LI>
         * </UL>
         * First, TableA is the main FROM for the resulting view. Then we look at TableB and only
         * search backward. So we check against A to see if TableB has a foreign key to A or
         * the reverse, A has an FK to B. Then we look at TableC and we check first for FKs between
         * C and B, before checking C vs A. We should pick the first match that comes up.
         * 
         * @param PS
         * @param V
         * @param refs
         * @return
         */
        protected ForeignKey getCompatibleRefDef(ParserSession PS, View V, List<RefDef> refs)
          {
            int i = findRef(refs, this);
            while (i > 0)
              {
                RefDef ref = refs.get(--i);
                // Let's look first at the FKs from this ref to the previous ref;
                ForeignKey FK = null;
                for (ForeignKey fk : this._vc._SameAsObj._ParentObject._ForeignKeys)
                  if (fk._DestObjectObj.getFullName().equals(ref._vc._SameAsObj._ParentObject.getFullName()) == true)
                    {
                      if (FK != null)
                        duplicateFKError(PS, FK, fk, ref);
                      FK = fk;
                    }
                if (FK != null)
                  return FK;
                // Then let's look the previous ref to this ref.
                for (ForeignKey fk : ref._vc._SameAsObj._ParentObject._ForeignKeys)
                  if (fk._DestObjectObj.getFullName().equals(this._vc._SameAsObj._ParentObject.getFullName()) == true)
                    {
                      if (FK != null)
                        duplicateFKError(PS, FK, fk, ref);
                      FK = fk;
                    }
                if (FK != null)
                  return FK;
              }
            return null;
          }
      }

    public static void autoFillImpliedViewJoins(ParserSession PS, View V)
      {
        if (V._Name.equals("VisitView") == true)
          LOG.debug("SSS");

        List<RefDef> refs = getReferences(V);

        List<ViewJoin> newJoins = computeJoins(PS, V, refs);

        V._Joins = newJoins;
      }

    /**
     * Goes through refs and finds if they already have a matching ViewJoin, or if a new one needs to be automatically added.
     * 
     * @param PS
     * @param V
     * @param refs
     * @return
     */
    protected static List<ViewJoin> computeJoins(ParserSession PS, View V, List<RefDef> refs)
      {
        List<ViewJoin> newJoins = new ArrayList<ViewJoin>();
        for (int i = 1; i < refs.size(); ++i)
          {
            RefDef ref = refs.get(i);
            ViewJoin VJ = getViewJoin(V._Joins, ref);
            if (VJ != null)
              newJoins.add(VJ);
            else
              {
                ForeignKey fk = ref.getCompatibleRefDef(PS, V, refs);
                if (fk == null)
                  PS.AddError("View '" + ref._vc._ParentView.getFullName() + "' defines ViewColumn '" + ref._vc.getName() + "' with a sameAs referencing '" + ref._vc._SameAsObj._ParentObject.getFullName() + "' which cannot be joined automatically. Please provide an explicit join.");
                else
                  {
                    VJ = makeNewJoin(ref, fk, ref._vc._As);
                    VJ.validate(PS, V);
                    newJoins.add(VJ);
                  }
              }
          }
        return newJoins;
      }

    /**
     * Creates a new ViewJoin based on a FK definition and the "as"
     * 
     * @param fk
     * @param as
     * @return
     */
    private static ViewJoin makeNewJoin(RefDef ref, ForeignKey fk, String as)
      {
        ViewJoin VJ = new ViewJoin();
        VJ._As = as;
        VJ._Object = ref._vc._SameAsObj._ParentObject.getFullName(); // _DestObjectObj.getFullName();
        StringBuilder onClause = new StringBuilder();
        boolean nullable = fk._ParentObject.getFullName().equals(ref._vc._SameAsObj._ParentObject.getFullName()) == true;
        for (int i = 0; i < fk._SrcColumnObjs.size(); ++i)
          {
            Column fkCol = fk._SrcColumnObjs.get(i);
            // Nullable if the FK column itself is nullable, of the FK comes from the current
            // ref, e.g., "from A left join B" because B has the foreign key to A and not the reverse.
            if (fkCol._Nullable == true)
              nullable = true;
            if (onClause.isEmpty() == false)
              onClause.append(" and ");
            onClause.append(fkCol.getShortName()).append(TextUtil.isNullOrEmpty(as) == true ? "" : as).append(" = ").append(fk._DestObjectObj._PrimaryKey._ColumnObjs.get(i).getShortName());
          }
        Query Q = new Query(onClause.toString());
        VJ._Ons = new Query[] { Q
        };

        VJ._JoinStr = nullable == true ? JoinType.LEFT.name() : JoinType.INNER.name();
        return VJ;
      }

    /**
     * Finds a ViewJoin matching the ref provided. Returns null if none are found.
     * 
     * @param joins
     * @param ref
     * @return
     */
    private static ViewJoin getViewJoin(List<ViewJoin> joins, RefDef ref)
      {
        for (ViewJoin VJ : joins)
          if (VJ._ObjectObj != null && ref._signature.equals(RefDef.signature(VJ._ObjectObj, VJ._As)) == true)
            return VJ;
        return null;
      }

    /**
     * Goes through all columns in the view and puts together, the list of objects/views references
     * 
     * @param V
     * @param refs
     */
    protected static List<RefDef> getReferences(View V)
      {
        List<RefDef> L = new ArrayList<RefDef>();
        Set<String> S = new HashSet<String>();
        RefDef lastRef = null;

        for (ViewColumn VC : V._ViewColumns)
          {
            // is this real view column or not?
            if (VC._SameAsObj == null)
              continue;
            RefDef currentRef = new RefDef(VC);
            // First reference? It's the base of the view.
            if (lastRef == null)
              {
                S.add(currentRef._signature);
                L.add(currentRef);
                lastRef = currentRef;
                continue;
              }
            // Are we still in the same ref?
            if (currentRef.equals(lastRef) == true)
              continue;
            lastRef = currentRef;
            // It's a new ref and it hasn't been referenced yet, let's add it
            if (S.add(currentRef._signature) == true)
              L.add(currentRef);
          }
        return L;
      }

  }
