<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/resources/admin/plugins/fontawesome-free/css/all.min.css">
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
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                      <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck2">
                        <label class="form-check-label" for="exampleCheck2">Remember me</label>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">Sign in</button>
                  <button type="submit" class="btn btn-default float-right">Cancel</button>
                </div>
                <!-- /.card-footer -->
              </form>
            </div>
            <!-- /.card -->
            <!-- jQuery -->
<script src="/resources/admin/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- bs-custom-file-input -->
<script src="/resources/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/admin/dist/js/adminlte.min.js"></script>

<!-- Page specific script -->
<script>
$(function () {
 // bsCustomFileInput.init();
});
</script>
</body>

</html>