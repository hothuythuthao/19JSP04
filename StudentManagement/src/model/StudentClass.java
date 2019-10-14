package model;

public class StudentClass {
	private int id;
	private int student_id;
	private int class_id;

	public StudentClass() {
		super();
	}

	public StudentClass(int id, int student_id, int class_id) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.class_id = class_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

}
