package Library.Model;

public class User {
	private String userID;
	private String userName;
	private String email;
	private String password;
	private int isAdmin;
	private String status;

	public User() {
		super();
	}

	public User(String userID, String userName, String email, String password, int isAdmin, String status) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
		this.status = status;
	}

	public User(User user) {
		super();
		this.userID = user.userID;
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.isAdmin = user.isAdmin;
		this.status = user.status;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
