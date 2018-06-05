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

						<!---选项卡-->
						<div class="am-tabs" data-am-tabs>
							<ul class="am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
								</li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<tbody>
											<%
											    List<ExamWrong> examListrws = (List<ExamWrong>) request.getAttribute("ExamWronglist");
											    if (null == examListrws) {
											        System.out.println("ExamResultlist为什么会是空的呢？");
											    } else {%>
													<% int i = 1;
											        for (ExamWrong jc : examListrws) { %>
														<%=i %>. 题目：<%=jc.getTestname()%><br>
														<input type="radio" name="<%=jc.getTestid()%>" id="optiona" value="<%=jc.getTestid()%>-A">选项A: <%=jc.getOptiona()%><br>
														 <input type="radio" name="<%=jc.getTestid()%>"  id="optionb" value="<%=jc.getTestid()%>-B">选项B：<%=jc.getOptionb()%><br>
														  <input type="radio" name="<%=jc.getTestid()%>"  id="optionc" value="<%=jc.getTestid()%>-C">选项C：<%=jc.getOptionc()%><br>
														  <input type="radio" name="<%=jc.getTestid()%>"  id="optiond" value="<%=jc.getTestid()%>-D">选项D：<%=jc.getOptiond()%><br>
														  <span>正确答案：<%=jc.getTestkey()%></span><br> 
														  <span>你的答案：<%=jc.getYourkey()%></span> <br>
														  <br>
														<%i++ ;%>
													<%} %>
											<%
											    }
											%>
											<br>
											<!-- <input type="hidden" name="key" id="key" value=""> -->
										</tbody>
									</table>
									<br>
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