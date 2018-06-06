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

						<%
						    if (null == userInfo) {
						        System.out.println("为什么会是空的呢？");
						    } else {
						%>

						<div class="am-panel am-panel-default">
							<div class="am-panel-hd am-cf"
								data-am-collapse="{target: '#collapse-panel-1'}">
								个人信息<span class="am-icon-chevron-down am-fr"></span>
							</div>

							<div id="collapse-panel-1" class="am-panel-bd am-collapse am-in">
								<div class="admin-task-bd">
									<div class="am-u-md-4">
										姓名：<%=userInfo.getUsername()%><br> 性别：<%=userInfo.getUsergender()%><br>
										邮箱：<%=userInfo.getUseremail()%><br> <br> <br>
									</div>
									<div class="am-u-md-4">
										学校：<%=userInfo.getUserschool()%><br> 专业：<%=userInfo.getUserfield()%><br>
										毕业时间：<%=userInfo.getUsergraduate()%><br> <br> <br>
									</div>
									<div class="am-u-md-4">
										<img src="img/default.jpg" title="User Photo"
											class="am-img-thumbnail am-radius" width="130" height="180">
									</div>
								</div>

								<div class="am-cf">
									<div class="am-btn-toolbar am-fr">
										<div class="am-btn-group am-btn-group-xs">
											<a href="useredit.jsp" class="am-btn am-btn-default"> <span
												class="am-icon-pencil">编辑</span>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
						    }
						%>
					</div>
				</div>


				<div class="am-g">
					<div class="am-u-md-12">

						<div class="am-panel am-panel-default">
							<div class="am-panel-hd am-cf"
								data-am-collapse="{target: '#collapse-panel-3'}">
								项目经验<span class="am-icon-chevron-down am-fr"></span>
							</div>


							<div id="collapse-panel-3" class="am-panel-bd am-collapse am-in">
								<ul class="am-list admin-content-task">
									<%
									    List<Experience> experiencelist = (List<Experience>) request.getSession().getAttribute("experiencelist");
									    if (null == experiencelist || experiencelist.size()==0) {
									        System.out.println("为什么会项目经验是空的呢？");
									%>

									<li>
										<div class="admin-task-meta">
											<span>无数据</span>
										</div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="userexpedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
												</div>
											</div>
										</div>
									</li>
									<%
									    } else {
									        int i = 1;
									        for (Experience exp : experiencelist) {
									%>

									<li>
										<div class="admin-task-meta">
											项目名称：<%=exp.getProgram()%>&nbsp;&nbsp;&nbsp;&nbsp; 项目职位：<%=exp.getPosition()%>&nbsp;&nbsp;&nbsp;&nbsp;
											项目时间：<%=exp.getStarttime()%>~<%=exp.getEndtime()%><br>
											工作单位：<%=exp.getSname()%>

										</div>
										<div class="admin-task-bd">
											项目职责：<%=exp.getDuty()%><br> 项目成果：<%=exp.getResult()%>
										</div>
										<div class="am-cf">
											<div class="am-btn-toolbar am-fr">
												<div class="am-btn-group am-btn-group-xs">
													<a href="userexpedit.jsp" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span>
													</a>
													<a href="UserExpEditServlet?method=update&expid=<%=exp.getExpid() %>" class="am-btn am-btn-default">
														<span class="am-icon-pencil"></span>
													</a>
													<a href="UserExpEditServlet?method=delete&expid=<%=exp.getExpid() %>" class="am-btn am-btn-default">
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