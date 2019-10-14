package model;

import java.sql.Date;

public class DayOff {
	private int dayOffID;
	private Date dayOff;
	private int studentID;

	public DayOff() {
		super();
	}

	public DayOff(int dayOffID, Date dayOff, int studentID) {
		super();
		this.dayOffID = dayOffID;
		this.dayOff = dayOff;
		this.studentID = studentID;
	}

	public int getDayOffID() {
		return dayOffID;
	}

	public void setDayOffID(int dayOffID) {
		this.dayOffID = dayOffID;
	}

	public Date getDayOff() {
		return dayOff;
	}

	public void setDayOff(Date dayOff) {
		this.dayOff = dayOff;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

}
