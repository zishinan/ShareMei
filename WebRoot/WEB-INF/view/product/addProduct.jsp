<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		产品名称：<input name="name" type="text" /><br>
		产品编号：<input name="sn" type="text" /><br>
		产品类型：<select name="dir">
				<option value=""></option>
				<option value="1">一号</option>
				<option value="2">二号</option>
			  </select><br>
		原价：<input name="price" type="text" /><br>
		折扣价：<input name="salePrice" type="text" /><br>
		进价：<input name="costPrice" type="text" /><br>
		库存：<input name="storeNum" type="text" /><br>
		简介：<input name="storeNum" type="text" /><br>
		<input type="submit" value="添加" >&nbsp;&nbsp;<input type="reset" value="重置">
	</form> 
</body>
</html>