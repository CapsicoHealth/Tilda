package tilda.generation.helpers;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Catalog_Data;
import tilda.data.Catalog_Factory;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectMode;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.utils.TextUtil;

public class CatalogHelper
  {
    protected static final Logger LOG = LogManager.getLogger(CatalogHelper.class.getName());

    public CatalogHelper()
      {
      }

    public List<Catalog_Data> _CL = new ArrayList<Catalog_Data>();


    public void addSchema(Schema s) throws Exception
      {
        for (Object O : s._Objects)
          {
            if (O != null && O._FST != FrameworkSourcedType.VIEW && (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.DB_ONLY))
              addColumns(O._Columns);
          }
        for (View V : s._Views)
          if (V != null && (V._Mode == ObjectMode.NORMAL || V._Mode == ObjectMode.DB_ONLY))
            {
              addViewColumns(V._ViewColumns);
              addViewColumns(V._PivotColumns);
              addFormulas(V._Formulas);
            }
      }
    
    public void addColumns(List<Column> CL)
    throws Exception
      {
        for (Column col : CL)
          {
            Catalog_Data catalog = new Catalog_Data(col._ParentObject.getSchema().getShortName(), col._ParentObject.getBaseName(), col.getName(), col.getType().name(), col._Description);
            catalog.setTableViewName2(null);
            catalog.setAggregate(null);
            catalog.setCollection(col.isCollection());
            catalog.setTitle(null);
            catalog.setFormula(null);
            catalog.setNullMeasure();
            catalog.setHtmlDoc(null);
            catalog.setReferencedColumns(null);
            catalog.setReferencedFormulas(null);
            _CL.add(catalog);
          }
      }

    public void addViewColumns(List<ViewColumn> VCL)
    throws Exception
      {
        for (ViewColumn vc : VCL)
          {
            if (vc._FormulaOnly == true || vc._JoinOnly == true)
             continue;
            Catalog_Data catalog = new Catalog_Data(vc._ParentView.getSchema().getShortName(), vc._ParentView.getBaseName(), vc._Name, vc.getType().name(), vc._Description);
            catalog.setTableViewName2(vc._ParentView.getRealizedTableName(true));
            catalog.setAggregate(vc._Aggregate == null ? null : vc._Aggregate.name());
            catalog.setCollection(vc.isCollection());
            catalog.setTitle(null);
            catalog.setFormula(vc._Expression == null ? null : vc._Expression);
            catalog.setNullMeasure();
            catalog.setHtmlDoc(null);
            catalog.setReferencedColumns(null);
            catalog.setReferencedFormulas(null);
            _CL.add(catalog);
          }

      }

    public void addFormulas(List<Formula> FL)
    throws Exception
      {
        for (Formula f : FL)
          {
            String description = String.join("\n", f._Description);
            Catalog_Data catalog = new Catalog_Data(f._ParentView.getSchema().getShortName(), f._ParentView.getBaseName(), f._Name, f.getType().name(), description);
            catalog.setTableViewName2(f._ParentView.getRealizedTableName(true));
            catalog.setAggregate(null);
            catalog.setCollection(f.isCollection());
            catalog.setTitle(f._Title);
            catalog.setFormula(String.join("\\n", f._FormulaStrs));
            catalog.setMeasure(f._Measure);
            catalog.setHtmlDoc(null);

            List<String> names = new ArrayList<String>();
            for (ViewColumn vc : f.getDependencyColumns())
              names.add(vc._Name);
            catalog.setReferencedColumns(names);

            names.clear();
            for (Formula ff : f.getDependencyFormulas())
              names.add(ff._Name);
            catalog.setReferencedFormulas(names);
            _CL.add(catalog);
          }
      }

    public String outputSQLProc(CodeGenSql gen, long firstKey, int start, int size)
    throws Exception
      {
        StringBuilder str = new StringBuilder();

        String[] cols = { "schemaName", "tableViewName", "columnName", "type", "description", "tableViewName2", "aggregate", "collection", "title", "formula", "measure", "htmlDoc", "referencedColumns", "referencedFormulas"
        };

        str.append("  INSERT INTO TILDA.Catalog (\"refnum\"");
        boolean first = true;
        for (String col : cols)
          str.append(", ").append(gen.getShortColumnVar(col));
        str.append(")\n");
        str.append("    VALUES (");
        Set<String> names = new HashSet<String>();
        for (int i = start; i < start+size && i < _CL.size(); ++i)
          {
            Catalog_Data cat = _CL.get(i);
            String sig = cat.getSchemaName() + " | " + cat.getTableViewName() + " | " + cat.getColumnName();
            if (names.add(sig) == false)
              LOG.error("Duplicate entry: " + sig);
            if (i > start)
              str.append("          ,(");
            str.append(firstKey + i);
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getSchemaName()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getTableViewName()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getColumnName()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getType()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getDescription()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getTableViewName2()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getAggregate()));
            str.append(", " + cat.getCollection());
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getTitle()));
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getFormula()));
            str.append(", " + cat.getMeasure());
            str.append(", " + TextUtil.escapeSingleQuoteForSQL(cat.getHtmlDoc()));
            str.append(", ");
            printArray(str, cat.getReferencedColumnsAsArray());
            str.append(", ");
            printArray(str, cat.getReferencedFormulasAsArray());
            str.append(")\n");
          }
        str.append("  ON CONFLICT(\"schemaName\", \"tableViewName\", \"columnName\") DO UPDATE\n");


        str.append("    SET ");
        first = true;
        cols = new String[] { "type", "description", "tableViewName2", "aggregate", "collection", "title", "formula", "measure", "htmlDoc", "referencedColumns", "referencedFormulas"
        };
        for (String col : cols)
          {
            if (first == true)
              first = false;
            else
              str.append("      , ");
            str.append(gen.getShortColumnVar(col)).append(" = EXCLUDED.").append(gen.getShortColumnVar(col)).append("\n");

          }
        str.append("      , ").append(gen.getShortColumnVar("lastUpdated")).append(" = current_timestamp\n");
        str.append("      , ").append(gen.getShortColumnVar("deleted")).append(" = null\n");
        str.append("   ;\n");
        str.append("\n");

        return str.toString();
      }

    private static void printArray(StringBuilder str, String[] vals)
      {
        if (vals == null || vals.length == 0)
          {
            str.append("null");
            return;
          }

        str.append("ARRAY[");
        TextUtil.escapeSingleQuoteForSQL(str, vals, true);
        str.append("]");
      }
    
    
    public void outputCSV(PrintWriter out)
    throws Exception
      {
        Catalog_Factory.toCSVSimple(out, _CL, true);
      }
    

  }
