package requestSample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request3 extends HttpServlet {

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
		sb.append("getRequestURL:");
		sb.append(new String(req.getRequestURL()));
		sb.append("</p>");

		sb.append("<p>");
		sb.append("getRequestURI:");
		sb.append(new String(req.getRequestURI()));
		sb.append("</p>");

		sb.append("<p>");
		sb.append("getServletPath:");
		sb.append(new String(req.getServletPath()));
		sb.append("</p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new String(sb));

		out.close();

	}

}
