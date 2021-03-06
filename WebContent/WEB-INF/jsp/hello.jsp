<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>myJournal</title>
</head>

<body>
	<c:import url="header.jsp" charEncoding="UTF-8" />

	<c:set var="count" value="1" scope="page" />

	<c:if test="${pageContext.request.method=='GET'}">
		<form name="group" action="/myJournal/hello" method="post">
			Група: <select name="Group" style="width: 200">
				<c:forEach var="group" items="${groups}">
					<option value="${group.groupID}">${group.groupName}</option>
				</c:forEach>
			</select> <br> Предмет: <select name="Subject" style="width: 200">
				<c:forEach var="subject" items="${subjects}">
					<option value="${subject.subjectID}">${subject.subjectName}</option>
				</c:forEach>
			</select> <br> <input type="submit" value="Submit">
		</form>
	</c:if>
	<c:if test="${pageContext.request.method=='POST'}">

		<form name="Submit" action="/myJournal/ok" method="post">



			<table border="1">
				<thead>Журнал групи ${selectedGroup.groupName} -
					${selectedSubject.subjectName} ()
				</thead>

				<tr>
					<td>Прізвище студента</td>
					<c:forEach var="date" items="${subjectDates}">
						<td><fmt:formatDate value="${date}" pattern="dd-MM-yyyy (E)" /></td>
					</c:forEach>
					<td><span title="Сума балів; кількість невідпрацьованих/відпрацованих пропусків">Підсумок</span></td>
				</tr>

				<c:forEach var="member" items="${groupMembers}"
					varStatus="studentCounter">
					<tr>
						<td><input type="text" name="student" value="${member.studentID}"
							hidden /><input type="text" name="student_FIO"
							value="${member.studentName}" disabled /></td>
						<c:forEach var="date" items="${subjectDates}"
							varStatus="dateCounter">
							<td>
							<select name="present"
								id="present_${dateCounter.count}_${studentCounter.count}" />
								<option value="0"></option>
								<option value="1">Н</option>
								<option value="2">&empty;</option>
							</select> 
								<!-- Select items in comboboxes -->
	<script type="text/javascript">
	document.getElementById("present_${dateCounter.count}_${studentCounter.count}").selectedIndex=${absenceMarks.get(studentCounter.count-1)[dateCounter.count-1]};
	</script> 
<input type="text" name="lessonid" maxlength="5" size="5"
								value="${lessonIDs.get(studentCounter.count-1)[dateCounter.count-1]}"
								hidden /> 
								<input type="number" min="0" max="10" step="1" name="mark" maxlength="2" size="2" width="10"
								value="${studentMarks.get(studentCounter.count-1)[dateCounter.count-1]}" required/></td>

						</c:forEach>
						<td><input type="text" name="total" size="2" value="${totalMark.get(studentCounter.count-1)}" readonly/>${totalAbs.get(studentCounter.count-1)}/${totalAbsOk.get(studentCounter.count-1)}</td>
					</tr>
				</c:forEach>
			</table>


			<input type="submit" value="Зберегти оцінки ->">
		</form>
		<form name="Back" action="/myJournal/hello" method="get">
			<input type="submit" value="<- Назад">
		</form>
	</c:if>




	<c:import url="footer.jsp" charEncoding="UTF-8" />
</body>
</html>
