<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="article">
<ul class="article-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/articleList" class="active">꽃 목록</a></li>
</ul>
<div style="margin-top:20px;">
	<span style="font-size:20px; font-weight:semi-bold">${articleList.title}</span>
</div>
<div style="margin-top:30px;">
	<div><span style="font-size:14px;">${articleList.content}</span></div>
</div>
<div class="clearfix" style="margin-top:30px;">
<hr/>
<div class="abutton clearfix">
	<input type="hidden" id="id" value="${articleList.id}"/>
	<span style="font-size:13px;">작성자: ${articleList.userid}</span>&nbsp;/
	<span style="font-size:13px; margin-right:10px;">
		작성일: <fmt:formatDate value="${articleList.writeDate}" pattern="yyyy-MM-dd"/>
	</span>
	<c:if test="${articleList.id==principal.user.id}">
		<a href="/articleListUpdate/${articleList.id}" id="btn-update">수정</a>
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