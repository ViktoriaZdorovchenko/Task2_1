package viktoria.dao;

import java.sql.SQLException;
import java.util.List;

import viktoria.bo.Account;
public interface IAccountDAO {
public static void  insert(Account ac) {
}
		public Account read(int account_id) throws SQLException ;
		public void update(Account ac) throws SQLException; 
		public void delete (int account_id)throws SQLException;
		public  List<Account> getAll() throws SQLException;
		
}
