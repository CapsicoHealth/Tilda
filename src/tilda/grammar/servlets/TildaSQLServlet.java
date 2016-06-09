package tilda.grammar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQL;
import tilda.grammar.TildaSQLValidator;
@WebServlet(value="/svc/TildaValidator")
public class TildaSQLServlet extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1181688239603166570L;
	protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());

	  public void init() throws ServletException{}
	  
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  PrintWriter _PrintWriter = response.getWriter();
		  String Expr = request.getParameter("expr");
		  TildaSQLValidator Validator = new TildaSQLValidator(Expr);
		  Validator.validate();
		  ErrorList errors = Validator.getValidationErrors();
		  Iterator<ErrorList.Error> errorLists = errors.getErrors();
		  if(errorLists == null){
			  _PrintWriter.println("{\"message\": \"Valid!\"}");
		  } else{
			  _PrintWriter.println("{\"message\": \"Invalid!\"}");
//			  while(errorLists.hasNext()){
//				  ErrorList.Error error = errorLists.next();
//				  _PrintWriter.println(error._Msg);
//			  }
		  }
//	      List<String> Failures = new ArrayList<String>();
//		  if (Validator.getParserSyntaxErrors() == 0)
//		    LOG.debug("SUCCESS Parsing");
//		  else{
//		    Failures.add("Expression " + i + " failed with " + Validator.getParserSyntaxErrors() + " errors.");
//		    LOG.error("    --> " + Validator.getParserSyntaxErrors() + " ERROR(S).");
//   		  }
	  }
	  
	  public void destroy()
	  {
	      // do nothing.
	  }
}
