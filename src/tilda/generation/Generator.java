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

package tilda.generation;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.generation.interfaces.CodeGenAppData;
import tilda.generation.interfaces.CodeGenAppFactory;
import tilda.generation.interfaces.CodeGenAppJson;
import tilda.generation.interfaces.CodeGenDocs;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.interfaces.CodeGenSqlDocs;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.generation.interfaces.CodeGenTildaFactory;
import tilda.generation.interfaces.CodeGenTildaJson;
import tilda.generation.interfaces.CodeGenTildaSupport;
import tilda.parsing.Parser;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.JsonMapping;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
import tilda.parsing.parts.View;

public class Generator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";


    public static boolean generate(Schema S, GeneratorSession G)
      throws Exception
      {
        LOG.info("Generating Tilda code for Schema '" + S.getFullName() + "'.");

        File Res = new File(S._ResourceName);
        File GenFolder = new File(Res.getParentFile().getAbsolutePath() + File.separator + "_Tilda");
        if (GenFolder.exists() == true)
          FileUtils.deleteDirectory(GenFolder);
        if (GenFolder.mkdir() == false)
          throw new Exception("Cannot create the Tilda folder " + GenFolder.getAbsolutePath());

        genTildaSql(G, GenFolder, S);
        genTildaSupport(G, GenFolder, S);

        for (Object O : S._Objects)
          if (O != null)
            {
              genTildaData(G, GenFolder, O);
              genTildaFactory(G, GenFolder, O);
              genTildaJson(G, GenFolder, O);
              genAppData(G, Res.getParentFile(), O);
              genAppFactory(G, Res.getParentFile(), O);
              genAppJson(G, Res.getParentFile(), O);
            }
        return true;
      }


    protected static void genTildaSql(GeneratorSession G, File GenFolder, Schema S)
      throws Exception
      {
        CodeGenSql CG = G.getSql();
        CodeGenSqlDocs DG = G.getSqlDocs();

        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(S._Objects.get(0)));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating the SQL file.");
//        LOG.debug("       -> " + f.getCanonicalPath());
        DG.FileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, S);
        for (Object O : S._Objects)
          if (O != null && O._FST != FrameworkSourcedType.VIEW)
            {
              Out.println();
              Out.println();
              Out.println();
              DG.ObjectDocs(Out, G, O);
              getFullTableDDL(CG, Out, O);
            }
        Out.println();
        for (View V : S._Views)
          if (V != null)
            {
              Out.println();
              Out.println();
              Out.println();
              DG.ObjectDocs(Out, G, null);
              getFullViewDDL(CG, Out, V);
            }
        Out.println();
        Out.close();
      }


    public static void getFullTableDDL(CodeGenSql CG, PrintWriter Out, Object O)
    throws Exception
      {
        CG.genDDL(Out, O);
        for (Index I : O._Indices)
          if (I != null)
            CG.genIndex(Out, I);
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          CG.genKeysManagement(Out, O);
      }

    public static void getFullViewDDL(CodeGenSql CG, PrintWriter Out, View V)
    throws Exception
      {
        CG.genDDL(Out, V);
      }


    protected static void genTildaSupport(GeneratorSession G, File GenFolder, Schema S)
      throws Exception
      {
        CodeGenTildaSupport CG = G.getGenTildaSupport();
        CodeGenDocs DG = G.getGenDocs();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(null));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating base generic Tilda support class.");
//        LOG.debug("       -> " + f.getCanonicalPath());
        CG.genFileStart(Out, S);
        Out.println();
        DG.SupportClassDocs(Out, G);
        Out.println();
        CG.genClassStart(Out, G, null);
        Out.println();
        CG.genSupportCode(Out, G, S);
        Out.println();
        CG.genInitMethod(Out, G, S);
        Out.println();
        CG.genClassEnd(Out, G);
        Out.close();
      }

    protected static void genTildaData(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenTildaData CG = G.getGenTildaData();
        CodeGenDocs DG = G.getGenDocs();

        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating Tilda class for Object '" + O.getFullName() + "'.");
//        LOG.debug("       -> " + f.getCanonicalPath());

        DG.DataFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O._ParentSchema);
        Out.println();
        DG.MustNotBeModified(Out, G);
        Out.println();
        DG.DataClassDocs(Out, G, O);
        CG.genClassStart(Out, G, O);
        for (Column C : O._Columns)
          if (C != null)
            {
              Out.println();
              Out.println();
              Out.println();
              DG.MustNotBeModified(Out, G);
              Out.println();

              if (C._Mode != ColumnMode.CALCULATED || C._Mode == ColumnMode.CALCULATED && C._MapperDef != null)
                {
                  DG.docField(Out, G, C, "definition");
                  CG.genField(Out, G, C);
                  if (C._Values != null && C._Type != ColumnType.DATETIME)
                    {
                      DG.docFieldValues(Out, G, C);
                      CG.genFieldValues(Out, G, C);
                    }
                }

              Out.println();
              DG.docField(Out, G, C, "getter");
              CG.genMethodGet(Out, G, C);

              if (C._Values != null && C._Type != ColumnType.DATETIME)
                for (ColumnValue V : C._Values)
                  {
                    if (V == null)
                      continue;
                    Out.println();
                    DG.docMethodIs(Out, G, V, "is-a");
                    CG.genMethodIs(Out, G, V);
                  }

              if (C._Mode != ColumnMode.CALCULATED && C._Nullable == true)
                {
                  Out.println();
                  DG.docField(Out, G, C, "isNull");
                  CG.genMethodIsNull(Out, G, C);
                }

              if (C._Mode == ColumnMode.CALCULATED && C._MapperDef != null)
                {
                  Out.println();
                  DG.docField(Out, G, C, "setter");
                  CG.genMethodSet(Out, G, C);

                  if (C._PrimaryKey == false && C._Nullable == true)
                    {
                      Out.println();
                      DG.docField(Out, G, C, "null setter");
                      CG.genMethodSetNull(Out, G, C);
                    }
                }

              if (C._Mode != ColumnMode.CALCULATED)
                {
                  Out.println();
                  DG.docField(Out, G, C, "setter");
                  CG.genMethodSet(Out, G, C);

                  if (C._PrimaryKey == false && C._Nullable == true)
                    {
                      Out.println();
                      DG.docField(Out, G, C, "null setter");
                      CG.genMethodSetNull(Out, G, C);
                    }


                  if (O._LC == ObjectLifecycle.NORMAL || O._LC == ObjectLifecycle.WORM)
                    {
                      if (C._Values != null && C._Type != ColumnType.DATETIME)
                        for (ColumnValue V : C._Values)
                          if (V != null)
                            {
                              Out.println();
                              DG.docMethodIs(Out, G, V, "setter-as");
                              CG.genMethodSetAs(Out, G, V);
                            }


                      if (C._PrimaryKey == false) // only non pk columns can be changed.
                        {
                          if (C._Type == ColumnType.DATETIME && C._TypeSep == null)
                            {
                              Out.println();
                              DG.docField(Out, G, C, "NOW setter");
                              CG.genMethodSetDateTimeNow(Out, G, C);
                              Out.println();
                              DG.docField(Out, G, C, "UNDEFINED setter");
                              CG.genMethodSetDateTimeUndefined(Out, G, C);
                              Out.println();
                              DG.docField(Out, G, C, "explicit setter %%CALENDAR_SETTER%%");
                              CG.genMethodSetDateTimeExplicit(Out, G, C);
                            }

                          Out.println();
                          DG.docField(Out, G, C, "hasChanged");
                          CG.genMethodHasChanged(Out, G, C);
                        }
                    }
                }
            }

        Out.println();
        Out.println();
        DG.MustNotBeModified(Out, G);

        if (O._LC != ObjectLifecycle.READONLY)
          {
            Out.println();
            DG.docMethodCopyTo(Out, G, O);
            CG.genMethodCopyTo(Out, G, O, O.getCopyToColumns());

            if (O._OCC == true)
              {
                Column C = O.getColumn("lastUpdated");
                if (C == null)
                  throw new Error("The object " + O.getFullName() + " is marked as OCC yet doesn't have the 'lastUpdated' column");
                Out.println();
                DG.docMethodTouch(Out, G, C);
                CG.genMethodTouch(Out, G, C);
              }

            Out.println();
            DG.docMethodWrite(Out, G, O);
            CG.genMethodWrite(Out, G, O);
          }

        Out.println();
        Out.println();
        DG.MustNotBeModified(Out, G);

        Out.println();
        DG.docMethodRefresh(Out, G, O);
        CG.genMethodRefresh(Out, G, O);

        Out.println();
        DG.docMethodRead(Out, G, O);
        CG.genMethodRead(Out, G, O);

        Out.println();
        DG.docMethodToString(Out, G, O);
        CG.genMethodToString(Out, G, O);

        if (O._Json.isEmpty() == false)
         {
           Out.println();
           DG.docMethodToJSON(Out, G, O);
           CG.genMethodToJSON(Out, G, O);
         }

        CG.genClassEnd(Out, G);
        Out.close();
      }

    protected static void genTildaFactory(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenTildaFactory CG = G.getGenTildaFactory();
        CodeGenDocs DG = G.getGenDocs();

        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating Tilda class for Object '" + O.getFullName() + "'.");
//        LOG.debug("       -> " + f.getCanonicalPath());

        DG.FactoryFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O._ParentSchema);
        Out.println();
        DG.MustNotBeModified(Out, G);
        Out.println();
        DG.FactoryClassDocs(Out, G, O);
        CG.genClassStart(Out, G, O);
        Out.println();
        Out.println();
        DG.MustNotBeModified(Out, G);

        if (O._LC != ObjectLifecycle.READONLY)
          {
            List<Column> CreateColumns = O.getCreateColumns();
            List<Column> DefaultCreateColumns = O.getDefaultCreateColumns();
            Out.println();
            DG.docMethodCreate(Out, G, O, CreateColumns);
            CG.genMethodCreate(Out, G, O, CreateColumns, DefaultCreateColumns);
          }

        int LookupId = -1;
        if (O._PrimaryKey != null)
          {
            Out.println();
            DG.docMethodLookupByPrimaryKey(Out, G, O._PrimaryKey);
            CG.genMethodLookupByPrimaryKey(Out, G, O._PrimaryKey, ++LookupId);
          }

        if (O._Indices != null)
          for (Index I : O._Indices)
            if (I != null && I._Unique == true)
              {
                Out.println();
                DG.docMethodLookupByUniqueIndex(Out, G, I);
                CG.genMethodLookupByUniqueIndex(Out, G, I, ++LookupId);
              }
        if (O._Indices != null)
          for (Index I : O._Indices)
            if (I != null && I._Unique == false)
              {
                Out.println();
                DG.docMethodLookupWhereIndex(Out, G, I);
                CG.genMethodLookupWhereIndex(Out, G, I, ++LookupId);
              }

        if (O._Queries != null)
          for (SubWhereClause Q : O._Queries)
            if (Q != null && Q._Unique == true)
              {
                Out.println();
                DG.docMethodLookupByUniqueQuery(Out, G, Q);
                CG.genMethodLookupByUniqueQuery(Out, G, Q, ++LookupId);
              }
        if (O._Queries != null)
          for (SubWhereClause Q : O._Queries)
            if (Q != null && Q._Unique == false)
              {
                Out.println();
                DG.docMethodLookupWhereQuery(Out, G, Q);
                CG.genMethodLookupWhereQuery(Out, G, Q, ++LookupId);
              }

        if (O._ForeignKeys != null)
          for (ForeignKey FK : O._ForeignKeys)
            if (FK != null)
              {
                Out.println();
                DG.docMethodLookupParent(Out, G, FK);
                CG.genMethodLookupParent(Out, G, FK);
              }

        Out.println();
        DG.docQueryHelper(Out, G, O);
        CG.genQueryHelper(Out, G, O);

        if (O._FST == FrameworkSourcedType.MAPPER)
          {
            DG.docMappingSupport(Out, G, O);
            CG.genMappingSupport(Out, G, O);
          }
        else if (O._FST == FrameworkSourcedType.ENUMERATION)
          {
            DG.docEnumerationSupport(Out, G, O);
            CG.genEnumerationSupport(Out, G, O);
          }

        CG.genClassEnd(Out, G);
        Out.close();
      }

    protected static void genTildaJson(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenTildaJson CG = G.getGenTildaJson();
        CodeGenDocs DG = G.getGenDocs();

        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating Tilda JSON class for Object '" + O.getFullName() + "'.");
//        LOG.debug("       -> " + f.getCanonicalPath());
        DG.JsonFileDocs(Out, G, O);
        Out.println();
        CG.genFileStart(Out, O._ParentSchema);
        Out.println();
        DG.JsonClassDocs(Out, G, O);
        CG.genClassStart(Out, G, O);
        Out.println();

        if (O._LC != ObjectLifecycle.READONLY)
          {
            List<Column> CreateColumns = O.getCreateColumns();
            List<Column> JsonColumns = O.getJsonColumns();
            CG.genJsonSerializableField(Out, G, JsonColumns);
            Out.println();
            CG.genMethodWrite(Out, G, O, CreateColumns, JsonColumns);
            Out.println();
            CG.genMethodToString(Out, G, O);
          }
        for (JsonMapping J : O._Json)
          if (J != null)
            {
              Out.println();
              DG.docMethodToJSON(Out, G, J);
              CG.genMethodToJSON(Out, G, J);
            }
        Out.println();
        CG.genClassEnd(Out, G);
        Out.close();
      }


    protected static File genAppData(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenAppData CG = G.getGenAppData();
        CodeGenDocs DG = G.getGenDocs();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        if (f.exists() == false)
          {
            PrintWriter Out = new PrintWriter(f);
            LOG.debug("  Generating template App Data class for Object '" + O.getFullName() + "'.");
//            LOG.debug("       -> " + f.getCanonicalPath());
            DG.AppFileDocs(Out, G);
            Out.println();
            CG.genFileStart(Out, O._ParentSchema);
            Out.println();
            DG.AppClassDocs(Out, G, O);
            CG.genClassStart(Out, G, O);
            Out.println();
            DG.AppCustomizeHere(Out, G, O);
            Out.println();
            CG.genClassCustomizations(Out, G, O);
            Out.println();
            CG.genClassEnd(Out, G);
            Out.close();
          }
        return f;
      }

    protected static File genAppFactory(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenAppFactory CG = G.getGenAppFactory();
        CodeGenDocs DG = G.getGenDocs();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        if (f.exists() == false)
          {
            PrintWriter Out = new PrintWriter(f);
            LOG.debug("  Generating template App Factory class for Object '" + O.getFullName() + "'.");
//            LOG.debug("       -> " + f.getCanonicalPath());
            DG.AppFileDocs(Out, G);
            Out.println();
            CG.genFileStart(Out, O._ParentSchema);
            Out.println();
            DG.AppClassDocs(Out, G, O);
            CG.genClassStart(Out, G, O);
            Out.println();
            DG.AppCustomizeHere(Out, G, O);
            Out.println();
            CG.genClassCustomizations(Out, G, O);
            Out.println();
            CG.genClassEnd(Out, G);
            Out.close();
          }
        return f;
      }

    protected static File genAppJson(GeneratorSession G, File GenFolder, Object O)
      throws Exception
      {
        CodeGenAppJson CG = G.getGenAppJson();
        CodeGenDocs DG = G.getGenDocs();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        if (f.exists() == false)
          {
            PrintWriter Out = new PrintWriter(f);
            LOG.debug("  Generating template App Json class for Object '" + O.getFullName() + "'.");
//            LOG.debug("       -> " + f.getCanonicalPath());
            DG.AppFileDocs(Out, G);
            Out.println();
            CG.genFileStart(Out, O._ParentSchema);
            Out.println();
            DG.AppClassDocs(Out, G, O);
            CG.genClassStart(Out, G, O);
            Out.println();
            DG.AppCustomizeHere(Out, G, O);
            Out.println();
            CG.genClassEnd(Out, G);
            Out.close();
          }
        return f;
      }

  }
