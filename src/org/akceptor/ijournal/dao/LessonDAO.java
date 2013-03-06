package org.akceptor.ijournal.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.akceptor.ijournal.domain.Lesson;

public interface LessonDAO {
	public void addLesson(Lesson lesson);
	public void updateLesson(Lesson lesson);
	public void delete(Lesson lesson);
	public Lesson getLessonByNumber(int lesson_number);
	public List<Lesson> findLessons();
	public ArrayList<Lesson> getStudentsMarksBySubject(int studentID, int subjectID);
	public ArrayList<Date> getLessonDatesBySubjectAndGroup(int subjectID, int groupID);
	public ArrayList<Lesson> getMarksBySubject(int groupID, int subjectID);
	public Lesson getLessonByID(int lessonID);
	
	public ArrayList<Lesson> getLessonsBySubject(int subjectID);
}