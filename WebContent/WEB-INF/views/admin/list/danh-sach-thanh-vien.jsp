<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/WEB-INF/common/admin/css-resources.jsp"%>
</head>

<body>
	<section id="container">
		<%@include file="/WEB-INF/common/admin/header.jsp"%>
		<%@include file="/WEB-INF/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="panel panel-default">
					<div class="panel-heading">Danh Sách Thành Viên</div>
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
									<th>Mã thành viên</th>
									<th>Họ tên</th>
									<th>Ngày sinh</th>
									<th>Giới tính</th>
									<th>SĐT</th>
									<th>Chi nhánh</th>
									<th>Tài khoản</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>TV0001</td>
									<td>JohnDoe</td>
									<th>1990-04-10</th>
									<td>Nam</td>
									<td>0252156525</td>
									<td>TVT Quận 1</td>
									<td>JohnDoe</td>
									<td>
										<a class="btn btn-primary" href="update-computer?computerId=${computer.computerId}">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
								</tr>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>TV0002</td>
									<td>Smith</td>
									<th>1990-04-10</th>
									<td>Nữ</td>
									<td>0252156525</td>
									<td>TVT Quận 1</td>
									<td>Smith</td>
									<td>
										<a class="btn btn-primary" href="update-computer?computerId=${computer.computerId}">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>TV0003</td>
									<td>Phạm Hương</td>
									<th>1990-04-10</th>
									<td>Nữ</td>
									<td>0252156525</td>
									<td>TVT Quận 1</td>
									<td>huongpham</td>
									<td>
										<a class="btn btn-primary" href="update-computer?computerId=${computer.computerId}">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="confirm('Are you sure delete this computer?')" href="delete-computer?computerId=${computer.computerId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
									</td>
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

<%@include file="/WEB-INF/common/admin/js-resources.jsp"%>
</body>

</html>