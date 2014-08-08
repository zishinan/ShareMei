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
	<form action="product?cmd=save" method="post" enctype="multipart/form-data">
	
	<input name="id" type="hidden" value="${product.id }"/>
		产品名称：<input name="name" type="text" value="${product.name }" />${errors.name}<br>
		产品编号：<input name="sn" type="text" value="${product.sn }" />${errors.sn}<br>
		产品类型：<select name="dir_id">
				<c:forEach items="${dirs }" var="d">
					<option value="${d.id}" ${d.id == product.dir.id?"selected='selected'":"" }>${d.name}</option>
				</c:forEach>
			  </select><br>
		原价：<input name="price" type="text" value="${product.price }" />${errors.price}<br>
		折扣价：<input name="salePrice" type="text" value="${product.salePrice }" />${errors.salePrice}<br>
		进价：<input name="costPrice" type="text" value="${product.costPrice }" />${errors.costPrice}<br>
		库存：<input name="storeNum" type="text" value="${product.storeNum }" />${errors.storeNum}<br>
		简介：<input name="content" type="text" value="${product.content }" />${errors.content}<br>
		图片：<input name="pic_file" type="file" /><br>
		<input type="submit" value="确定" >&nbsp;&nbsp;<input type="reset" value="重置">
	</form> 
</body>
</html>