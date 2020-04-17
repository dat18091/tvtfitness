<%@page import="com.tvt.model.bean.Account"%>
<%@page import="com.tvt.model.bean.Branch"%>
<%@ page import="java.util.ArrayList"%>
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
							<header class="panel-heading">Thêm Thành Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="${pageContext.request.contextPath}/them-thanh-vien">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã thành viên</label>
										<div class="col-sm-6">
											<input type="text" name="memberId" value="${member.memberId}"
												placeholder="Nhập mã thành viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Họ tên</label>
										<div class="col-sm-6">
											<input type="text" name="fullName" value="${member.fullName}"
												placeholder="Nhập họ tên đầy đủ..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày sinh</label>
										<div class="col-sm-6">
											<input type="text" name="birthday" value="${member.birthday}"
												placeholder="Nhập ngày tháng năm sinh..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Giới tính</label>
										<div class="col-lg-6">
											<select name="sex" class="form-control m-bot15">
												<option value="Nam">Nam</option>
												<option value="Nu">Nữ</option>
												<option value="Gay">Gay</option>
												<option value="Less">Less</option>
												<option value="Khac">Khác</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số điện thoại</label>
										<div class="col-sm-6">
											<input type="text" name="numberPhone"
												value="${member.numberPhone}"
												placeholder="Nhập ngày tháng năm sinh..."
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
											for="inputSuccess">Tài Khoản</label>
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
											<button name="submit" class="btn btn-save"
												type="submit" value="submit">
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