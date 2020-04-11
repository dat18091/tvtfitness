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
							<header class="panel-heading">Cập Nhật Giao Dịch</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="{{URL::to('/save-brand-product')}}">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã giao dịch</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập mã giao dịch..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên giao dịch</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập tên giao dịch..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Nhân viên</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">Nguyễn Thị Mè</option>
				                                   <option value="{{ $parent->parent_id }}">Lê Văn Nam</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Thành viên</label>
										<div class="col-sm-6">
											<select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">Hồ Hiền</option>
				                                   <option value="{{ $parent->parent_id }}">Hà Anh</option>
				                            </select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Đơn vị</label>
										<div class="col-sm-6">
											<select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">VND</option>
				                                   <option value="{{ $parent->parent_id }}">USD</option>
				                                   <option value="{{ $parent->parent_id }}">EURO</option>
				                            </select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập giá giao dịch..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tổng tiền</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập tổng tiền..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="add_brand_product" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-plus"></i> Update
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