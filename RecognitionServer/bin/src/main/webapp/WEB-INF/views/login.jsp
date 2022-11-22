<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div style="width:60%; height:60%; padding:30px 10px; margin:0 auto; text-align:center;
	background:white; margin-top:50px; border-radius:10px;">
<form action="/auth/loginProc" method="post">
  <div>
    <div style="padding:10px; font-size:14px; font-weight:bold">아이디</div>
    <input type="text" name="username" style="width:90%; padding:10px; text-align:center;
    	border:0; background:white; border-radius:5px;"
    	placeholder="아이디 입력">
  </div>
  <div style="margin-top:30px;">
    <div style="padding:10px; font-size:14px; font-weight:bold">비밀번호</div>
    <input type="password" name="password" style="width:90%; padding:10px; text-align:center;
    	border:0; background:white; border-radius:5px;"
    	placeholder="비밀번호 입력">
  </div>
  <div style="margin-top:30px;">
  	<button style="padding:8px 17px; border:0; background:var(--blue); 
  		font-size:14px; border-radius: 5px; color:white; cursor: pointer;">로그인</button>
  </div>
</form>
</div>

<!-- content -->		
</section>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="/js/user.js"></script>
<script src="/js/script.js"></script>
</body>
</html>