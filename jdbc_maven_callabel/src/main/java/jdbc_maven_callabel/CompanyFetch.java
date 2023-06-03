package jdbc_maven_callabel;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import com.mysql.cj.jdbc.CallableStatement;

public class CompanyFetch {

	public static void main(String[] args) throws Exception {
		String query = "select * from company";
		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		CallableStatement callableStatement = (CallableStatement) connection
				.prepareCall("select * from company.company_fetch()");
		ResultSet resultSet = callableStatement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println("**************************************************************");

			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getLong(5));

			System.out.println("**************************************************************");

		}

		connection.close();
	}

}
