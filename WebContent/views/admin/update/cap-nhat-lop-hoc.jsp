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
							<header class="panel-heading">Cập Nhật Lớp Học</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-lop-hoc">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="classId" value="${lopTap.classId}"
												readonly="readonly" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="className"
												value="${lopTap.className}" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Gói</label>
										<div class="col-lg-6">
											<select name="packageId" class="form-control m-bot15">
												<c:forEach items="${listGoi}" var="goi">
													<option value="${goi.packageId}" <c:if test="${goi.packageId == lopTap.packageId}">selected="selected"</c:if> >${goi.packageName}</option>
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
												value="${lopTap.maxMember}" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian bắt đầu khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess1" name=dateStart
												value="${lopTap.dateStart}">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian kết thúc khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess2" name=dateEnd
												value="${lopTap.dateEnd}">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Trạng thái</label>
										<div class="col-lg-6">
											<select name="status" class="form-control m-bot15">
												<option value="Còn chỗ">Còn chỗ</option>
												<option value="Đã hết chỗ" <c:if test="${lopTap.status == 'Đã hết chỗ' }">selected="selected"</c:if> >Đã hết chỗ</option>
												<option value="Đã kết thúc" <c:if test="${lopTap.status == 'Đã kết thúc' }">selected="selected"</c:if> >Đã kết thúc</option>
												<option value="Đã hủy" <c:if test="${lopTap.status == 'Đã hủy' }">selected="selected"</c:if> >Đã hủy</option>
											</select>
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
											<button name="submit" value="submit" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-plus"></i> Update
											</button>
											<button name="cancel" value="cancel" class="btn btn-cancel"
												type="submit">
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