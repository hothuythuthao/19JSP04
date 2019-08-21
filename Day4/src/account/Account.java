package account;

import Lab4.ATM;

public class Account implements ATM {
	private int accountID;
	private String accountName;
	private String accountPassword;
	private double accountBalance;

	public Account() {
		super();
	}

	public Account(int accountID, String accountName, String accountPassword, double accountBalance) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountBalance = accountBalance;
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

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + accountName + ", accountPassword="
				+ accountPassword + ", accountBalance=" + accountBalance + "]";
	}

	@Override
	public boolean withdraw(int accID, double money) {
		if(accID == accountID)	{
			if(accountBalance - money >= 50000)	{
				accountBalance = accountBalance - money;
				System.out.println("--Successful transaction.");
				System.out.print("--The balance in the account is " + accountBalance);
				return true;
			}
			else	{
				System.out.println("--Transaction failed. Available balance in the account is less than 50000.");
				return false;
			}
		}
		else	{
			System.out.println("--Account ID does not exist.");
			return false;
		}
	}

	@Override
	public boolean deposit(int accID, double money) {
		if(accID == accountID)	{
			accountBalance = accountBalance + money;
			System.out.println("--Successful transaction.");
			System.out.print("--The balance in the account is " + accountBalance);
			return true;
		}
		else	{
			System.out.println("--Account ID does not exist.");
			return false;
		}
	}

	@Override
	public double queryBalance(int accID) {
		if(accID == accountID)	{
			System.out.print("--The balance in the account is " + accountBalance);
			return accountBalance;
		}
		else
			System.out.println("--Account ID does not exist.");
			return 0;
	}

	@Override
	public boolean login(String account, String password) {
		if(account.equals(accountName) == true && password.equals(accountPassword) == true)	{
			System.out.println("--Logged in successfully.");
			return true;
		}
		else	{
			System.out.println("--Account or password is incorrect.");
			return false;
		}
	}

	@Override
	public boolean logout(String account) {
		if(account.equals(accountName) == true)	{
			System.out.println("--Successful logout.");
			return true;
		}
		else	{
			System.out.println("--Account name does not exist.");
			return false;
		}
	}

}
