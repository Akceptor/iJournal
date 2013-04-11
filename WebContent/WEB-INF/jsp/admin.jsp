<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Area</title>

<script type="text/javascript">
	function showOne(){
		document.getElementById("tab-one").hidden = false;
		document.getElementById("tab-two").hidden = true;
		document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = true;
		document.getElementById("tab-five").hidden = true;
};
    
    function showTwo(){
		document.getElementById("tab-one").hidden = true;
		document.getElementById("tab-two").hidden = false;
		document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = true;
		document.getElementById("tab-five").hidden = true;
};

    function showThree(){
		document.getElementById("tab-one").hidden = true;
		document.getElementById("tab-two").hidden = true;
		document.getElementById("tab-three").hidden = false;
	    document.getElementById("tab-four").hidden = true;
		document.getElementById("tab-five").hidden = true;
};

    function showFour(){
    	document.getElementById("tab-one").hidden = true;
	    document.getElementById("tab-two").hidden = true;
	    document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = false;
	    document.getElementById("tab-five").hidden = true;
    }


    function showFive(){
	    document.getElementById("tab-one").hidden = true;
	    document.getElementById("tab-two").hidden = true;
	    document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = true;
	    document.getElementById("tab-five").hidden = false;
	};
	
	function hideAll(){
		//hide all main DIV's
	    document.getElementById("tab-one").hidden = true;
	    document.getElementById("tab-two").hidden = true;
	    document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = true;
	    document.getElementById("tab-five").hidden = true;
	    //hide all but student add-user DIV's
	    document.getElementById("student-form").hidden = false;
		document.getElementById("teacher-form").hidden = true;
		document.getElementById("admin-form").hidden = true;
		document.getElementById("anon-form").hidden = true;
	};
	
	function selectRole(){
		var Index = document.adduser.role.options[document.adduser.role.selectedIndex].value;
		if (Index==1){
			//show student fields
			document.getElementById("student-form").hidden = false;
			document.getElementById("teacher-form").hidden = true;
			document.getElementById("admin-form").hidden = true;
			document.getElementById("anon-form").hidden = true;
			//Autofill required but invisible form field and clear visible ones
			document.forms['adduser'].elements['teachername'].value='NONE';
			document.forms['adduser'].elements['studentname'].value='';
			document.forms['adduser'].elements['bookNr'].value='';
		}
		if (Index==2){
			//show teacher fields
			document.getElementById("student-form").hidden = true;
			document.getElementById("teacher-form").hidden = false;
			document.getElementById("admin-form").hidden = true;
			document.getElementById("anon-form").hidden = true;
			//Autofill required but invisible form fields
			document.forms['adduser'].elements['teachername'].value='';
			document.forms['adduser'].elements['studentname'].value='NONE';
			document.forms['adduser'].elements['bookNr'].value='NONE';
		}
		if (Index==3){
			//show admin fields
			document.getElementById("student-form").hidden = true;
			document.getElementById("teacher-form").hidden = true;
			document.getElementById("admin-form").hidden = false;
			document.getElementById("anon-form").hidden = true;
			//Autofill required but invisible form fields
			document.forms['adduser'].elements['studentname'].value='NONE';
			document.forms['adduser'].elements['bookNr'].value='NONE';
			document.forms['adduser'].elements['teachername'].value='NONE';
		}
		if (Index==0){
			//show anonymous fields
			document.getElementById("student-form").hidden = true;
			document.getElementById("teacher-form").hidden = true;
			document.getElementById("admin-form").hidden = true;
			document.getElementById("anon-form").hidden = false;
			//Autofill required but invisible form fields
			document.forms['adduser'].elements['studentname'].value='NONE';
			document.forms['adduser'].elements['bookNr'].value='NONE';
			document.forms['adduser'].elements['teachername'].value='NONE';
		}
		//alert("Selected "+Index);
		
	}
</script>

</head>
<body onload="hideAll()">
<c:import url="header.jsp" charEncoding="UTF-8" />
Превед, одміністратор!
Шо будьєм дьелаць?
				<li><a href="#tab-one" onclick="showOne()">Користувачі</a></li>
				<li><a href="#tab-three" onclick="showThree()">Групи</a></li>
				<li><a href="#tab-five" onclick="showFive()">Предмети</a></li>
				
				<li><a href="#tab-two" onclick="showTwo()">Розклад</a></li>
				<li><a href="#tab-four" onclick="showFour()">Викладачі</a></li>
				
<!-- start page --><br><br>
	<div id="page">
		<c:import url="menu.jsp" charEncoding="UTF-8" />
		<!-- start admin tabs -->		
		
			<!--First table-->
			<div id="tab-one" >
				<div style="float: left; border: thin solid black">
					<form name="edituser" action="/myJournal/admin/edituser" method="post">
						<table border="1"><th>Username</th><th>Role</th><th colspan=2>Controls</th>
						
							<c:forEach var="user" items="${userList}" varStatus="usrCounter">
							<tr>
								<td>${user.username}</td>
								<td><img src="<c:url value="/resources/images/${user.userRole.userRoleID}.png" />"></td>
								<td><button type="submit" name ="editbtn" value="${user.userID}">Edit</button></td>
								<td><button type="submit" name ="deletebtn" value="${user.userID}">Delete</button></td>
							</tr>
							</c:forEach>
						</table>
					</form>
				</div>
				<div style="float: left; border: thin solid black">
					<center><b>Add User</b></center>
						<form name="adduser" action="/myJournal/admin/adduser" method="post">
						
								<input name="username" placeholder="Логін" type="text" required/>
								<input name="password" type="text" placeholder="Пароль" required/>
								<select name="role" id="role" onChange="selectRole()">
									<option value=0>Anonymous</option>
									<option value=1 selected="selected">Student</option>
									<option value=2>Teacher</option>
									<option value=3>Administrator</option>
								</select>
								<input type="submit" value="Add User"/>
							<br>	
							<div id="student-form" style="float: left; ">
									<input name="studentname" type="text" placeholder="Як звати студента" required/>
									<input name="bookNr" type="text" placeholder="Номер заліковки" required/>
									<select name="groupNr">
										<c:forEach var="group" items="${groupList}">
										<option value="${group.groupID}">${group.groupName}</option>
										</c:forEach>
									</select>
							</div>
							<div id="teacher-form" style="float: left; ">
									<input name="teachername" id="teachername" type="text" placeholder="Як звати викладача" required/>
							</div>	
							<div id="admin-form" style="float: left; ">
									Для адміністраторів немає додаткових полів :)<br>
									Просто постарайтеся не забути пароль <br>
							</div>
							<div id="anon-form" style="float: left; ">
									Ви точно впевнені, що потрібен такий юзер? :)<br>
									Наразі система на підтримує анонімних користувачів<br>
							</div>
						</form>
							
								
								
								
				</div>
				
			</div>


			<!--Second table-->
			<div id="tab-two" >
				<div style="float: left; border: thin solid black">
					<form name="editlessons" action="/myJournal/admin/editlessons" method="post">
						<table border="1"><th>Студент </th><th>№ заліковки </th><th colspan=2>Controls</th>
						
							<c:forEach var="student" items="${studentList}" varStatus="usrCounter">
							<tr>
								<td>${student.studentName}</td>
								<td>${student.bookNr}</td>
								<td><button type="submit" name ="editbtn">Edit</button></td>
								<td><button type="submit" name ="deletebtn">Delete</button></td>
							</tr>
							</c:forEach>
						</table>
					</form>
				</div>
			</div>			
			

			<!--Third table-->
			<div id="tab-three" >
				<div style="float: left; border: thin solid black">
					<form name="editgroup" action="/myJournal/admin/editgroup" method="post">
						<table border="1"><th>Group</th><th colspan=2>Controls</th>
						
							<c:forEach var="group" items="${groupList}" varStatus="groupCounter">
							<tr>
								<td>${group.groupName}</td>
								<td><button type="submit" name ="editbtn" value="${group.groupID}">Edit</button></td>
								<td><button type="submit" name ="deletebtn" value="${group.groupID}">Delete</button></td>
							</tr>
							</c:forEach>
						</table>
					</form>
				</div>
				<div style="float: left; border: thin solid black">
					<center><b>Add Group</b></center>
					<form name="addgroup" action="/myJournal/admin/addgroup" method="post">
						<input name="group" type="text"/>
						<input type="submit" value="Add Group"/>
					</form>
				</div>								
			</div>
			
			<!--Forth table-->
			<div id="tab-four" >
				<div style="float: left; border: thin solid black">
					<form name="editteacher" action="/myJournal/admin/editteacher" method="post">
						<table border="1"><th>Teacher</th><th colspan=2>Controls</th>
						
							<c:forEach var="teacher" items="${teacherList}" varStatus="teacherCounter">
								<tr>
									<td>${teacher.teacherName}</td>
									<td><button type="submit" name ="editbtn">Edit</button></td>
									<td><button type="submit" name ="deletebtn">Delete</button></td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</div>	
			</div>
			
			<div id="tab-five" >
				<div style="float: left; border: thin solid black">
					<form name="editsubject" action="/myJournal/admin/editsubject" method="post">
						<table border="1"><th>Subject</th><th colspan=2>Controls</th>
						
							<c:forEach var="subject" items="${subjectList}" varStatus="subjectCounter">
								<tr><td>${subject.subjectName}</td>
									<td><button type="submit" name ="editbtn" value="${subject.subjectID}">Edit</button></td>
									<td><button type="submit" name ="deletebtn" value="${subject.subjectID}">Delete</button></td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</div>
				<div style="float: left; border: thin solid black">
					<center><b>Add Subject</b></center>
					<form name="addsubject" action="/myJournal/admin/addsubject" method="post">
						<input name="subject" type="text"/>
						<input type="submit" value="Add Subject"/>
					</form>
				</div>
			</div>
		</div>
		<!-- end content -->

    
    
</body>
</html>