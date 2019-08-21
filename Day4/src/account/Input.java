package account;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);

	public static String inputAccountName() {
		System.out.print("--Input account name: ");
		return sc.nextLine();
	}
	
	public static String inputAccountPassword() {
		System.out.print("--Input account password: ");
		return sc.nextLine();
	}
	
	public static double inputAccountBalance() {
		System.out.print("--Input account balance: ");
		while (true) {
			try {
				double accountBalance = Double.parseDouble((sc.nextLine()));
				if (accountBalance < 50000) {
					throw new NumberFormatException();
				}
				return accountBalance;
			} catch (NumberFormatException ex) {
				System.out.println("\n--Invalid! The balance in the account must be more than 50000.");
				System.out.print("\n--Input account balance again: ");
			}
		}
	}
	
	public static int inputAccountID() {
		System.out.print("--Input account id: ");
		while (true) {
			try {
				int accountID = Integer.parseInt((sc.nextLine()));
				if (accountID <= 0) {
					throw new NumberFormatException();
				}
				return accountID;
			} catch (NumberFormatException ex) {
				System.out.println("\n--Invalid! The ID in the account must be more than 0.");
				System.out.print("\n--Input account ID again: ");
			}
		}
	}
	
	public static double inputWithdraw() {
		System.out.print("--Input the money you want to withdraw: ");
		while (true) {
			try {
				double money = Double.parseDouble((sc.nextLine()));
				if (money <= 0) {
					throw new NumberFormatException();
				}
				return money;
			} catch (NumberFormatException ex) {
				System.out.println("\n--Invalid! The money you want to withdraw must be more than 0.");
				System.out.print("\n--Input the money again: ");
			}
		}
	}
	
	public static double inputDeposit() {
		System.out.print("--Input the money you want to deposit: ");
		while (true) {
			try {
				double money = Double.parseDouble((sc.nextLine()));
				if (money <= 0) {
					throw new NumberFormatException();
				}
				return money;
			} catch (NumberFormatException ex) {
				System.out.println("\n--Invalid! The money you want to deposit must be more than 0.");
				System.out.print("\n--Input the money again: ");
			}
		}
	}
}
