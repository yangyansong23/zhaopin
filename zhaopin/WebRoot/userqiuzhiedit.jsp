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
						<div class="am-panel am-panel-default">
							<div class="am-panel-hd am-cf"
								data-am-collapse="{target: '#collapse-panel-2'}">
								编辑求职信息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<form id="userForm" class="am-form" action="UserQiuzhiEditServlet"
									method="post">

									<%
									    Qiuzhi editQiuzhi = (Qiuzhi) request.getAttribute("qiuzhiInfo");
									    String qiuzhiid = "";
									    String qjobname = "";
									    String qsalary = "";
									    String qcity = "";
									    if (null != editQiuzhi) {
									        qiuzhiid = String.valueOf(editQiuzhi.getQiuzhiid());
									        qjobname = editQiuzhi.getQ_jobname();
									        qsalary = editQiuzhi.getQ_salary();
									        qcity =editQiuzhi.getQ_city();
									    }
									%>

									<input type="hidden" name="qiuzhiid" value="<%=qiuzhiid%>" />
									<div class="am-u-sm-3 am-text-right">期望职位：</div>
									<div class="am-u-sm-8">
										<input type="text" name="qjobname"
											class="am-form-field am-radius" placeholder="期望职位"
											value="<%=qjobname%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">工作城市：</div>
									<div class="am-u-sm-8">
										<input type="text" name="qcity"
											class="am-form-field am-radius" placeholder="工作城市"
											value="<%=qcity%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">期望薪资：</div>
									<div class="am-u-sm-8">
										<input type="text" name="qsalary"
											class="am-form-field am-radius" placeholder="期望薪资"
											value="<%=qsalary%>" />
									</div>
									<br> <br>

									<div class="am-margin am-margin-top">
										<div class="am-u-sm-12 ">
											<center>
												<button type="submit" class="am-btn am-btn-primary ">保存</button>
											</center>
										</div>
									</div>
									<br> <br>
								</form>
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