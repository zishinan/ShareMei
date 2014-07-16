<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="dir?cmd=add">添加分类</a>

	<table border="1">
		<tr>
			<th>分类名称</th>
			<th>分类编号</th>
			<th>所属分类</th>
			<th>排序序号</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${dirs}" var="d">
		<tr>
			<td>${d.name}</td>
			<td>${d.sn}</td>
			<td>${d.dir.name}</td>
			<td>${d.sequence}</td>
			<td><a href="dir?cmd=update&id=${d.id}">修改</a>&nbsp;&nbsp;<a href="dir?cmd=delete&id=${d.id}">删除</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>