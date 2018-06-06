<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>

<%@ include file="head.jsp"%>


<script type="text/javascript">
	$("#head-menu li").eq(2).addClass('am-active').removeClass('item');
</script>
<br>

<div class="am-g am-g-fixed blog-g-fixed">
	<div class="am-u-md-8">
		<article class="blog-main">


			<!--列表框-->
			<section class="am-panel am-panel-default">
				<header class="am-panel-hd">
					<h3 class="am-panel-title">精英人才</h3>
				</header>
				<div class="am-panel-bd">

					<%
					    List<ManList> manlist = (List<ManList>) request.getAttribute("manlist");
					    if (null == manlist) {
					        System.out.println("为什么会是空的呢？");
					%>
					<div class="doc-example">
						<center>
							<span>无数据</span>
						</center>
					</div>
					<%
					    } else {
					        int i = 1;
					        for (ManList ml : manlist) {
					%>
					<div class="doc-example">
						<article class="am-comment">

							<a href="mandetail.jsp"><img src="<%=ml.getUserphoto()%>"
								alt="" class="am-comment-avatar" width="48" height="48" /></a>
							<div class="am-comment-main">
								<header class="am-comment-hd">
									<div class="am-comment-meta">
										<a href="#" class="am-comment-author"><%=ml.getUsername()%></a>
										发布于
										<time datetime="2013-07-27T04:54:29-07:00">
											<%=ml.getQ_time()%></time>
									</div>
									<div class="am-comment-actions">
										<form class="am-form" action="MandetailServlet" method="post">

											<input type="hidden" name="userid" value=<%=ml.getUserid()%>>
											<input type="hidden" name="qiuzhiid" value=<%=ml.getQiuzhiid()%>>
											<i class="am-icon-file-text"></i><input type="submit"
												class="am-btn am-btn-link" value="简历">
										</form>
									</div>
								</header>
								<div class="am-comment-bd">
									<p>
										期望职位：<%=ml.getQ_jobname()%>&nbsp;&nbsp;&nbsp;&nbsp;工作城市：<%=ml.getQ_city()%>
										&nbsp;&nbsp;&nbsp;&nbsp;期望薪资：<%=ml.getQ_salary()%></p>
								</div>
							</div>
					</div>
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