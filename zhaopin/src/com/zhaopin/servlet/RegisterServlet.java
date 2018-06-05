package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.SchoolsDAO;
import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Schools;
import com.zhaopin.po.Users;

public class RegisterServlet extends HttpServlet {

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("user_type");

        if (null != type && type.equals("user")) {
            String username = request.getParameter("username");
            String useremail = request.getParameter("email");
            String userpwd = request.getParameter("pwd");

            Users users = new Users();
            users.setUsername(username);
            users.setUseremail(useremail);
            users.setUserpwd(userpwd);

            UsersDAO udao = new UsersDAO();
            if (udao.add(users) == true) {
                System.out.println("用户注册登录成功");
                response.sendRedirect("login.jsp");

            } else {
                System.out.println("用户注册失败");
                request.setAttribute("error", "用户注册失败，请重新注册");
            }

        } else {
            String schoolName = request.getParameter("school");
            String schoolEmail = request.getParameter("email");
            String schoolPwd = request.getParameter("pwd");

            Schools schools = new Schools();
            schools.setSchoolName(schoolName);
            schools.setSchoolEmail(schoolEmail);
            schools.setSchoolPwd(schoolPwd);

            SchoolsDAO cdao = new SchoolsDAO();
            if (cdao.add(schools) == true) {
                System.out.println("学校注册成功");
                response.sendRedirect("login.jsp");
            } else {
                System.out.println("学校注册登录失败");
                request.setAttribute("error", "学校注册失败，请重新注册");
            }
        }
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
