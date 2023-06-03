package jdbc_maven_callabel;

import java.io.FileInputStream;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.util.Properties;

import java.util.Scanner;

//

public class CompanyUpdate {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("ENTER THE NAME : ");

		String name = scanner.next();

		System.out.println("ENTER THE GST : ");

		String gst = scanner.next();
		System.out.println("ENTER THE Address : ");

		String address = scanner.next();

		System.out.println("ENTER THE PHONE : ");

		long phone = scanner.nextLong();

		System.out.println("ENTER THE ID : ");

		int id = scanner.nextInt();

		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");

		Properties properties = new Properties();

		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),

				properties.getProperty("user"), properties.getProperty("password"));

// CallableStatement callableStatement = (CallableStatement) connection.prepareCall("call companydb.company_insert(?,?,?,?,?)");

// CallableStatement callableStatement = connection.prepareCall("call companydb.company_insert(?,?,?,?,?)");

		CallableStatement callableStatement = connection.prepareCall("call companydb.company_update(?,?,?,?,?)");

		callableStatement.setString(2, name);

		callableStatement.setString(3, gst);
		callableStatement.setString(4, address);

		callableStatement.setLong(5, phone);

		callableStatement.setInt(1, id);

		int count = callableStatement.executeUpdate();

		if (count == 1) {

			System.out.println("Updated");

		} else {

			System.out.println("Not Updated");

		}

	}

}
