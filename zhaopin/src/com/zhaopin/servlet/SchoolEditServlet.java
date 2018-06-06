package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.SchoolsDAO;
import com.zhaopin.po.Schools;

/**
 * Servlet implementation class SchoolEditServlet
 */
@WebServlet("/SchoolEditServlet")
public class SchoolEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolEditServlet() {
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
        String schid = request.getParameter("schoolid");
        if (null != schid && !"".equals(schid)) {
            Schools school = new Schools();
            school.setSchoolId(Integer.parseInt(schid));
            school.setSchoolName(request.getParameter("schoolname"));
            school.setSchoolEmail(request.getParameter("schoolemail"));
            school.setSchoolBrief(request.getParameter("schoolbrief"));
            school.setSchoolSize(Integer.parseInt(request.getParameter("schoolsize")));
            school.setSchoolLocate(request.getParameter("schoollocate"));
            SchoolsDAO schdao = new SchoolsDAO();
            boolean suc = schdao.update(school);
            if (suc) {
                school = schdao.queryById(Integer.parseInt(schid));
                HttpSession session = request.getSession();
                session.setAttribute("schoolInfo", school);
            }
        }

        request.getRequestDispatcher("/schoolhome.jsp").forward(request, response);
    }

}
