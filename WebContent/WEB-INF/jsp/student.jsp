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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
<c:import url="header.jsp" charEncoding="UTF-8" />
STUDENT<br>


				
<!-- List all subjects -->
					<c:forEach var="member" items="${subjectList}"
					varStatus="subjCounter">
<div style="float:left"><table border="1">
<th>Дата</th><th>Оцінка</th><th> </th>
<!-- dates --><c:forEach var="date" items="${lessonDates}" varStatus="dateCounter">
					
						<tr><td><fmt:formatDate value="${lessonDates[subjCounter.count-1][dateCounter.count-1]}" pattern="dd-MM-yyyy" /></td><td width=20>${allMarks[subjCounter.count-1][dateCounter.count-1]}</td></tr>	
					
					</c:forEach>
			<tr><td colspan=2><center>${member.subjectName}</center><td></tr>	
			
</table></div>
				</c:forEach>
			

</body>
</html>