package org.akceptor.ijournal.service;

import java.util.ArrayList;

import org.akceptor.ijournal.dao.SubjectDAO;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	
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
	
	public ArrayList getSubjectDatesByID(int subjectID){
		ArrayList dates = new ArrayList();
		dates.add("1.01.2013");
		dates.add("8.01.2013");
		dates.add("15.01.2013");
		dates.add("22.01.2013");
		dates.add("29.01.2013");
		dates.add("05.02.2013");
		dates.add("12.02.2013");
		return dates;
	}
	
}
