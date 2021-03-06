package org.akceptor.ijournal.dao;

import java.util.ArrayList;
import java.util.List;

import org.akceptor.ijournal.domain.Student;

public interface StudentDAO {
	public void updateStudent(Student student);
	public void delete(Student student);
	public Student getStudentByFIO(String studentFIO);
	public Student getStudentByBookNr(String bookNr);
	public List<Student> findStudents();
	public ArrayList<Student> findStudentsByGroup(int groupID);
	public String getStudentFIOByID(int studentID);
	public Student getStudentByUserID(int userID);
	public List<Student> getStudentByID(int studentID);

}