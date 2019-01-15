	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class GetCook extends HttpServlet
	{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	pw.println("<html><body>");
	
	Cookie[] cookies=req.getCookies();
	
	for(int i=0;i<cookies.length;i++)
	{
	pw.println(cookies[i].getName());
	pw.println(cookies[i].getValue());
	}
	}
	}