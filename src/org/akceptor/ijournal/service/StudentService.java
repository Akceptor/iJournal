package org.akceptor.ijournal.service;

import java.util.ArrayList;
import org.akceptor.ijournal.dao.GroupDAO;
import org.akceptor.ijournal.dao.StudentDAO;
import org.akceptor.ijournal.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	GroupService groupService;
	@Autowired
	UserService userService;
	
	public ArrayList<Student> getStudents(){
		/** 
		 * 	Returns all groups in ArrayList
		 */
		return (ArrayList<Student>) studentDAO.findStudents();
		
	};
	
	public Student getStudentByFIO(String studentFIO){
		return studentDAO.getStudentByFIO(studentFIO);
	}
	
	
	public String getStudentFIO(Student student){
		return student.getStudentName();
	}
	
	public String getStudentFIOByID(int studentID){
		return studentDAO.getStudentFIOByID(studentID);
	}
	
	public ArrayList<Student> getStudentsByGroupID(int groupID){
		/** 
		 * 	Returns all group members in ArrayList
		 */
		return (ArrayList<Student>) studentDAO.findStudentsByGroup(groupID);//findStudents();
	}
	
	public int getStudentIDByUserID(int userID) {
		return studentDAO.getStudentByUserID(userID).getStudentID();
	}
	
	public Student getStudentByID(int studentID){
		return studentDAO.getStudentByID(studentID).get(0);
	}

	
	public void deleteStudent(int studentID){
		studentDAO.delete(new Student(studentID));
	}
	
	
}
