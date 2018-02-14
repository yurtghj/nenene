package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Notice;

public class RoleDao2 {
	public List<Notice> getList() throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM NOTICE";

		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		String id;
		String title;
		String content;
		String writerid;
		Date regDate;
		int hit;
		 
		List<Notice> list = new ArrayList<>();
		
		while (rs.next()) {
			id = rs.getString("ID");
			writerid = rs.getString("WRITER_ID");
			title = rs.getString("TITLE");
			content = rs.getString("CONTENT");
			regDate = rs.getDate("reg_Date");
			hit = rs.getInt("HIT");
			
			
			Notice notice = new Notice(
					id,
					title,
					writerid,
					content,
					regDate,
					hit
					);
			
			list.add(notice);
			
		}
		
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}