<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<header class="panel-heading">Thêm Lớp Tập</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-lop-hoc">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="classId" placeholder="Nhap lop tap theo dinh dang TCxxxx..."
												class="form-control">
											<p style="color: red">${error}</p>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="className" placeholder="Tên lớp tập"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Gói</label>
										<div class="col-lg-6">
											<select name="packageId" class="form-control m-bot15">
												<c:forEach items="${listGoi}" var="goi">
													<option value="${goi.packageId}">${goi.packageName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Mã Nhân viên</label>
										<div class="col-lg-6">
											<select name="empId" class="form-control m-bot15">
												<c:forEach items="${listEmp}" var="emp">
													<option value="${emp.empId}">${emp.empName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian Biểu</label>
										<div class="col-lg-6">
											<select name="schedule" class="form-control m-bot15">
												<option value="07:00">07:00</option>
												<option value="09:00">09:00</option>
												<option value="15:00">15:00</option>
												<option value="17:00">17:00</option>
												<option value="19:00">19:00</option>
											</select><br> <input type="checkbox" id="vehicle1"
												name="schedule" value="2"> <label for="vehicle1">Thứ
												2</label> <input type="checkbox" id="vehicle2" name="schedule"
												value="3"> <label for="vehicle2">Thứ 3</label> <input
												type="checkbox" id="vehicle3" name="schedule" value="4">
											<label for="vehicle3">Thứ 4</label> <input type="checkbox"
												id="vehicle4" name="schedule" value="5"> <label
												for="vehicle4">Thứ 5</label> <input type="checkbox"
												id="vehicle5" name="schedule" value="6"> <label
												for="vehicle5">Thứ 6</label> <input type="checkbox"
												id="vehicle6" name="schedule" value="7"> <label
												for="vehicle6">Thứ 7</label> <input type="checkbox"
												id="vehicle7" name="schedule" value="cn"> <label
												for="vehicle7">Chủ nhật</label>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số lượng học
											viên</label>
										<div class="col-sm-6">
											<input type="number" name="maxMember" min=3
												placeholder="Số lượng học viên của lớp tập"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian bắt đầu khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess1" name=dateStart>
											<p style="color: red">${errorDate}</p>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian kết thúc khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess2" name=dateEnd>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Chi nhánh</label>
										<div class="col-lg-6">
											<select name="branchId" class="form-control m-bot15">
												<c:forEach items="${listBranch}" var="branch">
													<option value="${branch.branchId}">${branch.branchName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button class="btn btn-save" type="submit" value="submit"
												name="submit">
												<i class="glyphicon glyphicon-plus"></i> Add
											</button>
											<button name="cancel" class="btn btn-cancel" type="button">
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
		</section>
		<!--main content end-->
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>

</html>