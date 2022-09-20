<%@page
	import="com.academy.shopping.restcontroller.TopCategoryRestController"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Advanced form elements</title>
<%@ include file="../inc/header_link.jsp"%>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="../../index3.html" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<!-- Navbar Search -->
				<li class="nav-item"><a class="nav-link"
					data-widget="navbar-search" href="#" role="button"> <i
						class="fas fa-search"></i>
				</a>
					<div class="navbar-search-block">
						<form class="form-inline">
							<div class="input-group input-group-sm">
								<input class="form-control form-control-navbar" type="search"
									placeholder="Search" aria-label="Search">
								<div class="input-group-append">
									<button class="btn btn-navbar" type="submit">
										<i class="fas fa-search"></i>
									</button>
									<button class="btn btn-navbar" type="button"
										data-widget="navbar-search">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
						</form>
					</div></li>

				<!-- Messages Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="far fa-comments"></i>
						<span class="badge badge-danger navbar-badge">3</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="/static/admin/dist/img/user1-128x128.jpg"
									alt="User Avatar" class="img-size-50 mr-3 img-circle">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Brad Diesel <span class="float-right text-sm text-danger"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">Call me whenever you can...</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="/static/admin/dist/img/user8-128x128.jpg"
									alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										John Pierce <span class="float-right text-sm text-muted"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">I got your message bro</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="/static/admin/dist/img/user3-128x128.jpg"
									alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Nora Silvester <span class="float-right text-sm text-warning"><i
											class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">The subject goes here</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All
							Messages</a>
					</div></li>
				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span
						class="badge badge-warning navbar-badge">15</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-item dropdown-header">15
							Notifications</span>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-envelope mr-2"></i> 4 new messages <span
							class="float-right text-muted text-sm">3 mins</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-users mr-2"></i> 8 friend requests <span
							class="float-right text-muted text-sm">12 hours</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i>
							3 new reports <span class="float-right text-muted text-sm">2
								days</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All
							Notifications</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					data-widget="fullscreen" href="#" role="button"> <i
						class="fas fa-expand-arrows-alt"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					data-widget="control-sidebar" data-slide="true" href="#"
					role="button"> <i class="fas fa-th-large"></i>
				</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<%@ include file="../inc/sidebar.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Advanced Form</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Advanced Form</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<!-- SELECT2 EXAMPLE -->
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">카테고리 관리</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								<button type="button" class="btn btn-tool"
									data-card-widget="remove">
									<i class="fas fa-times"></i>
								</button>
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>상위카테고리</label>
										<!-- bootstrap은 한 div당 12칸으로 나누는데 이를 12칸으로 나누기 위해 class:row를 넣고, 나눌 대상을 col-md-숫자 를 넣는다.  -->
										<div class="row" style="margin: 1px">
											<input type="text" class="form-control col-md-11"
												name="category_name">
											<button class="btn btn-primary col-md-1"
												onClick="registTop()">등록</button>
										</div>
										<select class="form-control select" style="width: 100%;"
											size="20">
											<option selected="selected">Loading.....</option>
										
										</select>
									</div>
									<!--/.form-group  -->
									<button class="btn btn-primary">등록</button>
									<button class="btn btn-primary">삭제</button>
								</div>


								<div class="col-md-6">
									<div class="form-group">
										<label>하위카테고리</label> 
											<div class="row" style="margin: 1px">
												<input type="text" class="form-control col-md-11"
													name="category_name">
												<button class="btn btn-info col-md-1"
													onClick="registSub()">등록</button>
											</div>
										<select class="form-control select"
											style="width: 100%;" size="20">

										</select>
									</div>
									<!--/.form-group  -->
									<button class="btn btn-primary">등록</button>
									<button class="btn btn-primary">삭제</button>
								</div>
								<!-- /.col -->
							</div>
							<!--/.row  -->
						</div>
						<!-- /.card-body -->
						<div class="card-footer">원하시는 아이템을 선택후 삭제 및 수정이 가능합니다.</div>
					</div>
					<!-- /.card -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.2.0
			</div>
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
<%@ include file="../inc/footer_link.jsp" %>
	<script>
		function getTopList() {
			$.ajax({
				url : "/rest/admin/topcategory",
				type : "get",
				success : function(result, status, xhr) {
					printTopList(result);
				}

			});
		}

		function printTopList(jsonList) {

			var sel = $($("select")[0]);
			$(sel).empty();//기존 아이템을 모두 초기화

			var tag = "";
			for (var i = 0; i < jsonList.length; i++) {
				var topcategory = jsonList[i];//상위 카테고리 json
				tag += "<option value=\""+topcategory.topcategory_id+"\">"
						+ topcategory.category_name + "</option>";
			}
			$(sel).append(tag);

		}
		//상위 카테고리 비동기 등록 요청
		function registTop() {
			$.ajax({
				url : "/rest/admin/topcategory",
				type : "post",
				data : {
					category_name : $($("input[name='category_name']")[0]).val()
				},
				success : function(result, status, xhr) {
					getTopList();
				},
				error : function(xhr, status, error) {
					alert(status, +", " + error);
				}

			});
		}
		/*-------- 하위 카테고리------ */

		//하위 카테고리에 대한 비동기 등록 요청
		//주의) 반드시 상위 카테고리가 하나라도 선택이 되어있어야 한다.(유효성 체크)
		function registSub(){
			if($($("select")[0]).prop('selectedIndex')==-1){
				alert("좌측 영역에서 상위 카테고리를 적어도 하나는 선택하세요");
				return;
			}
			
			//하위카테고리 비동기 요청
			$.ajax({
				url:"/rest/admin/subcategory",
				type:"post",
				data:{
					"category_name":$($("input[name='category_name']")[1]).val(),
					"topcategory.topcategory_id":$($("select")[0]).val()
				},
				success:function(result,status,xhr){
					getSubList($($("select")[0]).val());
				},error:function(xhr,status,error){
					
				}
			});
		}
		//선택한 상위 카테고리에 소속된 하위 목록 가져오기
		function getSubList(topcategory_id){
			$.ajax({
				url : "/rest/admin/subcategory/"+topcategory_id,
				type : "get",
				success : function(result, status, xhr) {
					printSubList(result);
				},
				error:function(xhr,status,error){
					
				}

			});
		}
		function printSubList(jsonList){
			var sel = $($("select")[1]);
			$(sel).empty();//기존 아이템을 모두 초기화

			var tag = "";
			console.log(jsonList.length);
			for (var i = 0; i < jsonList.length; i++) {
				var subcategory = jsonList[i];//상위 카테고리 json
				tag += "<option value=\""+subcategory.subcategory_id+"\">"
						+ subcategory.category_name + "</option>";
			}
			$(sel).append(tag);
			
		}
		$(function() {
			getTopList();//상위카테로길의 목록 가져오기

			$($("select")[0]).change(function() {
				/* alert("당신이 선택한 아이템의 value값은 :" + $(this).val()); */
				getSubList($(this).val());
			});

		});
	</script>
</body>
</html>
