<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Section Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="canvas-close">
            <i class="fa fa-close"></i>
        </div>
        <div class="canvas-search search-switch">
            <i class="fa fa-search"></i>
        </div>
        <nav class="canvas-menu mobile-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/home-page">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/product">Product</a></li>
                <li><a href="${pageContext.request.contextPath}/about-us">About Us</a></li>
                <li><a href="${pageContext.request.contextPath}/class-details">Classes</a></li>
                <li><a href="${pageContext.request.contextPath}/services">Services</a></li>
                <li><a href="${pageContext.request.contextPath}/our-team">Our Team</a></li>
                <li><a href="#">Pages</a>
                    <ul class="dropdown">
                        <li><a href="${pageContext.request.contextPath}/about-us">About us</a></li>
                        <li><a href="${pageContext.request.contextPath}/classes-timetable">Classes timetable</a></li>
                        <li><a href="${pageContext.request.contextPath}/bmi-calculate">Bmi calculate</a></li>
                        <li><a href="${pageContext.request.contextPath}/our-team">Our team</a></li>
                        <li><a href="${pageContext.request.contextPath}/gallery">Gallery</a></li>
                        <li><a href="${pageContext.request.contextPath}/our-blog">Our blog</a></li>
                        <li><a href="${pageContext.request.contextPath}/404">404</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="canvas-social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-youtube-play"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>
        </div>
    </div>
    <!-- Offcanvas Menu Section End -->

    <!-- Header Section Begin -->
    <header class="header-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3">
                    <div class="logo">
                        <a href="./index.html">
                            <img src="<c:url value="/resources/web/img/logo.png" />" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="nav-menu">
                        <ul>
			                <li><a href="${pageContext.request.contextPath}/home-page">Home</a></li>
			                <li><a href="${pageContext.request.contextPath}/product">Product</a></li>
			                <li><a href="${pageContext.request.contextPath}/about-us">About Us</a></li>
			                <li><a href="${pageContext.request.contextPath}/class-details">Classes</a></li>
			                <li><a href="${pageContext.request.contextPath}/services">Services</a></li>
			                <li><a href="${pageContext.request.contextPath}/our-team">Our Team</a></li>
			                <li><a href="#">Pages</a>
			                    <ul class="dropdown">
			                        <li><a href="${pageContext.request.contextPath}/about-us">About us</a></li>
			                        <li><a href="${pageContext.request.contextPath}/classes-timetable">Classes timetable</a></li>
			                        <li><a href="${pageContext.request.contextPath}/bmi-calculate">Bmi calculate</a></li>
			                        <li><a href="${pageContext.request.contextPath}/our-team">Our team</a></li>
			                        <li><a href="${pageContext.request.contextPath}/gallery">Gallery</a></li>
			                        <li><a href="${pageContext.request.contextPath}/our-blog">Our blog</a></li>
			                        <li><a href="${pageContext.request.contextPath}/404">404</a></li>
			                    </ul>
			                </li>
			            </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="top-option">
                        <div class="to-search search-switch">
                            <i class="fa fa-search"></i>
                        </div>
                        <div class="to-social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-youtube-play"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="canvas-open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header End -->
