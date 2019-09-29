package MainPrograms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Customer;
import utils.Input;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String choose = null;

		displayMenu();
		while (true) {
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				AddCustomer();
				break;
			case "2":
				DeleteCustomer();
				break;
			case "3":
				UpdateCustomer();
				break;
			case "4":
				DisplayListCustomer();
				break;
			case "5":
				FindTheCustomerByName();
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
		System.out.println("1. Add new a customer.");
		System.out.println("2. Delete a customer by ID.");
		System.out.println("3. Update a customer by ID.");
		System.out.println("4. Show list customer.");
		System.out.println("5. Search a customer by Name.");
		System.out.print("--Please choose: ");
	}

	private static void AddCustomer() {
		Customer customer = new Customer();
		customer.setName(Input.inputName());
		customer.setAge(Input.inputAge());
		customer.setAddress(Input.inputAddress());
		customer.setSalary(Input.inputSalary());
		try {
			controller.CustomerController.AddNewCustomer(customer);
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void DeleteCustomer() {
		try {
			System.out.print("--Enter the ID you want to delete: ");
			int tmp = sc.nextInt();
			System.out.print(sc.nextLine());
			Customer customerByID;
			customerByID = controller.CustomerController.GetCustomerByID(tmp);
			if (customerByID == null) {
				System.out.println("--ID does not exist!");
			} else {
				controller.CustomerController.DeleteTheCustomer(tmp);
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}

	}

	private static void UpdateCustomer() {
		System.out.print("--Enter the ID you want to update: ");
		int tmp = sc.nextInt();
		System.out.print(sc.nextLine());
		Customer customerByID;
		try {
			customerByID = controller.CustomerController.GetCustomerByID(tmp);
			if (customerByID == null) {
				System.out.println("--ID does not exist!");
			} else {
				Customer customer = new Customer();
				customer.setName(Input.inputName());
				customer.setAge(Input.inputAge());
				customer.setAddress(Input.inputAddress());
				customer.setSalary(Input.inputSalary());
				controller.CustomerController.UpdateTheCustomer(customer, tmp);
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}

	}

	private static void FindTheCustomerByName() {
		System.out.print("--Enter the name you want to find: ");
		String tmp = Input.standardizeTheString(sc.nextLine());
		ArrayList<Customer> listCustomer;
		try {
			listCustomer = controller.CustomerController.FindCustomerByName(tmp);
			System.out.println(
					"----------------------------------- CUSTOMER INFORMATION -----------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s %-20s", "ID", "Name", "Age", "Address", "Salary");
			System.out.println();
			for (int i = 0; i < listCustomer.size(); i++) {
				System.out.printf("%-15d", listCustomer.get(i).getId());
				System.out.printf("%-25s", listCustomer.get(i).getName());
				System.out.printf("%-20d", listCustomer.get(i).getAge());
				System.out.printf("%-20s", listCustomer.get(i).getAddress());
				System.out.printf("%-20f", listCustomer.get(i).getSalary());
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}

	}

	private static void DisplayListCustomer() {
		ArrayList<Customer> listAllCustomer;
		try {
			listAllCustomer = controller.CustomerController.getAllCustomer();
			System.out.println(
					"----------------------------------- CUSTOMER INFORMATION -----------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s %-20s", "ID", "Name", "Age", "Address", "Salary");
			System.out.println();
			for (int i = 0; i < listAllCustomer.size(); i++) {
				System.out.printf("%-15d", listAllCustomer.get(i).getId());
				System.out.printf("%-25s", listAllCustomer.get(i).getName());
				System.out.printf("%-20d", listAllCustomer.get(i).getAge());
				System.out.printf("%-20s", listAllCustomer.get(i).getAddress());
				System.out.printf("%-20f", listAllCustomer.get(i).getSalary());
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}
}
