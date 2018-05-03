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
	<%
		int pageSize = 10; // 한페이지에서 보여줄 글갯수?

		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) { // 클릭한게 없으면 1번 페이지
			pageNum = "1";
		}
		// 연산을 하기 위한 pageNum 형변환 / 현재 페이지
		int currentPage = Integer.valueOf(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1; // 해당 페이지에서 시작할 레코드
		int endRow = currentPage * pageSize; // 마지막 레코드
		
		int count = Integer.valueOf(String.valueOf(request.getAttribute("count")));
	%>

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

		<table width="100%">
			<tr>
				<td width="95%">
					<ul id="pageing"
						class="pagination pagination-sm justify-content-center">
						<%
							// 페이징  처리
							if (count > 0) {
								// 총 페이지의 수
								int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
								// 한 페이지에 보여줄 페이지 링크 수
								int pageBlock = 10;
								// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
								int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
								int endPage = startPage + pageBlock - 1;

								// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
								if (endPage > pageCount) {
									endPage = pageCount;
								}

								if (startPage > pageBlock) { // 페이지 블록수보다 startPage가 클경우 이전 링크 생성
						%>
						<li class="page-item"><a class="page-link"
							href="list.do?pageNum=<%=startPage - 10%>" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
						</a></li>
						<%
							}
								for (int i = startPage; i <= endPage; i++) { // 페이지 블록 번호
									if (i == currentPage) { // 현재 페이지에는 링크를 설정하지 않음
						%>
						<li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
						<%
							} else { // 현재 페이지가 아닌 경우 링크 설정
						%>
						<li class="page-item"><a class="page-link"
							href="list.do?pageNum=<%=i%>"><%=i%></a></li>
						<%
							}
								} // for end
								if (endPage < pageCount) { // 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성
						%>
						<li class="page-item"><a class="page-link"
							href="list.do?pageNum=<%=startPage + 10%>" aria-label="Next">
								<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
						<%
							}
							}
						%>
					</ul>
				</td>
				<td width="5%"><a href="/webedu/bbs/write_view.do"
					target="iframe_content">글쓰기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>