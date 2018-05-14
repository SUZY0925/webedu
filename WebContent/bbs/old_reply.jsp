<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>댓글</title>
<style>

	#modifyDiv {
		width:500px;
		height:100px;
		background-color:gray;
		position:absolute; 
		top:20%;
		left:30%;
		padding:20px;
		/* z-index:100; */
		display:block; 
	}
</style>
<script>
	$(function() {
		$.getJSON('/webedu/rbbs/list?bNum=1', function(data) {
			var html = [];
			$.each(data, function(index, item) {
				html.push('<li>' + item.result[index].RCONTENT + '</li>'); 
				html.push('<li>' + item.result[index].BNUM + '</li>');
				$('#target').html(html.join(''));
			});
		});
	});
</script>

</head>
<body>
	<div>
		작성자 : <input type="text" name="rName" id="" />
	</div>
	<div>
		댓 글 :
		<textarea cols="50" rows="3" name="rContent"></textarea>
		<button>댓글등록</button>
	</div>
	<hr />
	<div id="modifyDiv">
		<span>11</span>번 댓글
		<div>
			<textarea rows="3" cols="50" readOnly></textarea>
		</div>
		<div align="right">
			<button>수정</button>
			<button>삭제</button>
		</div>
	</div>
	<h4>댓글리스트</h4>
<ul id="target">
</ul>

</body>
</html>