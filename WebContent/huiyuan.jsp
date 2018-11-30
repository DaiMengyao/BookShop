<%@page import="entity.UserInfo"%>
<%@page import="java.util.List"%>
 <%@ page import="java.lang.*"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" js csstransforms3d"><head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>会员</title>
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
<%
List<UserInfo> users = (List<UserInfo>)request.getAttribute("users");
%>
	<!--content S-->
	<div class="super-content">
		<div class="superCtab">
			<div class="ctab-title clearfix"><h3>会员管理</h3></div>
			
			<div class="ctab-Main">
				
				<div class="ctab-Mian-cont">
					<div class="Mian-cont-btn Mian-cont-btn2 clearfix">
						<div class="operateBtn">
							<div class="wd-msg">一共有  <span><%=users.size()%></span> 个会员！</div>
						</div>
						<div class="searchBar">
							<input type="text" id="" value="" class="form-control srhTxt" placeholder="输入会员id搜索">
							<input type="button" class="srhBtn"  value="" onclick="search()">	
						</div>
					</div>
					
					<div class="Mian-cont-wrap">
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable">
								<tbody>
					
								<tr>
								<th class="t_1">会员id</th>
								<th class="t_2">会员名</th>
								<th class="t_3">会员等级</th>
								<th class="t_4">会员积分</th>
								<th>操作</th>
								</tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
								<%
							int totalpage = (int)request.getAttribute("totalpage");
							int currentpage = (int)request.getAttribute("currentpage");
							int size = users.size();
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
							<tr >
								
								<td class="t_1"><a href="UserDetailServlet?userid=<%=users.get(i).getId() %>" class="team-a" ><%=users.get(i).getId() %></a></td>
								<td class="t_2"><%=users.get(i).getNickname() %></td>
								<td class="t_3"><%=users.get(i).getVipType() %></td>
								<td class="t_4"><%=users.get(i).getVipScore() %></td>
								<td class="alcenter"><a href="UserDetailServlet?userid=<%=users.get(i).getId() %>" class="team-a" >会员详情</a></td>
							
							</tr>
							<%} %>
	

				
						</tbody></table>
						<!--pages S-->
						<div class="pageSelect">
							<span>共 <b><%=users.size()%></b> 条 每页 <b>10</b>条   <%=currentpage+"/"+totalpage%></span>
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
						<!--pages E-->
					</div>
				</div>
			</div>
		</div>
		<!--main-->
		
	</div>
	<!--content E-->

<script>
function search(){
	var search=$("#search").val();
	window.location.href='user?type=search&userid='+search;
}

function pagepre(){
	var type = $("#type").val();
	console.log(type);
	var currentpage = parseInt($("#currentpage").text());
	console.log(currentpage);
	window.location.href='user?type='+type+'&currentpage='+(currentpage-1);
}

function pagenext(){
	var type = $("#type").val();
	console.log(type);
	var currentpage = parseInt($("#currentpage").text());
	console.log(currentpage);
	window.location.href='user?type='+type+'&currentpage='+(currentpage+1);
}

</script>


</body></html>