package Ekhairat.Javabean;

public class Khairatmember {
	String memberName;
    String memberID;
    String memberContactNo;
    String memberEmail;
    String memberPassword;
    String memberAddress;

  
    
	public Khairatmember(String memberName, String memberID, String memberContactNo, String memberEmail,
			String memberPassword, String memberAddress) {
		super();
		this.memberName = memberName;
		this.memberID = memberID;
		this.memberContactNo = memberContactNo;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
	}
	
	
	public Khairatmember(String memberName, String memberContactNo, String memberEmail, String memberPassword,
			String memberAddress) {
		super();
		this.memberName = memberName;
		this.memberContactNo = memberContactNo;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
	}


	public Khairatmember() {
		
	}

	public String getmemberName() {
        return memberName;
    }
    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getmemberID() {
        return memberID;
    }
    public void setmemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getmemberContactNo() {
        return memberContactNo;
    }
    public void setmemberContactNo(String memberContactNo) {
        this.memberContactNo = memberContactNo;
    }
    public String getmemberEmail() {
        return memberEmail;
    }
    public void setmemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    public String getmemberPassword() {
        return memberPassword;
    }
    public void setmemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
    public String getmemberAddress() {
        return memberAddress;
    }
    public void setmemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
}
