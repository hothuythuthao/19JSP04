package Lab5;

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;
	private boolean married;
	private Job job;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, double salary, boolean married, Job job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.married = married;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
