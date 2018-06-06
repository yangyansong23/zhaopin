<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>


<script type="text/javascript">
	$("#head-menu li").eq(1).addClass('am-active').removeClass('item');
</script>
<br>

<div class="am-g am-g-fixed blog-g-fixed">
	<div class="am-u-md-8">
		<article class="blog-main">

			<!--搜索框-->
			<form action="JobSearchServlet" method="post">
				<div class="am-input-group am-input-group-primary">
					<input type="text" class="am-form-field" name="keyword"
						placeholder="输入职位名称、学校名称试试！"> <span
						class="am-input-group-btn">
						<button class="am-btn am-btn-primary" type="submit">搜索</button>
					</span>
				</div>
			</form>
			<br>
			<!--搜索结果面板-->
			<section class="am-panel am-panel-default">
				<header class="am-panel-hd">
					<h3 class="am-panel-title">工作机会</h3>
				</header>
				<div class="am-panel-bd">
					<%
					    List<JobList> joblist = (List<JobList>) request.getAttribute("JobSearch");
					    if (null == joblist || joblist.size()==0) {
					        System.out.println("JobSearch为什么会是空的呢？");
					%>
					<div class="doc-example">
						<center>无数据</center>
					</div>
					<%
					    } else {
					        int i = 1;
					        for (JobList jc : joblist) {
					%>
					<div class="doc-example">
						<article class="am-comment">
							<a href="#link-to-user-home"><img
								src="<%=jc.getSchoolLogo()%>" alt="" class="am-comment-avatar"
								width="48" height="48" /></a>
							<div class="am-comment-main">
								<header class="am-comment-hd">
									<div class="am-comment-meta">
										<a href="#" class="am-comment-author"><%=jc.getSchoolName()%></a>
										发布于
										<time datetime="2018-05-02T09:54:29-12:00">
											<%=jc.getZ_timeStr()%></time>
									</div>
									<div class="am-comment-actions">
										<a href=""><i class="am-icon-thumbs-up"></i></a> <a href=""><i
											class="am-icon-thumbs-down"></i></a>
									</div>
								</header>
								<div class="am-comment-bd">
									<form class="am-form" action="JobdetailServlet" method="post">
										职位：<input type="submit" class="am-btn am-btn-link"
											value="<%=jc.getZ_jobname()%>" /> 工作城市：<%=jc.getZ_city()%>&nbsp;&nbsp;&nbsp;
										薪资：<%=jc.getZ_salary()%>
										<input type="hidden" name="zhpid1"
											value="<%=jc.getZhaopinid()%>" />
									</form>
								</div>
							</div>
					</div>
					<br>
					<%
					    }
					    }
					%>
					<br>
					<ul class="am-pagination am-pagination-centered">
						<li class="am-disabled"><a href="#">&laquo;</a></li>
						<li class="am-active"><a href="#">1</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>

				</div>
			</section>
	</div>

	<%@ include file="rightsidebar.jsp"%>

</div>

<%@ include file="foot.jsp"%>