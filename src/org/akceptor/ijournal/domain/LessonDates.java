package org.akceptor.ijournal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lessons_and_dates")
public class LessonDates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lessonID;

	@Column(name = "date_id")
	private int dateID;
	
	public LessonDates() {
	}

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public int getDateID() {
		return dateID;
	}

	public void setDateID(int dateID) {
		this.dateID = dateID;
	}
	
	
//	@OneToOne (cascade = CascadeType.ALL)
//	public Date getLesson_date() {
//		return lesson_date;
//	}
//
//	public void setLesson_date(Date lesson_date) {
//		this.lesson_date = lesson_date;
//	}
	
	


}