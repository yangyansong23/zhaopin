package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.AdminDAO;
import com.zhaopin.po.Admins;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
        String adminemail = request.getParameter("useremail");
        String adminpwd = request.getParameter("userpwd");

        Admins admin = new Admins();
        admin.setAdminemail(adminemail);
        admin.setAdminpwd(adminpwd);

        AdminDAO udao = new AdminDAO();

        Admins user = new Admins();
        user = udao.login(admin);

        if (null != user && user.getAdminname() != null) {

            System.out.println("管理员登录成功");
            String username = user.getAdminname();
            System.out.println("管理员用户" + username);
            HttpSession session = request.getSession();
            session.setAttribute("schoolInfo", null);
            session.setAttribute("userInfo", null);
            session.setAttribute("adminInfo", user);
            request.getRequestDispatcher("/adminuser.jsp").forward(request, response);

        } else {
            System.out.println("登录失败");
            request.setAttribute("error", "登录失败，请重新登录");
            response.sendRedirect("index.jsp");
        }
    }

}
