package viktoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import viktoria.bo.Account;
import viktoria.connection.ConnectionFactory;

public class OracleAccountDAO implements IAccountDAO{
	private static   ConnectionFactory connectionfactory;
	public OracleAccountDAO(ConnectionFactory connectionfactory){
		OracleAccountDAO.connectionfactory=connectionfactory;
	}
	

	
	public static void  insert(Account ac) throws SQLException  {
		 Connection connection = connectionfactory.getConnection();
		 try{
		String SQL="INSERT iNTO ACCOUNT(account_id,first_name,last_name,country) VALUES(seq.nextval,?,?,?) ";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setString(1,ac.getFirst_Name());
		ps.setString(2,ac.getLast_Name());
		ps.setString(3,ac.getCountry());
		ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
	
		
	
	}

	@Override
	public Account read(int account_id) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		Account a= new Account(account_id, null, null, null);
		try{
		String SQL="SELECT * FROM ACCOUNT WHERE account_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, account_id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		
		a.setaccount_Id(rs.getInt("account_id"));
		a.setFirst_Name(rs.getString("first_name"));
		a.setLast_Name(rs.getString("last_name"));
		a.setCountry(rs.getString("country"));
		 } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
				
				return a;
	}

	@Override
	public void update(Account ac) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{String SQL="Update  ACCOUNT set first_name=?,last_name=?,country=? WHERE account_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setString(1, ac.getFirst_Name());
		ps.setString(2, ac.getLast_Name());
		ps.setString(3, ac.getCountry());
		ps.setInt(4, ac.getaccount_id());
	   ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
		
		
	}
	@Override
	public void delete(int account_id) throws SQLException {
		Connection connection = connectionfactory.getConnection();
		try{
		String SQL="DELETE  FROM ACCOUNT WHERE account_id=?";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ps.setInt(1, account_id);
		   ps.execute();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

	}

	
	public List<Account> getAll() throws SQLException {
		Connection connection = connectionfactory.getConnection();
		List<Account>list=new ArrayList<Account>();
		try{
		String SQL="Select * from Account";
		PreparedStatement ps=connection.prepareStatement(SQL);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Account a=new Account(0, SQL, SQL, SQL);
			a.setaccount_Id(rs.getInt("account_id"));
			a.setFirst_Name(rs.getString("first_name"));
			a.setLast_Name(rs.getString("last_name"));
			a.setCountry(rs.getString("country"));
			list.add(a);
		
		}
		 } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
		
		return list;
	}



	

	

}
