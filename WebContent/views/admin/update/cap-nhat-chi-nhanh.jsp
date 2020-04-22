<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
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
							<header class="panel-heading">Cập Nhật Chi Nhánh</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-chi-nhanh">
									<div class="form-group">
										<label class="col-sm-12" id="notification"
											style="text-align: center;"></label>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã chi nhánh</label>
										<div class="col-sm-6">
											<input type="text" name="branchId"
												value="${branch.getBranchId() }" readonly="readonly"
												placeholder="Nhập mã chi nhánh..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên chi nhánh</label>
										<div class="col-sm-6">
											<input type="text" name="branchName"
												value="${branch.getBranchName() }"
												placeholder="Nhập tên chi nhánh..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Địa chỉ</label>
										<div class="col-sm-6">
											<input type="text" name="address"
												value="${branch.getAddress() }"
												placeholder="Nhập tên địa chỉ..." class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="action" class="btn btn-save" type="submit"
												value="Update">
												<i class="glyphicon glyphicon-edit"></i> Update
											</button>
											<button name="action" class="btn btn-cancel" type="button"
												value="Cancel" onclick="history.go(-1);">
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
</script>
</body>

</html>