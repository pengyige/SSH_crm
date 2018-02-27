<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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
  <div>
  	<form action="${pageContext.request.contextPath }/customer_listcondition.action" method="post">
  	客户名称:<input type="text" name="custName" /> 
  	<input type="submit" value="筛选"/>
  	</form>
  </div>
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
     	<!-- 使用JSTL获取域对象值 -->
  <%--    	<c:forEach items="${requestScope.list }" var="customer">
     	   <tr>
	     	   	<td>${customer.cid}</td>
	     		<td>${customer.custName}</td>
	     		<td>${customer.custLevel}</td>
	     		<td>${customer.custSource}</td>
	     		<td>${customer.custPhone}</td>
	     		<td>${customer.custMobile}</td>
     	   </tr>
     	</c:forEach> --%>
     	
     	<!-- 使用struts2标签获取值栈值 -->
     	<s:iterator value="list" var="customer">
     	<tr>
     		<td><s:property value="#customer.cid"/></td>
     		<td><s:property value="#customer.custName"/></td>
     		<td><s:property value="#customer.custLevel"/></td>
     		<td><s:property value="#customer.custSource"/></td>
     		<td><s:property value="#customer.custPhone"/></td>
     		<td><s:property value="#customer.custMobile"/></td>
     		<td>
     		<!-- 使用el表达式获取域对象值 -->
     			<%-- <a href="${pageContext.request.contextPath }/customer_delete.action?cid=${customer.cid}">删除</a> --%>
     		<!-- 使用strust2标签获取 -->
     			<a href="${pageContext.request.contextPath }/customer_delete.action?cid=<s:property value="#customer.cid" />">删除</a>
     			<a href="${pageContext.request.contextPath }/customer_showCustomer.action?cid=<s:property value="#customer.cid" />">修改</a>
     		</td>
     			
     	</tr>
     	</s:iterator>
     	
     <%-- 	<s:iterator value="list" var="customer">
     		<c:forEach var="entry" items="${ customer.setLinkMan}">
     			${entry.lkmName }
     		</c:forEach>
     	</s:iterator> --%>
     </table>
  </body>
</html>
