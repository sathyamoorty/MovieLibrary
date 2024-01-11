package com.java.dto;

public class Moviedto 
{
	private int mid;
	private String mname;
	private double mprice;
	private double mrating;
	private String mgenre;
	private String mlang;
	private byte[] mimage;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public double getMrating() {
		return mrating;
	}
	public void setMrating(double mrating) {
		this.mrating = mrating;
	}
	public String getMgenre() {
		return mgenre;
	}
	public void setMgenre(String mgenre) {
		this.mgenre = mgenre;
	}
	public String getMlang() {
		return mlang;
	}
	public void setMlang(String mlang) {
		this.mlang = mlang;
	}
	public byte[] getMimage() {
		return mimage;
	}
	public void setMimage(byte[] mimage) {
		this.mimage = mimage;
	}
	@Override
	public String toString() {
		return "Moviedto [mid=" + mid + ", mname=" + mname + ", mprice=" + mprice + ", mrating=" + mrating + ", mgenre="
				+ mgenre + ", mlang=" + mlang + ", mimage=" + mimage + "]";
	}
}
