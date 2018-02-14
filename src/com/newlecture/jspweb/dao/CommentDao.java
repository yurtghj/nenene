package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Comment;

public class CommentDao {
	public List<Comment> getList() throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM COMMENT";

		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		String content;
		String price;
		 
		List<Comment> list = new ArrayList<>();
		
		while (rs.next()) {
			content = rs.getString("comment");
			price = rs.getString("price");
			
			
			Comment comment = new Comment(
					content,
					price
					);
			
			list.add(comment);
			
		}
		
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}