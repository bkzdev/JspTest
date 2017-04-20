package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/ini/index5.html
 *
 */
public class Sample2 extends HttpServlet {

	int count = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = resp.getWriter();

		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>サンプル</title>");
		sb.append("</head>");
		sb.append("<body>");

		count++;
		sb.append("<p>訪問人数:");
		sb.append(count);
		sb.append("</p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new String(sb));

		out.close();
	}

}
