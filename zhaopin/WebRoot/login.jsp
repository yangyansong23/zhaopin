<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head2.jsp"%>

<br>
<br>
<br>
<div><center><font color="red"><%=(null == request.getAttribute("error"))?"":request.getAttribute("error") %></font></center></div>
<div class="get">
	<div class="am-g am-container">
		<div class="am-u-lg-12">

			<div class="am-g">
				<div class="am-u-lg-6 am-u-md-8 am-u-sm-12">
					<h4 class="about-color">关于我们</h4>
					<p>
					中小学教师招聘考试是针对教师这个行业，为应聘者提供最新，最全的职位信息，让他们能够即时获取所需要的内容。<br>
					已有的教师招聘考试最主要的功能有最新招聘、考试试题、复习资料、在线题库等功能分类等。教师招聘考试不仅对于个人来讲有着重要的意义，对于社会来说也是一种进步。<br>
					教师招聘考试系统的完善将促进并提高教师招聘的效率，间接性的促进了社会的教育文化发展，好的教育者才能教育出优秀的学子，提高全民的素质。					
					</p>
				</div>

				<div class="am-u-lg-6 am-u-md-4 am-u-sm-12">
					<div class="admin-content">

						<div class="am-tabs am-margin" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="#tab1">求职者</a></li>
								<li><a href="#tab2">学校</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<form class="am-form" action="UserLoginServlet" method="post">
										<div class="am-g am-margin-top">
											<div class="am-u-sm-3 am-text-right">邮箱：</div>
											<div class="am-u-sm-8">
												<input type="text" class="am-form-field am-radius"
													name="useremail" placeholder="邮箱" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">密码：</div>
											<div class="am-u-sm-8">
												<input type="password" class="am-form-field am-radius"
													name="userpwd" placeholder="密码" />
											</div>

											<br> <br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary">立即登录</button>
														<a href="register.jsp" class="am-btn am-btn-default"
															role="button"> 注册</a>
													</center>
												</div>
											</div>
										</div>
									</form>
								</div>

								<div class="am-tab-panel am-fade" id="tab2">
									<form class="am-form" action="SchoolLoginServlet" method="post">
										<div class="am-g am-margin-top">
											<div class="am-u-sm-3 am-text-right">邮箱：</div>
											<div class="am-u-sm-8">
												<input type="text" class="am-form-field am-radius"
													name="schoolEmail" placeholder="邮箱" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">密码：</div>
											<div class="am-u-sm-8">
												<input type="password" class="am-form-field am-radius"
													name="schoolPwd" placeholder="密码" />
											</div>

											<br> <br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary ">立即登录</button>
														<a href="register.jsp" class="am-btn am-btn-default"
															role="button"> 注册</a>
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
<br><br><br><br>
<br><br><br><br>
<%@ include file="foot.jsp"%>