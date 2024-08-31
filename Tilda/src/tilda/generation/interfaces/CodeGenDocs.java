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

package tilda.generation.interfaces;

import java.io.PrintWriter;
import java.util.List;

import tilda.generation.GeneratorSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.SubWhereClause;


public interface CodeGenDocs
  {
    public void MustNotBeModified(PrintWriter Out, GeneratorSession G);

    public void SupportFileDocs(PrintWriter Out, GeneratorSession G, Object O);
    
    public void SupportClassDocs(PrintWriter Out, GeneratorSession G);

    
    public void JsonFileDocs(PrintWriter Out, GeneratorSession G, Object O);

    public void JsonClassDocs(PrintWriter out, GeneratorSession g, Object o);

    public void docMethodOutput(PrintWriter Out, GeneratorSession G, OutputMap J);

    
    public void AppFileDocs (PrintWriter Out, GeneratorSession G) throws Exception;
    
    public void AppClassDocs(PrintWriter Out, GeneratorSession G, Object O) throws Exception;

    public void AppCustomizeHere(PrintWriter Out, GeneratorSession G, Object O);
    

    public void DataFileDocs (PrintWriter Out, GeneratorSession G) throws Exception;
    
    public void DataClassDocs(PrintWriter Out, GeneratorSession G, Object O, boolean exportPublish) throws Exception;
    
    public void docField(PrintWriter Out, GeneratorSession G, Column C, String DocsHeader) throws Exception;

    public void docFieldValues(PrintWriter Out, GeneratorSession G, Column C);

    public void docMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V, String DocsHeader);

    public void docMethodCopyTo(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodCopyForHistory(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodMask(PrintWriter out, GeneratorSession G, Object O);
    
    public void docMethodTouch(PrintWriter Out, GeneratorSession G, Column C);

    public void docMethodWrite(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodRefresh(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodRead(PrintWriter Out, GeneratorSession G, Object O);
    
    public void docMethodToString(PrintWriter Out, GeneratorSession G, Object O);

    public void docQueryHelper(PrintWriter Out, GeneratorSession G, Object O);

    public void docMappingSupport(PrintWriter Out, GeneratorSession G, Object O);
    
    public void docEnumerationSupport(PrintWriter Out, GeneratorSession G, Object O);

    
    public void FactoryFileDocs (PrintWriter Out, GeneratorSession G) throws Exception;
    
    public void FactoryClassDocs(PrintWriter Out, GeneratorSession G, Object O) throws Exception;
    
    public void docMethodCreate(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns);

    public void docMethodLookupByPrimaryKey(PrintWriter Out, GeneratorSession G, PrimaryKey _PrimaryKey);

    public void docMethodLookupByUniqueIndex(PrintWriter Out, GeneratorSession G, Index I);

    public void docMethodLookupWhereIndex(PrintWriter Out, GeneratorSession G, Index I);
    
    public void docMethodLookupByUniqueQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q);
    public void docMethodLookupWhereQuery(PrintWriter Out, GeneratorSession G, SubWhereClause Q);

    public void docMethodLookupParent(PrintWriter Out, GeneratorSession G, ForeignKey FK);

    public void docMethodOutput(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodJSONSchema(PrintWriter Out, GeneratorSession G, Column col);

    public void docMethodUpsert(PrintWriter Out, GeneratorSession G, Object O);

    public void docMethodInit(PrintWriter Out, GeneratorSession G, Object O);

    
  }
