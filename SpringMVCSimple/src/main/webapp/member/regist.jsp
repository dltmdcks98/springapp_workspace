<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/resources/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/resources/admin/dist/css/adminlte.min.css">
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
	<!-- jQuery -->
	<script src="/resources/admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
		src="/resources/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/admin/dist/js/adminlte.min.js"></script>

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