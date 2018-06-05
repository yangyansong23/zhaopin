<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="head2.jsp"%>

<br>
<br>
<br>


<div class="get">
	<div class="am-g am-container">
		<div class="am-u-lg-12">

			<div class="am-g">
				<div class="am-u-lg-6 am-u-md-8 am-u-sm-12">
					<h4 class="about-color">关于我们</h4>
					<p>
						猎聘招聘网是国内领先的线上招聘平台，随着互联网招聘行业的兴起，猎聘招聘网也在不断的发展壮大。猎聘招聘网专注于互联网就业机会，为国内IT行业人才提供简洁的操作流程，让好机会找到你！<br>
						基于JavaEE技术的猎聘招聘网的设计与实现，毕业设计作品。使用AmazeUI前端框架不仅让界面美观，而且还能够自适应不同分辨率的显示器，无论在什么平台都能享受舒适的体验。
						此项目部署在阿里云云服务器上，供演示使用。希望大家多多指导，让作品变得更优秀！
					</p>
				</div>

				<div class="am-u-lg-6 am-u-md-4 am-u-sm-12">
					<div class="admin-content">

						<div class="am-tabs am-margin" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="#tab1">管理员</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<form class="am-form" action="AdminLoginServlet" method="post">
										<div class="am-g am-margin-top" name="userdiv">
											<div class="am-u-sm-3 am-text-right">邮箱：</div>
											<div class="am-u-sm-8">
												<input type="text" class="am-form-field am-radius"
													name="useremail" placeholder="邮箱" />
											</div>
											<br>
											<br>
											<div class="am-u-sm-3 am-text-right">密码：</div>
											<div class="am-u-sm-8">
												<input type="password" class="am-form-field am-radius"
													name="userpwd" placeholder="密码" />
											</div>

											<br>
											<br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary">立即登录</button>
														<button type="botton" class="am-btn am-btn-default">忘记密码</button>
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
</div>
<!-- content end -->
</body>

<br>
<br>
<br>
<br>

<%@ include file="foot.jsp"%>