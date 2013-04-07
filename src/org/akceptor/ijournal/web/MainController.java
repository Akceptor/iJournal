package org.akceptor.ijournal.web;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.akceptor.ijournal.domain.Credentials;
import org.akceptor.ijournal.domain.Group;
import org.akceptor.ijournal.domain.Lesson;
import org.akceptor.ijournal.domain.Student;
import org.akceptor.ijournal.domain.Subject;
import org.akceptor.ijournal.service.GroupService;
import org.akceptor.ijournal.service.LessonService;
import org.akceptor.ijournal.service.SubjectService;
import org.akceptor.ijournal.service.TeacherService;
import org.akceptor.ijournal.service.UserService;
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
	@Autowired
	UserService userService;
	@Autowired
	TeacherService teacherService;
	
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
			//TO DO Move this to Service layer 
			ArrayList<ArrayList<Integer>> allStudentMarks = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> allLessonIDs = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> allAbsenceMarks = new ArrayList<ArrayList<Integer>>();
			ArrayList<Long> totalMarks = new ArrayList<Long>();
			ArrayList<Integer> totalAbs = new ArrayList<Integer>();
			ArrayList<Integer> totalAbsOk = new ArrayList<Integer>();
				for (Student student : groupService
					.getGroupMembersByID(currentGroup.getId())) {// for each
																	// student
				ArrayList<Integer> studentMarks = new ArrayList<Integer>();
				ArrayList<Integer> lesonIDs = new ArrayList<Integer>();
				ArrayList<Integer> absenceMarks = new ArrayList<Integer>();
							
				int totalAbsence = 0;//Summary for "H" marks
				int totalAbsenceOk = 0;//Summary for "R" marks
				for (Lesson lesson : lessonService.getStudentsDataFromSubject(
						student.getStudentID(), currentSubject.getSubjectID())) {// get all
																	// marks
					studentMarks.add(lesson.getMark());
					if (lesson.getAbsense()==1){
						totalAbsence=totalAbsence+lesson.getAbsense();
					}
					if (lesson.getAbsense()==2){
						totalAbsenceOk=totalAbsenceOk+lesson.getAbsense()/2;
					}
					lesonIDs.add(lesson.getLessonID());
					absenceMarks.add(lesson.getAbsense());
					
				}
				
				totalMarks.add(lessonService.getStudentsTotalMarkFromSubject(student.getStudentID(), currentSubject.getSubjectID()));//add summary score
				totalAbs.add(totalAbsence);//add summary score
				totalAbsOk.add(totalAbsenceOk);//add summary score for worked-out absences
				allStudentMarks.add(studentMarks);
				allLessonIDs.add(lesonIDs);
				allAbsenceMarks.add(absenceMarks);

			}
			//mav.addObject("studentMarks", allStudentMarks);	
				
			System.err.print(" " + allStudentMarks);
			mav.addObject("studentMarks", allStudentMarks);
			mav.addObject("totalMark", totalMarks);
			mav.addObject("lessonIDs", allLessonIDs);
			mav.addObject("absenceMarks", allAbsenceMarks);
			mav.addObject("totalAbs", totalAbs);
			mav.addObject("totalAbsOk", totalAbsOk);
			//adding dates
			mav.addObject("subjectDates",lessonService.getLessonDatesBySubject(currentSubject.getSubjectID()));

			
			

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
		// get user's ID from Spring security via credentials
				int userID = userService.getUserIDByName(Credentials.getUserName());
				System.err.println("Entered user with " + userID);
				// get student's ID from database based on userID
				try {
				userID = teacherService.getTeacherIDByUserID(userID);
				System.err.println("Teacher'z ID is " + userID);
				mav.addObject("groups", groupService.getGroups());
				mav.addObject("subjects", subjectService.getSubjectsForTeacher(userID));
				} catch (Exception e) {
					//Not a teacher. So, probably, admin (or hacker)
					System.err.println("NOT A TEACHER");
					mav.addObject("groups", groupService.getGroups());
					mav.addObject("subjects", subjectService.getSubjects());
				}finally {
					System.err.println("UserRole is " + Credentials.getUserRole());
				}
	
		return mav;
	}
	
}