package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.SchoolsDAO;
import com.zhaopin.po.Schools;

public class SchoolLoginServlet extends HttpServlet {

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String schoolEmail = request.getParameter("schoolEmail");
        String schoolPwd = request.getParameter("schoolPwd");

        Schools schools = new Schools();
        schools.setSchoolEmail(schoolEmail);
        schools.setSchoolPwd(schoolPwd);

        SchoolsDAO cdao = new SchoolsDAO();
        Schools school = cdao.login(schools);

        if (null != school && null != school.getSchoolName()) {

            System.out.println("登录成功");
            String schoolName = school.getSchoolName();
            System.out.println("学校用户:" + schoolName);
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", null);
            session.setAttribute("schoolInfo", school);
            response.sendRedirect("SchoolHomeServlet");

        } else {
            System.out.println("登录失败");
            request.setAttribute("error", "登录失败，请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public void init() throws ServletException {
        // Put your code here
    }

}
