<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<!-- 자바스크립트 외부파일 불러오기 -->
<!-- <script src = "/webedu/MEMBER/js/member.js"></script> -->
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script>
 $(function() {
	$("form").submit(function() {
		if($("#id").val()=="") {
			alert("아이디를 입력해주세요!");
			$("#id").focus();
			return false;
		} else if($("#id").val().length < 4) {
			alert("아이디는 최소 4글자 이상 입력해주세요!");
			$("#id").focus();
			return false;
		}
	});
});

 jQuery(function() {
	 $("form").submit(function() {
	 if ($("#passwd").val()=="") {
			alert("비밀번호를 입력해주세요!");
			$("#passwd").focus();
			return false;
		} else if($("#passwd").val()!=$("#passwd_chk").val()) {
			alert("비밀번호가 일치하지 않습니다!");
			$("#passwd").focus();
			return false;
			
		}
	 });
 });
</script>
</head>
<body>
<hr>
<h2>회원가입</h2>
<hr>
<form action="/webedu/MEMBER/memJoinOK.jsp" method="post" name="join_frm">
아이디 : <input type="email" name="id" id="id" placeholder="abc@abc.com"/>	<br>
비밀번호 : <input type="password" name="passwd" id="passwd"/> <br>
비밀번호확인 : <input type="password" name="passwd_chk" id="passwd_chk"/> <br>
이름 : <input type="text" name="name" id="name"/> <br>
생년월일 : <select name="year" id="year">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			</select>년

			<select name="month" id="month">
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
			<select name="day" id="day">
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
전화번호 : <input type="text" name="phone" id="phone" /> <br>
<input type="submit" value="회원가입" onClick="mem_check()"/>
<input type="reset" value="취소" />
</form>
</body>
</html>