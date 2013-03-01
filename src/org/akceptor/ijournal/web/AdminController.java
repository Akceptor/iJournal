package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView studentPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		//System.out.println(request.getContentLength());
		return mav;
	}

}