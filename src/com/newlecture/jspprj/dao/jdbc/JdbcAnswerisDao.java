package com.newlecture.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.entity.Answeris;
import com.newlecture.jspprj.entity.AnswerisView;

public class JdbcAnswerisDao implements AnswerisDao {

	@Override
	public int insert(Answeris answeris) {
		
		String sql = "INSERT INTO ANSWERIS(ID,TITLE,LANGUAGE,PLATRFORM,RUNTIME,ERROR_CODE,ERROR_MESSAGE,SITUATION,TRIED_TO_FIX,REASON,HOW_TO_FIX,WRITER_ID) "
				+ "VALUES((SELECT NVL(MAX(TO_NUMBER(ID)),0)+1) ID FROM ANSWERIS,?,?,?,?,?,?,?,?,?,?,?)";

		int result = 0;
		
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, answeris.getTitle());
			st.setString(2, answeris.getLanguage());
			st.setString(3, answeris.getPlatform());
			st.setString(4, answeris.getRuntime());
			st.setString(5, answeris.getErrorCode());
			st.setString(6, answeris.getErrorMessage());
			st.setString(7, answeris.getSituation());
			st.setString(8, answeris.getTriedToFix());
			st.setString(9, answeris.getReason());
			st.setString(10, answeris.getHowToFix());
			st.setString(11, answeris.getWriterId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Answeris answeris) {
		String sql = "UPDATE ANSWERIS SET" + 
				"    id = ?," + 
				"    TITLE = ?," + 
				"    LANGUAGE = ?," + 
				"    PLATFORM = ?," + 
				"    RUNTIME = ?," + 
				"    ERROR_CODE = ?," + 
				"    ERROR_MESSAGE  = ?," + 
				"    SITUATION  = ?," + 
				"    TRIED_TO_FIX  = ?," + 
				"    REASON  = ?," + 
				"    HOW_TO_FIX  = ?," + 
				"    HIT = ?," + 
				"    WHERE ID = ?";

		int result = 0;
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, answeris.getTitle());
			st.setString(2, answeris.getLanguage());
			st.setString(3, answeris.getPlatform());
			st.setString(4, answeris.getRuntime());
			st.setString(5, answeris.getErrorCode());
			st.setString(6, answeris.getErrorMessage());
			st.setString(7, answeris.getSituation());
			st.setString(8, answeris.getTriedToFix());
			st.setString(9, answeris.getReason());
			st.setString(10, answeris.getHowToFix());
			st.setInt(11, answeris.getHit());
			st.setString(12, answeris.getWriterId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}


	@Override
	public int delete(String id) {
		String sql = "DELETE ANSWERIS WHERE ID=?";

		int result = 0;
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<AnswerisView> getList() {
		String sql = "SELECT * FROM ANSWERIS_VIEW ORDER BY REG_DATE DESC";

		List<AnswerisView> list = new ArrayList<>();
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url,"c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery(); //결과 값을 가져오기 위한 도구
			
			AnswerisView answeris = null;

			while (rs.next()) {
				answeris = new AnswerisView(
						rs.getString("ID"),
						rs.getString("TITLE"),
						rs.getString("LANGUAGE"),
						rs.getString("PLATFORM"),
						rs.getString("RUNTIME"),
						rs.getString("ERROR_CODE"),
						rs.getString("ERROR_MESSAGE"),
						rs.getString("SITUATION"),
						rs.getString("TRIED_TO_FIX"),
						rs.getString("REASON"),
						rs.getString("HOW_TO_FIX"),
						rs.getString("WRITER_ID"),
						rs.getDate("REG_DATE"),
						rs.getInt("HIT"),
						rs.getInt("COMMENT_COUNT")
					);
				list.add(answeris);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public AnswerisView get(String id) {
		String sql = "SELECT * FROM ANSWERIS_VIEW WHERE ID=?";
		AnswerisView answeris = null;

		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			
			//prepareStatement 쓸 시 또 sql쓰면 ㄴㄴ ResultSet rs = st.executeQuery(sql);아님 노노노노 
			ResultSet rs = st.executeQuery();
			
			
			if (rs.next()) {
				answeris = new AnswerisView(
						rs.getString("ID"),
						rs.getString("TITLE"),
						rs.getString("LANGUAGE"),
						rs.getString("PLATFORM"),
						rs.getString("RUNTIME"),
						rs.getString("ERROR_CODE"),
						rs.getString("ERROR_MESSAGE"),
						rs.getString("SITUATION"),
						rs.getString("TRIED_TO_FIX"),
						rs.getString("REASON"),
						rs.getString("HOW_TO_FIX"),
						rs.getString("WRITER_ID"),
						rs.getDate("REG_DATE"),
						rs.getInt("HIT"),
						rs.getInt("CMT_COUNT")
					);
				
				//System.out.printf("name : %s, id :%s \n", name, id);
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answeris;
	}

}
