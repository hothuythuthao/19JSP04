package model;

public class Class {
	private int classID;
	private String className;
	private int classAmount;

	public Class() {
		super();
	}

	public Class(int classID, String className, int classAmount) {
		super();
		this.classID = classID;
		this.className = className;
		this.classAmount = classAmount;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassAmount() {
		return classAmount;
	}

	public void setClassAmount(int classAmount) {
		this.classAmount = classAmount;
	}

}
