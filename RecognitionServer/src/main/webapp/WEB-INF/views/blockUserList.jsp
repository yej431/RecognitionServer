<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="article">
<ul class="article-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/articleList" class="active">차단사용자</a></li>
</ul>
<div class="article-list-total">차단회원수: ${total}</div>
<!--article-->
<div style="margin-top: 10px;">
<table>
<tr>
	<th style="width:10%; text-align:center;">번호</th>
	<th style="width:60%;">회원명</th>
	<th style="width:15%">차단날짜</th>
</tr>
<c:forEach var="list" items="${blockUserList.content}">
<tr>
	<td>${list.id}</td>
	<td><div class="clickUser">${list.userid}</div></td>
	<td><fmt:formatDate value="${list.blockDate}" pattern="yyyy/MM/dd" /></td>
</tr>
</c:forEach>
</table>
</div>
<!-- paging -->
<div class="paging">
<ul style="font-size:10px;">
	<!-- 이전 -->
	<c:choose>
		<c:when test="${blockUserList.first}"></c:when>
		<c:otherwise>
			<li><a href="/blockUserList?page=0">&lt;&lt;</a></li>
			<li><a href="/blockUserList?page=${blockUserList.number-1}">&lt;</a></li>
		</c:otherwise>
	</c:choose>	
	<!-- 페이지 그룹 -->
	<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
		<c:choose>
			<c:when test="${blockUserList.pageable.pageNumber+1 == i}">
				<li><a href="/blockUserList?page=${i-1}">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/blockUserList?page=${i-1}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>    
	<!-- 다음 -->
	<c:choose>
		<c:when test="${blockUserList.last}"></c:when>
		<c:otherwise>
			<li><a href="/blockUserList?page=${blockUserList.number+1}">&gt;</a></li>
			<li><a href="/blockUserList?page=${blockUserList.totalPages-1}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>
</div>
</div>
	
<!-- content -->		
</section>
<script src="/js/main.js"></script>
<script src="/js/article.js"></script>
</body>
</html>