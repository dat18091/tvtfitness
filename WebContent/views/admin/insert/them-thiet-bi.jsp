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
							<header class="panel-heading">Thêm Thiết Bị</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-thiet-bi" enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-sm-12" id="notification" style="text-align: center;"></label>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã Thiết Bị</label>
										<div class="col-sm-6">
											<input type="text" id="equipmentId" name="equipmentId" required="required"
												placeholder="Nhập mã thiết bị..." class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên thiết bị</label>
										<div class="col-sm-6">
											<input type="text" name="equipmentName"
												placeholder="Nhập tên thiết bị..." class="form-control" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-6">
											<input type="text" name="cost" id="cost"
												placeholder="Giá..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Chi nhánh</label>
				                        <div class="col-lg-6">
				                            <select name="branchName" class="form-control m-bot15" required>
				                            	<c:forEach items="${list }" var="element" >
				                            	<option value="${element }">${element }</option>
				                            	</c:forEach>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại thiết bị</label>
				                        <div class="col-sm-6">
				                        <input type="text" name="equipmentType"
												placeholder="Loại thiết bị..." class="form-control" required>
												</div>
				                    </div>
				                    <div class="form-group">
										<label class="col-sm-3 control-label">Hình ảnh</label>
										<div class="col-sm-6">
											<input type="file" name="imageUrl"
												placeholder="Nhập ngày nhập thiết bị..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày nhập</label>
										<div class="col-sm-6">
											<input type="date" name="importDate"
												placeholder="Nhập ngày nhập thiết bị..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Thời hạn bảo hành</label>
										<div class="col-sm-6">
											<input type="date" name="warrantyDate"
												placeholder="Nhập thời gian bảo hành thiết bị..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group ">
										<label class="control-label col-lg-3">Trạng thái</label>
										<div class="col-lg-6">
											<textarea class="form-control"
												name="status" style="resize: none;"
												rows="5" id="ccomment" required></textarea>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="add_brand_product" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-plus"></i> Save
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

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	if(${error != null}){
		$("#notification").text("${error}");
        $("#notification").css("color", "red");
	}
	$("#equipmentId").on("change", function () {
	   var equipmentId = $("#equipmentId").val();
	   var patt = new RegExp("^TB[0-9]{4}$");
	   if (!(patt.test(equipmentId))) {
	       $("#notification").text("Mã TB: Có format là TBxxxx (x: ký tự số)");
	       $("#notification").css("color", "red");
	       $(this).val("");
	       $(this).focus();
	    } else {
	       $("#notification").text("")
	      }
		});
	$("#cost").on("change", function () {
        var cost = $("#cost").val();
        if(!(parseFloat(cost)>0)){
            $("#notification").text("Giá phải là 1 số lớn hơn 0");
            $("#notification").css("color", "red");
            $(this).val("");
            $(this).focus();
        } else {
            $("#notification").text("")
        }
    });
</script>
</body>

</html>