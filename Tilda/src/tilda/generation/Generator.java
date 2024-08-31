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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.MultiType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ObjectMode;
import tilda.generation.helpers.CatalogHelper;
import tilda.generation.interfaces.CodeGenAppData;
import tilda.generation.interfaces.CodeGenAppFactory;
import tilda.generation.interfaces.CodeGenDocs;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.interfaces.CodeGenSqlDocs;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.generation.interfaces.CodeGenTildaFactory;
import tilda.generation.interfaces.CodeGenTildaSupport;
import tilda.parsing.Parser;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
import tilda.parsing.parts.View;
import tilda.utils.json.JSONUtil;

public class Generator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "2.5";
    public static final String    TILDA_VERSION_VAROK = "2_5";

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

        genTildaSupport(G, GenFolder, S);
        for (Object O : S._Objects)
          if (O != null && (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.CODE_ONLY))
            {
              LOG.debug("  Generating Tilda classes for Object '" + O.getFullName() + "'.");
              genTildaData(G, GenFolder, O);
              genTildaFactory(G, GenFolder, O);
              genAppData(G, Res.getParentFile(), O);
              genAppFactory(G, Res.getParentFile(), O);
            }

        genTildaBigQuerySchemas(G, GenFolder, S);
        genTildaSql(G, GenFolder, S);
        G.switchDBGenerator("bigquery", 0, 0);
        genTildaSql(G, GenFolder, S);
        G.switchDBGeneratorBack();
        genCatalogCSV(G, GenFolder, S);
        return true;
      }



    protected static void genTildaSql(GeneratorSession G, File GenFolder, Schema S)
    throws Exception
      {
        CodeGenSql CG = G.getSql();
        CodeGenSqlDocs DG = G.getSqlDocs();

        Base B = S._Objects.isEmpty() == false ? S._Objects.get(0)
        : S._Views.isEmpty() == false ? S._Views.get(0)
        : null;

        // Some schemas may be empty, such as TILDA_TMP, so we have to fake a root object to get started.
        if (B == null)
          {
            B = new Object();
            B._ParentSchema = S;
          }

        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(B));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating the SQL file.");
        DG.FileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, S);

        for (Object O : S._Objects)
          if (O != null && O._FST != FrameworkSourcedType.VIEW && (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.DB_ONLY))
            {
              Out.println();
              Out.println();
              Out.println();
              DG.ObjectDocs(Out, G, O);
              getTableDDL(CG, Out, O, true, true);
            }
        Out.println();

        for (View V : S._Views)
          if (V != null && (V._Mode == ObjectMode.NORMAL || V._Mode == ObjectMode.DB_ONLY))
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

    private static void genCatalogCSV(GeneratorSession G, File genFolder, Schema S)
    throws Exception
      {
        CodeGenSql CG = G.getSql();

        Base B = S._Objects.isEmpty() == false ? S._Objects.get(0)
        : S._Views.isEmpty() == false ? S._Views.get(0)
        : null;

        // Some schemas may be empty, such as TILDA_TMP, so we have to fake a root object to get started.
        if (B == null)
          {
            B = new Object();
            B._ParentSchema = S;
          }

        File f = new File(genFolder.getAbsolutePath() + File.separator + "TILDA___Catalog" + "." + B.getSchema()._Name + ".csv");
        PrintWriter out = new PrintWriter(f);
        LOG.debug("  Generating the Catalog CSV file.");
        CatalogHelper CH = new CatalogHelper();
        CH.addSchema(S);
        CH.outputCSV(out);
        out.println();

        out.close();
      }



    protected static void genTildaBigQuerySchemas(GeneratorSession G, File GenFolder, Schema S)
    throws Exception
      {
        LOG.debug("  Generating the BigQuery JSON Schema files.");

        GenFolder = new File(GenFolder.getAbsolutePath() + File.separator + "bigquery");
        if (GenFolder.exists() == true)
          FileUtils.deleteDirectory(GenFolder);
        if (GenFolder.mkdir() == false)
          throw new Exception("Cannot create the Tilda folder " + GenFolder.getAbsolutePath());

        for (Object O : S._Objects)
          if (O != null && O._FST != FrameworkSourcedType.VIEW && (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.DB_ONLY))
            {
              File f = new File(GenFolder.getAbsolutePath() + File.separator + "bq." + O._Name + ".json");
              PrintWriter Out = new PrintWriter(f);
              genTildaBigQuerySchema(O, Out);
              Out.close();
            }

        for (View V : S._Views)
          if (V != null && (V._Mode == ObjectMode.NORMAL || V._Mode == ObjectMode.DB_ONLY))
            {
              File f = new File(GenFolder.getAbsolutePath() + File.separator + "bq." + V._Name + ".json");
              PrintWriter Out = new PrintWriter(f);
              genTildaBigQuerySchema(V, Out);
              Out.close();
            }

        LOG.debug("  Generating the BigQuery JSON Schema files.");


      }


    public static void genTildaBigQuerySchema(Base O, PrintWriter Out)
    throws IOException
      {
        Out.println("[");
        boolean First = true;
        for (String name : O.getColumnNames())
          if (name != null)
            {
              Column col = O.getColumn(name);
              if (col == null)
                continue;
              if (First == true)
                {
                  First = false;
                  Out.print("    {");
                }
              else
                Out.print("   ,{");
              JSONUtil.print(Out, "name", true, col.getName());
              JSONUtil.print(Out, "type", false, col.getType().getBigQueryType());
              JSONUtil.print(Out, "mode", false, col.isCollection() == true ? "REPEATED" : col._Nullable == false ? "REQUIRED" : "NULLABLE");
              JSONUtil.print(Out, "description", false, col._Description);
              Out.println(" }");
            }
        Out.println("]");
      }

    public static void getTableDDL(CodeGenSql CG, PrintWriter Out, Object O, boolean mainDDL, boolean keysDDL)
    throws Exception
      {
        if (mainDDL == true)
          {
            CG.genDDL(Out, O);
            if (CG.supportsIndices() == false && O._Indices.isEmpty() == false)
              Out.println("-- Indices are not supported for this database, so logical definition only");

            for (Index I : O._Indices)
              if (I != null)
                CG.genIndex(Out, I);
          }
        if (keysDDL == true)
          {
            if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
              CG.genKeysManagement(Out, O);
          }
      }


    public static void getFullViewDDL(CodeGenSql CG, PrintWriter Out, View V)
    throws Exception
      {
        getViewBaseDDL(CG, Out, V);
        Out.append("\n");
        getViewCommentsDDL(CG, Out, V);
        Out.append("\n");
      }

    public static void getViewBaseDDL(CodeGenSql CG, PrintWriter Out, View V)
    throws Exception
      {
        CG.genDDL(Out, V);
      }

    public static void getViewCommentsDDL(CodeGenSql CG, PrintWriter Out, View V)
    throws Exception
      {
        CG.genDDLComments(Out, V);
      }

    public static void genTildaSupport(GeneratorSession G, File GenFolder, Schema S)
    throws Exception
      {
        CodeGenTildaSupport CG = G.getGenTildaSupport();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(null));
        PrintWriter Out = new PrintWriter(f);
        LOG.debug("  Generating base generic Tilda support class.");
        genTildaSupport(G, S, Out);
        Out.close();
      }

    public static void genTildaSupport(GeneratorSession G, Schema S, PrintWriter Out)
    throws Exception
      {
        CodeGenTildaSupport CG = G.getGenTildaSupport();
        CodeGenDocs DG = G.getGenDocs();

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
      }

    public static void genTildaData(GeneratorSession G, File GenFolder, Object O)
    throws Exception
      {
        CodeGenTildaData CG = G.getGenTildaData();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        PrintWriter Out = new PrintWriter(f);
        genTildaData(G, O, Out);
        Out.close();
      }

    public static void genTildaData(GeneratorSession G, Object O, PrintWriter Out)
    throws Exception, Error
      {
        CodeGenTildaData CG = G.getGenTildaData();
        CodeGenDocs DG = G.getGenDocs();

        DG.DataFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O);
        Out.println();
        DG.MustNotBeModified(Out, G);
        Out.println();
        DG.DataClassDocs(Out, G, O, false);
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
                  if (C._Values != null && C.getType() != ColumnType.DATETIME && C.getType() != ColumnType.DATETIME_PLAIN)
                    {
                      DG.docFieldValues(Out, G, C);
                      CG.genFieldValues(Out, G, C);
                    }
                }

              Out.println();
              DG.docField(Out, G, C, "getter");
              CG.genMethodGet(Out, G, C);

              if (C._Values != null && C.getType() != ColumnType.DATETIME && C.getType() != ColumnType.DATETIME_PLAIN)
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
                      if (C._Values != null && C.getType() != ColumnType.DATETIME && C.getType() != ColumnType.DATETIME_PLAIN)
                        for (ColumnValue V : C._Values)
                          if (V != null)
                            {
                              Out.println();
                              DG.docMethodIs(Out, G, V, "setter-as");
                              CG.genMethodSetAs(Out, G, V);
                            }


                      if (C._PrimaryKey == false) // only non pk columns can be changed.
                        {
                          if ((C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN) && C.getTypeCollection() == MultiType.NONE)
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
            if (O._HistoryObj != null)
              {
                Out.println();
                DG.docMethodCopyForHistory(Out, G, O);
                CG.genMethodCopyForHistory(Out, G, O, O._HistoryObj);
              }

            if (O._OCC == true)
              {
                Column C = O.getColumn(O._ParentSchema.getConventionLastUpdatedName());
                if (C == null)
                  throw new Error("The object " + O.getFullName() + " is marked as OCC yet doesn't have the column '"+O._ParentSchema.getConventionLastUpdatedName()+"'");
                Out.println();
                DG.docMethodTouch(Out, G, C);
                CG.genMethodTouch(Out, G, C);
              }
            else
              {
                Out.println();
                DG.docMethodTouch(Out, G, null);
                CG.genMethodTouch(Out, G, null);
              }

            Out.println();
            DG.docMethodWrite(Out, G, O);
            CG.genMethodWrite(Out, G, O);
            if (O._HasNaturalIdentity == true) // There is a natural Id for this object
              {
                DG.docMethodUpsert(Out, G, O);
                CG.genMethodUpsert(Out, G, O);
              }
          }

        Out.println();
        Out.println();
        DG.MustNotBeModified(Out, G);

        if (O.hasMasking() == true)
          {
            DG.docMethodMask(Out, G, O);
            CG.genMethodMask(Out, G, O);
          }

        Out.println();
        DG.docMethodRefresh(Out, G, O);
        CG.genMethodRefresh(Out, G, O);

        Out.println();
        DG.docMethodRead(Out, G, O);
        CG.genMethodRead(Out, G, O);

        Out.println();
        DG.docMethodToString(Out, G, O);
        CG.genMethodToString(Out, G, O);

        Out.println();
        DG.docMethodOutput(Out, G, O);
        CG.genMethodOutput(Out, G, O);

        CG.genClassEnd(Out, G);
      }

    public static void genTildaFactory(GeneratorSession G, File GenFolder, Object O)
    throws Exception
      {
        CodeGenTildaFactory CG = G.getGenTildaFactory();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        PrintWriter Out = new PrintWriter(f);
        genTildaFactory(G, O, Out);
        Out.close();
      }

    public static void genTildaFactory(GeneratorSession G, Object O, PrintWriter Out)
    throws Exception
      {
        CodeGenTildaFactory CG = G.getGenTildaFactory();
        CodeGenDocs DG = G.getGenDocs();

        DG.FactoryFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O);
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
            Out.println();
            DG.docMethodInit(Out, G, O);
            CG.genMethodInit(Out, G, O);

            List<Column> CreateColumns = O.getCreateColumns();
            List<Column> DefaultCreateColumns = O.getDefaultCreateColumns();
            Out.println();
            DG.docMethodCreate(Out, G, O, CreateColumns);
            CG.genMethodCreate(Out, G, O, CreateColumns, DefaultCreateColumns);

            CG.genBatchWrite(Out, G, O);
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
            Out.println();
            DG.docMappingSupport(Out, G, O);
            CG.genMappingSupport(Out, G, O);
          }
        else if (O._FST == FrameworkSourcedType.ENUMERATION)
          {
            Out.println();
            DG.docEnumerationSupport(Out, G, O);
            CG.genEnumerationSupport(Out, G, O);
          }

        for (OutputMap OM : O._OutputMaps)
          if (OM != null)
            {
              Out.println();
              DG.docMethodOutput(Out, G, OM);
              CG.genMethodToOutput(Out, G, OM);
            }

        Out.println();
        CG.genClassEnd(Out, G);
      }

    public static File genAppData(GeneratorSession G, File GenFolder, Object O)
    throws Exception
      {
        CodeGenAppData CG = G.getGenAppData();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        if (f.exists() == false)
          {
            PrintWriter Out = new PrintWriter(f);
            genAppData(G, O, Out);
            Out.close();
          }
        return f;
      }

    public static void genAppData(GeneratorSession G, Object O, PrintWriter Out)
    throws Exception
      {
        CodeGenAppData CG = G.getGenAppData();
        CodeGenDocs DG = G.getGenDocs();

        DG.AppFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O);
        Out.println();
        DG.AppClassDocs(Out, G, O);
        CG.genClassStart(Out, G, O);
        Out.println();
        DG.AppCustomizeHere(Out, G, O);
        Out.println();
        CG.genClassCustomizations(Out, G, O);
        Out.println();
        CG.genClassEnd(Out, G);
      }

    public static File genAppFactory(GeneratorSession G, File GenFolder, Object O)
    throws Exception
      {
        CodeGenAppFactory CG = G.getGenAppFactory();
        File f = new File(GenFolder.getAbsolutePath() + File.separator + CG.getFileName(O));
        if (f.exists() == false)
          {
            PrintWriter Out = new PrintWriter(f);
            genAppFactory(G, O, Out);
            Out.close();
          }
        return f;
      }

    public static void genAppFactory(GeneratorSession G, Object O, PrintWriter Out)
    throws Exception
      {
        CodeGenAppFactory CG = G.getGenAppFactory();
        CodeGenDocs DG = G.getGenDocs();

        DG.AppFileDocs(Out, G);
        Out.println();
        CG.genFileStart(Out, O);
        Out.println();
        DG.AppClassDocs(Out, G, O);
        CG.genClassStart(Out, G, O);
        Out.println();
        DG.AppCustomizeHere(Out, G, O);
        Out.println();
        CG.genClassCustomizations(Out, G, O);
        Out.println();
        CG.genClassEnd(Out, G);
      }
  }
