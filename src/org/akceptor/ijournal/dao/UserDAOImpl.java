package org.akceptor.ijournal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.domain.User;
import javax.sql.DataSource;

@Repository
public class UserDAOImpl implements UserDAO {
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
	public void addUser(User user) {
		hibernateTemplate.save(user);
		hibernateTemplate.flush();
	}

	@Transactional
	public void updateUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
		hibernateTemplate.flush();
	}

	@Transactional
	public void delete(User user) {
		hibernateTemplate.delete(user);
		hibernateTemplate.flush();
	}

	@Transactional
	public User getUserByName(String name) {
		
		try 
		{
			return (User) hibernateTemplate.find("from User WHERE username='"+name+"'").get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> findUsers() {
		return hibernateTemplate.find("from User order by username");
	}
	
	@Transactional
	public int getLastUser() {
		User currentUser = (User) hibernateTemplate.find("from User order by user_id DESC").get(0);
		return currentUser.getUserID();
	}
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	public User getUserByID(int userID) {
		System.out.println("userID in DAO: "+userID);
		return (User) hibernateTemplate.find("from User WHERE user_id= "+userID).get(0);
	}
}
