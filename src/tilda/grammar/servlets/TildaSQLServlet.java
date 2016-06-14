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
import tilda.utils.HttpStatus;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet(value="/svc/TildaSQLValidator/lint")
public class TildaSQLServlet extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1181688239603166570L;
	protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());
	  TildaSQLValidator _Validator;
	  JsonObject json = new JsonObject();
	  public void init() throws ServletException{}
	  
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  PrintWriter _PrintWriter = response.getWriter();
		  String Expr = request.getParameter("expr");
		  _Validator = new TildaSQLValidator(Expr);
		  if(_Validator.getParserSyntaxErrors() == 0){
			  _Validator.validate();
			  if(isExprValid(_Validator)){
				  json.add("response", TildaSQLServlet.jsonArrayFromErrors(_Validator));
				  response.setStatus(HttpStatus.BadRequest._Code);
			  }
			  else{
				  response.setStatus(HttpStatus.OK._Code);
			  }
		  } else{
			  // TODO refactor.
			  JsonObject j1 = new JsonObject();
			  j1.addProperty("message", "Invalid");
			  j1.addProperty("fromLine", 0);
			  j1.addProperty("toLine", 0);
			  j1.addProperty("fromColumn", 1);
			  j1.addProperty("toColumn", Expr.length());
			  j1.addProperty("severity", "error");
			  JsonArray jsonArray = new JsonArray();
			  jsonArray.add(j1);
			  json.add("response", jsonArray);
			  response.setStatus(HttpStatus.BadRequest._Code);
		  }
		  response.setContentType("application/json");
		  _PrintWriter.println(json.toString());
	  }
	  
	  
	  private static boolean isExprValid(TildaSQLValidator _Validator){
		  int synTaxErrCnt = _Validator.getParserSyntaxErrors();
		  return synTaxErrCnt == 0 ? getLintErrors(_Validator).hasNext() ? false : true : true;
	  }
	  
	  private static Iterator<ErrorList.Error> getLintErrors(TildaSQLValidator _Validator){
		  ErrorList errors = _Validator.getValidationErrors();
		  return errors.getErrors();
	  }
	  
	  private static JsonArray jsonArrayFromErrors(TildaSQLValidator _Validator){
		  JsonArray jsonArray = new JsonArray();
		  Iterator<ErrorList.Error> errorList = getLintErrors(_Validator);
		  while(errorList.hasNext()){
			  ErrorList.Error error = errorList.next();
			  JsonObject j1 = new JsonObject();
			  j1.addProperty("message", error._Msg);
			  j1.addProperty("fromLine", error._Line);
			  j1.addProperty("toLine", error._Line);
			  j1.addProperty("fromColumn", error._Column);
			  j1.addProperty("toColumn", error._Column+3);
			  j1.addProperty("severity", "error");
			  jsonArray.add(j1);
		  }
		  return jsonArray;

	  }
	  public void destroy(){}
	  
}
