<%@ page language="java"
	import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<br>
<script type="text/javascript">  
    function sub() {  
        // jquery 表单提交   
        $("#formId").ajaxSubmit(function(message) {   
        // 对于表单提交成功后处理，message为返回内容   
        });   
  
        return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转   
    }   
  
</script> 
<div class="am-g am-g-fixed blog-g-fixed">

	<div class="am-u-md-8">

		<article class="am-article">

			<%
			    JobList jobdetail = (JobList) request.getAttribute("jobdetail");
			    if (null == jobdetail) {
			        System.out.println("为什么详细信息会是空的呢？");
			    } else {
			        System.out.println("显示详细信息");
			%>

			<div class="am-panel am-panel-default">
				<div class="am-panel-hd">
					职位名称：<%=jobdetail.getZ_jobname()%></div>
				<div class="am-panel-bd">
					工作地点：<%=jobdetail.getZ_city()%><br> <br> 薪资待遇：<%=jobdetail.getZ_salary()%><br>
					<br> 职位描述：<br>
					<%=jobdetail.getZ_description()%><br> <br> 任职要求：<br>
					<%=jobdetail.getZ_requirements()%><br> <br>

					<hr>
					<form id="formId" action="UserEmailServlet" method="post" onsubmit="return sub();">
						<input type="hidden" name="method" value="sendqzx" >
						<input type="hidden" name="schoolid" value="<%=jobdetail.getSchoolId()%>" >
						<input type="hidden" name="zhaopinid" value="<%=jobdetail.getZhaopinid() %>" >
						<button type="submit" class="am-btn am-btn-secondary am-radius"
							data-am-popover="{content: '已发送'}">发求职信</button>
						<button class="am-btn am-btn-secondary am-radius"
							data-am-popover="{content: '已关注'}">加关注</button>
					</form>
		</article>
	</div>

	<div class="am-u-md-4 blog-sidebar">
		<div class="am-panel-group">

			<section class="am-panel am-panel-default">
				<div class="am-panel-hd">学校概况</div>
				<div class="am-panel-bd">
					<p>
						学校名称：<%=jobdetail.getSchoolName()%><br /> 学校概述：<%=jobdetail.getSchoolBrief()%><br />
						学校规模：<%=jobdetail.getSchoolSize()%><br /> 学校位置：<%=jobdetail.getSchoolLocate()%><br />
					</p>
				</div>
			</section>

			<%
			    }
			%>
			<section class="am-panel am-panel-default">
				<div class="am-panel-hd">友情链接</div>
				<div class="am-panel-bd">
					<ul class="am-avg-sm-4 blog-team">
						<li><a href="http://www.zhaopin.com"><img
								class="am-thumbnail" src="img/link/zhilian.png" alt="" /></a></li>
						<li><a href="http://www.dajie.com"> <img
								class="am-thumbnail" src="img/link/dajie.png" alt="" />
						</a></li>
						<li><a href="http://www.neitui.me"><img
								class="am-thumbnail" src="img/link/neitui.jpg" alt="" /></a></li>
						<li><a href="http://www.lagou.com"><img
								class="am-thumbnail" src="img/link/lagou.jpg" alt="" /></a></li>
						<li><a href="http://www.58.com"><img class="am-thumbnail"
								src="img/link/58.png" alt="" /></a></li>
						<li><a href="http://www.yingjiesheng.com"><img
								class="am-thumbnail" src="img/link/yingjiesheng.png" alt="" /></a></li>
						<li><a href="http://www.chinahr.com"><img
								class="am-thumbnail" src="img/link/yingcai.png" alt="" /></a></li>
						<li><a href="http://www.ganji.com"><img
								class="am-thumbnail" src="img/link/ganji.png" alt="" /></a></li>
					</ul>
				</div>
			</section>

		</div>
	</div>

</div>

<%@ include file="foot.jsp"%>