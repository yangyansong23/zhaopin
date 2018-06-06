package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ManListDAO;
import com.zhaopin.po.ManList;

public class ManlistServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ManListDAO mdao = new ManListDAO();

        List<ManList> manlist = mdao.queryOrderByTime();
        request.setAttribute("manlist", manlist);

        request.getRequestDispatcher("/man.jsp").forward(request, response);

    }

    public void init() throws ServletException {

    }

}
