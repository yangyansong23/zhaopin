package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.JobListDAO;
import com.zhaopin.po.JobList;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/JobListServlet")
public class JobListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobListServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("执行joblistServlet");
        JobListDAO jcdao = new JobListDAO();
        HttpSession session = request.getSession();
        List<JobList> jobListCount = jcdao.queryOrderByCount();
        session.setAttribute("jobListCount", jobListCount);

        List<JobList> jobListTime = jcdao.queryOrderByTime();
        request.setAttribute("JobListTime", jobListTime);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return;
    }

}
