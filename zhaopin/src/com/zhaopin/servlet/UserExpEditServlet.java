package com.zhaopin.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhaopin.dao.UsersDAO;
import com.zhaopin.po.Experience;
import com.zhaopin.po.Users;

/**
 * Servlet implementation class UserExpEditServlet
 */
@WebServlet("/UserExpEditServlet")
public class UserExpEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExpEditServlet() {
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
            String expid = request.getParameter("expid");
            UsersDAO udao = new UsersDAO();
            if ("update".equals(method)) {
                Experience exp = udao.queryByExpId(Integer.parseInt(expid));
                request.setAttribute("editExpInfo", exp);
                request.getRequestDispatcher("/userexpedit.jsp").forward(request, response);
                return;
            } else if ("delete".equals(method)) {
                udao.deleteExp(Integer.parseInt(expid));
            } else {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Experience exp = new Experience();
                exp.setUserid(user.getUserid());
                exp.setProgram(request.getParameter("program"));
                exp.setPosition(request.getParameter("position"));
                exp.setSname(request.getParameter("schoolname"));
                exp.setDuty(request.getParameter("duty"));
                exp.setResult(request.getParameter("result"));
                try {
                    exp.setStarttime(format.parse(request.getParameter("starttime")));
                    exp.setEndtime(format.parse(request.getParameter("endtime")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (null != expid && !"".equals(expid)) {
                    exp.setExpid(Integer.parseInt(expid));
                    udao.updateExp(exp);
                } else {
                    udao.addExp(exp);
                }
            }
            List<Experience> Experiencelist = udao.queryExperiences(user.getUserid());
            request.setAttribute("experiencelist", Experiencelist);
            session.setAttribute("experiencelist", Experiencelist);
        }

        request.getRequestDispatcher("/userhome.jsp").forward(request, response);
    }

}
