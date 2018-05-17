<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<!-- 자바스크립트 외부파일 불러오기 -->
<!-- <script src = "/webedu/MEMBER/js/member.js"></script> -->
<link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/MEMBER/js/member2.js"></script>
<style>
	input {
		margin : 5px;
	}
</style>
</head>
<body>
<hr>
<h2>회원가입</h2>
<hr>
<form action="/webedu/MEMBER/memJoinOK.jsp" method="post" name="join_frm">
<label class="col-lg-2">아이디</label><input type="email" name="id" id="id" placeholder="abc@abc.com" class="form-control-sm"/>	<br>
<label class="col-lg-2">비밀번호</label><input type="password" name="passwd" id="passwd" class="form-control-sm"/> <br>
<label class="col-lg-2">비밀번호확인</label><input type="password" name="passwd_chk" id="passwd_chk" class="form-control-sm"/> <br>
<label class="col-lg-2">이름</label><input type="text" name="name" id="name" class="form-control-sm"/> <br>
<label class="col-lg-2">생년월일 </label><select name="year" id="year" class="form-control-sm">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			</select>년

			<select name="month" id="month" class="form-control-sm">
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
			<select name="day" id="day" class="form-control-sm">
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
<label class="col-lg-2">전화번호</label><input type="text" name="phone" id="phone" class="form-control-sm"/> <br>
<input type="button" value="회원가입" id="memJoin" onClick="mem_check()" class="btn btn-outline-primary btn-sm"/>
<input type="reset" value="취소" class="btn btn-outline-dark btn-sm"/>
</form>
</body>
</html>