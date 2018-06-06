package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.YaoqingDAO;
import com.zhaopin.po.Qiuzhixin;
import com.zhaopin.po.Schools;
import com.zhaopin.po.Yaoqing;

/**
 * Servlet implementation class SchoolEmailServlet
 */
@WebServlet("/SchoolEmailServlet")
public class SchoolEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolEmailServlet() {
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
        Schools school = (Schools) session.getAttribute("schoolInfo");
        if (null != school) {
            // 获取对应的请求参数
            String method = request.getParameter("method");
            YaoqingDAO ydao = new YaoqingDAO();
            if ("sendyq".equals(method)) {
                Yaoqing yq = new Yaoqing();
                yq.setUserid(Integer.parseInt(request.getParameter("userid")));
                yq.setSchoolId(school.getSchoolId());
                yq.setQiuzhiid(Integer.parseInt(request.getParameter("qiuzhiid")));
                yq.setStatus("--");

                if (!ydao.isExistYq(yq)) {
                    ydao.addYaoqing(yq);
                }

            }
            List<Yaoqing> yaoqinglist = ydao.queryYaoqingBySchoolId(Integer.valueOf(school.getSchoolId()));
            request.setAttribute("yaoqinglist", yaoqinglist);
            List<Qiuzhixin> qiuzhixinlist = ydao.queryQiuzhixinBySchoolId(Integer.valueOf(school.getSchoolId()));
            request.setAttribute("qiuzhixinlist", qiuzhixinlist);
        }
        request.getRequestDispatcher("/schoolemail.jsp").forward(request, response);
    }

}
