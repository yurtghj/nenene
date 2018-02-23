package com.newlecture.jspweb.entity;

import java.util.Date;

public class NoticeView extends Notice {
	private String writerName;
	private String commentCnt;
	
	
	public NoticeView(
			String id,
			String title, 
			String content, 
			String writerid, 
			Date regDate, 
			int hit
			) {
		super(id, title, content, writerid, regDate, hit);
		
		this.writerName = writerName;
		this.commentCnt = commentCnt;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}
	
	

}
