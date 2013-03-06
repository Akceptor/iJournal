<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>Доступ заборонено</title></head>
<body>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div align=center>
	<div><img src="resources/images/stop.png" height="32"/><font size=14><b>  Доступ заборонено!  </b></font><img src="resources/images/stop.png" height="32"/></div>
</div>		
<div><font size=6>У Вас нема доступу до обраної сторінки. На жаль... 
Ви можете спробувати зробити наступне:</font>
<ul>
<li><font size=5>Якщо Ви студент - <a href="student">натисніть тут</a></font></li>
<li><font size=5>Якщо Ви викладач - <a href="hello">натисніть тут</a></font></li>
<li><font size=5>Якщо Ви адміністратор ресурсу - Ви знаєте що робити ;)</font></li>
</ul>
А ще можна спробувати <a href="<spring:url value="/logout" htmlEscape="true" />">вийти</a> і увійти знову.
</div>


</body>
</html>