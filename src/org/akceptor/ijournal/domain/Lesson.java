package org.akceptor.ijournal.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson")

public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lesson_id;

	@Column(name = "student_id")
	private int student_id;
	
	@Column(name = "teacher_id")
	private int teacher_id;
	
	@Column(name = "subject_id")
	private int subject_id;
	
	@Column(name = "lesson_date")
	private Date lesson_date;
	
	@Column(name = "mark")
	private int mark;
	
	@Column(name = "absense")
	private int absense;
	
	public int getLesson_id() {
		return lesson_id;
	}


	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	public Date getDate() {
		return lesson_date;
	}


	public void setDate(Date lesson_date) {
		this.lesson_date = lesson_date;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}


	public int getAbsense() {
		return absense;
	}


	public void setAbsense(int absense) {
		this.absense = absense;
	}

	@ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student students;
	
	
	public Lesson() {
	}
	
	

}