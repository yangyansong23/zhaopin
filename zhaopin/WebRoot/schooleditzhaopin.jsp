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
								编辑招聘信息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<form id="userForm" class="am-form" action="SchoolJobServlet"
									method="post">
									<input type="hidden" name="method" value="add"/>
									<div class="am-u-sm-3 am-text-right">职位名称：</div>
									<div class="am-u-sm-8">
										<input type="text" name="jobname"
											class="am-form-field am-radius" placeholder="职位名称" value=""/>
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">职位薪资：</div>
									<div class="am-u-sm-8">
										<input type="text" name="jobsalary"
											class="am-form-field am-radius" placeholder="职位薪资" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">工作地址：</div>
									<div class="am-u-sm-8">
										<input type="text" name="jobcity"
											class="am-form-field am-radius" placeholder="工作地址" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">职位要求：</div>
									<div class="am-u-sm-8">
										<input type="text" name="jobrequirement"
											class="am-form-field am-radius" placeholder="职位要求" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">职位描述：</div>
									<div class="am-u-sm-8">
										<textarea name="jobdescription"
											class="am-form-field am-radius" placeholder="职位描述" rows="3"
											cols="20"></textarea>
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