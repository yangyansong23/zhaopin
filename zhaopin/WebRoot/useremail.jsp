<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

						<!---选项卡-->
						<div class="am-tabs" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">已发送求职信</a></li>
								<li><a href="#tab2">收到的邀请函</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<thead>
											<tr>
												<th>发送时间</th>
												<th>学校名称</th>
												<th>职位名称</th>
												<th>状态</th>
											</tr>
										</thead>
										<tbody>
											<%
											    List<Qiuzhixin> qiuzhixinlist = (List<Qiuzhixin>) request.getAttribute("qiuzhixinlist");
											    if (null == qiuzhixinlist || qiuzhixinlist.size() == 0) {
											%>
											<tr>
												<td colspan=4 align="center">无数据</td>
											</tr>
											<%
											    } else {
											        for (Qiuzhixin qzxin : qiuzhixinlist) {
											%>
											<tr>
												<td><%=qzxin.getQiuzhitimeStr()%></td>
												<td><%=qzxin.getSchoolname()%></td>
												<td><a
													href="JobdetailServlet?zhpid1=<%=qzxin.getZhaopinid()%>"><%=qzxin.getQzx_jobname()%></a></td>
												<td><span class="am-badge am-radius"><%=qzxin.getStatus()%></span></td>
											</tr>

											<%
											    }
											    }
											%>
										</tbody>
									</table>
									<ul class="am-pagination am-pagination-centered">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>


								<div class="am-tab-panel am-fade" id="tab2">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<thead>
											<tr>
												<th>发送时间</th>
												<th>学校名称</th>
												<th>职位名称</th>
												<th>管理</th>
											</tr>
										</thead>
										<tbody>

											<%
											    List<Yaoqing> yaoqinglist = (List<Yaoqing>) request.getAttribute("yaoqinglist");
											    if (null == yaoqinglist || yaoqinglist.size() == 0) {
											%>
											<tr>
												<td colspan=4 align="center">无数据</td>
											</tr>
											<%
											    } else {
											        for (Yaoqing yqing : yaoqinglist) {
											%>

											<tr>
												<td><%=yqing.getYaoqingtimeStr()%></td>
												<td><%=yqing.getSchoolname()%></td>
												<td><a href="#"><%=yqing.getQz_jobname()%></a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="UserEmailServlet?method=reply&yqid=<%=yqing.getYaoqingid() %>&msg=没兴趣">1. 没兴趣</a></li>
															<li><a href="UserEmailServlet?method=reply&yqid=<%=yqing.getYaoqingid() %>&msg=感兴趣">2. 感兴趣</a></li>
														</ul>
													</div>
												</td>
											</tr>

											<%
											    }
											    }
											%>

										</tbody>
									</table>
									<br>
									<ul class="am-pagination am-pagination-centered">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>

								</div>
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