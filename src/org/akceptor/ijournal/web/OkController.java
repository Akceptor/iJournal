package org.akceptor.ijournal.web;

import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.service.LessonService;
import org.akceptor.ijournal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/ok")
public class OkController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private LessonService lessonService;

	@RequestMapping(method = RequestMethod.POST)
	//Getting student names, marks and absence flags
	public ModelAndView showOkMessagePOST(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ok");
		/**
		 *  Okay, that's VERY bad stuff, I know.
		 *  I'll make this properly later...
		 */
		Lesson lesson;
		int studentID;
		int mark;
		int absence;
		int lessonID = 0;
		for (int i=0;i<request.getParameterValues("student").length;i++)//get students quantity as an appropriate arrays length
		{
			try{
				studentID = Integer.parseInt(request.getParameterValues("student")[i]);
				//trying parse student IDs from request
			} catch (Exception e) {
				studentID=0;
				//not existing student
			}
			
			System.out.println(studentID+" "+studentService.getStudentFIOByID(studentID));//just print student's ID and name
			
			for (int j=(i)*(request.getParameterValues("mark").length)/(request.getParameterValues("student").length);j<(i+1)*(request.getParameterValues("mark").length)/(request.getParameterValues("student").length);j++)
			//dividing marks quantity to student's quantity so getting marks-per-student value
			//than creating loop to print one student's marks in line, using the "/" operator for division without rest
			{
				try{
					//trying parse current student's mark and corresponding lesson ID
					mark = Integer.parseInt(request.getParameterValues("mark")[j]);
					lessonID = Integer.parseInt(request.getParameterValues("lessonid")[j]);
					absence = Integer.parseInt(request.getParameterValues("present")[j]);
				} catch (Exception e) {
					mark=0;
					absence = 0;
					lessonID=0;//not existing lesson ID
				}
				System.out.print(lessonID+" ");//marks
				//Get every lesson from DB
				//because of problems with  @org.hibernate.annotations.Entity(dynamicUpdate = true)
				//I'll just take all lesson and change mark and/or absence fields
				//absence will be added later
				
				lesson = lessonService.getLessonByID(lessonID);
				//set parsed student ID
				lesson.setStudent_id(studentID);
				//set mark 4 that student
				lesson.setMark(mark);
				//set absence flag 4 that student
				lesson.setAbsense(absence);
				//set ID 4 that lesson
				lesson.setLesson_id(lessonID);
				
				lessonService.updateLesson(lesson);
			}
			
			//
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