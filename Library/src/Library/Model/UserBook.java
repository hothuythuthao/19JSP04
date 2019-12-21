package Library.Model;

import java.sql.Date;

public class UserBook {
	private int ID;
	private String userID;
	private String bookID;
	private Date borrowDate;
	private Date returnDateExpected;
	private Date returnDateReal;
	private Date registerDate;
	private String empID;
	private int status;

	public UserBook() {
		super();
	}

	public UserBook(int iD, String userID, String bookID, Date registerDate) {
		super();
		ID = iD;
		this.userID = userID;
		this.bookID = bookID;
		this.registerDate = registerDate;
	}

	public UserBook(int iD, String userID, String bookID, Date borrowDate, Date returnDateExpected, Date returnDateReal,
			Date registerDate, String empID, int status) {
		super();
		ID = iD;
		this.userID = userID;
		this.bookID = bookID;
		this.borrowDate = borrowDate;
		this.returnDateExpected = returnDateExpected;
		this.returnDateReal = returnDateReal;
		this.registerDate = registerDate;
		this.empID = empID;
		this.status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDateExpected() {
		return returnDateExpected;
	}

	public void setReturnDateExpected(Date returnDateExpected) {
		this.returnDateExpected = returnDateExpected;
	}

	public Date getReturnDateReal() {
		return returnDateReal;
	}

	public void setReturnDateReal(Date returnDateReal) {
		this.returnDateReal = returnDateReal;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
