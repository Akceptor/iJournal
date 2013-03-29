package org.akceptor.ijournal.dao;

import org.akceptor.ijournal.domain.UserDetails;
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
	public UserDetails getUserRoleByID(int userID) {
		try {
			//trying find user details for selected user
			return (UserDetails) hibernateTemplate.find("select ud from UserDetails as ud where ud.userID="+userID).get(0);
		} catch (Exception e){
			//if no details record - return NONE
			UserDetails ud= new UserDetails();
			ud.setAuthority("NONE");
			return ud;
		}
	}


	
}
