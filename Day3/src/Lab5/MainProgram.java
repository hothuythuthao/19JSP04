package Lab5;

import java.util.Scanner;

public class MainProgram {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String choose = null;

		displayMenu();
		while (true) {
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				EmployeeManager.addEmp();
				break;
			case "2":
				EmployeeManager.displayList();
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
		System.out.println("\n---------- MENU ----------");
		System.out.println("1. Create employee.");
		System.out.println("2. Show the existing employee.");
		System.out.println("0. Exit.");
		System.out.println("--------------------------");
		System.out.print("--Please choose: ");
	}
}
