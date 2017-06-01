package postgreSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/database/index5.html
 */
public class Postgre2 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>データベーステスト</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<p>");

		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/jdbctestdb";
		String user = "testuser";
		String password = "testpass";
//	エラー確認用
//		String url = "jdbc:postgresql://localhost:5432/jdbctestdb2";
//		String user = "testuser2";
//		String password = "testpass2";

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			out.println("ドライバのロードに成功しました<br>");

			conn = DriverManager.getConnection(url, user, password);
			out.println("データベース接続に成功しました<br>");
		} catch (ClassNotFoundException e) {
			out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			out.println("Exception:" + e.getMessage());
		} finally {
			//Connectionを確実に切断するためfinallyに書く
			try {
				if(conn != null){
					conn.close();
					out.println("データベース切断に成功しました");
				}else{
					out.println("コネクションがありません");
				}
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
			}
		}

		out.println("</p>");

		out.println("</body>");
		out.println("</html>");
	}
}
