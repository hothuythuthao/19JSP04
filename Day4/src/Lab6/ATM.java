package Lab6;

public interface ATM {
	boolean withdraw(int accID, double money);
	boolean deposit(int accID, double money);
	double queryBalance(int accID);
	boolean login(String account, String password);
	boolean logout(String account);
}
