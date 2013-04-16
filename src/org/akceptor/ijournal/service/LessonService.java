package org.akceptor.ijournal.service;

import java.util.ArrayList;
import java.sql.Date;

import org.akceptor.ijournal.dao.LessonDAO;
import org.akceptor.ijournal.dao.SubjectDAO;
import org.akceptor.ijournal.domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private LessonDAO lessonDAO;

	public ArrayList<Integer> getStudentsMarkFromSubject(int studentID,
			int subjectID) {

		return lessonDAO.getStudentsMarksBySubject(studentID, subjectID);

	}

	public ArrayList<Lesson> getStudentsDataFromSubject(int studentID,
			int subjectID) {
		return lessonDAO.getStudentsDataBySubject(studentID, subjectID);

	}
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public ArrayList<Date> getLessonDatesBySubject(int subjectID) {
		return lessonDAO.getLessonDatesBySubject(subjectID);

	}

	public void updateLesson(Lesson lesson) {
		lessonDAO.updateLesson(lesson);

	}

	public ArrayList<Lesson> getMarksFromSubject(int subjectID) {

		return lessonDAO.getMarksBySubject(subjectID);

	}

	public int getSubjectByLessonID(int lessonID) {
		return lessonDAO.getLessonByID(lessonID).getSubjectID();

	}

	public ArrayList<Lesson> getLessonsBySubject(int subjectID) {
		return lessonDAO.getLessonsBySubject(subjectID);
	}

	public ArrayList<Lesson> getLessonsByStudent(int studentID) {
		return lessonDAO.getLessonsByStudent(studentID);
	}

	public Lesson getLessonByID(int lessonID) {
		return lessonDAO.getLessonByID(lessonID);

	}

	public long getStudentsTotalMarkFromSubject(int studentID, int subjectID) {
		return lessonDAO.getStudentsTotalMarkFromSubject(studentID, subjectID);

	}

}
