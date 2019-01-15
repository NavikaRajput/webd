	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Delete extends HttpServlet
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
	try
	{
	int i,num,a=0;
	String ii=req.getParameter("val");
	String dd;
	num=Integer.parseInt(ii);
	for(a=1;a<=num;a++)
	{
		dd=req.getParameter("d"+a);
		if(dd != null)
		{
		i=Integer.parseInt(dd);
		st.executeUpdate("delete from mail where id="+i);
		
		}
	}
	res.sendRedirect("http://localhost:8080/examples/servlets/servlet/Inbox");

	}
	catch(Exception e)
	{
	}
	}
	}