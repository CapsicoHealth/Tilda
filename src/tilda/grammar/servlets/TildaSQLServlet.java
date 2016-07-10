package tilda.grammar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;
import tilda.utils.AnsiUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.HttpStatus;
import tilda.utils.SystemValues;

@WebServlet(value = "/svc/TildaSQLValidator/lint")
public class TildaSQLServlet extends HttpServlet
  {
    /**
    * 
    */

    private static final long     serialVersionUID = 1181688239603166570L;
    protected static final Logger LOG              = LogManager.getLogger(TildaSQLServlet.class.getName());
    TildaSQLValidator             _Validator;
    JsonObject                    json             = new JsonObject();

    public void init()
    throws ServletException
      {
      }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
      {
        LogRequestHeader(20, request);

        PrintWriter _PrintWriter = response.getWriter();
        String Expr = request.getParameter("expr");
        _Validator = new TildaSQLValidator(Expr);
        String ColDefsStr = request.getParameter("colDefsJson");
        try
          {
            _Validator.setColumnEnvironment(ColDefJson.fromJSON(ColDefsStr));
          }
        catch (Exception e)
          {
            e.printStackTrace();
            return;
          }

        if (_Validator.getParserSyntaxErrors() == 0)
          { // check for syntax error
            _Validator.validate();
            ErrorList errors = _Validator.getValidationErrors();
            if (errors.isEmpty() == false)
              {
                LOG.error("Some validation error(s) occur.");
                errors.toJSON(_PrintWriter);
                response.setStatus(HttpStatus.BadRequest._Code);
              }
            else
              {
                response.setStatus(HttpStatus.OK._Code);
              }
          }
        else
          {
            ErrorList errors = new ErrorList();
            errors.addError("SYNTAX Error...", 1, 1, Expr.length());
            errors.toJSON(_PrintWriter);
            response.setStatus(HttpStatus.BadRequest._Code);
          }


        response.setContentType("application/json");
      }


    public void destroy()
      {
      }

    private void LogRequestHeader(final long TransactionID, HttpServletRequest Request)
      {
        LOG.info(SystemValues.NEWLINEx2);
        LOG.info("********************************************************************************************************************************************");
        LOG.info("** " + AnsiUtil.NEGATIVE + "R E Q U E S T   #" + TransactionID + AnsiUtil.NEGATIVE_OFF + " - " + DateTimeUtil.printDateTime(ZonedDateTime.now()));
        LOG.info("**    RequestURL     : " + Request.getRequestURL() + "?" + Request.getQueryString());
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
