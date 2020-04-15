<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/WEB-INF/common/admin/css-resources.jsp"%>
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
							<header class="panel-heading">Thêm Thiết Bị</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="{{URL::to('/save-brand-product')}}">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã Thiết Bị</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập mã thiết bị..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên thiết bị</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập tên thiết bị..." class="form-control">
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
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại thiết bị</label>
				                        <div class="col-lg-6">
				                            <select name="category_product_parent" class="form-control m-bot15">
				                                   <option value="{{ $parent->parent_id }}">Thiết bị gym</option>
				                                   <option value="{{ $parent->parent_id }}">Ghế tập gym</option>
				                                   <option value="{{ $parent->parent_id }}">Giàn tạ đa năng</option>
				                                   <option value="{{ $parent->parent_id }}">Thiết bị công viên</option>
				                                   <option value="{{ $parent->parent_id }}">Phụ kiện</option>
				                            </select>
				                        </div>
				                    </div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày nhập</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập ngày nhập thiết bị..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Thời hạn bảo hành</label>
										<div class="col-sm-6">
											<input type="text" name="brand_product_name"
												placeholder="Nhập thời gian bảo hành thiết bị..." class="form-control">
										</div>
									</div>
									
									<div class="form-group ">
										<label for="ccomment"
											class="control-label col-lg-3">Trạng thái</label>
										<div class="col-lg-6">
											<textarea class="form-control"
												name="brand_product_description" style="resize: none;"
												rows="5" id="ccomment"></textarea>
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

	<%@include file="/WEB-INF/common/admin/js-resources.jsp"%>
</body>

</html>