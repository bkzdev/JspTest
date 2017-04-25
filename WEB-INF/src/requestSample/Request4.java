package requestSample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/request/index7.html
 */
public class Request4 extends HttpServlet {

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
		sb.append("getScheme:");
		sb.append(req.getScheme());
		sb.append("</p>");

		sb.append("<p>");
		sb.append("getProtocol:");
		sb.append(req.getProtocol());
		sb.append("</p>");

		sb.append("<p>");
		sb.append("getMethod:");
		sb.append(req.getMethod());
		sb.append("</p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new StringBuffer(sb));
		out.close();

	}

}
