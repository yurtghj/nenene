package com.newlecture.jspprj.entity;

import java.util.Date;

public class AnswerisView extends Answeris {
	private int cmtCount;

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
			int cmtCount
		) {
		super(id, language, platform, runtime, title, errorCode, errorMessage, situation, triedToFix, reason, writerId,
				howToFix, regDate, hit);

		this.cmtCount = cmtCount;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

}
