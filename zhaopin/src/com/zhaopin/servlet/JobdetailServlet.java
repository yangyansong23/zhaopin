package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.JobListDAO;
import com.zhaopin.po.JobList;

public class JobdetailServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行JobdetailServlet");

		// 获取招聘编号，返回职位的详细信息

		int jobid = Integer.parseInt(request.getParameter("zhpid1"));
		JobListDAO jddao = new JobListDAO();
		JobList jobdetail = jddao.queryDetailById(jobid);

        request.setAttribute("jobdetail", jobdetail);

        request.getRequestDispatcher("/jobdetail.jsp").forward(request, response);

    }

    public void init() throws ServletException {

    }

}
