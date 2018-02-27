<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/customer_update.action" method="post">
     			<input type="hidden" name="cid" value="${customer.cid }"/>
     	客户名称:<input type="text" name="custName" value="${customer.custName }"/><br/>
     	客户级别:<input type="text" name="custLevel" value="${customer.custLevel }"/><br/>
     	信息来源:<input type="text" name="custSource" value="${customer.custSource }"/><br/>
     	固定电话:<input type="text" name="custPhone" value="${customer.custPhone }"/><br/>
     	移动电话:<input type="text" name="custMobile" value="${customer.custMobile }"/><br/>
     	<input type="submit" value="保存"/>
    </form>
     <br>
  </body>
</html>
