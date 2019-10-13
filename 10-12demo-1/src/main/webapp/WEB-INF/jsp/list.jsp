<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
</head>
<body>
<table>
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>价格</td>
		<td>数量</td>
		<td>好评率</td>
	</tr>
	<c:forEach items="${list }" var="e">
	<tr>
		<td>${e.gid }</td>
		<td>${e.gname }</td>
		<td>${e.price }</td>
		<td>${e.gcount }</td>
		<td>${e.saleCount }</td>
	</tr>
	</c:forEach>
	<tr>
		<td>
			<a href ="list?cpage=1">首页</a>
			<a href ="list?cpage=${cpage-1 }">上一页</a>
			<a href ="list?cpage=${cpage+1 }">下一页</a>
			<a href ="list?cpage=${ pages}">尾页</a>
		</td>
	</tr>
</table>
</body>
</html>