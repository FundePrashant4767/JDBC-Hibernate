package jdbc_maven_callabel;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyFetchById {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER THE ID : ");
		int id = scanner.nextInt();

		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));


		CallableStatement callableStatement = connection.prepareCall("call companydb.company_fetch_id(?)");

		callableStatement.setInt(1, id);

		int count = callableStatement.executeUpdate();

		if (count == 1) {
			System.out.println("Successfuly Fetch");
		} else {
			System.out.println("Sorry Something went wrong..!!");
		}
		connection.close();
	}
}
