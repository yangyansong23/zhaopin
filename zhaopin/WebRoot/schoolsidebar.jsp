<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>

<%
    Schools schInfo = (Schools) session.getAttribute("schoolInfo");
    if (null == schInfo) {
        response.sendRedirect("index.jsp");
    }
%>

<!-- sidebar start -->
<div class="admin-sidebar">

	<div class="am-panel am-panel-default admin-sidebar-panel">
		<div class="am-panel-bd">
			<p>
				<span class="am-icon-bookmark"></span> 学校主页
			</p>
			<div id="amz-offcanvas" class="am-offcanvas doc-offcanvas">
				<section class="amz-sidebar am-offcanvas-bar">
					<ul class="am-nav">
						<li><a href="SchoolHomeServlet">学校信息</a></li>
						<li><a href="SchoolJobServlet">招聘信息</a></li>
						<li><a href="SchoolEmailServlet">邮件中心</a></li>
						<li><a href="SchoolExamServlet">考试管理</a></li>
					</ul>
				</section>
			</div>

		</div>
	</div>

	<div class="am-panel am-panel-default admin-sidebar-panel">
		<div class="am-panel-bd">
			<p>
				<span class="am-icon-bookmark"></span> 公告
			</p>
			<p>宁静致远，务本维新。 —— 北京石油化工学院</p>
		</div>
	</div>

	<div class="am-panel am-panel-default admin-sidebar-panel">
		<div class="am-panel-bd">
			<p>
				<span class="am-icon-tag"></span> 招聘宣言
			</p>
			<p>北京石油化工学院欢迎你!</p>
		</div>
	</div>
</div>
<!-- sidebar end -->