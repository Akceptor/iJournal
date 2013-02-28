package org.akceptor.ijournal.web;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.domain.Student;
import org.akceptor.ijournal.domain.Subject;
import org.akceptor.ijournal.service.GroupService;
import org.akceptor.ijournal.service.LessonService;
import org.akceptor.ijournal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/hello")
public class MainController {
	@Autowired
	GroupService groupService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	LessonService lessonService;
	private static Group currentGroup;
	private static Subject currentSubject;

	/**
	 * Method provides data for inbox.jsp. Most of requests mapped to this
	 * controller are redirected to this method
	 */
	@RequestMapping(method = RequestMethod.POST)
	//
	public ModelAndView showSelectedOptipons(HttpServletRequest request) {
		String selectedGroup = "none";
		String selectedSubject = "none";
			// Group and subject selected. Show them
		if (request != null) {
			// Map<String, String[]> parameters = request.getParameterMap();
			selectedGroup = request.getParameter("Group");
			selectedSubject = request.getParameter("Subject");
			
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");

		if (selectedGroup != null) {
			//Came from group selection
			currentGroup = groupService.getGroupByID(Integer
					.parseInt(selectedGroup));
			currentSubject = subjectService.getSubjectByID(Integer
					.parseInt(selectedSubject));
		} else {
			//Came from marks Submit
						
		};
		
		try {
			//adding selected group and subject info
			mav.addObject("selectedGroup", currentGroup);
			mav.addObject("selectedSubject", currentSubject);
			//adding student list
			mav.addObject("groupMembers",
					groupService.getGroupMembersByID(currentGroup.getId()));
			
			
			// adding students marks for studentID & subjectID
			ArrayList<ArrayList<Integer>> allStudentMarks = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> allLessonIDs = new ArrayList<ArrayList<Integer>>();
				for (Student student : groupService
					.getGroupMembersByID(currentGroup.getId())) {// for each
																	// student
				ArrayList<Integer> studentMarks = new ArrayList<Integer>();
				ArrayList<Integer> lesonIDs = new ArrayList<Integer>();
				
				for (Lesson lesson : lessonService.getStudentsMarkFromSubject(
						student.getId(), currentSubject.getId())) {// get all
																	// marks
					studentMarks.add(lesson.getMark());
					lesonIDs.add(lesson.getLesson_id());
				}
				allStudentMarks.add(studentMarks);
				allLessonIDs.add(lesonIDs);

			}
			System.err.print(" " + allStudentMarks);
			mav.addObject("studentMarks", allStudentMarks);
			mav.addObject("lessonIDs", allLessonIDs);
			//adding dates
			mav.addObject("subjectDates",lessonService.getLessonDatesBySubject(currentSubject.getId(), currentGroup.getId()));

			
			

		} catch (Exception e) {
			return mav;
		};
		
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	// First Login - select group and subject
	public ModelAndView selectGroupAndSubject() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("groups", groupService.getGroups());
		mav.addObject("subjects", subjectService.getSubjects());
		return mav;
	}

}