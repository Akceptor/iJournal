package org.akceptor.ijournal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@Column(name = "user_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
	private int userID;
	
	//@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id" )
	private int studentID;

	@Column(name = "book_nr")
	private String bookNr;
	
	@Column(name = "student_fio")
	private String studentName;
	
	@ManyToOne
    @JoinColumn(name="group_id")
    private Group group;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

//	@OneToMany(mappedBy="lessonID")
//    private Set<Lesson> lessons;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setBookNr(String bookNr) {
		this.bookNr = bookNr;
	}
	
	
	public String getBookNr() {
		return bookNr;
	}

	public void getBookNr(String bookNr) {
		this.bookNr = bookNr;
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
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student() {
	}

	public Student(int studentID) {
		super();
		this.studentID = studentID;
	}


	
	
	

}