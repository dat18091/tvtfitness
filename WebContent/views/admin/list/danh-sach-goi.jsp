<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Danh Sách Gói</title>
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
					<div class="panel-heading">Danh Sách Gói</div>
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
									<th>Mã gói</th>
									<th>Tên gói</th>
									<th>Loại gói</th>
									<th>Phí gói</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${packageList}" var="packagelist">
								<tr>
									<td><label class="i-checks m-b-none"><input
											type="checkbox" name="post[]"><i></i></label></td>
									<td>${packagelist.packageId}</td>
									<td>${packagelist.packageName}</td>
									<td>${packagelist.packageType}</td>
									<td>${packagelist.price}</td>
									<td>
										<a class="btn btn-primary" href="cap-nhat-goi?packageId=${packagelist.packageId}">
										<i class="fa fa-edit"></i> Update</a> &nbsp; 
										<a class="btn btn-danger" onclick="return confirm('Are you sure delete this package?')" href="xoa-goi?packageId=${packagelist.packageId}">
										<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
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