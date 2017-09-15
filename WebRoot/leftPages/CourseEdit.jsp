<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改课程信息</title>
    
    <style type="text/css">
span{color:red;}
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 793px;
	font-size:20px;
	font-family:SimHei;
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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
    <h1 align="center">修改课程信息</h1>
<form action="courseUpdate.action"  method=post id="form1" name="form1">
  <br>
      <input type="hidden" name="param" value="1"/>
	  <table width="793"  border="1" bgColor="#ffffff" align="center">
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>课程编号</td>	    
				    <td colspan="5">
				    <input type="text" name="course.courseNumber" value="${course.courseNumber}" class="full" readonly="readonly"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>课程名称</td>	    
				    <td colspan="5">
				    <input type="text" name="course.courseName" value="${course.courseName}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>课程性质</td>	    
				    <td colspan="5">${course.property}
				    <select name="course.property" id="course.property" value="${course.property}">  
				    <option>必修</option>
				    <option>选修</option>
				    <option>学位</option>
				    </select>
				    </td>
	    </tr>
	  <!-- --------------------------------------------                 -->
	              <tr>
				    <td><span>*</span>课程学分</td>	    
				    <td colspan="5">
				    <input type="text" name="course.credit" value="${course.credit}" class="full"></td>
	    </tr>

	    </table>
				<input type="submit" name="submit" onclick="return confirm('确定提交吗')" value="提交">
	    </form>
	    </center>
  </body>
</html>
