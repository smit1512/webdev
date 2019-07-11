package session_listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/first")
public class first extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		try
		{
		String n=request.getParameter("username");  
        out.println("Welcome "+n);    
        HttpSession session=request.getSession();  
        session.setAttribute("uname",n); 
        ServletContext ctx=getServletContext();  
        int t=(Integer)ctx.getAttribute("totalusers");  
        int c=(Integer)ctx.getAttribute("currentusers"); 
        out.println("total users= "+t);
        out.println("current users= "+c);
        response.setContentType("text/html");
        out.print("<a href=\"logout\">logout</a>");
        out.close();  
		}catch(Exception e)
		{
			out.println(e.getMessage());
			HttpSession session=request.getSession(false); 
			session.invalidate();
		}
	}
}
