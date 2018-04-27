<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Bordered Table</h2>
		<p>The .table-bordered class adds borders to a table:</p>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="dto">
					<!--여기의 list는 BbsListCmd의 setAttribute에서 저장한 alist -->
					<tr> 
						<th scope="row">${dto.bNum }</th>
						<td>
						<a class="text-dark" href="view.do?bNum=${dto.bNum }">${dto.bTitle }</a>
						</td>
						<td>${dto.bName }</td>
						<td>${dto.bCdate }</td>
						<td>${dto.bHit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="right">
			<table>
				<tr>
					<td colspan="3"><a href="/webedu/bbs/write_view.do" target="iframe_content" >글쓰기</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>