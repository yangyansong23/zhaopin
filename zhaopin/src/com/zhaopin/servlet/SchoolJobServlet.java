package com.zhaopin.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.JobSearchDAO;
import com.zhaopin.dao.ZhaopinDAO;
import com.zhaopin.po.JobList;
import com.zhaopin.po.Schools;
import com.zhaopin.po.Zhaopin;

public class SchoolJobServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行SchoolJobServlet");
        HttpSession session = request.getSession();
        Schools school = (Schools) session.getAttribute("schoolInfo");
        if (null != school) {
            // 获取对应的请求参数
            String method = request.getParameter("method");
            // 根据请求参数去调用对应的方法。
            if ("add".equals(method)) {
                Zhaopin zhaopin = new Zhaopin();
                zhaopin.setSchoolId(school.getSchoolId());
                zhaopin.setZ_jobname(request.getParameter("jobname"));
                zhaopin.setZ_salary(request.getParameter("jobsalary"));
                zhaopin.setZ_city(request.getParameter("jobcity"));
                zhaopin.setZ_requirements(request.getParameter("jobrequirement"));
                zhaopin.setZ_desription(request.getParameter("jobdescription"));
                zhaopin.setZ_time(new Date());
                zhaopin.setZ_count(0);
                ZhaopinDAO zhpd = new ZhaopinDAO();
                boolean success = zhpd.add(zhaopin);
                if (success) {
                }

            } else if ("update".equals(method)) {
                update(request, response);
            }

            else if ("delete".equals(method)) {
                delete(request, response);
            }

            JobSearchDAO jobSearchDAO = new JobSearchDAO();
            List<JobList> jobLists = jobSearchDAO.query(school.getSchoolId());
            session.setAttribute("school-job", jobLists);
        }
        request.getRequestDispatcher("/schoolzhaopin.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        System.out.println("delete");
        String zhaopinid = request.getParameter("zhaopinid");
        System.out.println(zhaopinid);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        System.out.println("update");
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
