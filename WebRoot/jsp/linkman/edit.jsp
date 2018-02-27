<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
 	 <form action="${pageContext.request.contextPath }/linkman_updateLinkMan.action" method="post" >
		所属客户:
		<select name="customer.cid">
			<c:forEach var="customer" items="${listCustomer }">
				<option value="${customer.cid }" ${customer.cid==link.customer.cid?'selected':'' } >${customer.custName }</option>
			</c:forEach>
		</select>
		<br/>
		<input type="hidden" name="linkid" value="${link.linkid }"/>
		联系人名称：<input type="text" name="lkmName" value="${link.lkmName }"/><br/>
		联系人性别:<input type="radio" name="lkmGender" value="男"  ${link.lkmGender=='男'?'checked':'' }/>男
			<input type="radio" name="lkmGender" value="女" ${link.lkmGender=='女'?'checked':''} /> 女
		<br/>
		联系人办公电话:<input type="text" name="lkmPhone" value="${link.lkmPhone }"/><br/>
		联系人手机:<input type="text" name="lkmMobile" value="${link.lkmMobile}"/><br/>
		<input type="submit" value="保存"/>
  </form>

  </body>
</html>
