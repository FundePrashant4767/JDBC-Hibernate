package jdbc_wejm5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.Load Driver
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/user";
		String userName="root";
		String password="root";
		String query="UPDATE user SET name='RAJ' WHERE id=1";
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url,userName,password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}

}
