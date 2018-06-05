package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.Exam;

public class SchoolExamDeleteServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ExamDao cdao = new ExamDao();
	   	String id = request.getParameter("testid");
	   	int zid2 = Integer.parseInt(id);
	   	if (cdao.delete(zid2) == true) {
            System.out.println("删除试题成功");
//            response.sendRedirect("/schoolexam.jsp");
            List<Exam> list = cdao.queryuserinfo();
            request.setAttribute("Examlist", list);
        } else {
            System.out.println("试题删除失败");
            request.setAttribute("error", "试题删除失败,请重新操作");
        }

        request.getRequestDispatcher("/schoolexam.jsp").forward(request, response);
    }
    public void init() throws ServletException {
        // Put your code here
    }

}
