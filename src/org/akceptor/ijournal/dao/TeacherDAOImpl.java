package org.akceptor.ijournal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.domain.Teacher;

import javax.sql.DataSource;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
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
	public void addTeacher(Teacher teacher) {
		hibernateTemplate.save(teacher);
		hibernateTemplate.flush();
	}

	@Transactional
	public void delete(Teacher teacher) {
		hibernateTemplate.delete(teacher);
		hibernateTemplate.flush();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Teacher> findTeachers() {
		return hibernateTemplate.find("from Teacher order by teacher_fio");
	}
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		hibernateTemplate.saveOrUpdate(teacher);
		hibernateTemplate.flush();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Teacher> getTeacherByUserID(int userID) {
		return hibernateTemplate.find("from Teacher where user_id =" + userID);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getTeacherByID(int teacherID) {
		return hibernateTemplate.find("from Teacher where teacher_id =" + teacherID);
	}
}
