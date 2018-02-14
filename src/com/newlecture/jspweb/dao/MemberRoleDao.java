package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.MemberRole;

public class MemberRoleDao {
	public List<MemberRole> getList() throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM MEMBER_ROLE";

		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		String member_id;
		String role_id;
		 
		List<MemberRole> list = new ArrayList<>();
		
		while (rs.next()) {
			member_id = rs.getString("member_id");
			role_id = rs.getString("role_id");
			
			
			MemberRole memberRole = new MemberRole(
					member_id,
					role_id
					);
			
			list.add(memberRole);
			
		}
		
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}