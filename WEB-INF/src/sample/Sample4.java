package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.HttpServletResponse.*;


/**
 * https://www.javadrive.jp/servlet/webxml/index5.html
 * sample4page.htmlを表示するつもりだったができない謎
 * →置き場所変えたら解決
 */
public class Sample4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		String tmp;

		String code = "";
		tmp = req.getParameter("code");
		if(tmp == null || tmp.length() == 0){
			code = "200";
		} else {
			code = tmp;
		}

		if(code.equals("200")){
			resp.setStatus(SC_OK);

			StringBuffer sb = new StringBuffer();

			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>サンプル</title>");
			sb.append("</head>");
			sb.append("<body>");

			sb.append("<p>200:SC_OK</p>");

			sb.append("</body>");
			sb.append("</html>");

			out.println(new String(sb));
			out.close();

		} else {
			if(code.equals("404")){
				resp.sendError(SC_NOT_FOUND, "見つかりません");
			} else if(code.equals("500")){
				resp.sendError(SC_INTERNAL_SERVER_ERROR);
			}
		}

	}

}
