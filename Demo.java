	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.*;
	
	public class Demo extends HttpServlet
	{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	pw.println("<html><head><title>Server's Response</title></head><body><font face='comic sans ms' color='red'>Bye world-------</font></body></html>");
	}
	}
	