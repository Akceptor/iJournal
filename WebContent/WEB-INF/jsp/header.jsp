<%@ include file="/WEB-INF/jsp/include.jsp"%>
<h2>My little journal</h2>
<div id="top">
		 You are logged in as: <security:authentication property="principal.username" />        <div><a href="<spring:url value="/logout" htmlEscape="true" />">Logout</a></div>
	</div><br>
	