package org.akceptor.ijournal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.akceptor.ijournal.domain.Subject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
	
	
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

	@Transactional
	public void addSubject(Subject subject) {
		hibernateTemplate.save(subject);
		hibernateTemplate.flush();
	}

	@Transactional
	public void delete(Subject subject) {
		hibernateTemplate.delete(subject);
		hibernateTemplate.flush();
	}

		public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	
	
		@Override
	public void updateSubject(Subject subject) {
			hibernateTemplate.saveOrUpdate(subject);
			hibernateTemplate.flush();
		
	}

	@Override
	public Subject getSubjectByName(String subjectName) {
		return hibernateTemplate.get(Subject.class, subjectName);
		
	}

	@Override
	public Subject getSubjectByID(int subjectID) {
		return hibernateTemplate.get(Subject.class, subjectID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findSubjects() {
		return hibernateTemplate.find("FROM Subject ORDER BY subjectID");
	}
	
	/**
	  * Gets subjects, where selected student was enrolled
	  *
	  * @param studentID - id for current student
	  * @return List of subjects for that student as a part from Subject table 
	  */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findSubjectsByStudentID(int studentID) {
		StringBuffer queryString = new StringBuffer();
		queryString.append("FROM Subject AS s WHERE s.subjectID IN (SELECT l.subjectID FROM Lesson AS l WHERE l.studentID=");
		queryString.append(studentID);
		queryString.append(")");
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString.toString());
		List<Subject> result = query.list();
		return result;
	}
	
	/**
	  * Gets subjects for selected teacher
	  *
	  * @param teacherID - id for current student
	  * @return List of subjects for that teacher
	  */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findSubjectsForTeacher(int teacherID) {
		//Made as native query because of copy-pasting :)
		StringBuffer queryString = new StringBuffer();
		queryString.append("FROM Subject WHERE teacher_id=");
		queryString.append(teacherID);
		queryString.append(")");
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString.toString());
		List<Subject> result = query.list();
		return result;
		
	}

	}
