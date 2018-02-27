<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	${requestScope.error }
    <form action="${pageContext.request.contextPath }/user_login.action">
    	用户名:<input type="text" name="username" value="${username }"/><br/>
    	密码:<input type="password" name="password"/> <br/>
    	<input type="submit" value="登入"/>
    </form>
  </body>
</html>
