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
								编辑项目经验<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<form id="userForm" class="am-form" action="UserExpEditServlet"
									method="post">
									<%
									    Experience editExp = (Experience) request.getAttribute("editExpInfo");
									    String expid = "";
									    String program = "";
									    String position = "";
									    String sname = "";
									    String starttime = "";
									    String endtime = "";
									    String duty = "";
									    String result = "";
									    if (null != editExp) {
									        expid = String.valueOf(editExp.getExpid());
									        program = editExp.getProgram();
									        position = editExp.getPosition();
									        sname=editExp.getSname();
									        starttime = editExp.getStarttimeStr();
									        endtime = editExp.getEndtimeStr();
									        duty = editExp.getDuty();
									        result = editExp.getResult();
									    }
									%>
									<input type="hidden" name="expid" value="<%=expid%>" />
									<div class="am-u-sm-3 am-text-right">项目名称：</div>
									<div class="am-u-sm-8">
										<input type="text" name="program"
											class="am-form-field am-radius" placeholder="项目名称"
											value="<%=program%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">项目职位：</div>
									<div class="am-u-sm-8">
										<input type="text" name="position"
											class="am-form-field am-radius" placeholder="项目职位"
											value="<%=position%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">工作单位：</div>
									<div class="am-u-sm-8">
										<input type="text" name="schoolname"
											class="am-form-field am-radius" placeholder="工作单位"
											value="<%=sname%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">项目起始时间：</div>
									<div class="am-u-sm-8">
										<input type="date" name="starttime"
											class="am-form-field am-radius" placeholder="起始时间"
											value="<%=starttime%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">项目结束时间：</div>
									<div class="am-u-sm-8">
										<input type="date" name="endtime"
											class="am-form-field am-radius" placeholder="结束时间"
											value="<%=endtime%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">项目职责：</div>
									<div class="am-u-sm-8">
										<input type="text" name="duty" class="am-form-field am-radius"
											placeholder="项目职责" value="<%=duty%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">项目成果：</div>
									<div class="am-u-sm-8">
										<input type="text" name="result"
											class="am-form-field am-radius" placeholder="项目成果"
											value="<%=result%>" />
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