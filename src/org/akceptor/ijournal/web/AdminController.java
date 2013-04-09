package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.service.GroupService;
import org.akceptor.ijournal.service.StudentService;
import org.akceptor.ijournal.service.SubjectService;
import org.akceptor.ijournal.service.TeacherService;
import org.akceptor.ijournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired 
	StudentService studentService;
	@Autowired 
	GroupService groupService;
	@Autowired 
	TeacherService teacherService;
	@Autowired 
	SubjectService subjectService;
	
		@RequestMapping(method = RequestMethod.GET)
		/*
		 * Handles main admin page with all lists
		 */
		public ModelAndView adminPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userService.findUsers());
		mav.addObject("studentList", studentService.getStudents());
		mav.addObject("groupList", groupService.getGroups());
		mav.addObject("teacherList", teacherService.getTeachers());
		mav.addObject("subjectList", subjectService.findSubjects());
		mav.setViewName("admin");
		return mav;
		}
		
		@RequestMapping(method = RequestMethod.POST, value="/adduser")
		public String addUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		System.out.println("ADD USER "+request.getParameter("username")+" with pass "+request.getParameter("password"));
		userService.addUser(request.getParameter("username"), request.getParameter("password"));
		return "redirect:/admin";
		}
		
		@RequestMapping(method = RequestMethod.POST, value="/edituser")
		public String editUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		if (request.getParameter("editbtn")!=null){
			System.out.println("Edit button pressed "+ request.getParameter("editbtn"));
			
		};
		if (request.getParameter("deletebtn")!=null){
			System.out.println("Delete button pressed "+ request.getParameter("deletebtn"));
			userService.deleteUser(Integer.parseInt(request.getParameter("deletebtn")));
		};
		return "redirect:/admin";
		}

}