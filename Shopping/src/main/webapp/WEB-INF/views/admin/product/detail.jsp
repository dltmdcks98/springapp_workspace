<%@page import="com.academy.shopping.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.academy.shopping.model.domain.TopCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Product product = (Product)request.getAttribute("product");

	//현재 상품의 최상위 카테고리 가져오기
	int topcategory_id = product.getSubcategory().getTopcategory().getTopcategory_id();
	out.print(topcategory_id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Advanced form elements</title>
   <%@ include file="../inc/header_link.jsp" %>
<style >
	.col-md-9 *{
		margin:2px;'
	}
</style>

</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <%@ include file="../inc/topbar.jsp" %>
  <%@ include file="../inc/sidebar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>상품등록</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Advanced Form</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- SELECT2 EXAMPLE -->
        <div class="card card-primary">
        <form>
        <input type="hidden" name="product_id" value="<%=product.getProduct_id()%>">
        <input type="hidden" name="product_img" value="<%=product.getProduct_img() %>">
          <div class="card-header">
            <h3 class="card-title">상품 등록</h3>

            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-card-widget="collapse">
                <i class="fas fa-minus"></i>
              </button>
              <button type="button" class="btn btn-tool" data-card-widget="remove">
                <i class="fas fa-times"></i>
              </button>
            </div>
          </div>
          <!-- /.card-header -->
          <div class="card-body">
            <div class="row">
               <div class="col-md-3">
                  <div class="col-md-12">
                   <div class="form-group">
                     <label>상위 카테고리</label>

                     <select class="form-control select" style="width: 100%;" size="7" name="top">
                     </select>
                   </div>
                                 
                   </div>
                   <!-- /.form-group -->
                 <div class="col-md-12">
                   <div class="form-group">
                     <label>하위 카테고리</label>

                     <select class="form-control select" style="width: 100%;" size="7" name="subcategory.subcategory_id">
                     </select>
                   </div>
                                 
                   </div>
                </div>
               <div class="col-md-9">
	                  <input type="text" name="product_name"class="form-control" placeholder="상품명" value="<%=product.getProduct_name()%>">
	                  <input type="text" name="brand" class="form-control" placeholder="브랜드" value="<%=product.getBrand()%>">
	                  <input type="number" name="price"class="form-control" placeholder="원가격" value="<%=product.getPrice()%>">
	                  <input type="number"  name="discount" class="form-control" placeholder="할인가격" value="<%=product.getDiscount()%>">
	                  <textarea name="memo" class="form-control" placeholder="간략 설명" ><%=product.getMemo() %></textarea>
	                  <textarea name="detail" class="form-control" id="summernote" placeholder="간략 설명" ><%=product.getDetail()%></textarea>
	                  <input type="file" class="form-control" placeholder="상품 이미지 선택" name="photo">
	                  
	                  <button type="button" class="btn btn-info" onClick="editProduct()">상품수정</button>
	                  <button type="button" class="btn btn-info" onClick="deleteProduct()">상품삭제</button>
	                  <button type="button" class="btn btn-info" onClick="location.href='/admin/product/list';">목록</button>
               </div>
              
                <!-- /.form-group -->
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->     
          <!-- /.card-body -->
          <div class="card-footer">
            원하는 아이템을 선택후 수정, 삭제 가능
          </div>
          </form>
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
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<%@include file="../inc/footer_link.jsp" %>
<script>
function getTopList(){
   $.ajax({
      url:"/rest/admin/topcategory",
      type:"get",
      success:function(result, status, xhr){
         printTopList(result);
      }
   });
}
function printTopList(jsonList){
   var sel=$("select[name='top']");
   $(sel).empty();  //기존 카테고리 초기화
   var tag="";
   for(var i=0; i<jsonList.length; i++){
      var topcategory=jsonList[i];
      tag+="<option value=\""+topcategory.topcategory_id+"\">"+topcategory.category_name+"</option>";
   }
   $(sel).append(tag);
   
   //생성된 옵션들을 대상으로 자동 선택효과
   $(sel).val(<%=topcategory_id%>);
   getSubList(<%=topcategory_id%>);
}

//선택한 상위 카테고리에 소속된 하위 목록 가져오기
function getSubList(topcategory_id){
   $.ajax({
      url:"/rest/admin/subcategory/"+topcategory_id,
      type:"get",
      success:function(result, status, xhr){
         printSubList(result);
      },
      error:function(xhr, status, error){
         
      }
   });
}

function printSubList(jsonList){
   var sel=$("select[name='subcategory.subcategory_id']");
   $(sel).empty();  //기존 카테고리 초기화
   var tag="";
   for(var i=0; i<jsonList.length; i++){
      var subcategory=jsonList[i];
      tag+="<option value=\""+subcategory.subcategory_id+"\">"+subcategory.category_name+"</option>";
   }
   $(sel).append(tag);
   
   //생성된 옵션들을 대상으로 선택효과
   $(sel).val(<%=product.getSubcategory().getSubcategory_id()%>);
}


//상품 등록 요청
function editProduct(){
	if(confirm("상품을 수정하시겠어요?")){
		
		$("form").attr({
			"action":"/admin/product/edit",
			"method":"post",
			"enctype":"multipart/form-data"
		});
		$("form").submit();
	}
}

//비동기 전송시, json으로  key-value를 일일이 form을 포기하고 작성하는 것은 너무 불편
//시리얼화 시켜 편의성을 높이자
function deleteProduct(){
	//기존의 form양싱르 전송할 수 있도록 쪼개야한다.(직렬화)
	var formArray = $("form").serializeArray();
	
	for(var i=0;i<formArray.length;i++){
		console.log(formArray[i].name,"의 컴폰컨트의 값은",formArray[i].value);
	}
	//서버에 전송시 json으로 보내기
	var json = {};
	//json 동적 생성
	for(var i=0; i<formArray.length;i++){
		json[formArray[i].name]=formArray[i].value;
	}
	console.log(json);
	
  	if(confirm("상품을 삭제하시겠어요?")){
		$.ajax({
			url:"/rest/admin/product/delete",
			type:"post",
			contentType:"application/json;charset=utf-8",//서버에게 이 자료가 json 형태라는 것을 알려줌
			data:JSON.stringify(json), //json은 자체로 객체이므로 전송하려면 문자열화 시켜야한다.
			/* processData:false,// query String화 시키지 않도록 방지 */
			success:function(result, status, xhr){
				alert(result);
				location.href="/admin/product/list";
			}
		});
	} 
	
}

$(function(){
	 // Summernote
    $('#summernote').summernote({
    	height:200
    	
    });
    
   getTopList();
   
   $($("select")[0]).change(function(){
      //alert("당신이 선택한 아이템의 value값은 "+ $(this).val())
      getSubList($(this).val());
   });
   
  
   
})

</script>
</body>
</html>