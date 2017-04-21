package requestSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/request/index4.html
 * https://www.javadrive.jp/servlet/request/index5.html
 */
public class Request2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		req.setCharacterEncoding("Shift_JIS");

		StringBuffer sb = new StringBuffer();



		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>デバッグ</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<p>");

		Enumeration names = req.getParameterNames();
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String vals[] = req.getParameterValues(name);
			if(vals != null){
				for(int i=0;i<vals.length;i++){
					sb.append(name);
					sb.append(":");
					sb.append(vals[i]);
					sb.append("<br>");
				}
			}

		}

		sb.append("</p>");

		sb.append("</body>");
		sb.append("</html>");

		out.println(new String(sb));

		out.close();
	}
}
