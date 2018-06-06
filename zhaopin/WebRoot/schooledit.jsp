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
								编辑学校信息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<form id="userForm" class="am-form" action="SchoolEditServlet"
									method="post">

									<%
									   Schools editSch = (Schools) request.getSession().getAttribute("schoolInfo");
									    String schid = "";
									    String schname = "";
									    String schemail = "";
									    String schbrief = "";
									    String schsize = "";
									    String schlocate = "";
									    if (null != editSch) {
									        schid = String.valueOf(editSch.getSchoolId());
									        schname= editSch.getSchoolName();
									        schemail = editSch.getSchoolEmail();
									        schbrief = editSch.getSchoolBrief();
									        schsize = String.valueOf(editSch.getSchoolSize());
									        schlocate = editSch.getSchoolLocate();
									    }
									%>

									<input type="hidden" name="method" value="add" /> <input
										type="hidden" name="schoolid" value="<%=schid%>" />
									<div class="am-u-sm-3 am-text-right">学校名称：</div>
									<div class="am-u-sm-8">
										<input type="text" name="schoolname"
											class="am-form-field am-radius" placeholder="学校名称"
											value="<%=schname %>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">学校邮箱：</div>
									<div class="am-u-sm-8">
										<input type="text" name="schoolemail"
											class="am-form-field am-radius" placeholder="学校邮箱"
											value="<%=schemail %>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">学校地址：</div>
									<div class="am-u-sm-8">
										<input type="text" name="schoollocate"
											class="am-form-field am-radius" placeholder="学校地址"
											value="<%=schlocate%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">学校人数：</div>
									<div class="am-u-sm-8">
										<input type="text" name="schoolsize"
											class="am-form-field am-radius" placeholder="学校人数"
											value="<%=schsize%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">学校简介：</div>
									<div class="am-u-sm-8">
										<textarea name="schoolbrief"
											class="am-form-field am-radius" placeholder="学校简介" rows="3"
											cols="20"><%=schbrief%></textarea>
									</div>
									<br> <br> <br>

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