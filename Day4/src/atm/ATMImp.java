package atm;

import Lab6.ATM;

public class ATMImp implements ATM {
	
	private int atmID;
	private int accountID;
	
	public ATMImp() {
		super();
	}
	
	public ATMImp(int atmID, int accountID) {
		super();
		this.atmID = atmID;
		this.accountID = accountID;
	}

	public int getAtmID() {
		return atmID;
	}

	public void setAtmID(int atmID) {
		this.atmID = atmID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Override
	public boolean withdraw(int accID, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(int accID, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double queryBalance(int accID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout(String account) {
		// TODO Auto-generated method stub
		return false;
	}

}
