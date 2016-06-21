package tilda.grammar.servlets;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.grammar.ColDefs;
import tilda.grammar.TildaSQL;
import tilda.grammar.TildaSQLValidator;
import tilda.types.ColumnDefinition;
import tilda.utils.AnsiUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.HttpStatus;
import tilda.utils.SystemValues;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@WebServlet(value="/svc/TildaSQLValidator/colDef")
public class TildaSQLInit extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7106320250739764659L;
	/**
	 * 
	 */


	protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());
	  TildaSQLValidator _Validator;
	  JsonObject json = new JsonObject();
	  public void init() throws ServletException{}
	  public void doPost(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  LogRequestHeader(21, request);
		  String jsonStr = request.getParameter("payload");
		  JsonElement jelement = new JsonParser().parse(jsonStr);
		  JsonArray jArr = jelement.getAsJsonArray();
		  for(JsonElement obj : jArr){
			  JsonObject jsonObj       = (JsonObject)obj;
			  String     _ColName      = jsonObj.get("name").getAsString();
			  ColumnType _Type         = ColumnType.valueOf(jsonObj.get("type").getAsString());
			  String     _Description  = jsonObj.get("desc").getAsString();
			  boolean    _Multi        = Boolean.parseBoolean(jsonObj.get("name").getAsString());
			  boolean    _Nullable     = Boolean.parseBoolean(jsonObj.get("nullable").getAsString());

			  ColDefs._COLS.add(ColumnDefinition.Create(_ColName, _Type, _Multi, _Nullable, _Description));
		  }
		  response.setStatus(HttpStatus.OK._Code);
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
