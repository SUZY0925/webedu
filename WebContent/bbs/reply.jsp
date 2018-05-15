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
	width: 300px;
	height: 200px;
	position: absolute;
	background-color: gray;
	top: 20%;
	left: 37%;
	padding: 20px;
	z-index: 10;
}

#rereDiv {
	width: 300px;
	height: 200px;
	position: absolute;
	background-color: gray;
	top: 40%;
	left: 37%;
	padding: 20px;
	z-index: 10;
}

#pageNumList > li {
	list-style: none;
	display: inline;
	border: 1px solid #bcbcbc;
	padding: 5px;
	margin-right: :-4px;
}
</style>
<script>
	var bNum = 1;
	$(function() {
		// 댓글수정양식 숨기기
		$("#modifyDiv").hide();

		// 대댓글 양식 숨기기
		$("#rereDiv").hide();

		// 댓글 목록 처리
		$("#reply").on("click", ".reList #modifyBtn", function() {
			$("#rereDiv").hide();
			var li = $(this).parent();
			console.log(li);
			var rNum = li.attr("data-rNum");
			console.log(rNum);
			var reContent = li.text();

			$(".title-diaLog").html(rNum);
			$("#reContent").val(reContent);
			$("#modifyDiv").show("slow");

		});

		// 댓글 수정창 닫기
		$("#exitBtn").click(function() {
			$("#modifyDiv").hide();
			$("#rereDiv").hide();
		});


		// 댓글 삭제하기
		$("#reDelBtn").click(function() {
			var rNum = $(".title-diaLog").html();
			console.log(rNum);
			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/delete",
				dataType : "text",
				data : {
					rNum : rNum
				},
				success : function(result) {
					replyList();
					$("#modifyDiv").hide();
					$("#rereDiv").hide();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});

		// 댓글 수정하기
		$("#reModifyBtn").on("click", function() {
			var rNum = $(".title-diaLog").html();
			var rContent = $("#reContent").val();
			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/modify",
				dataType : "text",
				data : {
					rNum : rNum,
					rContent : rContent
				},
				success : function(result) {
					replyList();
					$("#modifyDiv").hide();
					$("#rereDiv").hide();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});


		});

		replyList(); // 댓글목록 가져오기 호출

		// 댓글 작성하기
		$("#replyBtn").click(function() {
			var writer = $("#writer").val();
			var replyContent = $("#replyContent").val();

			if ($("#writer").val() == "") {
				alert("작성자를 입력해주세요!");
				$("#writer").focus();
				return false;
			}
			if ($("#replyContent").val() == "") {
				alert("내용을 입력해주세요!");
				$("#replyContent").focus();
				return false;
			}

			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/write",
				dataType : "text",
				data : {
					bNum : bNum,
					rName : writer,
					rContent : replyContent
				},
				success : function(result) {
					$("#modifyDiv").hide();
					$("#rereDiv").hide();
					alert("댓글 작성 성공~");
					replyList();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});


		// '댓글' 버튼을 클릭했을때
		$("#reReplyBtn").click(function() {
			$("#rereDiv").show("slow");
			$("#reReplyContent").val("ㄴ");

			// 댓글 작성하기를 클릭했을때
			$("#rereplyBtn").click(function() {
				var rNum = $(".title-diaLog").html();
				var reWriter = $("#reWriter").val();
				var reReplyContent = $("#reReplyContent").val();

				if ($("#reWriter").val() == "") {
					alert("작성자를 입력해주세요!");
					$("#reWriter").focus();
					return false;
				}
				if ($("#reReplyContent").val() == "") {
					alert("내용을 입력해주세요!");
					$("#reReplyContent").focus();
					return false;
				}

				$.ajax({
					type : "POST",
					url : "/webedu/rbbs/reply",
					dataType : "text",
					data : {
						rNum : rNum,
						rName : reWriter,
						rContent : reReplyContent
					},
					success : function(result) {
						$("#modifyDiv").hide();
						$("#rereDiv").hide();
						alert("댓글 작성 성공~");
						replyList();
					},
					error : function(e) {
						console.log("실패" + e);
					}
				});
			});
		});

		$("#reply").on("click", ".reList #goodBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");

			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/good",
				dataType : "text",
				data : {
					rNum : rNum,
					goodOrBad : "good"
				},
				success : function(result) {
					replyList();
					$("#modifyDiv").hide();
					$("#rereDiv").hide();
					alert("좋아요");
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});

		$("#reply").on("click", ".reList #badBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");

			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/bad",
				dataType : "text",
				data : {
					rNum : rNum,
					goodOrBad : "bad"
				},
				success : function(result) {
					replyList();
					$("#modifyDiv").hide();
					$("#rereDiv").hide();
					alert("싫어요");
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});


	});




	// 댓글 목록 가져오기	
	function replyList() {
		var str = "";
		$.ajax({
			type : "GET",
			url : "/webedu/rbbs/list?reReqPage=1&bNum=" + bNum,
			dataType : "json",
			success : function(data) {
				/* 				console.log(data);
								console.log(data.result); */

				$.each(data.result, function(idx, rec) {
					console.log(rec);
					$(rec.RINDENT).each(function(i) {});
					str += "<li data-rNum='" + rec.RNUM + "' class = 'reList'>"
						+ rec.RINDENT + " | "
						+ rec.RCDATE + " | "
						+ rec.RNAME + " | "
						+ rec.RCONTENT + " | "
						+ rec.RGOOD + " | "
						+ rec.RBAD
						+ "<button id=\"modifyBtn\">수정</button>"
						+ "<button id=\"goodBtn\">좋아요</button>"
						+ "<button id=\"badBtn\">싫어요</button>"
						+ "</li>";

				});
				$("#reply").html(str);
			},
			error : function(error) {
				console.log("실패" + error);
			}
		});

	}
</script>

</head>
<body>
	<div id="modifyDiv">
		<span class="title-diaLog"></span>번 댓글
		<div>
			<textarea id="reContent" cols="30" rows="3"></textarea>
		</div>
		<div>
			<button id="reReplyBtn">댓글</button>
			<button id="reModifyBtn">수정</button>
			<button id="reDelBtn">삭제</button>
			<button id="exitBtn">닫기</button>
		</div>

	</div>
	<div id="rereDiv">
		작성자 : <input type="text" name="" id="reWriter" /><br> 댓글 :
		<textarea name="rContent" id="reReplyContent" cols="30" rows="3"></textarea>
		<br>
		<button id="rereplyBtn">댓글작성</button>
	</div>

	작성자 :
	<input type="text" name="" id="writer" />
	<br> 댓글 :
	<textarea name="rContent" id="replyContent" cols="30" rows="3"></textarea>
	<br>
	<button id="replyBtn">댓글작성</button>
	<h4>댓글리스트</h4>

	<ul id="reply">

	</ul>

	<ul id="pageNumList">
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
		<li>6</li>
		<li>7</li>
		<li>8</li>
		<li>9</li>
		<li>10</li>
	</ul>
</body>
</html>