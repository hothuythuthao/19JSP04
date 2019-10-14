package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ClassController;
import controller.DayOffController;
import controller.StudentController;
import model.Class;
import model.DayOff;
import model.Student;
import model.StudentClass;
import utils.Input;

public class StudentManagement {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Class> listAllClass;
	public static ArrayList<Student> listAllStudent;
	public static ArrayList<StudentClass> listAllStudentClass;
	public static ArrayList<DayOff> listAllDayOff;

	public static void main(String[] args) {
		String choose = null;

		displayMenu();
		while (true) {
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				AddTheStudent();
				break;
			case "2":
				AddTheClass();
				break;
			case "3":
				RegisterForClass();
				break;
			case "4":
				RegisterForDayOff();
				break;
			case "5":
				SearchTheStudent();
				break;
			case "6":
				SearchTheClassByName();
				break;
			case "7":
				SearchTheDayOff();
				break;
			case "8":
				DeleteTheStudentByID();
				break;
			case "9":
				DeleteTheClassByID();
				break;
			case "10":
				DisplayListStudent();
				break;
			case "11":
				DisplayListClass();
				break;
			case "12":
				controller.StudentClassController.getAllStudentClass();
				break;
			case "13":
				controller.DayOffController.getAllDayOff();
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
		System.out.println("1. Add new a student.");
		System.out.println("2. Add new a class.");
		System.out.println("3. Student register for class.");
		System.out.println("4. Register day off for student.");
		System.out.println("5. Search a student.");
		System.out.println("6. Search a class by class name.");
		System.out.println("7. Search a day off.");
		System.out.println("8. Delete a student by id.");
		System.out.println("9. Delete a class by id.");
		System.out.println("10. Show list student.");
		System.out.println("11. Show list class.");
		System.out.println("12. Show list student class.");
		System.out.println("13. Show list day off.");
		System.out.print("--Please choose: ");
	}

	private static void AddTheStudent() {
		try {
			Student student = new Student();
			System.out.print("--Enter the student name: ");
			student.setStudentName(Input.inputName());
			System.out.print("--Enter the student age: ");
			student.setStudentAge(Input.inputAge());
			controller.StudentController.AddNewStudent(student);
			System.out.println("--Added successfully!");
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void AddTheClass() {
		try {
			Class clas = new Class();
			System.out.print("--Enter the class name: ");
			clas.setClassName(Input.inputName());
			controller.ClassController.AddNewClass(clas);
			System.out.println("--Added successfully!");
		} catch (SQLException e) {
			System.out.println("--The error is " + e);
		}
	}

	private static void RegisterForClass() {
		try {
			StudentClass studentClass = new StudentClass();
			DisplayListStudent();
			System.out.print("--Enter the student ID you want to register: ");
			int studentID = Input.inputID();
			Student studentByID = StudentController.getStudentByID(studentID);
			if (studentByID == null) {
				System.out.println("--The student ID " + studentID + " does not exist");
			} else {
				DisplayListClass();
				System.out.print("--Enter the class ID you want to register: ");
				int classID = Input.inputID();
				Class classByID = ClassController.getClassByID(classID);
				if (classByID == null) {
					System.out.println("--The class ID " + classID + " does not exist");
				} else {
					studentClass.setStudent_id(studentID);
					studentClass.setClass_id(classID);
					controller.StudentClassController.AddNewStudentClass(studentClass);
					System.out.println("--Registered successfully!");
				}
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void SearchTheStudent() {
		try {
			System.out.print("--Enter the student ID you want to find: ");
			String studentID = Input.inputSearch();
			System.out.print("--Enter the student name you want to find: ");
			String studentName = Input.inputSearch();
			System.out.print("--Enter the student age you want to find: ");
			String studentAge = Input.inputSearch();

			if (studentID.isEmpty() && studentName.isEmpty() && studentAge.isEmpty()) {
				controller.StudentClassController.getAllStudentClass();
			} else {
				int tmpID = Input.checkInt(studentID);
				int tmpAge = Input.checkInt(studentAge);
				System.out.println(
						"----------------------------------- STUDENTS INFORMATION -----------------------------------");
				System.out.printf("%-14s %-24s %-19s %-19s", "Student ID", "Student Name", "Student Age", "Class Name");
				System.out.println();
				controller.StudentClassController.SearchStudent(tmpID, studentName, tmpAge);
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void SearchTheClassByName() {
		try {
			System.out.print("--Enter the class name you want to find: ");
			String className = Input.inputSearch();
			Class classByName = ClassController.getClassByName(className);
			if (classByName == null) {
				System.out.println("--The class name " + className + " does not exist");
			} else {
				System.out.println(
						"----------------------------------- CLASS INFORMATION -----------------------------------");
				System.out.printf("%-14s %-24s %-19s", "Class ID", "Class Name", "Amount");
				System.out.println();
				controller.ClassController.SearchTheClass(className);
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void RegisterForDayOff() {
		try {
			DisplayListStudent();
			System.out.print("--Enter the student ID you want to register for day off: ");
			int studentID = Input.inputID();
			Student studentByID = StudentController.getStudentByID(studentID);
			if (studentByID == null) {
				System.out.println("--The student ID " + studentID + " does not exist!");
			} else {
				System.out.print("--Enter the date you want to off (yyyy/MM/dd): ");
				String date = sc.nextLine();
				if (Input.inputDate(date) == null) {
					System.out.println("--Invalid date or The date cannot be empty!");
				} else {
					DayOff dayOff = new DayOff();
					dayOff.setDayOff(Input.inputDate(date));
					dayOff.setStudentID(studentID);
					controller.DayOffController.AddNewDayOff(dayOff);
					System.out.println("--Registered successfully!");
				}
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void SearchTheDayOff() {
		try {
			System.out.print("--Enter the student name you want to find for day off: ");
			String studentName = Input.inputSearch();
			System.out.print("--Enter the date off you want to find (yyyy/MM/dd): ");
			String date = sc.nextLine();
			Student studentByName = StudentController.getStudentByName(studentName);
			DayOff dayOffByDate = DayOffController.getDateOfByDate(Input.inputDate(date));
			if (studentName.isEmpty() && date.isEmpty()) {
				controller.DayOffController.getAllDayOff();
			} else if (studentByName == null && dayOffByDate == null) {
				System.out.println("--The student name or date off does not exist!");
			} else {
				System.out.println(
						"----------------------------------- DAYOFF INFORMATION -----------------------------------");
				System.out.printf("%-24s %-24s", "Student Name", "Day Off");
				System.out.println();
				controller.DayOffController.SearchDayOff(studentName, Input.inputDate(date));
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void DeleteTheStudentByID() {
		try {
			System.out.print("--Enter the student ID you want to delete: ");
			int studentID = Input.inputID();
			Student studentByID = StudentController.getStudentByID(studentID);
			if (studentByID == null) {
				System.out.println("--The student ID " + studentID + " does not exist!");
			} else {
				controller.StudentController.DeleteStudentByID(studentID);
				System.out.println("--Deleted successful!");
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void DeleteTheClassByID() {
		try {
			System.out.print("--Enter the class ID you want to delete: ");
			int classID = Input.inputID();
			Class classByID = ClassController.getClassByID(classID);
			if (classByID == null) {
				System.out.println("--The class ID " + classID + " does not exist!");
			} else {
				controller.ClassController.DeleteClassByID(classID);
				System.out.println("--Deleted successful!");
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void DisplayListStudent() {
		try {
			listAllStudent = controller.StudentController.getAllStudent();
			System.out.println(
					"----------------------------------- STUDENTS INFORMATION -----------------------------------");
			System.out.printf("%-14s %-24s %-19s", "Student ID", "Student Name", "Student Age");
			System.out.println();
			for (int i = 0; i < listAllStudent.size(); i++) {
				System.out.printf("%-15d", listAllStudent.get(i).getStudentID());
				System.out.printf("%-25s", listAllStudent.get(i).getStudentName());
				System.out.printf("%-20d", listAllStudent.get(i).getStudentAge());
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}

	private static void DisplayListClass() {
		try {
			listAllClass = controller.ClassController.getAllClass();
			System.out.println(
					"----------------------------------- CLASS INFORMATION -----------------------------------");
			System.out.printf("%-14s %-24s %-19s", "Class ID", "Class Name", "Amount");
			System.out.println();
			for (int i = 0; i < listAllClass.size(); i++) {
				System.out.printf("%-15d", listAllClass.get(i).getClassID());
				System.out.printf("%-25s", listAllClass.get(i).getClassName());
				System.out.printf("%-20d", listAllClass.get(i).getClassAmount());
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}
	}
	//
	// private static void DisplayListStudentClass() {
	// try {
	// listAllStudentClass = controller.StudentClassController.getAllStudentClass();
	// System.out.println(
	// "------------------------------- STUDENT CLASS INFORMATION
	// -------------------------------");
	// System.out.printf("%-14s %-24s %-19s", "ID", "Student ID", "Class ID");
	// System.out.println();
	// for (int i = 0; i < listAllStudentClass.size(); i++) {
	// System.out.printf("%-15d", listAllStudentClass.get(i).getId());
	// System.out.printf("%-25d", listAllStudentClass.get(i).getStudent_id());
	// System.out.printf("%-20d", listAllStudentClass.get(i).getClass_id());
	// System.out.println();
	// }
	// } catch (SQLException e) {
	// System.out.println("The error is " + e);
	// }
	// }

	// private static void DisplayListDayOff() {
	// try {
	// listAllDayOff = controller.DayOffController.getAllDayOff();
	// System.out.println("------------------------------- DAY OFF INFORMATION
	// -------------------------------");
	// System.out.printf("%-14s %-24s %-19s", "Day Off ID", "Day Off", "Student
	// ID");
	// System.out.println();
	// for (int i = 0; i < listAllDayOff.size(); i++) {
	// System.out.printf("%-15d", listAllDayOff.get(i).getDayOffID());
	// System.out.printf("%-25s", listAllDayOff.get(i).getDayOff());
	// System.out.printf("%-20d", listAllDayOff.get(i).getStudentID());
	// System.out.println();
	// }
	// } catch (SQLException e) {
	// System.out.println("The error is " + e);
	// }
	// }
}
