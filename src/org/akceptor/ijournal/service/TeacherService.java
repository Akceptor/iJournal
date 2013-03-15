package org.akceptor.ijournal.service;

import java.util.ArrayList;

import org.akceptor.ijournal.dao.GroupDAO;
import org.akceptor.ijournal.dao.TeacherDAO;
import org.akceptor.ijournal.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	
	public ArrayList<Teacher> getTeachers(){
		/** 
		 * 	Returns all groups in ArrayList
		 */
		return (ArrayList<Teacher>) teacherDAO.findTeachers();
		
	};
	
	public int getTeacherIDByUserID(int userID) {
		return teacherDAO.getTeacherByUserID(userID).get(0).getId();
	}
	
	public Teacher getTeacherByID(int teacherID){
		return teacherDAO.getTeacherByID(teacherID).get(0);
	}
}
