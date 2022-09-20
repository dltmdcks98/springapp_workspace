<%@page import="com.academy.shopping.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@page
	import="com.academy.shopping.restcontroller.TopCategoryRestController"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Product> productList = (List) request.getAttribute("productList");
%>
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
		<%@ include file="../inc/topbar.jsp" %>
		<%@ include file="../inc/sidebar.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>상품 목록</h1>
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
					        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Responsive Hover Table</h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

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
                      <th>No</th>
                      <th>카테고리</th>
                      <th>사진</th>
                      <th>상품명</th>
                      <th>브랜드</th>
                      <th>가격</th>
                      <th>할인가격</th>
                      <th>파일명</th>
                    </tr>
                  </thead>
                  <tbody>
                  <%for(int i=0; i<productList.size();i++){ %>
                  <%Product product = productList.get(i); %>
                    <tr>
                      <td><%=i %></td>
                      <td><%=product.getSubcategory().getCategory_name() %></td>
                      <td><img src="/static/data/<%=product.getProduct_img() %>" width="45px" ></td>
                      <td><a href="/admin/subcategory/<%=product.getProduct_id()%>"><%=product.getProduct_name() %></a></td>
                      <td><%=product.getBrand() %></td>
                      <td><%=product.getPrice() %></td>
                      <td><%=product.getDiscount() %></td>
                      <td><%=product.getProduct_img() %></td>
                    </tr>
                   <%} %>
                  </tbody>
                </table>
                <button class="btn btn-primary" onClick="location.href='/admin/product/registform';">상품등록</button>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
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
			 $($("input[name='category_name']")[0]).empty();
			
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
