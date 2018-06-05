<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>

<%@ include file="head.jsp"%>

<script type="text/javascript">
	$("#head-menu li").eq(0).addClass('am-active').removeClass('item');
</script>
<br>

<div class="am-g am-g-fixed blog-g-fixed">
	<div class="am-u-md-8">
		<article class="blog-main">
			<!-- 图片轮播­-->
			<div class="am-slider am-slider-default" data-am-flexslider>
				<ul class="am-slides">
					<li><img src="img/banner/1.jpg" /></li>
					<li><img src="img/banner/2.jpg" /></li>
				</ul>
			</div>

			<br>

			<!--搜索框-->
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

			<!---选项卡-->
			<div class="am-tabs" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
					<li class="am-active"><a href="#tab1">热门职位</a></li>
					<li><a href="#tab2">最新职位</a></li>
				</ul>

				<div class="am-tabs-bd">

					<div class="am-tab-panel am-fade am-in am-active" id="tab1">

						<%
						    List<JobList> jobListCount = (List<JobList>) request.getSession().getAttribute("jobListCount");
						    if (null == jobListCount) {
						        System.out.println("jobListCount 为什么会是空的呢？");
						    } else {
						        // int i = 1;
						        for (JobList jc : jobListCount) {
						%>

						<div class="doc-example">
							<article class="am-comment">
								<a href="#link-to-user-home"><img
									src="<%=jc.getSchoolLogo()%>" alt="" class="am-comment-avatar"
									width="48" height="48" /></a>
								<div class="am-comment-main">
									<header class="am-comment-hd">
										<div class="am-comment-meta">
											<a href="#link-to-user" class="am-comment-author"><%=jc.getSchoolName()%></a>
											发布于
											<time datetime="2013-07-27T04:54:29-07:00">
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
												value=<%=jc.getZ_jobname()%>> 工作城市：<%=jc.getZ_city()%>
											&nbsp;&nbsp;&nbsp;&nbsp; 薪资：<%=jc.getZ_salary()%>
											<input type="hidden" name="zhpid1"
												value=<%=jc.getZhaopinid()%>>
										</form>
									</div>
								</div>
						</div>
						<br>

						<%
						    }
						    }
						%>

						<ul class="am-pagination am-pagination-centered">
							<li class="am-disabled"><a href="#">&laquo;</a></li>
							<li class="am-active"><a href="#">1</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>

					</div>

					<div class="am-tab-panel am-fade" id="tab2">

						<%
						    List<JobList> joblistTime = (List<JobList>) request.getAttribute("JobListTime");
						    if (null == joblistTime) {
						        System.out.println("为什么会是空的呢？");
						    } else {
						        int i = 1;
						        for (JobList jc : joblistTime) {
						%>

						<div class="doc-example">
							<article class="am-comment">
								<a href="#link-to-user-home"><img
									src="<%=jc.getSchoolLogo()%>" alt="" class="am-comment-avatar"
									width="48" height="48" /></a>
								<div class="am-comment-main">
									<header class="am-comment-hd">
										<div class="am-comment-meta">
											<a href="#link-to-user" class="am-comment-author"><%=jc.getSchoolName()%></a>
											发布于
											<time datetime="2013-07-27T04:54:29-07:00">
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
												value=<%=jc.getZ_jobname()%>> 工作城市：<%=jc.getZ_city()%>
											&nbsp;&nbsp;&nbsp;&nbsp; 薪资：<%=jc.getZ_salary()%><input
												type="hidden" name="zhpid1" value="<%=jc.getZhaopinid()%>" />
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

				</div>
			</div>
		</article>
	</div>

	<%@ include file="rightsidebar.jsp"%>

</div>


<%@ include file="foot.jsp"%>