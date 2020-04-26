<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/common/admin/css-resources.jsp"%>
</head>

<body>
	<section id="container">
		<%@include file="/common/admin/header.jsp"%>
		<%@include file="/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading">Thêm Chi Nhánh</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-chi-nhanh">
									<div class="form-group">
										<label class="col-sm-12" id="notification" style="text-align: center;"></label>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã chi nhánh</label>
										<div class="col-sm-6">
											<input type="text" name="brandId" id="branchId"
												placeholder="Nhập mã chi nhánh..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên chi nhánh</label>
										<div class="col-sm-6">
											<input type="text" name="branchName"
												placeholder="Nhập tên chi nhánh..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Địa chỉ</label>
										<div class="col-sm-6">
											<input type="text" name="address"
												placeholder="Nhập tên địa chỉ..." class="form-control" required>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="action" class="btn btn-save"
												type="submit" value="Submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button class="btn btn-cancel"
												type="button"  onclick="history.go(-1);">
												<i class="glyphicon glyphicon-remove"></i> Cancel
											</button>
										</div>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>

			</section>
			<!-- footer -->
			<!--<div class="footer">
                <div class="wthree-copyright">
                    <p>© 2017 Visitors. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
                </div>
            </div>-->
			<!-- / footer -->
		</section>
		<!--main content end-->
	</section>
	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	if(${error != null}){
		$("#notification").text("${error}");
        $("#notification").css("color", "red");
	}
		$("#branchId").on("change", function () {
	        var branchId = $("#branchId").val();
	        var patt = new RegExp("^CN[0-9]{4}$");
	        if (!(patt.test(branchId))) {
	            $("#notification").text("Mã KH: Có format là KHxxxx (x: ký tự số)");
	            $("#notification").css("color", "red");
	            $(this).val("");
	            $(this).focus();

	        } else {
	            $("#notification").text("")
	        }
		});
</script>
</body>

</html>