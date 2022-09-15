<%@page import="com.academy.springdb.model.domain.News"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
News news = (News) request.getAttribute("news");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=button] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

#inputArea input[name='detail'] {
	width: 65%
}

#inputArea input[name='author'] {
	width: 15%
}

#inputArea input[name='button'] {
	width: 15%
}
</style>
<!--REACT  -->
<script src="https://unpkg.com/react@18/umd/react.development.js"
	crossorigin></script>
<script
	src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"
	crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type ="text/babel">
function regist() {
		if (confirm("등록하시겠습니까?")) {
			form1.action = "/news/regist";
			form1.method = "post";
			form1.submit();
		}
	}
	
//데이터 출력용  tr을 컴포넌트로 정의한다.(reusable UI Compoent)
function Row(){
	return(
		<tr>
			<td>댓글내용</td>
			<td>작성자</td>
			<td>22-09-15</td>
		</tr>
	);
}

function printCommentsList(){
	var tag = [];
	for(var i =0; i<10; i++){
		tag.push(<Row/>);//컴포넌트 1개를 변수에 추가
	}
		var result=(
			<table width="100%" border="1px">
				<tr>
					<th width="65%">댓글내용</th>
					<th width="15%">작성자</th>
					<th width="20%">등록일</th>
				</tr>
				{tag}
			</table>
		);

	var root = ReactDOM.createRoot(document.getElementById("listArea"));
	root.render(result);
	}

$(function(){
	printCommentsList();
});
</script>
</head>
<body>

	<h3>뉴스 상세 보기</h3>

	<div class="container">
		<form name="form1">
			<input type="text" name="title" placeholder="제목입력" value="<%=news.getTitle()%>"> 
			<input type="text" name="writer" placeholder="작성자 입력" value="<%=news.getWriter()%>">
			<textarea name="content" placeholder="내용작성" style="height: 200px"><%=news.getContent()%></textarea>
			<input type="button" value="등록" onClick="regist()"> 
			<input type="button" value="목록" onClick="location.href='/news/list'">
		</form>

		<div id="inputArea">
			<input type="text" name="detail"> 
			<input type="text" name="author"> 
			<input type="button" value="댓글등록">
		</div>
		<div id="listArea"></div>
	</div>

</body>
</html>