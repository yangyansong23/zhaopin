<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<br>
<script>  
    function lepaiclockdone() {  
    setTimeout("lepaiclockdone()", 1000);  
    //进行显示倒计时的元素  
    $("#parameter").each(function() {  
        var obj = $(this);  
        //获取时间戳即可  
        var tms = obj.attr("count_down");  
        var html = '距考试结束：';  
        if(tms > 0) {  
            tms = parseInt(tms) - 1;  
            var days = Math.floor(tms / (1 * 60 * 60 * 24));  
            var hours = Math.floor(tms / (1 * 60 * 60)) % 24;  
            var minutes = Math.floor(tms / (1 * 60)) % 60;  
            var seconds = Math.floor(tms / 1) % 60;  
  
            if(days > 0) {  
                html += days + "天";  
            }  
            if(hours > 0) {  
                html += hours + "时";  
            }  
            if(minutes > 0) {  
                html += minutes + "分";  
            }  
            html += parseInt(seconds) + "秒";  
            obj.html(html);  
            obj.attr("count_down", tms);  
        } else if(tms == 0) {  
    		location.href = "http://localhost:8080/zhaopin/UserExamKeyServlet";  
        }  
    });  
}  
lepaiclockdone(); //启动倒计时  

$(function(){
		var test_s = "";
		$('button').click(function(){
			<% List<Exam> examList = (List<Exam>) request.getAttribute("Examlist");
		    if (null == examList) {
		        System.out.println("Examlist为什么会是空的呢？");
		    } else {%>
		    	<% for (Exam jc : examList) { %>
		        var val = $('input[name="'+<%=jc.getTestid()%>+'"]:checked').val();
		        if(val.string() != "undefined"){
			        alert(val);
		        	test_s = test_s + ";" + val;
				    $("#key").val(test_s);
		        }
		        <%}%>  
		    <%}%>
	    });
    	
    /* $('button').click(function(){
        var val = $('input[name="16"]:checked').val();
        alert(val);   
    }); */
})

</script> 


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
								 <span id="parameter" count_down="30"></span>
								</li>
							</ul>

							<div class="am-tabs-bd">
							<form class="am-form" action="UserExamKeyServlet" method="post">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<table
										class="am-table am-table-bd am-table-striped admin-content-table">
										<tbody>
											<%
											    List<Exam> examList1 = (List<Exam>) request.getAttribute("Examlist");
											    if (null == examList1) {
											        System.out.println("Examlist为什么会是空的呢？");
											    } else {%>
													<% int i = 1;
											        for (Exam jc : examList1) { %>
														<%=i %>. 题目：<%=jc.getTestname()%><br>
														<input type="radio" name="<%=jc.getTestid()%>" id="optiona" value="<%=jc.getTestid()%>-A">选项A: <%=jc.getOptiona()%><br>
														 <input type="radio" name="<%=jc.getTestid()%>"  id="optionb" value="<%=jc.getTestid()%>-B">选项B：<%=jc.getOptionb()%><br>
														  <input type="radio" name="<%=jc.getTestid()%>"  id="optionc" value="<%=jc.getTestid()%>-C">选项C：<%=jc.getOptionc()%><br>
														  <input type="radio" name="<%=jc.getTestid()%>"  id="optiond" value="<%=jc.getTestid()%>-D">选项D：<%=jc.getOptiond()%><br>
														  <br>
														<%i++ ;%>
													<%} %>
											<%
											    }
											%>
											<br>
											<input type="hidden" name="key" id="key" value="">
										</tbody>
										<th><button type="submit" class="am-btn am-btn-primary">交卷</button></th>
									</table>
									<br>
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
	<!-- content end -->
</div>

<%@ include file="foot.jsp"%>