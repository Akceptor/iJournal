package org.akceptor.ijournal.dao;

import java.util.ArrayList;
import java.util.List;

import org.akceptor.ijournal.domain.Subject;

public interface SubjectDAO {
	public void addSubject(Subject subject);
	public void updateSubject(Subject subject);
	public void delete(Subject subject);
	public Subject getSubjectByName(String subjectName);
	public Subject getSubjectByID(int subjectID);
	public List<Subject> findSubjects();
	public ArrayList<Subject> findSubjectsByCourse(int courseID);
}