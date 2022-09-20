<%@page import="java.util.List"%>
<%@page import="com.academy.shopping.model.domain.TopCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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

                     <select class="form-control select" style="width: 100%;" size="7" name="sub">
                     </select>
                   </div>
                                 
                   </div>
                </div>
               <div class="col-md-9">
	                  <input type="text" class="form-control" placeholder="상품명">
	                  <input type="text" class="form-control" placeholder="브랜드">
	                  <input type="number" class="form-control" placeholder="원가격">
	                  <input type="number" class="form-control" placeholder="할인가격">
	                  <textarea class="form-control" placeholder="간략 설명" ></textarea>
	                  <textarea class="form-control" id="summernote" placeholder="간략 설명"></textarea>
	                  <input type="file" class="form-control" placeholder="상품 이미지 선택" name="photo">
	                  
	                  <button class="btn btn-info" onClick="registProduct()">상품등록</button>
	                  <button class="btn btn-info">목록보기</button>
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
   var sel=$("select[name='sub']");
   $(sel).empty();  //기존 카테고리 초기화
   var tag="";
   for(var i=0; i<jsonList.length; i++){
      var subcategory=jsonList[i];
      tag+="<option value=\""+subcategory.subcategory_id+"\">"+subcategory.category_name+"</option>";
   }
   $(sel).append(tag);
}


//상품 등록 요청
function registProduct(){
	if(confirm("상품을 등록하시겠어요?")){
		
		$("form").attr({
			"action":"/admin/product/regist",
			"method":"post",
			"enctype":"multipart/form-data"
		});
		$("form").submit();
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