<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<script>
	function get() {
		va
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<p class="h2" align="center">글 내용보기</p>
<table class="table">
	<form action="" name="frm_1">
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" name="bTitle" readonly="readonly" class="form-control" id="" value="${bbsdto.bTitle }" >
			</td>
		</tr>
		<tr>
			<th scope="col">작성자</th>
			<td scope="col">
				<input type="text" name="bName" readonly="readonly" class="form-control" id="" value="${bbsdto.bName }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">글번호</th>
			<td scope="col"> 
				<input type="text" name="bNum" readonly="readonly" class="form-control" id="" value="${bbsdto.bNum}" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">조회수</th>
			<td scope="col"> 
				<input type="text" name="bHit" readonly="readonly" class="form-control" id="" value="${bbsdto.bHit }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">작성일</th>
			<td scope="col"> 
				<input type="text" name="bUdate" readonly="readonly" class="form-control" id="" value="${bbsdto.bUdate }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">내용</th>
			<td scope="col">
				<textarea name="bContent" readonly="readonly" class="form-control" id="" rows="5" >${bbsdto.bContent }</textarea>
			</td>
		</tr>
		<tr><!-- 읽기모드일 경우 버튼 -->
			<td colspan=2 align="right">
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true">목록으로</a>
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true">수정하기</a>
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true">삭제하기</a>
			</td>
		</tr>
		<tr><!-- 수정하기일 경우 버튼, hidden상태여야함,,,,처음에는 -->
			<td colspan=2 align="right">
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true">수정완료</a>
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true">목록으로</a>
			</td>
		</tr>
</form>
</table>
</div>
</body>
</html>