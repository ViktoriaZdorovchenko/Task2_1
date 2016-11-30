package viktoria.bo;

public class Credit_card {
	private int card_id;
	private int account_id;
private int cash_amount;
public Credit_card(int card_id, int account_id,  int cash_amount){
	this.card_id=card_id;
	this. account_id= account_id;
	this.cash_amount=cash_amount;

}
	
	public int getCard_id() {
	return card_id;
}


public void setCard_id(int card_id) {
	this.card_id = card_id;
}


public int getAccount_id() {
return account_id;
}


public void setAccount_id(int account_id) {
this.account_id = account_id;
}


	public int getCash_amount() {
	return cash_amount;
}


public void setCash_amount(int cash_amount) {
	this.cash_amount = cash_amount;
}
}
