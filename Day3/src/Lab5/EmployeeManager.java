package Lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
	public static Scanner sc = new Scanner(System.in);
	private static ArrayList<Employee> empList = new ArrayList<>();
	private static ArrayList<Job> jobList = new ArrayList<>();

	public static void addEmp() {
		int id = (empList.size() > 0) ? (empList.size() + 1) : 1;
		System.out.println("\n--Employee ID : " + id);
		String name = Input.inputName();
		int age = Input.inputAge();
		double salary = Input.inputSalary();
		boolean married = Input.inputMarried();
		int jobID = (jobList.size() > 0) ? (jobList.size() + 1) : 1;
		System.out.println("--Job ID: " + jobID);
		String jobName = Input.inputJobName();
		Job job = new Job(jobID, jobName);
		jobList.add(job);
		Employee employee = new Employee(id, name, age, salary, married, job);
		empList.add(employee);
	}

	public static void displayList() {
		if (empList.size() == 0) {
			System.out.println("\n--Employee list is NULL!");
		} else {
			System.out.printf("\n%-9s %-24s %-19s %-25s", "ID", "Name", "Salary", "Job name");
			System.out.println();
			for (Employee employee : empList) {
				System.out.printf("%-10d", employee.getId());
				System.out.printf("%-25s", employee.getName());
				System.out.printf("%-20s", employee.getSalary());
				System.out.printf("%-25s", employee.getJob().getJobName());
				System.out.println();
			}
		}
	}
}
