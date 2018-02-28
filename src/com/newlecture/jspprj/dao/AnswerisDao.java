package com.newlecture.jspprj.dao;

import java.util.List;

import com.newlecture.jspprj.entity.Answeris;
import com.newlecture.jspprj.entity.AnswerisView;

//JdbcAnswerisDao/MyBatisAnwerisDao/SpringAnswerisDao
public interface AnswerisDao {
	public int insert(Answeris answeris);
	public int update(Answeris answeris);
	public int delete(String id);
	
	public List<AnswerisView> getList(int page);
	public AnswerisView get(String id);
}
