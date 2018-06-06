<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<br>

<div class="am-g am-g-fixed blog-g-fixed">
	<div class="am-cf admin-main">
		<div class="am-u-md-3 blog-sidebar">
			<%@ include file="usersidebar.jsp"%>
		</div>

		<div class="am-u-md-9">
			<!-- content start -->
			<div class="admin-content">

				<div class="am-g">
					<div class="am-u-md-12">

						<div class="am-panel am-panel-default">
							<div class="am-panel-hd am-cf"
								data-am-collapse="{target: '#collapse-panel-3'}">
								求职信息<span class="am-icon-chevron-down am-fr"></span>
							</div>


							<div id="collapse-panel-3" class="am-panel-bd am-collapse am-in">
								<ul class="am-list admin-content-task">

									<%
									    List<Qiuzhi> qiuzhilist = (List<Qiuzhi>) request.getAttribute("qiuzhilist");
									    if (null == qiuzhilist) {
									        System.out.println("为什么qiuzhi信息是空的呢？");
									%>

									<li>
										<div class="admin-task-meta">
											<span>无数据</span>
										</div>
										<div class="admin-task-bd"></div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="userqiuzhiedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
												</div>
											</div>
										</div>
									</li>
									<%
									    } else {
									        int i = 1;
									        for (Qiuzhi qz : qiuzhilist) {
									%>

									<li>
										<div class="admin-task-meta">
											期望职位：<%=qz.getQ_jobname()%>&nbsp;&nbsp;&nbsp;&nbsp; 工作城市：<%=qz.getQ_city()%>&nbsp;&nbsp;&nbsp;&nbsp;
											期望薪资：<%=qz.getQ_salary()%>

										</div>
										<div class="admin-task-bd"></div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="userqiuzhiedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
													<a href="UserQiuzhiEditServlet?method=update&qiuzhiid=<%=qz.getQiuzhiid() %>" class="am-btn am-btn-default">
														<span class="am-icon-pencil"></span>
													</a>
													<a href="UserQiuzhiEditServlet?method=delete&qiuzhiid=<%=qz.getQiuzhiid() %>" class="am-btn am-btn-default">
														<span class="am-icon-times"></span>
													</a>
													
												</div>
											</div>
										</div>
									</li>
									<%
									    }
									    }
									%>

								</ul>
							</div>

						</div>

					</div>
				</div>


			</div>
			<!-- content end -->
		</div>
	</div>
</div>
<%@ include file="foot.jsp"%>