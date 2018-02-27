<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listpage.jsp' starting page</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table>
  		<tr>
     		<td>客户Id</td>
     		<td>客户名称</td>
     		<td>客户等级</td>
     		<td>客户资源</td>
     		<td>客户电话</td>
     		<td>手机电话</td>
     		<td>操作</td>
     	</tr>
     	<c:forEach items="${pageBean.list }" var="customer">
     	   <tr>
	     	   	<td>${customer.cid}</td>
	     		<td>${customer.custName}</td>
	     		<td>${customer.custLevel}</td>
	     		<td>${customer.custSource}</td>
	     		<td>${customer.custPhone}</td>
	     		<td>${customer.custMobile}</td>
     	   </tr>
     	</c:forEach>
     		
     		共${pageBean.totalCount }条记录,${pageBean.totalPage }页<br/>
     		当前第${pageBean.currentPage }页<br/>
     		<c:if test="${pageBean.currentPage != 1 }">
     				<a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=${pageBean.currentPage - 1}">前一页</a>
     		</c:if>
     		
     		<c:if test="${pageBean.currentPage != pageBean.totalPage }">
     		<a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=${pageBean.currentPage + 1}">下一页</a>
     		</c:if>
  
    </table>

  </body>
</html>
