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
							<header class="panel-heading">Cập Nhật Thiết Bị</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-thiet-bi">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã Thiết Bị</label>
										<div class="col-sm-6">
											<input type="text" name="equipmentId" value="${equipment.getEquipmentId() }"
												placeholder="Nhập mã thiết bị..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên thiết bị</label>
										<div class="col-sm-6">
											<input type="text" name="equipmentName" value="${equipment.getEquipmentName() }"
												placeholder="Nhập tên thiết bị..." class="form-control" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-6">
											<input type="text" name="cost" value="${equipment.getCost () }"
												placeholder="Nhập tên thiết bị..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="branchName">Chi nhánh</label>
				                        <div class="col-lg-6">
				                            <select name="branchName" id="branchName" class="form-control m-bot15" required>
				                            	<c:forEach var="element" items="${list }">
				                            	<option value="${element }">${element }</option>
				                            	</c:forEach>
				                                   
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại thiết bị</label>
				                        <div class="col-lg-6">
				                            <input type="text" name="equipmentType" value="${equipment.getEquipmentType() }"
												placeholder="Loại thiết bị..." class="form-control" required>
				                        </div>
				                    </div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày nhập</label>
										<div class="col-sm-6">
											<input type="date" name="importDate" value="${equipment.getImportDate() }"
												placeholder="Nhập ngày nhập thiết bị..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Thời hạn bảo hành</label>
										<div class="col-sm-6">
											<input type="date" name="warrantyDate"  value="${equipment.getWarrantyDate() }"
												placeholder="Nhập thời gian bảo hành thiết bị..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group ">
										<label for="ccomment"
											class="control-label col-lg-3">Trạng thái</label>
										<div class="col-lg-6">
											<textarea class="form-control"
												name="status" style="resize: none;"
												rows="5" id="ccomment">${equipment.getStatus()}</textarea>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="add_brand_product" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-edit"></i> Update
											</button>
											<button name="cancel_brand_product" class="btn btn-cancel"
												type="button" onclick="history.go(-1);">
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
	<script type="text/javascript">
	$("#branchName").val("${branchName}").attr("selected", true);
	</script>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>

</html>