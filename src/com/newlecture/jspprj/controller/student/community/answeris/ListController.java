package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기본값은 1
		int page = 1;
		
		//요청한 page 값이 있을 경우 기본값을 대치함
		String page_ = request.getParameter("p");
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
			
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		List<AnswerisView> list = answerisDao.getList(page);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/list.jsp");
		dispatcher.forward(request, response);
	}
}
