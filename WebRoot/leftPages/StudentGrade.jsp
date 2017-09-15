<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生分数统计</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="jiaoben1286-fenye/css/slimtable.css">
<link rel="stylesheet" href="jiaoben1286-fenye/css/site.css">
<script type="text/javascript">
$(document).ready(function(){
		$(".div2").click(function(){ 
			$(this).next("div").slideToggle("slow")  
			.siblings(".div3:visible").slideUp("slow");
		});
	});
</script>
<style type="text/css">
span{color:red;}
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 793px;
	font-family:SimHei;
	bgcolor:#336699;
}
th{
	border: solid #333 1px;
	font-size:20px;
}
td {
	border: solid #333 1px;
	font-size:20px;
}
input.full{width:100%; height:100%;}
option.afull{width:100%; height:100%;}
</style>
</head>
<body background="images/index.jpg">
    <br>
 	<br>
	<form action="studentGrade.action" method="post">
		<table align="center">
			<tr>
				<td style="border:0px;">学号：
					<input type="text" style="width: 300px;height: 30px;font-size: 16px" name="queryText"  value="${searchText }"/>
					<input type="submit" value="查询" style="width: 100px;height: 30px;font-size: 16px"/>
				</td>
			</tr>
		</table>
	</form>
<center>	
	<table>
	<thead>
	    <tr><td>总计学分</td><td>${request.sum }</td></tr>
		<tr>
		    <th>学号</th>
		    <th>课程编号</th>
			<th>课程成绩</th>
		</tr>
	</thead>
		 
		<c:forEach var="grade" items="${grades }">
			<tr align="center"  height="24px">
				<td>${grade.id.student.sno}</td>
				<td>${grade.id.course.courseNumber}</td>
				<c:if test="${grade.grade< 60.0 }">
				   <td style="background:#ff0000;">${grade.grade }</td>
				</c:if>
				<c:if test="${grade.grade>=60.0 }">
				  <td>${grade.grade }</td>
				</c:if>
				
			</tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>
