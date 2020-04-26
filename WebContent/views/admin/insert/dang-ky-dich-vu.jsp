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
							<header class="panel-heading">Đăng Ký Dịch Vụ</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="get"
									action="dang-ky-dich-vu">


									<div class="form-group">
										<label class="col-sm-3 control-label">Mã dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="maDv"
												placeholder="Nhập mã dịch vụ..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã thành viên</label>
										<div class="col-sm-6">
											<input type="text" name="maTv"
												placeholder="Nhập mã thành viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Thời gian đăng
											ký dịch vụ</label>
										<div class="col-sm-6">
											<input type="date" name="thoiGian" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Chi phí</label>
										<div class="col-sm-6">
											<input type="number" name="chiPhi" min="0"
												placeholder="Nhập chi phí đăng ký..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" class="btn btn-save" type="submit"
												value="submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button name="cancel" class="btn btn-cancel" value="cancel"
												type="button">
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
</body>

</html>