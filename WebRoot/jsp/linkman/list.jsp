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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><table>
		<tr>
			<td>联系人Id</td>
			<td>姓名</td>
			<td>性别</td>
			<td>固定电话</td>
			<td>手机号</td>
			<td>所属客户</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${listLinkMan}" var="linkman">
			<tr>
				<td>${linkman.linkid }</td>
				<td>${linkman.lkmName }</td>
				<td>${linkman.lkmGender }</td>
				<td>${linkman.lkmPhone }</td>
				<td>${linkman.lkmMobile }</td>
				<td>${linkman.customer.custName }</td>
				<td><a href="${pageContext.request.contextPath }/linkman_showLinkMan.action?linkid=${linkman.linkid}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
