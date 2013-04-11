package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.service.GroupService;
import org.akceptor.ijournal.service.SubjectService;
import org.akceptor.ijournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/*
 * Handles editing and deleting stuff for administrator role
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminEditController {
	
	@Autowired
	UserService userService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	GroupService groupService;
	
	/*
	 * Editing existed user
	 */
	@RequestMapping(method = RequestMethod.POST, value="/edituser")
	public String editUser(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("admin");
	if (request.getParameter("editbtn")!=null){
		System.out.println("Edit button pressed "+ request.getParameter("editbtn"));
		
	};
	if (request.getParameter("deletebtn")!=null){
		System.out.println("Delete button pressed "+ request.getParameter("deletebtn"));
		int userID = Integer.parseInt(request.getParameter("deletebtn"));
		userService.deleteUser(userID);
		
	};
	return "redirect:/admin";
	}
	
	/*
	 * Editing existed subject
	 */
	@RequestMapping(method = RequestMethod.POST, value="/editsubject")
	public String editSubject(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("admin");
	if (request.getParameter("editbtn")!=null){
		System.out.println("Edit button pressed "+ request.getParameter("editbtn"));
		
	};
	if (request.getParameter("deletebtn")!=null){
		System.out.println("Delete button pressed "+ request.getParameter("deletebtn"));
		subjectService.deleteSubject(Integer.parseInt(request.getParameter("deletebtn")));
	};
	return "redirect:/admin";
	}
	
	/*
	 * Editing existed group
	 */
	@RequestMapping(method = RequestMethod.POST, value="/editgroup")
	public String editGroup(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("admin");
	if (request.getParameter("editbtn")!=null){
		System.out.println("Edit button pressed "+ request.getParameter("editbtn"));
		
	};
	if (request.getParameter("deletebtn")!=null){
		System.out.println("Delete button pressed "+ request.getParameter("deletebtn"));
		groupService.deleteGroup(Integer.parseInt(request.getParameter("deletebtn")));
	};
	return "redirect:/admin";
	}

}
