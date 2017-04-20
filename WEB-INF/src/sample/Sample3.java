package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/sample/Sample3
 *
 */
public class Sample3 extends HttpServlet {

	int count;

	public void init() throws ServletException{
		count = 100;
		log("カウント開始します");

	}

	public void destroy(){
		log("カウントの最終値は"+count+"でした");

	}

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
		sb.append("<p>訪問人数：");
		sb.append(count);
		sb.append("</p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new String(sb));

		out.close();
	}



}
