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
								<li class="am-active"><a href="#tab1">试题详情</a></li>
							</ul>

							<div id="collapse-panel-1" class="am-panel-bd am-collapse am-in">
								<div class="admin-task-bd">
								<%
							    Exam Examdetail = (Exam) request.getAttribute("Examdetail");
							    if (null == Examdetail) {
							        System.out.println("Examdetail为什么会是空的呢？");
							    }else {
							        System.out.println("显示详细信息");
								%> 
							    
									<div class="am-u-md-centered">
										题目：<%=Examdetail.getTestname()%><br> 选项A：<%=Examdetail.getOptiona()%><br>
										选项B：<%=Examdetail.getOptionb()%><br> 选项C：<%=Examdetail.getOptionc()%><br>
										选项D：<%=Examdetail.getOptiond()%><br> 答案：<%=Examdetail.getTestkey()%><br>
										创建时间：<%=Examdetail.getCreated()%><br>
									</div>
									<%
								    }
								%>
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