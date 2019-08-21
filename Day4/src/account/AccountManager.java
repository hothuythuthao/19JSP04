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
		int tmp = 0;
		int accountID = Input.inputAccountID();
		double money = Input.inputWithdraw();
		for(Account account : accountList) {
			if(accountID == account.getAccountID()) {
				account.withdraw(accountID, money);
				if(account.withdraw(accountID, money) == true) {
					tmp = 1;
				}
				else {
					tmp = -1;
				}
			}
		}
		if(tmp == 1) {
			System.out.println("\n--Successful transaction.");
		}
		else if(tmp == -1) {
			System.out.println("\n--Transaction failed. Available balance in the account is less than 50000.");
		}
		else {
			System.out.println("\n--Account ID does not exist.");
		}
	}
	
	public static void Deposit()	{
		int tmp = 0;
		double m = 0;
		int accountID = Input.inputAccountID();
		double money = Input.inputDeposit();
		for(Account account : accountList) {
			account.deposit(accountID, money);
			if(accountID == account.getAccountID())	{
				tmp += 1;
				m = account.getAccountBalance();
			}
		}
		
		if(tmp == 1)	{
			System.out.println("--Successful transaction.");
			System.out.print("--The balance in the account is " + m);
		}
		else	{
			System.out.println("--Account ID does not exist.");
		}
	}
	
	public static void QueryBalance()	{
		int tmp = 0;
		double m = 0;
		int accountID = Input.inputAccountID();
		for(Account account : accountList) {
			account.queryBalance(accountID);
			if(accountID == account.getAccountID())	{
				tmp += 1;
				m = account.getAccountBalance();
			}
		}
		
		if(tmp == 1)	{
			System.out.print("--The balance in the account is " + m);
		}
		else	{
			System.out.println("--Account ID does not exist.");
		}
	}
	
	public static void Login()	{
		int tmp = 0;
		String accountName = Input.inputAccountName();
		String accountPassword = Input.inputAccountPassword();
		for(Account account : accountList) {
			account.login(accountName, accountPassword);
			if(accountName.equals(account.getAccountName()) == true && accountPassword.equals(account.getAccountPassword()) == true)	{
				tmp += 1;
			}
		}
		if(tmp == 1)	{
			System.out.println("--Logged in successfully.");
		}
		else	{
			System.out.println("--Account or password is incorrect.");
		}
	}
	
	public static void Logout()	{
		int tmp = 0;
		String accountName = Input.inputAccountName();
		for(Account account : accountList) {
			account.logout(accountName);
			if(accountName.equals(account.getAccountName()) == true)	{
				tmp += 1;
			}
		}
		if(tmp == 1)	{
			System.out.println("--Successful logout.");
		}
		else	{
			System.out.println("--Account name does not exist.");
		}
	}

}
