<%@page import="entity.Order,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html class=" js csstransforms3d"><head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>订单管理——待发货</title>
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
<% List<Order> orders = (List<Order>)request.getAttribute("orders"); %>
	<!--content S-->
	<div class="super-content">
		<div class="superCtab">
			<div class="ctab-title clearfix"><h3>订单管理</h3></div>
			
			<div class="ctab-Main">
				<div class="ctab-Main-title">
					<ul class="clearfix">
						<li> <a class="cur">待发货</a></li>
						<li><a href="OrderServlet?type=query">已发货</a></li>
					</ul>
				</div>
				<div class="ctab-Mian-cont">		
					<div class="Mian-cont-wrap">
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable">
								<tbody><tr><th class="t_1">订单</th><th class="t_2_1">商品标题</th><th class="t_3">成交时间</th><th class="t_5">下单用户</th><th class="t_4">操作</th></tr>
							</tbody></table>
						</div>
						
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
						<%
							int totalpage = (int)request.getAttribute("totalpage");
							int currentpage = (int)request.getAttribute("currentpage");
							int size = orders.size();
							int start = (currentpage-1) * 10;
							int end = start;
							String type = (String)request.getAttribute("type");
							if(currentpage == totalpage && size % 10 != 0){
								end = size; 
							}else{
								end = currentpage * 10;
							}
							for (int i=start;i<end;i++){
						%>
							<tr>
								<td class="t_1"><%=orders.get(i).getOrder_id() %></td>
								<td class="t_2_1"><%=orders.get(i).getBooks()%></td>
								<td class="t_3"><%=orders.get(i).getPayTime() %></td>
								<td class="t_4"><%=orders.get(i).getUserid() %></td>
								<td class="t_7">
									<div class="btn">
									<a href="OrderServlet?type=deliver&id=<%=orders.get(i).getOrder_id() %>" class="modify">发货</a>
									<a href="OrderServlet?type=details&id=<%=orders.get(i).getOrder_id() %>"class="modify" >查看详情</a>
									</div>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
						</table>
						<!--pages S-->
						<div class="pageSelect">
							<span>共 <b><%=orders.size()%></b> 条 每页 <b>10</b>条   <%=currentpage+"/"+totalpage%></span>
					  <div class="pageWrap">
						<!--向前一页  -->
							<a onclick="pagepre()" class="pagepre"  value=""  ><i class="ico-pre">&nbsp;</i></a>
						<!--当前页  -->
							<a  href= "pagecurrent()" class="pagenumb cur"  id="currentpage"><%=currentpage%></a>
						<!-- 向后一页 -->
							<a onclick="pagenext()" class="pagenext"  value=""  ><i class="ico-next">&nbsp;</i></a>
						</div>
						</div>
						<!--pages E-->
						<input type="hidden" id = "type" value="<%=type %>">
					</div>
				</div>
			</div>
		</div>
		<!--main-->
		
	</div>
	<!--content E-->
	<!--点击修改弹出层-->
	<div class="layuiBg" style="display: none; height: 757px;"></div><!--公共遮罩-->
	<!--点击添加分类弹出-->
	<div class="addFeileibox layuiBox">
		<div class="layer-title clearfix"><h2>添加分类</h2><span class="layerClose"></span></div>
		<div class="layer-content">
			<div class="aFllink clearfix" style="margin-top: 38px;"><span>二级栏目：</span><input type="text" value=""></div>
			<div class="aFlBtn"><input type="button" value="保存" class="saveBtn"></div>
		</div>
	</div>
	
<script type="text/javascript">
function pagepre(){
	var type = $("#type").val();
	console.log(type);
	var currentpage = parseInt($("#currentpage").text());
	console.log(currentpage);
	window.location.href='OrderServlet?type='+type+'&currentpage='+(currentpage-1);
}

function pagenext(){
	var type = $("#type").val();
	console.log(type);
	var currentpage = parseInt($("#currentpage").text());
	console.log(currentpage);
	window.location.href='OrderServlet?type='+type+'&currentpage='+(currentpage+1);
}
</script>
</body></html>