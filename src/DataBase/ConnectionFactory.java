package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class ConnectionFactory {

	 public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	 public static final String USER = "system";
	 public static final String PASSWORD = "khalid";
	 public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver"; 

	private ConnectionFactory() throws SQLException {
	}

	private static Connection conn = null;

	public static Connection getInstance() {

		if (conn == null)
			try {
				Class.forName(DRIVER_CLASS);
				return conn = DriverManager.getConnection(URL,USER, PASSWORD);
	
			} catch (ClassNotFoundException e) {
				System.err.println(e.getCause());
			} catch (SQLException e) {
				System.err.println(e.getCause());
			}
		return conn;
	}
}

