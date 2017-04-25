package requestSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/request/index8.html
 * https://www.javadrive.jp/servlet/request/index9.html
 */
public class Request5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>テスト</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<p>");

		Enumeration headernames = req.getHeaderNames();
		while(headernames.hasMoreElements()){
			String name = (String)headernames.nextElement();
			Enumeration headervals = req.getHeaders(name);
			while(headervals.hasMoreElements()){
				String val = (String)headervals.nextElement();
				sb.append(name);
				sb.append(":");
				sb.append(val);
				sb.append("<br>");
			}
		}

		sb.append("<p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new String(sb));

		out.close();
	}

}
