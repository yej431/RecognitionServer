<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="flower">
<ul class="flower-sub">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/flowerList" class="active">글목록</a></li>
	<li class="divider">/</li>
	<li><a href="/flowerList" class="active">글작성</a></li>
	<li class="divider">/</li>
	<li><a href="/flowerList" class="active">글수정</a></li>
</ul>
<div class="write-form">
<form action="/flowerListUpdate" enctype="multipart/form-data" method="post">	
	<input type="hidden" name="id" value="${flowerList.id}"/>
	<div class="write-form-title">
		<input name="title" value="${flowerList.title}"/>
	</div>	
	<div class="write-form-textarea">
		<textarea rows="20" id="5" name="content" >${flowerList.content}</textarea>
	</div>
	<div class="file"><input type="file" name="file"/></div>	
	<div class="submit clearfix"><input type="submit" value="수정"/></div>	
</form>
</div>
</div>

<!-- content -->		
</section>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="/js/flower.js"></script>
<script src="/js/main.js"></script>
</body>
</html>