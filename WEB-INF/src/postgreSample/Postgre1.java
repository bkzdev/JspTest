package postgreSample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://www.javadrive.jp/servlet/database/index1.html
 * https://www.javadrive.jp/servlet/database/index2.html
 * JDBCドライバはTomcatのlibに入れる
 */
public class Postgre1 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("Shift_JIS");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>DBテスト</title>");
		out.println("</head>");
		out.println("<body>");

		String msg = "";
    	try {
			Class.forName("org.postgresql.Driver").newInstance();
			msg = "ドライバのロードに成功しました";
		} catch (ClassNotFoundException e) {
			msg = "ドライバのロードに失敗しました(1)";
			e.printStackTrace();
		} catch (Exception e){
			msg = "ドライバのロードに失敗しました(2)";
		}

		out.println("<p>");
		out.println(msg);
		out.println("</p>");

		out.println("</body>");
		out.println("</html>");

	}

	/*	    public static void main(String[] args) throws Exception {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;

	        try {
	            //-----------------
	            // 接続
	            //-----------------
	        	Class.forName("org.postgresql.Driver");		//◇◆こいつがいないと動かなかった
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
	                    "postgres", // ログインロール
	                    "sdd@0913"); // パスワード
	            statement = connection.createStatement();

	            //-----------------
	            // SQLの発行
	            //-----------------
	            //ユーザー情報のテーブル
	            resultSet = statement.executeQuery("SELECT * FROM pg_shadow");

	            //-----------------
	            // 値の取得
	            //-----------------
	            // フィールド一覧を取得
	            List<String> fields = new ArrayList<String>();
	            ResultSetMetaData rsmd = resultSet.getMetaData();
	            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	                fields.add(rsmd.getColumnName(i));
	            }

	            //結果の出力
	            int rowCount = 0;
	            while (resultSet.next()) {
	                rowCount++;

	                System.out.println("---------------------------------------------------");
	                System.out.println("--- Rows:" + rowCount);
	                System.out.println("---------------------------------------------------");

	                //値は、「resultSet.getString(<フィールド名>)」で取得する。
	                for (String field : fields) {
	                    System.out.println(field + ":" + resultSet.getString(field));
	                }
	            }


	        } finally {
	            //接続を切断する
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
*/
}
