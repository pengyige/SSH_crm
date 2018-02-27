<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
  <body class="easyui-layout">   
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
    	    首页 <br>
   当前用户:${sessionScope.user.username }
    </div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
    <h2>客户管理</h2>
   <ul>
   	<li><a href="${pageContext.request.contextPath }/customer_toAddPage.action">添加客户</a></li>
   	<li><a href="${pageContext.request.contextPath }/customer_list.action">显示客户</a></li>
   	<li><a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=1">分页客户列表</a></li>
   </ul>
   
   <h2>联系人管理</h2>
   <ul>
   	<li><a href="${pageContext.request.contextPath }/linkman_toAddPage.action">添加联系人</a></li>
   	<li><a href="${pageContext.request.contextPath }/linkman_list.action">显示所有联系人</a></li>
   	<li></li>
   </ul>
   
   <h2>客户拜访</h2>
   <ul>
   	<li><a href="${pageContext.request.contextPath }/visit_toAddPage.action">新增拜访</a></li>
   	<li><a href="${pageContext.request.contextPath }/visit_list.action">拜访列表</a></li>
   	<li></li>
   </ul>
   
   <h2>综合查询</h2>
   <ul>
   	<li><a href="${pageContext.request.contextPath }/customer_toMoreCondition.action">客户信息查询</a></li>
   	<li></li>
   	<li></li>
   </ul>
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;text-align: center;"><h4>欢迎光临</h4></div>   
</body>  

  
  
  

   
   
  </body>
</html>
