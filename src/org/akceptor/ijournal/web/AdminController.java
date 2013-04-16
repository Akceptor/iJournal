package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.service.DateService;
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

/*
 * Handles main admin page and all adding stuff for administrator role
 */

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
	@Autowired
	DateService dateService;
	
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
		
		/*
		 * Adding new user
		 */
		@RequestMapping(method = RequestMethod.POST, value="/adduser")
		public String addUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
			
		//Add student called
		if (request.getParameter("role").equals("1")){
			int groupNr = 0;
			//Adding new student record
				try{
					groupNr = Integer.parseInt(request.getParameter("groupNr"));
				} catch (Exception e){
					groupNr = 0;
				}
			System.out.println("ADDING STUDENT USER "+request.getParameter("username")+" with pass "+request.getParameter("password"));
			userService.addUser(request.getParameter("username"), request.getParameter("password"), 
					Integer.parseInt(request.getParameter("role")), request.getParameter("studentname"), 
					request.getParameter("bookNr"), groupNr, "");
			}
		
			//Add teacher called
			if (request.getParameter("role").equals("2")){
				//Adding new teacher record
				System.out.println("ADDING TEACHER USER "+request.getParameter("username")+" with pass "+request.getParameter("password"));
				userService.addUser(request.getParameter("username"), request.getParameter("password"), 
						Integer.parseInt(request.getParameter("role")), "", "", 0, request.getParameter("teachername"));
			}
				
			//Add administrator called
			if (request.getParameter("role").equals("3")){
				//Adding new admin record
				System.out.println("ADDING ADMINISTRATOR USER "+request.getParameter("username")+" with pass "+request.getParameter("password"));
				userService.addUser(request.getParameter("username"), request.getParameter("password"), 
						Integer.parseInt(request.getParameter("role")), "", "", 0, "");
			}
		
		return "redirect:/admin";
		}
		
		/*
		 * Adding new subject
		 */
		@RequestMapping(method = RequestMethod.POST, value="/addsubject")
		public String addSubject(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		System.out.println("ADD Subject "+request.getParameter("subject"));
		subjectService.addSubject(request.getParameter("subject"));
		return "redirect:/admin";
		}
		
		/*
		 * Adding new group
		 */
		@RequestMapping(method = RequestMethod.POST, value="/addgroup")
		public String addGroup(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		System.out.println("ADD Group "+request.getParameter("group"));
		groupService.addGroup(request.getParameter("group"));
		return "redirect:/admin";
		}
		
		/*
		 * Adding new academic year dates
		 */
		@RequestMapping(method = RequestMethod.POST, value="/newyear")
		public String addYear(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		
		dateService.generateCalendar(2012, true);
		return "redirect:/admin";
		}

}