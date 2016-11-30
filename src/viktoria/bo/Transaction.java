package viktoria.bo;

public class Transaction {
	private int transaction_id;
	private int from_card;
	private int to_card;
	private int amount;
	
	public Transaction(int transaction_id, int from_card,  int to_card, int amount){
		this.transaction_id=transaction_id;
		this.from_card=from_card;
		this.to_card=to_card;
		this.amount=amount;
	}


	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getFrom_card() {
		return from_card;
	}
	public void setFrom_card(int from_card) {
		this.from_card = from_card;
	}
	public int getTo_card() {
		return to_card;
	}
	public void setTo_card(int to_card) {
		this.to_card = to_card;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
