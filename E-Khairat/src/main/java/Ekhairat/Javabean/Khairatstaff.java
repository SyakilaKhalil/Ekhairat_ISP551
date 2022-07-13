package Ekhairat.Javabean;

public class Khairatstaff {
	String staffName;
	String staffID;
	String staffContactNo;
	String staffEmail;
	String staffPassword;
	String staffAddress;
	
	public Khairatstaff() {}
	
	
	public Khairatstaff(String staffName, String staffID, String staffContactNo, String staffEmail,
			String staffPassword, String staffAddress) {
		super();
		this.staffName = staffName;
		this.staffID = staffID;
		this.staffContactNo = staffContactNo;
		this.staffEmail = staffEmail;
		this.staffPassword = staffPassword;
		this.staffAddress = staffAddress;
	}


	public Khairatstaff(String staffName, String staffContactNo, String staffEmail, String staffPassword,
			String staffAddress) {
		super();
		this.staffName = staffName;
		this.staffContactNo = staffContactNo;
		this.staffEmail = staffEmail;
		this.staffPassword = staffPassword;
		this.staffAddress = staffAddress;
	}


	public String getstaffName() {
		return staffName;
	}
	public void setstaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getstaffID() {
		return staffID;
	}
	public void setstaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getstaffContactNo() {
		return staffContactNo;
	}
	public void setstaffContactNo(String staffContactNo) {
		this.staffContactNo = staffContactNo;
	}
	public String getstaffEmail() {
		return staffEmail;
	}
	public void setstaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getstaffPassword() {
		return staffPassword;
	}
	public void setstaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getstaffAddress() {
		return staffAddress;
	}
	public void setstaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
}

