<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    	<caption>客户拜访表</caption>
    	<tr>
    		<th>客户名称</th>
    		<th>用户名称</th>
    		<th>拜访地址</th>
    		<th>拜访内容</th>
    		<th>操作</th>
    	</tr>
    	
    	<c:forEach items="${visitList }" var="visit">
    	<tr>
    		 <td>${visit.user.username }</td>
    		<td>${visit.customer.custName }</td> 
    		<td>${visit.vaddress }</td>
    		<td>${visit.vcontent }</td>
    		<td><a>删除</a></td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
