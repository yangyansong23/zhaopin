package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.Exam;

public class SchoolExamDetailServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ExamDao cdao = new ExamDao();
	   	String id = request.getParameter("testid");
	   	int zid2 = Integer.parseInt(id);
	   	Exam detail = cdao.queryDetailById(zid2);
	   	request.setAttribute("Examdetail", detail);

        request.getRequestDispatcher("/schoolexamdetail.jsp").forward(request, response);
    }
    public void init() throws ServletException {
        // Put your code here
    }

}
