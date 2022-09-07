<%@page import="com.academy.springmvcsimple.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Emp> memberlist =(List) request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/inc/header.jsp" %>
</head>
<body>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">사원 목록</h3>

					<div class="card-tools">
						<div class="input-group input-group-sm" style="width: 150px;">
							<input type="text" name="table_search"
								class="form-control float-right" placeholder="Search">

							<div class="input-group-append">
								<button type="submit" class="btn btn-default">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /.card-header -->
				<div class="card-body table-responsive p-0">
					<table class="table table-hover text-nowrap">
						<thead>
							<tr>
								<th>사원 번호</th>
								<th>사원명</th>
								<th>급여</th>
								<th>입사일</th>
								<th>부서 번호</th>
								<th>부서명</th>
								<th>부서 위치</th>
							</tr>
						</thead>
						<tbody>
						<%for(Emp emp : memberlist){//개선된 for문%>
							<tr>
								<td><%= emp.getEmpno() %></td>
								<td><a href="/member/detail?empno=<%=emp.getEmpno()%>"><%= emp.getEname() %></a></td>
								<td><%= emp.getSal() %></td>
								<td><%= emp.getHiredate() %></td>
								<td><%= emp.getDept().getDeptno() %></td>
								<td><%= emp.getDept().getDname() %></td>
								<td><%= emp.getDept().getLoc() %></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
	</div>
	<!-- /.row -->
	<%@ include file="/inc/footer.jsp" %>
</body>
</html>