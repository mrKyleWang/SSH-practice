<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<script type="text/javascript" src="/sshkaoshi/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="/sshkaoshi/js/Login.js"></script>
</head>
<body>

<h3><font color="red">${msg }</font></h3>
	<b>查询</b><br/>
	<form action="/user/login" method="post">
		<table border="1px" width="50%">
			<tr>
				<td>用户名</td>
				<td><input type="text"  name="username"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password"   name="password"/></td>
			</tr>
		</table>
		<input type="submit" name="login" value="登录" />
	</form>
</body>
</html>