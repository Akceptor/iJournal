package org.akceptor.ijournal.service;

import java.util.ArrayList;
import java.util.List;

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

	public ArrayList<MyDate> getSubjectDatesByID(int subjectID) {
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
