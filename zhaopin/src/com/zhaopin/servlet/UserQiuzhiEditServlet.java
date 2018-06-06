package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Qiuzhi;
import com.zhaopin.po.Users;

/**
 * Servlet implementation class UserQiuzhiEditServlet
 */
@WebServlet("/UserQiuzhiEditServlet")
public class UserQiuzhiEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserQiuzhiEditServlet() {
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
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("userInfo");
        if (null != user) {
            String method = request.getParameter("method");
            String qiuzhiid = request.getParameter("qiuzhiid");
            UsersDAO udao = new UsersDAO();
            if ("update".equals(method)) {
                Qiuzhi qiuzhi = udao.querQqiuzhiById(Integer.parseInt(qiuzhiid));
                request.setAttribute("qiuzhiInfo", qiuzhi);
                request.getRequestDispatcher("/userqiuzhiedit.jsp").forward(request, response);
                return;
            } else if ("delete".equals(method)) {
                udao.deleteQiuzhi(Integer.parseInt(qiuzhiid));
            } else {
                Qiuzhi qiuzhi = new Qiuzhi();
                qiuzhi.setUserid(user.getUserid());
                qiuzhi.setQ_jobname(request.getParameter("qjobname"));
                qiuzhi.setQ_salary(request.getParameter("qsalary"));
                qiuzhi.setQ_city(request.getParameter("qcity"));

                if (null != qiuzhiid && !"".equals(qiuzhiid)) {
                    qiuzhi.setQiuzhiid(Integer.parseInt(qiuzhiid));
                    udao.updateQiuzhi(qiuzhi);
                } else {
                    udao.addQiuzhi(qiuzhi);
                }
            }
            List<Qiuzhi> qiuzhilist = udao.queryuserqiuzhi(user.getUserid());
            request.setAttribute("qiuzhilist", qiuzhilist);
        }

        request.getRequestDispatcher("/userqiuzhi.jsp").forward(request, response);
    }

}
