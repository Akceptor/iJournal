package org.akceptor.ijournal.dao;

import java.util.List;

import org.akceptor.ijournal.domain.Group;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

@Repository
public class GroupDAOImpl implements GroupDAO {
	
	private HibernateTemplate hibernateTemplate;
	private DataSource dataSource;
	private SessionFactory sessionFactory;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
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

	@Override
	@Transactional
	public void addGroup(Group group) {
		hibernateTemplate.save(group);
		hibernateTemplate.flush();
		
	}

	@Override
	@Transactional
	public void updateGroup(Group group) {
		hibernateTemplate.saveOrUpdate(group);
		hibernateTemplate.flush();
		
	}

	@Override
	@Transactional
	public void delete(Group group) {
		hibernateTemplate.delete(group);
		hibernateTemplate.flush();
		
	}

	@Override
	@Transactional
	public Group getGroupByName(String groupName) {
		return hibernateTemplate.get(Group.class, groupName);
	}
	
	@Override
	@Transactional
	public Group getGroupByID(int groupID) {
		System.out.println("Searching for groupID "+groupID);
		try{
			return (Group) hibernateTemplate.find("FROM Group AS g WHERE g.groupID="+groupID).get(0);
		} catch (IndexOutOfBoundsException e){
			System.err.println("Group ID does not exist: "+groupID);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Group> findGroups() {
		return hibernateTemplate.find("from Group order by group_name");
	}
	
}
