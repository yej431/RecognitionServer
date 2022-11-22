<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="userinfo">
<ul class="userinfo-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/userList" class="active">회원정보</a></li>
	<li class="divider">/</li>
	<li><a href="/selectUser/${userinfo.userid}" class="active">사용자 정보</a></li>
</ul>
<div style="margin-top:20px;">
	<span style="font-size:20px; font-weight:semi-bold">사용자 정보</span>
</div>
<div style="margin-top: 10px;">
<table>
	<tr>
		<td style="width:10%">아이디</td>
		<td>${userinfo.userid}</td>
	</tr>
	<tr>
		<td style="width:10%">이메일</td>
		<td>${userinfo.email}</td>
	</tr>
	<tr>
		<td style="width:10%">가입일</td>
		<td>${userinfo.joinDate}</td>
	</tr>
</table>
<div class="abutton">
	<input type="hidden" id="userid" value="${userinfo.userid}"/>
	<button type="button" class="blockUser">차단하기</button>
</div>
</div>
</div>

<!-- content -->		
</section>
<script src="/js/main.js"></script>
<script src="/js/article.js"></script>
</body>
</html>