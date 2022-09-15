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
function Row(props){
	return(
		<tr>
			<td>{props.detail}</td>
			<td>{props.cwriter}</td>
			<td>{props.cregdate}</td>
		</tr>
	);
}

function printCommentsList(jsonArray){
	var tag = [];

	for(var i =0; i<jsonArray.length; i++){
		var comments=jsonArray[i];
		tag.push(<Row detail={comments.detail} cwriter={comments.author} cregdate={comments.writedate}/>);//컴포넌트 1개를 변수에 추가
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

//비동기 댓글 등록 요청
function registAsync(){
	$.ajax({
		url:"/rest/comments",
		type:"post",
		data:{
			detail:$("input[name='detail']").val(),
			author:$("input[name='author']").val(),
			news_id: $("input[name='news_id']").val()
		},
		success:function(result,status,xhr){//서버의 응답이 성공하면(200) 익명함수가 호출됨
			getListAsync();
		}
	});	
}
//비동기 댓글 가져오기 
function getListAsync(){
	$.ajax({
//		요청이니까 /rest를 넣어야함 서버쪽에서는 /rest를 넣지 않아도 됨 
		url:"/rest/comments/"+$("input[name='news_id']").val(),  
		type:"get",
		success : function(result, status, xhr){
			console.log("댓글 수는 :"+result.length);
		
			printCommentsList(result);//json배열을 넘김 
	
		}
	});
}
function edit(){
	if(confirm("수정하시겠어요?")){
		$("form").attr({
			action:"/news/update",
			method:"post"
		});
		$("form").submit();
	}
}

function del(){
	if(confirm("삭제하시겠어요?")){
		$(location).attr("href","/news/delete?news_id="+$("input[name='news_id']").val());
	}
}
$(function(){
	getListAsync()

	
	//댓글 등록이벤트 구현 
	$("#inputArea input[type='button']").click(function(){
		registAsync();
	});
});
</script>
</head>
<body>

	<h3>뉴스 상세 보기</h3>

	<div class="container">
		<form name="form1">
			<input type ="hidden" name="news_id" value="<%=news.getNews_id()%>">
			<input type="text" name="title" placeholder="제목입력" value="<%=news.getTitle()%>"> 
			<input type="text" name="writer" placeholder="작성자 입력" value="<%=news.getWriter()%>">
			<textarea name="content" placeholder="내용작성" style="height: 200px"><%=news.getContent()%></textarea>
			
			<input type="button" value="수정" onClick="edit()"> 
			<input type="button" value="삭제" onClick="del()"> 
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