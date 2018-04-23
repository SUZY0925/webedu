<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "com.edu.*" %>
 <%
 	String id = (String)session.getAttribute("id");
 	MemberDAO mdao = MemberDAO.getInstance();
 	MemDTO mdto = mdao.getMember(id);
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<script src = "/webedu/MEMBER/js/member.js"></script>
</head>
<body>
<h2>회원수정</h2>
<form action="/webedu/MEMBER/memModifyOK.jsp" method="post" name="modify_frm">
아이디 : <input type="email" name="id" value="<%=mdto.getId()%>" disabled="disabled"/>	<br>
비밀번호 : <input type="password" name="passwd"/> <br>
비밀번호확인 : <input type="password" name="passwd_chk"/> <br>
이름 : <input type="text" name="name" value="<%=mdto.getName()%>"/> <br>
생년월일 : <select name="year">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			</select>년

			<select name="month">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>월
			<select name="day">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>일 <br>
전화번호 : <input type="text" name="phone" id="" value="<%=mdto.getPhone()%>"/> <br>
<input type="button" value="회원정보수정" onClick="updateInfo()"/>
<input type="reset" value="취소" />
<input type="button" value="회원탈퇴" onClick="javascript:location.href='memDelete.jsp'"/>
</form>
</body>
</html>