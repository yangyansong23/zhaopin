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
								编辑用户信息<span class="am-icon-chevron-down am-fr"></span>
							</div>
							<div id="collapse-panel-2" class="am-panel-bd am-collapse am-in">
								<form id="userForm" class="am-form" action="UserEditServlet"
									method="post">

									<%
									    Users editUser = (Users) request.getSession().getAttribute("userInfo");
									    String usid = "";
									    String usname = "";
									    String usemail = "";
									    String usgender = "";
									    String usschool = "";
									    String usfield = "";
									    String usgraduate = "";
									    if (null != editUser) {
									        usid = String.valueOf(editUser.getUserid());
									        usname = editUser.getUsername();
									        usemail = editUser.getUseremail();
									        usgender = editUser.getUsergender();
									        usschool = editUser.getUserschool();
									        usfield = editUser.getUserfield();
									        usgraduate = editUser.getUsergraduate();
									    }
									%>

									<input type="hidden" name="userid" value="<%=usid%>" />
									<div class="am-u-sm-3 am-text-right">用户名：</div>
									<div class="am-u-sm-8">
										<input type="text" name="username"
											class="am-form-field am-radius" placeholder="用户名"
											value="<%=usname%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">邮箱：</div>
									<div class="am-u-sm-8">
										<input type="text" name="useremail"
											class="am-form-field am-radius" placeholder="邮箱"
											value="<%=usemail%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">性别：</div>
									<div class="am-u-sm-8">
										<input type="radio" name="usergender"
											class="am-form-radio am-radius" value="女"
											<%=("女".equals(usgender))?"checked":""%> />女 
										<input type="radio"
											name="usergender" class="am-form-radio am-radius"
											value="男" <%=("男".equals(usgender))?"checked":""%> />男
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">学校：</div>
									<div class="am-u-sm-8">
										<input type="text" name="userschool"
											class="am-form-field am-radius" placeholder="学校"
											value="<%=usschool%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">专业：</div>
									<div class="am-u-sm-8">
										<input type="text" name="userfield"
											class="am-form-field am-radius" placeholder="专业"
											value="<%=usfield%>" />
									</div>
									<br> <br>
									<div class="am-u-sm-3 am-text-right">毕业时间：</div>
									<div class="am-u-sm-8">
										<input type="date" name="usergraduate"
											class="am-form-field am-radius" placeholder="毕业时间"
											value="<%=usgraduate%>" />
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