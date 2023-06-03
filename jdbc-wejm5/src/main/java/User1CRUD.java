import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class User1CRUD {

	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("dbconfiguration.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void signupUser(User user1) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSER INTO user1(ID,NAME,EMAIL,PASSWORD,ADDRESS) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user1.getId());
		preparedStatement.setString(2, user1.getName());
		preparedStatement.setString(3, user1.getEmail());
		preparedStatement.setString(4, user1.getPassword());
		preparedStatement.setString(5, user1.getAddress());
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Signed up Succesfully..!!");

		} else {
			System.out.println("Failed to Sign Up..!!");
		}
		connection.close();
	}

	public boolean loginUser(User user1) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=?");
		preparedStatement.setString(1, user1.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getNString("password");

		}
		connection.close();
		if (password.equals(user1.getPassword())) {
			return true;
		}
		return false;

	}
	public  void displayPassword(String email) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(" SELECT * FROM USER1 WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("The Saved Passwords are : ");
			System.out.println("Facebook :"+resultSet.getString("facebook"));
			System.out.println("WhatsApp :"+resultSet.getString("whatsapp"));
			System.out.println("Snapchat :"+resultSet.getString("snapchat"));
			System.out.println("Twitter :"+resultSet.getString("twitter"));
			System.out.println("Instagram :"+resultSet.getString("instagram"));
			
		}
		connection.close();
	}
	public void updatePassword(User user1) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET FACEBOOK=?,WHATSAPP=?,SNAPCHAT=?,TWITTER=?,INSTAGRAM=? WHERE EMAIL=?");
		preparedStatement.setString(1, FACEBOOK());
		preparedStatement.setString(2,WHATSAPP());
		preparedStatement.setString(3, SNAPCHAT());
		preparedStatement.setString(4, TWITER());
		preparedStatement.setString(5, INSTAGRAM());
		



	}

	private String INSTAGRAM() {
		// TODO Auto-generated method stub
		return null;
	}

	private String TWITER() {
		// TODO Auto-generated method stub
		return null;
	}

	private String SNAPCHAT() {
		// TODO Auto-generated method stub
		return null;
	}

	private String EMAIL() {
		// TODO Auto-generated method stub
		return null;
	}

	private String WHATSAPP() {
		// TODO Auto-generated method stub
		return null;
	}

	private String FACEBOOK() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
