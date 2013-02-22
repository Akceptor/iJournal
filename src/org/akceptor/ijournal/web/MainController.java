package org.akceptor.ijournal.web;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.domain.Student;
import org.akceptor.ijournal.domain.Subject;
import org.akceptor.ijournal.service.GroupService;
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
			currentGroup = groupService.getGroupByID(Integer
					.parseInt(selectedGroup));
			currentSubject = subjectService.getSubjectByID(Integer
					.parseInt(selectedSubject));
		}
		try {
			mav.addObject("selectedGroup", currentGroup);
			mav.addObject("selectedSubject", currentSubject);
			mav.addObject("groupMembers",
					groupService.getGroupMembersByID(currentGroup.getId()));
			mav.addObject("subjectDates",
					subjectService.getSubjectDatesByID(currentSubject.getId()));
			// adding students marks for studentID & subjectID

			ArrayList<ArrayList<Integer>> allStudentMarks = new ArrayList<ArrayList<Integer>>();
			//int groupSize = groupService.getGroupSizeByID(currentGroup.getId());
			//System.err.println("Students in group " + groupSize);
			for (Student student : groupService
					.getGroupMembersByID(currentGroup.getId())) {// for each
																	// student
				ArrayList<Integer> studentMarks = new ArrayList<Integer>();
				//int marksNumber = subjectService.getStudentsMarkFromSubject(student.getId(), currentSubject.getId()).size();
				//System.err.println("Marks quantity: " + marksNumber);

				for (Lesson lesson : subjectService.getStudentsMarkFromSubject(
						student.getId(), currentSubject.getId())) {// get all
																	// marks
					studentMarks.add(lesson.getMark());
				}
				allStudentMarks.add(studentMarks);
				// System.err.print(" "+allStudentMarks);

			}
			System.err.print(" " + allStudentMarks);
			mav.addObject("studentMarks", allStudentMarks);

		} catch (Exception e) {
			return mav;
		}
		;
		// mav.addObject(attributeName, attributeValue);
		// } else
		// {
		// mav.addObject("selectedGroup", currentGroup);
		// mav.addObject("selectedSubject",
		// subjectService.getSubjectByID(currentGroup.getId()));
		// mav.addObject("groupMembers", groupService.getGroupMembersByID(1));
		// mav.addObject("subjectDates", subjectService.getSubjectDatesByID(1));
		// };
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