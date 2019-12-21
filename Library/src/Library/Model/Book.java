package Library.Model;

public class Book {
	private String bookID;
	private String bookName;
	private String bookAuthor;
	private String publishYear;
	private String bookKind;

	public Book() {
		super();
	}

	public Book(String bookID, String bookName, String bookAuthor, String publishYear, String bookKind) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publishYear = publishYear;
		this.bookKind = bookKind;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getBookKind() {
		return bookKind;
	}

	public void setBookKind(String bookKind) {
		this.bookKind = bookKind;
	}

}
