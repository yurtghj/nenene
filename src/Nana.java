import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hell")
public class Nana extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8"); //내가 행위하는데 필요
		response.setContentType("text/html; charset=UTF-8"); //meta data 사용자에게 보여지지x
		PrintWriter out = response.getWriter();

		//writer는 문자단위 stream은 바이트단위
		//PrintStream -> printWriter 이미지는 상관없지만 문자일 경우 생각해야함
		//OutputStream os = response.getOutputStream();
		
		//PrintStream out = new PrintStream(os);
		//PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8),true);			
		//보내는거 직접 지정				
		
		//밑에처럼 하면 길고 기차나 그래서 
		//PrintWriter out = response.getWriter();
		//response.setCharacterEncoding("UTF-8"); 지정
		
		int cnt=0;
		
		String temp = request.getParameter("cnt");
		if(temp != null && !temp.equals(""))
			cnt = Integer.parseInt(temp); //문자열을 숫자로      문자열로 받기때문에 
		
		for(int i=0; i<cnt; i++) 
		out.println((i+1)+": 안녕 Servlet<br/>");
	}
}
