<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<p class="h2" align="center">답글작성</p>
<table class="table">
	<form action="reply.do" method="post">
	<input type="hidden" name="bNum" value="${replyView.bNum }" />
	<input type="hidden" name="bGroup" value="${replyView.bGroup }" />
	<input type="hidden" name="bStep" value="${replyView.bStep }" />
	<input type="hidden" name="bIndent" value="${replyView.bIndent }" />
	<input type="hidden" name="reqPage" value="${reqPage }" />
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" name="bTitle" class="form-control" id="bTitle" value="re : ${replyView.bTitle }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">작성자</th>
			<td scope="col">
				<input type="text" name="bName" class="form-control" value="${replyView.bName }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">조회수</th>
			<td scope="col"> 
				<input type="text" name="bHit" readonly="readonly" class="form-control" id="" value="${replyView.bHit }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">수정일</th>
			<td scope="col"> 
				<input type="text" name="bUdate" readonly="readonly" class="form-control" id="" value="${replyView.bUdate }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">내용</th>
			<td scope="col">
				<textarea name="bContent" class="form-control" id="bContent" rows="5">${replyView.bContent }
-------------------------------
</textarea>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="right">
			<input class="btn btn-secondary" type="submit"  value="답글등록">
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true" >목록으로</a>
			</td>
		</tr>
			</form>
</table>
</div>
</body>
</html>