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
								data-am-collapse="{target: '#collapse-panel-1'}">
								学校信息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-1" class="am-panel-bd am-collapse am-in">
								<div class="admin-task-bd">
									<div class="am-u-md-4">
										学校名称：<%=schoolInfo.getSchoolName()%><br> 学校邮箱：<%=schoolInfo.getSchoolEmail()%><br>
										学校地址：<%=schoolInfo.getSchoolLocate()%><br> 学校人数：<%=schoolInfo.getSchoolSize()%><br>
										学校简介：<%=schoolInfo.getSchoolBrief()%><br>
									</div>
									<div class="am-u-md-4">
										<br> <br> <br> <br> <br>
									</div>
									<div class="am-u-md-4">
										<img src="img/default.jpg" title="School Logo"
											class="am-img-thumbnail am-radius" width="130" height="180">
										<br> <br>
									</div>
								</div>

								<div class="am-cf">
									<div class="am-btn-toolbar am-fr">
										<div class="am-btn-group am-btn-group-xs">
											<button type="button" onclick="alert('btn');"
												class="am-btn am-btn-default">
												<span class="am-icon-pencil">编辑</span>
											</button>
										</div>
									</div>
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