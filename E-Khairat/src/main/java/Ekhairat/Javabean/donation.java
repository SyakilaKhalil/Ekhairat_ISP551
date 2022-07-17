package Ekhairat.Javabean;
import javax.servlet.http.Part;
import com.google.protobuf.Timestamp;
public class donation {
String receiptID;
Part paymentdetail;
String paymenttype;
Timestamp datentime;
String memberid;
String donationvalue;

public String getreceiptID() {
	return receiptID;
}
public void setreceiptID(String receiptID) {
	this.receiptID = receiptID;
}
public Part getpaymentdetail() {
	return paymentdetail;
}
public void setpaymentdetail(Part paymentdetail) {
	this.paymentdetail = paymentdetail;
}
public String getpaymenttype() {
	return paymenttype;
}
public void setpaymenttype(String paymenttype) {
	this.paymenttype = paymenttype;
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
public String getdonationvalue() {
	return donationvalue;
}
public void setdonationvalue(String donationvalue) {
	this.donationvalue = donationvalue;
}
}
