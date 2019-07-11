package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/check")
public class check extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		Logger logger = Logger.getAnonymousLogger();
		logger.info("init called");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		String s1=req.getParameter("user");
		String s2=req.getParameter("pass");
		PrintWriter out = res.getWriter();
		if(s1.equals("smit") && s2.equals("smit"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");  
			rd.forward(req, res); 
		}
		else
		{
			out.println("invalid");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res); 
		}
	}
	public void destroy()
	{
		Logger logger = Logger.getAnonymousLogger();
		logger.info("destroy called");
	}
}
