package Lab5;

import java.util.Scanner;

public class WSEBank {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)	{
		String choose = null;

		displayMenu();
		while (true) {
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				account.AccountManager.addNewAccount();
				break;
			case "2":
				account.AccountManager.displayAccountList();
				break;
			case "3":
				account.AccountManager.Withdraw();
				break;
			case "4":
				account.AccountManager.Deposit();
				break;
			case "5":
				account.AccountManager.QueryBalance();
				break;
			case "6":
				account.AccountManager.Login();
				break;
			case "7":
				account.AccountManager.Logout();
				break;
			case "0":
				System.out.println("\n--Exited!");
				System.exit(0);
				break;
			default:
				System.out.println("\n--Invalid! Please choose action in below menu.");
				break;
			}
			displayMenu();
		}
	}
	
	public static void displayMenu() {
		System.out.println("\n--------------- MENU ---------------");
		System.out.println("1. Create a new account.");
		System.out.println("2. Display the list of created accounts.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Deposit.");
		System.out.println("5. Query Balance.");
		System.out.println("6. Login.");
		System.out.println("7. Logout.");
		System.out.println("0. Exit.");
		System.out.println("------------------------------------");
		System.out.print("--Please choose: ");
	}

}
