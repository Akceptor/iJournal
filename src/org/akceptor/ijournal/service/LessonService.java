package org.akceptor.ijournal.service;

import java.sql.Date;
import java.util.ArrayList;

import org.akceptor.ijournal.dao.LessonDAO;
import org.akceptor.ijournal.dao.SubjectDAO;
import org.akceptor.ijournal.domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private LessonDAO lessonDAO;
	
	
	
	public ArrayList<Lesson> getStudentsMarkFromSubject (int studentID, int subjectID){
		
		return lessonDAO.getStudentsMarksBySubject(studentID, subjectID);
		
	}
	
	public ArrayList<Date> getLessonDatesBySubject (int subjectID, int groupID){
		//System.err.println("LessonService");
		return lessonDAO.getLessonDatesBySubjectAndGroup(subjectID, groupID);
		
	}
	
}
