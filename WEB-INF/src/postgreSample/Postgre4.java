package postgreSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/database/index7.html
 * UPDATEコマンド
 */
public class Postgre4 extends HttpServlet {

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

		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/jdbctestdb";
		String user = "testuser";
		String password = "testpass";

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();

			String sql = "update kabukatable set company='楽天（株）' where code = 4755";
			int num = stmt.executeUpdate(sql);

			out.println("<p>");
			out.println("楽天 > 楽天（株） result:" + num);
			out.println("</p>");

			sql = "SELECT * FROM kabukatable";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int code = rs.getInt("code");
				String company = rs.getString("company");
				out.println("<p>");
				out.println("コード:" + code + ", 会社名:" + company);
				out.println("</p>");
			}

			rs.close();
			stmt.close();

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
				}
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
			}
		}

		out.println("</body>");
		out.println("</html>");
	}
}
