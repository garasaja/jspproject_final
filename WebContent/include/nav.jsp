<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Cos Blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Colo Shop Template">

<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/blog/css/styles.css" rel="stylesheet">
</head>
<body>

	

<div class="super_container">

	<!-- Header -->

	<header class="header trans_300">

		<!-- Top Navigation -->

		<div class="top_nav">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="top_nav_left">중고나라 사이트입니다.</div>
					</div>
					<div class="col-md-6 text-right">
						<div class="top_nav_right">
							<ul class="top_nav_menu">

								<!--  My Account -->							
								<li class="currency">
									<a href="#">
										product
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="currency_selection">
										<li><a href="/blog/shop.jsp">productlist</a></li>
										<li><a href="/blog/product?cmd=register">productwrite</a></li>
										<li><a href="/blog/product?cmd=update">productupdate</a></li>
										
									</ul>
								</li>
								<li class="language">
									<a href="#">
										BOARD
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="language_selection">
										<li><a href="/blog/board?cmd=home&page=0">boardlist</a></li>
										<li><a href="/blog/board?cmd=write">boardwrite</a></li>
										<li><a href="/blog/board?cmd=update">boardupdate</a></li>
										
									</ul>
								</li>
								<li class="account">
									<a href="#">
										My Account
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="account_selection">
									<c:choose>
										<c:when test="${empty sessionScope.principal}">
										<li><a href="user?cmd=login"><i class="fa fa-sign-in" aria-hidden="true"></i>Log In</a></li>
										<li><a href="user?cmd=join"><i class="fa fa-user-plus" aria-hidden="true"></i>Join</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="user?cmd=logout"><i class="fa fa-sign-in" aria-hidden="true"></i>Log Out</a></li>
										<li><a href="user?cmd=update"><i class="fa fa-user-plus" aria-hidden="true"></i>Member</a></li>
										</c:otherwise>
									</c:choose>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Navigation -->

		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="/blog/index.jsp">중고<span>나라</span></a>
						</div>
						<div class="container">

	
	</div>
						<nav class="navbar">
							<ul class="navbar_menu">
								<form class="form-inline justify-center" action="/action_page.php">
  								  <input class="form-control mr-sm-2" type="text" placeholder="상품을 검색해주세요">
  								  <button class="btn btn-success" type="submit">Search</button>
 								 </form>
								
							</ul>
							<ul class="navbar_user">
								<li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
								<li class="checkout">
									<a href="#">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i>
										<span id="checkout_items" class="checkout_items">5</span>
									</a>
								</li>
							</ul>
							<div class="hamburger_container">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</header>
	</div>
	<br>