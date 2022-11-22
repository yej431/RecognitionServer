<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>   
<section id="content">
<%@ include file="layout/navbar.jsp" %>   
<!-- content -->	

<div id="chart">
<h1 class="title">차트</h1>
<ul class="breadcrumbs">
	<li><a href="/">Home</a></li>
	<li class="divider">/</li>
	<li><a href="/chart" class="active">차트</a></li>
</ul>
<div class="data">
<div class="content-data">
	<div class="head">
		<div class="menu1">
			<div id="searchChart"></div>
		</div>
	</div>
</div>
<div class="content-data">
	<div class="head">
	<!-- <h3>Chatbox</h3> -->
		<div class="menu2">
			<div id="userMonthChart"></div>
		</div>
	</div>
</div>
</div>
</div>		

<!-- content -->		
</section>
<!-- <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script> -->
<script src="/js/main.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart']});
google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart1);
google.charts.setOnLoadCallback(drawChart2);

function drawChart1(){
	var jsonData = $.ajax({
		url: "/chart/searchChart",
		dataType: "json",
		async: false
	}).responseText;
	
	console.log("jsonData : "+jsonData);
	var data = new google.visualization.DataTable(jsonData);
	var options = {
			title : "인기 검색어",
	        titleTextStyle: {'fontSize': '20'},
	        fontSize: 13,
	        width : 500,
	        height : 400,
	        chartArea: {'width': '100%', 'height': '70%'},
	        legend: {'position': 'left'},
	        pieHole: 0.4
		};
	
	var chart = new google.visualization.PieChart(document.getElementById('searchChart'));
	chart.draw(data, options);
}
	
function drawChart2(){
	var jsonData = $.ajax({
		url: "/chart/userMonthChart",
		dataType: "json",
		async: false
	}).responseText;
		
	console.log("jsonData2 : "+jsonData);
	
	var data2 = new google.visualization.DataTable(jsonData);
	var options2 = {
	        title : "월별 사용자 가입 현황",
		    titleTextStyle: {'fontSize': '20', bold: true, color:'#000000'},
		    fontSize: 13,
		    left: 20,
		    width : 650,
		    height : 400,
		    chartArea: {'width': '100%', 'height': '70%'},
		    legend: {'position': 'right'}
	    };
		
	var chart2 = new google.charts.Bar(document.getElementById('userMonthChart'));
    chart2.draw(data2, google.charts.Bar.convertOptions(options2));
} 
</script>
</body>
</html>