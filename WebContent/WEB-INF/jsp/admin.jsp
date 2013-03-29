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
	    document.getElementById("tab-one").hidden = true;
	    document.getElementById("tab-two").hidden = true;
	    document.getElementById("tab-three").hidden = true;
	    document.getElementById("tab-four").hidden = true;
	    document.getElementById("tab-five").hidden = true;
	};
</script>

</head>
<body onload="hideAll()">
<c:import url="header.jsp" charEncoding="UTF-8" />
Превед, одміністратор!
Шо будьєм дьелаць?
				<li><a href="#tab-one" onclick="showOne()">Користувачі</a></li>
				<li><a href="#tab-two" onclick="showTwo()">Студенти</a></li>
				<li><a href="#tab-three" onclick="showThree()">Групи</a></li>
				<li><a href="#tab-four" onclick="showFour()">Викладачі</a></li>
				<li><a href="#tab-five" onclick="showFive()">Предмети</a></li>
<!-- start page --><br><br>
	<div id="page">
		<c:import url="menu.jsp" charEncoding="UTF-8" />
		<!-- start admin tabs -->		
		
			<!--First table-->
			<div id="tab-one" >
				<div style="float: left; border: thin solid black"><form name="edituser" action="/myJournal/admin/edituser" method="post">
				<table><th>Username</th><th colspan=2>Controls</th>
				
					<c:forEach var="user" items="${userList}" varStatus="usrCounter">
					<tr><td>${user.username}</td><td><button type="submit" name ="editbtn">Edit</button></td><td><button type="submit" name ="deletebtn">Delete</button></td></tr>
					</c:forEach>
				</table>
				</form></div><div style="float: left; border: thin solid black">
				<center><b>Add User</b></center>
				<form name="adduser" action="/myJournal/admin/adduser" method="post">
					<input name="username" type="text"/>
					<input name="password" type="text"/>
					<input type="submit" value="Add User"/>
				</form></div>
			</div>


			<!--Second table-->
			<div id="tab-two" >
				TWO	
			</div>			
			

			<!--Third table-->
			<div id="tab-three" >
				THREE								
			</div>
			
			<!--Forth table-->
			<div id="tab-four" >
				FOUR
			</div>
			
			<div id="tab-five" >
				FIVE
			</div>
		</div>
		<!-- end content -->

    
    
</body>
</html>