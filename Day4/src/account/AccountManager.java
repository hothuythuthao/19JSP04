package account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	public static Scanner sc = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<>();

	public static void addNewAccount() {
		int accountID = (accountList.size() > 0) ? (accountList.size() + 1) : 1;
		System.out.println("\n--Account ID : " + accountID);
		String accountName = Input.inputAccountName();
		String accountPassword = Input.inputAccountPassword();
		double accountBalance = Input.inputAccountBalance();
		Account account = new Account(accountID, accountName, accountPassword, accountBalance);
		accountList.add(account);
	}
	
	public static void displayAccountList() {
		if (accountList.size() == 0) {
			System.out.println("\n--Account list is NULL!");
		} else {
			System.out.printf("\n%-14s %-24s %-19s %-20s", "Account ID", "Account name", "Account password", "Account balance");
			System.out.println();
			for (Account account : accountList) {
				System.out.printf("%-15d", account.getAccountID());
				System.out.printf("%-25s", account.getAccountName());
				System.out.printf("%-20s", account.getAccountPassword());
				System.out.printf("%-20s", account.getAccountBalance());
				System.out.println();
			}
		}
	}
	
	public static void Withdraw()	{
		int accountID = Input.inputAccountID();
		double money = Input.inputWithdraw();
		for(Account account : accountList) {
			account.withdraw(accountID, money);
		}
	}
	
	public static void Deposit()	{
		int accountID = Input.inputAccountID();
		double money = Input.inputDeposit();
		for(Account account : accountList) {
			account.deposit(accountID, money);
		}
	}
	
	public static void QueryBalance()	{
		int accountID = Input.inputAccountID();
		for(Account account : accountList) {
			account.queryBalance(accountID);
		}
	}
	
	public static void Login()	{
		String accountName = Input.inputAccountName();
		String accountPassword = Input.inputAccountPassword();
		for(Account account : accountList) {
			account.login(accountName, accountPassword);
		}
	}
	
	public static void Logout()	{
		String accountName = Input.inputAccountName();
		for(Account account : accountList) {
			account.logout(accountName);
		}
	}

}
