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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.interfaces.CodeGenAppData;
import tilda.generation.interfaces.CodeGenAppFactory;
import tilda.generation.interfaces.CodeGenDocs;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.interfaces.CodeGenSqlDocs;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.generation.interfaces.CodeGenTildaFactory;
import tilda.generation.interfaces.CodeGenTildaSupport;

public class GeneratorSession
  {
    protected static final Logger LOG = LogManager.getLogger(GeneratorSession.class.getName());

    public GeneratorSession(String Language, int LanguageMajorVersion, int LanguageMinorVersion, String Database, int DatabaseMajorVersion, int DatabaseMinorVersion)
    throws Exception
     {
       Language = Language.toLowerCase();
       //Database = Database.toLowerCase();
       
       for (int i = LanguageMajorVersion; i >= 1; --i)
         {
           for (int j = LanguageMinorVersion; j >= 0; --j)
             {
               if (InitCodeGenerators(Language+i+"_"+j) == true)
                break;
             }
           if (_TildaSupportGenerator != null || InitCodeGenerators(Language+i) == true)
            break;
           if (LanguageMinorVersion < 0)
             LanguageMinorVersion = 15;
         }
       if (_TildaSupportGenerator == null && InitCodeGenerators(Language) == false)
        throw new Exception("Could not load code generators for language "+Language+LanguageMajorVersion+(LanguageMinorVersion<0?"":"_"+LanguageMinorVersion));
       
       for (int i = DatabaseMajorVersion; i >= 1; --i)
         {
           for (int j = DatabaseMinorVersion; j >= 0; --j)
             {
               if (InitDBGenerators(Database+i+"_"+j) == true)
                break;
             }
           if (_SqlClassGenerator != null || InitDBGenerators(Database+i) == true)
            break;
           if (DatabaseMinorVersion < 0)
             DatabaseMinorVersion = 15;
         }
       if (_SqlClassGenerator == null && InitDBGenerators(Database) == false)
        throw new Exception("Could not load code generators for database "+Database+DatabaseMajorVersion+(DatabaseMinorVersion < 0 ? "" : "_"+DatabaseMinorVersion));
       
     }
    protected boolean InitCodeGenerators(String ClassKey)
      {
        try{
          _DocsGenerator         = (CodeGenDocs        ) Class.forName("tilda.generation."+ClassKey+".Docs"   ).getDeclaredConstructor().newInstance();

          _TildaSupportGenerator = (CodeGenTildaSupport) Class.forName("tilda.generation."+ClassKey+".TildaSupport").getDeclaredConstructor().newInstance();
          _TildaDataGenerator    = (CodeGenTildaData   ) Class.forName("tilda.generation."+ClassKey+".TildaData"   ).getDeclaredConstructor().newInstance();
          _TildaFactoryGenerator = (CodeGenTildaFactory) Class.forName("tilda.generation."+ClassKey+".TildaFactory").getDeclaredConstructor().newInstance();
//          _TildaJsonGenerator    = (CodeGenTildaJson   ) Class.forName("tilda.generation."+ClassKey+".TildaJson"   ).getDeclaredConstructor().newInstance();

          _AppDataGenerator      = (CodeGenAppData     ) Class.forName("tilda.generation."+ClassKey+".AppData"     ).getDeclaredConstructor().newInstance();
          _AppFactoryGenerator   = (CodeGenAppFactory  ) Class.forName("tilda.generation."+ClassKey+".AppFactory"  ).getDeclaredConstructor().newInstance();
//          _AppJsonGenerator      = (CodeGenAppJson     ) Class.forName("tilda.generation."+ClassKey+".AppJson"     ).getDeclaredConstructor().newInstance();
        }
        catch (Throwable T)
          {
            return false;
          }
        return true;
      }
    
    protected boolean InitDBGenerators(String ClassKey)
      {
        try{
          _SqlClassGenerator = (CodeGenSql    ) Class.forName("tilda.generation."+ClassKey+".Sql" ).getDeclaredConstructor().newInstance();
          _SqlDocsGenerator  = (CodeGenSqlDocs) Class.forName("tilda.generation."+ClassKey+".Docs").getDeclaredConstructor().newInstance();
        }
        catch (Throwable T)
          {
            return false;
          }
        return true;
      }
    
    
    protected CodeGenSql          _SqlClassGenerator    ;
    protected CodeGenSqlDocs      _SqlDocsGenerator     ;
    
    protected CodeGenDocs         _DocsGenerator        ;

    protected CodeGenTildaSupport _TildaSupportGenerator;
    protected CodeGenTildaData    _TildaDataGenerator   ;
    protected CodeGenTildaFactory _TildaFactoryGenerator;
//    protected CodeGenTildaJson    _TildaJsonGenerator   ;
    
    protected CodeGenAppData      _AppDataGenerator     ;
    protected CodeGenAppFactory   _AppFactoryGenerator  ;
//    protected CodeGenAppJson      _AppJsonGenerator     ;
    
    public CodeGenSql          getSql            () { return _SqlClassGenerator    ; }
    public CodeGenSqlDocs      getSqlDocs        () { return _SqlDocsGenerator     ; }

    public CodeGenDocs         getGenDocs        () { return _DocsGenerator        ; }

    public CodeGenTildaSupport getGenTildaSupport() { return _TildaSupportGenerator; }
    public CodeGenTildaData    getGenTildaData   () { return _TildaDataGenerator   ; }
    public CodeGenTildaFactory getGenTildaFactory() { return _TildaFactoryGenerator; }
//    public CodeGenTildaJson    getGenTildaJson   () { return _TildaJsonGenerator   ; }
    
    public CodeGenAppData      getGenAppData     () { return _AppDataGenerator     ; }
    public CodeGenAppFactory   getGenAppFactory  () { return _AppFactoryGenerator  ; }
//    public CodeGenAppJson      getGenAppJson     () { return _AppJsonGenerator     ; }

  }
