<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Thêm Gói Tập</title>
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
							<header class="panel-heading">Thêm Gói</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-goi">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageId"
												placeholder="Nhập mã gói..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageName"
												placeholder="Nhập tên gói..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại gói</label>
				                        <div class="col-lg-6">
				                            <select name="packageType" class="form-control m-bot15">
				                                   <option value="Gói tập vô thời hạn">Gói tập vô thời hạn</option>
				                                   <option value="Gói tập 1 tháng">Gói tập 1 tháng</option>
				                                   <option value="Gói tập bình thường">Gói bình thường</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Chi phí gói</label>
										<div class="col-sm-6">
											<input type="text" name="price"
												placeholder="Nhập phí của gói..." class="form-control">
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

	<%@include file="/common/admin/js-resources.jsp" %>
</body>

</html>