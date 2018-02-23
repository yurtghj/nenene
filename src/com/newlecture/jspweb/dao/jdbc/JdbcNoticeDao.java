package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.dao.NoticeDao;
import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {
   
   public List <NoticeView> getList() {
	   
	   String sql = "SELECT * FROM NOTICE";
	      
	      // 드라이버 로드
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         
	         ResultSet rs = st.executeQuery();
	         
	         NoticeView notice = null;
	         
	         List<NoticeView> list = new ArrayList<>();
	         
	         while(rs.next()) { 
	            /*id=rs.getString("ID");
	            title = rs.getString("TITLE");
	            writerId = rs.getString("WRITER_ID");
	            content = rs.getString("content");
	            regDate = rs.getDate("reg_Date");
	            hit = rs.getInt("hit");*/
	            
	        	 		notice = new NoticeView(
	            		rs.getString("ID"),
	            		rs.getString("TITLE"),
	            		rs.getString("WRTITER_ID"),
	            		rs.getString("CONTENT"),
	            		rs.getDate("REG_DATE"),
	            		rs.getInt("HIT")
	            		
	                 );
	            
				list.add(notice);
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

   /*public List<NoticeView> getList(int page, String field, String query) {
      
      String sql = "SELECT * FROM NOTICE";
      
      // 드라이버 로드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         String id;
         String title;
         String writerId;
         String content;
         Date regDate;
         int hit;      
         
         List<NoticeView> list = new ArrayList<>();
         
         while(rs.next()) { 
            id=rs.getString("ID");
            title = rs.getString("TITLE");
            writerId = rs.getString("WRITER_ID");
            content = rs.getString("content");
            regDate = rs.getDate("reg_Date");
            hit = rs.getInt("hit");
            
            NoticeView notice = new NoticeView(
                              id,
                              title,
                              writerId,
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
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
	}*/

   
	@Override
	public NoticeView get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeView getPrev(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeView getNext(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}