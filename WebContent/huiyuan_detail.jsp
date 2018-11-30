<%@page import="entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" js csstransforms3d"><head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>会员管理-会员详情页</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
	<!--[if IE]>
	<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>

<body style="background: #f6f5fa;">
<% UserInfo user = (UserInfo)request.getAttribute("user");
%>
	<!--content S-->
	<div class="super-content">
		<div class="superCtab">
			<div class="ctab-title zxtop-title clearfix"><h3>会员管理</h3><a href="user?type=query" class="backlistBtn"><i class="ico-back"></i>返回列表</a></div>
		</div>
		<!--main-->
	</div>
	<!--content E-->
	<div class="zx-dtlMain">
	<dl>
			<dt>会员号：</dt><dd><%=user.getId() %></dd>
		</dl>
		<dl>
			<dt>会员微信昵称：</dt><dd><%=user.getNickname() %></dd>
		</dl>
		<dl>
			<dt>会员性别：</dt><dd><%=user.getSex() %></dd>
		</dl>
		<dl>
			<dt>所在国家：</dt><dd><%=user.getCountry() %></dd>
		</dl>
		<dl>
			<dt>所在省份：</dt><dd><%=user.getProvince() %></dd>
		</dl>
		<dl>
			<dt>所在城市：</dt><dd><%=user.getCity() %></dd>
		</dl>
		<dl>
			<dt>会员类型：</dt><dd><%=user.getVipType() %></dd>
		</dl>
		<dl>
			<dt>会员积分：</dt><dd><%=user.getVipScore() %></dd>
		</dl>
	</div>
		


</body></html>