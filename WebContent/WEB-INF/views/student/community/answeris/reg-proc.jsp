<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao"%>
<%@page import="com.newlecture.jspprj.dao.AnswerisDao"%>
<%@page import="com.newlecture.jspprj.entity.Answeris"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<%-- jsp:useBean id="answeris" class=com.newlecture.jspprj.entity.Answeris>
	<jsp:setProperty name="answeris" property="title" param="title"/>
</jsp:useBean> --%> <!-- useBeen 객체를 생성하는 -->

<%
	Answeris answeris = new Answeris();
	answeris.setTitle(request.getParameter("title"));
	answeris.setWriterId("sist79");
	
	AnswerisDao answerisDao = new JdbcAnswerisDao();
	answerisDao.insert(answeris);
	
	//out.print(answeris.getTitle());
	response.sendRedirect("list.jsp");
	
%>