<%@ page language="java" import="java.util.*,com.zhaopin.po.*"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<br>

<div class="am-g am-g-fixed blog-g-fixed">

	<div class="am-u-md-8">

		<article class="am-article">

			<div class="am-panel am-panel-default">
				<div class="am-panel-hd">个人简历</div>
				<div class="am-panel-bd">
					<%
					    List<Users> userinfolist = (List<Users>) request.getAttribute("userinfolist");
					    String photosrc = "img/users/2.jpeg";
					    if (null == userinfolist) {
					        System.out.println("为什么会是空的呢？");
					        response.sendRedirect("MandetailServlet");

					    } else {
					        int i = 1;
					        for (Users user : userinfolist) {
					%>
					<B>基本信息：</B><br> 姓名：<%=user.getUsername()%>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					性别：<%=user.getUsergender()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					邮箱：<%=user.getUseremail()%><br> 学校：<%=user.getUserschool()%>&nbsp;&nbsp;
					专业:<%=user.getUserfield()%>
					&nbsp;&nbsp; 毕业时间：<%=user.getUsergraduate()%><br>
					<%
					    photosrc = user.getUserphoto();
					%>
					<br>
					<%
					    }
					    }
					%>


					<B>项目经验：</B><br>

					<%
					    List<Experience> experiencelist = (List<Experience>) request.getAttribute("experiencelist");
					    if (null == experiencelist) {
					        System.out.println("为什么会项目经验是空的呢？");
					    } else {
					        int i = 1;
					        for (Experience exp : experiencelist) {
					%>
					项目名称：<%=exp.getProgram()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学校名称：<%=exp.getCname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					项目职位：<%=exp.getPosition()%><br> 项目时间：


					<%=exp.getStarttime()%>~<%=exp.getEndtime()%><br> 项目职责：<%=exp.getDuty()%><br>
					项目成果：<%=exp.getResult()%><br> <br>


					<%
					    }
					    }
					%>

					<hr>
					<button type="button" class="am-btn am-btn-secondary am-radius">邀请投递</button>
					<button type="button" class="am-btn am-btn-secondary am-radius">发邮件</button>
		</article>
	</div>

	<div class="am-u-md-4 blog-sidebar">
		<div class="am-panel-group">

			<section class="am-panel am-panel-default">
				<div class="am-panel-hd">头像信息</div>
				<div class="am-panel-bd">
					<div align="center">
						<img class="am-img-thumbnail am-radius" alt="140*140"
							src=<%=photosrc%> width="120" height="120" />
					</div>
				</div>
			</section>
			<section class="am-panel am-panel-default">
				<div class="am-panel-hd">网站介绍</div>
				<div class="am-panel-bd">
					<p>中小学教师招聘考试是针对教师这个行业，为应聘者提供最新，最全的职位信息，让他们能够即时获取所需要的内容。<br>
					已有的教师招聘考试最主要的功能有最新招聘、考试试题、复习资料、在线题库等功能分类等。教师招聘考试不仅对于个人来讲有着重要的意义，对于社会来说也是一种进步。<br>
					教师招聘考试系统的完善将促进并提高教师招聘的效率，间接性的促进了社会的教育文化发展，好的教育者才能教育出优秀的学子，提高全民的素质。	</p>
				</div>
			</section>

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