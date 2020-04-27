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
							<header class="panel-heading">Thêm Tài Khoản</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-tai-khoan">
									<div class="form-group">
										<label class="col-sm-12" id= "notification" style="text-align: center;"></label>
									</div>								
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên tài khoản</label>
										<div class="col-sm-6">
											<input type="text" name="accountName"
												placeholder="Nhập tên tài khoản..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Mật khẩu</label>
										<div class="col-sm-6">
											<input type="text" name="password"
												placeholder="Nhập mật khẩu..." class="form-control" required>
										</div>
									</div>

									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Phân quyền</label>
				                        <div class="col-lg-6">
				                            <select name="accountType" class="form-control m-bot15" required>
				                                   <option value="Administrator" >Administrator</option>
				                                   <option value="User">User</option>		                                   				                          
				                            </select>
				                        </div>
				                    </div>
									
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="action" class="btn btn-save"
												type="submit" value="Submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button onclick="history.go(-1)"
												type="submit" class="btn btn-cancel">
												<i class="glyphicon glyphicon-remove" ></i>Cancel 
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
		$("#notification").css("color","red");
	}
	</script>
</body>

</html>