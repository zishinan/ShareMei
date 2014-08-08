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
	<a href="product?cmd=add">添加物品</a>

	<table border="1">
		<tr>
			<th>产品名称</th>
			<th>产品编号</th>
			<th>产品类型</th>
			<th>排序序号</th>
			<th>最近修改</th>
			<th>产品简介</th>
			<th>图片地址</th>
			<th>小图地址</th>
			<th>进价</th>
			<th>原价</th>
			<th>折价</th>
			<th>库存</th>
			<th>浏览量</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${products}" var="p">
		<tr>
			<td>${p.name}</td>
			<td>${p.sn}</td>
			<td>${p.dir.name}</td>
			<td>${p.sequence}</td>
			<td>${p.ctime}</td>
			<td>${p.content}</td>
			<td>${p.pic}</td>
			<td>${p.spic}</td>
			<td>${p.costPrice}</td>
			<td>${p.price}</td>
			<td>${p.salePrice}</td>
			<td>${p.storeNum}</td>
			<td>${p.clickNum}</td>
			<td><a href="product?cmd=update&id=${p.id}">修改</a>&nbsp;&nbsp;<a href="product?cmd=delete&id=${p.id}">删除</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>