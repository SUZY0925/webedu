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
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<script>
$(function() {
	$("input[value='검색']").click(function() {
		if ($("input[name=search]").val() == "") {
			window.alert("검색할 단어를 입력해주세요!");
			$("input[name=search]").focus();
			return false;
		}
		
		var inputState = $("[name=inputState]").value();
		location.href = "search.do?inputState=" + inputState;
	});	
});
</script>

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
						<td><c:forEach begin="1" end="${dto.bIndent }">　</c:forEach>
						<c:if test="${dto.bIndent >0}">ㄴ</c:if> <a class="text-dark"
							href="view.do?bNum=${dto.bNum }&reqPage=${page.recordCriteria.reqPage }">${dto.bTitle }</a></td>
						<td>${dto.bName }</td>
						<td>${dto.bCdate }</td>
						<td>${dto.bHit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table width="100%">
			<tr>
				<td width="95%">
					<ul id="pageing"
						class="pagination pagination-sm justify-content-center">
						<c:if test="${page.prev }">
							<li class="page-item"><a class="page-link"
								href="list.do?reqPage=1">◀</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?reqPage=${page.startPage-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
							</a></li>
						</c:if>

						<c:forEach begin="${page.startPage }" end="${page.endPage }"
							var="PAGE">
							<c:if test="${page.recordCriteria.reqPage == PAGE }">
								<li class="page-item active"><a class="page-link" href="#">${PAGE }</a></li>
							</c:if>
							<c:if test="${page.recordCriteria.reqPage != PAGE }">
								<li class="page-item"><a class="page-link"
									href="list.do?reqPage=${PAGE }">${PAGE }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${page.next }">
							<li class="page-item"><a class="page-link"
								href="list.do?reqPage=${page.endPage+1 }" aria-label="Next">
									<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
							</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?reqPage=${page.finalEndPage}">▶</a></li>
						</c:if>
					</ul>
				</td>
				<td><a
					href="/webedu/bbs/write_view.do?reqPage=${page.recordCriteria.reqPage }"
					target="iframe_content">글쓰기</a></td>
			</tr>
			<tr>
				<td>
					<select name="inputState" class="form-control-sm">
						<option selected>작성자</option>
						<option>제목</option>
						<option>내용</option>
						<option>제목+내용</option>
						<option>제목+내용+작성자</option>
						<option>작성자+내용</option>
					</select>
				<input type="text" name="search" id="" class="form-control-sm"/>
				<input type="button" class="btn-sm btn-secondary" id="searchBtn" value="검색" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>