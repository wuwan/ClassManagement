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
    
    <title>添加成绩</title>
    
    <style type="text/css">
span{color:red;}
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 793px;
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
    <h1 align="center">添加成绩</h1>
<form action="gradeAdd.action"  method=post id="form1" name="form1">
  <br>
      <input type="hidden" name="param" value="1"/>
	  <table width="793"  border="1" bgColor="#ffffff" align="center">
	  <!-- --------------------------------------------                 -->  
	    <tr>
        <td width="10%" style="color:red">学号</td>
		
		    <td width="40%" colspan="5">
		            <select name="grade.id.student.sno" id="grade.user.sno">  
                      <c:forEach items="${users}" var="item">        
                      <option>${item.sno}</option>  
                      </c:forEach>                             
                      </select>  
		    </td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	    <tr>
        <td width="10%" style="color:red">课程编号</td>
		
		    <td width="40%" colspan="5">
		            <select name="grade.id.course.courseNumber" id="grade.course.courseNumber">  
                      <c:forEach items="${courses}" var="item">        
                      <option>${item.courseNumber}</option>  
                      </c:forEach>                             
                      </select>  
		    </td>
	    </tr>
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>成绩</td>	    
				    <td colspan="5">
				    <input type="text" name="grade.grade" value="${grade.grade}" class="full"></td>
	    </tr>
	 
	    </table>
				<input type="submit" name="submit" onclick="return confirm('确定提交吗')" value="提交">
	    </form>
	    </center>
  </body>
</html>
