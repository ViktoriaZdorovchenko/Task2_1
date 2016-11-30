package viktoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import viktoria.bo.Credit_card;
import viktoria.connection.ConnectionFactory;

public class OracleCreditCardDAO implements ICreditCardDAO{
	private static   ConnectionFactory connectionfactory;
	public OracleCreditCardDAO(ConnectionFactory connectionfactory){
		OracleCreditCardDAO.connectionfactory=connectionfactory;
	}

	
	public static void insert(Credit_card cc) throws SQLException {
		 Connection connection = connectionfactory.getConnection();
		 try{
		String SQL="INSERT iNTO Credit_card(card_id,account_id,cash_amount) VALUES(seq_credit.nextval,?,?) ";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1,cc.getAccount_id());
		ps.setInt(2,cc.getCash_amount());
		ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
	
	}

	@Override
	public Credit_card read(int card_id) throws SQLException{
		Credit_card c= new Credit_card(card_id, 0, 0);
		Connection connection = connectionfactory.getConnection();
		try{
		String SQL="SELECT * FROM Credit_Card WHERE card_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, card_id);
	    ResultSet rs=ps.executeQuery();
		rs.next();
		c.setCard_id(rs.getInt("card_id"));
		c.setAccount_id(rs.getInt("account_id"));
		c.setCash_amount(rs.getInt("cash_amount"));
		  } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
		return c;
	}

	@Override
	public void update(Credit_card cc) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{String SQL="Update  Credit_card set account_id=?,cash_amount=? WHERE card_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, cc.getAccount_id());
		ps.setInt(2, cc.getCash_amount());
		 ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }	
		
	}

	
	public void delete(int card_id) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{
		String SQL="DELETE  FROM ACCOUNT WHERE card_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, card_id);
		   ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
		
	}

	@Override
	public List<Credit_card> getAll() throws SQLException {
		Connection connection = connectionfactory.getConnection();
		List<Credit_card>list=new ArrayList<Credit_card>();
		try{
					String SQL="Select * from Credit_Card";
			PreparedStatement ps=connection.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Credit_card c=new Credit_card(0, 0, 0);
				c.setCard_id(rs.getInt("card_id"));
				c.setAccount_id(rs.getInt("account_id"));
				c.setCash_amount(rs.getInt("cash_amount"));
				list.add(c);
		
	} 
			} catch (SQLException e) {
        System.out.println(e.getMessage());
    }
			return list;
	}
	

}
