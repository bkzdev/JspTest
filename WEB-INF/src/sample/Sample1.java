package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/ini/index4.html
 *
 */
public class Sample1 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = resp.getWriter();

		out.println(createHTML("GET"));

		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = resp.getWriter();

		out.println(createHTML("POST"));

		out.close();
	}

	protected String createHTML(String methodType) {
		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>サンプル</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<p>");
		sb.append(methodType);
		sb.append("メソッドで呼び出されました</p>");

		sb.append("<p><a href=\"/sample/Sample1\">リンク</a></p>");

		sb.append("<form action=\"/sample/Sample1\" method=\"get\">");
		sb.append("<input type=\"submit\" value=\"GETで送信\">");
		sb.append("</form>");

		sb.append("<form action=\"/sample/Sample1\" method=\"post\">");
		sb.append("<input type=\"submit\" value=\"POSTで送信\">");
		sb.append("</form>");

		sb.append("</body>");
		sb.append("</html>");

		return (new String(sb));

	}

}
