<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户登录</title>
	<link rel="stylesheet" href="css/base.css" />
	<link rel="stylesheet" href="css/login.css" />
</head>
<body>
<div class="superlogin"></div>
<div class="loginBox">
	<div class="loginMain">
		<div class="tabwrap">
		<table border="0" cellspacing="0" cellpadding="0">
		<form action="user" ,method="post">
			<tr><td class="title">用户名：</td><td><input type="text" name="user"/></td></tr>
			<tr><td class="title">密   码：</td><td><input type="password" name="password" /></td></tr>
			<input type="submit"  value="登录" />	
		</form>
		</table>
		</div>
	</div>
</div>
<div class="footer">Copyright © 2016-2017 jianet  All Rights Reserved.</div>
</body>
</html>
