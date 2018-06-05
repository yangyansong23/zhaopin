package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.Exam;

public class UserExamServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 ExamDao cdao = new ExamDao();
    	 List<Exam> list = cdao.queryuserinfo();
    	 request.setAttribute("Examlist", list);

         request.getRequestDispatcher("/userexam.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("执行SchoolExamServlet");

        ExamDao cdao = new ExamDao();
        String testname = request.getParameter("testname");
        String optiona = request.getParameter("optiona");
        String optionb = request.getParameter("optionb");
        String optionc = request.getParameter("optionc");
        String optiond = request.getParameter("optiond");
        String testkey = request.getParameter("testkey");

        Exam exam = new Exam();
        exam.setTestname(testname);
        exam.setOptiona(optiona);
        exam.setOptionb(optionb);
        exam.setOptionc(optionc);
        exam.setOptiond(optiond);
        exam.setTestkey(testkey);

        if (cdao.add(exam) == true) {
            System.out.println("试题录入成功");
//            response.sendRedirect("/schoolexam.jsp");
            List<Exam> list = cdao.queryuserinfo();
            request.setAttribute("Examlist", list);
        } else {
            System.out.println("试题录入失败");
            request.setAttribute("error", "试题失败，请重新录入");
        }

        request.getRequestDispatcher("/userexam.jsp").forward(request, response);

    }

    public void init() throws ServletException {
        // Put your code here
    }

}
