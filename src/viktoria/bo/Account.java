package viktoria.bo;

public class Account {
	
	private int account_id;
	private String first_name;
	private String last_name;
	private String country;
	
	
	public Account(int account_id, String first_name,  String last_name, String country){
		this.account_id=account_id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.country=country;
	}

	public int getaccount_id() {
		return account_id;
	}
	public void setaccount_Id(int account_id) {
		this.account_id = account_id;
	}
	public String getFirst_Name() {
		return first_name;
	}
	public void setFirst_Name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_Name() {
		return last_name;
	}
	public void setLast_Name(String last_name) {
		this.last_name = last_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	 
	    public String toString() {
	        return  account_id +
	                " " + first_name +
	                " " + last_name +
	                " " + country;
	    }

}
