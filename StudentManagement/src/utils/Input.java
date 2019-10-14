package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);

	public static String inputName() {
		while (true) {
			try {
				String name = standardizeTheString(sc.nextLine());
				if (name.isEmpty() || name == null) {
					throw new IllegalArgumentException();
				}
				return name;
			} catch (IllegalArgumentException iae) {
				System.out.println("--Invalid! Name cannot be empty.");
				System.out.print("--Please re-enter: ");
			}
		}
	}

	public static int inputAge() {
		while (true) {
			try {
				int age = Integer.parseInt((sc.nextLine()));
				if ((age < 18) || (age > 100)) {
					throw new NumberFormatException();
				}
				return age;
			} catch (NumberFormatException ex) {
				System.out.println("--Invalid! Age must be older than 18 and younger than 100.");
				System.out.print("--Please re-enter: ");
			}
		}
	}

	public static int inputID() {
		while (true) {
			try {
				int id = Integer.parseInt((sc.nextLine()));
				return id;
			} catch (NumberFormatException ex) {
				System.out.print("--Invalid ID! Please re-enter: ");
			}
		}
	}

	public static int checkInt(String s) {
		try {
			int id = Integer.parseInt(s);
			return id;
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public static Date inputDate(String date) {
		if (date == null || date.isEmpty()) {
			return null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format.setLenient(false);
			try {
				java.util.Date formatDate = format.parse(date);
				java.sql.Date sqlDate = new java.sql.Date(formatDate.getTime());
				return sqlDate;
			} catch (ParseException p) {
				return null;
			}
		}
	}

	public static String inputSearch() {
		return standardizeTheString(sc.nextLine());
	}

	public static String standardizeTheString(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}
}
