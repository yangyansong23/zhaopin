<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<br>

<div class="am-g am-g-fixed blog-g-fixed">
	<div class="am-cf admin-main">
		<div class="am-u-md-3 blog-sidebar">
			<%@ include file="schoolsidebar.jsp"%>
		</div>

		<div class="am-u-md-9">
			<!-- content start -->
			<div class="admin-content">

				<div class="am-g">
					<div class="am-u-md-12">
						<div class="am-panel am-panel-default">
							<div class="am-panel-hd am-cf"
								data-am-collapse="{target: '#collapse-panel-2'}">
								招聘消息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<ul class="am-list admin-content-task">

									<%
									    List<JobList> jobLists = (List<JobList>) request.getSession().getAttribute("school-job");
									    if (null == jobLists || jobLists.size()==0) {
									%>
									<li>
										<div class="admin-task-meta">
										<span>无数据</span>
										</div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="schoolzhaopinedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
												</div>
											</div>
										</div>
									</li>
									<%
									    } else {
									        int i = 1;
									        for (JobList exp : jobLists) {
									%>

									<li>
										<div class="admin-task-meta">
											职位：<%=exp.getZ_jobname()%>&nbsp;&nbsp;&nbsp;&nbsp; 薪资：<%=exp.getZ_salary()%>&nbsp;&nbsp;&nbsp;&nbsp;
											工作地点：<%=exp.getZ_city()%>&nbsp;&nbsp;&nbsp;&nbsp; 职位分类：<%=exp.getZ_category()%>&nbsp;&nbsp;&nbsp;&nbsp;
											要求：<%=exp.getZ_requirements()%>

										</div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="schoolzhaopinedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
													<a href="SchoolJobServlet?method=update&zhaopinid=<%=exp.getZhaopinid() %>" class="am-btn am-btn-default">
														<span class="am-icon-pencil"></span>
													</a>
													<a href="SchoolJobServlet?method=delete&zhaopinid=<%=exp.getZhaopinid() %>" class="am-btn am-btn-default">
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
		</div>

	</div>
	<!-- content end -->
</div>
<%@ include file="foot.jsp"%>