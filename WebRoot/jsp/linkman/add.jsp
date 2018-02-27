<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <form action="${pageContext.request.contextPath }/linkman_addLinkMan.action" method="post" enctype="multipart/form-data">
		所属客户:
		<select name="customer.cid">
			<c:forEach var="customer" items="${listCustomer }">
				<option value="${customer.cid }">${customer.custName }</option>
			</c:forEach>
		</select>
		<br/>
		联系人名称：<input type="text" name="lkmName"/><br/>
		联系人性别:<input type="radio" name="lkmGender" value="男"/>男
			<input type="radio" name="lkmGender" value="女"/>女
		<br/>
		联系人办公电话:<input type="text" name="lkmPhone"/><br/>
		联系人手机:<input type="text" name="lkmMobile"/><br/>
		选择文件：<input type="file" name="upload"/>
		<input type="submit" value="保存"/>
  </form>
  </body>
</html>
