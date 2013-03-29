package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

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
	
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView adminPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userService.findUsers());
		mav.setViewName("admin");
		//System.out.println(request.getContentLength());
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
		if (request.getParameter("editbtn")!=null){System.out.println("Edit button pressed");};
		if (request.getParameter("deletebtn")!=null){System.out.println("Delete button pressed");};
		return "redirect:/admin";
		}

}