package com.newlecture.jspweb.entity;

import java.util.Date;

public class Notice {
	private String id;
	private String title;
	private String content;
	private String writerid;
	private Date regDate;
	private int hit;
	
	public Notice(String id, String title, String content, String writerid, Date regDate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerid = writerid;
		this.regDate = regDate;
		this.hit = hit;
	}
	public Notice() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	

	
}
