import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Calc extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		int result = 0;
		
		String result_ = request.getParameter("result");
		if(result_ !=null && !result_.equals(""))
			result = Integer.parseInt(result_);

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");	
		out.write("		<form action=\"add\" method=\"post\">");	
		out.write("			<div>");
		out.write("				<label>x :</label>");			 
		out.write("				<input type=\"text\" name=\"x\" />");			
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<label>y :</label>"); 
		out.write("				<input type=\"text\" name=\"y\" />");
		out.write("			<div>");
		out.write("				<input id=\"btn-submit\" type=\"submit\" name=\"btn\" value=\"����\" />");			
		out.write("				<input id=\"btn-app\" type=\"submit\" name=\"btn\" value=\"Application\" />");		
		out.write("				<input id=\"btn-session\" type=\"submit\" name=\"btn\" value=\"Session\" />");		
		out.write("				<input id=\"btn-cookie\" type=\"submit\" name=\"btn\" value=\"Cookie\" />");		
		out.write("			</div>");
		out.write("			<div> result:");	
		out.printf("%d", result);
		out.write("<input type=\"hidden\" name=\"result\" value=\""+result+"\"/>");
		out.write("			</div>");
		out.write("		</form>");		
		out.write("	</div>");
		out.write("<div>");
		out.write("<a href=\"mypage\">����������</a>"); /*url�� mypage*/
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//request.setCharacterEncoding("UTF-8"); �ݵ�� getParameter ���� ����� ��
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		int result = 0;

		int x = 0;
		int y = 0;

		String btn = "����";
		
		/*final String Application="Application";
		final String Session="Session";
		final String Cookie="Cookie";*/
		
		String tx = request.getParameter("x");
		if (tx != null && !tx.equals(""))
			x = Integer.parseInt(tx);

		String ty = request.getParameter("y");
		if (ty != null && !ty.equals(""))
			y = Integer.parseInt(ty);

		
		String btn_ = request.getParameter("btn");
		if (btn_!= null && !btn.equals(""))
			btn = btn_;
		
		//���࿡ btn���� ���޵� ���� �ִٸ� �� ���� btn������ ����
		switch (btn) {
		case "����":
			result = x + y;
			break;
		
		case "Application":{
			ServletContext application = request.getServletContext();
			String result_ = request.getParameter("result");
			//object ���� 
			//int result = Integer.parseInt(request.getParameter("result"));
			application.setAttribute("result", result_);
			}
			break;
			
		case "Session":{
			HttpSession session = request.getSession();
			String result_ = request.getParameter("result");
			session.setAttribute("result", result_);
			}
			break;

		case "Cookie":{
			String result_ = request.getParameter("result");
			//��Ű�� Ű ������ ���ڿ�����. Ű ���̵� ����~~ ������ �׷��� �������
			Cookie cookie = new Cookie("result",result_);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			}
			break;
		}
		

		//response.sendRedirect("add?result="+result);
		//response.sendRedirect("add?x="+x+"&y="+y+"&result="+result+"");
		response.sendRedirect(String.format("add?x=%d&y=%d&result=%d", x,y,result));
	}
	

	/*service ��� doGet ��� ����
	public void service1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int result = 0;

		if (request.getMethod().equals("POST")) {
			int x = 0;
			int y = 0;

			String tx = request.getParameter("x");
			if (tx != null && !tx.equals(""))
				x = Integer.parseInt(tx);

			String ty = request.getParameter("y");
			if (ty != null && !ty.equals(""))
				y = Integer.parseInt(ty);

			result = x + y;

			// response.sendRedirect("calc.html");
		}

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");
		out.write("		<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<label>x :</label>");
		out.write("				<input type=\"text\" name=\"x\" />");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<label>y :</label>");
		out.write("				<input type=\"text\" name=\"y\" />");
		out.write("				<input id=\"btn-submit\" type=\"submit\" value=\"����\" />");
		out.write("			</div>");
		out.write("			<div> result:");
		out.printf("%d", result);
		out.write("			</div>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}*/
}