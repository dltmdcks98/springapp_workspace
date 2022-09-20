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
                  <textarea class="form-control" placeholder="간략 설명"></textarea>
               </div>
              
                <!-- /.form-group -->
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->     
          <!-- /.card-body -->
          <div class="card-footer">
            Visit <a href="https://select2.github.io/">Select2 documentation</a> for more examples and information about
            the plugin.
          </div>
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
function registTop(){
   $.ajax({
      url:"/rest/admin/topcategory",
      type:"post",
      data:{
         category_name:$($("input[name='category_name'][0]")).val()
      },
      success:function(result, status, xhr){
         alert(status);
      },
      error:function(xhr, status, error){
         alert(status+", "+error);
      }
   })
}

//하위 카테고리에 대한 비동기 등록요청
//주의) 반드시 상위 카테고리가 하나라도 선택되어있어야 한다(유효성 체크)
function registSub(){
   if($($("select")[0]).prop('selectedIndex')==-1){
      alert("좌측 영역에서 상위카테고리를 선택하세요");
      return;
   }
   $.ajax({
      url:"/rest/admin/subcategory",
      type:"post",
      data:{
         "category_name":$($("input[name='category_name']")[1]).val(),
         "topcategory.topcategory_id":$($("select")[0]).val()
      },
      success:function(result, status, xhr){
         alert(result);
         getSubList($($("select")[0]).val())
      },
      error:function(xhr, status, error){
      }
   })      
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
$(function(){
   getTopList();
   
   $($("select")[0]).change(function(){
      //alert("당신이 선택한 아이템의 value값은 "+ $(this).val())
      getSubList($(this).val());
   });
})

</script>
</body>
</html>