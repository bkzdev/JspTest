package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/response/index6.html
 * sample6page.htmlを表示するつもりだったができない謎
 */
public class Sample6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tmp;

		String url = "";
		tmp = req.getParameter("url");
		if(tmp == null || tmp.length() == 0){
			url = "http://www.excite.co.jp/";
		} else {
			url = "http://" + tmp;
		}

		resp.sendRedirect(url);
	}

}
