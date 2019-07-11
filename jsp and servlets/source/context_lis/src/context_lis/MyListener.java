package context_lis;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent e)
	{
		try
		{
			System.out.println("i am initialised");
			Class.forName("oracle.jdbc.driver.OracleDriver");					
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "smit");
	        ServletContext ctx = e.getServletContext();
	        ctx.setAttribute("mycon",con);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void contextDestroyed(ServletContextEvent e)
	{
		System.out.println("Servlet Context listener destroyed ");
	}
}