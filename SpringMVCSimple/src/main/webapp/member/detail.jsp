<%@page import="com.academy.springmvcsimple.domain.Emp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%Emp emp = (Emp) request.getAttribute("emp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
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
							placeholder="사원명" value="<%=emp.getEname()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망급여</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" name ="sal"
							placeholder="희망급여"  value="<%=emp.getSal()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">입사일</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name ="hiredate"
							placeholder="입사일"  value="<%=emp.getHiredate()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망 부서</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.dname" placeholder="희망부서"  value="<%=emp.getDept().getDname()%>">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">부서 위치</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.loc" placeholder="부서 위치" value="<%=emp.getDept().getLoc()%>">
					</div>
				</div>
				
			</div>
			<!-- /.card-body -->
			<div class="card-footer">
				<button type="button" class="btn btn-danger" onClick="location.href='/member/list';">목록보기</button>
				<button type="button" class="btn btn-danger" onClick="edit();">수정</button>
				<button type="button" class="btn btn-danger" onClick="del();">삭제</button>
				<button type="submit" class="btn btn-default float-right">Cancel</button>
			</div>
			<!-- /.card-footer -->
		</form>
	</div>
	<!-- /.card -->

<%@ include file="/inc/footer.jsp" %>
	<!-- Page specific script -->
	<script>
	function edit(){
		if(confirm("수정하시겠어요?")){
			form1.action = "/member/edit";
			form1.method = "post";
			form1.submit();
		}
	}
	function del(){
		if(confirm("삭제?")){
			location.href="/member/delete?notice_id=<%=emp.getEmpno()%>";
		}
	}
	</script>
</body>
</html>