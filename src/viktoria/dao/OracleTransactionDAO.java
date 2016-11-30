package viktoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import viktoria.bo.Transaction;
import viktoria.connection.ConnectionFactory;

public class OracleTransactionDAO implements ITransactionDAO{
	private static   ConnectionFactory connectionfactory;
	public OracleTransactionDAO(ConnectionFactory connectionfactory){
		OracleTransactionDAO.connectionfactory=connectionfactory;
	}
	
	
	
	public static void insert(Transaction tr) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		 try{
		String SQL="INSERT iNTO Transaction(transaction_id,from_card,to_card,amount) VALUES(seq_transact.nextval,?,?,?) ";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1,tr.getFrom_card());
		ps.setInt(2,tr.getTo_card());
		ps.setInt(3,tr.getAmount());
		ps.execute();
   } catch (SQLException e) {
       System.out.println(e.getMessage());
   }
		
	}
@Override
	public Transaction read(int transaction_id) throws SQLException {
		Transaction tr= new Transaction(transaction_id,0,0,0);
		Connection connection = connectionfactory.getConnection();
		try{
			String SQL="SELECT * FROM Transaction WHERE transaction_id=?";
		
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, transaction_id);
	    ResultSet rs=ps.executeQuery();
		rs.next();
		tr.setTransaction_id(rs.getInt("transaction_id"));
		tr.setFrom_card(rs.getInt("from_card"));
		tr.setTo_card(rs.getInt("to_card"));
		tr.setAmount(rs.getInt("amount"));
		  } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
	return tr;
		
				
	}

	@Override
	public void update(Transaction tr) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{String SQL="Update  Transaction set from_card=?,to_card=?,amount=? WHERE transaction_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, tr.getFrom_card());
		ps.setInt(2, tr.getTo_card());
		ps.setInt(2, tr.getAmount());
		 ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }	
		
	}

	public void delete(int transaction_id) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{
		String SQL="DELETE  FROM Transaction WHERE transaction_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, transaction_id);
		   ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
		
	}

	@Override
	public List<Transaction> getAll() throws SQLException {
		Connection connection = connectionfactory.getConnection();
		List<Transaction>list=new ArrayList<Transaction>();
		try{
					String SQL="Select * from Transaction";
			PreparedStatement ps=connection.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Transaction tr=new Transaction(0,0,0,0);
				tr.setTransaction_id(rs.getInt("transaction_id"));
				tr.setFrom_card(rs.getInt("from_card"));
				tr.setTo_card(rs.getInt("to_card"));
				tr.setAmount(rs.getInt("amount"));
				list.add(tr);
		
	} 
			} catch (SQLException e) {
        System.out.println(e.getMessage());
    }
			return list;
	}


}
