package tilda.grammar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import tilda.grammar.ColDefs;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQL;
import tilda.grammar.TildaSQLValidator;
import tilda.utils.AnsiUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.HttpStatus;
import tilda.utils.SystemValues;
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
		  LogRequestHeader(20, request);

		  PrintWriter _PrintWriter = response.getWriter();
		  String Expr = request.getParameter("expr");
		  _Validator = new TildaSQLValidator(Expr);
		  _Validator.setColumnEnvironment(ColDefs._COLS);

		  if(_Validator.getParserSyntaxErrors() == 0){ // check for syntax error
			  _Validator.validate();
			  Iterator<ErrorList.Error> errors = _Validator.getValidationErrors().getErrors();
			  boolean isValid = (errors != null && errors.hasNext()) ? false : true;
			  if(!isValid){
				  json.add("response", TildaSQLServlet.jsonArrayFromErrors(errors));
				  response.setStatus(HttpStatus.BadRequest._Code);
			  }
			  else{
				  response.setStatus(HttpStatus.OK._Code);
			  }
		  } else {
			  JsonObject j1 = new JsonObject();
			  j1.addProperty("message", "SYNTAX Error..");
			  j1.addProperty("fromLine", 0);// For code mirror line starts from zero(0) not from one(1)
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
	  
	  	  
	  private static JsonArray jsonArrayFromErrors(Iterator<ErrorList.Error> errorList){
		  JsonArray jsonArray = new JsonArray();
		  while(errorList !=null && errorList.hasNext()){
			  ErrorList.Error error = errorList.next();
			  JsonObject j1 = new JsonObject();
			  j1.addProperty("message", error._Msg);
			  j1.addProperty("fromLine", error._Line-1);
			  j1.addProperty("toLine", error._Line-1);
			  j1.addProperty("fromColumn", error._ColumnFrom);
			  j1.addProperty("toColumn", error._ColumnTo);
			  j1.addProperty("severity", "error");
			  jsonArray.add(j1);
		  }
		  return jsonArray;

	  }
	  public void destroy(){}
	  
	  private void LogRequestHeader(final long TransactionID, HttpServletRequest Request)
      {
        LOG.info(SystemValues.NEWLINEx2);
        LOG.info("********************************************************************************************************************************************");
        LOG.info("** " + AnsiUtil.NEGATIVE + "R E Q U E S T   #" + TransactionID + AnsiUtil.NEGATIVE_OFF + " - " + DateTimeUtil.printDateTime(ZonedDateTime.now()));
        LOG.info("**    RequestURL     : " + Request.getRequestURL()+"?"+Request.getQueryString());
        LOG.info("**    RemoteAddr     : " + Request.getRemoteAddr() + ":" + Request.getRemotePort());
        LOG.info("**    PathInfo/Trans : " + Request.getPathInfo() + " | " + Request.getPathTranslated());
        LOG.info("**    Servlet/CtxPath: " + Request.getServletPath() + " | " + Request.getContextPath());
          {
            LOG.info("**    Headers:");
            Enumeration<String> HeaderNames = Request.getHeaderNames();
            while (HeaderNames.hasMoreElements())
              {
                String Name = HeaderNames.nextElement();
                Enumeration<String> Headers = Request.getHeaders(Name);
                while (Headers.hasMoreElements())
                  LOG.info("**       " + Name + ": " + Headers.nextElement());
              }
          }
          {
            LOG.info("**    Parameters:");
            Enumeration<String> ParamNames = Request.getParameterNames();
            while (ParamNames.hasMoreElements() == true)
              {
                String p = (String) ParamNames.nextElement();
                String pLowerCase = p.toLowerCase();
                String[] Vals = Request.getParameterValues(p);
                for (String v : Vals)
                  {
                    if (pLowerCase.indexOf("password") != -1 || pLowerCase.indexOf("pswd") != -1)
                      v = "****";
                    LOG.info("**       " + p + "= " + v);
                  }
              }
          }
        LOG.info("********************************************************************************************************************************************");
      }	  
}
