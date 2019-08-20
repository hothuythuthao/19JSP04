package banker;

public class Banker {
	private int bankerID;
	private String bankerName;
	
	public Banker() {
		super();
	}

	public Banker(int bankerID, String bankerName) {
		super();
		this.bankerID = bankerID;
		this.bankerName = bankerName;
	}

	public int getBankerID() {
		return bankerID;
	}

	public void setBankerID(int bankerID) {
		this.bankerID = bankerID;
	}

	public String getBankerName() {
		return bankerName;
	}

	public void setBankerName(String bankerName) {
		this.bankerName = bankerName;
	}

	@Override
	public String toString() {
		return "Banker [bankerID=" + bankerID + ", bankerName=" + bankerName + "]";
	}
	
}
