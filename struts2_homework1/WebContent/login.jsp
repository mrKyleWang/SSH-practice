<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font style="color:red"><s:property value="errorMsg"></s:property></font>
<form action="${pageContext.request.contextPath}/user_login" method="post">

	用户名:<input type="text" name="username"/><br/>
	密&nbsp&nbsp&nbsp码:<input type="password" name="password"/><br/>
	<input type="submit">
</form>
</body>
</html>