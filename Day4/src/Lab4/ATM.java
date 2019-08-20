package Lab4;

public interface ATM {
	boolean withdraw(int accountID, double money);
	boolean deposit(int accountID, double money);
	double queryBalance(int accountID);
	boolean login(String account, String password);
	boolean logout(String account);
}
