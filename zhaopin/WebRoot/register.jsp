<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head2.jsp"%>

<br>
<br>
<br>


<div class="get">
	<div class="am-g am-container">
		<div class="am-u-lg-12">

			<div class="am-g">

				<div class=" am-u-md-8 am-u-sm-12 am-u-md-centered">
					<div class="admin-content">

						<div class="am-tabs am-margin" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="#tab1">求职者</a></li>
								<li><a href="#tab2">学校</a></li>

							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<!-- <form class="am-form"> -->
									<div class="am-g am-margin-top">

										<form id="userForm" class="am-form" action="RegisterServlet"
											method="post">
											<input type="hidden" name="user_type" value="user" />
											<div class="am-u-sm-3 am-text-right">姓名：</div>
											<div class="am-u-sm-8">
												<input type="text" name="username"
													class="am-form-field am-radius" placeholder="真实姓名" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">邮箱：</div>
											<div class="am-u-sm-8">
												<input type="text" name="email"
													class="am-form-field am-radius" placeholder="邮箱账号" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">密码：</div>
											<div class="am-u-sm-8">
												<input type="password" name="pwd"
													class="am-form-field am-radius" placeholder="密码" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">确认密码：</div>
											<div class="am-u-sm-8">
												<input type="password" class="am-form-field am-radius"
													placeholder="再次输入密码" />
											</div>

											<br> <br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary ">立即注册</button>
														<a href="login.jsp" class="am-btn am-btn-default"
															role="button"> 已有账号</a>
													</center>
												</div>
											</div>
										</form>
									</div>
									<!-- </form> -->
								</div>

								<div class="am-tab-panel am-fade" id="tab2">
									<form id="schoolForm" class="am-form" action="RegisterServlet"
										method="post">
										<div class="am-g am-margin-top">
											<input type="hidden" name="user_type" value="school" />
											<div class="am-u-sm-3 am-text-right">学校：</div>
											<div class="am-u-sm-8">
												<input type="text" name="school"
													class="am-form-field am-radius" placeholder="学校名称" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">邮箱：</div>
											<div class="am-u-sm-8">
												<input type="text" name="email"
													class="am-form-field am-radius" placeholder="邮箱账号" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">密码：</div>
											<div class="am-u-sm-8">
												<input type="password" name="pwd"
													class="am-form-field am-radius" placeholder="密码" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">确认密码：</div>
											<div class="am-u-sm-8">
												<input type="password" class="am-form-field am-radius"
													placeholder="再次输入密码" />
											</div>

											<br> <br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary">立即注册</button>
														<a href="login.jsp" class="am-btn am-btn-default"
															role="button"> 已有账号</a>
													</center>
												</div>
											</div>
										</div>
									</form>
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
</body>

<br>
<br>
<br>
<br>
<%@ include file="foot.jsp"%>