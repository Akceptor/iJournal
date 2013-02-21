package org.akceptor.ijournal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.domain.Student;
import javax.sql.DataSource;

@Repository
public class StudentDAOImpl implements StudentDAO {
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
	public void addStudent(Student student) {
		hibernateTemplate.save(student);
		hibernateTemplate.flush();
	}

	@Transactional
	public void delete(Student student) {
		hibernateTemplate.delete(student);
		hibernateTemplate.flush();
	}

	@Transactional
	public Student getStudentByFIO(String studentFIO) {
		return hibernateTemplate.get(Student.class, studentFIO);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> findStudents() {
		return hibernateTemplate.find("from Student order by student_fio");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Student> findStudentsByGroup(int groupID) {
		return (ArrayList<Student>) hibernateTemplate.find("from Student where group_id =" + groupID +" order by student_fio");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Lesson> getStudentsMarksBySubject(int studentID, int subjectID) {
		ArrayList<Lesson> ololo = (ArrayList<Lesson>) hibernateTemplate.find("from Lesson where student_id =" + studentID +" and subject_id="+subjectID);
		
		
		return ololo;
	}
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.saveOrUpdate(student);
		hibernateTemplate.flush();
		
	}

	@Override
	@Transactional
	public Student getStudentByBookNr(String bookNr) {
		return hibernateTemplate.get(Student.class, bookNr);
	}
}
