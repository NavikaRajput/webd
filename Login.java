	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Login extends HttpServlet
	{
	Connection con;
	ResultSet rs;
	Statement st;
	public void init(ServletConfig c)throws ServletException
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jas","root","navika99");
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

	HttpSession hs=req.getSession();
	hs.putValue("username",name);
	try
	{
	rs=st.executeQuery("select userid,password from table1 where userid='"+name+"' and password='"+pass+"'");
	if(rs.next())
	{
	res.sendRedirect("http://localhost:8080/examples/servlets/valid.html");
	}
	else
	{
	pw.println("<center><a href='http://localhost:8080/examples/servlets/login.html'><font face='comic sans ms' color='lime'>Sorry u r not a valid user plz try again</a></center>");
	}
	}
	catch(Exception e1)
	{
	}
	}
	}
