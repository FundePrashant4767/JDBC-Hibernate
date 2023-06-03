package jdbc_wejm5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserFetch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/user?user=root&password=root";
		//   String userName="root";
		//   String password="root";
		String query="SELECT * FROM user";
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println("************ USER DETAIL'S *************");
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("**************************************************************");
			
		}
		connection.close();
	}
}
