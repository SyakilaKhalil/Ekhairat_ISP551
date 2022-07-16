package Ekhairat.Javabean;

import java.sql.Date;

public class paymentkhairat {
	String paymentdetail;
	String path;
	Date datentime;
	String memberid;
	
	public paymentkhairat() {}
	
	public String getpaymentdetail() {
		return paymentdetail;
	}
	public void setpaymentdetail(String paymentdetail) {
		this.paymentdetail = paymentdetail;
	}
	public String getpath() {
		return path;
	}
	public void setpath(String path) {
		this.path = path;
	}
	public Date getdatentime() {
		return datentime;
	}
	public void setdatentime(Date datentime) {
		this.datentime = datentime;
	}
	public String getmemberid() {
		return memberid;
	}
	public void setmemberid(String memberid) {
		this.memberid = memberid;
	}
}
