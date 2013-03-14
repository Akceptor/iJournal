package org.akceptor.ijournal.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.domain.Credentials;
import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.domain.Student;
import org.akceptor.ijournal.domain.Subject;
import org.akceptor.ijournal.service.LessonService;
import org.akceptor.ijournal.service.StudentService;
import org.akceptor.ijournal.service.SubjectService;
import org.akceptor.ijournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	LessonService lessonService;
	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	@Autowired
	SubjectService subjectService;

	@RequestMapping
	public ModelAndView studentPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student");

		// get user's ID from Spring security via credentials
		int userID = userService.getUserIDByName(Credentials.getUserName());
		System.err.println("Entered user with " + userID);
		// get student's ID from database based on userID
		userID = studentService.getStudentIDByUserID(userID);
		System.err.println("Student'z ID is " + userID);

		mav.addObject("subjectList",
				subjectService.findSubjectsByStudentID(userID));

		// adding students marks for studentID & subjectID
		// TODO Move this to Service layer
		ArrayList<ArrayList<Date>> allLessonDates = new ArrayList<ArrayList<Date>>();
		ArrayList<ArrayList<Integer>> allMarks = new ArrayList<ArrayList<Integer>>();

		for (Student student : studentService.getStudentByID(userID)) {// for
																		// each
																		// student
			for (Subject subject : subjectService.findSubjects()) {// get all
				 { // marks
					allLessonDates.add(lessonService
							.getLessonDatesBySubject(subject.getId()));
					allMarks.add(lessonService.getStudentsMarkFromSubject(
							userID, subject.getId()));
				}

			}

		}

		mav.addObject("lessonDates", allLessonDates);

		System.err.print(" " + allMarks);
		mav.addObject("allMarks", allMarks);

		return mav;
	}

}