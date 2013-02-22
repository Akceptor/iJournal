package org.akceptor.ijournal.domain;

public class MyDate {
	private int nr;
	private String dateString;
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public MyDate(int nr, String dateString) {
		super();
		this.nr = nr;
		this.dateString = dateString;
	}

	
}
