<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	if(session.getAttribute("admin") != null ) {
 %>
 	<jsp:forward page="/ADMIN/admin.jsp" />
 <%
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<style>
input {
		margin : 5px;
	}
</style>

</head>
<body>
	<hr />
	<h2>관리자 로그인</h2>
	<hr />
	<form action="/webedu/ADMIN/adminLoginOK.jsp" method="post">
	<label class="col-lg-2">아이디</label><input type="text" name="id"  class="form-control-sm"/><br>
	<label class="col-lg-2">비밀번호</label><input type="password" name="passwd" class="form-control-sm"/><br>
	<input type="submit" value="로그인" class="btn btn-outline-primary btn-sm"/>
	<input type="reset" value="초기화" class="btn btn-outline-dark btn-sm"/>
	</form>
</body>
</html>