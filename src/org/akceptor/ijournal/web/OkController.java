package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/ok")
public class OkController {


	@RequestMapping(method = RequestMethod.POST)
	//Getting student names, marks and absense flags
	public ModelAndView showOkMessagePOST(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ok");
		/**
		 *  Okay, that's VERY bad stuff, I know.
		 *  I'll make this properly later...
		 */
		for (int i=0;i<request.getParameterValues("student").length;i++)//get students quantity as an appropriate arrays length
		{
			System.out.println(request.getParameterValues("student")[i]);//just print student's name
			for (int j=(i)*(request.getParameterValues("mark").length)/(request.getParameterValues("student").length);j<(i+1)*(request.getParameterValues("mark").length)/(request.getParameterValues("student").length);j++)
			//dividing marks quantity to student's quantity so getting marks-per-student value
			//than creating loop to print one student's marks in line, using the "/" operator for division without rest
			{
				System.out.print(request.getParameterValues("mark")[j]+" ");//marks
			}
			System.out.println();
			System.out.println();
		}
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	// For future use :)
	public ModelAndView showOkMessageGET(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ok");
		//System.out.println(request.getContentLength());
		return mav;
	}

}