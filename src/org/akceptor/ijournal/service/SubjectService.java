package org.akceptor.ijournal.service;

import java.util.ArrayList;

import org.akceptor.ijournal.dao.StudentDAO;
import org.akceptor.ijournal.dao.SubjectDAO;
import org.akceptor.ijournal.domain.MyDate;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private StudentDAO studentDAO;
	
	public ArrayList<Subject> getSubjects(){
		/** 
		 * 	Returns all groups in ArrayList
		 */
		return (ArrayList<Subject>) subjectDAO.findSubjects();
		
	};
	
	public Subject getSubjectByID(int subjectID){
		return subjectDAO.getSubjectByID(subjectID);
	}
	
	public String getGroupName(Group group){
		return group.getGroupName();
	}
	
	public ArrayList<MyDate> getSubjectDatesByID(int subjectID){
		ArrayList<MyDate> dates = new ArrayList<MyDate>();
		dates.add(new MyDate(0, "1.01.2013"));
		dates.add(new MyDate(1, "8.01.2013"));
		dates.add(new MyDate(2, "15.01.2013"));
		dates.add(new MyDate(3, "22.01.2013"));
		dates.add(new MyDate(4, "29.01.2013"));
		dates.add(new MyDate(5, "05.02.2013"));
		dates.add(new MyDate(6, "12.02.2013"));
		return dates;
	}

	
}
