<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ShareMeiTitle}</title>
</head>
<body>
	<form action="user?cmd=save" method="post">
		用户名：<input name="nickname" type="text"><br>
		邮箱：<input name="email" type="text"><br>
		电话：<input name="phone" type="text"><br>
		
		<input type="submit" value="添加" >&nbsp;&nbsp;<input type="reset" value="重置">
	</form>
</body>
</html>