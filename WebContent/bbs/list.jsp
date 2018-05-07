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
		<p class="h2" align="center">글목록</p>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col" width="60%">제목</th>
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
						<td><c:forEach begin="1" end="${dto.bIndent }">ㄴ</c:forEach>
							<a class="text-dark" href="view.do?bNum=${dto.bNum }">${dto.bTitle }</a>
						</td>
						<td>${dto.bName }</td>
						<td>${dto.bCdate }</td>
						<td>${dto.bHit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table>
				<a href="/webedu/bbs/write_view.do"
					target="iframe_content">글쓰기</a>
		</table>
	</div>
</body>
</html>