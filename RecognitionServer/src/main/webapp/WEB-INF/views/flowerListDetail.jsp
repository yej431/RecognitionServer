<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="flower">
<ul class="flower-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/flowerList" class="active">꽃 목록</a></li>
</ul>
<div style="margin-top:20px;">
	<span style="font-size:20px; font-weight:semi-bold">${flowerList.title}</span>
</div>
<div style="width:300px; margin-top:20px;">
	<img src="${flowerList.files}" style="width:100%;"/>
</div>
<div style="margin-top:30px;">
	<div><span style="font-size:12px;">${flowerList.content}</span></div>
</div>
<div class="clearfix" style="margin-top:30px;">
<hr/>
<div class="abutton clearfix">
	<input type="hidden" id="id" value="${flowerList.id}"/>
	<span style="font-size:12px; margin-right:10px;">작성자: ${flowerList.userid}</span>
	<c:if test="${flowerList.userid==principal.user.userid}">
		<a href="/flowerListUpdate/${flowerList.id}" id="btn-update">수정</a>
		<button type="button" id="btn-delete">삭제</button>
	</c:if>	
</div>
</div>
</div>

<!-- content -->		
</section>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="/js/main.js"></script>
<script src="/js/flower.js"></script>
</body>
</html>