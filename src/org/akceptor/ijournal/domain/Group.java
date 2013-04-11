package org.akceptor.ijournal.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")

public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private int groupID;

	@Column(name = "group_name")
	private String groupName;
	
	@OneToMany(mappedBy="group", fetch=FetchType.EAGER) 
	//Change to LAZY later and implement OpenSessionInView or http://habrahabr.ru/post/111911/
    private Set<Student> students;
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	public int getGroupID() {
		return groupID;
	}


	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Group() {
	}


	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}


	public Group(int groupID) {
		super();
		this.groupID = groupID;
	}
	
	

}