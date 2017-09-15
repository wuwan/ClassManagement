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
    
    <title>添加学生</title>
    
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
    <h1 align="center">添加学生</h1>
<form action="studentAdd.action"  method=post id="form1" name="form1">
  <br>
      <input type="hidden" name="param" value="1"/>
	  <table width="793"  border="1" bgColor="#ffffff" align="center">
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>学号</td>	    
				    <td colspan="5">
				    <input type="text" name="user.sno" value="${user.sno}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>姓名</td>	    
				    <td colspan="5">
				    <input type="text" name="user.sname" value="${user.sname}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	  <tr>
				    <td><span>*</span>性别</td>	    
				    <td colspan="5">
				    <input type="text" name="user.sex" value="${user.sex}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	  <tr>
				    <td><span>*</span>出生日期</td>	    
				    <td colspan="5">
				    <input type="text" name="user.dateBirth" value="${user.dateBirth}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	  <tr>
				    <td><span>*</span>密码</td>	    
				    <td colspan="5">
				    <input type="password" name="user.password" value="${user.password}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	  <tr>
				    <td><span>*</span>家庭住址</td>	    
				    <td colspan="5">
				    <input type="text" name="user.home" value="${user.home}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	  <tr>
				    <td><span>*</span>联系电话</td>	    
				    <td colspan="5">
				    <input type="text" name="user.contact" value="${user.contact}" class="full"></td>
	    </tr>
	  <!-- --------------------------------------------                 -->  
	    <tr>
        <td width="10%" style="color:red">班级编号</td>
		
		    <td width="40%" colspan="5">
		            <select name="user.claM.cno" id="user.claM.cno">  
                      <c:forEach items="${clams}" var="item">        
                      <option>${item.cno}</option>  
                      </c:forEach>                             
                      </select>  
		    </td>
	    </tr>

	    </table>
				<input type="submit" name="submit" onclick="return confirm('确定提交吗')" value="提交">
	    </form>
	    </center>
  </body>
</html>
