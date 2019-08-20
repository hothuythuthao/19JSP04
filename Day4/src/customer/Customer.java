package customer;

public class Customer {
	private int customerID;
	private String customerName;
	private int customerAge;
	private String customerPhoneNumber;
	private String customerAddress;
	
	public Customer() {
		super();
	}

	public Customer(int customerID, String customerName, int customerAge, String customerPhoneNumber,
			String customerAddress) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerAddress = customerAddress;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerAge=" + customerAge
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", customerAddress=" + customerAddress + "]";
	}
	
}
