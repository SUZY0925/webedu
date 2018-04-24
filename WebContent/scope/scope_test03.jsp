<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cnt" class="com.edu.CountBean" scope="session"/>
    <jsp:setProperty property="count" name="cnt" />	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount호출(session)</title>
</head>
<body>
	<jsp:getProperty property="count" name="cnt"/>
	${cnt.count }
<%-- 	<jsp:forward page ="scope_result_3.jsp" /> --%>
<%-- 	<% response.sendRedirect("scope_result_3.jsp"); %> --%>
	<a href="scope_result_3.jsp">result_3</a>
</body>
</html>