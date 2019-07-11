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
@WebServlet("/logout")
public class logout extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{  
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession(false);  
		session.invalidate();//invalidating session  
		out.print("You are successfully logged out");  
		ServletContext ctx=getServletContext();  
        int t=(Integer)ctx.getAttribute("totalusers");  
        int c=(Integer)ctx.getAttribute("currentusers"); 
		out.println("total users= "+t);
        out.println("current users= "+c);
		out.close();  
	}
}
