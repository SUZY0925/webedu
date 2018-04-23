<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	if(session.getAttribute("chkMember") != null ) {
 %>
 	<jsp:forward page="/main.jsp" />
 <%
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script>

/* 	$(document).ready(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	}); */
	
	// 축약1)
/* 	jQuery(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	}); */

	//축약2
	$(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	});
	
</script>
</head>
<body>
	<hr />
	<h2>로그인</h2>
	<hr />
	<form action="/webedu/MEMBER/memLoginOK.jsp" method="post">
	아이디: <input type="text" name="id"  id="id"/><br>
	비밀번호 <input type="password" name="passwd"  id="passwd"/><br>
	<input type="submit" value="로그인" />
	<input type="button" value="회원가입" onClick="javascript:window.location='/webedu/MEMBER/memJoin.jsp' "/>	<!-- 함수로 안만들고 간단한건 이렇게도 처리 가능 -->
	</form>
</body>
</html>