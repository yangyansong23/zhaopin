package com.zhaopin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Users;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
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
        String userid = request.getParameter("userid");
        if (null != userid && !"".equals(userid)) {
            Users user = new Users();
            user.setUseremail(request.getParameter("useremail"));
            user.setUserfield(request.getParameter("userfield"));
            user.setUsergender(request.getParameter("usergender"));
            if ("男".equals(request.getParameter("usergender"))) {
                user.setUserphoto("img/users/9.jpeg");
            } else {
                user.setUserphoto("img/users/2.jpeg");
            }
            user.setUsergraduate(request.getParameter("usergraduate"));
            user.setUserid(Integer.parseInt(userid));
            user.setUsername(request.getParameter("username"));
            user.setUserschool(request.getParameter("userschool"));
            UsersDAO udao = new UsersDAO();
            boolean suc = udao.updateUser(user);
            if (suc) {
                user = udao.queryUserById(Integer.parseInt(userid));
                HttpSession session = request.getSession();
                session.setAttribute("userInfo", user);
            }
        }

        request.getRequestDispatcher("/userhome.jsp").forward(request, response);
    }

}
