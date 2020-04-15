<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin Panel</title>
	<%@include file="/common/admin/css-resources.jsp" %>
</head>

<body>
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
									<th>Mã lớp</th>
									<th>Tên lớp</th>
									<th>Gói</th>
									<th>Nhân viên</th>
									<th>Thời gian biểu</th>
									<th>Số lượng</th>
									<th>Bắt đầu</th>
									<th>Kết thúc</th>
									<th>Trạng thái</th>
									<th>Chi nhánh</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>LH0001</td>
									<td>Tập Tăng Cân</td>
									<td>Gói VIP</td>
									<td>Lý Hải</td>
									<td>07:00</td>
									<td>20</td>
									<td>07:00</td>
									<td>08:30</td>
									<td>Đủ học viên</td>
									<td>TVT Quận 1</td>
									<td>
										<a class="btn btn-primary" href="${pageContext.request.contextPath}/cap-nhat-lop-hoc">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
								</tr>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>LH0002</td>
									<td>Tập Tăng Cân</td>
									<td>Gói VIP</td>
									<td>Lý Hải</td>
									<td>07:00</td>
									<td>20</td>
									<td>07:00</td>
									<td>08:30</td>
									<td>Đủ học viên</td>
									<td>TVT Quận 1</td>
									<td>
										<a class="btn btn-primary" href="${pageContext.request.contextPath}/cap-nhat-lop-hoc}">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
								</tr>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>LH0003</td>
									<td>Tập Tăng Cân</td>
									<td>Gói VIP</td>
									<td>Lý Hải</td>
									<td>07:00</td>
									<td>20</td>
									<td>07:00</td>
									<td>08:30</td>
									<td>Đủ học viên</td>
									<td>TVT Quận 1</td>
									<td>
										<a class="btn btn-primary" href="${pageContext.request.contextPath}/cap-nhat-lop-hoc">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
								</tr>
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
									<li><a href=""><i class="fa fa-chevron-left"></i></a></li>
									<li><a href="">1</a></li>
									<li><a href="">2</a></li>
									<li><a href="">3</a></li>
									<li><a href="">4</a></li>
									<li><a href=""><i class="fa fa-chevron-right"></i></a></li>
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

	<%@include file="/common/admin/js-resources.jsp" %>
</body>

</html>