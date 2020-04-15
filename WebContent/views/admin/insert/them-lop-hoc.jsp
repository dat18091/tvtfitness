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
							<header class="panel-heading">Thêm Lớp Tập</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="${pageContext.request.contextPath}/them-lop-tap">
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã lớp học</label>
										<div class="col-sm-6">
											<input type="text" name="classId" placeholder="TC0001"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="className" placeholder="Tên lớp tập"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Gói</label>
										<div class="col-lg-6">
											<select name="packageName" class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">Gói VIP</option>
												<option value="{{ $parent->parent_id }}">Gói 1
													tháng</option>
												<option value="{{ $parent->parent_id }}">Gói nửa
													năm</option>
												<option value="{{ $parent->parent_id }}">Gói 1 năm</option>
												<option value="{{ $parent->parent_id }}">Gói bình
													thường</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Nhân viên</label>
										<div class="col-lg-6">
											<select name="category_product_parent"
												class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">Hoàng Hải</option>
												<option value="{{ $parent->parent_id }}">Thành Đông</option>
												<option value="{{ $parent->parent_id }}">Quang Hiếu</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian Biểu</label>
										<div class="col-lg-6">
											<input type="checkbox" id="vehicle1" name="timeTable" value="2">
											<label for="vehicle1">Thu 2</label> &nbsp;
											<input type="checkbox" id="vehicle2" name="timeTable" value="3">
											<label for="vehicle2">Thu 3</label> &nbsp;
											<input type="checkbox" id="vehicle3" name="vehicle3" value="4">
											<label for="vehicle3">Thu 4</label> &nbsp;
											<input type="checkbox" id="vehicle4" name="vehicle4" value="5">
											<label for="vehicle3">Thu 5</label> &nbsp;
											<input type="checkbox" id="vehicle5" name="vehicle5" value="6">
											<label for="vehicle3">Thu 6</label> &nbsp;
											<input type="checkbox" id="vehicle6" name="vehicle6" value="7">
											<label for="vehicle3">Thu 7</label> &nbsp;
											<input type="checkbox" id="vehicle7" name="vehicle3" value="cn">
											<label for="vehicle3">Chu nhat</label>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số lượng học
											viên</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập số lượng học viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian Bắt Đầu</label>
										<div class="col-lg-6">
											<select name="category_product_parent"
												class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">07:00</option>
												<option value="{{ $parent->parent_id }}">09:00</option>
												<option value="{{ $parent->parent_id }}">13:00</option>
												<option value="{{ $parent->parent_id }}">15:00</option>
												<option value="{{ $parent->parent_id }}">17:00</option>
												<option value="{{ $parent->parent_id }}">19:00</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian Kết Thúc</label>
										<div class="col-lg-6">
											<select name="category_product_parent"
												class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">08:30</option>
												<option value="{{ $parent->parent_id }}">10:30</option>
												<option value="{{ $parent->parent_id }}">14:30</option>
												<option value="{{ $parent->parent_id }}">16:30</option>
												<option value="{{ $parent->parent_id }}">19:30</option>
												<option value="{{ $parent->parent_id }}">21:30</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Trạng thái lớp</label>
										<div class="col-lg-6">
											<select name="category_product_parent"
												class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">Đủ học
													viên</option>
												<option value="{{ $parent->parent_id }}">Thiếu học
													viên</option>
												<option value="{{ $parent->parent_id }}">Cơ sở vật
													chất hỏng</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Chi nhánh</label>
										<div class="col-lg-6">
											<select name="category_product_parent"
												class="form-control m-bot15">
												<option value="{{ $parent->parent_id }}">TVT Quận 1</option>
												<option value="{{ $parent->parent_id }}">TVT Quận
													Bình Thạn</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="add_brand_product" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button name="cancel_brand_product" class="btn btn-cancel"
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