package utils;

import java.util.Scanner;

public class Input {

	public static Scanner sc = new Scanner(System.in);

	public static String inputName() {
		System.out.print("--Name: ");
		return standardizeTheString(sc.nextLine());
	}

	public static int inputAge() {
		System.out.print("--Age: ");
		while (true) {
			try {
				int age = Integer.parseInt((sc.nextLine()));
				if ((age < 1) || (age > 200)) {
					throw new NumberFormatException();
				}
				return age;
			} catch (NumberFormatException ex) {
				System.out.println("--Invalid! Age must be older than 1 and younger than 200.");
				System.out.print("--Please re-enter: ");
			}
		}
	}

	public static String inputAddress() {
		System.out.print("--Address: ");
		return standardizeTheString(sc.nextLine());
	}

	public static double inputSalary() {
		System.out.print("--Salary: ");
		while (true) {
			try {
				double salary = Double.parseDouble((sc.nextLine()));
				if (salary < 0) {
					throw new NumberFormatException();
				}
				return salary;
			} catch (NumberFormatException ex) {
				System.out.println("--Invalid! Salary must be greater than 0.");
				System.out.print("--Please re-enter: ");
			}
		}
	}

	public static String standardizeTheString(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}
}
