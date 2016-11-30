package viktoria.dao;

import java.sql.SQLException;
import java.util.List;

import viktoria.bo.Transaction;

public interface ITransactionDAO {
	public static void  insert(Transaction tr) throws SQLException {
	}
		
		public Transaction  read(int transaction_id) throws SQLException;
		
		public void update(Transaction tr) throws SQLException;
		
		public void delete (int transaction_id)throws SQLException;
		
		public List<Transaction>getAll() throws SQLException;	
}
