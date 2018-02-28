package com.newlecture.jspprj.entity;

import java.util.Date;

public class AnswerisView extends Answeris{

	private int commentCnt;
	
	public AnswerisView() {
		// TODO Auto-generated constructor stub
	}
	
	public AnswerisView(
			String id,
			String title,
			String language,
			String platform,
			String runtime,
			String errorCode,
			String errorMessage,
			String situation,
			String triedToFix, 
			String reason,
			String howToFix, 
			String writerId,
			Date regDate,
			int hit,
			int commentCnt)
	{
		super(id, title, language, platform, runtime, errorCode, errorMessage, situation, triedToFix, reason, howToFix,
				writerId, regDate, hit);
		this.commentCnt = commentCnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	
}
