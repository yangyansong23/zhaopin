package com.zhaopin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaopin.dao.ExamDao;
import com.zhaopin.po.Exam;

public class SchoolExamEditServlet extends HttpServlet {

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ExamDao cdao = new ExamDao();
	   	String id = request.getParameter("testid");
	   	int zid2 = Integer.parseInt(id);
	   	Exam detail = cdao.queryDetailById(zid2);
	   	request.setAttribute("Examdetail", detail);

        request.getRequestDispatcher("/schoolexamedit.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 System.out.println("执行SchoolExamServlet");

         ExamDao cdao = new ExamDao();
         String testid = request.getParameter("testid");
         String testname = request.getParameter("testname");
         String optiona = request.getParameter("optiona");
         String optionb = request.getParameter("optionb");
         String optionc = request.getParameter("optionc");
         String optiond = request.getParameter("optiond");
         String testkey = request.getParameter("testkey");

         Exam exam = new Exam();
         exam.setTestid(Integer.parseInt(testid));
         exam.setTestname(testname);
         exam.setOptiona(optiona);
         exam.setOptionb(optionb);
         exam.setOptionc(optionc);
         exam.setOptiond(optiond);
         exam.setTestkey(testkey);

         if (cdao.edit(exam) == true) {
             System.out.println("试题修改成功");
//             response.sendRedirect("/schoolexam.jsp");
             List<Exam> list = cdao.queryuserinfo();
             request.setAttribute("Examlist", list);
         } else {
             System.out.println("试题修改失败");
             request.setAttribute("error", "试题修改失败，请重新修改");
         }

         request.getRequestDispatcher("/schoolexam.jsp").forward(request, response);
    }
    public void init() throws ServletException {
        // Put your code here
    }

}
