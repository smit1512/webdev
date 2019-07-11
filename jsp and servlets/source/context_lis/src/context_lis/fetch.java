package context_lis;
import java.beans.Statement;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetch")
public class fetch extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		try
		{
			ServletContext ctx = getServletContext();
			Connection con = (Connection) ctx.getAttribute("mycon");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
	        //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "smit");
			/*
	        PreparedStatement ps=con.prepareStatement("select * from train",  
			ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);                
			ResultSet rs=ps.executeQuery(); 
			*/
			String sql="select * from train";
			java.sql.Statement stmt = con.createStatement();	
			ResultSet rs =  stmt.executeQuery(sql);
					while(rs.next())
					{  
					out.print("<br>"+rs.getInt(1)+" "+rs.getString(2));  
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
					} 
			//con.close();
		}catch(Exception e)
		{
			out.println("hi");
			out.println(e.getMessage());
		}
		
		
	}
}