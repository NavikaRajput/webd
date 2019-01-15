	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Compose extends HttpServlet
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
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	pw.println("<html><body>");
	
	HttpSession hs=req.getSession();
	String n=req.getParameter("t1");
	String n1=req.getParameter("t2");
	String n2=req.getParameter("t3");
	pw.println(n);
	try
	{
	
	rs=st.executeQuery("select userid from table1 where userid='"+n+"'");
	pw.println("Bye");
	if(rs.next())
	{
	
	st.executeUpdate("Insert into mail (receiver,sender,subject,message) values('"+n+"','"+hs.getValue("username")+"','"+n1+"','"+n2+"')");
	pw.println("<a href='http://localhost:8080/examples/servlets/compose.html'><font face='comic sans ms' color='lime'>Mail sent go Back....</font></a>");

	}
	else
	{
	pw.println("<a href='http://localhost:8080/examples/servlets/compose.html'><font face='comic sans ms' color='lime'>Sorry invalid id</font></a>");
	}
	}
	catch(Exception e)
	{
	}
	}
	}