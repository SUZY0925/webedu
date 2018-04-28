/*jQuery 이용한 유효성체크*/
$(function() {
	$("input[value='등록']").click(function() {
		if ($("input[name=bTitle]").val() == "") {
			window.alert("제목을 입력해주세요!");
			$("input[name=bTitle]").focus();
			return false;
		}
		if ($("input[name=bName]").val() == "") {
			window.alert("작성자를 입력해주세요!");
			$("input[name=bName]").focus();
			return false;
		}
		if ($("textarea[name=bContent]").val() == "") {
			window.alert("내용을 입력해주세요!");
			$("textarea[name=bContent]").focus();
			return false;
		}
		document.write_form.submit();
	});	
});

