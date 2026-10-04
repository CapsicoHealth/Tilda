package tilda.generation;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;

public class GenerationCache
  {
    private static final String INPUTS_SUFFIX = ".inputs";

    private GenerationCache()
      {
      }

    public static boolean isUpToDate(String schemaPath)
      {
        try
          {
            File schemaFile = new File(schemaPath);
            if (schemaFile.isFile() == false)
              return false;

            File generatedFolder = new File(schemaFile.getAbsoluteFile().getParentFile(), "_Tilda");
            String supportName = "TILDA__" + Generator.TILDA_VERSION_VAROK;
            File sentinel = new File(generatedFolder, supportName + ".java");
            File inputsFile = new File(generatedFolder, supportName + INPUTS_SUFFIX);
            if (sentinel.isFile() == false || inputsFile.isFile() == false)
              return false;

            long generatedAt = sentinel.lastModified();
            if (generatedAt <= 0 || schemaFile.lastModified() >= generatedAt)
              return false;

            List<String> inputs = Files.readAllLines(inputsFile.toPath(), StandardCharsets.UTF_8);
            if (inputs.isEmpty() == true)
              return false;

            for (String input : inputs)
              {
                File inputFile = resolveInput(input);
                if (inputFile == null || inputFile.isFile() == false || inputFile.lastModified() <= 0 || inputFile.lastModified() >= generatedAt)
                  return false;
              }
            return true;
          }
        catch (Exception e)
          {
            return false;
          }
      }

    public static void writeInputs(String schemaPath, ParserSession PS)
    throws IOException
      {
        File schemaFile = new File(schemaPath).getAbsoluteFile();
        File generatedFolder = new File(schemaFile.getParentFile(), "_Tilda");
        String supportName = "TILDA__" + Generator.TILDA_VERSION_VAROK;
        File inputsFile = new File(generatedFolder, supportName + INPUTS_SUFFIX);

        Set<String> inputs = new TreeSet<String>();
        addInput(inputs, PS._Main);
        Iterator<Schema> dependencies = PS.getDependenciesIterator();
        while (dependencies.hasNext() == true)
          addInput(inputs, dependencies.next());

        if (inputs.isEmpty() == true)
          throw new IOException("Cannot record generation inputs for schema '" + schemaPath + "'.");
        File tempFile = new File(generatedFolder, inputsFile.getName() + ".tmp");
        Files.write(tempFile.toPath(), new ArrayList<String>(inputs), StandardCharsets.UTF_8);
        try
          {
            Files.move(tempFile.toPath(), inputsFile.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
          }
        catch (java.nio.file.AtomicMoveNotSupportedException e)
          {
            Files.move(tempFile.toPath(), inputsFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
          }
      }

    private static void addInput(Set<String> inputs, Schema schema)
    throws IOException
      {
        if (schema == null || schema._ResourceName == null || schema._ResourceName.trim().isEmpty() == true)
          throw new IOException("Cannot record a schema dependency without a source path.");
        inputs.add(schema._ResourceName);
      }

    private static File resolveInput(String input)
    throws Exception
      {
        File file = new File(input);
        if (file.isFile() == true)
          return file;

        URL resource = FileUtil.class.getClassLoader().getResource(input);
        if (resource == null)
          return null;
        if ("file".equals(resource.getProtocol()) == true)
          return new File(resource.toURI());
        if ("jar".equals(resource.getProtocol()) == true)
          {
            URL jar = ((JarURLConnection) resource.openConnection()).getJarFileURL();
            if ("file".equals(jar.getProtocol()) == true)
              return new File(jar.toURI());
          }
        return null;
      }
  }