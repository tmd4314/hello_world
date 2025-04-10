<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      async function drawChart() {
    	  var dataArray = [];
	      	dataArray.push(['UserName', 'Count Per User']);
	      	
	      	let r1 = await fetch('chartJson.do');
	      	let r2 = await r1.json();
	      	r2.forEach(item => {
	      		console.log(item);
	      		dataArray.push([item.userName, item.cnt]);
	      	});
	      	  
	          var data = google.visualization.arrayToDataTable(dataArray);
	
	          var options = {
	            title: '사용자별 작성건수',
	            is3D: true,
	          };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </body>
</html>