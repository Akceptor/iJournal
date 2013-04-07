package org.akceptor.ijournal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lesson", catalog="iJournal")
//Tried this thing: @org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true, selectBeforeUpdate = true)
//doesn't work, so I did this stupid way in OkController.java

public class Lesson implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lessonID;

	@Column(name = "student_id")
	private int studentID;
	
	@Column(name = "subject_id")
	private int subjectID;
	
//	@Column(name = "lesson_date")
//	private Date lesson_date;
//	
	@Column(name = "mark")
	private int mark;
	
	@Column(name = "absense")
	private int absense;
	
	public int getLessonID() {
		return lessonID;
	}


	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public int getSubjectID() {
		return subjectID;
	}


	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
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
	
	@ManyToOne
	@JoinColumn(name="subject_id", referencedColumnName = "subject_id", insertable = false, updatable = false)
    private Subject subject;
	
	public Lesson() {
	}
	

}