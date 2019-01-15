	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Store extends HttpServlet
	{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	pw.println("<html><body>");
	
	String data=req.getParameter("t1");
	
	Cookie cookie=new Cookie("mycookie",data);
	res.addCookie(cookie);
	
	pw.println("<a href='http://localhost:8080/examples/servlets/servlet/GetCook'>Get Cook</a>");
	}
	}