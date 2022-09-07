<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/inc/header.jsp" %>
</head>
<body>
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Horizontal Form</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<form class="form-horizontal">
			<div class="card-body">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">사원명</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name ="ename"
							placeholder="사원명">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망급여</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" name ="sal"
							placeholder="희망급여">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망 부서</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.dname" placeholder="희망부서">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">부서 위치</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.loc" placeholder="부서 위치">
					</div>
				</div>
				
			</div>
			<!-- /.card-body -->
			<div class="card-footer">
				<button type="button" class="btn btn-danger">사원 등록</button>
				<button type="submit" class="btn btn-default float-right">Cancel</button>
			</div>
			<!-- /.card-footer -->
		</form>
	</div>
	<!-- /.card -->

<%@ include file="/inc/footer.jsp" %>
	<!-- Page specific script -->
	<script>
		$(function() {
			// bsCustomFileInput.init();
			$("button[type='button']").click(function(){
				$(".form-horizontal").attr({
					action:"/member/regist",
					method:"post"
				});
				$(".form-horizontal").submit();
			});
		});
	</script>
</body>
</html>