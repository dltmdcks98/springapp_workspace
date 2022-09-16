<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], input[type=password] {
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
  background-color: #051515;
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
	width:30%;
  	border-radius: 5px;
  	background-color: #f2f2f2;
  	padding: 20px;
  	margin:auto;'
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
//비동기로 요청 RESTful 하게 하므로, /rest/뒤에 명사형 즉 regist대신 명사로 표현
function registAsync(){
	$.ajax({
		url:"/rest/admin",
		type:"post",
		data:{
			user_id:$("input[name='user_id']").val() ,
			pass:$("input[name='pass']").val() ,
			name:$("input[name='name']").val()
		},
		success:function(result,status,xhr){
			alert(result);
		}
	});
	
}
$(function(){
	$($("input[type='button']")[1]).click(function(){
		//비동기로 가입을 처리 
		registAsync();
	});
});
</script>
</head>
<body>


<div class="container">
<h3>admin 등록</h3>
  <form action="/action_page.php">

    <input type="text" 			name=" user_id" 		placeholder="Admin ID..">    
    <input type="password"  	name="pass" 			placeholder="Admin Pass..">
    <input type="text" 			name="name" 			placeholder="Admin name..">
    
    <input type="button" value="관리자 로그인">
    <input type="button" value="관리자 등록" >
  </form>
</div>

</body>
</html>

