<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="dir?cmd=save" method="post">
	<input name="id" value="${dir.id}" type="hidden" />
		分类名称：<input name="name" type="text" value="${dir.name }"/>${errors.name}<br>
		分类编号：<input name="sn" type="text" value="${dir.sn }" />${errors.sn}<br>
		所属分类：<select name="dir_id">
				<option value="0">无</option>
				<c:forEach items="${dirs}" var="d">
				<option value="${d.id}" ${d.id == dir.dir.id?"selected='selected'":"" }>${d.name}</option>
				</c:forEach>
			  </select><br>
		
		<input type="submit" value="确定" >&nbsp;&nbsp;<input type="reset" value="重置">
	</form>
</body>
</html>