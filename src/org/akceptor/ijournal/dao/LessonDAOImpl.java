package org.akceptor.ijournal.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.domain.Lesson;

import javax.sql.DataSource;

@Repository
public class LessonDAOImpl implements LessonDAO {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private DataSource dataSource;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	  * Gets marks for student from DB
	  *
	  * @param studentID - id for current student
	  * @param subjectID - id for subject to get marks from
	  * @return Integer arraylist filled with student's marks 
	  */	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Integer> getStudentsMarksBySubject(int studentID, int subjectID) {
	
		return (ArrayList<Integer>) hibernateTemplate.find("select l.mark from Lesson as l where l.student_id=" + studentID +" and l.subject_id="+subjectID);
	}
	
	/**
	  * Gets marks/absences for student from DB
	  *
	  * @param studentID - id for current student
	  * @param subjectID - id for subject to get marks from
	  * @return Arraylist of Lesson type (can get marks, absence marks, lesson dates, subject ID's and from here). For more info refer to Lesson table in DB or Lesson.class 
	  */	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Lesson> getStudentsDataBySubject(int studentID, int subjectID) {
	
		return (ArrayList<Lesson>) hibernateTemplate.find("select l from Lesson as l where l.student_id=" + studentID +" and l.subject_id="+subjectID);
	}
	
	/**
	  * Gets marks/absences for all students and selected subject from DB
	  *
	  * @param subjectID - id for subject to get marks from
	  * @return Arraylist of Lesson type (can get marks, absence marks, lesson dates, subject ID's and from here). For more info refer to Lesson table in DB or Lesson.class 
	  */	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Lesson> getMarksBySubject(int subjectID) {
	
		return (ArrayList<Lesson>) hibernateTemplate.find("select l from Lesson as l where l.subject_id="+subjectID);
	}
	
	/**
	  * Gets lesson dates for selected subject from DB
	  *
	  * @param subjectID - id for subject to get marks from
	  * @return Arraylist of Date type, filled with lesson dates for selected subject
	  */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Date> getLessonDatesBySubject(int subjectID) {
		//System.err.println("LessonDAO");
		return (ArrayList<Date>) hibernateTemplate.find("select distinct l.lesson_date from Lesson as l where l.subject_id="+subjectID);//+" and l.group_id="+groupID);
	}
	
	/**
	  * Gets list of lessons per selected subject
	  *
	  * @param subjectID - id for subject to get marks from
	  * @return Arraylist of Lesson type for selected subject 
	  */
	@SuppressWarnings("unchecked")
	@Transactional 
	public ArrayList<Lesson> getLessonsBySubject(int subjectID) {
		return (ArrayList<Lesson>) hibernateTemplate.find("from Lesson as l where l.subject_id="+subjectID);
	}
	
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	@Transactional
	public void updateLesson(Lesson lesson) {
		hibernateTemplate.saveOrUpdate(lesson);
		hibernateTemplate.flush();
		
	}

	@Override
	public void addLesson(Lesson lesson) {
		hibernateTemplate.save(lesson);
		hibernateTemplate.flush();
		
	}

	@Override
	public void delete(Lesson lesson) {
		hibernateTemplate.delete(lesson);
		hibernateTemplate.flush();
		
	}

	@Override
	public Lesson getLessonByNumber(int lesson_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findLessons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public Lesson getLessonByID(int lessonID) {
			return hibernateTemplate.get(Lesson.class, lessonID);
	}

	/**
	  * Gets marks/absences for student from DB
	  *
	  * @param studentID - id for current student
	  * @return Arraylist of Lesson type for seledcted student 
	  */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Lesson> getLessonsByStudent(int studentID) {
		return (ArrayList<Lesson>) hibernateTemplate.find("from Lesson as l where l.sudent_id="+studentID);
	}

}
