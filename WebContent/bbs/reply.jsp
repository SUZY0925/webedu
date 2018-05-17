<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>댓글</title>
<style>
.textByte {
	display:inline;
}
 #modifyDiv {
	/* width: 300px;
	height: 200px;
	background-color: gray;
	top: 20%;
	left: 37%;
	padding: 20px;
	z-index: 10; */
} 


/* #rereDiv {
	width: 300px;
	height: 200px;
	background-color: gray;
	top: 40%;
	left: 37%;
	padding: 20px;
	z-index: 10;
}
 */

#pageNumList{
	list-style: none;
	display: inline;
	padding: 5px;
	padding-left: :20px;
}

#modifyBtn {
	margin-left: 5px;
}

.reList {
	margin-bottom: 20px;
	list-style: none;
}

#goodBtn {
	margin-left: 5px;
}

#replyContent {
	margin-top:5px;
}

#allDiv {
  width: 100%;
  padding-right: 50px;
  padding-left: 50px;
  margin-right: auto;
  margin-left: auto;
}

</style>
<script>
	var bNum = ${bbsdto.bNum};
	var reReqPage = 1;
	
	// 글자수 제한 두기
	$(document).ready(function() {
	    	$('textarea').on('keyup focus', function() {
	    	var limitbyte = 197;
	    	var str = $(this).val();
	    	var strPiece = "";
	    	var strLength = 0;
	    	for(var i = 0; i<str.length; i++) {
	    		if(strLength > limitbyte) {
	    			break;
	    		}
	    		
	    		var code = str.charCodeAt(i);
	    		var ch = str.substr(i,1).toUpperCase();
	    		
	    		strPiece += str.substr(i,1);
	    		code = parseInt(code);
	    		if ((ch < "0" || ch > "9") && (ch < "A" || ch > "Z") && ((code > 255) || (code < 0)))
	    		{
                    strLength += 3; //UTF-8 3byte 로 계산
                }else{
                    strLength += 1;
                }
	    	}
	    	$(".textByte").html(strLength+"/200");
	    	$(this).val(strPiece);
	    });
	    
	});


	$(function() {
		
		//$("#modifyDiv").hide();// 댓글수정양식 숨기기
		//$("#rereDiv").hide();// 대댓글 양식 숨기기
		
		// 댓글수정 대댓글 양식 숨기기
		formhide();
		
		// 댓글목록 가져오기 호출
		replyList(reReqPage);
		
		// 댓글 목록 처리
		$("#reply").on("click", ".reList #modifyBtn", function() {
			$("#rereDiv").hide();
			$("#writeReply").hide();
			var li = $(this).parent();
			
			var rNum = li.attr("data-rNum");
			
			// 댓글내용 분리 작업.. 
			var strArray = li.text().split("|");
			var reContent = strArray[1].substring(11); // 날짜랑 분리,,
			
			// 대댓일 경우
			if(reContent.indexOf("└") > 0) 
			{
				var arr = reContent.split("└ ");
				reContent = arr[1];
			}

			$(".title-diaLog").html(rNum);
			$("#reContent").val(reContent);
			$("#modifyDiv").show();
		});

		// 댓글 수정창 닫기
		$("#exitBtn").click(function() {
			formhide();
			$("#writeReply").show();
			formclear();
		});
		
		//대댓글 작성창 닫기
		$("#reExitBtn").click(function() {
			formhide();
			$("#writeReply").show();
			formclear();
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
					replyList(reReqPage);
					formhide();
					$("#writeReply").show();
					formclear();
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
					replyList(reReqPage);
					formhide();
					$("#writeReply").show();
					formclear();
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});


		});

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
					formhide();
					alert("댓글 작성 성공~");
					replyList(reReqPage);
					$("#writeReply").show();
					formclear();		
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		}); 


		// '댓글' 버튼을 클릭했을때
		$("#reply").on("click", ".reList #reReplyBtn", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");
			
			$("#writeReply").hide();
			$("#modifyDiv").hide();
			$("#rereDiv").show();
			$(".title-diaLog").html(rNum);

			// 댓글 작성하기를 클릭했을때
			$("#rereplyBtn").click(function() {
				
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
						formhide();
						alert("댓글 작성 성공~");
						replyList(reReqPage);
						$("#writeReply").show();
						formclear();
					},
					error : function(e) {
						console.log("실패" + e);
					}
				});
			});
		});

		// 좋아요 버튼 클릭
		$("#reply").on("click", ".reList a #goodBtn", function() {
			var li = $(this).parent().parent();
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
					replyList(reReqPage);
					formhide();
					alert("좋아요");
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});

		// 싫어요 버튼 클릭
		$("#reply").on("click", ".reList a #badBtn", function() {
			var li = $(this).parent().parent();
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
					replyList(reReqPage);
					formhide();
					alert("싫어요");
					
				},
				error : function(e) {
					console.log("실패" + e);
				}
			});
		});
		
		// 페이지 선택했을 때
		$("#pageNumList").on("click", "a ", function(evt) {
			evt.preventDefault();
			reReqPage = $(this).attr("href");
			replyList(reReqPage);
			formhide();
			formclear();
		});
	});


	// 댓글 목록 가져오기	
	function replyList(reReqPage) {
		var str = "";
		$.ajax({
			type : "GET",
			url : "/webedu/rbbs/list?reReqPage=" + reReqPage + "&bNum=" + bNum,
			dataType : "json",
			success : function(data) {
				 console.log(data);
				 console.log(data.result);
				 console.log(data.pageCriteria);
				$.each(data.result, function(idx, rec) {
					if(rec.RINDENT==0 ) {
						str+="<hr>";
					}
					str += "<li data-rNum='" + rec.RNUM + "' class = 'reList'>";
						for(var i = 0; rec.RINDENT>i; i++){
							str+= "&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						str += rec.RNAME + " | " + rec.RCDATE +"<br>";
						for(var i = 0; rec.RINDENT>i; i++){
							str+= "&nbsp;&nbsp;&nbsp;";
						}
						if(rec.RINDENT>0) {
							str+= "└ ";
						}
					
						str += rec.RCONTENT + " | "
						+ "<button id=\"modifyBtn\" style=\"float:right\" class='btn btn-outline-primary btn-sm'>수정</button>"
						+ "<button id=\"reReplyBtn\" style=\"float:right\" class='btn btn-outline-primary btn-sm'>댓글</button>"
						+ "<a href='#'> "
				        +  "<span class='glyphicon glyphicon-thumbs-up' id='goodBtn'></span>"
				        + "</a>"
				        + rec.RGOOD  
				        + "  |  <a href='#'> "
				        + " <span class='glyphicon glyphicon-thumbs-down' id='badBtn'></span>"
				        + "</a>"
				        + rec.RBAD
						+ "</li>";
				});
		
				$("#reply").html(str);
			
				//페이지 리스트 호출
				showPageList(data.pageCriteria);
			},
			error : function(error) {
				console.log("실패" + error);
			}
		});
	}
	
	// 페이지 리스트
	function showPageList(pageCriteria) {
		var str = "";
		
		// 이전표시
		if(pageCriteria.prev) {
			str += "<li><a href='1'>◀</a></li>";
			str += "<li><a href='" + (pageCriteria.startPage-1) + "' aria-label=\"Prev\">" + 
			"<span aria-hidden=\"true\">&laquo;</span> <span class=\"sr-only\">Prev</span> "
			+ "</a></li>";
		
		}
		for(var i= pageCriteria.startPage, end=pageCriteria.endPage; i<=end; i++)  {
			if(reReqPage == i) {
			str += "<li class=\"page-item active\"><a class=\"page-link\" href='#'>" + i + "</a></li>";
			} else {
			str += "<li class=\"page-item \"><a class=\"page-link\" href='" + i + "'>" + i + "</a></li>";
			}
		}
		//다음 표시
		if(pageCriteria.next) {
			str += "<li><a href='" + (pageCriteria.endPage+1) + "' aria-label=\"Next\">" + 
			"<span aria-hidden=\"true\">&raquo;</span> <span class=\"sr-only\">Next</span> "
			+ "</a></li>";
			str += "<li><a href='" + (pageCriteria.finalEndPage) + "'>" + "▶</a></li>";			
		}
		$("#pageNumList").html(str);
	}
	
	// 폼안에 있는 내용 삭제
	function formclear() {
		$('textarea').val("");
		$('input').val("");
	}
	
	// 수정, 리댓 폼 하이드
	function formhide() {
		$("#modifyDiv").hide();
		$("#rereDiv").hide();
	}
	
</script>

</head>
<body>
	<div class="container" id="allDiv">
	
		<!-- 댓글 작성하기 폼 -->
		<div id="writeReply">
		<input type="text" name="" id="writer" class="form-control-m" placeholder="작성자" /><br>
		<textarea name="rContent" id="replyContent" class="form-control-m" cols="60" rows="3" placeholder="이곳에 댓글을 입력하세요." ></textarea>
		<div class="textByte"></div>	<button id="replyBtn" style="float:right" class='btn btn-outline-primary btn-sm'>댓글작성</button>
		</div>
		
		<!-- 댓글의 수정버튼을 눌렀을때의 폼.. -->
		<div id="modifyDiv">
			<span class="title-diaLog" ></span>번 댓글<br>
				<textarea id="reContent" cols="60" rows="3" class="form-control-m" placeholder="이곳에 댓글을 입력하세요."></textarea>
				<div class="textByte"></div>
			<div style="float:right">
				<button id="reModifyBtn" class='btn btn-outline-primary btn-sm'>수정</button>
				<button id="reDelBtn" class='btn btn-outline-primary btn-sm'>삭제</button>
				<button id="exitBtn" class='btn btn-outline-primary btn-sm'>닫기</button>
			</div>
		</div>
		
		<!-- 대댓글 작성할때의 폼.. -->
		<div id="rereDiv">
			<span class="title-diaLog" ></span>번 댓글에 댓글달기<br>
			<input type="text" name="" id="reWriter" class="form-control-m"
				placeholder="작성자" /><br>
			<textarea name="rContent" id="reReplyContent" class="form-control-m" cols="60" rows="3"
				placeholder="이곳에 댓글을 입력하세요."></textarea><div class="textByte"></div>
				<div style="float:right">
			<button id="rereplyBtn" class='btn btn-outline-primary btn-sm'>댓글작성</button>
			<button id="reExitBtn" class='btn btn-outline-primary btn-sm'>닫기</button>
			</div>
		</div>




		<h4>댓글리스트</h4>
		<ul id="reply">

		</ul>
		
		<ul id="pageNumList"
			class="pagination pagination-m justify-content-center">

		</ul>
	</div>

</body>
</html>