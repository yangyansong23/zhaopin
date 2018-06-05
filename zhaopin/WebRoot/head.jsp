<%@ page language="java"
    import="java.util.*,com.zhaopin.po.*,java.net.URLDecoder"
    pageEncoding="UTF-8"%>

<%
    Users userInfo = (Users) session.getAttribute("userInfo");
    Schools schoolInfo = (Schools) session.getAttribute("schoolInfo");
    Admins adminInfo = (Admins) session.getAttribute("adminInfo");
    boolean isLogin = false;
    String username = null;
    String userUrl = "#";
    if (null != userInfo) {
        isLogin = true;
        userUrl = "UserhomeServlet";
        username = userInfo.getUsername();
    } else if (null != schoolInfo) {
        isLogin = true;
        userUrl = "SchoolHomeServlet";
        username = schoolInfo.getSchoolName();
    } else if (null != adminInfo) {
        isLogin = true;
        userUrl = "adminuser.jsp";
        username = adminInfo.getAdminname();
    } else {
        isLogin = false;
        userUrl = "#";
        username = null;
        // response.sendRedirect("login.jsp");
        // return;
    }

    //Cookie cookies[]=request.getCookies();
    //name=URLDecoder.decode(cookies[1].getValue(),"UTF-8");
    //type=cookies[2].getValue();
    //System.out.println("cookie长度："+cookies.length); 
    //System.out.println("用户名："+name); 
    //System.out.println("用户类型："+type);
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="i/favicon.png">
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="css/personal.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
    <header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
        <div class="am-container">
            <h1 class="am-topbar-brand">
                <a href="JobListServlet">中小学教师招聘网</a>
            </h1>

            <!-- <button
                class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-secondary am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
                <span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
            </button> -->

            <div class="am-collapse am-topbar-collapse" id="collapse-head">
                <ul id="head-menu" class="am-nav am-nav-pills am-topbar-nav">
                    <li><a href="JobListServlet">首页</a></li>
                    <li><a href="JobSearchServlet">工作职位</a></li>
                </ul>


                <div class="am-topbar-right"
                    style="display: <%=isLogin ? "none" : ""%>">
                    <a href="register.jsp"
                        class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"
                        role="button"><span class="am-icon-pencil"></span> 注册</a>
                </div>

                <div class="am-topbar-right"
                    style="display: <%=isLogin ? "none" : ""%>">
                    <a href="login.jsp"
                        class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"
                        role="button"><span class="am-icon-user"></span> 登录</a>
                </div>

                <div class="am-topbar-right"
                    style="display: <%=isLogin ? "" : "none"%>">
                    <div class="am-dropdown"
                        data-am-dropdown="{boundary: '.am-topbar'}">
                        <button
                            class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
                            data-am-dropdown-toggle>
                            <%=username%>&nbsp;<span class="am-icon-caret-down"></span>
                        </button>
                        <ul class="am-dropdown-content">
                            <li><a href="<%=userUrl%>"><span class="am-icon-user"></span>个人中心</a></li>
                            <li><a href="LogoutServlet"><span
                                    class="am-icon-power-off"></span>退出</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </header>