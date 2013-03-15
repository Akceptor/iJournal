package org.akceptor.ijournal.dao;

import java.util.List;

import org.akceptor.ijournal.domain.Teacher;

public interface TeacherDAO {
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public void delete(Teacher teacher);
	public List<Teacher> findTeachers();
	public List<Teacher> getTeacherByUserID(int userID);
	public List<Teacher> getTeacherByID(int teacherID);

}
