	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Change extends HttpServlet
	{
	Connection con;
	ResultSet rs;
	Statement st;
	public void init(ServletConfig c)throws ServletException
	{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jas","root","navika1997");
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
	
	String oldpass=req.getParameter("t1");
	String newpass=req.getParameter("t2");

	HttpSession hs=req.getSession();
	try
	{
	rs=st.executeQuery("select * from table1 where userid='"+hs.getValue("username")+"' and password='"+oldpass+"'");	
	if(rs.next())
	{
	st.executeUpdate("update table1 set password='"+newpass+"' where userid='"+hs.getValue("username")+"'");
	pw.println("<a href='http://localhost:8080/examples/servlets/login.html'><font face='comic sans ms' color='lime'>Password updated successfully user</font></a>");
	}
	else
	{
	pw.println("<a href='http://localhost:8080/examples/servlets/change.html'><font face='comic sans ms' color='lime'>Sorry u r not a valid user</font></a>");
	}
	}
	catch(Exception e)
	{
	}
	}
	}
