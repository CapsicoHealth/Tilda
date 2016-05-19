package tilda.grammar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hello
  {
    protected static final Logger LOG = LogManager.getLogger(Hello.class.getName());

    public static void main(String[] args)
    throws Exception
      {
        String Expression = "12*(5-6)";
        ANTLRInputStream in = new ANTLRInputStream(Expression);
        HelloLexer lexer = new HelloLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        LOG.debug(Expression + " = " + parser.eval().value);
      }
  }
