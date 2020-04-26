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
	<form action="${pageContext.request.contextPath}/danh-sach-lop-hoc" method="get">
	<section id="container">
		<%@include file="/common/admin/header.jsp"%>
		<%@include file="/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="panel panel-default">
					<div class="panel-heading">Danh Sách Lớp Học</div>
					<div class="row w3-res-tb">
						<div class="col-sm-5 m-b-xs">
							<select class="input-sm form-control w-sm inline v-middle" name="sort">
								<option>Choose</option>
								<option value="ASC">Tăng Dần Theo Mã</option>
								<option value="DESC">Giảm Dần Theo Mã</option>
							</select>
							<button class="btn btn-sm btn-default">Apply</button>
						</div>
						<div class="col-sm-4"></div>
						<div class="col-sm-3">
							<div class="input-group">
								<input type="text" class="input-sm form-control"
									placeholder="Search" name="search"> <span class="input-group-btn">
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
									<th>Mã lớp tập</th>
									<th>Tên lớp tập</th>
									<th>Gói tập</th>
									<th>Nhân viên</th>
									<th>Thời gian biểu</th>
									<th>Số học viên tối đa</th>
									<th>Ngày bắt đầu</th>
									<th>Ngày kết thúc</th>
									<th>Trạng thái</th>
									<th>Chi nhánh</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTrainingClass}" var="lop">
									<tr>
										<td><label class="i-checks m-b-none"><input
												type="checkbox" name="post[]"><i></i></label></td>
										<td>${lop.classId}</td>
										<td>${lop.className}</td>
										<td>${lop.packageId}</td>
										<td>${lop.empId}</td>
										<td>${lop.schedule}</td>
										<td>${lop.maxMember}</td>
										<td>${lop.dateStart}</td>
										<td>${lop.dateEnd}</td>
										<td>${lop.status}</td>
										<td>${lop.branchId}</td>
										<td>
											<a class="btn btn-primary"
												href="cap-nhat-lop-hoc?classId=${lop.classId}">
												<i class="fa fa-edit"></i> Update
											</a> &nbsp; <a class="btn btn-danger"
												onclick="return confirm('Are you sure delete this service?');"
												href="xoa-lop-hoc?classId=${lop.classId}"">
												<i class="fa fa-trash" aria-hidden="true"></i> Delete
											</a>
										</td>
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
											href="danh-sach-lop-hoc?currentPage=${currentPage-1}">Previous</a></li>
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
													href="danh-sach-lop-hoc?currentPage=${i}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${currentPage lt noOfPages}">
										<li class="page-item"><a class="page-link"
											href="danh-sach-lop-hoc?currentPage=${currentPage+1}">Next</a></li>
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

</html>