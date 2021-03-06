package org.akceptor.ijournal.service;

import java.util.ArrayList;

import org.akceptor.ijournal.dao.GroupDAO;
import org.akceptor.ijournal.dao.StudentDAO;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private StudentDAO studentDAO;
	
	/** 
	 * 	Returns all groups in ArrayList
	 */
	public ArrayList<Group> getGroups(){
		return (ArrayList<Group>) groupDAO.findGroups();
	};
	
	public Group getGroupByID(int groupID){
		return groupDAO.getGroupByID(groupID);
	}
	
	public String getGroupName(Group group){
		return group.getGroupName();
	}
	
	public ArrayList<Student> getGroupMembersByID(int groupID){
		/** 
		 * 	Returns all group members in ArrayList
		 */
		return (ArrayList<Student>) studentDAO.findStudentsByGroup(groupID);//findStudents();
	}
	
	public int getGroupSizeByID(int groupID){
		/** 
		 * 	Returns all group members in ArrayList
		 */
		return studentDAO.findStudentsByGroup(groupID).size();//findStudents();
	}
	
	public void addGroup(String groupName){
		groupDAO.addGroup(new Group(groupName));
		
	}
	
	public void deleteGroup(int groupID){
		groupDAO.delete(new Group(groupID));
	}
	
	
}
