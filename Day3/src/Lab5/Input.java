package Lab5;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);

	public static String inputName() {
		System.out.print("--Input employee name: ");
		return sc.nextLine();
	}

	public static String inputJobName() {
		System.out.print("--Input job name: ");
		return sc.nextLine();
	}

	public static int inputAge() {
		System.out.print("--Input employee age: ");
		while (true) {
			try {
				int age = Integer.parseInt((sc.nextLine()));
				if (age < 0 || age > 100) {
					throw new NumberFormatException();
				}
				return age;
			} catch (NumberFormatException ex) {
				System.out.print("\n--Invalid! Input employee age again: ");
			}
		}
	}

	public static double inputSalary() {
		System.out.print("--Input employee salary: ");
		while (true) {
			try {
				double salary = Double.parseDouble((sc.nextLine()));
				if (salary < 0) {
					throw new NumberFormatException();
				}
				return salary;
			} catch (NumberFormatException ex) {
				System.out.print("\n--Invalid! Input employee salary again: ");
			}
		}
	}

	public static boolean inputMarried() {
		System.out.print("--Input employee married: ");
		while (true) {
			try {
				int married = Integer.parseInt((sc.nextLine()));
				if (married == 0) {
					return false;
				} else if (married != 0) {
					return true;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) {
				System.out.print("\n--Invalid! Input employee married again: ");
			}
		}
	}
}
