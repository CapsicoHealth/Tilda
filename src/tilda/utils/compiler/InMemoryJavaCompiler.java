package tilda.utils.compiler;

import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by trung on 5/3/15.
 * https://github.com/trung/InMemoryJavaCompiler
 * Apache 2 License
 */

public class InMemoryJavaCompiler
  {
    protected static final Logger LOG   = LogManager.getLogger(InMemoryJavaCompiler.class.getName());

    protected static JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

    public static Class<?> compile(String className, String sourceCodeStr)
    throws Exception
      {
        List<JavaFileObject> compilationUnits = new ArrayList<JavaFileObject>();
        compilationUnits.add(new SourceCode(className, sourceCodeStr));
        CompiledCode compiledCode = new CompiledCode(className);

        DynamicClassLoader cl = new DynamicClassLoader(ClassLoader.getSystemClassLoader());

        ExtendedStandardJavaFileManager fileManager = new ExtendedStandardJavaFileManager(javac.getStandardFileManager(null, null, null), compiledCode, cl);
        
        JavaCompiler.CompilationTask task = javac.getTask(null, fileManager, null, null, null, compilationUnits);
        if (task.call() == false)
          {
            LOG.error("Cannot run the compiler task");
            return null;
          }

        return cl.loadClass(className);
      }
  }
