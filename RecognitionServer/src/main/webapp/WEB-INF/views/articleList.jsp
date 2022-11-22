<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="article">
<ul class="article-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/articleList" class="active">게시판</a></li>
</ul>
<div class="article-list-total">총 건수: ${total}</div>
<!--article-->
<div style="margin-top: 10px;">
<table>
<tr>
	<th style="width:10%; text-align:center;">번호</th>
	<th style="width:70%">제목</th>
	<th style="width:10%">작성자</th>
	<th style="width:10%">게시일</th>
</tr>
<c:forEach var="articleList" items="${articleList.content}">
<input type="hidden" id="userid" value="${articleList.userid}"/>
<tr>
	<td>${articleList.id}</td>
	<td class="table-title"><a href="/articleListDetail/${articleList.id}">${articleList.title}</a></td>
	<td>
		<div class="clickUser">${articleList.userid}
			<div class="selectUser"><a href="/selectUser/${articleList.userid}">회원정보</a></div>
		</div>		
	</td>
	<td><fmt:formatDate value="${articleList.writeDate}" pattern="yyyy/MM/dd" /></td>
</tr>
</c:forEach>
</table>
</div>
<div class="abutton clearfix">
	<a href="/articleListWrite">글쓰기</a>
</div>
<!-- paging -->
<div class="paging">
<ul style="font-size:10px;">
	<!-- 이전 -->
	<c:choose>
		<c:when test="${articleList.first}"></c:when>
		<c:otherwise>
			<li><a href="/articleList?page=0">&lt;&lt;</a></li>
			<li><a href="/articleList?page=${articleList.number-1}">&lt;</a></li>
		</c:otherwise>
	</c:choose>	
	<!-- 페이지 그룹 -->
	<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
		<c:choose>
			<c:when test="${articleList.pageable.pageNumber+1 == i}">
				<li><a href="/articleList?page=${i-1}">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/articleList?page=${i-1}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>    
	<!-- 다음 -->
	<c:choose>
		<c:when test="${articleList.last}"></c:when>
		<c:otherwise>
			<li><a href="/articleList?page=${articleList.number+1}">&gt;</a></li>
			<li><a href="/articleList?page=${articleList.totalPages-1}">&gt;&gt;</a></li>
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