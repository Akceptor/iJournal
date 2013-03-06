package org.akceptor.ijournal.domain;

import java.util.ArrayList;

import org.akceptor.ijournal.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Consists of all lessons for single group and subject
 */
public class Work {
	@Autowired
	LessonService lessonService;
	
	private ArrayList<Lesson> students;
	private ArrayList<ArrayList<Lesson>> work;

	public ArrayList<Lesson> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Lesson> students) {
		this.students = students;
	}

	public ArrayList<ArrayList<Lesson>> getWork() {
		return work;
	}

	public void setWork(ArrayList<ArrayList<Lesson>> work) {
		this.work = work;
	}
	

}
