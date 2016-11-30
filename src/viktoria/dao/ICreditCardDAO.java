package viktoria.dao;

import java.sql.SQLException;
import java.util.List;

import viktoria.bo.Credit_card;

public interface ICreditCardDAO {
	
 public static void insert(Credit_card credit)throws SQLException {
}
	public Credit_card read(int card_id) throws SQLException;
	
	public void update(Credit_card credit_card) throws SQLException;
	
	public void delete (int card_id)throws SQLException;
	
	public List<Credit_card>getAll() throws SQLException;	
}
