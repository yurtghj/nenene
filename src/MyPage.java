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

@WebServlet("/mypage")
public class MyPage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		int app = 0;
		int s = 0;
		int c = 0;
		
		ServletContext application = request.getServletContext();
		
		/*Object app_ = String.valueOf(application.getAttribute("result"));
		if (app_!=null)
			app = (Integer)app_;*/
		
		/*Object app_ = application.getAttribute("result");
		if (app_!=null)
			app = Integer.parseInt(app_.toString());*/

		String app_ = String.valueOf(application.getAttribute("result"));
		if (!app_.equals("null") && !app_.equals(""))
			app = Integer.parseInt(app_);

		HttpSession session = request.getSession();

		String s_ = String.valueOf(session.getAttribute("result"));
		if (!s_.equals("null") && !s_.equals(""))
			s = Integer.parseInt(s_);

		String c_ = "";
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cook : cookies) {
			if (cook.getName().equals("result")) {
				c_ = cook.getValue();
				break;
			}
		}

		c = Integer.parseInt(c_);

		out.write("<html>");
		out.write("	<body>");
		out.write("		<div>application:"+app+"</div>");
		out.write("		<div>session:"+s+"</div>");
		out.write("		<div>cookie:"+c+"</div>");
		out.write("		<div><a href=\"add\">계산하기</a></div>");
		out.write("	</body>");
		out.write("</html>");
		
		
	}
}
