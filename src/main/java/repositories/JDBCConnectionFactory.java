package repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory {

	Properties credentialProps = null;
	Connection conn;

	public Connection createConnection() throws IOException {
		Properties credentialsProps = null;
		ClassLoader classLoader = getClass().getClassLoader();
		credentialsProps = new Properties();
		java.io.InputStream stream = classLoader.getResourceAsStream("credentials.properties");
		if (stream == null) {
			System.out.println("connection");
		}

		credentialsProps.load(stream);
		try {
			Class.forName(credentialsProps.getProperty("driver.name"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = credentialsProps.getProperty("connectionUrl");
		String user = credentialsProps.getProperty("userName");
		String password = credentialsProps.getProperty("password");

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}