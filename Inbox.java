	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	import java.sql.*;

	public class Inbox extends HttpServlet
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
	HttpSession hs=req.getSession();
	pw.println("<html><body > Session value is : "+hs.getValue("username"));
	
	

	try
	{
	rs=st.executeQuery("select * from mail where receiver='"+hs.getValue("username")+"'");
	int i=0;
	pw.println("<form method='post' action='http://localhost:8080/examples/servlets/servlet/Delete'>");
	pw.println("<br><br><center><table border=1 bgcolor=pink> ");
	pw.println("<th><font color='white' face='comic sans ms'>Delete</th>");
	pw.println("<th><font color='white' face='comic sans ms'>From.......</th>");
	pw.println("<th><font color='white' face='comic sans ms'>Subject.......</th><tr>");

	while(rs.next())
	{
	i++;
	int idd=rs.getInt("id");
	pw.println("<td><font color=black><input type=checkbox name=d"+i+" value="+idd+"></font></td>");
	pw.println("<td><font color=black>"+rs.getString("sender")+"</td>");
	pw.println("<td><a href='http://localhost:8080/examples/servlets/servlet/Show?val="+idd+"'><font color=black>"+rs.getString("subject")+"</a></td><tr><tr>");
	

	}
	pw.println("<td></td><td><input type=submit value='delete'></td>");
	pw.println("<input type='hidden' name='val' value="+i+">");
	pw.println("</table></center></form>");
	}
	catch(Exception e)
	{
	}
	}
	}