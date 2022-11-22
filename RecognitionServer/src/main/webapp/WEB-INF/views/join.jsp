<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<form>
  <div class="form-group">
    <label for="exampleInputEmail1">아이디</label>
    <input type="text" class="form-control" id="userid" placeholder="아이디 입력" >
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">이메일</label>
    <input type="email" class="form-control" id="email" placeholder="이메일 입력" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" id="password" placeholder="비밀번호 입력" >
  </div>
  <div style="margin-top:20px;">
  	<button id="btn-join" class="btn btn-primary">회원가입</button>
  </div>
</form>

<!-- content -->		
</section>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="/js/user.js"></script>
</body>
</html>