package Ekhairat.Javabean;

import javax.servlet.http.Part;
import com.google.protobuf.Timestamp;

public class paymentkhairat {
	Part paymentdetail;
	String path;
	Timestamp datentime;
	String memberid;
	String paymenttype;
	
	public String getpaymenttype() {
		return paymenttype;
	}

	public void setpaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public paymentkhairat() {}
	
	public Part  getpaymentdetail() {
		return paymentdetail;
	}
	public void setpaymentdetail(Part  paymentdetail) {
		this.paymentdetail = paymentdetail;
	}
	public String getpath() {
		return path;
	}
	public void setpath(String path) {
		this.path = path;
	}
	public Timestamp getdatentime() {
		return datentime;
	}
	public void setdatentime(Timestamp datentime) {
		this.datentime = datentime;
	}
	public String getmemberid() {
		return memberid;
	}
	public void setmemberid(String memberid) {
		this.memberid = memberid;
	}
}
