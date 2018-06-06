package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.JobSearchDAO;
import com.zhaopin.po.JobList;

public class JobSearchServlet extends HttpServlet {

    public void destroy() {
        super.destroy();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        JobSearchDAO jsdao = new JobSearchDAO();

        if (keyword == null || "".equals(keyword.trim())) {
            // 默认显示全部
            List<JobList> joblist = jsdao.query();
            request.setAttribute("JobSearch", joblist);
            request.getRequestDispatcher("/job.jsp").forward(request, response);
        } else {
            // 搜索查询条件
            List<JobList> list = jsdao.query(keyword);
            request.setAttribute("JobSearch", list);
            request.getRequestDispatcher("/job.jsp").forward(request, response);
        }
    }

    public void init() throws ServletException {

    }

}
