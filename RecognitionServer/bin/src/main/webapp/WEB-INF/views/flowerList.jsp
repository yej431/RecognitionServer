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
<div class="flower-list-total">총 건수: ${flowerListTotal}</div>
<!--board-->
<div style="margin-top: 10px;">
<table>
<tr>
	<th style="width:15%">사진</th>
	<th style="width:55%">제목</th>
	<th style="width:15%">작성자</th>
	<th style="width:15%">게시일</th>
</tr>
<c:forEach var="flowerList" items="${flowerList.content}">
<tr>
	<td>
		<a href="/flowerListDetail/${flowerList.id}">
			<img src="${flowerList.files}" style="width:50px;"/>
		</a>
	</td>
	<td class="table-title"><a href="/flowerListDetail/${flowerList.id}">${flowerList.title}</a></td>
	<td>${flowerList.userid}</td>
	<td><fmt:formatDate value="${flowerList.createDate}" pattern="yyyy/MM/dd"/></td>
</tr>
</c:forEach>
</table>
</div>
<div class="abutton clearfix">
	<a href="/flowerListWrite">글쓰기</a>
</div>
<!-- paging -->
<div class="paging">
<ul style="font-size:10px;">
	<!-- 이전 -->
	<c:choose>
		<c:when test="${flowerList.first}"></c:when>
		<c:otherwise>
			<li><a href="/flowerList?page=0">&lt;&lt;</a></li>
			<li><a href="/flowerList?page=${flowerList.number-1}">&lt;</a></li>
		</c:otherwise>
	</c:choose>
	
	<!-- 페이지 그룹 -->
	<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
		<c:choose>
			<c:when test="${flowerList.pageable.pageNumber+1 == i}">
				<li><a href="/flowerList?page=${i-1}">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/flowerList?page=${i-1}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
    
	<!-- 다음 -->
	<c:choose>
		<c:when test="${flowerList.last}"></c:when>
		<c:otherwise>
			<li><a href="/flowerList?page=${flowerList.number+1}">&gt;</a></li>
			<li><a href="/flowerList?page=${flowerList.totalPages-1}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>
</div>
</div>
	
<!-- content -->		
</section>
<script src="/js/main.js"></script>
</body>
</html>