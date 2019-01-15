	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Show extends HttpServlet
	{
	Connection con;
	ResultSet rs;
	Statement st;
	public void init(ServletConfig c)throws ServletException
	{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jas","root","");
	st=con.createStatement();
	super.init(c);
	}
	catch(Exception e1)
	{
	}
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	pw.println("<html><body bgColor='black'>");
	
	try
	{
	String s=req.getParameter("val");
	rs=st.executeQuery("select * from mail where id="+Integer.parseInt(s));
	pw.println("<table width=75%>");
	if(rs.next())
	{
	pw.println("<td><font color=yellow face='comic sans ms'>from: "+rs.getString("sender")+"</td><tr>");
	pw.println("<td><font color=yellow face='comic sans ms'>Subject: "+rs.getString("subject")+"</td><tr>");
             pw.println("<td><TextArea rows=5 cols=30>"+rs.getString("message")+"</TextArea></td><tr>");
	}
	
	pw.println("<td><a href='http://localhost:8080/examples/servlets/servlet/Inbox'><font color=yellow face='comic sans ms'>back............</a></td>");
	pw.println("</table>");

		}
	catch(Exception e)
	{
	}
	}
	}