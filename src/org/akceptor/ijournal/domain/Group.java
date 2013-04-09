package org.akceptor.ijournal.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	
	@OneToMany(mappedBy="group")
    private Set<Student> students;
	
	
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