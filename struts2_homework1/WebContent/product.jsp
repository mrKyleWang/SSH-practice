<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>名称</th>
				<th>价格</th>
				<th>库存</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="productList" >
				<tr>
					<td><s:property value="name"/></td>
					<td><s:property value="price"/></td>
					<td><s:property value="count"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<s:debug/>
</body>
</html>