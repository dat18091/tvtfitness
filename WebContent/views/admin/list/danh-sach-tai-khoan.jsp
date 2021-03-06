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

				<div class="panel panel-default">
					<div class="panel-heading">Danh Sách Tài Khoản</div>
					<div class="row w3-res-tb">
						<div class="col-sm-5 m-b-xs">
							<select class="input-sm form-control w-sm inline v-middle">
								<option value="0">Bulk action</option>
								<option value="1">Delete selected</option>
								<option value="2">Bulk edit</option>
								<option value="3">Export</option>
							</select>
							<button class="btn btn-sm btn-default">Apply</button>
						</div>
						<div class="col-sm-4"></div>
						<div class="col-sm-3">
							<div class="input-group">
								<input type="text" class="input-sm form-control"
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
									<th>Mã tài khoản</th>
									<th>Tên tài khoản</th>
									<th>Mật khẩu</th>
									<th>Phân quyền</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="element">
									<tr>
										<td><label class="i-checks m-b-none"><input
												type="checkbox" name="post[]"><i></i></label></td>
										<td scope="row">${element.getAccountId()}</td>
										<td scope="row">${element.getAccountName()}</td>
										<td scope="row">${element.getPassword()}</td>
										<td scope="row">${element.getAccountType()}</td>
										<td><a class="btn btn-primary"
											href="cap-nhat-tai-khoan?id=${element.getAccountId()}">
												<i class="fa fa-edit"></i> Update
										</a> &nbsp; <a class="btn btn-danger"
											onclick="return confirm('Are you sure delete this computer?')"
											href="xoa-tai-khoan?id=${element.getAccountId()}">
												<i class="fa fa-trash" aria-hidden="true"></i> Delete
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
									${start+1 } - ${end } of ${rows } items</small>
							</div>
							<div class="col-sm-7 text-right text-center-xs">
								<ul class="pagination pagination-sm m-t-none m-b-none">
									<c:if test="${currentPage != 1}">
										<li class="page-item"><a class="page-link"
											href="danh-sach-tai-khoan?currentPage=${currentPage-1}">Previous</a></li>
									</c:if>

									<c:forEach begin="1" end="${noOfPages}" var="i">
										<c:choose>
											<c:when test="${currentPage eq i}">
												<li class="page-item active"><a class="page-link">
														${i} <span class="sr-only">(current)</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="danh-sach-tai-khoan?currentPage=${i}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${currentPage lt noOfPages}">
										<li class="page-item"><a class="page-link"
											href="danh-sach-tai-khoan?currentPage=${currentPage+1}">Next</a></li>
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

	<%@include file="/common/admin/js-resources.jsp"%>
</body>

</html>