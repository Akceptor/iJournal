package org.akceptor.ijournal.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dates")
public class MyDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "date_id")
	private int dateID;

	@Column(name = "date")
	private Date date;
	


	public int getDateID() {
		return dateID;
	}



	public void setDateID(int dateID) {
		this.dateID = dateID;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public MyDate() {
		super();
	}

	
}
