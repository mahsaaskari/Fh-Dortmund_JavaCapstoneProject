public class User {
	private String fullname;
	private String carType;
	private int maxWaitTime;
	private UsersLoggers userLog;
	
	public User(String fullname, int maxWaitTime, String carType) {
		this.fullname = fullname;
		this.maxWaitTime = maxWaitTime;
		this.carType = carType;
		
		userLog = new UsersLoggers();
		userLog.logActivity("fullname is: " + fullname + " and Max Wait Time is: " + maxWaitTime);
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}
	
	
}
