<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="dir?cmd=save" method="post">
		分类名称：<input name="name" type="text" /><br>
		分类编号：<input name="sn" type="text" /><br>
		所属分类：<select name="dir">
				<option value=""></option>
				<option value="1">一号</option>
				<option value="2">二号</option>
			  </select><br>
		
		<input type="submit" value="添加" >&nbsp;&nbsp;<input type="reset" value="重置">
	</form>
</body>
</html>