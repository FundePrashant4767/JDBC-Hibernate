package jdbc_wejm5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. LOAD OR REGISTER DRIVER.
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish Connection.
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		//3. Create Statment
		Statement statement=connection.createStatement();
		//4. Execute Statment
		statement.execute("INSERT INTO user VALUES(6,'AMOL','8551041584','amol@gmail.com.com','A.Nagar')");
		//5.Close Connection
		connection.close();
	}
}
