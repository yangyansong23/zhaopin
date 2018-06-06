package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.QiuzhixinDAO;
import com.zhaopin.po.Qiuzhixin;
import com.zhaopin.po.Users;
import com.zhaopin.po.Yaoqing;

/**
 * Servlet implementation class UserEmailServlet
 */
@WebServlet("/UserEmailServlet")
public class UserEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEmailServlet() {
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
        System.out.println("执行UserEmailServlet");

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("userInfo");
        if (null != user) {
            String method = request.getParameter("method");
            QiuzhixinDAO qdao = new QiuzhixinDAO();
            if ("sendqzx".equals(method)) {
                Qiuzhixin qiuzhixin = new Qiuzhixin();
                qiuzhixin.setUserid(user.getUserid());
                qiuzhixin.setSchoolId(Integer.valueOf(request.getParameter("schoolid")));
                qiuzhixin.setZhaopinid(Integer.valueOf(request.getParameter("zhaopinid")));
                qiuzhixin.setStatus("--");
                if (!qdao.isExistQzx(qiuzhixin)) {
                    qdao.addQiuzhixin(qiuzhixin);
                }
            }
            List<Yaoqing> yaoqinglist = qdao.queryYaoqingByUserId(user.getUserid());
            request.setAttribute("yaoqinglist", yaoqinglist);
            List<Qiuzhixin> qiuzhixinlist = qdao.queryQiuzhixinByUserId(user.getUserid());
            request.setAttribute("qiuzhixinlist", qiuzhixinlist);
        }

        request.getRequestDispatcher("/useremail.jsp").forward(request, response);

    }

}
