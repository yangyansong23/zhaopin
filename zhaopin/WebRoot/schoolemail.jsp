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

						<!---选项卡-->
						<div class="am-tabs" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">发出的邀请函</a></li>
								<li><a href="#tab2">收到的求职信</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<thead>
											<tr>
												<th>发送时间</th>
												<th>求职者姓名</th>
												<th>职位名称</th>
												<th>状态</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>2015.06.01</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-badge-success am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2015.03.24</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">Java工程师</a></td>
												<td><span class="am-badge am-radius">没兴趣</span></td>
											</tr>
											<tr>
												<td>2015.02.26</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-badge-warning am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2015.01.14</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-radius">没兴趣</span></td>
											</tr>
											<tr>
												<td>2014.12.25</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-badge-success am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2015.06.01</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-radius">没兴趣</span></td>
											</tr>
											<tr>
												<td>2015.03.24</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">Java工程师</a></td>
												<td><span class="am-badge am-badge-success am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2015.02.26</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-badge-warning am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2015.01.14</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-badge-success am-radius">感兴趣</span></td>
											</tr>
											<tr>
												<td>2014.12.25</td>
												<td><a href="#">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td><span class="am-badge am-radius">没兴趣</span></td>
											</tr>
										</tbody>
									</table>
									<br>
									<ul class="am-pagination am-pagination-centered">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>


								<div class="am-tab-panel am-fade" id="tab2">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<thead>
											<tr>
												<th>接收时间</th>
												<th>求职者姓名</th>
												<th>职位名称</th>
												<th>管理</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>2014.12.25</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<td>2015.06.01</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<td>2015.03.24</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">Java工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<td>2015.02.26</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<td>2015.01.14</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<td>2014.12.25</td>
												<td><a href="">路飞</a></td>
												<td><a href="#">软件工程师</a></td>
												<td>
													<div class="am-dropdown" data-am-dropdown>
														<button
															class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
															data-am-dropdown-toggle>
															<span class="am-icon-cog"></span> <span
																class="am-icon-caret-down"></span>
														</button>
														<ul class="am-dropdown-content">
															<li><a href="#">1. HR已阅</a></li>
															<li><a href="#">2. 感兴趣</a></li>
															<li><a href="#">3. 面试中</a></li>
															<li><a href="#">4. 通过</a></li>
															<li><a href="#">5. 未通过</a></li>
														</ul>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<br>
									<ul class="am-pagination am-pagination-centered">
										<li class="am-disabled"><a href="#">&laquo;</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
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