import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Clac3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = 0;
		
		String result_ = request.getParameter("result");
		if(result_ != null && !result_.equals(""))
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
		out.write("				<input id=\"btn-submit\" type=\"submit\" value=\"µ¡¼À\" />");				
		out.write("			</div>");
		out.write("			<div> result:");	
		out.printf(				"%d", result);
		out.write("			</div>");
		out.write("		</form>");		
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int result = 0;

		int x = 0;
		int y = 0;

		String tx = request.getParameter("x");
		if (tx != null && !tx.equals(""))
			x = Integer.parseInt(tx);

		String ty = request.getParameter("y");
		if (ty != null && !ty.equals(""))
			y = Integer.parseInt(ty);

		result = x + y;
		
		//response.sendRedirect("add?result="+result);
		response.sendRedirect(String.format("add?x=%d&y=%d&result=%d", x,y,result));
		

	}
}
