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
<style id="viewStyle">
	#modifyMode{
		display:none;
	}
</style>
<script>
	function Modify() {
		document.getElementById("viewStyle").disabled= true;
		document.getElementById("viewMode").style.display="none";
		frm_1.bTitle.readOnly = false;
		frm_1.bName.readOnly = false;
		frm_1.bContent.readOnly = false;
	}
	
</script>

<title>Insert title here</title>
</head>
<body>
<div class="container">
<p class="h2" align="center">글 내용보기</p>
<table class="table">
	<form action="modify.do" name="frm_1">
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" name="bTitle" readonly="readonly" class="form-control" id="" value="${bbsdto.bTitle }" >
			</td>
		</tr>
		<tr>
			<th class="w-25 p-3">작성자</th>
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
				<textarea name="bContent" readonly="readonly" class="form-control" id="" rows="5">${bbsdto.bContent }</textarea>
			</td>
		</tr>
		<tr id="viewMode">
			<td colspan=2 align="right">
			<a href="list.do" class="btn btn-secondary" role="button" aria-pressed="true" >목록으로</a>
			<a href="#" class="btn btn-secondary" role="button" aria-pressed="true" onClick="Modify()">수정하기</a>
			<a href="delete.do?bNum=${bbsdto.bNum }" class="btn btn-secondary" role="button" aria-pressed="true">삭제하기</a>
			</td>
		</tr>
		<tr id="modifyMode">
			<td colspan=2 align="right">
			<input class="btn btn-secondary" type="submit" value="수정완료">
			<a href="view.do?bNum=${bbsdto.bNum}" class="btn btn-secondary" role="button" aria-pressed="true">취소</a>
			</td>
		</tr>
				<div style="float: right">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="pageNav.do?bNum=${bbsdto.bNum}&np=1">Previous</a></li>
							<li class="page-item"><a class="page-link" href="pageNav.do?bNum=${bbsdto.bNum}&np=0">Next</a></li>
						</ul>
					</nav>
				</div>
			</form>
</table>
</div>
</body>
</html>