<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/WEB-INF/common/admin/css-resources.jsp" %>
</head>

<body>
	<section id="container">
		<%@include file="/WEB-INF/common/admin/header.jsp"%>
		<%@include file="/WEB-INF/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading">Thêm Thành Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="{{URL::to('/save-brand-product')}}">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã thành viên</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập mã thành viên..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Họ tên</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập họ tên đầy đủ..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày sinh</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập ngày tháng năm sinh..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Giới tính</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">Nam</option>
				                                   <option value="{{ $parent->parent_id }}">Nữ</option>
				                                   <option value="{{ $parent->parent_id }}">Gay</option>
				                                   <option value="{{ $parent->parent_id }}">Less</option>
				                                   <option value="{{ $parent->parent_id }}">Khác</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Số điện thoại</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập ngày tháng năm sinh..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Chi nhánh</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">TVT Quận 1</option>
				                                   <option value="{{ $parent->parent_id }}">TVT Quận Bình Thạnh</option>
				                                   
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Tài Khoản</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">JohnDoe</option>
				                                   <option value="{{ $parent->parent_id }}">Smith</option>
				                                   
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

	<%@include file="/WEB-INF/common/admin/js-resources.jsp" %>
</body>

</html>