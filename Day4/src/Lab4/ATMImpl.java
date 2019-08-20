package Lab4;

public class ATMImpl implements ATM {
	private int idATM;
	private int accountID;
	
	public ATMImpl() {
		super();
	}
	
	public ATMImpl(int idATM, int accountID) {
		super();
		this.idATM = idATM;
		this.accountID = accountID;
	}
	
	public int getIdATM() {
		return idATM;
	}

	public void setIdATM(int idATM) {
		this.idATM = idATM;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	@Override
	public String toString() {
		return "ATMImpl [idATM=" + idATM + ", accountID=" + accountID + "]";
	}

	@Override
	public boolean withdraw(int accountID, double money) {
		return false;
	}
	@Override
	public boolean deposit(int accountID, double money) {
		return false;
	}
	@Override
	public double queryBalance(int accountID) {
		return 0;
	}
	@Override
	public boolean login(String account, String password) {
		return false;
	}
	@Override
	public boolean logout(String account) {
		return false;
	}
	
	
}
