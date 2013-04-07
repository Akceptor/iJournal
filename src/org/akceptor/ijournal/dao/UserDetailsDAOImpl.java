package org.akceptor.ijournal.dao;

import org.akceptor.ijournal.domain.UserRoles;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
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
	public UserRoles getUserRoleByID(int userID) {
		try {
			// trying find user details for selected user
			StringBuffer queryString = new StringBuffer();
			queryString.append("SELECT ur.authority FROM UserRoles AS ur, User AS u, UsersAndRoles AS unr ");
			queryString.append("WHERE (unr.userID = u.userID) AND (unr.userRoleID = ur.userRoleID) ");
			queryString.append("AND (u.userID=");
			queryString.append(userID);
			queryString.append(")");
			Query query = hibernateTemplate.getSessionFactory().openSession()
					.createQuery(queryString.toString());
			UserRoles ud = new UserRoles();
			ud.setAuthority((String) query.list().get(0));
			return ud;
		} catch (Exception e) {
			// if no details record - return NONE
			UserRoles ud = new UserRoles();
			ud.setAuthority("AUTH_NONE");
			return ud;
		}
	}

}
