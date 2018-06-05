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
								<li class="am-active"><a href="#tab1">创建试题</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<!-- <form class="am-form"> -->
									<div class="am-g am-margin-top">

										<form id="userForm" class="am-form" action="SchoolExamServlet"
											method="post">
											<div class="am-u-sm-3 am-text-right">题目：</div>
											<div class="am-u-sm-8">
												<input type="text" name="testname"
													class="am-form-field am-radius" placeholder="题目" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">选项A：</div>
											<div class="am-u-sm-8">
												<input type="text" name="optiona"
													class="am-form-field am-radius" placeholder="选项A" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">选项B：</div>
											<div class="am-u-sm-8">
												<input type="text" name="optionb"
													class="am-form-field am-radius" placeholder="选项B" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">选项C：</div>
											<div class="am-u-sm-8">
												<input type="text" name="optionc" 
												class="am-form-field am-radius" placeholder="选项C" />
											</div>
											<br> <br>
											<div class="am-u-sm-3 am-text-right">选项D：</div>
											<div class="am-u-sm-8">
												<input type="text" name="optiond" 
												class="am-form-field am-radius" placeholder="选项D" />
											</div>
											
											<br> <br>
											<div class="am-u-sm-3 am-text-right">答案：</div>
											<div class="am-u-sm-8">
												<input type="text" name="testkey" 
												class="am-form-field am-radius" placeholder="正确答案" />
											</div>

											<br> <br>
											<div class="am-margin am-margin-top">
												<div class="am-u-sm-12 ">
													<center>
														<button type="submit" class="am-btn am-btn-primary ">创建</button>
													</center>
												</div>
											</div>
										</form>
									</div>
									<!-- </form> -->
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