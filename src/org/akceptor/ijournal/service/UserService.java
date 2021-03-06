package org.akceptor.ijournal.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.akceptor.ijournal.dao.UserDAO;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Student;
import org.akceptor.ijournal.domain.Teacher;
import org.akceptor.ijournal.domain.User;
import org.akceptor.ijournal.domain.UsersAndRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	GroupService groupService;
//	@Autowired 
//	UserAndRoleService unrs;

	public int getUserIDByName(String username) {
		return userDAO.getUserByName(username).getUserID();
	}

	public ArrayList<User> findUsers() {
		return (ArrayList<User>) userDAO.findUsers();

	}

	public void addUser(String login, String password, int role, String studentName, String bookNr, int groupNr, String teacherName) {
		User user = new User();
		user.setUsername(login);
		// MD5 hash password
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.update(password.getBytes(), 0, password.length());
		String hashtext = new BigInteger(1,m.digest()).toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		
		//set MD5-hashed password to User-object inctance
		user.setPassword(hashtext);
		
		//create new userrole stub, set selected roleID and set role to user
		UsersAndRoles unr = new UsersAndRoles();
		unr.setUserRoleID(role);
		unr.setUser(user);
		//if user is student
		if (role == 1){
			//create student object and set it's properties
			Student student = new Student();
			student.setStudentName(studentName);
			student.setBookNr(bookNr);
			//set current user account to student
			student.setUser(user);
			//create group stub for student
			Group group = groupService.getGroupByID(groupNr);
			//set group
			student.setGroup(group);
			//finally, set student account to user
			user.setStudent(student);
		}
		
		//if user is teacher
				if (role == 2){
					//create teacher object and set it's properties
					Teacher teacher = new Teacher();
					teacher.setTeacherName(teacherName);
					//set current user to teacher account
					teacher.setUser(user);
					//finally, set teacher account to user
					user.setTeacher(teacher);
				}		
				
				
		//set userrole and commit user to DB
		//for all types of users
		user.setUserRole(unr);
		userDAO.addUser(user);
		

	}
	
	public void deleteUser(int userID){
		userDAO.delete(new User(userID));
	}
	
	public User getUserByID(int userID){
		return userDAO.getUserByID(userID);
	}
	
	public int getLastUser(){
		return userDAO.getLastUser();
	}

}