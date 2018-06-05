package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.JobSearchDAO;
import com.zhaopin.dao.SchoolsDAO;
import com.zhaopin.po.JobList;
import com.zhaopin.po.Schools;

public class SchoolHomeServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行SchoolHomeServlet");
        /*
         * int userid = 2;
         * 
         * UsersDAO udao = new UsersDAO(); SchoolsDAO cdao = new SchoolsDAO();
         * List<Users> userlist = udao.queryuserinfo(userid);
         * request.setAttribute("userinfolist", userlist);
         * 
         * List<Experience> Experiencelist = udao.queryuserexperience(userid);
         * request.setAttribute("experiencelist", Experiencelist);
         */
        HttpSession session = request.getSession();
        Schools schools = (Schools) session.getAttribute("schoolInfo");

        if (null != schools && null != schools.getSchoolName()) {
            SchoolsDAO cdao = new SchoolsDAO();
            Schools school = cdao.login(schools);

            System.out.println("获取学校信息成功");
            session.setAttribute("userInfo", null);
            session.setAttribute("schoolInfo", school);

            JobSearchDAO jobSearchDAO = new JobSearchDAO();
            List<JobList> jobLists = jobSearchDAO.query(school.getSchoolId());
            session.setAttribute("school-job", jobLists);

        } else {
            System.out.println("获取学校信息失败");
            request.setAttribute("error", "获取学校信息失败");
        }

        request.getRequestDispatcher("/schoolhome.jsp").forward(request, response);

    }

    public void init() throws ServletException {
        // Put your code here
    }

}
