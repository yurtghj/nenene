import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Calc2 extends HttpServlet{
	
	@Override
				/*service ´ë½Å doGet »ç¿ë °¡´É*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		int x = 0;
		int y = 0;
		
		String tx = request.getParameter("x");
		if(tx!=null && !tx.equals(""))
			x = Integer.parseInt(tx);
		
		String ty = request.getParameter("y");
		if(ty!=null && !ty.equals(""))
			y = Integer.parseInt(ty);
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");	
		out.write("		<form method=\"post\">");	
		out.write("			<div>");
		out.write("				<label>x :</label>");			 
		out.write("				<input type=\"text\" name=\"x\" />");			
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<label>y :</label>"); 
		out.write("				<input type=\"text\" name=\"y\" />");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<input id=\"btn-submit\" type=\"submit\" value=\"µ¡¼À\" />");		
		out.write("				<input id=\"btn-app\" type=\"submit\" value=\"Application\" />");		
		out.write("				<input id=\"btn-session\" type=\"submit\" value=\"Session\" />");		
		out.write("				<input id=\"btn-cookie\" type=\"submit\" value=\"Cookie\" />");		
		out.write("			</div>");
		out.write("			<div> result : ");	
		out.printf("%d", x+y);
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
		out.print("¸Þ··~~");
	}
}







