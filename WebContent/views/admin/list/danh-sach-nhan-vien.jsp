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
	<form action="${pageContext.request.contextPath}/danh-sach-thanh-vien"
		method="post">
		<section id="container">
			<%@include file="/common/admin/header.jsp"%>
			<%@include file="/common/admin/sidebar.jsp"%>
			<!--main content start-->
			<section id="main-content">
				<section class="wrapper">

					<div class="panel panel-default">
						<div class="panel-heading">Danh Sách Nhân Viên</div>
						<div class="row w3-res-tb">
							<div class="col-sm-5 m-b-xs">
								<select name="sortBy"
									class="input-sm form-control w-sm inline v-middle">
									<option value="desc">Giam Dan</option>
									<option value="asc">Tang Dan</option>
								</select>
								<button class="btn btn-sm btn-default">Apply</button>
							</div>
							<div class="col-sm-4"></div>
							<div class="col-sm-3">
								<div class="input-group">
									<input type="text" class="input-sm form-control" name="search"
										placeholder="Search"> <span class="input-group-btn">
										<button class="btn btn-sm btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th style="width: 20px;"><label class="i-checks m-b-none">
												<input type="checkbox"><i></i>
										</label></th>
										<th>Mã nhân viên</th>
										<th>Tên nhân viên</th>
										<th>SĐT</th>
										<th>Ngày sinh</th>
										<th>Hình ảnh</th>
										<th>Chi nhánh</th>
										<th>Tài khoản</th>
										<th style="width: 250px;">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listEmployee}" var="employee">
										<tr>
											<td><label class="i-checks m-b-none"><input
													type="checkbox" name="post[]"><i></i></label></td>
											<td>${employee.empId}</td>
											<td>${employee.empName}</td>
											<td>${employee.numberPhone}</td>
											<td>${employee.birthday}</td>
											<td><img alt="" width="50px" height="50px"
												src="<c:url value="/resources/uploads/${employee.img}" />"></td>
											<td>${employee.branchId}</td>
											<td>${employee.accountId}</td>
											<td><a class="btn btn-primary"
												href="cap-nhat-nhan-vien?empId=${employee.empId}"> <i
													class="fa fa-edit"></i> Update
											</a> &nbsp; <a class="btn btn-danger btn_delete"
												href="xoa-nhan-vien?empId=${employee.empId}"> <i
													class="fa fa-trash" aria-hidden="true"></i> Delete
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<footer class="panel-footer">
							<div class="row">

								<div class="col-sm-5 text-center">
									<small class="text-muted inline m-t-sm m-b-sm">showing
										20-30 of 50 items</small>
								</div>
								<div class="col-sm-7 text-right text-center-xs">
									<ul class="pagination pagination-sm m-t-none m-b-none">
										<c:if test="${page != 1}">
											<li class="page-item"><a class="page-link"
												href="danh-sach-nhan-vien?page=${page-1}">Previous</a></li>
										</c:if>

										<c:forEach begin="1" end="${limited}" var="i">
											<c:choose>
												<c:when test="${page eq i}">
													<li class="page-item active"><a class="page-link">
															${i} <span class="sr-only">(current)</span>
													</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="danh-sach-nhan-vien?page=${i}">${i}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>

										<c:if test="${page lt limited}">
											<li class="page-item"><a class="page-link"
												href="danh-sach-nhan-vien?page=${page+1}">Next</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</footer>
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
	</form>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>
<script>
	$(".btn_delete").on('click', function(event) {
		if (confirm("Are you sure you want to delete?")) {
			return true;
		} else {
			event.preventDefault();
			return false;
		}
	});
</script>
</html>