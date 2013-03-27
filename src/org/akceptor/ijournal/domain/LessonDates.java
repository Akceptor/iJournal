package org.akceptor.ijournal.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson_dates")
public class LessonDates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lesson_id;

	@Column(name = "lesson_date")
	private Date lesson_date;
	
	public LessonDates() {
	}

	public int getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}
	
	@OneToOne (cascade = CascadeType.ALL)
	public Date getLesson_date() {
		return lesson_date;
	}

	public void setLesson_date(Date lesson_date) {
		this.lesson_date = lesson_date;
	}


}