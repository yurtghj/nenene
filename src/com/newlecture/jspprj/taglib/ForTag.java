package com.newlecture.jspprj.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {
	
	private int index = 0;
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		
		if(++index <5)
			return EVAL_BODY_AGAIN;
			else 
				return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

}
