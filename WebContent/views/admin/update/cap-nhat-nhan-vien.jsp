<%@page import="com.tvt.model.bean.Account"%>
<%@page import="com.tvt.model.bean.Branch"%>
<%@page import="java.util.ArrayList"%>
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
							<header class="panel-heading">Cập Nhật Nhân Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="${pageContext.request.contextPath}/cap-nhat-nhan-vien">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empId" value="${employee.empId}"
												placeholder="Nhập mã nhân viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empName" value="${employee.empName}"
												placeholder="Nhập họ tên nhân viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số điện thoại</label>
										<div class="col-sm-6">
											<input type="text" name="numberPhone"
												value="${employee.numberPhone}"
												placeholder="Nhập số điện thoại của nhân viên..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày sinh</label>
										<div class="col-sm-6">
											<input type="text" name="birthday"
												value="${employee.birthday}"
												placeholder="Nhập ngày tháng năm sinh của nhân viên..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Product Image -->
										<label class="col-sm-3 control-label">Hình ảnh</label>
										<div class="col-sm-6">
											<input type="file" name="imgUrl" value="${employee.img}"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Chi nhánh</label>
										<div class="col-lg-6">
											<select name="branch" class="form-control m-bot15">
												<%
													ArrayList<Branch> listBranch = (ArrayList<Branch>) request.getAttribute("listBranch");
													for (Branch branch : listBranch) {
												%>
												<option value="<%=branch.getBranchId()%>"><%=branch.getBranchName()%></option>
												<%
													}
												%>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Tài khoản</label>
										<div class="col-lg-6">
											<select name="account" class="form-control m-bot15">
												<%
													ArrayList<Account> listAccount = (ArrayList<Account>) request.getAttribute("listAccount");
													for (Account account : listAccount) {
												%>
												<option value="<%=account.getAccountId()%>"><%=account.getAccountName()%></option>
												<%
													}
												%>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" value="submit" class="btn btn-save" type="submit">
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

	<%@include file="/common/admin/js-resources.jsp"%>
</body>

</html>