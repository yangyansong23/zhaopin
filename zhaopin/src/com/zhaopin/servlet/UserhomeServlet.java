package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Experience;
import com.zhaopin.po.Users;

public class UserhomeServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行UserhomeServlet");

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("userInfo");
        if (null != user) {
            UsersDAO udao = new UsersDAO();
            // // 根据ID查询会查到集合吗？ 答：不会
            // List<Users> userlist = udao.queryuserinfo(user.getUserid());
            // request.setAttribute("userinfolist", userlist);

            List<Experience> Experiencelist = udao.queryExperiences(user.getUserid());
            request.setAttribute("experiencelist", Experiencelist);
            session.setAttribute("experiencelist", Experiencelist);
        }

        request.getRequestDispatcher("/userhome.jsp").forward(request, response);

    }

    public void init() throws ServletException {
        // Put your code here
    }

}
