package org.akceptor.ijournal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userID;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private UsersAndRoles userRole;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Student student;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Teacher teacher;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}
	
	public User(int userID) {
		super();
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public UsersAndRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UsersAndRoles userRole) {
		this.userRole = userRole;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
}