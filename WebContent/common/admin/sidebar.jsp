<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--sidebar start-->
<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				<li>
					<!-- Dashboard --> <a class="active"
					href="${pageContext.request.contextPath}/admin-home"> <i
						class="glyphicon glyphicon-dashboard"></i> <span>Dashboard</span>
				</a>
				</li>
				<li class="sub-menu">
					<!-- Parent --> <a href="javascript:;"> <i
						class="fa fa-map-marker"></i><span>Chi Nhánh</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-chi-nhanh"><i
								class="fa fa-circle-o"></i>Thêm Chi Nhánh</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-chi-nhanh"><i
								class="fa fa-circle-o"></i>Danh Sách Chi Nhánh</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Category --> <a href="javascript:;"> 
					<i class="fa fa-user"></i> <span>Tài Khoản</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-tai-khoan"><i
								class="fa fa-circle-o"></i>Thêm Tài Khoản</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-tai-khoan"><i
								class="fa fa-circle-o"></i>Danh Dách Tài Khoản</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Brand --> <a href="javascript:;"> <i
						class="fa fa-gear fa-spin"></i> <span>Thiết Bị</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-thiet-bi"><i
								class="fa fa-circle-o"></i>Thêm Thiết Bị</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-thiet-bi"><i
								class="fa fa-circle-o"></i>Danh Sách Thiết Bị</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-users"></i> <span>Thành Viên</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-thanh-vien"><i
								class="fa fa-circle-o"></i>Thêm Thành Viên</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-thanh-vien"><i
								class="fa fa-circle-o"></i>Danh Sách Thành Viên</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Slider --> <a href="javascript:;"> <i
						class="fa fa-home"></i> <span>Lớp Học</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-lop-hoc"><i class="fa fa-circle-o"></i>
								Thêm Lớp Học</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-lop-hoc"><i class="fa fa-circle-o"></i>
								Danh Sách Lớp Học</a></li>
					</ul>
				</li>

				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-user"></i> <span>Nhân Viên</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-nhan-vien"><i
								class="fa fa-circle-o"></i>Thêm Nhân Viên</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-nhan-vien"><i
								class="fa fa-circle-o"></i>Danh Sách Nhân Viên</a></li>
					</ul>
				</li>

				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-coffee"></i> <span>Dịch Vụ</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-dich-vu"><i
								class="fa fa-circle-o"></i>Thêm Dịch Vụ</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-dich-vu"><i
								class="fa fa-circle-o"></i>Danh Sách Dịch Vụ</a></li>
					</ul>
				</li>
				
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-gift"></i> <span>Gói</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-goi"><i
								class="fa fa-circle-o"></i>Thêm Gói</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-goi"><i
								class="fa fa-circle-o"></i>Danh Sách Gói</a></li>
					</ul>
				</li>
				
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-user-plus"></i> <span>Đăng Ký</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/dang-ky-lop-hoc"><i
								class="fa fa-circle-o"></i>Đăng Ký Lớp Học</a></li>
						<li><a href="${pageContext.request.contextPath}/dang-ky-dich-vu"><i
								class="fa fa-circle-o"></i>Đăng Ký Dịch Vụ</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-dang-ky-lop"><i
								class="fa fa-circle-o"></i>Danh Sách Đăng Ký Lớp</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-dang-ky-dich-vu"><i
								class="fa fa-circle-o"></i>Danh Sach Dang Ky Dịch Vụ</a></li>		
						<li><a href="${pageContext.request.contextPath}/danh-sach-dang-ky"><i
								class="fa fa-circle-o"></i>Danh Sách Đăng Ký</a></li>
					</ul>
				</li>
				
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;"> <i
						class="fa fa-exchange"></i> <span>Giao Dịch</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-giao-dich"><i
								class="fa fa-circle-o"></i>Thêm Giao Dịch</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-giao-dich"><i
								class="fa fa-circle-o"></i>Danh Sách Giao Dịch</a></li>
						<li><a href="${pageContext.request.contextPath}/lich-su-giao-dich"><i
								class="fa fa-circle-o"></i>Lịch Sử Giao Dịch</a></li>
					</ul>
				</li>
				
				<li>
					<!-- Login --> <a href="${pageContext.request.contextPath}/admin-login"> <i
						class="fa fa-sign-in"></i> <span>Login Page</span>
				</a>
				</li>
				<li>
					<!-- Help --> <a href="${pageContext.request.contextPath}/help"> <i
						class="fa fa-question-circle"></i> <span>Help</span>
				</a>
				</li>
			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
</aside>
<!--sidebar end-->