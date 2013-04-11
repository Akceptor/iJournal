package org.akceptor.ijournal.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.akceptor.ijournal.domain.Lesson;

public interface LessonDAO {
	public void addLesson(Lesson lesson);
	public void updateLesson(Lesson lesson);
	public void delete(Lesson lesson);
	public Lesson getLessonByNumber(int lessonNumber);
	public List<Lesson> findLessons();
	public ArrayList<Integer> getStudentsMarksBySubject(int studentID, int subjectID);
	public ArrayList<Date> getLessonDatesBySubject(int subjectID);
	public ArrayList<Lesson> getMarksBySubject(int subjectID);
	public Lesson getLessonByID(int lessonID);
	
	public ArrayList<Lesson> getLessonsBySubject(int subjectID);
	public ArrayList<Lesson> getLessonsByStudent(int studentID);
	public ArrayList<Lesson> getStudentsDataBySubject(int studentID,
			int subjectID);
	public Long getStudentsTotalMarkFromSubject(int studentID, int subjectID);
}