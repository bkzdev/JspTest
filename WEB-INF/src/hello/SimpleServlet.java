package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 *http://www.whitemark.co.jp/tec/webapp/eclipseWebApp.html
 */
public class SimpleServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=Shift_JIS");

		//HTML出力用 PrintWriter
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<H1>");
		out.println("Hello!");
		out.println("<H1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
/*
web.xml
<?xml version="1.0" encoding="ISO-8859-1"?>

<!DOCTYPE web-app
	PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
	"http://java.sun.com/dtd/web-app_2_3.dtd">

<web-app>
	<servlet>
		<servlet-name>Simple</servlet-name>
		<servlet-class>hello.SimpleServlet</servlet-class></servlet>
	<servlet-mapping>
		<servlet-name>Simple</servlet-name>
		<url-pattern>/SimpleServlet</url-pattern></servlet-mapping></web-app>
*/