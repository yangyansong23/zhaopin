package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.ExamWrong;

public class UserExamWrongServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 ExamDao cdao = new ExamDao();
    	 List<ExamWrong> list = cdao.queryexamwrong();
    	 request.setAttribute("ExamWronglist", list);

         request.getRequestDispatcher("/userexamwrong.jsp").forward(request, response);
    }
}
