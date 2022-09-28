<%@page import="com.academy.shopping.model.domain.OrderSummary"%>
<%@page import="com.academy.shopping.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.academy.shopping.restcontroller.admin.TopCategoryRestController"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	 List<OrderSummary> orderSummaryList = (List)request.getAttribute("orderSummaryList");
	
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
                <h3 class="card-title">주문현황</h3>

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
                      <th>주문번호</th>
                      <th>구매자</th>                  
                      <th>결제방법</th>
                      <th>총구매금액</th>
                      <th>총결제금액</th>
                      <th>주문일</th>
        
                    </tr>
                  </thead>
                  <tbody>
                  <%for(int i=0; i<orderSummaryList.size();i++){ %>
                  <%OrderSummary orderSummary = orderSummaryList.get(i); %>
                    <tr>
                      <td><%=i+1 %></td>
                      <td><%=orderSummary.getOrdersummary_id() %></td>
                      <td><%=orderSummary.getMember().getCustomer_name() %></td>
                      <td><%=orderSummary.getPaymethod().getPayname() %></a></td>
                      <td><%=orderSummary.getTotalbuy() %></td>
                      <td><%=orderSummary.getTotalpay() %></td>
                      <td><%=orderSummary.getBuydate() %></td>
                    </tr>
                   <%} %>
                  </tbody>
                </table>
                
                <button class="btn btn-primary" onClick="location.href='/admin/product/registform';">상품등록</button>
                <button class="btn btn-primary" onClick="showExcel()">엑셀등록</button>
                <div style="display:none" id="excel-area">
                	<form id="excel-form">
		                <input type="file" name="excel" > 
		                <button type="button" class="btn btn-info" onClick="registExcel()">등록</button>
					</form>
				</div>              
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
		
	//가려져있던 엑셀 등록 폼을 등장시키자
	function showExcel(){
		$("#excel-area").css({
			display:"block"
			
		});
	}
	//엑셀파일을 이용한 상품일괄 등록
	function registExcel(){
		if($("input[name='excel']").val==""){
			alert("선택한 파일이 없음");
			return;
			
		}
		if(confirm("액셀로 등록할까요?")){
		$("#excel-form").attr({
			"action":"/admin/product/excel",
			"method":"post",
			"enctype":"multipart/form-data"
			
		});
			$("#excel-form").submit();
		}
	}
	$(function() {
		getTopList();//상위카테로길의 목록 가져오기

		$($("select")[0]).change(function() {
			/* alert("당신이 선택한 아이템의 value값은 :" + $(this).val()); */
			getSubList($(this).val());
		});
		//파일 선택 컴포넌트에 이벤트 연결
		$("input[name='excel']").change(function(){
			//선택한 파일 구하기
			var ext = getExt($(this).val());
			if(ext!="xls" && ext!="xlsx"){
				alert("엑셀만 선택하세요");	
			}
		});
	});
	

	</script>
</body>
</html>
