package org.akceptor.ijournal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.akceptor.ijournal.domain.Subject;
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
		return hibernateTemplate.find("from Subject order by subject_id");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Subject> findSubjectsByCourse(int courseID) {
		return (ArrayList<Subject>) hibernateTemplate.find("from Subject where course_id =" + courseID +" order by subject_name");
	}

}
