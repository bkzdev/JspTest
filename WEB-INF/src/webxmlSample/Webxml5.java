package webxmlSample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/webxml/index11.html
 */
public class Webxml5 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		String ini = getInitParameter("zeiritsu");
		int zeiritsu = 0;

		if(ini == null){
			zeiritsu = 0;
		} else {
			zeiritsu = Integer.parseInt(ini);
		}
		int sale = 100000;

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>init-paramテスト</h1>");
		out.println("<p>");
		out.println("税率は" + zeiritsu + "%です。<br>");
		out.println("お買い上げ金額は" + sale + "です。<br>");
		sale = sale * (100+ zeiritsu) / 100;
		out.println("消費税込みの金額は" + sale + "です。");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
