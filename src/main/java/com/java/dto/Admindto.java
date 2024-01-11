package com.java.dto;

public class Admindto {
	private int aid;
	private String aname;
	private long acon;
	private String amail;
	private String apass;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;

	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public long getAcon() {
		return acon;
	}

	public void setAcon(long acon) {
		this.acon = acon;
	}

	public String getAmail() {
		return amail;
	}

	public void setAmail(String amail) {
		this.amail = amail;
	}

	public String getApass() {
		return apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

	@Override
	public String toString() {
		return "Admindto [aid=" + aid + ", aname=" + aname + ", acon=" + acon + ", amail=" + amail + ", apass=" + apass
				+ "]";
	}
}
