
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>
	<%@ include file="../inc/css.jsp" %>
</head>

<body>
	<%@ include file="../inc/topbar.jsp" %>
	
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->
	
<section class="product-details spad">
	<div class="container">
		<div class="row">
			   <!-- Horizontal Form -->
		<div class="card card-info col-sm-12">
             <div class="card-header">
               <h3 class="card-title">회원 가입</h3>
             </div>
             <!-- /.card-header -->
             <!-- form start -->
             <form>
               <div class="card-body">
               
                 <div class="form-group row">
                   <label for="customer_id" class="col-sm-2 col-form-label">ID</label>
                   <div class="col-sm-8">
                   		<input type="text" class="form-control" id="customer_id" name="customer_id" placeholder="ID">
                   		<button class="btn btn-warning">중복확인</button>
                   </div>
                 </div>
                 
                 <div class="form-group row">
                   <label for="customer_name" class="col-sm-2 col-form-label">회원 이름</label>
                   <div class="col-sm-10">
                     <input type="text" class="form-control" id="customer_name" name="customer_name" placeholder="회원 이름">
                   </div>
                 </div>
                 
                 <div class="form-group row">
                   <label for="customer_pass" class="col-sm-2 col-form-label">Password</label>
                   <div class="col-sm-10">
                     <input type="password" class="form-control" id="customer_pass" name="customer_pass" placeholder="Password">
                   </div>
                 </div>
                 
                 <div class="form-group row">
                   <label for="customer_email" class="col-sm-2 col-form-label">회원이메일</label>
                   <div class="col-sm-10">
                     <input type="email" class="form-control" id="customer_email" name="customer_email" placeholder="회원이메일">
                   </div>
                 </div>
                 
               <!-- /.card-body -->
               <div class="card-footer">
                 <button type="button" class="btn btn-info">로그인</button>
                 <button type="button" class="btn btn-info">등록</button>
               </div>
               <!-- /.card-footer -->
             </form>
           </div>
    <!-- /.card -->
			
		</div>
	</div>

</section>	
	
	
<!-- Instagram Begin -->
<%@ include file="../inc/insta.jsp" %>

<%@ include file="../inc/footer.jsp" %>
<%@ include file="../inc/search.jsp" %>

<!-- Js Plugins -->
<%@ include file="../inc/plugin.jsp" %>
<script type="text/javascript">
var isCheck=false;//중복확인을 수행하였는지 여부

function checkId(){
	if($("customer_id").val()==""){
		alert("아이디를 입력하세요");
		return;
	}
	
	$.ajax({
		url:"/rest/member/"+$("#customer_id").val(),
		type:"get",
		success:function(result,status,xhr){
			console.log(result);
		}
		
	});
	
}

function regist(){
	if(!isCheck){
		alert("아이디 중복여부 확인");
		return;
	}	
	//폼전송
	$.ajax({
		url:"/rest/member",
		type:"post",
		data:{
			customer_id:$("#customer_id").val(),
			customer_name:$("#customer_name").val(),
			customer_pass:$("#customer_pass").val(),
			customer_email:$("#customer_email").val()
		},
		success:function(result,status,xhr){
			if(result.code==1){
				alert(result.msg);
			}else{
				alert(result.msg+"\n계속될 경우 관리자에게 연락바랍니다.");
			}
		},
		error:function(xhr,status,error){
			alert(error);
		}
	});
}
$(function(){
	//회원 등록 버튼에 이벤트 연결
	$($("form button")[0]).click(function(){//중목확인
		checkId();
	});
	
	$($("form button")[1]).click(function(){//로그인
		login();
	});
	
	$($("form button")[2]).click(function(){//가입
		regist();
	});
	
});
</script>
</body>

</html>