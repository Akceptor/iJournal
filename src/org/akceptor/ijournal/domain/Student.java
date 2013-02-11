package org.akceptor.ijournal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	@Column(name = "book_nr")
	private String bookNr;
	
	@Column(name = "student_fio")
	private String studentName;
	
	@ManyToOne
    @JoinColumn(name="group_id")
    private Group group;


	public String getBookNr() {
		return bookNr;
	}

	public void getBookNr(String bookNr) {
		this.bookNr = bookNr;
	}

	public Student() {
	}
	
	public Student(String studentName, String bookNr) {
        this.studentName = studentName;
        this.bookNr = bookNr;
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}