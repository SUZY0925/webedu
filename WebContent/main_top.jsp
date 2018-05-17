<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
  <style>
    * { margin: 0; text-align: center; }
    html, body { margin:0; padding:0; height:100%;  }
    #header1 { background: gray; height:15%; }
    #nav1 { background-color: white; height:5%;}
    #section1 { background-color: rgb(148, 29, 196); width:70%; height:30%;
                float:left;}
    #article1 { background-color: rgb(207, 63, 18); width:30%; height:20%;
                float:right;}
    #aside { background-color: rgb(57, 210, 33); width:30%; height:50%;
              float:right;}
    #section2 { background-color: rgb(244, 229, 33); width:70%; height:40%;
                float:left;}
    #header2 { background-color: rgb(200, 206, 207); height:10%}
    #footer1 { background-color: rgb(92, 190, 15); height:10%}
    #footer2 {  background-color: gray; height:10%; width:100%; float:clear;}
    #p1 { height: 65%;}
	a {
    	text-decoration:none !important;
    }
    li {
    	display:inline;
    }
  </style>
</head>
<body class="container">
<header id="header1">
<p class="display-2">BBS TEST</p>
</header>
<nav id="nav1">
	<ul>
			<li><a href="/webedu/index.jsp" class="btn-sm btn-outline-primary btn-sm ">홈으로</a></li>
			<li><a href="/webedu/MEMBER/memLogin.jsp" target="iframe_content" class="btn-sm btn-outline-dark btn-sm ">로그인</a></li>
			<li><a href="/webedu/MEMBER/memJoin.jsp" target="iframe_content" class="btn-sm btn-outline-dark btn-sm ">회원가입</a></li>
			<li><a href="/webedu/ADMIN/adminLogin.jsp" target="iframe_content" class="btn-sm btn-outline-dark btn-sm ">관리자로그인</a></li>
			<li><a href="/webedu/bbs/list.do" target="iframe_content" class="btn-sm btn-outline-dark btn-sm ">게시판</a></li>
	</ul>
</nav>