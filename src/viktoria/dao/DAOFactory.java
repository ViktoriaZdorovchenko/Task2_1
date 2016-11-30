package viktoria.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory {
	public Connection getConnection() throws SQLException;
	public IAccountDAO getIAccountDAO(Connection connection);
	public ICreditCardDAO getICreditCardDAO(Connection connection);
	public ITransactionDAO getITransactionDAO(Connection connection);
}
