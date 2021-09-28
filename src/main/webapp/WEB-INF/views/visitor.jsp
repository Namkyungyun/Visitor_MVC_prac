<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		const searchVisitors = document.getElementById("search-visitors");
		searchVisitors.onclick = function(event){
			$target = event.target;
			var nickname = $target.previousElementSibling.value;
			console.log((nickname == "${nickname}"));
			
			if($target.nodeName == "TEXTAREA"
					&& $target.readOnly
					&& (nickname == "${nickname}")){
				
				var result = confirm("수정하시겠습니까?");
				if(result){
					$target.readOnly = false;
				}
			}
		}
	}
	function updateVisitor($this){
		var result = confirm("정말로 수정하시겠습니까?");
		if(result){
			var form = $this.parentElement;
			form.action = "update";
			form.method = "post";
			form.submit();
		}
	}
	function deleteVisitor($this){
		var result = confirm("삭제하시겠습니까?")
		if(result){
			var form = $this.parentElement;
			form.action = "delete";
			form.method = "post";
			form.submit();
		}
	}

	function sessionOut($this){
		var result = confirm("방명록페이지에서 나가시겠습니까?");
		if(result){
			var form = $this.parentElement;
			form.action = "sessionOut";
			form.method = "post";
			form.submit();
		}
	}

</script>
</head>
<body>
	<h1>방명록을 입력하세요!</h1>
	<form action="" method="">
	 <button onclick="sessionOut(this)">나가기</button>
	</form>
	<form action="regist" method="post">
	nickname: <input type="text" name="nickname" value="${nickname}"><br>
	<textarea rows="10" cols="40" name="content"></textarea>	
	<input type="submit" value="등록">
	</form>
	
	<div id="search-visitors">
	  <c:forEach items="${vlist}" var="vvo">
		<form action="" method="">
			<input type="hidden" name="vno" value="${vvo.vno}">
			<span>${vvo.nickname} - ${vvo.regdate}</span><br>
			<input type="hidden" name="nickname" value="${vvo.nickname}">
			<textarea rows="10" cols="40" name="content" readonly> ${vvo.content} </textarea>
			<c:if test="${nickname eq vvo.nickname}">
				<a href="#" onclick ="updateVisitor(this)">수정</a>
				<a href="#" onclick="deleteVisitor(this)">삭제</a>
			</c:if>
		</form> 
	  </c:forEach>
    </div>
	
	
</body>
</html>