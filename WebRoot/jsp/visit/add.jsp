<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/visit_addVisit.action" method="post">
    所属用户:<select name="user.id">
    	<c:forEach items="${listUser }" var="user">
    		<option value="${user.id }">${user.username }</option>
    	</c:forEach>
    </select>
    <br/>
    所属客户:<select name="customer.cid">
    	<c:forEach items="${listCustomer }" var="customer">
    		<option value="${customer.cid }">${customer.custName }</option>
    	</c:forEach>
    </select>
    <br/>
    
    拜访内容:<textarea rows="" cols="" name="vcontent"></textarea><br/>
 拜访地址:<input type="text" name="vaddress"/><br/>
 <input type="submit" value="保存"/>
 </form>
  </body>
</html>
