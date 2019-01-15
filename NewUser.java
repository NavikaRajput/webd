	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class NewUser extends HttpServlet
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
	
	pw.println("<html><body bgColor='blue'>");
	
	String name=req.getParameter("t1");
	String pass=req.getParameter("t2");
	String hq=req.getParameter("t3");
	String ha=req.getParameter("t4");

	try
	{
	rs=st.executeQuery("select userid from table1 where userid='"+name+"'");
	if(rs.next())
	{
	pw.println("<a href='http://localhost:8080/examples/servlets/newUser.html'><font face='comic sans ms' color='lime'>This id allready exist plz try another</a>");
	}
	else
	{
	st.executeUpdate("Insert into table1 values('"+name+"','"+pass+"','"+hq+"','"+ha+"')");
	pw.println("<a href='http://localhost:8080/examples/servlets/login.html'><font face='comic sans ms' color='lime'>Your id created plz login now...</a>");

	}
	}
	catch(Exception e)
	{
	}
	}
	}
