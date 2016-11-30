package viktoria.dao;
import java.util.Random;

import viktoria.bo.Account;
import viktoria.bo.Credit_card;
import viktoria.bo.Transaction;
import viktoria.connection.ConnectionFactory;

public class Main {
	public static void main(String[] args)  {}
	
		private static IAccountDAO accountDAO=null;
	
	
	static {
		accountDAO=new OracleAccountDAO(( ConnectionFactory.getInstance()));
	

		try{String st[]={"qsdvf","qwert","dsffdg","zxsaq","hdghdg","dfsfs"};
		for( int i=0;i<=1000;i++) {
			Account acc=new Account(i,st[new Random().nextInt(st.length)],st[new Random().nextInt(st.length)],st[new Random().nextInt(st.length)]);
			OracleAccountDAO.insert( acc);
			}
		
		for (Account Account: accountDAO.getAll()){
			System.out.println(Account);
			
		}
				
		 } catch (Exception e){
	            e.printStackTrace();
		 }
		
	
	}	
	private static ICreditCardDAO cardDAO=null;
	static {cardDAO=new OracleCreditCardDAO(( ConnectionFactory.getInstance()));
	
		try{
	
	     for (int i=0;i<1000;i++){
	    	 	Credit_card credit =new Credit_card(i,new Random().nextInt(1000),new Random().nextInt(1000000));
       OracleCreditCardDAO.insert(credit);
	     } 
	     for (Credit_card card: cardDAO.getAll()){
				System.out.println(card);} 
		}catch (Exception e){
	            e.printStackTrace();
		}
	
}
	private static ITransactionDAO transactDAO=null;
	static {transactDAO=new OracleTransactionDAO(( ConnectionFactory.getInstance()));
	
		try{
	
	     for (int i=0;i<1000;i++){
	    	 	Transaction transact =new Transaction(i,new Random().nextInt(1000),new Random().nextInt(1000),new Random().nextInt(100000));
       OracleTransactionDAO.insert(transact);
	     } 
	     for (Transaction transact: transactDAO.getAll()){
				System.out.println(transact);} 
		}catch (Exception e){
	            e.printStackTrace();
		}
	}	
}
