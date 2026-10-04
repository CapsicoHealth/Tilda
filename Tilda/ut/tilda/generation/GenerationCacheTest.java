package tilda.generation;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Schema;

public class GenerationCacheTest
  {
    public static void main(String[] args)
    throws Exception
      {
        Path root = Files.createTempDirectory("tilda-generation-cache");
        Path schema = root.resolve("_tilda.Root.json");
        Path dependency = root.resolve("_tilda.Dependency.json");
        Path transitiveDependency = root.resolve("_tilda.Base.json");
        Files.write(schema, new byte[0]);
        Files.write(dependency, new byte[0]);
        Files.write(transitiveDependency, new byte[0]);

        Path generated = root.resolve("_Tilda");
        Files.createDirectory(generated);
        String supportName = "TILDA__" + Generator.TILDA_VERSION_VAROK;
        Path sentinel = generated.resolve(supportName + ".java");
        Path inputs = generated.resolve(supportName + ".inputs");
        Files.write(sentinel, new byte[0]);
        Files.write(inputs, Arrays.asList(dependency.toString(), transitiveDependency.toString()), StandardCharsets.UTF_8);

        setModified(schema, 1_000_000L);
        setModified(dependency, 1_000_000L);
        setModified(transitiveDependency, 1_000_000L);
        setModified(sentinel, 2_000_000L);
        assertUpToDate(schema, true);

        setModified(transitiveDependency, 3_000_000L);
        assertUpToDate(schema, false);

        setModified(transitiveDependency, 1_000_000L);
        setModified(schema, 3_000_000L);
        assertUpToDate(schema, false);

        setModified(schema, 1_000_000L);
        Files.delete(transitiveDependency);
        assertUpToDate(schema, false);

        Files.delete(inputs);
        assertUpToDate(schema, false);

        Files.write(transitiveDependency, new byte[0]);
        setModified(transitiveDependency, 1_000_000L);
        Schema rootSchema = new Schema();
        rootSchema._Package = "test";
        rootSchema._Name = "Root";
        rootSchema._ResourceName = schema.toString();
        Schema dependencySchema = new Schema();
        dependencySchema._Package = "test";
        dependencySchema._Name = "Dependency";
        dependencySchema._ResourceName = dependency.toString();
        Schema transitiveSchema = new Schema();
        transitiveSchema._Package = "test";
        transitiveSchema._Name = "Base";
        transitiveSchema._ResourceName = transitiveDependency.toString();
        ParserSession session = new ParserSession(rootSchema, null);
        session.addDependencySchema(dependencySchema);
        session.addDependencySchema(transitiveSchema);
        GenerationCache.writeInputs(schema.toString(), session);
        java.util.List<String> recorded = Files.readAllLines(inputs, StandardCharsets.UTF_8);
        if (recorded.contains(schema.toString()) == false || recorded.contains(dependency.toString()) == false || recorded.contains(transitiveDependency.toString()) == false)
          throw new IllegalStateException("The generation manifest did not include the root and its transitive dependency closure: " + recorded);
        assertUpToDate(schema, true);
      }

    private static void setModified(Path path, long timestamp)
    throws Exception
      {
        Files.setLastModifiedTime(path, FileTime.fromMillis(timestamp));
      }

    private static void assertUpToDate(Path schema, boolean expected)
      {
        boolean actual = GenerationCache.isUpToDate(schema.toString());
        if (actual != expected)
          throw new IllegalStateException("Expected schema freshness to be " + expected + " but got " + actual + ".");
      }
  }