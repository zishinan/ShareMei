<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ShareMeiTitle}</title>
</head>
<body>
	<a href="user?cmd=add">添加用户</a>

	<table border="1">
		<tr>
			<th>用户名 </th>
			<th>邮箱</th>
			<th>电话</th>
		</tr>
		
		<c:forEach items="${users}" var="u">
		<tr>
			<td>${u.nickname}</td>
			<td>${u.email}</td>
			<td>${u.phone}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>