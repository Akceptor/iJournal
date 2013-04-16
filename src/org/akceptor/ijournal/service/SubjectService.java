package org.akceptor.ijournal.service;

import java.util.ArrayList;
import java.util.List;

import org.akceptor.ijournal.dao.StudentDAO;
import org.akceptor.ijournal.dao.SubjectDAO;
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

	/**
	 * Returns all subjects in ArrayList
	 */
	public ArrayList<Subject> getSubjects() {
		return (ArrayList<Subject>) subjectDAO.findSubjects();

	};
	
	/**
	 * Returns all subjects in ArrayList
	 */
	public ArrayList<Subject> getSubjectsForTeacher(int teacherID) {
		return (ArrayList<Subject>) subjectDAO.findSubjectsForTeacher(teacherID);

	};

	public Subject getSubjectByID(int subjectID) {
		return subjectDAO.getSubjectByID(subjectID);
	}

	public String getGroupName(Group group) {
		return group.getGroupName();
	}

	public List<Subject> findSubjects() {
		return subjectDAO.findSubjects();
	}

	public List<Subject> findSubjectsByStudentID(int studentID) {
		System.err.println(subjectDAO.findSubjectsByStudentID(studentID));
		return subjectDAO.findSubjectsByStudentID(studentID);
	}

	public void addSubject(String subjectName){
		subjectDAO.addSubject(new Subject(subjectName, 0));
		
	}
	
	public void deleteSubject(int subjectID){
		subjectDAO.delete(new Subject(subjectID));
	}
	
	

}
