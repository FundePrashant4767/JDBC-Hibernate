package jdbc_wejm5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// 1. LOAD OR REGISTER DRIVER.
	Class.forName("com.mysql.cj.jdbc.Driver");
	//2.Establish Connection.
	Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
	//3. Create Statement
	Statement statement=connection.createStatement();
	//4. Execute Statement
	statement.execute("INSERT INTO EMPLOYEE VALUES (8,'jaydeep','wakad',50000,26)");
	//5.Close Connection
	connection.close();
}
}
