<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/common/admin/css-resources.jsp" %>
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
							<header class="panel-heading">Cập Nhật Đăng Ký Lớp Học</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-dang-ky-lop">

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Lớp tập</label>
										<div class="col-lg-6">
											<select name="classId" class="form-control m-bot15">
												<c:forEach items="${listClass}" var="lop">
													<option value="${lop.classId}">${lop.className}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã thành viên</label>
										<div class="col-sm-6">
											<input type="text" name="memberId" value="${rc.memberId}"
												 class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày đăng kí lớp</label>
										<div class="col-sm-6">
											<input type="Date" name="registerDate" value="${rc.registerDate}" class="form-control">
											<p style="color: red">${error}</p>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Trạng thái phí</label>
										<div class="col-lg-6">
											<select name="payStatus"
												class="form-control m-bot15">
												<option value="Chưa đóng phí">Chưa thanh toán phí</option>
												<option value="Đã đóng phí">Đã thanh toán phí</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" value="submit" class="btn btn-save" type="submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button name="cancel" value="cancel" class="btn btn-cancel" type="submit">
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

	<%@include file="/common/admin/js-resources.jsp" %>
</body>

</html>