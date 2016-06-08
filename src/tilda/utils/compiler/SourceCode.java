package tilda.utils.compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * Created by trung on 5/3/15.
 * https://github.com/trung/InMemoryJavaCompiler
 * Apache 2 License
 */
public class SourceCode extends SimpleJavaFileObject
  {
    private String contents = null;

    public SourceCode(String className, String sourceCodeStr)
      throws Exception
      {
        super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        contents = sourceCodeStr;
      }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
    throws IOException
      {
        return contents;
      }
  }
