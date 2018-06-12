<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>

<!-- right side bar start -->
<div class="am-u-md-4 blog-sidebar">
	<div class="am-panel-group">
		<section class="am-panel am-panel-default">
			<div class="am-panel-hd">热门职位</div>
			<div class="am-panel-bd">
				<table class="am-table">
					<%
					    List<JobList> jobListSide = (List<JobList>) request.getSession().getAttribute("jobListCount");
					    if (null == jobListSide || jobListSide.size() == 0) {
					        System.out.println("JobSearch为什么会是空的呢？");
					%>
					<div class="doc-example">
						<center>无数据</center>
					</div>
					<%
					    } else {
					        int i = 1;
					        for (JobList jc : jobListSide) {
					%>
					<tr>
						<td><%=jc.getSchoolName()%></td>
						<td><%=jc.getZ_jobname()%></td>
						<td><%=jc.getZ_salary()%></td>
						<td><span class="am-badge am-badge-warning am-round"><%=i++%></span></td>
					</tr>
					<%
					    }
					    }
					%>
				</table>
			</div>
		</section>

		<section class="am-panel am-panel-default">
			<div class="am-panel-hd">网站介绍</div>
			<div class="am-panel-bd">
				<p>中小学教师招聘考试是针对教师这个行业，为应聘者提供最新，最全的职位信息，让他们能够即时获取所需要的内容。
					已有的教师招聘考试最主要的功能有最新招聘、考试试题、复习资料、在线题库等功能分类等。教师招聘考试不仅对于个人来讲有着重要的意义，对于社会来说也是一种进步。
					教师招聘考试系统的完善将促进并提高教师招聘的效率，间接性的促进了社会的教育文化发展，好的教育者才能教育出优秀的学子，提高全民的素质。
				</p>
			</div>
		</section>

		<section class="am-panel am-panel-default">
			<div class="am-panel-hd">友情链接</div>
			<div class="am-panel-bd">
				<ul class="am-avg-sm-4 blog-team">
					<li><a href="http://www.zhaopin.com"><img
							class="am-thumbnail" src="img/link/zhilian.png" alt="" /></a></li>
					<li><a href="http://www.dajie.com"> <img
							class="am-thumbnail" src="img/link/dajie.png" alt="" />
					</a></li>
					<li><a href="http://www.neitui.me"><img
							class="am-thumbnail" src="img/link/neitui.jpg" alt="" /></a></li>
					<li><a href="http://www.lagou.com"><img
							class="am-thumbnail" src="img/link/lagou.jpg" alt="" /></a></li>
					<li><a href="http://www.58.com"><img class="am-thumbnail"
							src="img/link/58.png" alt="" /></a></li>
					<li><a href="http://www.yingjiesheng.com"><img
							class="am-thumbnail" src="img/link/yingjiesheng.png" alt="" /></a></li>
					<li><a href="http://www.chinahr.com"><img
							class="am-thumbnail" src="img/link/yingcai.png" alt="" /></a></li>
					<li><a href="http://www.ganji.com"><img
							class="am-thumbnail" src="img/link/ganji.png" alt="" /></a></li>
				</ul>
			</div>
		</section>

		<section class="am-panel am-panel-default">
			<div class="am-panel-hd">联系我们</div>
			<div class="am-panel-bd">
				<ul class="am-avg-sm-4 blog-team">

					<div class="am-dropdown" data-am-dropdown>
						<li><a href=""
							class="am-icon-btn am-primary am-icon-qq am-dropdown-toggle"></a></li>
						<div class="am-dropdown-content">
							<p>QQ：123456789</p>
						</div>
					</div>

					<div class="am-dropdown" data-am-dropdown>
						<li><a href=""
							class="am-icon-btn am-primary am-icon-weixin am-dropdown-toggle"></a></li>
						<div class="am-dropdown-content">
							<!-- <img class="am-thumbnail am-radius" src="img/us/weixin.jpg"
									title="微信号：XXX_001" width="140" height="140" /> -->
							<p>微信号：XXX_001</p>
						</div>
					</div>

					<div class="am-dropdown" data-am-dropdown>
						<li><a href=""
							class="am-icon-btn am-primary am-icon-envelope am-dropdown-toggle"></a></li>
						<div class="am-dropdown-content">
							<p>用户反馈：yh@zhaopin.com</p>
							<p>学校反馈：xx@zhaopin.com</p>
						</div>
					</div>

				</ul>
			</div>
		</section>
	</div>
</div>
<!-- right side bar end -->
