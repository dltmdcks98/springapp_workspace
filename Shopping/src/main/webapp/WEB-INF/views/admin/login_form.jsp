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
	width:30%;
  	border-radius: 5px;
  	background-color: #f2f2f2;
  	padding: 20px;
  	margin:auto;'
}
</style><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$($("input[type='button']")[0]).click(function(){
			//post요청 body에 실어서 옮겨야 노출되지 않음 
			$.ajax({
				url:"/rest/admin/login",
				type:"post",
				data:{
					user_id:$("input[name='user_id']").val(),
					pass:$("input[name='pass']").val()
				},
				success:function(result,status,xhr){
					console.log(result+" "+status);
				}
			});
		});
	});
</script>
</head>
<body>


<div class="container">
<h3>Admin Login Form</h3>
  <form>
    <input type="text" 			name="user_id" 	placeholder="Your ID..">

    <input type="password"  	name="pass" 		placeholder="Your Pass..">
    
    <input type="button" value="관리자 로그인">
    <input type="button" value="관리자 등록" onClick="location.href='/admin/registform'">
  </form>
</div>

</body>
</html>

