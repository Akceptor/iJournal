package org.akceptor.ijournal.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.domain.UsersAndRoles;

import javax.sql.DataSource;

@Repository
public class UserAndRoleDAOImpl implements UserAndRoleDAO {
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

	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@Transactional
	public void addUserAndRole(UsersAndRoles userRole) {
		hibernateTemplate.save(userRole);
		hibernateTemplate.flush();
	}

	@Transactional
	public void updateUserAndRole(UsersAndRoles userRole) {
		hibernateTemplate.saveOrUpdate(userRole);
		hibernateTemplate.flush();
		
	}

	@Transactional
	public void deleteUserAndRole(UsersAndRoles userRole) {
		hibernateTemplate.delete(userRole);
		hibernateTemplate.flush();
		
	}
}
