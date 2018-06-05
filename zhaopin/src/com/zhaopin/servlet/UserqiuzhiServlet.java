package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Qiuzhi;
import com.zhaopin.po.Users;

public class UserqiuzhiServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行UserqiuzhiServlet");

		UsersDAO udao = new UsersDAO();
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userInfo");
		List<Qiuzhi> qiuzhilist = udao.queryuserqiuzhi(user.getUserid());
		request.setAttribute("qiuzhilist", qiuzhilist);

        request.getRequestDispatcher("/userqiuzhi.jsp").forward(request, response);

    }

    public void init() throws ServletException {

    }

}
