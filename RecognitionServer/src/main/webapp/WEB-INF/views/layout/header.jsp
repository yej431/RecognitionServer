<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<link rel="stylesheet" href="/css/main.css">
	<link rel="stylesheet" href="/css/flower.css">
	<link rel="stylesheet" href="/css/chart.css">
	<link rel="stylesheet" href="/css/article.css">
	<link rel="stylesheet" href="/css/user.css">
	<title>FlowerRecognition</title>
</head>
<body>
	<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="/flowerList" class="brand" style="font-size:25px; padding-top:10px;]">&nbsp;&nbsp;&nbsp;AdminPage</a>
		<ul class="side-menu">
			<li class="divider" data-text="App">App</li>
			<li>
				<a href="/flowerList"><i class='bx bxs-inbox icon' ></i> 앱 <i class='bx bx-chevron-right icon-right' ></i></a>
				<ul class="side-dropdown">
					<li><a href="/flowerList">꽃 목록</a></li>
					<li><a href="/articleList">게시판</a></li>
				</ul>
			</li>
			<li><a href="/chart"><i class='bx bxs-chart icon' ></i> 차트</a></li>
			<li class="divider" data-text="User">User</li>
			<li>
				<a href="#"><i class='bx bxs-notepad icon' ></i> 회원관리 <i class='bx bx-chevron-right icon-right' ></i></a>
				<ul class="side-dropdown">
					<li><a href="/userList">회원정보</a></li>
					<li><a href="/blockUserList">차단사용자</a></li>
				</ul>
			</li>
		</ul>
		<%-- <div class="ads">
			<div class="wrapper">
				<a href="#" class="btn-upgrade">Upgrade</a>
				<p>Become a <span>PRO</span> member and enjoy <span>All Features</span></p>
			</div>
		</div> --%>
	</section>
	<!-- SIDEBAR -->