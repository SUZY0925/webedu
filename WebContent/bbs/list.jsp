<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
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
    <tr>
		<th scope="row">1</th>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
    </tr>
    <tr>
      <th scope="row">2</th>
    	<td></td>
		<td></td>
		<td></td>
		<td></td>
    </tr>
    <tr>
      <th scope="row">3</th>
      	<td></td>
		<td></td>
		<td></td>
		<td></td>
    </tr>
    <tr>
    	<td colspan="6" align="right">
    		<a href="">글쓰기</a>
    	</td>
    </tr>
  </tbody>
</table>
</div>
</body>
</html>