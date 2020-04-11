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
							<header class="panel-heading">Thêm Dịch Vụ</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="{{URL::to('/save-brand-product')}}">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập mã dịch vụ..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập tên dịch vụ..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại dịch vụ</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">Tập với HLV Nữ</option>
				                                   <option value="{{ $parent->parent_id }}">Tập với HLV Nam</option>
				                                   <option value="{{ $parent->parent_id }}">Chế độ luyện tập chuyên nghiệp</option>
				                                   <option value="{{ $parent->parent_id }}">Mua thiết bị</option>
				                                   <option value="{{ $parent->parent_id }}">Ăn uống</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Phí dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập phí dịch vụ..." class="form-control">
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