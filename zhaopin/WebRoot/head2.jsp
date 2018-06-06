<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="i/favicon.png">
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="css/personal.css" />
<script type="text/javascript">
</script>
</head>

<body>
	<header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
		<div class="am-container">
			<h1 class="am-topbar-brand">
				<a href="index.jsp">中小学教师招聘网</a>
			</h1>

			<!-- <button
                class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-secondary am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
                <span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
            </button> -->

			<div class="am-collapse am-topbar-collapse" id="collapse-head">
				<ul class="am-nav am-nav-pills am-topbar-nav">
					<li><a href="JobListServlet">首页</a></li>
                    <li><a href="JobSearchServlet">工作职位</a></li>
                    <li><a href="ManlistServlet">精英人才</a></li>
				</ul>

			</div>
		</div>
	</header>