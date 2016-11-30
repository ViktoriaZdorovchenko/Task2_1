package viktoria.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static final String url = "jdbc:oracle:thin:@//localhost:1521/pbasanew";
    public static final String user = "Viktoria";
    public static final String password = "oracle12c";

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found class " + driver, e);
        }
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user,password);
    }

	public static void close() {
		 ConnectionFactory.close();

		
	}
}
