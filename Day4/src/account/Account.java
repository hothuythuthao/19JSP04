package account;

public class Account {
	private int accountID;
	private String accountName;
	private String accountPassword;
	
	public Account() {
		super();
	}

	public Account(int accountID, String accountName, String accountPassword) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + accountName + ", accountPassword="
				+ accountPassword + "]";
	}
	
}
