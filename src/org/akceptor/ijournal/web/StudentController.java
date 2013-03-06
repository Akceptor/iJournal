package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.domain.Credentials;
import org.akceptor.ijournal.service.LessonService;
import org.akceptor.ijournal.service.StudentService;
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
	
	
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView studentPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student");
		System.err.println(Credentials.getUserName());	
		int studentID = 1;
		
		System.err.println(lessonService.getStudentsMarkFromSubject(studentID, 1).get(0).getMark());

		
		return mav;
	}

}