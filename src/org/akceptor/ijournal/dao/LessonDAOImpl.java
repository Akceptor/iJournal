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

		
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Lesson> getStudentsMarksBySubject(int studentID, int subjectID) {
	
		return (ArrayList<Lesson>) hibernateTemplate.find("select l from Lesson as l where l.student_id=" + studentID +" and l.subject_id="+subjectID);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Lesson> getMarksBySubject(int groupID, int subjectID) {
	
		return (ArrayList<Lesson>) hibernateTemplate.find("select l from Lesson as l where l.subject_id="+subjectID);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Date> getLessonDatesBySubjectAndGroup(int subjectID, int groupID) {
		//System.err.println("LessonDAO");
		return (ArrayList<Date>) hibernateTemplate.find("select distinct l.lesson_date from Lesson as l where l.subject_id="+subjectID);//+" and l.group_id="+groupID);
	}
	
	/*
	 * Gets list of lessons per selected subject
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

}
