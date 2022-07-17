package Ekhairat.Javabean;

import java.sql.Timestamp;

public class announcement {
	Timestamp Datentime;
	String announceDetail;
	String staffid;
	
	public announcement() {
	}
	public Timestamp getDatentime() {
		return Datentime;
	}
	public void setDatentime(Timestamp Datentime) {
		this.Datentime = Datentime;
	}
	public String getannounceDetail() {
		return announceDetail;
	}
	public void setannounceDetail(String announceDetail) {
		this.announceDetail = announceDetail;
	}
	public String getstaffid() {
		return staffid;
	}
	public void setstaffid(String staffid) {
		this.staffid= staffid;
	}
} 
