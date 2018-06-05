package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.ExamResult;
import com.zhaopin.po.Users;

public class UserExamKeyServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行SchoolExamServlet");

        ExamDao cdao = new ExamDao();
        String key = request.getParameter("key");
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("userInfo");
        if (null != user) {
        	String username = user.getUseremail();
        	List<ExamResult> list =cdao.queryTestResult(key, username);
            request.setAttribute("ExamResutlist", list);
        }

        request.getRequestDispatcher("/userexamresult.jsp").forward(request, response);

    }

    public void init() throws ServletException {
        // Put your code here
    }

}
